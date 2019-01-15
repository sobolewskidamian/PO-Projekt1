package agh.tasks;

import agh.objects.Judge;
import agh.objects.Judgment;

import java.util.LinkedHashMap;

public class TaskV {
    public String execute(LinkedHashMap<String, Judgment> judgmentList, String arg) {
        String nameAndSurname = arg;
        int counter = 0;
        for (String key : judgmentList.keySet()) {
            Judgment judgment = judgmentList.get(key);
            LinkedHashMap<String, Judge> judges = judgment.getJudges();
            for (String nameOfJudge : judges.keySet())
                if (nameOfJudge.equals(nameAndSurname))
                    counter++;
        }
        return nameAndSurname + " - liczba orzeczeń: " + counter;
    }
}
