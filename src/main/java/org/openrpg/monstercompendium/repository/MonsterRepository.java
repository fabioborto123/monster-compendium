package org.openrpg.monstercompendium.repository;

import org.openrpg.monstercompendium.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, BigInteger> {
}
