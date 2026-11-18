package strings;

public class TextProcessor {

    static void main(String[] args) {
//        countWords("I love Java");
//        reverseString("Hello World");
        addSpaces("HelloWorld!It'sMeArtem");
    }

    public static void countWords(String text) {
        var words = text.split(" ");
        int numberOfWords = words.length;


        String message = String.format("Your text contains %d words", numberOfWords);
        System.out.println(message);

        for (String word : words) {
            System.out.println(word);
        }

    }

    public static void reverseString(String text) {
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));
        }
    }

    public static void addSpaces(String text) {
        var modifedText = new StringBuilder(text);
        for (int i = 0; i < modifedText.length(); i++) {
            if (i != 0 && Character.isUpperCase(modifedText.charAt(i))) {
                modifedText.insert(i, " ");
                i++;
            }
        }
        System.out.println(modifedText);
    }
}


