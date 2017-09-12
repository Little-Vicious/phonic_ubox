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
  </head>

  <body>
    <div id="wrapper">
      <!-- 引入我们的头部文件 -->
      <%@ include file="../../navbar.jsp"%>
      <div id="page-wrapper">
        <div class="panel panel-default">
          <form action="${pageContext.request.contextPath }/batchCallOut/nextCallOut.action" method="post">
            <input type="hidden" name="batchNo" id="batchNo" value="${batchcalloutCustom.batchNo }">
            <input type="hidden" name="uboxhdl" id="uboxhdl" value="">
            <input type="hidden" name="callNo" id="callNo" value="${callOutCustom.callNo }">
            <input type="hidden" name="recFlag" id="recFlag">
            <div class="panel panel-info">
              <div class="panel-heading">外呼群组：${ batchcalloutCustom.projectName }</div>
            </div>
            <div class="panel-body">
              <table id="dataTable" width="100%">
                <tr>
                  <td align="right">默认活动量类型：</td>
                  <td>
                    <select class="form-control">
                      <option>---请选择---</option>
                    </select>
                  </td>
                  <td align="right">开始时间：</td>
                  <td id="starttimeDiv">
                    <input type="hidden" id="starttime" name="starttime" value="${callOutCustom.startTime }" class="form-control">
                  </td>
                  <td align="right">状态:</td>
                  <td>${callOutCustom.calloutStatus}</td>
                </tr>
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
                    <i class="fa fa-play">播放</i>
                  </button>
                    <button id="callBtn" type="button" class="btn btn-primary" onclick="return callOut(this);">
                    <i class="fa fa-phone">呼叫</i>
                  </button>
                    <button id="nextBtn" type="button" class="btn btn-primary" onclick="nextCall();">
                    <i class="fa fa-step-forward">下一个</i>
                  </button>
                  </td>
                </tr>
              </table>
            </div>
            <div style="display: none;">
              <a id="next" href="${pageContext.request.contextPath }/batchCallOut/nextCallOut.do?batch_id=${ batchcalloutCustom.batchNo }&call_id=${callOutCustom.callNo}">
                <i class="fa fa-edit fa-fw"></i> 下一个
              </a>
              <a id="effeive" href="${pageContext.request.contextPath }/batchCallOut/effeiveCallOut.action?batch_id=${ batchcalloutCustom.batchNo }&call_id=${callOutCustom.callNo}">
                <i class="fa fa-edit fa-fw"></i> 生效
              </a>
            </div>
          </form>
        </div>
      </div>

    </div>


<style>
    #pop{width:300px;height:400px;border:solid 1px #000;position:fixed;left:50%;top:50%;margin-left:-150px;margin-top:-200px;border:solid 1px #000;border-radius:5px;background:#fff;display:none;z-index:22}
    #lightbox{width:100%;height:100%;position:fixed;top:0;left:0;background:#000;filter:alpha(opacity=50);opacity:.5;display:none}
</style>
<div id="lightbox"></div>
<div id="pop"><form>
    <table width="100%" border="0" cellpadding="5" cellspacing="5">
        <tr><td colspan="2">修改用户</td></tr>
        <tr><td align="right">用户名：</td><td><input type="text" name="name" /></td></tr>
        <tr><td align="right">昵　称：</td><td><input type="text" name="nickname" /></td></tr>
        <tr><td align="right">年　龄：</td><td><input type="text" name="age" /></td></tr>
        <tr><td colspan="2" align="right"><input type="button" value="保存" />　<input type="button" value="关闭" onclick="PopLayer()" /> </td></tr>
    </table>
</form>
</div>
<script>
    var pop=document.getElementById('pop');
    popf=pop.getElementsByTagName('form')[0];
    lightbox=document.getElementById('lightbox');
    function PopLayer(obj) {
      console.log(obj);
        lightbox.style.display = pop.style.display = obj ? 'block' : 'none';
        if (obj) {//点击修改
            /*var tr = obj.parentNode.parentNode
            popf.name.value = tr.cells[0].innerHTML
            popf.nickname.value = tr.cells[1].innerHTML
            popf.age.value = tr.cells[2].innerHTML*/
        }
        return false
    }
</script>

  </body>

</html>