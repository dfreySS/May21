package com.ss.utopia.dao;

import com.ss.utopia.entity.AirplaneType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

    public AirplaneTypeDAO(Connection conn) {
        super(conn);
    }

    public void addAirplaneType(AirplaneType airplaneType) throws SQLException {
        save("INSERT into airplane_type (id, max_capacity) values (?, ?)",
                new Object[] {airplaneType.getId(), airplaneType.getMaxCapacity()});
    }

    public void updateAirplaneType(AirplaneType airplaneType) throws SQLException {
        save("UPDATE airplane_type set id = ?, max_capacity = ?",
                new Object[] {airplaneType.getId(), airplaneType.getMaxCapacity()});
    }

    public void deleteAirplaneType(AirplaneType airplaneType) throws SQLException, ClassNotFoundException {
        save("DELETE from airport where id = ?", new Object[] {airplaneType.getId()});
    }

    public List<AirplaneType> readAllAirports() throws SQLException, ClassNotFoundException {
        return read("SELECT * from airplane_type", null);
    }

    @Override
    protected List<AirplaneType> getData(ResultSet results) throws SQLException {
        List<AirplaneType> airplaneTypes = new ArrayList<>();
        while (results.next()) {
            AirplaneType airplaneType = new AirplaneType();
            airplaneType.setId(results.getInt("id"));
            airplaneType.setMaxCapacity(results.getInt("max_capacity"));
            airplaneTypes.add(airplaneType);
        }
        return airplaneTypes;
    }
} // AirportDAO
