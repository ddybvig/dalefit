$('#saveActivity').click(function(){
	saveActivity();
})
function saveActivity() {
	var formData = {
	title: $('#title').val(),
	description: $('#description').val(),
	sport: {sport: $('#sport').val()},
	date: $('#date').val(),
	startTime: $('#startTime').val(),
	duration: calculateDurationInSeconds
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
		console.log("where sports?");
				var tr=[];
				for (var i = 0; i < json.length; i++) {
					tr.push('<option value=' + json[i].id + '>' + json[i].name + '</option>');
				}
				$('select').append($(tr.join('')));
	})
}
var hours = $('#hours');
var minutes = $('#minutes');
var seconds = $('#seconds');
function calculateDurationInSeconds(hours, minutes, seconds) {
	return hours*3600 + minutes*60 + seconds;
}

$(document).ready(function() {
	console.log("hello there")
	console.log(getSports());
});