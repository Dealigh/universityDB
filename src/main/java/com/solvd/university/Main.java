package com.solvd.university;

import com.solvd.university.bin.School;
import com.solvd.university.service.IBaseService;
import com.solvd.university.service.impl.SchoolServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        School lawSchool = new School(1, 12000, "School of Laws");
        School lawSchool2 = new School(2, 9000, "Economics School");
        School lawSchool3 = new School(3, 17000, "Medicine School");
        School lawSchool4 = new School(4, 5000, "Arts School");
        School lawSchool5 = new School(5, 13000, "Engineering School");

        List<School> schools = new ArrayList<>();
        schools.add(lawSchool);
        schools.add(lawSchool2);
        schools.add(lawSchool3);
        schools.add(lawSchool4);
        schools.add(lawSchool5);

        IBaseService<School> schoolService = new SchoolServiceImpl();

        for (School school: schools) {
            schoolService.createEntity(school);
        }

        for(int i = 0; i < schools.size(); i++) {
            LOGGER.error(schoolService.readEntity(i));
        }
    }
}
