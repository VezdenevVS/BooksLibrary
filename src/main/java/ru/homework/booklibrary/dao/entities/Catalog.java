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
@Table(name = "catalogs")
public class Catalog extends BasicEntity {

    @Column(nullable = false)
    private String label;

    @ToString.Exclude
    @OneToMany(mappedBy = "catalog", fetch = FetchType.LAZY)
    private Set<Book> books = new LinkedHashSet<>();
}
