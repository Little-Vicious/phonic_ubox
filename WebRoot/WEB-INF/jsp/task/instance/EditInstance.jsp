<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      修改任务环节信息
    </title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=path %>/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="<%=path %>/css/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="<%=path %>/css/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <!-- DataTables Responsive CSS -->
    <link href="<%=path %>/css/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=path %>/css/dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<%=path %>/css/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  </head>

  <body>
    <div id="wrapper">
      <!-- 引入我们的头部文件 -->
      <%@ include file="../../navbar.jsp" %>
      <div id="page-wrapper">
        <div class="panel panel-default">

          <form id="form">
            <div class="panel panel-info">
              <div class="panel-heading">
                修改任务环节信息
                <div style="float: right">
                  <a href="${pageContext.request.contextPath }/task/listTache.do?taskId=${taskId}">
                    <i class="fa fa-history fa-fw"></i>返回 </a>
                </div>
              </div>
            </div>
            <div class="panel-body">
              <input type="hidden" id="taskId" name="taskId" value="${taskId }">
              <input type="hidden" id="tacheId" name="tacheId" value="${tacheCustom.tacheId }">
              <table width="100%" class="table table-striped table-bordered table-hover">
                <tr>
                  <td align="right" width="30%">
                    环节类别:
                    <font color="red">*</font>
                  </td>
                  <td>
                    <select id="tacheType" name="tacheType" class="form-control">
                    </select>
                  </td>
                  <td width="40%"></td>
                </tr>
                <tr>
                  <td align="right">
                    环节标识:
                  </td>
                  <td>
                    <input type="text" id="tacheFlag" name="tacheFlag" class="form-control" value="${tacheCustom.tacheFlag }" >
                  </td>
                  <td width="40%" id="taskFlagTip"></td>
                </tr>

                <tr>
                  <td align="right">
                    环节名称:
                    <font color="red">*</font>
                  </td>
                  <td>
                    <input type="text" id="tacheName" name="tacheName" class="form-control" value="${tacheCustom.tacheName }">
                  </td>
                  <td width="40%"></td>
                </tr>
                <tr>
                  <td colspan="4" align="center">
                    <button type="button" id="saveBtn" class="btn btn-danger">
                      <i class="fa fa-save fa-fw"></i>保存
                    </button>
                  </td>
                </tr>
              </table>
            </div>
          </form>
        </div>
      </div>
      <!-- jQuery -->
      <script src="<%=path %>/css/vendor/jquery/jquery.min.js">
      </script>
      <!-- Bootstrap Core JavaScript -->
      <script src="<%=path %>/css/vendor/bootstrap/js/bootstrap.min.js">
      </script>
      <!-- Metis Menu Plugin JavaScript -->
      <script src="<%=path %>/css/vendor/metisMenu/metisMenu.min.js">
      </script>
      <!-- DataTables JavaScript -->
      <script src="<%=path %>/css/vendor/datatables/js/jquery.dataTables.min.js">
      </script>
      <script src="<%=path %>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js">
      </script>
      <script src="<%=path %>/css/vendor/datatables-responsive/dataTables.responsive.js">
      </script>
      <!-- Custom Theme JavaScript -->
      <script src="<%=path %>/css/dist/js/sb-admin-2.js">
      </script>
      <script type="text/javascript" src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>

      <script type="text/javascript" src="<%=path %>/js/initPage.js"></script>
      <script type="text/javascript">
        $(function() {
          initDrop({
            data: [{
              "selectIds": "tacheType",
              "typeCode": "tacheType"}]
            });

          $("#saveBtn").click(function() {
            var taskId = $("#taskId").val();
            var tacheId = $("#tacheId").val();
            var tacheType = $("#tacheType").val();
            var tacheFlag = $("#tacheFlag").val();
            var tacheName = $("#tacheName").val();
            
            if(tacheName == "") {
              alert("环节名称不能为空!");
              $("#tacheName").focus();
              return false;
            }
            

            $.ajax({
              url: getContextPath() + "/task/submitEditTache.do",
              type: "POST",
              data: {
                "taskId": taskId,
                "tacheId": tacheId,
                "tacheType": tacheType,
                "tacheFlag": tacheFlag,
                "tacheName": tacheName
              },
              dataType:"json",
              success: function(msg) {
                console.log(JSON.stringify(msg));
                window.location.href = getContextPath()+"/task/listTache.do?taskId="+taskId;
              },
              error: function(er) {
                console.log(JSON.stringify(er));
              }
            });
          });
        });
        
        //校验taskFlag是否存在
        function checkTaskFlag(taskFlag){
          $.ajax({
              url: getContextPath() + "/task/checkTaskFlag.do",
              type: "POST",
              data: {
                "taskFlag": taskFlag
              },
              success: function(msg) {
                var str = JSON.stringify(msg);
                var obj = eval('('+str+')');
                var flag = obj.flag;
                var msg = obj.msg;
                if(flag){
                  alert(msg);
                  taskFlagTip
                }
              },
              error: function(er) {
                console.log(JSON.stringify(er));
              }
            });
        }
        
      </script>
    </div>
  </body>

</html>