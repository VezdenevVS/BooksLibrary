package ru.homework.booklibrary.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "books")
public class Book extends BasicEntity {

    @Column(nullable = false)
    private String label;

    @Column(name = "release_at", nullable = false)
    private Date releaseAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Catalog catalog;

}
