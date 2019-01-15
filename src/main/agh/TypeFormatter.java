package agh;

public class TypeFormatter {
    private String type;
    private int intType;

    public TypeFormatter(String a) {
        this.type = a;
    }

    public String courtType() {
        switch (this.type) {
            case "COMMON":
                return "Sąd Powszechny";
            case "SUPREME":
                return "Sąd Najwyższy";
            case "ADMINISTRATIVE":
                return "Sąd Administracyjny";
            case "CONSTITUTIONAL_TRIBUNAL":
                return "Trybunał Konstytucyjny";
            case "NATIONAL_APPEAL_CHAMBER":
                return "Krajowa Izba Odwoławcza";
            default:
                return "Nie zdefiniowano";
        }
    }

    public String sourceCodeType() {
        switch (this.type) {
            case "COMMON_COURT":
                return "Sąd Powszechny";
            case "SUPREME_COURT":
                return "Sąd Najwyższy";
            case "CONSTITUTIONAL_TRIBUNAL":
                return "Trybunał Konstytucyjny";
            case "NATIONAL_APPEAL_CHAMBER":
                return "Krajowa Izba Odwoławcza";
            default:
                return "Nie zdefiniowano";
        }
    }

    public String judgespecialRoles() {
        switch (this.type) {
            case "PRESIDING_JUDGE":
                return "Przewodniczacy składu sędziowskiego";
            case "REPORTING_JUDGE":
                return "Sędzia sprawozdawca";
            case "REASONS_FOR_JUDGMENT_AUTHOR":
                return "Autor uzasadnienia";
            default:
                return "Nie zdefiniowano";
        }
    }
}
