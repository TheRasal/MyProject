<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js "></script> 
<style type="text/css"> 

.search { 
font-family: arial; 
background-color: green; 
text-align: center; 
border-color: red; 
width: 400px; 
margin: auto; 
color: red; 
} 
.table{ 
border-collapse: collapse; 
border: 1px solid gray; 
margin: auto; 
margin-top: 20px; 
} 
</style> 
<script> 
$(document).ready(function () { 
$('#StartSearch').click(function(){ 
var SearchText = $('#SearchText').val(); 
if(SearchText.length > 0){ 
ajaxReuest(SearchText); 
} 
else{ 
alert("Введите название фильма"); 
} 
}); 

$('#ClearSearch').click(function(){ 
$('#SearchText').val(''); 
$('#results').html(''); 
}); 
}); 

function ajaxReuest(term){ 
$.ajax({ 
type: 'GET', 
url: 'http://www.omdbapi.com/ ', 
data: {'s': term, 'r' : 'json'}, 
success: function(data){ 
$.each(data.Search, function (keyFilm, valFilm) { 

var $filmTable=$('<table class="table" align="center"></table>'); 
$.each(valFilm, function(keyAttr, valAttr) 
{ 
var $filtAttrTr=$('<tr><td>' + keyAttr + '</td><td>' + valAttr + '</td></tr>'); 
$filmTable.append($filtAttrTr); 
}); 
$('#results').append($filmTable); 
}); 

} 
}); 
} 
</script> 
</head> 
<body> 
<div > 
<table class="search" border="1"> 
<tr> 
<td><h1 >Поиск фильмов</h1> 
</td> 
</tr> 
<tr> 
<td> 
<input type="text" placeholder="Ввеедите название фильма" id="SearchText"> 
</td> 
<td> 

<input type="submit" value="Поиск" id="StartSearch" > 
</td> 
<td> 
<input type="button" value="Сброс" id="ClearSearch" > 
</td> 
</tr> 
</table> 
</div> 
<div id="results"></div> 

</body> 
</html>