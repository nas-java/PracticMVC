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

        people.add(new person(++PEOPLE_COUNT,"Tom", 25,"tom@yandex.ru"));
        people.add(new person(++PEOPLE_COUNT,"Maga",2,"m@yandex.ru"));
        people.add(new person(++PEOPLE_COUNT,"Omar",15,"o@yandex.ru"));
        people.add(new person(++PEOPLE_COUNT,"Vlad",35,"vlad@yandex.ru"));

    }

    public List<person> index(){
        return people;
    }

    public person show(int id){

        return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }

    public void save(person p){
        p.setId(++PEOPLE_COUNT);
        people.add(p);
    }

    public void update(int id, person updatedPerson) {
        person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p->p.getId()==id);
    }
}
