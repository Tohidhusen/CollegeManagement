package com.Homework.Collegemanagement.BookDTO;


import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Long Id;

    private String name;

    private String Address;

    private String Acheivement;

    private List<String> Books;




}
