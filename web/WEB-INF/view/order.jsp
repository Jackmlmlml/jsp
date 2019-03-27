
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <link href="${path}/two/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/optstyle.css" rel="stylesheet" type="text/css" />
    <title>我的订单</title>
    <script type="text/javascript">
        $(function () {


        })

        function pay(orderid){
            $.ajax({
                url:path+"/process/order?action=update",
                data:{orderid:orderid,status:2},
                type:"post",
                dataType:"json",
                success:function(result){
                    alert(result.info);
                    window.location.href=path+"/process/order?action=query";
                }
            })
        }

        function shouhuo(orderid){
            $.ajax({
                url:path+"/process/order?action=update",
                data:{orderid:orderid,status:3},
                type:"post",
                dataType:"json",
                success:function(result){
                    alert(result.info);
                    window.location.href=path+"/process/order?action=query";
                }
            })
        }

        function cancel(orderid){
            $.ajax({
                url:path+"/process/order?action=update",
                data:{orderid:orderid,status:4},
                type:"post",
                dataType:"json",
                success:function(result){
                    alert(result.info);
                    window.location.href=path+"/process/order?action=query";
                }
            })

        }
    </script>
</head>
<body>
<%@include file="header1.jsp"%>
<fieldset>
    <legend>我的订单</legend>
    <table border="1">
        <thead>
        <tr>
            <td>订单编号</td>
            <td>详情</td>
            <td>订单日期</td>
            <td>订单金额</td>
            <td>订单状态</td>
            <td>操作</td>
            <td>取消订单</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.code}</td>
                <td><a href="${path}/orderDetail.jsp">查看详情</a></td>
                <td>${order.createDate}</td>
                <td>${order.total}</td>
                <td>
                    <c:if test="${order.status=='1'}">
                        待付款
                    </c:if>
                    <c:if test="${order.status=='2'}">
                        待收货
                    </c:if>
                    <c:if test="${order.status=='3'}">
                        完成
                    </c:if>
                    <c:if test="${order.status=='4'}">
                        已取消
                    </c:if>
                </td>
                <td>
                    <c:if test="${order.status=='1'}">
                        <a href="javascript:vood(0)" onclick="pay('${order.id}')">去付款</a>
                    </c:if>
                    <c:if test="${order.status=='2'}">
                        <a href="javascript:vood(0)" onclick="shouhuo('${order.id}')">确认收货</a>
                    </c:if>
                    <c:if test="${order.status=='3'}">

                    </c:if>
                    <c:if test="${order.status=='4'}">

                    </c:if>
                </td>
                <td>
                    <c:if test="${order.status=='1' or order.status=='2' }">
                        <a href="javascript:vood(0)" onclick="cancel('${order.id}')">取消订单</a>
                    </c:if>

                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</fieldset>
</body>
</html>
