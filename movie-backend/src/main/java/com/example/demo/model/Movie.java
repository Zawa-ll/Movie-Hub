package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    // Uncomment this to establish a many-to-many relationship
    // @ManyToMany(mappedBy = "wishlistedMovieIds")
    // private Set<User> users = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



//@Entity
//@Table(name = "movie")
//@Data
//public class Movie {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String title;
//
////    @ManyToMany(mappedBy = "wishlist")
////    private Set<User> users = new HashSet<>();
//
//    public Movie(Long id, String title, Set<User> users) {
//        this.id = id;
//        this.title = title;
////        this.users = users;
//    }
//
//    public Movie(String title) {
//        this.title = title;
//    }
//
//    public Movie() {
//
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//}
