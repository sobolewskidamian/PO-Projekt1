package agh;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllFunctionsTest {

    @Test
    public void testFunctions() throws IOException, ParseException, IllegalAccessException {
        Path path = Paths.get("D:/Damian/Dokumenty/studia/III SEMESTR/Obiektowka/projekt/src/data");
        Parser parser = new Parser(path);
        Solver solver = new Solver(parser, new HistoryFile());
        String wejscie;

        wejscie = "content \"II CSK 495/10\"";
        TaskStorage taskstorage = new TaskStorage(wejscie);
        Assert.assertEquals(solver.solve(taskstorage), "Sygn. akt II CSK 495/10\n" +
                "POSTANOWIENIE\n" +
                "Dnia 6 maja 2011 r.\n" +
                "Sąd Najwyższy w składzie :\n" +
                "SSN Krzysztof Pietrzykowski (przewodniczący)\n" +
                "SSN Wojciech Katner (sprawozdawca)\n" +
                "SSN Katarzyna Tyczka-Rote\n" +
                "w sprawie z wniosku B. P.\n" +
                "przy uczestnictwie B. K.\n" +
                "o podział majątku wspólnego,\n" +
                "po rozpoznaniu na rozprawie w Izbie Cywilnej w dniu 6 maja 2011 r.,\n" +
                "skargi kasacyjnej uczestnika postępowania\n" +
                "od postanowienia Sądu Okręgowego\n" +
                "z dnia 16 marca 2010 r.,\n" +
                "oddala skargę kasacyjną.\n" +
                "Uzasadnienie\n" +
                "2\n" +
                "Postanowieniem z dnia 16 marca 2010 r. Sąd Okręgowy, po rozpoznaniu\n" +
                "apelacji wnioskodawczyni B. P. w sprawie z udziałem B. K. o podział majątku\n" +
                "wspólnego i uznaniu apelacji za częściowo uzasadnioną, zmienił postanowienie\n" +
                "Sądu Rejonowego w P. z dnia 21 kwietnia 2006 r. Sąd Okręgowy ponownie\n" +
                "rozpoznając sprawę, ze względu na uchylenie poprzedniego postanowienia z dnia\n" +
                "8 grudnia 2006 r., mocą postanowienia Sądu Najwyższego z dnia 6 lutego 2008 r.\n" +
                "(w sprawie o sygn. akt II CSK 419/07) - zaskarżonym obecnie postanowieniem\n" +
                "dokonał podziału majątku wspólnego wnioskodawczyni oraz uczestnika\n" +
                "postępowania przez przyznanie na własność wyłącznie wnioskodawczyni B. P.\n" +
                "szeregu działek wskazanych w pkt. 1.1.a. postanowienia; na własność wyłącznie\n" +
                "uczestnika postępowania B. K. przyznał szereg działek wskazanych w pkt 1.1.b.\n" +
                "postanowienia, a jedną działkę, stanowiącą drogę dojazdową do poszczególnych\n" +
                "działek obojga uczestników przyznał wnioskodawczyni i uczestnikowi postępowania\n" +
                "na współwłasność w częściach ułamkowych po 1\n" +
                "/2 części. Ponadto, Sąd Okręgowy\n" +
                "powołanym postanowieniem (pkt 1.2.) zasądził od wnioskodawczyni na rzecz\n" +
                "uczestnika dopłatę, celem wyrównania udziałów w majątku wspólnym, nakazał\n" +
                "uczestnikowi postępowania (pkt 1.3.) wydać wnioskodawczyni działki wskazane w\n" +
                "pkt 1.1.a. oraz dokonał rozliczenia nakładów z majątku odrębnego na majątek\n" +
                "wspólny (pkt 1.4. i I.5.), a także ustalił wartość przedmiotu sprawy (pkt I.6.), oddalił\n" +
                "apelację w pozostałym zakresie (pkt II) oraz rozstrzygnął o kosztach postępowania,\n" +
                "włącznie z kosztami postępowania apelacyjnego (pkt I.7., 1.8. oraz pkt III i IV).\n" +
                "W skardze kasacyjnej uczestnik postępowania zarzucił zaskarżonemu\n" +
                "postanowieniu naruszenie prawa materialnego, tj. art. 46 ustawy z dnia 25 lutego\n" +
                "1964 r. Kodeks rodzinny i opiekuńczy (Dz. U. Nr 9, poz. 59 ze zm., dalej jako k.r.\n" +
                "i op.), art. 1035 i nast. k.c., art. 1042 § 2 k.c. oraz art. 211 i 212 k.c. przez nietrafne\n" +
                "przyjęcie, że przy podziale majątku wspólnego uwzględnia się stan przedmiotów\n" +
                "majątkowych podlegających podziałowi z chwili dokonywania podziału, podczas\n" +
                "gdy wartość tę „należy określać według ich stanu z chwili ustania wspólności\n" +
                "majątkowej małżeńskiej\"; art. 43 § 1 k.r. i op. przez nieuwzględnienie tego,\n" +
                "3\n" +
                "że wnioskodawczyni otrzymała już na własność pewne działki składające się na\n" +
                "podlegającą podziałowi nieruchomość, co spowodowało przyznanie jej wartościowo\n" +
                "większej części majątku wspólnego, aniżeli uczestnikowi; art. 65 k.c. przez\n" +
                "dokonanie wykładni umowy stron zawartej w akcie notarialnym z dnia 1 sierpnia\n" +
                "1997 r. w sposób sprzeczny z jej wyraźnym sformułowaniem. Skarżący zarzucił\n" +
                "także naruszenie przepisów postępowania, tj. art. 316 k.p.c. „przez nietrafne\n" +
                "przyjęcie, że zasada orzekania według stanu rzeczy istniejącego w chwili\n" +
                "zamknięcia rozprawy wyłącza regułę prawa materialnego, nakazującą - przy\n" +
                "dokonywaniu podziału majątku wspólnego - uwzględnienie stanu wchodzących\n" +
                "w jego skład przedmiotów według innego momentu czasowego aniżeli chwila\n" +
                "orzekania\", a także pominięcie przy wydawaniu zaskarżonego postanowienia faktu\n" +
                "dokonania częściowego podziału majątku wspólnego stron postępowania.\n" +
                "Skarżący wniósł o uchylenie zaskarżonego postanowienia w całości i przekazanie\n" +
                "sprawy do ponownego rozpoznania wraz z rozstrzygnięciem o kosztach\n" +
                "postępowania.\n" +
                "Sąd Najwyższy zważył, co następuje:\n" +
                "Skarga kasacyjna, jako niezasadna podlega oddaleniu.\n" +
                "Zasadniczą kwestią sporną, podniesioną w skardze kasacyjnej jest ustalenie\n" +
                "chwili, według której ma zostać uwzględniony stan przedmiotów majątkowych\n" +
                "podlegających podziałowi po ustaniu wspólności ustawowej małżeńskiej oraz ich\n" +
                "wartość. Ocena prawna jest w tym wypadku dokonywana na podstawie\n" +
                "odpowiedniego stosowania art. 1035 i nast. k.c., do których odsyła art. 46 k.r. i op.\n" +
                "Z przepisów o wspólności majątku spadkowego i o dziale spadku, które z kolei\n" +
                "nakazują odpowiednie stosowanie przepisów o współwłasności w częściach\n" +
                "ułamkowych wynika, że przy podziale majątku w każdej z sytuacji, w której\n" +
                "„wspólność do niepodzielnej ręki\" staje się współwłasnością w częściach\n" +
                "ułamkowych, bierze się przy dokonywaniu podziału stan majątku z chwili powstania\n" +
                "tej współwłasności, a wartość majątku ocenia się według chwili orzekania\n" +
                "o podziale. W przypadku rozwiązania małżeństwa przez rozwód, jak w niniejszej\n" +
                "sprawie o stanie majątku podlegającego podziałowi decyduje chwila ustania\n" +
                "małżeństwa, a o wartości tego majątku - chwila dokonywania podziału, czyli\n" +
                "4\n" +
                "orzekania o tym podziale. Powyższa zasada nie budzi żadnych wątpliwości\n" +
                "w orzecznictwie oraz doktrynie.\n" +
                "Należy zauważyć, że ponownie rozpoznając sprawę Sąd Okręgowy\n" +
                "zastosował się do wytycznych zawartych w postanowieniu Sądu Najwyższego z\n" +
                "dnia 6 lutego 2008 r. i skrupulatnie dokonał rozliczeń majątkowych\n" +
                "wnioskodawczyni i uczestnika, przeprowadzając także dodatkowy dowód z opinii\n" +
                "biegłego w celu ustalenia wartości składników majątku, podlegających podziałowi\n" +
                "na chwilę dokonywania podziału, włącznie z ustaleniem wartości nakładu\n" +
                "uczestnika postępowania z tytułu spłaconego przez niego kredytu, który obciążał\n" +
                "oboje małżonków. Nie ma racji skarżący, który zarzuca Sądowi drugiej instancji,\n" +
                "że połączył ocenę stanu majątku podlegającego podziałowi z jego wartością na\n" +
                "chwilę dokonywania podziału. Można jedynie wskazać, że wobec nietrafnego,\n" +
                "krótkiego fragmentu uzasadnienia zaskarżonego postanowienia powstaje taka\n" +
                "wątpliwość, jednakże wobec pozostałych stwierdzeń Sądu drugiej instancji, który\n" +
                "obszernie i przekonująco uzasadnia zajęte stanowisko, nie można przychylić się do\n" +
                "stawianego w tym względzie zarzutu.\n" +
                "Niniejszy zarzut skargi kasacyjnej jest nietrafny także z innego powodu.\n" +
                "Otóż, od ustania małżeńskiej wspólności ustawowej minęło ćwierć wieku i w tym\n" +
                "czasie doszło do zmian w stanie faktycznym i prawnym nieruchomości, której\n" +
                "dotyczy podział. Stan faktyczny zmienił się przez to, że po ustaniu\n" +
                "wspólności uczestnik dokonał zmiany charakteru nieruchomości gruntowej przez\n" +
                "to, że grunt rolny, będący przedmiotem wspólności stał się w całości gruntem\n" +
                "dającym uprawnienia do jego zabudowy i został podzielony na kilkadziesiąt działek.\n" +
                "Działki te stały się przedmiotem obrotu, także z udziałem i za zgodą\n" +
                "obojga uczestników, którzy, jak ustalono w sprawie dzielili się dochodami\n" +
                "uzyskanymi z tego tytułu. Niektóre działki zostały podzielone między nimi za\n" +
                "obopólnym porozumieniem. Pomiędzy wydaniem zaskarżonego orzeczenia,\n" +
                "a rozpoznawaniem niniejszej skargi kolejne dwie działki zostały przez uczestnika\n" +
                "sprzedane. Nie można więc tych wszystkich faktów nie uwzględnić i przyjąć pogląd,\n" +
                "który wynika ze skargi kasacyjnej, choć nie jest wyraźnie podniesiony przez\n" +
                "uczestnika, że jego zdaniem podziałowi według wartości z daty podziału winien\n" +
                "podlegać grunt rolny. Jednakże w taki sposób nie można rozumieć pojęcia „stan\n" +
                "5\n" +
                "majątku z chwili ustania wspólności majątkowej\". Przekształcenie gruntu rolnego\n" +
                "w nieruchomość gruntową do zabudowy nic nie zmieniło w stanie nieruchomości.\n" +
                "Jest to ta sama prawnie nieruchomość gruntowa, co pierwotnie, w całości o tej\n" +
                "samej powierzchni i w tym samym miejscu położenia, która bez żadnych istotnych\n" +
                "nakładów majątkowych uczestnika przekształciła się mocą decyzji administracyjnej\n" +
                "w nieruchomość podzieloną następnie na działki budowlane. Należy zwrócić uwagę\n" +
                "na ten fragment uzasadnienia przytoczonego postanowienia Sądu Najwyższego\n" +
                "zapadłego w sprawie o sygn. akt II CSK 419/07, w którym zawarto odniesienie do\n" +
                "upływu znacznego czasu między stanem istniejącym wtedy, gdy istniała wspólność\n" +
                "majątkowa a dokonywaniem podziału majątku, którego cena różna w obu tych\n" +
                "chwilach nie może prowadzić do pokrzywdzenia jednego z byłych małżonków.\n" +
                "Słusznie powołano na takie okoliczności utrwalone już stanowisko judykatury,\n" +
                "zgodnie z którym o rozstrzygnięciach co do dzielonego majątku decydują\n" +
                "we wszystkich sprawach działowych, a więc i przy podziale majątku wspólnego\n" +
                "małżeńskiego, okoliczności i dowody występujące w chwili podziału\n" +
                "(por. postanowienia SN z dnia 27 sierpnia 1979 r., III CRN 137/79, OSNCP 1980,\n" +
                "nr 2, poz. 33 oraz z dnia 16 marca 1994 r., II CRN 31/94, Wokanda 1994, nr 9,\n" +
                "poz. 9).\n" +
                "Z tych względów Sąd drugiej instancji trafnie przyjął jako stan majątku\n" +
                "z chwili ustania wspólności majątkowej małżeńskiej - nieruchomość, która należała\n" +
                "do wspólności, ale już jako działki budowlane, co z kolei doprowadziło do tego,\n" +
                "że wartość tych działek stała się podstawą obliczenia wartości udziałów\n" +
                "przypadających każdemu z małżonków. Przyjęcie odmiennego stanowiska\n" +
                "i uznanie za właściwe obliczenie wartości majątku na dzień podziału jako gruntu\n" +
                "rolnego, który od bardzo dawna nie istnieje w tej postaci prawnej, doprowadziłoby\n" +
                "do rezultatów rażąco niesprawiedliwych dla wnioskodawczyni. Tak samo\n" +
                "należałoby ocenić sytuację odwrotną do tej, jaka wystąpiła w niniejszej sprawie,\n" +
                "to znaczy, gdyby grunt budowlany z jakichś powodów został przekształcony\n" +
                "w nieruchomość o znacznie mniejszej wartości (np. wywłaszczony pod drogę).\n" +
                "W takim przypadku, dokonując podziału majątku, jego wartość należałoby odnieść\n" +
                "do stanu gruntu z dnia ustania wspólności, ale z uwzględnieniem zmian prawnych\n" +
                "dotyczących wszystkich współwłaścicieli.\n" +
                "6\n" +
                "W niniejszej sprawie podział majątku wspólnego jest o tyle łatwiejszy,\n" +
                "że następuje w naturze, bo takie jest oczekiwanie wnioskodawczyni. Podział\n" +
                "dokonany przez Sąd w zaskarżonym postanowieniu jest logiczny, uwzględnia\n" +
                "interesy wnioskodawczyni i uczestnika, dokonuje prawidłowych rozliczeń miedzy\n" +
                "nimi. Nie można podzielić zarzutów skarżącego odnoszących do naruszenia art. 43\n" +
                "§ 1 k.r. i op. przez nieuwzględnienie w ramach dokonanego przez strony podziału\n" +
                "częściowego to jest, że wnioskodawczyni otrzymała już wcześniej pewne działki\n" +
                "składające się na nieruchomość, ponieważ te działki nie są przedmiotem podziału\n" +
                "w niniejszej sprawie. Podstawy prawne takiego słusznego stanowiska zostały\n" +
                "obszernie i przekonująco wyjaśnione w uzasadnieniu zaskarżonego postanowienia.\n" +
                "Odnosi się to również do zarzutu naruszenia art. 65 k.c. w stosunku do wykładni\n" +
                "umowy stron w akcie notarialnym z dnia 1 sierpnia 1997 r. Z oświadczeń stron tej\n" +
                "umowy, a także już jako uczestników tego postępowania wynika, że dokonywane\n" +
                "przez nich podziały umowne nie były związane z wzajemnymi rozliczeniami\n" +
                "i dopłatami. Kwestia ta pojawiła się dopiero w związku ze sporami wynikającymi już\n" +
                "z niniejszej sprawy. Nie było podstaw, aby kwestionować skutki wcześniejszych\n" +
                "oświadczeń woli stron, zwłaszcza że na wady oświadczenia woli żadna ze stron nie\n" +
                "powoływała się.\n" +
                "Zarzut naruszenia prawa procesowego, tj. art. 316 § 1 w zw. z art. 13 § 2\n" +
                "k.p.c. także należy ocenić jako bezzasadny. Sąd drugiej instancji, wbrew\n" +
                "twierdzeniom skarżącego nie przyjął stanowiska, iż zasada orzekania według stanu\n" +
                "rzeczy istniejącego w chwili zamknięcia rozprawy wyłącza zasadę, zgodnie z którą\n" +
                "przy dokonywaniu podziału majątku wspólnego uwzględnia się stan przedmiotów\n" +
                "według innego momentu niż chwila orzekania. Z przedstawionych wcześniej\n" +
                "rozważań wynika, że Sądowi drugiej instancji nie można zarzucić, iż połączył ocenę\n" +
                "stanu majątku podlegającego podziałowi z jego wartością na chwilę dokonywania\n" +
                "podziału. Należy natomiast podkreślić, iż w art. 316 § 1 k.p.c. sformułowano\n" +
                "zasadę, iż podstawą rozstrzygnięcia jest stan rzeczy istniejący w chwili zamknięcia\n" +
                "rozprawy, a więc sąd nie może wydając orzeczenie merytoryczne powoływać się na\n" +
                "późniejsze zdarzenia, zaszłe po zamknięciu rozprawy (por. wyrok SN z 5 września\n" +
                "2008 r., I CSK 41/08, niepubl.). Taki jest cel powołanego przepisu i bezzasadnie\n" +
                "7\n" +
                "skarżący dokonał zestawienia regulacji z art. 316 § 1 k.p.c. z art. 1035 i nast. k.c. w\n" +
                "zw. z art. 46 k.r. i op.\n" +
                "Z przedstawionych względów, na podstawie art. 39814\n" +
                "w zw. z art. 13 § 2\n" +
                "k.p.c. Sąd Najwyższy oddalił skargę kasacyjną.\n\n\n");

        wejscie = "rubrum \"II CSK 495/10\"";
        taskstorage = new TaskStorage(wejscie);

        Assert.assertEquals(solver.solve(taskstorage),
                "Sygnatura orzeczenia: II CSK 495/10\n" +
                        "Data wydania orzeczenia: 2011-05-06\n" +
                        "Rodzaj sądu: Sąd Najwyższy\n" +
                        "\n" +
                        "Skład sędziów:\n" +
                        "Katarzyna Tyczka-Rote - funkcja: SSN; role: brak\n" +
                        "Krzysztof Pietrzykowski - funkcja: SSN; role: Przewodniczacy składu sędziowskiego\n" +
                        "Wojciech Katner - funkcja: SSN; role: Autor uzasadnienia, Sędzia sprawozdawca\n" +
                        "\n");

        wejscie = "judge \"Krzysztof Pietrzykowski\"";
        taskstorage = new TaskStorage(wejscie);
        Assert.assertEquals(solver.solve(taskstorage), "Krzysztof Pietrzykowski - liczba orzeczeń: 10\n");

        wejscie = "judges";
        taskstorage = new TaskStorage(wejscie);
        Assert.assertEquals(solver.solve(taskstorage), "41 - Wojciech Katner\n" +
                "20 - Bogumiła Ustjanicz\n" +
                "18 - Piotr Tuleja\n" +
                "14 - Marta Romańska\n" +
                "14 - Anna Owczarek\n" +
                "14 - Andrzej Rzepliński\n" +
                "14 - Zbigniew Myszka\n" +
                "13 - Aurelia Pietrzak\n" +
                "13 - Józef Frąckowiak\n" +
                "12 - Bogusław Cudowski\n" +
                "\n");

        wejscie = "months";
        taskstorage = new TaskStorage(wejscie);
        Assert.assertEquals(solver.solve(taskstorage), "Styczeń: 0\n" +
                "Luty: 0\n" +
                "Marzec: 100\n" +
                "Kwiecień: 31\n" +
                "Maj: 68\n" +
                "Czerwiec: 196\n" +
                "Lipiec: 199\n" +
                "Sierpień: 0\n" +
                "Wrzesień: 97\n" +
                "Październik: 0\n" +
                "Listopad: 196\n" +
                "Grudzień: 98\n" +
                "\n");

        wejscie = "courts";
        taskstorage = new TaskStorage(wejscie);
        Assert.assertEquals(solver.solve(taskstorage), "Sąd Najwyższy: 118\n" +
                "Krajowa Izba Odwoławcza: 129\n" +
                "Sąd Powszechny: 691\n" +
                "Trybunał Konstytucyjny: 47\n" +
                "\n");

        wejscie = "regulations";
        taskstorage = new TaskStorage(wejscie);
        Assert.assertEquals(solver.solve(taskstorage), "629 - Ustawa z dnia 17 listopada 1964 r. - Kodeks postępowania cywilnego\n" +
                "398 - Ustawa z dnia 23 kwietnia 1964 r. - Kodeks cywilny\n" +
                "135 - Konstytucja Rzeczypospolitej Polskiej z dnia 2 kwietnia 1997 r.\n" +
                "135 - Ustawa z dnia 6 czerwca 1997 r. - Kodeks karny\n" +
                "131 - Ustawa z dnia 6 czerwca 1997 r. - Kodeks postępowania karnego\n" +
                "100 - Rozporządzenie Prezesa Rady Ministrów z dnia 15 marca 2010 r. w sprawie wysokości i sposobu pobierania wpisu od odwołania oraz rodzajów kosztów w postępowaniu odwoławczym i sposobu ich rozliczania\n" +
                "90 - Obwieszczenie Marszałka Sejmu Rzeczypospolitej Polskiej z dnia 8 czerwca 2010 r. w sprawie ogłoszenia jednolitego tekstu ustawy - Prawo zamówień publicznych\n" +
                "87 - Rozporządzenie Ministra Sprawiedliwości z dnia 28 września 2002 r. w sprawie opłat za czynności adwokackie oraz ponoszenia przez Skarb Państwa kosztów nieopłaconej pomocy prawnej udzielonej z urzędu\n" +
                "82 - Ustawa z dnia 17 grudnia 1998 r. o emeryturach i rentach z Funduszu Ubezpieczeń Społecznych\n" +
                "75 - Rozporządzenie Ministra Sprawiedliwości z dnia 28 września 2002 r. w sprawie opłat za czynności radców prawnych oraz ponoszenia przez Skarb Państwa kosztów pomocy prawnej udzielonej przez radcę prawnego ustanowionego z urzędu\n" +
                "\n");

        wejscie = "jury";
        taskstorage = new TaskStorage(wejscie);
        Assert.assertEquals(solver.solve(taskstorage), "0: 86\n" +
                "1: 435\n" +
                "2: 10\n" +
                "3: 443\n" +
                "5: 7\n" +
                "7: 2\n" +
                "13: 1\n" +
                "15: 1\n" +
                "\n");
    }
}
