package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook,Long> {
}
