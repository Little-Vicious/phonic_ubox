<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html;utf-8">
    <title>单个外呼</title>
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
    <!-- jQuery -->
    <script src="<%=path %>/js/uboxweb.js"></script>
    <script src="<%=path %>/js/dateFormat.js"></script>
    <script src="<%=path %>/js/batchCallOut.js"></script>
    <script type="text/javascript">
     function CallerDisplay(callerNumber){
       $("#custNumber").val(callerNumber);
     }
    </script>
  </head>

  <body>
    <div id="wrapper">
      <!-- 引入我们的头部文件 -->
      <%@ include file="../../navbar.jsp"%>
      <div id="page-wrapper">
        <div class="panel panel-default">
          <form action="${pageContext.request.contextPath }/batchCallOut/nextCallOut.action" method="post">
            <input type="hidden" name="uboxhdl" id="uboxhdl" value="">
            <div class="panel panel-info">
              <div class="panel-heading">监听：</div>
            </div>
            <div class="panel-body">
              <table id="dataTable" width="100%">
                <tr>
                  <td align="right">
                    客户姓名：
                    <font color="red">*</font>
                  </td>
                  <td width="20%">
                    <input type="text" id="custName" name="custname" value="" class="form-control">

                  </td>
                  <td align="right">
                    客户电话：
                    <font color="red">*</font>
                  </td>
                  <td width="20%">
                    <input type="text" id="custNumber" name="custname" value="" class="form-control">

                  </td>
                  <td align="right">其他电话：</td>
                  <td width="20%">
                    <select id="otherNumber" class="form-control">
                    </select>
                  </td>
                </tr>
                <tr>

                </tr>
                <tr>
                  <td id="centent" align="center" colspan="6"></td>
                </tr>
                <tr>
                  <td align="center" colspan="6">
                    客户评分录音
                    <button id="playBtn" type="button" class="btn btn-primary" onclick="playRec();">
                    <i class="fa fa-headphones">接听</i>
                  </button>
                  </td>
                </tr>
              </table>
            </div>
          </form>
        </div>
      </div>

    </div>




  </body>

</html>