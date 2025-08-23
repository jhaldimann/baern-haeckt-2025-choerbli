package org.choerbli.repository;

import org.choerbli.model.UserRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRankRepository extends JpaRepository<UserRank, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<UserRank> findAllById(Iterable<UUID> uuids);
}
