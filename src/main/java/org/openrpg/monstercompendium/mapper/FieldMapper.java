package org.openrpg.monstercompendium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openrpg.monstercompendium.dto.FieldDto;
import org.openrpg.monstercompendium.entity.Field;

@Mapper(componentModel = "spring")
public interface FieldMapper {


    Field toEntity(FieldDto fieldDto);

}
