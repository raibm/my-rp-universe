package com.wow.myrpuniverse.entity;

import com.wow.myrpuniverse.entity.rel.RelCharacterBadge;
import com.wow.myrpuniverse.enumeration.CurrentSituationEnum;
import com.wow.myrpuniverse.enumeration.converter.CurrentSituationConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_CHR_CHARACTER")
@NoArgsConstructor
@AllArgsConstructor
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHR_ID")
    @SequenceGenerator(name = "SEQ_CHR_ID", sequenceName = "SEQ_CHR_ID", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "NM_CHR_NAME")
    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters long")
    private String name;

    @Column(name = "DS_CHR_DESCRIPTION")
    @Size(max = 5000, message = "Description size exceeds limit")
    private String description;

    @Column(name = "DS_CHR_AVATAR")
    private String avatarPath;

    @Max(value = 999999, message = "Age size exceeds limit")
    @Column(name = "DS_CHR_AGE")
    private Long age;

    @Convert(converter = CurrentSituationConverter.class)
    @OrderColumn(name = "DS_CHR_CURRENT_SITUATION")
    private CurrentSituationEnum currentSituation;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RelCharacterBadge> badges;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Card> cards;

    @ManyToOne
    @JoinColumn(name = "CD_CHR_USR_ID", referencedColumnName = "ID")
    private User user;
}
