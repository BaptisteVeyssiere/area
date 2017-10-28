package eu.epitech.area;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;


public class XMLDecodeFromFile {
    public void DecodeUserBean(UserBean ub) throws Exception
    {
        // ouverture d'un flux sur un fichier
        XMLDecoder decoder=null;
        try {
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("userBean.xml")));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File userBean.xml not found");
        }
       ub = (UserBean) decoder.readObject();
    }

}
