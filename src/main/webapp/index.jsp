<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="upload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <button type="submit" >提交</button>
    </form>
</body>
</html>
