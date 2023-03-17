package ru.osipov.hbrnt.repository;

import org.springframework.data.repository.CrudRepository;
import ru.osipov.hbrnt.model.ComposeKey;
import ru.osipov.hbrnt.model.Persons;

import java.util.List;
import java.util.Optional;

public interface MyCrudRepository extends CrudRepository<Persons, ComposeKey> {

    public List<Persons> findAllByCityOfLiving(String cityOfLiving);
    public List<Persons> findAllByComposeKeyAgeLessThanOrderByComposeKeyAge(int age);
    Optional<Persons> findByComposeKeyNameAndComposeKeySurname(String name, String surname);
}