package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.Title;
import com.solvd.university.dao.ITitleDAO;
import org.apache.ibatis.session.SqlSession;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class TitleServiceImpl implements ITitleDAO {

    private static final String TITLE_DAO = "ITitleDAO";
    private final SqlSession session = getSession();


    public TitleServiceImpl() {
    }

    @Override
    public void create(Title entity) {
        createMapper(TITLE_DAO, entity);
    }
    
    @Override
    public Title read(String id) {
        getSession();
        if (session != null) {
            try {

            } finally {
                session.close();
            }

        }
    }

    @Override
    public void update(Title entity) {
        updateMapper(TITLE_DAO, entity);
    }

    @Override
    public void delete(int id) {
        String idExam = String.valueOf(id);
        deleteMapper(TITLE_DAO, idExam);
    }
}