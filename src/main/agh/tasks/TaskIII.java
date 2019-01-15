package agh.tasks;

        import agh.objects.Judgment;

        import java.util.LinkedHashMap;

public class TaskIII {
    public String execute(LinkedHashMap<String, Judgment> judgmentList, String arg, String didntFound) {
        if (judgmentList.containsKey(arg)) {
            Judgment judgment = judgmentList.get(arg);
            String textContent = judgment.getTextContent();
            return textContent.replaceAll("\\<.*?\\>", "") + "\n";
        } else
            return arg + ": " + didntFound;
    }
}
