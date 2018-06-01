import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name="NameServlet", urlPatterns = "/name")
public class NameServlet extends HttpServlet {
    // Handles GET requests to /name
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // call the .jsp to show the name form
        request.getRequestDispatcher("/name.jsp").forward(request, response);
    }


    // handles POST submission to /name
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the name value from the form and save it to a variable.
        String name = request.getParameter("name");

        // capitalize the name
        name = StringUtils.capitalize(name);

        if("".equals(name)) {
            name = "Bob";
        }

        // set the name attribute to the request
        request.setAttribute("name", name);

        // forward the user to another page, sending that name variable.
        request.getRequestDispatcher("/name.jsp").forward(request, response);
    }

}
