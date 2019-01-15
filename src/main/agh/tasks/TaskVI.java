package agh.tasks;

import agh.objects.Judge;
import agh.objects.Judgment;

import java.util.LinkedHashMap;

public class TaskVI extends AbstractSolve {
    public String execute(LinkedHashMap<String, Judgment> judgmentList) {
        super.setJudgmentList(judgmentList);
        LinkedHashMap<String, Integer> judgesFinal = new LinkedHashMap<>();
        for (String key : judgmentList.keySet()) {
            Judgment judgment = judgmentList.get(key);
            LinkedHashMap<String, Judge> judges = judgment.getJudges();
            for (String nameOfJudge : judges.keySet()) {
                if (judgesFinal.containsKey(nameOfJudge)) {
                    int amount = judgesFinal.get(nameOfJudge);
                    judgesFinal.replace(nameOfJudge, amount, amount + 1);
                } else {
                    judgesFinal.put(nameOfJudge, 1);
                }
            }
        }
        return super.sortListAndReturn10Values(judgesFinal);
    }
}
