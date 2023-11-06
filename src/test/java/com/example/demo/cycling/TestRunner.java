package com.example.demo.cycling;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("myPU_DEV");
            em = emf.createEntityManager();

            Team team = new Team("Jumbo");
            Rider rider = new Rider("Menno", "Huizing");
            team.riders.add(rider);
            rider.setTeam(team);

            em.getTransaction().begin();
            em.persist(team);
            em.getTransaction().commit();

            System.out.println("DONE");

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) emf.close();
        }
    }
}
