package com.sapient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "City")
@EntityListeners(AuditingEntityListener.class)
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @NotBlank
    private String state;

    @NotBlank
    private String country;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Theater> theTheater;
}
