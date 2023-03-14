package ru.osipov.hbrnt.controllel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.osipov.hbrnt.model.Persons;
import ru.osipov.hbrnt.repository.ClassRep;

import java.util.List;

@RestController
public class ClassContr {
    final ClassRep rep;

    public ClassContr(ClassRep rep) {
        this.rep = rep;
    }

    @GetMapping("persons/by-city")
    public List<Persons> getPersonByCity(@RequestParam String city) {
        return rep.getPersonByCity(city);
    }
}