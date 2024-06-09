package com.example.billing.repository;

import com.example.billing.model.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    @Modifying
    @Query(nativeQuery = true, value = """
            update cards
            set deleted = true
            where id = :id
            """)
    void deleteById(@Param("id") UUID id);
}
