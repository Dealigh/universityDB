package com.solvd.university.dao.jdbcImpl;

import com.solvd.university.bin.Student;
import com.solvd.university.dao.IBaseDAO;
import com.solvd.university.utils.connectionpool.ConnectionPool;
import com.solvd.university.utils.connectionpool.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.solvd.university.utils.Instantiation.instantiateStudent;

public class StudentDAO extends AbstractDAO implements IBaseDAO<Student> {

    public static final String SELECT_STUDENT_ID = "SELECT * FROM Student WHERE Id = ?";
    public static final String DELETE_STUDENT_ID = "DELETE FROM Student WHERE Id = ?";
    public static final String UPDATE_STUDENT_ID = "UPDATE Student "
            + "SET Name = ?, Age = ?, CareerPercentage = ?, Residence = ? "
            + "WHERE Id = ?";
    public static final String INSERT_STUDENT_ID = "INSERT INTO Student "
            + "(Name, Age, careerPercentage, Residence)"
            + "VALUES "
            + "(?, ?, ?, ?)";

    public StudentDAO() {
    }

    @Override
    public Student getEntityById(int id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(SELECT_STUDENT_ID);

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Student student = instantiateStudent(rs);
                return student;
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
    public void saveEntity(Student obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(INSERT_STUDENT_ID,
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setInt(2, obj.getAge());
            st.setDouble(3, obj.getCareerPercent());
            st.setString(4, obj.getResidence().getName());

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
    public void updateEntity(Student obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(UPDATE_STUDENT_ID);

            st.setString(1, obj.getName());
            st.setInt(2, obj.getAge());
            st.setDouble(3, obj.getCareerPercent());
            st.setString(4, obj.getResidence().getName());

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
            st = getConnection().prepareStatement(DELETE_STUDENT_ID);

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }
}