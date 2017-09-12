<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      修改码值信息
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

          <form id="codetypeForm" action="${pageContext.request.contextPath }/codeinfo/editCodeInfoByTypeSubmit.do" method="post">
            <input type="hidden" name="typeCode" value="${codetype.typeCode }">
            <input type="hidden" name="isDel" value="${codeinfo.isDel }">
            <div class="panel panel-info">
              <div class="panel-heading">
              ${codetype.typeName } - 修改码值信息
              <div style="float: right">
                   <a href="${pageContext.request.contextPath }/codeinfo/listCodeInfoByType.do?typeCode=${codetype.typeCode}">
                   <i class="fa fa-history fa-fw"></i>返回 </a>
               </div>
              </div>
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover">
                <tr>
                  <td>
                    码值:
                  </td>
                  <td>
                    <input type="text" name="codeValue" value="${codeinfo.codeValue }">
                  </td>
                </tr>
                <tr>
                  <td>
                    码值名称:
                  </td>
                  <td>
                    <input type="text" name="codeName" value="${codeinfo.codeName }">
                  </td>
                </tr>
                <tr>
                  <td colspan="4" align="center">
                    <input type="submit" class="btn btn-primary" />
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
    </div>
  </body>

</html>