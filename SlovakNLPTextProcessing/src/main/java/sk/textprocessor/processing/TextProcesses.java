package sk.textprocessor.processing;

import java.util.ArrayList;

/*V tejto triede budu funkcie na spracovanie textu ako tokenizacie atd.. nižie uvedana funkcia je samozrejme len provizorna */
public class TextProcesses {

    public void tokenize(String text){
        String[] tokens = text.split(" ");
        System.out.println("Tokenized text:");
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    public static void extractSentences(String text) {
        ArrayList<String> sentenses = new ArrayList<String>();
        sentenses.add("/**** ZOZNAM VIET ****/");

        Abbreviation skr = new Abbreviation();
        boolean dictionary = false;

        int sentense_last_char = 0;
        int word_last_char = 0;
        String word = "";
        String input = text;
        String next_line = "";

        input = next_line + " " + input;

        sentense_last_char = 0;
        word_last_char = 0;

        for (int i = 1; i < input.length() - 3; i++) {
            String ch = input.substring(i, i + 3);

//            vytvaranie slov
            if (input.charAt(i + 2) == ' ') {
                word = input.substring(word_last_char, i + 2).trim().toLowerCase();
                word_last_char = i + 3;
                dictionary = skr.isAbbreviation(word);
            }

//          delenie textu na vety

//          teraz sa deli text, ked konci veta cislovkou ale nemože sa začínať. Ak chceš aby sa mohla začínať, tak pridaj toto do podmienky.
//          && (input.substring(i-1,i).matches("[a-z]")
            if ((ch.matches("([!?.])(\\s)[A-Z]")) && !dictionary ) {
                sentenses.add(input.substring(sentense_last_char, i + 1));
                sentense_last_char = i + 1;
            }
        }

        next_line = input.substring(sentense_last_char, input.length()).trim();
        sentenses.add(next_line);
        sentenses.add("/*** KONIEC ZOZNAMU VIET ***/");

        for (String sentence : sentenses) {
            System.out.println(sentence);
        }
    }

}

