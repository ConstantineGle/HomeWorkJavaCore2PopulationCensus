import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }

        //1st condition
        persons.stream()
                .filter(person -> person.getAge() < 18)
                .forEach(System.out::println);

        //2nd condition
        persons.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .forEach(System.out::println);

        //3rd condition
        persons.stream()
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .filter(person -> person.getSex().equals(Sex.MAN) && person.getAge() >= 18 && person.getAge() < 65
                        || person.getSex().equals(Sex.WOMAN) && person.getAge() >= 18 && person.getAge() < 60)
                .forEach(System.out::println);

    }
}