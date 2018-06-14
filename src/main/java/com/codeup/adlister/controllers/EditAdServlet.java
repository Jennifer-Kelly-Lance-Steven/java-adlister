package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.MySQLAdsDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getParameter("id");

        try {
            response.sendRedirect("/edit.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
