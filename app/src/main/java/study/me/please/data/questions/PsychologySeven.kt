package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//revidovano
//dobry zdroj chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://is.muni.cz/do/1499/el/estud/fss/ps06/psy112/Vaculik__M.__Jezek__S.__Wortner__V.__2006__-_Zakladni_pojmy_z_metodologie.pdf
object PsychologySeven {

    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Snižováním chyby měření zvyšujeme primárně""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""reliabilitu testu""",
                    false,
                    "Dají se výsledky replikovat?"
                ),
                PsychologyTermAnswer("""kredibilitu testových výsledků""",
                    false
                ),
                PsychologyTermAnswer("""empirickou validitu testu""",
                    false,
                    "Měří test opravdu co má měřit?"
                ),
                PsychologyTermAnswer("""autenticitu testu""",
                    false
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """K metodám sběru psychologických údajů nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dotazník""",
                    false
                ),
                PsychologyTermAnswer("""faktorová analýza""", false,
                    "(Factor analysis) - statická metoda. Když máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny," +
                        " které už nám to predikují a analyzují lépe."
                ),
                PsychologyTermAnswer("""sběr a analýza stop""",
                    false
                ),
                PsychologyTermAnswer("""rozhovor""",
                    false
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Většina přirozených kvantitativních veličin, které jsou určeny velkým množstvím nezávislých vlivů, má hodnoty rozloženy podle",
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
            answers = listOf(
                PsychologyTermAnswer("""bimodální rozdělení""",
                    false
                ),
                PsychologyTermAnswer("""uniformniho rozdělení""",
                    false
                ),
                PsychologyTermAnswer("""Poissonova rozdělení""",
                    false,
                    "Rozdělení pravděpodobnosti. Jaká je pravděpodobnost v určitém intervalu," +
                        " když jevy nastávají nezávisle na sobě (např. příchod zákazníků do restaurace)." +
                        " Poissonovo rozdělení nám v takovém případě spočítá jaká je pravděpodobnost, že přijdou např. 4 v určitý interval."
                ),
                PsychologyTermAnswer("""normálního rozdělení""",
                    false
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Většina přirozených kvantitativních veličin, které mají náhodné hodnoty, které mají stejnou pravděpodobnost, má hodnoty rozloženy podle",
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
            answers = listOf(
                PsychologyTermAnswer("""Poissonovo rozdělení""",
                    false
                ),
                PsychologyTermAnswer("""Rovnoměrné rozdělení""",
                    false,
                    "stejně často vyskytující hodnoty, rovnoměrné rozložení",
                    imageExplanationUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Rovnomerne_rozdeleni_hustota.svg/220px-Rovnomerne_rozdeleni_hustota.svg.png"
                ),
                PsychologyTermAnswer("""Leptokurtické rozdělení""",
                    false,
                    "špičatost - jaká je koncentrace kolem střední hodnoty",
                    imageExplanationUrl = "https://docplayer.cz/docs-images/17/66551/images/79-1.jpg"
                ),
                PsychologyTermAnswer("""Uniformní rozdělení""",
                    false
                ),
            ),
            questionNumber = 103,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Hodnota p, uváděná u výsledků řady psychologických statistických šetření, znamená:",
            textAnswer = "Hodnota P nám říká jaká je pravděpodobnost, že naše data mohly nastat v nulové hypotéze." +
                "\n Např. P<=0,05 v takovém případě nulovou hypotézu zavrhujeme." +
                "\n Nulová hypotéza - statistická významnost.",
            answers = listOf(
                PsychologyTermAnswer("""pravděpodobnost chyby prvního druhu""",
                    false,
                    "Hodnota p, H0. \"Chyba nadměrného skepticismu\" - tedy se lehce stane, že bude mít falešné pozitivy (false positive)" +
                        "\nMíra chyby = významnost testu. Značení α (alfa)"
                ),
                PsychologyTermAnswer("""pravděpodobnost chyby druhého druhu""",
                    false,
                    "H1. False negative. \"Nadměrná důvěřivost\". Značení β (beta)." +
                        "\nNedostatečně průkazné data k hypotéze, která ve skutečnosti platí"
                ),
                PsychologyTermAnswer(
                    """míru použitelnosti výsledku v další experimentální práci""",
                    false
                ),
                PsychologyTermAnswer(
                    """index významnosti výsledku, počítaný podle počtu zúčastněných zkoumaných osob""",
                    false
                ),
            ),
            questionNumber = 4,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Gaussova křivka je grafickým zachycením""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""uniformního rozdělení""",
                    false
                ),
                PsychologyTermAnswer("""regresního rozdělení""",
                    false
                ),
                PsychologyTermAnswer("""normálního rozdělení""",
                    false
                ),
                PsychologyTermAnswer("""Studentova rozdělení""",
                    false,
                    "Nastane v případě, kdy odhadujeme směrodatnou odchylku v normálním rozdělení"
                ),
            ),
            questionNumber = 5,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Introspekce jako metoda poznávání se nejvíce uplatňuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v experimentální psychologii""",
                    false
                ),
                PsychologyTermAnswer("""v kognitivní psychologii""",
                    false
                ),
                PsychologyTermAnswer("""v behaviorismu""",
                    false
                ),
                PsychologyTermAnswer(
                    """v humanistické psychologii""",
                    false,
                    "Maslow, Rogers. Zaměřeno na terapii. Nerozkládá člověka, však k němu přistupuje jako k celku."
                ),
            ),
            questionNumber = 6,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Regresní rovnice vyjadřuje""",
            textAnswer = "Aproximace hodnot pomocí přímky skrze směr hodnot.",
            answers = listOf(
                PsychologyTermAnswer(
                    """závislost hodnot jedné proměnné na hodnotách jiné proměnné""",
                    false
                ),
                PsychologyTermAnswer(
                    """pravděpodobnost shody empirického rozložení s rozložením teoretickým""",
                    false
                ),
                PsychologyTermAnswer(
                    """míru poklesu naměřených hodnot při opakovaných měřeních""",
                    false
                ),
                PsychologyTermAnswer(
                    """podstatu jevu označovaného jako regrese k průměru""",
                    false
                ),
            ),
            questionNumber = 7,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Jaká je nejvyšší běžně užívaná hranice statistické významnosti " +
                "(kdy považujeme za dostatečně pravděpodobné, že výsledky nejsou náhodné)?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""63,7%""",
                    false
                ),
                PsychologyTermAnswer("""15%""",
                    false
                ),
                PsychologyTermAnswer("""5%""",
                    false,
                    "p<=0.05 - pravděpodobnost chyby prvního druhu"
                ),
                PsychologyTermAnswer("""0,5%""",
                    false
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Jaký zásah dělá experimentátor v kontrolní skupině?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""vyrovnává rozdíly mezi osobami""",
                    false
                ),
                PsychologyTermAnswer("""žádný""",
                    false
                ),
                PsychologyTermAnswer("""ovlivňuje nezávisle proměnnou""",
                    false,
                    "Proměnnou, kterou měníme za účelem vlivu"
                ),
                PsychologyTermAnswer("""ovlivňuje závisle proměnnou""",
                    false,
                    "Proměnná, ve které očekáváme změny na základě změn v nezávisle proměnné"
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Mezi používané druhy škál nepatří""",
            textAnswer = "nominální (modus - nejčastěji vyskytující se hodnota) - disjunkce - vzájemně se vylučující (kvalitativní proměnné)" +
                "\n\tdichotomické/binární - pokud nabývá pouze 2 nominálních hodnot (např. ano/ne, muž/žena)" +
                "\n\tvícekategoriální - pokud nabývá více jak 2 nominálních hodnot (např. barva očí)" +
                "\n\nordinální/pořadové (medián, modus) - stupnice, lze porovnat podle kvantity/intenzity (míra souhlasu, známky)" +
                "\n\nkardinální (průměr) - číselné hodnoty (např. věk, váha, výška, reakční čas)" +
                "\n\tintervalové/pořadové - můžeme uspořádat a rozdíl mezi hodnotami je stejný (např. IQ)" +
                "\n\tpoměrové/podílové - můžeme uspořádat, rozdíl mezi hodnotami je stejný a lze poměřovat podílem či násobkem" +
                "\n\nkategoriální - nominální + ordinální kategorie" +
                "\n\nnumerické - číselné údaje - kardinální" +
                "\n\ndiskrétní - pouze celé čísla - např. věk v letech" +
                "\n\nspojité - libovolné hodnoty na nepřerušované škále - např. reakční čas",
            answers = listOf(
                PsychologyTermAnswer("""škály diferencované""",
                    false
                ),
                PsychologyTermAnswer("""škály ordinální""",
                    false,
                    "(medián, modus) - stupnice, lze porovnat podle kvantity/intenzity (míra souhlasu, známky)"
                ),
                PsychologyTermAnswer("""škály kardinální""",
                    false,
                    "číselné hodnoty (např. věk, váha, výška, reakční čas)"
                ),
                PsychologyTermAnswer("""škály poměrové""",
                    false,
                    "můžeme uspořádat, rozdíl mezi hodnotami je stejný a lze poměřovat podílem či násobkem"
                ),
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Mezi používané druhy škál nepatří""",
            textAnswer = "nominální (modus - nejčastěji vyskytující se hodnota) - disjunkce - vzájemně se vylučující (kvalitativní proměnné)" +
                "\n\tdichotomické/binární - pokud nabývá pouze 2 nominálních hodnot (např. ano/ne, muž/žena)" +
                "\n\tvícekategoriální - pokud nabývá více jak 2 nominálních hodnot (např. barva očí)" +
                "\n\nordinální/pořadové (medián, modus) - stupnice, lze porovnat podle kvantity/intenzity (míra souhlasu, známky)" +
                "\n\nkardinální (průměr) - číselné hodnoty (např. věk, váha, výška, reakční čas)" +
                "\n\tintervalové/pořadové - můžeme uspořádat a rozdíl mezi hodnotami je stejný (např. IQ)" +
                "\n\tpoměrové/podílové - můžeme uspořádat, rozdíl mezi hodnotami je stejný a lze poměřovat podílem či násobkem" +
                "\n\nkategoriální - nominální + ordinální kategorie" +
                "\n\nnumerické - číselné údaje - kardinální" +
                "\n\ndiskrétní - pouze celé čísla - např. věk v letech" +
                "\n\nspojité - libovolné hodnoty na nepřerušované škále - např. reakční čas",
            answers = listOf(
                PsychologyTermAnswer("""škály složené""",
                    false
                ),
                PsychologyTermAnswer("""škály kategoriální""",
                    false,
                    "nominální + ordinální kategorie"
                ),
                PsychologyTermAnswer("""škály spojité""",
                    false,
                    "libovolné hodnoty na nepřerušované škále - např. reakční čas"
                ),
                PsychologyTermAnswer("""škály numerické""",
                    false,
                    "číselné údaje - kardinální"
                ),
            ),
            questionNumber = 110,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Mezi používané druhy škál nepatří""",
            textAnswer = "nominální (modus - nejčastěji vyskytující se hodnota) - disjunkce - vzájemně se vylučující (kvalitativní proměnné)" +
                "\n\tdichotomické/binární - pokud nabývá pouze 2 nominálních hodnot (např. ano/ne, muž/žena)" +
                "\n\tvícekategoriální - pokud nabývá více jak 2 nominálních hodnot (např. barva očí)" +
                "\n\nordinální/pořadové (medián, modus) - stupnice, lze porovnat podle kvantity/intenzity (míra souhlasu, známky)" +
                "\n\nkardinální (průměr) - číselné hodnoty (např. věk, váha, výška, reakční čas)" +
                "\n\tintervalové/pořadové - můžeme uspořádat a rozdíl mezi hodnotami je stejný (např. IQ)" +
                "\n\tpoměrové/podílové - můžeme uspořádat, rozdíl mezi hodnotami je stejný a lze poměřovat podílem či násobkem" +
                "\n\nkategoriální - nominální + ordinální kategorie" +
                "\n\nnumerické - číselné údaje - kardinální" +
                "\n\ndiskrétní - pouze celé čísla - např. věk v letech" +
                "\n\nspojité - libovolné hodnoty na nepřerušované škále - např. reakční čas",
            answers = listOf(
                PsychologyTermAnswer("""škály intervalové""",
                    false,
                    "můžeme uspořádat a rozdíl mezi hodnotami je stejný (např. IQ)"
                ),
                PsychologyTermAnswer("""škály binární""",
                    false,
                    "pokud nabývá pouze 2 nominálních hodnot (např. ano/ne, muž/žena)"
                ),
                PsychologyTermAnswer("""škály prosté""",
                    false
                ),
                PsychologyTermAnswer("""škály diskrétní""",
                    false,
                    "pouze celé čísla - např. věk v letech"
                ),
            ),
            questionNumber = 111,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Pokud nepovažujeme výsledky našeho šetření za dostatečně průkazné k přijetí hypotézy, i když ve skutečnosti hypotéza platí, jedná se o""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""chybný výpočet indexu významnosti""",
                    false
                ),
                PsychologyTermAnswer("""chybu druhého druhu""",
                    false,
                    "H1. False negative. \"Nadměrná důvěřivost\". Značení β (beta)"
                ),
                PsychologyTermAnswer("""chybu prvního druhu""",
                    false,
                    "Hodnota p, H0. \"Chyba nadměrného skepticismu\" - tedy se lehce stane, že bude mít falešné pozitivy (false positive)" +
                        "\nMíra chyby = významnost testu. Značení α (alfa)"
                ),
                PsychologyTermAnswer("""důsledek etického přístupu k datům""",
                    false
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Pojem centrální tendence označuje""",
            textAnswer = "Poměrně snadno tak vyčleníme z určitého hlediska protikladné póly," +
                " protože jsou dobře registrovatelné, avšak rovněž \"oni ostatní\" nejsou pochopitelně \"stejní\". ",
            answers = listOf(
                PsychologyTermAnswer(
                    """soustředění na hlavní vykonávanou úlohu v experimentu""",
                    false
                ),
                PsychologyTermAnswer(
                    """sklon experimentátora vybírat do vzorku pouze průměrné osoby""",
                    false
                ),
                PsychologyTermAnswer(
                    """sklon osoby nepoužívat krajní body polárních škál""",
                    false
                ),
                PsychologyTermAnswer("""to, že rozložení má jeden vrchol""",
                    false
                ),
            ),
            questionNumber = 12,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Která metoda sběru údajů má nejblíže k inventáři?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dotazník""",
                    false
                ),
                PsychologyTermAnswer("""projektivni test""",
                    false
                ),
                PsychologyTermAnswer("""fyziologické měření""",
                    false
                ),
                PsychologyTermAnswer("""rozhovor""",
                    false
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Jaká chyba se nedá odstranit zvyšováním počtu měření""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""náhodná""",
                    false
                ),
                PsychologyTermAnswer("""chyba prvního druhu""",
                    false,
                    "Hodnota p, H0. \"Chyba nadměrného skepticismu\" - tedy se lehce stane, že bude mít falešné pozitivy (false positive)" +
                        "\nMíra chyby = významnost testu. Značení α (alfa)"
                ),
                PsychologyTermAnswer("""chyba druhého druhu""",
                    false,
                    "H1. False negative. \"Nadměrná důvěřivost\". Značení β (beta)." +
                        "\nNedostatečně průkazné data k hypotéze, která ve skutečnosti platí"
                ),
                PsychologyTermAnswer("""systematická""",
                    false
                ),
            ),
            questionNumber = 14,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Hodnota, která udává, jak dalece se skóry tvořící určitý soubor odchylují" +
                " od průměrné hodnoty tohoto souboru, vyjádřená v původních jednotkách měření, se nazývá:",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""směrodatná odchylka""",
                    false
                ),
                PsychologyTermAnswer("""rozdělení""",
                    false
                ),
                PsychologyTermAnswer("""rozptyl""",
                    false
                ),
                PsychologyTermAnswer("""rozpěti""",
                    false
                ),
            ),
            questionNumber = 15,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Metoda nejmenších čtverců je základem""",
            textAnswer = "linie, graficky vyjadřující vztah mezi body",
            answers = listOf(
                PsychologyTermAnswer("""lineární regrese""",
                    false,
                    "Aproximace hodnot pomocí přímky skrze směr hodnot"
                ),
                PsychologyTermAnswer("""analýzy kontingenčních tabulek""",
                    false,
                    "Nějaký tabulkový sumárum vztahu statistických znaků."
                ),
                PsychologyTermAnswer(
                    """řeckých čtverců""",
                    false,
                    "to samé co latinské čtverce, jen se vyznačují pomocí řecké abecedy"
                ),
                PsychologyTermAnswer("""latinských čtverců""",
                    false,
                    "dvojrozměrné pole, kde každý sloupec i řádka mají unikátní obsahy, ale používají stejné hodnoty"
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Co platí o bimodálním rozložení hodnot?""",
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
            answers = listOf(
                PsychologyTermAnswer(
                    """jde o typické rozdělení hodnot, když se měří dvojice znaků u jedné osoby""",
                    false
                ),
                PsychologyTermAnswer(
                    """nad průměrem je přesně dvojnásobek hodnot než pod průměrem""",
                    false
                ),
                PsychologyTermAnswer(
                    """pod průměrem je přesně dvojnásobek hodnot než nad průměrem""",
                    false
                ),
                PsychologyTermAnswer("""má dva vrcholy""",
                    false
                ),
            ),
            questionNumber = 17,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Platnost testu se označuje termínem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""kredibilita""",
                    false
                ),
                PsychologyTermAnswer("""rekurzibilita""",
                    false
                ),
                PsychologyTermAnswer("""reliabilita""",
                    false,
                    "Dají se výsledky replikovat?"
                ),
                PsychologyTermAnswer("""validita""",
                    false,
                    "Měří test opravdu co má měřit?"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Pokud při zkoumání vývoje postupujeme tak," +
                " že změříme zkoumanou charakteristiku u různých věkových skupin najednou, o jaký postup se jedná?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""příčný (transverzální)""",
                    false,
                    "Srovnávání osob různého věku v jednom časovém bodě"
                ),
                PsychologyTermAnswer("""longitudinální""",
                    false
                ),
                PsychologyTermAnswer("""chybný""",
                    false
                ),
                PsychologyTermAnswer("""zkrácený""",
                    false
                ),
            ),
            questionNumber = 19,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Operacionalizace určitého jevu je""",
            textAnswer = "Překlad z teoretického do observačního",
            answers = listOf(
                PsychologyTermAnswer(
                    """rozložení struktury jevu na jednotlivé elementární děje""",
                    false
                ),
                PsychologyTermAnswer(
                    """vymezení postupu, kterým tento jev vyvoláme""",
                    false
                ),
                PsychologyTermAnswer(
                    """výzkumná strategie při zkoumání myšlenkových postupů""",
                    false
                ),
                PsychologyTermAnswer("""definice jevu""",
                    false
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Hlavním účelem převádění hrubého skóru na skór vážený je",
            textAnswer = "Hrubý skór - původně naměřené hodnoty" +
                "\n\nVážený skór - definovaný na základě porovnání hrubých skórů vyšetřované osoby se skóry určitého souboru osob" +
                "\n\nStandardní skór - čísla, vzniklá transformací (normalizací) z hrubých skór do rozložení s předem danými vlastnostmi",
            answers = listOf(
                PsychologyTermAnswer("""chybná konstrukce testu""",
                    false
                ),
                PsychologyTermAnswer("""zjednodušení matematického postupu""",
                    false
                ),
                PsychologyTermAnswer("""zajištění porovnatelnosti individuálního výsledku s rozložením výsledků v populaci""",
                    false
                ),
                PsychologyTermAnswer(
                    """zajištění normálního rozložení hrubých skórů""",
                    false
                ),
            ),
            questionNumber = 21,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """K důležitým požadavkům na správný experiment patří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""reprodukovatelnost""",
                    false
                ),
                PsychologyTermAnswer("""opakovatelné použití u téže osoby""",
                    false
                ),
                PsychologyTermAnswer("""stabilita v čase""",
                    false,
                    "platí u testu, standardně 6 měsíců"
                ),
                PsychologyTermAnswer(
                    """uvědomění probanda o účelu experimentu předem""",
                    false,
                    "Proband - testovaná osoba" +
                        "\nRespondent - dotazovaná osoba"
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Výběrový vzorek je reprezentativní, když""",
            textAnswer = "Míra v jaké se zkoumaný soubor shoduje s populací v našich zkoumaných parametrech",
            answers = listOf(
                PsychologyTermAnswer("""se při vybíráni postupuje systematicky""",
                    false
                ),
                PsychologyTermAnswer(
                    """se jeho výsledky v určité proměnné shodují s výsledky jiných výběrových vzorků""",
                    false
                ),
                PsychologyTermAnswer(
                    """má v rozhodujících charakteristikách stejné složení jako výchozi populace""",
                    false
                ),
                PsychologyTermAnswer("""jsou v něm zastoupena obě pohlaví""",
                    false
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Idiograficky orientovaný výzkum se zaměřuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""na studium jednoho psychického procesu""",
                    false,
                    "Hodně krátkodobé, jedná se vlastně o zpracování určitých jevů a informací. \n" +
                    " Může se jednat o vnímání, paměť, představivost, učení či myšlení."),
                PsychologyTermAnswer(
                    """na jednu osobu""",
                    false
                ),
                PsychologyTermAnswer("""na vyvozování individuálních zákonitostí ze zákonů obecně platných""",
                    false
                ),
                PsychologyTermAnswer("""nejprve na deskripci a pak na vyvozování obecných zákonů""",
                    false
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Sběr dat, analýza a interpretace se překrývají""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""kvalitativního výzkumu""",
                    false
                ),
                PsychologyTermAnswer("""vývojového výzkumu""",
                    false
                ),
                PsychologyTermAnswer("""transverzálního výzkumu""",
                    false
                ),
                PsychologyTermAnswer("""kvantitativního výzkumu""",
                    false,
                    "Orientační výzkum - zjištění určitých hodnot bez hypotézy. Např. počet lidí, kteří mají deprese." +
                        "\n\nKorelační výzkum - korelace mezi nějakými jevy. Neznáme příčinný vztah - korelace neznamená kauzalitu."
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Pravidlo, podle kterého se nemá zavádět více teoretických entit, než je pro vysvětlení nezbytně nutné, je známo jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Henleyova klička""",
                    false
                ),
                PsychologyTermAnswer("""Occamova břitva""",
                    false,
                    "(Ockhamova) \"Nemá se postulovat množství (důvodů či příčin), není-li to nezbytné.\""
                ),
                PsychologyTermAnswer("""realistický imperativ""",
                    false
                ),
                PsychologyTermAnswer("""redukcionismus""",
                    false,
                    "Rozklad na menší části, které se dají měřit. Opak holistického pohledu."
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Čím vyšší je statistická významnost výsledku výzkumu, tím menší je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""šíře možných interpretaci""",
                    false
                ),
                PsychologyTermAnswer(
                    """pravděpodobnost, že výsledky jsou důsledkem náhodné variability""",
                    false
                ),
                PsychologyTermAnswer("""množství populací, pro výzkum platí""",
                    false
                ),
                PsychologyTermAnswer("""faktická významnost nálezu""",
                    false
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Mezi formy kontroly nežádoucích proměnných nepatří jejich:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""eliminace""",
                    false
                ),
                PsychologyTermAnswer("""znáhodnění""",
                    false
                ),
                PsychologyTermAnswer("""transformace na závislé proměnné""",
                    false
                ),
                PsychologyTermAnswer("""zkonstantnění""",
                    false
                ),
            ),
            questionNumber = 28,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Co to znamená, když hodnota korelačního koeficientu dvou proměnných, které jsme měřili u sta lidí, činí -0.9 ?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""mezi jevy je velmi slabá korelace""",
                    false
                ),
                PsychologyTermAnswer(
                    """z uvedených fakt nelze vysuzovat žádné závěry""",
                    false
                ),
                PsychologyTermAnswer(
                    """mezi jevy je silná korelace; čím vyšší je hodnota jedné proměnné, tím vyšší bude pravděpodobně hodnota druhé proměnné""",
                    false
                ),
                PsychologyTermAnswer(
                    """mezi jevy je silná korelace; čím vyšší je hodnota jedné proměnné, tím nižší bude pravděpodobně hodnota druhé proměnné""",
                    false
                ),
            ),
            questionNumber = 29,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Co to znamená, když hodnota korelačního koeficientu dvou proměnných, které jsme měřili u sta lidí, činí 0.9 ?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""mezi jevy je velmi slabá korelace""",
                    false
                ),
                PsychologyTermAnswer(
                    """z uvedených fakt nelze vysuzovat žádné závěry""",
                    false
                ),
                PsychologyTermAnswer(
                    """mezi jevy je silná korelace; čím vyšší je hodnota jedné proměnné, tím vyšší bude pravděpodobně hodnota druhé proměnné""",
                    false
                ),
                PsychologyTermAnswer(
                    """mezi jevy je silná korelace; čím vyšší je hodnota jedné proměnné, tím nižší bude pravděpodobně hodnota druhé proměnné""",
                    false
                ),
            ),
            questionNumber = 129,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Výzkumný přístup, který se orientuje na hledání obecných zákonů platných pro všechny lidi, se označuje",
            textAnswer = "Přístup psychologie osobnosti je dichotomický," +
                " zčásti jde o hledání všeobecných norem a obecností ze zkoumání většího počtu osob (nomotetický přístup)," +
                " zčásti je zdůrazňována jedinečnost a neopakovatelnost člověka a jeho psychických jevů (idiografický přístup)",
            answers = listOf(
                PsychologyTermAnswer("""generalistický""",
                    false
                ),
                PsychologyTermAnswer("""idiografický""",
                    false
                ),
                PsychologyTermAnswer("""logistický""",
                    false
                ),
                PsychologyTermAnswer("""nomotetický""",
                    false,
                    "Snaží se hledat principy, aplikovatelné na většinu lidí"
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Z hrubého skóru se ve většině psychometrických technik vypočítává""",
            textAnswer = "Hrubý skór - původně naměřené hodnoty" +
            "\n\nVážený skór - definovaný na základě porovnání hrubých skórů vyšetřované osoby se skóry určitého souboru osob" +
                "\n\nStandardní skór - čísla, vzniklá transformací (normalizací) z hrubých skór do rozložení s předem danými vlastnostmi",
            answers = listOf(
                PsychologyTermAnswer("""vážený skór""",
                    false,
                    "definovaný na základě porovnání hrubých skórů vyšetřované osoby se skóry určitého souboru osob"
                ),
                PsychologyTermAnswer("""jemný skór""",
                    false
                ),
                PsychologyTermAnswer("""integrovaný skór""",
                    false
                ),
                PsychologyTermAnswer("""hrubé skóre""",
                    false,
                    "Hrubý skór - původně naměřené hodnoty"
                ),
            ),
            questionNumber = 31,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Rozbor a popis jednoho případu se označuje""",
            textAnswer = "Případová studie",
            answers = listOf(
                PsychologyTermAnswer("""kauzoanalýza""",
                    false
                ),
                PsychologyTermAnswer("""anamnéza""",
                    false,
                    "Medical history"
                ),
                PsychologyTermAnswer("""kauzální studie""",
                    false
                ),
                PsychologyTermAnswer("""kazuistika""",
                    false
                ),
            ),
            questionNumber = 32,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Pravděpodobnost, že jedinec bude vybrán do výběrového vzorku, je při prostém náhodném výběru pro každého příslušníka populace",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""závislá na sociálním statusu jedince""",
                    false
                ),
                PsychologyTermAnswer("""stejná""",
                    false
                ),
                PsychologyTermAnswer(
                    """tím vyšší, čím více se jeho výkony blíží k průměru""",
                    false
                ),
                PsychologyTermAnswer("""nulová""",
                    false
                ),
            ),
            questionNumber = 33,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """V Cattellově rozlišení L-, Q- a T-dat pro studium osobnosti jsou L-data""",
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
                PsychologyTermAnswer("""údaje získávané pozorováním""",
                    false
                ),
                PsychologyTermAnswer("""údaje z objektivních testů""",
                    false
                ),
                PsychologyTermAnswer(
                    """údaje získávané sebepozorováním (dotazníky)""",
                    false
                ),
                PsychologyTermAnswer("""údaje z dlouhodobých záznamů""",
                    false
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Výběrový postup, kdy je populace rozdělena do oblastí a v nich je pak náhodně vybírán " +
                "počet jedinců odpovídající poměrné velikosti této oblasti, se označuje",
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
                "\n\ta) Stratifikovaný náhodný výběr - subpopulace podle důležitých charakteristik, následně náhoda" +
                "\n\tb) Výběr pro párování - zámerný výběr respondentů",
            answers = listOf(
                PsychologyTermAnswer("""vícestupňový""",
                    false
                ),
                PsychologyTermAnswer("""stratifikovaný""",
                    false,
                    "subpopulace podle důležitých charakteristik, následně náhoda"
                ),
                PsychologyTermAnswer("""kvótní""",
                    false,
                    "podle rozložení určitých znaků ve vzorku, často reprezentuje zkoumanou populaci"
                ),
                PsychologyTermAnswer("""oblastně redukovaný""",
                    false
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Q-data jsou v Cattellově etí""",
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
                PsychologyTermAnswer("""údaje získané z dlouhodobých záznamů""",
                    false
                ),
                PsychologyTermAnswer("""údaje o kvalitě života""",
                    false
                ),
                PsychologyTermAnswer("""údaje získané pozorováním""",
                    false
                ),
                PsychologyTermAnswer("""dotazníkové údaje""",
                    false
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Zejména při studiu účinnosti léčiv se používá metoda, při které pacient neví," +
                " zda dostává lék nebo neúčinnou substanci," +
                " a neví to ani lékař, který mu substanci podává. Jedná se o",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dvojitě slepou metodu""",
                    false
                ),
                PsychologyTermAnswer("""metodu náhodné prezentace""",
                    false
                ),
                PsychologyTermAnswer("""terapii naslepo""",
                    false
                ),
                PsychologyTermAnswer("""jednoduchou slepou metodu""",
                    false
                ),
            ),
            questionNumber = 37,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Standardizovaný postup, jímž se vyvolávají hodnotitelné reakce probandů, se obecně označuje",
            textAnswer = "Proband - testovaná osoba" +
                "\nRespondent - dotazovaná osoba",
            answers = listOf(
                PsychologyTermAnswer("""dotaznik""",
                    false
                ),
                PsychologyTermAnswer("""retest""",
                    false
                ),
                PsychologyTermAnswer("""test""",
                    false
                ),
                PsychologyTermAnswer("""projektivní technika""",
                    false
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Dobově podmíněná a jen částečně reflektovaná pravidla," +
                " která určují postupy uvažování, dokazování i empirické práce ve vědě, se označují",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""normativní kánony""",
                    false
                ),
                PsychologyTermAnswer("""společenské normy""",
                    false
                ),
                PsychologyTermAnswer("""hypostáze""",
                    false
                ),
                PsychologyTermAnswer("""paradigmata""",
                    false,
                    "(z řec. parádeigma = vzor, příklad, model)"
                ),
            ),
            questionNumber = 39,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Statistickým testem určujeme pravděpodobnost""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""chyby prvniho druhu""",
                    false
                ),
                PsychologyTermAnswer("""výběrové chyby""",
                    false
                ),
                PsychologyTermAnswer("""proximální chyby třetího druhu""",
                    false
                ),
                PsychologyTermAnswer("""chyby druhého druhu""",
                    false,
                    "H1. False negative. \"Nadměrná důvěřivost\". Značení β (beta)." +
                        "\nNedostatečně průkazné data k hypotéze, která ve skutečnosti platí"
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Tam, kde zkoumané osoby ani svědci z nějakých důvodů již nejsou k dispozici, lze použít",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""narkoanalýzu""",
                    false
                ),
                PsychologyTermAnswer("""pozorování""",
                    false
                ),
                PsychologyTermAnswer("""analýzu stop a výsledků činnosti""",
                    false
                ),
                PsychologyTermAnswer("""dotazníky""",
                    false
                ),
            ),
            questionNumber = 41,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Dotazovaná osoba je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""tester""",
                    false
                ),
                PsychologyTermAnswer("""respondent""",
                    false
                ),
                PsychologyTermAnswer("""proband""",
                    false,
                    "testovaná osoba"
                ),
                PsychologyTermAnswer("""imitand""",
                    false
                ),
            ),
            questionNumber = 42,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Techniky, u kterých probandovi prezentujeme neurčitý či málo strukturovaný materiál a žádáme, aby ho vyložil či dotvořil, označujeme jako",
            textAnswer = "Proband - testovaná osoba" +
                "\nRespondent - dotazovaná osoba",
            answers = listOf(
                PsychologyTermAnswer("""projektivní""",
                    false
                ),
                PsychologyTermAnswer("""produktivní""",
                    false
                ),
                PsychologyTermAnswer("""autodiagnostické""",
                    false
                ),
                PsychologyTermAnswer("""kreativní""",
                    false
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Operacionální definice proměnné je definice založená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """na analýze jednotlivých dějů, které se na hodnotě proměnné podílejí""",
                    false
                ),
                PsychologyTermAnswer(
                    """na popisu postupu, jakým proměnnou vyvoláme""",
                    false
                ),
                PsychologyTermAnswer(
                    """na vzájemné souvislosti myšlení a činnosti""",
                    false
                ),
                PsychologyTermAnswer("""na definici kruhem""",
                    false
                ),
            ),
            questionNumber = 44,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """U souborů dat uspořádaných podle pořadové škály lze stanovit""",
            textAnswer = "nominální (modus - nejčastěji vyskytující se hodnota) - disjunkce - vzájemně se vylučující (kvalitativní proměnné)" +
                "\n\tdichotomické/binární - pokud nabývá pouze 2 nominálních hodnot (např. ano/ne, muž/žena)" +
                "\n\tvícekategoriální - pokud nabývá více jak 2 nominálních hodnot (např. barva očí)" +
                "\n\nordinální/pořadové (medián, modus) - stupnice, lze porovnat podle kvantity/intenzity (míra souhlasu, známky)" +
                "\n\nkardinální (průměr) - číselné hodnoty (např. věk, váha, výška, reakční čas)" +
                "\n\tintervalové/pořadové - můžeme uspořádat a rozdíl mezi hodnotami je stejný (např. IQ)" +
                "\n\tpoměrové/podílové - můžeme uspořádat, rozdíl mezi hodnotami je stejný a lze poměřovat podílem či násobkem" +
                "\n\nkategoriální - nominální + ordinální kategorie" +
                "\n\nnumerické - číselné údaje - kardinální" +
                "\n\ndiskrétní - pouze celé čísla - např. věk v letech" +
                "\n\nspojité - libovolné hodnoty na nepřerušované škále - např. reakční čas",
            answers = listOf(
                PsychologyTermAnswer("""medián""",
                    false
                ),
                PsychologyTermAnswer("""medián a modus""",
                    false,
                    "Modus - nejčastěji vyskytující se hodnota"
                ),
                PsychologyTermAnswer("""medián, modus a průměr""",
                    false
                ),
                PsychologyTermAnswer("""medián a průměr""",
                    false
                ),
            ),
            questionNumber = 45,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """U souborů dat uspořádaných podle nominální škály lze stanovit""",
            textAnswer = "nominální (modus - nejčastěji vyskytující se hodnota) - disjunkce - vzájemně se vylučující (kvalitativní proměnné)" +
                "\n\tdichotomické/binární - pokud nabývá pouze 2 nominálních hodnot (např. ano/ne, muž/žena)" +
                "\n\tvícekategoriální - pokud nabývá více jak 2 nominálních hodnot (např. barva očí)" +
                "\n\nordinální/pořadové (medián, modus) - stupnice, lze porovnat podle kvantity/intenzity (míra souhlasu, známky)" +
                "\n\nkardinální (průměr) - číselné hodnoty (např. věk, váha, výška, reakční čas)" +
                "\n\tintervalové/pořadové - můžeme uspořádat a rozdíl mezi hodnotami je stejný (např. IQ)" +
                "\n\tpoměrové/podílové - můžeme uspořádat, rozdíl mezi hodnotami je stejný a lze poměřovat podílem či násobkem" +
                "\n\nkategoriální - nominální + ordinální kategorie" +
                "\n\nnumerické - číselné údaje - kardinální" +
                "\n\ndiskrétní - pouze celé čísla - např. věk v letech" +
                "\n\nspojité - libovolné hodnoty na nepřerušované škále - např. reakční čas",
            answers = listOf(
                PsychologyTermAnswer("""modus""",
                    false,
                    "nejčastěji vyskytující se hodnota"
                ),
                PsychologyTermAnswer("""medián a modus""",
                    false
                ),
                PsychologyTermAnswer("""medián, modus a průměr""",
                    false
                ),
                PsychologyTermAnswer("""medián a průměr""",
                    false
                ),
            ),
            questionNumber = 145,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """U souborů dat uspořádaných podle kardinální škály lze stanovit""",
            textAnswer = "nominální (modus - nejčastěji vyskytující se hodnota) - disjunkce - vzájemně se vylučující (kvalitativní proměnné)" +
                "\n\tdichotomické/binární - pokud nabývá pouze 2 nominálních hodnot (např. ano/ne, muž/žena)" +
                "\n\tvícekategoriální - pokud nabývá více jak 2 nominálních hodnot (např. barva očí)" +
                "\n\nordinální/pořadové (medián, modus) - stupnice, lze porovnat podle kvantity/intenzity (míra souhlasu, známky)" +
                "\n\nkardinální (průměr) - číselné hodnoty (např. věk, váha, výška, reakční čas)" +
                "\n\tintervalové/pořadové - můžeme uspořádat a rozdíl mezi hodnotami je stejný (např. IQ)" +
                "\n\tpoměrové/podílové - můžeme uspořádat, rozdíl mezi hodnotami je stejný a lze poměřovat podílem či násobkem" +
                "\n\nkategoriální - nominální + ordinální kategorie" +
                "\n\nnumerické - číselné údaje - kardinální" +
                "\n\ndiskrétní - pouze celé čísla - např. věk v letech" +
                "\n\nspojité - libovolné hodnoty na nepřerušované škále - např. reakční čas",
            answers = listOf(
                PsychologyTermAnswer("""medián""",
                    false
                ),
                PsychologyTermAnswer("""průměr""",
                    false
                ),
                PsychologyTermAnswer("""medián, modus a průměr""",
                    false
                ),
                PsychologyTermAnswer("""medián a průměr""",
                    false
                ),
            ),
            questionNumber = 245,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Když studujeme argumenty užívané v politické kampani tím," +
                " že rozebíráme související novinové články a hledáme témata," +
                " která se v nich objevují, provádíme z metodologického hlediska",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""syntetickou studii""",
                    false
                ),
                PsychologyTermAnswer("""obsahovou analýzu""",
                    false,
                    "Obsahová analýza (Věcná analýza) - kvantitativní analýza, obsah transformován do věcných selekčních údajů." +
                        "\n Např. referát, anotace, abstrakt."
                ),
                PsychologyTermAnswer("""politickou analýzu""",
                    false
                ),
                PsychologyTermAnswer("""dokumentovou syntézu""",
                    false
                ),
            ),
            questionNumber = 46,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Co znamená kódování?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""konceptualizace hrubých dat""",
                    false
                ),
                PsychologyTermAnswer("transformace (normalizace) hrubých skór na vážený",
                    false
                ),
                PsychologyTermAnswer("transformace (normalizace) hrubých skór na standardní",
                    false
                ),
                PsychologyTermAnswer("typ kvalitativní studie",
                    false
                ),
            ),
            questionNumber = -46,
            correctAnswer = 0,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Hawthornský efekt znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""zvyšování validity redukuje reliabilitu""",
                    false,
                    "Validita - Měří test opravdu co má měřit?" +
                        "\nReliabilita - Dají se výsledky replikovat?"
                ),
                PsychologyTermAnswer("nedostatek respondentů na významný výsledek",
                    false
                ),
                PsychologyTermAnswer("placebo efekt, toho, že probandi jsou sledováni",
                    false,
                    "Americká továrna"
                ),
                PsychologyTermAnswer("klamné spojení korelace s kauzalitou",
                    false
                ),
            ),
            questionNumber = -47,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "Matematická metoda, která dokáže najít ve velkém množství proměnných společnou strukturu," +
                " jež může vysvětlit celek dat kombinací menšího množství proměnných, se souhrnně označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""analýza kovariance""",
                    false
                ),
                PsychologyTermAnswer(
                    """analýza rozptylu""",
                    false,
                    "ANOVA - ANalysis Of VAriance - vytvoření podskupin s průměrem a porovnání průměrů mezi sebou"
                ),
                PsychologyTermAnswer("""metoda největších čtverců""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer(
                    """faktorová analýza""",
                    false,
                    "(Factor analysis) - statická metoda. Když máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny," +
                        " které už nám to predikují a analyzují lépe."
                ),
            ),
            questionNumber = 47,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Experimentální subjekt je jiné označení pro""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""experimentátor""",
                    false
                ),
                PsychologyTermAnswer("""problém studovaný v experimentu""",
                    false
                ),
                PsychologyTermAnswer("""pokusnou osobu""",
                    false
                ),
                PsychologyTermAnswer("""osoba informovaná o záměru experimentu""",
                    false
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Hlavní aplikací faktorové analýzy je""",
            textAnswer = "(Factor analysis) - statická metoda. Když máme hodně proměnných, které se nedají měřit nezávisle, uděláme z nich skupiny," +
                " které už nám to predikují a analyzují lépe.",
            answers = listOf(
                PsychologyTermAnswer("""analýza činnosti""",
                    false
                ),
                PsychologyTermAnswer("""studium průběhu vnímání""",
                    false
                ),
                PsychologyTermAnswer("""studium osobnosti""",
                    false
                ),
                PsychologyTermAnswer("""analýza kategoriálního experimentu""",
                    false
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Které pozorování budeme nejspíše vyhodnocovat kvantitativně?""",
            textAnswer = "Orientační výzkum - zjištění určitých hodnot bez hypotézy. Např. počet lidí, kteří mají deprese." +
                "\n\nKorelační výzkum - korelace mezi nějakými jevy. Neznáme příčinný vztah - korelace neznamená kauzalitu.",
            answers = listOf(
                PsychologyTermAnswer("""nestrukturované""",
                    false
                ),
                PsychologyTermAnswer("""strukturované""",
                    false
                ),
                PsychologyTermAnswer("""volné""",
                    false
                ),
                PsychologyTermAnswer("""žádné""",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """K extraspektivnim metodám nepatří""",
            textAnswer = "\"Pozorování chování\", \"behaviorální pozorování\"",
            answers = listOf(
                PsychologyTermAnswer("""testování""",
                    false
                ),
                PsychologyTermAnswer("""měření fyziologických odpovědí""",
                    false
                ),
                PsychologyTermAnswer("""introspekce""",
                    false
                ),
                PsychologyTermAnswer("""pozorování""",
                    false
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Dva základní typy výzkumných projektů ve vývojové psychologii jsou""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""longitudinální a mediální""",
                    false
                ),
                PsychologyTermAnswer("""dlouhodobý a krátkodobý""",
                    false
                ),
                PsychologyTermAnswer("""průřezový a příčný""",
                    false,
                    "Příčný - srovnávání osob různého věku v jednom časovém bodě"
                ),
                PsychologyTermAnswer(
                    """longitudinální a průřezový""",
                    false,
                    "Průřezový - Cross-sectional, typ longitudinální přístupu.\nPorovnáme skupiny ruzných věků (rychlejší způsob, ale horší)."
                ),
            ),
            questionNumber = 52,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Korelační koeficient vyjadřuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""míru spolehlivosti psychologického testu""",
                    false
                ),
                PsychologyTermAnswer(
                    """míru, v níž se různé proměnné podílejí na výsledku v určitém subtestu""",
                    false
                ),
                PsychologyTermAnswer(
                    """rozložení inteligenčního kvocientu v populaci""",
                    false
                ),
                PsychologyTermAnswer(
                    """míru společné proměnlivosti dvou proměnných""",
                    false
                ),
            ),
            questionNumber = 53,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Výzkumný projekt, při kterém se po dlouhou dobu sleduje skupina stejných osob, se nazývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""monosubjektový""",
                    false
                ),
                PsychologyTermAnswer("""idiografický""",
                    false,
                    "Výzkum jedné osoby. Opakem je nomotetický."
                ),
                PsychologyTermAnswer("""průřezový""",
                    false,
                    "Cross-sectional, typ longitudinální přístupu. Porovnáme skupiny ruzných věků (rychlejší způsob, ale horší)."
                ),
                PsychologyTermAnswer("""longitudinální""",
                    false
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Standardní odchylka u IQ skóru činí""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""100 bodů IQ""",
                    false
                ),
                PsychologyTermAnswer("""15 bodů IQ""",
                    false
                ),
                PsychologyTermAnswer("""1 bod IQ""",
                    false
                ),
                PsychologyTermAnswer("""10 bodů IQ""",
                    false
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Standardní odchylka IQ skóru činí 15 bodů, průměr je 100 bodů. Kolik procent populace ma IQ nad 130?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""0,7%""",
                    false
                ),
                PsychologyTermAnswer("""25%""",
                    false
                ),
                PsychologyTermAnswer("""10%""",
                    false
                ),
                PsychologyTermAnswer("""2,3%""",
                    false
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """V experimentu manipuluje experimentátor""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""intervenující proměnné""",
                    false,
                    "rušivá proměnná, které se snažíme zbavit"
                ),
                PsychologyTermAnswer("""nezávisle proměnné""",
                    false
                ),
                PsychologyTermAnswer("""experimentální konstanty""",
                    false
                ),
                PsychologyTermAnswer("""závisle proměnné""",
                    false
                ),
            ),
            questionNumber = 57,
            correctAnswer = 1,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = "V experimentu se měří srdeční frekvence u probandů, kteří sledují fotografie emocionálně neutrálních nebo emocionálně nabitých scén." +
                " Předpokládá se, že emocionalita fotografií bude způsobovat zvýšení srdeční frekvence." +
                " Z hlediska experimentálního projektu je tedy srdeční frekvence",
            textAnswer = "Proband - testovaná osoba" +
                "\nRespondent - dotazovaná osoba",
            answers = listOf(
                PsychologyTermAnswer("""kontrolní proměnná""",
                    false
                ),
                PsychologyTermAnswer("""fyziologická korelace""",
                    false
                ),
                PsychologyTermAnswer("""závisle proměnná""",
                    false
                ),
                PsychologyTermAnswer("""nezávisle proměnná""",
                    false
                ),
            ),
            questionNumber = 58,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Základní rozdíl mezi laboratorním a přirozeným experimentem spočívá v tom, že""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """přirozený experiment studuje složitější jevy""",
                    false
                ),
                PsychologyTermAnswer(
                    """laboratorní experiment nemá žádnou ekologickou validitu""",
                    false,
                    "Ekologická validita = využitelnost výsledků v praxi"
                ),
                PsychologyTermAnswer(
                    """přirozený experiment je zaměřen na problematiku aplikovaných disciplin""",
                    false
                ),
                PsychologyTermAnswer(
                    """v laboratorním experimentu manipuluje nezávisle proměnné experimentátor""",
                    false
                ),
            ),
            questionNumber = 59,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Spolehlivost testu se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""empirická validita""",
                    false,
                    "Měří test opravdu co má měřit?"
                ),
                PsychologyTermAnswer("""kredibilita""",
                    false
                ),
                PsychologyTermAnswer("""validita""",
                    false,
                    "Měří test opravdu co má měřit?"
                ),
                PsychologyTermAnswer("""reliabilita""",
                    false,
                    "Dají se výsledky replikovat?"
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "7. Metodologické základy"
        ),
        PsychologyTerm(
            prompt = """Pokud test měří vlastnost, kterou má podle našeho záměru měřit, označujeme jej jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""kvalitativní""",
                    false
                ),
                PsychologyTermAnswer("""kredibilni""",
                    false
                ),
                PsychologyTermAnswer("""validni""",
                    false,
                    "Platnost testu"
                ),
                PsychologyTermAnswer("""empiricky ukotvený""",
                    false
                ),
            ),
            questionNumber = 61,
            correctAnswer = 2,
            categoryId = "7. Metodologické základy"
        ),
    )
}