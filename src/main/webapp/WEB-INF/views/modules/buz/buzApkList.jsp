<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>apk信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/buz/buzApk/">apk信息列表</a></li>
		<shiro:hasPermission name="buz:buzApk:add"><li><a href="${ctx}/buz/buzApk/form">apk信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="buzApk" action="${ctx}/buz/buzApk/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>版本号：</label>
				<form:input path="edition" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>版本号</th>
				<th>名称</th>
				<th>类型</th>
				<th>创建者</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="buz:buzApk:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="buzApk">
			<tr>
				<td><a href="${ctx}/buz/buzApk/form?id=${buzApk.id}">
					${buzApk.edition}
				</a></td>
				<td>
					${buzApk.name}
				</td>
				<td>
					${fns:getDictLabel(buzApk.type, 'apk_type', '')}
				</td>
				<td>
					${buzApk.createBy.name}
				</td>
				<td>
					${buzApk.updateBy.name}
				</td>
				<td>
					<fmt:formatDate value="${buzApk.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${buzApk.remarks}
				</td>
				<shiro:hasPermission name="buz:buzApk:edit"><td>
    				<a href="${ctx}/buz/buzApk/form?id=${buzApk.id}">修改</a>
					<a href="${ctx}/buz/buzApk/delete?id=${buzApk.id}" onclick="return confirmx('确认要删除该apk信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>