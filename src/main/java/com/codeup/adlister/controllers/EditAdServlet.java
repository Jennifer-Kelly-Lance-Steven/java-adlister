
package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.MySQLAdsDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/edit")
public class EditAdServlet extends HttpServlet{
    protected void doPost(HttpServletResponse response, HttpServletRequest request){
        String adID = request.getParameter("edit");
    }
}
