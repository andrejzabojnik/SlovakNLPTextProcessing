package sk.textprocessor.processing;

/*V tejto triede budu funkcie na spracovanie textu ako tokenizacie atd.. nižie uvedana funkcia je samozrejme len provizorna */
public class TextProcesses {

    public void tokenize(String text){
        String[] tokens = text.split(" ");
        System.out.println("Tokenized text:");
        for (String token : tokens) {
            System.out.println(token);
        }
    }

}

