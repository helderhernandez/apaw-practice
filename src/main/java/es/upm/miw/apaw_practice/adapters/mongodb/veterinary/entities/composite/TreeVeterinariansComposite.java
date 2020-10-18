package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeVeterinariansComposite implements TreeVeterinarians {
    private String veterinariansGroupName;

    private List<TreeVeterinarians> treeVeterinariansList;

    public TreeVeterinariansComposite(String veterinariansGroupName) {
        this.veterinariansGroupName = veterinariansGroupName;
        this.treeVeterinariansList = new ArrayList<>();
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String getName() {
        return this.veterinariansGroupName;
    }

    @Override
    public void add(TreeVeterinarians treeVeterinarians) {
        this.treeVeterinariansList.add(treeVeterinarians);
    }

    @Override
    public void remove(TreeVeterinarians treeVeterinarians) {
        this.treeVeterinariansList.remove(treeVeterinarians);
    }

    @Override
    public List<String> getVeterinariansName() {
        return treeVeterinariansList.stream()
                .filter(treeVeterinarians -> !treeVeterinarians.isComposite())
                .map(TreeVeterinarians::getName)
                .collect(Collectors.toList());
    }
}
