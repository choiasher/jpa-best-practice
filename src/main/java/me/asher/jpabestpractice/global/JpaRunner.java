package me.asher.jpabestpractice.global;

import me.asher.jpabestpractice.domain.User;
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
        User user = new User();
        user.setUserName("choi");
        user.setPassword("pass");
        //entityManager.persist(account);

        Session session = entityManager.unwrap(Session.class);
        session.save(user);


    }
}
