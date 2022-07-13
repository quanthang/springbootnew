package com.example.t2009mt1demo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table (name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;
    public String name;
    public String description;
    public String gender;
    public String color;
    public int size;
    public double price;
    public LocalDateTime createAt;
    public int status;
}
