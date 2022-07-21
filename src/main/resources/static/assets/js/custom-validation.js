
$(function () {
    page.dialogs.element.frmCreDrug.validate({
        onkeyup: function(element) { $(element).valid() },
        onclick: false,
        onfocusout: false,
        rules: {
            drugNameCre: {
                required: true,
                maxlength: 100
            },
            drugContentCre: {
                required: true,
                number: true,
                min: 0,
                max: 10000000
            },
            quantityCre: {
                required: true,
                number: true,
                min: 0,
                max: 5000000
            },
            pricePerUnitCre: {
                required: true,
                number: true,
                min: 0,
                max: 5000000
            },
            dosageFormCre: {
                required: true,
                number: true,
                min: 0,
            },
            productionDateCre: {
                required: true
            },
            expirationDateCre: {
                required: true
            },

        },
        errorLabelContainer: "#mdCreateDrug .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#mdCreateDrug .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                page.dialogs.alertDanger.mdCreateDrug.removeClass("hide").addClass("show");
            } else {
                page.dialogs.alertDanger.mdCreateDrug.removeClass("show").addClass("hide").empty();
                page.dialogs.element.frmCreDrug.removeClass("error");
            }
            this.defaultShowErrors();
        },
        messages: {
            drugNameCre: {
                required: "Drug name is required.",
                maxlength: $.validator.format("Max characters of drug name is {0}.")
            },
            drugContentCre: {
                required: "Drug content is required.",
                number: "Drug content must be a number.",
                min: "Drug content must be greater than 0.",
                max: $.validator.format("Max value of drug content is {0}.")
            },
            quantityCre: {
                required: "Quantity is required.",
                number: "Quantity must be a number.",
                min: "Quantity must be greater than 0.",
                max: $.validator.format("Max value of quantity is {0}.")
            },
            pricePerUnitCre: {
                required: "Price is required.",
                number: "Price must be a number.",
                min: "Price must be greater than 0.",
                max: $.validator.format("Max value of price is {0}.")
            },
            dosageFormCre: {
                required: "Dosage form ID is required.",
                number: "Dosage form ID must be a number.",
                min: "Dosage form ID must be greater than 0."
            },
            productionDateCre: {
                required: "Production date is required.",
            },
            expirationDateCre: {
                required: "Expiration date is required.",
            },
        },
        submitHandler: function() {
            page.dialogs.commands.createNewDrug();
        }
    });

    page.dialogs.element.frmUpDrug.validate({
        onkeyup: function(element) { $(element).valid() },
        onclick: false,
        onfocusout: false,
        rules: {
            drugNameUp: {
                required: true,
                maxlength: 100
            },
            drugContentUp: {
                required: true,
                number: true,
                min: 0,
                max: 10000000
            },
            quantityUp: {
                required: true,
                number: true,
                min: 0,
                max: 5000000
            },
            pricePerUnitUp: {
                required: true,
                number: true,
                min: 0,
                max: 5000000
            },
            dosageFormUp: {
                required: true,
                number: true,
                min: 0,
            },
            productionDateUp: {
                required: true
            },
            expirationDateUp: {
                required: true
            },

        },
        errorLabelContainer: "#mdUpdateDrug .modal-alert-danger",
        errorPlacement: function (error, element) {
            error.appendTo("#mdUpdateDrug .modal-alert-danger");
        },
        showErrors: function(errorMap, errorList) {
            if (this.numberOfInvalids() > 0) {
                page.dialogs.alertDanger.mdUpdateDrug.removeClass("hide").addClass("show");
            } else {
                page.dialogs.alertDanger.mdUpdateDrug.removeClass("show").addClass("hide").empty();
                page.dialogs.element.frmUpDrug.removeClass("error");
            }
            this.defaultShowErrors();
        },
        messages: {
            drugNameUp: {
                required: "Drug name is required.",
                maxlength: $.validator.format("Max characters of drug name is {0}.")
            },
            drugContentUp: {
                required: "Drug content is required.",
                number: "Drug content must be a number.",
                min: "Drug content must be greater than 0.",
                max: $.validator.format("Max value of drug content is {0}.")
            },
            quantityUp: {
                required: "Quantity is required.",
                number: "Quantity must be a number.",
                min: "Quantity must be greater than 0.",
                max: $.validator.format("Max value of quantity is {0}.")
            },
            pricePerUnitUp: {
                required: "Price is required.",
                number: "Price must be a number.",
                min: "Price must be greater than 0.",
                max: $.validator.format("Max value of price is {0}.")
            },
            dosageFormUp: {
                required: "Dosage form ID is required.",
                number: "Dosage form ID must be a number.",
                min: "Dosage form ID must be greater than 0."
            },
            productionDateUp: {
                required: "Production date is required.",
            },
            expirationDateUp: {
                required: "Expiration date is required.",
            },
        },
        submitHandler: function() {
            page.dialogs.commands.updateDrug();
        }
    });
});