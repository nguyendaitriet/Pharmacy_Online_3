package com.tr.pharmacy.online.utils;

public class ErrorMessage {
    public static final String DUPLICATE_EMAIL = "Email address exists.";
    public static final String DUPLICATE_PHONE = "Phone number exists.";

    public static final String VALID_DRUG_NAME = "Drug name contains letters and digits only.";

    public static final String SERVER_ERROR = "Failed operation, please contact to the system manager.";

    public static final String DRUG_EXISTS = "Drug exists. Try another drug.";


//    public static final String INVALID_PRODUCTION_DATE = "Invalid production date.";
//    public static final String INVALID_EXPIRATION_DATE = "Invalid expiration date.";

//    public static final String EMPTY_DOSAGE_FORM_ID = "Dosage form ID must NOT be empty.";
//    public static final String INVALID_DOSAGE_FORM_ID = "Dosage form ID contains digits only.";

    public static final String MAX_AMOUNT_LENGTH = "Max character of transaction amount is 12.";
    public static final String MINIMUM_TRANSACTION_AMOUNT = "Transaction amount must NOT be LESS than 100.";
    public static final String MAXIMUM_TRANSACTION_AMOUNT = "Transaction amount must NOT be GREATER than 50,000,000.";
    public static final String MAXIMUM_WITHDRAW_AMOUNT = "Balance is not enough for this transaction.";


    public static final String SENDER_NOT_EMPTY = "Sender ID must NOT be empty.";
    public static final String RECIPIENT_NOT_EMPTY = "Recipient ID must NOT be empty.";
    public static final String EMPTY_TRANSFER_AMOUNT = "Transfer amount must NOT be empty.";
    public static final String SENDER_NOT_EXIST = "Sender ID doesn't exist.";
    public static final String RECIPIENT_NOT_EXIST = "Recipient ID doesn't exist.";
    public static final String DUPLICATE_SENDER = "Sender and recipient must NOT be the same.";

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
