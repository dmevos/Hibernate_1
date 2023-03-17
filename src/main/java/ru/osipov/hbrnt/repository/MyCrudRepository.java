package ru.osipov.hbrnt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import ru.osipov.hbrnt.model.ComposeKey;
import ru.osipov.hbrnt.model.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyCrudRepository extends CrudRepository<Persons, ComposeKey> {

//    Optional<Persons> findByComposeKey(ComposeKey composeKey);

    public List<Persons> findByCityOfLiving(String cityOfLiving);

}
