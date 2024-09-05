package org.example;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPU");

    // Метод для добавления объекта Person
    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    // Метод для обновления объекта Person
    public void updatePerson(Long id, String newName, int newAge) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            person.setName(newName);
            person.setAge(newAge);
            em.getTransaction().commit();
        } else {
            System.out.println("Person not found!");
        }
        em.close();
    }

    // Метод для удаления объекта Person
    public void deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
            em.getTransaction().commit();
        } else {
            System.out.println("Person not found!");
        }
        em.close();
    }

    // Метод для получения всех объектов Person
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        em.close();
        return persons;
    }

    // Метод для закрытия EntityManagerFactory
    public void close() {
        emf.close();
    }
}

