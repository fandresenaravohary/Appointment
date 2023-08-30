package com.appointment_management.Repository.Admin;

import com.appointment_management.model.Admin;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminPostgresql implements AdminDAO {
    private Connection connection;

    public AdminPostgresql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Admin A) {
        String sql = "INSERT INTO Admin (firstName, lastName, email, gender, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, A.getFirstName());
            statement.setString(2, A.getLastName());
            statement.setString(3, A.getEmail());
            statement.setString(4, String.valueOf(A.getGender()));
            statement.setString(5, A.getPassword());

            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * from Admin";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                admins.add(new Admin(
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
        return admins;
    }

    @Override
    public List<Admin> findId(int id) {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM Admin WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                admins.add(new Admin(
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
        return admins;
    }

    @Override
    public void update(Admin A) {
        String sql = "UPDATE Admin SET firstName = ?, lastName = ?, email = ?, gender = ?, password = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, A.getFirstName());
            statement.setString(2, A.getLastName());
            statement.setString(3, A.getEmail());
            statement.setString(4, String.valueOf(A.getGender()));
            statement.setString(5, A.getPassword());
            statement.setInt(6, A.getId());

            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while updating");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Admin WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error while suppressing");
        }
    }


}
