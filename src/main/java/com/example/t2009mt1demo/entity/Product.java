package com.example.t2009mt1demo.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "products")


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String  description;
    public String gender;
    public String color;
    public String size;
    public double price;
    public LocalDateTime createdAt;
    public int status; // 1 đang bán , 2 dừng bán
}