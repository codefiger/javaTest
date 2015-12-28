<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@ page language="java" contentType="text/HTML;charset=UTF-8"%>
<%
    String lastIp = request.getRemoteAddr();
    String userAgent = request.getHeader("User-Agent");
    Logger logger = LoggerFactory.getLogger("index.jsp");
    logger.debug("user-agent:{},lastIp:{}", userAgent, lastIp);
%>
<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
