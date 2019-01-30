<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/table.css">
	<link rel="stylesheet" href="./css/form.css">
	<title>宛先情報入力画面</title>
</head>
<body>
	<s:include value="header.jsp" />

	<div id="contents">
		<h1>宛先情報入力画面</h1>

		<!-- エラーメッセージがある場合は表示する -->
		<s:if test="!familyNameErrorMessageList.isEmpty()">
			<div class="error">
			<div class="error-message">
				<s:iterator value="familyNameErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
			</div>
		</s:if>
		<s:if test="!firstNameErrorMessageList.isEmpty()">
			<div class="error">
			<div class="error-message">
				<s:iterator value="firstNameErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
			</div>
		</s:if>
		<s:if test="!famimyNameKanaErrorMessageList.isEmpty()">
			<div class="error">
			<div class="error-message">
				<s:iterator value="famimyNameKanaErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
			</div>
		</s:if>
		<s:if test="!firstNameKanaErrorMessageList.isEmpty()">
			<div class="error">
			<div class="error-message">
				<s:iterator value="firstNameKanaErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
			</div>
		</s:if>
		<s:if test="!userAddressErrorMessageList.isEmpty()">
			<div class="error">
			<div class="error-message">
				<s:iterator value="userAddressErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
			</div>
		</s:if>
		<s:if test="!telNumberErrorMessageList.isEmpty()">
			<div class="error">
			<div class="error-message">
				<s:iterator value="telNumberErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
			</div>
		</s:if>
		<s:if test="!emailErrorMessageList.isEmpty()">
			<div class="error">
			<div class="error-message">
				<s:iterator value="emailErrorMessageList">
					<s:property /><br>
				</s:iterator>
			</div>
			</div>
		</s:if>

		<!-- 宛先情報の入力フォーム -->
		<s:form action="CreateDestinationConfirmAction">
			<table class="vertical-list-table">
				<tr>
					<th>姓</th>
					<td><div class="txt-box"><s:textfield name="familyName" placeholder="姓" class="form-txt" /></div></td>
				</tr>
				<tr>
					<th>名</th>
					<td><div class="txt-box"><s:textfield name="firstName" placeholder="名" class="form-txt" /></div></td>
				</tr>
				<tr>
					<th>姓ふりがな</th>
					<td><div class="txt-box"><s:textfield name="familyNameKana" placeholder="姓ふりがな" class="form-txt" /></div></td>
				</tr>
				<tr>
					<th>名ふりがな</th>
					<td><div class="txt-box"><s:textfield name="firstNameKana" placeholder="名ふりがな" class="form-txt" /></div></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><div class="txt-box"><s:textfield name="userAddress" placeholder="住所" class="form-txt" /></div></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><div class="txt-box"><s:textfield name="telNumber" placeholder="電話番号" class="form-txt" /></div></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><div class="txt-box"><s:textfield name="email" placeholder="メールアドレス" class="form-txt" /></div></td>
				</tr>
			</table>

			<div class="submit_btn_box">
					<s:submit value="確認" class="submit_btn" />
			</div>
		</s:form>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>