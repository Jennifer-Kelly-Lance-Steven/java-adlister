# Using JSPs and Servlets Together

We can use JSPs and servlets together in order to enable us to separate the
logic that our application does from the presentation. To do this, we'll use two
key methods on the `request` object inside of a servlet's `doGet` or `doPost`
method.

- `setAttribute`: to make data available in the view
- `getRequestDispatcher`: to specify the jsp file to pass the information to

Let's take a look at a simple example:

```java
@WebServlet(name = "ExampleServlet", urlPatterns = "/adams")
public class ExampleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("theAnswer", 42);
        request.getRequestDispatcher("/my-jsp-file.jsp").forward(request, response);
    }
}
```

```jsp
<%-- inside of src/main/webapp/my-jsp-file.jsp  --%>
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

Now, inside of the jsp file, we can reference the the variable named
`theAnswer`, because we used the `setAttribute` method earlier to define it.

## Exercises

For this exercise, each of the problems will contain a description of what the
end user experience will be like, but it is up to you do determine how to make
this happen.

Create a branch named `jsp-drills` off of the `jsp-and-jstl-solution` tag and
do the following:

- Name Page

    A user goes to the url "/name" and is given a "name" page. On the "name"
    page, the user sees a form prompting them to enter their first name. After
    submitting their name, the user is redirected to a page that says in an h1:
    "Well, howdy, TheUserNameGoesHere!". The user's name is capitalized if it is
    not already.

    Hints:

    - Use one servlet and two JSPs.
    - The form should send a `POST` request
    - You'll need both a `doGet` and `doPost` method
    - Don't worry about styling.

- Color Page

    A user goes to a url "/pickcolor". On the "pickcolor" page, the user is
    prompted to enter their favorite color. Upon clicking submit, they are
    redirected to a page with background color of their favorite color.

    Hints

    - One servlet and two JSPs.
    - The form should send a `POST` request
    - You'll need both a `doGet` and `doPost` method
    - Use style tags

- Calculator

    A user goes to "/addition" and enters two numbers into two separate input
    fields. After clicking submit, the user sees the result of adding those two
    numbers together.

    A user goes to "/multiplication" and enters two numbers into two separate
    input fields. After clicking submit, the user sees the result of multiplying
    those two numbers together.

- Bonus: Guessing Game

    A user goes to a url "/guess" and is prompted to guess a number between 1
    and 100. The user will be taken to another page and if the answer is
    correct, a message will be displayed indicating the win; otherwise a higher
    or lower message will be given with a link to the form to guess again.

    Bonus: create a link that will reset the random computer number to a new number

For all of the above exercises, make sure to do any logic inside of your
servlets, and pass the results of that logic to the jsp and display it there.
