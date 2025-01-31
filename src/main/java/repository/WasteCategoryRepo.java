package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepo extends JpaRepository<WasteCategory, Long> {
    Optional<WasteCategory> findByName(String name);
}
