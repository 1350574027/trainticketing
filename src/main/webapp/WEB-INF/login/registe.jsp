
<%@ page import="java.sql.*" language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html >
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>

    <link type="text/css" rel="stylesheet" href="/css/style.css">

    <script src="/js/jquery-1.10.2.js"></script>
    <script src="/js/img_ver.js"></script>

    <style>
        .bxs-row {
            margin-bottom:12px;
        }
        .logo-box {
            width:404px;
            margin:120px auto;
            border:1px solid #e5e5e5;
            border-radius:4px;
            box-shadow:0 4px 18px rgba(0,0,0,0.2);
            position:relative;
            overflow:hidden;
            height:340px;
        }
        .login {
            position:absolute;
            width:320px;left:0;
            top:0;
            padding: 42px 42px 36px;
            transition:all 0.8s;
        }
        .username,.password,.btn {
            height: 44px;
            width: 100%;
            padding: 0 10px;
            border: 1px solid #9da3a6;
            background: #fff;
            text-overflow: ellipsis;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            -khtml-border-radius: 4px;
            border-radius: 4px;
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
            color: #000;
            font-size: 1em;
            font-family: Helvetica,Arial,sans-serif;
            font-weight: 400;
            direction: ltr;
            font-size:13px;
        }
        .submit {
            background-color: #0070ba;
            color:#fff;
            border:1px solid #0070ba;
        }
        .submit:hover {
            background-color:#005ea6;
        }
        .verBox {
            position:absolute;
            width:100%;
            text-align:center;
            left:404px;
            top:0;
            opacity:0;
            transition:all 0.8s;
            padding-top:55px;
        }
        .err {
            margin:12px 0 0;
            line-height:12px;
            height:12px;
            font-size:12px;
            color:red;
        }
    </style>

</head>
<body>

<div class="logo-box">
    <div class="login" style="">
        <div class="bxs-row" style="text-align:center;">
            <img id="logo" src="/images/zhuce.jpg" style="width:72px;"><span class="tips" style="color:red;">注册之后忘记可是找不回来的</span>
        </div>

            <div class="bxs-row">
                <input type="text" class="username" placeholder="用户名" id="loginName">
            </div>
            <div class="bxs-row">
                <input type="password" class="password" placeholder="密码" id="loginPassword">
            </div>
            <div class="bxs-row">
                <input type="submit" class="submit btn" onclick="zhuce()"  value="注册">
            </div>
        </form>
    </div>

    <div class="verBox">
        <div id="imgVer" style="display:inline-block;"></div>
    </div>
</div>

    <script type="text/javascript">
        success: function zhuce() {
            var loginName = document.getElementById("loginName").value;
            var loginPassword = document.getElementById("loginPassword").value;
            $.ajax({
                type: "post",
                url: "/login/registeinfo.do",
                data: JSON.stringify({
                    loginName: loginName,
                    loginPassword: loginPassword,
                }),
                contentType: "application/json;charset=UTF-8",
                dataType: "json",
                success: function (data) {
                    if (data != null) {
                        if (data.code == 1) {
                            window.location.href = "/index/index.do";
                        } else {
                            $(".tips").html('这个账号被人抢先一步，在换一个咯！~');
                            $("#logo").attr("src", '/images/zhuceerr.jpg')
                        }
                    }
                },
                error: function () {
                }
            })
        }
    </script>
    </body>
</html>