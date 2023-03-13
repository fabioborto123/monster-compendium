package org.openrpg.monstercompendium.repository;

import org.openrpg.monstercompendium.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface FieldRepository extends JpaRepository<Field, BigInteger> {
}
