package com.solvd.university.dao.jdbcImpl;

import com.solvd.university.bin.Exam;
import com.solvd.university.dao.IExamDAO;
import com.solvd.university.utils.connectionpool.ConnectionPool;
import com.solvd.university.utils.connectionpool.DbException;

import java.sql.*;

import static com.solvd.university.utils.Instantiation.instantiateExam;

public class ExamDAO extends AbstractDAO implements IExamDAO {

    public static final String DELETE_EXAM_ID = "DELETE FROM exam WHERE Id = ?";
    public static final String SELECT_EXAM = "SELECT Exam "
            + "FROM exam INNER JOIN grade "
            + "ON exam.GradeId = grade.Id "
            + "WHERE exam.Id = ?";
    public static final String INSERT_EXAM = "INSERT INTO Exam "
            + "(Note, Grade, Date)"
            + "VALUES "
            + "(?, ?, ?)";
    public static final String UPDATE_EXAM = "UPDATE Exam "
            + "SET Note = ?, Grade = ?, Date = ? "
            + "WHERE Id = ?";

    public ExamDAO() {
    }

    @Override
    public Exam read(int id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConnection().prepareStatement(SELECT_EXAM);

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Exam exam = instantiateExam(rs);
                return exam;
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
    public void create(Exam obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(INSERT_EXAM,
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getNote());
            st.setInt(2, obj.getGrade());
            st.setDate(3, new java.sql.Date(obj.getDate().getTime()));

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
    public void update(Exam obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(UPDATE_EXAM);

            st.setInt(1, obj.getId());
            st.setInt(2, obj.getNote());
            st.setInt(2, obj.getGrade());
            st.setDate(3, new java.sql.Date(obj.getDate().getTime()));

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
            st = getConnection().prepareStatement(DELETE_EXAM_ID);

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }
}
