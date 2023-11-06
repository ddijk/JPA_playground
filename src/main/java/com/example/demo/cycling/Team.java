package com.example.demo.cycling;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public Team(String name) {
        this.name = name;
    }

    String name;

    @OneToMany( mappedBy = "team", cascade = CascadeType.ALL)
    List<Rider> riders = new ArrayList<>();
}
