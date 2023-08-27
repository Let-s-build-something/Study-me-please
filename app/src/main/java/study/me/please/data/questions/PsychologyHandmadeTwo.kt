package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

object PsychologyHandmadeTwo {

    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Komplex méněcennosti je jedním ze stěžejních termínů:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""J. B. Watsona""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
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
                PsychologyTermAnswer("""C. G. Junga""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""S. Freuda""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy 2",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Tzv. Bobo doll experiment byl zaměřen na:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální učení se násilnému chování u dětí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """vztah k panence jako náhradnímu vztahovému objektu u dětí z ústavů""",
                    false
                ),
                PsychologyTermAnswer("""schopnost lhát ve stresové situaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozvoj tzv. teorie mysli s věkem dítěte""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """K léčbě těžké závislosti na opiátech se používají látky působící mechanismem modulace opiátových receptorů. Existují dva základní typy těchto léků: agonisté a antagonisté. Agonisté se váží na opiátové receptory, vyvolávají příjemné pocity a snižují touhu po opiátech. Která látka patří do skupiny agonistů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""antabus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""metadon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""naloxon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""methedrin""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """V rámci modelu pracovní paměti jsou rozlišovány různé součásti. Která součást do modelu pracovní paměti nepatří?""",
            textAnswer = "Model pracovní paměti" +
                "\nAllan Badeley a Hitch." +
                "\nCentrální vykonavatel - pozornost, řídíc a koordinuje pamět, nemá kapacitu." +
                "\nFonologická smyčka - infromace vyjádřené řeči." +
                "\nVizuálně-prostorový náčrtník - vizuální informace.",
            answers =
            listOf(
                PsychologyTermAnswer("""vizuálně prostorový náčrtník""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""centrální exekutiva""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""eidetický registr""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fonologická smyčka""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Rozšířená psychodiagnostická metoda používaná ke zjištění IQ skóru u dospělých jedinců má zkratku:""",
            textAnswer = "",
            imageAnswerUrl = "https://coimages.sciencemuseumgroup.org.uk/images/400/631/medium_SMG00158122.jpg",
            answers =
            listOf(
                PsychologyTermAnswer("""WAIS""",
                    false,
                    "Wechslerův inteligenční test pro dospělé"
                ),
                PsychologyTermAnswer("""TAT""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ROR""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""MMPI""",
                    false,
                    "MMPI. Osobnostní a psychopatologický test pro dospělé. Více než 500 tvrzení, dichotomická škála - ano/ne." +
                        "\nPoužívá se na měření psychického stavu (deprese, paranoia, schizofrenie,...)"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co neplatí o konceptu tendence k aktualizaci?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Tento koncept hraje důležitou roli v tzv. terapii zaměřené na klienta.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Celý proces aktualizace je možno chápat jako sociální dění - prostřednictvím ostatních se stáváme sami sebou.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Podstatou je tendence k naplnění nebo uplatnění všech schopností organismu.""",
                    false
                ),
                PsychologyTermAnswer("""Autorem konceptu je C. Rogers.""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Prožívání emocí může být spojeno s vnímáním vlastní fyziologické aktivace. Jak se odborně tento druh percepce nazývá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""reprezentace druhého řádu""",
                    false,
                    "Mentální reprezentace:" +
                        "\n\t1. Řád = přichází z vnějšího světa - vjemy" +
                        "\n\t2. Řád = subjektivní reflexe psychického dění" +
                        "\n\t3. Řád = snaha porozumění psych. životu druhých - mentální reprezentace o světě druhého člověka",
                    imageExplanationUrl = "https://wikisofia.cz/w/images/0/0a/1.IMG_20211018_171521.jpg"
                ),
                PsychologyTermAnswer("""mentální projekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""viscerální percepce""",
                    false,
                    "tělové vnímání"
                ),
                PsychologyTermAnswer("""fyziologická atribuce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Co je podstatou modelu vývoje E. Eriksona?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Klíčovým faktorem vývoje jsou podmínky prostředí a mechanismy učení.""",
                    false,
                    "Behaviorismus"
                ),
                PsychologyTermAnswer(
                    """Podstatou lidského vývoje je střetávání procesů asimilace a akomodace.""",
                    false,
                    "Piaget"
                ),
                PsychologyTermAnswer(
                    """Lidé procházejí ve svém životě osmi geneticky podmíněnými psychosociálními krizemi.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Jediným zásadním obdobím vývoje je rané dětství, kdy dochází k utváření nevědomých struktur a většiny osobnosti, přičemž nesprávným vývojem může dojít k fixaci na dané stadium.""",
                    false,
                    "Freud"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Ústředním motivem díla V. E. Frankla je:""",
            textAnswer = "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě",
            answers =
            listOf(
                PsychologyTermAnswer("""smysl života""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pud moci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""učení nápodobou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bytostné já""",
                    false,
                    "Jung"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Publikace obsahující systém klasifikace nemocí a jevů s nimi spojených, která je platná pro evropské zdravotnictví, se v češtině označuje zkratkou:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""MKN""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""WHO""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""MRI""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""CGI""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jak se jmenoval slavný experiment, v rámci kterého byla u malého chlapce vyvolána podmíněná reakce strachu z bílého králíka (a následně pak i jiných zvířat a věcí)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Studie malého Alfonse""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Studie malého Johna""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Studie malého Alberta""",
                    false,
                    "Watson"
                ),
                PsychologyTermAnswer("""Studia malého Edmunda""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Jak se označuje zbavení se emoce jejím intenzivním prožitím?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""substituce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""introjekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sublimace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""katarze""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Pokud psychodiagnostické metody dávají opakovatelné, konzistentní výsledky, svědčí to o jejich:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""empirické validitě""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konstruktové validitě""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""aplikabilitě""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reliabilitě""",
                    false,
                    "Dají se výsledky replikovat?"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Jaký je vztah mezi halucinací a iluzí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Iluze není projevem patologie, naopak halucinace je vždy projevem psychotického onemocnění.""",
                    false,
                    "Může být navozeno psychodeliky, migrénou apod."
                ),
                PsychologyTermAnswer(
                    """Iluze je vždy projevem závažnější psychické poruchy než halucinace.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Halucinace nemá na rozdíl od iluze reálný základ.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Iluze je specifickým typem zrakové halucinace.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Co je podstatou James-Langeovy teorie emocí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Druhy emocí, které lidé v určitých situacích prožívají, a chování vhodné pro určité emoce jsou kulturně specifické.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Kognitivní hodnocení výrazně ovlivňuje charakter výsledné emoce.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Autonomní aktivace (a možná i další tělesné změny) diferencují emoce.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Emoční reakce jsou založeny na procesech podmiňování.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících psychologických směrů je nejstarší (jeho vznik je datován před rokem 1900)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""transpersonální psychologie""",
                    false,
                    "1960s"
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    "1900"
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    "1950s"
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    "1895-1896"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Která z následujících osobností není řazena mezi představitele humanistické psychologie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""G. Allport""",
                    false,
                    "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\nFukční autonomie - že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku" +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                ),
                PsychologyTermAnswer("""A. Maslow""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""C. Rogers""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Petr po dobu dvou let používal telefon s operačním systémem Android a nyní dostal k narozeninám nový iPhone s operačním systémem iOS. Ačkoli je velmi technicky zdatný, ovládání nového telefonu mu zpočátku činí veliké potíže z důvodu odlišnosti systému. Jaký termín by pro popis situace použil kognitivní psycholog?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""retrográdní amnézie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zpětné maskování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pozitivní transfer""",
                    false,
                    "kladný přínost minulého učení na nové"
                ),
                PsychologyTermAnswer("""proaktivní interference""",
                    false,
                    "interference přechozích znalostí s novými"
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Mezi gestaltistické zákony nepatří:""",
            imageAnswerUrl = "https://images.slideplayer.cz/41/11152302/slides/slide_53.jpg",
            textAnswer = "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                "\nNěkteré věci, které řešili:" +
                "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                "\nZákon podobnosti - tendence vnímat podobné podněty jako celky.",
            answers =
            listOf(
                PsychologyTermAnswer("""zákon společného osudu""",
                    false,
                    "Podněty, které jdou stejným směrem bereme jako celek"
                ),
                PsychologyTermAnswer("""zákon uzavřenosti""",
                    false,
                    "",
                    imageExplanationUrl = "https://slideplayer.cz/slide/15246770/92/images/22/Z%C3%A1kon+uzav%C5%99enosti+N%C4%9Bkdy+vid%C3%ADme+i+to%2C+co+na+obr%C3%A1zku+nen%C3%AD..jpg"
                ),
                PsychologyTermAnswer("""zákon konkrétnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zákon podobnosti""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Podle Gardnerovy teorie inteligence""",
            textAnswer = "Teorie rozmanitých inteligencí (1983):" +
                "\n1.Lingvistická inteligence" +
                "\n2.Logicko-matematická inteligence" +
                "\n3.Prostorová inteligence - dobrá orientace v prostoru" +
                "\n4.Muzikální inteligence" +
                "\n5.Tělesně-pohybová (kinestetická) inteligence" +
                "\n6.Intrapersonální inteligence - schopnost rozumět sobě samému" +
                "\n7.Interpersonální inteligence - schopnost rozumět druhým" +
                "\n8.Přírodní inteligence - rozumět vzorcům ve světě přírody",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """je možno inteligenci definovat jako obecnou schopnost získávat informace a aplikovat je.""",
                    false
                ),
                PsychologyTermAnswer(
                    """je možno schopnosti rozdělit podle pěti druhů operací, pěti druhů obsahů a šesti druhů produktů.""",
                    false
                ),
                PsychologyTermAnswer(
                    """neexistuje jen jedna duševní schopnost, ale řada různých a vzájemně propojených typů inteligence.""",
                    false
                ),
                PsychologyTermAnswer(
                    """je možno IQ skór odvodit jako podíl mentálního a chronologického věku.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který z rysových faktorů není řazen mezi základní dimenze osobnosti v rámci teorie Big Five?""",
            textAnswer = "1. Otevřenost (zkušenostem)" +
                "\n2. Svědomitost - sebekontrola" +
                "\n3. Extraverze - sociabilita a aktivita lidí" +
                "\n4. Přívětivost (agreebleness) - ochota ustupovat (pomáhat) pro dobro druhých" +
                "\n5. Neuroticismus - jak jedinec prožívá negativní emoce, úzkost, náladovost",
            answers =
            listOf(
                PsychologyTermAnswer("""neuroticismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoticismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""svědomitost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""otevřenost""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jak se nazývá druh paměti, ve které ukládáme autobiografické vzpomínky vázané na konkrétní čas a místo?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pracovní paměť""",
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
                PsychologyTermAnswer("""epistemologická paměť""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Na základě experimentů s naučenou bezmocností navrhl M. Seligman kognitivní teorii, která vysvětlovala vznik:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""autismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""demence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprese""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Najděte společný nebo nadřazený pojem: systematická desenzibilizace, zaplavování, averzivní terapie, pozitivní zpevnění.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""behaviorální terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rogeriánská terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt terapie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Existuje více teorií, jak u dětí dochází k osvojování jazyka. Kdo je autorem teorie, že si děti osvojují jazyk automaticky, pokud mu jsou vystaveny a že při osvojování jazyka hrají důležitou roli vrozené faktory - např. že je dítě disponováno rozpoznat a užívat tzv. jazykové univerzálie?""",
            textAnswer = "Jazykové univerzálie - jazykové složky, které jsou společné pro všechny jazyky",
            answers =
            listOf(
                PsychologyTermAnswer("""N. Chomsky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""J. Piaget""",
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
                PsychologyTermAnswer("""G. Allport""",
                    false,
                    "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\nFukční autonomie - že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku" +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jak se nazývá obranný mechanismus, který umožňuje vyjádření nevědomých impulzů prostřednictvím chování představujícího společensky přijatelnou symbolickou alternativu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""reaktivní výtvor""",
                    false,
                    "(reaktivní formace) - potlačil u sebe a chce potlačit i u někoho dalšího"
                ),
                PsychologyTermAnswer("""sublimace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sugesce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vytěsnění""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Pojem "hlavonožec" se ve vývojové psychologii vztahuje k popisu""",
            textAnswer = "2-4 roky",
            answers =
            listOf(
                PsychologyTermAnswer("""dětské kresby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dětské hry""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pohybových vzorců v batolecím věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""senzomotorického vývoje kojence""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Anekdoticky lze tuto poruchu spánku vyjádřit následovně: usne-li během přednášky student, je to zcela normální. Usne-li přednášející, můžeme u něj pomýšlet právě na tuto poruchu. O jakou nemoc se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""spánková apnoe""",
                    false,
                    "Zástava dechu v spánku"
                ),
                PsychologyTermAnswer("""insomnie""",
                    false,
                    "nespavost"
                ),
                PsychologyTermAnswer("""narkolepsie""",
                    false,
                    "Člověk není schopen regulovat cyklus spánku a bdění"
                ),
                PsychologyTermAnswer("""katatonická schizofrenie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Psycholožka se zabývá vývojem řeči u dětí. Náhodně vybere 5 skupin, každou o 50 dětech, a porovná jejich porozumění a produkci řeči. Jednotlivé skupiny dětí jsou ve věku 6 měsíců, 9 měsíců, 1 roku, 2 a 5 let. Jaký přístup výzkumnice používá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""longitudinální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""narativní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""průřezový""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""idiografický""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """S kterou oblastí psychologie či teorií je především spojováno jméno Margaret Meadová?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""interkulturní rozdíly""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie kolektivního nevědomí""",
                    false,
                    "Jung"
                ),
                PsychologyTermAnswer("""zkoumání postojů a možnosti jejich změny""",
                    false,
                    "Festinger"
                ),
                PsychologyTermAnswer("""zkoumání instrumentální agrese""",
                    false,
                    "Předem plánovaná, není cílem, pouze pomůcka."
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """H. Eysenck ve své teorii osobnosti propojil klasické temperamentové typy s výsledky faktorově-analytických studií osobnosti. Jak by bylo možno v souladu s jeho teorií nejlépe charakterizovat cholerika?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""emočně nestabilní extravert""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emočně nestabilní introvert""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emočně stabilní introvert""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emočně stabilní extravert""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Která disciplína psychologie se zabývá zejména fylogenezí a ontogenezí psychiky?""",
            textAnswer = "biologická psychologie – zkoumá vzájemné vztahy mezi tělesnými a psychickými procesy\n" +
                "psychologická metodologie – řeší problémy, které souvisejí s pochopením metodologických přístupů (výzkumných projektů a teorií) a jejich užitím v psychologii\n" +
                "obecná psychologie – přináší obecné poznatky o psychice člověka, studuje chování, motivaci a prožívání, má význam při zpracování základních teoretických otázek\n" +
                "psychologie osobnosti – zabývá se strukturou, vývojem a dynamikou osobnosti; dnes je její významnou součástí diferenciální psychologie\n" +
                "psychopatologie – studuje změny (chorobné) psychických jevů, které mají různé příčiny (společenské, neurologické, endokrinologické aj.)\n" +
                "sociální psychologie – zabývá se vlivem společenských faktorů na lidskou psychiku a interakcí\n" +
                "kognitivní psychologie – zkoumá způsob vnímání a zpracování informací dodaných smyslovými orgány\n" +
                "vývojová psychologie – studuje fylogenetický (vývoj druhu organismu) a ontogenetický (vývoj jednoho organismu) vývoj lidské psychiky, sleduje změny psychiky od početí do smrti",
            answers =
            listOf(
                PsychologyTermAnswer("""psychopatologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obecná psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývojová psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Na přelomu 19. a 20. století byla tato látka zvyšující energii a sebedůvěru hojně používána, autorem jedné z prvních studií o jejích účincích byl Sigmund Freud. Jde o vysoce návykovou látku, což postupně vedlo k jejímu zákazu. O jakou drogu se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""extáze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""heroin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kokain""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""LSD""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """V šedesátých letech minulého století byl populární jistý směr psychoterapie, jehož základní myšlenky byly zachyceny v knihách Jak si lidé hrají (Games People Play) nebo Co řeknete, až pozdravíte (What Do You Say After You Say Hello?). Jak se jmenoval čelní představitel této terapie a autor těchto knih?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Carl Gustav Jung""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Eric Berne""",
                    false,
                    "E. Berne" +
                        "\nMezilidská komunikace. Inspiruje se v psychoanalýze: tři roviny osobnosti:" +
                        "\nDítě - vzpomínky z dětství a naše dětskost (hravost, bezmocnost, spontaneita, hravost,...)." +
                        "\nRodič - vzpomínky toho, co jsme jako děti slyšeli od rodičů a naše rodičovskost (autorita, poučování, dohled,...)." +
                        "\nDospělý - rozumě založené informace, vlastní názory." +
                        "\nPoté analyzujeme  konverzaci jako Dospělý - Dítě bez ohledu na věku."
                ),
                PsychologyTermAnswer("""Stanislav Grof""",
                    false,
                    "ČR původ, transpersonální psychologie - Např. Maslow - transcedentní/spirituální aspekty lidské zkušenosti, holotropní dýchání (\"drogy, zcelující stav\")."
                ),
                PsychologyTermAnswer("""Carl Rogers""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Stav označovaný jako delirium tremens se vyskytuje""",
            textAnswer = "Nebo také alkoholové delirium, náhlý abstinenční syndrom.",
            answers =
            listOf(
                PsychologyTermAnswer("""u neurotických jedinců""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""u mentálně retardovaných jedinců""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""u schizofreniků""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""u osob dlouhodobě závislých na alkoholu""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Která z následujících poruch se nejpravděpodobněji rozvine u osob, které prožily přírodní katastrofu, např. zemětřesení v Japonsku?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""posttraumatická stresová porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""porucha příjmu potravy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fobie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Ve které fázi vývoje musí podle E. Eriksona jedinec řešit psychosociální krizi IDENTITA vs. ZMATEK?""",
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
                PsychologyTermAnswer("""střední dospělost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""třetí až pátý rok života""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mladší dospělost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""adolescence""",
                    false,
                    ""
                ),
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Který z uvedených nepatří mezi představitele humanistické psychologie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Carl Rogers""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Rollo May""",
                    false,
                    "Existenciální a humanistická psychologie. Love and Will (1969)"
                ),
                PsychologyTermAnswer("""A. H. Maslow""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Helena vypráví kamarádce, jak minulý týden probíhal maturitní večírek její třídy. Který druh paměti se u Heleny při tomto vybavování nejvíce uplatňuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""krátkodobá paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sémantická paměť""",
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Pro kterou poruchu je charakteristický hluboký problém s porozuměním sociálnímu prostředí, což vede k narušení verbální i neverbální komunikace a schopnosti rozvinout normální sociální vztahy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""autismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""panická úzkostná porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprese""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální anorexie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Výzkumníci vyvolali v osobách žádajících po telefonu charitativní dary přesvědčení, že mohou očekávat vysokou úspěšnost. Když zkoumané osoby ve skutečnosti nezískaly žádné dary, objevovalo se u nich bouchání telefonem, vulgární výrazy atd. Pro podporu které teorie či hypotézy svědčí tyto výsledky?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""hypotéza frustrace-agrese""",
                    false,
                    "Skupina z Yale (J. Dollard, N. E. Miller) - Frustrace navozuje pohotovost k agresi, ale její projev závisí na dalších okolnostech"
                ),
                PsychologyTermAnswer("""teorie kognitivní dizonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie emocionální aktivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předpoklad poslušnosti vůči autoritě""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Které z uvedených tvrzení je nejvíce opodstatněnou kritikou (raného) behaviorismu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""behaviorismus podceňoval význam učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """behaviorismus nebral v úvahu emoce a myšlenky""",
                    false
                ),
                PsychologyTermAnswer(
                    """behaviorismus byl příliš závislý na metodě introspekce""",
                    false
                ),
                PsychologyTermAnswer("""behaviorismus nevyužíval vědecké metody""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """V přehledové studii bylo zjištěno, že průměrná hodnota korelace mezi inteligencí identických dvojčat vychovávaných společně je 0,86, u identických dvojčat vychovávaných zvlášť je to 0,72 a u neidentických dvojčat vychovávaných spolu je korelace 0,60. Jaký závěr můžeme učinit?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """z těchto údajů nelze žádný závěr o podílu genetických faktorů a faktorů prostředí na výši inteligence vyvodit""",
                    false
                ),
                PsychologyTermAnswer(
                    """na výši inteligence mají výrazně vyšší vliv faktory prostředí než vrozené (genetické) faktory""",
                    false
                ),
                PsychologyTermAnswer(
                    """na výši inteligence mají výrazně vyšší vliv vrozené (genetické) faktory než faktory prostředí""",
                    false
                ),
                PsychologyTermAnswer(
                    """podíl faktorů prostředí a genetických faktorů na výši inteligence je zhruba stejný""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Zkratky PET, MRI, MEG označují""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """zobrazovací techniky používané při zkoumání mozku""",
                    false
                ),
                PsychologyTermAnswer(
                    """baterie osobnostních testů určených pro diagnostikování psychopatologických rysů osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """tři základní indexy při zkoumání polygrafem (detektorem lži)""",
                    false
                ),
                PsychologyTermAnswer("""uspořádání kvaziexperimentálních plánů""",
                    false,
                    "(Quasi-experiment, přírodní experiment) - různé skupiny podle atributů  charakteristik (pohlavím, věk, neurotismus), bez kontrolní skupiny"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """„Všichni psychiatři jsou blázni. Každý blázen trpí stihomamem. Z toho plyne, že všichni psychiatři trpí stihomamem." Jaký typ myšlení tento sled tvrzení představuje?""",
            textAnswer = "Stihomam - pocity pronásledování",
            answers =
            listOf(
                PsychologyTermAnswer("""deduktivní usuzování""",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
                PsychologyTermAnswer("""kreativní myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vhled""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""induktivní usuzování""",
                    false,
                    "(z lat. in-ducere, vyvozovat) - od jedinečného k obecnému"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Festinger a Carlsmith zjistili, že lidé mění své chování a názory tak, aby byly v souladu s jejich minulými skutky. Jak se tato teorie označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""teorie kognitivní dizonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie obětního beránka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie objektních vztahů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie osobních konstruktů""",
                    false,
                    "George Kelly se domníval, že na lidi by se mělo pohlížet jako na intuitivní vědce." +
                        "\nCílem psychologa by pak mělo být objevení dimenzí, které používají sami jedinci k interpretaci a vytváření sebe samých nebo svých sociálních světů"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """STRACH : FOBIE = SMUTEK : ? Z nabízených pojmů vyberte ten, který se významově nejvíce hodí namísto otazníku:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""apatie""",
                    false,
                    "naprostá pasivita, zeslabení zájmů a reakcí vůči vjemům"
                ),
                PsychologyTermAnswer("""sklíčenost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsese""",
                    false,
                    "Opakované, vtíravé myšlenky (nápady), pudy a činy."
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
            """Výzkumník chce zjistit, jak sledování televizních pořadů souvisí s mírou dětské agrese. U skupiny 45 dětí po dva týdny sleduje, kolik hodin stráví sledováním televize. Současně při volném hraní dětí ve školce zaznamenává u každého dítěte počet agresivních projevů. O jaký typ experimentu jde?""",
            textAnswer = "Typy experimentů:" +
                "\n\nMezisubjektový experiment - 2 a více skupiny účastníků" +
                "\n\nVnitrosubjektový experiment - porovnává různé výsledky stejné skupiny" +
                "\n\nVícefaktoriální experiment - více než jeden faktorů, zkoumá faktory" +
                "\n\nField experimentů - v přirozeném prostředí" +
                "\n\nKvaziexperiment (Quasi-experiment, přírodní experiment) - různé skupiny podle atributů  charakteristik (pohlavím, věk, neurotismus), bez kontrolní skupiny",
            answers =
            listOf(
                PsychologyTermAnswer("""experiment s vnitrosubjektovým plánem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""experiment s mezisubjektovým plánem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nejedná se o experiment""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vícefaktoriální experiment""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Zajímavou otázkou pro psychology je již delší dobu způsob, jakým lidé řeší problémy. Který z následujících směrů je charakterizován holistickým přístupem, rozlišením produktivního a reproduktivního myšlení a důrazem na mechanismus vhledu při řešení problémů?""",
            textAnswer = "reproduktivní (repetice, podmiňování) vs. produktivní (nové myšlenky) přemýšlení",
            answers =
            listOf(
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""strukturalismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""informační psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """V metodologicky správném výzkumném plánu je nutné co nejvíce eliminovat možné zdroje zkreslení výsledků výzkumu. Který zdroj zkreslení se snažíme odstranit užitím jednoduché slepé kontroly a případně klamáním o skutečném účelu experimentu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""operacionalizace proměnných""",
                    false,
                    "Z abstraktního/teoretického do měřitelného/sledovatelného"
                ),
                PsychologyTermAnswer("""účinek pořadí při opakovaném měření""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""umělost prostředí (ekologická validita)""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """charakteristiky požadavku (vyhovění předpokládaným požadavkům experimentátora)""",
                    false,
                    "Také Hawthornský efekt"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Při výzkumech skupinového rozhodování bylo zjištěno, že skupinová diskuse vede k rozhodnutím, která jsou ve srovnání s individuálními rozhodnutími extrémnější. Například jestliže se jednotliví členové skupiny původně přikláněli k riskantnějšímu řešení nějakého dilematu, potom skupina ještě více riskovala; jestliže se členové skupiny přikláněli k opatrnějšímu řešení, skupina byla ještě opatrnější. Jak se tento vliv skupiny označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""skupinová polarizace""",
                    false,
                    "posun skupiny k extrému"
                ),
                PsychologyTermAnswer("""pluralitní ignorance""",
                    false,
                    "podřízení skupinovým normám"
                ),
                PsychologyTermAnswer("""deindividualizace""",
                    false,
                    "Např. Zimbardo - vězeňský experiment"
                ),
                PsychologyTermAnswer("""sociální facilitace""",
                    false,
                    "sociální facilitace - vliv přítomnosti jiných osob na výkon jedince"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Pořadí mezi sourozenci (tzv.sourozenecká konstelace) je důležité v teorii osobnosti""",
            textAnswer = "",
            answers =
            listOf(
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
                PsychologyTermAnswer("""Maxe Luschera""",
                    false,
                    "Luscherů test" +
                        "\n\tProjektivní test osobnosti (manipulační). Výběr mezi barvami - každý má jinou preferenci, která je podvědomě vedena."
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
                ),
                PsychologyTermAnswer("""Carla Gustava Junga""",
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
                PsychologyTermAnswer("""Rorschachův test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Analytický test inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Test nedokončených vět""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Čtyřletá Anička se dívá z okna, pozoruje déšť a nahlas uva-žuje: „Proč prší? Asi to ví, že jsme doma.“ Jde o""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""normální projev myšlení dítěte v tomto věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projev myšlení autistického dítěte""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """projev myšlení mentálně retardovaného dítěte""",
                    false
                ),
                PsychologyTermAnswer(
                    """projev myšlení extrémně rozmazleného dítě, které si myslí, že se vše vždy točí kolem něj""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Tento známý vědec, bratranec Charlese Darwina, přispěl svými objevy nejen psychologii, ale i dalším vědám. Byl jedním z prvních, kdo se pokusil vyvinout inteligenční testy, zabýval se výzkumy představivosti, do metodologie psychologie přinesl koncept korelačního koeficientu a použití dotazníkových metod. O kterého vědce jde?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Johann Gregor Mendel""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""John Locke""",
                    false,
                    "Empirismus, blank slate - \"Vím, protože jsem to zažil\", Dualismus (duše, tělo), Asocianismus - psychické dění jsou spoje mezi psych. obsahy"
                ),
                PsychologyTermAnswer("""William James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer("""Francis Galton""",
                    false,
                    "Sociální Darwinismus, eugenika - pokus šlechtit lidský gen, vytvořil koncept \"korelace\""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Alena se chová velmi zvláštně. Mívá delší období, kdy poci-ťuje silný smutek, nedokáže se z ničeho radovat a vlastně se ani přimět k nějaké činnosti. Poté se ale její chování a nálada úplně změní, celé dny je nadšená, energická, sebevědomá, rychle a hodně mluví, nepotřebuje skoro spát a spřádá velkolepé, nereálné plány. Jakou poruchou Alena nejspíše trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální fobií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bipolární poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsedantně kompulzivní poruchou""",
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
            prompt = """Co nám říká Ebinghausova křivka zapomínání o rychlosti zapomínání?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """nejprve zapomínáme rychle a potom se zapomínání výrazně zpomalí""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejprve zapomínáme pomalu a potom se zapomínání výrazně zrychlí""",
                    false
                ),
                PsychologyTermAnswer("""zapomínáme pomalu a konstantním tempem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zapomínáme rychle a konstantním tempem""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """V psychologii osobnosti se v poslední době prosazuje poje-tí, které strukturu osobnosti popisuje pomocí „pěti silných“ faktorů (big five factors). Který z následujících nepatří mezi těchto pět základních faktorů?""",
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
                PsychologyTermAnswer("""příjemnost (přívětivost)""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dominance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""extraverze""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Metadon (methadon) je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """návyková látka používaná k léčbě závislosti na heroinu""",
                    false
                ),
                PsychologyTermAnswer(
                    """tělu vlastní hormon podílející se na regulaci růstu""",
                    false,
                    "růstový hormon"
                ),
                PsychologyTermAnswer(
                    """jedním z hormonů produkovaných tělem při stresové reakci""",
                    false,
                    "norepinephrin"
                ),
                PsychologyTermAnswer("""odpadní produkt metabolismu neutrotransmiterů""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jirka včera oslavil osmé narozeniny. V jakém stadiu podle Freudovy teorie psychosexuálního vývoje se nejpravděpodob-něji nachází?""",
            textAnswer = "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací.",
            answers =
            listOf(
                PsychologyTermAnswer("""ve falickém stadiu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve stadiu latence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v orálním stadiu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v genitálním stadiu""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """V dětských jeslích můžeme často pozorovat, že děti po sobě vzájemně pokukují a hrají si podobným způsobem nebo se stejnou hračkou, ale každé samo, bez interakce s ostatními. Jak tento typ hry označuje vývojová psychologie?""",
            textAnswer = "1. Neobsazená hra. Dítě jen pozoruje, nehraje si. Začnou se rozhlížet a pozorovat svět kolem sebe, ale ne nutně lidi v něm.\n" +
                "2. Osamělá hra. Dítě hraje samo bez zájmu o interakci s ostatními.\n" +
                "3. Hra diváka. Dítě pozoruje ostatní v okolí, ale nehraje si s nimi.\n" +
                "4. Paralelní hra. Dítě hraje nebo dělá stejnou činnost jako ostatní kolem sebe současně, ale nemusí s nimi komunikovat.\n" +
                "5. Asociativní hra. Dítě hraje bok po boku s ostatními, občas se zapojuje, ale nekoordinuje úsilí.\n" +
                "6. Kooperativní hra. Dítě si hraje s ostatními při interakci s nimi a zajímá se o ně i o aktivitu.",
            answers =
            listOf(
                PsychologyTermAnswer("""paralelní hra""",
                    false,
                    "děti si jako batolata hrají vedle sebe PARALELNĚ, na svém písečku"
                ),
                PsychologyTermAnswer("""asociální hra""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""izolovaná hra""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asociativní hra""",
                    false,
                    "socializování dětí"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co jsou to anxiolytika?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """jeden z druhů stimulancií (povzbuzujících látek)""",
                    false
                ),
                PsychologyTermAnswer("""léky odstraňující symptomy schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""látky snižující úzkost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""druh antidepresiv – inhibitory MAO""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Kdo založil první psychologickou laboratoř a je často ozna-čován jako „otec psychologie“?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""J. B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""W. Wundt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""G. Stanley Hall""",
                    false,
                    "Funkcionalismus. Předškolní testy, aby zjistil co děti ví. Vývojová (genetická) psychologie."
                ),
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících vědců přišel s teorií vývoje řeči, která předpokládá, že při osvojování jazyka se u dítěte výrazně uplatňuje vrozená komponenta – zabudovaný mechanismus, který dítěti automaticky umožňuje dekódovat mluvený jazyk, který kolem sebe slyší, a odhalit jeho základní pravidla a principy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""J. B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""N. Chomsky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""E. C. Tolman""",
                    false,
                    "Neobehaviorismus, Molární a Molekulární chování" +
                        "\nInspirace z Gestaltu, S-O-R (S-Organism-R), kognitivní a emociální vliv." +
                        "\nKognitivní mapa - Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Jakým pojmem označujeme v psychologickém výzkumu proces, jímž činíme proměnné měřitelné či testovatelné?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""validizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hypotetizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""operacionalizace""",
                    false,
                    "Z abstraktního/teoretického do měřitelného/sledovatelného"
                ),
                PsychologyTermAnswer("""korelace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Na základě experimentů s modifikací chování hospitalizovaných psychotiků pomocí odměn v a letech minulého století zavedly psychiatrické léčebny programy tzv. žetonové ekonomiky. Personál dával pacientům žetony (karty nebo napodobeniny peněz) za žádoucí chování – za udržování čistoty a pořádku, za dobré chování ke spolupacientům apod. Tyto žetony pak pacienti mohli vyměnit za speciální výsady jako lepší pokoj, speciální propustka atd. Na jakém principu byl tento program založen?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""na asertivním výcviku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na averzivním podmiňování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na operantním podmiňování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na klasickém podmiňování""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Některé duševní poruchy, například deprese, se mohou zlepšit samy, jednoduše s uplynutím určité doby – podobně jako běžné nachlazení. Jak se toto zlepšení stavu bez jakékoliv profesionálně poskytované léčby označuje?""",
            textAnswer = "",
            imageAnswerUrl = "https://slideplayer.cz/slide/2874175/10/images/14/Etapy+l%C3%A9%C4%8Dby+depresivn%C3%AD+poruchy.jpg",
            answers =
            listOf(
                PsychologyTermAnswer("""agravace""",
                    false,
                    "Zveličování obtíží pacientem."
                ),
                PsychologyTermAnswer("""spontánní remise""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přirozená adaptace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""disimulace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Dalibora přivedl k terapeutovi jeho velký strach z jízdy autem. Očekává, že terapeut s ním bude pátrat po příčinách a kořenech jeho strachu a tak postupně strach odbourá. Terapeut místo toho Dalibora přiměje, aby s ním sedl do auta a přestože Dalibor zpočátku hystericky ječí, tak s ním 6 hodin jezdí, dokud Daliborův strach nezmizí. Jak se tato terapeutická technika označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""averzivní terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zaplavování (zahlcení)""",
                    false,
                    "vystavování člověka jeho strachům"
                ),
                PsychologyTermAnswer(
                    """systematická desenzibilizace (desenzitizace)""",
                    false,
                    "relaxační metoda"
                ),
                PsychologyTermAnswer("""biologická zpětná vazba (biofeedback)""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Melodii poznáme převedenou i do jiné tóniny a stejně tak geometrický obrazec zůstává stále stejným obrazcem, i když je nakreslen v libovolné barvě a velikosti. Jak se označuje tento jev?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""transpozice""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gradient struktury""",
                    false,
                    "přejíždíme-li zrakem po určité scenérii – dochází ke změnám vnímané členitosti povrchu."
                ),
                PsychologyTermAnswer("""zákon společného osudu""",
                    false,
                    "Podněty, které jdou stejným směrem bereme jako celek"
                ),
                PsychologyTermAnswer("""figura a pozadí""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Z pohledu trichromatické teorie vnímání barev slouží ke vnímání barev pouze tři typy receptorů (čípků). Každý z těchto typů receptorů je citlivý k širokému spektru vlnových délek, ale nejvyšší citlivost má pouze v malém rozsahu. Kdo tuto teorii rozvinul a kvantifikoval?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Hermann von Helmholtz""",
                    false,
                    "Teorie vidění oka, vizuální percepce, barvy, vnímání tónů a zvuků, Empirismus."
                ),
                PsychologyTermAnswer("""Sigmund Freud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Carl Rogers""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""J. B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Pokud test určený k měření inteligence ve skutečnosti měří schopnost čtení, jakou psychometrickou vlastnost test nemá v dostatečné míře?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""objektivitu administrace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""stabilitu v čase""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""validitu""",
                    false,
                    "Měří test opravdu co má měřit?"
                ),
                PsychologyTermAnswer("""reliabilitu (vnitřní konzistenci)""",
                    false,
                    "Dají se výsledky replikovat?"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Dcera Sigmunda Freuda Anna Freudová""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """zcela odmítla psychoanalytický přístup a přiklonila se k behaviorismu""",
                    false
                ),
                PsychologyTermAnswer(
                    """rezignovala na své vzdělání a byla celý život v domácnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """se připojila ke směru gestalt psychologie, který se v té době v Evropě a především v německy mluvících zemích bouřlivě rozvíjel""",
                    false
                ),
                PsychologyTermAnswer(
                    """rozvíjela teorii svého otce a zabývala se především obrannými mechanismy ega""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Psychologické testy a dotazníky jsou ve skříni na katedře psychologie rozděleny podle zaměření. V horní polici najdeme test Army alfa, Army beta, Stanford-Binetova škálu, Wechslerův test, Ravenův test …. O jaké metody se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""testy kreativity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""testy temperamentu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""testy inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projektivní testy osobnosti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Jaká je obvyklá kapacita krátkodobé paměti?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""přibližně sedm prvků""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přibližně 20-25 prvků""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """kapacita krátkodobé paměti je v podstatě neomezená""",
                    false
                ),
                PsychologyTermAnswer(
                    """právě jeden prvek (poté je přesunut do dlouhodobé paměti, aby uvolnil místo pro další)""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.gigacalculator.com/img/calculators/iq-scale.png",
            prompt = """Jaká část populace má IQ vyšší než 130?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""2%""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přibližně 12%""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přibližně 0,2%""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přibližně 20%""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Čtyřletého chlapce (v předkonvenčním stadiu morálního vývoje podle Kohlbergse zeptali, proč není správné bít svého mladšího bratříčka. Jak pravděpodobně zněla jeho odpověď?""",
            textAnswer = "Stádie morálního vývoje" +
                "\n1.Předkonvenční morálka" +
                "\n\t-trest, odměna" +
                "\n2.Konvenční morálka" +
                "\n\t-chce být hodný kluk/hodná holka, autorita - zákony, pravidla" +
                "\n3.Postkonvenční (autonomní, hyperkonvenční, principiální 25%) morálka" +
                "\n\t-společenská smlouva, balance mezi univerzálními a osobními etickými principy",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """chtěl by, aby si o něm všichni mysleli, že je hodný kluk""",
                    false,
                    "konvenční - hodný kluk/hodná holka"
                ),
                PsychologyTermAnswer("""je to proti rodinným pravidlům""",
                    false,
                    "postkonvenční - společenské smlouvy, etika,..."
                ),
                PsychologyTermAnswer(
                    """pokud bude bratříčka bít, bude sám potrestán""",
                    false,
                    "předkonvenční - trest, odměna"
                ),
                PsychologyTermAnswer("""to by se mamince nelíbilo""",
                    false,
                    "konvenční - autorita"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Pro které období lidského vývoje je podle Eriksonovy teorie typická psychosociální krize označená Intimita versus izolace?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""stáří""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""adolescence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""první rok života""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""raná dospělost""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Tomáš by rád vyrazil s přítelkyní na exotickou dovolenou. Nemá ale dost peněz. V práci se mu náhle naskytne příležitost: všichni odešli na oběd a on si všimne, že firemní trezor zůstal odemčený. Co Tomáš udělá? Podle Freuda naše motivace k jednání pramení z dynamického soupeření tří stránek nevě-domé mysli: ega, superega a id. Jak by se nejspíše vyjádřilo Tomášovo superego?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""honem než se někdo vrátí! vezmu co můžu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """nemůžu to udělat, přijdou na mne a vyhodí mě z práce""",
                    false
                ),
                PsychologyTermAnswer("""krást se nemá, je to nemorální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """to si s Hankou užijeme krásnou dovolenou za firemní peníze!""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Klára se přes svého známého seznámila se skupinou osob. Přijetí do skupiny bylo spojeno s iniciačními obřady a také přidělením nového jména Stefanie. Po určité době byla Stefanie vyzvána, aby prodala svůj dům (peníze vložila na účet skupiny) a začala bydlet společně se členy skupiny a přerušila tak komunikaci a kontakty s okolním světem – na kterém členové skupiny stejně vidí převážně negativní stránky. Stefanie je nadšena a přijímá učení skupiny, které dokáže snadno vyřešit všechny myslitelné problémy. Jakékoli pochybnosti jsou umlčeny hned v zárodku. Jakým termínem lze tyto techniky působení na jedince souhrnně označit?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""brainwashing""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""brainstorming""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální inhibice""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální facilitace""",
                    false,
                    "sociální facilitace - vliv přítomnosti jiných osob na výkon jedince"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Obranné mechanismy představují nevědomou obranu ega před nezvládnutými afekty a pudovými přáními. Jako příklad jistého obranného mechanismu je v literatuře uváděna možnost, kdy falicky fixovaná touha ukazovat vlastní penis se projeví prostřednictvím profesní dráhy hasiče, jenž může za velkého zájmu veřejnosti na ulicích rozvinovat silné hadice a vysouvat dlouhé žebříky. O jaký obranný mechanismus se jedná?""",
            textAnswer = "",
            answers =
            listOf(
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
                ),
                PsychologyTermAnswer("""regrese""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Psycholog zkoumá vztah mezi fyzikálními vlastnostmi vizuálního podnětu a tím, jak je tento podnět lidmi vnímán. Do které oblasti či oboru psychologie spadá tento typ zkoumání?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychometrika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální percepce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychofyzika""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Z následujících situací vyberte tu, která je příkladem instrumentální agrese:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """na poště stojí u okénka dlouhá řada zákazníků. Vladimíra po minutách čekání předběhne starší muž. Když tento muž odchází od okénka, Vladimír se neudrží a napadne ho.""",
                    false
                ),
                PsychologyTermAnswer(
                    """při fotbalovém zápase se Martin řítí sám na brankáře a obránce Lukáš nemá jinou možnost, jak ho zastavit a zabránit gólu, než ho srazit k zemi faulem zezadu tak, že Martin si při pádu zraní ruku.""",
                    false
                ),
                PsychologyTermAnswer(
                    """fotbalový zápas skončil pro domácí tým nepříznivě. Po ukončení zápasu se obránce Zdeněk pustí do sporu s kapitánem vítězného týmu a vychrlí na něj proud nadávek, zakončený úderem pěstí.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Zuzana náhodou zahlédne v mobilním telefonu svého manžela milostnou textovou zprávu. V následné hádce se neovládne a manželovi nafackuje.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Oblíbeným tématem dětských kreseb je kresba člověka – nejčastěji blízkých lidí, jako je maminka, tatínek či sourozenci. Pro který věk je typická kresba tzv. hlavonožce, který je charak-teristický hrubým znázorněním hlavy, nohou a hlavních částí obličeje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""2 roky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""6 let""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""8 let""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""4 roky""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Teorie L. Festingera předpokládá, že když není jednání osoby konzistentní s jejími postoji, nepříjemné pocity, které tento nesoulad vyvolává, vedou osobu k tomu, aby uvedla tyto postoje do souladu se svým jednáním. Jak se tato teorie označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""teorie situační atribuce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie kognitivní disonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie obrany ega""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie schematického zpracování informací""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Sebereflexe, tj. zážitek sebe sama, se vyznačuje jistou dvojakostí. Jak tyto dvě základní složky jáství označuje sociální psychogie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""podmětné a předmětné já""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ego a superego""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""id a ego""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsahové a formální já""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Ne všechny vlastnosti či schopnosti jsou do stejné míry ovlivněny prostředím či dědičností. Co z následujícího je nejméně ovlivněno prostředím?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""charakter""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""temperament""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""krystalizovaná (krystalická) inteligence""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Ve filmu Šestý smysl vystupuje v jednom z vedlejších příběhů rodina, kde matka tajně dává své nemocné dcerce do polévky jedovatou látku. Dcera nakonec zemře. Ve filmu šlo nejspíše o příklad poruchy, kdy se pečovatel snaží vyvolat dojem, že je dítě nemocné: buď se snaží namluvit lékařům, že dítě má příznaky choroby nebo je u dítěte dokonce cíleně vyvolává. Cílem osoby, která takto dítě zneužívá, je pouze psychologický profit – chce získat pozornost, péči a obdiv lékařů a dalších osob. Jak se tato porucha souhrnně označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Tourettův syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální retardace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Aspergerův syndrom""",
                    false,
                    "DSM-5 má přímo v autistickém spektru." +
                        "\nNemá opoždění ve vývoji řeči a kognitivních schopností."
                ),
                PsychologyTermAnswer("""Münchhausenův syndrom v zastoupení (by proxy)""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Triangularni_teorie_lasky-cs.svg/1200px-Triangularni_teorie_lasky-cs.svg.png",
            prompt =
            """Láska je pojem, který se obtížně definuje. Podle Sternbergovy triangulární teorie lásky vznikají různé typy vztahu kombinací tří složek. Která z následujících mezi tyto základní složky nepatří?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""intimita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nenávist""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""touha (vášeň)""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""oddanost (závazek)""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Marcela měla před třemi měsíci autonehodu: protijedoucí předjíždějící auto se nestihlo včas zařadit a s Marceliným autem se čelně srazilo. Řidič tohoto auta byl na místě mrtev, jeho spolujezdkyně utrpěla těžká zranění. Marcela vyvázla jen s banálním poraněním ruky. Po psychické stránce však není od té doby zcela v pořádku. Špatně spí, nedokáže se soustředit na práci a nebaví ji ani její dřívější koníčky. Často se jí najednou detailně vybaví okamžik nehody a její hrůzné následky. Stále přemítá, zda sama neudělala nějakou chybu, i když policie připsala vinu řidiči druhého auta. Jakou poruchou Marcela nejpravděpodobněji trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""hysterickou poruchou osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""endogenní depresí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""naučenou bezmocností""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""postraumatickou stresovou poruchou""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Otázka, zda má na lidský vývoj větší vliv dědičnost nebo prostředí, je v psychologii řešena od samého počátku. Čelný představitel jistého směru se k této otázce vyjádřil takto: „Dejte mi na výchovu tucet zdravých dětí a já vám zaručím, že z každé-ho z nich vychovám specialistu, jakého náhodně zvolím – lékaře, právníka, umělce, obchodníka, dokonce i žebráka, zloděje bez ohledu na jeho talent, sklony i bez ohledu na vlastnosti jeho předků“. O představitele kterého směru se jedná?""",
            textAnswer = "Watson",
            answers =
            listOf(
                PsychologyTermAnswer("""funkcionalismus""",
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
                ),
                PsychologyTermAnswer("""humanistická psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jaká metoda kontroly se užívá v psychologickém experimentu, chceme-li vyloučit vliv očekávání výzkumníka na výsledky experimentu?""",
            textAnswer = "Typy experimentů:" +
                "\n\nMezisubjektový experiment - 2 a více skupiny účastníků" +
                "\n\nVnitrosubjektový experiment - porovnává různé výsledky stejné skupiny" +
                "\n\nVícefaktoriální experiment - více než jeden faktorů, zkoumá faktory" +
                "\n\nField experimentů - v přirozeném prostředí" +
                "\n\nKvaziexperiment (Quasi-experiment, přírodní experiment) - různé skupiny podle atributů  charakteristik (pohlavím, věk, neurotismus), bez kontrolní skupiny",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """užití klamu k zakrytí cíle výzkumu subjektům""",
                    false
                ),
                PsychologyTermAnswer(
                    """užití mezisubjektového plánu (vyvážení podmínek)""",
                    false
                ),
                PsychologyTermAnswer("""dvojitě slepý pokus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""informovaný souhlas zkoumaných osob""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Gabriela má často obavy, aby se její patnáctileté dceři něco zlého nepřihodilo. Dnes zase s napětím čeká, až se dcera vrátí z volejbalového turnaje. Snaží se uklidnit, ale nejen že neustále sleduje hodiny, ale chová se i poněkud nelogicky – nemůže si pomoci, stále dokola si obléká a svléká veškeré oblečení, a to v přesně daném pořadí. Jak se tento typ chování označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""bludy""",
                    false,
                    "Nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech"
                ),
                PsychologyTermAnswer("""fobie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""panická porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kompulze""",
                    false,
                    "spojené s chováním"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Kurt Lewin zkoumal vliv stylu vedení na klima ve skupině a výkon. Mezi styly řízení vymezené Lewinem nepatří styl""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""demokratický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""autoritářský""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konsensuální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""liberální""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Výrok naší sousedky Anny Zemanové: „Všechny blondýny s výrazným nalíčením jsou hloupé“ bychom nejspíše mohli zařadit do skupiny""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociálních rolí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projevů skupinové polarizace""",
                    false,
                    "posun skupiny k extrému"
                ),
                PsychologyTermAnswer("""atribučních chyb""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""stereotypů""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který autor zabývající se inteligencí předpokládal, že existuje obecný inteligenční faktor (označovaný „g“), nabývající u jednotlivců různých hodnot?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Louis Thurstone""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Robert Sternberg""",
                    false,
                    "Měl úzkosti z testů, tudíž proti ní protestoval." +
                        "\n Úspěšná inteligence - Sternbergovy triarchická teorie - analytická, kreativní a praktická inteligence."
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
                PsychologyTermAnswer("""Charles Spearman""",
                    false,
                    "Faktorová analýza (Factor analysis, inteligenční faktor g) - statická metoda. " +
                        "\nKdyž máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny, které už nám to predikují a analyzují lépe." +
                        "\nSpearmenova koeficient pořadové korelace - statistická závisost mezi 2 veličinami (korelace)" +
                        "\nVýzkům a zastánce dědičnosti IQ (eugenetika)"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Který z uvedených pojmů nepatří k ostatním třem?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""reaktivní výtvor""",
                    false,
                    "(reaktivní formace) - potlačil u sebe a chce potlačit i u někoho dalšího"
                ),
                PsychologyTermAnswer("""sublimace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""represe""",
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
            prompt = """Co se označuje termínem fobofobie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""strach z vlastní osoby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""strach, že jsem nemocný/á""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""strach, že budu mít strach""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nadměrná obava ze světla""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Podle Ainsworthové lze děti rozdělit do tří typů: bezpečný, nejistý vyhýbavý a nejistý ambivalentní. Na jakém fenoménu je tato typologie založena?""",
            textAnswer = "Strange situation experiment",
            answers =
            listOf(
                PsychologyTermAnswer("""mravní (morální) vývoj""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""připoutání (vazby)""",
                    false,
                    "Navazovala na Bowlbyho"
                ),
                PsychologyTermAnswer("""kognitivní styl""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""temperament""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Bětka umí logicky uvažovat o objektech a událostech. Když jí dá maminka kostky na hraní, dokáže je roztřídit např. podle barvy nebo podle velikosti. V terminologii Piagetovy teorie kognitivního vývoje si uvědomuje stálost objektu a chápe i stálost počtu, množství a hmotnosti. Nedokáže však logicky uvažovat o abstraktních pojmech. Ve kterém stádiu vývoje se Bětka nachází?""",
            textAnswer = "Asimilace a Akomodace \nSenzomotorická inteligence (0-2 roky):" +
                "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                " Strange situation study - attachment styly." +
                "\n\nPředoperační (symbolické, předpojmové) stadium (3-6 let):" +
                "\n\t\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí, konzervace - přelívání tekutin to nádob o jiných velikostí." +
                "\n\nStadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                "\n\nStadium formálních operací (12+)" +
                "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení",
            answers =
            listOf(
                PsychologyTermAnswer("""ve stadiu formálních operací""",
                    false,
                    "to už je abstraktní myšlení"
                ),
                PsychologyTermAnswer("""v předoperačním stádiu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v senzomotorickém stádiu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve stadiu konkrétních operací""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Podnětový materiál jistého psychologického testu se skládá zmnohoznačných obrázků osob a scén, ke kterým má testovaná osoba vymyslet příběh. O jaký test se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Tematický apercepční test""",
                    false,
                    "Projektivní test osobnosti (verbální), nejdominantnější hned po Rorschahovu testu." +
                        "\n32 černobílých obrázků s nejednoznačnými situacemi."
                ),
                PsychologyTermAnswer("""Szondiho test""",
                    false,
                    "Typologie osobností podle 24 obrázků obličejů lidí - kterému se pacient blíží"
                ),
                PsychologyTermAnswer("""Rorschachův test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Minnesotský multifázový osobnostní inventář""",
                    false,
                    "MMPI. Osobnostní a psychopatologický test pro dospělé. Více než 500 tvrzení, dichotomická škála - ano/ne." +
                        "\nPoužívá se na měření psychického stavu (deprese, paranoia, schizofrenie,...)"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Psycholog prezentuje studentům seznam několika desítek slov. Hned poté je požádá, aby si vybavili co nejvíce slov. Jaké bude pořadí jednotlivých částí seznamu podle podílu vybavených slov?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """nejvíce bude vybaveno z počáteční části seznamu, méně z koncové části, nejméně ze střední části""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejvíce bude vybaveno ze střední části seznamu, méně z počáteční části, nejméně z koncové části""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejvíce bude vybaveno z koncové části seznamu, méně ze střední části, nejméně z počáteční části""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejvíce bude vybaveno z koncové části seznamu, méně z počáteční části, nejméně ze střední části""",
                    false,
                    "Ale jen kvůli tomu, že se jich zeptáme okamžitě, jinak by hrál roli primacy efekt více.",
                    imageExplanationUrl = "https://i.ytimg.com/vi/qsZKBsy6yDw/hqdefault.jpg"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.gigacalculator.com/img/calculators/iq-scale.png",
            prompt =
            """Psycholog administruje inteligenční test Josefovi. Po vyhodnocení testu psycholog zjistí, že naměřené IQ Josefa činí 115 bodů. Rozdělení inteligenčních skórů v populaci odpovídá normálnímu rozdělení. Jaká je správná informace, kterou by měl psycholog Josefovi poskytnout, pokud je populační průměr 100 bodů a směrodatná odchylka 15 bodů""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Váš výsledek je dobrý, přibližně 68% osob v populaci dosahuje horších výsledků.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Váš výsledek je dobrý, přibližně 84% osob v populaci dosahuje horších výsledků.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Váš výsledek je dobrý, přibližně 48% osob v populaci dosahuje horších výsledků.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Váš výsledek je dobrý, přibližně 54% osob v populaci dosahuje horších výsledků.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Tato droga vyvolává halucinace již při nízkých dávkách. Halucinace mohou být v podobě živých barev a zvuků nebo i mystické povahy. O jakou drogu se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""heroin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""LSD""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""marihuana""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pervitin""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Výzkumník našel vysokou pozitivní korelaci mezi úspěšností dítěte ve škole a počtem knih, které rodina vlastní. Co je možno z tohoto zjištění vyvodit?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """čtení knih v rodině způsobuje, že se zlepšuje školní výkon dítěte""",
                    false
                ),
                PsychologyTermAnswer(
                    """vlastnictví knih způsobuje, že se zlepšuje školní výkon dítěte""",
                    false
                ),
                PsychologyTermAnswer(
                    """čím více knih u dítěte doma, tím větší je pravděpodobnost, že dítě bude ve škole úspěšné""",
                    false
                ),
                PsychologyTermAnswer(
                    """pokud rodina nevlastní knihy, je důsledkem zhoršení školního výkonu dítěte""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Který fenomén se snaží vysvětlit tzv. teorie obětního beránka?""",
            textAnswer = "E. Goffman - chceme na někoho hodit všechny naše problémy",
            answers =
            listOf(
                PsychologyTermAnswer("""poslušnost vůči autoritě""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vznik paranoidní schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vznik předsudků a kořeny rasismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sklon k homosexuálnímu chování""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Pětiletý Honzík byl dvakrát pokousán kokršpanělem. Poté se u něj objevil panický strach ze všech psů a koček. K jakému procesu došlo z hlediska teorie podmiňování?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""ke generalizaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""k facilitaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""k rozlišení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""k habituaci""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Kryštof má dneska narozeniny. Psycholog by jeho vývoj charakterizoval jako normální. Kryštof umí chodit po schodech nahoru i dolů, postaví věž ze sedmi kostek, napodobí kresbu vertikální čáry, má slovní zásobu 200-slov, ale ještě nepoužívá v řeči minulý čas. Kolik je Kryštofovi let?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""jeden rok""",
                    false
                ),
                PsychologyTermAnswer("""čtyři roky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dva roky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""tři roky""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """S Amesovou místností se můžeme setkat především ve výzkumech v oblasti""",
            textAnswer = "",
            imageAnswerUrl = "https://www.mozaweb.com/cs/mozaik3D/TER/tajekozodas/optikai_szoba/960.jpg",
            answers =
            listOf(
                PsychologyTermAnswer("""psychologie emocí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie motivace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """K léčbě jaké poruchy se nejčastěji využívá skupina psychofarmak označovaných jako neuroleptika?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""mentální anorexie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úzkostná porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprese""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Termín observační učení označuje""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""učení ve skupině""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""učení se pracovním dovednostem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""učení v laboratorních podmínkách""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""učení pozorováním jiné osoby nebo osob""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Pokud Pavel po přečtení novinové zprávy o mučení iráckých vězňů americkými vojáky prohlásí: „Ti vojáci musí být přirozeně brutální a sadističtí, já bych se v takové situaci takto nikdy nezachoval/a“, je možné, že se zde projevuje""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""atribuční chyba""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předsudek""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""haló efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""racionalizace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Slovo čas se skládá""",
            textAnswer = "Foném dokáže rozlišit význam slova, morfém je nejmenší významová jednotka." +
                "\nNapř. \"zmatečný\" má 3 morfémy: \"z\", \"mat\", \"ečný\" (myslím)",
            answers =
            listOf(
                PsychologyTermAnswer("""z jednoho taktu a tří mandů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""z jednoho mandu a tří taktů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""z jednoho fonému a tří morfémů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ze tří fonémů a jednoho morfému""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Na kterou složku osobnosti má zřejmě největší vliv výchova a působení rodiny, školy a společnosti?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""extraverze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""charakter""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emocionalita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fluidní inteligence""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Vyberte, která z dimenzí popisujících osobnost není zastoupena v teorii osobnosti Hanse Eysencka:""",
            textAnswer = "Studoval inteligenci a osobnosti." +
                "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                "\nDělení osobnosti:" +
                "\n\t1. Psychoticismus (zároveň předpoklad k onecmocnění)" +
                "\n\t2. Extraverze (vzrušivost mozkové kůry)" +
                "\n\t3. Neuroticismus (stabilita - labilita).",
            answers =
            listOf(
                PsychologyTermAnswer("""introverze-extraverze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoticismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""svědomitost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neuroticismus""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Psycholog po vyšetření sdělí Tomášovým rodičům, že Tomáš je ambidexter. Rodiče tomu nerozumějí, a tak jim to vysvětlí takto:""",
            textAnswer = "nevyhraněná lateralita",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Tomáš má přibližně stejně obratnou levou i pravou ruku.""",
                    false
                ),
                PsychologyTermAnswer("""Tomáš má nevyhraněnou sexuální orientaci.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """Tomáš trpí častými výkyvy nálad, střídáním depresivní a povznesené nálady.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Tomáš má ambivalentní, rozporuplný vztah ke svým rodičům.""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """„Ať už se jedná o jakékoli jedince, bez ohledu na jejich způsob života, povolání, povahu nebo inteligenci, samým faktem, že se změnili v dav, je ovládne kolektivní mysl, která je nutí cítit, myslet a jednat způsobem zcela odlišným od toho, jak by každý z nich cítil, myslel nebo jednal, kdyby byl ve stavu izolace.“ Kdo je autorem citovaného textu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Carl Gustav Jung""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Theodor Adorno""",
                    false,
                    "Sociolog, frankfurtská škola. Masy lidí, ovládání médii a autoritářství."
                ),
                PsychologyTermAnswer("""Gustave Le Bon""",
                    false,
                    "Psychologie davu (1895)"
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Která z uvedených psychoterapeutických škol se nejvíce zaměřuje na minulost klienta?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""kognitivně-behaviorální terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rogeriánská psychoterapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Pokud zjistíme vztah mezi dvěma měřeními testu u stejných osob po určitém časovém intervalu, případně mezi ekvivalentními formami testu nebo polovinami jednoho testu, o čem těsnost vztahu především vypovídá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""o reliabilitě testu""",
                    false,
                    "Dají se výsledky replikovat?"
                ),
                PsychologyTermAnswer("""o specificitě testu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""o senzitivitě testu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""o validitě testu""",
                    false,
                    "Měří test opravdu co má měřit?"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Vítězslav má strach z neznámého prostředí a vyhýbá se cestování, tlačenicím, ale i otevřeným prostranstvím. Není často schopen ani vyjít ze svého domova. Jakou poruchou Vítězslav nejspíše trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální fobií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""agorafobií""",
                    false,
                    "agora=kde se sjednocují lidé. Fóbie z otevřených prostorů a nemožnosti být v \"bezpečné zóně\""
                ),
                PsychologyTermAnswer("""mentální retardací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""arachnofobií""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Zuzana má sníženou potřebu spánku, mluví rychle a je velmi povídavá, stále má nějaké nové nápady, snadno ale ztrácí pozornost a projevuje se u ní psychomotorický neklid. Většinu doby má abnormálně povznesenou náladu a stále musí něco dělat. Jakou poruchou Zuzana pravděpodobně trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""dezorganizovanou schizofrenií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsedantně-kompulzivní poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""manickou fází bipolární poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""katatonickou schizofrenií""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Jakým společným tématem se zabývali tito výzkumníci: Muzafer Sherif, Solomon Asch, Richard Crutchfield?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""konformita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie her""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zrakové vnímání a pozornost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jiří cítí, že se narodil do špatného těla. Je sice muž, ale cítí se být ženou. Je zoufale nešťastný ze svého fyzického vzhledu. Jakým termínem lze Jiřího označit?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""transsexuál""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bisexuál""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""homosexuál""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hermafrodit""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Tento psycholog byl jedním ze zakladatelů americké psychologie. Je autorem knihy Principles of Psychology. Byl pro něj charakteristický pragmatismus a kritika mechanistického světového názoru německých fyziologů. Zajímal se o množství psychologických fenoménů, např. emoce nebo prožívání náboženské zkušenosti. O jakého psychologa jde?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Kurt Lewin""",
                    false,
                    "Gestalt Psychologie\n" +
                        "Teorie pole - chování = osobnost + prostředí." +
                        "\n typy vedení: autokracie (agrese, rebelie), demokracie (stabilni, prumerne), bez vedení (bez agrese, bez cíle, bez spolupráce)" +
                        "\n\nKonflikty motivů:" +
                        "\n\t- Apetence x apetence - obě stejně přitažlivé motivy, není stabilní a vydrží jen chvíli" +
                        "\n\t- Averze x apetence - přitažlivý motiv s negativním aspektem" +
                        "\n\t- Averze x averze - výběr mezi dvěma negativními motivy, výběr menšího zla, tendence nevybrat ani jeden"
                ),
                PsychologyTermAnswer("""William James""",
                    false,
                    "Funkcionalismus - evolucionální důvod za chováním, ne o \"paměti\", ale učení." +
                        "\nProud vědomí - nepřetržitě měnící se osobní vědomí, a určuje zájem" +
                        "\nPragmatismus - užitečnost empirismu do života" +
                        "\nJames-Langeova teorie emocí - \"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\"." +
                        "\nZásady psychologie (1890)."
                ),
                PsychologyTermAnswer("""John B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""Wilhelm Wundt""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """S termínem noogenní neuróza se můžeme setkat""",
            textAnswer = "Znamená to nedostatek smyslu či cíle v životě",
            answers =
            listOf(
                PsychologyTermAnswer("""v psychoanalýze S. Freuda""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v analytické psychologii C. G. Junga""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v teorii pole K. Lewina""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v logoterapii V. E. Frankla""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Martin navštívil po letech své rodné město a když kráčel ulicemi, vybavoval si náhle věci a události, na které si nedokázal vzpomenout už dlouhou dobu. Tato situace je dobrým příkladem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vybavení závislého na kontextu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """rozdílu mezi záměrným zapomínáním a rozpadem paměťové stopy""",
                    false
                ),
                PsychologyTermAnswer(
                    """rozdílného vybavení záměrně a nezáměrně naučeného materiálu""",
                    false
                ),
                PsychologyTermAnswer("""vlivu rozpadu paměťové stopy na vybavení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Jako tzv. mnemotechnické systémy označujeme:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """testové baterie pro zjišťování skrytých významů vět""",
                    false
                ),
                PsychologyTermAnswer("""zastaralé způsoby vyučování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """terapeutické techniky pro vyvolání potlačených vzpomínek""",
                    false
                ),
                PsychologyTermAnswer("""strategie pro lepší zapamatování""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Asocianistická tradice v psychologii a následně behavioristický přístup má svůj historický zdroj""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""v racionalismu""",
                    false,
                    "Rozum a poznání jsou jediné zdroje informací - proti empirismu"
                ),
                PsychologyTermAnswer("""ve fenomenologii""",
                    false,
                    "Nedeterministcká - svodobná volba, introspekce. E. Husserl, M. Heideggar - filosoficky-humanistický směr. Chtěli přivést zpět vědockost, naše zkušenost je známá jen nám (Rogers)"
                ),
                PsychologyTermAnswer("""v konstruktivismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v empirismu""",
                    false,
                    "Empirismus, blank slate - \"Vím, protože jsem to zažil\", Dualismus (duše, tělo), Asocianismus - psychické dění jsou spoje mezi psych. obsahy"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Vztah učení : paměť je jako vztah tvořivost : …………""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""kognitivní styl""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konvergentní myšlení""",
                    false,
                    "Myšlení pomocí již prověřených a použitých způsobů řešení, J. P. Guilford"
                ),
                PsychologyTermAnswer("""divergentní myšlení""",
                    false,
                    "Pátrání po novém řešení, J. P. Guilford"
                ),
                PsychologyTermAnswer("""temperament""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Pro kterou vývojovou poruchu je typické narušení kognitivního mechanismu označovaného jako tzv. teorie mysli, který umožňuje připisovat lidem duševní stavy (znalosti, přesvědčení, emoce), které mohou být odlišné od našich vlastních stavů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""agnózie""",
                    false,
                    "porucha poznávání předmětů"
                ),
                PsychologyTermAnswer("""Downův syndrom""",
                    false,
                    "Trizomie 21. chromozomu způsobuje"
                ),
                PsychologyTermAnswer("""autismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""afázie""",
                    false,
                    "Afázie - ztráta či porucha řeči"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Vývojová porucha čtení, při které nejsou postiženy jiné intelektové schopnosti, se označuje""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""agrafie""",
                    false,
                    "porucha psaní kvůli poškozenému mozku"
                ),
                PsychologyTermAnswer("""dysortografie""",
                    false,
                    "porucha psaní v rámci gramatiky a pravopisu"
                ),
                PsychologyTermAnswer("""dyslexie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""afázie""",
                    false,
                    "Afázie - ztráta či porucha řeči"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Vyberte, který pojem nepatří k ostatním třem:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""usuzování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""uchování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vybavování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kódování""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Vyberte, se kterým jménem jsou spojeny následující pojmy, vyjadřující fáze jistého procesu: popírání, hněv a zlost, smlouvání, zármutek či deprese, smíření nebo rezignace:""",
            textAnswer = "",
            answers =
            listOf(
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
                PsychologyTermAnswer("""Elisabeth Kübler- Rossová""",
                    false,
                    "psychologie umírání a smrti - Thanatologie" +
                        "\npětifázový model smiřování:" +
                        "\n1. Popírání (denial): Jedinec se snaží ignorovat nebo popírat skutečnost ztráty nebo smrti. Nemusí být ochoten či schopen uvěřit, že se něco takového stalo.\n" +
                        "\n\n" +
                        "2. Hněv a zlost (anger): Jedinec začíná projevovat vztek, hněv a frustraci ohledně ztráty nebo smrti. Může hledat viníky nebo cítit nespravedlnost.\n" +
                        "\n\n" +
                        "3. Smlouvání (bargaining): Jedinec se pokouší vyjednávat nebo dohodnout se situací nebo s vyšší mocí. Může se snažit slibovat, že udělá něco určitého, pokud by se ztráta nebo smrt mohla obrátit.\n" +
                        "\n\n" +
                        "4. Zármutek či deprese (depression): Jedinec prožívá smutek, zármutek a pocit ztráty. Mohou se objevovat symptomy deprese, jako je smutek, beznaděj a ztráta zájmu o normální činnosti.\n" +
                        "\n\n" +
                        "5. Smíření nebo rezignace (acceptance): Jedinec se postupně smiřuje se ztrátou nebo smrtí. Přijímá skutečnost a začíná hledat způsoby, jak se s tím vyrovnat a pokračovat v životě."
                ),
                PsychologyTermAnswer("""Abraham Maslow""",
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://i.pinimg.com/originals/4d/5e/00/4d5e00dde635db1bee998f801e6cfbdd.jpg",
            prompt =
            """Model chování, který byl označen jako chování typu A, charakterizuje podle Friedmana a Rosenmana pacienty s""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""depresí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ischemickou chorobou srdeční""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsedantně-kompulzivní poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""autismem""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Představte si, že odborník v kognitivní psychologii chce zkoumat studenty ve vaší třídě. Kterou z uvedených otázek by jim pravděpodobně položil?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """jakým způsobem se připravujete a učíte na písemku?""",
                    false
                ),
                PsychologyTermAnswer("""jak vycházíte se svými učiteli?""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """objevily se u vás někdy příznaky duševní poruchy?""",
                    false
                ),
                PsychologyTermAnswer("""jaké jsou vaše životní cíle?""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Výzkumník se snaží experimentálně zjistit, zda je nový lék účinný proti bolestem hlavy. Náhodně vybranou skupinu osob rozdělí na dvě podskupiny. Jedné podskupině je dáno placebo a druhé nový lék. Zkoumané osoby mají za úkol při nastupující bolesti hlavy užít lék a zaznamenat, jak dlouho bolest hlavy trvala. Jakou proměnnou je v tomto experimentu užití placeba či nového léku?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""závislou""",
                    false,
                    "očekáváme změny na základě změn v nezávislých proměnných"
                ),
                PsychologyTermAnswer("""kontrolní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""intervenující""",
                    false,
                    "rušivá proměnná, které se snažíme zbavit"
                ),
                PsychologyTermAnswer("""nezávislou""",
                    false,
                    "hodnota, kterou můžeme účelově měnit"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Který z uvedených autorů je tvůrcem tzv. teorie osobních konstruktů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""George Kelly""",
                    false,
                    "George Kelly se domníval, že na lidi by se mělo pohlížet jako na intuitivní vědce." +
                        "\nCílem psychologa by pak mělo být objevení dimenzí, které používají sami jedinci k interpretaci a vytváření sebe samých nebo svých sociálních světů"
                ),
                PsychologyTermAnswer("""Stanislav Grof""",
                    false,
                    "ČR původ, transpersonální psychologie - Např. Maslow - transcedentní/spirituální aspekty lidské zkušenosti, holotropní dýchání (\"drogy, zcelující stav\")."
                ),
                PsychologyTermAnswer("""Sigmund Freud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Zdeněk Matějček""",
                    false,
                    "Dětský psycholog, vliv podmínek v ústavech - deprivace/strádání, vývojová psychologie"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Podnětový materiál jistého psychologického testu se skládá z tabulí, na kterých jsou poměrně složité inkoustové skvrny. O jaký test se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Rosenzweigův obrázkový frustrační test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Tematický apercepční test""",
                    false,
                    "Projektivní test osobnosti (verbální), nejdominantnější hned po Rorschahovu testu." +
                        "\n32 černobílých obrázků s nejednoznačnými situacemi."
                ),
                PsychologyTermAnswer("""Rorschachův test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Szondiho test""",
                    false,
                    "Typologie osobností podle 24 obrázků obličejů lidí - kterému se pacient blíží"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Hráči biliáru různé výkonnosti a dovednosti hrají turnaj před očima publika. Jaký vliv bude mít přítomnost tohoto publika na jejich výkon podle závěrů psychologů o sociální facilitaci?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """u dobrých hráčů dojde ke zvýšení výkonu, u špatných ke zhoršení""",
                    false
                ),
                PsychologyTermAnswer("""u všech hráčů dojde ke zhoršení výkonu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""u všech hráčů dojde ke zlepšení výkonu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """u špatných hráčů dojde ke zvýšení výkonu, u dobrých ke zhoršení""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Tato droga se dobře váže na přirozená receptorová místa bolest tlumících endorfinů v mozku. Vyvolává krátké, ale mimořádně intenzivní pocity euforie, následované delšími účinky utlumení bolesti. Vzniká na ni tolerance, závislost a při jejím odnětí pak dochází k těžkým abstinenčním příznakům. O jakou drogu se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""amfetamin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pervitin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kokain""",
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
            prompt =
            """Jednou z metod výzkumu v psychologii je korelační studie. Vyberte tvrzení, které pro tuto metodu neplatí:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """cílem korelační studie je zjistit, zda existuje vztah mezi dvěma nebo více proměnnými""",
                    false
                ),
                PsychologyTermAnswer(
                    """z jejích výsledků nelze vyvodit příčinu a následek""",
                    false
                ),
                PsychologyTermAnswer(
                    """na rozdíl od experimentu není potřeba jakkoli manipulovat s nezávisle proměnnou""",
                    false
                ),
                PsychologyTermAnswer(
                    """obvykle jde o dlouhodobé a podrobné zkoumání jedince""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jung pokládal za konečný bod vývoje sebeuskutečnění jedincova potenciálu a dosažení duševní rovnováhy, integraci protikladů, seberealizaci – uskutečnění tzv. bytostného Já. Jak tento proces označoval?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""reaktivní formace""",
                    false,
                    "(reaktivní formace) - potlačil u sebe a chce potlačit i u někoho dalšího"
                ),
                PsychologyTermAnswer("""individuace""",
                    false,
                    "uskutečnění tzv. bytostného Já"
                ),
                PsychologyTermAnswer("""introverze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kompenzace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Najděte správný výraz pro déletrvající nedostatek v uspokojování některé ze základních lidských potřeb""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""retardace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""frustrace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""stres""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který z uvedených psychologů nepatří mezi ostatní (z hlediska psychologického směru či přístupu, ke kterému se řadí)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""J. B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""A. Maslow""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""C. L. Hull""",
                    false,
                    "neobehaviorismus, teorie drive-redukce - bez drivu se neučíme"
                ),
                PsychologyTermAnswer("""B. F. Skinner""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Co je podle Freuda hlavním psychologickým smyslem snu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""splnění neuspokojených přání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poskytnout člověku kreativní podněty""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pomoci utřídit si myšlenky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""příprava pro budoucí aktivity""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Piaget popsal v rámci kognitivního vývoje dítěte proces, s jehož pomocí jsou nové objekty, situace nebo myšlenky pochopeny prostřednictvím schémat, které již dítě má. Jak se tento proces označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""abstrakce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""akomodace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konzervace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asimilace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Podle které teorie emocí se vědomé pocity emocí a fyziologické změny objevují jako oddělené, souběžné reakce, tj. podle této teorie není pro vznik emocí nutná ani postačující fyziologická aktivace?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""podle Schachterovy-Singerovy teorie""",
                    false,
                    "Injekce epinephrinu (fight-or-flight) neměla takový vliv - kognitivní složka a kontext hrají také roli."
                ),
                PsychologyTermAnswer("""podle Cannonovy-Bardovy teorie""",
                    false,
                    "Thalamus je pod neustálým útlumem mozkové kúry, emoce však z thalamu uvolní eferentní podněty."
                ),
                PsychologyTermAnswer("""taková teorie emocí neexistuje""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""podle Jamesovy-Langeovy teorie""",
                    false,
                    "\"Jsme smutní, protože pláčeme a veselí, protože se usmíváme\""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Výzkumník ověřuje účinnost léku proti úzkosti ve srovnání s účinností placeba. Postupuje tak, že zkoumané osoby náhodně rozdělí do dvou skupin; jedna skupina dostává lék a druhá placebo. Žádný pacient ani lékaři, kteří jim pilulky podávají a vyhodnocují účinnost, nevědí, kdo dostává lék a kdo placebo. Jak se tato situace označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""dvojitě slepý pokus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""latentní přirozený experiment""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projekt s vnitroskupinovými efekty""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kvaziexperiment""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Pro vzorky vzniklé tzv. samovýběrem – tj. vzniklé pouze z jedinců, kteří se sami dobrovolně rozhodli o své účasti na výzkumu, platí:""",
            textAnswer = "0. \"Nulové\" strategie:" +
                "\n\ta) Samovýběr - podle charakteristiky, se kterou výzkumník nemanipuloval" +
                "\n\tb) Příležitostný výběr (náhodilý, libovolný výběr, dobrovolníci) - zrovna po ruce" +
                "\n1. Pravděpodobnostní (náhodné) strategie" +
                "\n\ta) Prostý náhodný výběr - čistě náhodný, vybírá z rámce" +
                "\n\tb) Systematický náhodný výběr - rámec třízený podle kritéria" +
                "\n2. Záměrné, nepravděpodobnostní strategie" +
                "\n\ta) Kvótní výběr - podle rozložení určitých znaků ve vzorku, často reprezentuje zkoumanou populaci" +
                "\n\tb) Lavinový výběr - doporučení studie respondentů dalším - dobré třeba na sekty, klany apod." +
                "\n3. Kombinované strategie" +
                "\n\ta)Stratifikovaný náhodný výběr - subpopulace podle důležitých charakteristik, následně náhoda" +
                "\n\tb) Výběr pro párování - zámerný výběr respondentů",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """výsledky výzkumu na těchto vzorcích mohou být snadno zobecněny na cílovou populaci""",
                    false
                ),
                PsychologyTermAnswer(
                    """při jejich sestavování se uplatňuje rozdělení do dílčích kategorií (strat)""",
                    false
                ),
                PsychologyTermAnswer("""jsou většinou neetické""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """nejsou často reprezentativní vzhledem k cílové populaci výzkumu""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Bludy jsou poruchy:""",
            textAnswer = "Nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech",
            answers =
            listOf(
                PsychologyTermAnswer("""paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pozornosti""",
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Jak za sebou následují ve vývoji jedince stádia morálního vývoje dle Laurence Kohlberga?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""orientace na to být hodným dítětem, orientace na autoritu/zachování pořádku, orientace na odměnu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""orientace na autoritu/zachování pořádku, orientace na odměnu, orientace na to být hodným dítětem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """orientace na odměnu, orientace na to být hodným dítětem, orientace na autoritu/zachování pořádku""",
                    false
                ),
                PsychologyTermAnswer(
                    """orientace na to být hodným dítětem, orientace na odměnu, orientace na autoritu/zachování pořádku""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Mezi monokulární vodítka pro vnímání hloubky nepatří""",
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
                PsychologyTermAnswer("""relativní velikost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""výška umístění""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""překrývání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""disparita obrazů na sítnici""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Kdo je autorem tzv. terapie zaměřené na klienta, jež se dá charakterizovat jako nedirektivní a zaměřená na seberealizaci jedince?""",
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
                PsychologyTermAnswer("""Carl Rogers""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Abraham Maslow""",
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
            prompt =
            """Skupině dospělých respondentů byl administrován určitý test inteligence. Po dvou měsících byl stejný test administrován stejným respondentům. Mezi oběma měřeními byla zjištěna korelace r=0,90. Těsný vztah mezi oběma měřeními svědčí především o:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vysoké úrovni inteligence respondentů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vysoké úrovni reliability měření""",
                    false,
                    "Dají se výsledky replikovat?"
                ),
                PsychologyTermAnswer("""vysoké úrovni validity měření""",
                    false,
                    "Měří test opravdu co má měřit?"
                ),
                PsychologyTermAnswer("""vysoké úrovni vlivu prostředí na výkon""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """O jakou spánkovou poruchu se může jednat, pokud například přednášející usne uprostřed přednášky či pokud osoba usne uprostřed hovoru?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""paradoxní spánek""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""apnoe""",
                    false,
                    "Zástava dechu v spánku"
                ),
                PsychologyTermAnswer("""insomnie""",
                    false,
                    "nespavost"
                ),
                PsychologyTermAnswer("""narkolepsie""",
                    false,
                    "Člověk není schopen regulovat cyklus spánku a bdění"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Terapeut pomáhá panu Ivovi zbavit se strachu z hadů. Nejdříve se Ivo pouze dívá na obrázky a fotografie hadů a přitom poslouchá svou oblíbenou pohodovou hudbu. Posléze vezme do ruky hračku představující hada. Poté opět za poslechu své oblíbené hudby pozoruje skutečné hady ve skleněných klecích v zoologické zahradě. Jak se označuje technika, kterou terapeut používá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""učení nápodobou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""averzivní terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""systematická desenzibilizace""",
                    false,
                    "u fóbií, relaxační metoda"
                ),
                PsychologyTermAnswer("""operantní podmiňování""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Vyberte tvrzení, které neplatí.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """mentální anorexie a mentální bulimie patří mezi psychotické poruchy""",
                    false
                ),
                PsychologyTermAnswer("""mentální bulimie je porucha příjmu potravy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """mentální anorexie se vyskytuje nejčastěji v dospívání a mladé dospělosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """mentální anorexie se vyskytuje mnohem častěji u žen než u mužů""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Maminka kojí pětiměsíční Věrušku. Její sestra Denisa jí ukáže novou hračku. Věruška přestane pít mléko a hledí na hračku. Poté, co jí Denisa tuto hračku ukazuje už poněkolikáté, Věruška pokračuje v pití mléka a hračky si už moc nevšímá. Jak se nazývá proces, který u Věrušky nastal?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""habituace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dishabituace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""trakce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""distrakce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Americký psycholog Philip Zimbardo je známý především svým výzkumem zelet dvacátého století. O jaký výzkum šlo?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """o experimenty zkoumající tzv. efekt přihlížejícího a rozptýlenou zodpovědnost""",
                    false
                ),
                PsychologyTermAnswer("""o tzv. stanfordský vězeňský experiment""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""o výzkum tzv. kognitivní disonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """o experiment s poslušností vůči autoritě, kde zkoumané osoby zaujímaly roli učitele a udělovaly elektrické šoky žákům""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Tzv. analýza prostředků a cílů (nebo analýza dílčích cílů) a strategie tvorby analogií patří mezi strategie řešení problémů""",
            textAnswer = "Analýza prostředků a cílů - kombinace stoupání na horu a postupem vzad - postupuje vpřed a porovnáváme s finální cílem, v průběhu hledáme nejrychlejší a nejefektivnější cestu." +
                "\nDíky tomuto řešení Newell a Simon udělali počítačový program General Problem Solver.",
            answers =
            listOf(
                PsychologyTermAnswer("""reproduktivní""",
                    false,
                    "Gestalt, Wertheimer"
                ),
                PsychologyTermAnswer("""vhledové""",
                    false,
                    "Gestalt, Kohler"
                ),
                PsychologyTermAnswer("""heuristické""",
                    false,
                    "Newell-Simonova teorie informačně-procesního řešení problémů" +
                        "\nHeuristické řešení" +
                        "\n\t\t-stoupání na horu" +
                        "\n\t\t-postupování vzad" +
                        "\n\t\t-analýza prostředků a cílů"
                ),
                PsychologyTermAnswer("""algoritmické""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Tzv. stoupání na horu (hill climbing) patří mezi strategie řešení problémů""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""reproduktivní""",
                    false,
                    "Gestalt, Wertheimer"
                ),
                PsychologyTermAnswer("""vhledové""",
                    false,
                    "Gestalt, Kohler"
                ),
                PsychologyTermAnswer("""heuristické""",
                    false,
                    "Newell-Simonova teorie informačně-procesního řešení problémů" +
                        "\nHeuristické řešení" +
                        "\n\t\t-stoupání na horu" +
                        "\n\t\t-postupování vzad" +
                        "\n\t\t-analýza prostředků a cílů"
                ),
                PsychologyTermAnswer("""algoritmické""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Tzv. postupování vzad (means-ends analysis) patří mezi strategie řešení problémů""",
            textAnswer = "Postup od cílového stavu k výchozímu stavu.",
            answers =
            listOf(
                PsychologyTermAnswer("""reproduktivní""",
                    false,
                    "Gestalt, Wertheimer"
                ),
                PsychologyTermAnswer("""vhledové""",
                    false,
                    "Gestalt, Kohler"
                ),
                PsychologyTermAnswer("""heuristické""",
                    false,
                    "Newell-Simonova teorie informačně-procesního řešení problémů" +
                        "\nHeuristické řešení" +
                        "\n\t\t-stoupání na horu" +
                        "\n\t\t-postupování vzad" +
                        "\n\t\t-analýza prostředků a cílů"
                ),
                PsychologyTermAnswer("""algoritmické""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Tzv. Problém kyvadla byl/je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""experiment""",
                    false,
                    "Řešení problému jak svázat 2 kusy lana, na které přišlo málo lidí. Poté však výzkumník \"jakoby náhodou\" lano rozhoupal, přičemž všichni na to \"čirou náhodou\", (bez uvědomění si, že jim  bylo pomoci) přišli.",
                ),
                PsychologyTermAnswer("""způsob řešení problémů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""redukcionistická myšlenka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lhaní respondentů v dotazníku""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jedete domů autem svou obvyklou cestou. Náhle si povšimnete, že kousek před vámi cestu zablokovala dopravní nehoda. Bez rozmýšlení zahnete doprava do vedlejší ulice a pokračujete touto jinou cestou domů. Co jste přitom podle amerického psychologa Edwarda Tolmana využili?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""orientační reflex""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""instinkt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní mapu""",
                    false,
                    "Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Co označuje v pojetí Charlese Spearmana tzv. g-faktor?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""obecný inteligenční faktor""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """obecný faktor nevysvětlitelného v rámci parapsychologie""",
                    false
                ),
                PsychologyTermAnswer("""obecný faktor vlivu dědičnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obecný faktor vlivu prostředí""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Vyberte pojem nebo slovní spojení, které nepatří k ostatním.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""projekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""flow fenomén""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""haló efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""atribuční chyba""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Psychiatr se při vyšetřování pacienta vyptává na dosavadní průběh jeho života, na průběh jeho potíží, na rodinné zázemí atd. Jak se označuje soubor těchto údajů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""anamnéza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""autoatribuce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""interview""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fenotyp""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Které z uvedených onemocnění se snaží objasnit tzv. dopaminová hypotéza, pojednávající o nadbytku dopaminu na určitých synapsích v mozku?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""depresi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsedantně-kompulzivní poruchu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""generalizovanou úzkostnou poruchu""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Určete, jak se označuje psychoterapeutický přístup, který pracuje s částmi klientovy osobnosti nazývanými rodič, dítě a dospělý, a jehož autorem je E. Berne:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""gestalt terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""realitní terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""transakční analýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""racionálně-emotivní terapie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Která z uvedených metod nepatří mezi metody zaznamenávání aktivity mozku či zobrazovací techniky používané k vyšetření mozku?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pozitronová emisní tomografie""",
                    false,
                    "PET scan"
                ),
                PsychologyTermAnswer("""magnetická rezonance""",
                    false,
                    "MR"
                ),
                PsychologyTermAnswer("""pletysmograf""",
                    false,
                    "Měření fyziologických parametrů ako např. objem tkáně v důsledku průtoku krve"
                ),
                PsychologyTermAnswer("""evokované potenciály""",
                    false,
                    "měření elektrických signálů mozku"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Výzkumník chce zjišťovat osobnostní souvislosti agrese u předškolních dětí hrajících si společně ve školce. Rozhodne se, že ukazatelem agrese bude u každého dítěte počet fyzických útoků vůči ostatním dětem. Jak se označuje tento proces vymezení proměnné?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""stratifikace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""korelace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""inference""",
                    false,
                    "vyvozování závěru z dat/pozorování"
                ),
                PsychologyTermAnswer("""operacionalizace""",
                    false,
                    "Z abstraktního/teoretického do měřitelného/sledovatelného"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jak za sebou následují ve vývoji jedince psychosociální problémy/krize dle Erika Eriksona?""",
            textAnswer = "Vývoj osobnosi, psychosociální teorie. Každý stádium má krizi, kterou musíme vyřešit abychom mohli pokračovat." +
                "\n1. Důvěra x nedůvěra (do roku)" +
                "\n2. Autonomie x stud (2-3 let) - podobné anal stádiu u Fredu - je dítě učeno být samostatné?" +
                "\n3. Iniciativa x vina (3-5 let) - jak moc nechají rodiče dítě růst" +
                "\n4. Snaživost x méněcennost (6-12 let)" +
                "\n5. Identita x nejistota (12-16)" +
                "\n6. Intimita x izolace (18-35)" +
                "\n7. Reprodukce x stagnace (35-55)" +
                "\n8. Integrita x stagnace (55+)",
            answers =
            listOf(
                PsychologyTermAnswer("""1. píle versus pocity méněcennosti, 2. intimita versus izolace, 3. identita versus zmatek""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""1. identita versus zmatek, 2. píle versus pocity méněcennosti, 3. intimita versus izolace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """1. identita versus zmatek, 2. intimita versus izolace, 3. píle versus pocity méněcennosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """1. píle versus pocity méněcennosti, 2. identita versus zmatek, 3. intimita versus izolace""",
                    false,
                    "1. - Snaživost x méněcennost (6-12 let)" +
                        "\n2. Identita x nejistota (12-16)" +
                        "\n3. Intimita x izolace (18-35)"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Vyberte tvrzení, které neplatí o tzv. pásmové nemoci (jet lag):""",
            textAnswer = "(jet syndrome, desynchronosis ) - narušení spánkových biorytmů z létání do jiných čas. zón." +
                "\nJe to těžší pro Američany než pro evropany - prodloužení dne když se letí z východu na západ je jednodušší pro biorytmy.",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """přizpůsobení je obtížnější, pokud cestujeme pomalu z východu na západ, než když cestujeme rychle ze západu na východ""",
                    false
                ),
                PsychologyTermAnswer(
                    """příznaky pásmové nemoci jsou podobné těm, které se vyskytují v souvislosti s prací na směny""",
                    false
                ),
                PsychologyTermAnswer(
                    """jde o důsledek desynchronizace mezi biorytmy těla a synchronizátory nového časového pásma (doba jídla, intenzita denního světla, atd.)""",
                    false
                ),
                PsychologyTermAnswer(
                    """přizpůsobení je obtížnější, pokud synchronizátory zkracují den a cirkadiánní rytmus, tj. pokud vedou k předbíhání fáze, než v opačném případě""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """V rámci psychologického výzkumu byl zkoumaným osobám předložen popis následující situace: Petře je 27 let, je svobodná, otevřená a velmi chytrá. Na vysoké škole studovala psychologii..... a velmi ji zajímala problematika diskriminace. Zkoumané osoby měly za úkol odhadnout pravděpodobnost dvou tvrzení: 1. Petra je bankovní úřednicí; Petra je bankovní úřednicí a je aktivní ve feministickém hnutí. Pokud většina osob tvrdila, že je druhé tvrzení pravděpodobnější než první, jaké pravděpodobnostní pravidlo bylo při jejich uvažování porušeno?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """pravidlo konjunkce""",
                    false,
                    "pravděpodobnostní pravidlo - kombinace 2 pravděpodobností nemůže být vyšší než jedno z nich - 0.5 (50%) x 0.5 (50%) nikdy nemůže vyjít více jak 0.5 (50%)."
                ),
                PsychologyTermAnswer("""pravidlo příčinnosti""",
                    false
                ),
                PsychologyTermAnswer("""pravidlo poměrného základu""",
                    false
                ),
                PsychologyTermAnswer("""pravidlo podobnosti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Desetiletý Luboš má odmalička problémy s porozuměním sociálnímu prostředí – lidské vztahy jsou pro něj matoucí a nepředvídatelné. Není schopen normální verbální ani neverbální komunikace, při interakcích se známými i neznámými lidmi působí uzavřeně. Jakou poruchou Luboš pravděpodobně trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""bipolární poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální retardací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""posttraumatickou stresovou poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""autismem""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Co se označuje zkratkou DSM?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""klasifikační manuál duševních poruch""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""metoda zobrazení mozku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mnohočetná porucha osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývojová porucha, způsobená genovou mutací""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jak se označuje postup řešení problémů, při kterém jsou systematicky probrána všechna možná řešení?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""algoritmická strategie""",
                    false,
                    "Jako počítač, který zkouší všechny možné variace až na to jednou přijde."
                ),
                PsychologyTermAnswer("""kognitivní restrukturace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""heuristická strategie""",
                    false,
                    "Newell-Simonova teorie informačně-procesního řešení problémů" +
                        "\nHeuristické řešení" +
                        "\n\t\t-stoupání na horu" +
                        "\n\t\t-postupování vzad" +
                        "\n\t\t-analýza prostředků a cílů"
                ),
                PsychologyTermAnswer("""produktivní myšlení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Ve které oblasti psychologie se proslavili Jean Piaget, L. S. Vygotskij, Erik Erikson?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychologická diagnostika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fyziologická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývojová psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychopatologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Přístup, který se zaměřuje téměř výlučně na subjektivní zkušenost a zabývá se osobním pohledem jedince na události se označuje jako""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""fenomenologie""",
                    false,
                    "(Kant, fenomenální objekty) - jak člověk opravdu vnímá věci, zkušenosti."
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychonalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Pro kterou poruchu je charakteristický hluboký problém s porozuměním sociálnímu prostředí, což vede k narušení verbální i neverbální komunikace a schopnosti rozvinout normální sociální vztahy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""panická úzkostná porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""autismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální anorexie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprese""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Piaget označil proces, kdy dítě při setkání s novou událostí modifikuje své schéma (tedy implicitní „teorii“ vysvětlující fungování svět) a rozšiřuje tak svoje chápání světa:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""akomodace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konzervace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asimilace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ekvilibrium""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Autogenní trénink je především""",
            textAnswer = "Víceméně meditace založená na pozitivních sugescích.",
            answers =
            listOf(
                PsychologyTermAnswer("""relaxační metoda""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""metoda pro vytváření nepodmíněných reflexů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""trénink koordinace pohybů a jemné motoriky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""trénink paměti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Helena se pokouší získat řidičský průkaz. U zkoušky jednou přehlédne přednost v jízdě, dvakrát vjede do protisměru a při parkování poškodí lak vedle stojícího automobilu. U zkoušky neuspěje a vysvětlí si to tak, že její řidičské schopnosti jsou dobré, ale provoz na silnici byl hodně rušný a zkušební komisař byl příliš přísný. Jak psychologové označují tento typ úsudku?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální inhibice""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální facilitace""",
                    false,
                    "sociální facilitace - vliv přítomnosti jiných osob na výkon jedince"
                ),
                PsychologyTermAnswer("""kognitivní dizonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""situační atribuce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """„Všichni psychologové jsou blázni. Každý blázen trpí samomluvou. Z toho plyne, že všichni psychologové trpí samomluvou.“ Jaký typ myšlení tento sled tvrzení představuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vhled""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kreativní myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deduktivní usuzování""",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
                PsychologyTermAnswer("""induktivní usuzování""",
                    false,
                    "(z lat. in-ducere, vyvozovat) - od jedinečného k obecnému"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Psychickou deprivací se z českých psychologů nejvíce zabýval""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Zdeněk Matějček""",
                    false,
                    "Dětský psycholog, vliv podmínek v ústavech - deprivace/strádání, vývojová psychologie"
                ),
                PsychologyTermAnswer("""Karel Balcar""",
                    false,
                    "Kognitivní psychologie. Paměť a učení - učení slov, zpětná vazba učení. Sociální učení a vztahy mezi dětmi."
                ),
                PsychologyTermAnswer("""Jaro Křivohlavý""",
                    false,
                    "\n\t1. Hlasitost řeči - šepot / hlučná" +
                        "\n\t2. Výška tónu řeči - bas, alt / tenor, soprán" +
                        "\n\t3. Rychlost řeči" +
                        "\n\t4. Objem řeči - málo / mimořádně mnoho" +
                        "\n\t5. Plynulost řeči - zámlky, pomlky / plynulost" +
                        "\n\t6. Intonace - monotónní / \"téměř zpívá\"" +
                        "\n\t7. Chyby v řeči - přeřeknutí, nedokončené věty / bez chyb" +
                        "\n\t8. Správnost výslovnosti" +
                        "\n\t9. Kvalita řeči - věcnost hovoru - strohý / upovídaný" +
                        "\n\t10. Členění řečí - frázování - bez pauzy / moc pauz"
                ),
                PsychologyTermAnswer("""Josef Švancara""",
                    false,
                    "Psycholog a pedagog, vliv emocí na chování a myšlení. Psychologie reklamy"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co označil Sigmund Freud jako „královskou cestu do nevědomí“?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""hypnózu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""analýzu snů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""volné asociace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vzpomínky z dětství""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících mechanismů by mohl vysvětlovat, proč si někdy nejsme vědomi stálého hučení ledničky?""",
            textAnswer = "Čivost spočívá ve schopnosti registrovat jednoduché podněty a rozlišovat jejich intenzitu. " +
                "\nHorní počitkový práh - buďto již nic necítíme nebo vznikne bolest.",
            answers =
            listOf(
                PsychologyTermAnswer("""senzorická adaptace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozdílový práh podnětu""",
                    false,
                    "hranice, kdy dokážeme rozeznat rozdíl mezi 2 podněty v 50% případů"
                ),
                PsychologyTermAnswer("""Weberův zákon""",
                    false,
                    "Rozlišení dvou podnětů závisí na velikosti základního podnětu. Vycházel z experimentu s intenzitou světla, při kterém zjistil, že když intenzita prvního světla, byla vysoká, musel být i přírůstek větší, než když byla intenzita úvodního světla menší."
                ),
                PsychologyTermAnswer("""absolutní práh podnětu""",
                    false,
                    "Dolní počitkový práh (absolutní práh) - kdy to můžeme ještě rozeznat v 50% případů."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co je předmětem thanatologie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""problematika umírání a smrti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """problematika využití hypnózy a sugesce v medicíně""",
                    false
                ),
                PsychologyTermAnswer(
                    """problematika kulturních rozdílů v myšlení a percepci""",
                    false
                ),
                PsychologyTermAnswer("""problematika integrace handicapovaných osob""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Výzkumná situace, ve které je hodnota jedné proměnné (nezávislá proměnná) soustavně měněna tak, aby se zjistil její vliv na druhou proměnnou (závislá proměnná) se označuje jako:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""srovnávací studie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""experimentální studie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""průřezová studie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""korelační studie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Zkratky PET, MRI, MEG označují""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """zobrazovací techniky používané při zkoumání mozku""",
                    false
                ),
                PsychologyTermAnswer("""uspořádání kvaziexperimentálních plánů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """tři základní indexy při zkoumání polygrafem (detektorem lži)""",
                    false
                ),
                PsychologyTermAnswer(
                    """baterie osobnostních testů, určených pro diagnostikování psychopatologických rysů osobnosti""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Pořadí mezi sourozenci (tzv.sourozenecká konstelaje důležité v teorii osobnosti""",
            textAnswer = "",
            answers =
            listOf(
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
                ),
                PsychologyTermAnswer("""Maxe Lüschera""",
                    false,
                    "Lüscherův test - Projektivní test osobnosti (manipulační). Výběr mezi barvami - každý má jinou preferenci, která je podvědomě vedena."
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Proč se podle Freuda chováme tak, jak se chováme?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""ovládají nás kognitivní procesy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ovlivňuje nás to, jak vnímáme ostatní lidi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""naučili jsme se tak chovat""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """jsme ovládáni sexuálními a jinými biologickými pohnutkami""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Paní Karla, která je druhým rokem hospitalizována v nemocnici po úrazu hlavy při autonehodě, se stále nenaučila nalézt cestu do jídelny. Který typ poruchy paměti je pravděpodobnou příčinou?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""retrográdní amnézie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychogenní amnézie""",
                    false,
                    "Psychogenní - způsobeno psychickými faktory (např. bolest hlavy ze stresu)"
                ),
                PsychologyTermAnswer("""anterográdní amnézie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""prozopagnozie""",
                    false,
                    "Zraková agnózie - porucha poznávání známých tváří"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který přístup v psychologii, rozvíjený na konci století, považoval za předmět psychologie vědomou mysl, jež by se měla zkoumat introspekcí s cílem rozložit prožívání na jednotlivé součásti, jako jsou představy, počitky atd.?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""funkcionalismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""strukturalismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Pro které vývojové období je charakteristická psychosociální krize identity versus zmatku v rolích dle teorie Erika Eriksona?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""třetí až pátý rok života""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mladší dospělost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""adolescence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""střední dospělost""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Najděte společný nebo nadřazený pojem: systematická desenzibilizace, zaplavování, averzivní terapie, pozitivní zpevnění.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""gestalt terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rogeriánská terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorální terapie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Mezi monokulární vodítka k odhadu hloubky nepatří:""",
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
                PsychologyTermAnswer("""výška umístění""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""relativní velikost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dotváření""",
                    false,
                    "",
                    imageExplanationUrl = "https://slideplayer.cz/slide/15246770/92/images/22/Z%C3%A1kon+uzav%C5%99enosti+N%C4%9Bkdy+vid%C3%ADme+i+to%2C+co+na+obr%C3%A1zku+nen%C3%AD..jpg"
                ),
                PsychologyTermAnswer("""překrývání""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """„Vrozeně určená posloupnost růstu a změn, které jsou relativně nezávislé na událostech v prostředí.“ Co je předmětem této definice?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""evoluce""",
                    false,
                    "Přizpůsobování organismů"
                ),
                PsychologyTermAnswer("""zrání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývoj""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nevratné změny v průběhu vývoje""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Specifické poruchy rozpoznávání objektů vznikající u lidí s poškozením mozku lze označit obecným termínem:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""amnézie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""agnózie""",
                    false,
                    "porucha poznávání předmětů"
                ),
                PsychologyTermAnswer("""retardace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""metakognice""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Doplňte na místo otazníku: vrozená : získaná = fluidní inteligence : ?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""figurální inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obecná inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývojová inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""krystalická inteligence""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Stabilita v čase, vnitřní konzistence, shoda posuzovatelů jsou termíny, které sdružuje pojem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""variabilita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""faktorová analýza""",
                    false,
                    "(Factor analysis) - statická metoda. Když máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny," +
                        " které už nám to predikují a analyzují lépe."
                ),
                PsychologyTermAnswer("""reliabilita""",
                    false,
                    "Dají se výsledky replikovat?"
                ),
                PsychologyTermAnswer("""validita""",
                    false,
                    "Měří test opravdu co má měřit?"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
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
                PsychologyTermAnswer("""schizofrenií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""depresí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální anorexií""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Která z uvedených nepatří mezi aplikované psychologické disciplíny?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""forenzní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pedagogická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""klinická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývojová psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jiří má předsudky vůči Romům, Vietnamcům a jiným menšinám. Vůči svému vedoucímu v práci je submisivní a servilní, ale k lidem s nižším postavením se Jiří chová nepřátelsky a s opovržením. Jak sociolog Adorno označoval tento typ osobnosti?""",
            textAnswer = "Sociolog, frankfurtská škola. Masy lidí, ovládání médii a autoritářství.",
            answers =
            listOf(
                PsychologyTermAnswer("""konformní osobnost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rasistická osobnost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""autonomní osobnost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""autoritářská osobnost""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Který z uvedených autorů není psychologem?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Edward L. Thorndike""",
                    false,
                    "Behaviorismus, pokus a omyl funkcionalismus - W. James, J. Dewey, psychické procesy, jak se psychika přizbůsobuje prostředí"
                ),
                PsychologyTermAnswer("""Karl Popper""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Max Wertheimer""",
                    false,
                    "Praha, reproduktivní (repetice, podmiňování) vs. produktivní (nové myšlenky) přemýšlení"
                ),
                PsychologyTermAnswer("""Hans J. Eysenck""",
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
            prompt = """Gender studies se zabývají problematikou""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""rozdílů mezi pohlavími""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""genetiky chování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""soužití různých etnik""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vytváření rodokmenů""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Slečna Amanda ráda při hraní počítačových her popíjí Coca- Colu. Nedávno nešťastnou náhodou převrhla do klávesnice svého drahého notebooku sklenici Coca-Coly a nenapravitelně ho tak zničila. Amanda si poté řekla: „No co, stejně měl dost pomalý procesor a malý disk. Tak jako tak bych si za chvíli chtěla pořídit nový.“ Který z obranných mechanismů Amanda nejspíše použila?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""racionalizaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""regresi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projekci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""potlačení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Který z následujících přístupů nejvíce ve výzkumu využíval experimenty se zvířaty?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""humanistická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    ""
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
            """Výzkumník se snaží experimentálně zjistit, jaký vliv má použití nové relaxační techniky na výkon v testu pozornosti u studentů. Co je v tomto experimentu použití relaxační techniky?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""závislá proměnná""",
                    false,
                    "očekáváme změny na základě změn v nezávislých proměnných"
                ),
                PsychologyTermAnswer("""nezávislá proměnná""",
                    false,
                    "hodnota, kterou můžeme účelově měnit"
                ),
                PsychologyTermAnswer("""kontrolní proměnná""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""placebo""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Přístup založený na zkoumání velkých skupin lidí s cílem najít obecné zákonitosti chování se označuje jako nomotetický; zatímco přístup založený na podrobném zkoumání jednotlivců s cílem dosáhnout jedinečného porozumění se označuje jako""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""idiografický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""holistický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""individualistický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""longitudinální""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Pokusné osobě je předložena řada slov k zapamatování a posléze je má reprodukovat. Která slova si pravděpodobně nejlépe zapamatuje?""",
            textAnswer = "Posléze je bůhví po jak dlouhý době - po krátké by to byl recency effect, po dlouhé primacy effect, celkově však serial position effect",
            answers =
            listOf(
                PsychologyTermAnswer("""ta na konci řady""",
                    false,
                    "recency effect"
                ),
                PsychologyTermAnswer("""ta na začátku řady""",
                    false,
                    "primacy effect"
                ),
                PsychologyTermAnswer("""ta na začátku a na konci řady""",
                    false,
                    "serial position effect"
                ),
                PsychologyTermAnswer("""ta uprostřed řady""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Metoda pro zjišťování pozice jedince ve skupině se nazývá""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociogogika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociografie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociometrie""",
                    false,
                    "J. L. Moreno, Zkoumání skrze vzájemné výběry a odmítnutí členů malé skupiny."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """U Shakespeara se dočteme, že „César rozděluje muže na tlusté, holohlavé s dobrým spánkem, se kterými se cítí dobře, a hubené, intelektuální, kteří nemají rádi hudbu.“ Jak bychom mohli Césarovo uvažování charakterizovat z pohledu psychologie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """snaha vysvětlit vývoj člověka interakcí mezi dědičnými vlivy a vlivy prostředí""",
                    false
                ),
                PsychologyTermAnswer("""klasický příklad základní atribuční chyby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """pokus demonstrovat vliv individuálního očekávání na sociální percepci""",
                    false
                ),
                PsychologyTermAnswer("""pokus o vytvoření typologie osobnosti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Která z následujících poruch se nejpravděpodobněji rozvine u osob, které prožily přírodní katastrofu, např. ničivý úder tsunami na asijském pobřeží?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""posttraumatická stresová porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fobie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy příjmu potravy""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Alzheimerova nemoc se vyskytuje nejvíce""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""v rané dospělosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v dětském věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v dospívání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve stáří""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Deprese a mánie se řadí mezi""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""poruchy vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy nálady""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úzkostné poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy myšlení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Pokud budeme asi půl minuty sledovat výraznou skvrnu v jedné barvě a pak odvrátíme zrak na neutrální pozadí, uvidíme původní skvrnu v komplementární barvě. Jak se nazývá tento jev?""",
            textAnswer = "Latence sítnice je asi 0,1 s. I pocit světla trvá déle. Toto prodloužení se nazývá následný obraz a trvá tak dlouho," +
                " než zaniknou rozpadové produkty, které vznikly v sítnici při fotochemické reakci při působení světla.",
            answers =
            listOf(
                PsychologyTermAnswer("""eidetický obraz""",
                    false,
                    "eidetický obraz - grafická pamět - vizuální pamětní představy" +
                        "\nW. Stern hovoří o existenci přechodu od vjemů k představám, vyjadřuje to řadou:  vjem – následný obraz – eidetický obraz – představa."
                ),
                PsychologyTermAnswer("""optický klam""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""barvová konstanta""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""negativní paobraz""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pozitivní paobraz""",
                    false,
                    "Opak - při koukání na tmavé pozadí ve kterém vidíme šmouhy - a vzniká v důsledku existence senzorického registru"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Podle Piagetovy teorie kognitivního vývoje si dítě začíná uvědomovat, že věci existují i tehdy, nejsou-li jeho smyslům dostupny""",
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
                PsychologyTermAnswer("""mezi 18. a 24. měsícem věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mezi 2. a 3. rokem věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ihned po narození""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mezi 6. a 12. měsícem věku""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Americký psycholog Rosenthal ve svých pokusech ve školních třídách dal učitelům na začátku školního roku seznam údajně velmi nadaných žáků; ve skutečnosti šlo o náhodně vybrané žáky. Učitelé byli touto informací tak ovlivněni, že tyto žáky hodnotili lépe než zbytek třídy. Na konci školního roku byli tito „nadaní“ žáci skutečně (podle testování nezávislými psychology) inteligentnější než před rokem. Jak se tento jev v psychologii označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""centrální tendence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""haló efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""flow fenomén""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Pygmalion efekt""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Které z uvedených tvrzení je nejvíce opodstatněnou kritikou (raného) behaviorismu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""behaviorismus nevyužíval vědecké metody""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """behaviorismus nebral v úvahu emoce a myšlenky""",
                    false
                ),
                PsychologyTermAnswer("""behaviorismus podceňoval význam učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """behaviorismus byl příliš závislý na metodě introspekce""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Co označuje v psychologii tzv. „magické číslo 7“?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """sedm prvků jako typickou kapacitu krátkodobé paměti""",
                    false
                ),
                PsychologyTermAnswer(
                    """sedm základních fází motorického vývoje v raném věku""",
                    false
                ),
                PsychologyTermAnswer(
                    """sedm zdrojů zkreslení při posuzování osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """sedm základních rysů osobnosti (také tzv. big seven)""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Který psycholog navrhl rozdělení vývoje do osmi tzv. psychosociálních stadií? Každé životní stadium vymezil určitým úkolem či psychosociální krizí, kterou má člověk ve svém duševním vývoji vyřešit.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Z. Matějček""",
                    false,
                    "Dětský psycholog, vliv podmínek v ústavech - deprivace/strádání, vývojová psychologie"
                ),
                PsychologyTermAnswer("""J. Piaget""",
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Pojmy reliabilita a validita se vztahují k""",
            textAnswer = "Validita - Měří test opravdu co má měřit?" +
                "\nReliabilita - Dají se výsledky replikovat?",
            answers =
            listOf(
                PsychologyTermAnswer("""přejímání sociálních norem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úspěšnosti psychoterapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vlastnostem testů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""strategiím zvládání zátěžových situací""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Humanistická psychologie se někdy označuje jako tzv. třetí síla – vedle kterých dvou přístupů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychoanalýzy a behaviorismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýzy a neopsychoanalýzy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorismu a kognitivní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoanalýzy a kognitivní psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Podle Freudovy teorie psychosexuálního vývoje představuje první rok života""",
            textAnswer = "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací.",
            answers =
            listOf(
                PsychologyTermAnswer("""anální stadium""",
                    false,
                    "Anální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní."
                ),
                PsychologyTermAnswer("""genitální stadium""",
                    false,
                    "Genitální stádium (puberta-dospělost): sex. potřeby se navrací."
                ),
                PsychologyTermAnswer("""latentní stadium""",
                    false,
                    "Latentní stádium (5-puberta): sublimace sex. potřeb do školy."
                ),
                PsychologyTermAnswer("""orální stadium""",
                    false,
                    "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný."
                ),
                PsychologyTermAnswer("falické stadium",
                    false,
                    "Falické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Herman Ebbinghaus na základě svých experimentů se smysluprostými slabikami odvodil tzv. křivku zapomínání, podle které""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """množství zapamatovaného materiálu klesá v čase rovnoměrně""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejvíce zapomínáme v prvních několika hodinách po naučení, poté už k zapomínání nedochází""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejméně zapomínáme v průběhu prvních několika hodin po naučení, poté se rychlost zapomínání zvyšuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejvíce zapomínáme v průběhu prvních několika hodin po naučení, poté se rychlost zapomínání snižuje""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Experimentátor chce zjistit, zda schopnost učení závisí na délce spánku pokusné osoby. Rozdělí probandy, muže i ženy, náhodně do tří skupin, osobám z první skupiny dovolí spát 8 hodin, osobám z druhé skupiny 6 hodin a osobám z třetí skupiny jen 3 hodiny. Po probuzení jim dá k dispozici stejně dlouhou dobu k naučení úkolu a zaznamená počet zapamatovaných slov. Co je v tomto experimentu nezávislou proměnnou?""",
            textAnswer = "hodnota, kterou můžeme účelově měnit",
            answers =
            listOf(
                PsychologyTermAnswer("""délka spánku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pohlaví pokusné osoby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""délka učení se úkolu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""počet zapamatovaných slov""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Weberova konstanta pro koncentraci pachového podnětu je 0,07 a pro koncentraci chuťového podnětu 0,20. Z toho vyplývá, že přidáváme-li do jídla koření,""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""zaznamenáme rozdíl čichem dříve než chutí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zaznamenáme rozdíl chutí dříve než čichem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""z uvedených údajů nelze určit""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """zaznamenáme rozdíl v podstatě současně (Weberova konstanta se vztahuje k jiným aspektům vnímání)""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Od jaké intenzity zvuku je podnět vnímán většinou lidí bolestivě?""",
            textAnswer = "140 dB trvalé poškození sluchu",
            answers =
            listOf(
                PsychologyTermAnswer("""60 dB""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""120 dB""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""20 dB""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""30 dB""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """LSD (dietylamid kyseliny lysergové) je psychotropní látka, která se řadí mezi""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""canabinoidy""",
                    false,
                    "THC, Spice, K2"
                ),
                PsychologyTermAnswer("""opiáty""",
                    false,
                    "Heroin, morfin, fentanyl, metadon"
                ),
                PsychologyTermAnswer("""stimulancia""",
                    false,
                    "Kofein, nikotin, amfetamin, kokain, metamfetamin"
                ),
                PsychologyTermAnswer("""halucinogeny""",
                    false,
                    "LSD, psilocybin, DMT a peyote"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Učitelka zkouší látku z minulého týdne a zeptá se Alice, jaké je hlavní město Mongolska. Který druh paměti se u Alice při vybavování odpovědi uplatňuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""krátkodobá paměť""",
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
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """V léčbě fobií je často uplatňován postup behaviorální terapie, při kterém nejprve vytvoříme seznam situací vyvolávajících strach podle stupně intenzity tohoto strachu. Pak naučíme klienta relaxovat, uvolňovat se. Klient se uvolní, poté mu terapeut začne popisovat nejméně znepokojující situaci ze seznamu. Klient si tuto situaci snaží představit, přičemž se snaží zůstat uvolněný. Takto se postupně, pomalu zvládá celý seznam obávaných situací. Jak se tento postup označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""vyhasínání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""averzivní terapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""systematická desenzibilizace""",
                    false,
                    "relaxační metoda"
                ),
                PsychologyTermAnswer("""přesycení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Michal je spíše uzavřený, plachý, citlivý, raději tráví čas o samotě než ve společnosti, špatně se přizpůsobuje změnám v prostředí. Podle Kretschmerovy konstituční typologie osobnosti bude Michal nejspíše""",
            textAnswer = "Astenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """hubené postavy, s úzkými rameny, dlouhým krkem a protáhlým trupem""",
                    false
                ),
                PsychologyTermAnswer(
                    """vysoké, svalnaté postavy s dlouhými končetinami""",
                    false
                ),
                PsychologyTermAnswer(
                    """zakulacené postavy, s kratšími končetinami a kulatou hlavou""",
                    false
                ),
                PsychologyTermAnswer(
                    """robustní postavy, svalnatý, se širokými rameny a hrudníkem""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """S kreativitou je často spojováno""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""konvergentní myšlení""",
                    false,
                    "Myšlení pomocí již prověřených a použitých způsobů řešení, J. P. Guilford"
                ),
                PsychologyTermAnswer("""pojmově-logické myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""propozicionální myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""divergentní myšlení""",
                    false,
                    "Pátrání po novém řešení, J. P. Guilford"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Jaká část populace má IQ nižší než 70""",
            textAnswer = "",
            imageAnswerUrl = "https://www.gigacalculator.com/img/calculators/iq-scale.png",
            answers =
            listOf(
                PsychologyTermAnswer("""přibližně 1""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přibližně 0,2%""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přibližně 20%""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přibližně 2%""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Kolikrát přibližně se u dospělého člověka v průběhu osmihodinového spánku objeví fáze REM?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""1-2krát""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""8-10krát""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""4-5krát""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """REM fáze se objevují jen vzácně, ne při každém spánku""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Zakladatelem logoterapie, jejímž východiskem je poznatek, že v člověku existuje potřeba smyslu, byl""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""V. E. Frankl""",
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
                PsychologyTermAnswer("""C. R. Rogers""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""H. A. Maslow""",
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
                PsychologyTermAnswer("""síla ega""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""míra funkční autonomie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úroveň anticipace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""aspirační úroveň""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Pacienti, u nichž dochází ke střídání období deprese s obdobími mánie, obvykle s návratem k normální náladě mezi těmito obdobími, trpí""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""generalizovanou úzkostnou poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bipolární poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""endogenní depresí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""disociační poruchou""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Pokud terapeut využívá tzv. eklektický přístup, znamená to, že.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """pracuje metodou volných asociací a analýzy snů a tak pomáhá přivádět vytěsněné myšlenky a pocity do vědomí klienta""",
                    false
                ),
                PsychologyTermAnswer(
                    """používá při terapii elektrokonvulzivní terapii a psychofarmaka""",
                    false
                ),
                PsychologyTermAnswer(
                    """nedrží se striktně jedné metody, ale vybírá z různých technik to, co je pro daného klienta nejvhodnější""",
                    false
                ),
                PsychologyTermAnswer(
                    """používá metody založené na principech učení k modifikaci chování jedince""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Ruský fyziolog I. P. Pavlov a jeho žáci prováděli experimenty se psy. Experimentátor rozsvítil žárovku a krátce nato podal psovi potravu. Po určitém počtu opakování se u psa začalo objevovat slinění při pouhém rozsvícení žárovky bez předložení potravy. Jakým typem podnětu bylo v tomto experimentu rozsvícení žárovky?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""operantním podnětem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nepodmíněným podnětem""",
                    false,
                    "evokuje vrozenou reakci bez předchozího učení (jídlo)"
                ),
                PsychologyTermAnswer("""podmíněným podnětem""",
                    false,
                    "původně neutrální stimul (světlo, metronom), který získá schopnost vyvolat vrozenou reakci (slinění)"
                ),
                PsychologyTermAnswer("""generalizovaným podnětem""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Matka, která má nevědomé pocity viny za to, že nechtěla své dítě, je nyní rozmazluje a přehnaně ochraňuje, aby ujistila dítě o své lásce a sama sebe, že je dobrou matkou. O který obranný mechanismus se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""přesunutí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""racionalizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reaktivní výtvor""",
                    false,
                    "(reaktivní formace) - potlačil u sebe a chce potlačit i u někoho dalšího"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který psychologický směr představují K. Horneyová, H. S. Sullivan, E. Fromm?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""neopsychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gestalt psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neobehaviorismus""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Martin se vždy, když odchází z domova, několikrát vrátí a opakovaně zkontroluje, zda nezapomněl zavřít dveře a okna v obavách, aby vinou jeho opomenutí nedošlo ke vloupání. Když řídí auto, často cítí nutkání zastavit a přesvědčit se, že nepřejel člověka, zvláště dítě. Jakou poruchou Martin pravděpodobně trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""depresí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychosomatickou poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsedantně-kompulzivní poruchou""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Paní Dvořáková se nikdy nesetkala s žádným Němcem, přesto o nich prohlašuje, že Němci jsou chladní, nemají smysl pro humor, zato jsou pracovití a výkonní. Tento postoj je příkladem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""stereotypu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""haló efektu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""atribuční chyby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""skupinové polarizace""",
                    false,
                    "posun skupiny k extrému"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Starší muž dostane na rušné ulici srdeční infarkt. Leží na zemi a kolem něj stojí hlouček lidí, nikdo z nich ani z ostatních kolemjdoucích mu však neposkytne žádnou pomoc. Jak sociální psychologové jejich neochotu nejčastěji vysvětlují?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""rozložením zodpovědnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální konformitou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální facilitací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální fobií""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Mírou vztahu dvou proměnných je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""směrodatná odchylka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""korelační koeficient""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""standardní chyba průměru""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Gaussovo normální rozdělení""",
                    false,
                    "",
                    imageExplanationUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Standard_deviation_diagram.svg/370px-Standard_deviation_diagram.svg.png"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Jak se nazývá smysl, který vnímá pozici a pohyby hlavy a končetin vzhledem k trupu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""nocicepce""",
                    false,
                    "tříneuronová aferentní dráha bolesti - vnímání bolesti"
                ),
                PsychologyTermAnswer("""synestezie""",
                    false,
                    "Sdružení dvou nebo více smyslových vjemů člověka"
                ),
                PsychologyTermAnswer("""osmorecepce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kinestezie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který druh amnézie se vyznačuje neschopností zapamatovat si nové informace nebo události všedního dne?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""postraumatická amnézie""",
                    false,
                    "po úrazu hlavy"
                ),
                PsychologyTermAnswer("""ostrůvkovitá amnézie""",
                    false,
                    "delirium (obluzené vědomí) a amenze (zmatenost)"
                ),
                PsychologyTermAnswer("""anterográdní amnézie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""retrográdní amnézie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Co je základem polygrafu (tzv. detektoru lži)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """měření prodlevy odpovědí na tzv. kritické otázky""",
                    false
                ),
                PsychologyTermAnswer(
                    """měření fyziologických reakcí jako míry autonomní aktivace""",
                    false
                ),
                PsychologyTermAnswer(
                    """srovnání prodlevy odpovědí u neutrálních a kritických otázek""",
                    false
                ),
                PsychologyTermAnswer(
                    """zjišťování míry subjektivního prožitku strachu a viny""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Některé diagnostické nástroje obsahují nejednoznačné testové podněty; předpokládá se, že testovaný jedinec do nich promítne svou osobnost a odhalí tak svá nevědomá přání a motivy. Jak se tento typ nástroje označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""projektivní test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""objektivní test osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologický inventář""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""osobnostní inventář""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Poruchu rozpoznávání objektů označujeme termínem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""apercepce""",
                    false,
                    "Závislost přijímání a zpracování informace (obv. při vnímání) na minulé zkušenosti." +
                        "\nK apercepci také řadíme priming: předcházející podnět, či situace ovlivní následující podnět."
                ),
                PsychologyTermAnswer("""agnózie""",
                    false,
                    "porucha poznávání předmětů"
                ),
                PsychologyTermAnswer("""amnézie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""afázie""",
                    false,
                    "Afázie - ztráta či porucha řeči"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Při výzkumech skupinového rozhodování bylo zjištěno, že skupinová diskuse vede k rozhodnutím, která jsou ve srovnání s individuálními rozhodnutími extrémnější. Například jestliže se jednotliví členové skupiny původně přikláněli k riskantnějšímu řešení nějakého dilematu, potom skupina ještě více riskovala; jestliže se členové skupiny přikláněli k opatrnějšímu řešení, skupina byla ještě opatrnější. Jak se tento vliv skupiny označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""deindividualizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""skupinová polarizace""",
                    false,
                    "posun skupiny k extrému"
                ),
                PsychologyTermAnswer("""sociální facilitace""",
                    false,
                    "sociální facilitace - vliv přítomnosti jiných osob na výkon jedince"
                ),
                PsychologyTermAnswer("""pluralitní ignorance""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Která z částí osobnosti se podle psychoanalýzy řídí principem slasti?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""id""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""superego""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ego""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""libido""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Které životní období psychologové označují obdobím „experimentování s rolemi“ či „krize identity“?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""starší dospělost (45-60 let)""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mladou dospělost (20-35 let)""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dospívání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předškolní věk""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Konec kojeneckého období je ve vývojové psychologii vymezen zpravidla""",
            textAnswer = "Novorozenec: 1-2 měsíce" +
                "\nKojenec: 2-12 měsíců" +
                "\nBatole: 1-3 let",
            answers =
            listOf(
                PsychologyTermAnswer("""ukončením kojení dítěte""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dovršením 12 měsíců věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dovršením 9 měsíců věku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dovršením 24 měsíců věku""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Petra vypráví kamarádce, jak minulý týden probíhal maturitní večírek její třídy. Který druh paměti se u Petry při tomto vybavování nejvíce uplatňuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""krátkodobá paměť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sémantická paměť""",
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Pokud budeme asi půl minuty sledovat výraznou barevnou skvrnu a pak odvrátíme zrak na neutrální pozadí, uvidíme původní skvrnu v komplementární barvě. Jak se nazývá tento jev?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""percepční konstanta""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""eidetický obraz""",
                    false,
                    "eidetický obraz - grafická pamět - vizuální pamětní představy" +
                        "\nW. Stern hovoří o existenci přechodu od vjemů k představám, vyjadřuje to řadou:  vjem – následný obraz – eidetický obraz – představa."
                ),
                PsychologyTermAnswer("""negativní paobraz""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""optický klam""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Podle Freudovy teorie psychosexuálního vývoje představuje první rok života""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""falické stadium""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""latentní stadium""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""anální stadium""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""orální stadium""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Pokusní psi, kteří byli v laboratorních experimentech vystaveni nevyhnutelným elektrošokům, se ve srovnání s kontrolní skupinou zvířat nebyli schopni naučit únikovému chování v důsledku nekontrolovatelnosti daného podnětu. Jak tento stav psychologové nazývají?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""naučená bezmocnost""",
                    false,
                    "Seligman"
                ),
                PsychologyTermAnswer("""naučené očekávání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""podmíněná rezignace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""naučená úniková reakce""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Narušení řečových schopností se označuje termínem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""agnózie""",
                    false,
                    "porucha poznávání předmětů"
                ),
                PsychologyTermAnswer("""amnézie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""apercepce""",
                    false,
                    "Závislost přijímání a zpracování informace (obv. při vnímání) na minulé zkušenosti." +
                        "\nK apercepci také řadíme priming: předcházející podnět, či situace ovlivní následující podnět."
                ),
                PsychologyTermAnswer("""afázie""",
                    false,
                    "Afázie - ztráta či porucha řeči"
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Poruchy vnímání barev se vyskytují""",
            textAnswer = "daltonismus",
            answers =
            listOf(
                PsychologyTermAnswer("""mnohem častěji u žen""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mnohem častěji u mužů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""u obou pohlaví stejně""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """do 40 let častěji u mužů, v pozdějším věku u obou pohlaví stejně""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Tomáš je veselý, uvolněný, otevřený, má rád lidi, občas kolísá mezi povznesenou náladou a smutkem. Podle zastánců konstituční typologie osobnosti bude Tomáš nejspíše""",
            textAnswer = "E. Kretschmer se snažil se spojit fyziologickou postavu jedince k patologii." +
                "\nAstenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """robustní postavy, svalnatý, se širokými rameny a hrudníkem""",
                    false
                ),
                PsychologyTermAnswer("""střední postavy, hubený, s užším hrudníkem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """zakulacené postavy, s kratšími končetinami a kulatou hlavou""",
                    false
                ),
                PsychologyTermAnswer(
                    """vysoké, hubené postavy, šlachovitý, s ostře řezaným obličejem""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Starší muž dostane na rušné ulici srdeční infarkt. Leží na zemi a kolem něj stojí hlouček lidí, nikdo z nich ani nikdo z ostatních kolemjdoucích mu však neposkytne žádnou pomoc. Jak sociální psychologové jejich neochotu vysvětlují?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální facilitací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní disonancí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sociální konformitou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rozložením zodpovědnosti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Pokud po přečtení novinové zprávy o mučení iráckých vězňů americkými vojáky prohlásíme: „Ti vojáci jsou nesmírně brutální a sadističtí, já bych se v takové situaci takto nikdy nezachoval/a“, je možné, že se zde projevuje""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""racionalizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""haló efekt""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předsudek""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""atribuční chyba""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """V rámci psychologického vyšetření jsou klientovi předkládány tabule s inkoustovými skvrnami. Klient dostane pokyn, aby si tabule prohlédl a sdělil, čemu všemu se skvrny podobají. O jaký typ metody se jedná?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""dotazník""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""výkonový test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""objektivní test osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projektivní test""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://epomedicine.com/wp-content/uploads/2018/07/sleep-eeg.jpg",
            prompt = """Pro kterou fázi spánku jsou typické delta vlny na EEG?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""hluboký spánek""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""usínání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""REM""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""probouzení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Zakladatelem logoterapie, jejímž východiskem je poznatek, že v člověku existuje potřeba smyslu, byl""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""V. E. Frankl""",
                    false,
                    "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                        "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                        "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě"
                ),
                PsychologyTermAnswer("""C. G. Jung""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""E. Fromm""",
                    false,
                    ""
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Označte správné pořadí Maslowovy hierarchie potřeb:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """fyziologické potřeby, bezpečí, uznání, kognitivní potřeby, estetické potřeby, sounáležitost a láska, seberealizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby, bezpečí, uznání, sounáležitost a láska, kognitivní potřeby, estetické potřeby, seberealizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby, bezpečí, sounáležitost a láska, uznání, kognitivní potřeby, estetické potřeby, seberealizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby, bezpečí, sounáležitost a láska, kognitivní potřeby, estetické potřeby, uznání, seberealizace""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Pojem mentální věk v psychologii""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """souvisí se starším způsobem výpočtu inteligenčního kvocientu""",
                    false
                ),
                PsychologyTermAnswer(
                    """označuje současnou etapu výzkumu ve společenských vědách""",
                    false
                ),
                PsychologyTermAnswer(
                    """poukazuje na rozdíl skutečného věku člověka a toho, na jaký věk se cítí""",
                    false
                ),
                PsychologyTermAnswer("""nic z výše uvedeného neplatí""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Jaký typ učení zkoumal Herman Ebbinghaus ve svých pokusech, kde používal smysluprosté slabiky?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pojmové učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asociační učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""diskriminační učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""modelové učení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Podle Fechnerova zákona platí, že když se zvyšuje fyzikální intenzita podnětu,""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """velikost vjemu zpočátku roste pomalu a poté stále rychleji""",
                    false
                ),
                PsychologyTermAnswer("""velikost vjemu roste konstantním tempem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""velikost vjemu zůstává víceméně konstantní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """velikost vjemu zpočátku roste rychle a poté stále pomaleji""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Aneta často svým kamarádům závidí nové věci. Nikdy by si však nepřiznala, že je závistivá, naopak pokládá za nadměrně závistivé mnohé ze svých kamarádů, i když tomu tak ve skutečnosti není. Jak se označuje obranný mechanismus, který Aneta používá?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""projekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přesunutí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sublimace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vytěsnění""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Neodůvodněný strach z hadů, výšek či uzavřených prostor je příkladem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""úzkostné poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""panické poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsese""",
                    false,
                    "Opakované, vtíravé myšlenky (nápady), pudy a činy."
                ),
                PsychologyTermAnswer("""fobie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Který psycholog navrhl rozdělení vývoje do osmi tzv. psychosociálních stadií? Každé životní stadium vymezil určitým úkolem či psychosociální krizí, kterou má člověk ve svém duševním vývoji vyřešit.""",
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
                PsychologyTermAnswer("""E. Kübler-Rossová""",
                    false,
                    "psychologie umírání a smrti - Thanatologie" +
                        "\npětifázový model smiřování:" +
                        "\n1. Popírání (denial): Jedinec se snaží ignorovat nebo popírat skutečnost ztráty nebo smrti. Nemusí být ochoten či schopen uvěřit, že se něco takového stalo.\n" +
                        "\n\n" +
                        "2. Hněv a zlost (anger): Jedinec začíná projevovat vztek, hněv a frustraci ohledně ztráty nebo smrti. Může hledat viníky nebo cítit nespravedlnost.\n" +
                        "\n\n" +
                        "3. Smlouvání (bargaining): Jedinec se pokouší vyjednávat nebo dohodnout se situací nebo s vyšší mocí. Může se snažit slibovat, že udělá něco určitého, pokud by se ztráta nebo smrt mohla obrátit.\n" +
                        "\n\n" +
                        "4. Zármutek či deprese (depression): Jedinec prožívá smutek, zármutek a pocit ztráty. Mohou se objevovat symptomy deprese, jako je smutek, beznaděj a ztráta zájmu o normální činnosti.\n" +
                        "\n\n" +
                        "5. Smíření nebo rezignace (acceptance): Jedinec se postupně smiřuje se ztrátou nebo smrtí. Přijímá skutečnost a začíná hledat způsoby, jak se s tím vyrovnat a pokračovat v životě."
                ),
                PsychologyTermAnswer("""S. Freud""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""J. B. Watson""",
                    false,
                    "Behaviorismus, Little Albert." +
                        "\n\"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
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
                    """jev, kdy samy o sobě neúčinné prostředky léčí, jestliže je pacient přesvědčen o jejich účinnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """stav organismu, který umožňuje prožívat představy, které slouží k odpočinku a sebepoznání""",
                    false
                ),
                PsychologyTermAnswer(
                    """působení naučeného obsahu na nový průběh učení""",
                    false
                ),
                PsychologyTermAnswer(
                    """sugestivní technika zaměřená na dosažení změněného stavu vědomí""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://wikisofia.cz/w/images/5/5f/HebbianYerkesDodson.JPG",
            prompt = """Nejlepšího výkonu ve středně těžké úloze dosahuje většina lidí při""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""nízké úrovni motivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vysoké úrovni motivace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """úroveň motivace nehraje u většiny lidí pro jejich výkon roli""",
                    false
                ),
                PsychologyTermAnswer("""střední úrovni motivace""",
                    false,
                    ""
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
                PsychologyTermAnswer("""schopnost formálních operací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schopnost senzomotorických operací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pojetí stálosti objektu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pojetí konzervace""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Standa byl vždy přehnaně plachý a většinu svého volného času trávil sám. V poslední době je rozrušený a mluví nahlas sám pro sebe. Prozradil, že v noci často slyší hlas, který opakuje rozkaz, aby ublížil svým rodičům a zapálil jejich dům. Jakou poruchou Standa pravděpodobně trpí?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychosomatickou poruchou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""depresí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úzkostnou poruchou""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Způsoby chování považované za žádoucí u příslušníků určité sociální skupiny označujeme jako""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""normy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""postoje""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projevy skupinová koheze""",
                    false,
                    "koheze=soudružnost"
                ),
                PsychologyTermAnswer("""sociální stereotypy""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Z jakého důvodu nejčastěji psychologové provádějí výzkumy na dvojčatech?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """umožňují prozkoumat vliv sourozenecké konstelace na vývoj""",
                    false
                ),
                PsychologyTermAnswer(
                    """umožňují studovat kognitivní vývoj a vývoj řeči""",
                    false
                ),
                PsychologyTermAnswer(
                    """umožňují odhadnout podíl vlivů prostředí a vlivů dědičnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """umožňují zkoumat specifika prenatálního vývoje""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt =
            """Který psychologický směr představují K. Horneyová, H. S. Sullivan, E. Fromm?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""behaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neopsychoanalýza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neobehaviorismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Veronika volá svého psa Skipa. Skipovi se nechce přiběhnout a tak Veronika pískne na píšťalku. Její zvuk má frekvenci 10 000 Hz. Může běžný člověk slyšet její zvuk?""",
            textAnswer = "20 Hz - 20 kHz",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """ano""",
                    false
                ),
                PsychologyTermAnswer(
                    """ne, člověk slyší zvuky pouze do frekvence 8 000 Hz""",
                    false
                ),
                PsychologyTermAnswer(
                    """ne, člověk slyší zvuky pouze do frekvence 2 000 Hz""",
                    false
                ),
                PsychologyTermAnswer(
                    """ne, člověk slyší zvuky pouze do frekvence 200 Hz""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.studium-psychologie.cz/dejiny-psychologie/images/2-gestaltismus-tvarova-psychologie.jpg",
            prompt = """Mezi gestaltistické principy sdružování objektů při vnímání nepatří:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""princip dotváření (uzavřenosti)""",
                    false,
                    imageExplanationUrl = "https://slideplayer.cz/slide/15246770/92/images/22/Z%C3%A1kon+uzav%C5%99enosti+N%C4%9Bkdy+vid%C3%ADme+i+to%2C+co+na+obr%C3%A1zku+nen%C3%AD..jpg"
                ),
                PsychologyTermAnswer("""princip blízkosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""princip podobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""princip gradientu struktury""",
                    false,
                    "přejíždíme-li zrakem po určité scenérii – dochází ke změnám vnímané členitosti povrchu."
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt =
            """Jak se označuje postup behaviorální terapie, při kterém je nežádoucí chování při svém výskytu negativně zpevněno (např. alkoholik dostane elektrickou ránu ve chvíli, kdy sáhne po sklenici)?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""přesycení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vyhasínání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""systematická desenzibilizace""",
                    false,
                    "relaxační metoda"
                ),
                PsychologyTermAnswer("""averzivní terapie""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Somnolence, sopor, torpor, koma jsou""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""poruchy spánku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy vědomí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy pozornosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy vnímání""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Vyberte tvrzení, které neplatí.""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """mentální anorexie se vyskytuje mnohem častěji u žen než u mužů""",
                    false
                ),
                PsychologyTermAnswer(
                    """mentální anorexie a mentální bulimie patří mezi psychotické poruchy""",
                    false
                ),
                PsychologyTermAnswer("""mentální bulimie je porucha příjmu potravy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """mentální anorexie se vyskytuje nejčastěji v dospívání a mladé dospělosti""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Co odlišuje experiment od jiných metod psychologického výzkumu?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """možnost přímého, nezúčastněného pozorování subjektů""",
                    false
                ),
                PsychologyTermAnswer(
                    """možnost použít standardizované testy schopností a osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """možnost prozkoumat subjektivní zkušenost pozorovaných osob""",
                    false
                ),
                PsychologyTermAnswer("""možnost manipulovat s proměnnými""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Co označuje v psychologii tzv. „magické číslo 7“?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """sedm zdrojů zkreslení při posuzování osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """sedm prvků jako typickou kapacitu krátkodobé paměti""",
                    false
                ),
                PsychologyTermAnswer(
                    """sedm základních rysů osobnosti (také tzv. big seven)""",
                    false
                ),
                PsychologyTermAnswer("""sedm velkých psychologů století""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Věta pětiletého dítěte „ten zlý stůl, který mě praštil do hlavy“ je nejspíše projevem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""antropomorfního myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivního egocentrismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální retardace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""magického myšlení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Americký psycholog Skinner dokázal naučit pokusné holuby i velice složitému chování tak, že když hladový holub náhodně udělal to, co se měl naučit (např. otočil se doleva), odměnil jej potravou. Jak se tento typ učení označuje?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální učení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""operantní podmiňování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""klasické podmiňování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asociační učení""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt =
            """Poškození kterého smyslu může nejpravděpodobněji vést u starších osob k paranoidním pocitům?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""zraku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sluchu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rovnováhy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""čichu a chuti""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt =
            """Dvě dvanáctileté školačky, Martina a Šárka, najdou ve škole na chodbě cizí peněženku. Martina navrhne, aby peníze utratily za časopisy a sladkosti. Šárka odmítne a chce peněženku vrátit s odůvodněním: „Paní učitelce by se to nelíbilo, kdyby to zjistila.“ Pro které stadium morálního vývoje je Šárčino uvažování typické?""",
            textAnswer = "Stádie morálního vývoje" +
                "\n1.Předkonvenční morálka" +
                "\n\t-trest, odměna" +
                "\n2.Konvenční morálka" +
                "\n\t-chce být hodný kluk/hodná holka, autorita - zákony, pravidla" +
                "\n3.Postkonvenční (autonomní, hyperkonvenční, principiální 25%) morálka" +
                "\n\t-společenská smlouva, balance mezi univerzálními a osobními etickými principy",
            answers =
            listOf(
                PsychologyTermAnswer("""nekonvenční morálka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předkonvenční morálka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""konvenční morálka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""postkonvenční morálka""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Pro křivku normálního rozdělení (Gaussova křivka) je typické, že""",
            textAnswer = "- proměnné rozděleny do kategorií (intervalů) - různá četnost\n\n" +
                "- rozložení nebývá nahodilé - popsatelný tvar\n\n" +
                "1. Rovnoměrné - stejně často vyskytující hodnoty, rovnoměrné rozložení\n\n" +
                "2. Normální (Gaussovo) rozdělení - velké množství náhodných proměnných, směrodatná odchylka uprostřed, např. graf IQ - soustředění kolem průměru\n\n" +
                "3. Uniformní (rovné) - všechny hodnoty náhodné veličiny mají stejnou pravděpodobnost\n\n" +
                "4. Unimodální, bimodální, multimodální (podle počtu vrcholů - unimodální - jednovrcholová)\n\n" +
                "5. Zešikmení (zprava - kladně, zleva - negativně" +
                "\n\t-efekt stropu - většina kolem maximální hodnoty" +
                "\n\t-efekt podlahy - většina kolem nuly - málo senzitivní\n\n" +
                "6. Leptokurtické (špičatost), platykurtické (strmost) - jaká je koncentrace kolem střední hodnoty?\n\n" +
                " 7. Poissonovo (rozložení řídkých událostí - děje v čase)",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """případy jsou rovnoměrně rozloženy po celém rozsahu škály""",
                    false
                ),
                PsychologyTermAnswer(
                    """většina případů se shlukuje kolem střední hodnoty, směrem ke krajním hodnotám množství případů postupně klesá""",
                    false
                ),
                PsychologyTermAnswer(
                    """množství případů je u nižších hodnot škály malé a s vyššími hodnotami postupně roste""",
                    false
                ),
                PsychologyTermAnswer(
                    """většina případů se shlukuje kolem krajních hodnot, směrem ke středním hodnotám množství případů postupně klesá""",
                    false
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """S kreativitou je často spojováno""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""motorické myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""propozicionální myšlení""",
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
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Jak za sebou následují stadia psychosexuálního vývoje dle Sigmunda Freuda?""",
            textAnswer = "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací.",
            answers =
            listOf(
                PsychologyTermAnswer("""1. orální, 2. anální, 3. genitální, 4. období latence, 5. falické""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""1. orální, 2. anální, 3. falické, 4. období latence, 5. genitální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""1. orální, 2. anální, 3. období latence, 4. falické, 5. genitální""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""1. období latence, 2. orální, 3. anální, 4. falické, 5. genitální""",
                    false,
                    ""
                )
            ),
            categoryId = "MUNI testy",
            correctAnswer = 1
        )
    )
}