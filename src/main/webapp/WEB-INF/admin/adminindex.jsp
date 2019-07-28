
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="../assets/img/favicon.png" />
    <title>管理员操作界面</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- CSS Files -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/assets/css/paper-bootstrap-wizard.css" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="/assets/css/demo.css" rel="stylesheet" />

    <!-- Fonts and Icons -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="/assets/css/themify-icons.css" rel="stylesheet">
</head>

<body>
<div class="image-container set-full-height" style="background-image: url(/assets/img/paper-2.jpeg)">
    <!--   Creative Tim Branding   -->
    <a href="/index/cancellation.do">
        <div class="logo-container">
            <div class="logo">
                <img src="/assets/img/new_logo.png">
            </div>
            <div class="brand">
                <p>${ sessionScope.loginName}</p>
                <p>注销</p>
            </div>
        </div>
    </a>
    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">

                <!--      Wizard container        -->
                <div class="wizard-container">
                    <div class="card wizard-card" data-color="green" id="wizard">
                        <div class="wizard-navigation">
                            <div class="progress-with-circle">
                                <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="4" style="width: 15%;"></div>
                            </div>
                            <ul>
                                <li>
                                    <a href="#location" data-toggle="tab">
                                        <div class="icon-circle">
                                            <i class="ti-map"></i>
                                        </div>
                                        列车管理
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane" id="location" class="form-control">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h5 class="info-text"> <a href="${pageContext.request.contextPath}/order/findAllOrder.do">全部订单</a></h5>
                                    </div>
                                </div>
                                <table border="0" class="form-control">
                                    <tr  style="line-height: 200%">
                                        <th width="100px" align="center">列车号</th>
                                        <th width="100px" align="center">车厢数</th>
                                        <th width="100px" align="center">车厢载客数</th>
                                        <th width="100px" align="center">操作</th>
                                    </tr>
                                    <c:forEach items="${admin}" var="a">
                                        <tr  style="line-height: 200%">
                                            <td align="center">${a.trainid}</td>
                                            <td align="center">${a.carriagenumber}</td>
                                            <td align="center">${a.carriagenumpeo}</td>
                                            <td align="center">
                                                <a href="${pageContext.request.contextPath}/admin/setup.do?id=${a.trainid}">设置路程</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <a href="${pageContext.request.contextPath}/admin/insert.do">添加列车&nbsp;&nbsp;&nbsp;</a>
                                    <a href="${pageContext.request.contextPath}/admin/page.do">查看全部列车线路</a>
                                </table>
                            </div>

                        </div>

                    </div>

                </div> <!-- wizard container -->
            </div>
        </div> <!-- row -->
    </div> <!--  big container -->

    <div class="footer">

    </div>
</div>

</body>

<!--   Core JS Files   -->
<script src="/assets/js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/assets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="/assets/js/paper-bootstrap-wizard.js" type="text/javascript"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="/assets/js/jquery.validate.min.js" type="text/javascript"></script>

</html>
