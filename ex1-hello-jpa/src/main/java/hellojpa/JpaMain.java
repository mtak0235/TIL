package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            //비영속
            Member member = new Member();
            member.setName("min");
            member.setId(3l);

            System.out.println("before");
            //영속
            em.persist(member);
            System.out.println("after");

            Member member1 = em.find(Member.class, 3L);
            System.out.println("member1.getId() = " + member1.getId());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
