<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>用户信息管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		//$("#name").focus();
		$("#inputForm").validate({
			submitHandler : function(form) {
				loading('正在提交，请稍等...');
				form.submit();
			},
			errorContainer : "#messageBox",
			errorPlacement : function(error, element) {
				$("#messageBox").text("输入有误，请先更正。");
				if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
					error.appendTo(element.parent().parent());
				} else {
					error.insertAfter(element);
				}
			}
		});
	});
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/buz/buzCustomer/">用户信息列表</a></li>
		<li class="active"><a
			href="${ctx}/buz/buzCustomer/form?id=${buzCustomer.id}">用户信息${not empty buzCustomer.id?'修改':'添加'}
				<shiro:lacksPermission name="buz:buzCustomer:edit">查看</shiro:lacksPermission>
		</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="buzCustomer"
		action="${ctx}/buz/buzCustomer/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<input type="hidden" name="password" id="password">
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">手机号：</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="64"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="200"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码：</label>
			<div class="controls">
				<input id="password1" type="password" maxlength="100"
					class="input-xlarge" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码(重复输入)：</label>
			<div class="controls">
				<input id="password2" type="password" maxlength="100"
					class="input-xlarge">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">职位：</label>
			<div class="controls">
				<form:input path="position" htmlEscape="false" maxlength="64"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱：</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="64"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4"
					maxlength="255" class="input-xxlarge " />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="buz:buzCustomer:edit">
				<input id="btnSubmit" class="btn btn-primary" type="button"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
	<script type="text/javascript">
		$('#btnSubmit').click(function() {
			var flag = false;
			var id = $("#id").val();
			var password1 = $("#password1").val();
			var password2 = $("#password2").val();
			if (id == "") {
				//新增状态下 密码为必填项
				if (password1 == password2 && password1.length >= 6 && password1.length <= 18) {
					flag = true;
					$("#password").val(md5(password2));
				} else {
					alert("密码输入有误,请重新输入");
					return;
				}
			} else {
				flag = true;
				if (password1 != password2) {
					alert("两次密码输入");
					return;
				}
				if (password1.length < 6 || password1.length >= 19) {
					alert("密码长度不对");
					return;
				}
				if (password1 == password2 && password1.length >= 6 && password1.length <= 18) {
					$("#password").val(md5(password2));
				}
	
			}
			if (flag) {
				$("#inputForm").submit();
			}
	
		});
	</script>
</body>
</html>