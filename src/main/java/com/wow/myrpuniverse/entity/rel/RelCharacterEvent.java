package com.wow.myrpuniverse.entity.rel;

import com.wow.myrpuniverse.entity.Event;
import com.wow.myrpuniverse.entity.pk.PkRelCharacterEvent;
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
@Table(name = "TB_REL_CHR_EVT")
@NoArgsConstructor
@AllArgsConstructor
public class RelCharacterEvent implements Serializable {

    @EmbeddedId
    private PkRelCharacterEvent id;

    @MapsId(value = "idCharacter")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_REL_CHR_ID")
    private Character character;

    @MapsId(value = "idEvent")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CD_REL_EVT_ID")
    private Event event;

    @Column(name = "DT_REL_ACQUISITION_DATE")
    private LocalDateTime acquisitionDate;
}
