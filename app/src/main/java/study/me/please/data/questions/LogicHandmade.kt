package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

object LogicHandmade {

    val logicPrompts = listOf(
        PsychologyTerm(
            prompt = "Výrazy které říkají, zdali je něco pravda či nepravda jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("výroky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("propozice",
                    false,
                    "myšlenky kterými jsou výroky vyjádřovány"
                ),
                PsychologyTermAnswer("vlastní jména",
                    false,
                    "výrazy označující právě jeden předmět z oblasti, o níž uvažujeme"
                ),
                PsychologyTermAnswer("obor úvahy",
                    false,
                    "oblast o níž uvažujeme"
                )
            ),
            categoryId = "Logika",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Predikáty jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům",
                    false,
                    "predikáty"
                ),
                PsychologyTermAnswer("výrazy které říkají, zdali je něco pravda či nepravda",
                    false,
                    "výroky"
                ),
                PsychologyTermAnswer("výrazy označující právě jeden předmět z oblasti, o níž uvažujeme",
                    false,
                    "vlastní jména"
                ),
                PsychologyTermAnswer("- a -, - nebo -, jestliže - pak -, - právě tehdy když",
                    false,
                    "logické spojky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Složené výroky",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vytvořením výroku ze spoje výroků pomocí logické spojky",
                    false,
                    "složené výroky, rozhoduje se pravdivostní hodnotě"
                ),
                PsychologyTermAnswer("výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům",
                    false,
                    "predikáty"
                ),
                PsychologyTermAnswer("- a -, - nebo -, jestliže - pak -, - právě tehdy když",
                    false,
                    "logické spojky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Pavel a Petr jsou doma\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("složené výroky",
                    false,
                    "vytvořením výroku ze spoje výroků pomocí logické spojky, rozhoduje se pravdivostní hodnotě"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Pavel nebo Petr je doma\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Není pravda, že Ondřej se starší než Eliška\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Jesliže Janě ujel vlak, pak přijede autobusem\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Jan přijel z Třeboně právě tehdy, když přijel z dovolené\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrokům, které jsou pravdivé vždy říkáme",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("tautologie",
                    false,
                    "\"Karel je doma nebo Karel není doma\" či \"Sylvie spí nebo nespí\""
                ),
                PsychologyTermAnswer("kontradikce",
                    false,
                    "\"Važec leží na Slovensku a Važec neleží na Slovensku\""
                ),
                PsychologyTermAnswer("kvantifikátor",
                    false,
                    "tvrzení o některých, či o všech předmět téže druhu - \"všechny\", \"některé\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Všichni přítomní mají maturitu\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "kvantifikátor"
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "kvantifikátor"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Žádní přítomní nemají maturitu\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "kvantifikátor"
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "kvantifikátor"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Někteří přítomní mají maturitu\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "kvantifikátor"
                ),
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "kvantifikátor"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"Karel IV. a zakladatel Karlových Varů\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je složený výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("je výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("není výrok",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"Petr Bezruč byl chovatelem morčat\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("je složený výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("není výrok",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"Není pravda, že Carlos Saura ani Ingmar Bergman\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je složený výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("je výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("není výrok",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"Každému, kdo je štědrý, budiž vzdána chvála\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je složený výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("je výrok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("není výrok",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"Modřín\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je vlastní jméno",
                    false,
                    "výrazy označující právě jeden předmět z oblasti, o níž uvažujeme"
                ),
                PsychologyTermAnswer("je predikát",
                    false,
                    "výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům"
                ),
                PsychologyTermAnswer("ani jedno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"současný prezident České republiky\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je predikát",
                    false,
                    "výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům"
                ),
                PsychologyTermAnswer("je vlastní jméno",
                    false,
                    "výrazy označující právě jeden předmět z oblasti, o níž uvažujeme"
                ),
                PsychologyTermAnswer("ani jedno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"nejstarší bratranec\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je predikát",
                    false,
                    "výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům"
                ),
                PsychologyTermAnswer("je vlastní jméno",
                    false,
                    "výrazy označující právě jeden předmět z oblasti, o níž uvažujeme"
                ),
                PsychologyTermAnswer("ani jedno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),

        PsychologyTerm(
            prompt = "Výraz \"polní maršál\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je predikát",
                    false,
                    "výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům"
                ),
                PsychologyTermAnswer("je vlastní jméno",
                    false,
                    "výrazy označující právě jeden předmět z oblasti, o níž uvažujeme"
                ),
                PsychologyTermAnswer("ani jedno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"trpělivý\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je predikát",
                    false,
                    "výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům"
                ),
                PsychologyTermAnswer("je vlastní jméno",
                    false,
                    "výrazy označující právě jeden předmět z oblasti, o níž uvažujeme"
                ),
                PsychologyTermAnswer("ani jedno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výraz \"kůň, který alespoň jednou vyhrál první pardubickou\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je predikát",
                    false,
                    "výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům"
                ),
                PsychologyTermAnswer("je vlastní jméno",
                    false,
                    "výrazy označující právě jeden předmět z oblasti, o níž uvažujeme"
                ),
                PsychologyTermAnswer("ani jedno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Pokud je Karel lékařem, ví, co je meniskus\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "všechny/žádné, kvantifikátor"
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "některé, kvantifikátor"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Každý sportovec ví, co je meniskus\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "všechny/žádné, kvantifikátor"
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "některé, kvantifikátor"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Ředitel Národní galerie bydlí mezi Krčí a Šeberovem\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "všechny/žádné, kvantifikátor"
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "některé, kvantifikátor"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Jsou takoví vodní živočichové, kteří dýchají žábrami\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "některé, kvantifikátor"
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "všechny/žádné, kvantifikátor"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Někteří lidé jsou flegmatici a někteří lidé se snadno rozčílí\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "všechny/žádné, kvantifikátor"
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "některé, kvantifikátor"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Jan je stejně starý jako Milan, nebo jsou dvojčata\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "všechny/žádné, kvantifikátor"
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "některé, kvantifikátor"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Je-li deštivo, protostou houby\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("implikace",
                    false,
                    "jestliže - pak"
                ),
                PsychologyTermAnswer("konjukce",
                    false,
                    "spojka \"a\""
                ),
                PsychologyTermAnswer("všeobecné tvrzení",
                    false,
                    "všechny/žádné, kvantifikátor"
                ),
                PsychologyTermAnswer("existenční tvrzení",
                    false,
                    "některé, kvantifikátor"
                ),
                PsychologyTermAnswer("negace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ekvivalence",
                    false,
                    "- právě tehdy když -"
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    "spojka \"nebo\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pro potřebu rozlišit smysl jazykového výrazu od předmětu se používá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Fregeho trojúhelník",
                    false,
                    "výraz vyjadřuje smysl, smysl je konceptem denotátu a výraz označuje denotát"
                ),
                PsychologyTermAnswer("konjunkce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("disjunkce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("implikace",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Slovo \"zámek\" je příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("hononyma",
                    false,
                    "dva různé smysly"
                ),
                PsychologyTermAnswer("synonyma",
                    false,
                    "stejný denotát, stejný smysl"
                ),
                PsychologyTermAnswer("vágnosti",
                    false,
                    "červený, dítě, horký čaj, velký pes"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Označení množiny, kde některé předměty nejednoznačně patří do množiny se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("mlžná množina",
                    false,
                    "(fuzzy množina)"
                ),
                PsychologyTermAnswer("mylná množina",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vágní množina",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jestliže řekneme \"toto je Pražský hrad\" a ukážeme na něj bez vysvětlení jedná se o",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ostenzivní definici",
                    false,
                    ""
                ),
                PsychologyTermAnswer("slovní definici",
                    false,
                    "explicitní vysvětlení"
                ),
                PsychologyTermAnswer("vágnost",
                    false,
                    "vágní (neostré) pojmy např. velký pes, červený"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Loď\" v definici \"Lod = zařízení sloužící k dopravě lidi a nákladu po vodě\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("definiendum",
                    false,
                    ""
                ),
                PsychologyTermAnswer("definiens",
                    false,
                    ""
                ),
                PsychologyTermAnswer("definice zavedením úmluvy o užívání výrazu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("definice standardního užívání výrazu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"zařízení sloužící k dopravě lidi a nákladu po vodě\" v definici \"Lod = zařízení sloužící k dopravě lidi a nákladu po vodě\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("definiens",
                    false,
                    ""
                ),
                PsychologyTermAnswer("definiendum",
                    false,
                    ""
                ),
                PsychologyTermAnswer("definice zavedením úmluvy o užívání výrazu",
                    false,
                    "subjektivní definice"
                ),
                PsychologyTermAnswer("definice standardního užívání výrazu",
                    false,
                    "objektivní definice"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Subjektivní definice nazýváme",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("definice zavedením úmluvy o užívání výrazu",
                    false,
                    "subjektivní definice"
                ),
                PsychologyTermAnswer("definice standardního užívání výrazu",
                    false,
                    "objektivní definice"
                ),
                PsychologyTermAnswer("definiens",
                    false,
                    "obsah vysvětlení"
                ),
                PsychologyTermAnswer("definiendum",
                    false,
                    "co vysvětlujeme"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "V případě, kdy je definiens rozsáhlejší než definiendum, mluvíme o",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("široké definici",
                    false,
                    "obsah definice - definiens je příliž vágní"
                ),
                PsychologyTermAnswer("úzké definici",
                    false,
                    ""
                ),
                PsychologyTermAnswer("definici zavedením úmluvy o užívání výrazu",
                    false,
                    "subjektivní definice"
                ),
                PsychologyTermAnswer("definici standardního užívání výrazu",
                    false,
                    "objektivní definice"
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "V případě, kdy je definiendum rozsáhlejší než definiens, mluvíme o",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("úzké definici",
                    false,
                    "nedostatečně jsme tudíž pokryly definici - definiens"
                ),
                PsychologyTermAnswer("široké definici",
                    false,
                    ""
                ),
                PsychologyTermAnswer("definici zavedením úmluvy o užívání výrazu",
                    false,
                    "subjektivní definice"
                ),
                PsychologyTermAnswer("definici standardního užívání výrazu",
                    false,
                    "objektivní definice"
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Kladné číslo je číslo, které ať vynásobíme jakýmkoliv kladným číslem, výsledek je větší než 0\" je definice",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("kruh v definici",
                    false,
                    ""
                ),
                PsychologyTermAnswer("úzká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("široká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ani jedno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Tunel znamená totéž jako podzemní chodba, kterou prochází železniční trať\" je definice",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nepřiměřená, úzká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("přiměřená",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obojí",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřiměřená, široká",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Kostel je stavba s věží, určená k náboženským účelům\" je definice",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nepřiměřená, široká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřiměřená, úzká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("přiměřená",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obojí",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Čtverec definujeme jako pravúhlý čtyřúhelník\" je definice",
            textAnswer = "délky stran také hrají roli",
            answers =
            listOf(
                PsychologyTermAnswer("nepřiměřená, široká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřiměřená, úzká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("přiměřená",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obojí",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"A je neteř osoby B = A je dcerou osoby, jejímž sourozencem je B\" je definice",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("přiměřená",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřiměřená, široká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřiměřená, úzká",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obojí",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Demografie se zabývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("popisem populace a mechanismy její reprodukce\n",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zkoumáním lidových zvyků",
                    false,
                    ""
                ),
                PsychologyTermAnswer("výzkumem veřejného mínění",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Úsudek se nezkládá z",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("problémové (tématické) oblasti",
                    false,
                    "vyjasnění širšího kontextu argumentu"
                ),
                PsychologyTermAnswer("premisů",
                    false,
                    ""
                ),
                PsychologyTermAnswer("závěrů",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Premisy jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("množina tvrzení",
                    false,
                    "premisy"
                ),
                PsychologyTermAnswer("vyjasnění širšího kontextu argumentu",
                    false,
                    "problémová (tématická) oblast"
                ),
                PsychologyTermAnswer("tvrzením, k němuž dospíváme",
                    false,
                    "závěr"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jestliže A, pak B" +
                "\nJestliže B, pak C" +
                "\n---------------------" +
                "\nJestliže A, pak C" +
                "\nje příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("úsudku výrokové logiky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("úsudku predikátové logiky",
                    false,
                    "neboli sylogismy (Artistotelés) - správnost je dána vlastnostmi všeobecných a existenčních výroků"
                ),
                PsychologyTermAnswer("široké definice",
                    false,
                    ""
                ),
                PsychologyTermAnswer("protipříkladu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jestliže A, pak B" +
                "\nA" +
                "\n---------------------" +
                "\nB" +
                "\nje příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("úsudku výrokové logiky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("úsudku predikátové logiky",
                    false,
                    "neboli sylogismy (Artistotelés) - správnost je dána vlastnostmi všeobecných a existenčních výroků"
                ),
                PsychologyTermAnswer("široké definice",
                    false,
                    ""
                ),
                PsychologyTermAnswer("protipříkladu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Všechny P jsou Q" +
                "\nVšechna Q jsou R" +
                "\n---------------------" +
                "\nVšechna P jsou R" +
                "\nje příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("úsudku predikátové logiky",
                    false,
                    "neboli sylogismy (Artistotelés) - správnost je dána vlastnostmi všeobecných a existenčních výroků"
                ),
                PsychologyTermAnswer("úsudku výrokové logiky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("široké definice",
                    false,
                    ""
                ),
                PsychologyTermAnswer("protipříkladu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Některá P jsou Q" +
                "\nVšechna Q jsou R" +
                "\n---------------------" +
                "\nNěkterá P jsou R" +
                "\nje příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("úsudku predikátové logiky",
                    false,
                    "neboli sylogismy (Artistotelés) - správnost je dána vlastnostmi všeobecných a existenčních výroků"
                ),
                PsychologyTermAnswer("úsudku výrokové logiky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("široké definice",
                    false,
                    ""
                ),
                PsychologyTermAnswer("protipříkladu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Každý, kdo si koupil vstupenku, má přístup do sbírek NG" +
                "\nŘeditel NG si vstupenku nekoupil" +
                "\n---------------------" +
                "\nŘeditel NG nemá do sbírek NG přístu" +
                "\nje příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("protipříkladu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("úsudku predikátové logiky",
                    false,
                    "neboli sylogismy (Artistotelés) - správnost je dána vlastnostmi všeobecných a existenčních výroků"
                ),
                PsychologyTermAnswer("úsudku výrokové logiky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("široké definice",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Alík vrtí ocasem, když potká svého pána" +
                "\nRitta vrtí ocasem, když potká svého pána" +
                "\nTyrl vrtí ocasem, když potká svého pána" +
                "\n---------------------" +
                "\nVšichni psi vrtí ocasem, když potkají svého pána" +
                "\nje příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("induktivního usuzování (indukce)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("protipříkladu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("úsudku predikátové logiky",
                    false,
                    "neboli sylogismy (Artistotelés) - správnost je dána vlastnostmi všeobecných a existenčních výroků"
                ),
                PsychologyTermAnswer("úsudku výrokové logiky",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "V Atlantickém oceánu ubývají velryby." +
                "\nV Tichém oceánu ubývají velryby." +
                "\nV Severním oceánu ubývají velryby." +
                "\nV Indickém oceánu ubývají velryby." +
                "\n---------------------" +
                "\nVe všech oceánech ubývají velryby" +
                "\nje příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("úplné indukce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("neúplné indukce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("úsudku predikátové logiky",
                    false,
                    "neboli sylogismy (Artistotelés) - správnost je dána vlastnostmi všeobecných a existenčních výroků"
                ),
                PsychologyTermAnswer("úsudku výrokové logiky",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Je následující úsudek výrokové logiky slučitelný (konzistentní)?" +
                "\nJestliže A, pak B" +
                "\nJestliže B, pak C" +
                "\n---------------------" +
                "\nJestliže A, pak C",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ano",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ne",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Argument je",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("přesvědčování o něčem pomocí uvádení důvodů",
                    false,
                    ""
                ),
                PsychologyTermAnswer("přesvědčování",
                    false,
                    ""
                ),
                PsychologyTermAnswer(" konverzace mezi 2 a více osoby",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dialog založený na konstruktivní kritice",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Argument se neskládá z",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("spojky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("teze",
                    false,
                    "charakteristika problému"
                ),
                PsychologyTermAnswer("problémové (tématické) oblasti",
                    false,
                    "širší kontext problému"
                ),
                PsychologyTermAnswer("problému",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autor předpokládá pravdivost určitých tvrzení, tudíž je vynechá, těmto tvrzením říkáme",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("zamlčené premisy (ZP)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("podargument",
                    false,
                    "v konextu složeného argumentu"
                ),
                PsychologyTermAnswer("složený argument",
                    false,
                    "zdali bylo definováno v rámci předchozích argumentů (podargumentů)"
                ),
                PsychologyTermAnswer("diagram argumentu",
                    false,
                    "logická mapa argumentu"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "ad rem znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("argumentace k věci",
                    false,
                    "ad rem"
                ),
                PsychologyTermAnswer("argumentace k člověku",
                    false,
                    "ad hominem"
                ),
                PsychologyTermAnswer("výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům",
                    false,
                    "predikáty"
                ),
                PsychologyTermAnswer("správnost je dána vlastnostmi všeobecných a existenčních výroků",
                    false,
                    "sylogismy (Artistotelés) - úsudky predikátové logiky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "ad hominem znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("argumentace k člověku",
                    false,
                    "ad hominem"
                ),
                PsychologyTermAnswer("argumentace k věci",
                    false,
                    "ad rem"
                ),
                PsychologyTermAnswer("výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům",
                    false,
                    "predikáty"
                ),
                PsychologyTermAnswer("správnost je dána vlastnostmi všeobecných a existenčních výroků",
                    false,
                    "sylogismy (Artistotelés) - úsudky predikátové logiky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Predikáty jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům",
                    false,
                    "predikáty"
                ),
                PsychologyTermAnswer("argumentace k člověku",
                    false,
                    "ad hominem"
                ),
                PsychologyTermAnswer("argumentace k věci",
                    false,
                    "ad rem"
                ),
                PsychologyTermAnswer("správnost je dána vlastnostmi všeobecných a existenčních výroků",
                    false,
                    "sylogismy (Artistotelés) - úsudky predikátové logiky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Sylogismy jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("správnost je dána vlastnostmi všeobecných a existenčních výroků",
                    false,
                    "sylogismy (Artistotelés) - úsudky predikátové logiky"
                ),
                PsychologyTermAnswer("argumentace k člověku",
                    false,
                    "ad hominem"
                ),
                PsychologyTermAnswer("argumentace k věci",
                    false,
                    "ad rem"
                ),
                PsychologyTermAnswer("výrazy, které označují vlastnosti, vztahy, jež mohou být přisouzeny předmětům",
                    false,
                    "predikáty"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Přeformulování původního argumentu druhé osoby tak, aby naše odpověď působila dobře se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("posunutí tématu diskuse",
                    false,
                    ""
                ),
                PsychologyTermAnswer("posunutí přímého důkazu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Namísto podložení svých argumentů, osoba žádá prokázání opaku, jinak je jeho argument správně, tato taktika se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("posunutí přímého důkazu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("posunutí tématu diskuse",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        )
    )
}