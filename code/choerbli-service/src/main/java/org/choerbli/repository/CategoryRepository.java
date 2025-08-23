package org.choerbli.repository;

import org.choerbli.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<Category> findAllById(Iterable<UUID> uuids);
}
