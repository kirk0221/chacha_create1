<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setAttribute("contentPage", "storeSettlementContent.jsp");
    RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");
    rd.forward(request, response);
%>
