/**
 * 
 */

window.addEventListener('load', function(){
	
	//alert("This is a date Template");
	var URLactual = window.location.pathname;
	//alert(URLactual);
	if (URLactual=="/date")
		confirm("This is a date Template");
	else
		confirm("This is a time Template");
})