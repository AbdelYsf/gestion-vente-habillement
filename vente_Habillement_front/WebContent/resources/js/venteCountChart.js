function CountVenteChart(  s, e) {
            var labelsSet = [];
            var dataSet = [];
			var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/"><soapenv:Header/>'
				+'<soapenv:Body>'
				+'  <bus:getVenteCount>'
		         +'<arg0>'+s+'</arg0>'
		         +'<arg1>'+e+'</arg1>'
		      +'</bus:getVenteCount>'
		      +'</soapenv:Body></soapenv:Envelope>';

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
            var xhr = createCORSRequest("POST", "http://localhost:8080/vente_hebillement_WS/status?wsdl");
            if (!xhr) {
                console.log("XHR issue");
                return;
            }
            xhr.onload = function () {
                var results = xhr.responseText;
                // console.log(results);

                //console.log(res.getElementsByTagName("return")[0].childNodes[0].nodeValue);
                parser = new DOMParser();
                xmlDoc = parser.parseFromString(results, 'text/xml');

                for (var i = 0; i < xmlDoc.getElementsByTagName("return").length; i++) {
                	labelsSet
							.push(xmlDoc.getElementsByTagName("return")[i].childNodes[0].innerHTML);
                	dataSet
							.push(parseInt(xmlDoc
									.getElementsByTagName("return")[i].childNodes[1].innerHTML));
				}
                console.log(dataSet);
                console.log(labelsSet);
                
                new Chart(document.getElementById("vente-count"), {
                    type: 'line',
                    data: {
                        labels: labelsSet,
                        
                        datasets: [
                            {
                                label: "",
                                backgroundColor: ["#3e95cd"],
                                data: dataSet,
                                borderColor: "#80b6f4",
                                pointBorderColor: "#80b6f4",
                                pointBackgroundColor: "#80b6f4",
                                pointHoverBackgroundColor: "#80b6f4",
                                pointHoverBorderColor: "#80b6f4",
                                pointBorderWidth: 10,
                                pointHoverRadius: 10,
                                pointHoverBorderWidth: 1,
                                pointRadius: 3,
                                fill: false,
                                borderWidth: 4,
                            }
                        ]
                    },
                    
                    options: {
                        responsive: true,
                        legend: { display: false },
                        title: {
                            display: true,
                            text: 'nomber des ventes'
                        },
                        scales : {
    						yAxes : [ {
    							ticks : {
    								beginAtZero : true
    							}
    						} ]
    					},
    					legend: {
    			            display: true,
    			            labels: {
    			                fontColor: 'rgb(255, 99, 132)'
    			            }
    					},
    					 animation:{
    					        animateRotate: true,
    					        
    					    },
    					
                    }
                });


            }

            xhr.setRequestHeader('Content-Type', 'text/xml');
            xhr.send(str);
        }

/////////////////////////////////////////////:  par taille .//////////////////////////////////////

function CountVenteChartTaille( s, e) {
    var labelsSet = [];
    var dataSet = [];
	var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/"><soapenv:Header/>'
		+'<soapenv:Body>'
		+'<bus:getVenteCountByTailleDate>'
         +'<arg0>'+s+'</arg0>'
         +'<arg1>'+e+'</arg1>'
      +'</bus:getVenteCountByTailleDate>'
      +'</soapenv:Body></soapenv:Envelope>';

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
    var xhr = createCORSRequest("POST", "http://localhost:8080/vente_hebillement_WS/status?wsdl");
    if (!xhr) {
        console.log("XHR issue");
        return;
    }
    xhr.onload = function () {
        var results = xhr.responseText;
   
        parser = new DOMParser();
        xmlDoc = parser.parseFromString(results, 'text/xml');

        for (var i = 0; i < xmlDoc.getElementsByTagName("return").length; i++) {
        	labelsSet
					.push(xmlDoc.getElementsByTagName("return")[i].childNodes[1].innerHTML);
        	dataSet
					.push(parseInt(xmlDoc
							.getElementsByTagName("return")[i].childNodes[0].innerHTML));
		}
        console.log(dataSet);
        console.log(labelsSet);
        
        new Chart(document.getElementById("vente-countTaille"), {
            type: 'bar',
            data: {
                labels: labelsSet,
                
                datasets: [
                    {
                        label: "",
                        backgroundColor:  ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                        data: dataSet,
                        borderColor: "#80b6f4",
                        pointBorderColor: "#80b6f4",
                        pointBackgroundColor: "#80b6f4",
                        pointHoverBackgroundColor: "#80b6f4",
                        pointHoverBorderColor: "#80b6f4",
                        pointBorderWidth: 10,
                        pointHoverRadius: 10,
                        pointHoverBorderWidth: 1,
                        pointRadius: 3,
                        fill: false,
                        borderWidth: 4,
                    }
                ]
            },
            
            options: {
                responsive: true,
                legend: { display: false },
                title: {
                    display: true,
                    text: 'nomber des ventes par taille'
                },
                scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				},
				legend: {
		            display: true,
		            labels: {
		                fontColor: 'rgb(255, 99, 132)'
		            }
				},
				 animation:{
				        animateRotate: true,
				        
				    },
				
            }
        });


    }

    xhr.setRequestHeader('Content-Type', 'text/xml');
    xhr.send(str);
}


///////////////////////////////////// pat article ////////////////////////////////////////////////

function CountVenteChartArticle(  s, e) {
	//console.log("abdellah");
    var labelsSet = [];
    var dataSet = [];
	var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/"><soapenv:Header/>'
		+'<soapenv:Body>'
		+' <bus:getVenteCountByArticleDate>'
         +'<arg0>'+s+'</arg0>'
         +'<arg1>'+e+'</arg1>'
      +'</bus:getVenteCountByArticleDate>'
      +'</soapenv:Body></soapenv:Envelope>';

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
    var xhr = createCORSRequest("POST", "http://localhost:8080/vente_hebillement_WS/status?wsdl");
    if (!xhr) {
        console.log("XHR issue");
        return;
    }
    xhr.onload = function () {
        var results = xhr.responseText;
   
        parser = new DOMParser();
        xmlDoc = parser.parseFromString(results, 'text/xml');
        for (var i = 0; i < xmlDoc.getElementsByTagName("return").length; i++) {
        	console.log("test");
        	labelsSet
					.push(xmlDoc.getElementsByTagName("return")[i].childNodes[0].innerHTML);
        	dataSet
					.push(parseInt(xmlDoc
							.getElementsByTagName("return")[i].childNodes[1].innerHTML));
		}
        console.log(dataSet);
        console.log(labelsSet);
        
        new Chart(document.getElementById("vente-countArticle"), {
            type: 'bar',
            data: {
                labels: labelsSet,
                
                datasets: [
                    {
                        label: " ",
                        backgroundColor:  ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                        data: dataSet,
                       
                        pointBackgroundColor: "#80b6f4",
                        pointHoverBackgroundColor: "#80b6f4",
                        pointHoverBorderColor: "#80b6f4",
                      
                        pointHoverBorderWidth: 1,
                        pointRadius: 3,
                        fill: false,
                        borderWidth: 4,
                    }
                ]
            },
            
            options: {
                responsive: true,
                legend: { display: false },
                title: {
                    display: true,
                    text: 'nomber des ventes par article'
                },
                scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				},
				legend: {
		            display: true,
		            labels: {
		                fontColor: 'rgb(255, 99, 132)'
		            }
				},
				 animation:{
				        animateRotate: true,
				        
				    },
				
            }
        });


    }

    xhr.setRequestHeader('Content-Type', 'text/xml');
    xhr.send(str);
}

/////////////////////////////////////////////:  par type.//////////////////////////////////////

function CountVenteChartType(  c,s, e) {
    var labelsSet = [];
    var dataSet = [];
	var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/"><soapenv:Header/>'
		+'<soapenv:Body>'
		+'<bus:getVenteCountByCategoryDate>'
         +'<arg0>'+c+'</arg0>'
         +'<arg1>'+s+'</arg1>'
         +'<arg2>'+e+'</arg2>'
      +'</bus:getVenteCountByCategoryDate>'
      +'</soapenv:Body></soapenv:Envelope>';

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
    var xhr = createCORSRequest("POST", "http://localhost:8080/vente_hebillement_WS/status?wsdl");
    if (!xhr) {
        console.log("XHR issue");
        return;
    }
    xhr.onload = function () {
        var results = xhr.responseText;
   
        parser = new DOMParser();
        xmlDoc = parser.parseFromString(results, 'text/xml');

        for (var i = 0; i < xmlDoc.getElementsByTagName("return").length; i++) {
        	labelsSet
					.push(xmlDoc.getElementsByTagName("return")[i].childNodes[0].innerHTML);
        	dataSet
					.push(parseInt(xmlDoc
							.getElementsByTagName("return")[i].childNodes[1].innerHTML));
		}
        console.log(dataSet);
        console.log(labelsSet);
        
        new Chart(document.getElementById("vente-countType"), {
            type: 'doughnut',
            data: {
                labels: labelsSet,
                datasets: [
                    {
                        label: "les ventes par type",
                        backgroundColor:  ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                        data: dataSet,
                       
                    }
                ]
            },
      
            options: {
                responsive: true,
                legend: { display: false },
                title: {
                    display: true,
                    text: 'nomber des ventes par Type'
                },
                scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : true
						}
					} ]
				},
				legend: {
		            display: true,
		            labels: {
		                fontColor: 'rgb(255, 99, 132)'
		            }
				},
				 animation:{
				        animateRotate: true,
				        
				    },
				
            }
        });


    }

    xhr.setRequestHeader('Content-Type', 'text/xml');
    xhr.send(str);
}


