package com.example.bookv2.domain.entities;

import com.example.bookv2.domain.entities.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//ONE
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Book> books;
}
