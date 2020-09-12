<%-- 
    Document   : index
    Created on : Sep 11, 2020, 9:46:46 PM
    Author     : gajen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login -Contact Application</title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
    </head>
    
    <s:url var="url_bg" value="/static/images/bg2.jpg"/>
    <body background="${url_bg}">
        <table border="1" width="80%" align="center">
            
            <tr>
                <td height="80px">
                    
                  <!--Header-->
                  <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            
              <tr>
                <td height="25px">
                    
                  <!--Menu-->
                  <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            
              <tr>
                <td height="350px" valign="top">
                    
                  <!--Body-->
                  <h1>User Login</h1>
                  Todo : html form
                </td>
            </tr>
            
              <tr>
                <td height="25px">
                    
                  <!--Footer-->
                  <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
            
        </table>
    </body>
</html>
