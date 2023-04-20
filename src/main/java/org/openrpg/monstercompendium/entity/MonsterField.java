package org.openrpg.monstercompendium.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monster_field",schema = "monster_compendium_api")

public class MonsterField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monster_id")
    private Monster monster;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "field_id")
    private Field field;


}
