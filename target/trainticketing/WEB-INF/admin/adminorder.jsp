
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="apple-touch-icon" sizes="76x76" href="/assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="/assets/img/favicon.png" />
    <title>选座购票</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- CSS Files -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/assets/css/paper-bootstrap-wizard.css" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="/assets/css/demo.css" rel="stylesheet" />

    <!-- Fonts and Icons -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="/assets/css/themify-icons.css" rel="stylesheet">
</head>

<body>
<div class="image-container set-full-height" style="background-image: url('/assets/img/paper-2.jpeg')">
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

                            <!--        You can switch " data-color="green" "  with one of the next bright colors: "blue", "azure", "orange", "red"       -->

                            <div class="wizard-header">
                                <h3 class="wizard-title">购票结果</h3>
                            </div>
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
                                            我的车票
                                        </a>
                                    </li>
                                </ul>
                            </div>

                        <div class="tab-content">

                            <div class="tab-pane" id="location" class="form-control">
                                        <h5 class="info-text"> <a href="${pageContext.request.contextPath}/index/index.do">返回主页</a></h5>

                                    <table border="0" class="form-control">
                                    <tr style="line-height: 150%">
                                        <th width="100px" >列车号</th>
                                        <th width="100px" >出发地</th>
                                        <th width="100px" >出发时间</th>
                                        <th width="100px" >目的地</th>
                                        <th width="100px" >到达时间</th>
                                        <th width="100px" >票价</th>
                                        <th width="100px" >车厢号</th>
                                        <th width="100px" >座位号</th>
                                    </tr>
                                    <c:forEach items="${list}" var="l" varStatus="vl" >
                                        <tr style="line-height: 300%">
                                            <td width="50px">${l.trainid}</td>
                                            <td width="50px">${l.chufa}</td>
                                            <td width="50px"><fmt:formatDate value="${l.chufatime}" type="both"/></td>
                                            <td width="50px">${l.daoda}</td>
                                            <td width="50px"><fmt:formatDate value="${l.daodatime}" type="both"/></td>
                                            <td width="50px">${l.needmoney1}元</td>
                                            <td width="50px">${l.carriageid}号</td>
                                            <td width="50px">${l.liness}列${l.seat}</td>
                                        </tr>
                                    </c:forEach>
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
