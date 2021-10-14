package me.asher.jpabestpractice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String content;

    @ManyToOne
    private Post post;
}
