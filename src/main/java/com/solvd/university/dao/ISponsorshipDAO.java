package com.solvd.university.dao;

import com.solvd.university.bin.Sponsorship;

public interface ISponsorshipDAO extends IBaseDAO<Sponsorship> {

    Sponsorship getEntityById(int id);

    void saveEntity(Sponsorship entity);

    void updateEntity(Sponsorship entity);

    void removeEntity(int id);
}
