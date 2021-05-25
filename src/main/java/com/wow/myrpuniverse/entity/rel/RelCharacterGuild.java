package com.wow.myrpuniverse.entity.rel;

import com.wow.myrpuniverse.entity.Guild;
import com.wow.myrpuniverse.entity.Hierarchy;
import com.wow.myrpuniverse.entity.pk.PkRelCharacterGuild;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TB_REL_CHR_GLD")
@NoArgsConstructor
@AllArgsConstructor
public class RelCharacterGuild implements Serializable {

    @EmbeddedId
    private PkRelCharacterGuild id;

    @MapsId(value = "idCharacter")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHR_CHARACTER_ID")
    private Character character;

    @MapsId(value = "idGuild")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GLD_GUILD_ID")
    private Guild guild;

    @Column(name = "REL_ENTRY_DATE")
    private LocalDate entryDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REL_HIR_HIERARCHY_ID")
    private Hierarchy hierarchy;
}
