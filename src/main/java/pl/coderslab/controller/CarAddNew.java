package pl.coderslab.controller;

import pl.coderslab.DAO.CarDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "CarAddNew", urlPatterns = "/caraddnew")
public class CarAddNew extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String year = request.getParameter("year");
        String plate = request.getParameter("plate");
        String next_check = request.getParameter("next_check");
        String customer_id = request.getParameter("customer_id");


        CarDAO car1 = new CarDAO();
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


    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

            getServletContext().getRequestDispatcher("/WEB-INF/forms/CarAddNew.jsp").forward(request, response);
        }
    }

