package ru.homework.booklibrary.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class BasicEntity {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    BasicEntity(Long id) {
        this.id = id;
    }

    @PrePersist
    public void prePersist() {
        if (id == null)
            id = UUID.randomUUID().getMostSignificantBits();
        if (createdAt == null)
            createdAt = now();
        if (updatedAt == null)
            updatedAt = getCreatedAt();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        if (!(o instanceof BasicEntity)) return false;
        BasicEntity that = (BasicEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    protected Timestamp now() {
        return new Timestamp(Instant.now().toEpochMilli());
    }

}
