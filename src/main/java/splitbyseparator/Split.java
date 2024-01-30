package splitbyseparator;

import java.util.ArrayList;
import java.util.List;

public class Split {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> separatedWords = new ArrayList<>();
        for (String word : words) {
            char curChar;
            int startIndex = 0;
            for (int j = 0; j < word.length(); j++) {
                curChar = word.charAt(j);
                if (curChar == separator) {
                    String separatedWord = word.substring(startIndex, j);
                    if (!separatedWord.isEmpty()) {
                        separatedWords.add(separatedWord);
                    }
                    startIndex = j + 1;
                } else if (j == word.length() - 1) {
                    separatedWords.add(word.substring(startIndex, j + 1));
                }
            }
        }
        return separatedWords;
    }
}
