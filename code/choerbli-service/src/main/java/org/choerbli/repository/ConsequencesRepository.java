package org.choerbli.repository;

import org.choerbli.model.Consequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConsequencesRepository extends JpaRepository<Consequence, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<Consequence> findAllById(Iterable<UUID> uuids);
}
