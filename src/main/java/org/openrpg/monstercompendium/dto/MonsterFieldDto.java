package org.openrpg.monstercompendium.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MapsId;
import lombok.*;
import org.hibernate.annotations.CollectionId;
import org.mapstruct.Mapping;
import org.openrpg.monstercompendium.entity.Field;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonsterFieldDto {

    private BigInteger id;

    private String value;

    private FieldIdDto field;
}
