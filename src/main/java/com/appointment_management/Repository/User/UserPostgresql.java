package com.appointment_management.Repository.User;

import com.appointment_management.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserPostgresql implements UserDAO{
    private Connection connection;

    public UserPostgresql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User u) {
        String sql = "INSERT INTO \"User\" (firstName, lastName, email, password, userType) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, u.getFirstName());
            statement.setString(2, u.getLastName());
            statement.setString(3, u.getEmail());
            statement.setString(4, u.getPassword());
            statement.setString(5, u.getUserType());

            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * from \"User\"";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("userType")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public List<User> findId(int id) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM \"User\" WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("userType")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE \"User\" SET firstName = ?, lastName = ?, email = ?, password = ?, userType = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, u.getFirstName());
            statement.setString(2, u.getLastName());
            statement.setString(3, u.getEmail());
            statement.setString(4, u.getPassword());
            statement.setString(5, u.getUserType());
            statement.setInt(6, u.getId());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM \"User\" WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error while suppressing");
        }
    }

}


