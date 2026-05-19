package com.alexluta.ainetworkassistant.mapper;

import com.alexluta.ainetworkassistant.dto.request.CreateDiagnosticRequestDto;
import com.alexluta.ainetworkassistant.dto.response.DiagnosticResponse;
import com.alexluta.ainetworkassistant.entity.DiagnosticRequest;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticRequestMapper {

    public DiagnosticRequest toEntity(CreateDiagnosticRequestDto request) {
        return DiagnosticRequest.builder()
                .problemDescription(request.getProblemDescription())
                .deviceOutput(request.getDeviceOutput())
                .category(request.getCategory())
                .build();
    }

    public DiagnosticResponse toDto(DiagnosticRequest diagnosticRequest) {
        return DiagnosticResponse.builder()
                .id(diagnosticRequest.getId())
                .problemDescription(diagnosticRequest.getProblemDescription())
                .deviceOutput(diagnosticRequest.getDeviceOutput())
                .category(diagnosticRequest.getCategory())
                .aiResponse(diagnosticRequest.getAiResponse())
                .severity(diagnosticRequest.getSeverity())
                .createdAt(diagnosticRequest.getCreatedAt())
                .userId(diagnosticRequest.getUser().getId())
                .build();
    }
}
