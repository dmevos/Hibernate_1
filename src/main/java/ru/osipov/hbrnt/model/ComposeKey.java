package ru.osipov.hbrnt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
@Table(name = "persons")
public class ComposeKey implements Serializable {

    @Column(name = "name", length = 30)
    String name;
    @Column(name = "surname", length = 50)
    String surname;
    @Column(name = "age")
    int age;
}