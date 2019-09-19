//<script>

	$(document).ready(function() {
		$('.datepicker').pickadate({
			format : 'mm/dd/yyyy',
			selectMonths : true, // Creates a dropdown to control month
			selectYears : 15
		// Creates a dropdown of 15 years to control year
		});
		
		
	});
	$(document).ready(function() {
		$('select').material_select();
	});
	// Hide Sections
	$('.section').hide();
	
	setTimeout(function() {
		$(document).ready(function() {
			// Show sections
			$('.section').fadeIn();

			// Hide preloader
			$('.loader').fadeOut();

			//Init Side nav
			$('.button-collapse').sideNav();

			// Init Modal
			$('.modal').modal();
			
			// Counter
			$('.count').each(function () {
			  $(this).prop('Counter', 0).animate({
			    Counter: $(this).text()
			  }, {
			      duration: 2000,
			      easing: 'swing',
			      step: function (now) {
			        $(this).text(Math.ceil(now));
			      }
			    });
			});
		});
	}, 1000);
	
	/// new staff
	
	
//</script>