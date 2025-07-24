package com.std.sbb;

import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    int lastId;
    List<Person> people;

    PersonController() {
        lastId = 0;
        people = new ArrayList<>();
    }

    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        lastId++;
        Person p = new Person(lastId, age, name);
        people.add(p);

        return String.format("%d번째 사람이 추가되었습니다.", p.getId());
    }

    @GetMapping("/person/people")
    @ResponseBody
    public List<Person> getPeople() {
        System.out.println(people);
        return people;
    }

    @GetMapping("/person/remove")
    @ResponseBody
    public String removePerson(@RequestParam("id") int id) {
        boolean removed = false;

        for (Person person : people) {
            if (person.getId() == id) {
                people.remove(person);
                removed = true;
            }
        }

        if ( removed == false ) {
            return id + "번 사람이 존재하지 않습니다.";
        }

        return id + "번 사람이 삭제되었습니다.";
    }

    @GetMapping("/person/remove2")
    @ResponseBody
    public String removePerson2(@RequestParam("id") int id) {
        boolean removed = people.removeIf(person -> person.getId() == id);

        if ( removed == false ) {
            return id + "번 사람이 존재하지 않습니다.";
        }

        return id + "번 사람이 삭제되었습니다.";
    }
}


@AllArgsConstructor
@Getter
@Setter
@ToString
class Person {
    private int id;
    private int age;
    private String name;
}