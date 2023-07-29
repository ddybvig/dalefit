$('#saveActivity').click(function(){
	saveActivity();
})
function saveActivity() {
	var formData = {
	title: $('#title').val(),
	description: $('#description').val(),
	sport: {sport: $('#sport').val()}
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