package es.upm.miw.apaw_practice.adapters.mongodb.article.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.WorksEntity;

public class TreeWorksLeaf implements TreeWorks {
    private WorksEntity worksEntity;

    public TreeWorksLeaf(WorksEntity worksEntity) { this.worksEntity = worksEntity; }

    public WorksEntity getWorksEntity() { return worksEntity; }

    public void  setWorksEntity(WorksEntity worksEntity) { this.worksEntity = worksEntity; }

    @Override
    public void add(TreeWorks treeWorks) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void remove(TreeWorks treeWorks) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public boolean isComposite() { return false; }

    @Override
    public int numberOfDescendants() {
        return 1;
    }
}
