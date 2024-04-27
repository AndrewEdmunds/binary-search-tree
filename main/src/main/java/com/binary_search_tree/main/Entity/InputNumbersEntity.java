package com.binary_search_tree.main.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "input_numbers")
public class InputNumbersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numbers", nullable = false)
    private String numbers; // Adjusted to match the column type in the database

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public InputNumbersEntity() {
    }

    public InputNumbersEntity(String numbers) { // Adjusted constructor parameter type
        this.numbers = numbers;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() { // Adjusted getter and setter
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}