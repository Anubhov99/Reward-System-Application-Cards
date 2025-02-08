package com.infosys.amex.RewardSystemApplication.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;


    private Double amount;


    private double cashback;

    @Version  // Optimistic locking
    private Integer version;
}
