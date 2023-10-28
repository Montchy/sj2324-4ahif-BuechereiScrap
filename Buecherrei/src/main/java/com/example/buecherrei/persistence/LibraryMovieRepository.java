package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.LibraryMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryMovieRepository extends JpaRepository<LibraryMovie,Long> {
}
