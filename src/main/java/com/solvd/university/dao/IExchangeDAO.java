package com.solvd.university.dao;

import com.solvd.university.bin.Exchanges;

public interface IExchangeDAO extends IBaseDAO<Exchanges> {

    Exchanges getEntityById(int id);

    void saveEntity(Exchanges entity);

    void updateEntity(Exchanges entity);

    void removeEntity(int id);
}
