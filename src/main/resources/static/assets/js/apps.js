class App {
    static DOMAIN = location.origin;

    static BASE_URL_DRUG = this.DOMAIN + "/api/drugs";
    static BASE_URL_DOSAGE_FORM = this.DOMAIN + "/api/dosageForms";
    static BASE_URL_USER = this.DOMAIN + "/api/users";
    static BASE_URL_PROVINCE = "https://vapi.vnappmob.com/api/province";
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