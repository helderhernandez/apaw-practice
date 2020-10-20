package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeDiseasesComposite implements TreeDiseases {

    private final List<TreeDiseases> treeDiseasesList;
    private final String name;

    public TreeDiseasesComposite(String name) {
        this.treeDiseasesList = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(TreeDiseases treeDiseases) {
        this.treeDiseasesList.add(treeDiseases);
    }

    @Override
    public void remove(TreeDiseases treeDiseases) {
        this.treeDiseasesList.remove(treeDiseases);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public List<String> getDiseasesName() {
        return this.treeDiseasesList.stream()
                .filter(treeDiseases -> !treeDiseases.isComposite())
                .map(TreeDiseases::getName)
                .collect(Collectors.toList());
    }
}
