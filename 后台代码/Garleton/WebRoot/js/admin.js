$(".manage").mouseenter(function(){

	var ul = this.parentNode.getElementsByTagName('ul')[0];

	$(ul).show("quick");

	$(ul).mouseleave(function(){

		$(this).hide("slow");

	});

});