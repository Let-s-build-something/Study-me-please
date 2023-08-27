package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

object PsychologyFive {

    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Mentální anorexie patří mezi""",
            textAnswer = "Úmyslné hubnutí, pacient si sám přivolal a udržuje. Strach z tloušťky." +
                "\nOmezený výběr jídla, nadměrná tělesná činnost, vyvolávání zvracení/průjmu",
            answers = listOf(
                PsychologyTermAnswer("""poruchy přijmu potravy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy metabolismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy motoriky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy vnimani""",
                    false,
                    ""
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Blud patří mezi""",
            textAnswer = "Nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech",
            answers = listOf(
                PsychologyTermAnswer("""obranné mechanismy ega""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""adaptační procesy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy vnímání""",
                    false,
                    ""
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Předstírané poruchy myšlení se objevuji u""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""tyto poruchy nelze předstirat""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """syndromu Kaspara Hausera""",
                    false,
                    "Hodně dlouho izolovaný jedinec - pojmenováno po nalezeném 16 let izolovaném chlapci v cele." +
                        "\nŘeč, impulzivita, motorika."
                ),
                PsychologyTermAnswer(
                    """Kannerova syndromu""",
                    false,
                    "Vývojová porucha. Dětský autismus. a) Manifestace před 3 lety. b) omezené všechny tři oblasti psychopatologie " +
                        "(sociální interakce, komunikace a opakující se omezené stereotypní chování)"
                ),
                PsychologyTermAnswer(
                    """Ganscrova syndromu""",
                    false,
                    "Disociativní porucha (vědomí). Bizarní odpovědi na jednoduché otázky (jména, počty, data (čas a prostor))."
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termin obsese označuje""",
            textAnswer = "Opakované, vtíravé myšlenky (nápady), pudy a činy." +
                "\nCingular Gyrus - mimovolní pohyby (aktivuje se u lidí s obsesí více, kompulze).",
            answers = listOf(
                PsychologyTermAnswer(
                    """opakované nutkavé myšlenky, představy či impulsy""",
                    false
                ),
                PsychologyTermAnswer("""opakované nutkavé chování či jednání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """poruchu myšlení, která se vyznačuje zveličováním""",
                    false
                ),
                PsychologyTermAnswer("""jednání nepřizpůsobené sociální situaci""",
                    false,
                    ""
                ),
            ),
            questionNumber = 4,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termin kompulze označuje""",
            textAnswer = "Opakované nutkavé chování či jednání (spojováno s obsesí)",
            answers = listOf(
                PsychologyTermAnswer("""úzkostné vyhýbání se sociálním situacím""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""jednání nepřizpůsobené sociální situaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """opakované nutkavé myšlenky, představy či impulsy""",
                    false
                ),
            ),
            questionNumber = 5,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termin kompulze označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""úzkostné vyhýbání se sociálním situacím""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""jednání nepřizpůsobené sociální situaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""opakované nutkavé chování či jednání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """opakované nutkavé myšlenky, představy či impulsy""",
                    false
                ),
            ),
            questionNumber = -5,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Opakované nutkavé chování či jednání se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """automatismus""",
                    false,
                    "Věci, které děláme \"už automaticky\", třeba v řeči, či motorice."
                ),
                PsychologyTermAnswer("""obsese""",
                    false,
                    "Opakované, vtíravé myšlenky (nápady), pudy a činy." +
                        "\nCingular Gyrus - mimovolní pohyby (aktivuje se u lidí s obsesí více, kompulze)."
                ),
                PsychologyTermAnswer("""sukcese""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kompulze""",
                    false,
                    "Opakované nutkavé chování či jednání (spojováno s obsesí)"
                ),
            ),
            questionNumber = 6,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Domnělý vjem, který není vyvolán skutečným podnětem a osoba jej přitom považuje za skutečný, označujeme terminem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""halucinace""",
                    false,
                    "Fiktivní obraz/osoba/věc, který vznikne bez reálného podnětu. Člověk ji považuje za realitu."
                ),
                PsychologyTermAnswer("""obnubilace""",
                    false,
                    "Snížená úroveň bdělosti a vědomí, jednání bez myšlení. Třeba histerie, epilepsie"
                ),
                PsychologyTermAnswer("""pseudehalucinace""",
                    false,
                    "Pseudohalucinace - třeba u LSD, kdy vidímě věci, které tam nejsou, ale víme o tom."
                ),
                PsychologyTermAnswer("""iluze""",
                    false,
                    ""
                ),
            ),
            questionNumber = 7,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Iatropatogenní působení je""",
            textAnswer = "Nežádoucí účinky důsledkem lékařským zákrokem",
            answers = listOf(
                PsychologyTermAnswer(
                    """chybné vyhodnocení diagnózy jako maligní, i když je ve skutečnosti benigní""",
                    false,
                    "Maligní je zhoubný nádor, benigní je v pohodě"
                ),
                PsychologyTermAnswer(
                    """pozitivní ovlivnění zdravotního stavu pacienta lékařem, zdravotnickým personálem či procesem léčby""",
                    false
                ),
                PsychologyTermAnswer(
                    """negativní ovlivnění zdravotního stavu pacienta lékařem, zdravotnickým personálem či procesem léčby""",
                    false
                ),
                PsychologyTermAnswer(
                    """chybné vyhodnocení diagnózy jako benigní, i když je ve skutečnosti maligní""",
                    false,
                    "Maligní je zhoubný nádor, benigní je v pohodě"
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Zkratka WAIS označuje""",
            imageAnswerUrl = "https://coimages.sciencemuseumgroup.org.uk/images/400/631/medium_SMG00158122.jpg",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Würzburské automatizované škálováni inteligence""",
                    false
                ),
                PsychologyTermAnswer("""Wechslerův inteligenční test pro dospělé""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Wechslerovu paměťovou škálu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """Würzburský strukturovaný inventář asociálního chování""",
                    false
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín kazuistika označuje""",
            textAnswer = "Rozbor a popis jednoho případu",
            answers = listOf(
                PsychologyTermAnswer("""případovou studii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """vyjádřeni znalce k určitému soudnímu případu""",
                    false
                ),
                PsychologyTermAnswer("""analýzu přičin chování v určité situaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """nenucený přístup při psychologickém vyšetření""",
                    false
                ),
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Zjišťování psychických nároků pro výkon ruzných profesí, " +
                "výběr uchazečů a posuzováni jejich vhodnosti jsou témata, která řeší převážně",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """inženýrská psychologie""",
                    false,
                    "Inženýrská psychologie zkoumá procesy a prostředky řídící interakce mezi člověkem a technickým zařízením. Inženýrská psychologie vyrůstá z tradice experimentální psychologie." +
                        "\nKooperace mezi člověkem a zařízením, efektivita, kvalita, přesnost, příjem informací člověkem."
                ),
                PsychologyTermAnswer("""personální psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie organizace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ekonomická psychologie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Lehké dětské encefalopatie se označují také jako""",
            textAnswer = "Označuje globální dyzfunkci mozku.",
            answers = listOf(
                PsychologyTermAnswer("""dětské neurotoxické deficity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""encefalické syndromy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lehké mozkové dysfunkce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dětské epileptoformni poruchy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 12,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín suicidium znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sebevraždu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """neurotické snižování vlastního sebepojeti""",
                    false
                ),
                PsychologyTermAnswer("""sebepoškozování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""slabé vědomí já""",
                    false,
                    ""
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Jaký text je lépe čitelný?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""světlý na tmavém pozadí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """při stejném kontrastu je čitelnost stejná""",
                    false
                ),
                PsychologyTermAnswer("""čitelnost nelze vhodně operacionalizovat""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""tmavý na světlém pozadí""",
                    false,
                    ""
                ),
            ),
            questionNumber = 14,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Tzv. bájná lhavost se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""hyperaktivní fantazijní produkce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""arealitní syndrom""",
                    false,
                    "Pocit, že svět okolo jedince není reálný."
                ),
                PsychologyTermAnswer("""konfúzní výpověď""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """pseudologia phantastica""",
                    false,
                    "Bájivá či chorobná lhavost. Daný lže pro pozornost."
                ),
            ),
            questionNumber = 15,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Balbutik je člověk trpící""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""koktavostí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """poruchou volního rozhodování""",
                    false,
                    "Volní procesy souvisí s rozhodováním." +
                        "\nFáze rozhodovací - zpracuju, uvědomím si informace z vnějška a vytvořím cíl - rozhodnutí." +
                        "\nFáze realuzační - realizovace cíle/rozhodnutí."
                ),
                PsychologyTermAnswer("""korovou hluchotou""",
                    false,
                    "hluchota způsobena poškozením sluchové kůry v mozku"
                ),
                PsychologyTermAnswer("""bludy""",
                    false,
                    "Nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech"
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Terapeut si při terapii pozve kromě dětského pacienta i rodiče a sourozence a soustředí se na komunikaci a vztahy mezi rodinnými příslušníky." +
                " Jako pacient přitom není vnímáno samo dítě, ale celá rodina. Jakou psychoterapii nejspíše terapeut praktikuje?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dynamickou""",
                    false,
                    "Vyšlo z psychoanalýzy - nevědomé procesy."
                ),
                PsychologyTermAnswer("""manželskou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivně-behaviorální""",
                    false,
                    "KBT - stoicismus - nejde o svět okolo nás, ale jak ten svět okolo nás vnímáme." +
                        "\nTedy jsme se něco naučili špatně a KBT se snaží nás to naučit správně."
                ),
                PsychologyTermAnswer("""systemickou""",
                    false,
                    "Holistický pohled na problém - když řešíme problém dítěte, pozveme si celou rodinu."
                ),
            ),
            questionNumber = 17,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Neúčinná látka, po jejíž aplikaci dojde ke zlepšení stavu pacienta v důsledku jeho očekávání," +
                " že substance bude pozitivně působit, se označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""homeopatie""",
                    false,
                    "Vážně pomáhá, z nějakýho záhadnýho důvodu, nejen placebo."
                ),
                PsychologyTermAnswer("""efektivní psychofarmakon""",
                    false,
                    "\"farmakon\"=léčivo"
                ),
                PsychologyTermAnswer("""substituční farmakon""",
                    false,
                    "\"farmakon\"=léčivo"
                ),
                PsychologyTermAnswer("""placebo""",
                    false,
                    ""
                ),
            ),
            questionNumber = 18,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Lehká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("IQ 50-69",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
                PsychologyTermAnswer("IQ 35-49",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("IQ 21-34",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie"
                ),
                PsychologyTermAnswer("pod IQ 20",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Středně těžká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("IQ 35-49",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("IQ 50-69",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
                PsychologyTermAnswer("IQ 21-34",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie"
                ),
                PsychologyTermAnswer("pod IQ 20",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Těžká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("IQ 21-34",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie"
                ),
                PsychologyTermAnswer("IQ 35-49",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("IQ 50-69",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
                PsychologyTermAnswer("pod IQ 20",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Hluboká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("pod IQ 20",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
                PsychologyTermAnswer("IQ 21-34",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie"
                ),
                PsychologyTermAnswer("IQ 35-49",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("IQ 50-69",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Lehká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("debilita",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
                PsychologyTermAnswer("imbecilita",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("prostá idiocie",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie)"
                ),
                PsychologyTermAnswer("těžká idiocie",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Středně těžká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("imbecilita",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("debilita",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
                PsychologyTermAnswer("prostá idiocie",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie)"
                ),
                PsychologyTermAnswer("těžká idiocie",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Těžká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("prostá idiocie",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie)"
                ),
                PsychologyTermAnswer("imbecilita",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("debilita",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
                PsychologyTermAnswer("těžká idiocie",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Hluboká mentální retardace odpovídá",
            textAnswer = "Lehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("těžká idiocie",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
                PsychologyTermAnswer("prostá idiocie",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie)"
                ),
                PsychologyTermAnswer("imbecilita",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("debilita",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Jako prodromální fáze poruchy či choroby se označuje období""",
            textAnswer = "Bez zjevných projevů - Latentní" +
                "\nS nespecifickými příznaky - prodromální" +
                "\n\nFáze nemoci: " +
                "\n\t1. Prodromální - (zvýšená únavost organismu, bolest hlavy, změna nálady)" +
                "\n\t2. Rozvinuté klinické příznaky - symptomy (pocení, tepové/dechová frekvence, bolest)" +
                "\n\t3. Rekonvalescence",
            imageAnswerUrl = "https://www.fsps.muni.cz/inovace-RVS/kurzy/patofyziologie/obr/1_2_4_Stadia.jpg",
            answers = listOf(
                PsychologyTermAnswer(
                    """mezi prvními varovnými příznaky a plným rozvinutím poruchy""",
                    false,
                    imageExplanationUrl = "https://www.fsps.muni.cz/inovace-RVS/kurzy/patofyziologie/obr/1_2_3_Symptom_syndrom_morbus.jpg"
                ),
                PsychologyTermAnswer(
                    """mezi nástupem rozvinuté poruchy a vznikem ireverzibilního poškození""",
                    false
                ),
                PsychologyTermAnswer("""před objevením se prvních příznaků""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předcházející úmrtí v důsledku poruchy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 19,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Přechodné snížení rozumových schopností se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""demence""",
                    false,
                    "Častěji až později ve stáří." +
                        "\nNapř. Alzheimerova choroba (viz. foto), demence Lewyho tělísek (shluky bílkovin v neuronech), 40% lidí s Parkinsonem bude mít i demenci",
                    imageExplanationUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Alzheimer%27s_disease_brain_comparison.jpg/1920px-Alzheimer%27s_disease_brain_comparison.jpg"
                ),
                PsychologyTermAnswer("""pseudodemence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální retardace""",
                    false,
                    "Narozdíl od demence vrozená kognitivní porucha\n" +
                        "Hranice je IQ 65-68." +
                        "\nV závorce starší označení" +
                        "\nLehká mentální retardace IQ 50-69 (debilita)" +
                        "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                        "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                        "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
                PsychologyTermAnswer("""reverzibilní inzitizace""",
                    false,
                    "neexistuje"
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Ke snižování tolerance vůči alkoholu dochází""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""ve fázi nepravidelného pití""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve fázi nebezpečného (varovného/prodromálního) pití""",
                    false,
                    "Tolerance roste, pije tajně. Neplánované opilosti, tajné zásoby."
                ),
                PsychologyTermAnswer("""v terminálním stádiu závislosti""",
                    false,
                    "Tolerance prudce klesá. Posun vnitřních hranic."
                ),
                PsychologyTermAnswer("""v počátečním stádiu závislosti""",
                    false,
                    "Poživačné pití"
                ),
                PsychologyTermAnswer("""v rozhodném/kruciálním stádiu závislosti""",
                    false,
                    "Tolerance stále roste. Rozhoduje se o závislosti. Ztráta kontroly (po započetí pití). Zúžení zájmů."
                )
            ),
            questionNumber = 21,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Army alfa byl""",
            textAnswer = "Pro identifikaci rekruitů, kteří měli nízkou inteligenci",
            answers = listOf(
                PsychologyTermAnswer("""inteligenční test""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""test pozornosti""",
                    false,
                    "třeba tachistoskop"
                ),
                PsychologyTermAnswer("""test osobnostní stability""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""test výkonnosti""",
                    false,
                    ""
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Pervitin je návyková látka zařazovaná mezi:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""halucinogeny""",
                    false,
                    "LSD" +
                        "\npsilocybin (houbičky)" +
                        "\nmeskalin (z kaktusů)" +
                        "\nLSA (havajská růže)" +
                        "\nDMT"
                ),
                PsychologyTermAnswer("""psychostimulancia""",
                    false,
                    "(Psychoanaleptika) - zvýšení činnosti CNS" +
                        "\n1. Sympatomimetika:" +
                        "\n\t\t-sympatomimetické aminy (kokain, pervitin, amfetamin, extáze...)" +
                        "\n\t\t-kofein" +
                        "\n\t\t-nikotin" +
                        "\n2. Analeptika - zvýšení převahy excitačních nad inhibičními neurotransmitory" +
                        "\n\t\t-strychnin, pikrotoxin"
                ),
                PsychologyTermAnswer("""opioidy""",
                    false,
                    "Opioidní analgetika (tlumiče bolesti, dříve od opia (narkotika) - na spánek)" +
                        "\n1. Od molekuly morfinu (z makovic máku setého):" +
                        "\n\t\t-přirozené (alkaloidy) - morfin, kodein" +
                        "\n\t\t-polosyntetické - heroin, hydromorfon, oxykodon" +
                        "\n2. Syntetické (od moleky fenylpiperazin)" +
                        "\n\t\t-metadon, fentanyl, petidin, megafon"
                )
            ),
            questionNumber = 23,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Kokain je návyková látka zařazovaná mezi:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""halucinogeny""",
                    false,
                    "LSD" +
                        "\npsilocybin (houbičky)" +
                        "\nmeskalin (z kaktusů)" +
                        "\nLSA (havajská růže)" +
                        "\nDMT"
                ),
                PsychologyTermAnswer("""psychostimulancia""",
                    false,
                    "(Psychoanaleptika) - zvýšení činnosti CNS" +
                        "\n1. Sympatomimetika:" +
                        "\n\t\t-sympatomimetické aminy (kokain, pervitin, amfetamin, extáze...)" +
                        "\n\t\t-kofein" +
                        "\n\t\t-nikotin" +
                        "\n2. Analeptika - zvýšení převahy excitačních nad inhibičními neurotransmitory" +
                        "\n\t\t-strychnin, pikrotoxin"
                ),
                PsychologyTermAnswer("""opioidy""",
                    false,
                    "Opioidní analgetika (tlumiče bolesti, dříve od opia (narkotika) - na spánek)" +
                        "\n1. Od molekuly morfinu (z makovic máku setého):" +
                        "\n\t\t-přirozené (alkaloidy) - morfin, kodein" +
                        "\n\t\t-polosyntetické - heroin, hydromorfon, oxykodon" +
                        "\n2. Syntetické (od moleky fenylpiperazin)" +
                        "\n\t\t-metadon, fentanyl, petidin, megafon"
                ),
                PsychologyTermAnswer("""kofeinoidy""",
                    false,
                    "neexistují"
                ),
            ),
            questionNumber = -923,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Heroin je návyková látka zařazovaná mezi:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""halucinogeny""",
                    false,
                    "LSD" +
                        "\npsilocybin (houbičky)" +
                        "\nmeskalin (z kaktusů)" +
                        "\nLSA (havajská růže)" +
                        "\nDMT"
                ),
                PsychologyTermAnswer("""psychostimulancia""",
                    false,
                    "(Psychoanaleptika) - zvýšení činnosti CNS" +
                        "\n1. Sympatomimetika:" +
                        "\n\t\t-sympatomimetické aminy (kokain, pervitin, amfetamin, extáze...)" +
                        "\n\t\t-kofein" +
                        "\n\t\t-nikotin" +
                        "\n2. Analeptika - zvýšení převahy excitačních nad inhibičními neurotransmitory" +
                        "\n\t\t-strychnin, pikrotoxin"
                ),
                PsychologyTermAnswer("""opioidy""",
                    false,
                    "Opioidní analgetika (tlumiče bolesti, dříve od opia (narkotika) - na spánek)" +
                        "\n1. Od molekuly morfinu (z makovic máku setého):" +
                        "\n\t\t-přirozené (alkaloidy) - morfin, kodein" +
                        "\n\t\t-polosyntetické - heroin, hydromorfon, oxykodon" +
                        "\n2. Syntetické (od moleky fenylpiperazin)" +
                        "\n\t\t-metadon, fentanyl, petidin, megafon"
                ),
                PsychologyTermAnswer("""kofeinoidy""",
                    false,
                    "neexistují"
                ),
            ),
            questionNumber = -924,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Kofein je návyková látka zařazovaná mezi:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""halucinogeny""",
                    false,
                    "LSD" +
                        "\npsilocybin (houbičky)" +
                        "\nmeskalin (z kaktusů)" +
                        "\nLSA (havajská růže)" +
                        "\nDMT"
                ),
                PsychologyTermAnswer("""psychostimulancia""",
                    false,
                    "(Psychoanaleptika) - zvýšení činnosti CNS" +
                        "\n1. Sympatomimetika:" +
                        "\n\t\t-sympatomimetické aminy (kokain, pervitin, amfetamin, extáze...)" +
                        "\n\t\t-kofein" +
                        "\n\t\t-nikotin" +
                        "\n2. Analeptika - zvýšení převahy excitačních nad inhibičními neurotransmitory" +
                        "\n\t\t-strychnin, pikrotoxin"
                ),
                PsychologyTermAnswer("""opioidy""",
                    false,
                    "Opioidní analgetika (tlumiče bolesti, dříve od opia (narkotika) - na spánek)" +
                        "\n1. Od molekuly morfinu (z makovic máku setého):" +
                        "\n\t\t-přirozené (alkaloidy) - morfin, kodein" +
                        "\n\t\t-polosyntetické - heroin, hydromorfon, oxykodon" +
                        "\n2. Syntetické (od moleky fenylpiperazin)" +
                        "\n\t\t-metadon, fentanyl, petidin, megafon"
                )
            ),
            questionNumber = -925,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """LSD je návyková látka zařazovaná mezi:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""halucinogeny""",
                    false,
                    "LSD" +
                        "\npsilocybin (houbičky)" +
                        "\nmeskalin (z kaktusů)" +
                        "\nLSA (havajská růže)" +
                        "\nDMT"
                ),
                PsychologyTermAnswer("""psychostimulancia""",
                    false,
                    "(Psychoanaleptika) - zvýšení činnosti CNS" +
                        "\n1. Sympatomimetika:" +
                        "\n\t\t-sympatomimetické aminy (kokain, pervitin, amfetamin, extáze...)" +
                        "\n\t\t-kofein" +
                        "\n\t\t-nikotin" +
                        "\n2. Analeptika - zvýšení převahy excitačních nad inhibičními neurotransmitory" +
                        "\n\t\t-strychnin, pikrotoxin"
                ),
                PsychologyTermAnswer("""opioidy""",
                    false,
                    "Opioidní analgetika (tlumiče bolesti, dříve od opia (narkotika) - na spánek)" +
                        "\n1. Od molekuly morfinu (z makovic máku setého):" +
                        "\n\t\t-přirozené (alkaloidy) - morfin, kodein" +
                        "\n\t\t-polosyntetické - heroin, hydromorfon, oxykodon" +
                        "\n2. Syntetické (od moleky fenylpiperazin)" +
                        "\n\t\t-metadon, fentanyl, petidin, megafon"
                )
            ),
            questionNumber = -926,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi psychadelika nepatří:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pervitin""",
                    false
                ),
                PsychologyTermAnswer("""kokain""",
                    false
                ),
                PsychologyTermAnswer("""morfin""",
                    false,
                    "Opioid"
                ),
                PsychologyTermAnswer("""nikotin""",
                    false
                ),
            ),
            questionNumber = -927,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Pro který psychoterapeutický směr je typická metoda volných asociací?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pro systemickou terapii""",
                    false,
                    "Holistický pohled na problém - když řešíme problém dítěte, pozveme si celou rodinu."
                ),
                PsychologyTermAnswer("""pro psychoanalýzu""",
                    false,
                    "Jung"
                ),
                PsychologyTermAnswer("""pro gestalt terapii""",
                    false,
                    "Humanistický, prožitkový přístup, teorie pole." +
                        "\nCílem je sjednocení těla, pocitů a rozumu." +
                        "\nVnější projevy musí souhlasit s vnitřními pocity."
                ),
                PsychologyTermAnswer("""pro kognitivně-behaviorální terapii""",
                    false,
                    "KBT - stoicismus - nejde o svět okolo nás, ale jak ten svět okolo nás vnímáme." +
                        "\nTedy jsme se něco naučili špatně a KBT se snaží nás to naučit správně."
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        /*BS otázka
        PsychologyTerm(
            prompt = """A65""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """Dietylamid kyseliny lysergové se označuje také jako""",
                    false,
                    "LSD"
                ),
                PsychologyTermAnswer("""mezkalin""",
                    false,
                    "halucinogen"
                ),
                PsychologyTermAnswer("""psylocybin""",
                    false,
                    "halucinogen"
                ),
                PsychologyTermAnswer("""LSD""",
                    false,
                    "halucinogen"
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),*/
        PsychologyTerm(
            prompt = """Psychickými změnami ve stáří se zabývá zejména""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""senilní psychologie""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""gerontopsychologie""",
                    false,
                    "psychologie stárnutí a stáří,též geropsychologie"
                ),
                PsychologyTermAnswer("""paliativní psychologie""",
                    false,
                    "paliativní léčba - zvyšování kvality života pacienta a rodiny při obtížné nemoci"
                ),
                PsychologyTermAnswer("""etnopsychologie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín adaptace označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """převod hrubých skórů testu na skóry vážené""",
                    false,
                    "" +
                        "Význam - zajištění porovnatelnosti individuálního výsledku s rozložením výsledků v populaci" +
                        "\n\nHrubý skór - původně naměřené hodnoty" +
                        "\n\nVážený skór - definovaný na základě porovnání hrubých skórů vyšetřované osoby se skóry určitého souboru osob" +
                        "\n\nStandardní skór - čísla, vzniklá transformací (normalizací) z hrubých skór do rozložení s předem danými vlastnostmi"
                ),
                PsychologyTermAnswer("""přizpůsobení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývoj""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dodržování norem""",
                    false,
                    ""
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Soubor údajů o dosavadním průběhu života či nějakého období a shromažďování tohoto souboru se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""anamnéza""",
                    false,
                    "Medical history"
                ),
                PsychologyTermAnswer("""amnézie""",
                    false,
                    "Porucha paměti. " +
                        "\nRetrográdní (třeba otřes mozku) - pomalu se rozpomínáme, ale část těsně před nehodou většinou nikdy nenavrátíme. " +
                        "\nAnterográdní - nepamatujeme si nové věci (neurochirurgické operace proti epilepsii)"
                ),
                PsychologyTermAnswer("""interview""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychohistorie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 28,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Jednání, které má vést k prosazování vlastních zájmů a zachovávání sebeúcty jednající osoby," +
                " vyhýbá se agresivitě a zdůrazňuje zodpovědnost jednajícího za své jednání, se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""atraktivita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""behaviorální závazek""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""sebeprosazující agování""",
                    false,
                    "Maskovaný projev nespokojenosti"
                ),
                PsychologyTermAnswer("""asertivita""",
                    false,
                    ""
                ),
            ),
            questionNumber = 29,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termínem lokomoce se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální mobilita""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychická výkonnost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""automatické chování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pohyb""",
                    false,
                    ""
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Polygraf je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """přístroj obvykle užívaný jako tzv. detektor lži""",
                    false
                ),
                PsychologyTermAnswer("""jiný název pro elektroencefalograf""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """přístroj pro počítačovou prezentaci dotazníků a současné měření fyziologických veličin""",
                    false
                ),
                PsychologyTermAnswer(
                    """aparát pro zaznamenávání evokovaných potenciálů""",
                    false
                ),
            ),
            questionNumber = 31,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Zkratka MKN označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""matrimoniální konfliktní neurózu""",
                    false,
                    "matrimoniální - manželský"
                ),
                PsychologyTermAnswer("""maligní Kleinferterovu nemoc""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer(
                    """minimální klasifikovatelný neurotický rys""",
                    false
                ),
                PsychologyTermAnswer("""mezinárodní klasifikaci nemocí""",
                    false,
                    ""
                ),
            ),
            questionNumber = 32,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Názorovou a verbální složku rozlišujeme při diagnostice""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""školní zralosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""inteligence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivního stylu""",
                    false,
                    "Způsob, jakým jedinec zpracovává, organizuje a používá informace"
                ),
                PsychologyTermAnswer("""skupinové komunikace""",
                    false,
                    ""
                ),
            ),
            questionNumber = 33,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Při anterográdní amnézií je narušena""",
            textAnswer =  "ztráta paměti po úrazu",
            answers = listOf(
                PsychologyTermAnswer("""deklarativní paměť""",
                    false,
                    "prochází vědomím, dělí se na epizodické - epizody z života (jako příběh) a sémantické - schémata a fakta o světě"
                ),
                PsychologyTermAnswer("""pracovní paměť""",
                    false,
                    "krátkodobá paměť"
                ),
                PsychologyTermAnswer(
                    """procedurální paměť""",
                    false,
                    "Implicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť."
                ),
                PsychologyTermAnswer("""inteligence""",
                    false,
                    ""
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Systematická desenzitizace se používá""",
            textAnswer = "relaxační metody pro snížení úzkosti",
            answers = listOf(
                PsychologyTermAnswer("""k léčbě sociálních maladaptací""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""k léčbě fobií""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """ke zjišťování regeneračních schopnosti CNS""",
                    false
                ),
                PsychologyTermAnswer("""k diagnostice skupinové koheze""",
                    false,
                    "Soudržnost"
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Která z uvedených organizací pracuje na bázi svépomocných skupin?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Mezinárodní psychoanalytický institut""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Sdružení na ochranu pacientů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""RIAPS""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Anonymní alkoholici""",
                    false,
                    ""
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Jako elektrodermální reakci označujeme""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""změny kožní vodivosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """změny elektrického potenciálu na kůži v důsledku práce srdce""",
                    false
                ),
                PsychologyTermAnswer(
                    """změny elektrického potenciálu na kůži v důsledku práce mozku""",
                    false
                ),
                PsychologyTermAnswer(
                    """kožní podráždění vzniklé při léčbě elektrošoky""",
                    false
                ),
            ),
            questionNumber = 37,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Perseverace je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""uchovávání informací v paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""jiný název pro obsesi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """ulpívání na nějakém myšlenkovém obsahu či představě""",
                    false
                ),
                PsychologyTermAnswer(
                    """uchování informace v senzorických registrech""",
                    false,
                    "Ultra krátkodobá paměť: Ikonická paměť (vizuální) do 1s, Echoická (zvuková) 3-4s."
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Elektrokonvulzivní terapie je""",
            textAnswer = "Použití elektrických šoků k vyvolání epileptiformního záchvatu." +
                "\nRoli s největší pravděpodobností hraje podpůrný efekt neuroplasticidy.",
            answers = listOf(
                PsychologyTermAnswer(
                    """terapie založená na dlouhodobé aplikaci malého elektrického napětí""",
                    false
                ),
                PsychologyTermAnswer(
                    """terapeutická implantace stimulačních elektrod do bazálních ganglii""",
                    false,
                    "Velké útvary šedé hmoty uvnitř hemisfér. Plynulé, cílené a přesné pohyby." +
                        "\nTypy:" +
                        "\n\t-Nucleus caudatus" +
                        "\n\t-Putamen" +
                        "\n\t-Corpus stratium - Putamen + Nucleus caudatus" +
                        "\n\t-Globus pallidus (medialis, lateralis)" +
                        "\n\t-Nucleus lentiformis - Putamen + Globus pallidus" +
                        "- Huntingtonova chorea, tiky, Parkinson"
                ),
                PsychologyTermAnswer(
                    """léčba založená na sledování elektrických reakcí vlastního těla""",
                    false
                ),
                PsychologyTermAnswer(
                    """léčba založená na vyvolání epileptických paroxysmů aplikací elektrického proudu""",
                    false
                ),
            ),
            questionNumber = 39,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Tematický apercepční test patří mezi""",
            textAnswer = "Projektivní test osobnosti (verbální), nejdominantnější hned po Rorschahovu testu." +
                "\n32 černobílých obrázků s nejednoznačnými situacemi.",
            answers = listOf(
                PsychologyTermAnswer("""projektivní techniky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""strukturované rozhovory""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""inventáře""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""výkonové testy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Matrimoniologie je""",
            textAnswer = "Věda o manželství. Lat. matrimonium=manželství." +
                "\nZakladatel Miroslav Plzák.",
            answers = listOf(
                PsychologyTermAnswer("""výchovné poradenství""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""teorie dynamiky dětských skupin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""manželské poradenství""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""výzkum mateřského chování""",
                    false,
                    ""
                ),
            ),
            questionNumber = 41,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Stav emočního vyčerpání a otupělosti vůči problémům druhých, který se objevuje u pomáhajících profesí, se označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""moral insanity""",
                    false,
                    "Třída duševních poruch - závažné porušení morálních reprezentací pacienta."
                ),
                PsychologyTermAnswer("""syndrom vyhoření""",
                    false,
                    "burn-out syndrome"
                ),
                PsychologyTermAnswer("""syndrom sociální tuposti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""burn-off syndrom""",
                    false,
                    ""
                ),
            ),
            questionNumber = 42,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Brainstorming je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""metoda skupinového řešení problému""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """soubor postupů k procvičování mozkových funkci""",
                    false
                ),
                PsychologyTermAnswer(
                    """metoda kognitivního tréninku pro pacienty s narušením mozku""",
                    false
                ),
                PsychologyTermAnswer(
                    """metoda nátlaku a donucování, založená na psychickém týrání""",
                    false
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Autogenní tréning je""",
            textAnswer = "Víceméně meditace založená na pozitivních sugescích.",
            answers = listOf(
                PsychologyTermAnswer("""metoda zlepšování schopností""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""relaxační technika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """výcvik vlastního reagování v sociálních situacích""",
                    false
                ),
                PsychologyTermAnswer(
                    """terapeutická metoda, která se soustředí na posilování pocitu sebevědomí""",
                    false
                ),
            ),
            questionNumber = 44,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Psychický stav, který se vyznačuje skleslou náladou, prožitky smutku a pesimismu a nezájmem o okolí, se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""autismus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""izolace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprese""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""deprivace""",
                    false,
                    ""
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Silný strach, který je svou intenzitou nepřiměřený skutečnému nebezpečí, označujeme""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""klaustrofobie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fobie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mánie""",
                    false,
                    "Stav chorobně povznesené nálady a zvýšené aktivity"
                ),
                PsychologyTermAnswer("""anxieta""",
                    false,
                    ""
                ),
            ),
            questionNumber = 46,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín fobie označuje""",
            textAnswer = "Silný strach, který je svou intenzitou nepřiměřený skutečnému nebezpečí",
            answers = listOf(
                PsychologyTermAnswer("""strach z malých prostor""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """vyhýbání se lidem a neschopnost navazovat vztahy""",
                    false
                ),
                PsychologyTermAnswer("""iracionální obavy z pronásledování""",
                    false,
                    "stihomam"
                ),
                PsychologyTermAnswer(
                    """silný strach, nepřiměřený podnětové situaci""",
                    false
                ),
            ),
            questionNumber = 47,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Halucinace je""",
            textAnswer = "Fiktivní obraz/osoba/věc, který vznikne bez reálného podnětu. Člověk ji považuje za realitu.",
            answers = listOf(
                PsychologyTermAnswer(
                    """iracionální nevývratné přesvědčení o nějaké skutečnosti""",
                    false,
                    "bludy"
                ),
                PsychologyTermAnswer(
                    """klamný vjem vznikající na podkladě skutečného vjemu; jedinec se při něm domnívá, že jde o skutečný vjem""",
                    false
                ),
                PsychologyTermAnswer(
                    """klamný vjem, který nemá žádný podklad ve skutečném podnětovém poli a jedinec se přitom domnívá, že jde o skutečný vjem""",
                    false
                ),
                PsychologyTermAnswer(
                    """klamný vjem vznikající na podkladě skutečného vjemu; jedinec si při něm uvědomuje, že nejde o skutečný vjem""",
                    false,
                    "pseudehalucinace"
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín anhedonie označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """depresivní fázi bipolární afektivní poruchy""",
                    false,
                    "",
                    imageExplanationUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Bipolar_disorder.webm/1200px--Bipolar_disorder.webm.jpg"
                ),
                PsychologyTermAnswer("""nedostatek vůle""",
                    false,
                    "abulie"
                ),
                PsychologyTermAnswer("""neschopnost prožitku štěstí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""celkovou ztrátu emocionality""",
                    false,
                    ""
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín hypnabilita označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """schopnost jedince přivodit hypnotický stav u druhých""",
                    false
                ),
                PsychologyTermAnswer(
                    """schopnost jedince být přiveden do stavu hypnózy""",
                    false
                ),
                PsychologyTermAnswer("""náchylnost ke spánku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """reaktivitu jedince na uspávací preparáty (hypnotika)""",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Změněný stav vědomí navozovaný sugescí a provázený zvýšenou sugestibilitou označujeme jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sugestivní bezvědomí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hypnopedii""",
                    false,
                    "Učení když člověk spí (nebo je pod hypnózou)"
                ),
                PsychologyTermAnswer("""hypnózu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sugerotomii""",
                    false,
                    "neexistuje"
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín hysterie je původně odvozen od řeckého slova pro""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""ztrátu paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""divadelní masku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vášeň""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dělohu""",
                    false,
                    ""
                ),
            ),
            questionNumber = 52,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezinárodní klasifikace nemocí (10. revize) používá pro označení maniodepresivity termín""",
            textAnswer = "mánie - zvýšená energie a nálada, deprese - zhoršení nálady, snížená aktivita a energie. To je bipolární.",
            answers = listOf(
                PsychologyTermAnswer("""depresivní psychóza""",
                    false,
                    "těžká depresivní fáze s psychotickými příznaky"
                ),
                PsychologyTermAnswer("""schizoafektivní porucha""",
                    false,
                    "Epizodická porucha. Afektivní a schizofrenní symptomy, nedají se však diagnostikovat jako schizofrenní ani jako" +
                        " depresivní, či manické epizody."
                ),
                PsychologyTermAnswer("""maniodepresivní psychóza""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""bipolární afektivní porucha""",
                    false,
                    ""
                ),
            ),
            questionNumber = 53,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Stav chorobně povznesené nálady a zvýšené aktivity se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""suprese""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""fáze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """agitovanost""",
                    false,
                    "Z angličtiny agitated - neklidný"
                ),
                PsychologyTermAnswer("""mánie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Porucha, při které postižený trvale usiluje o snížení či nezvyšování tělesné hmotnosti, " +
                "omezuje příjem potravy, trpí strachem z tloušťky, a tyto projevy u něj vedou k výraznému snížení hmotnosti a jsou příp. " +
                "provázeny poruchami hormonální regulace, se označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""porucha příjmu potravy""",
                    false,
                    "kategorie nad bulimií i anorexií"
                ),
                PsychologyTermAnswer("""mentální anorexie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""endokrinní kachektický syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální bulimie""",
                    false,
                    "Opakované záchvaty přejídění a nadměrná kontrola váhy, " +
                        "vedoucí k přejídání, následovaném zvracením či použití projímadel."
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Jaký je rozsah IQ, při kterém se diagnostikuje středně těžká mentální retardace?""",
            textAnswer = "Hranice je IQ 65-68." +
                "\nV závorce starší označení" +
                "\nLehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("""50-69""",
                    false,
                    "Lehká mentální retardace IQ 50-69 (debilita)"
                ),
                PsychologyTermAnswer("""15-40""",
                    false,
                    "Těžká mentální retardace IQ 21-34 (prostá idiocie)"
                ),
                PsychologyTermAnswer("""60-89""",
                    false,
                    "Mimo hranici, je to pod 65-68 IQ"
                ),
                PsychologyTermAnswer("""35-49""",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi psychodiagnostické metody nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pozorování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""magnetická rezonance""",
                    false,
                    "zobrazovací metoda při vyšetřeních mozku"
                ),
                PsychologyTermAnswer("""rozhovor""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""testové metody""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""anamnéza""",
                    false,
                    "Medical history"
                )
            ),
            questionNumber = 57,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi psychodiagnostické metody nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pozorování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""radioizotopová vyšetření""",
                    false,
                    "PET, SPECT, scintigrafie"
                ),
                PsychologyTermAnswer("""rozhovor""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""testové metody""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""anamnéza""",
                    false,
                    "Medical history"
                )
            ),
            questionNumber = -57,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Které z uvedených označení se používá pro poruchu, " +
                "jež se vyznačuje celkovou unavitelností, " +
                "trávicími a jinými tělesnými obtížemi, " +
                "nepříjemnými pocity a snadným odváděním pozornosti?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""anankastická porucha osobnosti""",
                    false,
                    "Nadměrná svědomitost, osobní nejistota a pochyby." +
                        "\nDochází k obsedantně-kompulzivním myšlenkám, ale nejsou tak seriózní, aby to byla diagnóza."
                ),
                PsychologyTermAnswer("""hysterie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neurastenie""",
                    false,
                    "Všechno je unavující a složité (Může se také jednat fyz. aktivitu)." +
                        "\nDuševní úsílí kompletně vyšťavní a denní úkoly jsou nepřekonatelné." +
                        "\nZároveň vtíravost nevhodných asociací nebo vzpomínek." +
                        "Zvýšená podrážděnost, deprese a úzkost, přerušení spánku ale i hypersomnie (spaní třeba 12h denně)."
                ),
                PsychologyTermAnswer("""konverzní psychóza""",
                    false,
                    "Fyzické (somatické) příznaky (ochrnutí, ztráta zraku/sluchu, záchvaty apod.), často způsobené traumatickou, či stresovou situací."
                ),
            ),
            questionNumber = 58,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín enuréza označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sníženou kontrolu stolice""",
                    false,
                    "fekální inkontinence - ano, hledal jsem to"
                ),
                PsychologyTermAnswer("""neurózu s tělesnými projevy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychogenní zástavu tělesného vývoje""",
                    false,
                    "Psychogenní - způsobeno psychickými faktory (např. bolest hlavy ze stresu)"
                ),
                PsychologyTermAnswer("""pomočování""",
                    false,
                    ""
                ),
            ),
            questionNumber = 59,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Popis činností, charakteristických pro určitou profesi, a nároků, které vykonávání těchto činností klade na člověka, se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""profesní rating""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""analýza práce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pracovní záznam""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""profesiogram""",
                    false,
                    ""
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Které z uvedených označení se používá pro zkoumanou či pokusnou osobu?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""oběť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""doktorand""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""proband""",
                    false,
                    "testovaná osoba"
                ),
                PsychologyTermAnswer("""experimentand""",
                    false,
                    ""
                ),
            ),
            questionNumber = 61,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Forenzní psychologie je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""soudní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""odvětví vývojové psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie výkonu trestu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """odvětví srovnávací psychologie""",
                    false,
                    "(Komparativní psychologie) Něco jako etologie psychologie. Tedy zkoumá hlavně chování zvířat (organismů) mimo lidi.\nObčas se však definuje jako věda porovnávající zvířata s lidmi."
                ),
            ),
            questionNumber = 62,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Ve věznicích působí nejčastěji""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""psychoterapeuti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pedopsychologové""",
                    false,
                    "dětská psychologie"
                ),
                PsychologyTermAnswer("""discentní psychologové""",
                    false,
                    "lat.\"discere\"=učit se, ale nejmenuje se tak žádný směr psychologie"
                ),
                PsychologyTermAnswer("""penitenciární psychologové""",
                    false,
                    ""
                ),
            ),
            questionNumber = 63,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Starší termín psychopatie nejlépe odpovídá dnes používanému pojmu""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""antisociální poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychózy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""specifické vývojové poruchy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 64,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Psychofarmaka předepisuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""psychiatr""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""klinický psycholog""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoterapeut""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""všichni uvedení""",
                    false,
                    ""
                ),
            ),
            questionNumber = 65,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Zkratka \MMPI označuje""",
            textAnswer = "",
            imageAnswerUrl = "https://moodlehub.ca/pluginfile.php/6963/mod_book/chapter/9350/MMPI%20.jpg",
            answers = listOf(
                PsychologyTermAnswer(
                    """mezinárodní matrimoniologický a personalistický institut""",
                    false
                ),
                PsychologyTermAnswer("""Minesotský osobnostní inventář""",
                    false,
                    "MMPI. Osobnostní a psychopatologický test pro dospělé. Více než 500 tvrzení, dichotomická škála - ano/ne." +
                        "\nPoužívá se na měření psychického stavu (deprese, paranoia, schizofrenie,...)"
                ),
                PsychologyTermAnswer("""nepoužívá se""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """multivariační faktorovou interpretaci dat""",
                    false
                ),
            ),
            questionNumber = 66,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Schizofrenie patří mezi""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""kognitivně-behaviorální poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""emoční poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychotické poruchy""",
                    false,
                    "(psychózy) - "
                ),
                PsychologyTermAnswer("""neurotické poruchy""",
                    false,
                    "neuroticismus - úzkost, stres"
                ),
            ),
            questionNumber = 67,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Znalec, který rozhoduje o věrohodnosti svědecké výpovědi, je obvykle""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""forenzní psycholog""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""penitenciární psycholog""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obecný psycholog""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psycholog""",
                    false,
                    ""
                ),
            ),
            questionNumber = 68,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Který typ poruchy bývá spojen s halucinacemi či bludy""",
            textAnswer = "Fiktivní obraz/osoba/věc, který vznikne bez reálného podnětu. Člověk ji považuje za realitu.",
            answers = listOf(
                PsychologyTermAnswer("""mentální retardace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychózy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""stupor""",
                    false,
                    "neschopnost pohybu, ztuhlost"
                ),
                PsychologyTermAnswer("""neurózy""",
                    false,
                    "neuroticismus - úzkosti, stres"
                ),
            ),
            questionNumber = 69,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Přenos ve freudovské psychoterapii znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """celková informační výměna mezi klientem a terapeutem na všech komunikačních kanálech""",
                    false
                ),
                PsychologyTermAnswer(
                    """přenášení poznatků a dovedností nabytých v terapii do života""",
                    false
                ),
                PsychologyTermAnswer("""emoční působení terapeuta na klienta""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """přenášení minulých zkušeností a vztahů na terapeuta""",
                    false
                ),
            ),
            questionNumber = 70,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi projektivní metody nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Learyho Test interpersonální diagnózy""",
                    false,
                    "8 interpersonálních tendence: dominance, zodpovědnost, kooperativnost, konformita, submisivita, agresivita, afilliantnost a individuálnost"
                ),
                PsychologyTermAnswer(
                    """tematicko apercepční test""",
                    false,
                    "Projektivní test osobnosti (verbální), nejdominantnější hned po Rorschahovu testu." +
                        "\n32 černobílých obrázků s nejednoznačnými situacemi."
                ),
                PsychologyTermAnswer(
                    """asociační experiment""",
                    false,
                    "Jung četl seznam slov nahlas a čekal na asociace, které slova evokovaly v recipientovi.\n" +
                        "Analytická škola, kolektivní nevědomí, Archetypy, introverze-extroverze, věřící, švýcar."
                ),
                PsychologyTermAnswer(
                    """Rorschachův test""",
                    false,
                    "Projektivní test osobnosti. 10 víceméně symetrických pestrých/nepestrých skvrn."
                ),
            ),
            questionNumber = 71,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Psychofarmaka mohou předepisovat""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""psychoterapeuti a psychiatři""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologové a psychiatři""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychiatři a další lékaři""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kliničtí psychologové a psychiatři (""",
                    false,
                    ""
                ),
            ),
            questionNumber = 72,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi aplikované psychologické disciplíny nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dopravní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vývojová psychologie""",
                    false,
                    "základní obor, není aplikovaný"
                ),
                PsychologyTermAnswer("""klinická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychodiagnostika""",
                    false,
                    "Kombinace psychologie osobnosti a diferenciální psychologie. Zjišťování a měření duševních vlastností a stavů."
                ),
            ),
            questionNumber = 73,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi aplikované psychologické disciplíny nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""klinická poradenská psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obecná psychologie""",
                    false,
                    "základní obor, není aplikovaný"
                ),
                PsychologyTermAnswer("""pedagogická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie práce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie sportu""",
                    false,
                    ""
                ),
            ),
            questionNumber = -973,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi aplikované psychologické disciplíny nepatří""",
            textAnswer =  "",
            answers = listOf(
                PsychologyTermAnswer("""psychologie reklamy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kognitivní psychologie""",
                    false,
                    "základní obor, není aplikovaný"
                ),
                PsychologyTermAnswer("""psychologie náboženství""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kosmická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychoterapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie dopravy""",
                    false,
                    ""
                ),
            ),
            questionNumber = -974,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi aplikované psychologické disciplíny nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""inženýrská psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""biologická psychologie""",
                    false,
                    "základní obor, není aplikovaný"
                ),
                PsychologyTermAnswer("""psychologie konfliktu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lékařská psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""manažerská psychologie""",
                    false,
                    ""
                ),
            ),
            questionNumber = -975,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi aplikované psychologické disciplíny nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""politická psychologie"""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie osobnosti""",
                    false,
                    "základní obor, není aplikovaný"
                ),
                PsychologyTermAnswer("""školní psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie trhu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie umění""",
                    false,
                    ""
                ),PsychologyTermAnswer("""vojenská psychologie""",
                    false,
                    ""
                ),
            ),
            questionNumber = -976,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi aplikované psychologické disciplíny nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""psychologie zdráví a psychologie nemocí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychopatologie""",
                    false,
                    "základní obor, není aplikovaný"
                ),
                PsychologyTermAnswer("""psychologie životního prostředí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""biopsychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dějiny psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""farmakopsychologie""",
                    false,
                    ""
                ),
            ),
            questionNumber = -977,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Mezi aplikované psychologické disciplíny nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""psycholingvistika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologická metodologie""",
                    false,
                    "základní obor, není aplikovaný"
                ),
                PsychologyTermAnswer("""psychometrika""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychodiagnostika""",
                    false,
                    "Kombinace psychologie osobnosti a diferenciální psychologie. Zjišťování a měření duševních vlastností a stavů."
                ),
                PsychologyTermAnswer("""zoopsychologie""",
                    false,
                    ""
                ),
            ),
            questionNumber = -978,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Psychosomatika se zabývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """psychickými příčinami některých tělesných chorob a jejich psychologickým ovlivňováním""",
                    false
                ),
                PsychologyTermAnswer(
                    """biologickými příčinami psychických poruch""",
                    false
                ),
                PsychologyTermAnswer(
                    """léčbou psychických poruch biologickými prostředky""",
                    false
                ),
                PsychologyTermAnswer(
                    """problematikou spirituálních potřeb v lidském životě""",
                    false
                ),
            ),
            questionNumber = 74,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Uvolnění tělesného či psychického napětí se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""difuze""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rekreace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dilatace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""relaxace""",
                    false,
                    ""
                ),
            ),
            questionNumber = 75,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Nespecifickou odpověď na narušení vnitřní rovnováhy organismu označujeme termínem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""autoregulace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """homeostáza""",
                    false,
                    "V angličtině homeostasis. Z řečtiny (hómoios, \", podobný, stejný\") + z řečtiny (stásis, \"zůstávající, stav\")"
                ),
                PsychologyTermAnswer("""stres""",
                    false,
                    "obecný termín pro reakci těla na podnět"
                ),
                PsychologyTermAnswer("""distres""",
                    false,
                    "po vystavení přetrvávajícímu/intenzivnímu nepříznivému podnětu"
                ),
            ),
            questionNumber = 76,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Anxiolytika se používají především při""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""léčbě úzkosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""prevenci sexuálně deviantního chování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""léčbě depresivních stavů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""léčbě psychotických symptomů""",
                    false,
                    "antipsychotika (např. chlorpromazin, klozapin, olanzapin, risperidon)"
                ),
            ),
            questionNumber = 77,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Léčba elektrošoky se používá především při""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""poruchách chování""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epilepsii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""depresivních poruchách""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v současné době se nepoužívá""",
                    false,
                    ""
                ),
            ),
            questionNumber = 78,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Negativní stresová odpověď se označuje jako:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nespecifická aktivačně-inhibiční reakce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""distres""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""eustres""",
                    false,
                    "\"beneficial stress\" - řec. eu=dobrý, třeba normální hladina stresu před přijímačkami, který člověka posouvá kupředu."
                ),
                PsychologyTermAnswer("""xenostres""",
                    false,
                    "neexistuje"
                ),
            ),
            questionNumber = 79,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Tzv. hysterická osobnost se dnes klasifikuje (dle MKN 10) jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""histrionská porucha osobnosti""",
                    false,
                    "sebedramatizace, teatrálnost, labilní afektivitou, přehnaný projev emocí"
                ),
                PsychologyTermAnswer("""hysterický habitus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""narcistická porucha osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hysterická afektivní poruchy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 80,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """THC je látka obsažená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v Prozacu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v bramborách""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v hypnotikách""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v marihuaně""",
                    false,
                    ""
                ),
            ),
            questionNumber = 81,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Psychoterapie je""",
            textAnswer = "Záměrné a cílené používání psychoterapeutických prostředků kvalifikovaným odborníkem",
            answers = listOf(
                PsychologyTermAnswer("""léčba lehčích duševních poruch""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """léčba a poradenství v oblasti duševních poruch""",
                    false
                ),
                PsychologyTermAnswer("""léčba psychologickými prostředky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""léčba duševních poruch""",
                    false,
                    ""
                ),
            ),
            questionNumber = 82,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Slovo strabismus označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""šilhání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchu příjmu potravy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""antisociální poruchu osobnosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ortopedické problémy v dětství""",
                    false,
                    ""
                ),
            ),
            questionNumber = 83,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Slovo anxieta znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """stav před nástupem epileptického záchvatu""",
                    false,
                    "Aura"
                ),
                PsychologyTermAnswer("""nespavost""",
                    false,
                    "insomnie"
                ),
                PsychologyTermAnswer("""úzkost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""spavost""",
                    false,
                    ""
                ),
            ),
            questionNumber = 84,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Slovo lakrimozita znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""poruchu funkce štítné žlázy""",
                    false,
                    "tyreopatie - nadměrná produkce hormonů štítné žlázy"
                ),
                PsychologyTermAnswer("""bojácnost""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchu tvorby mateřského mléka""",
                    false,
                    "hypogalaktie"
                ),
                PsychologyTermAnswer("""plačtivost""",
                    false,
                    "Opakem je sjögrenův syndrom - suchost očí a úst."
                ),
            ),
            questionNumber = 85,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Teratologie se zabývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """studiem vad vznikajících během nitroděložního vývoje""",
                    false
                ),
                PsychologyTermAnswer("""hereckými technikami sebevyjádření""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """studiem vlivu složení zemské kůry na fyziologické procesy""",
                    false
                ),
                PsychologyTermAnswer("""léčbou psychogenních kožních onemocnění""",
                    false,
                    "Psychogenní - způsobeno psychickými faktory (např. bolest hlavy ze stresu)"
                ),
            ),
            questionNumber = 86,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Thanatologie je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """psychoanalytická teorie o fungování pudu smrti""",
                    false,
                    "Thanatos. Pud života je Eros."
                ),
                PsychologyTermAnswer("""klasifikace smrtelných chorob""",
                    false,
                    "Mortalitní klasifikace."
                ),
                PsychologyTermAnswer(
                    """nauka o psychologických a lékařských aspektech smrtí a umírání""",
                    false
                ),
                PsychologyTermAnswer("""úzkostný strach ze smrti""",
                    false,
                    "thanatofobie"
                ),
            ),
            questionNumber = 87,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Thanatos je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """psychoanalytická teorie o fungování pudu smrti""",
                    false
                ),
                PsychologyTermAnswer("""klasifikace smrtelných chorob""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """nauka o psychologických a lékařských aspektech smrtí a umírání""",
                    false,
                    "Thanatologie"
                ),
                PsychologyTermAnswer("""úzkostný strach ze smrti""",
                    false,
                    "thanatofobie"
                ),
            ),
            questionNumber = -87,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Thanatofobie je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """psychoanalytická teorie o fungování pudu smrti""",
                    false
                ),
                PsychologyTermAnswer("""klasifikace smrtelných chorob""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """nauka o psychologických a lékařských aspektech smrtí a umírání""",
                    false,
                    "Thanatologie"
                ),
                PsychologyTermAnswer("""úzkostný strach ze smrti""",
                    false
                ),
            ),
            questionNumber = -88,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Štíhlou postavou, dlouhými končetinami, úzkým hrudníkem a relativně slabým svalstvem se vyznačuje""",
            textAnswer = "Konstituční typologie osobnosti, E. Kretschmer" +
                "\nE. Kretschmer se snažil se spojit fyziologickou postavu jedince k patologii." +
                "\nAstenický, leptosomní (schizothymní) typ - štíhlý, vysoký - náladový, nervózní." +
                "\nAtletický (viskózní) typ - vyrovnaný, nic mu není." +
                "\nPyknický (cyklothymní) typ - zkulacená postava - emočně labilní, impulsivní, maniodeprese." +
                "\nDysplastický - kombinace astenického a pyknického typu",
            imageAnswerUrl = "https://images.slideplayer.cz/42/11269088/slides/slide_10.jpg",
            answers = listOf(
                PsychologyTermAnswer("""astenický syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""astenický typ""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""leptosomní syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pyknický typ""",
                    false,
                    ""
                ),
            ),
            questionNumber = 88,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Tyflopedie je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """disciplína zabývající se výchovou a vzděláváním zrakově postižených""",
                    false
                ),
                PsychologyTermAnswer(
                    """disciplína zabývající se výchovou a vzděláváním pohybově postižených""",
                    false,
                    "Speciální pedagogika, defektologie, ergoterapie."
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """disciplína zabývající se výchovou a vzděláváním sluchově postižených""",
                    false,
                    "surdopedie"
                ),
            ),
            questionNumber = 89,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Surdopedie je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """disciplína zabývající se výchovou a vzděláváním zrakově postižených""",
                    false,
                    "Tyflopedie"
                ),
                PsychologyTermAnswer(
                    """disciplína zabývající se výchovou a vzděláváním pohybově postižených""",
                    false,
                    "Speciální pedagogika, defektologie, ergoterapie."
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """disciplína zabývající se výchovou a vzděláváním sluchově postižených""",
                    false
                ),
            ),
            questionNumber = -89,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Osobnostní typ A je náchylný k""",
            textAnswer = "Friedmanova a Rosenmanova teorie osobnosti",
            imageAnswerUrl = "https://i.pinimg.com/originals/4d/5e/00/4d5e00dde635db1bee998f801e6cfbdd.jpg",
            answers = listOf(
                PsychologyTermAnswer("""epilepsii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""srdečním poruchám""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""kožním chorobám""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchám příjmu potravy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 90,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Viktimologie se zabývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """mimořádnými projevy prosociálního chování""",
                    false
                ),
                PsychologyTermAnswer("""průběhem soudního přelíčení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""oběťmi trestných činů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pachateli trestných činů""",
                    false,
                    "kriminologie"
                ),
            ),
            questionNumber = 91,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Abulie znamená""",
            textAnswer = "Ztráta schopnosti zahájit určitou činnost, porucha vůle (např. deprese). (hypobulie - oslabená vůle, nerozhodnost)",
            answers = listOf(
                PsychologyTermAnswer("""nedostatek vůle""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nekontrolovatelné přejídáni""",
                    false,
                    "bulimie"
                ),
                PsychologyTermAnswer("""poruchu vegetativních reakci""",
                    false,
                    "dysautonomie"
                ),
                PsychologyTermAnswer("""hladovění""",
                    false,
                    "anorexie"
                ),
            ),
            questionNumber = 92,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Dysautonomie znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nedostatek vůle""",
                    false,
                    "abulie"
                ),
                PsychologyTermAnswer("""nekontrolovatelné přejídáni""",
                    false,
                    "bulimie"
                ),
                PsychologyTermAnswer("""poruchu vegetativních reakci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hladovění""",
                    false,
                    "anorexie"
                ),
            ),
            questionNumber = -92,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Škodlivé užívání toxických látek se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""úzus""",
                    false,
                    "lat. usus= užití, dovednost, zvyk. Zvyklosti, postupy a pravidla v dané společnosti"
                ),
                PsychologyTermAnswer("""desinhibice""",
                    false,
                    "Neschopnost se ovládnout"
                ),
                PsychologyTermAnswer("""profylaxe""",
                    false,
                    "Prevence před nemocemi u jedinců, kteří jsou na určité nemoci třeba náchylní"
                ),
                PsychologyTermAnswer("""abúzus""",
                    false,
                    "lat. abusus=zneužití, přemíra užití"
                ),
            ),
            questionNumber = 93,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Muž má v zaměstnání konflikt s nadřízeným. " +
                "\nPosléze svým útočným chováním doma vyvolá konflikt s partnerkou. Hovoříme zde o",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""konfliktní senzitizaci""",
                    false,
                    "Opakovaná expozice stresujícím situacím zvyšuje citlivost jedince na tyto situace."
                ),
                PsychologyTermAnswer("""opožděné agresi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přesunuté agresi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""připravenosti ke konfliktu""",
                    false,
                    ""
                ),
            ),
            questionNumber = 94,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Práce na úpravě zkreslených myšlenkových postupů a nevhodných vzorců chování je typická pro""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""kognitivně behaviorální terapii""",
                    false,
                    "KBT - stoicismus - nejde o svět okolo nás, ale jak ten svět okolo nás vnímáme." +
                        "\nTedy jsme se něco naučili špatně a KBT se snaží nás to naučit správně."
                ),
                PsychologyTermAnswer("""dynamickou psychoterapii""",
                    false,
                    "Vyšlo z psychoanalýzy - nevědomé procesy."
                ),
                PsychologyTermAnswer("""systemickou psychoterapii""",
                    false,
                    "Holistický pohled na problém - když řešíme problém dítěte, pozveme si celou rodinu."
                ),
                PsychologyTermAnswer("""psychoanalytickou psychoterapii""",
                    false,
                    ""
                ),
            ),
            questionNumber = 95,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Terapeut nařídí klientovi trpícímu nespavostí, aby večer ulehl do postele a snažil se neusnout. Jde o příklad""",
            textAnswer = "Postavení se strachu jako řešení - intencionální létání letadlem pokud se bojím - dělání opaku.",
            answers = listOf(
                PsychologyTermAnswer("""terapeutického pesimismu""",
                    false,
                    "Terapeut odstraní všechna očekávání a pomůže pacientovi pochopit, že terapie nebude hned a bude složitá."
                ),
                PsychologyTermAnswer("""intencionální symptomatologie""",
                    false,
                    "Cílené chování jakožto symptom nečeho. Slouží v odlišení co bylo cílené a co ne."
                ),
                PsychologyTermAnswer("""paradoxní intence""", false,
                    "Frankl, Postavení se strachu jako řešení - intencionální létání letadlem pokud se bojím - dělání opaku."
                ),
                PsychologyTermAnswer("""behaviorální terapie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 96,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín insomnie znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""zaměření na tělo v meditaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""somaticky podmíněná porucha vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mrákotný stav""",
                    false,
                    "synkopa"
                ),
                PsychologyTermAnswer("""nespavost""",
                    false,
                    ""
                ),
            ),
            questionNumber = 97,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """REM spánek se vyznačuje mj.""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""rychlými očními pohyby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obojím""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""absencí snů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ničím z uvedených""",
                    false,
                    ""
                ),
            ),
            questionNumber = 98,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Psychoterapie zaměřená na klienta se označuje také jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""klientská psychoterapie""",
                    false,
                    "client-centered therapy jedině"
                ),
                PsychologyTermAnswer("""Rogersovská psychoterapie""",
                    false,
                    "nedirektivní psychoterapie"
                ),
                PsychologyTermAnswer("""Franklovská psychoterapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""direktivní psychoterapie""",
                    false,
                    "psychoterapie se dělí na" +
                        "\nDirektivní - přímé usměrňování myšlení, postojů a chování. Příkazy, rady a sugesce." +
                        "\nNedirektivní - psychoterapeut je mediátor, příznivá atmosféra vytvořena pro sebeexploraci."
                ),
            ),
            questionNumber = 99,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Uzavřená psychoterapeutická skupina je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""skupina s nízkou dynamikou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """skupina s nízkou tolerancí vůči novým příchozím""",
                    false
                ),
                PsychologyTermAnswer(
                    """skupina pořádaná na uzavřeném psychiatrickém oddělení""",
                    false
                ),
                PsychologyTermAnswer(
                    """skupina, ze které neodcházejí a do níž nepřicházejí pacienti""",
                    false
                ),
            ),
            questionNumber = 100,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Jednou ze základních veličin, která se zjišťuje při měření na tzv. detektoru lži je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""kožně galvanická reakce""",
                    false,
                    "SCR [skin conductance response, odezva vodivosti kůže]"
                ),
                PsychologyTermAnswer("""směr pohledu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""změny šíře zornic""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""složení krve""",
                    false,
                    ""
                ),
            ),
            questionNumber = 101,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Tzv. Baum-test patří mezi""",
            textAnswer = "Kresba stromu, něm. Baum=strom",
            answers = listOf(
                PsychologyTermAnswer("""grafemické techniky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""objektivní testy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""projektivní techniky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dotazovací testy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 102,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Vývojová porucha čtení, při které nejsou postiženy jiné intelektové schopnosti, se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dysortografie""",
                    false,
                    "porucha psaní v rámci gramatiky a pravopisu"
                ),
                PsychologyTermAnswer("""dysgrafie""",
                    false,
                    "porucha psaní, jemné motorické dovednosti"
                ),
                PsychologyTermAnswer("""agrafie""",
                    false,
                    "porucha psaní kvůli poškozenému mozku"
                ),
                PsychologyTermAnswer("""dyslexie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 103,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Staré označení imbecilita odpovídá dnešnímu označení""",
            textAnswer = "Hranice je IQ 65-68." +
                "\nV závorce starší označení" +
                "\nLehká mentální retardace IQ 50-69 (debilita)" +
                "\nStředně těžká mentální retardace IQ 35-49 (imbecilita)" +
                "\nTěžká mentální retardace IQ 21-34 (prostá idiocie)" +
                "\nHluboká mentální retardace pod IQ 20 (těžká idiocie)",
            answers = listOf(
                PsychologyTermAnswer("""středně těžká mentální retardace""",
                    false,
                    "Středně těžká mentální retardace IQ 35-49 (imbecilita)"
                ),
                PsychologyTermAnswer("""středně těžká demence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lehká demence""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""hluboká mentální retardace""",
                    false,
                    "Hluboká mentální retardace pod IQ 20 (těžká idiocie)"
                ),
            ),
            questionNumber = 104,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Trizomie 21. chromozomu způsobuje""",
            textAnswer = "Trizomie - 3 kopie chromozomu",
            answers = listOf(
                PsychologyTermAnswer("""Mendelův syndrom""",
                    false,
                    "mutace 17. chromozomu (neurofibromatóza typu 1 - NF1) - velká náchylnost na nádory, kávové skvrny na kůži."
                ),
                PsychologyTermAnswer("""Downův syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""astenický syndrom""",
                    false,
                    "astenie - slabost, únava"
                ),
                PsychologyTermAnswer("""fenylketonurii""",
                    false,
                    "(PKU) - neschopnost rozkládat aminokyselinu, která se pak hromadí v krvi a může způsobit poškození mozku."
                ),
                PsychologyTermAnswer("""Edwardsův syndrom""",
                    false,
                    "trizomie 18. chromozomu. Malá hlava, nízká porodnostní hmotnost, deformace hrudi, srdeční vady, spoždění řečnické a motorické dovedností."
                ),
                PsychologyTermAnswer("""Patuův syndrom""",
                    false,
                    "trizomie 13. chromozomu. Malformace mozku, očí, nosu a uší, rozštěp rtu a ptra, mentální retardace."
                ),
            ),
            questionNumber = 105,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Zkratka DSM označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""poruchu senzorických mediátorů""",
                    false,
                    "senzorická dysfunkce"
                ),
                PsychologyTermAnswer("""test pozornosti""",
                    false,
                    "třeba tachistoskop"
                ),
                PsychologyTermAnswer(
                    """diagnostický a statistický manuál (americká klasifikace nemocí)""",
                    false
                ),
                PsychologyTermAnswer("""Downův motorický syndrom""",
                    false,
                    ""
                ),
            ),
            questionNumber = 106,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Výkon testu může být ovlivněn""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""všemi uvedenými faktory""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""měřenou veličinou""",
                    false,
                    "například pokud měříme matematické schopnosti - záleží na matematickém vzdělání"
                ),
                PsychologyTermAnswer("""motivací probanda""",
                    false,
                    "Proband - testovaná osoba" +
                        "\nRespondent - dotazovaná osoba"
                ),
                PsychologyTermAnswer("""zdravotním stavem probanda""",
                    false,
                    "Proband - testovaná osoba" +
                        "\nRespondent - dotazovaná osoba"
                ),
            ),
            questionNumber = 107,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Při vyšetření laterality zjišťujeme""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """maximální úhel, který je ještě v zorném poli""",
                    false
                ),
                PsychologyTermAnswer(
                    """sklon pacienta stavět se stranou ostatních pacientů s odůvodněním, že je hospitalizován z jiného důvodu""",
                    false
                ),
                PsychologyTermAnswer("""cévní zásobení různých oblastí mozku""",
                    false,
                    "cerebrovaskulární zásobení"
                ),
                PsychologyTermAnswer(
                    """tendenci k preferenčnímu používání motorických či senzorických párových orgánů na jedné straně těla""",
                    false
                ),
            ),
            questionNumber = 108,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín hypobulie označuje""",
            textAnswer = "nerozhodnost",
            answers = listOf(
                PsychologyTermAnswer("""přehnané ambice""",
                    false,
                    "hyperambice"
                ),
                PsychologyTermAnswer("""nedostatečný příjem potravy""",
                    false,
                    "anorexie"
                ),
                PsychologyTermAnswer("""oslabenou vůli""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""snížené sebeovládání""",
                    false,
                    "impulzivita"
                ),
            ),
            questionNumber = 109,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Pocit, který někdy bezprostředně předchází epileptickému záchvatu, se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""resentiment""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""aura""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""preepileptický senzus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""aurora""",
                    false,
                    ""
                ),
            ),
            questionNumber = 110,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Brazeltonova škála se používá při hodnocení""",
            textAnswer = "Hodnocené oblasti:" +
                "\n\t1. interakční chování (reaktivita na soc. partnera)" +
                "\n\t2. motorika" +
                "\n\t3. behaviorální stabilita (do jaké míry je dítě dráždivé a následně uklidnitelné)" +
                "\n\t4. fyziologická stabilita - (fyz. reakce na stres - třes, změna barvy kůže, apod.)",
            answers = listOf(
                PsychologyTermAnswer("""neuroticismu u předškolních dětí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sklonů k agresivitě u adolescentů""",
                    false,
                    "APS, ADF, ADP, AQ - A=agresivita"
                ),
                PsychologyTermAnswer("""pozornosti u dospělých""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""neurobehaviorálních projevů novorozenců""",
                    false,
                    "1. Klidný spánek bez očních pohybů" +
                        "\n2. REM spánek" +
                        "\n3. dřímota či klimbání či usínání" +
                        "\n4. klidné bdění" +
                        "\n5. neklidné bdění s otevřenýma očima a motorickou aktivitou" +
                        "\n6. křik či pláč"
                ),
            ),
            questionNumber = 111,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Která psychoterapeutická škola pracuje s rozdělením ega na stavy rodiče, dospělého a dítěte?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""systemická terapie""",
                    false,
                    "Holistický pohled na problém - když řešíme problém dítěte, pozveme si celou rodinu."
                ),
                PsychologyTermAnswer(
                    """transakční analýza""",
                    false,
                    "E. Berne" +
                        "\nMezilidská komunikace. Inspiruje se v psychoanalýze: tři roviny osobnosti:" +
                        "\nDítě - vzpomínky z dětství a naše dětskost (hravost, bezmocnost, spontaneita, hravost,...)." +
                        "\nRodič - vzpomínky toho, co jsme jako děti slyšeli od rodičů a naše rodičovskost (autorita, poučování, dohled,...)." +
                        "\nDospělý - rozumě založené informace, vlastní názory." +
                        "\nPoté analyzujeme  konverzaci jako Dospělý - Dítě bez ohledu na věku."
                ),
                PsychologyTermAnswer("""hypnoterapie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""interpersonální psychoterapie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 112,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Jak se označuje vcítění do druhého člověka?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""extrospekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""introspekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sympatie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""empatie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 113,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Vztahem člověka, technických systémů a pracovního prostředí se zabývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""laboronomie""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""ergonomie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""lobotomie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychologie organizace""",
                    false,
                    ""
                ),
            ),
            questionNumber = 114,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Cirkadiánní rytmus má periodu""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""cca. 8 hod.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""cca. 16 hod.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""cca. 24 hod.""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""cca. 12 hod.""",
                    false,
                    ""
                ),
            ),
            questionNumber = 115,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Slovo parafilie je jiné označení pro""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nesobeckou lásku""",
                    false,
                    "agapé - (lat. caritas - charité - charity) láska pečující"
                ),
                PsychologyTermAnswer("""psychopatii""",
                    false,
                    "neschopnost projevit empatie"
                ),
                PsychologyTermAnswer("""akcentované osobnostní komponenty""",
                    false,
                    "výraznější osobnostní rysy než jsou běžné v populaci"
                ),
                PsychologyTermAnswer("""sexuální deviace""",
                    false,
                    ""
                ),
            ),
            questionNumber = 116,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Sopor patří mezi""",
            textAnswer = "Druhý stupeň kvantitativních poruch vědomí" +
                "\n1. Synkopa - krátkodobá porucha vědomí, se ztrátou sval. napětí" +
                "\n2. Somnolence - reaguje na oslovení" +
                "\n3. Sopor - hluboký spánek, závratná ospavost (schopno probudit intenzivním podnětem)" +
                "\n4. Kóma - nereaguje",
            answers = listOf(
                PsychologyTermAnswer("""poruchy vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""opiáty""",
                    false,
                    "Opioidní analgetika (tlumiče bolesti, dříve od opia (narkotika) - na spánek)" +
                        "\n1. Od molekuly morfinu (z makovic máku setého):" +
                        "\n\t\t-přirozené (alkaloidy) - morfin, kodein" +
                        "\n\t\t-polosyntetické - heroin, hydromorfon, oxykodon" +
                        "\n2. Syntetické (od moleky fenylpiperazin)" +
                        "\n\t\t-metadon, fentanyl, petidin, megafon"
                ),
                PsychologyTermAnswer("""poruchy myšlení""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchy vědomí""",
                    false,
                    ""
                ),
            ),
            questionNumber = 117,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Narkoanalýza je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """analytický přístup ke studiu drogové závislosti""",
                    false
                ),
                PsychologyTermAnswer("""analýza složení psychotropní látky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """diagnostický rozhovor s pacientem, který je pod vlivem obluzujících psychofarmak""",
                    false
                ),
            ),
            questionNumber = 118,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Co to je ataxie?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""hyperkinetická porucha""",
                    false,
                    "ADHD"
                ),
                PsychologyTermAnswer("""porucha příjmu potravy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""porucha koordinace pohybů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""porucha navazování sociálních vazeb""",
                    false,
                    ""
                ),
            ),
            questionNumber = -119,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Co to je ataxie?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""hyperkinetická porucha""",
                    false,
                    "ADHD"
                ),
                PsychologyTermAnswer("""porucha příjmu potravy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""porucha koordinace pohybů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""porucha navazování sociálních vazeb""",
                    false,
                    ""
                ),
            ),
            questionNumber = -119,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Která z následujících poruch se dává do souvislosti s autismem?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""hyperkinetická porucha""",
                    false,
                    "ADHD"
                ),
                PsychologyTermAnswer("""hebefrenie""",
                    false,
                    "specifická forma schizofrenie"
                ),
                PsychologyTermAnswer("""schizofrenie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Aspergerův syndrom""",
                    false,
                    "DSM-5 má přímo v autistickém spektru." +
                        "\nNemá opoždění ve vývoji řeči a kognitivních schopností."
                ),
            ),
            questionNumber = 119,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Autismus patří mezi""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""psychotické poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""osobnostní rysy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pervazivní vývojové poruchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""komunikační poruchy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 120,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Záchvatovité přejídání, které je často následováno vyvoláváním zvracení, se nazývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""stravovací fobie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální bulimie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mentální anorexie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""reaktivní zvracení""",
                    false,
                    ""
                ),
            ),
            questionNumber = 121,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Chorobný strach z pavouků se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""generalizovaná úzkostná porucha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""agorafobie""",
                    false,
                    "agora=kde se sjednocují lidé. Fóbie z otevřených prostorů a nemožnosti být v \"bezpečné zóně\""
                ),
                PsychologyTermAnswer("""hydrofobie""",
                    false,
                    "hydro=voda"
                ),
                PsychologyTermAnswer("""arachnofobie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 122,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených starších termínů má nejblíže k označení bipolární afektivní poruchy?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """schizotymie""",
                    false,
                    """Sociální rezervovanost."""
                ),
                PsychologyTermAnswer(
                    """cyklotymie""",
                    false,
                    """Dlouhodobé střídaní nálad od mírné deprese po mírné elace (veselo). 
                         Kontroverze - afektivní vs. temperamentová porucha."""
                ),
                PsychologyTermAnswer("""leptosomie""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer(
                    """ambivalence""",
                    false,
                    """současně jsou přítomné kladné i záporné emoce, nálady a city. Časté u schizofrenie, fobií, depresí"""
                ),
            ),
            questionNumber = 123,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Zhoršení choroby po předchozím zlepšení se označuje""",
            textAnswer = "",
            imageAnswerUrl = "https://slideplayer.cz/slide/2874175/10/images/14/Etapy+l%C3%A9%C4%8Dby+depresivn%C3%AD+poruchy.jpg",
            answers = listOf(
                PsychologyTermAnswer("""agravace""",
                    false,
                    "Zveličování obtíží pacientem."
                ),
                PsychologyTermAnswer("""remise""",
                    false,
                    "Návrat do normálu po nemoci, bez symptomů, očekává se však že nemoc tam je, pouze nemá symptomy."
                ),
                PsychologyTermAnswer("""resurekce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""relaps""",
                    false,
                    "zhoršení choroby po předchozím zlepšení stavu"
                ),
                PsychologyTermAnswer("""recidiva""",
                    false,
                    "Opakovaný návrat do nežádoucí situace"
                ),
            ),
            questionNumber = 124,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Jako remise se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""posudek soudního znalce""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ústup příznaků choroby""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """zhoršení choroby po předchozím zlepšení stavu""",
                    false,
                    "relaps"
                ),
                PsychologyTermAnswer("""porucha epizodické paměti po úrazu""",
                    false,
                    "amnézie"
                ),
            ),
            questionNumber = 125,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Dítě začne několik měsíců po závažné dopravní, kdy samo nebylo vážně zraněno, trpět nespavostí," +
                " nesoustředěností a opakovaně se u něj objevují nepříjemné a nepotlačitelné vzpomínky na nehodu. Jedná se patrně o",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""posttraumatickou stresovou poruchu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""poruchu integračních procesů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""noční děsy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""válečný šok""",
                    false,
                    ""
                ),
            ),
            questionNumber = 126,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech označíme jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""iluzi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pseudohalucinaci""",
                    false,
                    "třeba u LSD, kdy vidímě věci, které tam nejsou, ale víme o tom"
                ),
                PsychologyTermAnswer("""schizotypní myšlení""",
                    false,
                    "\"schizofrenní myšlení\""
                ),
                PsychologyTermAnswer("""blud""",
                    false,
                    "Nevývratné a iracionálně odůvodňované chorobné přesvědčení o nějakých skutečnostech"
                ),
            ),
            questionNumber = 127,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Činností operátora ve velíně elektrárny se zabývá zejména""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""psychodiagnostika""",
                    false,
                    "Kombinace psychologie osobnosti a diferenciální psychologie. Zjišťování a měření duševních vlastností a stavů."
                ),
                PsychologyTermAnswer("""psychotechnika""",
                    false,
                    "H. Münsterberg, nástroj pro psychologický výběr pracovníků (vojáků) na pozice"
                ),
                PsychologyTermAnswer(
                    """inženýrská psychologie""",
                    false,
                    "Inženýrská psychologie zkoumá procesy a prostředky řídící interakce mezi člověkem a technickým zařízením. Inženýrská psychologie vyrůstá z tradice experimentální psychologie." +
                        "\nKooperace mezi člověkem a zařízením, efektivita, kvalita, přesnost, příjem informací člověkem."
                ),
                PsychologyTermAnswer("""xenopsychologie""",
                    false,
                    "psychologie mimozemšťanů"
                ),
            ),
            questionNumber = 128,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Studiem simulátorů ze zabývá především""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """inženýrská psychologie""",
                    false,
                    "Inženýrská psychologie zkoumá procesy a prostředky řídící interakce mezi člověkem a technickým zařízením. Inženýrská psychologie vyrůstá z tradice experimentální psychologie." +
                        "\nKooperace mezi člověkem a zařízením, efektivita, kvalita, přesnost, příjem informací člověkem."
                ),
                PsychologyTermAnswer("""automatická psychologie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""psychotechnika""",
                    false,
                    "H. Münsterberg, nástroj pro psychologický výběr pracovníků (vojáků) na pozice"
                ),
                PsychologyTermAnswer("""programová psychologie""",
                    false,
                    ""
                ),
            ),
            questionNumber = 129,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín hyperprosexie označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""neschopnost relaxace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přehnané školní nároky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přílišné těkání pozornosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nadměrné soustředění pozornosti""",
                    false,
                    "třeba pod vlivem psychostimulačních látek, u mánie apod."
                ),
            ),
            questionNumber = 130,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín hypoprosexie označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""neschopnost relaxace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přehnané školní nároky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přílišné těkání pozornosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""snížená kvalita pozornosti""",
                    false,
                    "deprese, fyz. vyčerpání,  kognitivní deficit,..."
                ),
            ),
            questionNumber = -130,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Termín aprosexie označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""neschopnost relaxace""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přehnané školní nároky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""přílišné těkání pozornosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úplná ztráta pozornosti""",
                    false,
                    "třeba sopor, těžkých psychóz"
                ),
            ),
            questionNumber = -131,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Péče zmírňující utrpení nevyléčitelných pacientů se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""neúčelová""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""anxiolytická""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""paliativní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""terminátní""",
                    false,
                    ""
                ),
            ),
            questionNumber = 131,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Metadon""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""není návykový""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""užívá se při léčbě opiátových závislostí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""má závažný dopad na psychiku závislého""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""se dnes již téměř neužívá""",
                    false,
                    ""
                ),
            ),
            questionNumber = 132,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Anankastická osobnost se vyznačuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""asociálními rysy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""puntičkářstvím""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nezdrženlivostí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obsesemi a histrionskými rysy""",
                    false,
                    "Obsese:" +
                        "\n\tOpakované, vtíravé myšlenky (nápady), pudy a činy." +
                        "\n\tCingular Gyrus - mimovolní pohyby (aktivuje se u lidí s obsesí více)." +
                        "\n\nHistrionská porucha osobnosti:" +
                        "\n\tsebedramatizace, teatrálnost, labilní afektivitou, přehnaný projev emocí"
                ),
            ),
            questionNumber = 133,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Assessment Centre""",
            textAnswer = "Metoda výběru zaměstnanců. Rozhovory, skupiné cvičení apod.",
            answers = listOf(
                PsychologyTermAnswer("""ani jedna odpověď není správně""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """je speciální individuální, někdy i skupinová forma výběrového řízení""",
                    false
                ),
                PsychologyTermAnswer(
                    """je místnost sloužící diagnostickým účelům""",
                    false
                ),
                PsychologyTermAnswer("""vždy zahrnuje modelové situace""",
                    false,
                    ""
                ),
            ),
            questionNumber = 134,
            correctAnswer = 3,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Vznik citové vazby mezi zajatcem a věznitelem bývá označován jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""londýnský syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""forenzní přenos""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""stockholmský syndrom""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""příklad pragmatické komunikace""",
                    false,
                    ""
                ),
            ),
            questionNumber = 135,
            correctAnswer = 2,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Sekundární viktimizace je způsobována například""",
            textAnswer = "(Druhotné zraňování) v kriminologii, po publikaci trestného činu trpí obět znovu, psychicky." +
                "\nV případě obětí znásilnění má okolí tendenci dávat čin za vinu částečně i oběti.",
            answers = listOf(
                PsychologyTermAnswer("""vzpomínkami oběti na trestný čin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""soudním procesem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ani jedna odpověď není správně""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""obě odpovědi jsou správně""",
                    false,
                    ""
                ),
            ),
            questionNumber = 136,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = "Výraz \"lehké mozkové dysfunkce\" je v současném diagnostickém úzu nahrazován výrazem/výrazy",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""lehké dětské encefalopatie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """specifické vývojové poruchy učení a hyperkinetické poruchy""",
                    false,
                    "hyperkinetická porucha - ADHD"
                ),
                PsychologyTermAnswer("""vývojové dyslexie a ADHD""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """specifické vývojové poruchy školních dovedností a poruchy chování""",
                    false
                ),
            ),
            questionNumber = 137,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Identita jedince trpícího transsexualitou je založena na jeho""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""chromozomálním pohlaví""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gonadálním pohlaví""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""genitálním pohlaví""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""matričním pohlaví""",
                    false,
                    ""
                ),
            ),
            questionNumber = 138,
            correctAnswer = 0,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Profylaxe nejúžeji souvisí s:""",
            textAnswer = "Profylaxe:" +
                "\n\t-Prevence před nemocemi u jedinců, kteří jsou na určité nemoci třeba náchylní" +
                "\nPrimární prevence" +
                "\n\t-Posilování žádoucích chování, s očekáváním, že se tak sníží procento výskytu nežadoucích.",
            answers = listOf(
                PsychologyTermAnswer("""primární nespecifickou prevencí""",
                    false,
                    "Obecně podpora volnočasových aktivit, zdravotního živ. stylu a osvojování sociálního chování."
                ),
                PsychologyTermAnswer("""sekundární prevencí""",
                    false,
                    "Včasné vyhlední osob, které se již rizikově chovají a snaha zamezit dalšímu zhoršení."
                ),
                PsychologyTermAnswer("""terciární prevencí""",
                    false,
                    "Už se stalo, snažíme se o to, aby se to nestalo znovu."
                ),
                PsychologyTermAnswer("""primární specifickou prevencí""",
                    false,
                    "aktivity a programy pro vymezení nežádoucího chování a prevence." +
                        "\n\tvšeobecná - všechny lidi" +
                        "\n\tselektivní - žáci ohrožení rizikovými faktory" +
                        "\n\tindikovanou - po zaznamenání nějakého rizikového faktoru"
                ),
            ),
            questionNumber = 139,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
        PsychologyTerm(
            prompt = """Netolismus je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""věda o vlivech ateismu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("závislost na tzv. \"virtuálních drogách\"",
                    false,
                    "Vrituální videa, Hry, TV"
                ),
                PsychologyTermAnswer("""extrémní úroveň závisti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""slovní hra""",
                    false,
                    ""
                ),
            ),
            questionNumber = 140,
            correctAnswer = 1,
            categoryId = "5 Klinická psychologie a další aplikované obory"
        ),
    )
}