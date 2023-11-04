package com.backendMarch.librarymanagementsystem.Service;

import com.backendMarch.librarymanagementsystem.DTO.AllAuthorResponseDto;
import com.backendMarch.librarymanagementsystem.DTO.BookResponseDto;
import com.backendMarch.librarymanagementsystem.Entity.Author;
import com.backendMarch.librarymanagementsystem.Entity.Book;
import com.backendMarch.librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(Author author){

        authorRepository.save(author);
    }

    public List<AllAuthorResponseDto> getAuthors(){

        List<Author> authors=new ArrayList<>();
        authors=authorRepository.findAll();
        List<AllAuthorResponseDto> authorsRes=new ArrayList<>();
        for(Author authr:authors){
            BookResponseDto bookResponseDto;
            List<BookResponseDto> bookRes=new ArrayList<>();
            for(Book book:authr.getBooks()){
                bookResponseDto=BookResponseDto.builder()
                        .price(book.getPrice())
                        .title(book.getTitle())
                        .build();
                bookRes.add(bookResponseDto);
            }
            AllAuthorResponseDto allAuthor= AllAuthorResponseDto.builder()
                    .id(authr.getId())
                    .age(authr.getAge())
                    .email(authr.getEmail())
                    .mobNo(authr.getMobNo())
                    .name(authr.getName())
                    .books(bookRes)
                    .build();
            authorsRes.add(allAuthor);
        }
        return authorsRes;
    }
}
