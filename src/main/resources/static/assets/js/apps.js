class App {
    static DOMAIN = location.origin;

    static BASE_URL_DRUG = this.DOMAIN + "/api/drugs";
    static BASE_URL_ROLE = this.DOMAIN + "/api/roles";
    static BASE_URL_DOSAGE_FORM = this.DOMAIN + "/api/dosageForms";
    static BASE_URL_AUTH = this.DOMAIN + "/api/auth";

    static BASE_URL_USER = this.DOMAIN + "/api/users";
    static BASE_URL_PROVINCE = "https://vapi.vnappmob.com/api/province";

    static SUCCESS_CREATED = "Successful data generation!";
    static SUCCESS_UPDATED = "Update data successfully!";
    static SUCCESS_REMOVED = "Remove successfully!";

    static REMOVE_DRUG = "Are you sure that you want to remove the this drug?";
    static BLOCK_USER = 'Are you sure that you want to block the this user?';

    static SweetAlert = class {
        static showConfirmDialog(message) {
            return Swal.fire({
                icon: 'WARNING',
                text: message,
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, please!',
                cancelButtonText: 'Cancel',
            })
        }

        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }
    }


    static IziToast = class {
        static showSuccessAlert(t) {
            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 2500,
                message: t
            });
        }

        static showErrorAlert(t) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                timeout: false,
                message: t
            });
        }
    }
}

class Drug {
    constructor(id, drugName, drugContent, quantity, dosageForm, drugUsage, pricePerUnit, productionDate, expirationDate, note) {
        this.id = id;
        this.drugName = drugName;
        this.drugContent = drugContent;
        this.quantity = quantity;
        this.dosageForm = dosageForm;
        this.drugUsage = drugUsage;
        this.pricePerUnit = pricePerUnit;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.note = note;
    }
}

class DosageForm {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}