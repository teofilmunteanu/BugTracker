document.addEventListener("DOMContentLoaded", () => {
	
	const rows = document.querySelectorAll("tr[data-page]");
	
	rows.forEach(row => {
		row.addEventListener("click", () => {
			window.location.href = row.dataset.page;
		});
	});
});

