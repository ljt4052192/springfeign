<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/2/002
  Time: 12:03
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
<form class="layui-form" action="" id="addstaffForm">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="name" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="loginnumber" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>

    </div>
    <div class="layui-form-item">
    <label class="layui-form-label">分组</label>
    <div class="layui-input-block">
        <select <%--name="city"--%> lay-verify="required">
            <option value=""></option>
            <option value="0">一组</option>
            <option value="1">二组</option>
            <option value="2">三组</option>
            <option value="3">四组</option>
            <option value="4">五组</option>
        </select>
    </div>
</div>
    <div class="layui-form-item">
        <label class="layui-form-label">复选框</label>
        <div class="layui-input-block">
            <input type="checkbox" <%--name="like[write]"--%> title="写作">
            <input type="checkbox" <%--name="like[read]"--%> title="阅读" checked>
            <input type="checkbox" <%--name="like[dai]"--%> title="发呆">
        </div>
    </div>
    <%--<div class="layui-form-item">
        <label class="layui-form-label">开关</label>
        <div class="layui-input-block">
            <input type="checkbox" name="switch" lay-skin="switch">
        </div>
    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="1" title="男">
            <input type="radio" name="sex" value="2" title="女" checked>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">时间</label>
        <div class="layui-inline"> <!-- 注意：这一层元素并不是必须的 -->
            <%--<input type="text" name="createTime" class="layui-input" id="test1">--%>
            <input type="text" name="create2wtime" id="createtimeid" lay-verify="date" placeholder="请输入日期" autocomplete="off" class="layui-input">
    </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">图片</label>
        <input type="hidden" name="headimg" id="image">
        <button type="button" class="layui-btn" id="test2">
            <i class="layui-icon">&#xe67c;</i>上传图片
        </button>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文本域</label>
        <div class="layui-input-block">
            <textarea name="details" id="demo2" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" id="formSubmitUser">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>



    /*layui.use('form', function(){
        var form = layui.form;
        /!* alert(form);*!/
        alert(1);
        //各种基于事件的操作，下面会有进一步介绍
        $.ajax({
            url:"../user/addUser.do",
            type:"post",
            data:form,
            datatype:"json",
            success:function(data){

                if(data.static==1){
                    layui.alert("新增成功");
                    layer.close(index);
                   /!* $('#updatded').dialog("close");
                    $("#userdg").datagrid("reload");*!/

                }else{
                    $.messager.alert('提示','修改失败!!!','info')


                }
            },
            error:function(){
                alert("程序错误");
            }
        })
    });*/

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#createtimeid' //指定元素
        });
    });

    layui.use('layedit', function(){
        var layedit = layui.layedit;
        layedit.build('demo2'); //建立编辑器
    });

    //上传图片
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test2' //绑定元素
            ,url: 'queryuploadPhoto.do' //上传接口
            ,done: function(res){
                //上传完毕回调
                $ = layui.jquery;
                $("#image").val(res.path);
                alert($("#image").val());
            }
            ,error: function(res){

            }
        });
    })


    $("#formSubmitUser").on('click', function(){

        $.ajax({
            url:"../user/addUser.do",
            type:"post",
            data:$("#addstaffForm").serialize(),
            dataType: "json",
            error:function(asd){
                alert(345);
            },
            success:function(data){
                alert(123);
                /*if(data.static==1){
                   ayui.alert("新增成功");
                    layer.close(index);
                   /!*  $('#updatded').dialog("close");
                    $("#userdg").datagrid("reload");*!/

                }else{

                    /!*$.messager.alert('提示','修改失败!!!','info')*!/


                }*/
            }

        })
    })




</script>

</body>
</html>
