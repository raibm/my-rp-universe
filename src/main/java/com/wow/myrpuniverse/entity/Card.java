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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NotEmpty(message = "Card name may not be empty")
    @Size(min = 1, max = 50, message = "Card name must be between 1 and 50 characters long")
    @Column(name = "CRD_TITLE")
    private String title;

    @Column(name = "CRD_DESCRIPTION")
    @Size(max = 200, message = "Card description size exceeds limit")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CRD_CHARACTER_ID", referencedColumnName = "ID")
    private Character character;
}
