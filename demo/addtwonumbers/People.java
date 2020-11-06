package demo.addtwonumbers;

/**
 * @author keith
 * @version 1.0
 * @date 2020-11-06
 */
public class People {

    private String name;

    private People people;

    public People(String name) {
        this.name = name;
    }

    public People(String name, People people) {
        this.name = name;
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }
}
