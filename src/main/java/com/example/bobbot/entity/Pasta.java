package com.example.bobbot.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "pasta")
public class Pasta {


    public Pasta(String pastaText) {
        this.pastaText = pastaText;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "pastatext")
    private String pastaText;


}
