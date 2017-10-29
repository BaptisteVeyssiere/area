package eu.epitech.area;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;


public class XMLDecodeFromFile {
    public UsersBean DecodeUsersBean(UsersBean users) throws Exception
    {
        // ouverture d'un flux sur un fichier
        XMLDecoder decoder=null;
        try {
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("usersBean.xml")));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File usersBean.xml not found");
        }
        users = (UsersBean) decoder.readObject();
        System.out.println("Class decoded");
        return (users);
    }
}
