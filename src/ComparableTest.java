import java.util.TreeMap;

public class ComparableTest {

    public static class Person implements Comparable<Person> {

        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        @Override
        public int compareTo(Person person) {
            return person.getFirstName().compareTo(firstName);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeMap<Person, String> map = new TreeMap<Person, String>();

        map.put(new Person("AA","BB"), "aa");
        map.put(new Person("BB","BB"), "aa");
        map.put(new Person("DD","BB"), "aa");
        map.put(new Person("CC","BB"), "aa");
        System.out.println(map);
    }
}
