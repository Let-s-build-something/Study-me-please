package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//revidovano
object PsychologyOne {
    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = "Neuronová síť je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "výpočetní struktura inspirovaná modelováním funkce nervové soustavy",
                    false
                ),
                PsychologyTermAnswer(
                    "typický způsob propojení neuronů v mozkové kuře",
                    false,
                    "Neurony jsou propojeny přes synapse, nikdy se však nedotýkají."
                ),
                PsychologyTermAnswer("jiné označení pro retikulární formaci", false,
                    "Retikulární formace prostupuje mozkovým kmenem, " +
                        "pokračuje do thalamu a hypothalamu, kaudálně navazuje na propriospinální míšní síť.\nFunkce: " +
                        "-senzitivní, motorická a autonomní funkce, složité reflexy\n" +
                        "- centrum řízení dýchání, kardiovaskulární soustavy, vazomotoriky, spánku, bdění"
                ),
                PsychologyTermAnswer("počítačový model úžiny pozornosti",
                    false
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Nálada je příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "vnitřního jednání",
                    false,
                    "Immanuel Kant rolišuje na vnitřní jednání (rozmýšlení, rozvažování):" +
                        "\n\t-jednající má myšlení kompletně pod kontrolou" +
                        "\n\t-vnější jednání - jednající podléha externím vlivům, stereotypům apod." +
                        "\nMentální fenoména - psychické procesy se nedají matematicky spočítat" +
                        "\nNoumenální (externí) objekty - objekty mimo lidské životy (nezažité)" +
                        "\nFenomenální (interní) - objekt potkán naším vědomím, kategorizováno uvnitř, nejde zkoumat"
                ),
                PsychologyTermAnswer(
                    "psychického stavu",
                    false,
                    """Stav s určitým obsahem jako je například zloba, radost, či celkový psychofyzický stav (vzrušení, útlum, únava apod.)."""
                ),
                PsychologyTermAnswer(
                    "psychogenního afektu",
                    false,
                    """Psychogenního - způsobeno psychickými faktory (např. bolest hlavy ze stresu). 
                        Afekt je intenzivní emoce, která vznikne rychle a má svoje konkrétní zaměření.
                    """
                ),
                PsychologyTermAnswer(
                    "psychického procesu",
                    false,
                    """Hodně krátkodobé, jedná se vlastně o zpracování určitých jevů a informací. 
                         Může se jednat o vnímání, paměť, představivost, učení či myšlení."""
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Přetrvávající následný obraz na sítnici je vníman",
            textAnswer = "Latence sítnice je asi 0,1 s. I pocit světla trvá déle. Toto prodloužení se nazývá následný obraz a trvá tak dlouho," +
                " než zaniknou rozpadové produkty, které vznikly v sítnici při fotochemické reakci při působení světla.",
            answers = listOf(
                PsychologyTermAnswer(
                    "v různých barvách, podle úrovně aktivace pozornosti",
                    false
                ),
                PsychologyTermAnswer("jako pohybující se proti směru pohybu oka",
                    false
                ),
                PsychologyTermAnswer("jako bezbarvý",
                    false
                ),
                PsychologyTermAnswer("v barvě komplementámi vůči k barvě podnětu",
                    false
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termin incentiva znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("pobidku",
                    false
                ),
                PsychologyTermAnswer("motivační zábranu",
                    false
                ),
                PsychologyTermAnswer("vstupni senzorickou informaci",
                    false
                ),
                PsychologyTermAnswer("rozhodovací operaci",
                    false
                ),
            ),
            questionNumber = 4,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podle periferních teorií emocí",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("doprovázejí emoce každý psychický proces",
                    false,
                    "Hodně krátkodobé, jedná se vlastně o zpracování určitých jevů a informací. \n" +
                        "Může se jednat o vnímání, paměť, představivost, učení či myšlení."
                ),
                PsychologyTermAnswer(
                    "jsou emoce spojeny hlavně s funkci laterálních jader hypotalamu",
                    false,
                    """Tam jsou základní regulační centra jako například příjem potravy,
                         tekutin, sexuálního chování, emocí, termoregulace, vegetativní funkce, hormonální funkce apod."""
                ),
                PsychologyTermAnswer(
                    "jsou tělesné změny základní příčinou emoci",
                    false,
                    """William James a Christiane Lang (James-Langova teorie emocí). "Jsme smutní, protože pláčeme a veselí, protože se usmíváme"."""
                ),
                PsychologyTermAnswer(
                    "hrají emoce v psychickém životě vedlejší roli",
                    false
                ),
            ),
            questionNumber = 5,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Tzv. magické číslo 7+-2 znamená",
            textAnswer = "Krátkodobá paměť, objevena George Millerem v roce 1956",
            answers = listOf(
                PsychologyTermAnswer(
                    "nejvyšší počet slabik za sekundu, který dokáže jedinec vnímat",
                    false
                ),
                PsychologyTermAnswer(
                    "maximální počet úrovni při zpracování zrakové informace",
                    false
                ),
                PsychologyTermAnswer(
                    "minimální počet opakování, které zajišťují trvalé uložení informace v paměti",
                    false
                ),
                PsychologyTermAnswer(
                    "maximální počet elementů, který si člověk dokáže zapamatovat po jediné prezentaci",
                    false
                ),
            ),
            questionNumber = 6,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt =
            "Po každém rozsvícení červeného světla v místnosti je pokusné osobě fouknut do oka proud vzduchu," +
                " který ji přinutí mrknout. Po určité době již osoba mrká při každém rozsvícení červeného světla," +
                " i bez podráždění vzduchem. Červené světlo zde funguje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "podmíněný podnět",
                    false,
                    "původně neutrální stimul (světlo, metronom), který získá schopnost vyvolat vrozenou reakci (slinění)"
                ),
                PsychologyTermAnswer(
                    "nepodminěny reflex",
                    false,
                    "vrozená odezva na nepodmíněný podnět (slinění)"
                ),
                PsychologyTermAnswer(
                    "nepodmíněný podnět",
                    false,
                    "evokuje vrozenou reakci bez předchozího učení (jídlo)"
                ),
                PsychologyTermAnswer(
                    "podmíněný reflex",
                    false,
                    "původně nepodmíněná reakce (slinění), kterou vyvolal podmíněný podnět (tikání, světlo)"
                ),
            ),
            questionNumber = 7,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Hedonistické motivační teorie kladou důraz na",
            textAnswer = "Hédonismus (z řec. hédoné, potěšení, slast)." +
                "\nAccording to the hedonic principle, our emotional experience can be thought of as a gauge that ranges from bad to good and our primary" +
                " motivation is to keep the needle on the gauge as close to good as possible.",
            answers = listOf(
                PsychologyTermAnswer("fyziologickou reakci na motivační podněty",
                    false
                ),
                PsychologyTermAnswer("rozhodující roli alimentárnich potřeb",
                    false
                ),
                PsychologyTermAnswer("emoční kvalitu příjemnosti-nepřijemnosti",
                    false
                ),
                PsychologyTermAnswer("racionální hodnocení přínosů a investic",
                    false
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Známá humanistická teorie motivace řadí potřeby do hierarchie," +
                " kde je uspokojení níže postavené potřeby podmínkou uspokojení potřeb výše postavených." +
                " Která je správná hierarchie (od nejnižší k nejvyšší)?",
            textAnswer = "Maslowa pyramida potřeb. Často přirovnával k dětem, které prvně potřebují naplnit potřeby a až teprve potom zkoumají a hrají si.",
            answers = listOf(
                PsychologyTermAnswer(
                    "fyziologické potřeby, potřeba bezpeči, lásky, altruismu a sebeaktualizace",
                    false
                ),
                PsychologyTermAnswer(
                    "fyziologické potřeby, potřeba bezpečí, lásky, sebeúcty a sebeaktualizace",
                    false
                ),
                PsychologyTermAnswer(
                    "potřeba bezpečí, fyziologické potřeby, potřeba lásky, sebeúcty a sebeaktualizace",
                    false
                ),
                PsychologyTermAnswer(
                    "fyziologické potřeby, potřeba bezpečí, lásky, sebeaktualizace a sebeúcty",
                    false
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pojem engram se někdy používá k označení",
            textAnswer = "Hypotetická permanentní změna v mozku, která poukazuje na existanci paměti - stopa paměti." +
                "Richard Semon (zoologista), 1904",
            answers = listOf(
                PsychologyTermAnswer("paměťové stopy",
                    false
                ),
                PsychologyTermAnswer("záznamu kožně-galvanické reakce",
                    false,
                    "SCR [skin conductance response, odezva vodivosti kůže]"
                ),
                PsychologyTermAnswer("okamžiku vtištění",
                    false
                ),
                PsychologyTermAnswer("senzorického kódovacího programu",
                    false
                ),
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Telereceptory jsou",
            textAnswer = "Specialized sense receptors, such as those in the eyes, ears and nose, that respond to distant external stimuli." +
                "\n\t-Fotoreceptory - světlo, tyčinky a čípky" +
                "\n\t-Mechanoreceptory - tlak, vibrace, dotyk, sluch" +
                "\n\t-Termoreceptory - teplota" +
                "\n\t-Chemoreceptory - chemikalie, hladina kyslíku, chuť a čich" +
                "\n\t-Nociceptory - poskozeni tkaniny -> bolest," +
                "\n\t-Baroreceptory - tlak krve" +
                "\n\tElektromagnetické receptory",
            answers = listOf(
                PsychologyTermAnswer("receptory pohybu",
                    false,
                    "proprioceptors"
                ),
                PsychologyTermAnswer("zrakové a sluchové receptory",
                    false
                ),
                PsychologyTermAnswer("chuťové receptory",
                    false,
                    "chemoreceptor"
                ),
                PsychologyTermAnswer(
                    "spekulativně postulované mimosmyslového vnímání receptory",
                    false
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt =
            "Aktivační úroveň, tj. míra připravenosti organismu k aktivitě, se označuje také jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("vigilní skór",
                    false,
                    "Vigilita - bdělost."
                ),
                PsychologyTermAnswer("škála aktivity",
                    false
                ),
                PsychologyTermAnswer("arousal",
                    false
                ),
                PsychologyTermAnswer("dismissal",
                    false
                ),
            ),
            questionNumber = 12,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt =
            "Jak se nazývá zákon, podle kterého bude chování, jež vedlo k uspokojení, opakováno s vyšší pravděpodobností než chování jiné?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("zákon efektu",
                    false,
                    "Thorndike - funkcionalismus (evolucionální důvod za chováním, ne o \"paměti\", ale učení), Trial and Error, association theory - S-R"
                ),
                PsychologyTermAnswer("hedonický zákon",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("Weberův zákon",
                    false,
                    "Rozlišení dvou podnětů závisí na velikosti základního podnětu. Vycházel z experimentu s intenzitou světla, při kterém zjistil, že když intenzita prvního světla, byla vysoká, musel být i přírůstek větší, než když byla intenzita úvodního světla menší. "
                ),
                PsychologyTermAnswer("Skinnerův zákon",
                    false,
                    "operativní podmiňování (operant conditioning)"
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Diferenciální psychologie je základem",
            textAnswer = "Disciplína, Zaměřuje se na individuální rozdíly mezi lidmi, jejich příčiny a také na vliv těchto odlišností na chování a mezilidské vztahy." +
                " K jejich kvantifikaci vyvíjí a využívá psychodiagnostické metody." +
                "Rozdíly, kterými se diferenciální psychologie zabývá, jsou například v oblastech inteligence, motivace, osobnosti, schopností a dovedností a dalších.",
            answers = listOf(
                PsychologyTermAnswer("srovnávací psychologie",
                    false,
                    "(Komparativní psychologie) Něco jako etologie psychologie. Tedy zkoumá hlavně chování zvířat (organismů) mimo lidi.\nObčas se však definuje jako věda porovnávající zvířata s lidmi."
                ),
                PsychologyTermAnswer("inženýrské psychologie",
                    false,
                    "Inženýrská psychologie zkoumá procesy a prostředky řídící interakce mezi člověkem a technickým zařízením. Inženýrská psychologie vyrůstá z tradice experimentální psychologie." +
                        "\nKooperace mezi člověkem a zařízením, efektivita, kvalita, přesnost, příjem informací člověkem."
                ),
                PsychologyTermAnswer("matematické psychologie",
                    false,
                    "Pracuje s stochastickými modely (náhodné veličiny), např.v teorii her (konfliktní situace), faktorová analýza, strukturální kombinatorika."
                ),
                PsychologyTermAnswer("psychologie osobnosti",
                    false
                ),
            ),
            questionNumber = 14,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mezi základní psychologické disciplíny nepatří",
            textAnswer = "biologická psychologie – zkoumá vzájemné vztahy mezi tělesnými a psychickými procesy\n" +
                "psychologická metodologie – řeší problémy, které souvisejí s pochopením metodologických přístupů (výzkumných projektů a teorií) a jejich užitím v psychologii\n" +
                "obecná psychologie – přináší obecné poznatky o psychice člověka, studuje chování, motivaci a prožívání, má význam při zpracování základních teoretických otázek\n" +
                "psychologie osobnosti – zabývá se strukturou, vývojem a dynamikou osobnosti; dnes je její významnou součástí diferenciální psychologie\n" +
                "psychopatologie – studuje změny (chorobné) psychických jevů, které mají různé příčiny (společenské, neurologické, endokrinologické aj.)\n" +
                "sociální psychologie – zabývá se vlivem společenských faktorů na lidskou psychiku a interakcí\n" +
                "kognitivní psychologie – zkoumá způsob vnímání a zpracování informací dodaných smyslovými orgány\n" +
                "vývojová psychologie – studuje fylogenetický a ontogenetický vývoj lidské psychiky, sleduje změny psychiky od početí do smrti",
            answers = listOf(
                PsychologyTermAnswer("obecná psychologie",
                    false,
                    "Zpracovává základní teoretické otázky a udává základ pro aplikované obory psychologie." +
                        " Psychika, Psychické jevy (trvalé, krátkodobé a elementární procesy - emoce, motivace, kognice), Prožívání (Rozum, cit a vůle), Chování"
                ),
                PsychologyTermAnswer("vývojová psychologie",
                    false,
                    "Zabývá se činiteli, zákonitostmi a průběhem psychického vývoje člověka od početí po smrt."
                ),
                PsychologyTermAnswer("sociální psychologie",
                    false,
                    "Pomezí socialogie a psychologie, tedy se dá i zkoumat z hledisek sociologie a psychologie." +
                        "\nHlavním předmětem zkoumání je jedinec, jeho chování v a vnímání sociálních situací a vliv sociálních situací na jedince."
                ),
                PsychologyTermAnswer("klinická psychologie",
                    false,
                    "Aplikovaná disciplína psychologie. Cílem zlepšení stavu pacienta skrze nejnovější (občas i experimentální) znalosti o patologii a lidské psychiky." +
                        " Čerpá z diferenciální psychologie - jelikož každý člověk je jiný."
                ),
            ),
            questionNumber = 15,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "V etologii se jako spouštěcí podnět označuje",
            textAnswer = "Instinkt je hierarchicky organizovaný mechanismus, řetězec nepodmíněných reflexů , reagující na klíčové spouštěcí podněty.",
            answers = listOf(
                PsychologyTermAnswer(
                    "podnět, který vyvolává instinktivní vzorec chování",
                    false
                ),
                PsychologyTermAnswer(
                    "podnět, který je vtiskován během senzitivní periody",
                    false,
                    "Vtiskování (imprinting), Lorenz - nácek který udělal hydraulický model agrese (který je špatně)."
                ),
                PsychologyTermAnswer(
                    "podnět, kterým se iniciuje přechod do vyššich ontogenetických stadii",
                    false
                ),
                PsychologyTermAnswer("podnět, který vyvolává nějakou reakci",
                    false
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Disciplina, která studuje chování živočichů, se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("ekologie",
                    false
                ),
                PsychologyTermAnswer("animologic",
                    false
                ),
                PsychologyTermAnswer("subhumánní behaviorismus",
                    false
                ),
                PsychologyTermAnswer("etologie",
                    false
                ),
            ),
            questionNumber = 17,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Synonymem terminu imprinting je",
            textAnswer = "Forma učení, ve které dochází k fixaci k určitému objektu/informaci v citlivém stadiu jedince, či zvířete." +
                "\n-Konrad Lorenz (1903-1989), hydraulický model agrese",
            answers = listOf(
                PsychologyTermAnswer("projekce",
                    false,
                    "Sigmund Freud, obranný mechanismus. Připisujeme potlačené naše atributy a impulzy na druhé"
                ),
                PsychologyTermAnswer("indoktrinace",
                    false,
                    "Konformita (soc. psychologie). Slepé, odevzdané přijetí doktríny, bez kritiky a pochyb."
                ),
                PsychologyTermAnswer("otisk",
                    false
                ),
                PsychologyTermAnswer("vtiskování",
                    false
                ),
            ),
            questionNumber = 18,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Co je příkladem molárně chápaného chování?",
            textAnswer = "Molekulární chování (Tolman 1932) - malé jednotky, či segmenty aktivity/chování v malých časových úsecích (např. reflex)." +
                "\nMolární chování - větší behaviorální celky aktivity/chování ve větších časových úsecích (např. kopnutí do míče)." +
                "\nInstrumentální chování (Thorndike, 1911) - chování je prostředek/nástroj k dosažení specifického cíle.",
            answers = listOf(
                PsychologyTermAnswer(
                    "zvednuti knihy ze stolu a její odneseni na druhou stranu místnosti",
                    false
                ),
                PsychologyTermAnswer("reakce zornic",
                    false,
                    "Molekulární chování"
                ),
                PsychologyTermAnswer(
                    "změna koncentrace neurotransmitterů v substantia nigra",
                    false,
                    "Molekulární chování" +
                        "\nSubstantia nigra - (černá substance) Ve středním mozku. Dopamin - Parkinson, Schizofrenie"
                ),
                PsychologyTermAnswer(
                    "flexe předloktí při zvedání činky nebo při držení podávaného nástroje",
                    false,
                    "Molekulární"
                ),
            ),
            questionNumber = 19,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Teze, že struktura jazyka má rozhodující vliv na myšlení, je typická pro",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("Whorfovu hypotézu",
                    false,
                    "Lingvisticko-antropologická hypotéza. Komunity a společnosti jsou založeny na jejich jazyku, podle nichž se potom předurčuje jak vnímají realitu"
                ),
                PsychologyTermAnswer("strukturalismus",
                    false,
                    "Wundt (DE) a Titchener (USA). Introspekce (looking inward)." +
                        " Mysl je složena ze smyslů, pocitů a obrázků. Dobová alternativa byla Funkcionalismus (evolucionální důvod za chováním, ne o \"paměti\", ale učení)."
                ),
                PsychologyTermAnswer("generativní gramatiku",
                    false,
                    "Lingvistika - Chomsky. Děti vytvářejí nové jazyky - dokáží generovat nové slova a zakládat nové jazyky velmi jednoduše (pár generací)."
                ),
                PsychologyTermAnswer("kulturni antropologii",
                    false,
                    "Řeč. Antropos=člověk. Význam kultur na člověka. Porovnávání a zkoumání různých kultur."
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Habituace je",
            textAnswer = "(přivykání) – na základě zkušenosti se sníží reakce a jedinec posléze přestane reagovat na podněty, které nepředstavují nebezpečí",
            answers = listOf(
                PsychologyTermAnswer("součást procesu operantního podmiňování",
                    false,
                    "Operantní podmiňování (Skinner, behaviourismus) je hlavně o odměňování (posílení, zpevnění) a trestání."
                ),
                PsychologyTermAnswer("bazální výstavba osobnosti",
                    false
                ),
                PsychologyTermAnswer("jednoduchá forma učení",
                    false
                ),
                PsychologyTermAnswer("percepční iluze",
                    false
                ),
            ),
            questionNumber = 21,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Učení se nereagovat na určitý opakující se podnět označujeme",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "habituace",
                    false,
                    "(přivykání) – na základě zkušenosti se sníží reakce a jedinec posléze přestane reagovat na podněty, které nepředstavují nebezpečí"
                ),
                PsychologyTermAnswer(
                    "senzitizace",
                    false,
                    "(zcitlivění) - opakované působení podnětu vede k nárůstu reakce na podnět,"
                ),
                PsychologyTermAnswer("inhibice",
                    false
                ),
                PsychologyTermAnswer(
                    "dishabituace",
                    false,
                    "návrat vnímání a sledování podnětu poté," +
                        " kdy na něj již vznikla habituace (přivyknutí, nevnímání)." +
                        " Jev je způsoben stimulací odlišnou od té, která vedla k habituaci."
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podmiňování druhého řádu je",
            textAnswer = "První řád je klasický zvyknutí se na nějaký dříve nepodmíněný podnět." +
                "\nDruhý řád na druhé straně je vytvoření podmíněné reákce na předchozí podmíněný podnět z prvního řádu. Je to takový řetěz podmiňování" +
                "\n\nDalší řády, tedy rozšíření se nazývá generalizace. např.: Fialový dům zubaře - bolest. Máme však strach i z jiných fialových domů potom.",
            answers = listOf(
                PsychologyTermAnswer(
                    "vytváření podmíněné reakce na současnou prezentaci dvou podmíněných podnětů",
                    false
                ),
                PsychologyTermAnswer(
                    "spojování podmíněného podnětu s nepodmíněnou reakcí",
                    false
                ),
                PsychologyTermAnswer(
                    "spojování podmíněného podnětu s podmíněnou reakcí",
                    false
                ),
                PsychologyTermAnswer("podmiňování kognitivních operací",
                    false
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Dítě bylo několikrát pokousáno jezevčíkem. Poté se u něj objevil panický strach ze všech psů i z koček." +
                " K jakému procesu došlo z hlediska teorie podmiňování?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("ke zvýšeni intenzity podmíněné reakce",
                    false
                ),
                PsychologyTermAnswer("ke generalizaci",
                    false
                ),
                PsychologyTermAnswer("k facilitaci",
                    false,
                    "Vliv přítomnosti jiných lidí na chování člověka. Touto problematikou se zabýval pravděpodobně první experiment v sociální psychologie (1898)," +
                        " který uskutečnil Norman Triplett. Pozoroval jevy v cyklisty a jejich zrychlení, když jely v skupinách."
                ),
                PsychologyTermAnswer("k rozlišení",
                    false
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Zákon účinku je rozhodujícím činitelem v",
            textAnswer = "Thorndike. Inspirováno Darwinovou teorií - vybíráme chování, které nám pomáhá přežít.",
            answers = listOf(
                PsychologyTermAnswer("operantním podmiňování",
                    false
                ),
                PsychologyTermAnswer("kognitivním učení",
                    false
                ),
                PsychologyTermAnswer("adaptaci senzorických receptorů",
                    false
                ),
                PsychologyTermAnswer("klasickém podmiňování",
                    false,
                    "Pavlov",
                    "Orientačně-pátrací reflex - vrozený instinkt jako odezva na změnu okolního prostředí (hrozba, novost), zvýší se rychlost učení a vnímání." +
                        "\nSignální soustavy:" +
                        "\n\t1. Umělecká - společné pro zvířata a lidi, např. reflexy, dojmy, představy, pocity" +
                        "\n\t2. Myslitelská (věděcký) - spojené s lidským myšlením, abstraktní myšlení"
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jako součást krátkodobé paměti se uvádí",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("senzorický registr",
                    false,
                    "Paměť ještě krátkodobější: Ikonická paměť (vizuální) do 1s, Echoická (zvuková) 3-4s."
                ),
                PsychologyTermAnswer(
                    "akustická smyčka",
                    false,
                    "Akustická zpětná vazba (též zvuková zpětná vazba, nebo jen zpětná vazba, nebo také Larsenův efekt. "),
                PsychologyTermAnswer("hippocampus",
                    false
                ),
                PsychologyTermAnswer("reiterační obvod", false),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Paměťový test probíhá tak, že osobě je přečten buď seznam číslic," +
                " nebo seznam běžných, dobře známých a průměrně dlouhých slov." +
                " Ihned po prezentaci má osoba za úkol slyšený seznam zopakovat. Jak se bude lišit zapamatování číslic a slov?",
            textAnswer = "Kdyby tomu tak bylo, tak bychom nemohli říkat o krátkodobé paměti, že je 7-+2, protože by tomu bylo jinak u slov a u číslic.",
            answers = listOf(
                PsychologyTermAnswer("výsledek silně závisí na hodnotě čísla, které použité číslice udávají",
                    false
                ),
                PsychologyTermAnswer("nebude se lišit",
                    false
                ),
                PsychologyTermAnswer("většina osob si zapamatuje vice číslic",
                    false
                ),
                PsychologyTermAnswer("většina osob si zapamatuje více slov",
                    false
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pokusným osobám je prezentován krátký seznam číslic (max. 6 čísel)." +
                " Hned poté jsou jim prezentovány číslice a osoby mají za úkol rozhodnout, zda číslice byla obsažena v seznamu." +
                " Jak závisí doba rozhodování (rozhodovací čas) na délce seznamu?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("lineárně",
                    false,
                    "Čím více předmětů v seznamu, tím déle to bude trvat, jelikož už dojde k displacementu (nahrazování) a serial position efektu."
                ),
                PsychologyTermAnswer("exponencialně",
                    false
                ),
                PsychologyTermAnswer("nezávisí na ní",
                    false
                ),
                PsychologyTermAnswer("logaritmicky",
                    false
                ),
            ),
            questionNumber = 28,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Prezentujeme osobám delší seznam slov (několik desitek)." +
                " Hned poté je požádáme, aby si vybavily co nejvíce slov ze seznamu." +
                " Jaké bude pořadi jednotlivých částí seznamu podle procenta vybavených slov (od nejlepší k nejhorší)",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "nejvíce bude vybaveno z počáteční části seznamu, méně z koncové části, nejméně ze střední části",
                    false
                ),
                PsychologyTermAnswer(
                    "nejvíce bude vybaveno z počáteční části seznamu, méně ze střední části, nejméně z koncové části",
                    false
                ),
                PsychologyTermAnswer(
                    "nejvíce bude vybaveno z koncové části seznamu, méně ze střední části, nejméně z počáteční části",
                    false
                ),
                PsychologyTermAnswer(
                    "nejvíce bude vybaveno z koncové části seznamu, méně z počáteční části, nejméně ze střední části",
                    false,
                    "Serial position effect, recency effect, primacy effect."
                ),
            ),
            questionNumber = 29,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Přístup, který modeluje mentální reprezentaci v síti uzlů vzájemně propojených různě silnými spoji," +
                " jejichž síla se může měnit při \"učení\", se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("mentální modelování",
                    false,
                    "Mentální model - v konextu mentální reprezentace to nějaká propozice a představa o nějakém podnětu." +
                        " Např. jak fungují vzorečky ve fyzice, historie našich předků."
                ),
                PsychologyTermAnswer("mentalismus",
                    false,
                    "Hypnóza/sugesce nebo může také znamenat: Fyzický svět neexistuje a mysl je jediné co opravdu existuje."
                ),
                PsychologyTermAnswer("konektivismus",
                    false,
                    "teorie vzdělávání v prostředí sociálních sítí"
                ),
                PsychologyTermAnswer("konekcionismus",
                    false,
                    "Asociace mezi smyslovým vjemem a impulsem k akci."
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín \"kognitivní procesy\" má svým významem nejblíže k termínu:",
            textAnswer = "Kognitivní procesy jsou děje, jejichž prostřednictvím člověk poznává svět i sám sebe",
            answers = listOf(
                PsychologyTermAnswer("poznávací procesy",
                    false
                ),
                PsychologyTermAnswer("myšlení",
                    false
                ),
                PsychologyTermAnswer("koherentní procesy",
                    false
                ),
                PsychologyTermAnswer("myšlenkové procesy",
                    false
                ),
            ),
            questionNumber = 31,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Absolutní práh je:",
            textAnswer = "Čivost spočívá ve schopnosti registrovat jednoduché podněty a rozlišovat jejich intenzitu. " +
                "\nDolní počitkový práh (absolutní práh) - kdy to můžeme ještě rozeznat v 50% případů." +
                "\nHorní počitkový práh - buďto již nic necítíme nebo vznikne bolest." +
                "\nRozdílový práh - hranice, kdy dokážeme rozeznat rozdíl mezi 2 podněty v 50% případů",
            answers = listOf(
                PsychologyTermAnswer(
                    "nejsilnější podnět, který ještě nezpůsobí poškození senzorických orgánů",
                    false
                ),
                PsychologyTermAnswer(
                    "nejslabší podnět, který je ještě vědomě zpracováván",
                    false
                ),
                PsychologyTermAnswer(
                    "maximum informace, které je psychika schopna zpracovat za časovou jednotku",
                    false
                ),
                PsychologyTermAnswer(
                    "nejslabší podnět, který dokáže vyvolat počitek",
                    false,
                    ""
                ),
            ),
            questionNumber = 32,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Psychofyzika zkoumá:",
            textAnswer = "Gustav Fechner, JND (just noticeable difference), Fechnerův zákon - response na stimuli není 1:1 " +
                "(přidání 1 zvonu do 10 již zvonícíh nemá takový vliv už), S=k*log(R)",
            answers = listOf(
                PsychologyTermAnswer(
                    "psychické jevy vyvolané fyzikálními vlivy na mozek",
                    false
                ),
                PsychologyTermAnswer(
                    "vztah mezi intenzitou podnětů a intenzitou smyslových dojmů",
                    false
                ),
                PsychologyTermAnswer(
                    "výkonnost organismu v závislosti na tělesných procesech",
                    false
                ),
                PsychologyTermAnswer("v podstatě totéž co psychosomatika",
                    false,
                    "Psychosomitika se zabývá psychickými příčinami některých tělesných chorob a jejich psychologickým ovlivňováním"
                ),
            ),
            questionNumber = 33,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Formulace DI/I konstanta (kde I rozumíme intenzitu podnětu a DI přírůstek intenzity odpovídající nejmenšímu rozlišitelnému rozdílu) se nazývá:",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("Weberův zákon",
                    false
                ),
                PsychologyTermAnswer("zákon zachování rozdílu",
                    false
                ),
                PsychologyTermAnswer("Frischův zákon",
                    false,
                    "neeixstuje"
                ),
                PsychologyTermAnswer("Stevensův vzorec",
                    false,
                    "neexistuje"
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Fechnerův zákon tvrdí, že:",
            textAnswer = "Gustav Fechner, JND (just noticeable difference), Fechnerův zákon - response na stimuli není 1:1 " +
                "(přidání 1 zvonu do 10 již zvonícíh nemá takový vliv už), S=k*log(R)",
            answers = listOf(
                PsychologyTermAnswer(
                    "má-li růst intenzita počitku geometricky, musí intenzita podnětu růst aritmeticky",
                    false
                ),
                PsychologyTermAnswer(
                    "má-li rust intenzita počitku aritmeticky, musi intenzita podnětu růst geometricky",
                    false
                ),
                PsychologyTermAnswer(
                    "intenzita počitku je funkci intenzity a počtu podnětů",
                    false
                ),
                PsychologyTermAnswer(
                    "intenzita počitku je funkci intenzity a trváni podnětu",
                    false
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Ke studiu selektivní pozornosti se z uvedených metod nejlépe hodí metoda",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("vigilanční test",
                    false,
                    "Test, který testuje pozornost pomocí rychlosti odpovědi a konzistenci na vizuální stimulus.",
                ),
                PsychologyTermAnswer("asociativní experiment",
                    false,
                    "Testovaná osoba řekla první slovo, které je napadlo když Jung četl seznam slov."
                ),
                PsychologyTermAnswer("indukované pozornosti",
                    false
                ),
                PsychologyTermAnswer("dichotického poslechu",
                    false,
                    "Dichotický poslech je psychologický test běžně používaný k vyšetřování selektivní pozornost a lateralizace funkce mozku v rámci sluchový systém." +
                        " Používá se v polích kognitivní psychologie a neurovědy."
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mezi základní psychické procesy nepatří:",
            textAnswer = "Hodně krátkodobé, jedná se vlastně o zpracování určitých jevů a informací. \n" +
                "Může se jednat o vnímání, paměť, představivost, učení či myšlení.",
            answers = listOf(
                PsychologyTermAnswer("kognitivní procesy",
                    false,
                    "(poznávací procesy) - vnímání, paměť, představivost, učení, myšlení."
                ),
                PsychologyTermAnswer("volní procesy",
                    false,
                    "Souvisí s rozhodováním." +
                        "\nFáze rozhodovací - zpracuju, uvědomím si informace z vnějška a vytvořím cíl - rozhodnutí." +
                        "\nFáze realuzační - realizovace cíle/rozhodnutí."
                ),
                PsychologyTermAnswer("konativní procesy",
                    false,
                    "(Nebo také emoční procesy) - duševní síly, emoce, které usměrňují naše chování."
                ),
                PsychologyTermAnswer("behaviorální procesy",
                    false
                ),
            ),
            questionNumber = 37,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Který z uvedených psychologických směrů nejvíce užívá metody a postupy přírodních věd?",
            textAnswer = "Tedy co se více měří a je méně filozofické, jak tomu s psychologií často bývá.",
            answers = listOf(
                PsychologyTermAnswer("humanistická psychologie",
                    false,
                    "Maslow, Rogers. Zaměřeno na terapii. Nerozkládá člověka, však k němu přistupuje jako k celku."
                ),
                PsychologyTermAnswer("veristická psychologie",
                    false
                ),
                PsychologyTermAnswer("kognitivní psychologie",
                    false
                ),
                PsychologyTermAnswer("transpersonální psychologie",
                    false,
                    "Např. Maslow - transcedentní/spirituální aspekty lidské zkušenosti."
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Rozdílový (diferenční) práh je:",
            textAnswer = "Čivost spočívá ve schopnosti registrovat jednoduché podněty a rozlišovat jejich intenzitu. " +
                "\nDolní počitkový práh (absolutní práh) - kdy to můžeme ještě rozeznat v 50% případů." +
                "\nHorní počitkový práh - buďto již nic necítíme nebo vznikne bolest." +
                "\nRozdílový práh - hranice, kdy dokážeme rozeznat rozdíl mezi 2 podněty v 50% případů",
            answers = listOf(
                PsychologyTermAnswer(
                    "nejvyšší rozdíl mezi dvěma současně prezentovanými podněty, kdy jsou ještě vnímány oba tyto podněty",
                    false
                ),
                PsychologyTermAnswer(
                    "nejmenší rozdíl mezi podněty, který upoutá pozornost jedince",
                    false
                ),
                PsychologyTermAnswer("nic z uvedeného",
                    false
                ),
                PsychologyTermAnswer(
                    "nejmenší rozdíl mezi podněty, který člověk svými smysly ještě zaznamená",
                    false
                ),
            ),
            questionNumber = 39,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "K vizuální prezentaci krátkodobých zrakových podnětů slouží",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("tachistoskop",
                    false,
                    "přístroj pro zkoumání vizuálního vnímání, pozornosti a reakčního času, též tachystoskop a tachyskop",
                    imageExplanationUrl = "https://vlp.mpiwg-berlin.mpg.de/vlpimages/images/img23725.jpg"
                ),
                PsychologyTermAnswer("flicker",
                    false
                ),
                PsychologyTermAnswer("monoskop",
                    false
                ),
                PsychologyTermAnswer("stetoskop",
                    false,
                    "Měření dechu a srdce"
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Nocicepce je:",
            textAnswer = "tříneuronová aferentní dráha bolesti",
            answers = listOf(
                PsychologyTermAnswer("vnímání hladu",
                    false
                ),
                PsychologyTermAnswer("vnímání za sníženého osvětlení",
                    false
                ),
                PsychologyTermAnswer("vnímání bolesti",
                    false
                ),
                PsychologyTermAnswer("vnímání útrobních pohybů",
                    false
                ),
            ),
            questionNumber = 41,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jako alfa-samec se ve skupině šimpanzů označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("samec usilující o první koitus",
                    false
                ),
                PsychologyTermAnswer("dominantní samec",
                    false
                ),
                PsychologyTermAnswer("nezralý samec",
                    false
                ),
                PsychologyTermAnswer("samec, který je poprvé v říji",
                    false
                ),
            ),
            questionNumber = 42,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Vnímání polohy kosterního svalstva, šlach a kostí se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("propriocepce",
                    false,
                    "Polohocit. Schopnost nervové soustavy zaznamenávat změny ve svalech."
                ),
                PsychologyTermAnswer("viscerocepce",
                    false,
                    "Sympathic system. Zúžení žil a snížení průtoku krve."
                ),
                PsychologyTermAnswer("kosterní polohový systém",
                    false
                ),
                PsychologyTermAnswer("interocepce",
                    false,
                    "Senzorické neurony v orgánech. Na kůži se jim nazývá exterocepce."
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Silná a krátkodobá emoční reakce se označuje jako",
            textAnswer = "Dělení emocí podle intenzity a trvání:" +
                "\nAfekty – intenzivní emoce, vzniká náhle, prudce a má konkrétní zaměření" +
                "\nNálady - déletrvající pohotovost k emočním reakcím určitého směru",
            answers = listOf(
                PsychologyTermAnswer("nálada",
                    false
                ),
                PsychologyTermAnswer("afekt",
                    false,
                    "intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření"
                ),
                PsychologyTermAnswer("cit",
                    false
                ),
                PsychologyTermAnswer("exprese",
                    false
                ),
            ),
            questionNumber = 44,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jako počitek bychom nejspíše pojmenovali zážitek vyvolaný:",
            textAnswer = "Počitek je nejjednodušší element našeho vnímání." +
                "\nJe to výsledný prvek jednoho analyzátoru (smyslu) - např. receptor + nerv + mozek.",
            answers = listOf(
                PsychologyTermAnswer(
                    "zvukem startujícího automobilu",
                    false
                ),
                PsychologyTermAnswer(
                    "neostrým obrazem viditelným při slabém osvětlení",
                    false
                ),
                PsychologyTermAnswer(
                    "světelným bodem v jinak úplně tmavé místnosti",
                    false,
                    "Musíme být schopni oddělit danou vlastnost od ostatních." +
                        "\nNapř. ucítíme něco teplého, uvědomíme si pouze teplo, nikoliv odkud pochází."
                ),
                PsychologyTermAnswer(
                    "výrazně emocionálně nabitým smyslovým podnětem",
                    false
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Princip psychického řízení chování a činnosti, založený na samostatném kladení cílů," +
                " plánování, realizaci, kontrole výsledků činnosti a případné korekci postupů, se označuje jako",
            textAnswer = "Např. autoregulace učení je proces, při kterém si jedinec usměrňuje proces na základě učebních cílů.",
            answers = listOf(
                PsychologyTermAnswer("algoritmické řízení",
                    false
                ),
                PsychologyTermAnswer("autoregulace",
                    false,
                    "Self-regulation"
                ),
                PsychologyTermAnswer("autosugesce",
                    false,
                    "Sugesce (suggero - podsouvám, našeptávám) je podmanivé ovlivňování myšlení či představ." +
                        "\nAutosugesce (autos - sám) je zdali je sugesce způsobena naším myšlením. Může být nevědomá i vědomá."
                ),
                PsychologyTermAnswer("autonomní psychodynamika",
                    false,
                    "Psychodynamika zkoumá psychologické síly, které následně vytvářejí chování," +
                        " pocity a emoci, a jak mohou souviset s ranným dětstvím."
                ),
            ),
            questionNumber = 46,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín axiom označuje",
            textAnswer = "Z řec. axióma - to, co se uznává. Tedy něco, na čem se při diskusi shodneme a můžeme to využít jako počáteční bod k dalšímu argumentu.",
            answers = listOf(
                PsychologyTermAnswer(
                    "logicky dokázané tvrzení, které je součástí tvorby teorie",
                    false
                ),
                PsychologyTermAnswer(
                    "tvrzení, kterém jsou provázány psychologické teorie s přírodovědně zjišťovanými fakty",
                    false
                ),
                PsychologyTermAnswer(
                    "postup dokazování, při kterém se vychází Invaz obecných fakt a dospívá se ke konkrétním případům",
                    false
                ),
                PsychologyTermAnswer(
                    "nedokazované tvrzení, které je základem výstavby teorie",
                    false,
                    "Je to něco, na čem se shodneme, tudíž o tom nemusíme argumentovat - dokazovat a ušetří nám to čas."
                ),
            ),
            questionNumber = 47,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Strukturované a komplexní působení člověka na prostředí, které je vědomě řízeno a které směřuje k dosažení cíle, se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("behavioralita",
                    false
                ),
                PsychologyTermAnswer("chování",
                    false
                ),
                PsychologyTermAnswer("činnost",
                    false
                ),
                PsychologyTermAnswer("agování",
                    false,
                    "Maskovaný projev nespokojenosti"
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Dispozice organismu k reagování na senzorické podněty a jejich změny se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("vjemová funkce",
                    false
                ),
                PsychologyTermAnswer("čiti",
                    false
                ),
                PsychologyTermAnswer("čivost",
                    false,
                    "Čivost spočívá ve schopnosti registrovat jednoduché podněty a rozlišovat jejich intenzitu. " +
                        "\nDolní počitkový práh (absolutní práh) - kdy to můžeme ještě rozeznat v 50% případů." +
                        "\nHorní počitkový práh - buďto již nic necítíme nebo vznikne bolest." +
                        "\nRozdílový práh - hranice, kdy dokážeme rozeznat rozdíl mezi 2 podněty v 50% případů"
                ),
                PsychologyTermAnswer("vnímání",
                    false
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pro označení relativně stálých prožitků vztahů k objektům," +
                " kterými jsou naplňovány specificky lidské potřeby, je nejvhodnější použít termín",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("afekty",
                    false,
                    "intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření"
                ),
                PsychologyTermAnswer("city",
                    false
                ),
                PsychologyTermAnswer("incentivy",
                    false,
                    "objekt nebo soubor podmínek navozující v organismu tendenci k okamžitému jednání, které vede prostřednictvím dosažení cíle k uspokojení vzniklé potřeby."
                ),
                PsychologyTermAnswer("emoční reakce",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Váš přítel se přestěhoval a vy jste si konečně zapamatovali jeho adresu." +
                " Současně jste zjistili, že si špatně pamatujete jeho starou adresu. K jakému procesu dochází?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("k útlumu",
                    false,
                    "Proaktivní útlum - potíž při vybavování nových znalostí kvůli starším, retroaktivní = vybavení starších poznatků narušují novější"
                ),
                PsychologyTermAnswer("k sekundárnímu tlumivému účinku",
                    false
                ),
                PsychologyTermAnswer("k interferenci",
                    false,
                    "Teorie interference (střetnutí pamětních stop) - podobné paměti uložené se ruší navzájem a dochází k problému si paměti vybavit."
                ),
                PsychologyTermAnswer("k interakci",
                    false
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Který z uvedených příkladů lze nejlépe označit jako příklad implicitní paměti?",
            textAnswer = "Explicitní (deklarativní) - prochází vědomím, dělí se na epizodické - epizody z života (jako příběh) a sémantické - schémata a fakta o světě." +
                "\nImplicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť.",
            answers = listOf(
                PsychologyTermAnswer("schopnost vysvětlit význam slova \"amnézie\"",
                    false,
                    "Explicitní, sémantické"
                ),
                PsychologyTermAnswer("znalost nejvyšší hory v České republice",
                    false,
                    "Explicitní, sémantické"
                ),
                PsychologyTermAnswer("vzpomínka na titulek v ranních novinách",
                    false,
                    "Explicitní, sémantické, teoreticky může být i epizodické kvůli zmínění časové osnovy."
                ),
                PsychologyTermAnswer("dovednost jízdy na kole",
                    false,
                    "Implicitní, procedurální"
                ),
            ),
            questionNumber = 52,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mnemotechnická pomůcka je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "jedno ze zařízení, které se používá při výzkumu paměti",
                    false
                ),
                PsychologyTermAnswer("aparát pro kompenzaci poruch při demencích",
                    false
                ),
                PsychologyTermAnswer(
                    "postup zlepšující zapamatování komplexních zrakově prostorových údajů",
                    false
                ),
                PsychologyTermAnswer(
                    "postup, kterým si usnadňujeme zapamatování či vybavení nějakých údajů",
                    false
                ),
            ),
            questionNumber = 53,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Největší část naučeného materiálu je zapomenuta (jsou-li tímto materiálem nesouvisející slova):",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("ve spánku mezi dnem naučení a dalším dnem",
                    false
                ),
                PsychologyTermAnswer(
                    "obsah materiálu uchovaného v paměti klesá rovnoměrně",
                    false
                ),
                PsychologyTermAnswer("mezi druhým a třetím opakováním",
                    false
                ),
                PsychologyTermAnswer("v prvních hodinách po naučení",
                    false,
                    "Některé studie poukazují na 50% hodinu po naučení."
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Vědomé vybavování není součástí",
            textAnswer = "Explicitní (deklarativní) - prochází vědomím, dělí se na epizodické - epizody z života (jako příběh) a sémantické - schémata a fakta o světě." +
                "\nImplicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť.",
            answers = listOf(
                PsychologyTermAnswer("deklarativní paměti",
                    false,
                    "prochází vědomím, dělí se na epizodické - epizody z života (jako příběh) a sémantické - schémata a fakta o světě"
                ),
                PsychologyTermAnswer("implicitní paměti",
                    false,
                    "Implicitní - je implicitně v paměti, tedy jen tak se to tam dostala bez explicitního \"klíče\"," +
                        " tudíž potom nemáme klíč, pod kterým bychom si tom vybavili."
                ),
                PsychologyTermAnswer("epizodické paměti",
                    false,
                    "epizodické - epizody z života (jako příběh)"
                ),
                PsychologyTermAnswer("sémantické paměti",
                    false,
                    "schémata a fakta o světě"
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín homeostáza znamená",
            textAnswer = "V angličtině homeostasis. Z řečtiny (hómoios, \", podobný, stejný\") + z řečtiny (stásis, \"zůstávající, stav\")",
            answers = listOf(
                PsychologyTermAnswer("stav vyrovnané motivační úrovně",
                    false
                ),
                PsychologyTermAnswer(
                    "motivační funkce detekovaných odchylek ve složení krve",
                    false
                ),
                PsychologyTermAnswer("konflikt motivů",
                    false,
                    "K. Lewin:" +
                        "\nApetence x apetence - obě stejně přitažlivé motivy, není stabilní a vydrží jen chvíli" +
                        "\nAverze x apetence - přitažlivý motiv s negativním aspektem" +
                        "\nAverze x averze - výběr mezi dvěma negativními motivy, výběr menšího zla, tendence nevybrat ani jeden"
                ),
                PsychologyTermAnswer("stálost vnitřního prostředí",
                    false
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Kterou teorii vystihuje výrok \"Mám radost, protože se směji\"?",
            textAnswer = """William James a Christiane Lang (James-Langova teorie emocí). "Jsme smutní, protože pláčeme a veselí, protože se usmíváme".""",
            answers = listOf(
                PsychologyTermAnswer("psychomotorickou motivační teorii",
                    false
                ),
                PsychologyTermAnswer("periferní teorii emocí",
                    false
                ),
                PsychologyTermAnswer("expresivní teorii emocí",
                    false
                ),
                PsychologyTermAnswer("Jones-Langmanovu teorii emocí",
                    false,
                    "Je to James-Langova teorie emocí"
                ),
            ),
            questionNumber = 57,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Na které z uvedených operací a činností se podílí spíše levá mozková hemisféra?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("zpracování hudby",
                    false
                ),
                PsychologyTermAnswer("pochopení vtipu",
                    false,
                    "Ano, pravá hemisféra."
                ),
                PsychologyTermAnswer("komplexní matematické myšlení",
                    false
                ),
                PsychologyTermAnswer("lokalizace v prostoru",
                    false
                ),
            ),
            questionNumber = 58,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Behaviorismus chápe psychologii především jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("vědu o kognitivních procesech",
                    false,
                    "Kognitivní psychologie měla explozi až v 1967"
                ),
                PsychologyTermAnswer(
                    "soubor postupů pro korekci maladaptivního chování",
                    false
                ),
                PsychologyTermAnswer("analýzu vzorců sociálního chování",
                    false
                ),
                PsychologyTermAnswer("vědu o chování",
                    false
                ),
            ),
            questionNumber = 59,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Schéma \"S-R\" vystihuje",
            textAnswer = "S - stimuli, R - response",
            answers = listOf(
                PsychologyTermAnswer("gestaltistický výklad vnímání",
                    false,
                    "Lidská mysl je celek, nikoliv komponenty. Když slyšíme melodii, nemluvíme o notách, ale o souboru not, který tvoří celek."
                ),
                PsychologyTermAnswer(
                    "vztah mezi sociálním a personálním vlivem na chování",
                    false
                ),
                PsychologyTermAnswer("kognitivistický přístup k psychologii",
                    false
                ),
                PsychologyTermAnswer("behavioristický přístup k psychologii",
                    false
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Představa, která má svou ostrostí a úplnosti blízko k vjemu, se označuje jako",
            textAnswer = "Vjem je skupina spojených počitků.",
            answers = listOf(
                PsychologyTermAnswer("reprodukční",
                    false
                ),
                PsychologyTermAnswer("intenzivni",
                    false
                ),
                PsychologyTermAnswer("eidetická",
                    false,
                    "eidetický obraz - grafická pamět - vizuální pamětní představy" +
                        "\nW. Stern hovoří o existenci přechodu od vjemů k představám, vyjadřuje to řadou:  vjem – následný obraz – eidetický obraz – představa."
                ),
                PsychologyTermAnswer("vjemová",
                    false
                ),
            ),
            questionNumber = 61,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Které z uvedených jevů bychom nejspíše zařadili k vyšším emocím?",
            textAnswer = "Základní emoce - strach, hněv, radost, smutek, důvěra, znechucení, očekávání, překvapení." +
                "\nVyšší emoce - intelektuální, morální, estetické",
            answers = listOf(
                PsychologyTermAnswer("city",
                    false,
                    "Mám k němu city. Jedná se o hodně komplexní věc."
                ),
                PsychologyTermAnswer("jednoduché emoce",
                    false
                ),
                PsychologyTermAnswer("afekty",
                    false,
                    "intenzivní emoce, vzniká náhle, prudce a má konkrétní zaměření"
                ),
                PsychologyTermAnswer("nálady",
                    false,
                    "déletrvající pohotovost k emočním reakcím určitého směru"
                ),
            ),
            questionNumber = 62,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín empatie označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "náklonnost ke druhým lidem, spojená s emočním porozuměním",
                    false
                ),
                PsychologyTermAnswer(
                    "porozumění druhému člověku, kdy jedinec přestává rozlišovat mezi vlastními hodnotami a emocemi na jedné straně a hodnotami a emocemi druhého člověka na straně druhé",
                    false
                ),
                PsychologyTermAnswer("vnější projevy porozumění druhým lidem",
                    false,
                    "Projevy empatie nejsou to samé jako empatie."
                ),
                PsychologyTermAnswer(
                    "vcítění se do druhého, porozumění jeho motivům a emocím",
                    false
                ),
            ),
            questionNumber = 63,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Fantazii řadíme mezi",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("volní procesy",
                    false,
                    "Souvisí s rozhodováním." +
                        "\nFáze rozhodovací - zpracuju, uvědomím si informace z vnějška a vytvořím cíl - rozhodnutí." +
                        "\nFáze realuzační - realizovace cíle/rozhodnutí."
                ),
                PsychologyTermAnswer("konativní procesy",
                    false,
                    "Od slova konat - behaviourální. Motivační procesy (někdy též motivačně-volní či konativní)" +
                        " - Duševní síly, které aktivizují a usměrňují chování."
                ),
                PsychologyTermAnswer("kognitivní procesy",
                    false,
                    "Kognitivní (poznávací) procesy můžeme charakterizovat jako děje, jejichž prostřednictvím člověk poznává svět i sám sebe."
                ),
                PsychologyTermAnswer("emoční procesy",
                    false,
                    "Emoční proces může určitě vyvolat myšlenku, ale samotný \"fantazírování\" bychom řadili spíše pod kognitivní."
                ),
            ),
            questionNumber = 64,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Druh představivosti, který vytváří představy, jež nebyly nikdy vnímány, označujeme",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("fantazie",
                    false,
                    "W. Stern odlišuje představy na:" +
                        "\npaměťové (vzpomínky a poznatky)" +
                        "\nfantazijní - tedy nové"
                ),
                PsychologyTermAnswer("reprodukční představivost",
                    false
                ),
                PsychologyTermAnswer("eidetická vloha",
                    false,
                    "grafická paměť"
                ),
                PsychologyTermAnswer("metakognice",
                    false,
                    "Všechno meta je věc o samotný věci - poznávání jak člověk poznává."
                ),
            ),
            questionNumber = 65,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín homeostáza má význam zejména při vysvětlování",
            textAnswer = "V angličtině homeostasis. Z řečtiny (hómoios, \", podobný, stejný\") + z řečtiny (stásis, \"zůstávající, stav\")",
            answers = listOf(
                PsychologyTermAnswer("emocí",
                    false
                ),
                PsychologyTermAnswer("motivace",
                    false,
                    "Motivaci je v porovnání s homeostází stav, kdy se chceme z dané homeostáze odrazit. Podle Maslowa však i tuto homeostázi potřebujeme na to," +
                        " abychom takové motivace dostávali."
                ),
                PsychologyTermAnswer("vývoje",
                    false
                ),
                PsychologyTermAnswer("kognice",
                    false
                ),
            ),
            questionNumber = 66,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Experiment je uspořádán tak, že zvíře musí udělat nějaký úkon," +
                " aby se zbavilo působení nepříjemného podnětu. O jaký mechanismus se jedná",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("klasické podmiňování",
                    false,
                    "I.P.Pavlov"
                ),
                PsychologyTermAnswer("trest",
                    false,
                    "když trestáme, snažíme se nějakého chování zbavit"
                ),
                PsychologyTermAnswer("negativní posilování",
                    false
                ),
                PsychologyTermAnswer("pozitivní posilování",
                    false,
                    "Odměňování - chceme aby se chování opakovalo. Odměňovat musíme nepravidelně."
                ),
            ),
            questionNumber = 67,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Obsah termínu imaginativní procesy zahrnuje",
            textAnswer = "Imaginace je schopnost vyvolávat v mysli obrazce - představa bude vždy.",
            answers = listOf(
                PsychologyTermAnswer("představování a fantazii",
                    false
                ),
                PsychologyTermAnswer("představování a divergentní myšlení",
                    false,
                    "Divergentní myšlení je sbíhavý vznik nových řešení na problém (ADHD)."
                ),
                PsychologyTermAnswer("pouze fantazii",
                    false
                ),
                PsychologyTermAnswer("divergentní myšlení a paměť",
                    false
                ),
            ),
            questionNumber = 68,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pragmatika se zabývá",
            textAnswer = "Nebo také pragmatická lingvistika (z řeckého pragma - skutek)." +
                " Řeč není jen sémantická, informativní, ale je pod tím i něco více, nějak záměr.",
            answers = listOf(
                PsychologyTermAnswer("řešením konfliktů",
                    false
                ),
                PsychologyTermAnswer("vztahem znakového systému a jeho uživatelů",
                    false,
                    "Uživatel totiž něco zamýšlí, má nějaký záměr, nejedná se jen o samotný znakový systém."
                ),
                PsychologyTermAnswer("problematikou adaptace člověka",
                    false
                ),
                PsychologyTermAnswer("vzájemným vztahem znaků ve znakovém systému",
                    false
                ),
            ),
            questionNumber = 69,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Disciplína, která studuje vzájemné vztahy znaků ve znakovém systému" +
                " a jejich přípustné kombinace se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("gramatika",
                    false,
                    "Stavba vět"
                ),
                PsychologyTermAnswer("pragmatika",
                    false,
                    "Nebo také pragmatická lingvistika (z řeckého pragma - skutek)." +
                        " Řeč není jen sémantická, informativní, ale je pod tím i něco více, nějak záměr."
                ),
                PsychologyTermAnswer("sémantika",
                    false,
                    "Vztah mezi znaky a jejich významy"
                ),
                PsychologyTermAnswer("syntaxe",
                    false,
                    "Vztahy mezi jednotlivými výrazy."
                ),
            ),
            questionNumber = 70,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Frustrační tolerance znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "odolnost vůči frustraci",
                    false,
                    "Trochu spekulativní. Člověk může být \"trochu\" frustrován a stále bychom ho nenazvali frustrovaný." +
                        " Nemáme odolnost, pouze každý zvládne jiné množšství."
                ),
                PsychologyTermAnswer(
                    "práh maximálního podráždění senzorických receptorů",
                    false
                ),
                PsychologyTermAnswer("tendence skupiny připustit nátlak",
                    false,
                    "Frustrační tolerace není exkluzivní na skupinu"
                ),
                PsychologyTermAnswer("míra tendence jedince omezovat jiné lidi",
                    false
                ),
            ),
            questionNumber = 71,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "U spolubydlících žen byla zaznamenána tendence k synchronizaci menstruačního cyklu." +
                " Co má patrně rozhodující vliv na vznik tohoto jevu?",
            textAnswer = "Také naýváno jako McClintock effect.",
            answers = listOf(
                PsychologyTermAnswer("pozorování změn v chování",
                    false
                ),
                PsychologyTermAnswer("emoční sounáležitost",
                    false
                ),
                PsychologyTermAnswer("čich",
                    false,
                    "V angličtině olfactory. Jde o feromony."
                ),
                PsychologyTermAnswer("citlivost k hlasovým projevům",
                    false
                ),
            ),
            questionNumber = 72,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Eidetická vloha je",
            textAnswer = "Grafická paměť",
            answers = listOf(
                PsychologyTermAnswer("nic z uvedených možností",
                    false
                ),
                PsychologyTermAnswer(
                    "schopnost velmi podrobně si znovuvybavit vjem",
                    false
                ),
                PsychologyTermAnswer("výrazný sklon k napodobování ostatnich lidí",
                    false
                ),
                PsychologyTermAnswer("vloha pro tvorbu originálních myšlenek",
                    false
                ),
            ),
            questionNumber = 73,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Zkoumání vědomých obsahů a procesů své vlastní psychiky označujeme pojmem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("introspekce",
                    false,
                    "Spojováno se strukturalismem - W. Wundt (1832-1920)." +
                        "\nSpojováno s John Locke (1632-1704), zakladatel Saussure"
                ),
                PsychologyTermAnswer("introdukce",
                    false
                ),
                PsychologyTermAnswer("vnitřní zření",
                    false
                ),
                PsychologyTermAnswer("konspekce",
                    false
                ),
            ),
            questionNumber = 74,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Který z uvedených faktorů je nejdůležitější pro myšlení?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("uplatnění pracovní paměti",
                    false
                ),
                PsychologyTermAnswer("fi-fenomén",
                    false,
                    "Gestalt psychologie. Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly."
                ),
                PsychologyTermAnswer("zapamatování informací",
                    false
                ),
                PsychologyTermAnswer("chápání vztahů",
                    false
                ),
            ),
            questionNumber = 75,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Myšlení patří mezi",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("součásti inteligence",
                    false
                ),
                PsychologyTermAnswer("logické operace",
                    false
                ),
                PsychologyTermAnswer("kognitivní procesy",
                    false
                ),
                PsychologyTermAnswer("konativní procesy",
                    false,
                    "(Nebo také emoční procesy) - duševní síly, emoce, které usměrňují naše chování."
                ),
            ),
            questionNumber = 76,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podněty následující rychle po sobě jsou vnímány jako jeden celek. Jak se tento jev obvykle označuje?",
            textAnswer = "Gestalt psychologie - Kohler, Wertheimer, Koffka, Lewin." +
                "\nNěkteré věci, které řešili:" +
                "\nFi-fenomen - Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly." +
                "\nZákon dobrého tvaru (pregnance) - doplňujeme si mezery, které můžou v celku být." +
                "\nZákon proximity - v určité vzdálenosti vnímáme prvky jako celek." +
                "\nZákon podobnosti - tendence vnímat podobné podněty jako celky.",
            answers = listOf(
                PsychologyTermAnswer("fi-fenomén",
                    false
                ),
                PsychologyTermAnswer("koherenční jev",
                    false
                ),
                PsychologyTermAnswer("zákon dobré figury",
                    false,
                    "Gestalt psychologie. Podle tohoto zákona vnímáme jako jeden celek ty podněty, které na sebe plynule navazují."
                ),
                PsychologyTermAnswer("zákon kontrastu",
                    false,
                    "Podle něho je představa bílé barvy asociována s černou barvou, podobně jako jsou spojeny představy dne a noci, světla a stínu" +
                        "\nAsocianismus - vznik ve filozofii 18-19 století. J.F. Herbart, Locke a Ebbinghaus. \"Nic není ve vědomí, co dříve nebylo ve smyslech.\""
                ),
            ),
            questionNumber = 77,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Barevné vidění zajišťují",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("tyčinky",
                    false
                ),
                PsychologyTermAnswer("amakrinní buňky",
                    false,
                    "neurony v sítnici"
                ),
                PsychologyTermAnswer("čípky",
                    false
                ),
                PsychologyTermAnswer("chromatické buňky",
                    false
                ),
            ),
            questionNumber = 78,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Weberova konstanta pro intenzitu světla je 0,01. O kolik procent se musí zvýšit intenzita světla, aby ji člověk dokázal zaznamenat?",
            textAnswer = "Weberův zákon říká, že čím menší je hodnota konstanty, tím je potřeba menšího přírůstku," +
                " aby smyslový orgán zaregistroval změnu intenzity podnětu.\n" +
                "Frekvence zvuku 0,003\n" +
                "Intenzita zvuku 0,15\n" +
                "Intenzita světla 0,01\n" +
                "Koncentrace pachového podnětu 0,07\n" +
                "Koncentrace chuťového podnětu 0,20\n" +
                "Intenzita tlakového podnětu 0,14",
            answers = listOf(
                PsychologyTermAnswer("nelze určit",
                    false
                ),
                PsychologyTermAnswer("1%",
                    false
                ),
                PsychologyTermAnswer("10%",
                    false
                ),
                PsychologyTermAnswer("50%",
                    false
                ),
            ),
            questionNumber = 79,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Které z uvedených vodítek se neuplatňuje při vnímání vzdálených předmětů",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("překrývání",
                    false,
                    "Interpozice - překrývání objektů v percepčním poli (bližší objekty překrývají ty vzdálenější)"
                ),
                PsychologyTermAnswer("binokulární paralaxa",
                    false,
                    "Vidění oběma očima zároveň"
                ),
                PsychologyTermAnswer("ani jedno",
                    false
                ),
                PsychologyTermAnswer("pohybová paralaxa",
                    false
                ),
            ),
            questionNumber = 80,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Vztah mezi znaky a jejich významy studuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("pragmatika",
                    false,
                    "Nebo také pragmatická lingvistika (z řeckého pragma - skutek)." +
                        " Řeč není jen sémantická, informativní, ale je pod tím i něco více, nějak záměr."
                ),
                PsychologyTermAnswer("sémiotika",
                    false,
                    "Sémiotika (z řec. sémeion - znak, označení) je nauka o znakových systémech."
                ),
                PsychologyTermAnswer("lingvistika",
                    false,
                    "Neboli jazykověda je věda zkoumající přirozený jazyk."
                ),
                PsychologyTermAnswer("sémantika",
                    false,
                    "Vztah mezi znaky a jejich významy"
                ),
            ),
            questionNumber = 81,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jiné označení pro tvořivost zní",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("produktivita",
                    false
                ),
                PsychologyTermAnswer("divergence",
                    false,
                    "Divergentní myšlení je sbíhavý vznik nových řešení na problém (ADHD)."
                ),
                PsychologyTermAnswer("kreativita",
                    false
                ),
                PsychologyTermAnswer("fantazie",
                    false
                ),
            ),
            questionNumber = 82,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín motivace je odvozen od latinské podoby slova",
            textAnswer = "Taky to má blízko k angl. slovu motion.",
            answers = listOf(
                PsychologyTermAnswer("hýbat se",
                    false,
                    "\"Movere\""
                ),
                PsychologyTermAnswer("usilovat",
                    false
                ),
                PsychologyTermAnswer("zacílit",
                    false
                ),
                PsychologyTermAnswer("zamýšlet",
                    false
                ),
            ),
            questionNumber = 83,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Postupná modifikace složitého chování podmiňováním jednotlivých částí a kroků behaviorálního vzorce se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("podmíněná reakce",
                    false,
                    "klasické podmiňování, reflex"
                ),
                PsychologyTermAnswer("komplexizace",
                    false
                ),
                PsychologyTermAnswer("tvarování",
                    false
                ),
                PsychologyTermAnswer("sukcesivní posilování",
                    false
                ),
            ),
            questionNumber = 84,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mezi poznávací procesy nepatří",
            textAnswer = "Také například učení, vnímání, pozornost, učení a paměť.",
            answers = listOf(
                PsychologyTermAnswer("představování",
                    false
                ),
                PsychologyTermAnswer("čití",
                    false,
                    "Čivost spočívá ve schopnosti registrovat jednoduché podněty a rozlišovat jejich intenzitu.\n" +
                        "\nDolní počitkový práh (absolutní práh) - kdy to můžeme ještě rozeznat v 50% případů.\n" +
                        "\nHorní počitkový práh - buďto již nic necítíme nebo vznikne bolest.\n" +
                        "\nRozdílový práh - hranice, kdy dokážeme rozeznat rozdíl mezi 2 podněty v 50% případů"
                ),
                PsychologyTermAnswer("myšlení",
                    false
                ),
                PsychologyTermAnswer("inteligence",
                    false
                ),
            ),
            questionNumber = 85,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Potlačení patří mezi",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("obranné mechanismy",
                    false,
                    "S.Freud: Agrese\n" +
                        "Projekce\n" +
                        "Introjekce \n" +
                        "Anticipace\n" +
                        "Disociace\n" +
                        "Hédonická adaptace - prostě to časem odejde.\n" +
                        "Humor\n" +
                        "Identifikace\n" +
                        "Projektivní identifikace\n" +
                        "Racionalizace\n" +
                        "Reaktivní formace - potlačitli jsme u sebe a chceme potlačit i u jiných.\n" +
                        "Regrese\n" +
                        "Sublimace\n" +
                        "Šikana\n" +
                        "Egocentrismus\n" +
                        "Vytěsnění\n" +
                        "Opačné reagování\n" +
                        "Somatizace\n" +
                        "Izolace\n" +
                        "Identifikace\n" +
                        "Obejití překážky\n" +
                        "Kompenzace\n" +
                        "Fixace"
                ),
                PsychologyTermAnswer("osobnostní rysy",
                    false
                ),
                PsychologyTermAnswer("poznávací procesy",
                    false,
                    "(kognitivní procesy) - vnímání, paměť, představivost, učení, myšlení."
                ),
                PsychologyTermAnswer("mnemotechnické pomůcky",
                    false,
                    "postup, kterým si usnadňujeme zapamatování či vybavení nějakých údajů"
                ),
            ),
            questionNumber = 86,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Potřeby se řadí mezi",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("incentivy",
                    false,
                    "Objekt nebo soubor podmínek navozující v organismu tendenci k okamžitému jednání," +
                        " které vede prostřednictvím dosažení cíle k uspokojení vzniklé potřeby. \nMaslow.\nPotřeba vytváří incentivu, neřadí se pod ní však."
                ),
                PsychologyTermAnswer("regulátory",
                    false
                ),
                PsychologyTermAnswer("motivy",
                    false,
                    "1. Uspokojuje potřeby vyjadřující nedostatky ve fyzickém nebo sociálním bytí.\n" +
                        "2. Zajišťuje účelné chování udržující vitální a sociální funkce individua.\n" +
                        "3. Organizuje chování."
                ),
                PsychologyTermAnswer("cíle",
                    false
                ),
            ),
            questionNumber = 87,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Které druhy pozornosti rozlišujeme",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("krátkodobá a dlouhodobá",
                    false
                ),
                PsychologyTermAnswer("bezděčná a záměrná",
                    false,
                    "záměrná - subjekt cíleně vnímá podnět a bezděčnou - subjekt vnímá podnět bez úmyslu." +
                        "\nNěkdy se může objevit též pozornost protivolní - subjekt nedokáže potlačit vnímá podnětu, může vést k obsedantnímu jednání"
                ),
                PsychologyTermAnswer("automatická a algoritmická",
                    false
                ),
                PsychologyTermAnswer("diferencovaná a globální",
                    false
                ),
            ),
            questionNumber = 88,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín alimentární potřeby označuje",
            textAnswer = "Ze slova \"alimentum\" - výživa, potrava",
            answers = listOf(
                PsychologyTermAnswer("potřeby spojené s výživou",
                    false
                ),
                PsychologyTermAnswer("potřebu rodičovského chování",
                    false
                ),
                PsychologyTermAnswer("pomůcky při psychologickém experimentování",
                    false
                ),
                PsychologyTermAnswer("potřeby vyvíjejícího se dítěte",
                    false
                ),
            ),
            questionNumber = 89,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Srovnávací psychologie se zabývá",
            textAnswer = "(Komparativní psychologie) Něco jako etologie psychologie." +
                " Tedy zkoumá hlavně chování zvířat (organismů) mimo lidi.\nObčas se však definuje jako věda porovnávající zvířata s lidmi.",
            answers = listOf(
                PsychologyTermAnswer("porovnáváním chování různých jedinců",
                    false,
                    "jedinci - lidi"
                ),
                PsychologyTermAnswer("porovnáváním chování lidí a zvířat",
                    false
                ),
                PsychologyTermAnswer(
                    "porovnávání chování u různých sociálních skupin",
                    false,
                    "To bude asi spíše Srovnávací (komparativní) sociologie."
                ),
                PsychologyTermAnswer("vyrovnáváním vrozených rozdílů mezi lidmi",
                    false
                ),
            ),
            questionNumber = 90,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Lidé slyší zuky ve frekvenčním rozsahu přibližně:",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("470 Hz-760 kHz",
                    false
                ),
                PsychologyTermAnswer("0,02 kHz-200 kHz",
                    false
                ),
                PsychologyTermAnswer("20 Hz-20 kHz",
                    false
                ),
                PsychologyTermAnswer("200 Hz-200 kHz",
                    false
                ),
            ),
            questionNumber = 91,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Weberův zákon platí:",
            textAnswer = "Weberův zákon říká, že čím menší je hodnota konstanty, tím je potřeba menšího přírůstku," +
                " aby smyslový orgán zaregistroval změnu intenzity podnětu.\n" +
                "Frekvence zvuku 0,003\n" +
                "Intenzita zvuku 0,15\n" +
                "Intenzita světla 0,01\n" +
                "Koncentrace pachového podnětu 0,07\n" +
                "Koncentrace chuťového podnětu 0,20\n" +
                "Intenzita tlakového podnětu 0,14",
            answers = listOf(
                PsychologyTermAnswer("pro podněty střední intenzity",
                    false,
                    "vyřazovací metodou k tomuhle dojdeš"
                ),
                PsychologyTermAnswer("pro extrémní podněty",
                    false
                ),
                PsychologyTermAnswer(
                    "pro podněty, které nepřekračují určitou mez intenzity",
                    false
                ),
                PsychologyTermAnswer(
                    "pro podněty překračující určitou mez intenzity",
                    false
                ),
            ),
            questionNumber = 92,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Za jasného slunečního svitu se nám zelené listy růže zdají světlejší než jejich červené květy," +
                " zatímco v šeru se nám zdají světlejší květy. Mluvíme o",
            textAnswer = "Jde o posun maxima citlivosti oka při změně světelných podmínek.",
            answers = listOf(
                PsychologyTermAnswer("Slavíčkově jevu",
                    false
                ),
                PsychologyTermAnswer("Blochově zákonu",
                    false
                ),
                PsychologyTermAnswer("Goethově fenoménu",
                    false
                ),
                PsychologyTermAnswer("Purkyňově fenoménu",
                    false
                ),
            ),
            questionNumber = 93,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín percepce označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("zrakové vnímání",
                    false
                ),
                PsychologyTermAnswer("čití",
                    false,
                    "Čivost spočívá ve schopnosti registrovat jednoduché podněty a rozlišovat jejich intenzitu.\n" +
                        "\nDolní počitkový práh (absolutní práh) - kdy to můžeme ještě rozeznat v 50% případů.\n" +
                        "\nHorní počitkový práh - buďto již nic necítíme nebo vznikne bolest.\n" +
                        "\nRozdílový práh - hranice, kdy dokážeme rozeznat rozdíl mezi 2 podněty v 50% případů"
                ),
                PsychologyTermAnswer("vnímání",
                    false
                ),
                PsychologyTermAnswer("úmyslné vnímání",
                    false
                ),
            ),
            questionNumber = 94,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Předmětnost vnímání znamená,",
            textAnswer = "Vidíme, co vidíme. Opravdu to existuje - narozdíl například od halucinace.",
            answers = listOf(
                PsychologyTermAnswer(
                    "že vnímáme předměty, události a jevy ve vnějším světě a spíše než stav svých smyslových orgánů",
                    false
                ),
                PsychologyTermAnswer(
                    "že vjemy vždy odpovídají předmětům a ostatní vnímané obsahy se pouze konstruují podle těchto předmětů.",
                    false
                ),
                PsychologyTermAnswer(
                    "že vnímaný předmět je rozhodující součástí vjemu",
                    false
                ),
                PsychologyTermAnswer("že předměty vnímáme přesněji než děje",
                    false
                ),
            ),
            questionNumber = 95,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Který termín znamená něco jiného než ostatní?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("operační paměť",
                    false
                ),
                PsychologyTermAnswer("senzorická paměť",
                    false
                ),
                PsychologyTermAnswer("mžikové smyslové zásobníky",
                    false
                ),
                PsychologyTermAnswer("ultrakrátká paměť",
                    false
                ),
            ),
            questionNumber = 96,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Amesova komora slouží k demonstraci",
            textAnswer = "Optický klam.",
            answers = listOf(
                PsychologyTermAnswer(
                    "prostorové orientace při nedostatku prostorových vodítek",
                    false
                ),
                PsychologyTermAnswer("závislosti či nezávislosti na poli",
                    false
                ),
                PsychologyTermAnswer(
                    "vlivu absolutně tichého prostředí na vnímání zvuku",
                    false
                ),
                PsychologyTermAnswer("vlivu vnímání prostoru na vnímání velikosti",
                    false
                ),
            ),
            questionNumber = 97,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://wikisofia.cz/w/images/1/1b/M%C3%BCllerova-Lyerova_iluze.jpg",
            prompt = "Müller-Lyerova iluze ovlivňuje",
            textAnswer = "Šipky s jinými zakončeními, vypadají rozdílně, jsou však stejně dlouhé.",
            answers = listOf(
                PsychologyTermAnswer("vnímání délky",
                    false
                ),
                PsychologyTermAnswer("vnímání tvaru",
                    false
                ),
                PsychologyTermAnswer("vnímání barev",
                    false
                ),
                PsychologyTermAnswer("vnímání hloubky",
                    false
                ),
            ),
            questionNumber = 98,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://o.quizlet.com/vNJYYOsyqEaRkwNuzgC9xw.png",
            prompt = "Podráždění buněk v Cortiho orgánu při vnímání řeči představuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("distální stimulus",
                    false,
                    "vnější zdroj stimulace tak, jak existuje v prostředí. Tento vnější podnět se může lišit od vnitřního vnímání podnětu, jak je zaznamenáván smyslovými receptory."
                ),
                PsychologyTermAnswer("proximální stimulus",
                    false,
                    "vnitřní počitek zdroje stimulace tak, jak je zaznamenáván smyslovými receptory." +
                        "\nTento vnitřní vjem nemusí přesně odpovídat vnějšímu zdroji stimulace tak, jak se vyskytuje ve světě (STERNBERG 2002)."
                ),
                PsychologyTermAnswer("zdroj šumu",
                    false
                ),
                PsychologyTermAnswer("dekódování informace",
                    false
                ),
            ),
            questionNumber = 99,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jaký je vztah mezi motivací a výkonem obvykle platí?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "při střední motivaci se dosahuje nejhoršího výkonu",
                    false
                ),
                PsychologyTermAnswer("neexistuje žádný stabilní vztah",
                    false
                ),
                PsychologyTermAnswer(
                    "nejlepšího výkonu se dosahuje při maximální motivaci",
                    false
                ),
                PsychologyTermAnswer(
                    "nejlepšího výkonu se dosahuje při střední úrovní motivace",
                    false
                ),
            ),
            questionNumber = 100,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podle ekologické teorie vnímání",
            textAnswer = "Argument proti Gestalskému pojetí percepce Koffky. Klasické gestalské vysvětlení je," +
                " že pouze informace získáme a následně je zpracujeme v hlavě, tohle je opak. Gibson (1904-1979)",
            answers = listOf(
                PsychologyTermAnswer("je informace obsažena v toku podnětů",
                    false
                ),
                PsychologyTermAnswer(
                    "vytvořil David Marr pojem dvouapůlrozměrného náčrtku (2,5-D sketch)",
                    false,
                    "Teorie toho, že nevnímáme 3 rozměry, ale že si je konstruujeme v hlavě - dosti Gestalský přístup."
                ),
                PsychologyTermAnswer(
                    "vnímatel konstruuje vjem integrací parciálních vjemů jednotlivých smyslů",
                    false,
                    "To je také ten gestalský přístup."
                ),
                PsychologyTermAnswer(
                    "platí zákon o specifických energiích smyslových",
                    false
                ),
            ),
            questionNumber = 101,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Nemožnost dosáhnout cíle či naplnit motiv vyvolává",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("amnézii",
                    false,
                    "Ztráta pasměti"
                ),
                PsychologyTermAnswer("abulii",
                    false,
                    "Nedostatek podnětů k činnosti."
                ),
                PsychologyTermAnswer("frustraci",
                    false
                ),
                PsychologyTermAnswer("averzi",
                    false
                ),
            ),
            questionNumber = 102,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "V určitých pokusech je zvíře nuceno plavat v bazénku, kde jsou pod hladinu umístěny ostrůvky," +
                " na nichž si může odpočinout. Ostrůvky nejsou vidět a zvíře se musí spoléhat na svou orientaci a paměť. Toto uspořádání se používá ke studiu",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("strukturních reprezentací",
                    false
                ),
                PsychologyTermAnswer("vnímání prostoru",
                    false
                ),
                PsychologyTermAnswer("výkonu v nejistotě",
                    false
                ),
                PsychologyTermAnswer("kognitivních map",
                    false,
                    "Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí." +
                        "\n-E. C. Tolman, neobehaviorismus (inspirace z Gestaltu)."
                ),
            ),
            questionNumber = 103,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Scénáře (schémata) jsou považovány za způsob reprezentace",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("běžných událostí",
                    false,
                    "Teorie zní, že v každé soc. situaci máme určité naučené scénáře (schémata)." +
                        " Např. do divadla se chodí slušně oblečeno, vypínají se zvonění na telefonech a nemluví se když se hraje."
                ),
                PsychologyTermAnswer("filmů a televizních přenosů",
                    false
                ),
                PsychologyTermAnswer("sociálně významných událostí",
                    false
                ),
                PsychologyTermAnswer("mimořádných zážitků",
                    false
                ),
            ),
            questionNumber = 104,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Kognitivní mapa je",
            textAnswer = "Schopnost reagovat pomocí naučených znalostí. Projevuje se jako snaha orientovat se v prostředí." +
                "\n-E. C. Tolman, neobehaviorismus (inspirace z Gestaltu).",
            answers = listOf(
                PsychologyTermAnswer("způsob reprezentace vztahů mezi lidmi",
                    false
                ),
                PsychologyTermAnswer(
                    "způsob reprezentace prostoru a prostorových vztahů",
                    false
                ),
                PsychologyTermAnswer(
                    "schematický způsob zachycení průběhu kognitivních procesů",
                    false
                ),
                PsychologyTermAnswer(
                    "mapa rozmístění kognitivních systémů v mozkové kůře",
                    false
                ),
            ),
            questionNumber = 105,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Který z termínů nesouvisí s konekcionismem?",
            textAnswer = "Přístup, který modeluje mentální reprezentaci v síti uzlů vzájemně propojených různě silnými spoji," +
                " jejichž síla se může měnit při \"učení\".",
            answers = listOf(
                PsychologyTermAnswer("subsymbolická mentální reprezentace",
                    false,
                    "Re-prezentace nám umožňuje znovu-zpřítomnění. Zastupuje věc, která nemusí být aktuálně přítomná. (V mysli)"
                ),
                PsychologyTermAnswer("váha spoje",
                    false
                ),
                PsychologyTermAnswer("akomodace",
                    false,
                    "Přizpůsobení"
                ),
                PsychologyTermAnswer(
                    "neuronová síť", false,
                "výpočetní struktura inspirovaná modelováním funkce nervové soustavy"),
            ),
            questionNumber = 106,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "V psychologii se rozlišují dva druhy zpracování informace zdola nahoru (bottom-up)" +
                " a shora dolů (top-down). Na jaký typ zpracování klade důraz gestaltistická teorie vnímání?",
            textAnswer = "Hezkým příkladem je Stroop efekt - list barevných názvů barev se záměrně špatnými barvami." +
                " Dělá nám to problém, protože zakládáme na našich \"systémech\".",
            answers = listOf(
                PsychologyTermAnswer("shora dolů",
                    false
                ),
                PsychologyTermAnswer("zdola nahoru",
                    false
                ),
                PsychologyTermAnswer("teorii nelze analyzovat v těchto termínech",
                    false
                ),
                PsychologyTermAnswer(
                    "teorie vyrovnaně pracuje s oběma typy zpracování",
                    false
                ),
            ),
            questionNumber = 107,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pozitivní následný obraz vzniká",
            textAnswer = "Paobraz, Goethe a Purkyně. Vidíme obrazec, na který jsme se dlouho koukali pokud se následně koukneme na bílé pozadí.",
            answers = listOf(
                PsychologyTermAnswer("jako následek adaptace receptorů",
                    false
                ),
                PsychologyTermAnswer("tehdy, když jsou špatné světelné podmínky",
                    false
                ),
                PsychologyTermAnswer("následkem pomalého přenosu na synapsích",
                    false
                ),
                PsychologyTermAnswer("v důsledku existence senzorického registru",
                    false,
                    "smyslová paměť, jedná se o milisekundy" +
                        "\nUltra krátkodobá paměť: Ikonická paměť (vizuální) do 1s, Echoická (zvuková) 3-4s."
                ),
            ),
            questionNumber = 108,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Negativní následný obraz vzniká",
            textAnswer = "Paobraz, Goethe a Purkyně. Vidíme obrazec, na který jsme se dlouho koukali pokud se následně koukneme na bílé.",
            answers = listOf(
                PsychologyTermAnswer("následkem pomalého přenosu na synapsích",
                    false
                ),
                PsychologyTermAnswer("v důsledku existence senzorického registru",
                    false,
                    "Ultra krátkodobá paměť: Ikonická paměť (vizuální) do 1s, Echoická (zvuková) 3-4s."
                ),
                PsychologyTermAnswer("jako následek adaptace receptorů",
                    false
                ),
                PsychologyTermAnswer("tehdy, když jsou špatné světelné podmínky",
                    false
                ),
            ),
            questionNumber = 109,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pojmem schéma označujeme",
            textAnswer = "F. Bartlett",
            answers = listOf(
                PsychologyTermAnswer(
                    "uměle vytvořenou reprezentaci vztahů mezi lidmi ve skupině",
                    false
                ),
                PsychologyTermAnswer(
                    "paměťovou reprezentaci skupiny lidí, objektů, událostní nebo situací",
                    false
                ),
                PsychologyTermAnswer("plán uspořádání pokusu",
                    false
                ),
                PsychologyTermAnswer(
                    "procedurální reprezentaci jemných senzomotorických aktivit",
                    false
                ),
            ),
            questionNumber = 110,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jaký je hlavní rozdíl mezi jednáním a chováním?",
            textAnswer = "Představ si když řeknu \"Jednají spolu\" a \"Chovala své dítě\".",
            answers = listOf(
                PsychologyTermAnswer(
                    "jednání vždy implikuje přítomnost druhých osob",
                    false
                ),
                PsychologyTermAnswer("chování má fyziologické průvodní projevy",
                    false
                ),
                PsychologyTermAnswer("chování můžeme objektivně hodnotit",
                    false
                ),
                PsychologyTermAnswer("jednání je komplexní a cílené",
                    false
                ),
            ),
            questionNumber = 111,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Který z uvedených typů znaků nepatří do klasifikace založené na díle Ch. S. Pierce?",
            textAnswer = "Peircův triadický model znaku.",
            answers = listOf(
                PsychologyTermAnswer("ikón",
                    false,
                    "Metafory a analogie - nějaká podobnost objektu."
                ),
                PsychologyTermAnswer("signál",
                    false
                ),
                PsychologyTermAnswer("symbol",
                    false,
                    "Symbolizuje nějaký objekt - symbol je kouř a (naučený/dohodnutý) objekt nebezpečí"
                ),
                PsychologyTermAnswer("index",
                    false,
                    "Indexuje něco dalšího - je přímo ovlivněn, kauzálně propojen s objektem. Např. kouř je index objektu - oheň"
                ),
            ),
            questionNumber = 112,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Znak, kde je označující a označované propojeno vzájemnou podobností, se označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("imagen",
                    false
                ),
                PsychologyTermAnswer("signál",
                    false
                ),
                PsychologyTermAnswer("index",
                    false,
                    "Indexuje něco dalšího - je přímo ovlivněn, kauzálně propojen s objektem. Např. kouř je index objektu - oheň"
                ),
                PsychologyTermAnswer("ikón",
                    false,
                    "Metafory a analogie - nějaká podobnost objektu."
                ),
            ),
            questionNumber = 113,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Spontánní proud představ, které se týkají přání jedince a mají obvykle kladné emoční zabarvení označujeme",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "ipsační fantazie",
                    false
                ),
                PsychologyTermAnswer("denní snění",
                    false
                ),
                PsychologyTermAnswer("Münchhausenův syndrom",
                    false,
                    "Předstíráme, že jsme nemocní."
                ),
                PsychologyTermAnswer("pseudologia phantastica",
                    false,
                    "Bájivá či chorobná lhavost. Daný lže pro pozornost."
                ),
            ),
            questionNumber = 114,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Abstraktní informace, jako např. údaje o vymezení pojmů, obsahuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("procedurální paměť",
                    false,
                    "Implicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť."
                ),
                PsychologyTermAnswer("syntaktická paměť'",
                    false
                ),
                PsychologyTermAnswer("sémantická paměť",
                    false,
                    "Sémantická paměť - schémata a fakta o světě."
                ),
                PsychologyTermAnswer("epizodická paměť",
                    false,
                    "Epizodická paměť - epizody z života (jako příběh)."
                ),
            ),
            questionNumber = 115,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pro získání dovednosti jízdy na kole je rozhodující",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("inkluzní paměť",
                    false
                ),
                PsychologyTermAnswer("epizodická paměť",
                    false
                ),
                PsychologyTermAnswer("deklarativní paměť",
                    false,
                    "Explicitní (deklarativní) - prochází vědomím, dělí se na epizodické - epizody z života (jako příběh) a sémantické - schémata a fakta o světě."
                ),
                PsychologyTermAnswer("procedurální paměť",
                    false,
                    "Implicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť."
                ),
            ),
            questionNumber = 116,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Kybernetický pojem pro systém, jehož chování zkoumáme, jehož vnitřní struktura je nám ovšem nepřístupná, je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("Skinnerův box",
                    false,
                    "To byla klec, ve které měl Skinner krysy a ve které je učil podmiňování."
                ),
                PsychologyTermAnswer("kognitivní modul",
                    false
                ),
                PsychologyTermAnswer("behaviorální element",
                    false,
                    "To je styl, jakým subjekt učíme nebo odnaučíme."
                ),
                PsychologyTermAnswer("černá skříňka",
                    false,
                    "Také často používáno \"black box\""
                ),
            ),
            questionNumber = 117,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podle modularistického pojetí je mysl",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("uspořádána do zcela uzavřených monád",
                    false
                ),
                PsychologyTermAnswer("jedním uzavřeným modulem",
                    false
                ),
                PsychologyTermAnswer(
                    "důsledkem činnosti anatomicky zřetelně odlišitelných mozkových subsystémů",
                    false
                ),
                PsychologyTermAnswer(
                    "složena z relativně samostatných a funkčně specializovaných jednotek",
                    false
                ),
            ),
            questionNumber = 118,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Myšlenkové odvozování a usuzování se označuje také jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("abdukce",
                    false
                ),
                PsychologyTermAnswer("dedukce",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
                PsychologyTermAnswer("atribuce",
                    false,
                    "Kognitivní proces přisuzování jedné či více příčin vlastnímu chování a chování jiných lidí." +
                        " Dělí se na vnější a vnitřní."
                ),
                PsychologyTermAnswer("inference",
                    false,
                    "vyvozování závěru z dat/pozorování"
                ),
            ),
            questionNumber = 119,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Kde na sítnici je největší nahromadění čípků?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("kolem slepé skvrny",
                    false
                ),
                PsychologyTermAnswer(
                    "v periferní oblasti sitnice, asi 200 od centrální jamky",
                    false
                ),
                PsychologyTermAnswer("uprostřed žluté skvrny",
                    false
                ),
                PsychologyTermAnswer("rozmístění čípků je homogenní",
                    false
                ),
            ),
            questionNumber = 120,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Vodítkem pro vnímání prostoru není",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "akomodace",
                    false,
                    "Měna zakřivenosti čočky tak, aby oko mohlo zaostřit na různě vzdálené objekty"
                ),
                PsychologyTermAnswer("horopterová kružnice",
                    false,
                    "oči se snaží mít stejný objekt na sejném místě sítnice - 3 body"
                ),
                PsychologyTermAnswer("binokulární disparace",
                    false,
                    "Dva různé obrazy očí, které když se zkombinují, vytváří představu hlopubky"
                ),
                PsychologyTermAnswer("překrývání objektů",
                    false,
                    "Interpozice - překrývání objektů v percepčním poli (bližší objekty překrývají ty vzdálenější)"
                ),
            ),
            questionNumber = 121,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Gradient struktury se uplatňuje při",
            textAnswer = "J. Gibson, Ekologická teorie vnímání - informace pro přesné vnímání jsou již součástí podnětu." +
                "\nNapř. Gradient (spád) struktury - přejíždíme-li zrakem po určité scenérii – dochází ke změnám vnímané členitosti povrchu,....",
            answers = listOf(
                PsychologyTermAnswer("druhotné analýze komplexních zrakových vjemů",
                    false
                ),
                PsychologyTermAnswer("vnímání řeči",
                    false
                ),
                PsychologyTermAnswer("hmatovém vnímání",
                    false
                ),
                PsychologyTermAnswer("zrakovém vnímání hloubky",
                    false
                ),
            ),
            questionNumber = 122,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Autokinetický efekt je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "zraková iluze vznikající při pohybu vnímatele vůči stacionárnímu objektu",
                    false
                ),
                PsychologyTermAnswer(
                    "iluzorní vjem pohybu za zvláštních světelných podmínek",
                    false
                ),
                PsychologyTermAnswer(
                    "zraková iluze vznikající při pohybu vnímatele vůči objektu v protipohybu",
                    false
                ),
                PsychologyTermAnswer(
                    "iluze vznikající následkem očního pohybu při náhlém překvapení",
                    false
                ),
            ),
            questionNumber = 123,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Samovolné střídání figury a pozadí ve vjemu nastává při vnímání",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("střídavých obrazců",
                    false
                ),
                PsychologyTermAnswer("tranzitivních figur",
                    false
                ),
                PsychologyTermAnswer("reverzních terčíků",
                    false
                ),
                PsychologyTermAnswer("reverzibiních figur",
                    false,
                    "Reverzibilní figura – střídání figury a pozadí."
                ),
            ),
            questionNumber = 124,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Sledujeme-li např. železniční semafor, máme dojem, že světlo při střídání lamp \npřechází\" z jedné strany na druhou. Tento jev se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("ksi-efekt",
                    false
                ),
                PsychologyTermAnswer("fi-fenomén",
                    false,
                    "Gestalt psychologie. Pokud diody blikají za sebou dostatečně rychle (30ms), tak to působí jako by se hýbaly."
                ),
                PsychologyTermAnswer("psí-fenomén",
                    false
                ),
                PsychologyTermAnswer("kinetický efekt",
                    false
                ),
            ),
            questionNumber = 125,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Efekt \"cocktail party\" ukazuje, že sluchový systém",
            textAnswer = "Dokážeme odfiltrovat ostatní podněty/stimuli pokud se soustředíme na jeden konkrétní. Například konverzace v klubu.",
            answers = listOf(
                PsychologyTermAnswer(
                    "zpracovává i signály, kterým právě nevěnujeme pozornost",
                    false,
                    "Zpracováváme je, nicméně je poté ignorujeme."
                ),
                PsychologyTermAnswer(
                    "zpracovává řeč a jiné zvukové podněty samostatně",
                    false
                ),
                PsychologyTermAnswer(
                    "mění citlivost k některým frekvencim pod vlivem alkoholu",
                    false
                ),
                PsychologyTermAnswer(
                    "v hlučném prostředí funguje hůře než v prostředí tichém",
                    false
                ),
            ),
            questionNumber = 126,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "V teoriích myšlení se nepoužívá pojem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("abstrakce",
                    false
                ),
                PsychologyTermAnswer("pojem",
                    false
                ),
                PsychologyTermAnswer("generealizace",
                    false
                ),
                PsychologyTermAnswer("projekce",
                    false
                ),
            ),
            questionNumber = 127,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Se schématem \"S-O-R\" se setkáváme",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("v teorii podmiňování",
                    false
                ),
                PsychologyTermAnswer("v neobehaviorismu",
                    false
                ),
                PsychologyTermAnswer("v ranném behaviorismu",
                    false
                ),
                PsychologyTermAnswer("v modelech pozornosti",
                    false
                ),
            ),
            questionNumber = 128,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Při hledání nového řešení technického problému se uplatňuje především",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("divergentní myšlení",
                    false,
                    "Divergentní myšlení je sbíhavý vznik nových řešení na problém (ADHD)."
                ),
                PsychologyTermAnswer("konvergentní myšlení",
                    false,
                    "Opak divergentního myšlení"
                ),
                PsychologyTermAnswer("technické myšlení",
                    false
                ),
                PsychologyTermAnswer("používání analytických operací",
                    false
                ),
            ),
            questionNumber = 129,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Usuzování, při kterém dospíváme logickými kroky k závěru, jenž je obsažen v premisách, se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("abstrakce",
                    false
                ),
                PsychologyTermAnswer("atribuce",
                    false,
                    "Kognitivní proces přisuzování jedné či více příčin vlastnímu chování a chování jiných lidí." +
                        " Dělí se na vnější a vnitřní."
                ),
                PsychologyTermAnswer("indukce",
                    false,
                    "(z lat. in-ducere, vyvozovat) - od jedinečného k obecnému"
                ),
                PsychologyTermAnswer("dedukce",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
            ),
            questionNumber = 130,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Které místo na sítnici zajišťuje nejostřejší vidění?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("oblast kolem spojnice žluté a slepé skvrny",
                    false
                ),
                PsychologyTermAnswer("okruh receptorů asi 250 od centrální jamky",
                    false
                ),
                PsychologyTermAnswer("centrální jamka uprostřed žluté skvrny",
                    false
                ),
                PsychologyTermAnswer("slepá skvrna",
                    false
                ),
            ),
            questionNumber = 131,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podráždění receptorových buněk se označuje také jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("stimulace",
                    false
                ),
                PsychologyTermAnswer("inhibice",
                    false
                ),
                PsychologyTermAnswer("facilitace",
                    false,
                    "sociální facilitace - vliv přítomnosti jiných osob na výkon jedince"
                ),
                PsychologyTermAnswer("iritabilita",
                    false,
                    "Tohle není test biologie, tady se spíše mluví o \"excitation\""
                ),
            ),
            questionNumber = 132,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Při subliminální percepci",
            textAnswer = "(Podprahová percepce) Opak supraliminální. Např. subliminální percepce etnických skupin.",
            answers = listOf(
                PsychologyTermAnswer(
                    "si jedinec neuvědomuje povahu podnětu, ale pociťuje excitaci svých smyslových buněk",
                    false
                ),
                PsychologyTermAnswer(
                    "si jedinec neuvědomuje existenci podnětu, ten však přesto nějak působí na jeho psychiku",
                    false
                ),
                PsychologyTermAnswer(
                    "nepociťuje jedinec rozdíl oproti normálnímu vnímání",
                    false
                ),
                PsychologyTermAnswer(
                    "si jedinec uvědomuje existenci slabého podnětu, ale neuvědomuje si jeho působení na svou psychiku",
                    false
                ),
            ),
            questionNumber = 133,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pro operantní podmiňování je charakteristické",
            textAnswer = "Skinner",
            answers = listOf(
                PsychologyTermAnswer(
                    "habituace",
                    false,
                    "(přivykání) – na základě zkušenosti se sníží reakce a jedinec posléze přestane reagovat na podněty, které nepředstavují nebezpečí"
                ),
                PsychologyTermAnswer(
                    "učení pokusem a omylem",
                    false,
                    "Edward Lee Thorndike, trial-and-error, cat experiment."
                ),
                PsychologyTermAnswer("generalizace",
                    false,
                    "Klasické podmiňování." +
                        "Generalizace (zobecňování) - Reflexivní reakci vyvolávají podněty, které se podobají původnímu podmíněnému"
                ),
                PsychologyTermAnswer(
                    "učení vhledem",
                    false,
                    "Gestalt Psychologie. Wertheimer, Kohler\n" +
                        "Spontánní pochopení problému v dané situaci - najednou má člověk nadhled."
                ),
            ),
            questionNumber = 134,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "V behaviorismu znamenal termín intervenující proměnná",
            textAnswer = "E.C.Tolman - neobehaviourismus. Není to pouhé S-R, ale jsou tu další faktory jako dědičnost, minulá zkušenost a zralost.",
            answers = listOf(
                PsychologyTermAnswer(
                    "vlastnosti organismu, které zprostředkovávají vztah mezi podnětem a odpovědí",
                    false
                ),
                PsychologyTermAnswer(
                    "nežádoucí osobní vliv experimentátorova posuzování výsledků experimentu",
                    false
                ),
                PsychologyTermAnswer(
                    "rušivou proměnnou, která bránila stanovení jednoznačného vztahu mezi podnětem a odpovědí",
                    false
                ),
                PsychologyTermAnswer(
                    "vliv zvláštní situace psychologického experimentu na normální podobu vztahu mezi podnětem a reakci",
                    false
                ),
            ),
            questionNumber = 135,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Které smysly jsou založeny na zpracování informací z chemoreceptorů?",
            textAnswer = "Specialized sense receptors, such as those in the eyes, ears and nose, that respond to distant external stimuli." +
                "\n\t-Fotoreceptory - světlo, tyčinky a čípky" +
                "\n\t-Mechanoreceptory - tlak, vibrace, dotyk, sluch" +
                "\n\t-Termoreceptory - teplota" +
                "\n\t-Chemoreceptory - chemikalie, hladina kyslíku, chuť a čich" +
                "\n\t-Nociceptory - poskozeni tkaniny -> bolest," +
                "\n\t-Baroreceptory - tlak krve" +
                "\n\tElektromagnetické receptory",
            answers = listOf(
                PsychologyTermAnswer("hmat a sluch",
                    false,
                    "Mechanoreceptory"
                ),
                PsychologyTermAnswer("chuť a čich",
                    false
                ),
                PsychologyTermAnswer("zrak a sluch",
                    false
                ),
                PsychologyTermAnswer("chuť, čich a hmat",
                    false
                ),
            ),
            questionNumber = 136,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Které smysly jsou založeny na zpracování informací z mechanoreceptorů?",
            textAnswer = "Specialized sense receptors, such as those in the eyes, ears and nose, that respond to distant external stimuli." +
                "\n\t-Fotoreceptory - světlo, tyčinky a čípky" +
                "\n\t-Mechanoreceptory - tlak, vibrace, dotyk, sluch" +
                "\n\t-Termoreceptory - teplota" +
                "\n\t-Chemoreceptory - chemikalie, hladina kyslíku, chuť a čich" +
                "\n\t-Nociceptory - poskozeni tkaniny -> bolest," +
                "\n\t-Baroreceptory - tlak krve" +
                "\n\tElektromagnetické receptory",
            answers = listOf(
                PsychologyTermAnswer("zrak a sluch",
                    false
                ),
                PsychologyTermAnswer("hmat, sluch a statokinetický smysl",
                    false,
                    "Mechanoreceptory jsou základem sluchového ústrojí - mechanické podráždění."
                ),
                PsychologyTermAnswer("pouze statokinetický smysl",
                    false,
                    "Statokinetický smysl (rovnovážné ústrojí) - reakce na polohu a horizontální/vertikální pohyby hlavy"
                ),
                PsychologyTermAnswer("pouze hmat",
                    false
                ),
            ),
            questionNumber = 137,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Dispozičním protějškem myšlení je",
            textAnswer = "V tomhle kontextu se jedná o doplněk, ne opak.",
            answers = listOf(
                PsychologyTermAnswer("inteligence",
                    false
                ),
                PsychologyTermAnswer("rozum",
                    false
                ),
                PsychologyTermAnswer("atrakce",
                    false
                ),
                PsychologyTermAnswer("konvergence",
                    false
                ),
            ),
            questionNumber = 138,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Teorie prototypů chápe pojmy především jako",
            textAnswer = "Prototype theory is a cognitive psychological theory that suggests that when people categorize objects," +
                " they do so based on how similar the object is to a prototypical (or ideal) example of that category." +
                "\nOftentimes it is not clear if an object has all of the necessary defining features for membership in a category," +
                " and people are often able to categorize objects even when they do not have all of the necessary features.",
            answers = listOf(
                PsychologyTermAnswer(
                    "základní nástroj hodnocení sociálních situací",
                    false
                ),
                PsychologyTermAnswer("zobecnění zkušenosti jedince",
                    false
                ),
                PsychologyTermAnswer(
                    "kategorie s jednoznačným určením příslušnosti",
                    false
                ),
                PsychologyTermAnswer(
                    "neostré (fuzzy) množiny",
                    false
                ),
            ),
            questionNumber = 139,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jako intencionální nebývají z podstaty své definice chápány:",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("nálada",
                    false,
                    "Nějak se cítím špatně, nevím ani proč. Třeba to je počasím." +
                        "\nDéletrvající pohotovost k emočním reakcím určitého směru."
                ),
                PsychologyTermAnswer("city",
                    false
                ),
                PsychologyTermAnswer("afekty",
                    false,
                    "intenzivní emoce, vzniká náhle, prudce a má konkrétní zaměření"
                ),
                PsychologyTermAnswer("nálady, afekty i city jsou intencionální",
                    false
                ),
            ),
            questionNumber = 140,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Heuristika je",
            textAnswer = "Jako takový trial-and-error (Thorndike), ale často o tom již máme nějaké informace, jen si nejsme jisti a prostě něco zkusíme.",
            answers = listOf(
                PsychologyTermAnswer(
                    "metoda a postup uplatňující se při hledání nových řešení",
                    false
                ),
                PsychologyTermAnswer(
                    "specificky lidský přístup ke zpracování informace",
                    false
                ),
                PsychologyTermAnswer(
                    "automatický proces vnitřního myšlenkového vyhodnocování pravděpodobnosti",
                    false
                ),
                PsychologyTermAnswer("kybernetická obdoba abstrakce",
                    false
                ),
            ),
            questionNumber = 141,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pojmy \"první prezident České republiky\" a \"Václav Havel\" se liší svou",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("extenzi",
                    false,
                    "rozsah pojmu znamená souhrn všech věcí, jež pod tento pojem spadají"
                ),
                PsychologyTermAnswer("elaboraci",
                    false,
                    "zpracování"
                ),
                PsychologyTermAnswer("intenzí",
                    false,
                    "smysl pojmu je jeho obsah"
                ),
                PsychologyTermAnswer("neliší se",
                    false
                ),
            ),
            questionNumber = 142,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mentální model je forma mentální",
            textAnswer = "Mentální model - v konextu mentální reprezentace to nějaká propozice a představa o nějakém podnětu." +
                " Např. jak fungují vzorečky ve fyzice, historie našich předků.",
            answers = listOf(
                PsychologyTermAnswer("psychodynamická reprezentace",
                    false,
                    "Představa = mentální reprezentace vnějšího světa, dostává se z dlouhodobé paměti (předvědomí) -S.Freud."
                ),
                PsychologyTermAnswer("smíšená forma mentální reprezentace",
                    false
                ),
                PsychologyTermAnswer("propoziční forma mentální reprezentace",
                    false,
                    "(Jazyková) - popis jevů v abstraktní rovině, lze rozdělit na symboly"
                ),
                PsychologyTermAnswer("obrazová forma mentální reprezentace",
                    false,
                    "(analogová, imaginativní) Nerozkládá se na další prvky, prostě je."
                ),
            ),
            questionNumber = 143,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mentální model je forma mentální",
            textAnswer = "Mentální model - v konextu mentální reprezentace to nějaká propozice a představa o nějakém podnětu." +
                " Např. jak fungují vzorečky ve fyzice, historie našich předků.",
            answers = listOf(
                PsychologyTermAnswer("psychodynamická reprezentace",
                    false,
                    "Představa = mentální reprezentace vnějšího světa, dostává se z dlouhodobé paměti (předvědomí) -S.Freud."
                ),
                PsychologyTermAnswer("smíšená forma mentální reprezentace",
                    false
                ),
                PsychologyTermAnswer("propoziční forma mentální reprezentace",
                    false,
                    "(Jazyková) - popis jevů v abstraktní rovině, lze rozdělit na symboly"
                ),
                PsychologyTermAnswer("analogová forma mentální reprezentace",
                    false,
                    "(obrazová, imaginativní) Nerozkládá se na další prvky, prostě je."
                ),
            ),
            questionNumber = 143,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Propoziční mentální reprezentace je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("smíšený model",
                    false,
                    "obsahuje obojí - propoziční a představy (analogové)"
                ),
                PsychologyTermAnswer("jazyková",
                    false,
                    "propoziční mentální reprezentace (Jazyková) - popis jevů v abstraktní rovině, lze rozdělit na symboly"
                ),
                PsychologyTermAnswer("obrazová",
                    false,
                    "analogová mentální reprezentace (obrazová, imaginativní) Nerozkládá se na další prvky, prostě je."
                ),
            ),
            questionNumber = 143,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Analogová mentální reprezentace je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("smíšený model",
                    false,
                    "obsahuje obojí - propoziční a představy (analogové)"
                ),
                PsychologyTermAnswer("obrazová",
                    false,
                    "analogová mentální reprezentace (obrazová, imaginativní) Nerozkládá se na další prvky, prostě je."
                ),
                PsychologyTermAnswer("jazyková",
                    false,
                    "propoziční mentální reprezentace (Jazyková) - popis jevů v abstraktní rovině, lze rozdělit na symboly"
                ),
            ),
            questionNumber = 143,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Efekt orientace znamená",
            textAnswer = "mentální reprezentace, kognitivní mapa",
            answers = listOf(
                PsychologyTermAnswer("dokážeme určit, kde se v kognitivní mapě nacházíme",
                    false,
                    "efekt oriantace"
                ),
                PsychologyTermAnswer("slouží nám k informacím o akci",
                    false,
                    "mapa tras (route map), např. jak dojít z bodu A do bodu B pěšky"
                ),
                PsychologyTermAnswer("slouží k informacím prostorového typu",
                    false,
                    "průzkumná mapa (survey map), jako kdybych navigovali v Google street view"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve vztahu k nám samotným",
                    false,
                    "egocentrická reprezentace prostoru, parietální kůra"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve světě",
                    false,
                    "alocentrická reprezentace prostoru, hipokampus"
                ),
            ),
            questionNumber = 143,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mapa tras znamená",
            textAnswer = "mentální reprezentace, kognitivní mapa",
            answers = listOf(
                PsychologyTermAnswer("slouží nám k informacím o akci",
                    false,
                    "mapa tras (route map), např. jak dojít z bodu A do bodu B pěšky"
                ),
                PsychologyTermAnswer("dokážeme určit, kde se v kognitivní mapě nacházíme",
                    false,
                    "efekt oriantace"
                ),
                PsychologyTermAnswer("slouží k informacím prostorového typu",
                    false,
                    "průzkumná mapa (survey map), jako kdybych navigovali v Google street view"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve vztahu k nám samotným",
                    false,
                    "egocentrická reprezentace prostoru, parietální kůra"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve světě",
                    false,
                    "alocentrická reprezentace prostoru, hipokampus"
                ),
            ),
            questionNumber = 143,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Ostrakismus znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("vyloučení jedince z určité sociální skupiny",
                    false,
                    ""
                ),
                PsychologyTermAnswer("skandalizace jedince",
                    false,
                    ""
                ),
                PsychologyTermAnswer("totéž co šikana",
                    false,
                    ""
                ),
            ),
            questionNumber = 143,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Interpozice znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("překrývání objektů v percepčním poli",
                    false,
                    "interpozice"
                ),
                PsychologyTermAnswer("přibližování rovnoběžných linií ve větší vzdálenosti",
                    false,
                    "lineární perspektiva"
                ),
                PsychologyTermAnswer("vzdálené objekty vidíme méně jasně a v bleších barvách (kouř, prach, smog)",
                    false,
                    "atmosférická perspektiva"
                ),
                PsychologyTermAnswer("u 2 známých předmětů – menší vnímáme jako vzdálenější",
                    false,
                    "relativní velikost"
                ),
                PsychologyTermAnswer("u 2 známých předmětů – ten který je výš je vnímán jako vzdálenější",
                    false,
                    "relativní výška (výška umístění)"
                ),
                PsychologyTermAnswer("přejíždíme-li zrakem po určité scenérii – dochází ke změnám vnímané členitosti povrchu, velikosti objektů a hustoty jejich rozmístění",
                    false,
                    "gradient/ spád struktury (Gibson)"
                ),
                PsychologyTermAnswer("rozdíl v rychlosti a směru pohybů objektů, které sledujeme z jedoucího dopravního prostředku",
                    false,
                    "pohybová paralaxa"
                )
            ),
            questionNumber = 143,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Průzkumná mapa znamená",
            textAnswer = "mentální reprezentace, kognitivní mapa",
            answers = listOf(
                PsychologyTermAnswer("slouží k informacím prostorového typu",
                    false,
                    "průzkumná mapa (survey map), jako kdybych navigovali v Google street view"
                ),
                PsychologyTermAnswer("slouží nám k informacím o akci",
                    false,
                    "mapa tras (route map), např. jak dojít z bodu A do bodu B pěšky"
                ),
                PsychologyTermAnswer("dokážeme určit, kde se v kognitivní mapě nacházíme",
                    false,
                    "efekt oriantace"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve vztahu k nám samotným",
                    false,
                    "egocentrická reprezentace prostoru, parietální kůra"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve světě",
                    false,
                    "alocentrická reprezentace prostoru, hipokampus"
                ),
            ),
            questionNumber = 143,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Egocentrická reprezentace prostoru znamená",
            textAnswer = "mentální reprezentace, kognitivní mapa",
            answers = listOf(
                PsychologyTermAnswer("kde se daný objekt nachází ve vztahu k nám samotným",
                    false,
                    "egocentrická reprezentace prostoru, parietální kůra"
                ),
                PsychologyTermAnswer("slouží k informacím prostorového typu",
                    false,
                    "průzkumná mapa (survey map), jako kdybych navigovali v Google street view"
                ),
                PsychologyTermAnswer("slouží nám k informacím o akci",
                    false,
                    "mapa tras (route map), např. jak dojít z bodu A do bodu B pěšky"
                ),
                PsychologyTermAnswer("dokážeme určit, kde se v kognitivní mapě nacházíme",
                    false,
                    "efekt oriantace"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve světě",
                    false,
                    "alocentrická reprezentace prostoru, hipokampus"
                ),
            ),
            questionNumber = 143,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Alocentrická reprezentace prostoru znamená",
            textAnswer = "mentální reprezentace, kognitivní mapa",
            answers = listOf(
                PsychologyTermAnswer("kde se daný objekt nachází ve světě",
                    false,
                    "alocentrická reprezentace prostoru, hipokampus"
                ),
                PsychologyTermAnswer("kde se daný objekt nachází ve vztahu k nám samotným",
                    false,
                    "egocentrická reprezentace prostoru, parietální kůra"
                ),
                PsychologyTermAnswer("slouží k informacím prostorového typu",
                    false,
                    "průzkumná mapa (survey map), jako kdybych navigovali v Google street view"
                ),
                PsychologyTermAnswer("slouží nám k informacím o akci",
                    false,
                    "mapa tras (route map), např. jak dojít z bodu A do bodu B pěšky"
                ),
                PsychologyTermAnswer("dokážeme určit, kde se v kognitivní mapě nacházíme",
                    false,
                    "efekt oriantace"
                ),
            ),
            questionNumber = 143,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Řešení problémů vhledem se zakládá",
            textAnswer = "Gestalt Psychologie. Wertheimer, Kohler\n" +
                "Spontánní pochopení problému v dané situaci - najednou má člověk nadhled.",
            answers = listOf(
                PsychologyTermAnswer("na restrukturaci problémové situace",
                    false
                ),
                PsychologyTermAnswer(
                    "na postupném vylučování nepodstatných aspektů",
                    false
                ),
                PsychologyTermAnswer("na manipulaci vizuální představy",
                    false
                ),
                PsychologyTermAnswer("na konkretizaci vizuální představy",
                    false
                ),
            ),
            questionNumber = 144,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mentálština znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "jazyk naší mysli, který nám pomáhá pochopit jazyk",
                    false,
                    "Fodor (1994)"
                ),
                PsychologyTermAnswer("jazyk, kterým komunikují děti",
                    false
                ),
                PsychologyTermAnswer("myšlenková jazyková rovina mezi klientem a terapeutem",
                    false
                ),
                PsychologyTermAnswer("konkretizace vizuální představy",
                    false
                ),
            ),
            questionNumber = 144,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Představa je vždy",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("doprovázena emocemi",
                    false
                ),
                PsychologyTermAnswer("prožívána vnitřně",
                    false
                ),
                PsychologyTermAnswer("ovlivněna fantazií",
                    false
                ),
                PsychologyTermAnswer("redukovatelná na propoziční obsah",
                    false
                ),
            ),
            questionNumber = 145,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podle R. B. Cattella je především zkušeností a vzděláním ovlivňována",
            textAnswer = "16 osobnostních faktorů, CFIT - kulturně inkluzivní test kognitivních schopností." +
                "\nDynamické motivační rysy:" +
                "\n\tErgy - instinkt/drive - vztek, hlad, sex, zvědavost" +
                "\n\tSentimenty - naučené- prostředí" +
                "\n\tPostoje - zájmy, emoce" +
                "\nInteligence:" +
                "\n\tFluidní (tekutá) - adaptivní, abstraktní, biologicky ovlivněné kognitivní schopnosti" +
                "\n\tKrystalická - zkušenosti, znalosti" +
                "\nL-Data (life data), T-Data (experimentální), Q-Data (dotazníky)",
            answers = listOf(
                PsychologyTermAnswer("empirická inteligence",
                    false
                ),
                PsychologyTermAnswer("inteligence jako celek",
                    false
                ),
                PsychologyTermAnswer("krystalizovaná inteligence",
                    false,
                    "Založena na zkušenostech, znalostech a naučených dovednostech."
                ),
                PsychologyTermAnswer("fluidní inteligence",
                    false,
                    "Vrozená schopnost se učit, jakýsi potenciál, který je možnosti kdykoli aktivovat."
                ),
            ),
            questionNumber = 146,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        // ani v papirove forme nebylo podtrzeni
        /*PsychologyTerm(
            prompt = "Ve které z následujících vět jsou podtrženy všechny jmenné fráze (jmenná syntagmata)?",
            textAnswer = "Syntagma - spojení nejméně dvou obvykle různých jazykových jednotek téže roviny jazyka v jeden celek na základě jejich kompatibility.",
            answers = listOf(
                PsychologyTermAnswer(
                    "Šedivý kocourek podrápal toho rozmrzelého starého psychologa.",
                    false
                ),
                PsychologyTermAnswer(
                    "Šedivý kocourek podrápal toho rozmrzelého starého psychologa.",
                    false
                ),
                PsychologyTermAnswer(
                    "Šedivý kocourek podrápal toho rozmrzelého starého psychologa.",
                    false
                ),
                PsychologyTermAnswer(
                    "Šedivý kocourek podrápal toho rozmrzelého starého psychologa.",
                    false
                ),
            ),
            questionNumber = 147,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),*/
        PsychologyTerm(
            prompt = "Dlouhodobé neuspokojování potřeb vyvolává stav",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("deprese",
                    false
                ),
                PsychologyTermAnswer("frustrace",
                    false,
                    "Spíše neúspěch. Například naučená bezmocnost (Seligman)."
                ),
                PsychologyTermAnswer("deprivace",
                    false
                ),
                PsychologyTermAnswer("obstrukce",
                    false
                ),
            ),
            questionNumber = 148,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín ustanovka v Uznadzeho teorii označuje",
            textAnswer = "Synonymum je zaměřenost. Ustanovka se může upevňovat opakováním vlivů, ve kterých byla vytvořena." +
                "Obsahem vzájemného působení konkrétní potřeby a situace, v níž se potřeba uspokojuje",
            answers = listOf(
                PsychologyTermAnswer(
                    "výběrovou zaměřenost na interakci s některými jedinci",
                    false
                ),
                PsychologyTermAnswer(
                    "náhlé zablokování činnosti během cílené aktivity",
                    false
                ),
                PsychologyTermAnswer(
                    "stav zaměřenosti a pohotovosti k určitému chování",
                    false
                ),
                PsychologyTermAnswer(
                    "základní úroveň motivačně charakterového nastavení osobnosti",
                    false
                ),
            ),
            questionNumber = 149,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Existují pojetí motivace, která kladou důraz na její funkci",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("existují obě",
                    false
                ),
                PsychologyTermAnswer("neexistuje ani jedno",
                    false
                ),
                PsychologyTermAnswer("energizující",
                    false
                ),
                PsychologyTermAnswer("řídici",
                    false
                ),
            ),
            questionNumber = 150,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín vigilita označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("zvýšenou aktivaci",
                    false
                ),
                PsychologyTermAnswer(
                    "stav bdělosti a připravenosti zpracovávat podněty",
                    false
                ),
                PsychologyTermAnswer("schopnost dlouhodobého bdění",
                    false
                ),
                PsychologyTermAnswer("stav koncentrace pozornosti",
                    false
                ),
            ),
            questionNumber = 151,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín olfakce znamená",
            textAnswer = "Od anglického slova olfactory - čich.",
            answers = listOf(
                PsychologyTermAnswer("nic z uvedeného",
                    false
                ),
                PsychologyTermAnswer("chut'",
                    false
                ),
                PsychologyTermAnswer("detekci stavu vnitřního prostředí",
                    false
                ),
                PsychologyTermAnswer("čich",
                    false
                ),
            ),
            questionNumber = 152,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Když se termín vigilance používá v odlišném významu od termínu vigilita, znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "míru schopnosti zachytit sporadicky (občasný) se vyskytující signály během delšího časového úseku",
                    false
                ),
                PsychologyTermAnswer("připravenost ke zvýšení aktivace",
                    false
                ),
                PsychologyTermAnswer(
                    "stav koncentrace pozornosti vedoucí ke ztrátě normálního vědomí",
                    false
                ),
                PsychologyTermAnswer("termín se nepoužívá",
                    false
                ),
            ),
            questionNumber = 153,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Úloha s dichotickým poslechem je úloha,",
            textAnswer = "Dichotomy - odlišnost.",
            answers = listOf(
                PsychologyTermAnswer(
                    "kdy se jako podnětový materiál používá stereofonní nahrávka přirozených zvuků",
                    false
                ),
                PsychologyTermAnswer(
                    "kdy je osobě do každého ucha prezentován jiný zvukový signál",
                    false
                ),
                PsychologyTermAnswer(
                    "při níž se bezprostředně za sebou prezentují dvojice zvukových podnětů",
                    false
                ),
                PsychologyTermAnswer(
                    "při níž se bezprostředně za sebou prezentují dvojice řečových podnětů",
                    false
                ),
            ),
            questionNumber = 154,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Sakadické pohyby jsou",
            textAnswer = "Velmi rychlé pohyby, které umožňují nasměrování oka tak, aby se vnímání objektu stalo co nejostřejším.",
            answers = listOf(
                PsychologyTermAnswer("oční pohyby v non-REM spánku",
                    false
                ),
                PsychologyTermAnswer("jeden typ očních pohybů",
                    false
                ),
                PsychologyTermAnswer(
                    "oční pohyby doprovázející aktivitu, která nemůže být vizuálně sledována",
                    false
                ),
                PsychologyTermAnswer("oční pohyby obecně",
                    false
                ),
            ),
            questionNumber = 155,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Hladina vědomí ve stavu alfa",
            textAnswer = "Alfa je nižší frekvece než Beta, která se vyskytuje když se člověk hodně soustředí nebo je ve stresu.",
            answers = listOf(
                PsychologyTermAnswer("se vyznačuje lehce sníženou bdělostí",
                    false
                ),
                PsychologyTermAnswer("je typická pro snění",
                    false
                ),
                PsychologyTermAnswer("se vyskytuje po převážnou část dne",
                    false
                ),
                PsychologyTermAnswer("je typická pro tzv. bdělý odpočinek",
                    false
                ),
            ),
            questionNumber = 156,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Konstantnost velikosti ve vnímání znamená",
            textAnswer = "Umožňuje vnímat tvar, barvu, jas a velikost jako stálé. Nezávisle na vzdálenosti, změně osvětlení či úhlu pohledu.",
            answers = listOf(
                PsychologyTermAnswer(
                    "předměty ve stejné vzdálenosti máme tendenci vnímat jako stejně velké",
                    false
                ),
                PsychologyTermAnswer(
                    "umístěním předmětů do různých vzdáleností můžeme dosáhnout toho, že se nám předměty jeví jako stejně velké",
                    false
                ),
                PsychologyTermAnswer(
                    "stejný předmět vnímáme jako stejně velký, i když velikost sítnicového obrazu se mění",
                    false
                ),
                PsychologyTermAnswer(
                    "při různé úrovni osvětlení si za vhodných podmínek uchováváme stejný vjem velikosti předmětu",
                    false
                ),
            ),
            questionNumber = 157,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Podle hypotézy lingvistického relativismu",
            textAnswer = "(Sapir-Whorf hypotéza, Whorfianism) lidé mluvící odlišnými jazyky, mají odlišené kognitivní systémy, tudíž vnímání světa.",
            answers = listOf(
                PsychologyTermAnswer(
                    "je možné rozložit význam slova do série binárních opozic",
                    false
                ),
                PsychologyTermAnswer(
                    "má gramatika i slovní zásoba jazyka významný vliv na chápání světa",
                    false
                ),
                PsychologyTermAnswer(
                    "není možné porovnávat různé jazyky, protože neexistuje společný vztažný systém",
                    false
                ),
                PsychologyTermAnswer(
                    "jsou různé jazyky tvarovány v závislosti na struktuře vnějšího světa",
                    false
                ),
            ),
            questionNumber = 158,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Foném je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "zvuk, jehož záměnou ve výrazu určitého jazyka se změní i význam",
                    false,
                    "Nejmenší součást zvukové stránky řeči a má v jazyce rozlišovací funkci."
                ),
                PsychologyTermAnswer(
                    "grafické zachycení zvukových charakteristik hlásky",
                    false
                ),
                PsychologyTermAnswer(
                    "grafický znak, který lze v písemném záznamu určitého jazyka zaměnit, aniž by se změnil význam",
                    false
                ),
                PsychologyTermAnswer("zvukový protějšek písmene",
                    false
                ),
            ),
            questionNumber = 159,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Sémantika se zabývá",
            textAnswer = "Vztah mezi znaky a jejich významy",
            answers = listOf(
                PsychologyTermAnswer("větnou skladbou",
                    false
                ),
                PsychologyTermAnswer("pojmotvornými procesy",
                    false
                ),
                PsychologyTermAnswer("významem",
                    false
                ),
                PsychologyTermAnswer("tvaroslovím",
                    false
                ),
            ),
            questionNumber = 160,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Doprovodný, vedlejší význam slova (např. citové zabarvení) se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("exprese",
                    false
                ),
                PsychologyTermAnswer("imprese",
                    false
                ),
                PsychologyTermAnswer("denotace",
                    false,
                    "Základní exaktní význam znaku, slova či věty"
                ),
                PsychologyTermAnswer("konotace",
                    false,
                    "Opak od denotace - hlubší nebo symbolické významy znaku, slova či věty"
                ),
            ),
            questionNumber = 161,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Který z uvedených termínů nepatří mezi ostatní tři?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("aktivace",
                    false
                ),
                PsychologyTermAnswer("incentiva",
                    false
                ),
                PsychologyTermAnswer(
                    "motivace",
                    false,
                    "Soubor motivů k určitému jednání. (Motiv - uvědomělé podněty vyvolávající uspokojení potřeb.)"
                ),
                PsychologyTermAnswer("drive",
                    false
                ),
            ),
            questionNumber = 162,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Ve známém experimentu řešily pokusné osoby řadu úkolů. " +
                "Při práci na některých z nich byly přerušeny před dokončením. V pamět'ovém testu si lépe vybavovaly",
            textAnswer = "Zeigarnik efekt - lidé si spíše pamatují nedokončené věci, než-li již dokončené. Pod supervizí Lewina (Gestalt).",
            answers = listOf(
                PsychologyTermAnswer("dokončené úkoly",
                    false
                ),
                PsychologyTermAnswer("nebyly zaznamenány významné rozdíly",
                    false
                ),
                PsychologyTermAnswer("nedokončené úkoly",
                    false
                ),
                PsychologyTermAnswer("vhodně formulované úkoly",
                    false
                ),
            ),
            questionNumber = 163,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Jedna část pokusných osob měla za úkol naučit se seznam slov pod vodou, druhá na souši." +
                " Po určitém čase byly testovány na úroveň zapamatování, a to opět buď pod vodou, nebo na souši. Lepšího vybavení dosáhly osoby, které byly testovány",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    "v opačném prostředí, než kde se učily seznam slov",
                    false
                ),
                PsychologyTermAnswer("výsledky byly shodné",
                    false
                ),
                PsychologyTermAnswer("na souši",
                    false
                ),
                PsychologyTermAnswer(
                    "ve stejném prostředí, kde se seznam slov učily",
                    false
                ),
            ),
            questionNumber = 164,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín deja vu označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("iluzi již viděného",
                    false
                ),
                PsychologyTermAnswer("vznik důvěrného vztahu",
                    false
                ),
                PsychologyTermAnswer("zrcadlový percepční klam",
                    false
                ),
                PsychologyTermAnswer("iluzi nikdy neviděného",
                    false
                ),
            ),
            questionNumber = 165,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Pojem indukce označuje",
            textAnswer = "(z lat. in-ducere, vyvozovat) - od jedinečného k obecnému",
            answers = listOf(
                PsychologyTermAnswer(
                    "vyvstávání emočniho procesu, který způsobuje zahlcení kapacit kognitivního systému",
                    false
                ),
                PsychologyTermAnswer("abstraktní usuzování",
                    false,
                    "Teorie abstraktních pravidel (mentální logiky) - lidi jsou racionální, pouze špatně chápají, či si vykládají otázky."
                ),
                PsychologyTermAnswer(
                    "myšlenkovou operaci, při které ze zkušenosti či pozorování vyvozujeme pravidlo",
                    false
                ),
                PsychologyTermAnswer("samovolný vznik vjemů na sítnici",
                    false
                ),
            ),
            questionNumber = 166,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Kognitivní psychologie",
            textAnswer = "Zkoumá způsob vnímání a zpracování informací dodaných smyslovými orgány",
            answers = listOf(
                PsychologyTermAnswer("považuje za psychické jevy pouze jevy vědomé",
                    false
                ),
                PsychologyTermAnswer(
                    "se dívá na psychiku jako na systém zpracovávající informace",
                    false
                ),
                PsychologyTermAnswer("chápe myšlení jako základ lidského poznávání",
                    false
                ),
                PsychologyTermAnswer(
                    "se snaží vysvětlit všechny psychické procesy jako procesy poznávací",
                    false,
                    "psychické procesy - hodně krátkodobé, jedná se vlastně o zpracování určitých jevů a informací. \n" +
                        "Může se jednat o vnímání, paměť, představivost, učení či myšlení."
                ),
            ),
            questionNumber = 167,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Mezi metody zobrazování aktivit mozku nepatří:",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("ECT",
                    false
                ),
                PsychologyTermAnswer("EEG",
                    false
                ),
                PsychologyTermAnswer("PET",
                    false
                ),
                PsychologyTermAnswer("MRI",
                    false
                ),
            ),
            questionNumber = 168,
            correctAnswer = 0,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Interaurální časový rozdíl zahrnuje",
            textAnswer = "Jelikož jsme ke zdroji zvuku vždy otočení nějakou stranou - je rozdíl v úhlu pravého a levého ucha k zvuku." +
                " Tudíž ke každému uchu zvuk dojde v jiné rychlosti a my jsme schopni rozeznat z jakého směru zvuk přišel.",
            answers = listOf(
                PsychologyTermAnswer("fázový rozdíl",
                    false,
                    "Fáze zvukových vln - rozdíl mezi 2 stejnými body zvukových vln, které doletí na odlišené uši - rozeznáme rozdíl a víme odkud jde zvuk."
                ),
                PsychologyTermAnswer("obojí",
                    false
                ),
                PsychologyTermAnswer("ani jedno",
                    false
                ),
                PsychologyTermAnswer("rozdíl v začátku",
                    false
                ),
            ),
            questionNumber = 169,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "K vodítkům pro lokalizaci zdroje zvuku patří",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("Dopplerův efekt",
                    false,
                    "Dopplerův jev - změna frekvence a vlnové délky přijímaného oproti vysílanému vlnění - protože máme jinou rychlost než vysílač," +
                        " takže se to formuje."
                ),
                PsychologyTermAnswer("maskování",
                    false
                ),
                PsychologyTermAnswer("interaurální rozdíl intenzit",
                    false
                ),
                PsychologyTermAnswer("interaurální rozdíl kapacit",
                    false
                ),
            ),
            questionNumber = 170,
            correctAnswer = 2,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Co z uvedeného nepatří k ostatním?",
            textAnswer = "Motivace",
            answers = listOf(
                PsychologyTermAnswer("pudy",
                    false
                ),
                PsychologyTermAnswer("hlad",
                    false
                ),
                PsychologyTermAnswer("představa cíle",
                    false
                ),
                PsychologyTermAnswer("pozornost",
                    false
                ),
            ),
            questionNumber = 171,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Výška tónu, kterou slyšíme při přibližování tělesa, se změní, když se těleso začne vzdalovat. Je to v důsledku",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("Ehrenfelsova fenoménu",
                    false,
                    "Ch. Ehrenfels byl předchůdce gestaltu"
                ),
                PsychologyTermAnswer("takový rozdíl neexistuje",
                    false
                ),
                PsychologyTermAnswer("selektivní citlivosti",
                    false
                ),
                PsychologyTermAnswer("Dopplerova efektu",
                    false,
                    "Dopplerův jev - změna frekvence a vlnové délky přijímaného oproti vysílanému vlnění - protože máme jinou rychlost než vysílač," +
                        " takže se to formuje."
                ),
            ),
            questionNumber = 172,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Proaktivní interference je",
            textAnswer = "Též proaktivní inhibice",
            answers = listOf(
                PsychologyTermAnswer("obojí z uvedených",
                    false
                ),
                PsychologyTermAnswer(
                    "vliv, kterým později zapamatovaná informace ovlivňuje informaci zapamatovanou dříve",
                    false
                ),
                PsychologyTermAnswer("ani jedno z uvedených",
                    false
                ),
                PsychologyTermAnswer(
                    "vliv, kterým dříve zapamatovaná informace ovlivňuje informaci zapamatovanou později",
                    false
                ),
            ),
            questionNumber = 173,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Termínem apercepce se obvykle označuje",
            textAnswer = "K apercepci také řadíme priming: předcházející podnět, či situace ovlivní následující podnět.",
            answers = listOf(
                PsychologyTermAnswer("ani jedno z uvedených",
                    false
                ),
                PsychologyTermAnswer(
                    "závislost přijímání a zpracování informace (obv. při vnímání) na minulé zkušenosti",
                    false
                ),
                PsychologyTermAnswer("koncentrované vnímání",
                    false
                ),
                PsychologyTermAnswer("stav, kdy selhává funkce vnímání",
                    false
                ),
            ),
            questionNumber = 174,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "Zákon dobré figury patří",
            textAnswer = "Gestalt psychologie. Podle tohoto zákona vnímáme jako jeden celek ty podněty, které na sebe plynule navazují.",
            answers = listOf(
                PsychologyTermAnswer("k asociačním zákonům",
                    false
                ),
                PsychologyTermAnswer("k zákonům vnímání prostoru",
                    false
                ),
                PsychologyTermAnswer("ke všem uvedeným",
                    false
                ),
                PsychologyTermAnswer("ke gestalt-zákonům",
                    false
                ),
            ),
            questionNumber = 175,
            correctAnswer = 3,
            categoryId = "1. Obecná psychologie"
        ),
        PsychologyTerm(
            prompt = "K redukci disonance mezi různými kognitivními prvky (např. vědomí, že jsem kuřák a že kouření škodí zdraví) podle Festingera dochází:",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("jedním z obranných mechanismů ega",
                    false
                ),
                PsychologyTermAnswer(
                    "změnou nebo zmenšením významnosti některého prvku nebo zavedením nového prvku",
                    false
                ),
                PsychologyTermAnswer(
                    "prostřednictvím afektivní agrese, a to i v přesunuté podobě za cenu ztráty autenticity",
                    false
                ),
            ),
            questionNumber = 176,
            correctAnswer = 1,
            categoryId = "1. Obecná psychologie"
        ),
    )
}