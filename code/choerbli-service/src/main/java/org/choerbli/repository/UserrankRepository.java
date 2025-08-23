package org.choerbli.repository;

import org.choerbli.model.Userrank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserrankRepository extends JpaRepository<Userrank, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<Userrank> findAllById(Iterable<UUID> uuids);
}
