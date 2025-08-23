package org.choerbli.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "VOTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vote {
    @Id
    @GeneratedValue
    private UUID id;
    private int factor;
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemDescription itemDescriptorId;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Choerbli choerbliId;
}
