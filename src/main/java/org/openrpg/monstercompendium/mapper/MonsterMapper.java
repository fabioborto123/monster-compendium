package org.openrpg.monstercompendium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.openrpg.monstercompendium.dto.MonsterDto;
import org.openrpg.monstercompendium.entity.Monster;

import java.math.BigInteger;

@Mapper(componentModel = "spring")
public interface MonsterMapper {

    @Mapping(source = "templateId", target = "template.id")
    Monster toEntity(MonsterDto monsterDto);


    @Mapping(source = "template.id", target = "templateId")
    MonsterDto toDto(Monster monster);



}