package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("movies")
@RestController
public class MovieController {
  
	@Autowired
   MovieService movieService;
	
	@PostMapping("/add-movie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
		String response = movieService.addMovie(movie);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@PostMapping("/add-director")
	public ResponseEntity<String> addDirector(@RequestBody Director director){
		String response = movieService.addDirector(director);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	@PostMapping("/add-movie-director-pair")
	public ResponseEntity<String> addMovieDirectorPair(@RequestParam("nameM") String nameM,@RequestParam("nameD") String nameD){
		String response = movieService.addMovieDirectorPair(nameM,nameD);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-movie-by-name/{nameM}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable("nameM") String nameM) {
		Movie movie = movieService.getMovieByName(nameM);
		return new ResponseEntity<>(movie,HttpStatus.FOUND);
	}
	@GetMapping("/get-director-by-name/{nameD}")
	public ResponseEntity<Director> getDirectorByName(@PathVariable("nameD") String nameD){
		Director director = movieService.getDirectorByName(nameD);
		return new ResponseEntity<>(director,HttpStatus.FOUND);
	}
	@GetMapping("/get-movies-by-director-name")
	public ResponseEntity <List<String>> getMoviesByDirectorName(@PathVariable("nameD") String nameD) {
		List<String> m1 = new ArrayList<>();
		m1 = movieService.getMoviesByDirectorName(nameD);
		return new ResponseEntity<>(m1,HttpStatus.FOUND);
	}
	@GetMapping("/get-all-movies")
	public ResponseEntity<List<String>> getAllMovies() {
		List<String> m1 = new ArrayList<>();
		m1 = movieService.findAllMovies();
		return new ResponseEntity<>(m1,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete-director-by-name")
	public ResponseEntity<String> deleteDirectorByName(@RequestParam("nameD") String nameD){
		String response = movieService.deleteDirectorByName(nameD);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete-all-directors")
	public ResponseEntity<String> deleteAllDirectors(){
		String response = movieService.deleteAllDirectors();
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
}
