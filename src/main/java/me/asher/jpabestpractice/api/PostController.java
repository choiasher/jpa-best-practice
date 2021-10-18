package me.asher.jpabestpractice.api;

import lombok.RequiredArgsConstructor;
import me.asher.jpabestpractice.domain.Post;
import me.asher.jpabestpractice.domain.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository posts;

    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable("id") Post post) {
        return post.getTitle();
    }

    @GetMapping("/posts")
    public Page<Post> getPosts(Pageable pageable) {
        return posts.findAll(pageable);
    }
}
