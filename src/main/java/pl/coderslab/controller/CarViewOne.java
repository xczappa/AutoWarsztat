package pl.coderslab.controller;

import jdk.nashorn.internal.runtime.regexp.joni.CodeRangeBuffer;
import pl.coderslab.DAO.CarDAO;
import pl.coderslab.models.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CarViewOne", urlPatterns = "/carviewone")
public class CarViewOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);
        try {
            Car car1 = CarDAO.loadCarById(id);
            request.setAttribute("carone", car1);
            getServletContext().getRequestDispatcher("/WEB-INF/views/CarViewOne.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
