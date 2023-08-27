package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//revidovano
object PsychologyEight {
    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Který z uvedených typů nepatří mezi klasické typy temperamentu?""",
            textAnswer = "Sangivinik - krev - radost ze života" +
                "\nCholerik - žlutá žluč - labilní, výbušnost" +
                "\nMelancholik - černá žluc - labilní, emotivita, uzavřenost" +
                "\nFlegmatik - sliz, hlen - klid, lhostejnost",
            answers = listOf(
                PsychologyTermAnswer("""sangvinik""",
                    false
                ),
                PsychologyTermAnswer("""cholerik""",
                    false
                ),
                PsychologyTermAnswer(
                    """introvert""",
                    false,
                    "Vytvořil Jung"
                ),
                PsychologyTermAnswer("""melancholik""",
                    false
                ),
            ),
            questionNumber = 1,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Termín homeostáza má v psychologii význam zejména při vysvětlování""",
            textAnswer = "V angličtině homeostasis. Z řečtiny (hómoios, \", podobný, stejný\") + z řečtiny (stásis, \"zůstávající, stav\")",
            answers =
            listOf(
                PsychologyTermAnswer("""vývoje v raném věku""",
                    false
                ),
                PsychologyTermAnswer(
                    """motivace""",
                    false,
                    "Soubor motivů k určitému jednání. (Motiv - uvědomělé podněty vyvolávající uspokojení potřeb.)"
                ),
                PsychologyTermAnswer("""frustrace""",
                    false
                ),
                PsychologyTermAnswer("""emocí""",
                    false
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Student psychologie se naučil, že první psychologická laboratoř byla založena roku 1879 v Lipsku. Který typ paměti využil?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """procedurální paměť""",
                    false,
                    "Implicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť."
                ),
                PsychologyTermAnswer(
                    """ikonickou paměť""",
                    false,
                    """Obrazová paměť - schopna uložit až 9 položek."""
                ),
                PsychologyTermAnswer(
                    """epizodickou paměť""",
                    false,
                    """Paměť spojená s naším životem - informace a události v našem životě."""
                ),
                PsychologyTermAnswer(
                    """deklarativní paměť""",
                    false,
                    """Neboli explicitní paměť - fakta a události."""
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Konstituční typologie osobnosti""",
            textAnswer = "E. Kretschmer se snažil se spojit fyziologickou postavu jedince k patologii." +
                "\nAstenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """dávají do souvislosti typ tělesné stavby s typem osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """hledají vlastnosti, které jsou jádrem osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """se zaměřují především na faktory vývoje osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """používají jako hlavní metodu faktorovou analýzu""",
                    false,
                    "(Factor analysis) - statická metoda. Když máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny," +
                        " které už nám to predikují a analyzují lépe."
                ),
            ),
            questionNumber = 4,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Dostali jste nový mobilní telefon a chvíli vám trvalo, než jste si zapamatovali své nové telefonní číslo. " +
                "\nNyní si ho již pamatujete, ale zároveň zjistíte, že si nemůžete vybavit své staré číslo, které jste přitom používali několik let. " +
                "\nK jakému procesu zde pravděpodobně dochází?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """amnézie""",
                    false,
                    "Porucha paměti. " +
                        "\nRetrográdní (třeba otřes mozku) - pomalu se rozpomínáme, ale část těsně před nehodou většinou nikdy nenavrátíme. " +
                        "\nAnterográdní - nepamatujeme si nové věci (neurochirurgické operace proti epilepsii)"
                ),
                PsychologyTermAnswer(
                    """vytěsnění""",
                    false,
                    """Freud. Teorie, že paměťová stopa je spojená s emocí.
                        Pokud je emoce negativní, tak naše nevědomí nedovolí vzpomínku vztoupit do vědomí,
                         aby ochránilo stabilitu člověka."""
                ),
                PsychologyTermAnswer(
                    """rozpad paměťové stopy""",
                    false,
                    """Informaci ztratíme kompletně a permanentně. Nedá se moc dokázat experimenty."""
                ),
                PsychologyTermAnswer(
                    """interference""",
                    false,
                    """Náharada staré paměti novou. V experimentech subjekty zapomínali staré řady čísel, ale pamatovali si nové."""
                ),
            ),
            questionNumber = 5,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://images.slideplayer.cz/41/11152302/slides/slide_53.jpg",
            prompt = "Když se podíváte na obrázek pod tímto odstavcem, budete ho nejspíše vnímat jako" +
                "dvě skupiny čtyř čtverců spíše než jako osm samostatných čtverců. Který z gestaltistických zákonů vysvětluje tento způsob vnímání?\n■ ■ ■ ■   ■ ■ ■ ■",
            textAnswer = "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                "\nNěkteré věci, které řešili:" +
                "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                "\nZákon podobnosti - tendence vnímat podobné podněty jako celky.",
            answers =
            listOf(
                PsychologyTermAnswer("""zákon blízkosti""",
                    false
                ),
                PsychologyTermAnswer("""zákon stejnosti""",
                    false
                ),
                PsychologyTermAnswer("""zákon uzavřenosti""",
                    false,
                    imageExplanationUrl = "https://slideplayer.cz/slide/15246770/92/images/22/Z%C3%A1kon+uzav%C5%99enosti+N%C4%9Bkdy+vid%C3%ADme+i+to%2C+co+na+obr%C3%A1zku+nen%C3%AD..jpg"
                ),
                PsychologyTermAnswer("""zákon nepřerušeného pokračování""",
                    false
                ),
            ),
            questionNumber = 6,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Co z uvedeného je nejvíce ovlivnitelné výchovou a působením společnosti?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""temperament""",
                    false
                ),
                PsychologyTermAnswer("""inteligence""",
                    false
                ),
                PsychologyTermAnswer("""charakter""",
                    false
                ),
                PsychologyTermAnswer("""kapacita krátkodobé paměti""",
                    false
                ),
            ),
            questionNumber = 7,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Které z uvedených tvrzení je přesvědčivou kritikou behaviorismu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """behaviorismus zvláště v počátku nevyužíval vědecké metody""",
                    false
                ),
                PsychologyTermAnswer(
                    """behaviorismus nebral v úvahu emoce a myšlenky""",
                    false
                ),
                PsychologyTermAnswer("""behaviorismus podceňoval význam učení""",
                    false
                ),
                PsychologyTermAnswer(
                    """behaviorismus byl příliš závislý na metodě introspekce""",
                    false,
                    "Tohle je strukturalismus"
                ),
            ),
            questionNumber = 8,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Co psychologové zjišťují zkoumáním vlastností dvojčat (jednovaječných, dvojvaječných, vychovávaných společně a odděleně)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """podíl vlivů prostředí a genetických vlivů na vývoj""",
                    false
                ),
                PsychologyTermAnswer("""vliv výchovy na vývoj""",
                    false
                ),
                PsychologyTermAnswer(
                    """zda jde při vývoji spíše o spojitý proces změn nebo o sérii kvalitativně oddělených etap""",
                    false
                ),
                PsychologyTermAnswer("""zda existují kritická období ve vývoji""",
                    false
                ),
            ),
            questionNumber = 9,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Metodou dichotického poslechu (do každého ucha je pomocí sluchátek pouštěn rozdílný soubor podnětů) se v psychologii nejčastěji zkoumá""",
            textAnswer = "Dichotický poslech je psychologický test běžně používaný k vyšetřování selektivní pozornost a lateralizace funkce mozku v rámci sluchový systém." +
                "Používá se v polích kognitivní psychologie a neurovědy.",
            answers =
            listOf(
                PsychologyTermAnswer("""selektivní pozornost""",
                    false
                ),
                PsychologyTermAnswer("""schopnost zachytit vysoké tóny""",
                    false
                ),
                PsychologyTermAnswer("""fáze procesu sluchového vnímání""",
                    false
                ),
                PsychologyTermAnswer("""kapacita krátkodobé paměti""",
                    false
                ),
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Jaký je hlavní rozdíl mezi jednáním a chováním?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""jednání vyžaduje přítomnost druhých osob""",
                    false
                ),
                PsychologyTermAnswer("""chování může být pozorováno""",
                    false
                ),
                PsychologyTermAnswer("""jednání je cílené""",
                    false
                ),
                PsychologyTermAnswer(
                    """cílem jednání je vyrovnat se s požadavky okolí""",
                    false
                ),
            ),
            questionNumber = 11,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Které z uvedených tvrzení nejlépe vystihuje závěry Milgramovy studie poslušnosti vůči autoritě?""",
            textAnswer = "Elektrické šoky",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Američané na rozdíl od Němců autoritě nepodléhají a odmítají poslušnost, pokud je proti jejich přesvědčení.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Většina lidí tvrdí, že autoritu poslechnou, ale ve skutečnosti hledají způsoby, jak se vyhnout plnění příkazů autority.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Většina lidí poslechne neškodné příkazy, ale odmítají poslušnost, pokud by měli někomu ublížit.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Většina lidí poslechne příkazy i v případě, pokud by měli někomu ublížit.""",
                    false
                ),
            ),
            questionNumber = 12,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Weberova konstanta pro koncentraci pachového podnětu je 0,07 a pro koncentraci chuťového podnětu 0,20. Z toho vyplývá, že přidáme-li do jídla koření,""",
            textAnswer = "Kde k je Weberova konstanta, I intenzita podnětu a ΔI přírůstek podnětu." +
                " Weberův zákon říká, že čím menší je hodnota konstanty, tím je potřeba menšího přírůstku, aby smyslový orgán zaregistroval změnu intenzity podnětu.",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """zaznamenáme rozdíl čichem dříve než chutí""",
                    false,
                    "Frekvence zvuku 0,003\n" +
                        "Intenzita zvuku 0,15\n" +
                        "Intenzita světla 0,01\n" +
                        "Koncentrace pachového podnětu 0,07\n" +
                        "Koncentrace chuťového podnětu 0,20\n" +
                        "Intenzita tlakového podnětu 0,14"
                ),
                PsychologyTermAnswer(
                    """zaznamenáme rozdíl chutí dříve než čichem""",
                    false
                ),
                PsychologyTermAnswer(
                    """zaznamenáme rozdíl vpodstatě současně (Weberova konstanta se vztahuje k jiným aspektům vnímání)""",
                    false
                ),
                PsychologyTermAnswer("""nelze určit""",
                    false
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Psycholog provádí zkoumání pozornosti u dětí; " +
                "začne testovat skupinu dětí brzy po narození. Testování opakuje ve věku 3 měsíců," +
                " 6 měsíců, 1 roku a 2 let. Jaký přístup používá?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """průřezový přístup""",
                    false,
                    "Cross-sectional, typ longitudinální přístupu. Porovnáme skupiny ruzných věků (rychlejší způsob, ale horší)."
                ),
                PsychologyTermAnswer("""longitudinální přístup""",
                    false
                ),
                PsychologyTermAnswer(
                    """kohortový přístup""",
                    false,
                    "Kohorta - skupina osob v populaci, která má nějakou společnou charakteristiku (aniž by tvořily sociální skupinu)"
                ),
                PsychologyTermAnswer("""biografický přístup""",
                    false,
                    "Kvalitativní výzkum. Zkoumáme biografie lidí."
                ),
            ),
            questionNumber = 14,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených psychologů nepatří mezi ostatní (z hlediska psychologického směru, ke kterému se řadí)?""",
            textAnswer = "Neopsychoanalýza - inspirováno Freudem.",
            answers =
            listOf(
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
                PsychologyTermAnswer("""H. S. Sullivan""",
                    false,
                    "Společně s K. Horney představitel neopsychoanalýzy (neoFreudismus) a vztahu dítěte a matky" +
                        "\nTenze = a) Nedostatečná fyz. satisfakce od matky b) Úzkost, z úzkostné matky" +
                        "\nOsobnost je výsledek interpersonálních vztahů," +
                        "\nDynamismus - vzorec transformace energie"
                ),
                PsychologyTermAnswer("""A. Maslow""", false, "Humanismus, transpersonální psychologie"),
            ),
            questionNumber = 15,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Představte si, že odborník v kognitivní psychologii chce zkoumat studenty ve vaší třídě. Kterou z uvedených otázek by jim pravděpodobně položil?""",
            textAnswer = "zkoumá způsob vnímání a zpracování informací dodaných smyslovými orgány",
            answers =
            listOf(
                PsychologyTermAnswer("""jak vycházíte se svými učiteli?""",
                    false
                ),
                PsychologyTermAnswer("""jaké jsou vaše životní cíle?""",
                    false
                ),
                PsychologyTermAnswer(
                    """objevily se u vás někdy příznaky duševní poruchy?""",
                    false
                ),
                PsychologyTermAnswer(
                    """jakým způsobem se připravujete a učíte na písemku?""",
                    false
                ),
            ),
            questionNumber = 16,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Většina lidí si nedokáže vybavit, co dělali např. 28. března 2001 odpoledne," +
                " ale mnoho lidí si pamatuje, kde se nacházeli a co dělali 11. září 2001 ve chvíli, " +
                "kdy se dozvěděli o teroristickém útoku v New Yorku. Jak psychologové označují tento typ vzpomínek?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""kontextové vzpomínky""",
                    false
                ),
                PsychologyTermAnswer("""implicitní vzpomínky""",
                    false
                ),
                PsychologyTermAnswer("""zábleskové vzpomínky""",
                    false
                ),
                PsychologyTermAnswer("""anterográdní vzpomínky""",
                    false
                ),
            ),
            questionNumber = 17,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Výzkumník se snaží experimentálně zjistit, jaký má metoda výuky čtení vliv na rychlost čtení na konci prvního ročníku. " +
                "Co je v tomto experimentu rychlost čtení?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """závislá proměnná""",
                    false,
                    "očekáváme změny na základě změn v nezávislých proměnných"
                ),
                PsychologyTermAnswer(
                    """nezávislá proměnná""",
                    false,
                    "hodnota, kterou můžeme účelově měnit"
                ),
                PsychologyTermAnswer("""kontrolní proměnná""",
                    false
                ),
                PsychologyTermAnswer("""intervenující proměnná""",
                    false,
                    "rušivá proměnná, které se snažíme zbavit"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Které z uvedených tvrzení neplatí o fenomenologickém přístupu ke studiu osobnosti?""",
            textAnswer = "Nedeterministcká - svodobná volba, introspekce. E. Husserl, M. Heideggar - filosoficky-humanistický směr. Chtěli přivést zpět vědockost, naše zkušenost je známá jen nám (Rogers)",
            answers =
            listOf(
                PsychologyTermAnswer("""jednou z hlavních metod je introspekce""",
                    false
                ),
                PsychologyTermAnswer("""zabývá se predikcí chování jedince""",
                    false
                ),
                PsychologyTermAnswer(
                    """zaměřuje se na subjektivní zkušenost jedince""",
                    false
                ),
                PsychologyTermAnswer(
                    """zdůrazňuje spíše pozitivní, optimistický pohled na osobnost""",
                    false
                ),
            ),
            questionNumber = 19,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Přítomnost bludů je charakteristická pro""",
            textAnswer = "Blud - nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech",
            answers =
            listOf(
                PsychologyTermAnswer("""neurózy""",
                    false,
                    "duševní nerovnováha -> duševní stres, tíseň (fobie)"
                ),
                PsychologyTermAnswer("""psychózy""",
                    false,
                    "chybné vnímání myšlenek a smyslových vjemů - vnímání reality"
                ),
                PsychologyTermAnswer("""úzkostné poruchy""",
                    false
                ),
                PsychologyTermAnswer("""poruchy osobnosti""",
                    false
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Bedřich dostal při zkoušce z angličtiny čtyřku, ačkoli měl pocit," +
            " že si svým výkonem zasloužil dvojku. Když se odpoledne vrátil domů," +
            " pohádal se kvůli maličkosti s mladším bratrem a dal mu facku." +
            " Který mechanismus může vysvětlovat Bedřichovo chování?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """projekce""",
                    false,
                    """Když se snažíme negativního pocitu zbavit pomocí reflektování daných negativních atributů/faktů na okolí a lidi okolo.
                        Například jsme kritizováni za to, že v hádce křičíme. To nás naštve a hned si začneme všímat a rozpomínat momentů, kdy druhá osoba kříčí, či křičela také.
                    """
                ),
                PsychologyTermAnswer(
                    """přesunutí""",
                    false,
                    """
                        Pokud se nám něco nedaří a tvoří to moc negativní pocit, začneme zaměřovat na něco jiného, či úplně nového, což nás pocitu zbaví.
                        Velmi časté v hádkách, kdy se přesuneme na nějaký nedostatek druhé osoby místo toho, abychom konfrontovali negativní informaci o nás.
                    """
                ),
                PsychologyTermAnswer(
                    """vytěsnění""",
                    false,
                    """Ignorování určité informace. Pokud si matka všimne něčeho negativního o svém dítěti,
                         často informaci popře, protože má v hlavě idealistický obraz dítěte. Negativní atribut/fakt tento obraz kazí, ignoruje jej tedy."""
                ),
                PsychologyTermAnswer(
                    """popření""",
                    false,
                    """Přinutíme obrácení myšlení. Pokud matka slyší něco negativního o svém dítěti,
                         často informaci vytěsní, protože má v hlavě idealistický obraz dítěte. Negativní atribut/fakt tento obraz kazí, chce se jej tedy zbavit."""
                ),
            ),
            questionNumber = 21,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Tělesné poruchy, u kterých se předpokládá rozhodující úloha emocí, se označují jako""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychosomatické poruchy""",
                    false
                ),
                PsychologyTermAnswer("""emocionální poruchy""",
                    false
                ),
                PsychologyTermAnswer("""fyziologické poruchy""",
                    false
                ),
                PsychologyTermAnswer("""posttraumatické stresové poruchy""",
                    false
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Asociální porucha osobnosti se vyskytuje""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""stejně často u mužů i žen""",
                    false
                ),
                PsychologyTermAnswer("""častěji u žen než u mužů""",
                    false
                ),
                PsychologyTermAnswer("""častěji u mužů než u žen""",
                    false
                ),
                PsychologyTermAnswer(
                    """v mladším věku častěji u mužů, později častěji u žen""",
                    false
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Který systém ve Freudově pojetí osobnosti představuje zvnitřněnou reprezentaci hodnot a morálky společnosti?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""ego""",
                    false
                ),
                PsychologyTermAnswer("""superego""",
                    false
                ),
                PsychologyTermAnswer("""id""",
                    false
                ),
                PsychologyTermAnswer(
                    """taková složka ve Freudově pojetí osobnosti není přítomna, člověk se podle něj řídí výhradně principem slasti""",
                    false
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Jak se označují nástroje hodnocení v psychologii, u nichž jsou testové podněty nejednoznačné a předpokládá se," +
                " že do nich jedinec promítne svou osobnost, svá přání a motivy?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""projektivní testy""",
                    false
                ),
                PsychologyTermAnswer("""osobnostní dotazníky""",
                    false
                ),
                PsychologyTermAnswer("""výkonové testy""",
                    false,
                    "Mají správné a špatné odpovědi, např. test inteligence či vědomostí."
                ),
                PsychologyTermAnswer("""testy organicity""",
                    false,
                    "Grassiho test organicity - psychomotorické tempo, kognitivní schopnosti s relací na IQ"
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Co mají společného gradient struktury, překrývání, relativní velikost a lineární perspektiva?""",
            textAnswer = "Monokulární vodítka: \n" +
                "\n\t1. Interpozice - překrývání objektů v percepčním poli (bližší objekty překrývají ty vzdálenější)." +
                "\n\t2. Lineární perspektiva - přibližování rovnoběžných linií ve větší vzdálenosti." +
                "\n\t3. Atmosférická perspektiva - vzdálené objekty vidíme hůře v bleších barvách (kouř, prach, smog)" +
                "\n\t4. Relativní velikost - u 2 známých předmětů, menší vnímáme jako vzdálenejší." +
                "\n\t5. Relativní Výška - objekt, který je výš je vnímán jakoi vzdálenější" +
                "\n\t6. Gradient (spád) struktury (Gibson) - přejíždíme-li zrakem po určité scenérii – dochází ke změnám vnímané členitosti povrchu." +
                "\n\t7. Pohybová relaxa - rychlost a směr vozidel, které vidíme když jsme sami v jedoucím vozidle",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """jsou to procesy vnímání vyžadující koordinaci obou očí""",
                    false
                ),
                PsychologyTermAnswer(
                    """jsou to klíče vnímání vzdálenosti objektů""",
                    false
                ),
                PsychologyTermAnswer(
                    """jsou to techniky pro rozlišení figury a pozadí""",
                    false
                ),
                PsychologyTermAnswer(
                    """jsou to metody pro odhad rychlosti rychle se pohybujících předmětů""",
                    false
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Piagetova teorie předpokládá čtyři stadia vývoje. Jaký druh vývoje Piaget popisuje?""",
            textAnswer = "Senzomotorická inteligence (0-2 roky):" +
                "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                " Strange situation study - attachment styly." +
                "\n\nPředoperační (symbolické, předpojmové) stadium (3-6 let):" +
                "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                "\n\nStadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                "\n\nStadium formálních operací (12+)" +
                "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení",
            answers =
            listOf(
                PsychologyTermAnswer("""emocionální""",
                    false
                ),
                PsychologyTermAnswer("""kognitivní""",
                    false
                ),
                PsychologyTermAnswer("""motorický""",
                    false
                ),
                PsychologyTermAnswer("""sociální""",
                    false
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Anonymní alkoholici jsou příkladem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""kognitivně behaviorální terapie""",
                    false,
                    "KBT - stoicismus - nejde o svět okolo nás, ale jak ten svět okolo nás vnímáme." +
                        "\nTedy jsme se něco naučili špatně a KBT se snaží nás to naučit správně."
                ),
                PsychologyTermAnswer("""svépomocné skupiny""",
                    false
                ),
                PsychologyTermAnswer(
                    """léčby závislostí pomocí averzivní terapie""",
                    false
                ),
                PsychologyTermAnswer(
                    """léčby závislostí pomocí behaviorální terapie""",
                    false
                ),
            ),
            questionNumber = 28,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Teorie kognitivní disonance se používá k vysvětlení""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""změny postojů""",
                    false
                ),
                PsychologyTermAnswer("""konstruktivní povahy vnímání""",
                    false
                ),
                PsychologyTermAnswer("""vzniku poruch osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """selhání při vybavování informací z dlouhodobé paměti""",
                    false
                ),
            ),
            questionNumber = 29,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Psychoanalýza vykládá agresi jako""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""výsledek sociálního učení""",
                    false
                ),
                PsychologyTermAnswer(
                    """důsledek frustrace (tzv. hypotéza frustrace-agrese)""",
                    false,
                    "Skupina z Yale (J. Dollard, N. E. Miller) - Frustrace navozuje pohotovost k agresi, ale její projev závisí na dalších okolnostech"
                ),
                PsychologyTermAnswer("""důsledek poruch raného vývoje""",
                    false
                ),
                PsychologyTermAnswer("""vrozený pud""",
                    false,
                    "id"
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Podle které teorie je základem učení pozitivní a negativní zpevnění?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""teorie klasického podmiňování""",
                    false,
                    "Pavlov"
                ),
                PsychologyTermAnswer("""teorie operantního podmiňování""",
                    false,
                    "Skinner"
                ),
                PsychologyTermAnswer("""teorie sociálního učení""",
                    false
                ),
                PsychologyTermAnswer("""teorie inovačního učení""",
                    false
                ),
            ),
            questionNumber = 31,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Psycholog předloží skupině osob tři seznamy k zapamatování." +
                " Všechny obsahují stejný počet prvků, ale jeden je tvořen slovy s abstraktním významem," +
                " druhý slovy s konkrétním významem a třetí obrázky předmětů. Který seznam si většina osob zapamatuje nejlépe?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""slova s abstraktním významem""",
                    false
                ),
                PsychologyTermAnswer("""slova s konkrétním významem""",
                    false
                ),
                PsychologyTermAnswer("""obrázky předmětů""",
                    false
                ),
                PsychologyTermAnswer(
                    """druh materiálu k zapamatování není rozhodující""",
                    false
                ),
            ),
            questionNumber = 32,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Co se označuje termínem brainstorming?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """technika stimulace tvořivého myšlení při řešení konkrétního problému ve skupině""",
                    false
                ),
                PsychologyTermAnswer("""jedna z metod měření inteligence""",
                    false
                ),
                PsychologyTermAnswer(
                    """stav mozku po doznění epileptického záchvatu""",
                    false
                ),
                PsychologyTermAnswer(
                    """technika potlačení kritického uvažování a násilného přijetí vnucených názorů""",
                    false
                ),
            ),
            questionNumber = 33,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Na základě experimentu v amerických základních školách bylo zjištěno," +
                " že chování a výkon dětí mohou být ovlivněny tím," +
                " co od nich učitelé očekávají. Jak se tento jev označuje?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""haló efekt""",
                    false
                ),
                PsychologyTermAnswer("""atribuční chyba""",
                    false,
                    "Máme tendenci přeceňovat dispoziční příčiny v našich selhání, ale charakterové příčiny když se jedná o někoho jiného."
                ),
                PsychologyTermAnswer("""Pygmalion efekt""",
                    false,
                    "Sebenaplňující se proroctví. Pygmalion efekt - pozitivní. Golem efekt - negativní."
                ),
                PsychologyTermAnswer("""projekce""",
                    false
                ),
            ),
            questionNumber = 34,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Mezi Jungovy archetypy nepatří""",
            textAnswer = "Persona - zachování individualismu" +
                "\nAnimus a anima - pomáhá a chápat svojí pohlaví, ukazuje se jako opačné pohlaví" +
                "\nStín - zvířecí, tendence primitivním formám života" +
                "\nAnalytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar.",
            answers = listOf(
                PsychologyTermAnswer("""anima/animus""",
                    false
                ),
                PsychologyTermAnswer("""persona""",
                    false
                ),
                PsychologyTermAnswer("""stín""",
                    false
                ),
                PsychologyTermAnswer("""světlo""",
                    false
                ),
            ),
            questionNumber = 35,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Honza je značně rozrušený a stále aktivní." +
                " Neustále mluví, žene se z jedné činnosti do druhé, stačí mu spát jen pár hodin denně," +
                " spřádá velké plány a málo se stará o to, jestli jsou reálné. Jakou poruchou nejpravděpodobněji trpí?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""panickou poruchou""",
                    false
                ),
                PsychologyTermAnswer("""schizofrenií""",
                    false
                ),
                PsychologyTermAnswer("""depresí""",
                    false
                ),
                PsychologyTermAnswer("""mánií""",
                    false
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Jak etologové označují podnět z prostředí, " +
                "který vyvolává chování specifické pro určitý druh (např. u mořských racků vyvolá červená nebo žlutá skvrna na zobáku matky reakci klování)?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""podnět pro vtištění""",
                    false
                ),
                PsychologyTermAnswer("""reflex""",
                    false
                ),
                PsychologyTermAnswer("""modelový podnět""",
                    false
                ),
                PsychologyTermAnswer("""spouštěč""",
                    false
                ),
            ),
            questionNumber = 37,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Návrat na nižší vývojovou úroveň se nazývá""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""retardace""",
                    false
                ),
                PsychologyTermAnswer("""abreakce""",
                    false
                ),
                PsychologyTermAnswer(
                    """regrese""",
                    false,
                    "Nevědomý obranný mechanizmus. Únik na vývojově nižší úroveň chování."
                ),
                PsychologyTermAnswer("""redukce""",
                    false
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Alice se ráno probudila zvoněním budíku." +
                " Právě se jí zdál barevný, živý sen, plný různých nelogických událostí." +
                " V jaké fázi spánku se v okamžiku zvonění budíku pravděpodobně nacházela?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""v REM fázi""",
                    false
                ),
                PsychologyTermAnswer("""v nREM fázi""",
                    false,
                    "non-rapid eye movement"
                ),
                PsychologyTermAnswer(
                    """je stejně pravděpodobné, že se nacházela v REM fázi i že se nacházela v nREM fázi""",
                    false
                ),
                PsychologyTermAnswer("""v relaxační fázi""",
                    false
                ),
            ),
            questionNumber = 39,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Jakým souhrnným termínem označujeme proces," +
                " kterým se realizuje postupné vrůstání jedince do společnosti," +
                " jeho postupné začleňování do soustavy společenských pozic a jim odpovídajících společenských rolí?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""socializace""",
                    false
                ),
                PsychologyTermAnswer("""hierarchizace""",
                    false
                ),
                PsychologyTermAnswer("""výchova""",
                    false
                ),
                PsychologyTermAnswer("""sociální interakce""",
                    false
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Monika leží v posteli a hluboce spí." +
                " Venku začne bouřka a Monika je náhle probuzena hlasitým zahřměním." +
                " Která část jejího mozku ji probudila?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""mozeček""",
                    false,
                    "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky"
                ),
                PsychologyTermAnswer("""retikulární formace""",
                    false,
                    "Retikulární formace prostupuje mozkovým kmenem, " +
                        "pokračuje do thalamu a hypothalamu, kaudálně navazuje na propriospinální míšní síť.\nFunkce: " +
                        "-senzitivní, motorická a autonomní funkce, složité reflexy\n" +
                        "- centrum řízení dýchání, kardiovaskulární soustavy, vazomotoriky, spánku, bdění"
                ),
                PsychologyTermAnswer("""hypothalamus""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
                PsychologyTermAnswer("""hipokampus""",
                    false,
                    "Pamět, zvětšuje se když se hodně učí a zmenšuje když máš např. deprese"
                ),
            ),
            questionNumber = 41,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Jaká je pravděpodobnost, že se páru, kde žena má krevní skupinu 0 a muž krevní skupinu AB, narodí dítě s krevní skupinou A?""",
            textAnswer = "0 je recesivní, A a B jsou dominantní. Nejpravděpodobnější jsou A a B u dítěte, potom máme fakt malou šanci na AB či 0.",
            answers =
            listOf(
                PsychologyTermAnswer("""0%""",
                    false
                ),
                PsychologyTermAnswer("""25%""",
                    false
                ),
                PsychologyTermAnswer("""50%""",
                    false
                ),
                PsychologyTermAnswer("""75%""",
                    false
                ),
            ),
            questionNumber = 42,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Ve které fázi mitózy se vytváří dělící vřeténko?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""v profázi""",
                    false
                ),
                PsychologyTermAnswer("""v metafázi""",
                    false
                ),
                PsychologyTermAnswer("""v anafázi""",
                    false
                ),
                PsychologyTermAnswer("""v telofázi""",
                    false
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Která část mozku reguluje uvolňování hormonů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""retikulární formace""",
                    false,
                    "Retikulární formace prostupuje mozkovým kmenem, " +
                        "pokračuje do thalamu a hypothalamu, kaudálně navazuje na propriospinální míšní síť.\nFunkce: " +
                        "-senzitivní, motorická a autonomní funkce, složité reflexy\n" +
                        "- centrum řízení dýchání, kardiovaskulární soustavy, vazomotoriky, spánku, bdění"
                ),
                PsychologyTermAnswer("""hipokampus""",
                    false,
                    "Paměť"
                ),
                PsychologyTermAnswer("""mozkový kmen""",
                    false,
                    "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                        "\nSkládá se z středního mozku, mostu a prodloužené míchy." +
                        "\nVšechny dráhy do a z mozku."
                ),
                PsychologyTermAnswer("""hypothalamus""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
            ),
            questionNumber = 44,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Od kterého týdne prenatálního vývoje hovoříme o plodu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""přibližně od třetího týdne""",
                    false
                ),
                PsychologyTermAnswer("""přibližně od pátého týdne""",
                    false
                ),
                PsychologyTermAnswer("""přibližně od devátého týdne""",
                    false
                ),
                PsychologyTermAnswer("""přibližně od dvacátého týdne""",
                    false
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://wikisofia.cz/w/images/6/69/Rez_okem.jpg",
            prompt = """Které místo na sítnici zajišťuje nejostřejší vidění?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""slepá skvrna""",
                    false
                ),
                PsychologyTermAnswer("""místo, kde vstupuje do oka zrakový nerv""",
                    false
                ),
                PsychologyTermAnswer(
                    """oblast kolem spojnice žluté a slepé skvrny""",
                    false
                ),
                PsychologyTermAnswer("""centrální jamka uprostřed žluté skvrny""",
                    false
                ),
            ),
            questionNumber = 46,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Vzájemný podíl mezi dědičnou a nedědičnou složkou proměnlivosti kvantitativního znaku vyjadřuje""",
            textAnswer = "Když se ve zprávách mluví o tom, že se našel gen, který \"způsobuje depres\", tak mluví o tomhle. Ten gen se nemusí projevit." +
                " Projevení je \"citlivější\", pokud se tam ten gen vyskytuje - tedy třeba vyšší pravděpodobnost, že osoba dostane deprese. Není kauzální.",
            answers =
            listOf(
                PsychologyTermAnswer("""dědičnost""",
                    false
                ),
                PsychologyTermAnswer("""koeficient variability""",
                    false
                ),
                PsychologyTermAnswer("""dědivost""",
                    false
                ),
                PsychologyTermAnswer("""koeficient proměnlivosti""",
                    false
                ),
            ),
            questionNumber = 47,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Věnčité tepny zásobují krví""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""plíce""",
                    false
                ),
                PsychologyTermAnswer("""srdeční sval""",
                    false
                ),
                PsychologyTermAnswer("""kosterní svaly""",
                    false
                ),
                PsychologyTermAnswer("""trávící soustavu""",
                    false
                ),
            ),
            questionNumber = 48,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Která část neuronu předává informace dalším neuronům?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""tělo neuronu""",
                    false
                ),
                PsychologyTermAnswer("""axon""",
                    false
                ),
                PsychologyTermAnswer("""dendrity""",
                    false
                ),
                PsychologyTermAnswer("""jádro neuronu""",
                    false
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = "Která část mozku hraje u většiny lidí největší roli v situaci, kdy si čtou otázku a snaží se ji zodpovědět?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pravá hemisféra""",
                    false
                ),
                PsychologyTermAnswer("""levá hemisféra""",
                    false
                ),
                PsychologyTermAnswer("""mozeček""",
                    false,
                    "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky"
                ),
                PsychologyTermAnswer("""mozkový kmen""",
                    false,
                    "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                        "\nSkládá se z středního mozku, mostu a prodloužené míchy." +
                        "\nVšechny dráhy do a z mozku."
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Langerhansovy ostrůvky produkují""",
            textAnswer = "Buňky Beta (70% obsahu) - inzulin" +
                "\nBuňky alfa (20%) - glukagon" +
                "\nBuňky delta (5%) - somatostatin",
            answers =
            listOf(
                PsychologyTermAnswer("""růstový hormon""",
                    false
                ),
                PsychologyTermAnswer("""adrenalin""",
                    false,
                    "aktivace, spánek, probuzení, sympatický NS"
                ),
                PsychologyTermAnswer("""inzulin""",
                    false
                ),
                PsychologyTermAnswer("""tyroxin""",
                    false
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Množství červených krvinek v krvi při nedostatku kyslíku""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""roste""",
                    false
                ),
                PsychologyTermAnswer("""klesá""",
                    false
                ),
                PsychologyTermAnswer("""nemění se""",
                    false
                ),
                PsychologyTermAnswer(
                    """nemění se, ale roste velikost červených krvinek""",
                    false
                ),
            ),
            questionNumber = 52,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Které vitamíny patří mezi vitamíny rozpustné v tucích?""",
            textAnswer = "(Z) A D E K",
            answers = listOf(
                PsychologyTermAnswer("""vitamíny D, E a C""",
                    false
                ),
                PsychologyTermAnswer("""vitamíny A, C a vitamíny skupiny B""",
                    false
                ),
                PsychologyTermAnswer("""vitamíny A, D a E""",
                    false
                ),
                PsychologyTermAnswer("""vitamíny C, E a vitamíny skupiny B""",
                    false
                ),
            ),
            questionNumber = 53,
            correctAnswer = 2,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Co je hlavní funkcí tlustého střeva?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""štěpení bílkovin""",
                    false
                ),
                PsychologyTermAnswer("""štěpení tuků""",
                    false
                ),
                PsychologyTermAnswer("""štěpení sacharidů""",
                    false
                ),
                PsychologyTermAnswer("""zpětná resorpce vody""",
                    false
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Který jev označujeme termínem fagocytóza?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """schopnost bílých krvinek pohlcovat choroboplodné mikroorganismy, mrtvé buňky a jiné částice""",
                    false
                ),
                PsychologyTermAnswer(
                    """schopnost červených krvinek transportovat kyslík""",
                    false
                ),
                PsychologyTermAnswer("""nekontrolovaný růst buněk""",
                    false
                ),
                PsychologyTermAnswer(
                    """působení krevních destiček při srážení krve""",
                    false
                ),
            ),
            questionNumber = 55,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Jakou hlavní funkci plní neuroglie?""",
            textAnswer = "Centrální:" +
                "\n\t1) Makroglie: " +
                "\n\t\tAstrocyty - regenerace a výživa" +
                "\n\t\tOligodendroglie - tvoří myelin" +
                "\n\t2) Mikroglie - čistí, hojí" +
                "\nPeriferní:" +
                "\n\tSchwannovy buňky - stejně jako Oligodendroglie, ale jen jedno vlákno" +
                "\n\tSatelitové buňky - obalují neurony v gangliích" +
                "\n\tHlasové a míšní nervy",
            answers = listOf(
                PsychologyTermAnswer("""vedou nervové vzruchy v páteřní míše""",
                    false
                ),
                PsychologyTermAnswer("""tlumí přenos nervového vzruchu""",
                    false
                ),
                PsychologyTermAnswer("""tvoří periferní nervový systém""",
                    false
                ),
                PsychologyTermAnswer(
                    """vyživují neurony a odvádějí odpadní látky metabolismu v nervové tkáni""",
                    false
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Do kdy je u dítěte zpravidla prořezán úplný mléčný chrup?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""do konce prvního roku""",
                    false
                ),
                PsychologyTermAnswer("""do konce druhého roku""",
                    false
                ),
                PsychologyTermAnswer("""do konce čtvrtého roku""",
                    false
                ),
                PsychologyTermAnswer("""v šestém roce""",
                    false
                ),
            ),
            questionNumber = 57,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        /*Tohle je biologie
        PsychologyTerm(
            prompt = """Kříženci ze vzájemného křížení rozdílně homozygotních rodičů""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """jsou homozygotní a heterozygotní v poměru 3:1""",
                    false
                ),
                PsychologyTermAnswer("""jsou vždy heterozygotní""", 
                    false
                ),
                PsychologyTermAnswer("""jsou vždy homozygotní""", 
                    false
                ),
                PsychologyTermAnswer(
                    """jsou homozygotní a heterozygotní, ale jejich poměr se nedá předem odhadnout""",
                    false
                ),
            ),
            questionNumber = 58,
            correctAnswer = 1,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),
        PsychologyTerm(
            prompt = """Nejjednodušším typem nervové soustavy je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""difúzní nervová soustava""", 
                    false
                ),
                PsychologyTermAnswer("""gangliová nervová soustava""", 
                    false
                ),
                PsychologyTermAnswer("""žebříčková nervová soustava""", 
                    false
                ),
                PsychologyTermAnswer("""trubicovitá nervová soustava""", 
                    false
                ),
            ),
            questionNumber = 59,
            correctAnswer = 0,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        ),*/
        PsychologyTerm(
            prompt = """Kterou funkci sdílejí hipokampus a amygdala (obě jsou součástí limbického systému)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""motorické dovednosti""",
                    false
                ),
                PsychologyTermAnswer("""plánování a rozhodování""",
                    false
                ),
                PsychologyTermAnswer(
                    """divergentní myšlení""",
                    false,
                    "Divergentní myšlení je sbíhavý vznik nových řešení na problém (ADHD)."
                ),
                PsychologyTermAnswer("""paměť""",
                    false,
                    "třeba PTSD"
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "Nezávislý test - PSYCHOLOGIE_XE_ENA"
        )
    )
}