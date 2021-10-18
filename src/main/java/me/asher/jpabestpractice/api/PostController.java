package me.asher.jpabestpractice.api;

import lombok.RequiredArgsConstructor;
import me.asher.jpabestpractice.domain.Post;
import me.asher.jpabestpractice.domain.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository posts;
    private final PagedResourcesAssembler<Post> assembler;

    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable("id") Post post) {
        return post.getTitle();
    }

    @GetMapping("/api/v1/posts")
    public Page<Post> getPostsV1(Pageable pageable) {
        return posts.findAll(pageable);
    }

    @GetMapping("/api/v2/posts")
    public ResponseEntity<PagedModel<EntityModel<Post>>> getPostsV2(Pageable pageable) {
        Page<Post> customers = posts.findAll(pageable);
        PagedModel<EntityModel<Post>> entityModels = assembler.toModel(customers);
        return ResponseEntity.ok(entityModels);
    }
}
