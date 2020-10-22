package es.upm.miw.apaw_practice.adapters.mongodb.garage;


import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.MechanicRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.PieceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.VehicleGarageRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.DriverEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.MechanicEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.PieceEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.VehicleEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class GarageSeederService {

    @Autowired
    private VehicleGarageRepository vehicleRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private MechanicRepository mechanicRepository;
    @Autowired
    private PieceRepository pieceRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Garage Initial Load -----------");

        MechanicEntity[] mechanics = {
                new MechanicEntity("Raúl García", "689555666", "Chapa y pintura", BigDecimal.valueOf(8.35), Double.valueOf(5), Boolean.TRUE),
                new MechanicEntity("Laura Rodríguez", "333444555", "Motor", BigDecimal.valueOf(12.75), Double.valueOf(10.75), Boolean.TRUE),
                new MechanicEntity("Andrea Montaño", "111222333", "Tapicería", BigDecimal.valueOf(10.50), Double.valueOf(7.50), Boolean.TRUE),
                new MechanicEntity("Álvaro Martín", "555666777", "Neumáticos", BigDecimal.valueOf(11.25), Double.valueOf(8), Boolean.TRUE)
        };
        this.mechanicRepository.saveAll(Arrays.asList(mechanics));

        PieceEntity[] pieces = {
                new PieceEntity("123456", "Neumático", Boolean.FALSE, BigDecimal.valueOf(60)),
                new PieceEntity("98745", "Pintura blanca", Boolean.TRUE, BigDecimal.valueOf(100)),
                new PieceEntity("2124565DF", "Luces delanteras led", Boolean.TRUE, BigDecimal.valueOf(60)),
                new PieceEntity("JK 452.as", "Cuero asientos",Boolean.TRUE, BigDecimal.valueOf(150)),
                new PieceEntity("2124T", "Válvula del inyector", Boolean.TRUE, BigDecimal.valueOf(75))
        };
        this.pieceRepository.saveAll(Arrays.asList(pieces));

        VehicleEntity[] vehicles = {
                new VehicleEntity("4585LHS", "Seat Ibiza", BigDecimal.valueOf(250.25), LocalDateTime.of(2020, 8, 2, 10, 0), LocalDateTime.of(2020, 8, 20, 17, 30)),
                new VehicleEntity("7777MKL", "Nissan Qashqai", BigDecimal.valueOf(60.75), LocalDateTime.of(2020, 9, 15, 10, 0), LocalDateTime.of(2020, 10, 2, 10, 0)),
                new VehicleEntity("1111PLO", "Nissan Juke", BigDecimal.valueOf(125.00), LocalDateTime.of(2020, 10, 2, 12, 0), LocalDateTime.of(2020, 10, 3, 13, 0)),
                new VehicleEntity("1808MGS", "Citroen C3", BigDecimal.valueOf(100.15), LocalDateTime.of(2020, 9, 16, 10, 0), LocalDateTime.of(2020, 9, 17, 10, 0))
        };

        vehicles[0].setMechanicEntities(List.of(mechanics[0], mechanics[1]));
        vehicles[1].setMechanicEntities(List.of(mechanics[2]));
        vehicles[2].setMechanicEntities(List.of(mechanics[1], mechanics[3]));
        vehicles[3].setMechanicEntities(List.of(mechanics[3]));
        vehicles[0].setPieceEntities(List.of(pieces[0], pieces[4]));
        vehicles[1].setPieceEntities(List.of(pieces[0], pieces[2]));
        vehicles[2].setPieceEntities(List.of(pieces[2], pieces[1]));
        vehicles[3].setPieceEntities(List.of(pieces[1]));
        this.vehicleRepository.saveAll(Arrays.asList(vehicles));

        DriverEntity[] drivers = {
                new DriverEntity("12345678M", "Carlos Ruiz", "159753456", "carlos_ruiz@example.com", Boolean.TRUE, List.of(vehicles[0], vehicles[1])),
                new DriverEntity("87654321K", "Francisco González", "789456123", "frcgon@example.com", Boolean.FALSE, List.of(vehicles[2])),
                new DriverEntity("28903000J", "Ángel Mirasierra", "852963741", "mirasigel@example.com", Boolean.TRUE, List.of(vehicles[3]))
        };
        this.driverRepository.saveAll(Arrays.asList(drivers));
    }

    public void deleteAll() {
        this.vehicleRepository.deleteAll();
        this.driverRepository.deleteAll();
        this.mechanicRepository.deleteAll();
        this.pieceRepository.deleteAll();
    }

}
