package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_movies", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "movie_id")
    private Set<Long> wishlistedMovieIds = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Long> getWishlistedMovieIds() {
        return wishlistedMovieIds;
    }

    public void setWishlistedMovieIds(Set<Long> wishlistedMovieIds) {
        this.wishlistedMovieIds = wishlistedMovieIds;
    }
}






//
//@Entity
//@Table(name = "user")
//@Data
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String username;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @ElementCollection
//    @CollectionTable(name = "user_movies", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "movie_id")
//    private Set<Long> wishlist = new HashSet<>();
//
////    @ElementCollection
////    @CollectionTable(name = "user_movies", joinColumns = @JoinColumn(name = "user_id"))
////    @Column(name = "wish_list")
////    private Set<Long> wishlist = new HashSet<>();
////    @Column(name = "movie_id")
//
//    public User(Long id, String username, String email, String password, Set<Long> wishlist) {
//        this.id = id;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.wishlist = wishlist;
//    }
//
//    public User() {
//
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<Long> getWishlist() {
//        return wishlist;
//    }
//
//    public void setWishlist(Set<Long> wishlist) {
//        this.wishlist = wishlist;
//    }
//}
//
//

//@Entity
//@Table(name = "user")
//@Data
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String username;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @ElementCollection
//    @CollectionTable(name = "user_movies", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "movie_id")
//    private Set<Long> wishlist = new HashSet<>();
//
//    public User(Long id, String username, String email, String password, Set<Long> wishlist) {
//        this.id = id;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.wishlist = wishlist;
//    }
//
//    public User() {
//
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<Long> getWishlist() {
//        return wishlist;
//    }
//
//    public void setWishlist(Set<Long> wishlist) {
//        this.wishlist = wishlist;
//    }
//}