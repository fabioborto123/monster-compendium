package org.openrpg.monstercompendium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldDto {

    private BigInteger id;

    private String name;

    private Boolean active;


}
