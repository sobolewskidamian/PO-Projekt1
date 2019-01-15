package agh;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import agh.objects.Judge;
import agh.objects.Judgment;
import agh.objects.ReferencedRegulation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.*;
import org.jsoup.nodes.*;


public class Parser {
    private Path path;
    private LinkedHashMap<String, Judgment> judgmentList;
    private List<Path> dirJSON;
    private List<Path> dirHTML;
    private String info;

    public Parser(Path path) throws ParseException, IOException, IllegalAccessException {
        this.path = path;
        this.judgmentList = new LinkedHashMap<>();
        openFiles();
        this.info = parseAllFiles();
    }

    private void openFiles() throws IOException, OutOfMemoryError, IllegalAccessException {
        List<Path> resultJSON = new ArrayList<>();
        List<Path> resultHTML = new ArrayList<>();
        if (!Files.exists(this.path))
            throw new IllegalAccessException(this.path.toString() + ": The specified path doesn't exist.");
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(this.path, "judgments-*.{json}");
            for (Path it : stream)
                resultJSON.add(it.toAbsolutePath());

            stream = Files.newDirectoryStream(this.path, "[0-9][0-9]");
            for (Path it : stream) {
                Path thisPath = it.toAbsolutePath();
                DirectoryStream<Path> stream2 = Files.newDirectoryStream(thisPath, "[0-9][0-9]");
                for (Path it2 : stream2) {
                    Path thisPath2 = Paths.get(thisPath + "/" + it2.getFileName() + "/");
                    DirectoryStream<Path> stream3 = Files.newDirectoryStream(thisPath2, "*.{html}");
                    for (Path it3 : stream3)
                        resultHTML.add(Paths.get(thisPath2 + "/" + it3.getFileName()));
                }
            }
        } catch (DirectoryIteratorException | IOException | OutOfMemoryError e) {
            throw e;
        }
        this.dirJSON = resultJSON;
        this.dirHTML = resultHTML;
    }

    private String parseAllFiles() throws IOException, ParseException, IllegalAccessException {
        JSONParser parser = new JSONParser();
        try {
            for (Path it : this.dirHTML) {
                Document document = Jsoup.parse(new File(it.toString()), "UTF-8");
                addJudgmentsHTML(document);
            }
            for (Path it : this.dirJSON) {
                JSONObject obj = (JSONObject) parser.parse(new FileReader(it.toString()));
                addJudgmentsJSON(obj);
            }
            if (this.dirJSON.size() == 0 && this.dirHTML.size() == 0)
                throw new IllegalAccessException("No files in the specified path.");
            return (this.dirJSON.size() + this.dirHTML.size()) + " files have been loaded. (" + dirJSON.size() + " JSONs and " + dirHTML.size() + " HTMLs)";
        } catch (ParseException | IOException | IllegalAccessException e) {
            throw e;
        }
    }

    private void addJudgmentsJSON(JSONObject obj) {
        JSONArray judgments = (JSONArray) obj.get("items");
        for (int i = 0; i < judgments.size(); i++) {
            JSONObject actual = (JSONObject) judgments.get(i);
            TypeFormatter formatter;
            formatter = new TypeFormatter((String) actual.get("courtType"));
            Judgment judgment = new Judgment(formatter.courtType(),
                    (String) actual.get("textContent"),
                    (String) actual.get("judgmentDate"));
            JSONArray judges = (JSONArray) actual.get("judges");
            for (int j = 0; j < judges.size(); j++) {
                JSONObject thisJudge = (JSONObject) judges.get(j);
                Judge judge = new Judge((String) thisJudge.get("name"),
                        (String) thisJudge.get("function"));
                JSONArray specialRolesArr = (JSONArray) thisJudge.get("specialRoles");
                for (int k = 0; k < specialRolesArr.size(); k++) {
                    formatter = new TypeFormatter((String) specialRolesArr.get(k));
                    judge.addSpecialRole(formatter.judgespecialRoles());
                }
                judgment.addJudge(judge);
            }
            JSONArray rfrncs = (JSONArray) actual.get("referencedRegulations");
            for (int j = 0; j < rfrncs.size(); j++) {
                JSONObject thisReferencedRegulation = (JSONObject) rfrncs.get(j);
                ReferencedRegulation referencedRegulation = new ReferencedRegulation((String) thisReferencedRegulation.get("journalTitle"),
                        (String) thisReferencedRegulation.get("text"));
                judgment.addReferencedRegulation(referencedRegulation);
            }
            JSONArray caseNumberArray = (JSONArray) actual.get("courtCases");
            String courtCaseNumber = "";
            for (int j = 0; j < caseNumberArray.size(); j++) {
                JSONObject caseNumberObj = (JSONObject) caseNumberArray.get(j);
                String caseNumber = (String) caseNumberObj.get("caseNumber");
                judgment.addCaseNumber(caseNumber);
                if (j == 0)
                    courtCaseNumber = caseNumber;
            }
            this.judgmentList.put(courtCaseNumber, judgment);
        }
    }

    private void addJudgmentsHTML(Document document) {
        String courtCaseNumber;
        String courtType = "";
        String textContent = "";
        String judgmentDate = "";
        LinkedList<Judge> judges = new LinkedList<>();
        LinkedList<ReferencedRegulation> RR = new LinkedList<>();
        String textRR = "";

        courtCaseNumber = document.select("span.war_header").text();
        String[] tab = courtCaseNumber.split(" - ");
        if (tab.length != 0)
            courtCaseNumber = tab[0];

        for (Element actualElement : document.select("tr.niezaznaczona")) {
            String actualKey = actualElement.select("td.lista-label").text();
            String actualValue = actualElement.select("td.info-list-value").toString();
            String actualValueWithoutArrays = actualElement.select("td.info-list-value").text();
            if (actualKey.equals("Sędziowie")) {
                String[] Sedzia = actualValue.split("<br>");
                for (int w = 0; w < Sedzia.length; w++) {
                    String actualJudge = Sedzia[w].replaceAll(" ?\\<.*?\\> ?", "");
                    String[] judgeArr = actualJudge.split(" /");
                    Judge judge = new Judge(judgeArr[0], "brak");
                    Boolean odw = false;
                    String funkcje = "";
                    for (int x = 0; x < actualJudge.length(); x++) {
                        char actChar = actualJudge.charAt(x);
                        if (actChar == '/') {
                            odw = !odw;
                            continue;
                        }
                        if (odw)
                            funkcje += actChar;
                    }
                    String[] functions = funkcje.split(" ");
                    for (int x = 0; x < functions.length; x++)
                        if (functions[x].equals(""))
                            judge.addSpecialRole("brak");
                        else
                            judge.addSpecialRole(functions[x]);
                    judges.add(judge);
                }
            } else if (actualKey.equals("Sąd")) {
                courtType = splitWandWE(actualValueWithoutArrays);
            } else if (actualKey.equals("Data orzeczenia")) {
                String[] type = actualValueWithoutArrays.split(" ");
                if (type.length != 0)
                    judgmentDate = type[0];
            } else if (actualKey.equals("Powołane przepisy")) {
                String[] Przepisy = actualValue.split("<br>");
                textRR = actualValueWithoutArrays;
                for (int x = 0; x < Przepisy.length; x++) {
                    Element element = Jsoup.parse(Przepisy[x]);
                    if (x % 2 == 1) {
                        String[] keys = element.text().split(" - t");
                        if (keys.length == 1)
                            keys = element.text().split("- t");
                        StringBuilder key = new StringBuilder();
                        if (keys.length == 1)
                            key.append(keys[0]);
                        else {
                            for (int i = 0; i < keys.length - 1; i++) {
                                key.append(keys[i]);
                                if (i > 0)
                                    key.append(" - t");
                            }
                        }
                        if (key.length() >= 2 && (key.charAt(key.length() - 1) == '.' && key.charAt(key.length() - 2) != 'r'))
                            key = key.deleteCharAt(key.length() - 1);
                        RR.add(new ReferencedRegulation(key.toString(), textRR + " " + element.text()));
                    } else
                        textRR = element.text();
                }
            }
        }
        textContent = document.select("span.info-list-value-uzasadnienie").text();
        Judgment judgment = new Judgment(courtType, textContent, judgmentDate);
        judgment.addCaseNumber(courtCaseNumber);
        for (int i = 0; i < judges.size(); i++)
            judgment.addJudge(judges.get(i));
        for (int i = 0; i < RR.size(); i++)
            judgment.addReferencedRegulation(RR.get(i));
        this.judgmentList.put(courtCaseNumber, judgment);
    }

    private String splitWandWE(String courtype) {
        String[] type = courtype.split(" w ");
        if (type.length < 2)
            type = courtype.split(" we ");
        if (type.length == 0)
            return "";
        else
            return type[0];
    }

    public LinkedHashMap<String, Judgment> getJudgmentList() {
        return this.judgmentList;
    }

    public String getInfo() {
        return this.info;
    }
}