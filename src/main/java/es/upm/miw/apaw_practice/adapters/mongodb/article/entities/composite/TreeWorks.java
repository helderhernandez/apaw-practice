package es.upm.miw.apaw_practice.adapters.mongodb.article.entities.composite;

public interface TreeWorks {

    void  add(TreeWorks treeWorks);

    void remove(TreeWorks treeWorks);

    boolean isComposite();

    int numberOfDescendants();
}
