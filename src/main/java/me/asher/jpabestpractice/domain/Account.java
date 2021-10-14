package me.asher.jpabestpractice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "studies")
@Getter
@Setter
@Entity
public class Account {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study) {
        study.setOwner(this);
        studies.add(study);
    }

}
