package pl.coderslab.DAO;

import pl.coderslab.models.Car;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;


public class CarDAO extends Car {

    public void CarSaveToDB() throws SQLException {
        try {
            Connection connection = DbUtil.getConn();
            if (this.getId() == 0) {
                String sql = "INSERT INTO cars (model, brand, year, plate, next_check, customer_id) VALUES (?, ?, ?, ?, ?, ?)";
                String generatedColumns[] = {"id"};
                PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);
                preparedStatement.setString(1, this.getModel());
                preparedStatement.setString(2, this.getBrand());
                preparedStatement.setInt(3, this.getYear());
                preparedStatement.setString(4, this.getPlate());
                preparedStatement.setDate(5, (Date) this.getNext_check());
                preparedStatement.setInt(6, this.getCustomer_id());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    this.setId(resultSet.getInt(1));
                }
            } else {
                String sql = "update cars set model=?, brand=?, year=?, plate=?, next_check=?, customer_id=? WHERE id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, this.getModel());
                preparedStatement.setString(2, this.getBrand());
                preparedStatement.setInt(3, this.getYear());
                preparedStatement.setString(4, this.getPlate());
                preparedStatement.setDate(5, (Date) this.getNext_check());
                preparedStatement.setInt(6, this.getCustomer_id());
                preparedStatement.setInt(7, this.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static public Car loadCarById(int id) throws SQLException {
        Connection connection = DbUtil.getConn();
        String sql = "SELECT * FROM cars where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            CarDAO loadedCar = new CarDAO();
            loadedCar.setId(resultSet.getInt("id"));
            loadedCar.setModel(resultSet.getString("model"));
            loadedCar.setBrand(resultSet.getString("brand"));
            loadedCar.setYear(resultSet.getInt("year"));
            loadedCar.setPlate(resultSet.getString("plate"));
            loadedCar.setNext_check(resultSet.getDate("next_check"));
            loadedCar.setCustomer_id(resultSet.getInt("customer_id"));
            return loadedCar;
        }
        return null;
    }

    public static ArrayList<Car> loadAllCars() throws SQLException {

        try {
            Connection connection = DbUtil.getConn();
            ArrayList<Car> carList = new ArrayList<>();
            String sql = "SELECT * FROM cars";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            getCarsData(carList, resultSet);
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static void getCarsData(ArrayList<Car> cars, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Car loadedCar = new Car();
            loadedCar.setId(resultSet.getInt("id"));
            loadedCar.setModel(resultSet.getString("model"));
            loadedCar.setBrand(resultSet.getString("brand"));
            loadedCar.setYear(resultSet.getInt("year"));
            loadedCar.setPlate(resultSet.getString("plate"));
            loadedCar.setNext_check(resultSet.getDate("next_check"));
            loadedCar.setCustomer_id(resultSet.getInt("customer_id"));
            cars.add(loadedCar);
        }
    }

    public void delete() throws SQLException {
        try {
            Connection connection = DbUtil.getConn();
            if (this.getId() != 0) {
                String sql = "delete from cars where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, this.getId());
                preparedStatement.executeUpdate();
                this.setId(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


