function renderBarChartByTaille() {
            var labelsSet = [];
            var dataSet = [];
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
							.push(xmlDoc.getElementsByTagName("return")[i].childNodes[1].innerHTML);
                	dataSet
							.push(parseInt(xmlDoc
									.getElementsByTagName("return")[i].childNodes[0].innerHTML));
				}
                console.log(dataSet);
                console.log(labelsSet);
                
                new Chart(document.getElementById("bar-chart"), {
                    type: 'bar',
                    data: {
                        labels: labelsSet,
                        datasets: [
                            {
                                label:'',
                                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                                data: dataSet
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        legend: { display: false },
                        title: {
                            display: true,
                            text: 'les ventes par taille'
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
    					}
                    }
                });


            }

            xhr.setRequestHeader('Content-Type', 'text/xml');
            xhr.send(str);
        }

