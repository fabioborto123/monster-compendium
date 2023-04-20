package org.openrpg.monstercompendium.mapper;

import org.mapstruct.Mapper;
import org.openrpg.monstercompendium.dto.TemplateDto;
import org.openrpg.monstercompendium.entity.Template;


@Mapper(componentModel = "spring")
public interface TemplateMapper {


     Template toEntity(TemplateDto templateDto);

     TemplateDto toDto(Template template);

}
