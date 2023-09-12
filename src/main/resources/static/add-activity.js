$('#saveActivity').click(function(){
	saveActivity();
})

var duration = 0;
var hours = 0;
var minutes = 0;
var seconds = 0;
function saveActivity() {
	hours = parseInt($('#hours').val());
	minutes = parseInt($('#minutes').val());
	seconds = parseInt($('#seconds').val());
	duration = hours*3600 + minutes*60 + seconds;
	var formData = {
	title: $('#title').val(),
	description: $('#description').val(),
	sport: {id: $('#sport').val()},
	date: $('#date').val(),
	startTime: $('#startTime').val(),
	duration: duration,
	distanceInMiles: parseFloat($('#distance').val())
};
console.log(formData);
		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/activity/save',
			data: JSON.stringify(formData),
			dataType: "json",
			contentType: 'application/json;charset=UTF-8'
	})
}

function getSports() {
	$.getJSON('http://localhost:8080/sports', function(json){
				var tr=[];
				for (var i = 0; i < json.length; i++) {
					tr.push('<option value=' + json[i].id + '>' + json[i].name + '</option>');
				}
				$('select').append($(tr.join('')));
	})
}
$(document).ready(function() {
	console.log(getSports());
});
