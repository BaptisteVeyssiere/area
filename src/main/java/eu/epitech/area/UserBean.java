package eu.epitech.area;

import java.io.Serializable;

public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userToken;

    public UserBean () {
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
