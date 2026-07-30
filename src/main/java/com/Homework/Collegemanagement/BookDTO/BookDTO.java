package com.Homework.Collegemanagement.BookDTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long Id;
    private String name;
    private String ISBN;
    
    private Double price;

    // Instead of sending the whole Author object,
    // send only the author's ID.
    private Long authorId;
}
