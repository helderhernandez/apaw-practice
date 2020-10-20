package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.composite;

import java.util.ArrayList;
import java.util.List;

public class TreeCDOwnerComposite implements TreeCDOwner{
    List<TreeCDOwner> treeCDOwnerList;

    public TreeCDOwnerComposite() {
        this.treeCDOwnerList = new ArrayList<>();
    }

    public TreeCDOwnerComposite(List<TreeCDOwner> treeCDOwnerList) {
        this.treeCDOwnerList = treeCDOwnerList;
    }

    @Override
    public void add(TreeCDOwner treeCDOwner) {
        this.treeCDOwnerList.add(treeCDOwner);
    }

    @Override
    public void remove(TreeCDOwner treeCDOwner) {
        this.treeCDOwnerList.remove(treeCDOwner);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public int numberOfDescendants() {
        return this.treeCDOwnerList.size();
    }
}
