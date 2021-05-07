package com.wow.myrpuniverse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TB_GUILD")
@NoArgsConstructor
@AllArgsConstructor
public class Guild implements Serializable {
}
