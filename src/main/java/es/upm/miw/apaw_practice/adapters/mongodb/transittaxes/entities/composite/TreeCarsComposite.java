package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.composite;


import java.util.ArrayList;
import java.util.List;

public class TreeCarsComposite implements TreeCars {

    private String enrollment;
    private List<TreeCars> treeArticlesList;

    public TreeCarsComposite(String enrollment) {
        this.enrollment = enrollment;
        this.treeArticlesList = new ArrayList<>();
    }

    @Override
    public String enrollment() {
        return this.enrollment;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeCars treeCars) {
        treeArticlesList.add(treeCars);
    }

    @Override
    public void remove(TreeCars treeCars) {
        treeArticlesList.remove(treeCars);

    }
}
