package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//zrevidovano
object PsychologyHandmade {
    val psychologyPrompts = listOf(
        /*PsychologyTerm(
            prompt = "tady je otázka",
            textAnswer = "Tady je vysvětlení otázky",
            answers = listOf(
                PsychologyTermAnswer(
                    "odpověď 1",
                    explanationMessage = "vysvětlení odpovědi 1"
                ),
                PsychologyTermAnswer(
                    "odpověď 2",
                    explanationMessage = "vysvětlení odpovědi 2"
                ),
                PsychologyTermAnswer(
                    "odpověď 3",
                    explanationMessage = "vysvětlení odpovědi 3"
                ),
                PsychologyTermAnswer(
                    "odpověď 4",
                    explanationMessage = "vysvětlení odpovědi 4"
                ),
            ),
            questionNumber = číslo otázky,
            correctAnswer = index správné otázky,
            categoryId = "Obor psychologie"
        )*/
        
        
        //---------------------------------------------------------------------------------------------------------------------------------------//




        PsychologyTerm(
            prompt =
            """Mezi poměrně časté úzkostné poruchy patří obsedantně-kompulzivní porucha. Doplňte slovo místo otazníku: obsese : myšlení / kompulze : ?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""chování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nálada""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""plánování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""percepce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy 1",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Který z následujících pojmů nepatří mezi ostatní?""", 
            textAnswer = "Ostatní měří variabilitu, modus je hodnotu",
            answers =
            listOf(
                PsychologyTermAnswer("""směrodatná odchylka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""modus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozptyl""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""interkvartilové rozpětí""",
                    false,
                    "rozdíl mezi třetím a prvním kvartilem (tedy mezi 75. a 25. percentilem)"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jedním druhem psychoaktivních látek jsou tzv. stimulancia. Mezi ně nepatří""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""amfetaminy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""metadon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kofein""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kokain""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Část pracovní paměti, která slouží pro ukládání informací v akustickém kódu a pro práci s nimi, se označuje jako""", 
            textAnswer = "Model pracovní paměti" +
                "\nAllan Badeley a Hitch." +
                "\nCentrální vykonavatel - pozornost, řídíc a koordinuje pamět, nemá kapacitu." +
                "\nFonologická smyčka - infromace vyjádřené řeči." +
                "\nVizuálně-prostorový náčrtník - vizuální informace.",
            answers =
            listOf(
                PsychologyTermAnswer("""akustická metareprezentace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fonologická smyčka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vizuospaciální náčrtník""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Ve známém velkofilmu Pán prstenů bylo pro dosažení žádoucích efektů rozdílné velikosti postav (např. elfové vs trpaslíci či hobiti) kromě technik počítačové animace využito také jevu známého z kognitivní psychologie, kdy postavy blíže ke kameře se jeví být vyšší než postavy situované od kamery dále. Jak se tento efekt označuje?""", 
            textAnswer = "",
            imageAnswerUrl = "https://www.mozaweb.com/cs/mozaik3D/TER/tajekozodas/optikai_szoba/960.jpg",
            answers =
            listOf(
                PsychologyTermAnswer("""efekt Amesovy místnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt aktéra a pozorovatele""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt primarity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt Schrödingerovy kočky""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Psychologové zkoumali vývoj prvních vazeb dítěte, které mají velký dopad na jeho pozdější vývoj. Mary Ainsworthová rozlišila různé typy těchto vazeb. Která z následujících mezi ně nepatří?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vyhýbavá""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""agresivní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""jistá""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ambivalentní""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Autorem známého projektivního testu osobnosti, který tvoří tabule s oboustranně symetrickými inkoustovými skvrnami, je""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""A. Binet""",
                    false,
                    "První test inteligence (Binet-Simonova inteligenční škála)"
                ),
                PsychologyTermAnswer("""H. Rorschach""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""D. Wechsler""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""F. B. Skinner""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Zajímavým zdrojem poznatků v sociálních vědách jsou interkulturní výzkumy. Např. v první polovině 20. století byl proveden výzkum porovnávající pohlavní role u tří domorodých kmenů na ostrově Nová Guinea. Kdo je autorem/autorkou výzkumu?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Margaret Meadová""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Karen Horneyová""",
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
                PsychologyTermAnswer("""John B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""William James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Pro kterou poruchu se používá zkratka ADHD?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Aspergerův syndrom""",
                    false,
                    "DSM-5 má přímo v autistickém spektru." +
                        "\nNemá opoždění ve vývoji řeči a kognitivních schopností."
                ),
                PsychologyTermAnswer("""specifická porucha učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pervazivní vývojová porucha""",
                    false,
                    "třeba autismus"
                ),
                PsychologyTermAnswer("""porucha pozornosti s hyperaktivitou""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících autorů popsal tzv. vrcholné okamžiky, které se vyznačují prožitky štěstí a naplnění: dočasný, spontánní a nesobecký stav dosažení cíle?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Burrhus F. Skinner""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Erik Erikson""",
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
                PsychologyTermAnswer("""Abraham Maslow""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Sigmund Freud""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """V současné době je jednou z vlivných teorií osobnosti tzv. Big Five (“velká pětka”). Která z následujících nepatří mezi základní dimenze osobnosti podle této teorie?""", 
            textAnswer = "1. Otevřenost (zkušenostem)" +
                "\n2. Svědomitost - sebekontrola" +
                "\n3. Extraverze - sociabilita a aktivita lidí" +
                "\n4. Přívětivost (agreebleness) - ochota ustupovat (pomáhat) pro dobro druhých" +
                "\n5. Neuroticismus - jak jedinec prožívá negativní emoce, úzkost, náladovost",
            answers =
            listOf(
                PsychologyTermAnswer("""svědomitost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoticismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""extraverze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neuroticismus""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Londýn je hlavní město spojeného království. Česká republika má přibližně miliónů obyvatel. Uvedené věty jsou příklady obecných znalostí o světě, které je možné ostatním lidem předat pomocí sdělení. Jak se nazývá druh paměti, kde jsou tyto vědomosti uloženy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """sémantická paměť""", 
                    false
                ),
                PsychologyTermAnswer("""pracovní paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""logická paměť""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """I. P. Pavlov prováděl ve své laboratoři slavné pokusy se psy. Vypozoroval, že pokud psům nesl potravu, ti začali sami od sebe slinit. Poté, co je přemístil do jiné místnosti, rozsvítil vždy žárovku na chodbě, když je chodil krmit. Po nějaké době začali psi slinit i při pouhém rozsvícení žárovky, aniž by jim nesl žrádlo. Rozsvícení žárovky je v tomto případě považováno za:""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""reaktivní podnět""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""podmíněný podnět""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nepodmíněný podnět""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""instrumentální podnět""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Pavel je zdvořilý, pohledný a inteligentní mladý muž. Většina lidí, kteří se s Pavlem setkají poprvé předpokládá, že je i spolehlivý a svědomitý. Jak se nazývá tento efekt, kdy lidé vyvozují nepodložené závěry o vlastnostech druhých osob na základě dojmu z jedné, či několika význačných vlastností?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Pygmalion efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""haló efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Piagetův efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt sněhové koule""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Zejména se kterým jménem jsou spjaty výzkumy zaměřené na fenomén konformity s většinou?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Albert Bandura""",
                    false,
                    "Sociální učení, Bobo doll"
                ),
                PsychologyTermAnswer("""Solomon Asch""",
                    false
                ),
                PsychologyTermAnswer("""George A. Miller""",
                    false,
                    "7-+2, George Miller (1956)"
                ),
                PsychologyTermAnswer("""Gordon Allport""",
                    false,
                    "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\nFukční autonomie - že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku" +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Jak se označuje zbavení se emoce jejím silným prožitím?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""frustrace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""aktivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""katarze""",
                    false,
                    "Vnitřní očista"
                ),
                PsychologyTermAnswer("""facilitace""",
                    false,
                    "sociální facilitace - vliv přítomnosti jiných osob na výkon jedince"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Radikální verze frustrační teorie agrese formulované již ve 30. letech 20. století říká:""", 
            textAnswer = "Skupina z Yale (J. Dollard, N. E. Miller) - Frustrace navozuje pohotovost k agresi, ale její projev závisí na dalších okolnostech",
            answers =
            listOf(
                PsychologyTermAnswer("""agrese je vždy důsledkem frustrace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""frustrace a agrese spolu nesouvisí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """frustrace a agrese jsou funkcí vysokého neuroticismu patologické osobnosti""", 
                    false
                ),
                PsychologyTermAnswer(
                    """frustrace může vést k agresi, někdy ale nemusí""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Pro kterou poruchu jsou typické následující symptomy: porucha sociální interakce, narušená schopnost komunikace, trvání na rituálech a rutinních činnostech?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""porucha autistického spektra""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""paranoidní schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bipolární porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úzkostná porucha""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Čeho se týká tzv. šuplíkový (zásuvkový) efekt?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""zkoumání potlačených vzpomínek a emocí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """problematiky atribucí v sociální psychologii""", 
                    false,
                    "Lidi mají sklon informace kategorizovat do již existujících šuplíků"
                ),
                PsychologyTermAnswer("""zkoumání pracovní paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""publikování výzkumných studií""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """O kolik bodů se změní IQ u jedince mezi 10. a 15. rokem, pokud v obou časových bodech jeho mentální věk přesně odpovídá věku chronologickému?""", 
            textAnswer = "Flynn efekt - každých 10 let se IQ zvýší o 3-4 body.",
            answers =
            listOf(
                PsychologyTermAnswer("""15""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""25""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""5""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""0""",
                    false,
                    "100 by mělo být standardem, tudíž by to mělo vycházet stejně"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """V rámci evolučních strategií byla popsána výrazná tendence chovat se pozitivním, až obětujícím se způsobem ke geneticky příbuzným jedincům. V určitých situacích však bylo zaznamenáno pomáhající chování také vůči nepříbuzným jedincům za předpokladu, že existuje vysoká pravděpodobnost dlouhodobé návratnosti takového chování. Jak se toto chování označuje?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""reciproční altruismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""egoistický altruismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""principiální altruismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""empatický altruismus""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jedním z mechanismů ovlivňujících situaci na finančních trzích je i fenomén, který vyvolá ničím nepodložená zpráva. Pokud je např. v tisku situace určitého podniku neprávem označena jako riziková, i přesto může dojít k vlně prodejů akcií této společnosti a následných finančním problémům této firmy způsobených pádem hodnoty akcií a nízkou důvěrou investorů. Na základě kterého fenoménu lze vysvětlit tuto situaci?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""efekt motýlích křídel""",
                    false,
                    "I malá změna může mít velký důsledek v kaskádovitém efektu."
                ),
                PsychologyTermAnswer("""efekt prvního dojmu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt sebenaplňujícího se proroctví""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""multiplikační efekt""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """S počátky výzkumu tzv. umělé inteligence je spojen pojem:""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Sternbergova triarchická teorie inteligence""",
                    false,
                    "analytická, kreativní a praktická inteligence"
                ),
                PsychologyTermAnswer("""Rorschachův test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Turingův test""",
                    false,
                    "V jedné místnosti počítač, v druhé člověk a prostředník komunikace. " +
                        "\nPokud člověk pozná, že se jedná o počítač - slabá umělá inteligence, v opačném případě to je inteligence silná."
                ),
                PsychologyTermAnswer("""zóna proximálního vývoje""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Kdo z uvedených jako první zkoumal fenomén naučené bezmocnosti?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Lawrence Kohlberg""",
                    false,
                    "Stádie morálního vývoje" +
                        "\n1.Předkonvenční morálka" +
                        "\n\t-trest, odměna" +
                        "\n2.Konvenční morálka" +
                        "\n\t-chce být hodný kluk/hodná holka, autorita - zákony, pravidla" +
                        "\n3.Postkonvenční (autonomní, hyperkonvenční, principiální 25%) morálka" +
                        "\n\t-společenská smlouva, balance mezi univerzálními a osobními etickými principy"
                ),
                PsychologyTermAnswer("""Lev S. Vygotskij""",
                    false,
                    "Kognitivní vývoj, sociokulturní teorie učení - vlivy při učení a vývoji, \"Sami sebou se stáváme skrze druhé\", " +
                        "problematika učení handicapovaných dětí." +
                        "\nKulturní kapitál - předané bohatsví" +
                        "\nKulturní nástroje - počítač, telefon, kolo - jazyk je esenciální" +
                        "\nMediace - dospělí pomáhají vnímat svět" +
                        "\nApropriace - učení jak používat nástrje, řeč apod." +
                        "\nInternalizace - zakomponování do osobní psyché" +
                        "\nLešení (scaffolding) - znalosti se musí pokládat na sebe (nemůže začít od vrchu tudíž)" +
                        "\nZóna proximálního vývoje - soubor věcí co dítě umí, co dítě umí udělat s pomocí, a věcí které není schopno dělat."
                ),
                PsychologyTermAnswer("""Martin Seligman""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Albert Bandura""",
                    false,
                    "Sociální učení, Bobo doll"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Která z následujících vlastností je klíčová pro rozlišení jednotlivých druhů temperamentu?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""fluidní inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rychlost a intenzita reakcí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""motivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""charakter""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Efekt přihlížejícího (autoři Latané a Darley) bývá někdy označován také jako:""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""efekt skupinové polarizace""",
                    false,
                    "posun skupiny k extrému"
                ),
                PsychologyTermAnswer("""efekt Kitty Genovese""",
                    false,
                    "Vražda v New Yorku, kde nikdo nezasáhl"
                ),
                PsychologyTermAnswer("""haló efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""koktejl párty fenomén""",
                    false,
                    "Dokážeme odfiltrovat ostatní podněty/stimuli pokud se soustředíme na jeden konkrétní. Například konverzace v klubu."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Ve kterém stádiu podle Piagetovy teorie kognitivního vývoje dokáže člověk uvažovat v čistě symbolických pojmech?""", 
            textAnswer = "1.Senzomotorická inteligence (0-2 roky):" +
                "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                " Strange situation study - attachment styly." +
                "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                "\n\n4.Stadium formálních operací (12+)" +
                "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení",
            answers =
            listOf(
                PsychologyTermAnswer("""ve stadiu konkrétních operací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v předoperačním stadiu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve stadiu formálních operací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v senzomotorickém stadiu""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Projektivní testy, které spočívají v prezentaci mnohoznačných obrázků (např. Rorschachův test či TAT) jsou určeny primárně k diagnostice:""", 
            textAnswer = "Tematický apercepční test - nejdominantnější hned po Rorschahovu testu. 32 černobílých obrázků s nejednoznačnými situacemi.",
            answers =
            listOf(
                PsychologyTermAnswer("""pozornosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""paměti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Co je to základní atribuční chyba?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """tendence v rámci připisování příčin vlastnímu chování, kdy se necháváme ovlivnit názory a chováním druhých lidí""", 
                    false
                ),
                PsychologyTermAnswer(
                    """tendence přisuzovat vlastnímu neúspěšnému chování dispoziční příčiny a vlastnímu úspěšnému chování situační příčiny""", 
                    false
                ),
                PsychologyTermAnswer(
                    """tendence vnímat příslušníky vlastní skupiny v lepším světle než příslušníky skupiny, ke které nepatříme""", 
                    false
                ),
                PsychologyTermAnswer(
                    """tendence projevující se při usuzování na příčiny chování druhých lidí, při níž nadhodnocujeme význam osobních dispozičních faktorů a podhodnocujeme význam faktorů situačních""", 
                    false
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Mezi humanistické psychoterapie patří:""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychoterapie Alberta Ellise""",
                    false,
                    "kognitivně behaviorální"
                ),
                PsychologyTermAnswer("""kognitivně-behaviorální psychoterapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoterapie Carla R. Rogerse""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících pojmů označuje léky zmírňující příznaky schizofrenie?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""anxiolytika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neuroleptika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""stimulancia""",
                    false,
                    "ADHD a narkolepsie\n" +
                        "Stimulant - zvýšení aktivity mozku a NS."
                ),
                PsychologyTermAnswer("""inhibitory monoaminooxidázy""",
                    false,
                    "MAOI - skupina léků používaných jako antidepresiva"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Který z následujících pojmů nesouvisí s poruchami spánku?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""narkolepsie""",
                    false,
                    "Člověk není schopen regulovat cyklus spánku a bdění"
                ),
                PsychologyTermAnswer("""insomnie""",
                    false,
                    "nespavost"
                ),
                PsychologyTermAnswer("""abulie""",
                    false,
                    "nedostatek vůle"
                ),
                PsychologyTermAnswer("""apnoe""",
                    false,
                    "Zástava dechu v spánku"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Kdy v psychologii nastal tzv. kognitivní obrat či revoluce?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """souběžně se vzestupem behaviorismu v první polovině 20. století""", 
                    false
                ),
                PsychologyTermAnswer(
                    """v padesátých až sedmdesátých letech 20. století""", 
                    false,
                    "Např. George Miller 1956 - magické číslo 7"
                ),
                PsychologyTermAnswer("""na přelomu 19. a 20. století""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na přelomu 20. a 21. století""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Ačkoli byli výrazně ovlivněni učením Sigmunda Freuda, v důležitých aspektech se od něj ve svých teoriích odlišovali. Kdo z následujících autorů do této skupiny nepatří?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Alfred Adler""",
                    false,
                    "Komplex méněcennosti, Neopsychoanalitika, styl žití naučen v 4-5 (drive). Individuální psychologie." +
                        "Pořadí narození:" +
                        "\n\t- Prvorozený - dostává všechnu pozornost do doby, kdy se narodí další - přišel o trůn. Benefituje z moci, je problémový. Snaží se dosáhnout co nejvíce, organizovaní." +
                        " Pokud selže v tom být nejlepší jsou si nejistí." +
                        "\n\t- Druhorozený - tolik mu nezáleží na rodičích, rodiče se tak nesnaží. Prvorození je pro něj model (může si připadat méněcenný a závidet), může být" +
                        " ctižádostivý a ambiciózní nebo úplný opak." +
                        "\n\t- Nejmladší - starší jako modely, velmi rychlý vývoj, buďto jsou hodně závislý na ostatních nebo chtějí dosahovat věcí."
                ),
                PsychologyTermAnswer("""Karen Horneyová""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""William James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer("""Carl Gustav Jung""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Krátkodobá paměť uchovává informace:""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""v řádu dní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v řádu sekund""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v řádu minut""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v řádu hodin""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Gibsonova teorie přímého vnímání se zabývá:""", 
            textAnswer = "J. Gibson, Ekologická teorie vnímání - informace pro přesné vnímání jsou již součástí podnětu." +
                "\nNapř. Gradient (spád) struktury - přejíždíme-li zrakem po určité scenérii – dochází ke změnám vnímané členitosti povrchu,....",
            answers =
            listOf(
                PsychologyTermAnswer("""hmatovým vnímáním""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""chuťovým vnímáním""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sluchovým vnímáním""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zrakovým vnímáním""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Následující pojmy popisují jevy typické pro obsedantně-kompulzivní poruchu. Který ale mezi ně nepatří?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vtíravá myšlenka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nutkání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rituál""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mánie""",
                    false,
                    "Mánie není typická pro obsedantně-kompulzivní poruchu, ale pro bipolární afektivní poruchu. Mánie je stav nadměrného nadšení, euforie, hyperaktivity a snížené potřeby spánku."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """V lidském vývoji existují období, ve kterých musí nastat určité události, aby vývoj mohl probíhat normálně. Například pokud v šestém a sedmém týdnu po oplodnění na plod nepůsobí mužské pohlavní hormony, nevyvinou se mužské pohlavní orgány správně, i kdybychom hormony později dodali. Jak se tato období ve vývojové psychologii nazývají?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""přirozená""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""optimální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kritická""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přechodná""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Kterých aspektů vývoje se týká nejznámější teorie Jeana Piageta?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""emocionálních""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivních""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sexuálních""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociálních""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Pavel trpí poškozením mozku. Jeho paměť je v pořádku, ale když se ho jeho neurolog zeptá, jakou střední školu vystudoval, zřetelně odpoví: "Řekl bych, že klikve skočily ham." Jaká porucha se u Pavla projevuje?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""dyslálie""",
                    false,
                    "porucha řeči - artikulace"
                ),
                PsychologyTermAnswer("""Wernickeova receptivní afázie""",
                    false,
                    "Afázie - ztráta či porucha řeči"
                ),
                PsychologyTermAnswer("""astereoagnozie""",
                    false
                ),
                PsychologyTermAnswer("""prozopagnozie""",
                    false,
                    "Zraková agnózie - porucha poznávání známých tváří"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Učitelka požádá žáky 8. A, aby uklidili kolem školy a nalezený odpad roztřídili. Žáci najdou při úklidu mj. velké množství PET lahví. Učitelka se zeptá, co žáci navrhují s PET láhvemi udělat. Většina doporučuje láhve sešlapat a odvézt do sběrného dvora, ale Berenika navrhne, že by z PET lahví mohli sestrojit vor, postavit lavičku nebo vyrobit originální lustry. Kterou schopnost má Berenika rozvinutou ve větší míře než ostatní žáci?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""krystalickou inteligenci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fluidní inteligenci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""frustrační toleranci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""divergentní myšlení""",
                    false,
                    "Pátrání po novém řešení, J. P. Guilford"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Psycholog po vyšetření sdělí Daliborovi, že jeho IQ se nachází tři směrodatné odchylky nad průměrem. Jakou hodnotu jeho IQ má?""", 
            textAnswer = "Hodnota, která udává, jak dalece se skóry tvořící určitý soubor odchylují" +
                " od průměrné hodnoty tohoto souboru, vyjádřená v původních jednotkách měření. Standardní odchylka IQ je 15 bodů.",
            answers =
            listOf(
                PsychologyTermAnswer("""109""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""145""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""103""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""121""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Co z následujícího platí o osobách prožívajících kognitivní disonanci?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """prožívají rozpor mezi tím, co si o sobě myslí a co si o nich myslí ostatní""", 
                    false
                ),
                PsychologyTermAnswer(
                    """prožívají konflikt mezi svým reálným a ideálním já""", 
                    false
                ),
                PsychologyTermAnswer(
                    """prožívají konflikt mezi svými postoji a jednáním""", 
                    false
                ),
                PsychologyTermAnswer(
                    """prožívají rozpor mezi nevědomými potřebami a požadavky okolí""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Weberova konstanta pro koncentraci pachového podnětu je 0,07 a pro koncentraci chuťového podnětu 0,20. Z toho vyplývá, že přidáme-li do jídla koření,""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """zaznamenáme rozdíl v podstatě současně (Weberova konstanta se vztahuje k jiným aspektům vnímání).""", 
                    false
                ),
                PsychologyTermAnswer("""zaznamenáme rozdíl čichem dříve než chutí.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zaznamenáme rozdíl chutí dříve než čichem.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """zaznamenáme rozdíl pouze chutí, pro čich je rozdíl příliš nepatrný.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """David usne na přednášce ze statistiky. Když to přednášející zjistí a probudí ho, je velice naštvaná a sdělí mu, že když má druhý den školu, nemůže chodit na večírky a ponocovat. Vzápětí se Davidovi ale omluví, protože ten jí sdělí, že trpí""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""mutismem""",
                    false,
                    "\"mute\" - tedy mu nejde mluvit, třeba kvůli úzkosti. Může mluvit s některými nebo nemluvit s nikým."
                ),
                PsychologyTermAnswer("""enurézou""",
                    false,
                    "pomočování"
                ),
                PsychologyTermAnswer("""agnózií""",
                    false,
                    "Agnózie - porucha poznávání předmětů"
                ),
                PsychologyTermAnswer("""narkolepsií""",
                    false,
                    "Člověk není schopen regulovat cyklus spánku a bdění"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který psychologický směr ve svých teoriích učení a myšlení klade důraz na náhlé porozumění struktuře situace?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                    "vhled, Kohler"
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""humanistická psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Marek příležitostně užíval diethylamid kyseliny lysergové. Od posledního užití uběhl už více než rok. Nedávno ho zaskočily prožitky a halucinace, které se velmi podobaly těm, které zažil při jednom z dřívějších požití drogy. Jak se tento fenomén označuje?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""fee fenomén""",
                    false,
                    "Gestalt. Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly."
                ),
                PsychologyTermAnswer("""feedback""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""retroaktivní transfer""",
                    false,
                    "Víceméně scaffolding - předchozí učení má vliv na proces učení nového materiálu. Interakce se starým materiálem."
                ),
                PsychologyTermAnswer("""flashback""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Psycholog profesor Š. se zabývá vývojovými trendy v rozsahu pozornosti. Zkoumá proto pozornost u skupiny 30 novorozenců, 30 kojenců ve věku tří měsíců, 30 dětí ve věku jednoho roku a 30 dětí tříletých. Při výběru těchto 90 dětí dbá na to, aby skupiny byly vyrovnané z hlediska zastoupení chlapců a dívek, velikosti místa bydliště a ekonomického statusu rodiny. Jak lze označit jeho výzkumný přístup?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""etnografický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""longitudinální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""průřezový""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""genetický""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Se kterým autorem jsou především spojeny pojmy individuace, extroverze a introverze, slovní asociační test... ?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Jean Piaget""",
                    false,
                    "1.Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\n4.Stadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""Sigmund Freud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Carl Jung""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Abraham Maslow""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Iva naposledy bruslila v dětství. Když se odhodlá jít po letech poprvé bruslit se svými syny, je přesvědčená, že už bruslit vůbec neumí, a pak je překvapena, že jí bruslení jde docela dobře. Jaký typ paměti se v tomto případě u Ivy uplatňuje?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""záblesková vzpomínka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sématická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""procedurální paměť""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících psychologů považuje za základní motivační sílu člověka tendenci k osobnímu růstu, zralosti a pozitivní změně?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Wilhelm Wundt""",
                    false,
                    "První laboratoř (1879, Lipsko), Strukturalismus psychologie jako věda, Introspekce (looking inward)"
                ),
                PsychologyTermAnswer("""J. B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""Leon Festinger""",
                    false,
                    "Kognitivní disonance. " +
                        "\nTeorie sociálního srovnávání (1954) - hlavně porovnání nám relavantní, pomáhá vytvářet sebepojetí" +
                    "\n\t-Srovnáváme se s lidmi na stejné úrovni" +
                        "\n\t-Srovnávání nahoru se děje pokud se chceme zlepšit" +
                        "\n\t-Srovnávání dolů je obranný mechanismus"
                ),
                PsychologyTermAnswer("""Carl Rogers""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Psycholog při administraci testu ukazuje testované osobě obrázky osob a scén a testovaná osoba má vymyslet na základě obrázku příběhy. O jaký test se jedná?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Tematický apercepční test""",
                    false,
                    "Projektivní test osobnosti (verbální), nejdominantnější hned po Rorschahovu testu." +
                        "\n32 černobílých obrázků s nejednoznačnými situacemi."
                ),
                PsychologyTermAnswer("""Test slovních asociací""",
                    false,
                    "Jung"
                ),
                PsychologyTermAnswer("""Minnesotský vícefázový osobnostní inventář""",
                    false,
                    "MMPI. Osobnostní a psychopatologický test pro dospělé. Více než 500 tvrzení, dichotomická škála - ano/ne." +
                        "\nPoužívá se na měření psychického stavu (deprese, paranoia, schizofrenie,...)"
                ),
                PsychologyTermAnswer("""Rorschachův test inkoustových skvrn""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Baum-test""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jedním ze způsobů, jak lze definovat odborné pojmy, je tzv. operacionální definice. Jde o takovou definici, která vymezuje soubor operací nezbytný k stanovení či měření pojmu. Tímto způsobem lze v psychologii studovat přímo nepozorovatelné jevy. Která z následujících definic představuje operacionální definici?""", 
            textAnswer = "Uděláme z čehokoliv něco měřitelné. Další příklady:" +
                "\n\nÚzkost: zvýšená aktivita sympatického nervového systému, měřená pomocí zvýšeného srdečního tepu a dýchací frekvence." +
                "\n\nDeprese: pocit smutku a ztráty zájmu o běžné aktivity, trvající déle než dva týdny." +
                "\n\nAgresivita: chování zaměřené na útok na druhé lidi nebo zničení věci, měřené pomocí zaznamenání fyzického násilí nebo verbální agrese vůči ostatním." +
                "\n\nExtraverze: sociální interakce a ochota zapojit se do nových aktivit a setkání s novými lidmi, měřené pomocí dotazníků, které posuzují chování v různých sociálních situacích.",
            answers =
            listOf(
                PsychologyTermAnswer("""inteligence: schopnost myslet abstraktně""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """hlad: počet hodin, který uplynul od posledního příjmu potravy""", 
                    false
                ),
                PsychologyTermAnswer(
                    """paměť: prostředek umožňující využití minulých zkušeností v přítomnosti""", 
                    false
                ),
                PsychologyTermAnswer(
                    """reflex: automatická mimovolní reakce na stimulaci, nevyžadující vstupní informace z mozku""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Petr K. je obviněn, že v hospodské hádce napadl svého kamaráda Martina J. a bodl ho nožem tak, že ten později svému zranění podlehl. V rámci obhajoby Petr tvrdí, že si na hádku a bodnutí nožem vůbec nevzpomíná. Pokud bychom jeho verzi uvěřili, o jaký typ amnézie se jedná?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""procedurální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""anterográdní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""retrográdní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""raná""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Štěpán vypráví svému psychoanalytikovi sen, který se mu zdál minulou noc. Ve snu šel do domu své kolegyně a z její ledničky si vzal mísu velmi chutných broskví a několik jich v její kuchyni snědl. Psychoanalytik sen vyloží tak, že si Štěpán přeje mít s kolegyní pohlavní styk. Za jaký obsah snu lze označit broskve a jejich konzumaci?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""latentní""",
                    false,
                    "skrytý, nevědomý obsah snu"
                ),
                PsychologyTermAnswer("""potlačený""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""manifestní""",
                    false,
                    "viditelný obsah snu"
                ),
                PsychologyTermAnswer("""nepřístupný""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Co psychologové zjišťují zkoumáním vlastností dvojčat (jednovaječných, dvojvaječných, vychovávaných společně a odděleně)?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """zda jde při vývoji spíše o spojitý proces změn nebo o sérii kvalitativně oddělených etap""", 
                    false
                ),
                PsychologyTermAnswer(
                    """podíl vlivů prostředí a genetických vlivů na vývoj""", 
                    false
                ),
                PsychologyTermAnswer(
                    """zda podobnost ve fyzickém vzhledu odpovídá podobnosti v osobnostních vlastnostech""", 
                    false
                ),
                PsychologyTermAnswer("""zda ve vývoji existují kritická období""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Psycholog je přesvědčen, že chování člověka je určováno především podmínkami prostředí. Který teoretický směr je nejbližší takovému pohledu?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""humanistická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""existenciální psychologie""",
                    false,
                    "Důraz na existenci a svobodu. Teorie \"já\" - člověk je proces, nikoliv hotový výtvor. Subjektivní vnímání reality."
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """V odborném článku se můžeme dočíst následující kritiku testu: "Výsledek v Jelínkově testu inteligence není ovlivněn výhradně rozumovými schopnostmi, ale z velké části úrovní pozornosti". Kterou charakteristiku testu autor článku kritizuje?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""validitu""",
                    false,
                    "Měří test opravdu co má měřit?"
                ),
                PsychologyTermAnswer("""objektivitu administrace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""specificitu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reliabilitu""",
                    false,
                    "Dají se výsledky replikovat?"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jedenapůlletá Barborka je zdravé a čilé dítě, které rádo prozkoumává své okolí: běhá, snaží se vyšplhat na nábytek a prolézačky na hřišti. Její ochranářská postarší maminka má však veliké obavy, že se Barborka může zranit a snaží se ji v těchto aktivitách omezovat. Neuvědomuje si však, že podle teorie Erika Eriksona tím Barborce brání ve vyřešení určitého vývojového úkolu - konfliktu:""", 
            textAnswer = "Vývoj osobnosi, psychosociální teorie. Každý stádium má krizi, kterou musíme vyřešit abychom mohli pokračovat." +
                "\nDůvěra x nedůvěra (do roku)" +
                "\nAutonomie x stud (2-3 let) - podobné anal stádiu u Fredu - je dítě učeno být samostatné?" +
                "\nIniciativa x vina (3-5 let) - jak moc nechají rodiče dítě růst" +
                "\nSnaživost x méněcennost (6-12 let)" +
                "\nIdentita x nejistota (12-16)" +
                "\nIntimita x izolace (18-35)" +
                "\nReprodukce x stagnace (35-55)" +
                "\nIntegrita x stagnace (55+)",
            answers =
            listOf(
                PsychologyTermAnswer("""autonomie vs. pochybnost""",
                    false,
                    "2-3 let"
                ),
                PsychologyTermAnswer("""důvěra vs. nedůvěra""",
                    false,
                    "do roku, jako měří Strange Situation experiment"
                ),
                PsychologyTermAnswer("""identita vs. zmatek""",
                    false,
                    "Puberta - 12-16"
                ),
                PsychologyTermAnswer("""píle vs. pocity méněcennosti""",
                    false,
                    "6-12 školní období"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Co z uvedeného je nejvíce ovlivnitelné výchovou a působením společnosti?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""temperament""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kapacita krátkodobé paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""charakter""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """V programu psychologické konference jste objevili příspěvek s názvem "Lidská mysl funguje jako počítač". K jakému psychologickému směru se autor příspěvku nejpravděpodobněji hlásí?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""transpersonální psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Pokud máme posoudit, co bylo příčinou chování ostatních lidí, máme většinou tendenci přisuzovat větší důležitost vnitřním faktorům (jako jsou osobnostní vlastnosti) než faktorům situačním, i když máme pro oboje příčiny stejně přesvědčivé doklady. Jak sociální psychologové označují tuto tendenci?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""základní atribuční chyba""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""skupinová polarizace""",
                    false,
                    "posun skupiny k extrému"
                ),
                PsychologyTermAnswer("""haló efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reciproční determinismus""",
                    false,
                    "A. Bandura, 3 aspekty - prostředí, jednotlivec a chování. Všechny tři se navzájem ovlivňují."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Který z následující čtveřice psychologů nepatří svým zaměřením mezi ostatní tři?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Stanley Milgram""",
                    false,
                    "Poslušnost vůči autoritě - elektrošoky"
                ),
                PsychologyTermAnswer("""Solomon Asch""",
                    false,
                    "Konformita"
                ),
                PsychologyTermAnswer("""Philip Zimbardo""",
                    false,
                    "Věznice"
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jak se nazývá nauka o významu jednotlivých slov, morfémů a jiných znaků, případně též jejich vztahu ke skutečnosti, kterou označují?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pragmatika""",
                    false,
                    "Nebo také pragmatická lingvistika (z řeckého pragma - skutek)." +
                        " Řeč není jen sémantická, informativní, ale je pod tím i něco více, nějak záměr."
                ),
                PsychologyTermAnswer("""sémantika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""syntax""",
                    false,
                    "Vztahy mezi jednotlivými výrazy."
                ),
                PsychologyTermAnswer("""etymologie""",
                    false,
                    "Původ slova"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Helenka zná přibližně 700 slov, umí chodit pozpátku a kutálet míčem, s panenkami si hraje raději sama než s vrstevníky. Když ji psycholog požádá, aby nakreslila podle předlohy čtverec, nedokáže to. Pro jakou vývojovou fázi jsou Helenčiny dovednosti typické?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""batole""",
                    false,
                    "1-3 let"
                ),
                PsychologyTermAnswer("""předškolák""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dítě mladšího školního věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kojenec""",
                    false,
                    "2-12 měsíců"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jakou roli zastávaly v Milgramově klasickém experimentu s poslušností vůči autoritě skutečné zkoumané osoby?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""roli učitele""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""roli žáka""",
                    false,
                    "žák byl herec, který předstíral, že dostává šoky"
                ),
                PsychologyTermAnswer("""roli pozorovatele""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """kteroukoli z rolí učitel, žák nebo pozorovatel (bylo přiřazeno náhodně)""", 
                    false
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Gregory a Wallace publikovali v roce 1963 článek o zkoumání pokroků muže, který po 50 letech slepoty znovu nabyl zrak. Tento výzkum je příkladem""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""deterministického přístupu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nomotetického přístupu""",
                    false,
                    "snaží se hledat principy, aplikovatelné na většinu lidí"
                ),
                PsychologyTermAnswer("""holistického přístupu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""idiografického přístupu""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Výzkumník chce zjistit, jak sledování televizních reklam souvisí s množstvím zkonzumovaných sladkostí u pětiletých dětí. U skupiny 45 dětí po dva týdny sleduje, kolik času stráví sledováním TV reklam. Současně zaznamenává u každého dítěte množství zkonzumovaných sladkostí. O jaký typ experimentu jde?""",
            textAnswer = "Typy experimentů:" +
                "\n\nMezisubjektový experiment - 2 a více skupiny účastníků" +
                "\n\nVnitrosubjektový experiment - porovnává různé výsledky stejné skupiny" +
                "\n\nVícefaktoriální experiment - více než jeden faktorů, zkoumá faktory" +
                "\n\nField experimentů - v přirozeném prostředí" +
                "\n\nKvaziexperiment (Quasi-experiment, přírodní experiment) - různé skupiny podle atributů  charakteristik (pohlavím, věk, neurotismus), bez kontrolní skupiny",
            answers =
            listOf(
                PsychologyTermAnswer("""nejedná se o experiment""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""experiment s mezisubjektovým plánem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vícefaktoriální experiment""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""experiment s vnitrosubjektovým plánem""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            "Podle Hullovy teorie motivace je pravděpodobnost určitého chování dána několika faktory. " +
                "Např. pravděpodobnost, že krysa zmáčkne páčku v experimentátorem vytvořené skříňce je podmíněna zkušeností krysy s mačkáním páčky," +
                " úrovní hladu krysy a atraktivitou odměny (potravy) za zmáčknutí páčky. Který z následujících nepatří mezi Hullem vymezené faktory?",
            textAnswer = "(1) reflexy, (2) reakce a (3) návyky" +
                "\n\n" +
                "Mezi jeho nejvýznačnější díla z této doby patří zejména Mathematico-Deductive Theory of Rote Learning (1940) a Principles of Behavior (1943)",
            answers =
            listOf(
                PsychologyTermAnswer("""pud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""síla návyku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přenos""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pobídka (incentiva)""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Starší muž dostane na rušné ulici srdeční infarkt. Leží na zemi a kolem něj stojí hlouček lidí, nikdo z nich ani z ostatních kolemjdoucích mu však neposkytne žádnou pomoc. Jak sociální psychologové jejich neochotu nejčastěji vysvětlují?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální konformitou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální fobií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozložením zodpovědnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální facilitací""",
                    false,
                    "Vliv přítomnosti jiných lidí na chování člověka. Touto problematikou se zabýval pravděpodobně první experiment v sociální psychologie (1898)," +
                        " který uskutečnil Norman Triplett. Pozoroval jevy v cyklisty a jejich zrychlení, když jely v skupinách."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Který z uvedených nepatří mezi zakladatele kognitivní psychologie?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""A. H. Maslow""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""U. Neisser""",
                    false,
                    "Paměť, inteligence, percepce, \"Otec kognitivní psychologie\""
                ),
                PsychologyTermAnswer("""G. A. Miller""",
                    false,
                    "7-+2, George Miller (1956)"
                ),
                PsychologyTermAnswer("""J. S. Bruner""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jak se označuje míra výkonu, kterou od sebe jedinec očekává při provádění známého úkolu?""", 
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""aspirační úroveň""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""míra funkční autonomie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""síla ega""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úroveň anticipace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Podle Skinnera jsou slova pouze reakce - projevy chování, které jsou produkovány proto, že byly prostředím upevněny. Při osvojování jazyka poskytují zpevnění rodiče, protože jejich úsměvy, pozornost a chvála jsou pro dítě příjemné. Každá řečová reakce, která vede k příjemným důsledkům, se bude příště vyskytovat s vyšší pravděpodobností. Jaké principy se podle Skinnera při osvojování jazyka uplatňují?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""principy asimilace a akomodace""",
                    false,
                    "Piaget"
                ),
                PsychologyTermAnswer("""vrozené faktory""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""principy reality a slasti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""principy operantního podmiňování""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """STRACH : FOBIE = VESELOST : ? Z nabízených pojmů vyberte ten, který se významově nejvíce hodí namísto otazníku:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""obsese""",
                    false,
                    "Opakované, vtíravé myšlenky (nápady), pudy a činy."
                ),
                PsychologyTermAnswer("""mánie""",
                    false,
                    "Extrémní strach - fóbie, extrémní veselost - mánie"
                ),
                PsychologyTermAnswer("""dobrá nálada""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""apatie""",
                    false,
                    "naprostá pasivita, zeslabení zájmů a reakcí vůči vjemům"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """H. Eysenck ve své teorii osobnosti propojil klasické temperamentové typy s výsledky faktorově-analytických studií osobnosti. Jak by bylo možno v souladu s jeho teorií nejlépe charakterizovat melancholika?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""emočně nestabilní introvert""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emočně stabilní extravert""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emočně stabilní introvert""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emočně nestabilní extravert""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """S kterou oblastí sociální psychologie je především spojováno jméno Gustav Le Bon?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""zkoumání postojů a možnosti jejich změny""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie davu""",
                    false,
                    "1895"
                ),
                PsychologyTermAnswer("""zkoumání procesů konstruování identity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zkoumání instrumentální agrese""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """V psychoterapii se někdy stává, že pacient vyjadřuje vůči terapeutovi postoje, které ve skutečnosti cítí vůči druhým lidem. Jak se tato tendence označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sublimace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sugesce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přenos""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reaktivní výtvor""",
                    false,
                    "(reaktivní formace) - potlačil u sebe a chce potlačit i u někoho dalšího"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Učitelka zkouší látku z minulého týdne a zeptá se Martina, jaké je hlavní město Portugalska. Který druh paměti se u Martina při vybavování odpovědi uplatňuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""krátkodobá paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""procedurální paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sémantická paměť""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Zajímavou otázkou pro psychology je již delší dobu způsob, jakým lidé řeší problémy. Který z následujících směrů je charakterizován redukcionistickým přístupem, rozložením řešení problému do souboru stádií/kroků a zkoumáním heuristických strategií při řešení problémů?""",
            textAnswer = "Newell-Simonova teorie informačně-procesního řešení problémů" +
                "\nHeuristické řešení" +
                "\n\t\t-stoupání na horu" +
                "\n\t\t-postupování vzad" +
                "\n\t\t-analýza prostředků a cílů",
            answers =
            listOf(
                PsychologyTermAnswer("""informační psychologie""",
                    false,
                    "Kognitivní psychologie, G Miller"
                ),
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""funkcionalismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""humanistická psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Která z uvedených nepatří mezi projektivní metody?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Tématický apercepční test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Wechslerův test inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Rorschachův test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Test nedokončených vět""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Pojem individuace je spojen s teorií""",
            textAnswer = "uskutečnění tzv. bytostného Já",
            answers =
            listOf(
                PsychologyTermAnswer("""Maxe Luschera""",
                    false,
                    "Luscherů test" +
                        "\n\tProjektivní test osobnosti (manipulační). Výběr mezi barvami - každý má jinou preferenci, která je podvědomě vedena."
                ),
                PsychologyTermAnswer("""Alfreda Adlera""",
                    false,
                    "Komplex méněcennosti, Neopsychoanalitika, styl žití naučen v 4-5 (drive). Individuální psychologie." +
                        "Pořadí narození:" +
                        "\n\t- Prvorozený - dostává všechnu pozornost do doby, kdy se narodí další - přišel o trůn. Benefituje z moci, je problémový. Snaží se dosáhnout co nejvíce, organizovaní." +
                        " Pokud selže v tom být nejlepší jsou si nejistí." +
                        "\n\t- Druhorozený - tolik mu nezáleží na rodičích, rodiče se tak nesnaží. Prvorození je pro něj model (může si připadat méněcenný a závidet), může být" +
                        " ctižádostivý a ambiciózní nebo úplný opak." +
                        "\n\t- Nejmladší - starší jako modely, velmi rychlý vývoj, buďto jsou hodně závislý na ostatních nebo chtějí dosahovat věcí."
                ),
                PsychologyTermAnswer("""Carla Gustava Junga""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Jeana Piageta""",
                    false,
                    "1.Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\n4.Stadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """V šedesátých letech minulého století byl populární jistý směr psychoterapie, jehož základní myšlenky byly zachyceny v knihách Jak si lidé hrají (Games People Play) nebo Já jsem OK - ty jsi OK (I'm Okay - You're Okay). Jak se tato terapie nazývá?""",
            textAnswer = "E. Berne" +
                "\nMezilidská komunikace. Inspiruje se v psychoanalýze: tři roviny osobnosti:" +
                "\nDítě - vzpomínky z dětství a naše dětskost (hravost, bezmocnost, spontaneita, hravost,...)." +
                "\nRodič - vzpomínky toho, co jsme jako děti slyšeli od rodičů a naše rodičovskost (autorita, poučování, dohled,...)." +
                "\nDospělý - rozumě založené informace, vlastní názory." +
                "\nPoté analyzujeme  konverzaci jako Dospělý - Dítě bez ohledu na věku.",
            answers =
            listOf(
                PsychologyTermAnswer("""transakční analýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivně-behaviorální terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt terapie""",
                    false,
                    "Humanistický, prožitkový přístup, teorie pole." +
                        "\nCílem je sjednocení těla, pocitů a rozumu." +
                        "\nVnější projevy musí souhlasit s vnitřními pocity."
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Ve které fázi vývoje musí podle E. Eriksona jedinec řešit psychosociální krizi INTIMITA vs. IZOLACE?""",
            textAnswer = "Vývoj osobnosi, psychosociální teorie. Každý stádium má krizi, kterou musíme vyřešit abychom mohli pokračovat." +
                "\nDůvěra x nedůvěra (do roku)" +
                "\nAutonomie x stud (2-3 let) - podobné anal stádiu u Fredu - je dítě učeno být samostatné?" +
                "\nIniciativa x vina (3-5 let) - jak moc nechají rodiče dítě růst" +
                "\nSnaživost x méněcennost (6-12 let)" +
                "\nIdentita x nejistota (12-16)" +
                "\nIntimita x izolace (18-35)" +
                "\nReprodukce x stagnace (35-55)" +
                "\nIntegrita x stagnace (55+)",
            answers =
            listOf(
                PsychologyTermAnswer("""adolescence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""třetí až pátý rok života""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""střední dospělost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mladší dospělost""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Psycholožka se zabývá vývojem řeči u dětí. Náhodně vybere skupinu 150 půlročních dětí a sleduje jejich porozumění a produkci řeči postupně ve věku 6 měsíců, 9 měsíců, 1 roku, 2 a 5 let. Jaký přístup výzkumnice používá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""narativní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""idiografický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""průřezový""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""longitudinální""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jak se nazývá přístroj, který je založen na měření fyziologických reakcí, jako jsou změny srdeční frekvence, krevního tlaku, dechu a kožní galvanické reakce?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pletysmograf""",
                    false,
                    "Měření fyziologických parametrů ako např. objem tkáně v důsledku průtoku krve"
                ),
                PsychologyTermAnswer("""počítačový tomograf""",
                    false,
                    "CT - scan mozku"
                ),
                PsychologyTermAnswer("""tachistoskop""",
                    false,
                    "test pozornosti, rychlost odpovědí",
                    imageExplanationUrl = "https://vlp.mpiwg-berlin.mpg.de/vlpimages/images/img23725.jpg"
                ),
                PsychologyTermAnswer("""polygraf""",
                    false,
                    "detektor lží"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Tato disciplína psychologie se zabývá zejména popisem a výkladem psychických jevů, tak jak se objevují u rozvinutého a nepatologicky prožívajícího dospělého jedince. O jakou disciplínu se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""klinická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""evoluční psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obecná psychologie""",
                    false,
                    "\n" +
                        "Obecná psychologie se zabývá základními otázkami psychologie a zkoumá mentální procesy, jako je vnímání, myšlení, učení, paměť, pozornost, emoce, motivace, vědomí."
                ),
                PsychologyTermAnswer("""sociální psychologie""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """V přehledové studii bylo zjištěno, že průměrná hodnota korelace mezi inteligencí identických dvojčat vychovávaných společně je 0,86, u identických dvojčat vychovávaných zvlášť je to 0,72 a u neidentických dvojčat vychovávaných spolu je korelace 0,60. Jaký závěr můžeme učinit?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """na výši inteligence mají výrazně vyšší vliv vrozené (genetické) faktory než faktory prostředí""",
                    false
                ),
                PsychologyTermAnswer(
                    """podíl faktorů prostředí a genetických faktorů na výši inteligence je zhruba stejný""",
                    false
                ),
                PsychologyTermAnswer(
                    """na výši inteligence mají výrazně vyšší vliv faktory prostředí než vrozené (genetické) faktory""",
                    false
                ),
                PsychologyTermAnswer(
                    """z těchto údajů nelze žádný závěr o podílu genetických faktorů a faktorů prostředí na výši inteligence vyvodit""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """George Kelly se domníval, že na lidi by se mělo pohlížet jako na intuitivní vědce. Cílem psychologa by pak mělo být objevení dimenzí, které používají sami jedinci k interpretaci a vytváření sebe samých nebo svých sociálních světů. Jak se tato teorie označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""teorie kognitivní dizonance""",
                    false,
                    "L. Festinger"
                ),
                PsychologyTermAnswer("""teorie objektních vztahů""",
                    false,
                    "Psychoanalitická teorie mezilidských vztahů, obzvláště v rodině a obzvláště mezi matkou a dítětem (např. Bowlby)."
                ),
                PsychologyTermAnswer("""teorie osobních konstruktů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie etnolingvistické identity""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Standard_deviation_diagram.svg/370px-Standard_deviation_diagram.svg.png",
            prompt = """Pro křivku normálního rozdělení (Gaussova křivka) je typické, že""",
            textAnswer = "Gaussovo rozdělení - velké množství náhodných proměnných, směrodatná odchylka uprostřed, např. graf IQ - soustředění kolem průměru",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """většina případů se shlukuje kolem střední hodnoty, směrem ke krajním hodnotám množství případů postupně klesá""",
                    false
                ),
                PsychologyTermAnswer(
                    """většina případů se shlukuje kolem krajních hodnot, směrem ke středním hodnotám množství případů postupně klesá""",
                    false
                ),
                PsychologyTermAnswer(
                    """případy jsou rovnoměrně rozloženy po celém rozsahu škály""",
                    false
                ),
                PsychologyTermAnswer(
                    """množství případů je u nižších hodnot škály malé a s vyššími hodnotami postupně roste""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co je to placebo efekt?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """stav organismu, který umožňuje prožívat představy, které slouží k odpočinku a sebepoznání""",
                    false
                ),
                PsychologyTermAnswer(
                    """sugestivní technika zaměřená na dosažení změněného stavu vědomí""",
                    false
                ),
                PsychologyTermAnswer(
                    """působení naučeného obsahu na nový průběh učení""",
                    false
                ),
                PsychologyTermAnswer(
                    """jev, kdy samy o sobě neúčinné prostředky léčí, jestliže je pacient přesvědčen o jejich účinnosti""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Šestiměsíční Julián leží v postýlce, pobrukuje si a natahuje se po zajímavé barevné hračce. Jestliže však maminka přes tuto hračku přehodí látku, Julián se po ní ihned přestane natahovat a ztratí zájem. Co je nejspíše příčinou? Co malý Julián postrádá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pojetí konzervace""",
                    false,
                    "přelívání tekutin do nádob o jiných velikostí má stále stejný objem"
                ),
                PsychologyTermAnswer("""schopnost formálních operací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pojetí stálosti objektu""",
                    false,
                    "V osmi měsících přijde"
                ),
                PsychologyTermAnswer("""schopnost senzomotorických operací""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """V metodologicky správném výzkumném plánu je nutné co nejvíce eliminovat možné zdroje zkreslení výsledků výzkumu. Který zdroj zkreslení se snažíme odstranit užitím dvojité slepé kontroly a nezávislého pozorovatele?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""účinek pořadí při opakovaném měření""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""očekávání výzkumníka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""operacionalizace proměnných""",
                    false,
                    "Z abstraktního/teoretického do měřitelného/sledovatelného"
                ),
                PsychologyTermAnswer("""umělost prostředí (ekologická validita)""",
                    false,
                    "Jsou výsledky aplikovatelné do skutečného světa?"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Změny ve vědomí vyvolané působením této drogy nejsou nijak výrazné, většinou nedochází k neobvyklým zrakovým vjemům nebo ztrátě kontaktu s realitou. Hlavním efektem je změna nálady - pocity pohody a snížení úzkosti. Po určité době užívání se zvyšuje tolerance, která často vede ke změně způsobu aplikace látky, a abstinenční příznaky jsou stále intenzivnější. O jakou drogu se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""hašiš""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""extáze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""LSD""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""heroin""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Pojem "hlavonožec" se ve vývojové psychologii vztahuje k popisu""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pohybových vzorců v batolecím věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dětské hry""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""senzomotorického vývoje kojence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dětské kresby""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Zkreslené vnímání tvaru vlastního těla se nejčastěji objevuje u osob trpících""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""úzkostí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální anorexií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""depresí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenií""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jak se označuje postup behaviorální terapie, při kterém je nežádoucí chování při svém výskytu negativně zpevněno (např. alkoholik dostane elektrickou ránu ve chvíli, kdy sáhne po sklenici)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""averzivní terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""systematická desenzibilizace""",
                    false,
                    "u fóbií - relaxační metoda"
                ),
                PsychologyTermAnswer("""vyhasínání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přesycení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Doplňte na místo otazníku: vrozená : získaná = fluidní inteligence : ?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""krystalická inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývojová inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""figurální inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obecná inteligence""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Která z následujících poruch nepatří mezi poruchy vnímání:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""bludy""",
                    false,
                    "Nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech"
                ),
                PsychologyTermAnswer("""synestezie""",
                    false,
                    "Sdružení dvou nebo více smyslových vjemů člověka"
                ),
                PsychologyTermAnswer("""iluze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""halucinace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Jak se označuje silná, bouřlivá, ale velmi krátce probíhající emoce?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""nálada""",
                    false,
                    "déletrvající pohotovost k emočním reakcím určitého směru"
                ),
                PsychologyTermAnswer("""cit""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""afekt""",
                    false,
                    "intenzivní emoce, vzniká náhle, prudce a má konkrétní zaměření"
                ),
                PsychologyTermAnswer("""vášeň""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Mezi dvojicí slov strach : fóbie existuje určitý vztah. Velmi podobný vztah existuje mezi dvojicí slov smutek : ?. Doplňte na místo otazníku jednu z následujících možností:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""radost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úzkost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neuróza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprese""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Psychologické testy a dotazníky jsou ve skříni na katedře psychologie rozděleny podle zaměření. Ve spodní polici najdeme Rorschachův test, Cattelův PF, MMPI ... O jaké metody se jedná? """,
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """testy inteligence""",
                    false
                ),
                PsychologyTermAnswer("""testy paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""testy kreativity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""testy osobnosti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který psychologický systém tvrdil, že rozklad složitých procesů na jednodušší prvky je považován za nejlepší cestu k porozumění psychice?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""funkcionalismus""",
                    false,
                    "evolucionální důvod za chováním, ne o \"paměti\", ale učení."
                ),
                PsychologyTermAnswer("""strukturalismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Tversky a Kahneman zkoumali, jak lidé usuzují a jakých chyb se případně ve svém induktivním usuzování dopouštějí. Zkoumaným osobám byl prezentován následující popis: Linda je 31 let stará, svobodná, otevřená a velmi chytrá. Na vysoké škole se specializovala na filozofii... a velmi ji zajímala problematika diskriminace. Pokusné osoby následně měly odhadnout, která z následujících možností je pravděpodobnější: 1) Linda je bankovní úřednicí. 2) Linda je bankovní úřednicí a je aktivní ve feministickém hnutí. Jaké byly výsledky výzkumu?""",
            textAnswer = "Konjunkční chyba ",
            answers =
            listOf(
                PsychologyTermAnswer("""Většina osob pokládala za pravděpodobnější možnost 2) a dopustila se tak chyby v usuzování.""",
                    false,
                    "pravidlo konjunkce"
                ),
                PsychologyTermAnswer(
                    """Většina osob pokládala za pravděpodobnější možnost 2) a nedopustila se tak chyby v usuzování.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Většina osob pokládala za pravděpodobnější možnost 1) a dopustila se tak chyby v usuzování.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Většina osob pokládala za pravděpodobnější možnost 1) a nedopustila se tak chyby v usuzování.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Martině se nepodařilo složit zkoušku na vysokou školu. Martina na tuto situaci reaguje kompenzací. Co nejlépe odpovídá tomuto řešení situace?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Vlastně to žádný velký problém není. Vyspím se na to a zítra uvidíme.""",
                    false
                ),
                PsychologyTermAnswer(
                    """No co. Stejně si na tu školu každý stěžuje a akademický titul by mi stejně nebyl k ničemu.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Není možné, že mě nepřijali. Prostě tomu nevěřím.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Když mě nepřijali na školu, tak se alespoň pokusím uspět v atletice.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Výzkumník Hofling se svými spolupracovníky provedl experiment, ve kterém lékař přikázal zdravotní sestře, aby pacientovi podala nadměrné množství léku. Lékař stylem příkazu navíc porušil několik dalších pravidel - příkaz byl dán telefonicky neznámou osobou a lék nebyl na seznamu vybraných uskladněných léků. Bylo zjištěno, že velká většina zdravotních sester příkaz přesto uposlechla. Na který výzkum tento experiment navazoval?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Zimbardův""",
                    false,
                    "Vězení"
                ),
                PsychologyTermAnswer("""Aschův""",
                    false,
                    "Konformita"
                ),
                PsychologyTermAnswer("""Milgramův""",
                    false,
                    "Autorita"
                ),
                PsychologyTermAnswer("""Festingerův""",
                    false,
                    "L Festiner: Kognitivní disonance. " +
                        "\nTeorie sociálního srovnávání (1954) - hlavně porovnání nám relavantní, pomáhá vytvářet sebepojetí" +
                        "\n\t-Srovnáváme se s lidmi na stejné úrovni" +
                        "\n\t-Srovnávání nahoru se děje pokud se chceme zlepšit" +
                        "\n\t-Srovnávání dolů je obranný mechanismus"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Jak C.G. Jung označuje proces, který by měl být náplní druhé poloviny života a představuje cestu k jádru vlastní osobnosti, k opravdovým, autentickým vztahům a k harmonii s kolektivním nevědomím v sobě?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sublimace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""intuice""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""individuace""",
                    false,
                    "uskutečnění tzv. bytostného Já"
                ),
                PsychologyTermAnswer("""archetypizace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Rys osobnosti, který vyjadřuje, jak jedinec odolává stresu nebo jak rychle a kvalitně ho překoná, jinak také nezdolnost vůči nepříznivým okolnostem, se označuje jako:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""extraverze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hostilita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""resilience""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoticismus""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Když před dítětem přelijete vodu z nižší-širší nádoby do užší- vyšší, a ono vám řekne, že více vody je teď v té užší-vyšší, ačkoli množství vody zůstalo zachováno, nachází se podle Piagetovy teorie v období:""",
            textAnswer = "1.Senzomotorická inteligence (0-2 roky):" +
                "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                " Strange situation study - attachment styly." +
                "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, " +
                "\n\t\tkonzervace - přelívání tekutin to nádob o jiných velikostí." +
                "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                "\n\n4.Stadium formálních operací (12+)" +
                "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení",
            answers =
            listOf(
                PsychologyTermAnswer("""abstraktních operací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konkrétních operací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předoperačním""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""formálních operací""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Ve kterých teoriích osobnosti je důležitým pojmem tzv. spiritualita - tj. hledání smyslu života, úsilí o vyšší hodnoty nebo ideály?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""kognitivní teorie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""humanistické teorie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Kdo je autorem následujícího výroku? „Sen, nad kterým jsme se nezamysleli, je jako dopis, který jsme neotevřeli".""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Jean Piaget""",
                    false,
                    "1.Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\n4.Stadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""Carl Gustav Jung""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""John Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Oblíbená teorie motivace tvrdí, že veškeré jednání je vedeno snahou dosahovat co nejvíce příjemných pocitů a co nejvíce se vyhýbat pocitům nepříjemným. Základním univerzálním motivem je tedy co nejpříznivější bilance libosti a nelibosti. Jak se tato teorie motivace označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""hierarchická teorie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reduktivní teorie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hedonická teorie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie primárních motivů""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Pokud budeme tvrdit, že „máme strach, protože se nám potí ruce a chvějeme se", budeme obhajovat teorii emocí, jejímž autorem je:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Walter Cannon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""William James a Carl Lange""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Hermann Helmholtz a Wilhelm Wundt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Carl Gustav Jung""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Co Festinger označoval jako kognitivní disonanci?""",
            textAnswer = "Teorie sociálního srovnávání (1954) - hlavně porovnání nám relavantní, pomáhá vytvářet sebepojetí" +
                "\n\t-Srovnáváme se s lidmi na stejné úrovni" +
                "\n\t-Srovnávání nahoru se děje pokud se chceme zlepšit" +
                "\n\t-Srovnávání dolů je obranný mechanismus",
            answers =
            listOf(
                PsychologyTermAnswer("""jeden z klíčových projevů deprese""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """rozpor mezi tím, jak člověk jedná a tím, jaké je jeho přesvědčení""",
                    false
                ),
                PsychologyTermAnswer("""neschopnost přemýšlet""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """nesoulad dvou lidí v názoru na určitou tematiku""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Výzkumník se snaží zjistit, zda nově navržená metoda pro měření osobnostního rysu extraverze skutečně měří tento rys. Za tímto účelem administruje novou metodu určité skupině osob spolu s metodou, která je již zavedená a slouží stejnému účelu. Posléze zjišťuje korelaci mezi výsledky obou testů. O jaké vlastnosti testu výše korelace nejvíce vypovídá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""split-half reliabilitě""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""souběžné validitě""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vnitřní konzistenci testu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konstruktové validitě""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Mezi hlavní účinky této drogy patří prožitky zvýšené sebedůvěry, euforie a radostné nálady. Na druhou stranu hrozí možnost dehydratace. O jakou látku se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""MDMA""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psilocybin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""heroin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""LSD""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Dalibor se pokouší uvázat si kravatu. Dělá to však poprvé a nedaří se mu to. Požádá kamaráda Petra, který kravatu denně nosí, aby mu postup vysvětlil. Petr se snaží, ale nedokáže postup slovně zformulovat. Nakonec Daliborovi kravatu raději sám uváže, což zvládne zcela bez problémů. Který systém paměti pro tuto dovednost Petr využívá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sémantickou paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deklarativní paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""procedurální paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epizodickou paměť""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Úroveň fluidní inteligence se v průběhu života mění. Ve kterém z následujících vývojových období je nejvyšší?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""střední dospělost (30-60 let)""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""po šedesátém roce života""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dospívání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""začátek života (kojenecké období)""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Mezi zákony gestaltistů nepatří:""",
            imageAnswerUrl = "https://images.slideplayer.cz/41/11152302/slides/slide_53.jpg",
            textAnswer = "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                "\nNěkteré věci, které řešili:" +
                "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                "\nZákon podobnosti - tendence vnímat podobné podněty jako celky.",
            answers =
            listOf(
                PsychologyTermAnswer("""zákon blízkosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zákon střední hodnoty""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zákon podobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zákon pokračování""",
                    false,
                    "fi-fenomén"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Petr už 2 roky pravidelně užívá opiáty. Před několika dny náhle s užíváním přestal. Nyní se potí, bolí ho svaly a klouby, má průjem a nutkání na zvracení. Současně je podrážděný a úzkostný. Jak se odborně jeho stav nazývá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""akutní intoxikace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""flashback""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""odvykací syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""akutní nevolnost po užití psychoaktivní látky""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Který z těchto znaků není charakteristický pro psychotické poruchy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Afektivní složka psychiky zůstává obvykle neporušena.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Mezi poměrně časté příznaky patří apatie, dezorganizovaná řeč a nedostatek vůle.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Řadí se mezi ně katatonní (katatonická) schizofrenie.""",
                    false
                ),
                PsychologyTermAnswer("""Je ztracený kontakt jedince s realitou.""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Gabriela se neustále zabývá pozorností lidí ve svém okolí a touží po jejich obdivu. Chodí vyzývavě oblékaná, ráda flirtuje a koketuje, ale v sexuálním životě je nespokojená. Nepřiměřeně dává na odiv své emoce, které se přitom velice často a náhle mění. Nejvíce ji rozladí, když není středem pozornosti. Nezajímá ji příliš, co prožívají druzí, ačkoli naoko dává najevo např. soucit s kolegyní, které zemřela kočka. Psychiatr u ní diagnostikoval poruchu osobnosti. O kterou poruchu se s největší pravděpodobností jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""anankastickou poruchu osobnosti""",
                    false,
                    "puntičkářství"
                ),
                PsychologyTermAnswer("""anxiózní poruchu osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schiozoidní poruchu osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""histrionskou poruchu osobnosti""",
                    false,
                    "sebedramatizace, teatrálnost, labilní afektivitou, přehnaný projev emocí"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Martin by rád vyrazil s přítelkyní na exotickou dovolenou. Nemá ale dost peněz. V práci se mu náhle naskytne příležitost: všichni odešli na oběd a on si všimne, že firemní trezor zůstal odemčený. Co Martin udělá? Podle Freuda naše motivace k jednání pramení z dynamického soupeření tří stránek nevědomé mysli: ega, superega a id. Jak by se nejspíše vyjádřilo Martinovo id?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """nemůžu to udělat, přijdou na mne a vyhodí mě z práce""",
                    false
                ),
                PsychologyTermAnswer(
                    """to si s Hankou užijeme krásnou dovolenou za firemní peníze, už nás vidím s koktejlem na pláži!""",
                    false
                ),
                PsychologyTermAnswer(
                    """bylo by to krásné, ale vůči kolegům by to nebylo fér""",
                    false
                ),
                PsychologyTermAnswer("""krást se nemá, je to nemorální""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících psychologů je jedním ze zakladatelů kulturní psychoanalýzy a autorem knih Strach ze svobody, Mít či být nebo Umění milovat?""",
            textAnswer = "",
            answers =
            listOf(
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
                PsychologyTermAnswer("""C.G. Jung""",
                    false,
                    ""
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jirka má velice rád kuřecí křidélka. Minulý měsíc šel s partou kamarádů do hospody a objednali si společně mísu křidélek. Jirkovi se v průběhu večera udělalo velmi nevolno a zbytek noci prozvracel. Ostatní kamarádi žádné obtíže neměli. Od té doby se Jirka nemůže na kuřecí křidélka ani podívat. Jakým mechanismem lze tuto změnu postoje ke kuřecím křidélkům u Jirky vysvětlit?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""habituací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mechanismem zaplavení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vytvořením podmíněného reflexu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mechanismem introjekce""",
                    false,
                    "inkorporace - internalizace - vnějšku do vnitra"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Se kterým psychickým procesem jsou spojeny postupy kategorizace, indukce a dedukce?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""představivost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""cítění""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""myšlení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """První slova, která již mají nějaký význam, byť mnohdy generalizovaný a nepřesný, začíná většina dětí používat přibližně ve věku:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""1 roku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""7-8 měsíců""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""1,5 roku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""6 měsíců""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Studenti psychologie učili krysy procházet bludištěm. Experimentátoři jim sdělili, že krysy nejsou bohužel stejně kvalitní a nenápadně zařídili, aby se studenti dozvěděli, který z nich má zvíře více a který naopak méně učenlivé. Ve skutečnosti byly všechny krysy stejně kvalitní. Zjistilo se, že studenti kteří pracovali s krysami, které považovali za více učenlivé se více snažili, krys se více dotýkali, lépe využívali vymezený čas atd. a jejich krysy byly podstatně úspěšnější ve srovnání s krysami ostatních studentů. Jaký jev se zde uplatnil?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""haló-efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozptýlení zodpovědnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projev skupinové konformity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sebenaplňující se proroctví""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Termín schémata od F. Bartletta se vztahuje k (ke):""",
            textAnswer = "Zabýval se studiem paměti",
            answers =
            listOf(
                PsychologyTermAnswer("""popisu interpersonálních vztahů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""způsobu uchovávání a vybavování vědomostí""",
                    false,
                    "Vytváříme si v hlavě schémata o světě okolo nás"
                ),
                PsychologyTermAnswer("""způsobu učení se pohybovým dovednostem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""popisu regulace emocí""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Tzv. bystander effect (efekt přihlížejících) znamená, že pravděpodobnost poskytnutí pomoci oběti""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""roste s počtem žen ve skupině.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""roste s počtem svědků nehody.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""klesá s tím, jak počet svědků nehody roste.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""se neváže na počet svědků nehody.""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který obranný mechanismus je výstižně shrnut ve známém úsloví "podle sebe soudím tebe"?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""popření""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sublimace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""racionalizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projekce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Max Wertheimer, Kurt Koffka a Wolfgang Kohler jsou považováni za zakladatele psychologické školy:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""neobehaviorismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neopsychoanalýzy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""transpersonální psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Při psychologické analýze skupiny rozlišují psychologové různé role, které její členové zastávají. Jak označují vůdčí roli, kterou zaujímá silná osobnost prosazující se především svojí odbornou nebo osobnostní autoritou.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""beta""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""alfa""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""omega""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gama""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jestliže máte za úkol vyjmenovat co nejvíce možností, jak použít kancelářskou svorku, využijete především:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""zabíhavé myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""divergentní myšlení""",
                    false,
                    "Pátrání po novém řešení, J. P. Guilford"
                ),
                PsychologyTermAnswer("""konvergentní myšlení""",
                    false,
                    "Myšlení pomocí již prověřených a použitých způsobů řešení, J. P. Guilford"
                ),
                PsychologyTermAnswer("""ulpívavé myšlení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Tzv. Amesova místnost se využívá především ve výzkumu:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""emocí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""motivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""paměti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Bylo zjištěno, že jistá vlastnost je výrazně více determinována geneticky ve srovnání s vlivy prostředí. Tento závěr byl odvozen ze studia podobnosti dvojčat a sourozenců (ne-dvojčat). Vyberte možnost, ve které jsou osoby seřazeny z hlediska podobnosti v této vlastnosti (od nejvyšší po nejnižší).""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """identická dvojčata vychovaná spolu; identická dvojčata vychovaná zvlášť; sourozenci vychovaní spolu; neidentická dvojčata vychovaná spolu""",
                    false
                ),
                PsychologyTermAnswer(
                    """identická dvojčata vychovaná zvlášť; identická dvojčata vychovaná spolu; neidentická dvojčata vychovaná spolu; sourozenci vychovaní spolu""",
                    false
                ),
                PsychologyTermAnswer(
                    """identická dvojčata vychovaná spolu; identická dvojčata vychovaná zvlášť; neidentická dvojčata vychovaná spolu; sourozenci vychovaní spolu""",
                    false
                ),
                PsychologyTermAnswer(
                    """identická dvojčata vychovaná spolu; neidentická dvojčata vychovaná spolu; identická dvojčata vychovaná zvlášť; sourozenci vychovaní spolu""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Jak můžeme na základě řeckého původu slov nejlépe vyložit význam slova psychologie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""láska k vědění""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""věda o duši""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""věda o chování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""láska k myšlení""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """S jakými vlastnostmi/schopnostmi spojovali staří řečtí lékaři individuální poměr tělesných šťáv, konkrétně krve, slizu, žluči a černé žluči?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""temperamentovými vlastnostmi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""motorickými schopnostmi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozumovými schopnostmi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""volními vlastnostmi""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Známý americký psychiatr českého původu Stanislav Grof je představitelem""",
            textAnswer = "ČR původ, transpersonální psychologie - Např. Maslow - transcedentní/spirituální aspekty lidské zkušenosti, holotropní dýchání (\"drogy, zcelující stav\").",
            answers =
            listOf(
                PsychologyTermAnswer("""transakční analýzy""",
                    false,
                    "E. Berne" +
                        "\nMezilidská komunikace. Inspiruje se v psychoanalýze: tři roviny osobnosti:" +
                        "\nDítě - vzpomínky z dětství a naše dětskost (hravost, bezmocnost, spontaneita, hravost,...)." +
                        "\nRodič - vzpomínky toho, co jsme jako děti slyšeli od rodičů a naše rodičovskost (autorita, poučování, dohled,...)." +
                        "\nDospělý - rozumě založené informace, vlastní názory." +
                        "\nPoté analyzujeme  konverzaci jako Dospělý - Dítě bez ohledu na věku."
                ),
                PsychologyTermAnswer("""kognitivně-behaviorální terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kulturní psychoanalýzy""",
                    false,
                    "Neofreudovský směr. Mezilidské vztahy hrajou velkou roli. Fromm, Horneyová"
                ),
                PsychologyTermAnswer("""transpersonální psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Co z následujícího neplatí o tzv. Elektřině komplexu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """jde o jeden z pojmů v rámci teorie psychosexuálního vývoje""",
                    false
                ),
                PsychologyTermAnswer("""v pozadí je nevědomá závist penisu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""týká se vztahu mezi otcem a dcerou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """jde o jednu z poruch osobnosti podle diagnostického manuálu DSM V""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Margaret Mahlerová""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """je autorkou pojmu "individuace" a "separace dítěte"""",
                    false
                ),
                PsychologyTermAnswer("""vytvořila teorii morálního vývoje dítěte""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""se zabývala především obrannými mechanismy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""popsala fáze vyrovnávání se se smrtí""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Kdo je autorem typologie temperamentu, která rozděluje jedince na flegmatiky, choleriky, melancholiky a sangviniky?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""E. Berne""",
                    false,
                    "Transakční analýza:" +
                        "\nMezilidská komunikace. Inspiruje se v psychoanalýze: tři roviny osobnosti:" +
                        "\nDítě - vzpomínky z dětství a naše dětskost (hravost, bezmocnost, spontaneita, hravost,...)." +
                        "\nRodič - vzpomínky toho, co jsme jako děti slyšeli od rodičů a naše rodičovskost (autorita, poučování, dohled,...)." +
                        "\nDospělý - rozumě založené informace, vlastní názory." +
                        "\nPoté analyzujeme  konverzaci jako Dospělý - Dítě bez ohledu na věku."
                ),
                PsychologyTermAnswer("""L. Kohlberg""",
                    false,
                    "Morální vývoj"
                ),
                PsychologyTermAnswer("""P. Zimbardo""",
                    false,
                    "Věznice"
                ),
                PsychologyTermAnswer("""Hippokratés""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Která metoda používaná představiteli psychoanalýzy (například Sigmund Freud) byla považována za královskou cestu do nevědomí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""omráčení jedince elektrickými šoky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""analýza snů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dotazník""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""anamnestický rozhovor""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Carl Gustav Jung předpokládal, že osobnost člověka je utvářena tím, jak reagujeme na svět a prožíváme ho. Která z následujících funkcí nepatří mezi způsoby prožívání světa v Jungově teorii osobnosti?""",
            textAnswer = "(myšlení, cítění, čití/smyslové vnímání, intuice)",
            answers =
            listOf(
                PsychologyTermAnswer("""intuice""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kompenzace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Ve známém filmu Rain Man představuje Dustin Hoffman autistu, který ovšem disponuje také zvláštními schopnostmi v oblasti paměti a početních operací. Jakým termínem se označují osoby s takovými schopnostmi?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""dipsoman""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""savant""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gigant""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprivant""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """U některých osob, především v dětském věku, může být přítomna schopnost přesného zapamatování vizuální informace, označovaná laiky jako fotografická paměť. Jak se tato schopnost v kognitivní psychologii také označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""eidetická představa""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epizodický zásobník""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""echoická paměť""",
                    false,
                    "Ultra krátkodobá paměť: Ikonická paměť (vizuální) do 1s, Echoická (zvuková) 3-4s."
                ),
                PsychologyTermAnswer("""explicitní paměť""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co označujeme termínem sekulární akcelerace?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """dočasné odmítání povinností a závazků typické pro osoby na hranici dospívání a dospělosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """rozvoj náboženského a duchovního života charakteristický pro pozdní věk""",
                    false
                ),
                PsychologyTermAnswer(
                    """urychlení růstu a dospívání ve srovnání s předchozími generacemi""",
                    false
                ),
                PsychologyTermAnswer(
                    """urychlení rozvoje motoriky mezi prvním a třetím rokem života""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Kdo je autorem/autorkou knih Mít či být, Strach ze svobody, Umění milovat?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""E. Fromm""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""C. G. Jung""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""K. Horneyová""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co znamená termín "sociální facilitace"?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """situace, kdy člověk umí dobře nějakou činnost a přítomnost lidí jeho výkon v této činnosti zlepšuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendence přizpůsobovat své názory společnosti, ve které se člověk nachází""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendence přisuzovat své neúspěchy externím činitelům""",
                    false
                ),
                PsychologyTermAnswer(
                    """situace, kdy skupina lidí tahá za jeden provaz a v důsledku nepracují všichni na 100 %""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """V rámci kognitivní psychologie byly zkoumány typické chyby při uvažování o pravděpodobnosti jevů. Např. bylo zjištěno, že lidé mají tendenci považovat při 6 dětech v rodině za pravděpodobnější pořadí narození D/Ch/Ch/D/Ch/D než pořadí Ch/Ch/Ch/D/D/D (Ch=chlapec, D=dívka), ačkoli jsou obě pořadí stejně pravděpodobná. Jak se označuje termín vysvětlující tuto chybu v uvažování?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""efekt kognitivního rámce""",
                    false,
                    "Jiná reakce podle toho, jakým způsobem věc vysvětlíme - třeba pozitivně/negativně."
                ),
                PsychologyTermAnswer("""heuristika ukotvení""",
                    false,
                    "Tzv. \"kotvení se\" na jednu skutečnost a zůstávání u ní",
                    imageExplanationUrl = "https://slideplayer.cz/slide/3341775/11/images/11/Heuristiky+Heuristika+dostupn%C3%BDch+informac%C3%AD+Heuristika+ukotven%C3%AD.jpg"
                ),
                PsychologyTermAnswer("""heuristika reprezentativnosti""",
                    false,
                    "Nejednáme jako statisticky, aplikujeme věci o kterých se snažíme soudit na reálný svět okolo nás a naše zkušenosti."
                ),
                PsychologyTermAnswer("""konstelační efekt""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Jakým termínem označujeme proces, na základě něhož se vědci snaží zobecnit informace získané na vzorku populace na celou populaci?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""statistická indukce""",
                    false,
                    "(z lat. in-ducere, vyvozovat) - od jedinečného k obecnému"
                ),
                PsychologyTermAnswer("""statistická dedukce""",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
                PsychologyTermAnswer("""statistická abstrakce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""statistická abdukce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Podle efektu Zeigarnikové si lidé""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""lépe pamatují nedokončené úlohy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lépe pamatují dokončené úlohy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lépe pamatují těžké úlohy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lépe pamatují lehké úlohy""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Noam Chomsky výrazně přispěl k poznatkům o vývoji člověka. Která z následujích možností odráží jeho závěry?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """vývoj člověka je nekončícím procesem, ve kterém se střetávají procesy asimilace a akomodace""",
                    false,
                    "Piaget"
                ),
                PsychologyTermAnswer(
                    """při osvojování jazyka se u dítěte výrazně uplatňuje vrozená komponenta, která dítěti umožňuje automaticky dekódovat mluvený jazyk a odhalit jeho základní pravidla a principy""",
                    false
                ),
                PsychologyTermAnswer(
                    """morální vývoj člověka probíhá ve třech hlavních stádiích - předkonvenční, konvenční a postkonvenční morálky""",
                    false,
                    "Kohlberg"
                ),
                PsychologyTermAnswer(
                    """při vývoji jazyka dochází k osvojování slov prostřednictvím pokusu a omylu a díky mechanismům zpevňování""",
                    false,
                    "Skinner zpěvňování, Thorndike pokus a omyl"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Co znamená pojem bipolární porucha?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""porucha nálady""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""porucha sexuálního pudu/orientace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nadměrné zvýšení pozornosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """jiný termín pro jednu z poruch příjmu potravy""",
                    false
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jedním ze slavných experimentů sociální psychologie je výzkum provedený v newyorském metru Piliavinem, Rodinem a Piliavinovou v šedesátých letech minulého století. Co z následujícího nebylo v tomto výzkumu sledováno?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""efekt rozptýlené zodpovědnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """poslušnost vůči autoritě jako faktor ovlivňující ochotu poskytnout pomoc""",
                    false
                ),
                PsychologyTermAnswer(
                    """mezipohlavní rozdíly v ochotě poskytnout pomoc""",
                    false
                ),
                PsychologyTermAnswer(
                    """charakteristiky oběti ovlivňující ochotu přihlížejících pomoci""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Se kterým psychologickým směrem se pojí "Little Albert Experiment"?""",
            textAnswer = "Watson, 1920",
            answers =
            listOf(
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Gestalt psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který psychologický směr je založený na pozorovaném chování a nezabývá se vnitřním světem jedince?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""fenomenologie""",
                    false,
                    "(Kant, fenomenální objekty) - jak člověk opravdu vnímá věci, zkušenosti."
                ),
                PsychologyTermAnswer("""individuální psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Význam sourozeneckých vztahů pro další vývoj člověka zdůrazňoval především""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Erik Erikson""",
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
                PsychologyTermAnswer("""Carl Gustav Jung""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Alfred Adler""",
                    false,
                    "Komplex méněcennosti, Neopsychoanalitika, styl žití naučen v 4-5 (drive). Individuální psychologie." +
                        "Pořadí narození:" +
                        "\n\t- Prvorozený - dostává všechnu pozornost do doby, kdy se narodí další - přišel o trůn. Benefituje z moci, je problémový. Snaží se dosáhnout co nejvíce, organizovaní." +
                        " Pokud selže v tom být nejlepší jsou si nejistí." +
                        "\n\t- Druhorozený - tolik mu nezáleží na rodičích, rodiče se tak nesnaží. Prvorození je pro něj model (může si připadat méněcenný a závidet), může být" +
                        " ctižádostivý a ambiciózní nebo úplný opak." +
                        "\n\t- Nejmladší - starší jako modely, velmi rychlý vývoj, buďto jsou hodně závislý na ostatních nebo chtějí dosahovat věcí."
                ),
                PsychologyTermAnswer("""Otto Rank""",
                    false,
                    "Porodní trauma. Žák Freuda, rozhodující je však jak dítě opustí dělohu."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Jakým společným tématem se zabývali tito výzkumníci: Muzafer Sherif, Solomon Asch, Richard Crutchfield?""",
            textAnswer = "Sherif - vliv skupinové dynamiky na hodnocení stimulu" +
                "\nCrutchfield - vlivy skupinových norem na konformitu",
            answers =
            listOf(
                PsychologyTermAnswer("""teorie her""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zrakové vnímání a pozornost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konformita""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Mezi poměrně časté úzkostné poruchy patří obsedantně-kompulzivní porucha. Doplňte slovo místo otazníku: obsese : myšlení / kompulze : ?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""chování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nálada""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""plánování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""percepce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Který z následujících pojmů nepatří mezi ostatní?""",
            textAnswer = "Měří variabilitu",
            answers =
            listOf(
                PsychologyTermAnswer("""směrodatná odchylka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""modus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozptyl""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""interkvartilové rozpětí""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jedním druhem psychoaktivních látek jsou tzv. stimulancia. Mezi ně nepatří""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""amfetaminy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""metadon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kofein""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kokain""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Část pracovní paměti, která slouží pro ukládání informací v akustickém kódu a pro práci s nimi, se označuje jako""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""akustická metareprezentace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fonologická smyčka""",
                    false,
                    " infromace vyjádřené řeči"
                ),
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vizuospaciální náčrtník""",
                    false,
                    "vizuální informace"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Ve známém velkofilmu Pán prstenů bylo pro dosažení žádoucích efektů rozdílné velikosti postav (např. elfové vs trpaslíci či hobiti) kromě technik počítačové animace využito také jevu známého z kognitivní psychologie, kdy postavy blíže ke kameře se jeví být vyšší než postavy situované od kamery dále. Jak se tento efekt označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""efekt Amesovy místnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt aktéra a pozorovatele""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt primarity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt Schrödingerovy kočky""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Psychologové zkoumali vývoj prvních vazeb dítěte, které mají velký dopad na jeho pozdější vývoj. Mary Ainsworthová rozlišila různé typy těchto vazeb. Která z následujících mezi ně nepatří?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vyhýbavá""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""agresivní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""jistá""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ambivalentní""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Autorem známého projektivního testu osobnosti, který tvoří tabule s oboustranně symetrickými inkoustovými skvrnami, je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""A. Binet""",
                    false,
                    "IQ"
                ),
                PsychologyTermAnswer("""H. Rorschach""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""D. Wechsler""",
                    false,
                    "Wechslerův inteligenční test pro dospělé"
                ),
                PsychologyTermAnswer("""F. B. Skinner""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Zajímavým zdrojem poznatků v sociálních vědách jsou interkulturní výzkumy. Např. v první polovině 20. století byl proveden výzkum porovnávající pohlavní role u tří domorodých kmenů na ostrově Nová Guinea. Kdo je autorem/autorkou výzkumu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Margaret Meadová""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Karen Horneyová""",
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
                PsychologyTermAnswer("""John B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""William James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """ Který z mechanismů učení je popsán v následující definici: „vymizení reakce na podnět po jeho několikanásobném opakování“?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""habituace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bezděčné učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""klasické podmiňování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""operantní podmiňování""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co to znamená paměť procedurální?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""paměť pro osobní zážitky""",
                    false,
                    "Epizodická"
                ),
                PsychologyTermAnswer("""paměť pro fakta""",
                    false,
                    "Sémantická"
                ),
                PsychologyTermAnswer("""paměť pro osoby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""paměť pro úkony""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Mezi hlavní psychoterapeutické školy nepatří:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""EFT psychoterapie""",
                    false,
                    "léčba depresí"
                ),
                PsychologyTermAnswer("""humanistická psychoterapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivně-behaviorální psychoterapie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Maslow navrhl hierarchii lidských potřeb. Která z následujících možností obsahuje jejich správné pořadí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """fyziologické potřeby; sounáležitost a láska; jistota a bezpečí; úcta; sebeaktualizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby; jistota a bezpečí; sounáležitost a láska; úcta; sebeaktualizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """jistota a bezpečí; fyziologické potřeby; sounáležitost a láska; úcta; sebeaktualizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby; jistota a bezpečí; úcta; sebeaktualizace; sounáležitost a láska""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Které stadium vývojové teorie nezahrnuje školní věk?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""konvenční stadium (Kohlberg)""",
                    false,
                    "Stádie morálního vývoje" +
                        "\n1.Předkonvenční morálka" +
                        "\n\t-trest, odměna" +
                        "\n2.Konvenční morálka" +
                        "\n\t-chce být hodný kluk/hodná holka, autorita - zákony, pravidla" +
                        "\n3.Postkonvenční (autonomní, hyperkonvenční, principiální 25%) morálka" +
                        "\n\t-společenská smlouva, balance mezi univerzálními a osobními etickými principy"
                ),
                PsychologyTermAnswer("""stadium konkrétních operací (Piaget)""",
                    false,
                    "1.Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\n4.Stadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""anální stadium (Freud)""",
                    false,
                    "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                        "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                        "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                        "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                        "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací."
                ),
                PsychologyTermAnswer("""snaživost versus méněcennost (Erikson)""",
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Které představitele řadíme do psychologického směru behaviorismus?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """John Watson, F.B. Skinner, Edward Tolman, E.L. Thorndike""",
                    false,
                    "Watson - zakladatel behaviorismu" +
                        "\nSkinner - behaviorismus, operantní podmiňování" +
                        "\nTolman - neobehaviorismus (Gestalt)" +
                        "\nThorndike - funkcionalismus (evolucionální důvod za chováním, ne o \"paměti\", ale učení)"
                ),
                PsychologyTermAnswer(
                    """John Watson, F.B. Skinner, Alfred Adler, Clark Hull""",
                    false,
                    "Adler - neopsychoanalýza, infiority komplex" +
                        "\nC. Hull - neobehaviorismus, teorie drive-redukce - bez drivu se neučíme"
                ),
                PsychologyTermAnswer(
                    """John Watson, C.G. Jung, Erik Erikson, Wolfgang Köhler""",
                    false,
                    "Jung - Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící." +
                        "\nW. Kohler - Gestalt psychology (knížka), the mentality of apes (učení, knížka)"
                ),
                PsychologyTermAnswer(
                    """John Watson, F.B. Skinner, Carl Rogers, Arnold Mindell""",
                    false,
                    "C. rogers - příjimání lidí jací jsou (basic need), conditional regard, Client Centered Therapy" +
                        "\nA. Mindell"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Rorschachův test je založen na principu""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""projekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dedukce""",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
                PsychologyTermAnswer("""indukce""",
                    false,
                    "(z lat. in-ducere, vyvozovat) - od jedinečného k obecnému"
                ),
                PsychologyTermAnswer("""sugesce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Popis lidské mysli jako tabula rasa je charakteristický pro""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""solipsismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""racionalismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fenomenologii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""empirismus""",
                    false,
                    "Třeba John Locke"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Na ulici zkolabuje muž, kolem něj se seběhne shluk lidí, ale nikdo nic neudělá, zatímco když ten stejný muž zkolaboval minulý měsíc brzy ráno na opuštěné ulici, náhodný kolemjdoucí okamžitě zavolal sanitku. Jak psychologie tento jev označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální polarizace""",
                    false,
                    "posun skupiny k extrému"
                ),
                PsychologyTermAnswer("""efekt přihlížejícího""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""efekt nečinnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální deziderabilita""",
                    false,
                    "Člověk se chová, jak očekává že daná společnost od něj očekává."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """V některých psychologických výzkumech je nutné držet jeho účastníky určitou dobu v nevědomosti o pravém účelu studie. V takovém případě do eticky prováděného výzkumu patří""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""detecting""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""debriefing""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""defining""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deleting""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Zhoršení choroby po předchozím zlepšení se označuje jako""",
            textAnswer = "",
            imageAnswerUrl = "https://slideplayer.cz/slide/2874175/10/images/14/Etapy+l%C3%A9%C4%8Dby+depresivn%C3%AD+poruchy.jpg",
            answers =
            listOf(
                PsychologyTermAnswer("""relaps""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""resurekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""agravace""",
                    false,
                    "Zveličování obtíží pacientem."
                ),
                PsychologyTermAnswer("""remise""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Edmund Husserl je zakladatelem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""fenomenologie""",
                    false,
                    "(Kant, fenomenální objekty) - jak člověk opravdu vnímá věci, zkušenosti."
                ),
                PsychologyTermAnswer("""frenologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""faktologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Tato porucha osobnosti je charakteristická mělkou a labilní afektivitou‚ sebedramatizací‚ teatrálností‚ přehnaným projevem emocí‚ sugestibilitou‚ egocentričností‚ povolností vůči sobě‚ nedostatkem ohledu na druhé‚ bolestínstvím a trvalým vyžadováním ocenění‚ vzrušení a pozornosti. O jakou poruchu se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""paranoidní porucha osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""histrionská porucha osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizoidní porucha osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""závislá porucha osobnosti""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jaký druh paměti zabezpečuje zapamatování faktických informací, jako jsou například hlavní města či jména prezidentů USA?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""autobiografická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sémantická paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pracovní paměť""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Nedostatek této schopnosti bývá považován za jeden z klíčových deficitů u osob trpících autismem, následkem čehož mají problémy v chápání myšlenkových pochodů jiných osob. Jak se tato schopnost označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""teorie mysli""",
                    false,
                    """Schopnost usuzovat emoce, přání, touhy, potřeby a názory druhých lidí.
                         Také schopnost vytvářet představu o tom, že ostatní lidé mají také mysl a s ní spojené prožitky."""
                ),
                PsychologyTermAnswer("""asimilace a akomodace""",
                    false,
                    "Piaget"
                ),
                PsychologyTermAnswer("""kognitivní kapacita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""attachment""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """V psychologii byly postupně představeny různé teorie emocí. Která z následujících teorií mezi teorie emocí nepatří?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Broadbentova teorie filtrování""",
                    false,
                    "Podle Broadbenta je mezi smyslovými zásobníky a krátkodobou pamětí je filtrovací zařízení."
                ),
                PsychologyTermAnswer(
                    """Schachterova a Singerova teorie kognitivního zhodnocení""",
                    false,
                    "Injekce epinephrinu (fight-or-flight) neměla takový vliv - kognitivní složka a kontext hrají také roli."
                ),
                PsychologyTermAnswer("""Hullova teorie redukce pudů""",
                    false,
                    "drive-reduction theory - bez drivu se neučíme"
                ),
                PsychologyTermAnswer("""Cannonova-Bardova talamická teorie""",
                    false,
                    "Thalamus je pod neustálým útlumem mozkové kúry, emoce však z thalamu uvolní eferentní podněty."
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Co nepatří mezi tvarové zákony?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""zákon proximity""",
                    false
                ),
                PsychologyTermAnswer(
                    """zákon pregnantnosti""",
                    false,
                    "Gestalt zákon, podle kterého Gestalt směřuje vždy k co " +
                        "nejjednoduššímu uspořádání prvků do jednoznačně definovatelného celku"
                ),
                PsychologyTermAnswer("""zákon generalizace""",
                    false
                ),
                PsychologyTermAnswer("""zákon společného osudu""",
                    false,
                    "Podněty, které jdou stejným směrem bereme jako celek"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Co je to Pygmalion efekt?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """druh sociální percepce, globální chyba v posuzování lidí, když jsou posuzováni podle celkového dojmu""",
                    false
                ),
                PsychologyTermAnswer("""sebenaplňující se předpověď""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """psychologické pojmenování momentu náhlého pochopení dříve nesrozumitelného problému a úkolu vhledem""",
                    false
                ),
                PsychologyTermAnswer(
                    """obranný mechanismus ega spočívající v připisování vlastních negativních charakteristik jiným osobám""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Autorem tzv. křivky zapomínání je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Ivan P. Pavlov""",
                    false,
                    "klasické podmiňování"
                ),
                PsychologyTermAnswer("""John Locke""",
                    false,
                    "empirismus"
                ),
                PsychologyTermAnswer("""Edward Thorndike""",
                    false,
                    "pokus a omyl"
                ),
                PsychologyTermAnswer("""Hermann Ebbinghaus""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který řecký myslitel vytvořil typologii osobnosti dle 4 temperamentů odpovídajícím tělním tekutinám?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Sokrates""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Platon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Aristoteles""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Hippokrates""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Fonologická smyčka a vizuálně prostorový zásobník jsou součástí modelu""",
            textAnswer = "Allan Badeley a Hitch." +
                "\nCentrální vykonavatel - pozornost, řídíc a koordinuje pamět, nemá kapacitu." +
                "\nFonologická smyčka - infromace vyjádřené řeči." +
                "\nVizuálně-prostorový náčrtník - vizuální informace.",
            answers =
            listOf(
                PsychologyTermAnswer("""výkonové motivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pozornosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""osvojování řeči""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pracovní paměti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Halucinace se řadí pod poruchy""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""emocí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vůle""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Který z níže uvedených známých psychologických experimentů by bylo v dnešní době obtížné provést z hlediska současných etických principů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Milgramův experiment – poslušnost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Ashovy experimenty – konformita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""experimenty Loftusové – očití svědkové""",
                    false,
                    "Ptali se na rychlost auta ve videu nehody. Pokud bylo použito dramatičtější slovo, lidé hádali vyšší rychlost - vlastní schémata"
                ),
                PsychologyTermAnswer("""Piagetovy experimenty – kognitivní vývoj""",
                    false,
                    "1.Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\n4.Stadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jakým pojmem se v psychologii označuje vnitřní nesoulad postojů a chování člověka?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""kognitivní disonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""disociativní psychóza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""myšlenkový paradox""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""postojová konsonance""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co nepatří mezi psychedelické drogy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psilocybin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""LSD""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""metadon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""meskalin""", false, "z kaktusů")
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Autorem konceptu kolektivního nevědomí je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Eduard von Hartmann""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Johann Friedrich Herbart""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Sigmund Freud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Carl Gustav Jung""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jak se nazývá test, který má vyhodnotit míru, s níž konkrétní programy umělé inteligence uspějí v simulaci inteligence (rozlišení, zda odpovídá člověk nebo počítač)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Turingův test""",
                    false,
                    "V jedné místnosti počítač, v druhé člověk a prostředník komunikace. Pokud člověk pozná, že se jedná o počítač - slabá umělá inteligence," +
                        " v opačném případě to je inteligence silná."
                ),
                PsychologyTermAnswer("""Gardnerův test""",
                    false,
                    "Teorie rozmanitých inteligencí (1983):" +
                        "\n1.Lingvistická inteligence" +
                        "\n2.Logicko-matematická inteligence" +
                        "\n3.Prostorová inteligence - dobrá orientace v prostoru" +
                        "\n4.Muzikální inteligence" +
                        "\n5.Tělesně-pohybová (kinestetická) inteligence" +
                        "\n6.Intrapersonální inteligence - schopnost rozumět sobě samému" +
                        "\n7.Interpersonální inteligence - schopnost rozumět druhým" +
                        "\n8.Přírodní inteligence - rozumět vzorcům ve světě přírody"
                ),
                PsychologyTermAnswer("""Pageův test""",
                    false
                ),
                PsychologyTermAnswer("""Sternbergův test""",
                    false,
                    "Měl úzkosti z testů, tudíž proti ní protestoval." +
                        "\n Úspěšná inteligence - Sternbergovy triarchická teorie - analytická, kreativní a praktická inteligence."
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Ačkoli nebývá zařazena v běžných testech inteligence, je hudební inteligence součástí jedné vlivné teorie inteligence. Kdo je jejím autorem?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Jean Piaget""",
                    false,
                    "1.Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\n2.Předoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                        "\n\n3.Stadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\n4.Stadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer("""Howard Gardner""",
                    false,
                    "Teorie rozmanitých inteligencí (1983):" +
                        "\n1.Lingvistická inteligence" +
                        "\n2.Logicko-matematická inteligence" +
                        "\n3.Prostorová inteligence - dobrá orientace v prostoru" +
                        "\n4.Muzikální inteligence" +
                        "\n5.Tělesně-pohybová (kinestetická) inteligence" +
                        "\n6.Intrapersonální inteligence - schopnost rozumět sobě samému" +
                        "\n7.Interpersonální inteligence - schopnost rozumět druhým" +
                        "\n8.Přírodní inteligence - rozumět vzorcům ve světě přírody"
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
                PsychologyTermAnswer("""Hans Eysenck""",
                    false,
                    "Studoval inteligenci a osobnosti." +
                        "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                        "\nDělení osobnosti:" +
                        "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                        "\n\tExtraverze (vzrušivost mozkové kůry)" +
                        "\n\tNeuroticismus (stabilita - labilita)."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Jak se nazývá alternativa oidipovského komplexu u dívek?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Minervin komplex""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Elektřin komplex""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Afroditin komplex""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Helenin komplex""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """O které kognitivní funkci můžeme říct, že ji dělíme na záměrnou a bezděčnou?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""motivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pozornost""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Nejmenší vidělitelná část slova, která je nositelem věcného či gramatického významu se označuje:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""syntaktická jednotka""",
                    false,
                    "minimální jednotka věty"
                ),
                PsychologyTermAnswer("""morfém""",
                    false,
                    "nesprávný - morfém je \"ne\"(-správný)"
                ),
                PsychologyTermAnswer("""grafém""",
                    false,
                    "základní prvek psaného jazyka \"a\", \"b\", \"ch\""
                ),
                PsychologyTermAnswer("""foném""",
                    false,
                    "zvuk, jehož záměnou ve výrazu určitého jazyka se změní i význam"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """František občas zažívá těžko zvládnutelné stavy, které jsou charakteristické pocity derealizace a depersonalizace a strachu ze ztráty kontroly, výrazným pocením, bušením srdce a bolestmi na hrudi. Občas se přidá i nevolnost. Tyto stavy neklidu jsou pro něj těžko vysvětlitelné, neboť nejsou vyvolány žádným specifickým podnětem. Jakou poruchou František nejpravděpodobněji trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""akrofobií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsedantně-kompulzivní poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bipolární poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""panickou poruchou""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Kognitivní psychologové v experimentech zjistili, že předchozí expozice jednoho podnětu může nevědomě ovlivňovat odpověď na podnět následující. Například slovo pes je rychleji rozpoznáno, pokud následuje po slově kočka, než když následuje po slově strom. Jak se tento jev nazývá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""generalizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sugesce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""priming""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""facilitace""",
                    false,
                    "sociální facilitace - vliv přítomnosti jiných osob na výkon jedince"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Co neplatí o hypnóze?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Více než 50 % osob je vůči hypnóze vysoce rezistentních.""",
                    false,
                    "15% senzitivní, 15% rezistentní"
                ),
                PsychologyTermAnswer(
                    """Hypnóza bývá využívána k významnému snížení vnímání bolesti.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Hypnózy je dosaženo směsicí uvolnění a přesvědčivých sugescí.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Její využití může urychlit terapeutický proces.""",
                    false
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """V rámci psychodynamických teorií byly definovány obranné mechanismy. Který z následujících mezi ně nepatří?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""konfirmace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reaktivní formace""",
                    false,
                    "(reaktivní formace) - potlačil u sebe a chce potlačit i u někoho dalšího"
                ),
                PsychologyTermAnswer("""vytěsnění""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""racionalizace""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Podle kterého autora jsou instinkty Thanatos a Erós klíčovými lidskými motivy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Aristoteles""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""W. Wundt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Galén""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Co platí o Milgramově experimentu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Experiment zkoumal příslušníky kmenů, které do té doby nebyly v kontaktu s moderní civilizací.""",
                    false,
                    "Meadová"
                ),
                PsychologyTermAnswer(
                    """Jeho výsledky výrazně přispěly k pochopení podstaty lidského vnímání.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Experiment se odehrával v prostředí simulované věznice.""",
                    false,
                    "Zimbardo"
                ),
                PsychologyTermAnswer(
                    """V rámci experimentu bylo využito klamání zkoumaných osob o pravém účelu výzkumu.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
    )
}