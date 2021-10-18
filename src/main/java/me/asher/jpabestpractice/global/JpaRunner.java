package me.asher.jpabestpractice.global;

import me.asher.jpabestpractice.domain.Account;
import me.asher.jpabestpractice.domain.Post;
import me.asher.jpabestpractice.domain.PostRepository;
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
    private PostRepository postRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Post post = new Post();
        post.setTitle("hello");
        post.setContent("bla bla~");

        postRepository.save(post);


    }
}
