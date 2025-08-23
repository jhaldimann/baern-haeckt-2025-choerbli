package org.choerbli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "CONSEQUENCES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consequence {
    @Id
    @GeneratedValue()
    private UUID id;
    private String description;
    private int orderOfApplication;
    private int type;
    @ManyToOne
    private Choerbli choerbli;
}
