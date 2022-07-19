
$(function () {
    page.dialogs.element.frmCreDrug.validate({
        onkeyup: function(element) { $(element).valid() },
        onclick: false,
        onfocusout: false,
        // rules: {
        //     fullName: {
        //         required: true,
        //         minlength: 5,
        //         maxlength: 50
        //     },
        //     email: {
        //         required: true,
        //         email: true,
        //         minlength: 10,
        //         maxlength: 50
        //     },
        //     address: {
        //         required: false,
        //         minlength: 5,
        //         maxlength: 50
        //     }
        // },
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
        // messages: {
        //     fullName: {
        //         required: "Vui lòng nhập tên đầy đủ",
        //         minlength: $.validator.format("Họ tên tối thiểu {0} ký tự"),
        //         maxlength: $.validator.format("Họ tên tối đa {0} ký tự")
        //     },
        //     email: {
        //         required: "Vui lòng nhập email đầy đủ",
        //         email: "Vui lòng nhập đúng định dạng email",
        //         minlength: $.validator.format("Email tối thiểu {0} ký tự"),
        //         maxlength: $.validator.format("Email tối đa {0} ký tự")
        //     },
        //     address: {
        //         minlength: $.validator.format("Địa chỉ tối thiểu {0} ký tự"),
        //         maxlength: $.validator.format("Địa chỉ tối đa {0} ký tự")
        //     }
        // },
        submitHandler: function() {
            page.dialogs.commands.createNewDrug();
        }
    });

    page.dialogs.element.frmUpDrug.validate({
        onkeyup: function(element) { $(element).valid() },
        onclick: false,
        onfocusout: false,
        // rules: {
        //     fullName: {
        //         required: true,
        //         minlength: 5,
        //         maxlength: 50
        //     },
        //     email: {
        //         required: true,
        //         email: true,
        //         minlength: 10,
        //         maxlength: 50
        //     },
        //     address: {
        //         required: false,
        //         minlength: 5,
        //         maxlength: 50
        //     }
        // },
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
        // messages: {
        //     fullName: {
        //         required: "Vui lòng nhập tên đầy đủ",
        //         minlength: $.validator.format("Họ tên tối thiểu {0} ký tự"),
        //         maxlength: $.validator.format("Họ tên tối đa {0} ký tự")
        //     },
        //     email: {
        //         required: "Vui lòng nhập email đầy đủ",
        //         email: "Vui lòng nhập đúng định dạng email",
        //         minlength: $.validator.format("Email tối thiểu {0} ký tự"),
        //         maxlength: $.validator.format("Email tối đa {0} ký tự")
        //     },
        //     address: {
        //         minlength: $.validator.format("Địa chỉ tối thiểu {0} ký tự"),
        //         maxlength: $.validator.format("Địa chỉ tối đa {0} ký tự")
        //     }
        // },
        submitHandler: function() {
            page.dialogs.commands.updateDrug();
        }
    });


});