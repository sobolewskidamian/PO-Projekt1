package agh;

import org.json.simple.parser.ParseException;
//import org.jline.reader.*;
//import org.jline.terminal.*;
import jline.console.ConsoleReader;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();

            HistoryFile historyFile;
            if (args.length != 0)
                historyFile = new HistoryFile(Paths.get(args[0]));
            else
                historyFile = new HistoryFile();

            /*Terminal terminal = TerminalBuilder
                    .builder()
                    .system(true)
                    .build();
            LineReader linereader = LineReaderBuilder.builder().terminal(terminal).build();*/

            ConsoleReader linereader = new ConsoleReader(System.in, System.out);

            System.out.print("Specify the path: ");
            String path = linereader.readLine();

            Parser data = new Parser(Paths.get(path));
            System.out.println(data.getInfo());

            Solver solver = new Solver(data, historyFile);

            System.out.println("To get information enter: help\nTo finish enter: quit");

            String wejscie;
            while (!(wejscie = linereader.readLine("> ")).equals("quit")) {
                TaskStorage taskStorage = new TaskStorage(wejscie);

                String wynik = solver.solve(taskStorage);

                System.out.print(wynik);
            }
            System.exit(0);
        } catch (ParseException |
                IOException |
                OutOfMemoryError |
                IllegalAccessException |
                InterruptedException |
                //org.jline.reader.UserInterruptException |
                java.nio.file.InvalidPathException e) {
            System.out.println(e.getMessage());
        }
    }
}
