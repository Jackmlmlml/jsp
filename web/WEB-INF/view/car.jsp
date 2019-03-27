<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp" %>
<html>
<head>
    <link href="${path}/two/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="${path}/two/css/optstyle.css" rel="stylesheet" type="text/css" />
    <title>Title</title>
    <script type="text/javascript">
        $(function () {
            $(".add").each(function () {
                $(this).click(function () {
                    var count = parseInt($(this).prev().val());
                    count = count + 1;
                    $(this).prev().val(count);
                    var price = parseFloat($(this).parent().prev().text());
                    var xiaoji = price * count;
                    $(this).parent().next().text(xiaoji);
                    var carid = $(this).parent().parent().find(".carid").val();
                    //alert(carid);
                    $.ajax({
                        url: path + "/process/car?action=update",
                        data: {carid: carid, count: count},
                        type: "post",
                        dataType: "json",
                        success: function (result) {
                            /*alert(result.info);*/
                            calc()
                        }
                    })

                })
            })


            $(".mins").each(function () {
                $(this).click(function () {
                    var count = parseInt($(this).next().val());
                    if (count > 1) {
                        count = count - 1;
                    }

                    $(this).next().val(count);
                    var price = parseFloat($(this).parent().prev().text());
                    var xiaoji = price * count;
                    $(this).parent().next().text(xiaoji);
                    var carid = $(this).parent().parent().find(".carid").val();
                    $.ajax({
                        url: path + "/process/car?action=update",
                        data: {carid: carid, count: count},
                        type: "post",
                        dataType: "json",
                        success: function (result) {
                            calc()
                        }
                    })

                })
            })


            $("#checkall").click(function () {
                var checked = $("#checkall").is(":checked");
                if (checked) {
                    $(".item").each(function () {
                        $(this).prop("checked", true);
                    })
                } else {
                    $(".item").each(function () {
                        $(this).prop("checked", false);
                    })
                }
                calc()
            });

            $(".item").each(function () {
                $(this).click(function () {
                    var total = $(".item").length;
                    var checked = $(".item:checked").length;
                    if (total == checked) {
                        $("#checkall").prop("checked", true);
                    } else {
                        $("#checkall").prop("checked", false);
                    }
                    calc()
                })
            })

        })


        function calc() {
            var total = 0;
            $(".item:checked").each(function () {
                var xiaoji = parseFloat($(this).parent().parent().find(".xiaoji").text());
                total = total + xiaoji;
            })
            $("#total").html(total);
        }

        function del(carid) {
            alert(carid);
            var flag = confirm("确定要将该商品移出购物车吗？");
            if (flag) {
                $.ajax({
                    url: path + "/process/car?action=del",
                    data: {carid: carid},
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        alert(result.info);
                        window.location.href = path + "/process/car?action=query"
                    }
                })
            }

        }

        function jiesuan() {
            var total = $("#total").text();
            var goodids = [];
            var counts = [];
            var prices = [];
            var carids=[];
            $(".item:checked").each(function () {
                goodids.push($(this).parent().parent().find(".goodid").val());
                counts.push($(this).parent().parent().find(".count").val());
                prices.push($(this).parent().parent().find(".price").text());
                carids.push($(this).parent().parent().find(".carid").val());
            })
            console.log(goodids);
            console.log(counts);
            console.log(prices);
            $.ajax({
                url: path + "/process/order?action=add",
                data: {
                    total: total,
                    goodids: goodids,
                    counts: counts,
                    prices: prices,
                    carids:carids
                },
                traditional: true,
                type: "post",
                dataType: "json",
                success: function (result) {
                    alert(result.info)
                }
            })
        }


    </script>
</head>

<body>
<!-- start header -->
<!--end header -->
<%@include file="header1.jsp" %>
<!-- start banner_x -->
<div class="banner_x center">
    <a href="${path}/index.jsp" target="_blank"><div class="logo fl"></div></a>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div style="">

        <hr>

        <fieldset class="orderList">
            <legend>我的购物车</legend>
            <table border="1">
                <thead >
                <tr >
                    <td><input id="checkall" type="checkbox"></td>
                    <td>商品名称</td>
                    <td>商品图片</td>
                    <td>商品价格</td>
                    <td>购买数量</td>
                    <td>小计</td>
                    <td>操作</td>
                </tr>

                </thead>
                <tbody>
                <c:forEach items="${requestScope.cars}" var="car">
                    <tr>
                        <td>
                            <input type="hidden" class="goodid" value="${car.goodid}">
                            <input type="hidden" class="carid" value="${car.carid}">
                            <input class="item" type="checkbox">
                        </td>
                        <td>${car.name}</td>
                        <td><img width="100px" height="100px" src="${path}${car.img}"></td>
                        <td class="price">${car.price}</td>
                        <td>
                            <input type="button" class="mins" value="-">
                            <input type="text" class="count" value="${car.counts}" style="width: 20px">
                            <input type="button" class="add" value="+">
                        </td>
                        <td class="xiaoji">${car.price*car.counts}</td>
                        <td><a href="javascript:void(0)" onclick="del('${car.carid}')">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            <br>
            总计：<span id="total"></span>元<br>
            <input type="button" value="提交订单" onclick="jiesuan()">
        </fieldset>
    </div>
    <%--<ul>--%>
    <%--<li><a href="./login.html" target="_blank">登录</a></li>--%>
    <%--<li>|</li>--%>
    <%--<li><a href="./register.html" target="_blank">注册</a></li>--%>
    <%--</ul>--%>

    <%--</div>--%>
    <%--<div class="clear"></div>--%>
    <%--</div>--%>
    <%--<div class="xiantiao"></div>--%>
    <%--<div class="gwcxqbj">--%>
    <%--<div class="gwcxd center">--%>
    <%--<div class="top2 center">--%>
    <%--<div class="sub_top fl">--%>
    <%--<input type="checkbox" value="quanxuan" class="quanxuan" />全选--%>
    <%--</div>--%>
    <%--<div class="sub_top fl">商品名称</div>--%>
    <%--<div class="sub_top fl">单价</div>--%>
    <%--<div class="sub_top fl">数量</div>--%>
    <%--<div class="sub_top fl">小计</div>--%>
    <%--<div class="sub_top fr">操作</div>--%>
    <%--<div class="clear"></div>--%>
    <%--</div>--%>
    <%--<div class="content2 center">--%>
    <%--<div class="sub_content fl ">--%>
    <%--<input type="checkbox" value="quanxuan" class="quanxuan" />--%>
    <%--</div>--%>
    <%--<div class="sub_content fl"><img src="./image/gwc_xiaomi6.jpg"></div>--%>
    <%--<div class="sub_content fl ft20">小米6全网通6GB内存+64GB 亮黑色</div>--%>
    <%--<div class="sub_content fl ">2499元</div>--%>
    <%--<div class="sub_content fl">--%>
    <%--<input class="shuliang" type="number" value="1" step="1" min="1" >--%>
    <%--</div>--%>
    <%--<div class="sub_content fl">2499元</div>--%>
    <%--<div class="sub_content fl"><a href="">×</a></div>--%>
    <%--<div class="clear"></div>--%>
    <%--</div>--%>
    <%--<div class="content2 center">--%>
    <%--<div class="sub_content fl ">--%>
    <%--<input type="checkbox" value="quanxuan" class="quanxuan" />--%>
    <%--</div>--%>
    <%--<div class="sub_content fl"><img src="./image/gwc_xiaomi6.jpg"></div>--%>
    <%--<div class="sub_content fl ft20">小米6全网通6GB内存+64GB 亮黑色</div>--%>
    <%--<div class="sub_content fl ">2499元</div>--%>
    <%--<div class="sub_content fl">--%>
    <%--<input class="shuliang" type="number" value="1" step="1" min="1" >--%>
    <%--</div>--%>
    <%--<div class="sub_content fl">2499元</div>--%>
    <%--<div class="sub_content fl"><a href="">×</a></div>--%>
    <%--<div class="clear"></div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="jiesuandan mt20 center">--%>
    <%--<div class="tishi fl ml20">--%>
    <%--<ul>--%>
    <%--<li><a href="./liebiao.html">继续购物</a></li>--%>
    <%--<li>|</li>--%>
    <%--<li>共<span>2</span>件商品，已选择<span>1</span>件</li>--%>
    <%--<div class="clear"></div>--%>
    <%--</ul>--%>
    <%--</div>--%>
    <%--<div class="jiesuan fr">--%>
    <%--<div class="jiesuanjiage fl">合计（不含运费）：<span>2499.00元</span></div>--%>
    <%--<div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></div>--%>
    <%--<div class="clear"></div>--%>
    <%--</div>--%>
    <%--<div class="clear"></div>--%>
    <%--</div>--%>

    <%--</div>--%>
</body>


</html>
