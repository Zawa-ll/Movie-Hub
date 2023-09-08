package com.example.demo.controller;

import com.example.demo.model.Movie; // Make sure to import the Movie class
import com.example.demo.model.requests.LikeRequest;
import com.example.demo.service.LikeMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user/likes")
public class LikeMovieController {

    @Autowired
    private LikeMoviesService likeService;

    @PostMapping("/like")
    public ResponseEntity<String> likeMovie(@RequestBody LikeRequest likeRequest) {
        likeService.likeMovie(likeRequest.getUserId(), likeRequest.getMovieId());
        return ResponseEntity.ok("Movie liked successfully");
    }

    @PostMapping("/unlike")
    public ResponseEntity<String> unlikeMovie(@RequestBody LikeRequest likeRequest) {
        likeService.unlikeMovie(likeRequest.getUserId(), likeRequest.getMovieId());
        return ResponseEntity.ok("Movie unliked successfully");
    }

    @GetMapping("/liked-movie-ids/{userId}")
    public ResponseEntity<Set<Long>> getLikedMovieIds(@PathVariable Long userId) {
        Set<Long> likedMovieIds = likeService.getLikedMovieIds(userId);
        return ResponseEntity.ok(likedMovieIds);
    }


}
