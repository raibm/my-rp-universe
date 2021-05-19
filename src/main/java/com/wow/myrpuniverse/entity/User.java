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

    @Column(name = "USR_NAME")
    @NotEmpty(message = "User name may not be empty")
    @Size(min = 2, max = 32, message = "User name must be between 2 and 32 characters long")
    private String name;

    @Column(name = "USR_LAST_NAME")
    @Size(max = 40, message = "User last name must be 40 characters long")
    private String lastName;

    @NotBlank(message = "User e-mail may not be blank")
    @Column(name = "USR_EMAIL")
    private String email;

    @NotBlank(message = "User password may not be blank")
    @Column(name = "USR_PASSWORD")
    private String password;

    @Column(name = "USR_AVATAR")
    private String avatarPath;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Character> characters;
}
