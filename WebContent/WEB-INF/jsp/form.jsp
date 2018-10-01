<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form" name="form" enctype="multipart/form-data" method="post" action="upload">
        <input type="file" name="file">
        <input type="submit" value="regist">
    </form>
<!--     <button type="button" id="upload">업로드</button> -->

<script src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
// 	$(document).ready(function(){
// 		$('#upload').on('click', function(e){
// 			var form = $('#form');
// 			form.action = "/fileUtil/upload";
//             form.submit();
// 		});
// 	});
</script>
</body>
</html>