// JavaScript Document
fun1 = function(element)
{
   for(var i = 0; i < document.getElementById("banner").childNodes.length; i ++)
{
document.getElementById("banner").childNodes[i].className = "nor";
}
element.className = "act";
} 