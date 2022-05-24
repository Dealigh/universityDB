package com.solvd.university.dao.impl;

import com.solvd.university.bin.Student;
import com.solvd.university.bin.Title;
import com.solvd.university.dao.IBaseDAO;
import com.solvd.university.utils.ConnectionPool;
import com.solvd.university.utils.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.solvd.university.utils.Instantiation.instantiateTitle;

public class TitleDAO extends AbstractDAO implements IBaseDAO<Title> {
    public static final String SELECT_TITLE_ID = "SELECT * FROM Title WHERE Id = ?";

    @Override
    public Title getEntityById(int id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(SELECT_TITLE_ID);

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Title title = instantiateTitle(rs);
                return title;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
            ConnectionPool.closeResultSet(rs);
        }
    }

    @Override
    public void saveEntity(Title obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(
                    "INSERT INTO Title "
                            + "(id, schoolId, name)"
                            + "VALUES "
                            + "(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getId());
            st.setInt(2, obj.getSchoolId());
            st.setString(3, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                ConnectionPool.closeResultSet(rs);
            } else {
                throw new DbException(ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }

    @Override
    public void updateEntity(Title obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(
                    "UPDATE Title "
                            + "SET id = ?, schoolId = ?, Name = ? "
                            + "WHERE Id = ?");

            st.setInt(1, obj.getSchoolId());
            st.setString(2, obj.getName());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }

    @Override
    public void removeEntity(int id) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement("DELETE FROM Title WHERE Id = ?");

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }
}

