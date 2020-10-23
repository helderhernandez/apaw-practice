package es.upm.miw.apaw_practice.adapters.mongodb.article.entities.composite;

import java.util.ArrayList;
import java.util.List;

public class TreeWorksComposite implements TreeWorks{
    List<TreeWorks> treeWorksList;

    public TreeWorksComposite() { this.treeWorksList = new ArrayList<>(); }

    public TreeWorksComposite(List<TreeWorks> treeWorksList) { this.treeWorksList = treeWorksList; }

    @Override
    public void add(TreeWorks treeWorks) { this.treeWorksList.add(treeWorks); }

    @Override
    public void remove(TreeWorks treeWorks) { this.treeWorksList.remove(treeWorks); }

    @Override
    public boolean isComposite() { return  true; }

    @Override
    public int numberOfDescendants() { return this.treeWorksList.size(); }
}
