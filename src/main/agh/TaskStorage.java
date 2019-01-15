package agh;

public class TaskStorage {
    private String string;
    private String[] args;
    private Task task;
    private Boolean needArgs;
    private String argsWithoutFuncionName = "";

    public TaskStorage(String string) {
        this.string = string;
        setTask();
        this.needArgs = needArgs(this.task);
        this.args = argsStringToArray();
    }

    private String nameOfFunction() {
        int length = this.string.length();
        String newName = "";
        for (int i = 0; i < length; i++) {
            char actualChar = this.string.charAt(i);
            if (actualChar == ' ') {
                String stringArgs = "";
                for (int j = i + 1; j < length; j++) {
                    char actualChar2 = this.string.charAt(j);
                    stringArgs += actualChar2;
                }
                this.argsWithoutFuncionName = stringArgs;
                break;
            }
            newName += actualChar;
        }
        return newName;
    }

    private String[] argsStringToArray() {
        int iloscCudzyslowow = 0;
        int iloscspacji = 0;
        int length = this.argsWithoutFuncionName.length();
        for (int i = 0; i < length; i++) {
            char actualPosition = this.argsWithoutFuncionName.charAt(i);
            if (actualPosition == '"')
                iloscCudzyslowow++;
            if (actualPosition == ' ')
                iloscspacji++;
        }
        if (length == 0 || iloscCudzyslowow % 2 == 1) {
            String[] t = {};
            return t;
        } else {
            String[] tab = new String[iloscCudzyslowow / 2 + iloscspacji + 1];
            for (int i = 0; i < tab.length; i++)
                tab[i] = "";
            String actualArg = "";
            boolean wCudzyslowie = false;
            boolean trafilemNaSpacje = true;
            int index = 0;
            for (int i = 0; i < length; i++) {
                char actualPosition = this.argsWithoutFuncionName.charAt(i);
                if (i == length - 1) {
                    if (actualPosition != ' ' && actualPosition != '"') {
                        actualArg += actualPosition;
                    }
                    tab[index] = actualArg;
                } else if (actualPosition == '"') {
                    if (wCudzyslowie || actualArg.length() > 0) {
                        tab[index] = actualArg;
                        actualArg = "";
                        index++;
                    }
                    wCudzyslowie = !wCudzyslowie;
                } else if (actualPosition == ' ' && !wCudzyslowie && trafilemNaSpacje) {
                } else if (actualPosition != ' ' || wCudzyslowie) {
                    actualArg += actualPosition;
                    trafilemNaSpacje = false;
                } else {
                    trafilemNaSpacje = true;
                    tab[index] = actualArg;
                    actualArg = "";
                    index++;
                }
            }
            int licznik = 0;
            for (int i = 0; i < tab.length; i++) {
                if (!(tab[i].equals("")))
                    licznik++;
            }
            String[] tab2 = new String[licznik];
            licznik = 0;
            for (int i = 0; i < tab.length; i++) {
                if (!tab[i].equals("")) {
                    tab2[licznik] = tab[i];
                    licznik++;
                }
            }
            return tab2;
        }
    }

    public Boolean needArgs(Task task) {
        if (task.equals(Task.iii) || task.equals(Task.iv) || task.equals(Task.v))
            return true;
        else
            return false;
    }

    private void setTask() {
        String a = nameOfFunction();
        switch (a) {
            case "content":
                this.task = Task.iii;
                return;
            case "rubrum":
                this.task = Task.iv;
                return;
            case "judge":
                this.task = Task.v;
                return;
            case "judges":
                this.task = Task.vi;
                return;
            case "months":
                this.task = Task.vii;
                return;
            case "courts":
                this.task = Task.viii;
                return;
            case "regulations":
                this.task = Task.ix;
                return;
            case "jury":
                this.task = Task.x;
                return;
            case "":
                this.task = Task.nothing;
                return;
            case "help":
                this.task = Task.info;
                return;
            default:
                this.task = Task.bad;
        }
    }

    public Task getName() {
        return this.task;
    }

    public String[] getArgs() {
        return this.args;
    }

    public Boolean getNeedArgs() {
        return this.needArgs;
    }

    public String getString() {
        return this.string;
    }
}