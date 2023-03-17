package ru.osipov.hbrnt.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "persons")
public class Persons {
    @EmbeddedId
    ComposeKey composeKey;
    @Column(name = "phone_number", length = 11)
    String phoneNumber;
    @Column(name = "city_of_living", length = 30)
    String cityOfLiving;
}

