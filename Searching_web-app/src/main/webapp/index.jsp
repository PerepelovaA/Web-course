<html>
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="js/search.js" charset="UTF-8"></script>
<body>
<h2>Hello World from Perepelova</h2>
<form method="post" action="${pageContext.request.contextPath}/searching">
    <input type="text" name="search_words" >
    <input type="submit" name="ok">
</form>
<div class="result">
   <textarea id="search_results"><%= session.getAttribute("listOfdocs")%></textarea>
</div>
</body>
</html>
