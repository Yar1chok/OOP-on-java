package oop4;

/**
 * This class count vowels in input string.
 */
public class CountVowels implements AnalyseLine {
    /**
     * This method counts the number vowels in string.
     *
     * @param str String from input.
     * @return Count of vowels in string.
     */
    @Override
    public int analyse(String str) {
        AnalyseLine analyseLine = (analyseString) ->
        {
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            int sumVowels = 0;
            for (int symbol : analyseString.toLowerCase().toCharArray()) {
                for (char vowel : vowels) {
                    if (symbol == vowel) {
                        sumVowels++;
                        break;
                    }
                }
            }
            return sumVowels;
        };
        return analyseLine.analyse(str);
    }
}
