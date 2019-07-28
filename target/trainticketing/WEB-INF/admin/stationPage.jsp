
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
    <title>列车班次</title>

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
                                <h3 class="wizard-title">您可以选择以下班次的列车</h3>
                                <p class="category">&nbsp;</p>
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
                                            列车
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/findAll.do">返回主页</a>
                            <div class="tab-content">

                                <div class="tab-pane" id="location" class="form-control">

                                        <table border="0" class="form-control">
                                            <tr style="line-height: 150%">
                                                <th width="100px" >列车趟次编号</th>
                                                <th width="100px" >列车号</th>
                                                <th width="100px" >站点名</th>
                                                <th width="100px" >到站时间</th>
                                                <th width="100px" >票价</th>
                                            </tr>
                                            <c:forEach items="${pageUtil.list}" var="p" varStatus="vp" >
                                            <tr style="line-height: 200%">
                                                <td width="50px">${p.trainstate}</td>
                                                <td width="50px">${p.trainid}</td>
                                                <td width="50px">${p.stationname}</td>
                                                <td width="50px"><fmt:formatDate value="${p.arrivaltime}" type="both"/></td>
                                                <td width="50px">${p.price}元</td>
                                            </tr>
                                            </c:forEach>
                                            <div class='page all'>
                                                <b>共${pageUtil.pageNumber}</b>条,当前第<span>${pageUtil.pageIndex}</span>页
                                                <a href="${pageContext.request.contextPath}/admin/page.do?pageIndex=1" class='first'>首页</a>
                                                <a href="${pageContext.request.contextPath}/admin/page.do?pageIndex=${pageUtil.pageIndex>1?pageUtil.pageIndex-1:1}" class='pre'>上一页</a>
                                                <c:forEach begin="1" end="${pageUtil.pageCount}" var="i">
                                                    <a href="${pageContext.request.contextPath}/admin/page.do?pageIndex=${i}" style="text-decoration: none;">${i}</a>
                                                </c:forEach>
                                                <a href="${pageContext.request.contextPath}/admin/page.do?pageIndex=${pageUtil.pageIndex<pageUtil.pageCount?pageUtil.pageIndex+1:pageUtil.pageCount}" class='next'>下一页</a>
                                                <a href="${pageContext.request.contextPath}/admin/page.do?pageIndex=${pageUtil.pageCount}" class='last'>末页</a>
                                            </div>
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
