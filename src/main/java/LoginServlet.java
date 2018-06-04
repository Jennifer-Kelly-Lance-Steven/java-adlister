import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    // handles the GET request to /login and loads the page w/ the login form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // render the .jsp and send the user that view
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String message;

        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile");

        } else {
            message = "Username or password is incorrect. Please try again.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
