import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

class Sentences {
    private String wordSt, replace;

    public Sentences() { }
    public Sentences(String wordSt) {
        Separator sep = new Separator();
        System.out.println(sep.isSeparator(wordSt));
        this.wordSt = wordSt;
        String[] words = wordSt.split(" ");
        Word wrd = new Word();
        for(String word : words) {
            wrd.enter_word(word);
        }
    }
    public void sort() {
        Scanner input = new Scanner(System.in);
        wordSt = input.nextLine();
        replace = wordSt.replaceAll("\\s+", " ");
        System.out.println(replace);
        char[] word = replace.toCharArray();

        for(int i = 0; i < (word.length-1); i++) {
            for(int j = i+1; j>0; j--) {
                if(word[j] < word[j-1]) {
                    char temp = word[j-1];
                    word[j-1] = word[j];
                    word[j] = temp;
                }
            }
        }
        wordSt = String.valueOf(word);
        System.out.println(wordSt);
    }
    public void showWord() {
        Scanner input = new Scanner(System.in);
        wordSt = input.nextLine();
        String[] words = wordSt.split(" ");
        Word wrd = new Word();
        for(String word : words) {
            wrd.enter_word(word);
        }
    }
}

class PlaceSpaces {
    private String stroke, replace;
    public void space_replace() {
        Scanner input = new Scanner(System.in);
        stroke = input.nextLine();
        replace = stroke.replaceAll("\\s+", " ");
        System.out.println(replace);
    }
    public void space_replacing(String stroke) {
        replace = stroke.replaceAll("\\s+", " ");
        System.out.print(replace);
    }
}

class Word {
    private String letters;
    public void word() {
        Scanner input = new Scanner(System.in);
        letters = input.nextLine();
        String[]strokes = letters.split("");
        System.out.println("Letters are: ");
        for(String alphabet : strokes) {
            System.out.println(alphabet);
        }
    }
    public void enter_word() {
        Scanner inputting = new Scanner(System.in);
        letters = inputting.nextLine();
        String input = letters;
        int[] symbols = new int[256];

        for (byte current : input.getBytes(StandardCharsets.UTF_8))
            symbols[current]++;

        java.lang.StringBuilder builder = new java.lang.StringBuilder();
        for (int count = 1; count < input.length(); count++)
            for (char charCode = 0; charCode < symbols.length; charCode++)
                if (symbols[charCode] == count)
                    for (int i = 0; i < count; i++) builder.append(charCode);
        String ss = builder.toString();
        PlaceSpaces ps = new PlaceSpaces();
        ps.space_replacing(ss);
        //System.out.println(builder.toString());
    }
    public void enter_word(String input) {
        int[] symbols = new int[1000];

        for (byte current : input.getBytes(StandardCharsets.UTF_8))
            symbols[current]++;

        java.lang.StringBuilder builder = new java.lang.StringBuilder();
        for (int count = 1; count < input.length(); count++)
            for (char charCode = 0; charCode < symbols.length; charCode++)
                if (symbols[charCode] == count)
                    for (int i = 0; i < count; i++) builder.append(charCode);
        String ss = builder.toString();
        PlaceSpaces ps = new PlaceSpaces();
        ps.space_replacing(ss);
        //System.out.print(builder.toString());
    }
    public void word_with_comparator() {
        String input = "hhhheeeeelllo";
        char[] chars = input.toCharArray();
        Function<char[], Character[]> toCharacterArray = chars1 -> {
            Character[] characters = new Character[chars1.length];
            for (int i = 0; i < chars1.length; i++)
                characters[i]  = (Character) chars1[i];
            return characters;
        };
        Character[] characters = toCharacterArray.apply(chars);
        Function<Character, Integer> charCount = c1 -> input.length() - input.replaceAll(c1.toString(), "").length();
        Arrays.sort(characters);
        Arrays.sort(characters, (c1, c2) -> charCount.apply(c2) - charCount.apply(c1));
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}

class Separator {
    private final static StringBuilder SEPATORS = new StringBuilder(",. \\t!\\\";:'-");
    public boolean isSeparator(String stroke) {
        char ch=',';
        for(int j=0; j<stroke.length(); j++) {
            ch = stroke.charAt(j);
            for (int i = 0; i < SEPATORS.length(); i++) {
                if (SEPATORS.charAt(i) == ch) {
                    return true;
                }
            }
        }
        return false;
    }
}


public class Laba4 {
    public static void main(String[] args) {
//        Sentences word = new Sentences();
//        word.sort();
//        Word wrd = new Word();
//        wrd.word();
//        Word wrd = new Word();
//        wrd.enter_word("hhhhheeelllo     aaaaaabb");
        Sentences st = new Sentences("hhhhheeelllo     aaaaaabb");
        //st.showWord();
    }
}
