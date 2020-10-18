package es.upm.miw.apaw_practice.domain.models.socialnetwork;

public interface TreeSocialUsers {

    String id();

    String nickName();

    Boolean isComposite();

    void add(TreeSocialUsers treeSocialUsers);

    void remove(TreeSocialUsers treeSocialUsers);

}
