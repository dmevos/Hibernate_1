package ru.osipov.hbrnt.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.osipov.hbrnt.model.Persons;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClassRep {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonByCity(String city) {
/*
        //Через SQL
        var result = entityManager.createNativeQuery(
                        "select name, surname from persons where city_of_living like '" + city + "';")
                .getResultList();
*/

        //Другим способом
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persons> criteria = builder.createQuery(Persons.class);
        criteria.from(Persons.class);
        List<Persons> products = entityManager.createQuery(criteria).getResultList();
        var result = products
                .stream()
                .filter(s -> city.equals(s.getCityOfLiving()))
                .collect(Collectors.toList());

        return result;
    }
}