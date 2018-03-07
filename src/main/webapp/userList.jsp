<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/1/001
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css"/>
    <script src="/js/layui-v2.2.5/layui/layui.js"></script>
<%--
    <script src="/js/layui-v2.2.5/layui/lay/modules/layer.js" ></script>
--%>
    <script src="/js/jquery-3.2.1/jquery-3.2.1.js" ></script>
</head>

<body>

<table id="demo" lay-filter="test"></table>
<script type="text/html" id="barDemo">
    <%--    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>

<script type="text/html" id="barDemo2">
    <%--    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-warm" id="addUser" >新增</a>
    <a class="layui-btn layui-btn-danger" lay-event="delAll">批量删除</a>
</script>


    <script>

    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 468
            ,height: 468
            ,url: "../user/selectUserList.do" //数据接口
            ,toolbar:"#barDemo2"
            ,page: true //开启分页
            ,cols: [[ //表头
                {checkbox: "userListBox", fixed: true}
                ,{field: 'id', title: 'ID', width:60, sort: true, fixed: 'left'}
               ,{field: 'name', title: '用户名', width:90}
                ,{field: 'loginnumber', title: '手机号', width:120}
                ,{field: 'password', title: '密码', width:90}
                ,{field: 'sex', title: '性别', width:80, sort: true}
                ,{field: 'createtime', title: '创建时间', width:160}
                ,{field: 'details', title: '简介', width: 170}
                ,{field: 'heading', title: '头像', width: 100, sort: true}
                ,{field:'right',width:160, title: '操作', toolbar:"#barDemo"}

            ]]
        });



 /*   //监听表格复选框选择
    table.on('checkbox(test)', function(obj){
        console.log(obj)
    });*/
    //监听工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"

        var data = obj.data; //获得当前行数据

        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        /* if(layEvent === 'detail'){ //查看
             //do somehing
         } else */
        if(layEvent === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
              /*  obj.del(); //删除对应行（tr）的DOM结构，并更新缓存*/
                /*  layer.close(index);*/
                //向服务端发送删除指令
                $.ajax({
                    url: "../user/DelectUser.do",
                    type: "POST",
                    data:{"id":data.id},
                    /*dataType: "json",*/
                    success: function(){
                            obj.del();
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});



                    },
                    error:function(){
                        layer.msg("删除失败", {icon: 5});
                        alert(6);
                    }


            });


            });
        }
            /*else if(layEvent === 'edit'){ //编辑
                //do something

                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    ,title: 'xxx'
                });
            }*/
    });

        $("#addUser").on('click', function(){

            layer.open({
                type:2
                ,area:['700PX', '300PX']
                ,title:"添加用户"
                ,content: '/addUser.jsp'
               /* type: 1,
                content:createFrame(addUser.jsp) //这里content是一个普通的String*/
            });
         /*   var type = $(this).data('type');
          active[type] ?demoTable active[type].call(this) : '';*/
        });

    });

  /*  alert(1);
    layer.open({
        type: 1,
        content: '传入任意的文本或html' //这里content是一个普通的String
    });
*/
 /* function addUser() {
      alert(1);
      layui.alert("qweq");
  }*/


    $(document).on("click", ".addUser", function() {
        alert(8888);
        layer.open({
            type:2
            ,area:['700PX', '300PX']
            ,title:"添加类别"
            ,content: '<%=request.getContextPath()%>/adduser.jsp'
        });
    });

    function createFrame(url){
        return '<iframe border="0" scrolling="no" frameborder="0"  src="/'+ url + '" style="width:99.9%;height:99.5%;"></iframe>';
    }


</script>


</body>
<%--<body>

<table class="layui-table" lay-data="{height:315, url:'/user/selectUserList.do', page:true, id:'test',height: 'full-25'}" lay-filter="test" id="test">
    <thead>
    <tr>
        <th lay-data="{field:'id', width:80, sort: true}">ID</th>
        <th lay-data="{field:'name', width:80}">用户名</th>
        <th lay-data="{field:'loginnumber', width:80, sort: true}">性别</th>
        <th lay-data="{field:'password', width:80}">城市</th>
        <th lay-data="{field:'sex', width:177}">签名</th>
        <th lay-data="{field:'createtime', width:80, sort: true}">积分</th>
        <th lay-data="{field:'details', width:80, sort: true}">评分</th>
        <th lay-data="{field:'heading', width:80}">职业</th>

    </tr>
    </thead>
</table>


<script>
    layui.use('table', function() {
        var table = layui.table;
    });
</script>
</body>--%>
<%--<script>
    var page = 1;
    var pageSize = 2;
    $(function () {
        selectUserList(page,pageSize);
    })

    function selectUserList(page,pageSize){

        $.ajax({
            url:"/user/selectUserList.do",
            dataType:"json",
            data:{"page":page, "pageSize":pageSize},
            type:"post",
            async:true,
            success:function(data){
                var list = "";
                var pageAlwaysSize = data.pageAlwaysSize;
                data = data.list;
                for (var i = 0;i<data.length;i++){
                    list += "<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].loginnumber+"</td><td>"+data[i].password+"</td><td>"+data[i].sex+"</td>" +
                        "<td>"+data[i].createtime+"</td><td>"+data[i].details+"</td><td>"+data[i].heading+"</td></tr>"

                }
                $("#qwe301").html(list);

                $("#pageFont").html(page);
                $("#pageAlways").html(pageAlwaysSize);



            },
            error:function(){
                alert(005);
            },
        })
    }

    /**
     * 上一页
     */
    function upPage() {

      /*  layer.open({
            title: '提示'
            ,content: '可以填写任意的layer代码'
        });*/
    }



</script>--%>
</html>
