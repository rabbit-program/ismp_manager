<%@ page contentType="text/html;charset=UTF-8" %>
<script type="text/javascript" src="amq/amq.js"></script>
<script type="text/javascript">amq.uri='amq';</script>
<script type="text/javascript">
<!--
var messageHandler = 
{
  rcvMessage: function(message) 
  {
	//alert("message is : "+message)
    if (message != null) {
      //alert("get message "+message.textContent);
      alert("get message "+message.getAttribute("index"));
      alert("get message "+message.getAttribute("message"));
      
    }
  }
};

function myClose(){
	amq.removeListener('test','topic://TOOL.DEFAULT');
	alert("close page");
}

function portfolioPoll(first)
{
   if (first)
   {
     amq.addListener('test','topic://TOOL.DEFAULT',messageHandler.rcvMessage);
   }
}
alert("test");
amq.addPollHandler(portfolioPoll);

//-->
</script>
<html>

<body onUnload="myClose()">
<h2>Hello World!测试</h2>
</body>
</html>
