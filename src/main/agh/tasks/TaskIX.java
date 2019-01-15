package agh.tasks;

import agh.objects.Judgment;
import agh.objects.ReferencedRegulation;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TaskIX extends AbstractSolve {
    public String execute(LinkedHashMap<String, Judgment> judgmentList) {
        super.setJudgmentList(judgmentList);
        LinkedHashMap<String, Integer> ustawy = new LinkedHashMap<>();
        for (String key : judgmentList.keySet()) {
            Judgment judgment = judgmentList.get(key);
            LinkedList<ReferencedRegulation> referencedRegulations = judgment.getReferencedRegulation();
            for (int i = 0; i < referencedRegulations.size(); i++) {
                ReferencedRegulation referencedRegulation = referencedRegulations.get(i);
                String TytulUstawy = referencedRegulation.getJournalTitle();
                if (ustawy.containsKey(TytulUstawy)) {
                    int amount = ustawy.get(TytulUstawy);
                    ustawy.replace(TytulUstawy, amount, amount + 1);
                } else {
                    ustawy.put(TytulUstawy, 1);
                }
            }
        }
        return super.sortListAndReturn10Values(ustawy);
    }
}
