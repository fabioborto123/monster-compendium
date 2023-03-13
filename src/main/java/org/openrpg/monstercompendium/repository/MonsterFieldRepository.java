package org.openrpg.monstercompendium.repository;

import org.openrpg.monstercompendium.entity.MonsterField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MonsterFieldRepository extends JpaRepository<MonsterField, BigInteger> {


}
