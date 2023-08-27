package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//revidovano
object PsychologyTen {
    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Nejvhodnější termín pro situaci, kdy po hodinovém čekání ve frontě zjistíte, že s sebou nemáte peníze, je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """amnézie""",
                    false,
                    "Je ztráta paměti zasahující explicitní (sémantickou - naučenou nebo epizodickou - epizody života)"
                ),
                PsychologyTermAnswer(
                    """deprivace""",
                    false
                ),
                PsychologyTermAnswer(
                    """frustrace""",
                    false
                ),
            ),
            questionNumber = 1,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """S logickým a analytickým myšlením souvisí""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """více levá hemisféra""",
                    false
                ),
                PsychologyTermAnswer(
                    """více pravá hemisféra""",
                    false
                ),
                PsychologyTermAnswer(
                    """obě hemisféry stejnou měrou""",
                    false
                ),
            ),
            questionNumber = 2,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Přirozený smích je provázen""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """rozšířením a pootevřením úst a přivřením očních štěrbin""",
                    false
                ),
                PsychologyTermAnswer(
                    """širokým otevřením očí a sevřením rtů""",
                    false
                ),
                PsychologyTermAnswer(
                    """širokým otevřením očí a vyceněním zubů""",
                    false
                ),
            ),
            questionNumber = 3,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Krátkodobá paměť má v průměru rozsah zhruba""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """1 předmět (štěp)""",
                    false
                ),
                PsychologyTermAnswer(
                    """7 předmětů (štěpů)""",
                    false,
                    "7-+2, George Miller (1956)"
                ),
                PsychologyTermAnswer(
                    """20 předmětů (štěpů)""",
                    false
                ),
            ),
            questionNumber = 4,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Pokud se ve vypjaté situaci začne dospělý chovat jako dítě, hovoříme o věkové""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """regresi""",
                    false,
                    "Nevědomý obranný mechanizmus. Únik na vývojově nižší úroveň chování."
                ),
                PsychologyTermAnswer(
                    """agresi""",
                    false
                ),
                PsychologyTermAnswer(
                    """digresi""",
                    false,
                    "V psychologii neexistuje"
                ),
            ),
            questionNumber = 5,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Z následujících cílů psychologie je nejobtížnější""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """deskripce""",
                    false
                ),
                PsychologyTermAnswer(
                    """predikce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """klasifikace""",
                    false
                ),
            ),
            questionNumber = 6,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Pokud nějaká psychologická teorie přetrvává několik desítek let, je jisté, že""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """pozitivně smýšlí o lidech""",
                    false
                ),
                PsychologyTermAnswer(
                    """někoho zaujala""",
                    false
                ),
                PsychologyTermAnswer(
                    """je zatím nezpochybněná""",
                    false
                ),
            ),
            questionNumber = 7,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Ústředním motivem díla Viktora Emila Frankla je""",
            textAnswer = "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě",
            answers = listOf(
                PsychologyTermAnswer(
                    """smysl života""",
                    false
                ),
                PsychologyTermAnswer(
                    """pud moci""",
                    false
                ),
                PsychologyTermAnswer(
                    """učení nápodobou""",
                    false
                ),
            ),
            questionNumber = 8,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """V 1,5 roce ovládá dítě asi""",
            textAnswer = "Všude se tvrdí jiné počty, hodně záleží. Okolo 1 roku to bývá 50 slov, 3 roky 1000 slov, 5 roků 10000 slov.",
            answers = listOf(
                PsychologyTermAnswer(
                    """15-30 slov""",
                    false
                ),
                PsychologyTermAnswer(
                    """150-300 slov""",
                    false
                ),
                PsychologyTermAnswer(
                    """1000 slov""",
                    false
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Myšlení je nejvíce spojeno s""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """emocemi""",
                    false
                ),
                PsychologyTermAnswer(
                    """vůlí""",
                    false
                ),
                PsychologyTermAnswer(
                    """řečí""",
                    false,
                    "Relativní hypotéza: Hypotéza lingvistického relativismu (Sapir-Whorf hypotéza, Whorfianism) - lidé mluvící odlišnými jazyky, mají odlišené kognitivní systémy, tudíž vnímání světa."
                ),
            ),
            questionNumber = 10,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Chodit začínají malé děti v průměru v(e)""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """6 měsících""",
                    false,
                    "umí se kroutit"
                ),
                PsychologyTermAnswer(
                    """9 měsících""",
                    false,
                    "to se umí plazit"
                ),
                PsychologyTermAnswer(
                    """12 měsících""",
                    false,
                    "už začínají být sociální - deferred imitation - hrají si se stejnou hračkou co ostatní děti"
                ),
            ),
            questionNumber = 11,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Jestliže u Vás vyvolává pouhý pohled na tvář určitého politika rozčilení, jedná se o""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """nepodmíněnou reakci""",
                    false
                ),
                PsychologyTermAnswer(
                    """podmíněnou reakci""",
                    false
                ),
                PsychologyTermAnswer(
                    """reaktivní výtvor""",
                    false,
                    "(reaktivní formace) - potlačil u sebe a chce potlačit i u někoho dalšího"
                ),
            ),
            questionNumber = 12,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Etologie studuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """postoje""",
                    false
                ),
                PsychologyTermAnswer(
                    """chování živočichů""",
                    false
                ),
                PsychologyTermAnswer(
                    """kriminální jednání""",
                    false
                ),
            ),
            questionNumber = 13,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Komplex méněcennosti je jedním ze stěžejních termínů""",
            textAnswer = "Podle Adlera je to drive, ale extrém.",
            answers = listOf(
                PsychologyTermAnswer(
                    """S.Freuda""",
                    false
                ),
                PsychologyTermAnswer(
                    """A.Adlera""",
                    false,
                    "Komplex méněcennosti, Neopsychoanalitika, styl žití naučen v 4-5 (drive). Individuální psychologie." +
                        "Pořadí narození:" +
                        "\n\t- Prvorozený - dostává všechnu pozornost do doby, kdy se narodí další - přišel o trůn. Benefituje z moci, je problémový. Snaží se dosáhnout co nejvíce, organizovaní." +
                        " Pokud selže v tom být nejlepší jsou si nejistí." +
                        "\n\t- Druhorozený - tolik mu nezáleží na rodičích, rodiče se tak nesnaží. Prvorození je pro něj model (může si připadat méněcenný a závidet), může být" +
                        " ctižádostivý a ambiciózní nebo úplný opak." +
                        "\n\t- Nejmladší - starší jako modely, velmi rychlý vývoj, buďto jsou hodně závislý na ostatních nebo chtějí dosahovat věcí."
                ),
                PsychologyTermAnswer(
                    """J.B.Watsona""",
                    false,
                    "Behaviorismus, \"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
            ),
            questionNumber = 14,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Knihu Charaktery (Povahopisy) napsal""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Theofrastos""",
                    false
                ),
                PsychologyTermAnswer(
                    """Platón""",
                    false
                ),
                PsychologyTermAnswer(
                    """Aristotelés""",
                    false,
                    "\n\t-5 smyslů, TABULA RASA (de anima)" +
                        "\n\t-filozofická škola Lekeion - procházka s žáky" +
                        "\n\t-dualismus (všechny organismy), de anima parva naturalia, de memoria"
                ),
            ),
            questionNumber = 15,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Pojem je výsledek""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """myšlení""",
                    false
                ),
                PsychologyTermAnswer(
                    """vnímání""",
                    false
                ),
                PsychologyTermAnswer(
                    """konání""",
                    false
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Démosthenés se stal proslulým řečníkem, ačkoli v mládí hovořil potichu, šlapal si na  jazyk a škubal ramenem.
                | Tento výsledek souvisí z následujících mechanismů nejvíce s""".trimMargin(),
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """regresí""",
                    false,
                    "Nevědomý obranný mechanizmus. Únik na vývojově nižší úroveň chování."
                ),
                PsychologyTermAnswer(
                    """kompenzací""",
                    false
                ),
                PsychologyTermAnswer(
                    """racionalizací""",
                    false,
                    "Obranný mechanizmus Freuda"
                ),
            ),
            questionNumber = 17,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Volní vlastnosti osobnosti řadíme mezi vlastnosti""",
            textAnswer = "Volní vlastnosti jsou charakteristiky lidské psychiky, spoluurčují průběh Volních procesů." +
                "\nVolní procesy souvisí s rozhodováním." +
                "\nFáze rozhodovací - zpracuju, uvědomím si informace z vnějška a vytvořím cíl - rozhodnutí." +
                "\nFáze realuzační - realizovace cíle/rozhodnutí.",
            answers = listOf(
                PsychologyTermAnswer(
                    """temperamentové""",
                    false
                ),
                PsychologyTermAnswer(
                    """charakterové""",
                    false
                ),
                PsychologyTermAnswer(
                    """emocionální""",
                    false
                ),
            ),
            questionNumber = 18,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Cirkadiánní rytmus je biorytmus, který se v průběhu""",
            textAnswer = "20-28 hodin",
            answers = listOf(
                PsychologyTermAnswer(
                    """spánku několikrát zopakuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """bdělého dne několikrát zopakuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """dne zopakuje právě jednou""",
                    false
                ),
            ),
            questionNumber = 19,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Vhled (insight) je termín, se kterým se setkáváme při studiu""",
            textAnswer = "Gestalt Psychologie. Wertheimer, Kohler\n" +
                "Spontánní pochopení problému v dané situaci - najednou má člověk nadhled.",
            answers = listOf(
                PsychologyTermAnswer(
                    """vnímání""",
                    false
                ),
                PsychologyTermAnswer(
                    """myšlení""",
                    false
                ),
                PsychologyTermAnswer(
                    """nevědomí""",
                    false
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Jako psychosomatické onemocnění označíme onemocnění""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """tělesné, které je důsledkem intrapsychického konfliktu""",
                    false
                ),
                PsychologyTermAnswer(
                    """tělesné, které způsobí změnu psychického stavu""",
                    false
                ),
                PsychologyTermAnswer(
                    """které pacient nemá, ačkoli je o tom přesvědčen""",
                    false
                ),
            ),
            questionNumber = 21,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Mezi labilní temperamenty nepatří""",
            textAnswer = "Sangivinik - krev - radost ze života" +
                "\nCholerik - žlutá žluč - labilní, výbušnost" +
                "\nMelancholik - černá žluc - labilní, emotivita, uzavřenost" +
                "\nFlegmatik - sliz, hlen - klid, lhostejnost",
            answers = listOf(
                PsychologyTermAnswer(
                    """flegmatik""",
                    false
                ),
                PsychologyTermAnswer(
                    """cholerik""",
                    false
                ),
                PsychologyTermAnswer(
                    """melancholik""",
                    false
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Kreativita znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """pohotovost""",
                    false
                ),
                PsychologyTermAnswer(
                    """zručnost""",
                    false
                ),
                PsychologyTermAnswer(
                    """tvořivost""",
                    false
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Z následujících stupňů oligofrenie (slaboduchosti) je nejzávažnějším postižením""",
            textAnswer = "Hranice je IQ 65-68." +
                "\nV závorce starší označení" +
                "\nLehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer(
                    """imbecilita""",
                    false,
                    "IQ 36-51"
                ),
                PsychologyTermAnswer(
                    """debilita""",
                    false,
                    "IQ 52-67"
                ),
                PsychologyTermAnswer(
                    """idiocie""",
                    false,
                    "prostá idiocie - IQ 20-35, těžká idiocie pod IQ 20"
                ),
            ),
            questionNumber = 24,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Mladá dívka se obléká jako její oblíbená, všeobecně nepříliš známá herečka.
                | Shání si o ní  materiály a ztotožňuje se s jejími názory. Jde tedy nejspíš o""".trimMargin(),
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """konformitu""",
                    false,
                    "Změna chování kvůli soc. tlaku"
                ),
                PsychologyTermAnswer(
                    """identifikaci""",
                    false
                ),
                PsychologyTermAnswer(
                    """projekci""",
                    false
                ),
            ),
            questionNumber = 25,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Empirismus zdůrazňuje jako zdroj poznatků""",
            textAnswer = "John Locke (1632-1704), George Barkley (1685-1753) - blank slate/tabula rasa, \"I Know, because I've experienced\"",
            answers = listOf(
                PsychologyTermAnswer(
                    """intuici""",
                    false
                ),
                PsychologyTermAnswer(
                    """zkušenost""",
                    false
                ),
                PsychologyTermAnswer(
                    """úvahu""",
                    false
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Takzvané období prvního vzdoru je doba kolem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """třetího roku""",
                    false,
                    "\"Ne\" je oblíbené slovo, ale občas zmiňováno ve 2. roce."
                ),
                PsychologyTermAnswer(
                    """šestého roku""",
                    false
                ),
                PsychologyTermAnswer(
                    """patnáctého roku""",
                    false
                ),
            ),
            questionNumber = 27,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Archetyp je termín""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """I.P.Pavlova""",
                    false,
                    "Orientačně-pátrací reflex - vrozený instinkt jako odezva na změnu okolního prostředí (hrozba, novost), zvýší se rychlost učení a vnímání." +
                        "\nSignální soustavy:" +
                        "\n\t1. Umělecká - společné pro zvířata a lidi, např. reflexy, dojmy, představy, pocity" +
                        "\n\t2. Myslitelská (věděcký) - spojené s lidským myšlením, abstraktní myšlení"
                ),
                PsychologyTermAnswer(
                    """C.G.Junga""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
                PsychologyTermAnswer(
                    """J.Watsona""",
                    false,
                    "Behaviorismus, \"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
            ),
            questionNumber = 28,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Seberealizace je charakteristický termín pro psychologii""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """kognitivní""",
                    false
                ),
                PsychologyTermAnswer(
                    """humanistickou""",
                    false,
                    "Maslow, Rogers. Zaměřeno na terapii. Nerozkládá člověka, však k němu přistupuje jako k celku."
                ),
                PsychologyTermAnswer(
                    """hlubinnou""",
                    false,
                    "Snaží se odhalit něco hluboko schovaného v nás. Nevědomí, id, superego apod. Freud, Jung, Adler"
                ),
            ),
            questionNumber = 29,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Vývoj lidské povahy""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """je ukončen před šestým rokem věku""",
                    false
                ),
                PsychologyTermAnswer(
                    """je ukončen dospělostí (kolem osmnácti let věku)""",
                    false
                ),
                PsychologyTermAnswer(
                    """probíhá po celý život""",
                    false
                ),
            ),
            questionNumber = 30,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Nejvíce informací přijímá zdravý člověk""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """sluchem""",
                    false
                ),
                PsychologyTermAnswer(
                    """zrakem""",
                    false,
                    "95% komunikace je neverbální, hlavně oči, ale kombinace všech."
                ),
                PsychologyTermAnswer(
                    """hmatem""",
                    false
                ),
            ),
            questionNumber = 31,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Atribuční teorie se zabývá tím, jak""",
            textAnswer = "Kognitivní proces přisuzování jedné či více příčin vlastnímu chování a chování jiných lidí." +
                "Dělí se na vnější a vnitřní.",
            answers = listOf(
                PsychologyTermAnswer(
                    """vzniká přátelství""",
                    false
                ),
                PsychologyTermAnswer(
                    """lidé vysvětlují své chování""",
                    false
                ),
                PsychologyTermAnswer(
                    """vznikají duševní nemoci""",
                    false
                ),
            ),
            questionNumber = 32,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Učení pokusem a omylem zkoumal""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Titchener""",
                    false,
                    "Strukturalismus - introspekce, Wundt, rozklad vědomí na elementy. Studoval pod Wundtem."
                ),
                PsychologyTermAnswer(
                    """Külpe""",
                    false,
                    "Würzburská škola, Kulpe, K.Buhler - experimentální laboratoř o myšlení. Kritický realismus - existence realit - věci na nás nezávislých"
                ),
                PsychologyTermAnswer(
                    """Thorndike""",
                    false,
                    "Behaviorismus, funkcionalismus - W. James, J. Dewey, psychické procesy, jak se psychika přizbůsobuje prostředí"
                ),
            ),
            questionNumber = 33,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Z následujících výzkumů bývá časově nejnáročnější výzkum""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """longitudinální (podélný)""",
                    false
                ),
                PsychologyTermAnswer(
                    """transverzální (příčný)""",
                    false,
                    "Srovnávání osob různého věku v jednom časovém bodě"
                ),
                PsychologyTermAnswer(
                    """mapující""",
                    false
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Klaustrofobie znamená strach z""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """neznámých lidí""",
                    false
                ),
                PsychologyTermAnswer(
                    """uzavřených prostorů""",
                    false
                ),
                PsychologyTermAnswer(
                    """výšek""",
                    false
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Gerontopsychologie se zabývá""",
            textAnswer = "psychologie stárnutí a stáří,též geropsychologie",
            answers = listOf(
                PsychologyTermAnswer(
                    """starými lidmi""",
                    false
                ),
                PsychologyTermAnswer(
                    """poruchami chování""",
                    false
                ),
                PsychologyTermAnswer(
                    """nadanými lidmi""",
                    false
                ),
            ),
            questionNumber = 36,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """To, že si přestaneme všímat zvuku, který nás původně vyrušoval, souvisí s""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """imprintingem""",
                    false,
                    "Forma učení, ve které dochází k fixaci k určitému objektu/informaci v citlivém stadiu jedince, či zvířete." +
                        "\n-Konrad Lorenz (1903-1989), hydraulický model agrese",
                ),
                PsychologyTermAnswer(
                    """pettingem""",
                    false
                ),
                PsychologyTermAnswer(
                    """habituací""",
                    false,
                    "(přivykání) – na základě zkušenosti se sníží reakce a jedinec posléze přestane reagovat na podněty, které nepředstavují nebezpečí"
                ),
            ),
            questionNumber = 37,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Člověk trpící zoofobií by měl pravděpodobně nejmenší problémy při účasti na""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """asociačních experimentech C.G.Junga""",
                    false,
                    "Jung četl seznam slov nahlas a čekal na asociace, které slova evokovaly v recipientovi.\n" +
                        "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
                PsychologyTermAnswer(
                    """imprinting prokazujících experimentech K.Lorenze""",
                    false,
                    "Forma učení, ve které dochází k fixaci k určitému objektu/informaci v citlivém stadiu jedince, či zvířete." +
                        "\n-Konrad Lorenz (1903-1989), hydraulický model agrese",
                ),
                PsychologyTermAnswer(
                    """experimentech s klasickým podmiňováním I.P.Pavlova""",
                    false
                ),
            ),
            questionNumber = 38,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Na vrcholu Maslowovy „pyramidy potřeb“ je""",
            textAnswer = "1. základní tělesné, fyziologické potřeby\n" +
                "2. bezpečí, jistoty\n" +
                "3. lásky, přijetí, sounáležitosti\n" +
                "4. uznání, úcty\n" +
                "5. seberealizace",
            answers = listOf(
                PsychologyTermAnswer(
                    """uznání""",
                    false
                ),
                PsychologyTermAnswer(
                    """seberealizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """láska""",
                    false
                ),
            ),
            questionNumber = 39,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Podle Eriksona řeší adolescenti psychosociální krizi typu""",
            textAnswer = "Vývoj osobnosi, psychosociální teorie. Každý stádium má krizi, kterou musíme vyřešit abychom mohli pokračovat." +
                "\nDůvěra x nedůvěra (do roku)" +
                "\nAutonomie x stud (2-3 let) - podobné anal stádiu u Fredu - je dítě učeno být samostatné?" +
                "\nIniciativa x vina (3-5 let) - jak moc nechají rodiče dítě růst" +
                "\nSnaživost x méněcennost (6-12 let)" +
                "\nIdentita x nejistota (12-16)" +
                "\nIntimita x izolace (18-35)" +
                "\nReprodukce x stagnace (35-55)" +
                "\nIntegrita x stagnace (55+)",
            answers = listOf(
                PsychologyTermAnswer(
                    """iniciativa versus pocity viny""",
                    false
                ),
                PsychologyTermAnswer(
                    """identita versus zmatek""",
                    false
                ),
                PsychologyTermAnswer(
                    """píle versus pocity méněcennosti""",
                    false
                ),
            ),
            questionNumber = 40,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Empatie znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """poruchu emocí""",
                    false
                ),
                PsychologyTermAnswer(
                    """vcítění""",
                    false
                ),
                PsychologyTermAnswer(
                    """apatie""",
                    false,
                    "naprostá pasivita, zeslabení zájmů a reakcí vůči vjemům"
                ),
            ),
            questionNumber = 41,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Významný skupinový psychoterapeut, autor odborných knih i románů o psychoterapii, je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Yalom""",
                    false
                ),
                PsychologyTermAnswer(
                    """Shalom""",
                    false
                ),
                PsychologyTermAnswer(
                    """Molaiy""",
                    false
                ),
            ),
            questionNumber = 42,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Somnambulismus je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Nespavost""",
                    false,
                    "insomnie"
                ),
                PsychologyTermAnswer(
                    """únavový syndrom""",
                    false
                ),
                PsychologyTermAnswer(
                    """náměsíčnictví""",
                    false
                ),
            ),
            questionNumber = 43,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Forenzní psychologie se uplatňuje především""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """u soudů""",
                    false
                ),
                PsychologyTermAnswer(
                    """v reklamě""",
                    false
                ),
                PsychologyTermAnswer(
                    """na neurologických klinikách""",
                    false
                ),
            ),
            questionNumber = 44,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Mezi významné psychology nepatří:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer(
                    """Kohlberg""",
                    false,
                    "Stádie morálního vývoje" +
                        "\n1.Předkonvenční morálka" +
                        "\n\t-trest, odměna" +
                        "\n2.Konvenční morálka" +
                        "\n\t-chce být hodný kluk/hodná holka, autorita - zákony, pravidla" +
                        "\n3.Postkonvenční (autonomní, hyperkonvenční, principiální 25%) morálka" +
                        "\n\t-společenská smlouva, balance mezi univerzálními a osobními etickými principy"
                ),
                PsychologyTermAnswer(
                    """Arnaud""",
                    false
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Touha po uspokojení pozitivních a snaha vyhnout se negativnímu je mravní hodnota výrazná pro etiku""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """pragmatickou""",
                    false,
                    "Nebo také pragmatická lingvistika (z řeckého pragma - skutek)." +
                        " Řeč není jen sémantická, informativní, ale je pod tím i něco více, nějak záměr."
                ),
                PsychologyTermAnswer(
                    """existenciální""",
                    false,
                    "Důraz na existenci a svobodu. Teorie \"já\" - člověk je proces, nikoliv hotový výtvor."
                ),
                PsychologyTermAnswer(
                    """hédonistickou""",
                    false,
                    "Hédonismus (z řec. hédoné, potěšení, slast)." +
                        "\nAccording to the hedonic principle, our emotional experience can be thought of as a gauge that ranges from bad to good and our primary" +
                        " motivation is to keep the needle on the gauge as close to good as possible."
                ),
            ),
            questionNumber = 46,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Déjà vu je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """pocit již viděného""",
                    false
                ),
                PsychologyTermAnswer(
                    """vtíravá myšlenka""",
                    false
                ),
                PsychologyTermAnswer(
                    """malý epileptický záchvat""",
                    false
                ),
            ),
            questionNumber = 47,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Oidipovský (Oidipský) komplex spadá do období""",
            textAnswer =  "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací.",
            answers = listOf(
                PsychologyTermAnswer(
                    """orálního""",
                    false
                ),
                PsychologyTermAnswer(
                    """análního""",
                    false
                ),
                PsychologyTermAnswer(
                    """falického""",
                    false
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Pokud dostanete v rámci psychologického vyšetření za úkol seřadit barvy od nejoblíbenější k nejméně oblíbené, jde nejspíš o""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """projektivní test""",
                    false
                ),
                PsychologyTermAnswer(
                    """dotazník""",
                    false
                ),
                PsychologyTermAnswer(
                    """test výkonnosti""",
                    false
                ),
            ),
            questionNumber = 49,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Metoda sebepozorování se nazývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """introverze""",
                    false
                ),
                PsychologyTermAnswer(
                    """introspekce""",
                    false
                ),
                PsychologyTermAnswer(
                    """interocepce""",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Kurt Lewin se zabýval""",
            textAnswer = "Gestalt Psychologie\n" +
                "Teorie pole - chování = osobnost + prostředí." +
                "\n typy vedení: autokracie (agrese, rebelie), demokracie (stabilni, prumerne), bez vedení (bez agrese, bez cíle, bez spolupráce)" +
                "\n\nKonflikty motivů:" +
                "\n\t- Apetence x apetence - obě stejně přitažlivé motivy, není stabilní a vydrží jen chvíli" +
                "\n\t- Averze x apetence - přitažlivý motiv s negativním aspektem" +
                "\n\t- Averze x averze - výběr mezi dvěma negativními motivy, výběr menšího zla, tendence nevybrat ani jeden",
            answers = listOf(
                PsychologyTermAnswer(
                    """zoopsychologií""",
                    false
                ),
                PsychologyTermAnswer(
                    """hlubinnou psychologií""",
                    false,
                    "Snaží se odhalit něco hluboko schovaného v nás. Nevědomí, id, superego apod. Freud, Jung, Adler"
                ),
                PsychologyTermAnswer(
                    """skupinovou dynamikou""",
                    false,
                    "Procesy, které mají vliv na skupinové dění."
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Opakem inhibice je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """excitace""",
                    false
                ),
                PsychologyTermAnswer(
                    """exhausce""",
                    false
                ),
                PsychologyTermAnswer(
                    """exhibice""",
                    false
                ),
            ),
            questionNumber = 52,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Aktivní složkou marihuany je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """fencyklidin""",
                    false
                ),
                PsychologyTermAnswer(
                    """diethylamid kyseliny lysergové""",
                    false
                ),
                PsychologyTermAnswer(
                    """tetrahydrokanabinol""",
                    false
                ),
            ),
            questionNumber = 53,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Kognitivní psychologové se v prvé řadě věnují""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """emocím""",
                    false
                ),
                PsychologyTermAnswer(
                    """chování""",
                    false
                ),
                PsychologyTermAnswer(
                    """myšlení""",
                    false
                ),
            ),
            questionNumber = 54,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Pojem ambidexter (ambidextrie) se používá v souvislosti s""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """únavou""",
                    false
                ),
                PsychologyTermAnswer(
                    """nevyhraněnou lateralitou""",
                    false,
                    "Tedy někdo, kdo je schopen používat obě ruce stejně dobře."
                ),
                PsychologyTermAnswer(
                    """vnitřní motivací""",
                    false
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Solomon Asch je známý studiem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """konfliktu""",
                    false
                ),
                PsychologyTermAnswer(
                    """konformity""",
                    false,
                    "Změna chování kvůli soc. tlaku"
                ),
                PsychologyTermAnswer(
                    """sociální role""",
                    false
                ),
            ),
            questionNumber = 56,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Afekt je""",
            textAnswer = "intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření",
            answers = listOf(
                PsychologyTermAnswer(
                    """déletrvající citový stav""",
                    false
                ),
                PsychologyTermAnswer(
                    """nálada""",
                    false,
                    "Déletrvající pohotovost k emočním reakcím určitého směru"
                ),
                PsychologyTermAnswer(
                    """intenzívní citová reakce""",
                    false
                ),
            ),
            questionNumber = 57,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Persona a Stín jsou""",
            textAnswer = "Persona - zachování individualismu" +
                "\nAnimus a anima - pomáhá a chápat svojí pohlaví, ukazuje se jako opačné pohlaví" +
                "\nStín - zvířecí, tendence primitivním formám života",
            answers = listOf(
                PsychologyTermAnswer(
                    """archetypy""",
                    false,
                    "Jung"
                ),
                PsychologyTermAnswer(
                    """paradigmata""",
                    false,
                    "Paradigma (z řec. parádeigma = vzor, příklad, model) je obecně přijímané schéma, vzorec myšlení či model." +
                        "\nParadigma vědy se myslí určitý vzorec, který vyjadřuje podstatu jevů, jež daná věda zkoumá"
                ),
                PsychologyTermAnswer(
                    """motivy""",
                    false,
                    "Uvědomělé podněty vyvolávající uspokojení potřeb."
                ),
            ),
            questionNumber = 58,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Jean Piaget se zabýval především""",
            textAnswer = "Senzomotorická inteligence (0-2 roky):" +
                "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                " Strange situation study - attachment styly." +
                "\n\nPředoperační (symbolické, předpojmové) stadium (3-6 let):" +
                "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                "\n\nStadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                "\n\nStadium formálních operací (12+)" +
                "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení",
            answers = listOf(
                PsychologyTermAnswer(
                    """vývojem lidského myšlení""",
                    false
                ),
                PsychologyTermAnswer(
                    """duševními chorobami""",
                    false
                ),
                PsychologyTermAnswer(
                    """partnerskými vztahy""",
                    false
                ),
            ),
            questionNumber = 59,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Chování poddaných ve známé Andersenově pohádce Císařovy nové šaty bychom mohli nejsnáze vysvětlit""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """amnézií""",
                    false
                ),
                PsychologyTermAnswer(
                    """habituací""",
                    false,
                    "(přivykání) – na základě zkušenosti se sníží reakce a jedinec posléze přestane reagovat na podněty, které nepředstavují nebezpečí"
                ),
                PsychologyTermAnswer(
                    """konformitou""",
                    false,
                    "Změna chování kvůli soc. tlaku"
                ),
            ),
            questionNumber = 60,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Tzv. Gaussova křivka znázorňuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """normální rozložení""",
                    false
                ),
                PsychologyTermAnswer(
                    """rychlost zapomínání""",
                    false
                ),
                PsychologyTermAnswer(
                    """vztah mezi motivací a výkonem""",
                    false
                ),
            ),
            questionNumber = 61,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Polygraf je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """člověk se specifickou poruchou učení""",
                    false
                ),
                PsychologyTermAnswer(
                    """přístroj zaznamenávající tělesné reakce doprovázející psychické děje""",
                    false
                ),
                PsychologyTermAnswer(
                    """přístroj, za který byla udělena Nobelova cena""",
                    false
                ),
            ),
            questionNumber = 62,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Involuce je""",
            textAnswer = "fyziologická atrofie (degenerace) orgánu",
            answers = listOf(
                PsychologyTermAnswer(
                    """růst""",
                    false
                ),
                PsychologyTermAnswer(
                    """stárnutí""",
                    false
                ),
                PsychologyTermAnswer(
                    """přizpůsobování""",
                    false
                ),
            ),
            questionNumber = 63,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Tvrzení „Ženy jsou špatné řidičky“ je příkladem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """kognitivní disonance""",
                    false
                ),
                PsychologyTermAnswer(
                    """sebenaplňujícího se proroctví""",
                    false
                ),
                PsychologyTermAnswer(
                    """stereotypu""",
                    false
                ),
            ),
            questionNumber = 64,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Slavná Beethovenova Měsíční sonáta je považována za hudební vyjádření neopětované lásky k Giuliettě Guicciardi.
                | Pokud tomu tak bylo, tak byste uvažoval(a) o psychickém mechanismu""".trimMargin(),
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """sublimace""",
                    false
                ),
                PsychologyTermAnswer(
                    """suprese""",
                    false
                ),
                PsychologyTermAnswer(
                    """dedikace""",
                    false
                ),
            ),
            questionNumber = 65,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Fenomén „figury a pozadí“ je studován""",
            textAnswer = "Vychází z předpokladu, že lidské vnímání neprobíhá pasivně. Je naopak aktivním procesem, který umožňuje vnímání smysluplných celků.",
            answers = listOf(
                PsychologyTermAnswer(
                    """gestaltisty""",
                    false,
                    "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                        "\nNěkteré věci, které řešili:" +
                        "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                        "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                        "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                        "\nZákon podobnosti - tendence vnímat podobné podněty jako celky."
                ),
                PsychologyTermAnswer(
                    """sexuology""",
                    false
                ),
                PsychologyTermAnswer(
                    """psychoimunology""",
                    false
                ),
            ),
            questionNumber = 66,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Pokud bychom Kretschmerovu konstituční typologii použili i na psy, odpovídal by pyknikovi""",
            textAnswer = "E. Kretschmer se snažil se spojit fyziologickou postavu jedince k patologii." +
                "\nAstenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            answers = listOf(
                PsychologyTermAnswer(
                    """vlčák""",
                    false
                ),
                PsychologyTermAnswer(
                    """chrt""",
                    false
                ),
                PsychologyTermAnswer(
                    """bernardýn""",
                    false
                ),
            ),
            questionNumber = 67,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Brainstorming je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """metoda tvůrčího uvažování""",
                    false
                ),
                PsychologyTermAnswer(
                    """patologický záznam na EEG""",
                    false
                ),
                PsychologyTermAnswer(
                    """nátlakové působení na jedince""",
                    false
                ),
            ),
            questionNumber = 68,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Srovnávací psychologové srovnávají jednotlivé""",
            textAnswer = "(Komparativní psychologie) Něco jako etologie psychologie. Tedy zkoumá hlavně chování zvířat (organismů) mimo lidi." +
                "\nObčas se však definuje jako věda porovnávající zvířata s lidmi.",
            answers = listOf(
                PsychologyTermAnswer(
                    """lidi""",
                    false
                ),
                PsychologyTermAnswer(
                    """psychologické školy""",
                    false
                ),
                PsychologyTermAnswer(
                    """živočišné druhy""",
                    false
                ),
            ),
            questionNumber = 69,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Inteligenční kvocient se dříve počítal tak, že se""",
            textAnswer = "W. Stern",
            answers = listOf(
                PsychologyTermAnswer(
                    """skutečný věk dělil mentálním""",
                    false
                ),
                PsychologyTermAnswer(
                    """skutečný věk dělil mentálním a násobil stem""",
                    false
                ),
                PsychologyTermAnswer(
                    """mentální věk dělil skutečným a násobil stem""",
                    false
                ),
            ),
            questionNumber = 70,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Objevitelem stresové reakce je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Pavlov""",
                    false,
                    "Orientačně-pátrací reflex - vrozený instinkt jako odezva na změnu okolního prostředí (hrozba, novost), zvýší se rychlost učení a vnímání." +
                        "\nSignální soustavy:" +
                        "\n\t1. Umělecká - společné pro zvířata a lidi, např. reflexy, dojmy, představy, pocity" +
                        "\n\t2. Myslitelská (věděcký) - spojené s lidským myšlením, abstraktní myšlení"
                ),
                PsychologyTermAnswer(
                    """Selye""",
                    false
                ),
                PsychologyTermAnswer(
                    """Wundt""",
                    false,
                    "První laboratoř (1879), Strukturalismus psychologie jako věda, Introspekce (looking inward)"
                ),
            ),
            questionNumber = 71,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """To, že je výkonnost u řady činností lepší v něčí společnosti než o samotě, je dáno""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """sociální facilitací""",
                    false,
                    "Vliv přítomnosti jiných lidí na chování člověka. Touto problematikou se zabýval pravděpodobně první experiment v sociální psychologie (1898)," +
                        " který uskutečnil Norman Triplett. Pozoroval jevy v cyklisty a jejich zrychlení, když jely v skupinách."
                ),
                PsychologyTermAnswer(
                    """konformitou""",
                    false,
                    "Změna chování kvůli soc. tlaku"
                ),
                PsychologyTermAnswer(
                    """sociální polarizací""",
                    false
                ),
            ),
            questionNumber = 72,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Z následujících psychologických škol je nejstarší""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """transpersonální psychologie""",
                    false,
                    "Psych. směr zabývající se transpersonálními, transcendentními nebo spirituálními aspekty lidské zkušenosti. A. Maslow." +
                        "\n70. léta 20. století."
                ),
                PsychologyTermAnswer(
                    """psychoanalýza""",
                    false,
                    "S. Freud (1856-1939)"
                ),
                PsychologyTermAnswer(
                    """asocianistická psychologie""",
                    false,
                    "Vznik ještě ve filozofii 18-19 století. J.F. Herbart, Locke a Ebbinghaus. \"Nic není ve vědomí, co dříve nebylo ve smyslech.\""
                ),
            ),
            questionNumber = 73,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """E. Berne je duchovním otcem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """transakční analýzy""",
                    false,
                    "E. Berne" +
                        "\nMezilidská komunikace. Inspiruje se v psychoanalýze: tři roviny osobnosti:" +
                        "\nDítě - vzpomínky z dětství a naše dětskost (hravost, bezmocnost, spontaneita, hravost,...)." +
                        "\nRodič - vzpomínky toho, co jsme jako děti slyšeli od rodičů a naše rodičovskost (autorita, poučování, dohled,...)." +
                        "\nDospělý - rozumě založené informace, vlastní názory." +
                        "\nPoté analyzujeme  konverzaci jako Dospělý - Dítě bez ohledu na věku."
                ),
                PsychologyTermAnswer(
                    """faktorové analýzy""",
                    false,
                    "(Factor analysis) - statická metoda. Když máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny," +
                        " které už nám to predikují a analyzují lépe."
                ),
                PsychologyTermAnswer(
                    """pojmové analýzy""",
                    false
                ),
            ),
            questionNumber = 74,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Vidění „bílých myšek“ nejpravděpodobněji nastane při""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """pseudologia phantastica""",
                    false,
                    "Bájivá či chorobná lhavost. Daný lže pro pozornost."
                ),
                PsychologyTermAnswer(
                    """deliriu tremens""",
                    false,
                    "Nebo také alkoholové delirium, náhlý abstinenční syndrom."
                ),
                PsychologyTermAnswer(
                    """epilepsii""",
                    false,
                    "Mohou mít halucinace."
                ),
            ),
            questionNumber = 75,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Aplikujeme-li znalost křivky zapomínání na své učení, dojdeme k názoru, že je důležité""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """nepouštět se do nové látky, dokud neumíme výborně látku starou""",
                    false
                ),
                PsychologyTermAnswer(
                    """učit se pouze v okamžicích, kdy nejméně zapomínáme""",
                    false
                ),
                PsychologyTermAnswer(
                    """v krátkých intervalech za novou látkou zařazovat opakování""",
                    false
                ),
            ),
            questionNumber = 76,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = "Jana byla na psychologických testech. " +
                "Vypráví o tom, že si prohlížela nějaké obrázky připomínající skvrny a měla říkat, čemu se to podobá. " +
                "Jana dělala pravděpodobně",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """tematický apercepční test""",
                    false,
                    "Projektivní test osobnosti (verbální), nejdominantnější hned po Rorschahovu testu." +
                        "\n32 černobílých obrázků s nejednoznačnými situacemi."
                ),
                PsychologyTermAnswer(
                    """Rorschachův test""",
                    false,
                    "Projektivní test osobnosti (verbální). 10 víceméně symetrických pestrých/nepestrých skvrn."
                ),
                PsychologyTermAnswer(
                    """Lüscherův test""",
                    false,
                    "Projektivní test osobnosti (manipulační). Výběr mezi barvami - každý má jinou preferenci, která je podvědomě vedena."
                ),
            ),
            questionNumber = 77,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Rodič dává dítěti za každou dobrou známku odměnu v podobě oblíbené laskominy. Jeho  přístup k motivování má nejblíže k přístupu""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """humanistickému""",
                    false,
                    "Maslow, Rogers. Zaměřeno na terapii. Nerozkládá člověka, však k němu přistupuje jako k celku."
                ),
                PsychologyTermAnswer(
                    """behavioristickému""",
                    false
                ),
                PsychologyTermAnswer(
                    """kognitivnímu""",
                    false,
                    "Analyzuje psychické procesy jedince."
                ),
            ),
            questionNumber = 78,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Nebezpečí haló-efektu spočívá v""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """nepřítomnosti informací o neverbálních projevech člověka""",
                    false
                ),
                PsychologyTermAnswer(
                    """ve zkreslení vnímání způsobeném dominantní charakteristikou""",
                    false
                ),
                PsychologyTermAnswer(
                    """ve stresovém působení nezvyklých situací""",
                    false
                ),
            ),
            questionNumber = 79,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Která z následujících podmínek je důležitá, má-li být experiment eticky přijatelný""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """informovaný souhlas zúčastněných""",
                    false
                ),
                PsychologyTermAnswer(
                    """náhodné rozřazení do jednotlivých experimentálních skupin""",
                    false
                ),
                PsychologyTermAnswer(
                    """experiment nesmí být spojen s žádnou činností""",
                    false
                ),
            ),
            questionNumber = 80,
            correctAnswer = 0,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Nejhůře se odnaučuje to chování, které bylo""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """posilováno odměnou pokaždé, když se vyskytlo""",
                    false
                ),
                PsychologyTermAnswer(
                    """posilováno odměnou pokaždé, když se nevyskytlo""",
                    false
                ),
                PsychologyTermAnswer(
                    """posilováno odměnou jen občas, když se vyskytlo""",
                    false
                ),
            ),
            questionNumber = 81,
            correctAnswer = 2,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
        PsychologyTerm(
            prompt = """Pokud by frustrace vedla vždy k agresivnímu jednání, je jisté, že""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """kdo není frustrován, nemůže být agresivní""",
                    false
                ),
                PsychologyTermAnswer(
                    """kdo není agresivní, nemohl být frustrován""",
                    false
                ),
                PsychologyTermAnswer(
                    """frustrováni mohou být pouze ti, co byli již dříve agresivní""",
                    false
                ),
            ),
            questionNumber = 82,
            correctAnswer = 1,
            categoryId = "Nezávislý test - FF UK PŘÍKLADY OTÁZEK TESTU Z PSYCHOLOGIE"
        ),
    )
}