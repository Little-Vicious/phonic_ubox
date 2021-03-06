<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>环节实例列表</title>
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
    
    <script type="text/javascript" src="<%=path %>/js/initPage.js"></script>
    
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
      
      function del(tacheId) {
          if (confirm("您确定要删除么？删除后将无法恢复！")) {
            var taskId = $("#taskId").val();
            
            $.ajax({
              url:getContextPath() + "/task/deleteTache.do",
              type:"POST",
              data:{
                "tacheId":tacheId
              },
              dataType:"json",
              success: function(msg) {
                var str = JSON.stringify(msg);
                console.log(str);
                var obj = eval('('+str+')');
                var flag = obj.flag;
                var msg = obj.msg;
                if(flag){
                  window.location.href = getContextPath()+"/task/listTache.do?taskId="+taskId;
                }else {
                  alert(msg);
                }
                
              },
              error: function(er) {
                console.log(JSON.stringify(er));
              }
            });
            return false;
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
          <input type="hidden" name="tacheId" id="tacheId" value="${tacheId}">
            <div class="panel panel-info">
              <div class="panel-heading">
               环节实例列表
                <div style="float: right">
                   <a href="${pageContext.request.contextPath }/task/listTache.do?taskId=${ taskId }">
                   <i class="fa fa-history fa-fw"></i>返回</a>
                   <a href="${pageContext.request.contextPath }/task/showEditInstance.do?tacheId=${ tacheId }">
                   <i class="fa fa-plus fa-fw"></i>创建实例</a>
                </div>
              </div>
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                  <tr>
                    <th>实例标识</th>
                    <th>实例名称</th>
                    <th>创建时间</th>
                    <th>执行状态</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>运行时间</th>
                    <th>执行脚本</th>
                    <th>操作</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${instanceCustoms}" var="instance">
                    <tr class="odd gradeX">
                      <td>${instance.instanceFlag}</td>
                      <td>${instance.instanceName}</td>
                      <td><fmt:formatDate value="${ instance.instanceTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                      <td>${instance.instanceStatus}</td>
                      <td>${instance.instanceStartTime}</td>
                      <td>${instance.instanceEndTime}</td>
                      <td>${instance.duration}</td>
                      <td>${instance.instanceScriptPath}</td>
                      <td>
                        <a href="${pageContext.request.contextPath }/task/showEditInstance.do?tacheId=${ tacheId }&&instanceId=${instance.instanceId}">
                          <i class="fa fa-edit fa-fw"></i>编辑
                        </a>
                        <a href="${pageContext.request.contextPath }/task/listInstance.do?typeCode=${task.taskId}">
                          <i class="fa fa-plus fa-fw"></i>添加实例
                        </a>
                        <a id="delTache" href="###" onclick="return del('${tache.tacheId}');" value="${tache.tacheId}">
                          <i class="fa fa-times fa-fw"></i>删除
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