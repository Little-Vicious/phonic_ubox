<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      保存活动量群组
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
      
      
  </head>

  <body>
    <div id="wrapper">
      <!-- 引入我们的头部文件 -->
      <%@ include file="../navbar.jsp" %>
      <div id="page-wrapper">
        <div class="panel panel-default">

          <form id="dataForm" method="post">
            <input type="hidden" id="contextPath" name="contextPath" value="${pageContext.request.contextPath }">
            <input type="hidden" name="groupNos" value="${groupNos}">
            <input type="hidden" id="batchType" name="batchType" value="${batchType}">
            <input type="hidden" name="projectname" id="projectname">
            <div class="panel panel-info">
              <div class="panel-heading">
             呼叫管理群组创建
              <div style="float: right">
                <a href="${pageContext.request.contextPath }/activity/listActivityGroup.do">
                  <i class="fa fa-history fa-fw"></i>返回
                </a>
              </div>
              </div>
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover">
                <tr>
                  <td>
                    群组名称
                  </td>
                  <td>
                  	<select id="batchid" name="batchid" class="form-control">
                  	</select>
                  </td>
                  <td>
                    <button type="submit" class="btn btn-link" onclick="return customizeGroup();">自定义群组</button>
                  </td>
                </tr>
                
                <tr>
                  <td colspan="4" align="center">
                    <button type="submit" class="btn btn-primary" onclick="return saveGroup();">
                      <i class="fa fa-save">保存</i>
                    </button>
                    <button type="reset" class="btn btn-warning" >
                      <i class="fa fa-repeat">重置</i>
                    </button>
                    <button type="button" class="btn btn-danger" >
                      <i class="fa fa-times">取消</i>
                    </button>
                  </td>
                </tr>
              </table>
            </div>
            
            <script type="text/javascript" >
            var contpath;
      	$(document).ready(function() {
      		contpath = $("#contextPath").val();
      		var batchType = $("#batchType").val();
      		$.ajax({
    			url : contpath+"/batchCallOut/getBatchCallOutByBatchType.do",
    			type : "POST",
    			data : {"batchType":batchType},
    			dataType : "json",
    			success : function(msg) {
    				var str = JSON.stringify(msg);
    				console.log(str);
    				var obj = eval('('+str+')');
    				var batch = obj.batch;
    				
    				var select = $("#batchid");
    				for(var i = 0;i<batch.length;++i){
    					var batchNo = batch[i].batchNo;
    					var projectName = batch[i].projectName;
    					option = "<option value="+batchNo+">"+projectName+"</option>";
    					select.append(option);
    				}
    				
    				select.change(function (){
              var selectText = select.find("option:selected").text();
              $("#projectname").val(selectText);
            });
    				
    			},
    			error : function(er) {
    				//console.log(JSON.stringify(er));
    			}
    		});
      		
      	});
      	
      	//自定义群组
      	function customizeGroup(){
      	  var url = contpath + "/groupCommon/customizeGroup.do";
          $("#dataForm").attr("action", url);
          return true;
      	}
      	
      	//保存群组
      	function saveGroup(){
      	  var url = contpath + "/groupCommon/saveGroupSubmit.do";
      	  var batchidText = $("#batchid").find("option:selected").text();
          if(batchidText != ""){
            console.log(batchidText);
            $("#projectname").val(batchidText);
          }
          $("#dataForm").attr("action", url);
          return true;
      	}
      	
      </script>
      
          </form>
        </div>
      </div>
      
    </div>
  </body>

</html>