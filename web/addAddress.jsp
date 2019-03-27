
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/view/common.jsp"%>
<html>
<head>
    <link href="${path}/two/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/optstyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${path}/two/js/jquery.js"></script>
    <title>添加地址</title>
    <script type="text/javascript">
        $(function(){

        });

        function www(){

            var shengid=$("#shengid").val();
            var shiid=$("#shiid").val();
            var quid=$("#quid").val();
            var detail=$("#detail").val();
            var shou=$("#shou").val();
            var phone=$("#phone").val();
            $.ajax({
                url:"${path}/process/area?action=add",
                data:{shengid:shengid,shiid:shiid,quid:quid,detail:detail,shou:shou,phone:phone},
                type:"post",
                dataType:"json",
                success:function(result){
                    alert(result.info);
                }
            })
        }

    </script>
</head>
<body>
<%@include file="WEB-INF/view/header1.jsp"%>
<fieldset>
    <legend>添加收货地址</legend>
    <br>
    省：
    <input type="text" id="shengid">
    <br>
    市：
    <input type="text" id="shiid">
    <br>
    区：
    <input type="text" id="quid">
    <br>
    详细地址:
    <input type="text" id="detail">
    <br>
    收货人:
    <input type="text" id="shou">
    <br>
    手机号:
    <input type="text" id="phone">
    <br>

</fieldset>
</form>
<input type="button" value="添加地址" onclick="www()">
<span id="info"></span>
</body>
</html>
