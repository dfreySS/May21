package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    public static Connection conn = null;

    public BaseDAO(Connection conn) {
        this.conn = conn;
    }
    public void save(String sql, Object[] vals) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if(vals!=null) {
            int count = 1;
            for(Object o: vals) {
                pstmt.setObject(count, o);
                count++;
            } // for
        } // if
        pstmt.executeUpdate();
    } // save

    public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if(vals!=null) {
            int count = 1;
            for(Object o: vals) {
                pstmt.setObject(count, o);
                count++;
            }
        }
        return getData(pstmt.executeQuery());
    }

    protected abstract List<T> getData(ResultSet rs) throws ClassNotFoundException, SQLException;
} // BaseDAO