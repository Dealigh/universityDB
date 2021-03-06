package com.solvd.university.dao.jdbcImpl;

import com.solvd.university.bin.Grade;
import com.solvd.university.dao.IBaseDAO;
import com.solvd.university.dao.IGradeDAO;
import com.solvd.university.utils.connectionpool.ConnectionPool;
import com.solvd.university.utils.connectionpool.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.solvd.university.utils.Instantiation.instantiateGrade;

public class GradeDAO extends AbstractDAO implements IGradeDAO {

    public static final String SELECT_GRADE_ID = "SELECT * FROM Grade WHERE Id = ?";
    public static final String DELETE_GRADE_ID = "DELETE FROM Grade WHERE Id = ?";
    public static final String INSERT_GRADE_ID = "INSERT INTO Grade "
            + "(Name, Optional, Title, Internship)"
            + "VALUES "
            + "(?, ?, ?, ?)";
    public static final String UPDATE_GRADE_ID = "UPDATE Grade "
            + "SET Name = ?, Optional = ?, Title = ?, Internship = ? "
            + "WHERE Id = ?";

    public GradeDAO() {
    }

    @Override
    public Grade read(int id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(SELECT_GRADE_ID);

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Grade grade = instantiateGrade(rs);
                return grade;
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
    public void create(Grade obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(INSERT_GRADE_ID,
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setBoolean(2, obj.getOptional());
            st.setObject(3, obj.getTitle());
            st.setObject(4, obj.getInternship());

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
    public void update(Grade obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(UPDATE_GRADE_ID);

            st.setString(1, obj.getName());
            st.setBoolean(2, obj.getOptional());
            st.setObject(3, obj.getTitle());
            st.setObject(4, obj.getInternship());

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
            st = getConnection().prepareStatement(DELETE_GRADE_ID);

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }
}

