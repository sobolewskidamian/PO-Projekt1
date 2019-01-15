package agh.tasks;

import agh.objects.Judgment;

import java.util.LinkedHashMap;

public class TaskVII {
    public String execute(LinkedHashMap<String, Judgment> judgmentList) {
        String result = "";
        int amountInMonths[] = new int[12];
        for (String key : judgmentList.keySet()) {
            Judgment judgment = judgmentList.get(key);
            String publicationDate = judgment.getJudgmentDate();
            if (!publicationDate.equals("")) {
                String[] out = publicationDate.split("-");
                int month = Integer.parseInt(out[1]);
                amountInMonths[month - 1]++;
            }
        }
        for (int i = 0; i < 12; i++)
            result += getMonth(i + 1) + ": " + amountInMonths[i] + "\n";
        return result;
    }

    private String getMonth(int i) {
        switch (i) {
            case 1:
                return "Styczeń";
            case 2:
                return "Luty";
            case 3:
                return "Marzec";
            case 4:
                return "Kwiecień";
            case 5:
                return "Maj";
            case 6:
                return "Czerwiec";
            case 7:
                return "Lipiec";
            case 8:
                return "Sierpień";
            case 9:
                return "Wrzesień";
            case 10:
                return "Październik";
            case 11:
                return "Listopad";
            case 12:
                return "Grudzień";
            default:
                return "Błąd";
        }
    }
}
