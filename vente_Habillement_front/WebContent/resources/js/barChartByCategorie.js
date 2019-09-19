function renderBarChartByCateAge() {
            var labelsSet = [];
            var dataSet = [];
			var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/">'
			+' <soapenv:Header/>'
			+'<soapenv:Body>'
			+'<bus:getVenteCountByCategory>'
			+'<arg0>c.nom_categ</arg0>'+
	     	'</bus:getVenteCountByCategory>'
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
                
                new Chart(document.getElementById("bar-chart-parAge"), {
                    type: 'pie',
                    data: {
                        labels: labelsSet,
                        datasets: [
                            {
                                label: "les ventes par age",
                                backgroundColor: ["#3cba9f","#c45850","#3e95cd", "#e8c3b9", "#8e5ea2"],
                                data: dataSet
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        legend: { display: false },
                        title: {
                            display: true,
                            text: 'les ventes par age'
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
    			                fontColor: 'dark'
    			            }
    					}
                    }
                });


            }

            xhr.setRequestHeader('Content-Type', 'text/xml');
            xhr.send(str);
        }




//////  par sex
function renderBarChartByCateSex() {
    var labelsSet = [];
    var dataSet = [];
	var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/">'
	+' <soapenv:Header/>'
	+'<soapenv:Body>'
	+'<bus:getVenteCountByCategory>'
	+'<arg0>c.sex</arg0>'+
 	'</bus:getVenteCountByCategory>'
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
        
        new Chart(document.getElementById("bar-chart-parSex"), {
            type: 'pie',
            data: {
                labels: labelsSet,
                datasets: [
                    {
                        label: "les ventes par age",
                        backgroundColor: ["#3e95cd","#8e5ea2","#3e95cd", "#e8c3b9"],
                        data: dataSet
                    }
                ]
            },
            options: {
                responsive: true,
                legend: { display: false },
                title: {
                    display: true,
                    text: 'les ventes par sex'
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
		                fontColor: 'dark'
		            }
				}
            }
        });


    }

    xhr.setRequestHeader('Content-Type', 'text/xml');
    xhr.send(str);
}

function renderBarChartByCateType() {
    var labelsSet = [];
    var dataSet = [];
	var str = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bus="http://business.service/">'
	+' <soapenv:Header/>'
	+'<soapenv:Body>'
	+'<bus:getVenteCountByCategory>'
	+'<arg0>c.type_categ</arg0>'+
 	'</bus:getVenteCountByCategory>'
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
        
        new Chart(document.getElementById("bar-chart-parType"), {
            type: 'doughnut',
            data: {
                labels: labelsSet,
                datasets: [
                    {
                        label: "les ventes par type",
                        backgroundColor: ["#e8c3b9","#3e95cd","#8e5ea2", "#e8c3b9", "#8e5ea2"],
                        data: dataSet
                    }
                ]
            },
            options: {
                responsive: true,
                legend: { display: false },
                title: {
                    display: true,
                    text: 'les ventes par type'
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
		                fontColor: 'dark'
		            }
				}
            }
        });


    }

    xhr.setRequestHeader('Content-Type', 'text/xml');
    xhr.send(str);
}


// par type date 












