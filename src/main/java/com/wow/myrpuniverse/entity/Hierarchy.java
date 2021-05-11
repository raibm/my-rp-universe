package com.wow.myrpuniverse.entity;

import lombok.Getter;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TB_HIR_HIERARCHY")
public class Hierarchy implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_HIR_ID", sequenceName = "SEQ_HIR_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVT_ID")
    private Long id;

    @Column(name = "NM_HIR_NAME")
    @NotEmpty(message = "Name may not be empty")
    @Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters long")
    private String name;

    @Column(name = "DS_HIR_DESCRIPTION")
    @Size(max = 200, message = "Description size exceeds limit")
    private String description;

    @NotNull(message = "Order may not be null")
    @Column(name = "CD_HIR_ORDER")
    private Long order;

    @ManyToOne
    @JoinColumn(name = "CD_HIR_GUILD_ID", referencedColumnName = "ID")
    private Guild guild;
}
