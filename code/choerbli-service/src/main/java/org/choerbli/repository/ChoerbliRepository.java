package org.choerbli.repository;

import org.choerbli.model.Choerbli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChoerbliRepository extends JpaRepository<Choerbli, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<Choerbli> findAllById(Iterable<UUID> uuids);
}
