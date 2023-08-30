package com.appointment_management.Repository.Make;

import com.appointment_management.model.Make;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MakeDAOPostgresql implements MakeDAO {
    private Connection connection;

    @Override
    public void insert(Make E) {
        String sql = "INSERT INTO Make (id_client, id_appointment) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, E.getId_client());
            statement.setInt(2, E.getId_appointment());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Make> findAll() {
        List<Make> make = new ArrayList<>();
        String sql = "SELECT * from Make";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                make.add(new Make(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_client"),
                        resultSet.getInt("id_appointment")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return make;
    }

    @Override
    public List<Make> findId(int id) {
        List<Make> make = new ArrayList<>();
        String sql = "SELECT * FROM Clients WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                make.add(new Make(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_client"),
                        resultSet.getInt("id_appointment")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return make;
    }

    @Override
    public void update(Make E) {
        String sql = "UPDATE Make SET id_client = ?, id_appointment = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, E.getId_client());
            statement.setInt(2, E.getId_appointment());
            statement.setInt(3, E.getId());

            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while updating");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Make WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error while suppressing");
        }
    }

}
