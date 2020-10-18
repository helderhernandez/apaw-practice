package es.upm.miw.apaw_practice.domain.models.socialnetwork;

public class TreeSocialUsersLeaf implements TreeSocialUsers {

    private SocialUser socialUser;

    public TreeSocialUsersLeaf(SocialUser socialUser) {
        this.socialUser = socialUser;
    }

    @Override
    public String id() {
        return this.socialUser.getId();
    }

    @Override
    public String nickName() {
        return this.socialUser.getNickName();
    }

    @Override
    public Boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeSocialUsers treeSocialUsers) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(TreeSocialUsers treeSocialUsers) {
        // Do nothing because is leaf
    }

}
