import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.InvalidFileException;
import sk.textprocessor.exceptions.InvalidParametersException;
import sk.textprocessor.input.InputReader;
import sk.textprocessor.processing.TextProcesses;

/*Hlavna trieda kde sa bude všetko špuštat*/
public class Main {

/*Nčitame si najprv objekty pre spracovanie textu a vloženie suboru*/
    public static void main(String[] args) {
        TextProcesses textprocessor = new TextProcesses();
        InputReader input = new InputReader();

/*Objekt pre argumentParser a inputext musi byť v try catch pretože by mohly vyhodit chybu*/
        try {
            ArgumentParser parser = new ArgumentParser(args);
            String inputText = input.readFile(parser.getInputFile());

            if (parser.isTokenize()) {
                textprocessor.tokenize(inputText);
            }
            if (parser.isExtractSentences()) {
                textprocessor.extractSentences(inputText);
            }
        } catch (InvalidParametersException | InvalidFileException e) {
            System.err.println(e.getMessage());
        }




    }
}
