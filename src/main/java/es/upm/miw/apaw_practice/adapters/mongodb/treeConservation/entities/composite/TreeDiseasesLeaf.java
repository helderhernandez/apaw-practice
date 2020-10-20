package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.DiseaseEntity;

import java.util.List;

public class TreeDiseasesLeaf implements TreeDiseases {

    private final DiseaseEntity diseaseEntity;

    public TreeDiseasesLeaf(DiseaseEntity diseaseEntity) {
        this.diseaseEntity = diseaseEntity;
    }

    @Override
    public String getName() {
        return this.diseaseEntity.getName();
    }

    @Override
    public void add(TreeDiseases treeDiseases) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void remove(TreeDiseases treeDiseases) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public List<String> getDiseasesName() {
        return List.of(this.diseaseEntity.getName());
    }
}
