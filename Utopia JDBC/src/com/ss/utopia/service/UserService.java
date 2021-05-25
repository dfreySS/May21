package com.ss.utopia.service;

import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.User;
import com.ss.utopia.entity.UserRole;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements CRUDInterface<User> {
    @Override
    public void add(User user) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            userDAO.addUser(user);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        Connection conn = null;
        List<User> users = new ArrayList<>();
        try {
            conn = ConnectionService.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            users = userDAO.readAllUsers();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return users;
    }

    @Override
    public void update(User user) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            userDAO.updateUser(user);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            userDAO.deleteUSer(user);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    public List<User> getUsersByRole(UserRole role) throws SQLException {
        Connection conn = null;
        List<User> users = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            users = userDAO.readUsersByRole(role);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return users;
    }
}