package com.tr.pharmacy.online.model.drug;

import com.tr.pharmacy.online.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="drugs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(nullable = false)
    private int dosageForm;

    private String usage;

    @Column(nullable = false, precision = 12)
    private BigDecimal pricePerUnit;

    @Column(nullable = false)
    private LocalDate productionDate;

    @Column(nullable = false)
    private LocalDate expirationDate;

    private String note;

}
