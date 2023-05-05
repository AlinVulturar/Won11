import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
class Person {
    int id;
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class PersonService {
    private List<Person> persons = new ArrayList<>();
    private int idCounter = 1;

    public Person addPerson(Person person) {
        person.id = idCounter++;
        persons.add(person);
        return person;
    }

    public Person removePerson(int id) {
        Person personToRemove = getPersonById(id);
        if (personToRemove == null) {
            throw new RuntimeException("Person not found");
        }
        persons.remove(personToRemove);
        return personToRemove;
    }

    public List<Person> getAllPersons() {
        return persons;
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }
        return persons.stream().filter(p -> p.age > age).collect(Collectors.toList());
    }

    public List<String> getAllPersonNames() {
        return persons.stream().map(p -> p.name).collect(Collectors.toList());
    }

    public Person getPerson(String name) {
        return persons.stream().filter(p -> p.name.equals(name)).findFirst().orElse(null);
    }

    public Person getPersonById(int id) {
        return persons.stream().filter(p -> p.id == id).findFirst().orElse(null);
    }
}