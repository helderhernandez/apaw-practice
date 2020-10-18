package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.VeterinaryEntity;

import java.util.List;

public class TreeVeterinariansLeaf implements TreeVeterinarians {

    private VeterinaryEntity veterinaryEntity;

    public TreeVeterinariansLeaf(VeterinaryEntity veterinaryEntity) {
        this.veterinaryEntity = veterinaryEntity;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String getName() {
        return this.veterinaryEntity.getName();
    }

    @Override
    public void add(TreeVeterinarians treeVeterinarians) {
        //Do nothing is leaf
    }

    @Override
    public void remove(TreeVeterinarians treeVeterinarians) {
        //Do nothing is leaf
    }

    @Override
    public List<String> getVeterinariansName() {
        return List.of(this.veterinaryEntity.getName());
    }
}
