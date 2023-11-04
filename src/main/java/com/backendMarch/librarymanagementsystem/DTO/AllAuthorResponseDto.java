package com.backendMarch.librarymanagementsystem.DTO;

import com.backendMarch.librarymanagementsystem.Entity.Book;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AllAuthorResponseDto {

    int id;

    private String name;

    private int age;

    private String mobNo;

    private String email;

    List<BookResponseDto> books = new ArrayList<>();
}
