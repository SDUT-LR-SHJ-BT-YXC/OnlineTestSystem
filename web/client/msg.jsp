<%--
  Created by IntelliJ IDEA.
  User: shangjin
  Date: 2019-12-08
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 本页面输出request域中的msg信息， 3秒后跳转到login.jsp -->
<html>
<head>
    <title>提示页面</title>
</head>
<body>
<h3>${requestScope.msg}</h3>
    <script>
        setTimeout(function () {
            window.location.href = "${pageContext.request.contextPath}/client/login.jsp";
        }, 3000)
    </script>
</body>
</html>
