package pl.coderslab.DAO;

import pl.coderslab.models.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CarDao", urlPatterns = "/cardao")
public class CarDao extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        CarDAO car1 = new CarDAO();
//        car1.setBrand("Alfa ROMEO");
//        car1.setModel("Julietta");
//        car1.setYear(2010);
//        car1.setPlate("PO dasd");
//        car1.setNext_check(Date.valueOf("2018-09-30"));
//        car1.setCustomer_id(2);
//
//        try {
//            car1.CarSaveToDB();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        try {
//            Car car2 = CarDAO.loadCarById(4);
//            response.getWriter().append(car2.toString());
//        } catch (SQLException e) {

        try {
            ArrayList<Car> car3 = CarDAO.loadAllCars();
            response.getWriter().append(car3.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





    }

