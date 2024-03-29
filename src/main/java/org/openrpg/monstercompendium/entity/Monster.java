package org.openrpg.monstercompendium.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(schema = "monster_compendium_api")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private Template template;

    @OneToMany(mappedBy = "monster", orphanRemoval = true)
    private List<MonsterField> monsterFields;

}
