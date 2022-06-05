package com.solvd.university.utils.jaxb;

import com.sun.xml.bind.v2.runtime.property.UnmarshallerChain;
import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbUtils {
    public static final String PATH_NAME = "src\\main\\resources\\";
    JAXBContext jaxbContext = null;

    public void marshall(Object obj) {
        try {
            jaxbContext = JAXBContext.newInstance(Object.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            String name = obj.getClass().getName();
            File file = new File(PATH_NAME + StringUtils.capitalize(name) + ".xml");
            marshaller.marshal(obj, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Object unmarshall(Object obj) {
        try {
            File file = new File(PATH_NAME + StringUtils.capitalize(obj.getClass().getName()) + ".xml");
            jaxbContext = JAXBContext.newInstance(Object.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }
}
