<%-- 
    Document   : Left
    Created on : Sep 28, 2023, 12:08:09 PM
    Author     : KHOACNTT
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card mb-3">
    <h3 class="card-header">Category</h3>  
    <ul class="list-group list-group-flush">
        <c:forEach var="x" items="${dsChuDe}">
            <li class="list-group-item"> <a href="san-pham?macd=${x.macd}" class="text-decoration-none">
                    <i class="bi bi-arrow-right-circle"></i> ${x.tencd} </a> 
            </li>
        </c:forEach>

    </ul>   
</div>
