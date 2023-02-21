package hard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Welcome to cipher day!
 * <p>
 * For this challenge, you need to write a program that will take the scrambled words from this post, and compare them
 * against Challenge3.txt to unscramble them. For bonus points, sort the words by length when you are finished.
 * Post your programs and/or subroutines!
 * <p>
 * Here are your words to de-scramble:
 * mkeart
 * sleewa
 * edcudls
 * iragoge
 * usrlsle
 * nalraoci
 * nsdeuto
 * amrhat
 * inknsy
 * iferkna
 */
public class Challenge3 {

    private static final String[] WORDS = {"mkeart", "sleewa", "edcudls", "iragoge",
            "usrlsle", "nalraoci", "nsdeuto", "amrhat", "inknsy", "iferkna"};

    private Map<Character, Integer> countLetters(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public boolean areWordsEqualButScrambled(String word1, String word2) {
        Map<Character, Integer> word1Letters = countLetters(word1);
        Map<Character, Integer> word2Letters = countLetters(word2);

        return word1Letters.entrySet().stream()
                .allMatch(e -> e.getValue().equals(word2Letters.get(e.getKey())));
    }

    public Map<String, String> bruteForce() {
        Map<String, String> result = new HashMap<>();
        List<String> words = new ArrayList<>(List.of(WORDS));
        try (FileReader reader = new FileReader("res/hard/Challenge3.txt"); BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : words) {
                    if (areWordsEqualButScrambled(line, word)) {
                        System.out.println(word + " is actually just " + line);
                        result.put(word, line);
                        words.remove(word);
                        break;
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }

}
