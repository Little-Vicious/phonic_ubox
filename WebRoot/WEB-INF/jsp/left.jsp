<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar-default sidebar" role="navigation">
  <div class="sidebar-nav navbar-collapse">
    <ul class="nav" id="side-menu">
      <li class="sidebar-search">
        <div class="input-group custom-search-form">
          <input type="text" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button">
              <i class="fa fa-search"></i>
            </button> </span>
        </div>
      </li>
      <li>
        <a href="${pageContext.request.contextPath }/success.do"><i class="fa fa-dashboard fa-fw"></i> 首页
        </a>
      </li>
      <li>
        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 电话营销<span class="fa arrow"></span>
        </a>
        <ul class="nav nav-second-level">
          <li>
            <!--  
            <a href="${pageContext.request.contextPath }/singleCallOut/callList.do">单个外呼</a>
            -->
            <a href="morris.html">单个外呼</a>
          </li>
          <li>
            <a href="morris.html">录音查询</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/batchCallOut/callList.do">批量外呼</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/listen/listenCallOut.do">呼入监听</a>
          </li>
        </ul>
      </li>
      <li>
        <a href="#"><i class="fa fa-users fa-fw"></i> 群组管理<span class="fa arrow"></span>
        </a>
        <ul class="nav nav-second-level">
          <li>
            <a href="${pageContext.request.contextPath }/oppo/listOppoGroup.do">商机管理</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/notice/listNoticeGroup.do">提醒管理</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/clients/listClientsGroup.do">客户群组管理</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/activity/listActivityGroup.do">活动量管理</a>
          </li>
        </ul>
      </li>
      <li>
        <a href="#"><i class="fa fa-tasks fa-fw"></i> 批量任务调度<span class="fa arrow"></span>
        </a>
        <ul class="nav nav-second-level">
          <li>
            <a href="${pageContext.request.contextPath }/task/listTask.do">任务列表</a>
          </li>
           <li>
            <a href="${pageContext.request.contextPath }/dispatch/listDispatch.do">调度列表</a>
          </li>
        </ul>
      </li>
      <li>
        <a href="#"><i class="fa fa-qrcode fa-fw"></i> 码值管理<span class="fa arrow"></span>
        </a>
        <ul class="nav nav-second-level">
          <li>
            <a href="${pageContext.request.contextPath }/codeinfo/listCodetypeAll.do">类型列表</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath }/organization/orgTree.do">机构列表</a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</div>