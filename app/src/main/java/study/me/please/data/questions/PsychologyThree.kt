package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//zrevidovano
object PsychologyThree {
    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Topologická psychologie je spojena""",
            textAnswer = "Topologie znamená rozdělení. Topologické pojmy - síla, vzdálenost nebo směr - matematické, nikoli statické.",
            answers = listOf(
                PsychologyTermAnswer("""se jménem K. Lewina""",
                    false,
                    "Gestalt Psychologie\n" +
                        "Teorie pole - chování = osobnost + prostředí." +
                        "\n typy vedení: autokracie (agrese, rebelie), demokracie (stabilni, prumerne), bez vedení (bez agrese, bez cíle, bez spolupráce)" +
                        "\n\nKonflikty motivů:" +
                        "\n\t- Apetence x apetence - obě stejně přitažlivé motivy, není stabilní a vydrží jen chvíli" +
                        "\n\t- Averze x apetence - přitažlivý motiv s negativním aspektem" +
                        "\n\t- Averze x averze - výběr mezi dvěma negativními motivy, výběr menšího zla, tendence nevybrat ani jeden"
                ),
                PsychologyTermAnswer("""s analýzou osobnostních rysů""",
                    false
                ),
                PsychologyTermAnswer(
                    """s rozdělením psyché na vědomí, nevědomí a předvědomí""",
                    false,
                    "Freud"
                ),
                PsychologyTermAnswer(
                    """s nástupem statistických metod do psychologie osobnosti""",
                    false
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Reaktologie""",
            textAnswer = "SSSR, zakládaly na principech přírodovědeckého materialismu." +
                "\nReflexologie - veškeré chování, jednání a myšlení jsou pouze reflexy, zvané objektivní psychologie." +
                "\nReaktologie - Zkoumání subjektivní lidské reakce na podněty. Reflex fyziologický, reakce má však i myšlenkový obsah. Sociální působení.",
            answers = listOf(
                PsychologyTermAnswer("""byla založena na behaviorismu""",
                    false
                ),
                PsychologyTermAnswer("""navazovala na reflexologii""",
                    false
                ),
                PsychologyTermAnswer("""analyzovala operantní podmiňování""",
                    false
                ),
                PsychologyTermAnswer("""byla předchůdcem reflexologie""",
                    false
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = "S. Freud byl ovlivněn prací s hysterickými pacienty, které se věnoval",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""B. Bolzano""", false,
                    "(1781-1848), pražský německý filosof," +
                        "\n-inspirace pro Franze Brentano" +
                        "\n-myšlení nelze redukovat na výsledky psychických procesů nebo logických postupů"
                ),
                PsychologyTermAnswer("""I. P. Pavlov""",
                    false,
                    "Orientačně-pátrací reflex - vrozený instinkt jako odezva na změnu okolního prostředí (hrozba, novost), zvýší se rychlost učení a vnímání." +
                        "\nSignální soustavy:" +
                        "\n\t1. Umělecká - společné pro zvířata a lidi, např. reflexy, dojmy, představy, pocity" +
                        "\n\t2. Myslitelská (věděcký) - spojené s lidským myšlením, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""T. de Chardin""",
                    false,
                    "Evoluce Vesmíru"
                ),
                PsychologyTermAnswer("""J. Charcot""",
                    false,
                    "Neurolog, Hypnóza a hysterie (pacientka Augustine), roztroušená skleróza."
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Autorem/autory koherenční teorie myšlení je/ jsou""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""G. E. Müller""",
                    false,
                    "Vitalismus - zdroj života zvířatům dává vitalitu, tudíž se nedá studovat (něco jako důvod žít)." +
                        "\nSpecifická nervová energie - podněty vytvářejí energii, která je zpracována vždy konkrétním nervem" +
                        "\nExperimental psychology (Leipzig). Color phenomena (retina -> 4 barvy), paměť."
                ),
                PsychologyTermAnswer(
                    """gestaltisté""",
                    false,
                    "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                        "\nNěkteré věci, které řešili:" +
                        "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                        "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                        "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                        "\nZákon podobnosti - tendence vnímat podobné podněty jako celky."
                ),
                PsychologyTermAnswer("""Thomas a Znaniecky""",
                    false,
                    "Thomas - humanistická sociologie, pozitivismus, Chicagská škola. Společně napsali Polský sedlák v Evropě a Americe." +
                        "\nSociální psychologie - nauka o postojích"
                ),
                PsychologyTermAnswer("""G. W. Allport""",
                    false,
                    "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\nFukční autonomie - že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku" +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                ),
            ),
            questionNumber = 4,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """V antické osobnostní typologii je sangvinik spojován""",
            textAnswer = "Sangivinik - krev - radost ze života" +
                "\nCholerik - žlutá žluč - labilní, výbušnost" +
                "\nMelancholik - černá žluc - labilní, emotivita, uzavřenost" +
                "\nFlegmatik - sliz, hlen - klid, lhostejnost",
            answers = listOf(
                PsychologyTermAnswer("""s převahou vzduchu""",
                    false
                ),
                PsychologyTermAnswer("""s vyrovnanými tělesnými šťávami""",
                    false
                ),
                PsychologyTermAnswer("""s převahou krve""",
                    false
                ),
                PsychologyTermAnswer("""s převahou žluči""",
                    false
                ),
            ),
            questionNumber = 5,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených badatelů je představitelem kognitivní psychologie?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""K. Lewin""",
                    false,
                    "Gestalt Psychologie\n" +
                        "Teorie pole - chování = osobnost + prostředí." +
                        "\n typy vedení: autokracie (agrese, rebelie), demokracie (stabilni, prumerne), bez vedení (bez agrese, bez cíle, bez spolupráce)" +
                        "\n\nKonflikty motivů:" +
                        "\n\t- Apetence x apetence - obě stejně přitažlivé motivy, není stabilní a vydrží jen chvíli" +
                        "\n\t- Averze x apetence - přitažlivý motiv s negativním aspektem" +
                        "\n\t- Averze x averze - výběr mezi dvěma negativními motivy, výběr menšího zla, tendence nevybrat ani jeden"
                ),
                PsychologyTermAnswer("""L. Klages""",
                    false,
                    "Grafologie - osobnost ze stylu psaní, Charakterologická psychologie - studie osobností, vývoje a rozdíl mezi nimi."
                ),
                PsychologyTermAnswer("""V. Frankl""",
                    false,
                    "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                        "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                        "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě"
                ),
                PsychologyTermAnswer("""žádný""",
                    false
                ),
            ),
            questionNumber = 6,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Sociální psychologii jako nauku o postojích definovali""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""W. I. Thomas a F. Znaniecky""",
                    false
                ),
                PsychologyTermAnswer("""H. J. Eysenck a G. W. Allport""",
                    false,
                    "Alport:" +
                        "\nMotivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\nFukční autonomie - že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku" +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                ),
                PsychologyTermAnswer("""W. Köhler a K. Koffka""",
                    false,
                    "Kohler - Zkoumal u primátů a popsal jejich řešení problému \"jak dostat nedostupný banán\" - vhled - heureka moment. Gestalisté"
                ),
                PsychologyTermAnswer("""W. McDougall a W. James""",
                    false,
                    "W. James: Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
            ),
            questionNumber = 7,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Z uvedených badatelů se kognitivní psychologií nezabýval""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""J. Fodor""",
                    false,
                    "Mentální reprezentace - vztah mezi přesvědčeními a touhy"
                ),
                PsychologyTermAnswer("""U. Neisser""",
                    false,
                    "Paměť, inteligence, percepce, \"Otec kognitivní psychologie\""
                ),
                PsychologyTermAnswer("""G. W. Allport""",
                    false,
                    "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\nFukční autonomie - že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku" +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                ),
                PsychologyTermAnswer("""Z. Pylyshyn""",
                    false,
                    "Kognitivní systémy za percepcí, představami a uvažování." +
                        "\nTeorie vizuálního indexování (FINST teorie) - sledujeme (trackujeme) několik různých objektů ve vnímání a jejich trajekce."
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Stadii morálního vývoje člověka se zabýval""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. Erikson""",
                    false,
                    "Vývoj osobnosi, psychosociální teorie. Každý stádium má krizi, kterou musíme vyřešit abychom mohli pokračovat." +
                        "\nDůvěra x nedůvěra (do roku)" +
                        "\nAutonomie x stud (2-3 let) - podobné anal stádiu u Fredu - je dítě učeno být samostatné?" +
                        "\nIniciativa x vina (3-5 let) - jak moc nechají rodiče dítě růst" +
                        "\nSnaživost x méněcennost (6-12 let)" +
                        "\nIdentita x nejistota (12-16)" +
                        "\nIntimita x izolace (18-35)" +
                        "\nReprodukce x stagnace (35-55)" +
                        "\nIntegrita x stagnace (55+)"
                ),
                PsychologyTermAnswer("""L. Kohlberg""",
                    false,
                    "Stádie morálního vývoje" +
                        "\n1.Předkonvenční morálka" +
                        "\n\t-trest, odměna" +
                        "\n2.Konvenční morálka" +
                        "\n\t-chce být hodný kluk/hodná holka, autorita - zákony, pravidla" +
                        "\n3.Postkonvenční (autonomní, hyperkonvenční, principiální 25%) morálka" +
                        "\n\t-společenská smlouva, balance mezi univerzálními a osobními etickými principy"
                ),
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                        "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                        "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                        "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                        "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací."
                ),
                PsychologyTermAnswer(
                    """C. G. Jung""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Která z uvedených charakteristik je společná pro behaviorismus a kognitivní psychologii?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""experimentální přístup""",
                    false
                ),
                PsychologyTermAnswer("""důraz na pozorovatelné chování""",
                    false
                ),
                PsychologyTermAnswer("""mentalismus""",
                    false,
                    "Hypnóza/sugesce nebo může také znamenat: Fyzický svět neexistuje a mysl je jediné co opravdu existuje."
                ),
                PsychologyTermAnswer("""kulturní relativismus""",
                    false,
                    "Teoreticko-metodolický přístup. Výchází z faktu, že každá kultura je unikátní."
                ),
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Psychonalytickým přístupem k objektovým vztahům se zabýval""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. Fromm""",
                    false,
                    "Neufreudián. Charakter je získaná složka osobnosti. Svoboda x Bezpečí (moc svobody=méně bezpečí a vise versa)." +
                        "\nVzdálení se od přírody: ve středověku (feduální systém) měl každý jasnou roli" +
                        " a měl tudíž i stabilitu. Renesancí se však vše změnilo a snážíme se stále hledat význam života." +
                        "\n3 způsoby jak utíkáme od svobody:" +
                        "\n\t1. Autoritářské tendence - snaha ovládnutí druhých (masochismus, sadismus - ovládání druhých)" +
                        "\n\t2. Destrukce - patriot, odpor k neznámým věcím a lidem"+
                        "\n\t3. Automaton - robot" +
                        "\n\nAsimilace (osvojování věcí) a socializace - způsob vývoje ve společnosti." +
                        "\n\tPoruchy asimilace: " +
                        "\n\t\treceptivní orientace - očekávání dostávat věci"+
                        "\n\t\tvykořisťovatelská orientace - vzít si co chtít"+
                        "\n\t\ttržní orientace - soutěživost, porovnávání se"+
                        "\n\t\thromadivá orientace"+
                        "\n\t\tnekrofilní - démonické, goth"+
                        "\n\t\tmarketing - předstírá, chce aby ho všichni měli rádi"
                ),
                PsychologyTermAnswer("""H. Kohut""",
                    false,
                    "Psychoanalýza (selfpsychologie), Narcismus - již nebral jako psychózu, ale jako porochu osobnosti." +
                        "\nNarcistický (selfobjektivní) přenos:" +
                        "\n\tZrcadlící přenos - analytik vnímán jako vyživující"+
                        "\n\tIdealizující přenos - analytik vnímán jako ideál"+
                        "\n\tBlíženecký přenos - analytik vnímán jako alter ego, jemu podobný"
                ),
                PsychologyTermAnswer("""A. Adler""",
                    false,
                    "Komplex méněcennosti, Neopsychoanalitika, styl žití naučen v 4-5 (drive). Individuální psychologie." +
                        "Pořadí narození:" +
                        "\n\t- Prvorozený - dostává všechnu pozornost do doby, kdy se narodí další - přišel o trůn. Benefituje z moci, je problémový. Snaží se dosáhnout co nejvíce, organizovaní." +
                        " Pokud selže v tom být nejlepší jsou si nejistí." +
                        "\n\t- Druhorozený - tolik mu nezáleží na rodičích, rodiče se tak nesnaží. Prvorození je pro něj model (může si připadat méněcenný a závidet), může být" +
                        " ctižádostivý a ambiciózní nebo úplný opak." +
                        "\n\t- Nejmladší - starší jako modely, velmi rychlý vývoj, buďto jsou hodně závislý na ostatních nebo chtějí dosahovat věcí."
                ),
                PsychologyTermAnswer("""V. E. Frankl""",
                    false,
                    "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                        "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                        "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě"
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Introspektivní analýza vjemů na počitky je postup typický pro""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""experimentální psychologii""",
                    false
                ),
                PsychologyTermAnswer(
                    """behaviorismus""",
                    false,
                    "(S-R psychologie, S=stimul, R=reakce) – zakladatel Watson, věda o chování, vliv měli " +
                        "Pavlov a Bechtěrev"
                ),
                PsychologyTermAnswer("""strukturalismus""",
                    false,
                    "Wundt (DE) a Titchener (USA). Introspekce (looking inward)." +
                        " Mysl je složena ze smyslů, pocitů a obrázků. Dobová alternativa byla Funkcionalismus (evolucionální důvod za chováním, ne o \"paměti\", ale učení)."
                ),
                PsychologyTermAnswer(
                    """gestaltismus""",
                    false,
                    "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                        "\nNěkteré věci, které řešili:" +
                        "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                        "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                        "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                        "\nZákon podobnosti - tendence vnímat podobné podněty jako celky."
                ),
            ),
            questionNumber = 12,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Kdo z uvedených měl zásadní význam pro humanizaci péče o duševně nemocné?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Pinel""",
                    false,
                    "Před psychiatrií. Klasifikace mentálních nemocí. Např. Dementia praecox (schizofrenie, autor E. Kraepelin)"
                ),
                PsychologyTermAnswer("""Komenský""",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                ),
                PsychologyTermAnswer("""Charcot""",
                    false,
                    "Neurolog, Hypnóza a hysterie (pacientka Augustine), roztroušená skleróza."
                ),
                PsychologyTermAnswer("""Wagner-Jauregg""",
                    false,
                    "První psychiatr co vyhrál nobelovku za léčení Generické parézy (demence, ze sifilis)" +
                        " malarijní terapií - navození malárie (pyroterapie) a tudíž vysoké teploty, která má léčit.\nSterilizace jako léčba (schizofrenie)."
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených psychologů se zabýval introspektivní analýzou počitků?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""I. P. Pavlov""",
                    false,
                    "Orientačně-pátrací reflex - vrozený instinkt jako odezva na změnu okolního prostředí (hrozba, novost), zvýší se rychlost učení a vnímání." +
                        "\nSignální soustavy:" +
                        "\n\t1. Umělecká - společné pro zvířata a lidi, např. reflexy, dojmy, představy, pocity" +
                        "\n\t2. Myslitelská (věděcký) - spojené s lidským myšlením, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""O. Külpe""",
                    false,
                    "Würzburská škola, Kulpe, K.Buhler - experimentální laboratoř o myšlení. Kritický realismus - existence realit - věci na nás nezávislých"
                ),
                PsychologyTermAnswer("""W. James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer("""E. B. Titchener""",
                    false,
                    "Strukturalismus - introspekce, Wundt, rozklad vědomí na elementy. Studoval pod Wundtem."
                ),
            ),
            questionNumber = 14,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = "Jedním z prvních, kteří se zabývali psychotechnikou, byl",
            textAnswer = "Otec psychotechniky - nástroj pro psychologický výběr pracovníků (vojáků) na pozice.",
            answers = listOf(
                PsychologyTermAnswer("""N. Parkinson""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""B. Hawthorn""",
                    false,
                    "Hawtornský efekt - efektivnější pracovníci když byli sledováni"
                ),
                PsychologyTermAnswer("""J. Kronenberg""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""H. Münsterberg (1863-1955)""",
                    false,
                    "Klinická, experimentální, pracovní psychologie, zastánce behaviorismu. Bádenská, novokantovská škola." +
                        "\nOtec psychotechniky - nástroj pro psychologický výběr pracovníků (vojáků) na pozice."
                ),
            ),
            questionNumber = 15,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín komplex méněcennosti začal používat""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""A. Adler""",
                    false,
                    "Komplex méněcennosti, Neopsychoanalitika, styl žití naučen v 4-5 (drive). Individuální psychologie." +
                        "Pořadí narození:" +
                        "\n\t- Prvorozený - dostává všechnu pozornost do doby, kdy se narodí další - přišel o trůn. Benefituje z moci, je problémový. Snaží se dosáhnout co nejvíce, organizovaní." +
                        " Pokud selže v tom být nejlepší jsou si nejistí." +
                        "\n\t- Druhorozený - tolik mu nezáleží na rodičích, rodiče se tak nesnaží. Prvorození je pro něj model (může si připadat méněcenný a závidet), může být" +
                        " ctižádostivý a ambiciózní nebo úplný opak." +
                        "\n\t- Nejmladší - starší jako modely, velmi rychlý vývoj, buďto jsou hodně závislý na ostatních nebo chtějí dosahovat věcí."
                ),
                PsychologyTermAnswer("""P. Janet""",
                    false,
                    "Hysterie, hypnóza, trauma, paměť, disociace. Žák Charcota." +
                        "\nPrvní používal termín \"podvědomí\"(\"podvědomá utkvělá představa\") a obviňoval Freuda za plagiátorství."
                ),
                PsychologyTermAnswer("""L. Withmer""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer(
                    """C. G. Jung""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Důležitým pojmem v psychologii L. S. Vygotského (1896-1934) je""",
            textAnswer = "Kognitivní vývoj, sociokulturní teorie učení - vlivy při učení a vývoji, \"Sami sebou se stáváme skrze druhé\", " +
                "problematika učení handicapovaných dětí." +
                "\nKulturní kapitál - předané bohatsví" +
                "\nKulturní nástroje - počítač, telefon, kolo - jazyk je esenciální" +
                "\nMediace - dospělí pomáhají vnímat svět" +
                "\nApropriace - učení jak používat nástrje, řeč apod." +
                "\nInternalizace - zakomponování do osobní psyché" +
                "\nLešení (scaffolding) - znalosti se musí pokládat na sebe (nemůže začít od vrchu tudíž)" +
                "\nZóna proximálního vývoje - soubor věcí co dítě umí, co dítě umí udělat s pomocí, a věcí které není schopno dělat.",
            answers = listOf(
                PsychologyTermAnswer("""extroverze""",
                    false
                ),
                PsychologyTermAnswer("""egocentrismus""",
                    false
                ),
                PsychologyTermAnswer("""reflex""",
                    false
                ),
                PsychologyTermAnswer("""interiorizace""",
                    false,
                    "Zakomponování nové znalosti do osobní psyché"
                ),
            ),
            questionNumber = 17,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """J. Bowlby se zabýval vztahem dítěte a matky a je autorem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """psychoanalytického odůvodnění poruch osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """objevu oční interakce dítěte a matky při kojení""",
                    false
                ),
                PsychologyTermAnswer("""termínku anaklitická deprese""",
                    false
                ),
                PsychologyTermAnswer("""teorie vazby""",
                    false
                ),
            ),
            questionNumber = 18,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Vztahem dědičnosti a mimořádných duševních schopností se v minulém století zabýval""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""F. Galton (1822-1911)""",
                    false,
                    "Sociální Darwinismus, eugenika - pokus šlechtit lidský gen, vytvořil koncept \"korelace\""
                ),
                PsychologyTermAnswer("""Ch. Darwin (1809-1882)""",
                    false
                ),
                PsychologyTermAnswer("""C. Lomboroso (1835-1909)""",
                    false,
                    "Vycházel z frenologie (korelace mezi fyzio. znaky lebky a duševními schopnostmi - antropologie (Řeč. Antropos=člověk)) a rozšířil to na kriminalistiku."
                ),
                PsychologyTermAnswer("""C. Burt""",
                    false,
                    "Pedagogický psycholog, měření IQ, dědění IQ (které zfalšoval)."
                ),
            ),
            questionNumber = 19,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """J. L. Moreno zavedl do psychoterapie""",
            textAnswer = "Psychodrama, sociální psycholog, Teorie Setkávání - sociometrie, zmapování vztahů mezi jedinci např. ve škole podle tříd.",
            answers = listOf(
                PsychologyTermAnswer("""psychogymnastiku""",
                    false,
                    "(psychopantomima) Česká psychoterapie - pantomima, Knohlochovi"
                ),
                PsychologyTermAnswer("""psychodrama""",
                    false
                ),
                PsychologyTermAnswer("""psychosomatické postupy""",
                    false
                ),
                PsychologyTermAnswer("""balintovské skupiny""",
                    false,
                    "Skupinová metoda řešení problémů, používá se například v supervizi a výcviku psychoterapeutů."
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """K historickým pokusům o lokalizaci duševních funkcí patří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""strukturalismus""",
                    false,
                    "Wundt (DE) a Titchener (USA). Introspekce (looking inward)." +
                        " Mysl je složena ze smyslů, pocitů a obrázků. Dobová alternativa byla Funkcionalismus (evolucionální důvod za chováním, ne o \"paměti\", ale učení)."
                ),
                PsychologyTermAnswer("""cytoarchitektonika""",
                    false,
                    "(Studium mikroskopické stavby každé korové oblasti mozkové kůry)"
                ),
                PsychologyTermAnswer("""frenologie""",
                    false,
                    "BS obor. Snaha vytvoření souvislostí mezi tvarem lebky a duševními schopnostmi a charakterovými rysy."
                ),
                PsychologyTermAnswer("""antropometrie""",
                    false,
                    "Řeč. Antropos=člověk, metrie  měření"
                ),
            ),
            questionNumber = 21,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Podle I. P. Pavlova patří řeč a myšlení""",
            textAnswer = "Orientačně-pátrací reflex - vrozený instinkt jako odezva na změnu okolního prostředí (hrozba, novost), zvýší se rychlost učení a vnímání." +
                "\nSignální soustavy:" +
                "\n\t1. Umělecká - společné pro zvířata a lidi, např. reflexy, dojmy, představy, pocity" +
                "\n\t2. Myslitelská (věděcký) - spojené s lidským myšlením, abstraktní myšlení",
            answers = listOf(
                PsychologyTermAnswer("""ke druhé signální soustavě""",
                    false
                ),
                PsychologyTermAnswer("""k první signální soustavě""",
                    false
                ),
                PsychologyTermAnswer("""do systému nepodmíněných reflexů""",
                    false
                ),
                PsychologyTermAnswer("""k soustavě sociálního podmiňování""",
                    false
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """C. Lomboroso se zabýval""",
            textAnswer = "Vycházel z frenologie",
            answers = listOf(
                PsychologyTermAnswer(
                    """psychodiagnostikou v policejní psychologii""",
                    false
                ),
                PsychologyTermAnswer(
                    """sociálním a kulturním podhoubím zločinnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """hledáním antropologických rozdílů mezi zločinci a normálními lidmi""",
                    false,
                    "Řeč. Antropos=člověk"
                ),
                PsychologyTermAnswer(
                    """vztahem ústavní výchovy a kriminality mladistvých""",
                    false
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """K představitelům neopsychoanalýzy nepatří""",
            textAnswer = "(neoFreudismus)",
            answers = listOf(
                PsychologyTermAnswer("""H. S. Sullivan (1892-1949)""",
                    false,
                    "Společně s K. Horney představitel neopsychoanalýzy (neoFreudismus) a vztahu dítěte a matky" +
                        "\nTenze = a) Nedostatečná fyz. satisfakce od matky b) Úzkost, z úzkostné matky" +
                        "\nOsobnost je výsledek interpersonálních vztahů," +
                        "\nDynamismus - vzorec transformace energie"
                ),
                PsychologyTermAnswer("""V. Frankl""",
                    false,
                    "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                        "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                        "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě"
                ),
                PsychologyTermAnswer("""E. Fromm""",
                    false,
                    "Neufreudián. Charakter je získaná složka osobnosti. Svoboda x Bezpečí (moc svobody=méně bezpečí a vise versa)." +
                        "\nVzdálení se od přírody: ve středověku (feduální systém) měl každý jasnou roli" +
                        " a měl tudíž i stabilitu. Renesancí se však vše změnilo a snážíme se stále hledat význam života." +
                        "\n3 způsoby jak utíkáme od svobody:" +
                        "\n\t1. Autoritářské tendence - snaha ovládnutí druhých (masochismus, sadismus - ovládání druhých)" +
                        "\n\t2. Destrukce - patriot, odpor k neznámým věcím a lidem"+
                        "\n\t3. Automaton - robot" +
                        "\n\nAsimilace (osvojování věcí) a socializace - způsob vývoje ve společnosti." +
                        "\n\tPoruchy asimilace: " +
                        "\n\t\treceptivní orientace - očekávání dostávat věci"+
                        "\n\t\tvykořisťovatelská orientace - vzít si co chtít"+
                        "\n\t\ttržní orientace - soutěživost, porovnávání se"+
                        "\n\t\thromadivá orientace"+
                        "\n\t\tnekrofilní - démonické, goth"+
                        "\n\t\tmarketing - předstírá, chce aby ho všichni měli rádi"
                ),
                PsychologyTermAnswer("""K. Horneyová""",
                    false,
                    "Základní (bazální) úzkost - neurotičtí rodiči vytvářejí nejistost v dítěti, rozporné chování okolí" +
                        "\nPotřeby bezpečí dětí - fyz. i mentální, zvládnou vše pokud mají dobrý základ" +
                        "\nNeurotické potřeby dospělých - nenásledují sliby, nefér chování" +
                        "\n\tReprese hostility dítěte -> Bezmocnost, Intimidace (strach z trestů), nedostatek potřeby bezpečí -> Základní úzkost." +
                        "\nNeurotické postoje:" +
                        "\n\t1. Pohyb směrem k lidem - konformita"+
                        "\n\t2. Pohyb směrem proti lidem - antisocial"+
                        "\n\t3. Pohyb směrem od lidí - asiocal"
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """K představitelům funkcionalismu patří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""J. Dewey""",
                    false,
                    "Funkcionalismus. Školství/učení by mělo pracovat s psychologií, kritika S-R modelu, S má vliv na R a R má vliv na S."
                ),
                PsychologyTermAnswer("""E. Brunswik""",
                    false,
                    "(Probalistický) Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nEkologická validita = využitelnost výsledků v praxi"
                ),
                PsychologyTermAnswer(
                    """v psychologii funkcionalistický směr nefiguroval.""",
                    false
                ),
                PsychologyTermAnswer(
                    """J. B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """W. Wundt založil první psychologickou laboratoř""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v Berlíně""",
                    false
                ),
                PsychologyTermAnswer("""v Lipsku""",
                    false
                ),
                PsychologyTermAnswer("""v Jeně""",
                    false
                ),
                PsychologyTermAnswer(
                    """ve Würzburgu""",
                    false,
                    "Würzburská škola, Kulpe (asistent Wundta), K.Buhler - experimentální laboratoř o myšlení. Kritický realismus - existence realit - věci na nás nezávislých"
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """První psychologická laboratoř byla založena v roce""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""1902""",
                    false
                ),
                PsychologyTermAnswer(
                    """1879""",
                    false,
                    """Wundt, Lipsko"""
                ),
                PsychologyTermAnswer("""1789""",
                    false
                ),
                PsychologyTermAnswer("""1869""",
                    false
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """První inteligenční testy sestrojil""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""A. Binet a T. Simon""",
                    false
                ),
                PsychologyTermAnswer("""Ch. Spearman (1863-1945)""",
                    false,
                    "Faktorová analýza (Factor analysis, inteligenční faktor g) - statická metoda. " +
                        "\nKdyž máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny, které už nám to predikují a analyzují lépe." +
                        "\nSpearmenova koeficient pořadové korelace - statistická závisost mezi 2 veličinami (korelace)" +
                        "\nVýzkům a zastánce dědičnosti IQ (eugenetika)"
                ),
                PsychologyTermAnswer("""J. Parsons a A. Bandura""",
                    false
                ),
                PsychologyTermAnswer("""B. Pearson""",
                    false,
                    "Politik co zorganizoval pohotovostní jednotky OSN"
                ),
            ),
            questionNumber = 28,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """První experimentální výzkumy paměti prováděl""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. Mach""",
                    false,
                    "Machovy proužky - optická iluze, gradient barev působí jako jako kontinuum, nikoliv oddělená barvy." +
                        "\nLogický pozitivismus (logical empirismus) - empirismus, pragmatismus."
                ),
                PsychologyTermAnswer("""W. Dilthey""",
                    false,
                    "Spor s Ebbinghausem. Filozof - filozofie života, jev života - nelze redukovat na mechanismy"
                ),
                PsychologyTermAnswer("""B. Bolzano""",
                    false,
                    "(1781-1848), pražský německý filosof," +
                        "\n-inspirace pro Franze Brentano" +
                        "\n-myšlení nelze redukovat na výsledky psychických procesů nebo logických postupů"
                ),
                PsychologyTermAnswer("""H. Ebbinghaus""",
                    false,
                    "Experimentální studie paměti, křivka zapomínání, monografie paměti. Asocianismus - \"Nic není ve vědomí, co dříve nebylo ve smyslech.\"" +
                        "\nSpacing effect - učení s prostory mezi je více efektivní." +
                        "\nSerial-position effect (efekt primárnosti a novosti) - Pozice pamatovných věcí hraje roli na to, jaké si pamatujeme."
                ),
            ),
            questionNumber = 29,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = "Pojem \"tabula rasa\" je spojen především se jménem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Aristotela""",
                    false,
                    "\n\t-5 smyslů, TABULA RASA (de anima)" +
                        "\n\t-filozofická škola Lekeion - procházka s žáky" +
                        "\n\t-dualismus (všechny organismy), de anima parva naturalia, de memoria"
                ),
                PsychologyTermAnswer("""J. Deweye""",
                    false,
                    "Funkcionalismus.\nŠkolství/učení by mělo pracovat s psychologií, kritika S-R modelu, S má vliv na R a R vliv na S."
                ),
                PsychologyTermAnswer("""T. Akvinského""",
                    false,
                    "1255-1274. Tabula rasa" +
                        "SUMMA CONTRA GENTILES - suma proti pohanům" +
                        "\nSUMMA THEOLOGIAE - teologická suma"
                ),
                PsychologyTermAnswer("""J. Locka (1632-1704)""",
                    false,
                    "Teorie poznání. Empirismus - blank slate/tabula rasa, \"I Know, because I've experienced\"" +
                        "\nDualismus - jediná interakce mezi mozkem a tělem je introspekce"
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených termínů je nejtypičtější pro Freudovu psychoanalýzu?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""libido""",
                    false
                ),
                PsychologyTermAnswer("""archetyp""",
                    false,
                    "Jung"
                ),
                PsychologyTermAnswer("""ego-obrany""",
                    false,
                    "dcera Freuda"
                ),
                PsychologyTermAnswer("""komplex méněcennosti""",
                    false,
                    "Adler"
                ),
            ),
            questionNumber = 31,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Autorem známé typologie hodnotových orientací je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""L. Klages""",
                    false,
                    "Grafologie - osobnost ze stylu psaní, Charakterologická psychologie - studie osobností, vývoje a rozdíl mezi nimi."
                ),
                PsychologyTermAnswer("""T. Leary""",
                    false,
                    "Zastánce psychodelických drog. Concord Prison experiment - vězni vycházející z vězení, návratnost z 60% na 20%"
                ),
                PsychologyTermAnswer("""J. Dollard (1900-1980)""",
                    false,
                    "Teorie (hypotéza) frustrace-agrese (taky N. E. Miller). Subjektivní behavioristi. S (pudová potřeba) + signál -> R -> zpevnění."
                ),
                PsychologyTermAnswer("""E. Spranger (1882-1963)""",
                    false,
                    "Sprangerova typologie:" +
                        "\n\t1. Ekonomický typ - praktický, ze zkušenost hlavně hmotný přínos" +
                        "\n\t2. Náboženský typ - duchovní hodnoty, zkušenosti" +
                        "\n\t3. Teoretický typ - hledání pravdy, poznání (filozof)" +
                        "\n\t4. Estetický typ - vychutnávání si života" +
                        "\n\t5. Politický typ - moc, dominance" +
                        "\n\t6. Sociální typ - láska k druhým, sebeovládání"
                ),
            ),
            questionNumber = 32,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených termínů je nejtypičtější pro analytickou psychologii C. G. Junga?""",
            textAnswer = "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar.",
            answers = listOf(
                PsychologyTermAnswer("""dítě""",
                    false
                ),
                PsychologyTermAnswer(
                    """anima""",
                    false,
                    "Nevědomý ženský protějšek mužské vědomé psýchy. Animus v případě ženské psýchy."
                ),
                PsychologyTermAnswer("""maska""",
                    false
                ),
                PsychologyTermAnswer("""ego-obrany""",
                    false,
                    "Freud a jeho dcera"
                ),
            ),
            questionNumber = 33,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = "\"Proud vědomí\" je důležitým pojmem v díle",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""W. Jamese""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer("""J. Piageta""",
                    false,
                    "Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\nPředoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\nStadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\nStadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer(
                    """J. B. Watsona""",
                    false,
                    "Behaviorismus, \"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer(
                    """C. G. Junga""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Za zakladatele neobehaviorismu se považuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """J. Watson""",
                    false,
                    "Behaviorismus, \"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""E. C. Tolman""",
                    false,
                    "Neobehaviorismus, Molární a Molekulární chování" +
                        "\nInspirace z Gestaltu, S-O-R (S-Organism-R), kognitivní a emociální vliv." +
                        "\nKognitivní mapa - Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí."
                ),
                PsychologyTermAnswer("""W. McDougall""",
                    false,
                    "Instinkt, sociální psychologie, Parapsychologie - paranormální." +
                        "\nHormic psychologie (řeč. hormé=impuls) opozice behaviorismu." +
                        "\nAnimismus (Lamarkismus) - vlivy prostředí mění geny a ty jsou následně děděny."
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Koncept kolektivního nevědomí pochází od""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. Sprangera""",
                    false,
                    "Sprangerova typologie:" +
                        "\n\t1. Ekonomický typ - praktický, ze zkušenost hlavně hmotný přínos" +
                        "\n\t2. Náboženský typ - duchovní hodnoty, zkušenosti" +
                        "\n\t3. Teoretický typ - hledání pravdy, poznání (filozof)" +
                        "\n\t4. Estetický typ - vychutnávání si života" +
                        "\n\t5. Politický typ - moc, dominance" +
                        "\n\t6. Sociální typ - láska k druhým, sebeovládání"
                ),
                PsychologyTermAnswer("""S. Grofa""",
                    false,
                    "ČR původ, transpersonální psychologie - Např. Maslow - transcedentní/spirituální aspekty lidské zkušenosti, holotropní dýchání (\"drogy, zcelující stav\")."
                ),
                PsychologyTermAnswer("""A. Adlera""",
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
                    """C. G. Junga""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """E. C. Tolman modifikoval schéma S-R a zavedl schematické vyjádření""",
            textAnswer = "Neobejaviorismus, Molární a Molekulární chování" +
                "\nInspirace z Gestaltu, S-O-R (S-Organism-R), kognitivní a emociální vliv." +
                "\nKognitivní mapa - Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí.",
            answers = listOf(
                PsychologyTermAnswer("""S-O-R""",
                    false,
                    "Stimuli - Organism - Response - kognitivní a emociální vliv"
                ),
                PsychologyTermAnswer("""delta Ixxx/ I = konst.""",
                    false
                ),
                PsychologyTermAnswer("""SUR""",
                    false
                ),
                PsychologyTermAnswer("""TOTE""",
                    false
                ),
            ),
            questionNumber = 37,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Freudův Výklad snů vyšel poprvé v roce""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""1895""",
                    false
                ),
                PsychologyTermAnswer("""1925""",
                    false
                ),
                PsychologyTermAnswer("""1900""",
                    false
                ),
                PsychologyTermAnswer("""1915""",
                    false
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Dementia praecox bylo původní označení pro""",
            textAnswer = "E. Kraepelin (P. Pinel)",
            answers = listOf(
                PsychologyTermAnswer("""časnou stařeckou demenci""",
                    false
                ),
                PsychologyTermAnswer("""mentální retardaci""",
                    false
                ),
                PsychologyTermAnswer("""Huntingtonovu chorobu""",
                    false
                ),
                PsychologyTermAnswer("""schizofrenii""",
                    false
                ),
            ),
            questionNumber = 39,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín paradoxní intence zavedl/a""",
            textAnswer = "Postavení se strachu jako řešení - intencionální létání letadlem pokud se bojím - dělání opaku.",
            answers = listOf(
                PsychologyTermAnswer("""V. Frankl""",
                    false,
                    "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                        "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                        "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě"
                ),
                PsychologyTermAnswer("""yaleská sociálněpsychologická škola""",
                    false
                ),
                PsychologyTermAnswer("""V. Satirová""",
                    false,
                    "\"Matka rodinné terapie\""
                ),
                PsychologyTermAnswer("""komunikativní psychoterapeutická škola""",
                    false
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín schizofrenie zavedl""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. Kraepelin (1856-1926)""",
                    false,
                    "Zakladatel moderní psychiatrie, zavedl \"Dementia praecox\"(Schizofrenie) a manio-deprese"
                ),
                PsychologyTermAnswer("""R. Cajal (1852-1934)""",
                    false,
                    "Nobelovka za strukturu Nervového Systému"
                ),
                PsychologyTermAnswer("""E. Bleuler (1857-1939)""",
                    false,
                    "Zavedl\"Schizofrenie\" a \"autismus\", detailní zkoumání duševních chorob."
                ),
                PsychologyTermAnswer(
                    """C. G. Jung""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 41,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Tzv. třetí vídeňská psychoterapeutická škola je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""komunikativní psychoterapie""",
                    false
                ),
                PsychologyTermAnswer("""logoterapie""",
                    false
                ),
                PsychologyTermAnswer("""individuální psychologie""",
                    false
                ),
                PsychologyTermAnswer("""systemická terapie""",
                    false,
                    "Holistický pohled na problém - když řešíme problém dítěte, pozveme si celou rodinu."
                ),
            ),
            questionNumber = 42,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """R. Spitz zavedl termín""",
            textAnswer = "Vývoj dítěte, úzkost 8. měsíce - anaklitická deprese - ztráta opory - začne se bát cizích lidí, pojem resilientní děti." +
                "\nCenestická percepce (vnímání přes tělesné vlivy), distální percepce (náznak odlišení sebe)" +
                "\nVýv. stádia: preobjektální, předběžného objektu, objektivních stavů",
            answers = listOf(
                PsychologyTermAnswer("""anaklitická deprese""",
                    false
                ),
                PsychologyTermAnswer("""dementia praecox""",
                    false,
                    "E. Kraepelin, P. Pinel, znamená to Schizofrenie"
                ),
                PsychologyTermAnswer("""stereotypní chování""",
                    false
                ),
                PsychologyTermAnswer("""hospitální mánie""",
                    false
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Hlavní zásluhou P. Pinela byla""",
            textAnswer = "Před psychiatrií. Klasifikace mentálních nemocí. Např. Dementia praecox (schizofrenie, autor E. Kraepelin)",
            answers = listOf(
                PsychologyTermAnswer("""vymezení deprese""",
                    false
                ),
                PsychologyTermAnswer("""humanizace přístupu k duševně chorým""",
                    false
                ),
                PsychologyTermAnswer("""zavedení farmakoterapie v psychiatrii""",
                    false
                ),
                PsychologyTermAnswer("""analýza abnormálního vědomí""",
                    false
                ),
            ),
            questionNumber = 44,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Alfred Adler je autorem termínu""",
            textAnswer = "Komplex méněcennosti, Neopsychoanalitika, styl žití naučen v 4-5 (drive). Individuální psychologie." +
                "Pořadí narození:" +
                "\n\t- Prvorozený - dostává všechnu pozornost do doby, kdy se narodí další - přišel o trůn. Benefituje z moci, je problémový. Snaží se dosáhnout co nejvíce, organizovaní." +
                " Pokud selže v tom být nejlepší jsou si nejistí." +
                "\n\t- Druhorozený - tolik mu nezáleží na rodičích, rodiče se tak nesnaží. Prvorození je pro něj model (může si připadat méněcenný a závidet), může být" +
                " ctižádostivý a ambiciózní nebo úplný opak." +
                "\n\t- Nejmladší - starší jako modely, velmi rychlý vývoj, buďto jsou hodně závislý na ostatních nebo chtějí dosahovat věcí.",
            answers = listOf(
                PsychologyTermAnswer("""obranné mechanismy ega""",
                    false,
                    "Freud a jeho dcera"
                ),
                PsychologyTermAnswer("""Elektřin komplex""",
                    false,
                    "Freud"
                ),
                PsychologyTermAnswer("""komplex méněcennosti""",
                    false
                ),
                PsychologyTermAnswer("""determinující tendence""",
                    false,
                    "Připravenost mysli řešit úkoly a konat, snaha jednat, duševní nastavení"
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Metodu sémantického diferenciálu zavedl/a""",
            textAnswer = "Škála mezi 2 slovy s opačným významem. Např. Myslím si, že jsem: Hodný 1-2-3-4-5 Zlý.",
            answers = listOf(
                PsychologyTermAnswer("""Joy Paul Guilford""",
                    false,
                    "Třírozměrný strukturní model inteligence (120 schopností):" +
                        "\n\t1.Operace - způsoby myšlení, např. srovnávání, třídění, rozhodování" +
                        "\n\t2.Obsah - konkrétní ifnroamce a znalosti (paměť)" +
                        "\n\t3.Produkt - aplikace Obsahu a Operace na řešení problémů" +
                        "\n\nStudium IQ, rozlišení konvergentní (testy na správnou odpověď) a divergentní (kreativní, variabilní) - v testech a myšlení"
                ),
                PsychologyTermAnswer("""Charles Egerton Osgood""",
                    false,
                    "Postoje, sémantika, výzkum veřejného mínění."
                ),
                PsychologyTermAnswer("""Hugo Münsterberg (1863-1955)""",
                    false,
                    "Klinická, experimentální, pracovní psychologie, zastánce behaviorismu. Bádenská, novokantovská škola." +
                        "\nOtec psychotechniky - nástroj pro psychologický výběr pracovníků (vojáků) na pozice."
                ),
                PsychologyTermAnswer("""Melanie Kleinová""",
                    false,
                    "Psychoanalitička, projekce, závist, dětská psychologie a jejich vývoj, teorie Objektivních vztahů - důležitost mezilidských vztahů (hlavně v rodině)."
                ),
            ),
            questionNumber = 46,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Symbolický interakcionismus je spojen se jménem""",
            textAnswer = "Interakce jedinců a jejich interpretace.",
            answers = listOf(
                PsychologyTermAnswer("""Ch. S. Pierce""",
                    false
                ),
                PsychologyTermAnswer("""D. Freemana""",
                    false
                ),
                PsychologyTermAnswer("""K. Horneyové""",
                    false,
                    "Základní úzkost - neurotičtí rodiči vytvářejí nejistost v dítěti, rozporné chování okolí" +
                        "\nPotřeby bezpečí dětí - fyz. i mentální, zvládnou vše pokud mají dobrý základ" +
                        "\nNeurotické potřeby dospělých - nenásledují sliby, nefér chování" +
                        "\n\tReprese hostility dítěte -> Bezmocnost, Intimidace (strach z trestů), nedostatek potřeby bezpečí -> Základní úzkost." +
                        "\nNeurotické postoje:" +
                        "\n\t1. Pohyb směrem k lidem - konformita"+
                        "\n\t2. Pohyb směrem proti lidem - antisocial"+
                        "\n\t3. Pohyb směrem od lidí - asiocal"
                ),
                PsychologyTermAnswer(
                    """G. H. Meada""",
                    false,
                    "Sociální psychologie (sociální behaviorismus), reprezentace společnoste v mysli jedince - zobecněný druhý (generalized other) - Interakce je zprostředkována interpretacemi a významy mezi jedinci., Symbolický Interakcionismus - interakce jedinců a jejich interpretace."
                ),
            ),
            questionNumber = 47,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Kurt Lewin je autorem""",
            textAnswer = "Gestalt Psychologie\n" +
                "Teorie pole - chování = osobnost + prostředí." +
                "\n typy vedení: autokracie (agrese, rebelie), demokracie (stabilni, prumerne), bez vedení (bez agrese, bez cíle, bez spolupráce)" +
                "\n\nKonflikty motivů:" +
                "\n\t- Apetence x apetence - obě stejně přitažlivé motivy, není stabilní a vydrží jen chvíli" +
                "\n\t- Averze x apetence - přitažlivý motiv s negativním aspektem" +
                "\n\t- Averze x averze - výběr mezi dvěma negativními motivy, výběr menšího zla, tendence nevybrat ani jeden",
            answers = listOf(
                PsychologyTermAnswer("""teorie kauzálních atribuci""",
                    false,
                    "F. Heider. Kognitivní proces přisuzování jedné či více příčin vlastnímu chování a chování jiných lidí." +
                        " Dělí se na vnější a vnitřní. Také od Heidera: Teorie rovnováhy - změna názoru"
                ),
                PsychologyTermAnswer("""teorie prototypů""",
                    false,
                    "E. Roschová. Věci okolo nás různě kategorizujeme a u každé kategorie máme určitý prototyp," +
                        " který by takovou skupinu mohl dobře reprezentovat - prototyp."
                ),
                PsychologyTermAnswer("""teorie pole""",
                    false,
                    "chování = osobnost + prostředí"
                ),
                PsychologyTermAnswer("""teorie determinující tendence""",
                    false,
                    "Připravenost mysli řešit úkoly a konat, snaha jednat, duševní nastavení"
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Pojem extraverze poprvé zavedl""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""W. Stern""",
                    false,
                    "Inteligenční kvocient (IQ - ment.věk děleno chronologický), založil Diferenciální psychologii (jako psychologie osobnosti - rozdíli mezi lidmi)"
                ),
                PsychologyTermAnswer("""H. J. Eysenck""",
                    false,
                    "Studoval inteligenci a osobnosti." +
                        "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                        "\nDělení osobnosti:" +
                        "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                        "\n\tExtraverze (vzrušivost mozkové kůry)" +
                        "\n\tNeuroticismus (stabilita - labilita)."
                ),
                PsychologyTermAnswer(
                    """C. G. Jung""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
                PsychologyTermAnswer("""M. Eysenck""",
                    false,
                    "Syn H. Eyesencka" +
                        "\nKognitivní faktory úzkosti"
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Neomentalismus se v psychologii objevil s""",
            textAnswer = "Mentalismus - percepce, proces myšlení je reálný, neomentalismus více gestalt",
            answers = listOf(
                PsychologyTermAnswer("""psychoanalýzou""",
                    false
                ),
                PsychologyTermAnswer("""kognitivní psychologií""",
                    false
                ),
                PsychologyTermAnswer("""behaviorismem""",
                    false
                ),
                PsychologyTermAnswer("""ekologickou psychologií""",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z těchto psychologů nepatří k ostatním?""",
            textAnswer = "Gestalt psychologie",
            answers = listOf(
                PsychologyTermAnswer("""K. Kofka""",
                    false,
                    "Kritizoval Wundta, napsal \"Perception: intro to gestalt psychology\""
                ),
                PsychologyTermAnswer("""W. Köhler""",
                    false,
                    "Zkoumal u primátů a popsal jejich řešení problému \"jak dostat nedostupný banán\" - vhled - heureka moment. Gestalisté"
                ),
                PsychologyTermAnswer("""W. Wundt""",
                    false,
                    "První laboratoř (1879), Strukturalismus psychologie jako věda, Introspekce (looking inward)"
                ),
                PsychologyTermAnswer("""M. Wertheimer""",
                    false,
                    "Praha, reproduktivní (repetice, podmiňování) vs. produktivní (nové myšlenky) přemýšlení"
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín vhled zavedl/a do psychologie myšlení""",
            textAnswer = "Gestalt Psychologie. Wertheimer, Kohler\n" +
                "Spontánní pochopení problému v dané situaci - najednou má člověk nadhled.",
            answers = listOf(
                PsychologyTermAnswer(
                    """Melanie Kleinová""",
                    false,
                    "Psychoanalitička, projekce, závist, dětská psychologie a jejich vývoj." +
                        "\nTeorie Objektivních vztahů - důležitost mezilidských vztahů (hlavně v rodině)."
                ),
                PsychologyTermAnswer(
                    """J. J. Gibson""",
                    false,
                    "Porti Gestaltu, Ekologická teorie vnímání - informace pro přesné vnímání jsou již součástí podnětu." +
                        "\nNapř. Gradient (spád) struktury - přejíždíme-li zrakem po určité scenérii – dochází ke změnám vnímané členitosti povrchu,...."
                ),
                PsychologyTermAnswer(
                    """Margaret Meadová""",
                    false,
                    "Terénní výzkum. byla jednou z prvních žen, která se vydala do odlehlé části světa," +
                         " aby zde zkoumala životy tamějších lidí. Skrze svou práci mohla ukázat obyvatelům západních \"vyspělých\" zemí," +
                           " že by se mohli mnohé naučit z každodenních životů a hodnot takzvaně \"primitivních\" národů."
                ),
                PsychologyTermAnswer(
                    """W. Köhler""",
                    false,
                    """Zkoumal u primátů a popsal jejich řešení problému „jak dostat nedostupný banán“ - vhled - heureka moment. Gestalisté"""
                ),
            ),
            questionNumber = 52,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Tolman modifikoval schéma S-R zavedením""",
            textAnswer = "Neobejaviorismus, Molární a Molekulární chování" +
                "\nInspirace z Gestaltu, S-O-R (S-Organism-R), kognitivní a emociální vliv." +
                "\nKognitivní mapa - Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí.",
            answers = listOf(
                PsychologyTermAnswer("""molárního přístupu ke stimulaci""",
                    false
                ),
                PsychologyTermAnswer("""odmítnutím vědomí""",
                    false
                ),
                PsychologyTermAnswer("""molekulárního chápání reakcí""",
                    false
                ),
                PsychologyTermAnswer("""intervenující proměnné O""",
                    false,
                    "rušivá proměnná, které se snažíme zbavit"
                ),
            ),
            questionNumber = 53,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """K psychoanalytickým pojmům nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Oidipův komplex""",
                    false,
                    "Freud - syn se bojí o genitálie, vztah s matkou"
                ),
                PsychologyTermAnswer("""vytěsnění""",
                    false
                ),
                PsychologyTermAnswer("""období latence""",
                    false,
                    "Freud - Latentní stádium (5-puberta): sublimace sex. potřeb do školy."
                ),
                PsychologyTermAnswer("""Midasův komplex""",
                    false,
                    "Antipatie vůči svědkům osobního selhání"
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Obrannými mechanismy ega se poprvé podrobně zabýval/a""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""P. Janet""",
                    false,
                    "Hysterie, hypnóza, trauma, paměť, disociace. Žák Charcota." +
                        "\nPrvní používal termín \"podvědomí\"(\"podvědomá utkvělá představa\") a obviňoval Freuda za plagiátorství."
                ),
                PsychologyTermAnswer("""A. Freudová""",
                    false
                ),
                PsychologyTermAnswer("""H. Kohut""",
                    false,
                    "Psychoanalýza (selfpsychologie), Narcismus - již nebral jako psychózu, ale jako porochu osobnosti." +
                        "\nNarcistický (selfobjektivní) přenos:" +
                        "\n\tZrcadlící přenos - analytik vnímán jako vyživující"+
                        "\n\tIdealizující přenos - analytik vnímán jako ideál"+
                        "\n\tBlíženecký přenos - analytik vnímán jako alter ego, jemu podobný"
                ),
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                        "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                        "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                        "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                        "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací."
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Asociační experiment zavedl""",
            textAnswer =  "Jung četl seznam slov nahlas a čekal na asociace, které slova evokovaly v recipientovi.\n" +
                "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar.",
            answers = listOf(
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                        "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                        "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                        "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                        "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací."
                ),
                PsychologyTermAnswer("""J. Locke""",
                    false,
                    "Empirismus, blank slate - \"Vím, protože jsem to zažil\", Dualismus (duše, tělo), Asocianismus - psychické dění jsou spoje mezi psych. obsahy"
                ),
                PsychologyTermAnswer("""H. Sullivan""",
                    false,
                    "Společně s K. Horney představitel neopsychoanalýzy (neoFreudismus) a vztahu dítěte a matky" +
                        "\nTenze = a) Nedostatečná fyz. satisfakce od matky b) Úzkost, z úzkostné matky" +
                        "\nOsobnost je výsledek interpersonálních vztahů," +
                        "\nDynamismus - vzorec transformace energie"
                ),
                PsychologyTermAnswer(
                    """C. G. Jung""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Významnou součástí dějin psychologie je teoretický spor mezi""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Freudem a gestaltisty""",
                    false
                ),
                PsychologyTermAnswer("""Watsonem a Pavlovem""",
                    false
                ),
                PsychologyTermAnswer("""Skinnerem a Rogersem""",
                    false,
                    "Spor mezi přírodovědným, analyzujícím světem -Rogers a \"vysvětlujícím\" - Skinner"
                ),
                PsychologyTermAnswer("""všechny odpovědi jsou správně""",
                    false
                ),
            ),
            questionNumber = 57,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Sociometrii zavedl""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""D. Krech (1909-1977)""",
                    false,
                    "Studie krys - teorie lokalizace mozku" +
                        "\nSociální psychologie - první soudní znalec psycholog"
                ),
                PsychologyTermAnswer("""Ch. Spearman""",
                    false,
                    "Faktorová analýza (Factor analysis, inteligenční faktor g) - statická metoda. " +
                        "\nKdyž máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny, které už nám to predikují a analyzují lépe." +
                        "\nSpearmenova koeficient pořadové korelace - statistická závisost mezi 2 veličinami (korelace)" +
                        "\nVýzkům a zastánce dědičnosti IQ (eugenetika)"
                ),
                PsychologyTermAnswer("""J. L. Moreno""",
                    false,
                    "Psychodrama, sociální psycholog, Teorie Setkávání - sociometrie, zmapování vztahů mezi jedinci např. ve škole podle tříd."
                ),
                PsychologyTermAnswer("""A. Comte""",
                    false,
                    "Zakladatel Pozitivismu - epistomologický, metodologický myšlení - snaží se vyhnut spekulaci" +
                        "Jeden ze zakladatelů sociologie"
                ),
            ),
            questionNumber = 58,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Typickým představitelem racionalistické podoby nativismu byl""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""J. Locke""",
                    false,
                    "Empirismus, blank slate - \"Vím, protože jsem to zažil\", Dualismus (duše, tělo), Asocianismus - psychické dění jsou spoje mezi psych. obsahy"
                ),
                PsychologyTermAnswer("""W. James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer("""T. Aquinský""",
                    false,
                    "Otec školy myšlení - teologie a filozofie (Thomism)"
                ),
                PsychologyTermAnswer("""G. W. Leibniz""",
                    false,
                    "Racionalista - rozumová složka/poznání, potřeba hypotéz a teorií" +
                        "\nMonády" +
                        "\nTeodicea (pokud Bůh je, odkud je zlo? Pokud není, odkud je dobro?)"
                ),
            ),
            questionNumber = 59,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Ch. Ehrenfels objevil "útvarové kvality", které jsou vlastnostmi celku neodvoditelnými z jednotlivých částí. Stal se tak předchůdcem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Würzburské školy""",
                    false,
                    "Würzburská škola, Kulpe, K.Buhler - experimentální laboratoř o myšlení. Kritický realismus - existence realit - věci na nás nezávislých"
                ),
                PsychologyTermAnswer("""funkcionalismu""",
                    false,
                    "evolucionální důvod za chováním, ne o \"paměti\", ale učení"
                ),
                PsychologyTermAnswer("""holismu""",
                    false
                ),
                PsychologyTermAnswer(
                    """gestaltismu""",
                    false,
                    "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                        "\nNěkteré věci, které řešili:" +
                        "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                        "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                        "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                        "\nZákon podobnosti - tendence vnímat podobné podněty jako celky."
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = "Určete autora výroku \"Dejte mi tucet zdravých nemluvňat, dobře vyvinutých, a můj vlastní specifický svět," +
                " v němž bych je vychovával, a já vám zaručím, že vezmu kterékoliv z nich náhodou a vycvičím je," +
                " aby se z něho stal jakýkoliv odborník podle vaší volby lékař, právník, umělec, obchodník, ano," +
                " dokonce i žebrák a zloděj, bez ohledu na jeho talenty, sklony, tendence, schopnosti a na povolání a rasu jeho předků.\"",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. Titchener""",
                    false,
                    "Strukturalismus - introspekce, Wundt, rozklad vědomí na elementy. Studoval pod Wundtem."
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    "Behaviorismus, operantní podmiňování"
                ),
                PsychologyTermAnswer(
                    """J. B. Watson""",
                    false,
                    "Behaviorismus, \"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""J. Locke""",
                    false,
                    "Empirismus, blank slate - \"Vím, protože jsem to zažil\", Dualismus (duše, tělo), Asocianismus - psychické dění jsou spoje mezi psych. obsahy"
                ),
            ),
            questionNumber = 61,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených psychologů vytvořil systém stádií, jež zahrnují celý průběh života jedince?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. Erikson""",
                    false,
                    "Vývoj osobnosi, psychosociální teorie. Každý stádium má krizi, kterou musíme vyřešit abychom mohli pokračovat." +
                        "\nDůvěra x nedůvěra (do roku)" +
                        "\nAutonomie x stud (2-3 let) - podobné anal stádiu u Fredu - je dítě učeno být samostatné?" +
                        "\nIniciativa x vina (3-5 let) - jak moc nechají rodiče dítě růst" +
                        "\nSnaživost x méněcennost (6-12 let)" +
                        "\nIdentita x nejistota (12-16)" +
                        "\nIntimita x izolace (18-35)" +
                        "\nReprodukce x stagnace (35-55)" +
                        "\nIntegrita x stagnace (55+)"
                ),
                PsychologyTermAnswer("""A. Binet""",
                    false,
                    "První test inteligence (Binet-Simonova inteligenční škála)"
                ),
                PsychologyTermAnswer("""J. Piaget""",
                    false,
                    "Asimilace a Akomodace \nSenzomotorická inteligence (0-2 roky):" +
                "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                    " Strange situation study - attachment styly." +
                    "\n\nPředoperační (symbolické, předpojmové) stadium (3-6 let):" +
                    "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                    "\n\nStadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                    "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                    "\n\nStadium formálních operací (12+)" +
                    "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""L. Kohlberg""",
                    false,
                    "Stádie morálního vývoje" +
                        "\n1.Předkonvenční morálka" +
                        "\n\t-trest, odměna" +
                        "\n2.Konvenční morálka" +
                        "\n\t-chce být hodný kluk/hodná holka, autorita - zákony, pravidla" +
                        "\n3.Postkonvenční (autonomní, hyperkonvenční, principiální 25%) morálka" +
                        "\n\t-společenská smlouva, balance mezi univerzálními a osobními etickými principy"
                ),
            ),
            questionNumber = 62,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Které významné hnutí se objevilo v americké psychologii mezi lety 1910 a 1920?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""strukturalismus""",
                    false,
                    "Tak 1900 (1898?)" +
                        "\nWundt (DE) a Titchener (USA). Introspekce (looking inward)." +
                        " Mysl je složena ze smyslů, pocitů a obrázků. Dobová alternativa byla Funkcionalismus (evolucionální důvod za chováním, ne o \"paměti\", ale učení)."
                ),
                PsychologyTermAnswer("""pragmatismus""",
                    false,
                    "1870"
                ),
                PsychologyTermAnswer("""koncepce sociálního učení""",
                    false,
                    "1977, Bandura - Bobo doll"
                ),
                PsychologyTermAnswer(
                    """behaviorismus""",
                    false,
                    "(S-R psychologie, S=stimul, R=reakce) – zakladatel Watson, věda o chování, vliv měli " +
                        "Pavlov a Bechtěrev"
                ),
            ),
            questionNumber = 63,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Molární a molekulární chování rozlišoval/i""",
            textAnswer = "Molární - složitější celky, zabírají déle (psaní dopisu)" +
                "\nMolekulární - spíše fyziologické, projevy bez soc. významu",
            answers = listOf(
                PsychologyTermAnswer("""strukturalisté""",
                    false,
                    "introspekce, Wundt, rozklad vědomí na elementy. Studoval pod Wundtem."
                ),
                PsychologyTermAnswer("""H. Helmholtz""",
                    false,
                    "Teorie vidění oka, vizuální percepce, barvy, vnímání tónů a zvuků, Empirismus."
                ),
                PsychologyTermAnswer("""E. C. Tolman""",
                    false,
                    "Neobejaviorismus, Molární a Molekulární chování" +
                        "\nInspirace z Gestaltu, S-O-R (S-Organism-R), kognitivní a emociální vliv." +
                        "\nKognitivní mapa - Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí."
                ),
                PsychologyTermAnswer("""W. Wundt""",
                    false,
                    "První laboratoř (1879, Lipsko), Strukturalismus psychologie jako věda, Introspekce (looking inward)"
                ),
            ),
            questionNumber = 64,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín bazální úzkost zavedl/a""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""K. Horneyová""",
                    false,
                    "Základní (bazální) úzkost - neurotičtí rodiči vytvářejí nejistost v dítěti, rozporné chování okolí" +
                        "\nPotřeby bezpečí dětí - fyz. i mentální, zvládnou vše pokud mají dobrý základ" +
                        "\nNeurotické potřeby dospělých - nenásledují sliby, nefér chování" +
                        "\n\tReprese hostility dítěte -> Bezmocnost, Intimidace (strach z trestů), nedostatek potřeby bezpečí -> Základní úzkost." +
                        "\nNeurotické postoje:" +
                        "\n\t1. Pohyb směrem k lidem - konformita"+
                        "\n\t2. Pohyb směrem proti lidem - antisocial"+
                        "\n\t3. Pohyb směrem od lidí - asiocal"
                ),
                PsychologyTermAnswer("""H. Ebbinghaus""",
                    false,
                    "Experimentální studie paměti, křivka zapomínání, monografie paměti. Asocianismus - \"Nic není ve vědomí, co dříve nebylo ve smyslech.\"" +
                        "\nSpacing effect - učení s prostory mezi je více efektivní." +
                        "\nSerial-position effect (efekt primárnosti a novosti) - Pozice pamatovných věcí hraje roli na to, jaké si pamatujeme."
                ),
                PsychologyTermAnswer("""V. Satirová""",
                    false,
                    "\"Matka rodinné terapie\""
                ),
                PsychologyTermAnswer("""H. Münsterberg (1863-1955)""",
                    false,
                    "Klinická, experimentální, pracovní psychologie, zastánce behaviorismu. Bádenská, novokantovská škola." +
                        "\nOtec psychotechniky - nástroj pro psychologický výběr pracovníků (vojáků) na pozice."
                ),
            ),
            questionNumber = 65,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Autorem spisu O duši (Peri psychés) je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Plotínos""",
                    false,
                    "Novoplatónismus - Monismus (jednota konceptů)"
                ),
                PsychologyTermAnswer("""Aristoteles""", false,
                    "\n\t-5 smyslů, TABULA RASA (de anima)" +
                        "\n\t-filozofická škola Lekeion - procházka s žáky" +
                        "\n\t-dualismus (všechny organismy), de anima parva naturalia, de memoria"
                ),
                PsychologyTermAnswer("""Empedokles""",
                    false,
                    "Definoval elementy oheň, vodu, vzduch a zemi" +
                        "\nReinkarnace - duše je nezávislý element"
                ),
                PsychologyTermAnswer("""Platón""",
                    false,
                    "(Aristokles), Platonismus - myšlenky místo příkladů, Duše dává život" +
                        "\nSokrates -> Platon -> Aristoteles" +
                        "\n\t-dialogy s ostatními (a následné vyvracení)" +
                        "\n\t-díla: Republika, Obrana Sókratova, Ústava, Symposion, Gorgiás"
                ),
            ),
            questionNumber = 66,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = "Který psycholog popsal svět kojence jako \"kvetoucí, bzučící zmatek\"?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""R. Spitz""",
                    false,
                    "Vývoj dítěte, úzkost 8. měsíce - anaklitická deprese - ztráta opory - začne se bát cizích lidí, pojem resilientní děti." +
                        "\nCenestická percepce (vnímání přes tělesné vlivy), distální percepce (náznak odlišení sebe)" +
                        "\nVýv. stádia: preobjektální, předběžného objektu, objektivních stavů"
                ),
                PsychologyTermAnswer("""W. Wundt""",
                    false,
                    "První laboratoř (1879), Strukturalismus psychologie jako věda, Introspekce (looking inward)"
                ),
                PsychologyTermAnswer("""W. James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer(
                    """C. G. Jung""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 67,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Jaká veličina patří do vzorce x = (mentální věk / chronologický věk)* 100 místo proměnné x?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""inteligenčni kvocient""",
                    false,
                    "W. Stern"
                ),
                PsychologyTermAnswer("""vývojový kvocient""",
                    false
                ),
                PsychologyTermAnswer("""vývojová úroveň""",
                    false
                ),
                PsychologyTermAnswer("""úroveň intelektové přiměřenosti""",
                    false
                ),
            ),
            questionNumber = 68,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """A. Gesell je znám především jako""",
            textAnswer = "5 vývojových zákonitostí (vznikly změnami v kojeneckém věku)" +
                "\nVývojový gradient:" +
                "\n\t1. Kefalokaudální směr - od hlavy k ocasu - první se vyvýjí hlava"+
                "\n\t2. Proximodistální směr - od centra těla na okraj - vývoj kloubů, první velké a pak jemnější"+
                "\n\t3. Ulnoradiální směr - uchopování věcí, první hrabavým pohybem, pak \"jako bagr\", poté radiálně (7.-8. měsíc), pak klíšťový úchop (palec a jeden prst v opozici)",
            answers = listOf(
                PsychologyTermAnswer(
                    """autor německé inteligenční škály pro dospělé""",
                    false
                ),
                PsychologyTermAnswer("""autor zákonů motorického vývoje dítěte""",
                    false
                ),
                PsychologyTermAnswer("""neopsychoanalytik""",
                    false
                ),
                PsychologyTermAnswer("""průkopník klinické psychologie v USA""",
                    false
                ),
            ),
            questionNumber = 69,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Jméno K. Pribrama je spojeno s""",
            textAnswer = "Moderní (subjektivní behaviorismus - snaha vytvořit společný jazyk, vliv Chomskyho)" +
                "\nObraz a plán - TOTE - 2 recipročně spjaté procesy",
            answers = listOf(
                PsychologyTermAnswer("""teorií systémů""",
                    false
                ),
                PsychologyTermAnswer("""operantním podmiňováním""",
                    false
                ),
                PsychologyTermAnswer("""interpersonální diagnostikou""",
                    false
                ),
                PsychologyTermAnswer("""holografickým modelem mozku""",
                    false
                ),
            ),
            questionNumber = 70,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Humanistická psychologie se jako nový směr objevila""",
            textAnswer = "1950-1960. Maslow, Rogers. Zaměřeno na terapii. Nerozkládá člověka, však k němu přistupuje jako k celku.",
            answers = listOf(
                PsychologyTermAnswer("""v západní Evropě""",
                    false
                ),
                PsychologyTermAnswer("""později než neobehaviorismus""",
                    false
                ),
                PsychologyTermAnswer("""během druhé světové války""",
                    false
                ),
                PsychologyTermAnswer("""později než transpersonální psychologie""",
                    false
                ),
            ),
            questionNumber = 71,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """První hromadné testování inteligence bylo prováděno:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v ústavech pro mentálně postižené""",
                    false
                ),
                PsychologyTermAnswer("""ve školách""",
                    false
                ),
                PsychologyTermAnswer("""pro armádu""",
                    false
                ),
                PsychologyTermAnswer("""v automobilkách""",
                    false
                ),
            ),
            questionNumber = 72,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Kdo z uvedených nebyl významným českým psychologem?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""M. Rostohar""",
                    false,
                    "1878-1966. Brno, celostní, tvarová psychologie, experimentální psychologie"
                ),
                PsychologyTermAnswer("""V. Vondráček""",
                    false
                ),
                PsychologyTermAnswer("""J. Stavěl""",
                    false,
                    "Založil psychotechnický ústav, dějiny psychologie, osobnost a motivace, poradenství" +
                        "\nPostoje, zájmy: poznávací, estetické, sociální, přírodní, obchodní, technické, rukodělně materiálové, výtvarné, sportovní zájmy"
                ),
                PsychologyTermAnswer("""V. Příhoda""",
                    false,
                    "1889-1979. Experimentální pedagogika, snaha o reformu učitelství."
                ),
            ),
            questionNumber = 73,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Autorem významné učebnice dějin psychologie je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""E. G. Boring""",
                    false
                ),
                PsychologyTermAnswer("""D. B. Tedious""",
                    false
                ),
                PsychologyTermAnswer("""N. D. Irksome""",
                    false
                ),
                PsychologyTermAnswer("""K. Langweil""",
                    false
                ),
            ),
            questionNumber = 74,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Zakladatelem obecné teorie systémů byl""",
            textAnswer = "Živé organismy si vyměňují látky a energii a nedají se jednoduše popsat (holismus oproti redukcionismu).",
            answers = listOf(
                PsychologyTermAnswer("""K. Lewin""",
                    false,
                    "Gestalt Psychologie\n" +
                        "Teorie pole - chování = osobnost + prostředí." +
                        "\n typy vedení: autokracie (agrese, rebelie), demokracie (stabilni, prumerne), bez vedení (bez agrese, bez cíle, bez spolupráce)" +
                        "\n\nKonflikty motivů:" +
                        "\n\t- Apetence x apetence - obě stejně přitažlivé motivy, není stabilní a vydrží jen chvíli" +
                        "\n\t- Averze x apetence - přitažlivý motiv s negativním aspektem" +
                        "\n\t- Averze x averze - výběr mezi dvěma negativními motivy, výběr menšího zla, tendence nevybrat ani jeden"
                ),
                PsychologyTermAnswer("""S. Woodworth""",
                    false,
                    "Woodworth Osobnostní test, psychometrika - měření různých věcí v psychologii"
                ),
                PsychologyTermAnswer("""K. Lorenz""",
                    false,
                    "Vtiskování (imprinting), Lorenz - nácek který udělal hydraulický model agrese (který je špatně)."
                ),
                PsychologyTermAnswer("""L. von Bertallanfy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 75,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Problematice měření inteligence se nevěnoval""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""L. Thurstone""",
                    false
                ),
                PsychologyTermAnswer("""C. Burt""",
                    false,
                    "Pedagogický psycholog, měření IQ, dědění IQ (které zfalšoval)."
                ),
                PsychologyTermAnswer("""E. Brunswik""",
                    false,
                    "(Probalistický) Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nEkologická validita = využitelnost výsledků v praxi"
                ),
                PsychologyTermAnswer("""L. Terman""",
                    false,
                    "Eugenetik, pedagogická psychologie"
                ),
            ),
            questionNumber = 76,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Koncepci asocianismu v novověké filosofii jako první rozvedl""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""J. Locke""",
                    false,
                    "Empirismus, blank slate - \"Vím, protože jsem to zažil\", Dualismus (duše, tělo), Asocianismus - psychické dění jsou spoje mezi psych. obsahy"
                ),
                PsychologyTermAnswer("""J. J. Rouseau""",
                    false
                ),
                PsychologyTermAnswer("""I. Kant""",
                    false,
                    "Immanuel Kant rolišuje na vnitřní jednání (rozmýšlení, rozvažování):" +
                        "\n\t-jednající má myšlení kompletně pod kontrolou" +
                        "\n\t-vnější jednání - jednající podléha externím vlivům, stereotypům apod." +
                        "\nMentální fenoména - psychické procesy se nedají matematicky spočítat" +
                        "\nNoumenální (externí) objekty - objekty mimo lidské životy (nezažité)" +
                        "\nFenomenální (interní) - objekt potkán naším vědomím, kategorizováno uvnitř, nejde zkoumat"
                ),
                PsychologyTermAnswer("""Empedokles""",
                    false,
                    "Definoval elementy oheň, vodu, vzduch a zemi" +
                        "\nReinkarnace - duše je nezávislý element"
                ),
            ),
            questionNumber = 77,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Podle Aristotela je duše charakteristická pro""",
            textAnswer = "\n\t-5 smyslů, TABULA RASA (de anima)" +
                "\n\t-filozofická škola Lekeion - procházka s žáky" +
                "\n\t-dualismus (všechny organismy), de anima parva naturalia, de memoria",
            answers = listOf(
                PsychologyTermAnswer("""vědomé bytosti""",
                    false
                ),
                PsychologyTermAnswer("""živočichy""",
                    false
                ),
                PsychologyTermAnswer("""organický život""",
                    false
                ),
                PsychologyTermAnswer("""lidi""",
                    false
                ),
            ),
            questionNumber = 78,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Klasické humorální pojetí temperamentu je spojeno se jménem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""J. W. Goetha""",
                    false
                ),
                PsychologyTermAnswer("""Galéna""",
                    false,
                    "Převzal po Hippokratovi a napsal spis čtyř tělesných tekutin"
                ),
                PsychologyTermAnswer("""H. J. Eysencka""",
                    false,
                    "Studoval inteligenci a osobnosti." +
                        "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                        "\nDělení osobnosti:" +
                        "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                        "\n\tExtraverze (vzrušivost mozkové kůry)" +
                        "\n\tNeuroticismus (stabilita - labilita)."
                ),
                PsychologyTermAnswer("""Platóna""",
                    false
                ),
            ),
            questionNumber = 79,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = "R. B. Cattell vymezuje tři stadia studia osobnosti: literární, klinické a vědecké. Koho byste zařadili do vědeckého stadia?",
            textAnswer = "16 osobnostních faktorů, CFIT - kulturně inkluzivní test kognitivních schopností." +
                "\nDynamické motivační rysy:" +
                "\n\tErgy - instinkt/drive - vztek, hlad, sex, zvědavost" +
                "\n\tSentimenty - naučené- prostředí" +
                "\n\tPostoje - zájmy, emoce" +
                "\nInteligence:" +
                "\n\tFluidní (tekutá) - adaptivní, abstraktní, biologicky ovlivněné kognitivní schopnosti" +
                "\n\tKrystalická - zkušenosti, znalosti" +
                "\nL-Data (life data), T-Data (experimentální), Q-Data (dotazníky)" +
                "\n\n\n" +
                "Literární stadium: V literárním stadiu se studium osobnosti opírá o popisné a interpretativní metody. Výzkumníci a teoretici v tomto stadiu se často spoléhají na literární zdroje, biografie, autobiografie, díla literatury a další texty, které obsahují popisy a analýzy jednotlivých osobností. Tento přístup k výzkumu osobnosti se často zaměřuje na kvalitativní analýzu a porozumění jednotlivým případům. Příkladem literárního stadia může být psychologická analýza děl Sigmunda Freuda, který se zabýval interpretací lidské psychiky na základě literárních textů.\n" +
                "\n" +
                "Klinické stadium: Klinické stadium se zaměřuje na výzkum a hodnocení osobnosti založené na klinické praxi a klinických metodách. Výzkumníci v tomto stadiu často pracují s pacienty nebo subjekty, kteří mají určité psychologické problémy nebo poruchy. Používají diagnostické nástroje, jako je například rozhovor, psychologické testy a pozorování, aby získali informace o osobnosti a jejích rysy. Klinické stadium se zaměřuje na porozumění individuálním rozdílům a vývoji osobnosti v kontextu psychopatologie. Psychologové a psychiatři často pracují v tomto stadiu, aby lépe porozuměli a pomohli lidem s psychickými obtížemi.\n" +
                "\n" +
                "Vědecké stadium: Vědecké stadium je charakterizováno systematickým a empirickým výzkumem osobnosti pomocí kvantitativních metod a statistické analýzy dat. Vědecké stadium se zaměřuje na objektivní měření a kvantifikaci různých aspektů osobnosti. Výzkumníci v tomto stadiu často používají dotazníky, testy a experimentální metody, aby získali kvantitativní data, která mohou být statisticky analyzována. Cílem je objevit vzorce a zákony, které ovlivňují osobnost a chování. Vědci v oblasti psychologie osobnosti, behaviorální genetiky, sociální psychologie a dalších příbuzných disciplín často pracují v tomto stadiu.",
            answers = listOf(
                PsychologyTermAnswer("""H. Eysencka""",
                    false,
                    "Studoval inteligenci a osobnosti." +
                        "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                        "\nDělení osobnosti:" +
                        "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                        "\n\tExtraverze (vzrušivost mozkové kůry)" +
                        "\n\tNeuroticismus (stabilita - labilita)."
                ),
                PsychologyTermAnswer("""S. Freuda""",
                    false
                ),
                PsychologyTermAnswer("""A. Maslowa""",
                    false
                ),
                PsychologyTermAnswer(
                    """C. G. Junga""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
            ),
            questionNumber = 80,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Köhlerovy pokusy se šimpanzi měly velký význam pro formulaci úlohy""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """významu pocitu bezpečí v psychickém vývoji""",
                    false
                ),
                PsychologyTermAnswer("""ničeho z uvedených""",
                    false
                ),
                PsychologyTermAnswer("""hierarchie ve skupině""",
                    false
                ),
                PsychologyTermAnswer(
                    """vhledu při řešení problémů""",
                    false,
                    "Gestalt Psychologie. Wertheimer, Kohler\n" +
                        "Spontánní pochopení problému v dané situaci - najednou má člověk nadhled."
                ),
            ),
            questionNumber = 81,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Pro který psychologický směr má největší význam lingvistická teorie N. Chomskyho?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociobiologie""",
                    false,
                    "Úzce spojeno s evoluční psychologií. Zkoumá sociální chování z biologického (hlavně evolučního) pohledu." +
                        "\nStrach má evoluční původ, společenská hiearchie také, apod."
                ),
                PsychologyTermAnswer("""psychologie osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false
                ),
                PsychologyTermAnswer("""marxistická psychologie""",
                    false
                ),
            ),
            questionNumber = 82,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Mezi pražské rodáky patří:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Sigmund Freud""",
                    false
                ),
                PsychologyTermAnswer("""Edmund Husserl""",
                    false,
                    "Fenomenologie - (Kant, fenomenální objekty) - jak člověk opravdu vnímá věci, zkušenosti."
                ),
                PsychologyTermAnswer("""Kurt Koffka""",
                    false,
                    "Gestalt"
                ),
                PsychologyTermAnswer("""Max Wertheimer""",
                    false,
                    "Praha, reproduktivní (repetice, podmiňování) vs. produktivní (nové myšlenky) přemýšlení"
                ),
            ),
            questionNumber = 83,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Mezi české psychology zabývající se dětským vývojem nepatří:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Zdeněk Matějček""",
                    false,
                    "Dětský psycholog, vliv podmínek v ústavech - deprivace/strádání, vývojová psychologie"
                ),
                PsychologyTermAnswer("""Josef Švejcar""",
                    false,
                    "Pediatr, tuberkulózní děti v SK, dětská klinika v Praze"
                ),
                PsychologyTermAnswer("""Josef Langmeier""",
                    false
                ),
                PsychologyTermAnswer("""Václav Příhoda""",
                    false,
                    "1889-1979. Experimentální pedagogika, snaha o reformu učitelství."
                ),
            ),
            questionNumber = 84,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Restrukturace problémového pole při řešení problémů byla jako důležitý faktor myšlení prosazována""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""reflektology""",
                    false
                ),
                PsychologyTermAnswer(
                    """asocianisty""",
                    false,
                    "Vznik ve filozofii 18-19 století. J.F. Herbart, Locke a Ebbinghaus. \"Nic není ve vědomí, co dříve nebylo ve smyslech.\""
                ),
                PsychologyTermAnswer("""strukturalisty""",
                    false
                ),
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
            ),
            questionNumber = 85,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Významné výzkumy poslušnosti a podrobování se autoritě prováděl/a""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""S. Milgram""",
                    false
                ),
                PsychologyTermAnswer("""M. Kleinová""",
                    false,
                    "Psychoanalitička, projekce, závist, dětská psychologie a jejich vývoj." +
                        "\nTeorie Objektivních vztahů - důležitost mezilidských vztahů (hlavně v rodině)."
                ),
                PsychologyTermAnswer("""M. Meadová""",
                    false,
                    "Terénní výzkum. byla jednou z prvních žen, která se vydala do odlehlé části světa," +
                        " aby zde zkoumala životy tamějších lidí. Skrze svou práci mohla ukázat obyvatelům západních \"vyspělých\" zemí," +
                        " že by se mohli mnohé naučit z každodenních životů a hodnot takzvaně \"primitivních\" národů."
                ),
                PsychologyTermAnswer("""N. Ach""",
                    false
                ),
            ),
            questionNumber = 86,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Lightner Witmer poprvé použil termin""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dementia praecox""",
                    false,
                    "E. Kraepelin, P. Pinel (schizofrenie)"
                ),
                PsychologyTermAnswer("""psychologie národů""",
                    false
                ),
                PsychologyTermAnswer("""klinická psychologie""",
                    false
                ),
                PsychologyTermAnswer("""psychognostika""",
                    false,
                    "Měření duševních vlastností a stavů (charakteristiky) jednotlivců"
                ),
            ),
            questionNumber = 87,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Kdo z uvedených badatelů se zabýval zejména kognitivním vývojem dětí?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""A. Gesell""",
                    false,
                    "5 vývojových zákonitostí (vznikly změnami v kojeneckém věku)" +
                        "\nVývojový gradient:" +
                        "\n\t1. Kefalokaudální směr - od hlavy k ocasu - první se vyvýjí hlava"+
                        "\n\t2. Proximodistální směr - od centra těla na okraj - vývoj kloubů, první velké a pak jemnější"+
                        "\n\t3. Ulnoradiální směr - uchopování věcí, první hrabavým pohybem, pak \"jako bagr\", poté radiálně (7.-8. měsíc), pak klíšťový úchop (palec a jeden prst v opozici)"
                ),
                PsychologyTermAnswer("""J. Piaget""",
                    false,
                    "Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\nPředoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\nStadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\nStadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""E. Erikson""",
                    false,
                    "Vývoj osobnosi, psychosociální teorie. Každý stádium má krizi, kterou musíme vyřešit abychom mohli pokračovat." +
                        "\nDůvěra x nedůvěra (do roku)" +
                        "\nAutonomie x stud (2-3 let) - podobné anal stádiu u Fredu - je dítě učeno být samostatné?" +
                        "\nIniciativa x vina (3-5 let) - jak moc nechají rodiče dítě růst" +
                        "\nSnaživost x méněcennost (6-12 let)" +
                        "\nIdentita x nejistota (12-16)" +
                        "\nIntimita x izolace (18-35)" +
                        "\nReprodukce x stagnace (35-55)" +
                        "\nIntegrita x stagnace (55+)"
                ),
                PsychologyTermAnswer("""R. Spitz""",
                    false,
                    "Vývoj dítěte, úzkost 8. měsíce - anaklitická deprese - ztráta opory - začne se bát cizích lidí, pojem resilientní děti." +
                        "\nCenestická percepce (vnímání přes tělesné vlivy), distální percepce (náznak odlišení sebe)" +
                        "\nVýv. stádia: preobjektální, předběžného objektu, objektivních stavů"
                ),
            ),
            questionNumber = 88,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín psychognostika je spojen se jménem""",
            textAnswer = "Měření duševních vlastností a stavů (charakteristiky) jednotlivců",
            answers = listOf(
                PsychologyTermAnswer("""H. Münsterberga (1863-1955)""",
                    false,
                    "Klinická, experimentální, pracovní psychologie, zastánce behaviorismu. Bádenská, novokantovská škola." +
                        "\nOtec psychotechniky - nástroj pro psychologický výběr pracovníků (vojáků) na pozice."
                ),
                PsychologyTermAnswer("""L. Thurstona""",
                    false,
                    "měření inteligence"
                ),
                PsychologyTermAnswer("""J. Stavěla""",
                    false,
                    "Založil psychotechnický ústav, dějiny psychologie, osobnost a motivace, poradenství" +
                        "\nPostoje, zájmy: poznávací, estetické, sociální, přírodní, obchodní, technické, rukodělně materiálové, výtvarné, sportovní zájmy"
                ),
                PsychologyTermAnswer("""L. Witmera""",
                    false,
                    "Klinická psychologie"
                ),
            ),
            questionNumber = 89,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """První inteligenční test (s výsledkem v podobě údaje o mentálním věku) byl sestrojen""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v USA""",
                    false
                ),
                PsychologyTermAnswer("""ve Francii""",
                    false
                ),
                PsychologyTermAnswer("""v Německu""",
                    false
                ),
                PsychologyTermAnswer("""v Československu""",
                    false
                ),
            ),
            questionNumber = 90,
            correctAnswer = 1,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Ve vývoji kognitivní psychologie sehrála důležitou úlohu recenze N. Chomskyho na knihu jednoho významného behavioristy. Jednalo se o knihu""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Teaching machines od B. F. Skinnera""",
                    false
                ),
                PsychologyTermAnswer("""Verbal structures od E. C. Tolmana""",
                    false
                ),
                PsychologyTermAnswer("""Verbal behavior od B. F. Skinnera""",
                    false
                ),
                PsychologyTermAnswer("""Verbal behavior od E. L. Thorndika""",
                    false
                ),
            ),
            questionNumber = 91,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín sociální behaviorismus poprvé použil/a pro označení svého vlastního přístupu""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""G. H. Mead""",
                    false,
                    "Sociální psychologie (sociální behaviorismus), reprezentace společnoste v mysli jedince - zobecněný druhý (generalized other) - Interakce je zprostředkována interpretacemi a významy mezi jedinci., Symbolický Interakcionismus - interakce jedinců a jejich interpretace."
                ),
                PsychologyTermAnswer("""M. Meadová""",
                    false,
                    "Terénní výzkum. byla jednou z prvních žen, která se vydala do odlehlé části světa," +
                        " aby zde zkoumala životy tamějších lidí. Skrze svou práci mohla ukázat obyvatelům západních \"vyspělých\" zemí," +
                        " že by se mohli mnohé naučit z každodenních životů a hodnot takzvaně \"primitivních\" národů."
                ),
                PsychologyTermAnswer("""J. Dollard""",
                    false,
                    "Teorie (hypotéza) frustrace-agrese (taky N. E. Miller). Subjektivní behavioristi. S (pudová potřeba) + signál -> R -> zpevnění."
                ),
                PsychologyTermAnswer("""E. C. Tolman""",
                    false,
                    "Neobejaviorismus, Molární a Molekulární chování" +
                        "\nInspirace z Gestaltu, S-O-R (S-Organism-R), kognitivní a emociální vliv." +
                        "\nKognitivní mapa - Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí."
                ),
            ),
            questionNumber = 92,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """O biologické zušlechťování lidské společnosti se pokoušela""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""etnogenetika""",
                    false
                ),
                PsychologyTermAnswer("""embryonika""",
                    false
                ),
                PsychologyTermAnswer("""genetika""",
                    false
                ),
                PsychologyTermAnswer("""eugenika""",
                    false
                ),
            ),
            questionNumber = 93,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """IQ pro vyjadřování inteligence zavedl""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""A. Gesell""",
                    false,
                    "5 vývojových zákonitostí (vznikly změnami v kojeneckém věku)" +
                        "\nVývojový gradient:" +
                        "\n\t1. Kefalokaudální směr - od hlavy k ocasu - první se vyvýjí hlava"+
                        "\n\t2. Proximodistální směr - od centra těla na okraj - vývoj kloubů, první velké a pak jemnější"+
                        "\n\t3. Ulnoradiální směr - uchopování věcí, první hrabavým pohybem, pak \"jako bagr\", poté radiálně (7.-8. měsíc), pak klíšťový úchop (palec a jeden prst v opozici)"
                ),
                PsychologyTermAnswer("""Ch. Bühlerová""",
                    false
                ),
                PsychologyTermAnswer("""W. Stern""",
                    false,
                    "Inteligenční kvocient (IQ - ment.věk děleno chronologický), založil Diferenciální psychologii (jako psychologie osobnosti - rozdíli mezi lidmi)"
                ),
                PsychologyTermAnswer("""R. B. Cattell""",
                    false,
                    "16 osobnostních faktorů, CFIT - kulturně inkluzivní test kognitivních schopností." +
                        "\nDynamické motivační rysy:" +
                        "\n\tErgy - instinkt/drive - vztek, hlad, sex, zvědavost" +
                        "\n\tSentimenty - naučené- prostředí" +
                        "\n\tPostoje - zájmy, emoce" +
                        "\nInteligence:" +
                        "\n\tFluidní (tekutá) - adaptivní, abstraktní, biologicky ovlivněné kognitivní schopnosti" +
                        "\n\tKrystalická - zkušenosti, znalosti" +
                        "\nL-Data (life data), T-Data (experimentální), Q-Data (dotazníky)"
                ),
            ),
            questionNumber = 94,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Tzv. klinický přístup je úzce spjat s osobou""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""R. B. Cattella""",
                    false,
                    "16 osobnostních faktorů, CFIT - kulturně inkluzivní test kognitivních schopností." +
                        "\nDynamické motivační rysy:" +
                        "\n\tErgy - instinkt/drive - vztek, hlad, sex, zvědavost" +
                        "\n\tSentimenty - naučené- prostředí" +
                        "\n\tPostoje - zájmy, emoce" +
                        "\nInteligence:" +
                        "\n\tFluidní (tekutá) - adaptivní, abstraktní, biologicky ovlivněné kognitivní schopnosti" +
                        "\n\tKrystalická - zkušenosti, znalosti" +
                        "\nL-Data (life data), T-Data (experimentální), Q-Data (dotazníky)"
                ),
                PsychologyTermAnswer("""E. Ch. Tolmana""",
                    false,
                    "Neobejaviorismus, Molární a Molekulární chování" +
                        "\nInspirace z Gestaltu, S-O-R (S-Organism-R), kognitivní a emociální vliv." +
                        "\nKognitivní mapa - Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí."
                ),
                PsychologyTermAnswer("""A. R. Lurijy""",
                    false
                ),
                PsychologyTermAnswer("""A. U. Paivia""",
                    false
                ),
            ),
            questionNumber = 95,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Ke sporu mezi analogovou a propoziční školou došlo""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v rámci kognitivní psychologie""",
                    false
                ),
                PsychologyTermAnswer(
                    """na rozhraní mezi kognitivní a humanistickou psychologii""",
                    false
                ),
                PsychologyTermAnswer("""v rámci komunikačního přístupu""",
                    false
                ),
                PsychologyTermAnswer("""ve třicátých letech v psycholingvistice""",
                    false
                ),
            ),
            questionNumber = 96,
            correctAnswer = 0,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Karen Horneyová bývá řazena mezi""",
            textAnswer = "Základní (bazální) úzkost - neurotičtí rodiči vytvářejí nejistost v dítěti, rozporné chování okolí" +
                "\nPotřeby bezpečí dětí - fyz. i mentální, zvládnou vše pokud mají dobrý základ" +
                "\nNeurotické potřeby dospělých - nenásledují sliby, nefér chování" +
                "\n\tReprese hostility dítěte -> Bezmocnost, Intimidace (strach z trestů), nedostatek potřeby bezpečí -> Základní úzkost." +
                "\nNeurotické postoje:" +
                "\n\t1. Pohyb směrem k lidem - konformita"+
                "\n\t2. Pohyb směrem proti lidem - antisocial"+
                "\n\t3. Pohyb směrem od lidí - asiocal",
            answers = listOf(
                PsychologyTermAnswer("""psychoanalytiky""",
                    false
                ),
                PsychologyTermAnswer("""představitele individuální psychologie""",
                    false
                ),
                PsychologyTermAnswer("""představitele tzv. kulturní analýzy""",
                    false,
                    "analýza kultury"
                ),
                PsychologyTermAnswer("""sullivanovské psychology""",
                    false,
                    "Sullivan - Společně s K. Horney představitel neopsychoanalýzy (neoFreudismus) a vztahu dítěte a matky" +
                        "\nTenze = a) Nedostatečná fyz. satisfakce od matky b) Úzkost, z úzkostné matky" +
                        "\nOsobnost je výsledek interpersonálních vztahů," +
                        "\nDynamismus - vzorec transformace energie"
                ),
            ),
            questionNumber = 97,
            correctAnswer = 2,
            categoryId = "3. Dějiny psychologie"
        ),
        PsychologyTerm(
            prompt = """Vyberte správné řazení škol podle období vzniku od nejstarší k nejmladší:""",
            textAnswer = "Strukturalismus, Rysy, Funkcionalismus, Psychoanalýza, Sestaltismus, Behaviorismus, Kognitivní, Humanistická, Fyziobiologie, Sociokulturní",
            answers = listOf(
                PsychologyTermAnswer(
                    """behaviorismus, strukturalismus, psychoanalýza, kognitivní psychologie""",
                    false
                ),
                PsychologyTermAnswer(
                    """strukturalismus, behaviorismus, kognitivní psychologie, kulturní analýza""",
                    false
                ),
                PsychologyTermAnswer(
                    """psychoanalýza, humanistická psychologie, transpersonální psychologie, neobehaviorismus""",
                    false
                ),
                PsychologyTermAnswer(
                    """funkcionalismus, psychoanalýza, gestaltismus, humanistická psychologie""",
                    false
                ),
            ),
            questionNumber = 98,
            correctAnswer = 3,
            categoryId = "3. Dějiny psychologie"
        ),
    )
}