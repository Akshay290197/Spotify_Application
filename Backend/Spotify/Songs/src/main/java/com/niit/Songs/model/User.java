package com.niit.Songs.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class User {

    @Id
    private String userEmail;
    private String userName;
    private String passwd;
    private List<Songss> songss;
}
