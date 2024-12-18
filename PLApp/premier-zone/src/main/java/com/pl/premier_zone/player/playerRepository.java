package com.pl.premier_zone.player;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface playerRepository extends JpaRepository<playerEntity, String /* the type of it's PK*/> {
// this extends the JPA repository interface which provides CRUD operations
    void deleteByName(String name);
    // add other methods for crud operations
    Optional<playerEntity> findByName(String name);
}
