(function(){

	if(window.member!=null){
		throw new Error("window.member已经存在");
	}else{
		member = {
			isPresent:true,
			present:null,

			addButtonListener:function(){
				this.addAdminBarListener();
				this.addCategoryListener();
				this.fuzzyMatch();
				this.recordCategory();
			},
			//搜索框搜索类别显示与隐藏
			addCategoryListener:function(){
				$(".search_rule").mouseenter(function(){
					
					$(".category ul").show();
					
					$(".search_ajax").mouseenter(function(){
						
						$(".category ul").hide();
						
					});
					
					$(".category ul").mouseleave(function(){
						
						$(".category ul").hide();
						
					});
					
				});
			},
			//记录搜索种类
			recordCategory:function(){
				
				
				var that  =this;
				
				$(".category ul li a").click(function(ev){
					
					ev.preventDefault();
					console.log($(this).html());
					that.searchCategory = $(this).html();
					$(".search_rule").html($(this).html());
					$(".category ul").hide();
					
				});
			},
			addAdminBarListener:function(){
		
					$(".manage").mouseenter(function(){
				
						var ul = this.parentNode.getElementsByTagName('ul')[0];
				
						$(ul).show();
				
						$(this).mouseleave(function(){
						
							$(ul).hide();
						
							$(ul).mouseenter(function(){
							
								$(this).show();
							
								$(this).mouseleave(function(){
								
									$(this).hide();
								
								});
							
							});
						
						});
				
					});
			},
			//模糊匹配
			fuzzyMatch:function(){
				
				var that = this;
				
				$("#search_bar").change(function(){
					
					console.log("模糊匹配");
					if($(this).val()=="")
						return;
					$.ajax({
						
						type:"post",
						url:"",
						async:true,
						data:{
							category:that.searchCategory,
							text:$(this).val()
						},
						dataType:"json",
						success:function(data){
							var arr = eval("("+data+")");
							
							if(arr instanceof Array){
								
								
								for(var i=0;i<arr.length;i++){
									
									var li = document.createElement("li");
									var a = document.createElement("a");
									a.innerHTML = arr[i].title;
									a.href=arr[i].src;
									li.appendChild(a);
									
									$("#search_result").append(li);
								}
								
							}else{
								throw new Error("返回的而不是一个数组");
							}
							
						}
						
					});
					
					
				});	
			},

			_generateInput:function(actionInfo,inputArr,successFunc){
				var that =  this;
				$("#"+actionInfo.actionName+" ."+actionInfo.actionClass).click(function(e){
					e.preventDefault();

					if(that.isPresent){
						that.present = $("#content").detach();

					}else{
						$("#content").remove();
					}

					var content = $("<div>",{
						id:"content"
					});

					$("#main_block header").html(actionInfo.header+"：").after(content);

					for(var i=0;i<inputArr.length;i++){
						$("#content").append($("<input>",inputArr[i]));
					}

					var submit = $("<a>",{
						href:"#",
						"class":"submit",
						click:function(e){
							var isOut = false;
							var arr= [];
							e.preventDefault();
							$("#content input").each(function(index,ele){
								if(ele.value==""){
									alert("请输入完整");
									isOut = true;
									return false;
								}
								arr.push(ele.name+"="+ele.value);
								
							});
							if(isOut){
								return;
							}
							var dataList = arr.join("&");
							$.ajax({
								type:"post",
								url:actionInfo.url,
								async:true,
								data:dataList,
								dataType:"json",
								success:function(data){
									if(data.text=="failed"){
										alert(actionInfo.header+"失败");
										$("#content input").each(function(index,ele){
											ele.val("");
										});									
									}else{
										successFunc(data);
									}
								},
							});
							
						},
					}).text("提交");
					var cancel = $("<a>",{
						href:"#",
						"class":"cancel",
						click:function(e){
							e.preventDefault();
							
							$("#content").remove();
							$("#main_block header").after(that.present).text("");
						}
					}).text("取消");

					$("#content").append(submit)
						.append(cancel);

					that.isPresent = false;

				});
			},

			columnAction:function(){
				this.addColumn();
				// this.deleteColumn();
				this.queryColumn();
			},
			addColumn:function(){
				var that = this;
				$("#columnAction .add").click(function(e){
					e.preventDefault();

					if(that.isPresent){
						that.present = $("#content").detach();

					}else{
						$("#content").remove();
					}

					var content = $("<div>",{
						id:"content"
					});

					
					$("#main_block header").html("增加栏目：").after(content);

					var name = $("<input>",{"name":"name","type":"text","placeholder":"name"});
					var institution = $("<input>",{"name":"institute","type":"text","placeholder":"institution"});
					var description = $("<input>",{"name":"column.description","type":"text","placeholder":"description"});
					var icon = $("<input>",{"name":"file","type":"file","placeholder":"icon"});
					var keyword = $("<input>",{"name":"keyword","type":"text","placeholder":"keyword"});

					var submit = $("<a>",{
						href:"#",
						"class":"submit",
						click:function(e){
							var isOut = false;
							var formData = new FormData();
							e.preventDefault();
							$("#content input").each(function(index,ele){
								var i=0;
								if($(ele).attr("type")!="file"){
									
									console.log("input"+(i++));
									if(ele.value==""){
										alert("请输入完整");
										
										isOut = true;
										return false;
									}
									formData.append(ele.name,ele.value);
									
								}else{
									if(ele.files.length==0){
										alert("请输入完整");
										isOut = true;
										return false;
									}
									console.log(ele.name);
									formData.append(ele.name,ele.files[0]);

								}
								
								
							});
							alert("pass");
							if(isOut){
								return;
							}
							$.ajax({
								type:"post",
								url:"columnAction!add",
								async:true,
								data:formData,
								dataType:"json",
								processData: false,
								contentType:false,
								success:function(data){
									if(data.text!="success"){
										alert("添加栏目失败");
										$("#content input").each(function(index,ele){
											ele.val("");
										});									
									}else{
										alert("添加栏目成功");
										$("#content input").each(function(index,ele){
											ele.val("");
										});	
									}
								},
							});
							
						},
					}).text("提交");
					var cancel = $("<a>",{
						href:"#",
						"class":"cancel",
						click:function(e){
							e.preventDefault();
							
							$("#content").remove();
							$("#main_block header").after(that.present).text("");
						}
					}).text("取消");

					
					$("#content").append(name)
						.append(institution)
						.append(description)
						.append(keyword)
						.append(icon)
						.append(submit)
						.append(cancel);

					this.isPresent = false;	
				});				
			},
			// deleteColumn:function(){

			// 	var that = this;
			// 	$("#columnAction .delete").click(function(e){
			// 		e.preventDefault();

			// 		if(that.isPresent){
			// 			that.present = $("#content").detach();

			// 		}else{
			// 			$("#content").remove();
			// 		}

			// 		var content = $("<div>",{
			// 			id:"content"
			// 		});

					
			// 		$("#main_block header").html("删除栏目：").after(content);

			// 		var id = $("<input>",{"name":"id","type":"text","placeholder":"id"});
					
			// 		var submit = $("<a>",{
			// 			href:"#",
			// 			"class":"submit",
			// 			click:function(e){
			// 				var isOut = false;
			// 				var arr= [];
			// 				e.preventDefault();
			// 				$("#content input").each(function(index,ele){
			// 					if(ele.value==""){
			// 						alert("请输入完整");
			// 						isOut = true;
			// 						return false;
			// 					}
			// 					arr.push(ele.name+"="+ele.value);
								
			// 				});
			// 				if(isOut){
			// 					return;
			// 				}
			// 				var dataList = arr.join("&");
			// 				$.ajax({
			// 					type:"post",
			// 					url:"",
			// 					async:true,
			// 					data:dataList,
			// 					dataType:"json",
			// 					success:function(data){
			// 						if(data.text!="success"){
			// 							alert("删除栏目失败");
			// 							$("#content input").each(function(index,ele){
			// 								ele.val("");
			// 							});									
			// 						}else{
			// 							alert("删除栏目成功");
			// 							$("#content input").each(function(index,ele){
			// 								ele.val("");
			// 							});	
			// 						}
			// 					},
			// 				});
							
			// 			},
			// 		}).text("提交");
			// 		var cancel = $("<a>",{
			// 			href:"#",
			// 			"class":"cancel",
			// 			click:function(e){
			// 				e.preventDefault();
							
			// 				$("#content").remove();
			// 				$("#main_block header").after(that.present).text("");
			// 			}
			// 		}).text("取消");

					
			// 		$("#content").append(id)
			// 			.append(submit)
			// 			.append(cancel);

			// 		this.isPresent = false;	
			// 	});
			// },
			queryColumn:function(){
				var that = this;
				$("#columnAction .query").click(function(e){
					e.preventDefault();

					if(that.isPresent){
						that.present = $("#content").detach();

					}else{
						$("#content").remove();
					}

					var content = $("<div>",{
						id:"content"
					});

					
					$("#main_block header").html("查询栏目：").after(content);

					var id = $("<input>",{"name":"id","type":"text","placeholder":"id"});
					
					var submit = $("<a>",{
						href:"#",
						"class":"submit",
						click:function(e){
							var isOut = false;
							var formData = new FormData();
							e.preventDefault();
							$("#content input").each(function(index,ele){
								if(ele.value==""){
									alert("请输入完整");
									isOut = true;
									return false;
								}
								formData.append(ele.name,ele.value);
								
							});
							if(isOut){
								return;
							}

							$.ajax({
								type:"post",
								url:"columnAction!search",
								async:true,
								data:formData,
								dataType:"json",
								success:function(data){
									if(data.text=="failed"){
										alert("查询栏目失败");
										$("#content input").each(function(index,ele){
											ele.val("");
										});									
									}else{
										$("#content").empty();

										if(data instanceof Array){
											
											if(data.length == 0){
												
												$("#content").html("您查询的内容为空");
												
											}else{
												
												var ul = $("<ul>");
												
												for(var i=0;i<data.length;i++){
													var article = $("<li>");

													(function(i){
													article.append($("<h2>").append($("<span>",{
														text:data[i].name
													})).append($("<img>",{
														src:data[i].icon
													})))
													.append($("<p>").append($("<span>",{
														text:data[i].publisher
													})).append($("<span>",{
														text:data[i].publishtime
													})))
													.append($("<p>",{
														text:data[i].description
													})
													.append($("<a>",{
														text:"删除",
														click:function(e){
															e.preventDefault();
															var that = this;
															(function(i){
																$.ajax({
																	type:"post",
																	url:"",
																	async:true,
																	data:{"id":data[i].id},
																	dataType:"json",
																	success:function(data){
																		if(data.text=="success"){
																			
																			
																			$(that).parent().remove();
																			
																		}else{
																			
																			alert("删除失败");
																			
																		}
																	}
																});
															})(i)
															
														}
													}))
													.append($("<a>",{
														text:"修改",
														click:function(e){
															e.preventDefault();
															
															var that = this;
																
																var display =null;
																var parent =$(that).parent();
																
																var name = $("<input>",{"name":"name","type":"text","placeholder":"name"}).val(data[i].name);
																var institution = $("<input>",{"name":"institute","type":"text","placeholder":"institution"}).val(data[i].institution);
																var description = $("<input>",{"name":"column.description","type":"text","placeholder":"description"}).val(data[i].description);
																var img = $("<img>",{
																	src:data[i].icon
																});
																var icon = $("<input>",{"name":"file","type":"file","placeholder":"icon"});
																var keyword = $("<input>",{"name":"keyword","type":"text","placeholder":"keyword"}).val(data[i].keyword);

																var submit = $("<a>",{
																	href:"#",
																	"class":"submit",
																	click:function(e){
																		var isOut = false;
																		var formData = new FormData();
																		e.preventDefault();
																		$(that).parent().children("input").each(function(index,ele){
																			var i=0;
																			if($(ele).attr("type")!="file"){
																				
																				if(ele.value==""){
																					alert("请输入完整");
																					
																					isOut = true;
																					return false;
																				}
																				formData.append(ele.name,ele.value);
																				
																			}else{
																				if(ele.files.length==0){
																					alert("请输入完整");
																					isOut = true;
																					return false;
																				}
																				console.log(ele.name);
																				formData.append(ele.name,ele.files[0]);

																			}
																			
																			
																		});
																
																		if(isOut){
																			return;
																		}
																		$.ajax({
																			type:"post",
																			url:"",
																			async:true,
																			data:formData,
																			dataType:"json",
																			processData: false,
																			success:function(data){
																				if(data.text!="success"){
																					alert("修改栏目失败");
																					$("#content input").each(function(index,ele){
																						ele.val("");
																					});									
																				}else{
																					alert("修改栏目成功");
																					$("#content input").each(function(index,ele){
																						ele.val("");
																					});	
																				}
																			},
																		});
																		
																	},
																}).text("提交");
																var cancel = $("<a>",{
																	href:"#",
																	"class":"cancel",
																	click:function(e){
																		e.preventDefault();
																		
																		parent.empty().append(display);
																		
																	}
																}).text("取消");

																display = parent.children().detach();

																parent.append(name)
																	.append(institution)
																	.append(description)
																	.append(keyword)
																	.append(img)
																	.append(icon)
																	.append(submit)
																	.append(cancel);
	
															
														}
													}))).appendTo(ul);

													})(i);
													

													
												}
												
												ul.appendTo($("#content").empty());
												
											}
											
										}else{
											alert("数据格式不对");
										}
										
										//to display the data to #content
										//...
									}
								},
							});
							
						},
					}).text("提交");
					var cancel = $("<a>",{
						href:"#",
						"class":"cancel",
						click:function(e){
							e.preventDefault();
							
							$("#content").remove();
							$("#main_block header").after(that.present).text("");
						}
					}).text("取消");

					
					$("#content").append(id)
						.append(submit)
						.append(cancel);

						this.isPresent = false;
				});
			},

			articleAction:function(){
				this.addArticle();
				this.deleteArticle();
				this.queryArticle();
				this.updateArticle();
			},
			addArticle:function(){
				this._generateInput({
					url:"",
					header:"增加文章",
					actionName:"articleAction",
					actionClass:"add"
				},[{
					name:"newsType",
					type:"text",
					placeholder:"newsType"
				},{
					name:"columnName",
					type:"text",
					placeholder:"columnName"
				},{
					name:"title",
					type:"text",
					placeholder:"title"
				},{
					name:"contentAbout",
					type:"text",
					placeholder:"contentAbout"
				},{
					name:"content",
					type:"textarea",
					placeholder:"content"
				}],function(data){
					alert("添加文章成功");
					$("#content input").val();
				});
			},
			deleteArticle:function(){
				this._generateInput({
					url:"",
					header:"删除文章",
					actionName:"articleAction",
					actionClass:"delete"
				},[{
					name:"id",
					type:"text",
					placeholder:"id"
				}],function(data){
					alert("删除文章成功");
					$("#content input").val("");	
				});
				},
			queryArticle:function(){
				this._generateInput({
					url:"",
					header:"查看文章",
					actionName:"articleAction",
					actionClass:"query"
				},[{
					name:"id",
					type:"text",
					placeholder:"id"
				}],function(data){
					var ul = $("<ul>");
					for(var i =0;i<data.length;i++){
						ul.append($("<li>")
							.append($("<span>")
								.append("<a>",{
									href:"#",
									text:data[i].title,
									click:function(e){
										e.preventDefault();
										$("#content")
											.empty()
											.append($("<h2><a>"+data[i].title+"</a></h2>"))
											.append($("<p><span>"
												+data[i].author
												+"</span><span>"
												+data[i].date
												+"</span></p>"))
											.append($("<p>")
												.text(data[i].content))
											.append($("<input>",{
												type:"textarea",
												name:"comment"
											}))
											.append($("<a>",{
												href:"#",
												text:"提交",
												click:function(e){
													e.preventDefault();
													$.ajax({
														type:"post",
														url:"",
														async:true,
														data:$(this).prev().val(),
														dataType:"json",
														success:function(data){
															alert(data.text);
															$(this).prev().val("");
														}
													});
												}
											}))
											.append("<a>",{
												href:"#",
												text:"取消",
												click:function(e){
													e.preventDefault();
													$("#content").remove();
													$("#main_block header").after(that.present).text("");
												}
											});
									}
								}))
							.append($("<span>")
								.text(data[i].author))
							.append($("<span>")
								.text(data[i].date)));
					}
				});
			},
			updateArticle:function(){
				this._generateInput({
					url:"",
					header:"修改文章",
					actionName:"articleAction",
					actionClass:"update"
				},[{
					name:"id",
					type:"text",
					placeholder:"id"
				}],function(data){
					
				});
			},

			caseAction:function(){
				this.addCase();
				this.queryCase();
				this.deleteCase();
			},
			addCase:function(){
				this._generateInput({
					url:"",
					header:"添加案例",
					actionName:"casesAction",
					actionClass:"add"
				},[{
					name:"resourcename",
					type:"text",
					placeholder:"资源名称"
				},{
					name:"resourcetype",
					type:"text",
					placeholder:"资源类型"
				},{
					name:"resourcesource",
					type:"text",
					placeholder:"资源来源"
				},{
					name:"description",
					type:"textarea",
					placeholder:"描述"
				},{
					name:"occurplace",
					type:"text",
					placeholder:"发生地点"
				},{
					name:"theinjuredname",
					type:"text",
					placeholder:"受伤人员"
				},{
					name:"enclosure",
					type:"file",
					placeholder:"附件"
				},{
					name:"occurtime",
					type:"time"
				},{
					name:"occurdate",
					type:"date"
				},{
					name:"degree",
					type:"number",
					placeholder:"事件等级"
				},{
					name:"copyrightholder",
					type:"text",
					placeholder:"版权所有人"
				},{
					name:"opendegree",
					type:"text",
					placeholder:"公开等级"
				},{
					name:"laber",
					type:"text",
					placeholder:"标签"
				},{
					name:"process",
					text:"textarea",
					placeholder:"事故过程"
				},{
					name:"cause",
					type:"textarea",
					placeholder:"事故原因"
				},{
					name:"handling",
					text:"textarea",
					placeholder:"事故处理"
				},{
					name:"accountability",
					text:"textarea",
					placeholder:"责任追究"
				},{
					name:"remedialmeasures",
					text:"textarea",
					placeholder:"善后措施"
				},{
					name:"improvement",
					type:"textarae",
					placeholder:"改进措施"
				}],function(data){
					alert("案例添加成功");
					$("#content input").val("");
				});
			},

			queryCase:function(){
				this._generateInput({
					url:"",
					header:"查询案例",
					actionName:"casesAction",
					actionClass:"query"
				},[{
					name:"id",
					type:"text",
					placeholder:"id"
				}],function(data){
					for(var i=0;i<data.length;i++){

					}
				});
			},

			deleteCase:function(){
				this._generateInput({
					url:"",
					header:"删除案例",
					actionName:"casesAction",
					actionClass:"delete"
				},[{
					name:"id",
					type:"text",
					placeholder:"id"
				}],function(data){
					alert("案例删除成功");
				});
			},

			resourceAction:function(){
				this.addResource();
				this.queryResource();
				this.deleteResource();
			},

			addResource:function(){
				this._generateInput({
					url:"",
					header:"增加资源",
					actionName:"resourceAction",
					actionClass:"add"
				},[{
					type:"text",
					name:"name",
					placeholder:"资源名称"
				},{
					type:"text",
					name:"type",
					placeholder:"资源类型"
				},{
					type:"number",
					name:"hotdegree",
					placeholder:"资源热度"
				},{

				}],function(data){
					if(data.text=="success"){
						alert("资源添加成功");
					}else{
						alert("资源添加失败");
					}
				});
			},
			queryResource:function(){
				$._generateInput({},[],function(data){
					if(data instanceof Array){
						for(var i=0;i<data.length;i++){
							
						}
					}
				});
			},
			deleteResource:function(){},


			knowledgeAction:function(){
				this.addKnowledge();
				this.deleteKnowledge();
				this.updateKnowledge();
				this.queryKnowledge();

			},

			addKnowledge:function(){},
			deleteKnowledge:function(){},
			updateKnowledge:function(){},
			queryKnowledge:function(){},

			configure:function(){
				this.addButtonListener();
				this.columnAction();
				this.articleAction();
				this.caseAction();
			}


		}

	}

})()

util.addLoad(member.configure.bind(member));

util.addLoad(function(){
	
	var multCol = new window.multColumn(800,200,3,'content');

			multCol.configure();

			window.onscroll = function(ev){
				ev = ev || window.event;

				if($("#content input")[0]!=null)
					return;

				if(window.innerHeight+document.body.scrollTop+200>document.body.scrollHeight){

					var arr = multCol.toLoad();

					multCol.toArrange(arr);

				}

			}
	
});

