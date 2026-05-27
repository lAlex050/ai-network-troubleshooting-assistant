package com.alexluta.ainetworkassistant.controller;

import com.alexluta.ainetworkassistant.dto.request.CreateDiagnosticRequestDto;
import com.alexluta.ainetworkassistant.dto.response.DiagnosticResponse;
import com.alexluta.ainetworkassistant.entity.DiagnosticRequest;
import com.alexluta.ainetworkassistant.service.DiagnosticRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DiagnosticRequestController {

    public final DiagnosticRequestService diagnosticRequestService;

    public DiagnosticRequestController(DiagnosticRequestService diagnosticRequestService){
        this.diagnosticRequestService = diagnosticRequestService;
    }

    @PostMapping("/users/{userId}/diagnostics")
    public ResponseEntity<DiagnosticResponse> addDiagnosticByUserId(@PathVariable Long userId,
                                                                    @Valid @RequestBody CreateDiagnosticRequestDto dto){

        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticRequestService.addDiagnosticByUserId(userId, dto));
    }

    @GetMapping("/users/{userId}/diagnostics")
    public ResponseEntity<List<DiagnosticResponse>> getDiagnosticsByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(diagnosticRequestService.getAllDiagnosticsByUserId(userId));
    }

    @GetMapping("/diagnostics/{id}")
    public ResponseEntity<DiagnosticResponse> getDiagnosticRequestById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(diagnosticRequestService.getDiagnosticById(id));
    }

}
