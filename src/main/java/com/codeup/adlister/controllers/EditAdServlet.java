package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String oldTitle = request.getParameter("oldTitle");
            String oldDescription = request.getParameter("oldDescription");
            request.setAttribute("id", id);
            request.setAttribute("oldTitle", oldTitle);
            request.setAttribute("oldDescription", oldDescription);
            request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        request.setAttribute("id", id);
        request.setAttribute("title", title);
        request.setAttribute("description", description);
        DaoFactory.getAdsDao().updateAd(title, description, id);
        try {
            response.sendRedirect("/profile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
