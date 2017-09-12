<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>机构列表</title>
		<!-- Bootstrap Core CSS -->
		<link href="<%=path %>/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!-- MetisMenu CSS -->
		<link href="<%=path %>/css/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
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
		<!-- Custom Theme JavaScript -->
		<script src="<%=path %>/css/dist/js/sb-admin-2.js">
		</script>
		
		<script type="text/javascript" src="<%=path %>/js/ztree/jquery.ztree.all-3.5.js"></script>
		<script type="text/javascript" src="<%=path %>/js/ztree/jquery.ztree.excheck-3.5.js" ></script>
		<script type="text/javascript" src="<%=path %>/js/ztree/jquery.ztree.exedit-3.5.js" ></script>
		
		<script type="text/javascript">
		var setting = {
		  
			async: {
				enable: true,
				url:"/organization/getOrgNodes.do",
				autoParam:["id", "name=n", "level=lv"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
				dataFilter: filter
			},
			view: {expandSpeed:"",
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeRemove: beforeRemove,
				beforeRename: beforeRename
			}
		};

		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}		
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				return false;
			}
			return true;
		}

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.id
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove();
		};

		$(document).ready(function(){
		  console.log(request.getContextPath());
			$.fn.zTree.init($("#treeDemo"), setting);
		});
		
		
		</script>

	</head>

	<body>
		<div id="wrapper">
			<!-- 引入我们的头部文件 -->
			<%@ include file="../navbar.jsp" %>
			<div id="page-wrapper">
				<div class="panel panel-default">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>