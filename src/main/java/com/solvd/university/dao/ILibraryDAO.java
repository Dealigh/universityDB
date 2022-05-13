package com.solvd.university.dao;

import com.solvd.university.bin.Library;

public interface ILibraryDAO extends IBaseDAO<Library> {

    Library getEntityById(int id);

    void saveEntity(Library entity);

    void updateEntity(Library entity);

    void removeEntity(int id);
}
