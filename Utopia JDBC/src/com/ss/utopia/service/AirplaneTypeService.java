package com.ss.utopia.service;

import com.ss.utopia.dao.AirplaneTypeDAO;
import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.entity.AirplaneType;
import com.ss.utopia.entity.Airport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneTypeService implements CRUDInterface<AirplaneType> {
    @Override
    public List<AirplaneType> getAll() throws SQLException {
        Connection conn = null;
        List<AirplaneType> airplaneTypes = new ArrayList<>();

        try {
            conn = ConnectionService.getConnection();
            AirplaneTypeDAO airplaneTypeDAO = new AirplaneTypeDAO(conn);
            airplaneTypes = airplaneTypeDAO.readAllAirports();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

        return airplaneTypes;
    }

    @Override
    public void add(AirplaneType airplaneType) throws SQLException {

        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            AirplaneTypeDAO airplaneTypeDAO = new AirplaneTypeDAO(conn);
            airplaneTypeDAO.addAirplaneType(airplaneType);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public void update(AirplaneType airplaneType) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            AirplaneTypeDAO airplaneTypeDAO = new AirplaneTypeDAO(conn);
            airplaneTypeDAO.updateAirplaneType(airplaneType);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }

    @Override
    public void delete(AirplaneType airplaneType) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionService.getConnection();
            AirplaneTypeDAO airplaneTypeDAO = new AirplaneTypeDAO(conn);
            airplaneTypeDAO.deleteAirplaneType(airplaneType);
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}
