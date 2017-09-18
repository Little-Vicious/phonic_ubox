<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      修改批量任务信息
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
      <%@ include file="../navbar.jsp" %>
      <div id="page-wrapper">
        <div class="panel panel-default">

          <form id="form">
            <div class="panel panel-info">
              <div class="panel-heading">
                修改批量任务信息
                <div style="float: right">
                  <a href="${pageContext.request.contextPath }/task/listTask.do">
                    <i class="fa fa-history fa-fw"></i>返回 </a>
                </div>
              </div>
            </div>
            <div class="panel-body">
              <input type="hidden" id="taskId" name="taskId" value="${task.taskId }">
              <table width="100%" class="table table-striped table-bordered table-hover">
                <tr>
                  <td align="right" width="30%">
                    任务类别:
                    <font color="red">*</font>
                  </td>
                  <td>
                    <select id="taskType" name="taskType" class="form-control">
                    </select>
                  </td>
                  <td width="40%"></td>
                </tr>
                <tr>
                  <td align="right">
                    任务标识:
                    <font color="red">*</font>
                  </td>
                  <td>
                    <input type="text" id="taskFlag" name="taskFlag" class="form-control" value="${task.taskFlag }" onBlur="checkTaskFlag(this.value);">
                  </td>
                  <td width="40%" id="taskFlagTip"></td>
                </tr>

                <tr>
                  <td align="right">
                    任务名称:
                    <font color="red">*</font>
                  </td>
                  <td>
                    <input type="text" id="taskName" name="taskName" class="form-control" value="${task.taskName }">
                  </td>
                  <td width="40%"></td>
                </tr>
                
                <tr>
                  <td align="right">
                    执行频率:
                    <font color="red">*</font>
                  </td>
                  <td>
                    <select id="execRate" name="execRate" class="form-control">
                    </select>
                  </td>
                  <td width="40%"></td>
                </tr>
                
                <tr>
                  <td align="right">
                    任务说明:
                  </td>
                  <td>
                    <textarea id="taskDescription" name="taskDescription" value="${task.taskDescription }" class="form-control" rows="3"></textarea>
                  </td>
                  <td width="40%"></td>
                </tr>

                <tr>
                  <td colspan="4" align="center">
                    <button type="button" id="saveBtn" class="btn btn-primary">
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
              "selectIds": "taskType",
              "typeCode": "taskType"
            },{"selectIds": "execRate",
              "typeCode": "execRate"}]
          });

          $("#saveBtn").click(function() {
            var taskId = $("#taskId").val();
            var taskType = $("#taskType").val();
            var taskFlag = $("#taskFlag").val();
            var taskName = $("#taskName").val();
            var taskDescription = $("#taskDescription").val();
            
            if(taskFlag == "") {
              alert("任务标识不能为空!");
              $("#taskFlag").focus();
              return false;
            }else{
              if(taskId == null){
                if(checkTaskFlag(taskFlag)){
                  alert("任务标识已经存在！");
                  return false;
                }
              }
            }

            if(taskName == "") {
              alert("任务名称不能为空!");
              $("#taskName").focus();
              return false;
            }

            $.ajax({
              url: getContextPath() + "/task/submitEditTask.do",
              type: "POST",
              data: {
                "taskId": taskId,
                "taskType": taskType,
                "taskFlag": taskFlag,
                "taskName": taskName,
                "taskDescription": taskDescription
              },
              success: function(msg) {
                console.log(JSON.stringify(msg));
                window.location.href = getContextPath()+"/task/listTask.do";
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