package gringotts.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", columnDefinition = "VARCHAR(50)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)", nullable = false)
    private String lastName;
    @Column(columnDefinition = "TEXT")
    private String notes;
    @Column(columnDefinition = "INT", nullable = false)
    private int age;
    @Column(name = "magic_wand_creator", columnDefinition = "VARCHAR(100)")
    private String magicWandCreator;
    @Column(name = "magic_wand_size")
    private short magicWandSize;
    @Column(name = "deposit_group", columnDefinition = "VARCHAR(20)")
    private String depositGroup;
    @Column(name = "deposit_start_date")
    private LocalDateTime depositStartDate;
    @Column(name = "deposit_amount", columnDefinition = "DECIMAL(19,4)")
    private BigDecimal depositAmount;
    @Column(name = "deposit_interest")
    private double depositInterest;
    @Column(name = "deposit_charge", columnDefinition = "DECIMAL(19,4)")
    private BigDecimal depositCharge;
    @Column(name = "deposit_expiration_date")
    private LocalDateTime depositExpirationDate;
    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;
}
