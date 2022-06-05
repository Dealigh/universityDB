package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.Title;
import com.solvd.university.dao.ITitleDAO;
import org.apache.ibatis.session.SqlSession;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class TitleDAO implements ITitleDAO {

    private final SqlSession session = getSession();

    private Title title;

    public TitleDAO() {
    }

    @Override
    public void create(Title entity) {
        createMapper(TITLE_DAO, entity);
    }

    @Override
    public Title read(int id) {
        getSession();
        if (session != null) {
            try {
                String idExam = String.valueOf(id);
                session.selectMap(TITLE_DAO + ".read", idExam);
            } finally {
                session.close();
            }
        }
        return title;
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