package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.models.Ad;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/ads/delete")
public class DeleteAdServlet extends HttpServlet{
    protected void doPost(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("id", MySQLAdsDao.deleteAd(id));
        response.sendRedirect("/profile");
    }

}
