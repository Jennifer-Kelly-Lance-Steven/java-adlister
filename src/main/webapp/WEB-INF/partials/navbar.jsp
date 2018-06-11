<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/ads">Adlister</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <c:if test="${sessionScope.user != null}">
                <li class="nav-item"><a class="nav-link" href="/profile">Profile</a></li>
                <li class="nav-item"><a class="nav-link" href="/ads">View All Ads</a></li>
                <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
                <li class="nav-item"><a class="nav-link" href="/ads">View All Ads</a></li>
                <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
            </c:if>
        </ul>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


<%--<nav class="navbar navbar-default">--%>
    <%--<div class="container-fluid">--%>
        <%--<!-- Brand and toggle get grouped for better mobile display -->--%>
        <%--&lt;%&ndash;<div class="navbar-header">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="navbar-brand" href="/ads">Adlister</a>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--<ul class="nav navbar-nav navbar-right">--%>



            <%--<c:if test="${sessionScope.user != null}">--%>
                <%--<li class="nav-item active"><a href="/profile">Profile</a></li>--%>
                <%--<li class="nav-item active"><a href="/ads">View All Ads</a></li>--%>
                <%--<li class="nav-item active"><a href="/logout">Logout</a></li>--%>
            <%--</c:if>--%>
            <%--<c:if test="${sessionScope.user == null}">--%>
                <%--<li class="nav-item active"><a href="/ads">View All Ads</a></li>--%>
                <%--<li class="nav-item active"><a href="/login">Login</a></li>--%>
            <%--</c:if>--%>
        <%--</ul>--%>
    <%--</div><!-- /.navbar-collapse -->--%>
    <%--</div><!-- /.container-fluid -->--%>
<%--</nav>--%>
