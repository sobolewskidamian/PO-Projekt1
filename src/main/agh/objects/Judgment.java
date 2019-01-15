package agh.objects;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Judgment {
    private String courtType;
    private LinkedList<String> caseNumbers;
    private LinkedHashMap<String, Judge> judges;
    private String textContent;
    private LinkedList<ReferencedRegulation> referencedRegulations;
    private String judgmentDate;

    public Judgment(String courtType, String textContent, String judgmentDate) {
        this.courtType = courtType;
        this.caseNumbers = new LinkedList<>();
        this.textContent = textContent;
        this.judgmentDate = judgmentDate;
        this.referencedRegulations = new LinkedList<>();
        this.judges = new LinkedHashMap<>();
    }

    public void addJudge(Judge judge) {
        this.judges.put(judge.getName(), judge);
    }

    public void addReferencedRegulation(ReferencedRegulation referencedRegulations) {
        this.referencedRegulations.add(referencedRegulations);
    }

    public void addCaseNumber(String caseNumber) {
        this.caseNumbers.add(caseNumber);
    }

    public String getTextContent() {
        return textContent;
    }

    public LinkedHashMap<String, Judge> getJudges() {
        return this.judges;
    }

    public String getCourtType() {
        return this.courtType;
    }

    public String getJudgmentDate() {
        return this.judgmentDate;
    }

    public LinkedList<ReferencedRegulation> getReferencedRegulation() {
        return this.referencedRegulations;
    }

    public String getFirstCaseNumber() {
        if (this.caseNumbers.size() != 0)
            return this.caseNumbers.getFirst();
        else
            return "";
    }
}
