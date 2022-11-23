package com.niit.Songs.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Songss {

    @Id
    private int id;
    private String songName;
    private String songDuration;
    private String songimg;
}
