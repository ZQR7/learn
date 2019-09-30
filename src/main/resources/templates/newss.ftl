<html>
<head></head>
<body>
<table>
<#list newss as news>
<tr>
<td>${news.id}</td><td>${news.title}</td><td>${news.content}</td>
</tr>
</#list>
</table>
</body>
</html>