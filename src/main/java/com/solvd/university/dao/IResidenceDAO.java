package com.solvd.university.dao;

import com.solvd.university.bin.Residence;

public interface IResidenceDAO extends IBaseDAO<Residence> {

    Residence getEntityById(int id);

    void saveEntity(Residence entity);

    void updateEntity(Residence entity);

    void removeEntity(int id);
}
