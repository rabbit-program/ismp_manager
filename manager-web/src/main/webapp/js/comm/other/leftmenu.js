// JavaScript Document
fun1 = function(element)
{
   for(var i = 0; i < document.getElementById("SearchT").childNodes.length; i ++)
{
document.getElementById("SearchT").childNodes[i].className = "li";
}
element.className = "ok";
} 