package com.solvd.university.service.impl;

import com.solvd.university.bin.Title;
import com.solvd.university.dao.impl.TitleDAO;
import com.solvd.university.service.TitleService;

public class TitleServiceImpl implements TitleService {

    public TitleServiceImpl() {
    }

    private TitleDAO titleDAO = new TitleDAO();

    @Override
    public Title getTitle(int id) {
        return titleDAO.getEntityById(id);
    }

    @Override
    public void saveTitle(Title title) {
        titleDAO.saveEntity(title);
    }
}
