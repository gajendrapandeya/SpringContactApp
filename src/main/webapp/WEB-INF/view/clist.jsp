<%-- 
    Document   : index
    Created on : Sep 11, 2020, 9:46:46 PM
    Author     : gajen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List -Contact Application</title>
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
                  <h3>Contact List</h3>
                  <c:if test="${param.act eq 'sv'}">
                      
                      <p class="success"> Contact Saved Successfully</p>
                  </c:if>
                      
                  <c:if test="${param.act eq 'del'}">
                      
                     <p class="success"> Contact Saved Successfully</p>
                  </c:if>
                  <table border="1" cellPadding="9">
                      
                      <tr>
                          <th>SR</th>
                          <th>CID</th>
                          <th>NAME</th>
                          <th>PHONE</th>
                          <th>EMAIL</th>
                          <th>ADDRESS</th>
                          <th>REMARK</th>
                          <th>ACTION</th>
                          
                          
                      </tr>
                      
                      <c:if test="${empty contactList}">
                          <tr>
                              <td align="center" colspan="8" class="error"> No records present</td>
                          </tr>
                      </c:if>
                      
                      <c:forEach var="c" items="${contactList}" varStatus="st">
                           <tr>
                          <td>${st.count}</td>
                          <td>${c.contactId}</td>
                          <td>${c.name}</td>
                          <td>${c.phone}</td>
                          <td>${c.email}</td>
                          <td>${c.address}</td>
                          <td>${c.remark}</td>
                          <s:url var="url_del" value="/user/del_contact">
                              <s:param name="cid" value="${c.contactId}"/>
                          </s:url>
                          <td>EDIT | <a href="${url_del}"> DELETE </a> </td>
                          
                          
                      </tr>
                      </c:forEach>
                      
                  </table>
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
