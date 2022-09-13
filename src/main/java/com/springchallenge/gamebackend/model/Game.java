package com.springchallenge.gamebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name="game")
@Data
public class Game {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="title")
    private String title;
    @Column(name="genre")
    private String genre;
    @Column(name="platform")
    private String platform;
    @Column(name="description")
    private String description;
    @Column(name="release_date")
    private LocalDate releaseDate;
    @Column(name="image")
    private String image;
    @Column(name="update_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "update_by", foreignKey = @ForeignKey(name = "FK_GAME_USER"))
    private User updateBy;

    @OneToMany(mappedBy = "user")
    Set<GameState> users;


    public Game (){
        this.id = UUID.randomUUID().toString();
        this.updateAt = LocalDateTime.now();
    }

}
