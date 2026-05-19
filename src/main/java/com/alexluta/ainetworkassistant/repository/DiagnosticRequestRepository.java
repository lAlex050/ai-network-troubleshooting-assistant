package com.alexluta.ainetworkassistant.repository;

import com.alexluta.ainetworkassistant.entity.DiagnosticRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosticRequestRepository extends JpaRepository<DiagnosticRequest, Long> {

    List<DiagnosticRequest> findByUserId(Long userId);
}
