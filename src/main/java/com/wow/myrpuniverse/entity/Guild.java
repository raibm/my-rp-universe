package com.wow.myrpuniverse.entity;

import com.wow.myrpuniverse.entity.rel.RelCharacterGuild;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_GLD_GUILD")
@NoArgsConstructor
@AllArgsConstructor
public class Guild implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_GLD_ID", sequenceName = "SEQ_GLD_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GLD_ID")
    private Long id;

    @NotEmpty(message = "Guild name may not be empty")
    @Size(min = 2, max = 50, message = "Guild name must be between 2 and 50 characters long")
    @Column(name = "GLD_NAME")
    private String name;

    @OneToMany(mappedBy = "guild", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Hierarchy> hierarchies;

    @OneToMany(mappedBy = "guild", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RelCharacterGuild> members;
}
