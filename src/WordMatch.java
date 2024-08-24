public class WordMatch {
    private String word;
    public WordMatch(String word) {
        this.word = word;
    }
    public int scoreGuess(String guess) {
        if (guess.length() > word.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        } else if (guess.isEmpty()) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }

        int cnt = 0;

        if (guess.equals(word)) return word.length() * word.length();

        for (int i = 0; i < word.length()+1-guess.length(); i++) {
            if (word.substring(i,i+guess.length()).equals(guess)) cnt++;
        }

        return cnt * guess.length() * guess.length();
    }
    public String findBetterGuess(String one, String two) {
        if (scoreGuess(two) > scoreGuess(one)) return two;
        else if (scoreGuess(one) > scoreGuess(two)) return one;
        else {
            if (two.compareTo(one) > one.compareTo(two)) return two;   // alphabetically greater (source: Sentry https://sentry.io/answers/how-to-compare-strings-in-java)
            return one;
        }
    }
}
