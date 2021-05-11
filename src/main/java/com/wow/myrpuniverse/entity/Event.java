package com.wow.myrpuniverse.entity;

import com.wow.myrpuniverse.entity.rel.RelCharacterEvent;
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
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_EVT_EVENT")
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_EVT_ID", sequenceName = "SEQ_EVT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVT_ID")
    private Long id;

    @Column(name = "NM_EVT_NAME")
    private String name;

    @Column(name = "DS_EVT_DESCRIPTION")
    private String description;

    @Column(name = "DT_EVT_START_DATE")
    private LocalDateTime startDate;

    @Column(name = "DT_EVT_END_DATE")
    private LocalDateTime endDate;

    @Column(name = "DS_EVT_BANNER")
    private String banner;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RelCharacterEvent> participants;
}
