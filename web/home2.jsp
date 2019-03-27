
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/view/common.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
    <link href="two/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="two/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
    <link href="two/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="two/css/hmstyle.css" rel="stylesheet" type="text/css" />
    <script src="two/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="two/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

    <title>Title</title>
    <script type="text/javascript">
        $(function(){
            loadGoodData(1,10,"");
        })

        function loadGoodData(page,pageSize,keyword){
            $.ajax({
                url:"${path}/good?action=query",
                data:{page:page,pageSize:pageSize,keyword:keyword},
                type:"post",
                dataType:"json",
                success:function(result){
                    console.log(result);
                    var data=result.data;
                    $("#prev").val(result.prev);
                    $("#next").val(result.next);
                    $("#end").val(result.end);
                    //$("#total").val(result.total);
                    $("#endPage").text(result.end);
                    $("#totalCount").text(result.total);
                    $("#goodData").html("");
                    for(var i=0; i<data.length;i++){
                        var row=data[i];
                        $("#goodData").append("<tr>" +
                            "<td><a href='"+path+"/good?action=detail&goodid="+row.id+"'>"+row.name+"</a></td>" +
                            "<td>"+row.price+"</td>" +
                            "<td><img style='width: 40px; height: 40px;'  src='"+path+row.img+"'  ></td>"+
                            "<td>"+row.detail+"</td>" +
                            "<td>"+row.kucun+"</td>" +
                            "</tr>");
                    }
                }
            })
        }

        function loadFirst(){
            var keyword=$("#keyword").val();
            var pageSize=$("#pageSize").val();
            loadGoodData(1,pageSize,keyword);
        }

        function loadPrev(){
            var prev=$("#prev").val();
            var keyword=$("#keyword").val();
            var pageSize=$("#pageSize").val();
            loadGoodData(prev,pageSize,keyword);
        }

        function loadNext(){
            var next=$("#next").val();
            var keyword=$("#keyword").val();
            var pageSize=$("#pageSize").val();
            loadGoodData(next,pageSize,keyword);
        }
        function loadEnd(){
            var end=$("#end").val();
            var keyword=$("#keyword").val();
            var pageSize=$("#pageSize").val();
            loadGoodData(end,pageSize,keyword);
        }

    </script>
</head>

<body>
    <!--顶部导航条 -->
    <%@include file="WEB-INF/view/header1.jsp"%>
    <!--悬浮搜索框-->
    <div class="nav white">
        <div class="logo"><img src="${path}/two/images/logo.png"/></div>
        <div class="logoBig">
            <li><img src="${path}/two/images/logobig.png" /></li>
        </div>
        <div class="search-bar pr">
            <a name="index_none_header_sysc" href="#"></a>
            <form>
                <input id="keyword" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
                <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="button" onclick="loadFirst()">
            </form>
        </div>
    </div>



<script>
    window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
</script>
<script type="text/javascript " src="two/basic/js/quick_links.js "></script>
<hr>
<input type="hidden" id="prev">
<input type="hidden" id="next">
<input type="hidden" id="end">
<%--<input type="hidden" id="total">--%>
<%--
<input type="text" id="keyword" ><input type="button" value="搜索" onclick="loadFirst()" ><br>
--%>
<a href="javascript:void(0)" onclick="loadFirst()">首页</a>
<a href="javascript:void(0)" onclick="loadPrev()">上一页</a>
<a href="javascript:void(0)" onclick="loadNext()">下一页</a>
<a href="javascript:void(0)" onclick="loadEnd()">尾页</a>
共<span id="endPage"></span>页/共<span id="totalCount"></span>条&nbsp;&nbsp;&nbsp;
每页条数：
<select id="pageSize" onchange="loadFirst()">
    <option value="5">5</option>
    <option value="10" selected="selected">10</option>
    <option value="20">20</option>
    <option value="30">30</option>
</select>
<table class="orderList">
    <thead>
    <tr>
    <td>名称</td>
    <td>价格</td>
    <td>图片</td>
    <td>详情</td>
    <td>库存</td>
    </tr>



    </thead>
    <tbody id="goodData">

    </tbody>
</table>
</body>

</html>