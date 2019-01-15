package agh;

import agh.objects.Judgment;
import agh.tasks.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solver {
    private LinkedHashMap<String, Judgment> judgmentList;
    private HistoryFile historyFile;

    public Solver(Parser parser, HistoryFile historyFile) {
        this.judgmentList = parser.getJudgmentList();
        this.historyFile = historyFile;
    }

    public String solve(TaskStorage taskStorage) throws IOException {
        Task task = taskStorage.getName();
        String[] args = taskStorage.getArgs();
        Boolean ifNeedArgs = taskStorage.getNeedArgs();
        String result;
        if (ifNeedArgs && args.length == 0) {
            result = "No or incorrect arguments";
        } else {
            String didntFound = "Nothing found";
            if (task.equals(Task.iii)) {
                TaskIII taskIII = new TaskIII();
                result = taskIII.execute(this.judgmentList, args[0], didntFound);
            } else if (task.equals(Task.iv)) {
                TaskIV taskIV = new TaskIV();
                result = taskIV.execute(this.judgmentList, args, didntFound);
            } else if (task.equals(Task.v)) {
                TaskV taskV = new TaskV();
                result = taskV.execute(this.judgmentList, args[0]);
            } else if (task.equals(Task.vi)) {
                TaskVI taskVI = new TaskVI();
                result = taskVI.execute(this.judgmentList);
            } else if (task.equals(Task.vii)) {
                TaskVII taskVII = new TaskVII();
                result = taskVII.execute(this.judgmentList);
            } else if (task.equals(Task.viii)) {
                TaskVIII taskVIII = new TaskVIII();
                result = taskVIII.execute(this.judgmentList);
            } else if (task.equals(Task.ix)) {
                TaskIX taskIX = new TaskIX();
                result = taskIX.execute(this.judgmentList);
            } else if (task.equals(Task.x)) {
                TaskX taskX = new TaskX();
                result = taskX.execute(this.judgmentList);
            } else if (task.equals(Task.nothing)) {
                return "";
            } else if (task.equals(Task.info)) {
                result = "Nazwa funkcji\tWymagany argument\tOpis\n" +
                        "content\t\ttak - jeden\t\tWyświetlanie uzasadnienia orzeczenia o określonej sygnaturze\n" +
                        "rubrum\t\ttak - dowolna ilość\tWyświetlanie rubrum dla podanych sygnatur\n" +
                        "judge\t\ttak - jeden\t\tWyświetlanie liczby orzeczeń dla wybranego sędziego\n" +
                        "judges\t\tnie\t\t\tWyświetlanie 10 sędziów, którzy wydali największą liczbę orzeczeń\n" +
                        "months\t\tnie\t\t\tWyświetlanie rozkładu statystycznego wyroków ze względu na miesiąc\n" +
                        "courts\t\tnie\t\t\tWyświetlanie rozkładu statystycznego wyroków ze względu na rodzaj sądu\n" +
                        "regulations\tnie\t\t\tWyświetlanie 10 najczęściej przywoływanych ustaw\n" +
                        "jury\t\tnie\t\t\tWyświetlanie rozkładu statystycznego liczby sędziów przypadających na orzeczenie\n\n" +
                        "Przykłady:\nrubrum \"II CSK 495/10\" \"IV CZ 130/13\"\n" +
                        "judge \"Wojciech Katner\"\n";
            } else
                result = "Incorrect function";
        }
        this.historyFile.addToFile(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "> " + taskStorage.getString() + "\r\n" + result + "\r\n");
        return result + "\n";
    }
}