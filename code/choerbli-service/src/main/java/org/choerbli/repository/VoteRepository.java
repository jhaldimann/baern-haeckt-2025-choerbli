package org.choerbli.repository;

import org.choerbli.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<Vote, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<Vote> findAllById(Iterable<UUID> uuids);

    List<Vote> findByUserId(UUID userId);
}
