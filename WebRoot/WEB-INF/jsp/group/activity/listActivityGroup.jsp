<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活动量群组列表</title>
<!-- Bootstrap Core CSS -->
<link href="<%=path%>/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="<%=path%>/css/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<!-- DataTables CSS -->
<link href="<%=path%>/css/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="<%=path%>/css/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="<%=path%>/css/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<%=path%>/css/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="<%=path%>/css/vendor/jquery/jquery.min.js">
	
</script>
<!-- Bootstrap Core JavaScript -->
<script src="<%=path%>/css/vendor/bootstrap/js/bootstrap.min.js">
	
</script>
<!-- Metis Menu Plugin JavaScript -->
<script src="<%=path%>/css/vendor/metisMenu/metisMenu.min.js">
	
</script>
<!-- DataTables JavaScript -->
<script src="<%=path%>/css/vendor/datatables/js/jquery.dataTables.min.js">
	
</script>
<script src="<%=path%>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js">
	
</script>
<script src="<%=path%>/css/vendor/datatables-responsive/dataTables.responsive.js">
	
</script>
<!-- Custom Theme JavaScript -->
<script src="<%=path%>/css/dist/js/sb-admin-2.js">
	
</script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script type="text/javascript">
  var contpath;
	$(document).ready(function() {
	  contpath = $("#contextPath").val();
    $.ajax({
        url : contpath + "/groupCommon/getInitCode.do",
        type : "POST",
        data : {},
        dataType : "json",
        success : function(msg) {
          var str = JSON.stringify(msg);
          
          var obj = eval('('+str+')');
          var codeTypes = obj.codeTypes;
          var custInfo = obj.custInfo;
          
          for(var i = 0;i<codeTypes.length;++i){
            var typeCode = codeTypes[i].typeCode;
            var select = $("#code"+typeCode);
            var listCodeInfo = codeTypes[i].listCodeInfo;
            
            for(var j = 0;j<listCodeInfo.length;++j){
              var codeinfo = listCodeInfo[j];
              codevalue = codeinfo.codeValue;
              codename = codeinfo.codeName;
              select.append("<option value="+codevalue+">"+codename+"</option>");
            }
          }
          
        },
        error : function(er) {
          //console.log(JSON.stringify(er));
        }
      });

    $('#dataTables-example').DataTable({
      responsive : true,
      "bSort" : false,
      "bFilter" : false,
      "language" : {
        "sLengthMenu" : "每页显示 _MENU_ 条记录",
        "sZeroRecords" : "抱歉， 没有找到",
        "sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
        "sInfoEmpty" : "没有数据",
        "sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
        "sZeroRecords" : "没有检索到数据",
        "sSearch" : "过滤:",
        "oPaginate" : {
          "sFirst" : "首页",
          "sPrevious" : "前一页",
          "sNext" : "后一页",
          "sLast" : "尾页"
        }
      }
    });
  });

  //查询活动量群组
  function queryGroup() {
    var url = contpath + "/activity/queryListActivityGroup.do"
    $("#dataForm").attr("action", url);
    return true;
  }

  //保存活动量群组
  function saveGroup() {
    var flag = false;
    var checkNum = $("input[name='groupNos']:checked").length;
    if(checkNum > 0){
      console.log(checkNum);
      var url = contpath + "/groupCommon/saveGroup.do"
      $("#dataForm").attr("action", url);
      flag= true;
    }else{
      alert("你还未选择客户！");
    }
    return flag;
  }
</script>

</head>

<body>
  <div id="wrapper">
    <!-- 引入我们的头部文件 -->
    <%@ include file="../../navbar.jsp"%>
    <div id="page-wrapper">
      <div class="panel panel-default">
        <form id="dataForm" method="post">
          <input type="hidden" id="contextPath" name="contextPath" value="${pageContext.request.contextPath }">
          <input type="hidden" id="batchType" name="batchType" value="${batchType}">
          <div class="panel panel-info">
            <div class="panel-heading">
              活动量群组客户列表
              <div style="float: right">
                <a href="${pageContext.request.contextPath }/activity/editCust.do">
                  <i class="fa fa-plus fa-fw"></i>
                  新增
                </a>
              </div>
            </div>
          </div>
          <div class="panel-body">
            <table width="100%" class="table">
              <tr>
                <td>客户号：</td>
                <td>
                  <input id="custNo" name="custNo" class="form-control" value="${activitygroupCustom.custNo}">
                </td>
                <td>客户姓名：</td>
                <td>
                  <input id="custName" name="custName" class="form-control" value="${activitygroupCustom.custName }">
                </td>
              </tr>
              <tr>
                <td>活动量名称：</td>
                <td>
                  <input id="activityName" name="activityName" class="form-control" value="${activitygroupCustom.activityName}">
                </td>
                <td>活动量类型：</td>
                <td>
                  <select id="codeactivityType" name="activityType" class="form-control">
                    <option value=""></option>
                  </select>
                </td>
              </tr>
              <tr>
                <td>接触阶段：</td>
                <td>
                  <select id="codeconStep" name="contactStep" class="form-control">
                    <option value=""></option>
                  </select>
                </td>
              </tr>
              <tr>
                <td colspan="4" align="center">
                  <button type="submit" class="btn btn-primary" onclick="return queryGroup();">
                    <i class="fa fa-search">查询</i>
                  </button>
                  <button type="reset" class="btn btn-warning">
                    <i class="fa fa-repeat">重置</i>
                  </button>
                  <button type="button" class="btn btn-success">
                    <i class="fa fa-file-excel-o">导出</i>
                  </button>
                  <button type="submit" class="btn btn-danger" onClick="return saveGroup();">
                    <i class="fa fa-group">保存群组</i>
                  </button>
                </td>
              </tr>
            </table>
            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
              <thead>
                <tr>
                  <th></th>
                  <th>客户号</th>
                  <th>客户姓名</th>
                  <th>活动量名称</th>
                  <th>活动量类型</th>
                  <th>工作日</th>
                  <th>接触阶段</th>
                  <th>客户来源渠道</th>
                  <th>创建人</th>
                  <th>状态</th>
                  <th>备注</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${activitygroups}" var="activity">
                  <tr class="odd gradeX">
                    <td>
                      <input name="groupNos" type="checkbox" value="${activity.groupNo}">
                    </td>
                    <td>${activity.custNo}</td>
                    <td>${activity.custName}</td>
                    <td>${activity.activityName}</td>
                    <td>${activity.activityType}</td>
                    <td><fmt:formatDate value="${ activity.workday }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${activity.contactStep}</td>
                    <td>${activity.sourceChannels}</td>
                    <td>${activity.creater}</td>
                    <td>${activity.status}</td>
                    <td>${activity.comments}</td>
                    <td></td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>

</html>