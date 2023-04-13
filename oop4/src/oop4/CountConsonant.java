package oop4;

/**
 * This class count consonant in input string.
 */
public class CountConsonant implements AnalyseLine{
    /**
     * This method counts the number consonant in string.
     * @param str String from input.
     * @return Count of consonant in string.
     */
    @Override
    public int analyse(String str) {
        AnalyseLine analyseLine = (analyseString) ->
        {
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            int sumConsonant = 0;
            int sumVowels = 0;
            for (int symbol : analyseString.toLowerCase().toCharArray()) {
                for (char vowel : vowels) {
                    if (symbol != vowel && Character.isLetter(symbol)) {
                        sumVowels++;
                    }
                }
                if (sumVowels == 5){
                    sumConsonant++;
                }
                sumVowels = 0;
            }
            return sumConsonant;
        };
        return analyseLine.analyse(str);
    }
}
