package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Movie;
import com.example.demo.services.Services;
@RestController

@RequestMapping("/MoviesApi")
@CrossOrigin(origins = "http://localhost:8080")
public class MovieController {
 
	private final Services service;

	@Autowired
	public MovieController(Services service) {
	this.service=service;
	}
	
		
	@GetMapping("/movies")
	public List<Movie> getMovies(){
		return service.getMovies();
	}
		
	@PostMapping("/addMovie")
	public Movie createMovie(@RequestBody Movie movie){
			return service.createMovie(movie);
	}
		
	@DeleteMapping("/deleteMovie/{id}")
	public boolean deleteMovie( @PathVariable Integer id) {
			return service.deleteMovie(id);
	}
	
	@PutMapping("/updateMovie/{id}")
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
		return service.updateMovie(movie, id);
	}
		
	@GetMapping("/searchId/{id}")
	public Optional < Movie> findById(@PathVariable Integer id) {
		return service.findById(id);
	}
		
	@GetMapping("/searchTitle/{title}")
	public List <Movie> findByTitle(@PathVariable String title ) {
		return service.findByTitle(title);
	}
			
	@GetMapping("/searchPopular/{title}")
		public List <Movie> findByRate( ) {
			return service.findByRate();
	}
			
	@GetMapping("/searchClassified/{classified}")
	public List <Movie> findClass( @PathVariable String classified) {
		return service.findClass(classified);
	}
					
}
