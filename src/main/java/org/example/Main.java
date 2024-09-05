package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService();

        // Добавление новых персон
        personService.addPerson(new Person("Alice", 25));
        personService.addPerson(new Person("Bob", 30));

        // Обновление персоны
        personService.updatePerson(1L, "Alice Updated", 26);

        // Получение всех персон
        List<Person> persons = personService.getAllPersons();
        persons.forEach(System.out::println);

        // Удаление персоны
        personService.deletePerson(2L);

        // Получение всех персон после удаления
        persons = personService.getAllPersons();
        persons.forEach(System.out::println);

        // Закрытие EntityManagerFactory
        personService.close();
    }
}





