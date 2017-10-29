package eu.epitech.area;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userToken;
    private Map<String, String> pair = new HashMap<>();

    public UserBean () {
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Map<String, String> getPair() {
        return pair;
    }

    public void setPair(Map<String, String> pair) {
        this.pair = pair;
    }

    public void createPair(String module, String token){
        pair.put(module, token);
    }
}
