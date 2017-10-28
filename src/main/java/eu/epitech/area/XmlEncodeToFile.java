package eu.epitech.area;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlEncodeToFile {
    public void EncodeUserBean(String ut) throws FileNotFoundException, IOException
    {
        System.out.println("Encoding class to XML");
        UserBean ub = new UserBean();
        ub.setUserToken(ut);

        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("userBean.xml")));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: While Creating or Opening the File userBean.xml");
        }
        encoder.writeObject(ub);
        encoder.close();
        System.out.println("Class encoded");
    }
}
