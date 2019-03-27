<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/23 0023
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米手机列表</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css">
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
                            "<td><img src='"+path+row.img+"' width='40px' height='40px'></td>" +
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
<!-- start header -->
<%@include file="WEB-INF/view/header2.jsp"%>
<!--end header -->

<!-- start banner_x -->
<hr>

<div style="text-align:center; font-size: 20px">
    <input type="hidden" id="prev">
    <input type="hidden" id="next">
    <input type="hidden" id="end">
    <%--<input type="hidden" id="total">--%>
    <div style="">
        <input type="text" id="keyword" ><input type="button" value="搜索" onclick="loadFirst()" ><br>
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
    </div>

    <table class="" >
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
</div>






<!-- end danpin -->


</body>
</html>