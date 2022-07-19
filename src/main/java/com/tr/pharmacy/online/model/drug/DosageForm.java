package com.tr.pharmacy.online.model.drug;

import com.tr.pharmacy.online.model.dto.DosageFormDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="dosage_forms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DosageForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    public DosageFormDTO toDosageFormDTO() {
        return new DosageFormDTO()
                .setId(String.valueOf(this.id))
                .setName(this.name);
    }
}
