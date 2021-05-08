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
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_REL_CHR_BDG")
@NoArgsConstructor
@AllArgsConstructor
public class RelCharacterBadge implements Serializable {

    @EmbeddedId
    private PkRelCharacterBadge id;

    @MapsId(value = "idCharacter")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_REL_CHR_ID")
    private Character character;

    @MapsId(value = "idBadge")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_REL_BDG_ID")
    private Badge badge;

    @Column(name = "DT_REL_ACQUISITION_DATE")
    private LocalDateTime acquisitionDate;
}
