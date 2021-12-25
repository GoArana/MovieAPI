package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	//al inicio de la API aparece lo siguiente
		public String init() {
			return "<h1>Bienvenido a mi API de Peliculas<h1>";
			};
	
	//para Leer el listado de películas

	public List<Movie> getMovies() {
		return movieRepository.findAll();
		}
	
	//agregar una pelicula a la bd
	public Movie createMovie(Movie movie) {
	return movieRepository.save(movie);	
	}
	
	//borrar peliculas
		public void deleteMovie(Integer id) {
			movieRepository.deleteById(id);
		}

		//actualizar la pelicula
		public Movie  updateMovie(Movie movie, Integer id){

			Optional<Movie> peliuptade = movieRepository.findById(id);

			if (!peliuptade.isEmpty()) {
				return movieRepository.save(movie);
			}else {
				throw new RuntimeException("Movie not found");
			}
			}
	
		//buscar por id
		public Optional < Movie> findId(Integer id) {
			return movieRepository.findById(id);
			}
		
		//buscar por titulo
		public List<Movie> findTitle(String title) {
			return movieRepository.findTitle(title);
		}
		
		//buscar por popular
		public List<Movie> findPopular() {
			return movieRepository.findPopular(PageRequest.of(0,3));
		}
		
		//buscar por clasificación de pelicula

		public List<Movie> findClass(String classified) {
			return movieRepository.findClass(classified);
		}
		
}
