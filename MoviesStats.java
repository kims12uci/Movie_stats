package labs.lab10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MoviesStats {

	/**
	 * Given a Stream of Movies, returns the number of movies in the Stream
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the number of movies in the Stream
	 */
	public static long problem1_countMovies(Stream<Movie> movies) {
		long ct = movies.count();
		return ct;
	}
	

	/**
	 * Given a Stream of Movies and a string, returns the number of movies
	 * in the Stream with a title that starts with the given string (case-sensitive)
	 * 
	 * @param movies		input stream of movies
	 * @param startsWith	starting string to search for
	 * 
	 * @return	the number of movies in the Stream with a title that starts with the 
	 * given string (case-sensitive)
	 */
	public static long problem2_countMoviesThatStartWith(Stream<Movie> movies, String startsWith) {
		long ct = movies.filter(m -> m.getTitle().startsWith(startsWith)).count();
		return ct;
	}
	
	
	/**
	 * Given a Stream of Movies and a string, returns the titles of movies
	 * in the Stream that contain the given string (NOT case-sensitive), each separated by ", "
	 * 
	 * @param movies	input stream of movies
	 * @param str		string to search for in movie titles
	 * 
	 * @return	the titles of movies in the Stream that contain the given string (NOT 
	 * case-sensitive), each separated by ", "
	 */
	public static String problem3_getMoviesThatContainString(Stream<Movie> movies, String str) {
		Stream<String> names = movies
				.filter(m -> m.getTitle().toLowerCase().contains(str.toLowerCase()))
				.map(m -> m.getTitle());
		String st = names.collect(Collectors.joining(", "));
		return st;
	}
	
	
	/**
	 * Counts how many movies were made in each year, given a (inclusive)
	 * range of years. Grabs all movies from the stream that were made 
	 * within the given range of years, and groups them by the year they were
	 * made. Returns a Map<Integer, Long>, that maps years to the number of movies made
	 * in that year. 
	 * 
	 * This map should be sorted in ascending order of year.
	 * 
	 * If the stream is empty, returns an empty map.
	 * 
	 * @param movies	input stream of movies
	 * @param minYear	lower bound of the range of years (inclusive)
	 * @param maxYear	upper bound of the range of years (inclusive)
	 * 
	 * @return	a map of all movies in the stream that were made within the given year range; 
	 * 			maps years to the number of movies made in that year
	 */
	public static Map<Integer, Long> problem4_countMoviesByYear(Stream<Movie> movies, int minYear,
			int maxYear) {
		Stream<Movie> target = movies.filter(m -> m.getYear() >= minYear && m.getYear() <= maxYear);
		Map<Integer, Long> val = target.collect(Collectors.groupingBy(m -> m.getYear(), Collectors.counting()));
		TreeMap<Integer, Long> result = new TreeMap<>();
		result.putAll(val);
		return result;
	}
	
	
	/**
	 * Given a Stream of Movies and the name of an actor, returns a list of movies that 
	 * actor has been in
	 * 
	 * @param movies	input stream of movies
	 * @param actorName	actor name to search for
	 * 
	 * @return	a list of movies the actor has been in
	 */	
	public static List<Movie> problem5_getMoviesWithActor(Stream<Movie> movies, String actorName) {
		List<Movie> val = movies
				.filter(m -> m.getActors().contains(actorName))
				.toList();
		
		return val;
	}
	
	
	/**
	 * Given a Stream of Movies and the name of a director, returns a list of movies that 
	 * director has directed
	 * 
	 * @param movies		input stream of movies
	 * @param directorName	director name to search for
	 * 
	 * @return	a list of movies the director has directed
	 */	
	public static List<Movie> problem5_getMoviesDirectedBy(Stream<Movie> movies, String directorName) {
		List<Movie> val = movies
				.filter(m -> m.getDirectors().contains(directorName))
				.toList();
		
		return val;
	}
	
	/**
	 * Given a Stream of Movies and the name of a producer, returns a list of movies that 
	 * producer has produced
	 * 
	 * @param movies		input stream of movies
	 * @param producerName	producer name to search for
	 * 
	 * @return	a list of movies the producer has produced
	 */	
	public static List<Movie> problem5_getMoviesProducedBy(Stream<Movie> movies, String producerName) {
		List<Movie> val = movies
				.filter(m -> m.getProducers().contains(producerName))
				.toList();
		
		return val;
	}

	
	/**
	 * Returns how many distinct actors are represented in given Stream of Movies
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the number of distinct actors in the given stream of movies
	 */
	public static long problem6_countActors(Stream<Movie> movies) {
		List<Movie> lm = movies.toList();
		ArrayList<String> name = new ArrayList<>();
		for (Movie m : lm) {
			name.addAll(m.getActors());
		}
		
		long ct = name.stream()
				.distinct()
				.count();
		
		return ct;
	}
	
	
	/**
	 * Returns how many distinct directors are represented in given Stream of Movies
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the number of distinct directors in the given stream of movies
	 */
	public static long problem6_countDirectors(Stream<Movie> movies) {
		List<Movie> lm = movies.toList();
		ArrayList<String> name = new ArrayList<>();
		for (Movie m : lm) {
			name.addAll(m.getDirectors());
		}
		
		long ct = name.stream()
				.distinct()
				.count();
		
		return ct;
	}
	

	/**
	 * Returns how many distinct producers are represented in given Stream of Movies
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the number of distinct producers in the given stream of movies
	 */
	public static long problem6_countProducers(Stream<Movie> movies) {
		List<Movie> lm = movies.toList();
		ArrayList<String> name = new ArrayList<>();
		for (Movie m : lm) {
			name.addAll(m.getProducers());
		}
		
		long ct = name.stream()
				.distinct()
				.count();
		
		return ct;
	}
	
	
	/**
	 * Returns the average number of actors in each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the average number of actors in each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 */
	public static double problem7_averageNumActors(Stream<Movie> movies) {
		IntStream ppl = movies.mapToInt(m -> m.getActors().size());
		double ct = ppl.average().orElse(0);
		
		return ct;
	}
	
	
	/**
	 * Returns the average number of directors of each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the average number of directors of each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 */
	public static double problem7_averageNumDirectors(Stream<Movie> movies) {
		IntStream ppl = movies.mapToInt(m -> m.getDirectors().size());
		double ct = ppl.average().orElse(0);
		
		return ct;
	}
	
	
	/**
	 * Returns the average number of producers of each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the average number of producers of each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 */
	public static double problem7_averageNumProducers(Stream<Movie> movies) {
		IntStream ppl = movies.mapToInt(m -> m.getProducers().size());
		double ct = ppl.average().orElse(0);
		
		return ct;
	}
	
	
	/**
	 * Returns a list of movies with exactly n words in the title
	 * 
	 * @param movies	input stream of movies
	 * @param n			number of words
	 * 
	 * @return	a list of movies with exactly n words in the title
	 */
	public static List<Movie> problem8_moviesWithNWordsInTitle(Stream<Movie> movies, int n) {
		List<Movie> val = movies.filter(m -> m.getTitle().split("\\s+").length == n).toList();
		
		return val;
	}
	
	
	/**
	 * Returns the oldest movie with a non-zero year in the Stream
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the oldest movie with a non-zero year in the Stream
	 */
	public static Optional<Movie> problem9_oldestMovie(Stream<Movie> movies) {
		Optional<Movie> mov = movies.filter(m -> m.getYear() != 0).min((m1, m2) -> m1.getYear() - m2.getYear());
		
		return mov;
	}
	
	
	/**
	 * Returns the newest movie in the Stream
	 * 
	 * @param movies	input stream of movies
	 * 
	 * @return	the newest movie in the Stream
	 */
	public static Optional<Movie> problem10_newestMovie(Stream<Movie> movies) {
		Optional<Movie> mov = movies.max((m1, m2) -> m1.getYear() - m2.getYear());
		
		return mov;
	}
}