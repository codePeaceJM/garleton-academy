var curtain = function(ev){
	function fix(ev){
		ev.preventDefault();
	}

	document.getElementById('sign_in').onclick = function(ev){
		document.getElementById("curtain").style.display = "block";
		document.getElementById("curtain").style.top = document.body.scrollTop+"px";

		document.getElementById("sign_in_form").style.display = "block";
		
		document.body.addEventListener("mousewheel",fix,false);

		ev.preventDefault();
		ev.stopPropagation();
	};

	document.getElementById('sign_in_form').onclick = function(ev){
			ev.stopPropagation();
	};

	document.getElementById('sign_up_form').onclick = function(ev){
		ev.stopPropagation();
	};

	document.getElementById('sign_up').onclick = function(ev){
		document.getElementById("curtain").style.display = "block";
		document.getElementById("curtain").style.top = document.body.scrollTop+"px";

		document.getElementById("sign_up_form").style.display = "block";
		
		document.body.addEventListener("mousewheel",fix,false);

		ev.preventDefault();
		ev.stopPropagation();
	};

	document.getElementById('curtain').onclick = function() {
		this.style.display = "none";
		document.getElementById("sign_up_form").style.display = "none";
		document.getElementById("sign_in_form").style.display = "none";

		document.body.removeEventListener("mousewheel",fix);
	};
}


if(window.onload == null){
	window.onload = function(ev){
		curtain(ev);
	}
}else {
	var func = window.onload;
	window.onload = function(ev){
		func(ev);
		curtain(ev);
	}
}

