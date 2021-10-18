package me.asher.jpabestpractice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = "post")
@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
