package com.binary_search_tree.main.Repo;

import com.binary_search_tree.main.Entity.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InputNumbersRepository extends CrudRepository<InputNumbersEntity, Long> {
    List<InputNumbersEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
        
    @Query(value = "SELECT * FROM input_numbers ORDER BY created_at DESC LIMIT 1", nativeQuery = true)
    List<InputNumbersEntity> findMostRecentEntry();
    List<InputNumbersEntity> findTopByOrderByCreatedAtDesc();
}