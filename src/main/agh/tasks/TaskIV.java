package agh.tasks;

import agh.objects.Judge;
import agh.objects.Judgment;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TaskIV {
    public String execute(LinkedHashMap<String, Judgment> judgmentList, String[] args, String didntFound) {
        String finalResult = "";
        for (int v = 0; v < args.length; v++) {
            if (judgmentList.containsKey(args[v])) {
                Judgment judgment = judgmentList.get(args[v]);
                LinkedHashMap<String, Judge> judges = judgment.getJudges();
                String judgesString = "";
                for (String key : judges.keySet()) {
                    Judge judge = judges.get(key);
                    LinkedList<String> specialRoles = judge.getSpecialRoles();
                    String roles = "";
                    if (specialRoles.size() == 0)
                        roles = "brak";
                    for (int it = 0; it < specialRoles.size(); it++) {
                        if (it > 0)
                            roles += ", ";
                        roles += specialRoles.get(it);
                    }
                    judgesString += judge.getName() + " - funkcja: " + judge.getFunction() + "; role: " + roles + "\n";
                }

                String publicationDate = judgment.getJudgmentDate();
                String code = judgment.getCourtType();
                String sygnatura = judgment.getFirstCaseNumber();
                finalResult += "Sygnatura orzeczenia: " + sygnatura + "\nData wydania orzeczenia: " + publicationDate + "\nRodzaj sądu: " + code + "\n\nSkład sędziów:\n" + judgesString;
            } else
                finalResult += args[v] + ": " + didntFound + "\n";
            if (v != args.length - 1)
                finalResult += "--------------------------------------------------------\n\n";
        }
        return finalResult;
    }
}
