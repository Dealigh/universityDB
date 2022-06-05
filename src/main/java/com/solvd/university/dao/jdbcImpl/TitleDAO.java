package com.solvd.university.dao.jdbcImpl;

import com.solvd.university.bin.Title;
import com.solvd.university.dao.ITitleDAO;
import com.solvd.university.utils.connectionpool.ConnectionPool;
import com.solvd.university.utils.connectionpool.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.solvd.university.utils.Instantiation.instantiateTitle;

public class TitleDAO extends AbstractDAO implements ITitleDAO {

    public static final String SELECT_TITLE_ID = "SELECT * FROM Title WHERE Id = ?";
    public static final String INSERT_TITLE_ID = "INSERT INTO Title "
            + "(id, name, Schools_id)"
            + "VALUES "
            + "(?, ?, ?)";
    public static final String UPDATE_TITLE_ID = "UPDATE Title "
            + "SET id = ?, name = ?, schoolsId = ?"
            + "WHERE id = ?";
    public static final String DELETE_TITLE_ID = "DELETE FROM Title WHERE Id = ?";

    @Override
    public Title read(int id) {

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
    public void create(Title obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(INSERT_TITLE_ID,
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getId());
            st.setString(2, obj.getName());
            st.setInt(3, obj.getSchoolsId());

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
    public void update(Title obj) {
        PreparedStatement st = null;
        try {
            st = getConnection().prepareStatement(UPDATE_TITLE_ID);

            st.setInt(1, obj.getSchoolsId());
            st.setString(2, obj.getName());

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
            st = getConnection().prepareStatement(DELETE_TITLE_ID);

            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConnectionPool.closeStatement(st);
        }
    }
}

