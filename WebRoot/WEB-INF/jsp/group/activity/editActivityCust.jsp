<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      修改码值类型信息
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
      <%@ include file="../../navbar.jsp" %>
      <div id="page-wrapper">
        <div class="panel panel-default">

          <form id="dataForm" action="${pageContext.request.contextPath }/activity/editCustSubmit.do" method="post">
            <input type="hidden" id="contextPath" name="contextPath" value="${pageContext.request.contextPath }">
            <input type="hidden" name="groupNo" value="${activitygroup.groupNo }">
            <div class="panel panel-info">
              <div class="panel-heading">
              添加活动量群组客户
              </div>
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover">
                <tr>
                  <td>
                    客户号
                  </td>
                  <td>
                  	<select id="custno" name="custNo" class="form-control">
                  		<option>请选择客户</option>
                  	</select>
                  </td>
                  <td>
                    客户名称
                  </td>
                  <td>
                  	
                    <input id="custname" type="text" name="custName" value="${activitygroup.custName }" class="form-control">
                  </td>
                </tr>
                
                <tr>
                  <td>
                    活动量名称
                  </td>
                  <td>
                    <input id="activityname" type="text" name="activityName" value="${activitygroup.activityName }" class="form-control">
                  </td>
                  <td>
                    活动量类型
                  </td>
                  <td>
                  	<select id="codeactivityType" name="activitytype" class="form-control">
                  	</select>
                  </td>
                </tr>
                
                <tr>
                  <td>
                    接触阶段
                  </td>
                  <td>
                  	<select id="codeconStep" name="contactStep" class="form-control">
                  	</select>
                  </td>
                  <td>
                    数据来源
                  </td>
                  <td>
                  	<select id="codedataSrc" name="sourceChannels" class="form-control">
                  	</select>
                  </td>
                </tr>
                
                <tr>
                  <td>
                    创建人
                  </td>
                  <td>
                    <input type="text" name="creater" value="${activitygroup.creater }" class="form-control">
                  </td>
                  <td>
                    备注
                  </td>
                  <td>
                    <textarea name="comments" value="${activitygroup.comments }" class="form-control" rows="3"></textarea>
                  </td>
                </tr>
                
                <tr>
                  <td colspan="4" align="center">
                    <input type="submit" class="btn btn-primary" />
                  </td>
                </tr>
              </table>
            </div>
            
            <script type="text/javascript" >
      	$(document).ready(function() {
      		var contpath = $("#contextPath").val();
      		$.ajax({
    			url : contpath+"/activity/getInitCode.do",
    			type : "POST",
    			data : {},
    			dataType : "json",
    			success : function(msg) {
    				var str = JSON.stringify(msg);
    				var obj = eval('('+str+')');
    				var codeTypes = obj.codeTypes;
    				var customers = obj.customers;
    				
    				for(var i = 0;i<codeTypes.length;++i){
    				  var codeType = codeTypes[i];
    				  var typeCode = codeType.typeCode;
              var select = $("#code"+typeCode);
              var listCodeInfo = codeType.listCodeInfo;
    					for(var j = 0;j<listCodeInfo.length;++j){
    					  var codeinfo = listCodeInfo[j];
                codevalue = codeinfo.codeValue;
                codename = codeinfo.codeName;
    						var option;
    						if(j == 0){
    							option = "<option value="+codevalue+" selected='true'>"+codename+"</option>";
    						}else {
    							option = "<option value="+codevalue+">"+codename+"</option>";
							}
    						select.append(option);
    					}
    				}
    				
    				var select = $("#custno");
    				for(var i = 0;i<customers.length;++i){
    					var custno = customers[i].custNo;
    					var custname=customers[i].custName;
    					var option = "<option value="+custno+">"+custname+"</option>";
    					select.append(option);
    				}
    				
    				select.change(function (){
    					var selectText = select.find("option:selected").text();
    					$("#custname").val(selectText);
    				});
    				
    			},
    			error : function(er) {
    				//console.log(JSON.stringify(er));
    			}
    		});
      		
      	});
      	
      </script>
      
          </form>
        </div>
      </div>
      
    </div>
  </body>

</html>