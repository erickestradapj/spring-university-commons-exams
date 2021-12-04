package com.dev.microservices.commons.exams.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnoreProperties(value = {"sons"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject parent;

    @JsonIgnoreProperties(value = {"parent"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Subject> sons;

    public Subject() {
        this.sons = new ArrayList<>();
    }
}
