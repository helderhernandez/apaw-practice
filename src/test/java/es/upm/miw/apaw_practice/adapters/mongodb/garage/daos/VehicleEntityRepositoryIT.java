package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.VehicleEntity;
import es.upm.miw.apaw_practice.domain.models.garage.composite.TreeVehicle;
import es.upm.miw.apaw_practice.domain.models.garage.composite.TreeVehicleComposite;
import es.upm.miw.apaw_practice.domain.models.garage.composite.TreeVehicleLeaf;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VehicleEntityRepositoryIT {

    @Autowired
    private VehicleGarageRepository vehicleRepository;

    private TreeVehicle vehicle;

    @BeforeEach
    void initialCompositePattern() {
        this.vehicle = new TreeVehicleComposite("vehicle");
        TreeVehicle car = new TreeVehicleComposite("car");
        TreeVehicle truck = new TreeVehicleComposite("truck");

        TreeVehicle seat = new TreeVehicleComposite("Seat");
        TreeVehicle nissan = new TreeVehicleComposite("Nissan");

        TreeVehicle car1 = new TreeVehicleLeaf(this.vehicleRepository.findByCarRegistration("4585LHS").get().toVehicle());
        TreeVehicle car2 = new TreeVehicleLeaf(this.vehicleRepository.findByCarRegistration("7777MKL").get().toVehicle());
        TreeVehicle car3 = new TreeVehicleLeaf(this.vehicleRepository.findByCarRegistration("1111PLO").get().toVehicle());

        seat.add(car1);
        nissan.add(car2);
        nissan.add(car3);

        car.add(seat);
        car.add(nissan);

        vehicle.add(car);
        vehicle.add(truck);
    }

    @Test
    void testCompositePattern(){
        assertTrue(this.vehicle.isComposite());
        assertEquals("vehicle", this.vehicle.getModel());
        assertEquals(2, this.vehicle.numberOfDescendants());
        assertTrue(this.vehicle.getVehiclesModel().containsAll(List.of("car", "truck")));

        this.vehicle.getVehicles().stream()
                .forEach(treeVehicle -> {
                    assertTrue(treeVehicle.isComposite());
                });

        TreeVehicle truck = this.vehicle.getVehicles().stream()
                .filter(treeVehicle -> treeVehicle.getModel().equals("truck"))
                .collect(Collectors.toList()).get(0);
        assertTrue(truck.isComposite());
        assertEquals(0, truck.numberOfDescendants());

        TreeVehicle car = this.vehicle.getVehicles().stream()
                .filter(treeVehicle -> treeVehicle.getModel().equals("car"))
                .collect(Collectors.toList()).get(0);
        assertTrue(car.isComposite());
        assertEquals(2, car.numberOfDescendants());
        assertTrue(car.getVehiclesModel().containsAll(List.of("Seat", "Nissan")));

        car.getVehicles().stream()
                .forEach(treeVehicle -> {
                    assertTrue(treeVehicle.isComposite());
                    assertTrue(treeVehicle.numberOfDescendants() > 0);
                });

        assertTrue(
                car.getVehicles().stream()
                    .flatMap(treeVehicle -> treeVehicle.getVehiclesModel().stream())
                    .collect(Collectors.toList())
                    .containsAll(List.of("Seat Ibiza", "Nissan Qashqai", "Nissan Juke"))
        );
    }

    @AfterAll
    void testDeletingCompositePattern() {
        TreeVehicle nissan = this.vehicle.getVehicles().stream()
                .filter(vehicle -> vehicle.getModel().equals("car"))
                .collect(Collectors.toList())
                .get(0)
                .getVehicles()
                .stream()
                .filter(vehicle -> vehicle.getModel().equals("Nissan"))
                .collect(Collectors.toList())
                .get(0);

        this.vehicle.getVehicles().stream()
                .filter(vehicle -> vehicle.getModel().equals("car"))
                .collect(Collectors.toList())
                .get(0)
                .remove(nissan);

        assertEquals(1,
                this.vehicle.getVehicles().stream()
                        .filter(vehicle -> vehicle.getModel().equals("car"))
                        .collect(Collectors.toList())
                        .get(0).numberOfDescendants()
                );
    }

    @Test
    void testFindByCarRegistration() {
        assertTrue(this.vehicleRepository.findByCarRegistration("4585LHS").isPresent());
        VehicleEntity vehicle = this.vehicleRepository.findByCarRegistration("4585LHS").get();
        assertEquals("Seat Ibiza", vehicle.getModel());
        assertEquals(0, BigDecimal.valueOf(250.25).compareTo(vehicle.getEstimatedBudget()));
        assertEquals(0, LocalDateTime.of(2020, 8, 2, 10, 0).compareTo(vehicle.getReceptionDate()));
        assertEquals(0, LocalDateTime.of(2020, 8, 20, 17, 30).compareTo(vehicle.getEstimatedDeliveryDate()));
        assertFalse(vehicle.getPieceEntities().isEmpty());
        assertFalse(vehicle.getMechanicEntities().isEmpty());
    }
}
