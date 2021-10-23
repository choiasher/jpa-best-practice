package me.asher.jpabestpractice.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void test() {

        Post post = new Post();
        post.setTitle("태훈");
        Post savedPost = postRepository.save(post);

        Post post2 = new Post();
        post2.setId(savedPost.getId());
        post2.setTitle("최태훈");
        Post savedPost2 = postRepository.save(post2);

        Assertions.assertFalse(entityManager.contains(post2));
        Assertions.assertTrue(entityManager.contains(savedPost2));

    }

}