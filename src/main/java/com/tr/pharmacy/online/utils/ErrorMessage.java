package com.tr.pharmacy.online.utils;

public class ErrorMessage {


    public static final String VALID_DRUG_NAME = "Drug name contains letters and digits only.";
    public static final String MAX_DRUG_NAME_LENGTH = "Max character of drug name is 100.";

    public static final String SERVER_ERROR = "Failed operation, please contact to the system manager.";

    public static final String DRUG_EXISTS = "Drug exists. Try another drug.";

    public static final String DOSAGE_FORM_NOT_EXIST = "Dosage form ID doesn't exist.";

    public static String getNotEmptyMessage(String string) {
        return string + " must NOT be empty.";
    }

    public static String getNotNumberMessage(String string) {
        return string + " contains digits only.";
    }

    public static String getMinValue(String string, String min) {
        if (min.equals("0")) {
            return string + " must NOT be equal or less than 0.";
        }
        return string + " must NOT be less than " + min + ".";
    }

    public static String getMaxValue(String string, String max) {
        return string + " must NOT be greater than " + max + ".";
    }

    public static String getProductionDateLimit(String date) {
        return "Production date must be between " + date + " and one day before today.";
    }

    public static String getExpirationDateLimit(String date) {
        return "Expiration date must be between one day after today and " + date + ".";
    }

}
