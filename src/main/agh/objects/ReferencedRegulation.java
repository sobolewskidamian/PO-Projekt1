package agh.objects;

public class ReferencedRegulation {
    private String journalTitle;
    private String text;

    public ReferencedRegulation(String journalTitle, String text) {
        this.journalTitle = journalTitle;
        this.text = text;
    }

    public String getJournalTitle() {
        return this.journalTitle;
    }

    public String getText() {
        return this.text;
    }
}
