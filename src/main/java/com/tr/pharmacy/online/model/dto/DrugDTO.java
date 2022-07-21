package com.tr.pharmacy.online.model.dto;


import com.tr.pharmacy.online.model.drug.DosageForm;
import com.tr.pharmacy.online.model.drug.Drug;
import com.tr.pharmacy.online.utils.ErrorMessage;
import com.tr.pharmacy.online.utils.ParsingValidationUtils;
import com.tr.pharmacy.online.utils.ValidationUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class DrugDTO implements Validator {

    private Long id;
    private String drugName;
    private String drugContent;
    private String quantity;
    private String pricePerUnit;
    private String productionDate;
    private String expirationDate;
    private String drugUsage;
    private String note;

    @Valid
    private DosageFormDTO dosageForm;

    public DrugDTO(Long id, String drugName, double drugContent, int quantity, BigDecimal pricePerUnit, LocalDate expirationDate) {
        this.id = id;
        this.drugName = drugName;
        this.drugContent = String.valueOf(drugContent);
        this.quantity = String.valueOf(quantity);
        this.pricePerUnit = String.valueOf(pricePerUnit);
        this.expirationDate = expirationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return DrugDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        DrugDTO drugDTO = (DrugDTO) target;
        String drugName = drugDTO.getDrugName();
        String drugContent = drugDTO.getDrugContent();
        String quantity = drugDTO.getQuantity();
        String pricePerUnit = drugDTO.getPricePerUnit();
        String productionDate = drugDTO.getProductionDate();
        String expirationDate = drugDTO.getExpirationDate();

        if (drugName.equals("") || drugName == null) {
            errors.rejectValue("drugName","400", ErrorMessage.getNotEmptyMessage("Drug name"));
        }
        else {
            boolean isDrugNameIdValid = Pattern.matches(ValidationUtils.FULL_NAME_REGEX, drugName);
            if (!isDrugNameIdValid) {
                errors.rejectValue("drugName","400", ErrorMessage.VALID_DRUG_NAME);
            }
            else if (drugName.length() > 100) {
                errors.rejectValue("drugName","400", ErrorMessage.MAX_DRUG_NAME_LENGTH);
            }
        }

        if (drugContent.equals("") || drugContent == null) {
            errors.rejectValue("drugContent","400", ErrorMessage.getNotEmptyMessage("Drug content"));
        }
        else {
            boolean isDrugContentValid = Pattern.matches(ValidationUtils.DOUBLE_REGEX, drugContent);
            if (!isDrugContentValid) {
                errors.rejectValue("drugContent","400", ErrorMessage.getNotNumberMessage("Drug content"));
            }
            else {
                double validDrugContent = Double.parseDouble(drugContent);
                if (validDrugContent <= 0) {
                    errors.rejectValue("drugContent","400", ErrorMessage.getMinValue("Drug content", "0"));
                }
                if (validDrugContent > 10000000) {
                    errors.rejectValue("drugContent","400", ErrorMessage.getMaxValue("Drug content", "10,000,000"));
                }
            }
        }

        if (quantity.equals("") || quantity == null) {
            errors.rejectValue("quantity","400", ErrorMessage.getNotEmptyMessage("Quantity"));
        }
        else {
            boolean isQuantityValid = Pattern.matches(ValidationUtils.INTEGER_REGEX, quantity);
            if (!isQuantityValid) {
                errors.rejectValue("quantity","400", ErrorMessage.getNotNumberMessage("Quantity"));
            }
            else {
                int validQuantity = Integer.parseInt(quantity);
                if (validQuantity <= 0) {
                    errors.rejectValue("quantity","400", ErrorMessage.getMinValue("Quantity", "0"));
                }
                if (validQuantity > 5000000) {
                    errors.rejectValue("quantity","400", ErrorMessage.getMaxValue("Quantity", "5,000,000"));
                }
            }
        }

        if (pricePerUnit.equals("") || pricePerUnit == null) {
            errors.rejectValue("pricePerUnit","400", ErrorMessage.getNotEmptyMessage("Price"));
        }
        else {
            boolean isPricePerUnitValid = Pattern.matches(ValidationUtils.INTEGER_REGEX, pricePerUnit);
            if (!isPricePerUnitValid) {
                errors.rejectValue("pricePerUnit","400", ErrorMessage.getNotNumberMessage("Price"));
            }
            else {
                int validPricePerUnit = Integer.parseInt(pricePerUnit);
                if (validPricePerUnit <= 0) {
                    errors.rejectValue("pricePerUnit","400", ErrorMessage.getMinValue("Price", "0"));
                }
                if (validPricePerUnit > 5000000) {
                    errors.rejectValue("pricePerUnit","400", ErrorMessage.getMaxValue("Price", "5,000,000"));
                }
            }
        }

        if (productionDate.equals("") || productionDate == null) {
            errors.rejectValue("productionDate","400", ErrorMessage.getNotEmptyMessage("Production date"));
        }
        else {
            if (!ParsingValidationUtils.isParsableToLocalDate(productionDate)) {
                errors.rejectValue("productionDate","400", ErrorMessage.getNotEmptyMessage("Production date"));
            }
            else {
                LocalDate validProductionDate = LocalDate.parse(productionDate);
                if (!ValidationUtils.checkProductionDate(validProductionDate)) {
                    errors.rejectValue("productionDate","400", ErrorMessage.getProductionDateLimit(ValidationUtils.minProductionDate));
                }
            }
        }

        if (expirationDate.equals("") || expirationDate == null) {
            errors.rejectValue("expirationDate","400", ErrorMessage.getNotEmptyMessage("Expiration date"));
        }
        else {
            if (!ParsingValidationUtils.isParsableToLocalDate(expirationDate)) {
                errors.rejectValue("expirationDate","400", ErrorMessage.getNotEmptyMessage("Expiration date"));
            }
            else {
                LocalDate validExpirationDate = LocalDate.parse(expirationDate);
                if (!ValidationUtils.checkExpirationDate(validExpirationDate)) {
                    errors.rejectValue("expirationDate","400", ErrorMessage.getExpirationDateLimit(ValidationUtils.maxExpirationDate));
                }
            }
        }

    }

    public Drug toDrug(DosageForm dosageForm) {
        return new Drug()
                .setId(this.id)
                .setDrugName(this.drugName.trim())
                .setDrugContent(Double.parseDouble(this.drugContent))
                .setQuantity(Integer.parseInt(this.quantity))
                .setPricePerUnit(new BigDecimal(this.pricePerUnit))
                .setDosageForm(dosageForm)
                .setDrugUsage(this.drugUsage.trim())
                .setProductionDate(LocalDate.parse(this.productionDate))
                .setExpirationDate(LocalDate.parse(this.expirationDate))
                .setNote(this.note.trim());
    }
}
