package labs.lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Utility class for reading in a file of movie data
 */
public class MoviesReader {
	
	/**
	 * Reads in a file of movie data and returns a list of Movie objects
	 * 
	 * @param filename	name of file containing movie data
	 * 
	 * @return	list of Movie objects from the file
	 */
	public static List<Movie> readMovies(String filename) {
		List<Movie> movies = new ArrayList<>();
		try (Scanner in = new Scanner(new File(filename))) {
			while (in.hasNextLine()) {
				String nameLine = in.nextLine();
				String yearLine = in.nextLine();
				String directorsLine = in.nextLine();
				String producersLine = in.nextLine();
				String actorsLine = in.nextLine();
				movies.add(new Movie(getString(nameLine), Integer.parseInt(getString(yearLine)), getList(directorsLine),
						getList(producersLine), getList(actorsLine)));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File: " + filename + " not found");
		}
		return movies;
	}

	private static String getString(String line) {
		int colon = line.indexOf(":");
		return line.substring(colon + 1).trim();
	}

	private static List<String> getList(String line) {
		return Stream.of(getString(line).split(", ")).collect(Collectors.toList());
	}
}
