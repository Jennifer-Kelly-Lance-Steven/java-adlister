package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/ads/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }
        String searchTerm = request.getParameter("search");
        request.setAttribute("searchAds", DaoFactory.getSearchDao().findBySearch(searchTerm));
        request.getRequestDispatcher("/WEB-INF/ads/searchAd.jsp").forward(request, response);
    }
}


