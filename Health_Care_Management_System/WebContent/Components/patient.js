$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	alert("check");
	// Form validation-------------------
	var status = validatePatientForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------------------
	var type = ($("#hidPIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "PatientsAPI",
		type : type,
		data : $("#formPatient").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onPatientSaveComplete(response.responseText, status);
		}
	});
});

function onPatientSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divPatientGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidPIDSave").val("");
	$("#formPatient")[0].reset();
}

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
	$("#hidPIDUpdate").val($(this).closest("tr").find('#hidPIDUpdate').val());
	$("#Pname").val($(this).closest("tr").find('td:eq(0)').text());
	$("#Gender").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Age").val($(this).closest("tr").find('td:eq(2)').text());
	$("#Blood_group").val($(this).closest("tr").find('td:eq(3)').text());
	$("#Pcontact").val($(this).closest("tr").find('td:eq(4)').text());
});

// Remove============================================
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "PatientsAPI",
		type : "DELETE",
		data : "PID=" + $(this).data("PID"),
		dataType : "text",
		complete : function(response, status) {
			onPatientDeleteComplete(response.responseText, status);
		}
	});
});

function onPatientDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divPatientGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// CLIENTMODEL=========================================================================
function validatePatientForm() {
	// name
	if ($("#Pname").val().trim() == "") {
		return "Insert Name.";
	}
	// gebder
	if ($("#Gender").val().trim() == "") {
		return "Insert Gender.";
	}

	// is numerical value/Age
	var tmpage = $("#Age").val().trim();
	if (!$.isNumeric(tmpage)) {
		return "Insert a numerical value for Age.";
	}

	// Blood Group-------------------------------
	if ($("#Blood_group").val().trim() == "") {
		return "Insert Blood group.";
	}

	// contact-------------------------------
	if ($("#Pcontact").val().trim() == "") {
		return "Insert Blood group.";
	}

	return true;
}
