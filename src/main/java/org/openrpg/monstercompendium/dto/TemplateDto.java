package org.openrpg.monstercompendium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemplateDto {

    private BigInteger id;
    private String name;

    private List<FieldDto> fields;
}
