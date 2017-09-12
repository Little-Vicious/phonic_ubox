<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      修改提醒群组客户信息
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

          <form id="dataForm" action="${pageContext.request.contextPath }/notice/editNoticeCustSubmit.do" method="post">
            <input type="hidden" id="contextPath" name="contextPath" value="${pageContext.request.contextPath }">
            <input type="hidden" name="groupNo" value="${noticeGroup.groupNo }">
            <div class="panel panel-info">
              <div class="panel-heading">
              添加提醒群组客户
              </div>
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover">
                <tr>
                  <td>
                    客户号
                  </td>
                  <td>
                  	<select id="custNo" name="custNo" class="form-control">
                  		<option>请选择客户</option>
                  	</select>
                  </td>
                  <td>
                    客户名称
                  </td>
                  <td>
                  	
                    <input id="custName" type="text" name="custName" value="${noticeGroup.custName }" class="form-control">
                  </td>
                </tr>
                
                <tr>
                  <td>
                    提醒名称
                  </td>
                  <td>
                    <input id="noticeName" type="text" name="noticeName" value="${noticeGroup.noticeName }" class="form-control">
                  </td>
                  <td>
                    提醒类型
                  </td>
                  <td>
                  	<select id="codenoticeType" name="noticeType" class="form-control">
                  	</select>
                  </td>
                </tr>
                
                <tr>
                  <td>
                    跟进状态
                  </td>
                  <td>
                  	<select id="codefollowStatus" name="followStatus" class="form-control">
                  	</select>
                  </td>
                  <td>
                  </td>
                  <td>
                  </td>
                </tr>
                
                <tr>
                <td>
                    客户群
                  </td>
                  <td>
                    <input id="custGroup" type="text" name="custGroup" value="${noticeGroup.custGroup }" class="form-control">
                  </td>
                  <td>
                    联系方式
                  </td>
                  <td>
                    <input id="custNumber" type="text" name="custNumber" value="${noticeGroup.custNumber }" class="form-control">
                  </td>
                </tr>
                
                <tr>
                  <td>
                    提醒消息说明
                  </td>
                  <td>
                    <textarea name="noticeState" value="${noticeGroup.noticeState }" class="form-control" rows="3"></textarea>
                  </td>
                  <td>
                    备注
                  </td>
                  <td>
                    <textarea name="comments" value="${noticeGroup.comments }" class="form-control" rows="3"></textarea>
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
    			url : contpath+"/groupCommon/getInitCode.do",
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
    				
    				var select = $("#custNo");
    				for(var i = 0;i<customers.length;++i){
    					var custNo = customers[i].custNo;
    					var mainNumber = customers[i].mainNumber;
    					var custName=customers[i].custName;
    					var optValue = custNo+','+mainNumber;
    					var option = "<option value="+optValue+">"+custName+"</option>";
    					select.append(option);
    				}
    				
    				select.change(function (){
    					var selectText = select.find("option:selected").text();
    					var selectValue =select.find("option:selected").val();
    					var arr = selectValue.split(',');
    					$("#custName").val(selectText);
    					$("#custNumber").val(arr[1]);
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