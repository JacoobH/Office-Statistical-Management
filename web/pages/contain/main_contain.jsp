<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ol class="breadcrumb">
    <li><a href="#"><span class="glyphicon glyphicon-tag"></span> 首页</a></li>
</ol>
<div class="alert alert-success alert-dismissable" role="alert">
    <button class="close" type="button" data-dismiss="alert">&times;</button>
    欢迎使用本系统，亲爱的${sessionScope["account_user"]}！如有需要，请查阅<a href="#" class="alert-link">用户手册</a>
</div>

<div class="row">
    <div id="ad_carousel" class="carousel slider col-md-10 col-md-offset-1" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#ad_carousel" data-slide-to="0" class="active"></li>
            <li data-target="#ad_carousel" data-slide-to="1"></li>
            <li data-target="#ad_carousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="img-rounded" src="../../assets/imgs/carousel03.jpeg" alt="面向办公室管理人员">
                <div class="carousel-caption">
                    <h1>面向办公室管理人员</h1>
                    <p>功能涵盖：账户管理、办公室管理、相关单位管理（客户）、缴费管理以及各类统计</p>
                </div>
            </div>
            <div class="item">
                <img class="img-rounded" src="../../assets/imgs/carousel01.jpg" alt="OfficeBuildingManagement">
            </div>
            <div class="item">
                <img class="img-rounded" src="../../assets/imgs/carousel02.PNG" alt="自适应移动端">
                <div class="carousel-caption">
                    <h1>自适应移动端</h1>
                    <p>根据您的移动设备屏幕大小而产生最佳的页面</p>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#ad_carousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">上一页</span>
        </a>
        <a class="right carousel-control" href="#ad_carousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">下一页</span>
        </a>
    </div>
</div>
<div class="row">
    <div class="col-md-3">
        <section class="panel panel-success">
            <div class="panel-heading  text-center">
                <span class="glyphicon glyphicon-th-list"></span> 在线人数
            </div>
            <div class="panel-body  text-center">
                <a href="#">
                    <h1>${applicationScope["online_num"]}位</h1>
                </a>
            </div>
        </section>
    </div>
    <div class="col-md-3">
        <section class="panel panel-info">
            <div class="panel-heading  text-center">
                <span class="glyphicon glyphicon-cloud"></span> 用户总数
            </div>
            <div class="panel-body  text-center">
                <a href="#">
                    <h1>${applicationScope["account_num"]}位</h1>
                </a>
            </div>
        </section>
    </div>
    <div class="col-md-3">
        <section class="panel panel-danger">
            <div class="panel-heading  text-center">
                <span class="glyphicon glyphicon-euro"></span> 相关单位数量
            </div>
            <div class="panel-body  text-center">
                <a href="#">
                    <h1>${applicationScope["company_num"]}处</h1>
                </a>
            </div>
        </section>
    </div>
    <div class="col-md-3">
        <section class="panel panel-warning">
            <div class="panel-heading  text-center">
                <span class="glyphicon glyphicon-modal-window"></span> 办公室数量

            </div>
            <div class="panel-body  text-center">
                <a href="#">
                    <h1>${applicationScope["room_num"]}间</h1>
                </a>
            </div>
        </section>
    </div>
</div>
