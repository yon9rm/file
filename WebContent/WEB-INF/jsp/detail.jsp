<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="download">${map.ORIGINAL_FILE_NAME}</div>
<script src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	var idx = '${map.IDX}';
	$(document).ready(function(){
		$('#download').on('click', function(e){
			$(location).attr('href', 'http://localhost:8002/fileUtil/download?idx=' + idx);
		});
	});
	
</script>

</body>
</html>