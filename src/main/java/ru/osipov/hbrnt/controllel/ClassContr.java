package ru.osipov.hbrnt.controllel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.osipov.hbrnt.model.ComposeKey;
import ru.osipov.hbrnt.model.Persons;
import ru.osipov.hbrnt.repository.MyCrudRepository;

import java.util.List;

@RestController
public class ClassContr {

    private MyCrudRepository rep;

    public ClassContr(MyCrudRepository rep) {
        this.rep = rep;
    }

//    @GetMapping("persons/by-city")
//    public List<Persons> getPersonByCity(@RequestParam String city) {
//        return rep.getPersonByCity(city);
//    }

    @GetMapping("persons/add")
    public Persons mySave() { //Лень передать через @RequestParam пэтому буду удалять в теле сам
        return rep.save(
                new Persons(
                        new ComposeKey("Dima2", "Dimych2", 35)
                        , "phone2"
                        , "Yaroslavl")
        );
    }

    @GetMapping("persons/del")
    public void myDel() { //Лень передать ComposeKey через @RequestParam пэтому буду удалять в теле сам
        rep.deleteById(new ComposeKey("Dima2", "Dimych2", 35));
    }

//    @GetMapping("/persons/by-city")
//    public List<Persons> myListPersons(@RequestParam String cityOfLiving) {
//        return rep.findByCityOfLiving(cityOfLiving);
//    }

}