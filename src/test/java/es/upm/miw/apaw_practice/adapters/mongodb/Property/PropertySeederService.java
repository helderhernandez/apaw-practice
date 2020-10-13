package es.upm.miw.apaw_practice.adapters.mongodb.Property;

import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.MaintanenceItemRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.PropertyCompanyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.PropertyStaffRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.ProprietorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.MaintanenceItemEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyCompanyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyStaffEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.ProprietorEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class PropertySeederService {
    @Autowired
    private MaintanenceItemRepository maintanenceItemRepository;
    @Autowired
    private PropertyCompanyRepository propertyCompanyRepository;
    @Autowired
    private PropertyStaffRepository propertyStaffRepository;
    @Autowired
    private ProprietorRepository proprietorRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Property Initial Load -----------");

        ProprietorEntity[] proprietors = {
                new ProprietorEntity("Paloma","35274690B","35","688128554","paloma@gmail.com"),
                new ProprietorEntity("Frida","97653915F","24","688129375","frida@gmail.com"),
                new ProprietorEntity("Pablo","73778443A","56","688987331","pablo@gmail.com"),
                new ProprietorEntity("Franco","20180553E","48","688734233","frank@gmail.com"),
                new ProprietorEntity("Calros","39176787D","28","688866552","carlos@gmail.com"),
                new ProprietorEntity("Yolanda","24551133F","21","688331583","yolanda@gmail.com"),
        };
        this.proprietorRepository.saveAll(Arrays.asList(proprietors));

        PropertyStaffEntity[] propertyStaffs = {
                new PropertyStaffEntity("Luis","74603721B","Sunday and Monday on duty"),
                new PropertyStaffEntity("Mario","59230573A","Tuesday on duty"),
                new PropertyStaffEntity("Eli","95720562E","Wednesday on duty"),
                new PropertyStaffEntity("Patricio","92744724F","Thursday on duty"),
                new PropertyStaffEntity("Julio","55862635E","Friday and Saturday on duty"),
        };
        this.propertyStaffRepository.saveAll(Arrays.asList(propertyStaffs));

        PropertyCompanyEntity[] propertyCompanys = {
                new PropertyCompanyEntity("Lancdon Property Company","calle de vinilla,23",
                        "Mainly responsible for residential properties"),
                new PropertyCompanyEntity("Harriet Property Company","calle de Servilla,8",
                        "Mainly responsible for shopping mall properties"),
                new PropertyCompanyEntity("Yancie Property Company","calle de Rubio,15",
                        "Mainly responsible for school property properties"),
        };
        this.propertyCompanyRepository.saveAll(Arrays.asList(propertyCompanys));

        MaintanenceItemEntity[] items = {
                new MaintanenceItemEntity("Flowerbed","Greenbelt", LocalDate.of(2020,5,30),
                        new BigDecimal("1000.00"), 60001L,"Weeder",true),
                new MaintanenceItemEntity("Garden","Greenbelt", LocalDate.of(2020,8,13),
                        new BigDecimal("300.00"), 60002L,"Weeder",true),
                new MaintanenceItemEntity("Roof leaks","Construction", LocalDate.of(2020,6,28),
                        new BigDecimal("600.00"), 60003L,"Crane",true),
                new MaintanenceItemEntity("Cracked wall","Construction", LocalDate.of(2020,7,2),
                        new BigDecimal("100.00"), 60004L,"Ladder",true),
                new MaintanenceItemEntity("Repair manhole cover","Road", LocalDate.of(2020,11,30),
                        new BigDecimal("800.00"), 60005L,"Barrier",false),
        };
        this.maintanenceItemRepository.saveAll(Arrays.asList(items));

    }

    public void deleteAll() {
        this.maintanenceItemRepository.deleteAll();
        this.propertyCompanyRepository.deleteAll();
        this.propertyStaffRepository.deleteAll();
        this.proprietorRepository.deleteAll();
    }
}
