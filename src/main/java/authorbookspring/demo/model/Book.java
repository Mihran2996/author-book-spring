package authorbookspring.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private int authorId;
}