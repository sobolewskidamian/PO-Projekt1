package agh.tasks;

import agh.objects.Judge;
import agh.objects.Judgment;

import java.util.LinkedHashMap;

public class TaskX {
    public String execute(LinkedHashMap<String, Judgment> judgmentList) {
        String result = "";
        int max = 0;
        for (String key : judgmentList.keySet()) {
            Judgment judgment = judgmentList.get(key);
            LinkedHashMap<String, Judge> judges = judgment.getJudges();
            if (judges.size() > max)
                max = judges.size();
        }
        int[] tab = new int[max + 1];
        for (String key : judgmentList.keySet()) {
            Judgment judgment = judgmentList.get(key);
            LinkedHashMap<String, Judge> judges = judgment.getJudges();
            tab[judges.size()]++;
        }
        for (int i = 0; i <= max; i++) {
            if (tab[i] == 0)
                continue;
            result += i + ": " + tab[i] + "\n";
        }
        return result;
    }
}
