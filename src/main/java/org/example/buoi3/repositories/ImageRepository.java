package org.example.buoi3.repositories;

import org.example.buoi3.models.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Images,Long> {
}
