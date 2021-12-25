package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Movie;
import com.example.demo.repo.MovieRepo;

@Service
public class Services {
	
	private final MovieRepo movieRepository;
	@Autowired
	public Services( MovieRepo movieRepository){
	this.movieRepository=movieRepository;
	}
	
	public List<Movie> getMovies() {
		return movieRepository.findAll();
		}
	
	public Movie createMovie(Movie movie) {
	return movieRepository.save(movie);	
	}
	
	public boolean deleteMovie(Integer id) {
		Optional<Movie> movie = movieRepository.findById(id);
		movieRepository.delete(movie.get());
		return true;
	}

	public Movie  updateMovie(Movie movie, Integer id){

		Optional<Movie> movieFind = movieRepository.findById(id);

		if (!movieFind.isEmpty()) {
			return movieRepository.save(movie);
		}else {
			throw new RuntimeException("Movie not found");
		}
		}
	
	public Optional < Movie> findById(Integer id) {
		return movieRepository.findById(id);
		}
		
	public List<Movie> findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}
		
	public List<Movie> findByRate() {
		return movieRepository.findByRate(null);
	}
		
	public List<Movie> findClass(String classified) {
		return movieRepository.findByClassified(classified);
	}
		
}
