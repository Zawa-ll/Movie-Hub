package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.model.User;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LikeMoviesService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void likeMovie(Long userId, Long movieId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        addToWishlist(user, movieId);
    }

    @Transactional
    public void unlikeMovie(Long userId, Long movieId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        removeFromWishlist(user, movieId);
    }

    private void addToWishlist(User user, Long movieId) {
        user.getWishlistedMovieIds().add(movieId);
        userRepository.save(user);
    }

    private void removeFromWishlist(User user, Long movieId) {
        user.getWishlistedMovieIds().remove(movieId);
        userRepository.save(user);
    }

    public Set<Long> getLikedMovieIds(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getWishlistedMovieIds();
    }

}

