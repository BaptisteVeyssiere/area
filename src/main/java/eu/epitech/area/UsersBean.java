package eu.epitech.area;

import java.util.LinkedList;

public class UsersBean {
    LinkedList<Client> users = new LinkedList<Client>();

    public UsersBean () {
    }

    public void addUser(Client client) {
     users.add(client);
    }

    public LinkedList<Client> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<Client> musers) {
        this.users = musers;
    }
}