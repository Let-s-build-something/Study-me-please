package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//revidovano
object PsychologyEleven {
    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Jaký druh paměti zabezpečuje zapamatování faktických informací, jako jsou například hlavní města či jména prezidentů USA?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""pracovní paměť""",
                    false,
                    "krátkodobá paměť"
                ),
                PsychologyTermAnswer("""epizodická paměť""",
                    false,
                    "epizody v životě"
                ),
                PsychologyTermAnswer("""autobiografická paměť""",
                    false
                ),
                PsychologyTermAnswer("""sémantická paměť """,
                    false,
                    "schémata a fakta o světě"
                ),
            ),
            questionNumber = 1,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Fonologická smyčka a vizuálně prostorový zásobník jsou součástí modelu""",
            textAnswer = "Allan Badeley a Hitch." +
                "\nCentrální vykonavatel - pozornost, řídíc a koordinuje pamět, nemá kapacitu." +
                "\nFonologická smyčka - infromace vyjádřené řeči." +
                "\nVizuálně-prostorový náčrtník - vizuální informace.",
            answers = listOf(
                PsychologyTermAnswer("""pozornosti""",
                    false
                ),
                PsychologyTermAnswer("""výkonové motivace""",
                    false
                ),
                PsychologyTermAnswer("""pracovní paměti""",
                    false
                ),
                PsychologyTermAnswer("""osvojování řeči """,
                    false
                ),
            ),
            questionNumber = 2,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Jak se nazývá alternativa oidipovského komplexu u dívek?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Elektřin komplex""",
                    false
                ),
                PsychologyTermAnswer("""Minervin komplex""",
                    false
                ),
                PsychologyTermAnswer("""Afroditin komplex""",
                    false
                ),
                PsychologyTermAnswer("""Helenin komplex""",
                    false
                ),
            ),
            questionNumber = 3,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co nepatří mezi psychedelické drogy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""LSD""",
                    false
                ),
                PsychologyTermAnswer(
                    """meskalin""",
                    false,
                    "Z kaktusů, funguje podobně jako LSD nebo psilocybin"
                ),
                PsychologyTermAnswer(
                    """metadon""",
                    false,
                    "Syntetický opioid. Používá se na odvykání."
                ),
                PsychologyTermAnswer(
                    """psilocybin""",
                    false,
                    "Z houbiček."
                ),
            ),
            questionNumber = 4,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Autorem tzv. křivky zapomínání je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Hermann Ebbinghaus""",
                    false,
                    "Experimentální studie paměti, křivka zapomínání, monografie paměti. Asocianismus - \"Nic není ve vědomí, co dříve nebylo ve smyslech.\"" +
                        "\nSpacing effect - učení s prostory mezi je více efektivní." +
                        "\nSerial-position effect (efekt primárnosti a novosti) - Pozice pamatovných věcí hraje roli na to, jaké si pamatujeme."
                ),
                PsychologyTermAnswer(
                    """John Locke""",
                    false,
                    "Empirismus, blank slate - \"Vím, protože jsem to zažil\", Dualismus (duše, tělo), Asocianismus - psychické dění jsou spoje mezi psych. obsahy"
                ),
                PsychologyTermAnswer(
                    """Edward Thorndike""",
                    false,
                    "Thorndike - funkcionalismus (psychické procesy, poznání, přizpůsobení psychiky na prostředí), Trial and Error, association theory - S-R"
                ),
                PsychologyTermAnswer("""Ivan P. Pavlov """,
                    false,
                    "Orientačně-pátrací reflex - vrozený instinkt jako odezva na změnu okolního prostředí (hrozba, novost), zvýší se rychlost učení a vnímání." +
                        "\nSignální soustavy:" +
                        "\n\t1. Umělecká - společné pro zvířata a lidi, např. reflexy, dojmy, představy, pocity" +
                        "\n\t2. Myslitelská (věděcký) - spojené s lidským myšlením, abstraktní myšlení"
                ),
            ),
            questionNumber = 5,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Které stadium vývojové teorie nezahrnuje školní věk?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""stadium konkrétních operací (Piaget)""",
                    false,
                    "Senzomotorická inteligence (0-2 roky):" +
                        "\n\t-po 6 týdnech soc. úsměv, 8 měsících rozumí permanentnosti předmětů, po 12 měsících začne experimentovat se světem, po 18 měsících opakuje chování jiných, tak 100 slov," +
                        " Strange situation study - attachment styly." +
                        "\n\nPředoperační (symbolické, předpojmové) stadium (3-6 let):" +
                        "\n\tTeorie mysli (4 roky) - každý dokáže nezávisle myslet, pocit nenávratnosti stavů věcí" +
                        "\n\t\tkonzervace - přelívání tekutin do nádob o jiných velikostí." +
                        "\n\nStadium konkrétních operací (7-11) - inkluze prvků do množiny" +
                        "\n\tSeriace - řazení předmětů do pořadí, groupování (seskupování), umí používat pouze konkrétní zkušenosti - ne asbtraktní, zvratnost, pochopení identity" +
                        "\n\nStadium formálních operací (12+)" +
                        "\n\thypoteticko-deduktivní schopnost, abstraktní myšlení"
                ),
                PsychologyTermAnswer(
                    """anální stadium (Freud)""",
                    false,
                    "Orální stádium (0-1): moc - kouření, alkoholismus; málo -pesimismus sarkasmus, nepříjemný." +
                        "\nAnální stádium (1-3): moc - tvrdohlavost, kontrolující; málo - nepořádný, destruktivní." +
                        "\nFalické stádium (4-5/6): Oedipus komplex - kluk se bojí o genitálie; Elektra komplex - závist penisu." +
                        "\nLatentní stádium (5-puberta): sublimace sex. potřeb do školy." +
                        "\nGenitální stádium (puberta-dospělost): sex. potřeby se navrací."
                ),
                PsychologyTermAnswer(
                    """konvenční stadium (Kohlberg)""",
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
                    """snaživost versus méněcennost (Erikson)""",
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
            ),
            questionNumber = 6,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """O které kognitivní funkci můžeme říct, že ji dělíme na záměrnou a bezděčnou?""",
            textAnswer = "Záměrná - top-down (shora dolů - používáme naše systémy pro zpracování)" +
                "\nBezděčná - bottom-up (zdola nahoru - samotný stimuli rozhoduje co vidíme), salience (výraznost)",
            answers =
            listOf(
                PsychologyTermAnswer("""pozornost""",
                    false
                ),
                PsychologyTermAnswer("""paměť""",
                    false,
                    "Explicitní (deklarativní) - prochází vědomím, dělí se na epizodické - epizody z života (jako příběh) a sémantické - schémata a fakta o světě." +
                        "\nImplicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť."
                ),
                PsychologyTermAnswer("""myšlení""",
                    false
                ),
                PsychologyTermAnswer(
                    """motivace""",
                    false,
                    "Soubor motivů k určitému jednání. (Motiv - uvědomělé podněty vyvolávající uspokojení potřeb.)"
                ),
            ),
            questionNumber = 7,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co je to Pygmalion efekt?""",
            textAnswer = "Sebenaplňující se proroctví. Pygmalion efekt - pozitivní. Golem efekt - negativní.",
            answers =
            listOf(
                PsychologyTermAnswer("""sebenaplňující se předpověď""",
                    false
                ),
                PsychologyTermAnswer(
                    """psychologické pojmenování momentu náhlého pochopení dříve nesrozumitelného problému a úkolu vhledem""",
                    false,
                    "Würzburská škola, Kulpe, K.Buhler - experimentální laboratoř o myšlení. Kritický realismus - existence realit - věci na nás nezávislých"
                ),
                PsychologyTermAnswer(
                    """druh sociální percepce, globální chyba v posuzování lidí, když jsou posuzováni podle celkového dojmu""",
                    false,
                    "Haló efekt, E. L. Thorndike"
                ),
                PsychologyTermAnswer(
                    """obranný mechanismus ega spočívající v připisování vlastních negativních charakteristik jiným osobám """,
                    false,
                    "Projekce, S. Freud"
                ),
            ),
            questionNumber = 8,
            correctAnswer = 0,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018"
        ),
        PsychologyTerm(
            prompt = """Autorem konceptu kolektivního nevědomí je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """Carl Gustav Jung""",
                    false,
                    "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar." +
                        "\nIntrovert+Extravert+Ego (myšlení, cítění, čití/smyslové vnímání, intuice)"
                ),
                PsychologyTermAnswer("""Sigmund Freud""",
                    false
                ),
                PsychologyTermAnswer("""Johann Friedrich Herbart""",
                    false,
                    "Pedagogie, Realismus - existence realit - věci na nás nezávislých"
                ),
                PsychologyTermAnswer("""Eduard von Hartmann""",
                    false,
                    "Philosophy of the unconscious - ne tak úplně, je to hlavně ten název"
                ),
            ),
            questionNumber = 9,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "V psychologii byly postupně představeny různé teorie emocí." +
                " Která z následujících teorií mezi teorie emocí nepatří?",
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
            questionNumber = 10,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Jakým pojmem se v psychologii označuje vnitřní nesoulad postojů a chování člověka?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""disociativní psychóza""",
                    false
                ),
                PsychologyTermAnswer("""postojová konsonance""",
                    false
                ),
                PsychologyTermAnswer("""kognitivní disonance""",
                    false
                ),
                PsychologyTermAnswer("""myšlenkový paradox""",
                    false
                ),
            ),
            questionNumber = 11,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Jak se nazývá test, který má vyhodnotit míru," +
                " s níž konkrétní programy umělé inteligence uspějí v simulaci inteligence" +
                " (rozlišení, zda odpovídá člověk nebo počítač)?",
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
            questionNumber = 12,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Popis lidské mysli jako tabula rasa je charakteristický pro""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""racionalismus""",
                    false,
                    "Rozum a poznání jsou jediné zdroje informací - proti empirismu"
                ),
                PsychologyTermAnswer("""solipsismus""",
                    false,
                    "subjektivní idealismus, (z lat. solus ipse = jen já sám) - pouze osamělé vědomí."
                ),
                PsychologyTermAnswer(
                    """empirismus""",
                    false,
                    "John Locke (1632-1704), George Barkley (1685-1753) - blank slate/tabula rasa, \"I Know, because I've experienced\""
                ),
                PsychologyTermAnswer("""fenomenologii""",
                    false,
                    "introspekce. E. Husserl, M. Heideggar - filosoficky-humanistický směr. Chtěli přivést zpět vědockost, naše zkušenost je známá jen nám (Rogers)"
                ),
            ),
            questionNumber = 13,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Ačkoli nebývá zařazena v běžných testech inteligence," +
                " je hudební inteligence součástí jedné vlivné teorie inteligence. Kdo je jejím autorem?",
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
                        "\n\t1. Psychoticismus (zároveň předpoklad k onecmocnění)" +
                        "\n\t2. Extraverze (vzrušivost mozkové kůry)" +
                        "\n\t3. Neuroticismus (stabilita - labilita)."
                ),
            ),
            questionNumber = 14,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Co to znamená paměť procedurální?""",
            textAnswer = "Implicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť.",
            answers =
            listOf(
                PsychologyTermAnswer("""paměť pro osoby""",
                    false
                ),
                PsychologyTermAnswer("""paměť pro úkony""",
                    false
                ),
                PsychologyTermAnswer("""paměť pro fakta""",
                    false
                ),
                PsychologyTermAnswer("""paměť pro osobní zážitky""",
                    false
                ),
            ),
            questionNumber = 15,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Který řecký myslitel vytvořil typologii osobnosti dle 4 temperamentů odpovídajícím tělním tekutinám?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Platón""",
                    false,
                    "(Aristokles), Platonismus - myšlenky místo příkladů, Duše dává život" +
                        "\nSokrates -> Platon -> Aristoteles" +
                        "\n\t-dialogy s ostatními (a následné vyvracení)" +
                        "\n\t-díla: Republika, Obrana Sókratova, Ústava, Symposion, Gorgiás"
                ),
                PsychologyTermAnswer("""Sokrates""",
                    false,
                        "\n\t-\"Vím, že nic nevím\"" +
                        "\n\t-nehledal příčiny světa a člověka, ale soustředil se na člověka a společnosti" +
                        "\n\t-Sokratesova metoda (učení otázkami), kritické myšlení"
                ),
                PsychologyTermAnswer("""Aristoteles""",
                    false,
                    "\n\t-5 smyslů, TABULA RASA (de anima)" +
                    "\n\t-filozofická škola Lekeion - procházka s žáky" +
                    "\n\t-dualismus (všechny organismy), de anima parva naturalia, de memoria"
                ),
                PsychologyTermAnswer("""Hippokrates""",
                    false,
                    "Zakladatel lékařské vědy - Hippokratova přísaha. Corpus Hippocraticum"
                ),
            ),
            questionNumber = 16,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Mezi hlavní psychoterapeutické školy nepatří:""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""psychoanalýza""",
                    false,
                    "Freud"
                ),
                PsychologyTermAnswer("""EFT psychoterapie""",
                    false,
                    "Emotional Freedom Technique - porozumění emocionálním potřebám"
                ),
                PsychologyTermAnswer("""humanistická psychoterapie""",
                    false,
                    "Carl Rogers, Adler, Erikson, Fromm"
                ),
                PsychologyTermAnswer("""kognitivně-behaviorální psychoterapie """,
                    false,
                    "KBT - na léčení depresí, fóbíí, uzkostncýh poruch, příjmy potravy,..."
                ),
            ),
            questionNumber = 17,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Tato porucha osobnosti je charakteristická mělkou a labilní afektivitou‚" +
                " sebedramatizací‚ teatrálností‚ přehnaným projevem emocí‚ sugestibilitou‚ egocentričností‚" +
                " povolností vůči sobě‚ nedostatkem ohledu na druhé‚ bolestínstvím a trvalým vyžadováním ocenění‚" +
                " vzrušení a pozornosti. O jakou poruchu se jedná?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""závislá porucha osobnosti""",
                    false,
                    "Přenášení zodpovědnosti na druhé"
                ),
                PsychologyTermAnswer("""histrionská porucha osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""paranoidní porucha osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""schizoidní porucha osobnosti """,
                    false
                ),
            ),
            questionNumber = 18,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Který z mechanismů učení je popsán v následující definici: \"vymizení reakce na podnět po jeho několikanásobném opakování\"?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""bezděčné učení""",
                    false
                ),
                PsychologyTermAnswer("""klasické podmiňování""",
                    false
                ),
                PsychologyTermAnswer("""operantní podmiňování""",
                    false
                ),
                PsychologyTermAnswer(
                    """habituace""",
                    false,
                    "(přivykání) – na základě zkušenosti se sníží reakce a jedinec posléze přestane reagovat na podněty, které nepředstavují nebezpečí"
                ),
            ),
            questionNumber = 19,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Který z níže uvedených známých psychologických experimentů by bylo v dnešní době obtížné provést z hlediska současných etických principů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""Piagetovy experimenty – kognitivní vývoj""",
                    false
                ),
                PsychologyTermAnswer(
                    """Ashovy experimenty – konformita""",
                    false,
                    "Test konformity (posuzování délky čar) - změna chování kvůli soc. tlaku"
                ),
                PsychologyTermAnswer("""experimenty Loftusové – očití svědkové""",
                    false,
                    "Ptali se na rychlost auta ve videu nehody. Pokud bylo použito dramatičtější slovo, lidé hádali vyšší rychlost - vlastní schémata"
                ),
                PsychologyTermAnswer("""Milgramův experiment – poslušnost""",
                    false,
                    "elektrické šoky"
                ),
            ),
            questionNumber = 20,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Nedostatek této schopnosti bývá považován za jeden z klíčových deficitů u osob trpících autismem,
                 následkem čehož mají problémy v chápání myšlenkových pochodů jiných osob. Jak se tato schopnost označuje?""",
            textAnswer = "Jedná se také o schizofrenii a bipolární poruchu.",
            answers =
            listOf(
                PsychologyTermAnswer("""kognitivní kapacita""",
                    false
                ),
                PsychologyTermAnswer(
                    """teorie mysli""",
                    false,
                    """Schopnost usuzovat emoce, přání, touhy, potřeby a názory druhých lidí.
                         Také schopnost vytvářet představu o tom, že ostatní lidé mají také mysl a s ní spojené prožitky."""
                ),
                PsychologyTermAnswer(
                    """attachment""",
                    false,
                    "It is true autistic kids tend to have problems with attachment - mixed attachment style (Disorganized/disoriented)." +
                        "Although it is important to note, that 52% of the infants in the Strange Situation experiment still were seeking safety," +
                        " comfort and cease their distress with their caregivers."
                ),
                PsychologyTermAnswer(
                    """asimilace a akomodace""",
                    false,
                    """Piaget.
                         Asimilace je aplikování vnějších jevů a informací do již naučených schémat (schéma kočička) - když dítě slyší "mňau", ví, že to je kočička.
                         Akomodace (accommodate) - přizpůsobení vnitřního já vnejšímu novému jevu, který nezapadá do žádného již existujícímu, naučenému schématu.
                    """
                ),
            ),
            questionNumber = 21,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Rorschachův test je založen na principu""",
            textAnswer = "Projektivní test osobnosti. 10 víceméně symetrických pestrých/nepestrých skvrn.",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """indukce""",
                    false,
                    "(z lat. in-ducere, vyvozovat) - od jedinečného k obecnému"
                ),
                PsychologyTermAnswer("""dedukce""",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
                PsychologyTermAnswer("""projekce""",
                    false
                ),
                PsychologyTermAnswer("""sugesce""",
                    false,
                    "Sugesce (suggero - podsouvám, našeptávám)"
                ),
            ),
            questionNumber = 22,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Halucinace se řadí pod poruchy""",
            textAnswer = "Fiktivní obraz/osoba/věc, který vznikne bez reálného podnětu. Člověk ji považuje za realitu.",
            answers =
            listOf(
                PsychologyTermAnswer("""vnímání""",
                    false,
                    "dojem reálného vjemu bez příslušného podnětu"
                ),
                PsychologyTermAnswer("""myšlení""",
                    false
                ),
                PsychologyTermAnswer("""vůle""",
                    false
                ),
                PsychologyTermAnswer("""emocí""",
                    false
                ),
            ),
            questionNumber = 23,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
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
            questionNumber = 24,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
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
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018"
        ),
        PsychologyTerm(
            prompt = "V některých psychologických výzkumech je nutné držet jeho účastníky určitou dobu v nevědomosti o pravém účelu studie." +
                " V takovém případě do eticky prováděného výzkumu patří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""debriefing""",
                    false
                ),
                PsychologyTermAnswer("""deleting""",
                    false
                ),
                PsychologyTermAnswer("""detecting""",
                    false
                ),
                PsychologyTermAnswer("""defining""",
                    false
                ),
            ),
            questionNumber = 26,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Zhoršení choroby po předchozím zlepšení se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""resurekce""",
                    false
                ),
                PsychologyTermAnswer("""agravace""",
                    false,
                    "Zveličování obtíží pacientem."
                ),
                PsychologyTermAnswer("""remise""",
                    false,
                    "Odeznění příznaků"
                ),
                PsychologyTermAnswer("""relaps""",
                    false,
                    "Návrat do nemoce během remise"
                ),
            ),
            questionNumber = 27,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Maslow navrhl hierarchii lidských potřeb. " +
                "Která z následujících možností obsahuje jejich správné pořadí?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """jistota a bezpečí; fyziologické potřeby; sounáležitost a láska; úcta; sebeaktualizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby; jistota a bezpečí; úcta; sebeaktualizace; sounáležitost a láska""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby; jistota a bezpečí; sounáležitost a láska; úcta; sebeaktualizace""",
                    false
                ),
                PsychologyTermAnswer(
                    """fyziologické potřeby; sounáležitost a láska; jistota a bezpečí; úcta; sebeaktualizace """,
                    false
                ),
            ),
            questionNumber = 28,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Edmund Husserl je zakladatelem""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""frenologie""",
                    false,
                    "BS obor. Snaha vytvoření souvislostí mezi tvarem lebky a duševními schopnostmi a charakterovými rysy."
                ),
                PsychologyTermAnswer("""fenomenologie""",
                    false,
                    "Nedeterministcká - svodobná volba, introspekce. E. Husserl, M. Heideggar - filosoficky-humanistický směr. Chtěli přivést zpět vědockost, naše zkušenost je známá jen nám (Rogers)"
                ),
                PsychologyTermAnswer(
                    """gestalt psychologie""",
                    false,
                    "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                        "\nNěkteré věci, které řešili:" +
                        "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                        "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                        "\nZákon blízkosti (proximity) - v určité vzdálenosti vnímáme prvky jako celek." +
                        "\nZákon podobnosti - tendence vnímat podobné podněty jako celky."
               ),
                PsychologyTermAnswer("""faktologie""",
                    false
                ),
            ),
            questionNumber = 29,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Na ulici zkolabuje muž, kolem něj se seběhne shluk lidí, ale nikdo nic neudělá," +
                " zatímco když ten stejný muž zkolaboval minulý měsíc brzy ráno na opuštěné ulici," +
                " náhodný kolemjdoucí okamžitě zavolal sanitku. Jak psychologie tento jev označuje?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""sociální polarizace""",
                    false,
                    "Změna názorů skupiny na základě diskuze. Může dojít k posunu k riskantnosti nebo i k větší opatrnosti."
                ),
                PsychologyTermAnswer("""sociální deziderabilita""",
                    false,
                    "Člověk se chová, jak očekává že daná společnost od něj očekává."
                ),
                PsychologyTermAnswer("""efekt přihlížejícího""",
                    false,
                    "Rozložení odpovědnosti na všechny lidi okolo - čím více lidí, tím méně odpovědnosti individuální osoby."
                ),
                PsychologyTermAnswer("""efekt nečinnosti""",
                    false,
                    "neexistuje"
                ),
            ),
            questionNumber = 30,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Neurotransmiter je""",
            textAnswer = "Glutammát (excitační) - aktivátor všech mozk. funckcí" +
                "\nGaba (inhibiční, kyselina gamaaminomáselný) - alkohol, anxiotika" +
                "\nDopamin - limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)" +
                "\nSeratonin - prožívání, spánek, deprese" +
                "\nAcethylcholin - nové paměťové spoje, Alzheimer, parasympatický NS" +
                "\nAdrenalin (Epinefrin), nonadrenalin - aktivace, spánek, probuzení, sympatický NS" +
                "\nOxytocin - sociální příjimání (matky mají mnoho před porodem)" +
                "\nEndorfiny (inhibiční) - tlumí bolest",
            answers = listOf(
                PsychologyTermAnswer("""lék podávaný při silné úzkosti""",
                    false,
                    "Třeba benzodiazepin nebo buspiron"
                ),
                PsychologyTermAnswer("""výběžek neuronu""",
                    false,
                    "To je axon"
                ),
                PsychologyTermAnswer(
                    """nervová uzlina tvořená shlukem nervových buněk""",
                    false
                ),
                PsychologyTermAnswer(
                    """chemická látka, která zajišťuje komunikaci mezi neurony v mozku""",
                    false
                ),
            ),
            questionNumber = 31,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Jak jsou nazývány buňky v mozku zajišťující výživu neuronů, podporu neurální sítě a mající schopnost fagocytózy?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""gliové buňky (neuroglie)""",
                    false,
                    "Centrální:" +
                        "\n\t1) Makroglie: " +
                        "\n\t\tAstrocyty - regenerace a výživa" +
                        "\n\t\tOligodendroglie - tvoří myelin" +
                        "\n\t2) Mikroglie - čistí, hojí" +
                        "\nPeriferní:" +
                        "\n\tSchwannovy buňky - stejně jako Oligodendroglie, ale jen jedno vlákno" +
                        "\n\tSatelitové buňky - obalují neurony v gangliích" +
                        "\n\tHlasové a míšní nervy",
                ),
                PsychologyTermAnswer("""pseudoneurony""",
                    false
                ),
                PsychologyTermAnswer("""mitochondrie""",
                    false,
                    "Produkce energie - Oxidace glukózy, Produkce tepla,..."
                ),
                PsychologyTermAnswer("""ani jedno z uvedených""",
                    false
                ),
            ),
            questionNumber = 32,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Aktivace sympatiku způsobí""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""rozšíření cév zásobujících svalstvo""",
                    false
                ),
                PsychologyTermAnswer("""podpoření trávení""",
                    false,
                    "Naopak, tohle se děje při klidnění - parasympatický NS"
                ),
                PsychologyTermAnswer("""zúžení zornic""",
                    false,
                    "Naopak, tohle se děje při klidnění - parasympatický NS"
                ),
                PsychologyTermAnswer("""snížení tlaku krve""",
                    false,
                    "Naopak, tohle se děje při klidnění - parasympatický NS"
                ),
            ),
            questionNumber = 33,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Jak se nazývá ta část mozku, která spojuje levou a pravou hemisféru?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""medulla obllongata""",
                    false,
                    "Prodložená mícha - reflexy (kašel, sací, polykací, zvracivý), křížení eferentní a aferentní."
                ),
                PsychologyTermAnswer("""amygdala""",
                    false,
                    "Stres, emoce, pudy."
                ),
                PsychologyTermAnswer("""gyrus cinguli""",
                    false,
                "Cingulární kortex (korová oblast) - limbický systém,  mimovolní aktivita/pohyb"
                ),
                PsychologyTermAnswer("""corpus callosum""",
                    false,
                    "R. Sperry - rozštěpení levé a pravé hemisféry, hemisféry fungují nezávisle na sobě, inverze končetin (levé okolo, pravá část hemisféry)"
                ),
            ),
            questionNumber = 34,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://docplayer.cz/docs-images/40/6531242/images/page_6.jpg",
            prompt = """Kolik párů míšních nervů vystupuje z míchy?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""32""",
                    false
                ),
                PsychologyTermAnswer("""30""",
                    false
                ),
                PsychologyTermAnswer("""31""",
                    false
                ),
                PsychologyTermAnswer("""28""",
                    false
                ),
            ),
            questionNumber = 35,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Míšní nervy podle výstupu dělíme na""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer(
                    """krční, hrudní, bederní, křížové, kostrční""",
                    false
                ),
                PsychologyTermAnswer("""eferentní, aferentní""",
                    false
                ),
                PsychologyTermAnswer("""mozkové, páteřní""",
                    false
                ),
                PsychologyTermAnswer("""šedá hmota, bílá hmota """,
                    false
                ),
            ),
            questionNumber = 36,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Co je to cerebellum?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""mozek""",
                    false
                ),
                PsychologyTermAnswer("""mozeček""",
                    false,
                    "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky"
                ),
                PsychologyTermAnswer("""prodloužená mícha""",
                    false,
                    "(Medulla Obllongata) - reflexy (kašel, sací, polykací, zvracivý), křížení eferentní a aferentní."
                ),
                PsychologyTermAnswer("""střední mozek""",
                    false,
                    "Střední mozek - držení vzpřímené polohy těla" +
                        "\n\t-čtverohrbolí - zrakové a sluchové reflexy" +
                        "\n\t-substantia nigra - dopamin (Parkinson, Schizofrenie)"
                ),
            ),
            questionNumber = 37,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Který hormon je nejvýznamnější pro pohlavní zrání u mužů?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""estrogen""",
                    false
                ),
                PsychologyTermAnswer("""testosteron""",
                    false
                ),
                PsychologyTermAnswer("""progesteron""",
                    false
                ),
                PsychologyTermAnswer("""serotonin""",
                    false,
                    "prožívání, spánek, chuť, deprese, nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
            ),
            questionNumber = 38,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Jaké hormony jsou vylučovány do krve z neurohypofýzy?""",
            textAnswer = "Zadní lalok hypofýzy - hypothalamus, vylučuje hormony.",
            answers =
            listOf(
                PsychologyTermAnswer("""oxytocin, ADH (antidiuretický hormon)""",
                    false,
                    "sociální příjimání (matky mají mnoho před porodem)"
                ),
                PsychologyTermAnswer("""STH (somatotropní hormon), endorfiny""",
                    false,
                    "tlumí bolest"
                ),
                PsychologyTermAnswer("""prolaktin, noradrenalin""",
                    false
                ),
                PsychologyTermAnswer("""kalcitonin, thyroxin """,
                    false
                ),
            ),
            questionNumber = 39,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = """Fenotyp je""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""konkrétní varianta genu""",
                    false
                ),
                PsychologyTermAnswer(
                    """soubor všech genů, které má organismus k dispozici pro zajištění svých biochemických, fyziologických a morfologických znaků""",
                    false,
                    "genotyp"
                ),
                PsychologyTermAnswer(
                    """soubor všech pozorovatelných vlastností a znaků organismu""",
                    false
                ),
                PsychologyTermAnswer("""soubor chromozomů daného organismu""",
                    false,
                    "23 párů"
                ),
            ),
            questionNumber = 40,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Lidský zárodek obvykle dospívá u zdravé ženy do děložní dutiny ve stádiu:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""fistuly""",
                    false
                ),
                PsychologyTermAnswer("""gastruly""",
                    false
                ),
                PsychologyTermAnswer("""blastuly""",
                    false
                ),
                PsychologyTermAnswer("""moruly""",
                    false
                ),
            ),
            questionNumber = 41,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = """Co je to tachykardie?""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""zpomalení srdečního rytmu""",
                    false,
                    "Bradykardie"
                ),
                PsychologyTermAnswer("""zrychlení dýchání""",
                    false
                ),
                PsychologyTermAnswer("""zrychlení srdečního rytmu""",
                    false
                ),
                PsychologyTermAnswer("""zpomalení dýchání""",
                    false
                ),
            ),
            questionNumber = 42,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Neurotransmiter, v jehož produkci se předpokládá největší narušení při Parkinsonově chorobě, se nazývá:",
            textAnswer = "Glutammát (excitační) - aktivátor všech mozk. funckcí" +
                "\nGaba (inhibiční, kyselina gamaaminomáselný) - alkohol, anxiotika" +
                "\nDopamin - limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)" +
                "\nSeratonin - prožívání, spánek, deprese" +
                "\nAcethylcholin - nové paměťové spoje, Alzheimer, parasympatický NS" +
                "\nAdrenalin (Epinefrin), nonadrenalin - aktivace, spánek, probuzení, sympatický NS" +
                "\nOxytocin - sociální příjimání (matky mají mnoho před porodem)" +
                "\nEndorfiny (inhibiční) - tlumí bolest",
            answers =
            listOf(
                PsychologyTermAnswer("""serotonin""",
                    false,
                    "prožívání, spánek, chuť, deprese, nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""dopamin""",
                    false,
                    "limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)"
                ),
                PsychologyTermAnswer("""adrenalin""",
                    false,
                    "aktivace, spánek, probuzení, sympatický NS"
                ),
                PsychologyTermAnswer("""noradrenalin """,
                    false,
                    "aktivace, spánek, probuzení, sympatický NS"
                ),
            ),
            questionNumber = 43,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = """Hlavním místem odstraňování červených krvinek z krevního oběhu u zdravého člověka je/jsou""",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""slezina""",
                    false
                ),
                PsychologyTermAnswer("""slepé střevo""",
                    false
                ),
                PsychologyTermAnswer("""ledviny""",
                    false
                ),
                PsychologyTermAnswer("""játra""",
                    false
                ),
            ),
            questionNumber = 44,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Julie se nešťastnou náhodou uhodila do hlavy, po prvotním šoku zjistila," +
                " že neudrží rovnováhu. Na zranění které části mozku nejspíše padne podezření?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("""mozeček""",
                    false,
                    "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky"
                ),
                PsychologyTermAnswer("""most Varolův""",
                    false,
                    "Varolův most (pons varoli) - spojuje mozeček, střední mozek a prodlouženou míchu, regulace dýchání, slzných a slinných žláz"
                ),
                PsychologyTermAnswer("""epifýza""",
                    false,
                    "Mezimozek, produkuje hormony, hlavně Melatonin"
                ),
                PsychologyTermAnswer("""endofýza""",
                    false
                ),
            ),
            questionNumber = 45,
            categoryId = "Nezávislý test - OBOROVÝ PŘIJÍMACÍ TEST PSYCHOLOGIE FF MU 2017/2018",
            correctAnswer = 0
        ),
    )
}