console.log("hello");
$(document).ready(function() {
    $.getJSON('http://localhost:8080/home', function(json) {
				var tr=[];
				for (var i = 0; i < json.length; i++) {
					var link = 'activity/' + json[i].id;
					tr.push('<tr>');
					tr.push('<td>' + json[i].date + '</td>');
					tr.push('<td><a href=' + link + '>' + json[i].title + '</a></td>');
					tr.push('<td>' + json[i].sport.name + '</td>');
					tr.push('<td>' + json[i].description + '</td>');

					tr.push('</tr>');
				}
				$('table').append($(tr.join('')));
			});
});

	
					
