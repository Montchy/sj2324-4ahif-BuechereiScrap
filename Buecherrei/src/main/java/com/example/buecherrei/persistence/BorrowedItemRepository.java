package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.BorrowedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedItemRepository extends JpaRepository<BorrowedItem,Long> {
}
