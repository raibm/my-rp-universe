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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;


/**
 * @author rai.maciel
 * Entidade responsável pelo gerenciamento de Badges.
 *
 *   As Badges são usadas para representar conquistas dos personagens (Characters),
 * podendo ser raras ou não.
 * @version 0.0.0
 */

@Getter
@Setter
@Entity
@Table(name = "TB_BDG_BADGE")
@NoArgsConstructor
@AllArgsConstructor
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BDG_ID")
    @SequenceGenerator(name = "SEQ_BDG_ID", sequenceName = "SEQ_BDG_ID", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "BDG_NAME")
    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters long")
    private String name;

    @Column(name = "BDG_DESCRIPTION")
    @NotEmpty(message = "Description may not be empty")
    @Size(max = 32, message = "Description size exceeds limit")
    private String description;

    @Column(name = "BDT_CREATION")
    private LocalDate creationDate;

}
