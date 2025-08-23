package org.choerbli.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "ITEMDESCRIPTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDescription {
    @Id
    @GeneratedValue()
    private UUID id;
    private String name;
    @ManyToOne
    private Category categoryId;
}
