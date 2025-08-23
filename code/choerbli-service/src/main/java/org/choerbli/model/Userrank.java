package org.choerbli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "USERRANK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Userrank {
    @Id
    @GeneratedValue()
    private UUID id;
    private int points;
    @ManyToOne(fetch = FetchType.LAZY)
    private Choerbli choerbliId;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
}
