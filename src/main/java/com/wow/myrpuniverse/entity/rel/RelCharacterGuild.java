package com.wow.myrpuniverse.entity.rel;

import com.wow.myrpuniverse.entity.Badge;
import com.wow.myrpuniverse.entity.pk.PkRelCharacterBadge;
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
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_REL_CHR_GLD")
@NoArgsConstructor
@AllArgsConstructor
public class RelCharacterGuild implements Serializable {

    @EmbeddedId
    private PkRelCharacterBadge id;

    @MapsId(value = "idCharacter")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_REL_CHR_ID")
    private Character character;

    @MapsId(value = "idGuild")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_REL_GLD_ID")
    private Badge badge;

    @Column(name = "DT_REL_ENTRY_DATE")
    private LocalDate entryDate;

    @Column(name = "DS_REL_CHR_DESCRIPTION")
    private String description;
}
