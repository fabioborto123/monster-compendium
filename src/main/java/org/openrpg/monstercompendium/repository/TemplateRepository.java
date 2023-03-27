package org.openrpg.monstercompendium.repository;

import org.openrpg.monstercompendium.entity.Field;
import org.openrpg.monstercompendium.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template, BigInteger> {

}
