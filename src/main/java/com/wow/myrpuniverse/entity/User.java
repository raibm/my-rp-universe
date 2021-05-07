package com.wow.myrpuniverse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_USR_USER")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USR_ID")
    @SequenceGenerator(name = "SEQ_USR_ID", sequenceName = "SEQ_USR_ID", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "NM_USR_NAME")
    @NotEmpty(message = "Name may not be empty")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
    private String name;

    @NotBlank(message = "E-mail may not be blank")
    @Column(name = "DS_USR_EMAIL")
    private String email;

    @NotBlank(message = "Password may not be blank")
    @Column(name = "DS_USR_PASSWORD")
    private String password;

    @Column(name = "DS_USR_AVATAR")
    private String avatarPath;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Character> characters;
}
