package com.alexluta.ainetworkassistant.dto.request;

import com.alexluta.ainetworkassistant.enums.DiagnosticCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDiagnosticRequestDto {

    @NotBlank
    private String problemDescription;

    private String deviceOutput;

    @NotNull
    private DiagnosticCategory category;
}
