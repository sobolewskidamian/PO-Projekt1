package agh.tasks;

import agh.objects.Judgment;

import java.util.LinkedHashMap;

public class TaskVIII {
    public String execute(LinkedHashMap<String, Judgment> judgmentList) {
        String result = "";
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        for (String key : judgmentList.keySet()) {
            Judgment judgment = judgmentList.get(key);
            String courtType = judgment.getCourtType();
            if (list.containsKey(courtType))
                list.replace(courtType, list.get(courtType) + 1);
            else
                list.put(courtType, 1);
        }
        for (String key : list.keySet())
            result += key + ": " + list.get(key) + "\n";
        return result;
    }
}
