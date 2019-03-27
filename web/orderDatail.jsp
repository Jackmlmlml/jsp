<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/23 0023
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/view/common.jsp"%>
<html>
<head>
    <link href="${path}/two/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/optstyle.css" rel="stylesheet" type="text/css" />
    <title>Title</title>
    <script type="text/javascript">
        $(function(){
        })
    </script>
</head>
<body>
<%@include file="WEB-INF/view/header1.jsp"%>
<hr>
<fieldset>
    <legend>订单详情</legend><br>
    <input type="hidden" id="goodid" value="${orderdetail.id}">
    订单编号：${orderdetail.name}<br>
    商品编号：${orderdetail.price}<br>
    价格：${orderdetail.detail}<br>
    购买数量：${orderdetail.count}<br>
    <input type="button" value="返回上一级" onclick="Back()" >
</fieldset>
</table>
</body>
</html>
