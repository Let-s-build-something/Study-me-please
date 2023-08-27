package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

object LawHandmade {

    val lawPrompts = listOf(
        PsychologyTerm(
            prompt = "Mezi charakteristické náležitosti státu nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("demokracie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("státní aparát",
                    false,
                    ""
                ),
                PsychologyTermAnswer("území",
                    false,
                    ""
                ),
                PsychologyTermAnswer("občany",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ozbrojenou moc",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právní subjektivitu",
                    false,
                    "způsobilost samostatně vystupovat"
                )
            ),
            categoryId = "Statoprávo",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Státní suverenita je",
            textAnswer = "(svrchovanost, nejvyšší státní moc)",
            answers =
            listOf(
                PsychologyTermAnswer("stát není podřízen žádnému vyššímu orgánu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("stát není součástí žádné organizace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("druhotné tvoření státu",
                    false,
                    "vznik států v pozdější době"
                ),
                PsychologyTermAnswer("prvotní tvoření státu",
                    false,
                    "vznik nejstarších známých států"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi nadstátní organizace nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Obce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Evropská unie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Organizace amerických států",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Organizace spojených národů",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "K rozpadu Rakouska-Uherska došlo",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("1918",
                    false,
                    "zároveň vznik Československa"
                ),
                PsychologyTermAnswer("1991", false, "rozpad SSSR"),
                PsychologyTermAnswer("1939", false, "Podkarpatská Rus již není částí Československa"),
                PsychologyTermAnswer("1989", false, "sametová revoluce")
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi rozsah státní moci nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("do kterých oblastní života občanů stát zasahuje",
                    false,
                    "obsah státní moci"
                ),
                PsychologyTermAnswer("územně státní hranice",
                    false,
                    ""
                ),
                PsychologyTermAnswer("počet obyvatelů",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Teokracie je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vládce vládnoucí z boží milosti",
                    false,
                    "z řečtiny \"boží vláda\""
                ),
                PsychologyTermAnswer("vládce vládne doživotně vlastním jménem",
                    false,
                    "monarchie, z řečtiny \"jediný vládce\""
                ),
                PsychologyTermAnswer("účast všech plnoprávných občasnů na správě a řízení státu",
                    false,
                    "demokracie, z řečtiny \"vláda lidu\", účast přímá a nepřímá"
                ),
                PsychologyTermAnswer("věc veřejná, většinou demokratický charakter s jedním zástupcem",
                    false,
                    "republika"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Monarchie konstituční je omezena",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ústavou",
                    false,
                    "konstituční"
                ),
                PsychologyTermAnswer("parlamentem",
                    false,
                    "parlamentní"
                ),
                PsychologyTermAnswer("není omezena",
                    false,
                    "absolutní"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Monarchie absolutní je omezena",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("není omezena",
                    false,
                    "absolutní"
                ),
                PsychologyTermAnswer("ústavou",
                    false,
                    "konstituční"
                ),
                PsychologyTermAnswer("parlamentem",
                    false,
                    "parlamentní"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jednotný stát je",
            textAnswer = "(unitární)",
            answers =
            listOf(
                PsychologyTermAnswer("stát s jedním řídícím centrem",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svazek dvou nebo více státních celků",
                    false,
                    "složený stát"
                ),
                PsychologyTermAnswer("volný svazek států, každý stát je samostatný subjekt mezinárodního práva",
                    false,
                    "konfederace"
                ),
                PsychologyTermAnswer("pevný svazek států, je jedním státem mezinárodního práva",
                    false,
                    "federace"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Centralizovaný stát je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("řízen z jednoho centra",
                    false,
                    ""
                ),
                PsychologyTermAnswer("značná část státní moci svěřena samosprávným uzemním celkům",
                    false,
                    "decentralizovaný stát"
                ),
                PsychologyTermAnswer("volný svazek států, každý stát je samostatný subjekt mezinárodního práva",
                    false,
                    "konfederace"
                ),
                PsychologyTermAnswer("pevný svazek států, je jedním státem mezinárodního práva",
                    false,
                    "federace"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pevný svazek států se nazývá",
            textAnswer = "je jedním státem mezinárodního práva",
            answers =
            listOf(
                PsychologyTermAnswer("federace",
                    false,
                    ""
                ),
                PsychologyTermAnswer("konfederace",
                    false,
                    "volný svazek států, každý stát je samostatný subjekt mezinárodního práva"
                ),
                PsychologyTermAnswer("decentralizovaný stát",
                    false,
                    "značná část státní moci svěřena samosprávným uzemním celkům"
                ),
                PsychologyTermAnswer("centralizovaný stát",
                    false,
                    "stát řízen z jednoho centra"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi příklady federace nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Velká Británie",
                    false,
                    "parlamentní monarchie"
                ),
                PsychologyTermAnswer("Spojené Státy americké",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Spolková republika Německo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Švýcarsko",
                    false,
                    "definuje se jako konfederace, struktura však odpovídá federaci"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zdůrazňování významu národnosti se nazývá",
            textAnswer = "kultura, původ, jazyk, zvyky, mravy",
            answers =
            listOf(
                PsychologyTermAnswer("nacionalismus",
                    false,
                    "zdůrazňování významu národnosti"
                ),
                PsychologyTermAnswer("kosmopolitismus",
                    false,
                    "volný vztah příslušnosti k národu"
                ),
                PsychologyTermAnswer("konfederace",
                    false,
                    "volný svazek států, každý stát je samostatný subjekt mezinárodního práva"
                ),
                PsychologyTermAnswer("federace",
                    false,
                    "pevný svazek států, je jedním státem mezinárodního práva"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Volný vztah příslušnosti k národu se nazývá",
            textAnswer = "kultura, původ, jazyk, zvyky, mravy",
            answers =
            listOf(
                PsychologyTermAnswer("kosmopolitismus",
                    false,
                    "volný vztah příslušnosti k národu"
                ),
                PsychologyTermAnswer("nacionalismus",
                    false,
                    "zdůrazňování významu národnosti"
                ),
                PsychologyTermAnswer("konfederace",
                    false,
                    "volný svazek států, každý stát je samostatný subjekt mezinárodního práva"
                ),
                PsychologyTermAnswer("federace",
                    false,
                    "pevný svazek států, je jedním státem mezinárodního práva"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Spojené státy americk jsou příkladem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("občanského státu",
                    false,
                    "smíšená národnost"
                ),
                PsychologyTermAnswer("státu dvou nebo více národů",
                    false,
                    "Belgie"
                ),
                PsychologyTermAnswer("státu s národnostními menšinami",
                    false,
                    "Slovensko"
                ),
                PsychologyTermAnswer("národního státu",
                    false,
                    "jeden národ - Portugalsko, Dánko"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "dokumenty o základních právech a svobodách občanů byly vytvořeny nadstátní organizací",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Organizace spojených národů",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Evropská unie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Organizace amerických států",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi složky státní moci demokratického státu nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("moc veto",
                    false,
                    ""
                ),
                PsychologyTermAnswer("moc zákonodárná",
                    false,
                    "vykonávají orgány jako parlament, sněmovna, apod."
                ),
                PsychologyTermAnswer("moc výkonná",
                    false,
                    "prezidenti a panovníci"
                ),
                PsychologyTermAnswer("moc soudní",
                    false,
                    "nezávislé soudy"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi typy demokracie nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("formální demokracie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("přímá demokracie",
                    false,
                    "občané dělají rozhodnutí napřímo"
                ),
                PsychologyTermAnswer("nepřímá demokracie",
                    false,
                    "volíme zástupce, kteří následně za nás dělají rozhodnutí"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ve volbách podle zásad poměrného zastoupení voliči",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("hlasují kandidátní listiny politických stran",
                    false,
                    "volby poměrného zastoupení"
                ),
                PsychologyTermAnswer("volí jednotliví kandidáti",
                    false,
                    "většinový volební systém"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ve volbách většinového volebního systému voliči",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("volí jednotliví kandidáti",
                    false,
                    "většinový volební systém"
                ),
                PsychologyTermAnswer("hlasují kandidátní listiny politických stran",
                    false,
                    "volby poměrného zastoupení"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Právo být volen se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("pasivní volební právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("aktivní volební právo",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Právo volit se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("aktivní volební právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("pasivní volební právo",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pojem právo znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("soubor předpisů, podle kterých se organizuje a řídí život lidské společnosti",
                    false,
                    "právo"
                ),
                PsychologyTermAnswer("souhrn všech právních předpisů ve státě",
                    false,
                    "právní řád, složeno z právních norem"
                ),
                PsychologyTermAnswer("závazné pravidlo chování, vydané příslušným státním orgánem v předepsané formě",
                    false,
                    "právní norma"
                ),
                PsychologyTermAnswer("společenské vztahy upravené právnimi normami",
                    false,
                    "právní vztahy"
                ),
                PsychologyTermAnswer("všechny okolnosti, s nimiž právní normy spojují vznik, změny nebo zánik právních vztahů",
                    false,
                    "právní skutečnost"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),

        PsychologyTerm(
            prompt = "Pojem právní řád znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("souhrn všech právních předpisů ve státě",
                    false,
                    "právní řád, složeno z právních norem"
                ),
                PsychologyTermAnswer("soubor předpisů, podle kterých se organizuje a řídí život lidské společnosti",
                    false,
                    "právo"
                ),
                PsychologyTermAnswer("závazné pravidlo chování, vydané příslušným státním orgánem v předepsané formě",
                    false,
                    "právní norma"
                ),
                PsychologyTermAnswer("společenské vztahy upravené právnimi normami",
                    false,
                    "právní vztahy"
                ),
                PsychologyTermAnswer("všechny okolnosti, s nimiž právní normy spojují vznik, změny nebo zánik právních vztahů",
                    false,
                    "právní skutečnost"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pojem právní norma znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("závazné pravidlo chování, vydané příslušným státním orgánem v předepsané formě",
                    false,
                    "právní norma"
                ),
                PsychologyTermAnswer("soubor předpisů, podle kterých se organizuje a řídí život lidské společnosti",
                    false,
                    "právo"
                ),
                PsychologyTermAnswer("souhrn všech právních předpisů ve státě",
                    false,
                    "právní řád, složeno z právních norem"
                ),
                PsychologyTermAnswer("společenské vztahy upravené právnimi normami",
                    false,
                    "právní vztahy"
                ),
                PsychologyTermAnswer("všechny okolnosti, s nimiž právní normy spojují vznik, změny nebo zánik právních vztahů",
                    false,
                    "právní skutečnost"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pojem právní vztahy znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("společenské vztahy upravené právnimi normami",
                    false,
                    "právní vztahy"
                ),
                PsychologyTermAnswer("soubor předpisů, podle kterých se organizuje a řídí život lidské společnosti",
                    false,
                    "právo"
                ),
                PsychologyTermAnswer("souhrn všech právních předpisů ve státě",
                    false,
                    "právní řád, složeno z právních norem"
                ),
                PsychologyTermAnswer("závazné pravidlo chování, vydané příslušným státním orgánem v předepsané formě",
                    false,
                    "právní norma"
                ),
                PsychologyTermAnswer("všechny okolnosti, s nimiž právní normy spojují vznik, změny nebo zánik právních vztahů",
                    false,
                    "právní skutečnost"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pojem právní skutečnost znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("všechny okolnosti, s nimiž právní normy spojují vznik, změny nebo zánik právních vztahů",
                    false,
                    "právní skutečnost"
                ),
                PsychologyTermAnswer("soubor předpisů, podle kterých se organizuje a řídí život lidské společnosti",
                    false,
                    "právo"
                ),
                PsychologyTermAnswer("souhrn všech právních předpisů ve státě",
                    false,
                    "právní řád, složeno z právních norem"
                ),
                PsychologyTermAnswer("závazné pravidlo chování, vydané příslušným státním orgánem v předepsané formě",
                    false,
                    "právní norma"
                ),
                PsychologyTermAnswer("společenské vztahy upravené právnimi normami",
                    false,
                    "právní vztahy, neboli upravené objektivním právem"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Objektivní právo znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právní předpisy - zákony, vládní nařízení, vyhlášky",
                    false,
                    "objektivní právo - abstraktní právo"
                ),
                PsychologyTermAnswer("nárok či oprávnění účastníka právního vztahu",
                    false,
                    "subjektivní právo - konkrétní právo"
                ),
                PsychologyTermAnswer("souhrn všech právních předpisů ve státě",
                    false,
                    "právní řád, složeno z právních norem"
                ),
                PsychologyTermAnswer("závazné pravidlo chování, vydané příslušným státním orgánem v předepsané formě",
                    false,
                    "právní norma"
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),

        PsychologyTerm(
            prompt = "Subjektivní právo znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nárok či oprávnění účastníka právního vztahu",
                    false,
                    "subjektivní právo - konkrétní právo"
                ),
                PsychologyTermAnswer("všechny okolnosti, s nimiž právní normy spojují vznik, změny nebo zánik právních vztahů",
                    false,
                    "právní skutečnost"
                ),
                PsychologyTermAnswer("právní předpisy - zákony, vládní nařízení, vyhlášky",
                    false,
                    "objektivní právo - abstraktní právo"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vývoj práva počíná",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nepsanými pravidly",
                    false,
                    "zvykové nebo obyčejové právo"
                ),
                PsychologyTermAnswer("ustanovení trestního práva",
                    false,
                    "pravděpodobně nejzákladnější právo"
                ),
                PsychologyTermAnswer("pozitivním právem",
                    false,
                    "takto se nazývá platné právo"
                ),
                PsychologyTermAnswer("právo přirozené",
                    false,
                    "v minulosti stanoveno Bohem skrze lidský rozum"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Právní řád státu neovlivňuje",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("cizince po opuštění státu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("cizince v době pobytu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("všechny občany",
                    false,
                    ""
                ),
                PsychologyTermAnswer("všechny občany i při pobytu v zahraničí",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Důležitost předpisů se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právní síla",
                    false,
                    "podle níž je právní řád uspořádán jako pyramida"
                ),
                PsychologyTermAnswer("pozitivním právem",
                    false,
                    "takto se nazývá platné právo"
                ),
                PsychologyTermAnswer("právo přirozené",
                    false,
                    "v minulosti stanoveno Bohem skrze lidský rozum"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Správné řazení právního řádu podle právní síly od nejvyššího je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("mezinárodní právo, ústava a ústavní zákon, zákony, vládní nařízení, vyhlášky ministrů, vyhlášky dalších organů (např, obce)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ústava a ústavní zákon, mezinárodní právo, zákony, vládní nařízení, vyhlášky ministrů, vyhlášky dalších organů (např, obce)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("mezinárodní právo, vládní nařízení, ústava a ústavní zákon, zákony, vyhlášky ministrů, vyhlášky dalších organů (např, obce)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("mezinárodní právo, ústava a ústavní zákon, zákony, vyhlášky ministrů, vládní nařízení, vyhlášky dalších organů (např, obce)",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi podzákonné (prováděcí) předpisy nespadá",
            imageAnswerUrl = "https://docplayer.cz/docs-images/44/4002324/images/page_14.jpg",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ústava a ústavní zákony",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vládní nařízení",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vyhlášku ministrů",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vyhlášku nižších státních orgánů, např. obcí",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zákonné (základní) předpisy nespadá",
            imageAnswerUrl = "https://docplayer.cz/docs-images/44/4002324/images/page_14.jpg",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vyhlášku ministrů",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ústava a ústavní zákony",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zákony a zákonná opatření",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://1.bp.blogspot.com/-yWEu27qqvg8/TeP6MQr65xI/AAAAAAAAAT0/MiF-Ke4_p9o/s400/pyramida.jpg",
            prompt = "Nesrovnalosti v právním řádu přezkoumává",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ústavní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("parlament",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nejvyšší soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obecní soud",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi účely sankce nepatří",
            textAnswer = "ne všechny právní normy mají sankce",
            answers =
            listOf(
                PsychologyTermAnswer("cyklické",
                    false,
                    ""
                ),
                PsychologyTermAnswer("preventivní",
                    false,
                    "(předcházející), dodává právní normě větší důraz a závažnost"
                ),
                PsychologyTermAnswer("represivní",
                    false,
                    "(odvetný), dodatečné, když už k porušení normy došlo"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi právní druhy nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("morální normy",
                    false,
                    ""
                ),
                PsychologyTermAnswer("kogentní normy",
                    false,
                    "(donucující) - např. pravidla silniční dopravy"
                ),
                PsychologyTermAnswer("dispozitivní normy",
                    false,
                    "(podpůrné) - např. uzavírání smlouvy - jelikož podniky si smlouvy většinou upraví podle potřeby"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tvorbě právních předpisů se říká",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("legislativa",
                    false,
                    ""
                ),
                PsychologyTermAnswer("kogentní normy",
                    false,
                    "(donucující) - např. pravidla silniční dopravy"
                ),
                PsychologyTermAnswer("dispozitivní normy",
                    false,
                    "(podpůrné) - např. uzavírání smlouvy - jelikož podniky si smlouvy většinou upraví podle potřeby"
                ),
                PsychologyTermAnswer("derogační klauzule",
                    false,
                    "zrušovací ustanovení - které normy či předpisy se novým předpisem ruší neboli derogují"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zrušovací ustanovení se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("derogační klauzule",
                    false,
                    "zrušovací ustanovení - které normy či předpisy se novým předpisem ruší neboli derogují"
                ),
                PsychologyTermAnswer("legislativa",
                    false,
                    "tvorba právních předpisů"
                ),
                PsychologyTermAnswer("kogentní normy",
                    false,
                    "(donucující) - např. pravidla silniční dopravy"
                ),
                PsychologyTermAnswer("dispozitivní normy",
                    false,
                    "(podpůrné) - např. uzavírání smlouvy - jelikož podniky si smlouvy většinou upraví podle potřeby"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zákonné opatření je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právní předpis, vydaný místo zákona v naléhavém případě",
                    false,
                    ""
                ),
                PsychologyTermAnswer("legislativa",
                    false,
                    "tvorba právních předpisů"
                ),
                PsychologyTermAnswer("kogentní norma",
                    false,
                    "(donucující) - např. pravidla silniční dopravy"
                ),
                PsychologyTermAnswer("derogační klauzule",
                    false,
                    "zrušovací ustanovení - které normy či předpisy se novým předpisem ruší neboli derogují"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ústavu, ústavní zákony, zákony, nálezy Ústavního soudu a další můžeme naleznout v",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Sbírka zákonů České republiky",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Věstník ministerstva školství, mládeže a tělovýchovy",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Listina základních práv a svobod",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Zákon o obcích",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Platnost právních předpisů znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("předpis byl vytvořen předepsaným způsobem a stal se součástí právního řádu",
                    false,
                    "platnost právnáho předpisu"
                ),
                PsychologyTermAnswer("povinnost předpisem se řídit, dodržovat jej",
                    false,
                    "účinnost" +
                        "\nv předpisech je občas naposáno od kdy je účinný, jinak chvíli po vyhlášení - aby se stihlo nastudovat"
                ),
                PsychologyTermAnswer("bližší informace o místě, čase a specifických entit na které předpis působí",
                    false,
                    "působnost"
                ),
                PsychologyTermAnswer("vacatio legis",
                    false,
                    "období od platnosti do účinnosti"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Platnost právních předpisů znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("předpis byl vytvořen předepsaným způsobem a stal se součástí právního řádu",
                    false,
                    "platnost právnáho předpisu"
                ),
                PsychologyTermAnswer("povinnost předpisem se řídit, dodržovat jej",
                    false,
                    "účinnost" +
                        "\nv předpisech je občas naposáno od kdy je účinný, jinak chvíli po vyhlášení - aby se stihlo nastudovat"
                ),
                PsychologyTermAnswer("bližší informace o místě, čase a specifických entit na které předpis působí",
                    false,
                    "působnost"
                ),
                PsychologyTermAnswer("vacatio legis",
                    false,
                    "období od platnosti do účinnosti"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Účinnost právních předpisů znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("povinnost předpisem se řídit, dodržovat jej",
                    false,
                    "účinnost" +
                        "\nv předpisech je občas naposáno od kdy je účinný, jinak chvíli po vyhlášení - aby se stihlo nastudovat"
                ),
                PsychologyTermAnswer("předpis byl vytvořen předepsaným způsobem a stal se součástí právního řádu",
                    false,
                    "platnost právnáho předpisu"
                ),
                PsychologyTermAnswer("bližší informace o místě, čase a specifických entit na které předpis působí",
                    false,
                    "působnost"
                ),
                PsychologyTermAnswer("vacatio legis",
                    false,
                    "období od platnosti do účinnosti"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vacatio legis znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("období od platnosti do účinnosti",
                    false,
                    "vacatio legis"
                ),
                PsychologyTermAnswer("předpis byl vytvořen předepsaným způsobem a stal se součástí právního řádu",
                    false,
                    "platnost právnáho předpisu"
                ),
                PsychologyTermAnswer("povinnost předpisem se řídit, dodržovat jej",
                    false,
                    "účinnost" +
                        "\nv předpisech je občas naposáno od kdy je účinný, jinak chvíli po vyhlášení - aby se stihlo nastudovat"
                ),
                PsychologyTermAnswer("bližší informace o místě, čase a specifických entit na které předpis působí",
                    false,
                    "působnost"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi významy působnosti právního předpisu nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("účinnost",
                    false,
                    ""
                ),
                PsychologyTermAnswer("osobní působnost",
                    false,
                    "okruh osob, na které se předpis vztahuje"
                ),
                PsychologyTermAnswer("územní působnost",
                    false,
                    "prostor, v němž se předpis uplatňuje"
                ),
                PsychologyTermAnswer("věcná působnost",
                    false,
                    "vymezuje, kterých záležitostí se předpis týká"
                ),
                PsychologyTermAnswer("časová působnost",
                    false,
                    "synonymum účinnosti - období od kdy do kdy"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi prvky právních vztahů nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("cena",
                    false,
                    ""
                ),
                PsychologyTermAnswer("účastníci",
                    false,
                    "neboli subjekty - osoby fyzické, osoby právnické. Osoba musí být způsobilá"
                ),
                PsychologyTermAnswer("obsah",
                    false,
                    "vzájemná práva a povinnosti jeho účastníků"
                ),
                PsychologyTermAnswer("předmět",
                    false,
                    "cíl (účel) k němuž práva a povinnosti účastníků směřují"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Právní subjektivita znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("způsobilost osoby mít práva a povinnosti",
                    false,
                    "vzniká narozením, zaniká úmrtím"
                ),
                PsychologyTermAnswer("způsobilost zakládat, měnit a rušit své právní vztahy",
                    false,
                    "způsobilost k právním úkonům fyz. osoby, vzniká zletilostí"
                ),
                PsychologyTermAnswer("právní úkony přiměřené rozumové vyspělosti odpovídající jejich věku",
                    false,
                    "nezletilí, zákonný zástupce"
                ),
                PsychologyTermAnswer("zbavení způsobilosti právním úkonům",
                    false,
                    "např. duševní porucha"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Způsobilost nezletilé osoby není",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("způsobilost k právním úkonům",
                    false,
                    "to má zákonný zástupce"
                ),
                PsychologyTermAnswer("právní subjektivita",
                    false,
                    "od narození (třeba dědění)"
                ),
                PsychologyTermAnswer("právní úkony přiměřené rozumové vyspělosti odpovídající jejich věku",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Poslanci Evropského parlamentu jsou do své funkce",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("voleni v přímých volbách",
                    false
                ),
                PsychologyTermAnswer("jmenováni Evropskou radou",
                    false
                ),
                PsychologyTermAnswer("delegováni parlamenty jednotlivých států",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Precedentálním právem je právo",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("anglické",
                    false
                ),
                PsychologyTermAnswer("německé",
                    false,
                    "kontinentální právo"
                ),
                PsychologyTermAnswer("rakouské",
                    false,
                    "kontinentální právo"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Prohlášením československé samostatnosti byla dne 18. 10. 1918",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Washingtonská deklarace",
                    false
                ),
                PsychologyTermAnswer("Pittsburgská deklarace",
                    false
                ),
                PsychologyTermAnswer("Martinská deklarace",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Korporace je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("společenství fyzických osob",
                    false,
                    "např. družstvo, obchodní společnost, vystupuje jako identita zvlášť"
                ),
                PsychologyTermAnswer("majetkové společenství",
                    false,
                    "s peněžní podstatou - fondy, nadace" +
                        "\ns jinou majetkovou hodnotou (např. budovy) - podniky, ústavy"
                ),
                PsychologyTermAnswer("společenství právnických osob",
                    false,
                    "sdružení"
                ),
                PsychologyTermAnswer("fyzická osoba",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Družstvo je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("společenství fyzických osob",
                    false,
                    "např. družstvo, obchodní společnost, vystupuje jako identita zvlášť"
                ),
                PsychologyTermAnswer("majetkové společenství",
                    false,
                    "s peněžní podstatou - fondy, nadace" +
                        "\ns jinou majetkovou hodnotou (např. budovy) - podniky, ústavy"
                ),
                PsychologyTermAnswer("společenství právnických osob",
                    false,
                    "sdružení"
                ),
                PsychologyTermAnswer("fyzická osoba",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Fond je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("majetkové společenství",
                    false,
                    "s peněžní podstatou - fondy, nadace" +
                        "\ns jinou majetkovou hodnotou (např. budovy) - podniky, ústavy"
                ),
                PsychologyTermAnswer("společenství fyzických osob",
                    false,
                    "např. družstvo, obchodní společnost, vystupuje jako identita zvlášť"
                ),
                PsychologyTermAnswer("společenství právnických osob",
                    false,
                    "sdružení"
                ),
                PsychologyTermAnswer("fyzická osoba",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Sdružení je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("společenství právnických osob",
                    false,
                    "sdružení"
                ),
                PsychologyTermAnswer("majetkové společenství",
                    false,
                    "s peněžní podstatou - fondy, nadace" +
                        "\ns jinou majetkovou hodnotou (např. budovy) - podniky, ústavy"
                ),
                PsychologyTermAnswer("společenství fyzických osob",
                    false,
                    "např. družstvo, obchodní společnost, vystupuje jako identita zvlášť"
                ),
                PsychologyTermAnswer("fyzická osoba",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ústav je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("majetkové společenství",
                    false,
                    "s peněžní podstatou - fondy, nadace" +
                        "\ns jinou majetkovou hodnotou (např. budovy) - podniky, ústavy"
                ),
                PsychologyTermAnswer("společenství fyzických osob",
                    false,
                    "např. družstvo, obchodní společnost, vystupuje jako identita zvlášť"
                ),
                PsychologyTermAnswer("společenství právnických osob",
                    false,
                    "sdružení"
                ),
                PsychologyTermAnswer("fyzická osoba",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Které subjekty pravděpodobně nejsou právnickými osoby?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("živnostník",
                    false,
                    ""
                ),
                PsychologyTermAnswer("stát",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obec",
                    false,
                    ""
                ),
                PsychologyTermAnswer("fond",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "V případě, že právo není úplatněno ve stanovené lhůtě dochází k",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("prekluzi práva",
                    false,
                    "propadnutí, stanovuje se jen výjimečně"
                ),
                PsychologyTermAnswer("promlčení práva",
                    false,
                    "právo nezaniká, pouze se oslabuje - platí všeobecně"
                ),
                PsychologyTermAnswer("vydržení práva",
                    false,
                    "držením věci po stanovenou vydržecí dobu nabývá vlastnické právo \"oprávněný držitel\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "V případě, že právo není úplatněno dochází k",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("promlčení práva",
                    false,
                    "právo nezaniká, pouze se oslabuje - platí všeobecně"
                ),
                PsychologyTermAnswer("prekluzi práva",
                    false,
                    "propadnutí, stanovuje se jen výjimečně"
                ),
                PsychologyTermAnswer("vydržení práva",
                    false,
                    "držením věci po stanovenou vydržecí dobu nabývá vlastnické právo \"oprávněný držitel\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Při nákupu v obchodě na samoobslužné pokladně dochází k subjektivní právní skutečnosti",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("konkludentní čin",
                    false,
                    "mlčky dávání najevo souhlas"
                ),
                PsychologyTermAnswer("výslovný souhlas",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Platný právní úkon nesmí být",
            textAnswer = "ostatní být musí",
            answers =
            listOf(
                PsychologyTermAnswer("nechtěný",
                    false,
                    "pokud se tomu tak stane"
                ),
                PsychologyTermAnswer("dodržená předepsaná forma",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svobodný",
                    false,
                    ""
                ),
                PsychologyTermAnswer("srozumitelný",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vážně míněný",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Rozvázání pracovního poměru je právní úkon",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("jednostranný (unilaterální)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dvoustranný (bilaterální)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("mnohostranný (multilaterální)",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Založení družstva 3 a více osoby je právní úkon",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("mnohostranný (multilaterální)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("jednostranný (unilaterální)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dvoustranný (bilaterální)",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Uzavření nájemní smlouvy je právní úkon",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("dvoustranný (bilaterální)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("jednostranný (unilaterální)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("mnohostranný (multilaterální)",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jak se nazývají upravené typické druhy smluv",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("pojmenované",
                    false,
                    "mají uzákoněné názvy, např. kupní či nájemní smlouva"
                ),
                PsychologyTermAnswer("nepojmenované",
                    false,
                    "(atypické) - pokud žádný z již existujících smluv nevyhovuje"
                ),
                PsychologyTermAnswer("dispozitivní",
                    false,
                    "právní řád připouští smluvní volnost - dispozitivnost"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Systém práva je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("uspořádání právního řádu do příslušných právních odvětví",
                    false,
                    "systém práva - právo ústavní, správní, občanské, obchodní, pracovní, rodinné, trestní, finanční, mezinárodní, apod."
                ),
                PsychologyTermAnswer("právní úkony jimiž se právní vztahy zakládají, mění nebo ruší záměrně a uvědoměle",
                    false,
                    "právní skutečnosti subjektivní"
                ),
                PsychologyTermAnswer("události, které vyplývají z přírodních zákonitostí, nezávisle na vůli účastníků",
                    false,
                    "právní skutečnosti objektivní"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Právní skutečnost objektivní je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("události, které vyplývají z přírodních zákonitostí, nezávisle na vůli účastníků",
                    false,
                    "právní skutečnosti objektivní"
                ),
                PsychologyTermAnswer("uspořádání právního řádu do příslušných právních odvětví",
                    false,
                    "systém práva - právo ústavní, správní, občanské, obchodní, pracovní, rodinné, trestní, finanční, mezinárodní, apod."
                ),
                PsychologyTermAnswer("právní úkony jimiž se právní vztahy zakládají, mění nebo ruší záměrně a uvědoměle",
                    false,
                    "právní skutečnosti subjektivní"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Právní skutečnost subjektivní je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právní úkony jimiž se právní vztahy zakládají, mění nebo ruší záměrně a uvědoměle",
                    false,
                    "právní skutečnosti subjektivní"
                ),
                PsychologyTermAnswer("uspořádání právního řádu do příslušných právních odvětví",
                    false,
                    "systém práva - právo ústavní, správní, občanské, obchodní, pracovní, rodinné, trestní, finanční, mezinárodní, apod."
                ),
                PsychologyTermAnswer("události, které vyplývají z přírodních zákonitostí, nezávisle na vůli účastníků",
                    false,
                    "právní skutečnosti objektivní"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Veřejné právo vyjadřuje",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právo v zájmu celé společnosti",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo v zájmu právnických osob",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo v zájmu jednotlivců",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Soukromé právo vyjadřuje",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právo v zájmu jednotlivců",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo v zájmu právnických osob",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo v zájmu celé společnosti",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Veřejné právo upravuje vztahy",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("v nichž je stát a jeho orgány nadřazený vůči podřízeným osobám",
                    false,
                    ""
                ),
                PsychologyTermAnswer("na základě rovnosti účastníků",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v nichž je stát a jeho orgány podřízený vůči nadřazeným osobám",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Soukromé právo upravuje vztahy",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("na základě rovnosti účastníků",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v nichž je stát a jeho orgány nadřazený vůči podřízeným osobám",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v nichž je stát a jeho orgány podřízený vůči nadřazeným osobám",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "O ústavě není pravda",
            textAnswer = "Ústavní právo vychází z 1/1993 Sb. Ústava České republiky a Listina základních práv a svobod č. 2/1993 Sb",
            answers =
            listOf(
                PsychologyTermAnswer("obsahuje ustanovení, že politická rozhodnutí nevycházejí z vůle většiny",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obsahuje preambuli",
                    false,
                    "úvodní prohlášení"
                ),
                PsychologyTermAnswer("obsahuje 113 článků",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obsahuje 8 hlav",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "V České republice má zákonodárnou moc",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("parlament",
                    false,
                    "veřejné a jejich usnesení se veřejní ve Sbírce zákonů České republiky"
                ),
                PsychologyTermAnswer("ústavní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ministři",
                    false,
                    ""
                ),
                PsychologyTermAnswer("poslanci",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi informace o prezidentovi není pravda",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("řídí administrativní aparát",
                    false,
                    "to řídí vláda"
                ),
                PsychologyTermAnswer("minimální věk 40 let",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nelze zvolit více než dvakrát",
                    false,
                    ""
                ),
                PsychologyTermAnswer("volební období je 5 let",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vláda se neskládá z",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("presidenta",
                    false,
                    ""
                ),
                PsychologyTermAnswer("předsedy",
                    false,
                    ""
                ),
                PsychologyTermAnswer("místopředsedů",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ministrů",
                    false,
                    "každý má svůj RESORT"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Do soustavy nezávislých soudů s mocí soudní nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("obecný soud",
                    false,
                    "obecný soud odpůrce při občanském soudním řízení - kde má žalovaný místo bydliště"
                ),
                PsychologyTermAnswer("nejvyšší soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nejvyšší správní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vrchní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("krajský soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("okresní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ústavní soud",
                    false,
                    "může rušit zákony, které nesouhlasí s ústavou"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Všeobecná deklarace lidských práv byla přijata",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("10. prosince 1948",
                    false,
                    "\"Všeobecná deklarace lidských práv\"" +
                        "\n-Spojené národy - UN"
                ),
                PsychologyTermAnswer("1991", false, "rozpad SSSR"),
                PsychologyTermAnswer("1918",
                    false,
                    "rozpad Rakouska-Uherska, zároveň vznik Československa"
                ),
                PsychologyTermAnswer("1939", false, "Podkarpatská Rus již není částí Československa"),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi lidská práva nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právo na vodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na život",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na svobodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo vlastnit majetek",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřípustnost cenzury",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zaručení dědění majetku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svobodně se združovat",
                    false,
                    ""
                ),
                PsychologyTermAnswer("práva hospodářská",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na vzdělání",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na právní pomoc",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svoboda pohybu, pobytu, myšlení, svědomí, náboženství, umělecké tvorby a vědeckého bádání",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi lidská práva nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právo na vodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na život",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na svobodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo vlastnit majetek",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřípustnost cenzury",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zaručení dědění majetku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svobodně se združovat",
                    false,
                    ""
                ),
                PsychologyTermAnswer("práva hospodářská",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na vzdělání",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na právní pomoc",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svoboda pohybu, pobytu, myšlení, svědomí, náboženství, umělecké tvorby a vědeckého bádání",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi lidská práva nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právo na vodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na život",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na svobodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo vlastnit majetek",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřípustnost cenzury",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zaručení dědění majetku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svobodně se združovat",
                    false,
                    ""
                ),
                PsychologyTermAnswer("práva hospodářská",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na vzdělání",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na právní pomoc",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svoboda pohybu, pobytu, myšlení, svědomí, náboženství, umělecké tvorby a vědeckého bádání",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi lidská práva nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("právo na vodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na život",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na svobodu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo vlastnit majetek",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nepřípustnost cenzury",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zaručení dědění majetku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svobodně se združovat",
                    false,
                    ""
                ),
                PsychologyTermAnswer("práva hospodářská",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na vzdělání",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na právní pomoc",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svoboda pohybu, pobytu, myšlení, svědomí, náboženství, umělecké tvorby a vědeckého bádání",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Součástí správního práva není",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("předpisy pro centrální banku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("předpisy o výkonné státní moci",
                    false,
                    "organizace a činnosti státního administratívního aparátu"
                ),
                PsychologyTermAnswer("předpisy o veřejné správě",
                    false,
                    "o územní samosprávě"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ústřední orgány správního práva například tvoří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ministerstva",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obecní úřady",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právnické komory",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Orgány místní správy správního práva například tvoří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("obecní úřady",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ministerstva",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právnické komory",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi atributy obce nepatří",
            textAnswer = "Obec je právnická osoba",
            answers =
            listOf(
                PsychologyTermAnswer("hymnu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obecní prapor",
                    false,
                    ""
                ),
                PsychologyTermAnswer("znak",
                    false,
                    ""
                ),
                PsychologyTermAnswer("jméno",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vnejší část obce se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("extravilán",
                    false,
                    "vnější část obce - pole, louky, lesy, cesty apod."
                ),
                PsychologyTermAnswer("intravilán",
                    false,
                    "vnitřní část obce - bydlení"
                ),
                PsychologyTermAnswer("vacatio legis",
                    false,
                    "období od platnosti do účinnosti"
                ),
                PsychologyTermAnswer("kosmopolitismus",
                    false,
                    "volný vztah příslušnosti k národu"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vnitřní část obce se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("intravilán",
                    false,
                    "vnitřní část obce - bydlení"
                ),
                PsychologyTermAnswer("extravilán",
                    false,
                    "vnější část obce - pole, louky, lesy, cesty apod."
                ),
                PsychologyTermAnswer("vacatio legis",
                    false,
                    "období od platnosti do účinnosti"
                ),
                PsychologyTermAnswer("kosmopolitismus",
                    false,
                    "volný vztah příslušnosti k národu"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zákon o obcích označuje jmenovitě 19 statutárních měst, jejich území se nemůže členit na",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("svazky obcí",
                    false,
                    ""
                ),
                PsychologyTermAnswer("městské obvody",
                    false,
                    ""
                ),
                PsychologyTermAnswer("městské části",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi rozlišení činnosti obce nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("podnikavost",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obecní samospráva",
                    false,
                    "samostatná působnost - správa vlastních obecních záležitostí"
                ),
                PsychologyTermAnswer("přenesená působnost",
                    false,
                    "VÝKON STÁTNÍ SPRÁVY v rozsahu v jakém ji stát podle míry decentralizace přenesl na obce některými zákony"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Obec se při výkonu obecní samosprávy řídí podle",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nikoho",
                    false,
                    "nepodléhá žádnomu nadřízenému státnímu orgánu"
                ),
                PsychologyTermAnswer("okrsku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("státu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Přenesená působnost je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("podíl obce na výkonu státní správy",
                    false,
                    "přenesená působnost"
                ),
                PsychologyTermAnswer("správa vlastních obecních záležitostí",
                    false,
                    "obecní samospráva"
                ),
                PsychologyTermAnswer("vnější část obce",
                    false,
                    "extravilán, pole, louky, lesy, cesty apod."
                ),
                PsychologyTermAnswer("vnitřní část obce",
                    false,
                    "intravilán, na bydlení"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi orgány obce nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("obecní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("obecní zastupitelstvo",
                    false,
                    "(ve městech městské zastupitelstvo)" +
                        "\nnejvyšší orgán obce, podle velikosti obce 5-55 členů, rozpočet, hospodaření, apod."
                ),
                PsychologyTermAnswer("obecní rada",
                    false,
                    "má 5-11 členů, tvoří ji starosta, jeho zástupce a další radní" +
                        "\n-obecní RADA SE NEVOLÍ kde má obecní zastupitelstvo méně než 15 členů" +
                        "\n-zřizuje komise"
                ),
                PsychologyTermAnswer("starosta",
                    false,
                    "zastupuje obec navenek, scolává a řídí schůze"
                ),
                PsychologyTermAnswer("obecní úřad",
                    false,
                    "tvoří starosta, zástupce starosty a zamestnanci úřadu" +
                        "\nMá-li obecní úřad alespoň 2 odbory, řídí zaměstnance TAJEMNÍK"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Trestní právo hmotné",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vymezuje co jsou trestné činy a jaké trest se za ně ukládají",
                    false,
                    "trestní právo hmotné"
                ),
                PsychologyTermAnswer("upravuje postup při zjišťování trestných činů",
                    false,
                    "trestní právo procesní"
                ),
                PsychologyTermAnswer("případ, kdy jsou splněny podmínky trestní odpovědnosti",
                    false,
                    "trestní odpovědnost: naplnění skutkové podstaty a vina" +
                        "\nvina - pachatelův psychický vztah ke skutečnostem naplňujícím skutkovou podstatu"
                ),
                PsychologyTermAnswer("pachatelův psychický vztah ke skutečnostem naplňujícím skutkovou podstatu",
                    false,
                    "vina"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vina",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("pachatelův psychický vztah ke skutečnostem naplňujícím skutkovou podstatu",
                    false,
                    "vina"
                ),
                PsychologyTermAnswer("vymezuje co jsou trestné činy a jaké trest se za ně ukládají",
                    false,
                    "trestní právo hmotné"
                ),
                PsychologyTermAnswer("upravuje postup při zjišťování trestných činů",
                    false,
                    "trestní právo procesní"
                ),
                PsychologyTermAnswer("případ, kdy jsou splněny podmínky trestní odpovědnosti",
                    false,
                    "trestní odpovědnost: naplnění skutkové podstaty a vina" +
                        "\nvina - pachatelův psychický vztah ke skutečnostem naplňujícím skutkovou podstatu"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pachatelem trestného činu může být pouze",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("fyzická osoba",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právnická osoba",
                    false,
                    ""
                ),
                PsychologyTermAnswer("fyzická osoba, která není součástí státního orgánu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("fyzická osoba bez dluhů",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi okolnosti vylučující trestnost osoby nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("o skutečnostech nelhala",
                    false,
                    ""
                ),
                PsychologyTermAnswer("jednánala v nutné obraně",
                    false,
                    ""
                ),
                PsychologyTermAnswer("jednánala v krajní nouzi",
                    false,
                    ""
                ),
                PsychologyTermAnswer("neměla dostatečný věk (15 roků)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("byla nepříčetná",
                    false,
                    "např. duševní porucha"
                ),
                PsychologyTermAnswer("oprávněně použila zbraň",
                    false,
                    "např. voják na stráži"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Osoba, která věděla, že její konání může způsobit porušení zákona, avšak spoléhala, že k tomu nedojde",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nedbalost vědomá",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nedbalost nevědomá",
                    false,
                    "když o tom osoba ani nevěděla"
                ),
                PsychologyTermAnswer("úmysl",
                    false,
                    "když osoba zákon porušit chtěla"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Recidiva znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("opakování trestného činu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("lítost porušení zákona",
                    false,
                    ""
                ),
                PsychologyTermAnswer("navrácení způsobené škody",
                    false,
                    ""
                ),
                PsychologyTermAnswer("přiznání",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Při trestním stíhání mladistvých",
            textAnswer = "15-18",
            answers = listOf(
                PsychologyTermAnswer("se trestní sazby snižují na polovinu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("se trestní sazby nesnižují",
                    false,
                    ""
                ),
                PsychologyTermAnswer("trestní sazby dostává zákonný zástupce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nejsou trestní sazby",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi 12 hlav trestného zákona s 200 skutkovými podstaty nepatří:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Trestné činy obecné", false, ""),
                PsychologyTermAnswer("Trestné činy proti republice",
                    false,
                    "vyzvědačství, hanobení republiky a jejího představitele"
                ),
                PsychologyTermAnswer("Trestné činy hospodářské",
                    false,
                    "neoprávněné podnikání, zkrácení daně"
                ),
                PsychologyTermAnswer("Trestné činu proti pořádku ve věcech veřejných",
                    false,
                    "útok na veřejného činitele, uplácení"
                ),
                PsychologyTermAnswer("Trestné činy hrubě narušující občanské soužití",
                    false,
                    "týrání zvířat, opilství, říšení poplašné zprávy, pomluva"
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi 12 hlav trestného zákona s 200 skutkovými podstaty nepatří:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Trestné činy narušující bezpečnost práce", false, ""),
                PsychologyTermAnswer("Trestné činy proti rodině a mládeži",
                    false,
                    "zanedbávání povinné výživy"
                ),
                PsychologyTermAnswer("Trestné činy proti životu a zdraví",
                    false,
                    "vražda, ublížení na zdraví"
                ),
                PsychologyTermAnswer("Trestné činy proti svobodě a lidské důstojnosti",
                    false,
                    "útisk, znásilnění, vydírání"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi 12 hlav trestného zákona s 200 skutkovými podstaty nepatří:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Trestné činy proti veřejnosprávě", false, ""),
                PsychologyTermAnswer("Trestné činy proti majetku",
                    false,
                    "krádež, poškozování cizí věci"
                ),
                PsychologyTermAnswer("Trestné činy proti lidskosti",
                    false,
                    "podpora a propagace hnutí proti práv a svobod občanů, genocidium"
                ),
                PsychologyTermAnswer("Trestné činy proti brannosti a proti civilní službě",
                    false,
                    "nenastoupení služby, neplnění odvodní povinnosti"
                ),
                PsychologyTermAnswer("Trestné činy vojenské",
                    false,
                    "neuposlechnutí rozkazu, zběhnutí"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi 12 hlav trestného zákona s 200 skutkovými podstaty nepatří:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Trestné činy proti mravnosti", false, ""),
                PsychologyTermAnswer("Trestné činu proti pořádku ve věcech veřejných",
                    false,
                    "útok na veřejného činitele, uplácení"
                ),
                PsychologyTermAnswer("Trestné činy hrubě narušující občanské soužití",
                    false,
                    "týrání zvířat, opilství, říšení poplašné zprávy, pomluva"
                ),
                PsychologyTermAnswer("Trestné činy proti svobodě a lidské důstojnosti",
                    false,
                    "útisk, znásilnění, vydírání"
                ),
                PsychologyTermAnswer("Trestné činy proti majetku",
                    false,
                    "krádež, poškozování cizí věci"
                ),
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi 12 hlav trestného zákona s 200 skutkovými podstaty nepatří:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Trestné činy proti demokracii", false, ""),
                PsychologyTermAnswer("Trestné činu proti pořádku ve věcech veřejných",
                    false,
                    "útok na veřejného činitele, uplácení"
                ),
                PsychologyTermAnswer("Trestné činy hrubě narušující občanské soužití",
                    false,
                    "týrání zvířat, opilství, říšení poplašné zprávy, pomluva"
                ),
                PsychologyTermAnswer("Trestné činy proti svobodě a lidské důstojnosti",
                    false,
                    "útisk, znásilnění, vydírání"
                ),
                PsychologyTermAnswer("Trestné činy proti majetku",
                    false,
                    "krádež, poškozování cizí věci"
                ),
                PsychologyTermAnswer("Trestné činy proti lidskosti",
                    false,
                    "podpora a propagace hnutí proti práv a svobod občanů, genocidium"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi odvětví veřejného práva nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Technické právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Finanční právo",
                    false,
                    "předpisy o finanční činnosti státu a plnění povinností vůči státu" +
                        "\n-státní rozpočet, daně, poplatky, cla, měna, devizové hospodaření (bezhotovostní cizí měna)"
                ),
                PsychologyTermAnswer("Živnostenské právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Trestní právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Subjektivní právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Veřejné právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Soukromé právo",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Správní právo",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Deviza je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("bezhotovostní forma cizích peněz",
                    false,
                    "deviza, např cenné papíry, šeky, akcie"
                ),
                PsychologyTermAnswer("hotovostní forma cizích peněz",
                    false,
                    "valuta"
                ),
                PsychologyTermAnswer("prekluze práva",
                    false,
                    "propadnutí, stanovuje se jen výjimečně"
                ),
                PsychologyTermAnswer("vydržení práva",
                    false,
                    "držením věci po stanovenou vydržecí dobu nabývá vlastnické právo \"oprávněný držitel\""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Majetkové právo věcné je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("ochrana užívání věcí, bez spojitosti s povinností jiné osoby",
                    false,
                    "majetkové právo, např. právo vlastnické"
                ),
                PsychologyTermAnswer("práva a povinnosti mezi osobami, mezi věřiteli a dlužníky",
                    false,
                    "závazkové - obligační právo"
                ),
                PsychologyTermAnswer("majetkové vztahy fyzických a právnických osob a ochrana osobnnosti",
                    false,
                    "občanské právo"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. duševní vlastnictví je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("majetková práva k nehmotným věcěm",
                    false,
                    ""
                ),
                PsychologyTermAnswer("právo na svobodné myšlení",
                    false,
                    ""
                ),
                PsychologyTermAnswer("hmotné vlastnictví",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dobrý duševní stav",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Insolvence je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("když dluhy převyšují hodnotu majetku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("když člověk nemá peníze",
                    false,
                    ""
                ),
                PsychologyTermAnswer("když právnická osoba nemůže splatit své dluhy",
                    false,
                    ""
                ),
                PsychologyTermAnswer("když fyzická osoba nemůže splatit své dluhy",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Věci movité jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("majetek, který se kterým se dá pohybovat",
                    false,
                    "movitý majetek"
                ),
                PsychologyTermAnswer("pozemky",
                    false,
                    "nemovitý majetek"
                ),
                PsychologyTermAnswer("věci, které lze reálně dělit",
                    false,
                    "dělitelný majetek"
                ),
                PsychologyTermAnswer("věci, které se dělí pomocí ideálního podílu",
                    false,
                    "nedělitelný majetek"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Věci nemovité jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("pozemky",
                    false,
                    "nemovitý majetek"
                ),
                PsychologyTermAnswer("majetek, který se kterým se dá pohybovat",
                    false,
                    "movitý majetek"
                ),
                PsychologyTermAnswer("věci, které lze reálně dělit",
                    false,
                    "dělitelný majetek"
                ),
                PsychologyTermAnswer("věci, které se dělí pomocí ideálního podílu",
                    false,
                    "nedělitelný majetek"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Nedělitelný majetek je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("věci, které se dělí pomocí ideálního podílu",
                    false,
                    "nedělitelný majetek"
                ),
                PsychologyTermAnswer("pozemky",
                    false,
                    "nemovitý majetek"
                ),
                PsychologyTermAnswer("majetek, který se kterým se dá pohybovat",
                    false,
                    "movitý majetek"
                ),
                PsychologyTermAnswer("věci, které lze reálně dělit",
                    false,
                    "dělitelný majetek"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vlastnické právo nelze získat",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nálezem",
                    false,
                    "nálezce má právo na pokrytí nutných výdajů a 10% z ceny nalezené věci"
                ),
                PsychologyTermAnswer("smlouvou",
                    false,
                    "(kupní, darovací, směnnou)"
                ),
                PsychologyTermAnswer("děděním",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vydržením",
                    false,
                    ""
                ),
                PsychologyTermAnswer("rozhodnutím státního orgánu",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Podílové spoluvlastnictví je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vlastnictví s mírou, podle které se rozvrhují práva a povinnosti",
                    false,
                    "podíl lze volně převést na blízké osoby či předkupním právem"
                ),
                PsychologyTermAnswer("vlastnictví akcie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("majetek mezi manžely získaný za trvání manželství",
                    false,
                    "společné jmění"
                ),
                PsychologyTermAnswer("zaměstnanecké akcie",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Společné jmění je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("majetek mezi manžely získaný za trvání manželství",
                    false,
                    "společné jmění"
                ),
                PsychologyTermAnswer("vlastnictví s mírou, podle které se rozvrhují práva a povinnosti",
                    false,
                    "podíl lze volně převést na blízké osoby či předkupním právem"
                ),
                PsychologyTermAnswer("vlastnictví akcie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zaměstnanecké akcie",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi možnosti rozsahu závazkového právního vztahu nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("něco prodat",
                    false,
                    ""
                ),
                PsychologyTermAnswer("něco dát",
                    false,
                    "dare"
                ),
                PsychologyTermAnswer("něco vykonat",
                    false,
                    "facere"
                ),
                PsychologyTermAnswer("něco strpět",
                    false,
                    "pati"
                ),
                PsychologyTermAnswer("něco nekonat",
                    false,
                    "non facere"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Něco dát v závazkovém právního vztahu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("dare",
                    false,
                    "něco dát"
                ),
                PsychologyTermAnswer("facere",
                    false,
                    "něco vykonat"
                ),
                PsychologyTermAnswer("pati",
                    false,
                    "něco strpět"
                ),
                PsychologyTermAnswer("non facere",
                    false,
                    "něco nekonat"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Něco vykonat v závazkovém právního vztahu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("facere",
                    false,
                    "něco vykonat"
                ),
                PsychologyTermAnswer("dare",
                    false,
                    "něco dát"
                ),
                PsychologyTermAnswer("pati",
                    false,
                    "něco strpět"
                ),
                PsychologyTermAnswer("non facere",
                    false,
                    "něco nekonat"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Něco strpět v závazkovém právního vztahu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("pati",
                    false,
                    "něco strpět"
                ),
                PsychologyTermAnswer("facere",
                    false,
                    "něco vykonat"
                ),
                PsychologyTermAnswer("dare",
                    false,
                    "něco dát"
                ),
                PsychologyTermAnswer("non facere",
                    false,
                    "něco nekonat"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Něco nekonat v závazkovém právního vztahu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("non facere",
                    false,
                    "něco nekonat"
                ),
                PsychologyTermAnswer("pati",
                    false,
                    "něco strpět"
                ),
                PsychologyTermAnswer("facere",
                    false,
                    "něco vykonat"
                ),
                PsychologyTermAnswer("dare",
                    false,
                    "něco dát"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi dúvody vzniku závazků nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vlastnictví akcií",
                    false,
                    ""
                ),
                PsychologyTermAnswer("smlouva",
                    false,
                    ""
                ),
                PsychologyTermAnswer("způsobená škoda",
                    false,
                    ""
                ),
                PsychologyTermAnswer("bezdůvodné obohacení",
                    false,
                    "např. záloha na smlouvě, která se neuskutečnila"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Společné dluhy a společné pohledávky nemohou být",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("volné",
                    false,
                    ""
                ),
                PsychologyTermAnswer("solidární",
                    false,
                    "tj. společné"
                ),
                PsychologyTermAnswer("podílové",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Solidární společný dluh je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("společný",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nezávislý",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("podílový",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Právní vady věci jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("třetí osoba uplatňuje nárok na věci",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vady na věci",
                    false,
                    ""
                ),
                PsychologyTermAnswer("moc nízká/vysoká cena",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nedostatečný popis ve smlouvě",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Faktické vady věci jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vady na věci",
                    false,
                    ""
                ),
                PsychologyTermAnswer("třetí osoba uplatňuje nárok na věci",
                    false,
                    ""
                ),
                PsychologyTermAnswer("moc nízká/vysoká cena",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nedostatečný popis ve smlouvě",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi řešení v případě, kdy lze vadu věci odstranit nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("zrušení smlouvy",
                    false,
                    ""
                ),
                PsychologyTermAnswer("sleva z ceny",
                    false,
                    ""
                ),
                PsychologyTermAnswer("oprava",
                    false,
                    ""
                ),
                PsychologyTermAnswer("doplnění toho, co chybí",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Závazek nezaniká",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("smrtí dlužníka v případě finanční dlužnosti",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dohodou",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v případě, kdy plnění je nemožné",
                    false,
                    ""
                ),
                PsychologyTermAnswer("smrtí dlužníka v případě splnění věci osobně",
                    false,
                    ""
                ),
                PsychologyTermAnswer("započtení",
                    false,
                    "neboli kompenzace"
                ),
                PsychologyTermAnswer("výpověď",
                    false,
                    "jednostranný právní úkon"
                ),
                PsychologyTermAnswer("neuplatnění práva",
                    false,
                    "pokud je trvání nároku omezeno lhůtou"
                ),
                PsychologyTermAnswer("splynutím",
                    false,
                    ""
                ),
                PsychologyTermAnswer("narovnáním",
                    false,
                    ""
                ),
                PsychologyTermAnswer("uplynutím doby",
                    false,
                    "např. nájmy na určitou dobu"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zánik závazku, kdy věřitel a dlužník splynou v jeden právnickou osob se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("splynutím",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dohoda",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v případě, kdy plnění je nemožné",
                    false,
                    ""
                ),
                PsychologyTermAnswer("smrtí dlužníka v případě splnění věci osobně",
                    false,
                    ""
                ),
                PsychologyTermAnswer("započtení",
                    false,
                    "neboli kompenzace"
                ),
                PsychologyTermAnswer("výpověď",
                    false,
                    "jednostranný právní úkon"
                ),
                PsychologyTermAnswer("neuplatnění práva",
                    false,
                    "pokud je trvání nároku omezeno lhůtou"
                ),
                PsychologyTermAnswer("narovnáním",
                    false,
                    ""
                ),
                PsychologyTermAnswer("uplynutím doby",
                    false,
                    "např. nájmy na určitou dobu"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zánik závazku, kdy účastníci mají vzájemné splatné pohledávky stejného druhu se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("započtení",
                    false,
                    "neboli kompenzace"
                ),
                PsychologyTermAnswer("splynutí",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dohoda",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v případě, kdy plnění je nemožné",
                    false,
                    ""
                ),
                PsychologyTermAnswer("smrtí dlužníka v případě splnění věci osobně",
                    false,
                    ""
                ),
                PsychologyTermAnswer("výpověď",
                    false,
                    "jednostranný právní úkon"
                ),
                PsychologyTermAnswer("neuplatnění práva",
                    false,
                    "pokud je trvání nároku omezeno lhůtou"
                ),
                PsychologyTermAnswer("narovnání",
                    false,
                    ""
                ),
                PsychologyTermAnswer("uplynutím doby",
                    false,
                    "např. nájmy na určitou dobu"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zánik závazku, kdy nájem projde ve smlouvě určenou dobou se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("uplynutí doby",
                    false,
                    "např. nájmy na určitou dobu"
                ),
                PsychologyTermAnswer("započtení",
                    false,
                    "neboli kompenzace"
                ),
                PsychologyTermAnswer("splynutí",
                    false,
                    ""
                ),
                PsychologyTermAnswer("dohoda",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v případě, kdy plnění je nemožné",
                    false,
                    ""
                ),
                PsychologyTermAnswer("smrtí dlužníka v případě splnění věci osobně",
                    false,
                    ""
                ),
                PsychologyTermAnswer("výpověď",
                    false,
                    "jednostranný právní úkon"
                ),
                PsychologyTermAnswer("neuplatnění práva",
                    false,
                    "pokud je trvání nároku omezeno lhůtou"
                ),
                PsychologyTermAnswer("narovnání",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Manželství nemůže vzniknout",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("bez presence ani jednoho",
                    false,
                    ""
                ),
                PsychologyTermAnswer("s presencí státního orgánu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("před orgánem státem registrované církve",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kolizní opatrovník je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("zástupce dětí při konfliktu mezi manžely",
                    false,
                    ""
                ),
                PsychologyTermAnswer("pěstounská péče",
                    false,
                    ""
                ),
                PsychologyTermAnswer("osvojení dítěte",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Osvojení je",
            textAnswer = "k osvojení rozhoduje soud na návrh osvojitele",
            answers =
            listOf(
                PsychologyTermAnswer("přijetí cizího dítěte za vlastní",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zástupce dětí při konfliktu mezi manžely",
                    false,
                    "kolizní opatrovník"
                ),
                PsychologyTermAnswer("dočasná péče o dítě, která zaniká dosažením zletilosti dítěte",
                    false,
                    "pěstounská péče"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Nezrušitelně osvojované dítě musí být",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("starší než jeden rok",
                    false,
                    ""
                ),
                PsychologyTermAnswer("starší než pět let",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zletilé",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nezletilé",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jestliže někoho žaluji, jsem v pozici",
            textAnswer = "Některé procesy jsou zahájeny i bez návrhu",
            answers =
            listOf(
                PsychologyTermAnswer("navrhovatele",
                    false,
                    "navrhuji pouze písemně"
                ),
                PsychologyTermAnswer("odpůrce",
                    false,
                    "žalovaný"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Věcně příslušný k občanskému soudnímu řízení je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("okresní soud",
                    false,
                    "VYJÍMKY - např. v obchodním právu je to krajský soud"
                ),
                PsychologyTermAnswer("obecný soud odpůrce",
                    false,
                    "kde má žalovaný místo bydliště"
                ),
                PsychologyTermAnswer("vrchní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("krajský soud",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Místně příslušný k občanskému soudnímu řízení je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("obecný soud odpůrce",
                    false,
                    "kde má žalovaný místo bydliště"
                ),
                PsychologyTermAnswer("okresní soud",
                    false,
                    "VYJÍMKY - např. v obchodním právu je to krajský soud"
                ),
                PsychologyTermAnswer("vrchní soud",
                    false,
                    ""
                ),
                PsychologyTermAnswer("okresní soud",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Usnesení soudu",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("probíhá v průběhu řízení",
                    false,
                    "např. přerušení"
                ),
                PsychologyTermAnswer("rozhodnutí o věci samé, o návrhu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("opravný prostředek proti rozhodnutí soudu",
                    false,
                    "odvolání"
                ),
                PsychologyTermAnswer("opravný prostředek vůči odvolání",
                    false,
                    "dovolání - rozhoduje Nejvyšší soud České republiky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Rozsudek soudu",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je rozhodnutí o věci samé, o návrhu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("probíhá v průběhu řízení",
                    false,
                    "např. přerušení"
                ),
                PsychologyTermAnswer("je opravný prostředek proti rozhodnutí soudu",
                    false,
                    "odvolání"
                ),
                PsychologyTermAnswer("je opravný prostředek vůči odvolání",
                    false,
                    "dovolání - rozhoduje Nejvyšší soud České republiky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Odvolání soudu",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je opravný prostředek proti rozhodnutí soudu",
                    false,
                    "odvolání"
                ),
                PsychologyTermAnswer("je rozhodnutí o věci samé, o návrhu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("probíhá v průběhu řízení",
                    false,
                    "např. přerušení"
                ),
                PsychologyTermAnswer("je opravný prostředek vůči odvolání",
                    false,
                    "dovolání - rozhoduje Nejvyšší soud České republiky"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Dovolání soudu",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("je opravný prostředek vůči odvolání",
                    false,
                    "dovolání - rozhoduje Nejvyšší soud České republiky"
                ),
                PsychologyTermAnswer("je opravný prostředek proti rozhodnutí soudu",
                    false,
                    "odvolání"
                ),
                PsychologyTermAnswer("je rozhodnutí o věci samé, o návrhu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("probíhá v průběhu řízení",
                    false,
                    "např. přerušení"
                )
            ),
            categoryId = "",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Které informace o notáři nejsou pravdivé",
            textAnswer = "notářská komora",
            answers =
            listOf(
                PsychologyTermAnswer("poskytuje právní pomoc",
                    false,
                    "advokát, Česká advokátní komora"
                ),
                PsychologyTermAnswer("je jmenován ministrem spravedlnosti",
                    false,
                    ""
                ),
                PsychologyTermAnswer("sepisuje veřejné listiny o právních úkonech",
                    false,
                    "např. závěti"
                ),
                PsychologyTermAnswer("osvědčuje právně významné skutečnosti",
                    false,
                    ""
                ),
                PsychologyTermAnswer("v řízení o dědictví jsou soudními komisaři",
                    false,
                    ""
                )
            ),
            categoryId = "",
            correctAnswer = 0
        )
    )
}