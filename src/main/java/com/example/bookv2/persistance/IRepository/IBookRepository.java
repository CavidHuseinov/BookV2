package com.example.bookv2.persistance.IRepository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Integer, Id> {
}
