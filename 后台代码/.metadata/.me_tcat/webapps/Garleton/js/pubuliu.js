(function(){

			function multColumn(width,columnWidth,minColNum,container){
				
				this.width = width;




				try{
					this.colNum = Math.floor(width/columnWidth)>=minColNum?Math.floor(width/columnWidth):minColNum;


				}catch(e){
					throw new Error('please input three number as params');
				}

				if(typeof container === 'string'){
					this.container = document.getElementById(container);
				}

				if($("#"+container+" input")[0]!=null){
					return;
				}

				for(var i = 0 ; i< this.colNum;i++){
					var div = document.createElement('div');
					div.className = 'column';
					div.id="col-"+(i+1);
					var width = parseInt(100/this.colNum)-2;
					div.style.width = width+'%';
					this.container.appendChild(div);
					this['col_'+(i+1)] = {
						height:div.offsetHeight
					};

				}

			}

			multColumn.prototype = {

				init:function(){

					var arr = this.toLoad();

					this.toArrange(arr);

				},



				toLoad:function(){

					return this.returnData(20);

				},

				toArrange:function(arr){

					for(var i = 0;i<arr.length;i++){

						var target =null;

						var maxH = this.returnMax();

						for(var j = 1;j<=this.colNum;j++){
							if(this['col_'+j].height == maxH){
								target = document.getElementById('col-'+j);
								break;
							}
						}

						var div = document.createElement('div');
						var h3 = document.createElement('h3');
						var p = document.createElement('p');

						h3.innerHTML = arr[i].title;
						p.innerHTML = arr[i].text;

						div.appendChild(h3);
						div.appendChild(p);


						target.appendChild(div);

						this.refreshHeight();

					}

				},


				returnData:function(number){

					var arr = [];

					try{
						for(var i=0;i<number;i++){

							var size = i;
							var str = '';

							var ran = parseInt(Math.random()*50);

							for(var j=0;j<ran;j++){
								str += size+"  ";
							}

							var data= {
								title:size,
								text:str
							};

							arr.push(data);

						}
					}catch(e){
						throw new Error('the param of returnData is not a number');
					}

					return arr;
				},

				returnMax:function(){
					var minH = this['col_1'].height;
					for(var i=0;i<this.colNum;i++){

						if(this['col_'+(i+1)].height<minH){
							minH = this['col_'+(i+1)].height;
						}

					}

					return minH;

				},

				refreshHeight:function(){
					for(var i=0;i<this.colNum;i++){
						this['col_'+(i+1)].height = document.getElementById('col-'+(i+1)).offsetHeight;
					}
				},

				configure:function(){

					this.init();
				}
			}

			if(!window.multColumn){
				window.multColumn = multColumn;
			}

		})()

