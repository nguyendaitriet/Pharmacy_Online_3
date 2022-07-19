package com.tr.pharmacy.online.model.drug;

import com.tr.pharmacy.online.model.BaseEntity;
import com.tr.pharmacy.online.model.dto.DrugDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="drugs")
@Accessors(chain = true)
public class Drug extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String drugName;

    @Column(nullable = false, scale = 1)
    private double drugContent;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "dosageForm_id", referencedColumnName = "id")
    private DosageForm dosageForm;

    private String drugUsage;

    @Column(nullable = false, precision = 12)
    private BigDecimal pricePerUnit;

    @Column(nullable = false)
    private LocalDate productionDate;

    @Column(nullable = false)
    private LocalDate expirationDate;

    private String note;

    public DrugDTO toDrugDTO() {
        return new DrugDTO()
                .setId(this.id)
                .setDrugName(this.drugName)
                .setDrugContent(String.valueOf(this.drugContent))
                .setQuantity(String.valueOf(this.quantity))
                .setPricePerUnit(String.valueOf(this.pricePerUnit))
                .setExpirationDate(this.expirationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
