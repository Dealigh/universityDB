package com.solvd.university.dao.jdbcImpl;

import com.solvd.university.bin.School;
import com.solvd.university.bin.Title;
import com.solvd.university.dao.ISchoolDAO;
import com.solvd.university.utils.connectionpool.ConnectionPool;
import com.solvd.university.utils.connectionpool.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.solvd.university.utils.Instantiation.instantiateSchool;
import static com.solvd.university.utils.Instantiation.instantiateTitle;

public class SchoolDAO extends AbstractDAO implements ISchoolDAO {

    public static final String SELECT_SCHOOL_ID = "SELECT * FROM Schools WHERE Id = ?";
    public static final String DELETE_SCHOOL_ID = "DELETE FROM Schools WHERE Id = ?";
    public static final String UPDATE_SCHOOL_ID = "UPDATE Schools "
            + "SET Name = ?, Price = ?"
            + "WHERE Id = ?";
    public static final String INSERT_SCHOOL_ID = "INSERT INTO Schools "
            + "(Id, Name, Price)"
            + "VALUES "
            + "(?, ?, ?)";

    public SchoolDAO() {
    }

    @Override
    public School read(int id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(SELECT_SCHOOL_ID);

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Title title = instantiateTitle(rs);
                School school = instantiateSchool(rs, title);
                return school;
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
    public void create(School obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(INSERT_SCHOOL_ID,
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getId());
            st.setInt(3, obj.getPrice());
            st.setString(2, obj.getName());

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
    public void update(School obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(UPDATE_SCHOOL_ID);

            st.setInt(1, obj.getId());
            st.setInt(2, obj.getPrice());
            st.setString(3, obj.getName());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(DELETE_SCHOOL_ID);

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }
}