package com.bankapp.dto;

import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {
    private int from;
    private int to;

    @DecimalMin(value = "0.0")
    private Double amount;
}
