package com.ss.utopia.service;

import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Route;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteService implements CRUDInterface<Route> {
    @Override
    public void add(Route route) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            RouteDAO routeDAO = new RouteDAO(conn);
            routeDAO.addRoute(route);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public List<Route> getAll() throws SQLException {

        Connection conn = null;
        List<Route> routes = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            RouteDAO routeDAO = new RouteDAO(conn);
            routes = routeDAO.readAllRoutes();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return routes;
    }

    @Override
    public void update(Route route) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            RouteDAO routeDAO = new RouteDAO(conn);
            routeDAO.updateRoute(route);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public void delete(Route route) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            RouteDAO routeDAO = new RouteDAO(conn);
            routeDAO.deleteRoute(route);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}
