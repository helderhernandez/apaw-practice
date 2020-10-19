package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory;



import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.AddressRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.FurnitureRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.StaffRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos.WarehouseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.AddressEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.StaffEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.WarehouseEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class FurnitureFactorySeederService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private FurnitureRepository furnitureRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- FurnitureFactory Initial Load -----------");

        FurnitureEntity[] furniture = {
                new FurnitureEntity("Desk", new BigDecimal("15.90"), LocalDate.of(2021, 11, 13), 10000L),
                new FurnitureEntity("Bed", new BigDecimal("89.90"), LocalDate.of(2020, 6, 1),11000L),
                new FurnitureEntity("Chair", new BigDecimal("35.60"), LocalDate.of(2020, 5, 23), 13000L),
                new FurnitureEntity("Chest", new BigDecimal("79.90"), LocalDate.of(2020, 4, 2), 14000L),

        };
        this.furnitureRepository.saveAll(Arrays.asList(furniture));
        AddressEntity[] address = {
                new AddressEntity("China", "Taizhou","Jiaojiang"),
                new AddressEntity("Spain", "Madrid","Granvia"),
                new AddressEntity("Japan", "Tokyo","Shinjuku"),
                new AddressEntity("Korea", "seoul","Xinshadong"),
        };
        this.addressRepository.saveAll(Arrays.asList(address));
        StaffEntity[] staff = {
                StaffEntity.builder().firstName("Jose").lastName("Luis").dni("Y6687008C").age(23).phone(688010527).post("hamal").build(),
                StaffEntity.builder().firstName("German").lastName("Dolado").dni("Y6577008A").age(19).phone(657011258).post("director").build(),
                StaffEntity.builder().firstName("Pablo").lastName("David").dni("Y6897008X").age(36).phone(688236589).post("cleaner").build(),
                StaffEntity.builder().firstName("Sebastian").lastName("jose").dni("Y6147008N").age(45).phone(641258963).post("security").build(),

        };
        this.staffRepository.saveAll(Arrays.asList(staff));
        WarehouseEntity[] warehouse = {
                new WarehouseEntity("a", "1200m³", true, Arrays.asList(staff), Arrays.asList(address),Arrays.asList(furniture)),
                new WarehouseEntity("b", "1300m³", true, Arrays.asList(staff), Arrays.asList(address),Arrays.asList(furniture)),
                new WarehouseEntity("c", "1500m³", false, Arrays.asList(staff), Arrays.asList(address),Arrays.asList(furniture)),
                new WarehouseEntity("d", "1600m³", false, Arrays.asList(staff), Arrays.asList(address),Arrays.asList(furniture)),
        };
        this.warehouseRepository.saveAll(Arrays.asList(warehouse));
    }


    public void deleteAll() {
        this.furnitureRepository.deleteAll();

    }
}


