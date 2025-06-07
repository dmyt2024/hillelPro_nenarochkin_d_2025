package org.dmytr.less_42_spring_data.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Table(name = "post")
@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "title"
    )
    private String title;
    @Column(
            name = "content"
    )
    private String content;
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    @JsonBackReference
    private User user;


}
