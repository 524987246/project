<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>用户信息管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/buz/buzCustomer/">用户信息列表</a></li>
		<shiro:hasPermission name="buz:buzCustomer:add">
			<li><a href="${ctx}/buz/buzCustomer/form">用户信息添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="buzCustomer"
		action="${ctx}/buz/buzCustomer/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>手机号：</label> <form:input path="phone"
					htmlEscape="false" maxlength="64" class="input-medium" /></li>
			<li><label>姓名：</label> <form:input path="name"
					htmlEscape="false" maxlength="200" class="input-medium" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>手机号</th>
				<th>职位</th>
				<th>邮箱</th>
				<th>创建者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="buzCustomer">
				<tr>
					<td><a href="${ctx}/buz/buzCustomer/form?id=${buzCustomer.id}">
							${buzCustomer.name} </a></td>
					<td>${buzCustomer.phone}</td>
					<td>${buzCustomer.position}</td>
					<td>${buzCustomer.email}</td>
					<td>${buzCustomer.createBy.name}</td>
					<td><fmt:formatDate value="${buzCustomer.updateDate}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${buzCustomer.remarks}</td>
					<td><shiro:hasPermission name="buz:buzCustomer:edit">
							<a href="${ctx}/buz/buzCustomer/form?id=${buzCustomer.id}">修改</a>
						</shiro:hasPermission> <shiro:hasPermission name="buz:buzCustomer:delete">
							<a href="${ctx}/buz/buzCustomer/delete?id=${buzCustomer.id}"
								onclick="return confirmx('确认要删除该用户信息吗？', this.href)">删除</a>
						</shiro:hasPermission></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>