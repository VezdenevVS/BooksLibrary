package ru.homework.booklibrary.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "authors")
public class Author extends BasicEntity {

    @Column(nullable = false)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books = new LinkedHashSet<>();

}
