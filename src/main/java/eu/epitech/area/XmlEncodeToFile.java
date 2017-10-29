package eu.epitech.area;

import javax.swing.*;
import java.beans.XMLEncoder;
import java.io.*;

public class XmlEncodeToFile {

    public void EncodeUsersBean(UsersBean ub) throws FileNotFoundException, IOException
    {
        System.out.println("Encoding class to XML");

        System.out.println(new File(".").getCanonicalPath() + "/usersBean.xml");
        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("usersBean.xml")));
        }catch(FileNotFoundException fileNotFound){
            System.err.println("ERROR: While Creating or Opening the File userBean.xml");
        }
        try {
            encoder.writeObject(ub);
            encoder.close();
        }
        catch(NullPointerException err) {
            System.err.println("ERROR: unable to write xml file: " + err.getMessage());
        }
        System.out.println("Class encoded");
    }

}
