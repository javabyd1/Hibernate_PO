package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books", schema = "ksiegarnia")
public class BooksEntity {



    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "published")
    private Date published;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "category")
    private String category;
    @Column(name = "pageCount")
    private Integer pageCount;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "onStock")
    private Integer onStock;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
