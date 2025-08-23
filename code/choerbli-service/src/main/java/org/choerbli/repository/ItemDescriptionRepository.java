package org.choerbli.repository;

import org.choerbli.model.ItemDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ItemDescriptionRepository extends JpaRepository<ItemDescription, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<ItemDescription> findAllById(Iterable<UUID> uuids);
}
