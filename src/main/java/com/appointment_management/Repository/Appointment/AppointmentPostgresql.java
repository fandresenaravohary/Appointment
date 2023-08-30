package com.appointment_management.Repository.Appointment;

import com.appointment_management.model.Appointment;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentPostgresql implements AppointmentDAO{
    private Connection connection;

    public AppointmentPostgresql(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insert(Appointment a) {
        String sql = "INSERT INTO Appointment (appointmentDate, location, description, appointmentType) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setDate(1, Date.valueOf(a.getAppointmentDate()));
            statement.setString(2, a.getLocation());
            statement.setString(3, a.getDescription());
            statement.setString(4, a.getAppointmentType());

            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Appointment> findAll() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * from Appointment";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                appointments.add(new Appointment(
                        resultSet.getInt("id"),
                        resultSet.getDate("appointmentDate").toLocalDate(),
                        resultSet.getString("location"),
                        resultSet.getString("description"),
                        resultSet.getString("appointmentType")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return appointments;
    }

    @Override
    public List<Appointment> findId(int id) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointment WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                appointments.add(new Appointment(
                        resultSet.getInt("id"),
                        resultSet.getDate("appointmentDate").toLocalDate(),
                        resultSet.getString("location"),
                        resultSet.getString("description"),
                        resultSet.getString("appointmentType")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return appointments;
    }

    @Override
    public void update(Appointment a) {
        String sql = "UPDATE Appointment SET appointmentDate = ?, location = ?, description = ?, appointmentType = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setDate(1, Date.valueOf(a.getAppointmentDate()));
            statement.setString(2, a.getLocation());
            statement.setString(3, a.getDescription());
            statement.setString(4, a.getAppointmentType());
            statement.setInt(5, a.getId());

            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Appointment WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error while suppressing");
        }
    }
}

