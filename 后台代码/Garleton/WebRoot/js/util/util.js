(function(){
	
	if(!window.util){
		window.util = {};
	}else{
		console.log("the util object exists");
	}
	
	util = {
		
		addLoad:function(func){
		
			if(window.onload == null){
				
				window.onload = func;
				
			}else{
				var fun = window.onload;
				window.onload = function(){
					
					fun();
					func();
					
				}
			}
		
		},
		
		addEvent:function(obj,type,func){
			if(obj.attachEvent){
				
				obj.attachEvent('on'+type,func);
				
			}else if(obj.addEventListener){
				
				obj.addEventListener(type,func,false);
				
			}else{
				obj['on'+type] = func();
			}
		},
		removeEvent:function(obj,type,func){
			if(obj.detachEvent){
				
				obj.detachEvent('on'+type,func);
				
			}else if(obj.removeEventListener){
				obj.removeEventListener(type,func,false);
			}
			
		},
	}
	
	
	
	
})()