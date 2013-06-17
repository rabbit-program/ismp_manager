					var diagnose = function(boxy) {
						alert("位置: " + boxy.getPosition() +
							  "\n大小: " + boxy.getSize() +
							  "\n内容区域大小: " + boxy.getContentSize() +
							  "\n中心点: " + boxy.getCenter());
					};
					$(function() {
					  Boxy.DEFAULTS.title = "标题";
					  // Diagnostics
					  $("#diagnostics").click(function() {
						  new Boxy("<div><a href='#nogo' onclick='diagnose(Boxy.get(this));'>显示诊断信息</a></div>");
						  return false;
					  });
					  
					  // Set content
					  var setContent = null;
					  $("#set-content-open").click(function() {
						  setContent = new Boxy(
							"<div style='background-color:red'>这里是显示的内容</div>", {
							  behaviours: function(c) {
								c.hover(function() {
								  $(this).css('backgroundColor', 'green');
								}, function() {
								  $(this).css('backgroundColor', 'pink');
								});
							  }
							}
						  );
						  return false;
					  });
					  $("#set-content").click(function() {
						  setContent.setContent("<div style='background-color:blue'>这里是新添加的显示内容</div>");
						  return false;
					  });
					  
					  // Callbacks
					  $("#after-hide").click(function() {
						  new Boxy("<div>测试内容</div>", {
							afterHide: function() {
							  alert("隐藏后回调");
							}
						  });
						  return false;
					  });	  
					  $("#before-unload").click(function() {
						  new Boxy("<div>测试内容</div>", {
							beforeUnload: function() {
							  alert("卸载前调用");
							},
							unloadOnHide: true
						  });
						  return false;
					  });  
					  $("#before-unload-no-auto-unload").click(function() {
						  new Boxy("<div>测试内容</div>", {
							beforeUnload: function() {
							  alert("这个不应该看见的");
							},
							unloadOnHide: false
						  });
						  return false;
					  });		  
					  $("#after-drop").click(function() {
						  new Boxy("<div>测试内容</div>", {
							afterDrop: function() {
							  alert("放下后: " + this.getPosition());
							},
							draggable: true
						  });
						  return false;
					  });	  
					  $("#after-show").click(function() {
						  new Boxy("<div>测试内容</div>", {
							afterShow: function() {
							  alert("显示后: " + this.getPosition());
							}
						  });
						  return false;
					  });
					  
					  // Z-index
					  var zIndex = null;
					  $("#z-index").click(function() {
						  zIndex = new Boxy(
							"<div>测试内容</div>", { clickToFront: true }
						  );
						  return false;
					  });	  
					  $("#z-index-latest").click(function() {
						  zIndex.toTop();
						  return false;
					  });
					  
					  // Modals
					  function newModal() {
						  new Boxy("<div><a href='#'>打开一个堆叠的模态</a> | <a href='#' onclick='alert(Boxy.isModalVisible()); return false;'>测试模态对话框</a></div>", {
							modal: true, behaviours: function(c) {
							  c.find("a:first").click(function() {
								newModal();
							  });
							}
						  });
					  };
					  
					  $("#modal").click(newModal);
					  
					  // No-show  
					  var noShow;
					  $("#no-show").click(function() {
						  noShow = new Boxy("<div>显示的内容</div>", {show: false});
						  return false;
					  });					  
					  $("#no-show-now").click(function() {
						  noShow.show();
						  return false;
					  });
					  
					  // Actuator		  
					  $("#actuator").click(function() {
						  var ele = $("#actuator-toggle")[0];
						  new Boxy("<div>测试内容</div>", {actuator: ele, show: false});
						  return false;
					  });
					  $("#actuator-toggle").click(function() {
						  Boxy.linkedTo(this).toggle();
						  return false;
					  });	  
					});
