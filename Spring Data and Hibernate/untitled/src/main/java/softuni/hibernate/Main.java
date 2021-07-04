package softuni.hibernate;

import softuni.hibernate.entities.ApplicationStarter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

//    Make sure that you enter your mysql server credentials in the persistence.xml file
//    The program runs is in a while loop for your convenience.
//    If you want to exit the program, enter 0

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_intro");
        EntityManager em = emf.createEntityManager();
        ApplicationStarter aps = new ApplicationStarter(em);
        aps.run();
        emf.close();
    }
}
