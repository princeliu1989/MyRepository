<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<script type="text/javascript">
	i = 1;
	j = 1;
	$(document).ready(function(){
		$("#btn_add").click(function(){
			document.getElementById("newUpload").innerHTML+='<div id="div_'+j+'"><input  name="file_'+j+'" type="file"  /><input type="button" value="删除"  onclick="del('+j+')"/></div>';
			  j = j + 1;
		});
	});

	function del(o){
		 document.getElementById("newUpload").removeChild(document.getElementById("div_"+o));
	}

</script>
</head>
<body>
 	<h1>springMVC上传文件</h1> 
 	<form name="userForm" action="/booksys/file/upload" enctype="multipart/form-data" method="post">
 		<div id="newUpload">
			<input type="file" name="file">
		</div>
		<input type="button" id="btn_add" value="增加一行" >
		<input type="submit" value="上传" >
 	</form> 
</body>
</html>