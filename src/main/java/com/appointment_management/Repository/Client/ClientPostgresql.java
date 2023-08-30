package com.appointment_management.Repository.Client;

import com.appointment_management.model.Client;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientPostgresql implements ClientDAO{
    private Connection connection;

    public ClientPostgresql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Client c) {
        String sql = "INSERT INTO Client (firstName, lastName, email, gender, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, c.getFirstName());
            statement.setString(2, c.getLastName());
            statement.setString(3, c.getEmail());
            statement.setString(4, String.valueOf(c.getGender()));
            statement.setString(5, c.getPassword());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * from Client";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                clients.add(new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public List<Client> findId(int id) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Clients WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("gender").charAt(0),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public void update(Client c) {
        String sql = "UPDATE Client SET appointmentDate = ?, location = ?, description = ?, appointmentType = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, c.getFirstName());
            statement.setString(2, c.getLastName());
            statement.setString(3, c.getEmail());
            statement.setString(4, String.valueOf(c.getGender()));
            statement.setString(5, c.getPassword());
            statement.setInt(6, c.getId());

            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while suppressing");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Client WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error while suppressing");
        }
    }
}
