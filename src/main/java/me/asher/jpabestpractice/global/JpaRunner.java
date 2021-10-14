package me.asher.jpabestpractice.global;

import me.asher.jpabestpractice.domain.Account;
import me.asher.jpabestpractice.domain.Study;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUserName("choi");
        account.setPassword("pass");
        //entityManager.persist(account);

        Study study = new Study();
        study.setName("Spring data JPA");
        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);


    }
}
