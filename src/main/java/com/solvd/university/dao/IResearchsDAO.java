package com.solvd.university.dao;

import com.solvd.university.bin.Researchs;

public interface IResearchsDAO extends IBaseDAO<Researchs> {

    Researchs getEntityById(int id);

    void saveEntity(Researchs entity);

    void updateEntity(Researchs entity);

    void removeEntity(int id);
}
