package org.choerbli.repository;

import org.choerbli.model.Choerbli;
import org.choerbli.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Override
    @Transactional(readOnly = true)
    List<User> findAllById(Iterable<UUID> uuids);

    List<User> findAllByChoerbli(final Choerbli choerbli);
}
