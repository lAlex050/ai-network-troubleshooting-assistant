package com.alexluta.ainetworkassistant.dto.response;

import com.alexluta.ainetworkassistant.enums.DiagnosticCategory;
import com.alexluta.ainetworkassistant.enums.SeverityLevel;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticResponse {
    private Long id;
    private String problemDescription;
    private String deviceOutput;
    private DiagnosticCategory category;
    private String aiResponse;
    private SeverityLevel severity;
    private Instant createdAt;
    private Long userId;

}
