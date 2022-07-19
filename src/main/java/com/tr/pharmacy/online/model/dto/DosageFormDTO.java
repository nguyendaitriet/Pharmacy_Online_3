package com.tr.pharmacy.online.model.dto;

import com.tr.pharmacy.online.utils.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class DosageFormDTO implements Validator {

    private String id;
    private String name;

    @Override
    public boolean supports(Class<?> clazz) {
        return DosageFormDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DosageFormDTO dosageFormDTO = (DosageFormDTO) target;
        String dosageFormId = dosageFormDTO.getId();

        if (dosageFormId.equals("") || dosageFormId == null) {
            errors.rejectValue("dosageForm","400", ErrorMessage.getNotEmptyMessage("Dosage form ID"));
            return;
        }

        boolean isDosageFormIdValid = java.util.regex.Pattern.matches("\\d+", dosageFormId);
        if (!isDosageFormIdValid) {
            errors.rejectValue("dosageForm","400", ErrorMessage.getNotNumberMessage("Dosage form ID"));
        }
    }

}
