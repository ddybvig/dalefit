async function fetchActivitiesJSON() {
	const response = await fetch("http://localhost:8080/home");
	const activities = await response.json();
	return activities;
}
//without the callback function this line just returns a pending promise
//let data = fetchActivitiesJSON();
fetchActivitiesJSON().then(data => {
	let tr=[];
	for (let i = 0; i < data.length; i++) {
		let link = 'activity/' + data[i].id;
		tr.push('<tr>');
		tr.push('<td>' + data[i].date + '</td>');
		tr.push('<td><a href=' + link + '>' + data[i].title + '</a></td>');
		tr.push('<td>' + data[i].sport.name + '</td>');
		tr.push('<td>' + data[i].description + '</td>');
		tr.push('</tr>');
		}
let tableData = tr.join('');
document.querySelector('table').insertAdjacentHTML('beforeend', tableData);
});
