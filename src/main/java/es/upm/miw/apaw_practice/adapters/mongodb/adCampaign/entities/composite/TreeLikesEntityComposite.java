package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;

import java.util.ArrayList;
import java.util.List;

public class TreeLikesEntityComposite implements TreeLikesEntity {

    private String id;
    private String name;

    private List<TreeLikesEntity> treeLikesEntityList;

    public TreeLikesEntityComposite(String id, String name) {
        this.id = id;
        this.name = name;
        this.treeLikesEntityList = new ArrayList<>();
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public String likesEntityName() {
        return this.name;
    }

    @Override
    public void add(TreeLikesEntity treeLikesEntity) {
        this.treeLikesEntityList.add(treeLikesEntity);
    }

    @Override
    public void remove(TreeLikesEntity treeLikesEntity) {
        this.treeLikesEntityList.remove(treeLikesEntity);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public List<TreeLikesEntity> treeLikesEntityList() {
        return this.treeLikesEntityList;
    }
}
