package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        String longestString = movies.stream()
                .reduce((word1, word2)
                        -> word1.getUri().length() > word2.getUri().length()
                        ? word1 : word2).get().toString();
        return longestString;
    }
}
