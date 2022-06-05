package com.solvd.university.utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static com.solvd.university.utils.jaxb.JaxbUtils.PATH_NAME;

public class jsonLister {

    public void saveJson(Object obj) {
        ObjectMapper writer = new ObjectMapper();

        List<Object> listJson = new ArrayList<>();
        listJson.add(obj);
        try {
            File file = new File(PATH_NAME + "JsonObjects.json");
            writer.writeValue(file, listJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
