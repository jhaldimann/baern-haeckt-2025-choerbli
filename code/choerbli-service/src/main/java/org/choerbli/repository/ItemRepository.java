package org.choerbli.repository;

import jakarta.persistence.Entity;
import org.choerbli.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<Item> findAllById(Iterable<UUID> uuids);

    List<Item> findAllByChoerbliId(UUID choerbliId);
}
