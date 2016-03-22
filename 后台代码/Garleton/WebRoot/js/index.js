(function() {

	if (!window.index) {

		window.index = {};

	} else {
		console.log("the index method is occupied.");
	}

	index = {

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

		configure : function() {

			util.addLoad(this.setCurtain);
			
			util.addLoad(this.isIntegrity);
			
		}

	};

	index.configure();

})();