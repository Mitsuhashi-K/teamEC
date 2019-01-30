<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/table.css">
<title>宛先情報入力確認画面</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>
</head>
<body>

	<s:include value="header.jsp" />

	<div id="contents">

		<h1>宛先情報入力確認画面</h1>

		<s:form>
			<table class="vertical-list-table">
				<tr>
					<th>姓</th>
					<td>
						<div class="txt">
							<s:property value="familyName" />
						</div> <s:hidden name="familyName" value="%{familyName}" />
					</td>
				</tr>
				<tr>
					<th>名</th>
					<td>
						<div class="txt">
							<s:property value="firstName" />
						</div> <s:hidden name="firstName" value="%{firstName}" />
					</td>
				</tr>
				<tr>
					<th>姓ふりがな</th>
					<td>
						<div class="txt">
							<s:property value="familyNameKana" />
						</div> <s:hidden name="familyNameKana" value="%{familyNameKana}" />
					</td>
				</tr>
				<tr>
					<th>名ふりがな</th>
					<td>
						<div class="txt">
							<s:property value="firstNameKana" />
						</div> <s:hidden name="firstNameKana" value="%{firstNameKana}" />
					</td>
				</tr>
				<tr>
					<th>住所</th>
					<td>
						<div class="txt">
							<s:property value="userAddress" />
						</div> <s:hidden name="userAddress" value="%{userAddress}" />
					</td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td>
						<div class="txt">
							<s:property value="telNumber" />
						</div> <s:hidden name="telNumber" value="%{telNumber}" />
					</td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td>
						<div class="txt">
							<s:property value="email" />
						</div> <s:hidden name="email" value="%{email}" />
					</td>
				</tr>
			</table>

			<div class="submit_btn_box">
				<input type="button" class="submit_btn" value="登録"
					onclick="submitAction('CreateDestinationCompleteAction')" />
			</div>

			<input type="button" class="submit_btn" value="戻る"
				onclick="submitAction('CreateDestinationAction')" />

		</s:form>

	</div>

	<s:include value="footer.jsp" />

</body>
</html>