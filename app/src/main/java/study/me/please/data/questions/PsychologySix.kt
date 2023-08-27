package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//revidovano
object PsychologySix {

    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Rozdíl mezi motivačním stavem a motivační vlastností:""",
            textAnswer = "Motivační vlastnosti - sklony, občas specifické na čas (Freud)",
            answers = listOf(
                PsychologyTermAnswer(
                    """stav je přechodný, vlastnost relativně trvalá""",
                    false
                ),
                PsychologyTermAnswer(
                    """termín motivační stav se používá v souvislosti s kognitivně zprostředkovanými motivy""",
                    false,
                    "Motiv - uvědomělé podněty vyvolávající uspokojení potřeb."
                ),
                PsychologyTermAnswer(
                    """jde o dvě označení téhož fenoménu""",
                    false
                ),
                PsychologyTermAnswer(
                    """stav je důsledkem motivace, vlastnost její příčinou""",
                    false
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt ="\"Big five\" je označení pro",
            textAnswer = "1. Otevřenost (zkušenostem)" +
                "\n2. Svědomitost - sebekontrola" +
                "\n3. Extraverze - sociabilita a aktivita lidí" +
                "\n4. Přívětivost (agreebleness) - ochota ustupovat (pomáhat) pro dobro druhých" +
                "\n5. Neuroticismus - jak jedinec prožívá negativní emoce, úzkost, náladovost",
            answers = listOf(
                PsychologyTermAnswer(
                    """pět kroků, kterými osobnosti prochází ve vývoji""",
                    false
                ),
                PsychologyTermAnswer(
                    """pět dimenzí, ve kterých lidé mají sklon hodnotit sebe a ostatni""",
                    false
                ),
                PsychologyTermAnswer(
                    """pět nejvýznamnějších psychologických teorií""",
                    false
                ),
                PsychologyTermAnswer(
                    """pět základních potřeb, které tvoří základ osobnosti""",
                    false
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Konstitutční typologie""",
            textAnswer = "E. Kretschmer se snažil se spojit fyziologickou postavu jedince k patologii." +
                "\nAstenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            answers = listOf(
                PsychologyTermAnswer(
                    """analyzují fyziologické aspekty stavby mozku a z nich vysuzují strukturu osobnosti""",
                    false,
                    "frenologie"
                ),
                PsychologyTermAnswer(
                    """hledají vlastnosti, které jsou ustavujícím jádrem osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """se soustředí na výstavbu osobnosti ve vývoji""",
                    false
                ),
                PsychologyTermAnswer(
                    """dávají do souvislosti typ tělesné stavby s typem osobnosti""",
                    false
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Temperament zahrnuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""charakterové zaměření osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""formální vlastnosti osobnosti""",
                    false,
                    "Biologický základ (formální, průběhové, dynamické, charakteristiky vztahující se ke stylu chování) - povahové vlastnosti"
                ),
                PsychologyTermAnswer("""výkonové vlastnosti osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""obsahové zaměření osobnosti""",
                    false
                ),
            ),
            questionNumber = 4,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Činný optimismus je nálada, která nejlépe charakterizuje temperamentový typ""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""cholerika""",
                    false,
                    "žlutá žluč - labilní, výbušnost"
                ),
                PsychologyTermAnswer("""melancholika""",
                    false,
                    "černá žluc - labilní, emotivita, uzavřenost"
                ),
                PsychologyTermAnswer("""sangvinika""",
                    false,
                    "krev - radost ze života"
                ),
                PsychologyTermAnswer("""flegmatika""",
                    false,
                    "sliz, hlen - klid, lhostejnost"
                ),
            ),
            questionNumber = 5,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Cyklotymie je v Kretschmerově typologii spojena s tělesným typem""",
            textAnswer = "Dlouhodobé střídaní nálad od mírné deprese po mírné elace (veselo)",
            answers = listOf(
                PsychologyTermAnswer("""leptosomním""",
                    false,
                    "Astenický, leptosomní (schizothymní) typ - štíhlí, vysoký - náladový, nervózní."
                ),
                PsychologyTermAnswer("""atletickým""",
                    false,
                    "Atletický (viskózní) typ - vyrovnaný, nic mu není."
                ),
                PsychologyTermAnswer("""astenickým""",
                    false,
                    "štíhlý, vysoký - náladový, nervózní."
                ),
                PsychologyTermAnswer("""pyknickým""",
                    false,
                    "Pyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese."
                ),
            ),
            questionNumber = 6,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Jak se označuje míra výkonu, kterou od sebe jedinec očekává při provádění známého úkolu?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""aspirační úroveň""",
                    false,
                    "Cíle mají formu jasné představy, obrazového obsahu či předjímání uspokojení z naplnění"
                ),
                PsychologyTermAnswer("""stupeň očekávání""",
                    false
                ),
                PsychologyTermAnswer("""ambiční úroveň""",
                    false
                ),
                PsychologyTermAnswer("""očekávaná četnost""",
                    false
                ),
            ),
            questionNumber = 7,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://wikisofia.cz/w/images/5/5f/HebbianYerkesDodson.JPG",
            prompt = """Podle Yerkes-Dodsonův zákonu neplatí""",
            textAnswer = "Optimum motivovanosti",
            answers = listOf(
                PsychologyTermAnswer("""U jednodušších činností na vyšší úrovni intenzity je optimum""",
                    false
                ),
                PsychologyTermAnswer("Arousal je bod, ve kterém je člověk schopen nevyššího výkonu",
                    false
                ),
                PsychologyTermAnswer("U složitějších činností na vyšší úrovni intenzity je optimum",
                    false
                ),
                PsychologyTermAnswer("""U složitějších činností na nižší úrovni intenzity je optimum""",
                    false
                ),
            ),
            questionNumber = -7,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Termín psychologické obrany se používá k označení""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """chování, kterým jedinec brání svou referenční skupinu""",
                    false
                ),
                PsychologyTermAnswer(
                    """mechanismů, kterými dokáže jedinec odvrátit hrozící agresivní chování druhých""",
                    false
                ),
                PsychologyTermAnswer(
                    """mechanismů, které chrání před úzkostí vznikající při ohrožení sebepojetí jedince""",
                    false
                ),
                PsychologyTermAnswer(
                    """argumenty, jimiž jedinec prosazuje své postoje""",
                    false
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Pětifaktorový model Big Five nezahrnuje jako osobnostní dimenzi:""",
            textAnswer = "1. Otevřenost (zkušenostem)" +
                "\n2. Svědomitost - sebekontrola" +
                "\n3. Extraverze - sociabilita a aktivita lidí" +
                "\n4. Přívětivost (agreebleness) - ochota ustupovat (pomáhat) pro dobro druhých" +
                "\n5. Neuroticismus - jak jedinec prožívá negativní emoce, úzkost, náladovost",
            answers = listOf(
                PsychologyTermAnswer("""přívětivost""",
                    false,
                    "(agreebleness) - ochota ustupovat (pomáhat) pro dobro druhých"
                ),
                PsychologyTermAnswer("""svědomitost""",
                    false,
                    "sebekontrola"
                ),
                PsychologyTermAnswer("""otevřenost vůči zkušenosti""",
                    false
                ),
                PsychologyTermAnswer("""inteligenci""",
                    false
                ),
            ),
            questionNumber = 9,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Pojem psychoticismu v souvislosti s temperamentem se objevuje u""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""H. J. Eysencka""",
                    false,
                    "Studoval inteligenci a osobnosti." +
                        "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                        "\nDělení osobnosti:" +
                        "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                        "\n\tExtraverze (vzrušivost mozkové kůry)" +
                        "\n\tNeuroticismus (stabilita - labilita)."
                ),
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
                PsychologyTermAnswer("""Heymanse a Wiersmy""",
                    false,
                    "Teorie temperamentu:" +
                        "\n\tEmocionalita vs. Nedostatek emocionality" +
                        "\n\tAktivita vs. Pasivita - vztah k práci, volnému času a závazkům" +
                        "\n\tPrimární funkce (okamžitá, silná reakce) vs. Sekundární funkce (slabá počáteční, postupný nárůst)"
                ),
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
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Termínem intencionalita při popisu psychických stavů či procesů rozumíme""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """zakotvení ve fenomenologické bázi prožívání jedince""",
                    false,
                    "Fenomenologie - (Kant, fenomenální objekty) - jak člověk opravdu vnímá věci, zkušenosti."
                ),
                PsychologyTermAnswer(
                    """předmětnost, tj. to, že se daný stav vztahuje k nějakému předmětu""",
                    false
                ),
                PsychologyTermAnswer("""schopnost nabývat různých intenzit""",
                    false
                ),
                PsychologyTermAnswer(
                    """jejich neoddělitelné propojení s činností""",
                    false
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Kterým z termínů se označuje rysová úzkost?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""deprese""",
                    false
                ),
                PsychologyTermAnswer("""depresivita""",
                    false
                ),
                PsychologyTermAnswer("""anxiozita""",
                    false
                ),
                PsychologyTermAnswer("""anxieta""",
                    false
                ),
            ),
            questionNumber = 12,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Jaké je správné seřazení emočních jevů co do trvalosti a stálosti (od nejproměnlivějších po nejtrvalejší)?""",
            textAnswer = "Afekty – intenzivní emoce, vzniká náhle, prudce a má konkrétní zaměření" +
                "\nNálady - déletrvající pohotovost k emočním reakcím určitého směru",
            answers = listOf(
                PsychologyTermAnswer(
                    """afekty, nálady, temperamentové vlastnosti""",
                    false
                ),
                PsychologyTermAnswer("""žádné řazení není adekvátní""",
                    false
                ),
                PsychologyTermAnswer(
                    """nálady, emoční stavy, temperamentové vlastnosti""",
                    false,
                    "Emoční stav je stav aktulních emocí - emoce jsou afektivní"
                ),
                PsychologyTermAnswer(
                    """nálady, temperamentové vlastnosti, emoční stavy""",
                    false
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Získané předpoklady pro vykonávání určitých konkrétních činností označujeme jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nadání""",
                    false
                ),
                PsychologyTermAnswer("""dispozice""",
                    false,
                    "rysy"
                ),
                PsychologyTermAnswer("""schopnosti""",
                    false
                ),
                PsychologyTermAnswer("""dovednosti""",
                    false
                ),
            ),
            questionNumber = 14,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Pokud se chování a prožívání změní tak, že jedinec opakuje projevy typické pro dřívější vývojová stadia, mluvíme o""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""infantilni neuróze""",
                    false
                ),
                PsychologyTermAnswer("""progresi""",
                    false
                ),
                PsychologyTermAnswer("""zpětném efektu""",
                    false
                ),
                PsychologyTermAnswer(
                    """regresi""",
                    false,
                    "Nevědomý obranný mechanizmus. Únik na vývojově nižší úroveň chování."
                ),
            ),
            questionNumber = 15,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Freudův výraz pro sexuální, resp. životní psychickou energii zní""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""libido""",
                    false
                ),
                PsychologyTermAnswer("""sexuální apetence""",
                    false,
                    "Apetence - určitá preference k druhu stimulů či aktivit"
                ),
                PsychologyTermAnswer("""sexuální apetit""",
                    false
                ),
                PsychologyTermAnswer("""destrudo""",
                    false
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Termín libido označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""hedonické kontinuum""",
                    false,
                    "spektrum/škála pocitů a emocí. Od pozitivních, netruálním k negativním." +
                        "\nTaké může znamenat \"pocitová rovnováha\"" +
                        "\n(řec. hēdonē=potěšení)"
                ),
                PsychologyTermAnswer("""destruktivní pud""",
                    false
                ),
                PsychologyTermAnswer("""crotický ideál""",
                    false
                ),
                PsychologyTermAnswer("""sexuální energii""",
                    false
                ),
            ),
            questionNumber = 17,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = "Dnes již lidové označení \"psychopat\" by se patrně nejlépe hodilo na člověka trpícího",
            textAnswer = "Manipulace, povrchnost, bez empatie, impulsivita.",
            answers = listOf(
                PsychologyTermAnswer("""pervazivní vývojovou poruchou""",
                    false
                ),
                PsychologyTermAnswer("""psychózou""",
                    false,
                    "Ztráta kontaktu s realitou, např. halucinace, bludy, poruchy myšlení a řeči"
                ),
                PsychologyTermAnswer("""neurózou""",
                    false,
                    "Historický termín - psychické poruchy, mimo psychózy (dnes většinově úzkostné a přizpůsobovací poruchy)"
                ),
                PsychologyTermAnswer("""poruchou osobnosti""",
                    false
                ),
            ),
            questionNumber = 18,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Jak by se dalo nejlépe psychologicky charakterizovat svědomí?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""internalizované normy jednání""",
                    false
                ),
                PsychologyTermAnswer("""internalizované meze chování""",
                    false
                ),
                PsychologyTermAnswer("""ego-ideál""",
                    false
                ),
                PsychologyTermAnswer("""nedostatečně rozvinuté super-ego""",
                    false
                ),
            ),
            questionNumber = 19,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Který teoretik vytvořil model přirovnávající osobnosti k divadlu a k divadelní roli?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""W. Shakespeare""",
                    false
                ),
                PsychologyTermAnswer("""E. Goffman""",
                    false,
                    "Interakcionistická Sociologie, stigmata." +
                        "\nDramaturgický přístup: " +
                        "\n\t- sociální interakce jako divadelní představení, má své fáze - začátek, uvedení do role, výkon, závěr" +
                        "\n\tManagement dojmů (autoprezentace) - snažíme se ovládat co si ostatní o nás myslí" +
                        "\n\tfront, back, off stage - přední, zadní, zbytkový region"
                ),
                PsychologyTermAnswer("""V. Frankl""", false,
                    "Logoterapie (humanismus, existencialismus, třetí vídeňská škola)" +
                        "\n \"Touha po smyslu\", Man's search for meaning, paradoxní intence" +
                        "\nNoogenní neuróza - neodstatek smyslu čí cíle v životě"
                ),
                PsychologyTermAnswer("""F. Klix (1894-1974)""",
                    false,
                    "Psychoanalýza, psychosomatické poruchy"
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Ve Sprangerově typologii hodnotových orientací se nevyskytuje typ""",
            textAnswer = "Sprangerova typologie:" +
                "\n\t1. Ekonomický typ - praktický, ze zkušenost hlavně hmotný přínos" +
                "\n\t2. Náboženský typ - duchovní hodnoty, zkušenosti" +
                "\n\t3. Teoretický typ - hledání pravdy, poznání (filozof)" +
                "\n\t4. Estetický typ - vychutnávání si života" +
                "\n\t5. Politický typ - moc, dominance" +
                "\n\t6. Sociální typ - láska k druhým, sebeovládání",
            answers = listOf(
                PsychologyTermAnswer("""estetický""",
                    false,
                    "vychutnávání si života"
                ),
                PsychologyTermAnswer("""politický""",
                    false,
                    "moc, dominance"
                ),
                PsychologyTermAnswer("""individualistický""",
                    false
                ),
                PsychologyTermAnswer("""teoretický""",
                    false,
                    "hledání pravdy, poznání (filozof)"
                ),
            ),
            questionNumber = 21,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Psychoanalytická teorie rozlišuje v rámci topografického modelu několik psychických subsystémů z hlediska přístupnosti uvědomění. Jsou to""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nevědomí, předvědomí, vědomí""",
                    false
                ),
                PsychologyTermAnswer("""nevědomí, vědomí, nadvědomí""",
                    false
                ),
                PsychologyTermAnswer("""nevědomí, předvědomí, Já""",
                    false
                ),
                PsychologyTermAnswer("""podvědomí, vědomí""",
                    false
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Eysenckovo pojetí temperamentu vychází z""",
            textAnswer = "Studoval inteligenci a osobnosti." +
                "\nDělení osobnosti:" +
                "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                "\n\tExtraverze (vzrušivost mozkové kůry)" +
                "\n\tNeuroticismus (stabilita - labilita).",
            answers = listOf(
                PsychologyTermAnswer("""obsahové analýzy výpovědí pokusných osob""",
                    false
                ),
                PsychologyTermAnswer("""analýzy přirozeného jazyka""",
                    false
                ),
                PsychologyTermAnswer(
                    """hypotetických fyziologických a nervových mechanismů""",
                    false
                ),
                PsychologyTermAnswer("""psychoanalytické teorie""",
                    false
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Protiklad závislosti/nezávislosti na poli je příkladem jedné z osobnostních charakteristik poznávacích procesů? Jde o""",
            textAnswer = "Závislost na poli - tendence jedince preferovat globální kontext před detaily v situacích, kde je obojí." +
                "\nPoužívá se třeba Test skrytých figur, kde hledáme schované věci v obrázcích (např. geometrické tvary) a jsme měřeni.",
            answers = listOf(
                PsychologyTermAnswer("""krystalizovanou inteligenci""",
                    false
                ),
                PsychologyTermAnswer("""kognitivní (poznávací) styl""",
                    false,
                    "Jakým způsobem zpracováváme informace, strategie které používáme při řešení problémů apod."
                ),
                PsychologyTermAnswer("""senzorickou vzrušivost""",
                    false
                ),
                PsychologyTermAnswer("""percepční (vjemovou) zaměřenost""",
                    false
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Co znamená původně slovo persona?""",
            textAnswer = "Původ z latiny=\"maska\" nebo \"osoba\"",
            answers = listOf(
                PsychologyTermAnswer("""maska""",
                    false
                ),
                PsychologyTermAnswer("""autora hry""",
                    false
                ),
                PsychologyTermAnswer("""praktikábl""",
                    false
                ),
                PsychologyTermAnswer("""jeviště""",
                    false
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Který z popisů vztahu mezi tvořivostí a inteligencí je adekvátní?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """určitá míra tvořivosti je nutnou, nikoli však postačující podmínkou inteligence""",
                    false
                ),
                PsychologyTermAnswer(
                    """určitá míra inteligence je nutnou, nikoli však postačující podmínkou tvořivosti""",
                    false
                ),
                PsychologyTermAnswer("""tvořivost stoupá s inteligencí""",
                    false
                ),
                PsychologyTermAnswer("""tyto vlastnosti jsou nezávislé""",
                    false
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = "Teze, že \"člověk aktivně zkoumá skutečnost ve snaze získat kontrolu nad událostmi v životě pomocí pojmů a pravidel," +
                " které si k tomu účelu osvojuje a vytváří\" (Balcar, 1984), je charakteristická pro",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""vývojové pojetí osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""kognitivní pojetí osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""algoritmické pojetí osobnosti""",
                    false,
                    "Rozklad osobnosti na matematické modely a algoritmy. Např psychometrie."
                ),
                PsychologyTermAnswer("""seberealizační pojetí osobnosti""",
                    false
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Obecné vlastnosti duševní dynamiky, tj. typický způsob, jakým probíhají nejrůznější duševní děje u jedince, se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""temperament""",
                    false
                ),
                PsychologyTermAnswer("""dynamogenie""",
                    false,
                    "psychická energie, která nás pohání a může být ovlivněna faktory jako je např. frustrace, úspěchy apod. (Psychoanalýza, psychodynamika)"
                ),
                PsychologyTermAnswer("""motivační dynamika""",
                    false
                ),
                PsychologyTermAnswer("""charakter""",
                    false
                ),
            ),
            questionNumber = 28,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených autorů není představitelem humanistické psychologie?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""G. Allport""", false,
                    "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                ),
                PsychologyTermAnswer("""A. Maslow""",
                    false
                ),
                PsychologyTermAnswer("""C. Rogers""",
                    false
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
            questionNumber = 29,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Třírozměrný strukturní model inteligence, který má podobu krychle a až 120 různých faktorů, vypracoval""",
            textAnswer = "",
            answers = listOf(
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
                PsychologyTermAnswer(
                    """C. Burt""",
                    false,
                    "Pedagogický psycholog, měření IQ, dědění IQ (které zfalšoval)."
                ),
                PsychologyTermAnswer("""H. Rorschach (1884-1922)""",
                    false,
                    "Projektivní Rorschachův test - 10 inkblotů"
                ),
                PsychologyTermAnswer("""J. B. Guilford""",
                    false,
                    "Třírozměrný strukturní model inteligence (120 schopností):" +
                        "\n\t1.Operace - způsoby myšlení, např. srovnávání, třídění, rozhodování" +
                        "\n\t2.Obsah - konkrétní ifnroamce a znalosti (paměť)" +
                        "\n\t3.Produkt - aplikace Obsahu a Operace na řešení problémů" +
                        "\n\nStudium IQ, rozlišení konvergentní (testy na správnou odpověď) a divergentní (kreativní, variabilní) - v testech a myšlení"
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Sklon k podřízenému a poddajnému chování označujeme termínem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""submisivita""",
                    false
                ),
                PsychologyTermAnswer("""subordinace""",
                    false
                ),
                PsychologyTermAnswer("""inferiorni agrese""",
                    false
                ),
                PsychologyTermAnswer("""subalternost""",
                    false
                ),
            ),
            questionNumber = 31,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Podle strukturálního modelu v rámci psychoanalýzy existují tři osobnostní systémy. Jsou to""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Ono, Já, Svědomí""",
                    false
                ),
                PsychologyTermAnswer("""Nevědomí, Já, Nadjá""",
                    false
                ),
                PsychologyTermAnswer("""Podvědomí, Já, Nadjá""",
                    false
                ),
                PsychologyTermAnswer("""Ono, Já, Nadjá""",
                    false
                ),
            ),
            questionNumber = 32,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Podle statisticky podložených výzkumů je jedna informace nesprávná. Která to je?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """extraverti masturbují častěji než introverti""",
                    false
                ),
                PsychologyTermAnswer(
                    """introverti dosahují vyššího stupně vysokoškolského vzdělání než extraverti""",
                    false
                ),
                PsychologyTermAnswer(
                    """introverti pracují lépe ráno a extraverti odpoledne""",
                    false
                ),
                PsychologyTermAnswer(
                    """v "testu citrónové kapky" produkují introverti více slin než extraverti""",
                    false,
                    "H. J. Eysenck - introverti při čtyřech kapkách citronové šťávy produkují introverti dvakrát více slin než extraverti"
                ),
            ),
            questionNumber = 33,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Hodnotová orientace má nejblíže k""",
            textAnswer = "\"Co má pro jedince největší význam v životě\"." +
                "\nSprangerova typologie:" +
                "\n\t1. Ekonomický typ - praktický, ze zkušenost hlavně hmotný přínos" +
                "\n\t2. Náboženský typ - duchovní hodnoty, zkušenosti" +
                "\n\t3. Teoretický typ - hledání pravdy, poznání (filozof)" +
                "\n\t4. Estetický typ - vychutnávání si života" +
                "\n\t5. Politický typ - moc, dominance" +
                "\n\t6. Sociální typ - láska k druhým, sebeovládání",
            answers = listOf(
                PsychologyTermAnswer("""motivačním vlastnostem osobnosti""",
                    false,
                    "Jak se jedinec motivuje a jaké usílí vkládá do věcí, vrozené nebo vyvinuté." +
                        "\nAmbice, sebevědomí, touha po úspěcha, potřeba uznání druhými"
                ),
                PsychologyTermAnswer("""motivačním stavům osobnosti""",
                    false,
                    "Jak se zrovna cítíme motivačně"
                ),
                PsychologyTermAnswer("""kognitivním operacím""",
                    false
                ),
                PsychologyTermAnswer("""kognitivnímu stylu""",
                    false,
                    "Způsob, jakým jedinec zpracovává, organizuje a používá informace"
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Na kterou složku osobnosti má zřejmě největší vliv výchova a sociální působení?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""temperament""",
                    false
                ),
                PsychologyTermAnswer("""charakter""",
                    false
                ),
                PsychologyTermAnswer("""kognitivní styl""",
                    false,
                    "Způsob, jakým jedinec zpracovává, organizuje a používá informace"
                ),
                PsychologyTermAnswer("""tekutá inteligence""",
                    false
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Morfologicky založená pojetí temperamentu dávají temperament do souvislosti s""",
            textAnswer = "řec.\"morphē\"=tvar, forma",
            answers = listOf(
                PsychologyTermAnswer(
                    """uspořádáním aktivačních neuronových okruhů""",
                    false
                ),
                PsychologyTermAnswer("""proměnlivostí lidského chování""",
                    false
                ),
                PsychologyTermAnswer("""tvarem lebky""",
                    false,
                    "frenologie - C. Lomboroso (1835-1909)"
                ),
                PsychologyTermAnswer("""tělesnou stavbou""",
                    false,
                    "Konstituční typologie osobnosti - E. Kretschmer"
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Implicitní teorie osobnosti""",
            textAnswer = "Vnímání ovlivněno předchozími zkušenostmi, tento vliv je nevědomý, proto implicitní.",
            answers = listOf(
                PsychologyTermAnswer(
                    """je laická představa o vzájemných vztazích mezi psychickými vlastnostmi""",
                    false
                ),
                PsychologyTermAnswer(
                    """představují skupinu teorií, které nepředpokládají výrazný vztah sociálního okoli na projevy rysů osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """představují skupinu teorií, které předpokládají výrazný vztah sociálního okolí na projevy rysů osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """jsou teorie osobnosti, které odmítají stabilní, trvalé a explicitně formulovatelné vztahy mezi osobnostními rysy""",
                    false
                ),
            ),
            questionNumber = 37,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Které z uvedených nepatří mezi obvyklá pojetí normality osobnosti?""",
            textAnswer = "Způsoby, kterými jsme schopni zjistit, zdali je jedinec \"v normě\"" +
                "\n\n1.Statistické pojetí - soulad jedince/skupiny s většinou, pokud můžeme kvantifikovat" +
                "\n\n2.Sociokulturní pojetí - norma je to, co je v kultuře standardem (stereotypy)" +
                "\n\n3.Funkční pojetí - stabilita a funkčnost společnosti" +
                "\n\n4.Mediální pojetí - normy pochází z médií" +
                "\n\n5.Normativní pojetí - předem stanovená norma, každá společnost má svoje normy" +
                "\n\n6.Subjektivní normalita - vlastním odhadem jedince",
            answers = listOf(
                PsychologyTermAnswer("""funkční normalita""",
                    false,
                    "stabilita a funkčnost společnosti"
                ),
                PsychologyTermAnswer("""nepřítomnost psychiatrických symptomů""",
                    false
                ),
                PsychologyTermAnswer("""dynamická normalita""",
                    false
                ),
                PsychologyTermAnswer("""statistická normalita""",
                    false,
                    "soulad jedince/skupiny s většinou, pokud můžeme kvantifikovat"
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Mezi obranné mechanismy ega nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""racionalizace""",
                    false
                ),
                PsychologyTermAnswer("""potlačení""",
                    false
                ),
                PsychologyTermAnswer("""reaktivní (záminková) formace""",
                    false
                ),
                PsychologyTermAnswer("""katexe""",
                    false
                ),
            ),
            questionNumber = 39,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Pojem akcentovaná osobnost znamená""",
            textAnswer = "Jedná se o typ osobnostního rysu, který je tak nápadný," +
                " že bychom se mohli myslet, že je rys patologický, neznamená to však, že má osoba duševní poruchu.",
            answers = listOf(
                PsychologyTermAnswer("""osobnost s určitými abnormními rysy""",
                    false
                ),
                PsychologyTermAnswer(
                    """osobnost s atypickým poměrem maskulinity/ femininity""",
                    false
                ),
                PsychologyTermAnswer("""osobnost zvláště výřečná""",
                    false
                ),
                PsychologyTermAnswer("""osobnost mimořádně nadaná""",
                    false
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """V Esenckově osobnostním dotazníku se kromě extraverze zjišťuje""",
            textAnswer = "Studoval inteligenci a osobnosti." +
                "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                "\nDělení osobnosti:" +
                "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                "\n\tExtraverze (vzrušivost mozkové kůry)" +
                "\n\tNeuroticismus (stabilita - labilita).",
            answers = listOf(
                PsychologyTermAnswer("""introverze""",
                    false
                ),
                PsychologyTermAnswer("""otevřenost""",
                    false
                ),
                PsychologyTermAnswer("""neuroticismus""",
                    false
                ),
                PsychologyTermAnswer("""závislost na odměně""",
                    false
                ),
            ),
            questionNumber = 41,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """V Esenckově osobnostním dotazníku se kromě extraverze zjišťuje""",
            textAnswer = "Studoval inteligenci a osobnosti." +
                "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                "\nDělení osobnosti:" +
                "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                "\n\tExtraverze (vzrušivost mozkové kůry)" +
                "\n\tNeuroticismus (stabilita - labilita).",
            answers = listOf(
                PsychologyTermAnswer("""introverze""",
                    false
                ),
                PsychologyTermAnswer("""otevřenost""",
                    false
                ),
                PsychologyTermAnswer("""psychoticismus""",
                    false
                ),
                PsychologyTermAnswer("""závislost na odměně""",
                    false
                ),
            ),
            questionNumber = -41,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Silný vyrovnaný nepohyblivý typ v Pavlovově typologii odpovídá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""melancholickému temperamentu""",
                    false,
                    "pesimističtí, nízká úroveň energie"
                ),
                PsychologyTermAnswer("""flegmatickému temperamentu""",
                    false
                ),
                PsychologyTermAnswer("""sangvinickému temperamentu""",
                    false,
                    "aktivní, komunikativní a energičtí"
                ),
                PsychologyTermAnswer("""introvertnímu temperamentu""",
                    false
                ),
                PsychologyTermAnswer("""cholerickému temperamentu""",
                    false,
                    "vysoká úroveň energie, impulzivní, agresivní"
                )
            ),
            questionNumber = 42,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Dynamické (tj. motivační) rysy rozdělil na ergy, sentimenty a postoje:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """R. B. Cattell""",
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
                PsychologyTermAnswer("""L. Klages""",
                    false,
                    "Grafologie - osobnost ze stylu psaní, Charakterologická psychologie - studie osobností, vývoje a rozdíl mezi nimi."
                ),
                PsychologyTermAnswer("""J. Piaget""", false,
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
                PsychologyTermAnswer("""G. W. Allport""",
                    false,
                    "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                        "\nFukční autonomie - že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku" +
                        "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                        "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                        "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích."
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených osobnostních systémů nefiguruje ve Freudově pojetí osobnosti?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""ego""",
                    false
                ),
                PsychologyTermAnswer("""archeego""",
                    false
                ),
                PsychologyTermAnswer("""superego""",
                    false
                ),
                PsychologyTermAnswer("""id""",
                    false
                ),
            ),
            questionNumber = 44,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Když hovoříme o tom, že určitá typologie pracuje s krajnostními typy nějaké vlastnosti, platí""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """většina jedinců má v dané vlastnosti krajní hodnoty, nevyhraněných jedinců je menšina""",
                    false
                ),
                PsychologyTermAnswer(
                    """většina jedinců se dá zařadit k některému z typů, nevyhraněná je menšina jedinců""",
                    false
                ),
                PsychologyTermAnswer(
                    """většina jedinců je nevyhraněná, čistým typům se blíží jen jedinci s krajními hodnotami určité vlastnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """typu odpovídají pouze jedinci, kteří mají nadprůměrný skór v určité vlastnosti""",
                    false
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Allportův princip funkční autonomie znamená""",
            textAnswer = "Motivy dospělého nezávislé na dětství. Motiv jiný od drivu - drive vychází z motivu." +
                "\n\t1.Kardinální rysy - výjimečné, odlišuje osobu od osoby." +
                "\n\t2.Centrální rysy - sdílené mezi lidmi a do určité míry definuje osobu. Např. upřímnost." +
                "\n\t3.Sekundární rysy - projevují se jen v konextu, v konkrétních situacích.",
            answers = listOf(
                PsychologyTermAnswer(
                    """že funkce osobnostních vlastností jsou vzájemně nezávislé""",
                    false
                ),
                PsychologyTermAnswer(
                    """že složitější motivační útvar (např. zájem) se může osamostatnit od základních potřeb, které stály u jeho vzniku""",
                    false
                ),
                PsychologyTermAnswer(
                    """že jedinec funguje jako autonomní jednotka bez sociálních vazeb""",
                    false
                ),
                PsychologyTermAnswer(
                    """že osobnost jedince se diferencuje na základě funkční zaměřenosti""",
                    false
                ),
            ),
            questionNumber = 46,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Které tělesné typy rozeznává Kretschmerova konstituční typologie""",
            textAnswer = "E. Kretschmer se snažil se spojit fyziologickou postavu jedince k patologii." +
                "\nAstenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            answers = listOf(
                PsychologyTermAnswer("""cyklotymní, schyzotymní, viskózní""",
                    false
                ),
                PsychologyTermAnswer("""pyknický, sychzotymní, atletický""",
                    false
                ),
                PsychologyTermAnswer("""astenický, pyknický, viskózní""",
                    false
                ),
                PsychologyTermAnswer(
                    """pyknický, leptosomní, atletický, dysplastický""",
                    false
                ),
            ),
            questionNumber = 47,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Které tělesné typy rozeznává Kretschmerova konstituční typologie""",
            textAnswer = "E. Kretschmer se snažil se spojit fyziologickou postavu jedince k patologii." +
                "\nAstenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            answers = listOf(
                PsychologyTermAnswer("""cyklotymní, schyzotymní, viskózní, pyknický""",
                    false
                ),
                PsychologyTermAnswer("""pyknický, schyzotymní, atletický, cyklothymní""",
                    false
                ),
                PsychologyTermAnswer("""astenický, pyknický, viskózní""",
                    false
                ),
                PsychologyTermAnswer(
                    """cyklothymní, schizothymní, viskózní, dysplastický""",
                    false
                ),
            ),
            questionNumber = -47,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Typologické přístupy k osobnosti chápou části osobnosti jako souřadné. Naproti tomu vrstvová pojetí je chápou především""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""systémově""",
                    false
                ),
                PsychologyTermAnswer("""dynamicky""",
                    false
                ),
                PsychologyTermAnswer("""hierarchicky""",
                    false,
                    "Např. psychoanalytická teorie - některé části jsou podřazené jiným, Big Five, 16 faktorů Cattella"
                ),
                PsychologyTermAnswer("""nezávisle""",
                    false
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Čím může být dán vzájemný vztah mezi vrstvami osobnosti""",
            textAnswer = "hierarchické pojetí částí osobnosti",
            answers = listOf(
                PsychologyTermAnswer("""ničím z uvedených""",
                    false
                ),
                PsychologyTermAnswer("""vývojem nebo situací""",
                    false
                ),
                PsychologyTermAnswer("""vývojem nebo vzájemným vlivem (řízením)""",
                    false
                ),
                PsychologyTermAnswer("""situací a typem osobnosti""",
                    false
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Jungova typologie dělí lidi podle jedné ze čtyř převládajících duševních funkcí. Jsou to""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """inteligence, emoční prožívání, čiti, vnímání""",
                    false
                ),
                PsychologyTermAnswer(
                    """myšlení, cítění, čití, intuice""",
                    false,
                    "Čivost spočívá ve schopnosti registrovat jednoduché podněty a rozlišovat jejich intenzitu.\n" +
                        "\nDolní počitkový práh (absolutní práh) - kdy to můžeme ještě rozeznat v 50% případů.\n" +
                        "\nHorní počitkový práh - buďto již nic necítíme nebo vznikne bolest.\n" +
                        "\nRozdílový práh - hranice, kdy dokážeme rozeznat rozdíl mezi 2 podněty v 50% případů"
                ),
                PsychologyTermAnswer("""vnímání, rozum, intuice, rozlišování""",
                    false
                ),
                PsychologyTermAnswer("""žádné z uvedených dělení není správné""",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """K termínům užívaným v Jungově typologii nepatří""",
            textAnswer = "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar.\n" +
                "1. Myšlení – zkoumá, co vnímaný předmět je\n" +
                "2. Cítění – ocepuje hodnotu předmětu\n" +
                "3. Čití / Smyslové vnímání – zahrnuje veškerou smyslovou zkušenost\n" +
                "4. Intuice – poznává skrytý význam předmětu" +
                "\nPoté vynásobíme všechny možnosti introverzí a extroverzí = 8",
            answers = listOf(
                PsychologyTermAnswer("""introverze""",
                    false
                ),
                PsychologyTermAnswer("""cítění""",
                    false
                ),
                PsychologyTermAnswer("""rozlišování""",
                    false
                ),
                PsychologyTermAnswer("""extraverze""",
                    false
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Termínem g-faktor se označuje""",
            textAnswer = "Také nazýváno obecná inteligence - řešení problémů, logické myšlení, verbální schopnosti a prostorovou představivost",
            answers = listOf(
                PsychologyTermAnswer("""termín se nepoužívá""",
                    false
                ),
                PsychologyTermAnswer(
                    """měřítko globální integrace osobnosti, které udává konzistenci rysů chování ve vztahu k určité teorii""",
                    false
                ),
                PsychologyTermAnswer(
                    """faktor udávající motivační význam základních potřeb u jedince""",
                    false
                ),
                PsychologyTermAnswer(
                    """hypotetickou obecnou rozumovou schopnost, která je v pozadí výkonu ve většině inteligenčních úloh""",
                    false
                ),
            ),
            questionNumber = 52,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Termínem q-faktor se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """osobnostní komponenta sebepojetí zjišťovaná dotazníky""",
                    false
                ),
                PsychologyTermAnswer(
                    """faktor kvality výsledků intelektové činnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """faktor zjišťovaný pomocí q-třídění (nucené distribuce)""",
                    false
                ),
                PsychologyTermAnswer("""termín se nepoužívá""",
                    false
                ),
            ),
            questionNumber = 53,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Termínem s-faktor se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """osobnostní komponenta sebepojetí zjišťovaná dotazníky""",
                    false
                ),
                PsychologyTermAnswer(
                    """specifická schopnost, opakem g-faktoru""",
                    false
                ),
                PsychologyTermAnswer(
                    """hypotetickou obecnou rozumovou schopnost, která je v pozadí výkonu ve většině inteligenčních úloh""",
                    false
                ),
                PsychologyTermAnswer("""termín se nepoužívá""",
                    false
                ),
            ),
            questionNumber = -53,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Se kterou vrstvou osobnosti jsou podle klasické psychoanalytické teorie především spojeny pudové motivy?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Nadjá""",
                    false
                ),
                PsychologyTermAnswer("""pudová báze osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""nevědomí""",
                    false
                ),
                PsychologyTermAnswer("""Ono""",
                    false
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Sebepojetí je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nic z uvedených""",
                    false
                ),
                PsychologyTermAnswer(
                    """vědomý obraz, který člověk má o své vlastní osobě""",
                    false
                ),
                PsychologyTermAnswer(
                    """způsob, jakým členové skupiny pohlížejí na svou skupinu""",
                    false
                ),
                PsychologyTermAnswer(
                    """hodnota, kterou člověk přikládá vlastní osobě""",
                    false
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Mezi obranné mechanismy ega patří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nevědomí""",
                    false
                ),
                PsychologyTermAnswer("""sebeprezentace""",
                    false
                ),
                PsychologyTermAnswer("""sebereflexe""",
                    false
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Která z uvedených charakteristik nejlépe vystihuje vztah mezi vlohami a schopnostmi?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""vlohy jsou komplexnější než schopnosti""",
                    false
                ),
                PsychologyTermAnswer("""vlohy jsou základem schopností""",
                    false
                ),
                PsychologyTermAnswer("""schopnosti jsou vrozené, vlohy osvojené""",
                    false
                ),
                PsychologyTermAnswer("""schopnosti jsou základem vloh""",
                    false
                ),
            ),
            questionNumber = 57,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Mezi Jungovy archetypy patří""",
            textAnswer = "Persona - zachování individualismu" +
                "\nAnimus a anima - pomáhá a chápat svojí pohlaví, ukazuje se jako opačné pohlaví" +
                "\nStín - zvířecí, tendence primitivním formám života" +
                "\nAnalytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar.",
            answers = listOf(
                PsychologyTermAnswer("""bouře""",
                    false
                ),
                PsychologyTermAnswer("""drak""",
                    false
                ),
                PsychologyTermAnswer("""stín""",
                    false
                ),
                PsychologyTermAnswer("""světlo""",
                    false
                ),
            ),
            questionNumber = 58,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Faktory druhého řádu""",
            textAnswer = "Agregované faktory prvního řádu",
            answers = listOf(
                PsychologyTermAnswer(
                    """jsou korelované faktory, které společně vytvářejí faktory prvního řádu""",
                    false
                ),
                PsychologyTermAnswer(
                    """jsou méně významné osobnostní charakteristiky""",
                    false
                ),
                PsychologyTermAnswer(
                    """nejsou užívány ve faktorových pojetích osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""sjednocují více korelovaných faktorů""",
                    false
                ),
            ),
            questionNumber = 59,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = "Pojetí vývoje osobnosti, podle kterých dochází v průběhu života k průběžnému rozčleňování a " +
                "modifikaci komplexních vnitřních struktur se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""komplexní""",
                    false
                ),
                PsychologyTermAnswer("""faktorové""",
                    false
                ),
                PsychologyTermAnswer("""stadiální""",
                    false,
                    "Stádia, které jsou pro všechny stejné, často se posouváme z jednoho stádia do druhého"
                ),
                PsychologyTermAnswer("""diferenciační""",
                    false
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Stadiální pojetí vývoje osobnosti předpokládají, že""",
            textAnswer = "Stádia, které jsou pro všechny stejné, často se posouváme z jednoho stádia do druhého",
            answers = listOf(
                PsychologyTermAnswer("""osobnost se vyvíjí pomalu""",
                    false
                ),
                PsychologyTermAnswer("""vývoj osobnosti je kontinuální""",
                    false,
                    "může se stagnovat a zastavit na jednom bodu vývoje, např. Freud nebo i Maslow"
                ),
                PsychologyTermAnswer(
                    """v průběhu života dochází ke kvalitativním změnám v osobnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """vývojová stadia se liší především kvantitativně""",
                    false
                ),
            ),
            questionNumber = 61,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených pojmů označuje instanci, jež nejméně souvisí s vědomým prožíváním subjektu?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""id""",
                    false
                ),
                PsychologyTermAnswer("""self""",
                    false
                ),
                PsychologyTermAnswer("""ego""",
                    false
                ),
                PsychologyTermAnswer("""já""",
                    false
                ),
            ),
            questionNumber = 62,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Interakcionistický přístup není součástí osobnostního modelu vytvořeného:""",
            textAnswer = "Interakce mezi osobností a prostředím",
            answers = listOf(
                PsychologyTermAnswer("""E. H. Eriksonem""", false,
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
                PsychologyTermAnswer(
                    """J. B. Watsonem""",
                    false,
                    "Behaviorismus, \"Dejte mi tucet zdravých nemluvňat a ideální prostředí a já z nich udělám kohokoliv budete chtít\" -parafráze"
                ),
                PsychologyTermAnswer("""W. Sternem""",
                    false,
                    "Inteligenční kvocient (IQ - ment.věk děleno chronologický), založil Diferenciální psychologii (jako psychologie osobnosti - rozdíli mezi lidmi)"
                ),
                PsychologyTermAnswer("""J. Piagetem""", false,
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
            ),
            questionNumber = 63,
            correctAnswer = 1,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Opačným pólem dimenze, na jejímž jednom konci je dominance, je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""introverze""",
                    false
                ),
                PsychologyTermAnswer("""agresivita""",
                    false
                ),
                PsychologyTermAnswer("""submise""",
                    false
                ),
                PsychologyTermAnswer("""nerozhodnost""",
                    false
                ),
            ),
            questionNumber = 64,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Extroverze a introverze v Eysenckově pojetí temperamentu tvoří""",
            textAnswer = "Studoval inteligenci a osobnosti." +
                "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                "\nDělení osobnosti:" +
                "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                "\n\tExtraverze (vzrušivost mozkové kůry)" +
                "\n\tNeuroticismus (stabilita - labilita).",
            answers = listOf(
                PsychologyTermAnswer("""dva póly faktoru extraverze""",
                    false
                ),
                PsychologyTermAnswer("""dva póly faktoru neuroticismu""",
                    false
                ),
                PsychologyTermAnswer(
                    """dva faktory, nazývané také extraverze a neuroticismus""",
                    false
                ),
                PsychologyTermAnswer(
                    """dva faktory, nazývané také extraverze a psychoticismus""",
                    false
                ),
            ),
            questionNumber = 65,
            correctAnswer = 0,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Ego a nevědomí v chápání psychoanalytické teorie:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""se vylučují""",
                    false
                ),
                PsychologyTermAnswer("""jsou spojeny prostřednictvím superega""",
                    false
                ),
                PsychologyTermAnswer(
                    """jsou spojeny prostřednictvím obranných mechanismů""",
                    false,
                    "suprese do nevědomí"
                ),
                PsychologyTermAnswer(
                    """v psychoanalýze se neužívá termín nevědomí, ale podvědomí""",
                    false
                ),
            ),
            questionNumber = 66,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Ve Frommově pojetí je charakter chápán jako:""",
            textAnswer = "Neufreudián. Charakter je získaná složka osobnosti." +
                "\nSvoboda x Bezpečí (moc svobody=méně bezpečí a vise versa)." +
                "\nVzdálení se od přírody: ve středověku (feduální systém) měl každý jasnou roli" +
                " a měl tudíž i stabilitu. Renesancí se však vše změnilo a snážíme se stále hledat význam života." +
                "\nZpůsoby jak utíkáme od svobody:" +
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
                "\n\t\tmarketing - předstírá, chce aby ho všichni měli rádi",
            answers = listOf(
                PsychologyTermAnswer("""širší pojem než temperament""",
                    false
                ),
                PsychologyTermAnswer("""užší pojem než temperament""",
                    false
                ),
                PsychologyTermAnswer("""konstituční složka osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""získaná složka osobnosti""",
                    false
                ),
            ),
            questionNumber = 67,
            correctAnswer = 3,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Lexikální analýza vedla ke vzniku:""",
            textAnswer = "1.Osobnostní rysy, kter jsou ve skupinách důležité se sami zakomponují do jazyka skupiny." +
                "\n\n2.Důležitější osobnostní rysy se zkrátí na jedno slovo",
            answers = listOf(
                PsychologyTermAnswer("""Eysenckova modelu osobnosti""",
                    false,
                    "Studoval inteligenci a osobnosti." +
                        "\nPojetí temperamentu vychází z hypotetických fyziologických a nervových mechanismů" +
                        "\nDělení osobnosti:" +
                        "\n\tPsychoticismus (zároveň předpoklad k onecmocnění)" +
                        "\n\tExtraverze (vzrušivost mozkové kůry)" +
                        "\n\tNeuroticismus (stabilita - labilita)."
                ),
                PsychologyTermAnswer("""Cloningerova modelu osobnosti""",
                    false,
                    "Zavedl pojem charakter - vědomá reflexe sebe a soudy o vlatní osobě" +
                        "\n3 Charakterové rysy:" +
                        "\n\t1. Sebeřízení - sebepojetí a seberegulační mechanismy" +
                        "\n\t2. Kooperativnost - pojetí vztahů s druhými" +
                        "\n\t3. Sebepřesažení - představa o své účasti ve světě"
                ),
                PsychologyTermAnswer("""modelu Big Five""",
                    false
                ),
                PsychologyTermAnswer("""situačního modelu osobnosti""",
                    false
                ),
            ),
            questionNumber = 68,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
        PsychologyTerm(
            prompt = """Jako protiklad k situacím odkazují dispozice na""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""schopnosti""",
                    false
                ),
                PsychologyTermAnswer("""nadání""",
                    false
                ),
                PsychologyTermAnswer("""rysy""",
                    false
                ),
                PsychologyTermAnswer("""možnosti""",
                    false
                ),
            ),
            questionNumber = 69,
            correctAnswer = 2,
            categoryId = "6. Psychologie osobnosti"
        ),
    )

}