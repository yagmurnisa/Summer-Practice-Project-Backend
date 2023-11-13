package tech.reaven.model;

import lombok.*;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "News")
public class News {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "isin_code")
    private String isinCode;
    @Column(name = "name")
    private String name;
    @Column(name = "headline")
    private String headLine;
    @Column(name = "link")
    private String link;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date")
    private Date date;// stand - ISO DATE

    public News(String isinCode, String name, String headline,
                  String link, Date date) {
        this.isinCode = isinCode;
        this.name = name;
        this.headLine = headLine;
        this.link = link;
        this.date= date;
    }
}

