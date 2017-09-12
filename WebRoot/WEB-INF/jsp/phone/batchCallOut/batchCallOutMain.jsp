<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>批量呼出</title>
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
          <form action="${pageContext.request.contextPath }/batchCallOut/callList.do" method="post">
            <div class="panel panel-info">
              <div class="panel-heading">
                批量外呼列表
                <div style="float: right">
                  <!--  
                   <a href="${pageContext.request.contextPath }/batchCallOut/editBatchCallOut.do">
                   <i class="fa fa-plus fa-fw"></i>新增 </a>
                   -->
                </div>
              </div>
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                  <tr>
                    <th>日期</th>
                    <th>名称</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>总时长</th>
                    <th>总数</th>
                    <th>已完成</th>
                    <th>未完成</th>
                    <th>有效</th>
                    <th>呼叫操作</th>
                    <th>删除操作</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${batchcalloutCustoms}" var="call">
                    <tr class="odd gradeX">
                      <td><fmt:formatDate value="${ call.insertDatetime }" pattern="yyyy-MM-dd" /></td>
                      <td>${call.projectName}</td>
                      <td>
                        <fmt:formatDate value="${ call.startTime }" pattern="yyyy-MM-dd" />
                      </td>
                      <td><fmt:formatDate value="${ call.endTime }" pattern="yyyy-MM-dd" /></td>
                      <td>0</td>
                      <td>${ call.countCallout }</td>
                      <td>${ call.countFinish }</td>
                      <td>${ call.countUnfinish }</td>
                      <td>${ call.countEffective }</td>
                      <td>
                        <a href="${pageContext.request.contextPath }/batchCallOut/showBatchCallOut.do?batchNo=${ call.batchNo }">
                          <i class="fa fa-edit fa-fw"></i>批量外呼
                        </a>
                      </td>
                      <td>
                      <!--  
                        <a href="${pageContext.request.contextPath }/batchCallOut/batchCallOutList.do?id=${ call.batchNo }">
                          <i class="fa fa-plus fa-fw"></i>增加外呼
                        </a>
                        -->
                        <a href="${pageContext.request.contextPath }/batchCallOut/deleteBatchCallout.do?batchNo=${ call.batchNo }" onclick="return del(this);">
                          <i class="fa fa-times fa-fw"></i>删除群组
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