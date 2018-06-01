# Using JSPs and Servlets Together

We can use JSPs and servlets together in order to enable us to separate the
logic that our application does from the presentation. To do this, we'll use two
key methods on the `request` object inside of a servlet's `doGet` or `doPost`
method.

- `setAttribute`: to make data available in the view
- `getRequestDispatcher`: to specify the jsp file to pass the information to

Let's take a look at a simple example:

```java
@WebServlet(name = "MyServlet", urlPatterns = "/adams")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("theAnswer", 42);
        request.getRequestDispatcher("/my-jsp-file.jsp").forward(request, response);
    }
}
```

```jsp
<%-- inside of my-jsp-file.jsp  --%>
<h1>The answer to life, the universe, and everything is ${theAnswer}.</h1>
```

First we use the `setAttribute` method to define a variable that will be
available in our JSP. In the above example, we create a variable in the jsp
named `theAnswer`, and set it's value to `42`. In a bigger application, the
second argument to `setAttribute` could come from another method call, or any
result of our own Java code.

Next we use the `getRequestDispatcher` method to pass the current request over
to the jsp file. We specify the location of the jsp file we want relative to the
`webapp` directory.
