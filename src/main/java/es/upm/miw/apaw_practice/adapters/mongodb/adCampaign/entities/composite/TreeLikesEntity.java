package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;

import java.util.List;

public interface TreeLikesEntity {

    String id();

    String likesEntityName();

    void add(TreeLikesEntity treeLikesEntity);

    void remove(TreeLikesEntity treeLikesEntity);

    boolean isComposite();

    List<TreeLikesEntity> treeLikesEntityList();
}
