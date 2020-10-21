package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation;

import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos.DiseaseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos.InspectionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos.InspectorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos.TreeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.DiseaseEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.InspectionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.InspectorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.TreeEntity;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.DiseaseCreation;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TreeConservationSeederService {
    @Autowired
    private TreeRepository treeRepository;
    @Autowired
    private InspectionRepository inspectionRepository;
    @Autowired
    private InspectorRepository inspectorRepository;
    @Autowired
    private DiseaseRepository diseaseRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Worker Initial Load -----------");
        DiseaseEntity[] diseases = {
                new DiseaseEntity(new DiseaseCreation("disease1", "This is the disease1")),
                new DiseaseEntity(new DiseaseCreation("disease2", "This is the disease2")),
                new DiseaseEntity(new DiseaseCreation("disease3", "This is the disease3")),
                new DiseaseEntity(new DiseaseCreation("disease4", "This is the disease4")),
                new DiseaseEntity(new DiseaseCreation("disease5", "This is the disease5"))
        };
        this.diseaseRepository.saveAll(Arrays.asList(diseases));

        InspectorEntity[] inspectors = {
                InspectorEntity.builder().dni("dni1").firstName("firstName1").lastName("lastName1").age(27).email("email1").phoneNumber("phone1").build(),
                InspectorEntity.builder().dni("dni2").firstName("firstName2").lastName("lastName2").age(28).email("email2").phoneNumber("phone2").build(),
                InspectorEntity.builder().dni("dni3").firstName("firstName3").lastName("lastName3").age(29).email("email3").phoneNumber("phone3").build()
        };
        this.inspectorRepository.saveAll(Arrays.asList(inspectors));

        InspectionEntity[] inspections = {
                new InspectionEntity(LocalDateTime.now(), "type1", "status1", inspectors[0]),
                new InspectionEntity(LocalDateTime.now(), "type1", "status1", inspectors[0]),
                new InspectionEntity(LocalDateTime.now(), "type2", "status2", inspectors[0]),
                new InspectionEntity(LocalDateTime.now(), "type1", "status2", inspectors[1]),
                new InspectionEntity(LocalDateTime.now(), "type2", "status2", inspectors[1]),
                new InspectionEntity(LocalDateTime.now(), "type2", "status3", inspectors[1]),
                new InspectionEntity(LocalDateTime.now(), "type1", "status3", inspectors[2]),
                new InspectionEntity(LocalDateTime.now(), "type1", "status3", inspectors[2]),
                new InspectionEntity(LocalDateTime.now(), "type2", "status1", inspectors[2])
        };
        this.inspectionRepository.saveAll(Arrays.asList(inspections));

        TreeEntity[] trees = {
                new TreeEntity("specie1", "young", Arrays.asList(inspections[0], inspections[3]), List.of(diseases[0], diseases[1])),
                new TreeEntity("specie1", "mature", Arrays.asList(inspections[1], inspections[4]), List.of(diseases[1], diseases[2])),
                new TreeEntity("specie2", "old", Arrays.asList(inspections[2], inspections[5]), List.of(diseases[3], diseases[4])),
                new TreeEntity("specie2", "young", Arrays.asList(inspections[6], inspections[7]), List.of(diseases[4], diseases[0])),
                new TreeEntity("specie3", "mature", Arrays.asList(inspections[8]), List.of(diseases[1], diseases[3])),
                new TreeEntity("specie3", "old", Arrays.asList(), List.of())
        };
        this.treeRepository.saveAll(Arrays.asList(trees));

    }

    public void deleteAll() {
        this.diseaseRepository.deleteAll();
        this.inspectorRepository.deleteAll();
        this.inspectionRepository.deleteAll();
        this.treeRepository.deleteAll();
    }
}
