package org.openrpg.monstercompendium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Mapping;
import org.openrpg.monstercompendium.entity.Template;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonsterDto {

    private BigInteger id;

    private String name;

    private BigInteger templateId;

    private List<MonsterFieldDto> monsterFields;

}
