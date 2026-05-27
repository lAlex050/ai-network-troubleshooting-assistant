package com.alexluta.ainetworkassistant.repository;

import com.alexluta.ainetworkassistant.entity.DiagnosticRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DiagnosticRequestRepository extends JpaRepository<DiagnosticRequest, Long> {

    List<DiagnosticRequest> findByUserId(Long userId);

    @Query("select d from DiagnosticRequest d where d.id = :id")
    Optional<DiagnosticRequest> findDiagnosticRequestById(@Param("id") Long id);
}
