package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class jpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member findMember = em.find(Member.class, 1L);
            
            // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
//            findMember.setName("HelloJPA"); // JPA가 관리하기 때문에 변경됨

            // 영속
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");

            System.out.println("===============");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
