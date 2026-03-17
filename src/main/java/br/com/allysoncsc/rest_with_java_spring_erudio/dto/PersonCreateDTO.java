package br.com.allysoncsc.rest_with_java_spring_erudio.dto;

import java.util.Date;
import jakarta.validation.constraints.NotBlank;

public record PersonCreateDTO(
        @NotBlank(message = "firstName é obrigatório")
        String firstName,
         String lastName,
        String address,
         String gender,
         Date birth
) {
}
