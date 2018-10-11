package pl.coderslab.controller;

import pl.coderslab.DAO.CarDAO;
import pl.coderslab.models.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "CarEdit", urlPatterns = "/caredit")
public class CarEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String year = request.getParameter("year");
        String plate = request.getParameter("plate");
        String next_check = request.getParameter("next_check");
        String customer_id = request.getParameter("customer_id");


        CarDAO car1 = new CarDAO();
        car1.setId(Integer.parseInt(id));
        car1.setModel(model);
        car1.setBrand(brand);
        car1.setYear(Integer.parseInt(year));
        car1.setPlate(plate);
        car1.setNext_check(Date.valueOf(next_check));
        car1.setCustomer_id(Integer.parseInt(customer_id));

        try {
            car1.CarSaveToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/carviewall").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String car_idParam = request.getParameter("car_id");
        int id = Integer.parseInt(car_idParam);
        try {
            Car car1 = CarDAO.loadCarById(id);
            request.setAttribute("carone", car1);
            getServletContext().getRequestDispatcher("/WEB-INF/forms/CarEdit.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
