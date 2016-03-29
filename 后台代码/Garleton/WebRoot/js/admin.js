(function(){
	
	if(window.start==null){
		
		window.start = {};
		
	}else{
		
		console.log("window.start is occupied");
	
	}
	
	start = {
		
		
		
		addButtonListener:function(){
		
			util.addLoad(this.addAdminBarListener);
			util.addLoad(this.addCategoryListener);
			util.addLoad(this.addCategoryListener);
			util.addLoad(this.fuzzyMatch);
			
			
		
		},
		
		addCategoryListener:function(){
			$(".search_rule").mouseenter(function(){
				
				$(".category ul").show();
				
				$(".category ul").mouseleave(function(){
					
					$(".category ul").hide();
					
				});
				
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
		
		
		addUserAction:function(){
			
			$("#userAction .query").click(this.queryUser);
			$("#userAction .delete").click(this.deleteUser);
			
		},
		
		addInstitutionAction:function(){
			
			
			$("#institutionAction .query").click(this.queryInstitution);
			$("#institutionAction .add").click(this.addInstitution);
			$("#institutionAction .delete").click(this.deleteInstitution);
			
		},
		
		addAuthorizeAction:function(){
			
			$("#authorizeAction .columnAuthorize").click(this.authorizeColumn);
			$("#authorizeAction .articleAuthorize").click(this.authorizeArticle);
			
		},
		
		authorizeColumn:function(ev){
			
			ev.preventDefault();
			
			$("#main_block header").html("");
			$("#content").empty();
			
			$("#main_block header").html("授权栏目管理：");
			
			var person = document.createElement("input");
			person.id="id";
			person.name="id";
			person.type="text";
			
			var submit = document.createElement("a");
			submit.href="";
			submit.innerHTML = "授权给他";
			
			util.addEvent(submit,"click",function(ev){
				
				ev.preventDefault();
				
				$.ajax({
					
					type:"post",
					async:true,
					url:"",
					data:{},
					dataType:"json",
					success:function(data){
						
						if(data!=null){
							
							alert(data);
							
						}
						
					}
					
				});
				
				
			});
			
			var cancel = document.createElement("a");
			cancel.href = "";
			cancel.innerHTML = "取消";
			
			util.addEvent(cancel,"click",function(ev){
				
				ev.preventDefault();
				
				$("#content").empty();
				
				$("#main_block header").html("");
				
			});
			
			$("#content").append(person).append(submit).append(cancel);
			
		},
		
		authorizeArticle:function(ev){
			
			ev.preventDefault();
			
			$("#main_block header").html("");
			$("#content").empty();
			
			$("#main_block header").html("授权文章管理：");
			
			var person = document.createElement("input");
			person.id="id";
			person.name="id";
			person.type="text";
			
			var submit = document.createElement("a");
			submit.href="";
			submit.innerHTML = "授权给他";
			
			util.addEvent(submit,"click",function(ev){
				
				ev.preventDefault();
				
				$.ajax({
					
					type:"post",
					async:true,
					url:"",
					data:{},
					dataType:"json",
					success:function(data){
						
						if(data!=null){
							
							alert(data);
							
						}
						
					}
					
				});
				
				
			});
			
			var cancel = document.createElement("a");
			cancel.href = "";
			cancel.innerHTML = "取消";
			
			util.addEvent(cancel,"click",function(ev){
				
				ev.preventDefault();
				
				$("#content").empty();
				
				$("#main_block header").html("");
				
			});
			
			$("#content").append(person).append(submit).append(cancel);
			
		},
		
		queryUser:function(ev){
			ev.preventDefault();
			
			$("#main_block header").html("");
			$("#content").empty();
			
			$("#main_block header").html("查看用户：");
			
			var input = document.createElement("input");
			input.type = "text";
			input.name = "name";
			input.id = "name";
			var submit = document.createElement("a");
			submit.href = "";
			submit.innerHTML = "提交";
			
			util.addEvent(submit,"click",function(ev){
				
				ev.preventDefault();
				$.ajax({
					
					type:"post",
					async:true,
					url:"userAction!search",
					dataType:"json",
					data:{name:$("#name").val()},
					success:function(data){
						alert(data);
					}
					
				});
				
				
				
				
			});
			
			var cancel = document.createElement("a");
			cancel.href = "";
			cancel.innerHTML = "取消";
			
			util.addEvent(cancel,"click",function(ev){
				
				ev.preventDefault();
				
				$("#content").empty();
				
				$("#main_block header").html("");
				
			});
			
			$("#content").append(input).append(submit).append(cancel);
			
			
			
		},
		deleteUser:function(ev){
			
			ev.preventDefault();
			
			$("#main_block header").html("");
			$("#content").empty();
			
			$("#main_block header").html("删除用户：");
			
			var input = document.createElement("input");
			input.type = "text";
			input.name = "name";
			input.id = "name";
			var submit = document.createElement("a");
			submit.href = "";
			submit.innerHTML = "提交";
			util.addEvent(submit,"click",function(ev){
				
				ev.preventDefault();
				$.ajax({
					
					type:"post",
					async:true,
					url:"userAction!del",
					dataType:"json",
					data:{name:$("#name").val()},
					success:function(data){
						alert(data);
					}
					
				});
				
				
			});
			
			var cancel = document.createElement("a");
			cancel.href = "";
			cancel.innerHTML = "取消";
			
			util.addEvent(cancel,"click",function(ev){
				
				ev.preventDefault();
				
				$("#content").empty();
				
				
				$("#main_block header").html("");
				
			});
			
			$("#content").append(input).append(submit).append(cancel);
			
			
		},
		
		queryInstitution:function(ev){
			ev.preventDefault();
			
			$("#main_block header").html("");
			$("#content").empty();
			
			$("#main_block header").html("查询机构：");
			
			var input = document.createElement("input");
			input.type = "text";
			input.name = "name";
			input.id = "name";
			var submit = document.createElement("a");
			submit.href = "";
			submit.innerHTML = "提交";
			util.addEvent(submit,"click",function(ev){
				
				ev.preventDefault();
				$.ajax({
					
					type:"post",
					async:true,
					url:"institutionAction!searchAll",
					dataType:"json",
					data:{name:$("#name").val()},
					success:function(data){
						alert(data);
					}
					
				});
				
				
			});
			
			var cancel = document.createElement("a");
			cancel.href = "";
			cancel.innerHTML = "取消";
			
			util.addEvent(cancel,"click",function(ev){
				
				ev.preventDefault();
				
				$("#content").empty();
				
				
				$("#main_block header").html("");
				
			});
			
			$("#content").append(input).append(submit).append(cancel);
			
			
		},
		
		
		addInstitution:function(ev){
			ev.preventDefault();
			
			$("#main_block header").html("");
			$("#content").empty();
			
			$("#main_block header").html("增加机构：");
			
			var form= document.createElement("form");
			form.method = "post";
			form.action = "institutionAction!add";
			form.id="institutionForm";
			
			var input = document.createElement("input");
			input.type = "text";
			input.name = "id";
			input.id = "id";
			input.placeholder = "id";
			form.appendChild(input);			
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "name";
			input.id = "name";
			input.placeholder = "name";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "type";
			input.id = "type";
			input.placeholder = "type";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "superior";
			input.id = "superior";
			input.placeholder = "superior";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "did";
			input.id = "did";
			input.placeholder = "did";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "level";
			input.id = "level";
			input.placeholder = "level";
			form.appendChild(input);
			
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "pic";
			input.id = "pic";
			input.placeholder = "pic";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "address";
			input.id = "address";
			input.placeholder = "address";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "postcode";
			input.id = "postcode";
			input.placeholder = "postcode";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "tel";
			input.id = "tel";
			input.placeholder = "tel";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "fax";
			input.id = "fax";
			input.placeholder = "fax";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "email";
			input.id = "email";
			input.placeholder = "email";
			form.appendChild(input);
			
			input = document.createElement("input");
			input.type = "text";
			input.name = "comment";
			input.id = "comment";
			input.placeholder = "comment";
			form.appendChild(input);
			
			
			
			var submit = document.createElement("a");
			submit.href = "";
			submit.innerHTML = "提交";
			
			
			
			util.addEvent(submit,"click",function(ev){
			
				function tranverseForm(formName){
			
					var aInput = document.querySelectorAll("#"+formName+" input");
					
					var str = "";
					
					for(var i=0;i<aInput.length;i++){
						
						str += aInput[i].name;
						str +=":";
						if(aInput[i].value == ""){
							str += "\"\",";
						}else{
							str += "\""+aInput[i].value +"\""+ ",";
						}
						
					}
					
					return "{"+str+"}";
					
				}
				
				ev.preventDefault();
				
				alert(tranverseForm("institutionForm"));
				
				$.ajax({
					
					type:"post",
					async:true,
					url:"userAction!search",
					dataType:"json",
					data:tranverseForm("institutionForm"),
					success:function(data){
						alert(data);
					}
					
				});
				
				
			});
			
			var cancel = document.createElement("a");
			cancel.href = "";
			cancel.innerHTML = "取消";
			
			util.addEvent(cancel,"click",function(ev){
				
				ev.preventDefault();
				
				$("#content").empty();
				
				
				$("#main_block header").html("");
				
			});
			
			$("#content").append(form).append(submit).append(cancel);
			
			
		},
		deleteInstitution:function(ev){
			
			ev.preventDefault();
			
			$("#main_block header").html("");
			$("#content").empty();
			
			$("#main_block header").html("删除机构：");
			
			var input = document.createElement("input");
			input.type = "text";
			input.name = "name";
			input.id = "name";
			var submit = document.createElement("a");
			submit.href = "";
			submit.innerHTML = "提交";
			util.addEvent(submit,"click",function(ev){
				
				ev.preventDefault();
				$.ajax({
					
					type:"post",
					async:true,
					url:"institutionAction!del",
					dataType:"json",
					data:{name:$("#name").val()},
					success:function(data){
						alert(data);
					}
					
				});
				
				
			});
			
			var cancel = document.createElement("a");
			cancel.href = "";
			cancel.innerHTML = "取消";
			
			util.addEvent(cancel,"click",function(ev){
				
				ev.preventDefault();
				
				$("#content").empty();
				
				
				$("#main_block header").html("");
				
			});
			
			$("#content").append(input).append(submit).append(cancel);
		
			
		},
		
		setContentDisplay:function(){
			
			$("#content").css("display","block");
			
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
		
		//模糊匹配
		fuzzyMatch:function(){
			
			var that = this;
			
			$("#search_bar").change(function(){
				
				console.log("模糊匹配");
				
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
		
		
		configure:function(){
			
			this.setContentDisplay();
			this.addButtonListener();
			this.addUserAction();
			this.addInstitutionAction();
			this.addAuthorizeAction();
			this.recordCategory();
			
		}
		
	};
	
})()

start.configure();
