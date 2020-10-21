package es.upm.miw.apaw_practice.domain.services.tree_conservation;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Disease;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.DiseaseCreation;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Inspection;
import es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation.DiseasePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation.TreePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DiseaseService {
    private final DiseasePersistence diseasePersistence;
    private final TreePersistence treePersistence;

    @Autowired
    public DiseaseService(DiseasePersistence diseasePersistence, TreePersistence treePersistence) {
        this.diseasePersistence = diseasePersistence;
        this.treePersistence = treePersistence;
    }

    public Disease create(DiseaseCreation diseaseCreation) {
        return this.diseasePersistence.create(diseaseCreation);
    }

    public void delete(String name) {
        this.diseasePersistence.deleteByName(name);
    }

    public Stream<Disease> findByInspectionType(String type) {
        List<String> diseaseNameList = this.treePersistence.readAll()
                .filter(tree -> tree.getInspections().stream()
                        .map(Inspection::getType).anyMatch(type::equals))
                .flatMap(tree -> tree.getDiseasesName().stream())
                .collect(Collectors.toList());
        return this.diseasePersistence.readAll().filter(disease ->
                diseaseNameList.contains(disease.getName()));
    }
}
