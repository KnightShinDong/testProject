<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.jsp.JspWriter" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <form action="/loginOk.jsp" method="post">
    아이디: <input type="text" name="id" value="<%if(session.getAttribute("id") != null)out.println(session.getAttribute("id"));%>"><br />
    비밀번호: <input type="password" name="pw" size="10">
    <input type="submit" value="로그인">&nbsp;&nbsp;
    <input type="button" value="회원가입" onclick="memberJoin();">
  </form>
</body>
</html>

<script type="text/javascript">
    function memberJoin() {
       window.location = "/memberJoin.jsp";
    }
</script>