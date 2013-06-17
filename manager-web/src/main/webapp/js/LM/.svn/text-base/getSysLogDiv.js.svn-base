
function showAddDivBox(url,divName) {
		new Ajax.Request(url, {
			method :'post',
			parameters :' ',

			onSuccess : function(transport) {
				var readyState = transport.readyState;
				var elementById=document.getElementById(divName);
				if (readyState == 4) {//加载完成,
					if (transport.status == 200) {
						if (transport.responseText != "" && transport.responseText.length > 20) {
							elementById.innerHTML = transport.responseText;
						} else {
							elementById.innerHTML = "抱歉，装载数据失败。请重试!";
						}
					}
				}
			}
		});
	}

