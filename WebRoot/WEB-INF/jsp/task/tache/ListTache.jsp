<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>任务环节列表</title>
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
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
      $(document).ready(function() {
        $('#dataTables-example').DataTable({
          responsive: true,
          ordering:false,
          searching: false,
          "language": {
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "抱歉， 没有找到",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "sZeroRecords": "没有检索到数据",
            "sSearch": "过滤:",
            "oPaginate": {
              "sFirst": "首页",
              "sPrevious": "前一页",
              "sNext": "后一页",
              "sLast": "尾页"
            }
          }
        });
      });
      
      function del(dlink) {
          if (confirm("您确定要删除么？删除后将无法恢复！")) {
            return true;
          } else {
            return false;
          }
        }
    </script>

  </head>

  <body>
    <div id="wrapper">
      <!-- 引入我们的头部文件 -->
      <%@ include file="../../navbar.jsp" %>
      <div id="page-wrapper">
        <div class="panel panel-default">
          <form method="post">
          <input type="hidden" name="taskId" id="taskId" value="${taskId}">
            <div class="panel panel-info">
              <div class="panel-heading">
               任务环节列表
                <div style="float: right">
                   <a href="${pageContext.request.contextPath }/task/showEditTache.do?taskId=${ taskId }">
                   <i class="fa fa-plus fa-fw"></i>创建环节</a>
                </div>
              </div>
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                  <tr>
                    <th>环节标识</th>
                    <th>环节名称</th>
                    <th>创建时间</th>
                    <th>执行状态</th>
                    <th>完成率</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>运行时间</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${tasks}" var="task">
                    <tr class="odd gradeX">
                      <td>${task.taskFlag}</td>
                      <td>${task.taskName}</td>
                      <td><fmt:formatDate value="${ task.taskTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                      <td>${task.taskStatus}</td>
                      <td>${task.completedTasks}/${task.totalTasks}</td>
                      <td>${task.taskStartTime}</td>
                      <td>${task.taskEndTime}</td>
                      <td>${task.duration}</td>
                      <td>
                        <a href="${pageContext.request.contextPath }/task/showEditTask.do?taskId=${ task.taskId }">
                          <i class="fa fa-edit fa-fw"></i>编辑任务
                        </a>
                        <a href="${pageContext.request.contextPath }/task/listEditTask.do?typeCode=${task.taskId}">
                          <i class="fa fa-plus fa-fw"></i>添加环节
                        </a>
                        <a href="${pageContext.request.contextPath }/task/deleteTask.do?typeCode=${task.taskId}" onclick="return del(this);">
                          <i class="fa fa-times fa-fw"></i>删除任务
                        </a>
                      </td>
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