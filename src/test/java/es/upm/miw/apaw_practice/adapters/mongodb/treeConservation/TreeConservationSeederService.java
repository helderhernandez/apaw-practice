package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.DiseaseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.InspectionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.InspectorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos.TreeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.DiseaseEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.InspectionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.InspectorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.TreeEntity;
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
                new DiseaseEntity("disease1", "This is the disease1"),
                new DiseaseEntity("disease2", "This is the disease2"),
                new DiseaseEntity("disease3", "This is the disease3"),
                new DiseaseEntity("disease4", "This is the disease4"),
                new DiseaseEntity("disease5", "This is the disease5")
        };
        this.diseaseRepository.saveAll(Arrays.asList(diseases));

        InspectorEntity[] inspectors = {
                new InspectorEntity("dni1", "firstName1", "lastName1", 27, "email1", "phone1"),
                new InspectorEntity("dni2", "firstName2", "lastName2", 28, "email2", "phone2"),
                new InspectorEntity("dni3", "firstName3", "lastName3", 29, "email3", "phone3")
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
