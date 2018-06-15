package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        List<Ad> adsList = DaoFactory.getAdsDao().all();
       List<User> users = new ArrayList<>();
        for (Ad ad : adsList) {
         long  id = ad.getUserId();
            System.out.println(id);
            users.add(DaoFactory.getUsersDao().findByUserId(id));
            System.out.println(users);

        }

        request.setAttribute("user", users);

        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

}
