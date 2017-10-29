package eu.epitech.area;

import java.util.ArrayList;
import java.util.List;

public class UsersBean {
    ArrayList<UserBean> users = new ArrayList<UserBean>();

    public UsersBean () {
    }

    public void addUser(UserBean ub)
    {
     users.add(ub);
    }

    public ArrayList<UserBean> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserBean> users) {
        this.users = users;
    }
}
