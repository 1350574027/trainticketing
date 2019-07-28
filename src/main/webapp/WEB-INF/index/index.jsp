
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="../assets/img/favicon.png" />
    <title>欢迎光临</title>

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
                        <form action="findStation.do" method="post">
                            <div class="wizard-header">
                                <h3 class="wizard-title">您的出行计划</h3>
                                <p class="category">此信息让我们更了解您的位置</p>
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
                                            地点
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="location">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text"> <a href="${pageContext.request.contextPath}/order/findByLoginName.do">我的订单</a></h5>
                                        </div>

                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>出发地</label>
                                                <select name="chufa" class="form-control">
                                                    <option disabled="" selected="">- 请选择城市 -</option>
                                                    <option value="福州站"> 福州站 </option>
                                                    <option value="厦门站"> 厦门站 </option>
                                                    <option value="泉州站"> 泉州站 </option>
                                                    <option value="宁德站"> 宁德站</option>
                                                    <option value="漳州站"> 漳州站 </option>
                                                    <option value="龙岩站"> 龙岩站 </option>
                                                    <option value="三明站"> 三明站 </option>
                                                    <option value="莆田站"> 莆田站 </option>
                                                    <option value="南平站"> 南平站 </option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>目的地</label><br>
                                                <select name="daoda" class="form-control">
                                                    <option disabled="" selected="">- 请选择城市 -</option>
                                                    <option value="福州站"> 福州站 </option>
                                                    <option value="厦门站"> 厦门站 </option>
                                                    <option value="泉州站"> 泉州站 </option>
                                                    <option value="宁德站"> 宁德站</option>
                                                    <option value="漳州站"> 漳州站 </option>
                                                    <option value="龙岩站"> 龙岩站 </option>
                                                    <option value="三明站"> 三明站 </option>
                                                    <option value="莆田站"> 莆田站 </option>
                                                    <option value="南平站"> 南平站 </option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>出行时间</label>
                                                <input type ="date" name="time" class="form-control">

                                                </input>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <input type='submit' class='btn btn-finish btn-fill btn-success btn-wd' name='next' value='下一步' />
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </form>
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
