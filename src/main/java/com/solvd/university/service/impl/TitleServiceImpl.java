package com.solvd.university.service.impl;

import com.solvd.university.bin.Title;
import com.solvd.university.service.IBaseService;

import com.solvd.university.dao.jdbcImpl.TitleDAO;
//import com.solvd.university.dao.mybatisImpl.TitleDAO;

public class TitleServiceImpl implements IBaseService<Title> {

    private TitleDAO titleDAO = new TitleDAO();

    public TitleServiceImpl() {
    }

    @Override
    public void createEntity(Title entity) {
        titleDAO.create(entity);
    }

    @Override
    public Title readEntity(int id) {
        return titleDAO.read(id);
    }

    @Override
    public void updateEntity(Title entity) {
        titleDAO.update(entity);
    }

    @Override
    public void deleteEntity(int id) {
        titleDAO.delete(id);
    }
}
