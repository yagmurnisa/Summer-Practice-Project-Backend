package tech.reaven.model;

import lombok.*;
import org.springframework.boot.jackson.JsonComponent;


import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name ="Index")
public class Index {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "isin_code")
    private String isinCode;
    @Column(name = "name")
    private String name;
    @Column(name = "index_")
    private String index;
    @Column(name = "link")
    private String link;


    public Index(String isinCode, String name, String index,
                String link) {
        this.isinCode = isinCode;
        this.name = name;
        this.index = index;
        this.link = link;
    }
}