package agh.tasks;

import agh.objects.Judgment;

import java.util.Arrays;
import java.util.LinkedHashMap;

abstract class AbstractSolve {
    protected LinkedHashMap<String, Judgment> judgmentList;

    protected void setJudgmentList(LinkedHashMap<String, Judgment> judgmentList) {
        this.judgmentList = judgmentList;
    }

    protected String sortListAndReturn10Values(LinkedHashMap<String, Integer> nameOfList) {
        String result = "";
        int sortedTab[] = new int[nameOfList.size()];
        int iter = 0;
        for (String key : nameOfList.keySet()) {
            sortedTab[iter] = nameOfList.get(key);
            iter++;
        }
        Arrays.sort(sortedTab);
        int amount = 0;
        for (int i = nameOfList.size() - 1; i >= 0 && amount < 10; i--) {
            for (String key : nameOfList.keySet()) {
                int actual = nameOfList.get(key);
                if (sortedTab[i] == actual) {
                    amount++;
                    result += actual + " - " + key + "\n";
                    nameOfList.remove(key);
                    break;
                }
            }
        }
        return result;
    }
}
