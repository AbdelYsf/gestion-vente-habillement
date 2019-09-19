function renderChartBySize() {
		// this function sends a soap request to render the chart 
		var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/"><soapenv:Header/> <soapenv:Body> <bus:getVenteCountByTaille/></soapenv:Body></soapenv:Envelope>';
		
		function createCORSRequest(method, url) {
			var xhr = new XMLHttpRequest();
			if ("withCredentials" in xhr) {
				xhr.open(method, url, false);
			} else if (typeof XDomainRequest != "undefined") {
				alert
				xhr = new XDomainRequest();
				xhr.open(method, url);
			} else {
				console.log("CORS not supported");
				alert("CORS not supported");
				xhr = null;
			}
			return xhr;
		}
		var xhr = createCORSRequest("POST",
				"http://localhost:8080/vente_hebillement_WS/status?wsdl");
		if (!xhr) {
			console.log("XHR issue");
			return;
		}
		var labelsSet = [];
		var dataSet = [];
		xhr.onload = function() {
			var results = xhr.responseText;
			console.log(results);

			parser = new DOMParser();
			xmlDoc = parser.parseFromString(results, 'text/xml');
			console.log(xmlDoc);

			for (var i = 0; i < xmlDoc.getElementsByTagName("return").length; i++) {
				labelsSet
						.push(xmlDoc.getElementsByTagName("return")[i].childNodes[1].innerHTML);
				dataSet
						.push(parseInt(xmlDoc
								.getElementsByTagName("return")[i].childNodes[0].innerHTML));
			}
			console.log(labelsSet);
			// render the chart
			new Chart(document.getElementById("bar-chart"),{
				type : 'bar',
				data : {
					labels : labelsSet,
					datasets : [ {
						label : "ventes par taille",
						backgroundColor : [ "#3e95cd", "#8e5ea2", "#3cba9f",
								"#e8c3b9", "#c45850" ],
						data : dataSet
					} ]
				},
				options : {
					responsive: true,
					animation : true,
					animationEasing : 'easeInOutQuart',
					animationSteps : 110,
					scales : {
						yAxes : [ {
							ticks : {
								beginAtZero : true
							}
						} ]
					},
					legend : {
						display : false
					},
					title : {
						display : true,
						text : 'les ventes par Taille'
					}

				}

			});

		}

		xhr.setRequestHeader('Content-Type', 'text/xml');
		xhr.send(str);
		
	}
	

	function drowChart() {
		
	}
	window.onload=function(){
		renderChartBySize();
		
	}