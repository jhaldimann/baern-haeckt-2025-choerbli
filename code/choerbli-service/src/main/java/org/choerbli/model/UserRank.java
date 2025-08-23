package org.choerbli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "USER_RANK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRank {
    @Id
    @GeneratedValue()
    private UUID id;
    private int points;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
