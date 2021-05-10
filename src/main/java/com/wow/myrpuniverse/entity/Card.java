package com.wow.myrpuniverse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TB_CRD_CARD")
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CRD_ID")
    @SequenceGenerator(name = "SEQ_CRD_ID", sequenceName = "SEQ_CRD_ID", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "NM_CRD_TITLE")
    private String title;

    @Column(name = "DS_CRD_DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CD_CRD_CHARACTER_ID", referencedColumnName = "ID")
    private Character character;
}
