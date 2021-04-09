console.log("workout js12 loaded")
var grand_total =0;

function total_exercise(section, grandTotal) {
	var set_total = [];
	var exercise_total;

	for (i = 1; i <= 4; i++) {
		var section_prefix = section + "-" + i;
		if (
			document.getElementById(section_prefix + "-1") == null ||
			document.getElementById(section_prefix + "-2") == null
		) {
			document.getElementById(section_prefix + "-3").value = parseInt(0);
			set_total.push(0);
			continue;
		}
		var input_one = document.getElementById(section_prefix + "-1").value;
		var input_two = document.getElementById(section_prefix + "-2").value;
		if (input_one == 0 || input_two == 0) {
			document.getElementById(section_prefix + "-3").value = parseInt(0);
			set_total.push(0);
			continue;
		} else {
			set_total.push(input_one * input_two);
			document.getElementById(section_prefix + "-3").value = parseInt(
				set_total[i - 1]
			);
		}
	}
	exercise_total = set_total.reduce(function(a, b) {
		return a + b;
	}, 0);
	if (grandTotal) {
		grand_total += exercise_total;
		console.log("grand total in loop", grand_total);
	}
	document.getElementById("ex-total-" + section).value = parseInt(
		exercise_total
	);
}

function workout_total() {
	total_exercise(1, true);
	total_exercise(2, true);
	total_exercise(3, true);
//	var exercises_completed = [];
	
//	var dropdown1 = document.getElementById("dropdown_one");
//	var dropdown2 = document.getElementById("dropdown_two");
//	var dropdown3 = document.getElementById("dropdown_three");
//	exercises_completed.push(dropdown1.options[dropdown1.selectedIndex].text);
//	exercises_completed.push(dropdown2.options[dropdown2.selectedIndex].text);
//	exercises_completed.push(dropdown3.options[dropdown3.selectedIndex].text);
//	console.log("exercises" + exercises_completed);

	document.getElementById("exercises_completed").value = exercises_completed;
	document.getElementById("total_weight_lifted").value = parseInt(grand_total);
	var msg = "You lifted: " + parseInt(grand_total) + " this workout!";
	console.log(msg);
	document.getElementById("total_weight").innerHTML = msg;
	
}

function clear_total() {
	grand_total = 0;
}