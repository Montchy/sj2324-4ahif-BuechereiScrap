package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {
}
