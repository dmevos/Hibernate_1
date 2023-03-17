package ru.osipov.hbrnt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.osipov.hbrnt.model.ComposeKey;
import ru.osipov.hbrnt.model.Persons;

import java.util.List;
import java.util.Optional;

public interface MyCrudRepository extends CrudRepository<Persons, ComposeKey> {

    @Query(value = "select * from persons where city_of_living like ?1", nativeQuery = true)
    List<Persons> getAllByCityOfLivingQuery(String cityOfLiving);

    @Query(value = "select * from persons where age<?1 order by age", nativeQuery = true)
    List<Persons> getAllByAgeLessThanOrderByAgeQuery(int age);

    @Query("select p from Persons p where p.composeKey.name = :name and p.composeKey.surname = :surname")
    Optional<Persons> getByNameAndSurnameJPQLQuery(String name, String surname);
}