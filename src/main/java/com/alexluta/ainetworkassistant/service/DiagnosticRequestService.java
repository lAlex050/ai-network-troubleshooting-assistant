package com.alexluta.ainetworkassistant.service;


import com.alexluta.ainetworkassistant.dto.request.CreateDiagnosticRequestDto;
import com.alexluta.ainetworkassistant.dto.response.DiagnosticResponse;
import com.alexluta.ainetworkassistant.entity.DiagnosticRequest;
import com.alexluta.ainetworkassistant.entity.User;
import com.alexluta.ainetworkassistant.enums.SeverityLevel;
import com.alexluta.ainetworkassistant.exception.DiagnosticRequestNotFoundException;
import com.alexluta.ainetworkassistant.exception.UserNotFoundException;
import com.alexluta.ainetworkassistant.mapper.DiagnosticRequestMapper;
import com.alexluta.ainetworkassistant.repository.DiagnosticRequestRepository;
import com.alexluta.ainetworkassistant.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticRequestService {

    public final DiagnosticRequestRepository diagnosticRequestRepository;
    public final UserRepository userRepository;
    private final DiagnosticRequestMapper diagnosticRequestMapper;

    public DiagnosticRequestService(DiagnosticRequestRepository diagnosticRequestRepository, UserRepository userRepository, DiagnosticRequestMapper diagnosticRequestMapper){
        this.diagnosticRequestRepository = diagnosticRequestRepository;
        this.userRepository = userRepository;
        this.diagnosticRequestMapper = diagnosticRequestMapper;
    }

    public DiagnosticResponse addDiagnosticByUserId (Long userId, CreateDiagnosticRequestDto diagnosticRequestDto){
        User user = userRepository.findById(userId)
                .orElseThrow((() -> new UserNotFoundException(userId)));

        DiagnosticRequest diagnostic = diagnosticRequestMapper.toEntity(diagnosticRequestDto);
        diagnostic.setUser(user);
        // mock uri pentru ca nu avem inca ai integrat
        diagnostic.setAiResponse("Possible routing issue detected.");
        diagnostic.setSeverity(SeverityLevel.MEDIUM);
        return diagnosticRequestMapper.toDto(diagnosticRequestRepository.save(diagnostic));

    }


    public List<DiagnosticResponse> getAllDiagnosticsByUserId(Long userId){
        userRepository.findById(userId)
                      .orElseThrow(() -> new UserNotFoundException(userId));


        List<DiagnosticRequest> diagnostics = diagnosticRequestRepository.findByUserId(userId);

                return diagnostics.stream()
                .map(diagnosticRequestMapper::toDto)
                .toList();

    }

    public DiagnosticResponse getDiagnosticById(Long id){

        DiagnosticRequest diagnostic = diagnosticRequestRepository.findDiagnosticRequestById(id)
                .orElseThrow(() -> new DiagnosticRequestNotFoundException(id));

        return diagnosticRequestMapper.toDto(diagnostic);

    }


}
