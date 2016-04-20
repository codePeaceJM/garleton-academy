(function() {

	if (!window.index) {

		window.index = {};

	} else {
		console.log("the index method is occupied.");
	}

	index = {
		
		freshInterval:3000,
		
		interval:null,
		
		searchCategory:null,

		setCurtain : function(ev) {
			function fix(ev) {
				ev.preventDefault();
			}

			document.getElementById('sign_in').onclick = function(ev) {
				document.getElementById("curtain").style.display = "block";
				document.getElementById("curtain").style.top = document.body.scrollTop
						+ "px";

				document.getElementById("sign_in_form").style.display = "block";

				document.body.addEventListener("mousewheel", fix, false);

				ev.preventDefault();
				ev.stopPropagation();
			};

			document.getElementById('sign_in_form').onclick = function(ev) {
				ev.stopPropagation();
			};

			document.getElementById('sign_up_form').onclick = function(ev) {
				ev.stopPropagation();
			};

			document.getElementById('sign_up').onclick = function(ev) {
				document.getElementById("curtain").style.display = "block";
				document.getElementById("curtain").style.top = document.body.scrollTop
						+ "px";

				document.getElementById("sign_up_form").style.display = "block";

				document.body.addEventListener("mousewheel", fix, false);

				ev.preventDefault();
				ev.stopPropagation();
			};

			document.getElementById('curtain').onclick = function() {
				this.style.display = "none";
				document.getElementById("sign_up_form").style.display = "none";
				document.getElementById("sign_in_form").style.display = "none";

				document.body.removeEventListener("mousewheel", fix);
			};
		},

		formValify : function() {
	
		},

		isIntegrity : function() {
			var form1 = document.getElementById('sign_in_form');
			var form2 = document.getElementById('sign_up_form');

			var pwd1 = document.getElementById('first_pwd');
			var pwd2 = document.getElementById('second_pwd');

			var aInput1 = form1.getElementsByTagName('input');
			var aInput2 = form2.getElementsByTagName('input');

			form1.querySelector('input[type="submit"]').onclick = function(ev) {
				ev.preventDefault();
				for (i = 0; i < aInput1.length; i++) {
					if (aInput1[i].value == "") {
						alert("请将信息输入完整");
						return;
					}
				}

				form1.submit();
			}

			form2.querySelector('input[type="submit"]').onclick = function(ev) {
				ev.preventDefault();
				for (i = 0; i < aInput2.length; i++) {
					if (aInput2[i].value == "") {
						alert("请将信息输入完整！");
						return;
					}
				}

				if (!(pwd1.value == pwd2.value)) {
					alert("两次输入的密码不一致！");
				}

				form2.submit();
			}
		},
		
		getColumnArticle:function(){
			
			$.ajax({
				
				type:"post",
				url:"",
				async:true,
				data:{},
				dataType:"json",
				success:function(data){
					
					//解析data
				
					if(data.constructor !== Array){
						
						return new Error("这不是一个数组");
						
					}else{
						
						
						
						for(var i = 0 ;i<data.length;i++){
							
							try{
								var title = document.createElement("h2");
								title.innerHTML = data[i].title;
								
								var date = document.createElement("p");
								date.innerHTML = data[i].date;
								
								var article = document.createElement("article");
								article.innerHTML = data[i].article;
								
								$("#content div:nth-of-type("+(i+1)+")")
									.append(title)
									.append(date)
									.append(article);
								
							}catch(e){
								
								throw new Error("有什么属性数据里没有");
								
							}
							
						}
						
					}
					
				}
				
			});
			
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
			
			$("#search_bar").on('input',function(){
				
				$("#search_result").show();
				
				if(this.value==""){
					$("#search_result").hide();
				}
				
				
				$.ajax({
					
					type:"post",
					url:"NewsAction!search",
					async:true,
					data:{
						"category":that.searchCategory,
						"news.title":$(this).val()
					},
					dataType:"json",
					success:function(data){
						alert(data);
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
		

		configure : function() {

			
			util.addLoad(this.getColumnArticle);
			
			this.interval = setInterval(this.addLoad,this.freshInterval);
			
			util.addLoad(this.setCurtain);
			util.addLoad(this.isIntegrity);
			
			util.addLoad(this.addCategoryListener);
			
			util.addLoad(this.recordCategory);
			util.addLoad(this.fuzzyMatch);
			
		}

	};


})();

window.index.configure();