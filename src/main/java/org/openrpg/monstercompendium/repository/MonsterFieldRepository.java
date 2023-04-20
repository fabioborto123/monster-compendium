package org.openrpg.monstercompendium.repository;

import jakarta.transaction.Transactional;
import org.openrpg.monstercompendium.entity.MonsterField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MonsterFieldRepository extends JpaRepository<MonsterField, BigInteger> {


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from monster_compendium_api.monster_field where field_id = ?1")
    void deleteByFieldId(BigInteger fieldId);
}
