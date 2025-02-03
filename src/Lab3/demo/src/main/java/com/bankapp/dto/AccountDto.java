package com.bankapp.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private int id;
    
    @NotBlank(message = "Name cannot be null")
    private String name;
    
    @NotNull(message = "Account balance cannot be null")
    @DecimalMin(value = "0.0", message = "Account should have minimum balance of 0 rupees")
    private Double balance;
}