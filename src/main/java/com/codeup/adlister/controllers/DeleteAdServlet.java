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


@WebServlet(name = "controllers.DeleteAdServlet", urlPatterns = "/delete")
public class DeleteAdServlet extends HttpServlet{
    protected void doPost(HttpServletResponse response, HttpServletRequest request){
        String adID = request.getParameter("delete");
        System.out.println(adID);
        MySQLAdsDao.deleteAd(Integer.parseInt(adID));
        try {
            response.sendRedirect("/profile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
