package com.backendMarch.librarymanagementsystem.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookResponseDto {

    private String title;

    private int price;
    private  String authorName;
}
