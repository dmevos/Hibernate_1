package ru.osipov.hbrnt.controllel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.osipov.hbrnt.model.ComposeKey;
import ru.osipov.hbrnt.model.Persons;
import ru.osipov.hbrnt.repository.MyCrudRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ClassContr {

    private final MyCrudRepository rep;

    public ClassContr(MyCrudRepository rep) {
        this.rep = rep;
    }

    @GetMapping("persons/add") //http://localhost:8080/persons/add
    public Persons mySave() { //Лень передать через @RequestParam пэтому буду удалять в теле сам
        return rep.save(
                new Persons(
                        new ComposeKey("Dima3", "Dimych3", 35)
                        , "phone3"
                        , "Yaroslavl")
        );
    }

    @GetMapping("persons/del") //http://localhost:8080/persons/del
    public void myDel() { //Лень передать ComposeKey через @RequestParam пэтому буду удалять в теле сам
        rep.deleteById(new ComposeKey("Dima3", "Dimych3", 35));
    }

    @GetMapping("persons/by-city")  //http://localhost:8080/persons/by-city?city=Kostroma
    public List<Persons> myListPersonsByCity(@RequestParam String city) {
        return rep.findAllByCityOfLiving(city);
    }

    @GetMapping("persons/by-age")  //http://localhost:8080/persons/by-age?age=29
    public List<Persons> myListPersonsByAge(@RequestParam String age){
        return rep.findAllByComposeKeyAgeLessThanOrderByComposeKeyAge(Integer.parseInt(age));
    }

    @GetMapping("persons/by-name_surname")  //http://localhost:8080/persons/by-name_surname?name=Dima3&surname=Dimych3
    public Optional<Persons> myListPersonsByAge(@RequestParam String name, @RequestParam String surname){
        return rep.findByComposeKeyNameAndComposeKeySurname(name, surname);
    }
}