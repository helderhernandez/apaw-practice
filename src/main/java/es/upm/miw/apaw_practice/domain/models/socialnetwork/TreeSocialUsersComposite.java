package es.upm.miw.apaw_practice.domain.models.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class TreeSocialUsersComposite implements TreeSocialUsers {

    private String id;
    private String nickName;
    private List<TreeSocialUsers> treeSocialUsersList;

    public TreeSocialUsersComposite(String id, String nickName) {
        this.id = id;
        this.nickName = nickName;
        this.treeSocialUsersList = new ArrayList<>();
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public String nickName() {
        return this.nickName;
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeSocialUsers treeSocialUsers) {
        this.treeSocialUsersList.add(treeSocialUsers);
    }

    @Override
    public void remove(TreeSocialUsers treeSocialUsers) {
        this.treeSocialUsersList.remove(treeSocialUsers);
    }

}
