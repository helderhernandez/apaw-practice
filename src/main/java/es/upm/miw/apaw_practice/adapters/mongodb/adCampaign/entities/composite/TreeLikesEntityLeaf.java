package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TreeLikesEntityLeaf implements TreeLikesEntity {

    private LikesEntity likesEntity;

    public TreeLikesEntityLeaf(LikesEntity likesEntity) {
        this.likesEntity = likesEntity;
    }

    @Override
    public String id() {
        return likesEntity.getId();
    }

    @Override
    public String likesEntityName() {
        return likesEntity.getName();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public List<TreeLikesEntity> treeLikesEntityList() {
        return Collections.singletonList(this);
    }

    @Override
    public void add(TreeLikesEntity treeLikesEntity) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(TreeLikesEntity treeLikesEntity) {
        // Do nothing because is leaf
    }

}
