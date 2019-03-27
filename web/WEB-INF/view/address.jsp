
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <title>我的地址</title>
    <script type="text/javascript"></script>
    <link href="${path}/two/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/optstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header1.jsp"%>
<a href="${path}/addAddress.jsp"> <input type="button" value="添加新的地址"></a>
<fieldset>
    <legend>我的地址</legend>
    <table border="1">
        <thead>
        <tr>
            <td>省</td>
            <td>市</td>
            <td>区</td>
            <td>详细地址</td>
            <td>收货人</td>
            <td>收货人手机号</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.address}" var="address">
            <tr>
                <td>${address.shengid}</td>
                <td>${address.shiid}</td>
                <td>${address.quid}</td>
                <td>${address.detail}</td>
                <td>${address.shou}</td>
                <td>${address.phone}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</fieldset>
</body>
</html>
