package br.com.desafio.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private UUID id;

    @Column(nullable = false, length = 4)
    private String originAgency;

    @Column(nullable = false, length = 6)
    private String originAccount;

    @Column(nullable = false, length = 4)
    private String destinationAgency;

    @Column(nullable = false, length = 6)
    private String destinationAccount;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal transferAmount;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tax;

    @Column(nullable = false)
    private LocalDate transferDate;

    @Column(nullable = false)
    private LocalDate schedulingDate;

    public void builder(BigDecimal tax, LocalDate schedulingDate) {
        this.id = UUID.randomUUID();
        this.tax = tax;
        this.schedulingDate = schedulingDate;
    }

}
