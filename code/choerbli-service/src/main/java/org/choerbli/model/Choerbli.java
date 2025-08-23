package org.choerbli.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "CHOERBLI")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Choerbli {
    @Id
    @GeneratedValue()
    private UUID id;
    private int state;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "choerbli")
    private Set<Item> items;
    @OneToMany(mappedBy = "choerbli")
    private Set<Vote> votes;
    @OneToMany(mappedBy = "choerbli")
    private Set<Consequence> consequences;
}
