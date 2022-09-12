package Exercise_9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {

    Map<String, Integer> map = new HashMap<>();

    public WordCount(String str){
        String[] words =  str.toLowerCase().split("\\W+");
        for (String stra : words)
            map.put(stra, getCount(stra)+1);


        System.out.println(map);
//        map.put(words[s], getCount(str));
    }
    public int getCount(String word){
        if (map.get(word) == null){
            return 0;
        }
        return map.get(word);
    }
}
