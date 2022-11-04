<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한 줄 내용 수정</title>
</head>
<body>
	<hr>한 줄내용 수정<hr>
	<hr>
	<table boarder="1">
		<form action="modify">
			<tr>
				<th>글번호<th>
				<td><input type="text" name="mid" value="${mdto.mid }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>글쓴이<th>
				<td><input type="text" name="mwriter" value="${mdto.mwriter }"></td>
			</tr>
			<tr>
				<th>글내용<th>
				<td><input type="text" name="mcontent" value="${mdto.mcontent }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료">
					<input type="button" value="목록" onclick="javascript:window.location='list'">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>