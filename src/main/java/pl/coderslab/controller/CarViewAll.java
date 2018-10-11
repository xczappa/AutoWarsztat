package pl.coderslab.controller;

import pl.coderslab.DAO.CarDAO;
import pl.coderslab.models.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CarViewAll", urlPatterns = "/carviewall")
public class CarViewAll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Car> carz = CarDAO.loadAllCars();
            request.setAttribute("cars", carz);
            getServletContext().getRequestDispatcher("/WEB-INF/views/CarViewAll.jsp").forward(request, response);
        } catch (SQLException e) {


        }
    }
}
