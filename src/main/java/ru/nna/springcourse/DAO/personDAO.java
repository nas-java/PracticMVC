package ru.nna.springcourse.DAO;

import org.springframework.stereotype.Component;
import ru.nna.springcourse.model.person;

import java.util.ArrayList;
import java.util.List;

@Component
public class personDAO {
    private static int PEOPLE_COUNT;
    public List<person> people;

    {
        people=new ArrayList<>();

        people.add(new person(++PEOPLE_COUNT,"Tom"));
        people.add(new person(++PEOPLE_COUNT,"Maga"));
        people.add(new person(++PEOPLE_COUNT,"Omar"));
        people.add(new person(++PEOPLE_COUNT,"Vlad"));

    }

    public List<person> index(){
        return people;
    }

    public person show(int id){

        return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }

}
