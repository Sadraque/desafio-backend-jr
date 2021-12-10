package com.desafiobackendjr.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    @NotEmpty(message = "marca é obrigatório")
    private String marca;

    @NotEmpty(message = "modelo é obrigatório")
    private String modelo;
}
