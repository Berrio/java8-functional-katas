package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> result=movieLists.stream().map(video -> video.getVideos()).flatMap(url -> url.stream())
                .map(m ->{List<BoxArt>  boxArt=m.getBoxarts().stream()
                        .filter(boxArt1 -> boxArt1.getWidth().equals(150) && boxArt1.getHeight().equals(200))
                        .collect(Collectors.toList());
                    HashMap<String,String> mov = new HashMap<>();
                    mov.put("id",m.getId().toString());
                    mov.put("title",m.getTitle());
                    mov.put("boxArt",boxArt.get(0).getUrl());
                    return mov;

                }).collect(Collectors.toList());

        return result;
    }
}
