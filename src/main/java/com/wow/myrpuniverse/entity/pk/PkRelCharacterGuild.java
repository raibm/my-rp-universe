package com.wow.myrpuniverse.entity.pk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PkRelCharacterGuild implements Serializable {

    private Long idCharacter;
    private Long idGuild;
}
