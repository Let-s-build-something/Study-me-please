package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

//zrevidovano
object PsychologyTwo {
    val psychologyPrompts = listOf(
        PsychologyTerm(
            prompt = """Míra prestiže jedince ve skupině má nejblíže k pojmu""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální status""",
                    false
                ),
                PsychologyTermAnswer(
                    """sociální stratifikace""",
                    false,
                    "Rozdělení společnosti do vrstev/kategorií - např. kastovní systém, otrokřský, třídní, stavovský (dědičný)"
                ),
                PsychologyTermAnswer("""sociální lapsus""", false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""rating prestiže""",
                    false
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Soubor očekávání, která jsou spjata s určitým místem jedince ve skupině, se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """sebesplňující proroctví""",
                    false,
                    "Pygmalion efekt (pozitivní), golem efekt (negativní)"
                ),
                PsychologyTermAnswer("""sociální role""",
                    false
                ),
                PsychologyTermAnswer("""skupinový tlak""", false,
                    "konformita, Milgram (1974)"
                ),
                PsychologyTermAnswer("""sociální pozice""",
                    false
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín deindividuace označuje""",
            textAnswer = "Odosobnění, ztrácíme se, např. když sledujeme sportovní utkání a hodně se soustředíme",
            answers = listOf(
                PsychologyTermAnswer(
                    """psychiatrický symptom obvyklý u poruch, které mají původ v narušených vztazích""",
                    false
                ),
                PsychologyTermAnswer("""ztrátu sebevědomí v davové situaci""",
                    false
                ),
                PsychologyTermAnswer(
                    """ztrátu sebevědomí nastávající v důsledku nedostatečné socializace""",
                    false
                ),
                PsychologyTermAnswer(
                    """ztrátu sebeuvědomování a pocitu zodpovědnosti v určitých skupinových situacích""",
                    false
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termínem sociální polarizace se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """vyostření názorů jedince na nějakou problematiku po komunikaci s lidmi, kteří mají podobné názory jako tento jedinec""",
                    false
                ),
                PsychologyTermAnswer(
                    """vyostření názorů jedince na nějakou problematiku po komunikaci s lidmi, kteří mají opačné názory jako tento jedinec""",
                    false
                ),
                PsychologyTermAnswer(
                    """vyostřování názorových rozdílů mezi lidmi z ekonomicky slabých a ekonomicky silných vrstev společnosti""",
                    false
                ),
                PsychologyTermAnswer(
                    """změna názorů způsobená vlivem rozporných extrémně vyhraněných argumentů""",
                    false
                ),
            ),
            questionNumber = 4,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Podle teorie sociálního srovnávání""",
            textAnswer = "Festinger (1954), hlavně porovnání nám relavantní, pomáhá vytvářet sebepojetí" +
                "\n\t-Srovnáváme se s lidmi na stejné úrovni" +
                "\n\t-Srovnávání nahoru se děje pokud se chceme zlepšit" +
                "\n\t-Srovnávání dolů je obranný mechanismus",
            answers = listOf(
                PsychologyTermAnswer(
                    """představuje důležitou diagnostickou informaci o druhých lidech ve skupině srovnání jejich výkonů""",
                    false
                ),
                PsychologyTermAnswer(
                    """není srovnávání osob vhodným prostředkem k dosažení motivační změny""",
                    false
                ),
                PsychologyTermAnswer(
                    """je snaha vnímat a prezentovat sebe sama žádoucím způsobem trvalou motivací jedince""",
                    false,
                    "Socilání srovnávání motivuje jedince."
                ),
                PsychologyTermAnswer(
                    """vnímáme ostatní jedince především na základě jejich rozdílů""",
                    false
                ),
            ),
            questionNumber = 5,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Haló efekt při vytváření dojmu z určitého jedince nejspíše vyvolá:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""barva jeho pleti""",
                    false,
                "zároveň stereotyp"
                ),
                PsychologyTermAnswer(
                    """to, je-li vnímán jako srdečný nebo chladný""",
                    false
                ),
                PsychologyTermAnswer("""ani jedno""",
                    false
                ),
                PsychologyTermAnswer("""oboje zmíněné""",
                    false
                ),
            ),
            questionNumber = 6,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Které z faktorů ovlivňují ochotu pomoci druhému člověku?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""oba uvedené""",
                    false
                ),
                PsychologyTermAnswer("""pohlaví osoby, která potřebuje pomoc""",
                    false
                ),
                PsychologyTermAnswer("""ani jeden uvedený""",
                    false
                ),
                PsychologyTermAnswer("""posouzení příčiny nesnází""",
                    false
                ),
            ),
            questionNumber = 7,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Sebeschéma je""",
            textAnswer = "schémata jsou vodítkem, co je pro jedince seberelevantní, jsou filtrem informací",
            answers = listOf(
                PsychologyTermAnswer(
                    """celková hodnota, kterou člověk přikládá svému vlastnímu já""",
                    false
                ),
                PsychologyTermAnswer(
                    """schéma sociálních vztahů vytvářené jedincem, které má rekurzivní strukturu""",
                    false
                ),
                PsychologyTermAnswer(
                    """struktura, která určuje jaké informace bude jedinec považovat za relevantní pro hodnocení a vnímání sebe sama""",
                    false,
                    "Sociální srovnávání nám pomáhá formulovat sebepojetí pomocí porovnávání s ostatními."
                ),
                PsychologyTermAnswer(
                    """diagnostický postup, kdy člověk do speciálního diagramu zachycuje jednotlivé složky vlastního vnímaného já""",
                    false
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Pomáhání druhým a jiné projevy altruismu označujeme jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální chování""",
                    false
                ),
                PsychologyTermAnswer("""prosociální chování""",
                    false
                ),
                PsychologyTermAnswer("""asociální chování""",
                    false
                ),
                PsychologyTermAnswer("""sociální podporu""",
                    false
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termínem persuaze se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """přesvědčování a ovlivňování postojů a jednání""",
                    false
                ),
                PsychologyTermAnswer(
                    """změna postojů ve směru k prosociálnímu chování""",
                    false
                ),
                PsychologyTermAnswer(
                    """dynamický proces ve skupině snižující kohezi""",
                    false
                ),
                PsychologyTermAnswer("""technika zjišťování postojů""",
                    false
                ),
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Jaký vliv má přítomnost dalších lidí na pravděpodobnost," +
                " že jedinec poskytne pomoc druhému jedinci?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """pravděpodobnost se nemění, ale mění se druh pomoci""",
                    false
                ),
                PsychologyTermAnswer(
                    """pravděpodobnost poskytnutí pomoci se snižuje""",
                    false,
                    "Efekt přihlížejícího."
                ),
                PsychologyTermAnswer(
                    """pravděpodobnost poskytnutí pomoci se zvyšuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """zvyšuje se pravděpodobnost, ale míra pomoci je menší""",
                    false
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Zjišťování vztahů ve skupině metodou vzájemných voleb se nazývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""skupinový výběr""",
                    false,
                    "(Group selection) - evoluční výběr genů"
                ),
                PsychologyTermAnswer("""skupinový rating""",
                    false
                ),
                PsychologyTermAnswer("""sociometrie""",
                    false,
                    "Sociometrie - Zkoumání skrze vzájemné výběry a odmítnutí členů malé skupiny."
                ),
                PsychologyTermAnswer("""sociologie""",
                    false
                ),
            ),
            questionNumber = 12,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který termín nepatří k ostatním?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""afektivita""",
                    false,
                    "Hodně spontánní, není plánované, intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření"
                ),
                PsychologyTermAnswer("""agresivita""",
                    false
                ),
                PsychologyTermAnswer("""hostilita""",
                    false
                ),
                PsychologyTermAnswer("""nepřátelství""",
                    false
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Sociometrie je""",
            textAnswer = "Sociometrie - Zkoumání skrze vzájemné výběry a odmítnutí členů malé skupiny.",
            answers = listOf(
                PsychologyTermAnswer(
                    """sociálně psychologický audit ve velkých organizacích""",
                    false
                ),
                PsychologyTermAnswer(
                    """průzkum zjišťující strukturu postojů ve společnosti""",
                    false
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false
                ),
                PsychologyTermAnswer(
                    """způsob zjišťování vztahů ve skupině a skupinové dynamiky""",
                    false
                ),
            ),
            questionNumber = 14,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Podle teorie (hypotéza) frustrace-agrese""",
            textAnswer = "Skupina z Yale - Frustrace navozuje pohotovost k agresi, ale její projev závisí na dalších okolnostech",
            answers = listOf(
                PsychologyTermAnswer(
                    """se vyskytuje buď frustrace, nebo agrese, avšak nikdy ne obojí dohromady""",
                    false
                ),
                PsychologyTermAnswer(
                    """dochází před každým projevem frustrace k nějaké agresi""",
                    false
                ),
                PsychologyTermAnswer("""je agrese příčinou frustrace""",
                    false
                ),
                PsychologyTermAnswer(
                    """dochází před každým projevem agrese k nějaké frustraci""",
                    false
                ),
            ),
            questionNumber = 15,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Šikana se klasifikuje jako případ""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""ani jednoho z uvedených""",
                    false
                ),
                PsychologyTermAnswer("""vyprovokované agrese""",
                    false
                ),
                PsychologyTermAnswer("""instrumentální agrese""",
                    false,
                    "Předem plánovaná, není cílem, pouze pomůcka."
                ),
                PsychologyTermAnswer("""afektivní agrese""",
                    false,
                    "Hodně spontánní, není plánované, intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření"
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Slovo dyáda označuje""",
            textAnswer = "(řeč. dyó = dva) relativně stálý vztah mezi dvěmi osobami",
            answers = listOf(
                PsychologyTermAnswer("""trojici""",
                    false
                ),
                PsychologyTermAnswer("""výměnu informací mezi dvěma jedinci""",
                    false
                ),
                PsychologyTermAnswer("""malou uzavřenou skupinu""",
                    false
                ),
                PsychologyTermAnswer("""dvojici""",
                    false
                ),
            ),
            questionNumber = 17,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Ke způsobům nonverbální komunikace nepatří:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""skupinová polarizace""",
                    false,
                    """vyostření názorů jedince na nějakou problematiku po komunikaci s lidmi, kteří mají podobné názory jako tento jedinec"""
                ),
                PsychologyTermAnswer("""sdílení postojů""",
                    false
                ),
                PsychologyTermAnswer("""slovní sdělování""",
                    false
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false
                ),
            ),
            questionNumber = 18,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termínem efekt přihlížejících (bystander efekt) se označuje fakt, že""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """přítomnost jiných lidí snižuje pravděpodobnost, že jedinec poskytne pomoc""",
                    false
                ),
                PsychologyTermAnswer(
                    """v přítomnosti jiných lidí se aktivují mechanismy abb sebeprezentace""",
                    false
                ),
                PsychologyTermAnswer(
                    """lidé mají sklon přihlížet vzrušujícím událostem""",
                    false
                ),
                PsychologyTermAnswer(
                    """sebepojetí je závislé na hodnocení druhými osobami""",
                    false
                ),
            ),
            questionNumber = 19,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Mezi paralingvistické projevy nepatří""",
            textAnswer = "J. Křivohlavý:" +
                "\n\t1. Hlasitost řeči - šepot / hlučná" +
                "\n\t2. Výška tónu řeči - bas, alt / tenor, soprán" +
                "\n\t3. Rychlost řeči" +
                "\n\t4. Objem řeči - málo / mimořádně mnoho" +
                "\n\t5. Plynulost řeči - zámlky, pomlky / plynulost" +
                "\n\t6. Intonace - monotónní / \"téměř zpívá\"" +
                "\n\t7. Chyby v řeči - přeřeknutí, nedokončené věty / bez chyb" +
                "\n\t8. Správnost výslovnosti" +
                "\n\t9. Kvalita řeči - věcnost hovoru - strohý / upovídaný" +
                "\n\t10. Členění řečí - frázování - bez pauzy / moc pauz",
            answers = listOf(
                PsychologyTermAnswer("""pauzy""",
                    false
                ),
                PsychologyTermAnswer(
                    """sémantika""",
                    false,
                    "Vztah mezi znaky a jejich významy"
                ),
                PsychologyTermAnswer("""intonace""",
                    false
                ),
                PsychologyTermAnswer("""tempo řeči""",
                    false
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Obdobím psychosociálního moratoria se nazývá období""",
            textAnswer = "Je to stádium člověka, kdy již je dospělý, dospělým však být nechce a odkládá dospelý život na později." +
                "\nNapř. stále bydlí s rodiči kvůli komfortu, jezdí s nimi na dovolenou, studují zbytečné školy jen aby něco studovali apod.",
            answers = listOf(
                PsychologyTermAnswer("""předškolního věku""",
                    false
                ),
                PsychologyTermAnswer("""stáří""",
                    false
                ),
                PsychologyTermAnswer(
                    """adolescence""",
                    false,
                    "Společnost dovoluje adolescentovi experimentovat s hodnotami, aby si mohl vytvořit vlastní identitu"
                ),
                PsychologyTermAnswer("""puberty""",
                    false
                ),
            ),
            questionNumber = 21,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených termínů nejméně souvisí se sociální percepcí?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """posun k riziku""",
                    false,
                    """Stejně smýšlející skupina táhne k ještě většímu riziku než samotný jedinec."""
                ),
                PsychologyTermAnswer(
                    """atribuce""",
                    false,
                    "Kognitivní proces přisuzování jedné či více příčin vlastnímu chování a chování jiných lidí." +
                        " Dělí se na vnější a vnitřní."
                ),
                PsychologyTermAnswer(
                    """haló efekt""",
                    false,
                    """Připisování irelevantních a neznámých atributů na základě obecných prvotních atributů.
                        "Ta blondýna musí být fakt blbá"
                    """
                ),
                PsychologyTermAnswer(
                    """centrální organizační rys""",
                    false,
                    "Jak již slovo \"centrální\" napovídá, jedná se o základní rys, " +
                        "který se nám o osobě udelá a následně nám i pomáhá v interpretaci ostatních rysů."
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Společnost dovoluje adolescentovi experimentovat s hodnotami, aby si mohl vytvořit vlastní identitu. Hovoříme o",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """sociální toleranci""",
                    false,
                    """Do doby, kdy to nikomu neubližuje, chování se toleruje.
                        Například divný chování v metru, které je často tolerováno. 
                    """
                ),
                PsychologyTermAnswer("""období životního experimentu""",
                    false
                ),
                PsychologyTermAnswer("""psychosociálním moratoriu""",
                    false,
                    "Je to stádium člověka, kdy již je dospělý, dospělým však být nechce a odkládá dospelý život na později." +
                        "\nNapř. stále bydlí s rodiči kvůli komfortu, jezdí s nimi na dovolenou, studují zbytečné školy jen aby něco studovali apod."
                ),
                PsychologyTermAnswer("""psychosociální úlevě""",
                    false,
                    "id"
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených efektů nemá vliv na formování dojmu o osobách?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """haló efekt""",
                    false,
                    """Přisuzování neznámých atributů osobě na základě jednoduchých atributů jako je třeba barva pleti, či temperament."""
                ),
                PsychologyTermAnswer(
                    """autokinetický efekt""",
                    false,
                    """Máme pocit, že světlá tečka v tmavém prostoru se hýbe, jelikož ji nemáme k čemu přichytit (anchor)."""
                ),
                PsychologyTermAnswer(
                    """efekt novosti""",
                    false,
                    """Informace nám nejnověji přivedené do vědomí mají větší váhu než ty, které nám byly přivedeny do vědomí dávno."""
                ),
                PsychologyTermAnswer(
                    """efekt primárnosti""",
                    false,
                    """První informace které o osobě dostaneme mají větší váhu než ty další.
                         Malý, modrooký, štědrý vs. Štědrý, modrooký, malý.
                    """
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Sociální mobilita je""",
            textAnswer = "Přechod jednotlivce v rámci určité sociální hierarchie.",
            answers = listOf(
                PsychologyTermAnswer("""pohyblivost členů společnosti""",
                    false
                ),
                PsychologyTermAnswer("""společenský závazek""",
                    false
                ),
                PsychologyTermAnswer("""schopnost odolávat společenským tlakům""",
                    false
                ),
                PsychologyTermAnswer("""nejbohatší část společnosti""",
                    false
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Když podáme hodnotící osobě informaci o určitém rysu chování nějaké osoby společně s dalšími nesouvisejícími charakteristikami,
                 jaký vliv má tato informace na hodnocení charakterizované osoby?""",
            textAnswer = "Hraje tu roli přehlcení informacemi.",
            answers = listOf(
                PsychologyTermAnswer(
                    """silnější, než kdyby byla tatáž informace podána samostatně""",
                    false
                ),
                PsychologyTermAnswer(
                    """slabší, než kdyby byla tatáž informace podána samostatně""",
                    false
                ),
                PsychologyTermAnswer(
                    """vliv závisí pouze na tom, na kterém místě v pořadí charakteristik byla informace uvedena""",
                    false
                ),
                PsychologyTermAnswer(
                    """stejná informace má vždy stejný vliv, bez ohledu na kontext při prezentaci""",
                    false
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Pokud osoba vykonává činnost, kterou dobře ovládá, za přítomnosti jiných osob, její výkon se",
            textAnswer = "Vliv přítomnosti jiných lidí na chování člověka. Touto problematikou se zabýval pravděpodobně první experiment v sociální psychologie (1898)," +
                " který uskutečnil Norman Triplett. Pozoroval jevy v cyklisty a jejich zrychlení, když jely v skupinách.",
            answers = listOf(
                PsychologyTermAnswer("""stává nestabilním""",
                    false
                ),
                PsychologyTermAnswer("""zvyšuje""",
                    false
                ),
                PsychologyTermAnswer("""snižuje""",
                    false,
                    "Pouze pokud to je něco pro osobu těžké"
                ),
                PsychologyTermAnswer("""nemění""",
                    false
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Shoda názorů či postojů se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""konsensus""",
                    false
                ),
                PsychologyTermAnswer("""konsonance""",
                    false
                ),
                PsychologyTermAnswer("""konspekt""",
                    false
                ),
                PsychologyTermAnswer("koheze",
                    false,
                    "Soudržnost"
                ),
            ),
            questionNumber = 28,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Skupina osob v populaci, která má nějakou společnou charakteristiku (aniž by tvořily sociální skupinu), se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""agregát""",
                    false,
                    "seskupení lidí, které nemá charakter sociální skupiny"
                ),
                PsychologyTermAnswer("""souručenství""",
                    false
                ),
                PsychologyTermAnswer("""dav""",
                    false,
                    "Málo organizované seskupení většího množství lidí," +
                        " ve kterém se snižuje racionální kontrola a zvyšuje se působení emocionálních reakcí na prožívání a chování"
                ),
                PsychologyTermAnswer("""kohorta""",
                    false
                ),
            ),
            questionNumber = 29,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Málo organizované seskupení většího množství lidí," +
                 " ve kterém se snižuje racionální kontrola a zvyšuje se působení emocionálních reakcí na prožívání a chování," +
                  " se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""depersonalizovaná skupina""",
                    false
                ),
                PsychologyTermAnswer("""agregát""",
                    false,
                    "seskupení lidí, které nemá charakter sociální skupiny"
                ),
                PsychologyTermAnswer(
                    """chaotická kohorta""",
                    false,
                    "Skupina osob v populaci, která má nějakou společnou charakteristiku (aniž by tvořily sociální skupinu)"
                ),
                PsychologyTermAnswer("""dav""",
                    false,
                    "Málo organizované seskupení většího množství lidí," +
                        " ve kterém se snižuje racionální kontrola a zvyšuje se působení emocionálních reakcí na prožívání a chování"
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených mechanismů či stavů se v obvyklých teoriích nepovažuje za příčinu agrese?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""depresivita""",
                    false
                ),
                PsychologyTermAnswer("""frustrace""",
                    false
                ),
                PsychologyTermAnswer(
                    """sociální učení""",
                    false,
                    """Dedukce chování na základě sociální situace (třeba mám sociální roli být strážník ve vězení - agrese normalizována)."""
                ),
                PsychologyTermAnswer("""generalizace instinktu""",
                    false
                ),
            ),
            questionNumber = 31,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Vysoká teplota prostředí má""",
            textAnswer = "Afektivní agresivita - hodně spontánní, není plánované, intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření",
            answers = listOf(
                PsychologyTermAnswer("""tlumivý vliv na afektivní agresivitu""",
                    false
                ),
                PsychologyTermAnswer(
                    """nespecifický vliv na afektivní agresivitu""",
                    false
                ),
                PsychologyTermAnswer("""nulový vliv na míru agresivity""",
                    false
                ),
                PsychologyTermAnswer("""posilující vliv na afektivní agresivitu""",
                    false
                ),
            ),
            questionNumber = 32,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Trojúhelníková teorie lásky R. J. Sternberga nezahrnuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""závazek""",
                    false
                ),
                PsychologyTermAnswer("""atraktivitu""",
                    false
                ),
                PsychologyTermAnswer("""intimitu""",
                    false
                ),
                PsychologyTermAnswer("""vášeň""",
                    false
                ),
            ),
            questionNumber = 33,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín agapé se používá pro označení""",
            textAnswer = "(lat. caritas - charité - charity) láska pečující",
            answers = listOf(
                PsychologyTermAnswer("""nesobecké altruistické lásky""",
                    false
                ),
                PsychologyTermAnswer("""odpoutání od sociálních vztahů""",
                    false
                ),
                PsychologyTermAnswer(
                    """neschopnosti vytvořit si pozitivní pouto k lidem""",
                    false
                ),
                PsychologyTermAnswer("""ničeho z uvedených""",
                    false
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Slovo minorita označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nábožensky orientované skupiny""",
                    false
                ),
                PsychologyTermAnswer("""menšinu""",
                    false
                ),
                PsychologyTermAnswer("""vedlejší aspekty sociální role""",
                    false
                ),
                PsychologyTermAnswer("""sociální vztahy v dětství""",
                    false
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Sebepotvrzující strategie slouží k zajištění toho,""",
            textAnswer = "Chceme aby nás ostatní vnímali jak vnímáme my sami sebe.",
            answers = listOf(
                PsychologyTermAnswer(
                    """aby lidé vnímali instituci jako potřebnou a vstřícnou""",
                    false
                ),
                PsychologyTermAnswer(
                    """aby byla zajištěna vypovídací hodnota sociálněpsychologického testování""",
                    false
                ),
                PsychologyTermAnswer(
                    """aby nebylo možné vyvrátit argumenty koalice při vnitroskupinovém konfliktu""",
                    false
                ),
                PsychologyTermAnswer(
                    """aby nás druzí vnímali a hodnotili stejně, jako se vnímáme a hodnotíme my sami""",
                    false
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Kterým termínem se někdy označují očekávání, která máme vůči člověku zastávajícímu určitou roli?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""expektace""",
                    false
                ),
                PsychologyTermAnswer("""exprimace""",
                    false,
                    "vyloučení"
                ),
                PsychologyTermAnswer("""anticipační útvary""",
                    false
                ),
                PsychologyTermAnswer("""postojové škály""",
                    false,
                    "Měřící nástroje pro měření postojů."
                ),
            ),
            questionNumber = 37,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Lidé mají sklon regulovat své chování podle své představy o tom, jaké chování je u nich očekáváno. Mluvíme o",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""automutilaci""",
                    false,
                    "sebepoškozování"
                ),
                PsychologyTermAnswer("""vlastním já""",
                    false
                ),
                PsychologyTermAnswer("""sebemonitorování""",
                    false
                ),
                PsychologyTermAnswer("""self-konceptu""",
                    false
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Mezi tři základní typy agrese není zařazována:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""afektivní agrese""",
                    false,
                    "Hodně spontánní, není plánované, intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření"
                ),
                PsychologyTermAnswer("""šikana""",
                    false,
                    "neklasifikuje se jako instrumentální agrese"
                ),
                PsychologyTermAnswer("""institucionální agrese""",
                    false,
                    "Agresivní chování, které je součástí nějaké společensky uznané profese, nazýváme"
                ),
                PsychologyTermAnswer("""přesunutá agrese""",
                    false
                ),
            ),
            questionNumber = 39,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Mezi strategie sebeprezentace nepatří""",
            textAnswer = "\t-Stategie zavděčení" +
                "\n\t-Strategie příkladnosti - cena je založena na morálních kvalitách (čestnost, spravedlivost, disciplína)" +
                "\n\t-Strategie sebepovýšení - snaha být vítěz" +
                "\n\t-Strategie zastrašování" +
                "\n\t-Strategie pokorného chování - cíl vyvolat pocit viny, aby o jedince pečovali",
            answers = listOf(
                PsychologyTermAnswer("""strategie paradoxní intence""",
                    false,
                    "Frankl, Postavení se strachu jako řešení - intencionální létání letadlem pokud se bojím - dělání opaku."
                ),
                PsychologyTermAnswer("""strategie sebepovýšení""",
                    false
                ),
                PsychologyTermAnswer("""strategie zastrašování""",
                    false
                ),
                PsychologyTermAnswer("""strategie zavděčení""",
                    false
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín agregát označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("mechanismus, kterým vzniká davové chování",
                    false
                ),
                PsychologyTermAnswer("proces, kterým se propojuje jedinec se skupinou",
                    false
                ),
                PsychologyTermAnswer(
                    "seskupení lidí, které nemá charakter sociální skupiny",
                    false
                ),
                PsychologyTermAnswer("podskupinu, která má velký vliv na skupinovou dynamiku",
                    false
                ),
            ),
            questionNumber = 41,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Která z uvedených nepatří mezi složky postojů",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("citová",
                    false,
                    "(emocionální dimenze) - co k předmětu cítíme"
                ),
                PsychologyTermAnswer("intencionální",
                    false
                ),
                PsychologyTermAnswer(
                    "kognitivní",
                    false,
                    "(kognitivní dimenze) - myšlenku a názory o předmětu"
                ),
                PsychologyTermAnswer("behaviorální",
                    false,
                    "(konativní, či behaviorální dimenze) - sklon k chování ve vztahu k předmětu"
                ),
            ),
            questionNumber = 42,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Termín proximita označuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("prostorovou blízkost",
                    false
                ),
                PsychologyTermAnswer("pouto vznikající ve vztahu",
                    false
                ),
                PsychologyTermAnswer(
                    "skupinovou kohezi",
                    false
                ),
                PsychologyTermAnswer("gestikulaci",
                    false
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Ve známém experimentu byli dobrovolníci podrobeni zdlouhavé a nudné proceduře." +
                " Jedna část z nich dostala jako odměnu jeden dolar, druhá pětadvacet dolarů." +
                " Poté se sledovalo, jak budou informovat své kolegy o průběu experimentu. Která z alternativ je správná?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("osoby, které dostaly větší odměnu, hodnotily experiment jako zábavnější a příjemnější než osoby, které dostaly odměnu menší.",
                    false
                ),
                PsychologyTermAnswer("osoby, které dostaly menší odměnu, hodnotily experiment jako zábavnější a příjemnější než osoby, které dostaly odměnu větší.",
                    false
                ),
                PsychologyTermAnswer(
                    "obě skupiny hodnotily experiment podobně, avšak ti, kteří dostali menší odměnu uváděli méně podrobností než osoby z druhé skupiny",
                    false
                ),
                PsychologyTermAnswer("obě skupiny hodnotily experiment podobně, avšak ti, kteří dostali větší odměnu uváděli méně podrobností než osoby z druhé skupiny",
                    false
                ),
            ),
            questionNumber = 44,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Sociogram zachycuje",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("strukturu společnosti, jak výplývá z analýzy statistických údajů o populaci",
                    false
                ),
                PsychologyTermAnswer("vývoj koheze skupiny od založení po rozpad",
                    false
                ),
                PsychologyTermAnswer(
                    "vzájemné preference členů skupiny v určité době, jak byly zachyceny sociometrickým testem",
                    false
                ),
                PsychologyTermAnswer("druh a styl interakcí mezi jednotlivými členy skupiny",
                    false
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Věta \"Němci jsou hluční a ukřičení\" je příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("haló efektu",
                    false
                ),
                PsychologyTermAnswer("stereotypu",
                    false
                ),
                PsychologyTermAnswer(
                    "prototypu",
                    false
                ),
                PsychologyTermAnswer("sociální dedukce",
                    false,
                    "(z lat. deduction - odvození) - z premisů se odvozují závery - z obecných tvrzení specificické závery"
                ),
            ),
            questionNumber = 46,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Altruismus je typem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("antisociálního chování",
                    false
                ),
                PsychologyTermAnswer("sociální zodpovědnosti",
                    false
                ),
                PsychologyTermAnswer(
                    "recipročního chování",
                    false
                ),
                PsychologyTermAnswer("prosociálního chování",
                    false
                ),
            ),
            questionNumber = 47,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Agresivní chování, které je součástí nějaké společensky uznané profese, nazýváme",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("agresivní závazek",
                    false
                ),
                PsychologyTermAnswer("tolerovaná agrese",
                    false
                ),
                PsychologyTermAnswer(
                    "institucionální agrese",
                    false
                ),
                PsychologyTermAnswer("vázaná agrese",
                    false
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Chování, kterým si jedinci vymezují či chrání určité prostorové oblasti vůči ostatním příslušníkům téhož druhu, se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("orientačně pátrací reakce",
                    false
                ),
                PsychologyTermAnswer("prostorová komunikace",
                    false
                ),
                PsychologyTermAnswer(
                    "teritorialita",
                    false
                ),
                PsychologyTermAnswer("prostorová orientace",
                    false
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Meadův pojem, označující reprezentaci společnosti v mysli jedince, zní",
            textAnswer = "Sociální psychologie (sociální behaviorismus), reprezentace společnoste v mysli jedince - zobecněný druhý (generalized other) - Interakce je zprostředkována interpretacemi a významy mezi jedinci., Symbolický Interakcionismus - interakce jedinců a jejich interpretace.",
            answers = listOf(
                PsychologyTermAnswer("""signifikantní druhý (significant other)""",
                    false
                ),
                PsychologyTermAnswer("""zobecněný druhý (generalized other)""",
                    false,
                    "Interakce je zprostředkována interpretacemi a významy mezi jedinci."
                ),
                PsychologyTermAnswer(
                    """interaktivní sociální instance (interactive social instance)""",
                    false
                ),
                PsychologyTermAnswer("""sociální konstrukt (social construct)""",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Rozmístění a vzdálenost aktérů komunikace patří k prvkům nonverbálního sdělování. Tuto oblast označujeme jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""distantologii""",
                    false
                ),
                PsychologyTermAnswer("""kineziku""",
                    false
                ),
                PsychologyTermAnswer("""proxemiku""",
                    false,
                    "Edward Twitchell Hall"
                ),
                PsychologyTermAnswer("""posturologii""",
                    false
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Sociální facilitace je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nic z uvedeného""",
                    false
                ),
                PsychologyTermAnswer("""urychlení vzniku sociální skupiny""",
                    false
                ),
                PsychologyTermAnswer("""podpora sociální skupiny jejímu členovi""",
                    false
                ),
                PsychologyTermAnswer(
                    """vliv přítomnosti jiných osob na výkon jedince""",
                    false
                ),
            ),
            questionNumber = 52,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Prezentujeme osobám řadu neznámých a citově neutrálních podnětů (neznámé znaky, cizí slova, fotografie lidí)." +
                " Některé z nich se přitom opakují." +
                " Jak tyto opakované podněty obvykle přijímají pokusné osoby? (Jde o tzv. efekt pouhé prezentace, \"mere exposure\"",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""negativně""",
                    false
                ),
                PsychologyTermAnswer("""asi stejně často pozitivně i negativně""",
                    false
                ),
                PsychologyTermAnswer("""obojí stejně""",
                    false
                ),
                PsychologyTermAnswer("""pozitivně""",
                    false
                ),
            ),
            questionNumber = 53,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Afiliace je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nedostatek pozitivních emočních kontaktů""",
                    false
                ),
                PsychologyTermAnswer("""příliš ochranitelský postoj""",
                    false
                ),
                PsychologyTermAnswer("""ztráta syna""",
                    false
                ),
                PsychologyTermAnswer("""tvorba pozitivních emočních kontaktů""",
                    false
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Zabití svědka proto, aby nemohl identifikovat pachatele, je příkladem",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""latentní agresivity""",
                    false
                ),
                PsychologyTermAnswer("""instrumentální agrese""",
                    false,
                    "Předem plánovaná, není cílem, pouze pomůcka."
                ),
                PsychologyTermAnswer("""afektivní agrese""",
                    false,
                    "Hodně spontánní, není plánované, intenzivní emoce, vzniké náhle, prudce a mají konkrétní zaměření"
                ),
                PsychologyTermAnswer("""latentní hostility""",
                    false
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Příkladem sociální instituce nebude/nebudou nejspíše:""",
            textAnswer = "Skupina s neosobními funkcemi. Kulturní, sociální způsob jednání.",
            answers = listOf(
                PsychologyTermAnswer("Vánoce",
                    false
                ),
                PsychologyTermAnswer("rodina",
                    false
                ),
                PsychologyTermAnswer("manželství",
                    false
                ),
                PsychologyTermAnswer("ani jedna odpověď není správně",
                    false
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Mezi paralingvistické projevy nepatří""",
            textAnswer = "Paralingivstika - zvuková stránka verbální komunikace." +
                "J. Křivohlavý:" +
                "\n\t1. Hlasitost řeči - šepot / hlučná" +
                "\n\t2. Výška tónu řeči - bas, alt / tenor, soprán" +
                "\n\t3. Rychlost řeči" +
                "\n\t4. Objem řeči - málo / mimořádně mnoho" +
                "\n\t5. Plynulost řeči - zámlky, pomlky / plynulost" +
                "\n\t6. Intonace - monotónní / \"téměř zpívá\"" +
                "\n\t7. Chyby v řeči - přeřeknutí, nedokončené věty / bez chyb" +
                "\n\t8. Správnost výslovnosti" +
                "\n\t9. Kvalita řeči - věcnost hovoru - strohý / upovídaný" +
                "\n\t10. Členění řečí - frázování - bez pauzy / moc pauz",
            answers = listOf(
                PsychologyTermAnswer("""intonace""",
                    false
                ),
                PsychologyTermAnswer("""obsah sdělení""",
                    false
                ),
                PsychologyTermAnswer("""hlasitost řeči""",
                    false
                ),
                PsychologyTermAnswer("""pauzy""",
                    false
                ),
            ),
            questionNumber = 57,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "\"Haló efekt\" znamená",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """změnu posuzování osoby, když je na ni upoutána pozornost velkého množství lidí""",
                    false
                ),
                PsychologyTermAnswer(
                    """postupná změna hodnocení osoby při zjišťování nových informací o ní nebo v důsledku zapomínání určitých rysů""",
                    false
                ),
                PsychologyTermAnswer(
                    """posuzování jednotlivých rysů osoby podle celkového dojmu nebo určitých významných charakteristik""",
                    false
                ),
                PsychologyTermAnswer(
                    """vliv první informace, kterou o člověku získáme, na celkové posuzování osoby""",
                    false,
                    "efekt primárnosti"
                ),
            ),
            questionNumber = 58,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Tzv. pygmalionský efekt se nazývá také""",
            textAnswer = "Sebenaplňující se proroctví. Pygmalion efekt - pozitivní. Golem efekt - negativní.",
            answers = listOf(
                PsychologyTermAnswer("""selektivní slepota""",
                    false
                ),
                PsychologyTermAnswer("""sociální viktimizace""",
                    false
                ),
                PsychologyTermAnswer("""nenaplněné proroctví""",
                    false
                ),
                PsychologyTermAnswer("""sebesplňující proroctví""",
                    false
                ),
            ),
            questionNumber = 59,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Jednotlivci a různě velké skupinky lidí měly za úkol co největší silou tahat za lano." +
                " Zjistilo se, že čím větší je skupinka, tím menší je průměrná síla vyvinutá jedincem. Tento jev se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""distribuce odpovědnosti""",
                    false
                ),
                PsychologyTermAnswer("""limitace zdrojů""",
                    false
                ),
                PsychologyTermAnswer("""distribuce zdrojů""",
                    false
                ),
                PsychologyTermAnswer("""sociální zahálení""",
                    false,
                    "Social loafing"
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Základní atribuční chyba spočívá v""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """vytváření stereotypů podle omezených zkušeností""",
                    false
                ),
                PsychologyTermAnswer("""přeceňování situačních příčin chování""",
                    false
                ),
                PsychologyTermAnswer("""přeceňování dispozičních příčin chování""",
                    false
                ),
                PsychologyTermAnswer("""vnímání lidí podle stereotypů""",
                    false
                ),
            ),
            questionNumber = 61,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Která charakteristika nejlépe vystihuje pojem kauzální atribuce?""",
            textAnswer = "Kognitivní proces přisuzování jedné či více příčin vlastnímu chování a chování jiných lidí." +
                " Dělí se na vnější a vnitřní.",
            answers = listOf(
                PsychologyTermAnswer(
                    """přisuzování příčin různým jevům, obvykle lidskému chování""",
                    false
                ),
                PsychologyTermAnswer(
                    """sociálně motivační proces, který iniciuje chování""",
                    false,
                    "Motivace"
                ),
                PsychologyTermAnswer("""zákonitý sled atribučních procesů""",
                    false
                ),
                PsychologyTermAnswer(
                    """chybné odhadování kauzality v lidském chování""",
                    false
                ),
            ),
            questionNumber = 62,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Jaký je vztah mezi pravděpodobností osobního setkání a pravděpodobností vzniku přátelských vztahů?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""vztah neexistuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """s pravděpodobností setkání klesá pravděpodobnost vzniku přátelských vztahů""",
                    false
                ),
                PsychologyTermAnswer(
                    """s pravděpodobností setkání roste pravděpodobnost vzniku přátelských vztahů, ale pouze při celkově podprůměrné úrovni setkávání""",
                    false
                ),
                PsychologyTermAnswer(
                    """s pravděpodobností setkání roste pravděpodobnost vzniku přátelských vztahů""",
                    false,
                    "O průměru čím více času s někým trávíme, tím bližší jim jsme."
                ),
            ),
            questionNumber = 63,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Jak se projevuje fyzická atraktivita při skutečné volbě partnera?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""žádný vztah neexistuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """pouze muži se při výběru partnerky řídí fyzickou atraktivitou""",
                    false
                ),
                PsychologyTermAnswer(
                    """lidé mají tendenci volit partnery zhruba stejně přitažlivé, jako jsou sami""",
                    false,
                    "Výjimkou je online seznamování, kdy je většinou snaha najít co nejatraktivnější osobu."
                ),
                PsychologyTermAnswer(
                    """pouze ženy se při výběru partnerky řídí fyzickou atraktivitou""",
                    false
                ),
            ),
            questionNumber = 64,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Když je člověk společně s dalšími osobami vystaven persuazivní komunikaci, domnívá se o ostatních, že",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """je persuaze ovlivnila více než jeho samotného""",
                    false
                ),
                PsychologyTermAnswer("""persuaze na ně nemá vliv""",
                    false
                ),
                PsychologyTermAnswer("""nic z uvedených""",
                    false
                ),
                PsychologyTermAnswer(
                    """neodhalí persuazivní charakter komunikace""",
                    false
                ),
            ),
            questionNumber = 65,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Jaké je správné řazení proxemických zón (zevnitř ven)?""",
            textAnswer = "\t-Intimní zóna (do 60cm)" +
                "\n\t-Osobní zóna (60cm - 1.2m)" +
                "\n\t-Společenská zóna (1.2m - 3.6m)" +
                "\n\t-Veřejná-zóna (3.6m - 7.6m)",
            answers = listOf(
                PsychologyTermAnswer(
                    """intimní jádro, osobní, veřejná a sociální slupka""",
                    false
                ),
                PsychologyTermAnswer("""intimní, osobní, sociální, veřejná zóna""",
                    false
                ),
                PsychologyTermAnswer(
                    """osobní zóna, sociální zóna, anonymní zóna""",
                    false
                ),
                PsychologyTermAnswer("""intimní, osobní, veřejná, sociální zóna""",
                    false
                ),
            ),
            questionNumber = 66,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Tendence přizpůsobovat své chování a názory lidem v okolí se nazývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""akceptace""",
                    false
                ),
                PsychologyTermAnswer("""pasivní formace""",
                    false
                ),
                PsychologyTermAnswer(
                    """konformita""",
                    false,
                    "Změna chování kvůli soc. tlaku"
                ),
                PsychologyTermAnswer("""konfirmace""",
                    false
                ),
            ),
            questionNumber = 67,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Sociální desirabilita znamená""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální žádoucnost (např. chování)""",
                    false
                ),
                PsychologyTermAnswer("""dynamický proces v malé skupině""",
                    false
                ),
                PsychologyTermAnswer("""náchylnost skupiny k jednotnému chování""",
                    false
                ),
                PsychologyTermAnswer("""komplex postojů""",
                    false
                ),
            ),
            questionNumber = 68,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Generalizované očekávání, že události jsou nezávislé na chování jedince," +
                " vzniklé v důsledku vystavení jedince nekontrolovatelným událostem, se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""generalizovaná ztráta kontroly""",
                    false
                ),
                PsychologyTermAnswer("""naučená bezmocnost""",
                    false,
                    "Seligman"
                ),
                PsychologyTermAnswer("""ztráta sebekontroly""",
                    false
                ),
                PsychologyTermAnswer("""generalizovaná impotence""",
                    false
                ),
            ),
            questionNumber = 69,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Když spolu diskutuje skupina lidí o záležitosti, na kterou mají podobný názor," +
                " jak se pravděpodobně změní mínění jednotlivých účastníků diskuse po této diskusi?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""směr a míra změny budou spíše náhodné""",
                    false
                ),
                PsychologyTermAnswer("""bude méně vyhraněné""",
                    false
                ),
                PsychologyTermAnswer("""nezmění se""",
                    false
                ),
                PsychologyTermAnswer("""bude vyhraněnější""",
                    false
                ),
            ),
            questionNumber = 70,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Předsudek je zvláštní typ""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""postoje""",
                    false
                ),
                PsychologyTermAnswer("""zájmu""",
                    false
                ),
                PsychologyTermAnswer(
                    """incentivy""",
                    false,
                    "objekt nebo soubor podmínek navozující v organismu tendenci k okamžitému jednání," +
                        " které vede prostřednictvím dosažení cíle k uspokojení vzniklé potřeby."
                ),
                PsychologyTermAnswer("""motivačního stavu""",
                    false
                ),
            ),
            questionNumber = 71,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "V důsledku fenoménu rozptýlené zodpovědnosti dochází k tomu," +
                " že lidé poskytují pomoc s větší pravděpodobností,",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """když mají blízký vztah k člověku, který pomoc potřebuje""",
                    false
                ),
                PsychologyTermAnswer("""když je na místě větší množství lidí""",
                    false
                ),
                PsychologyTermAnswer(
                    """když jsou v dané situaci jediní, kdo může pomoc poskytnout""",
                    false
                ),
                PsychologyTermAnswer("""když vědí, co danou situaci způsobilo""",
                    false
                ),
            ),
            questionNumber = 72,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Dispoziční atribuce je""",
            textAnswer = """situační atribuce – můžou za to okolnosti\n
                dispoziční atribuce – je to věcí povahy""",
            answers = listOf(
                PsychologyTermAnswer(
                    """sebeochranný motivační proces, který osobu nutí srovnávat se s ostatními""",
                    false
                ),
                PsychologyTermAnswer(
                    """připisování příčin chování nějaké osoby jejím vlastnostem""",
                    false
                ),
                PsychologyTermAnswer(
                    """sebeochranný motivační proces, který osobě zabraňuje srovnávat se s ostatními""",
                    false
                ),
                PsychologyTermAnswer(
                    """připisování příčin chování nějaké osoby okolnostem, které na ni působí""",
                    false
                ),
            ),
            questionNumber = 73,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín sebe-ochranné atribuce označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """tendenci připisovat příčiny úspěchu vlastní osobě a příčiny neúspěchu situačním faktorům""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendenci připisovat příčiny úspěchu přizpůsobení vlastní osoby situačním faktorům""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendenci zbavovat se zodpovědnosti za jednání, které by mohlo vyústit v neúspěch (bez ohledu na skutečný výsledek)""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendenci nejednat v podmínkách, kde jedinec nemá dostatečnou kontrolu""",
                    false
                ),
            ),
            questionNumber = 74,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín observační učení označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""učení ve skupinové situaci""",
                    false
                ),
                PsychologyTermAnswer("""učení se školním dovednostem""",
                    false
                ),
                PsychologyTermAnswer("""učení pozorování kauzálních jevů""",
                    false
                ),
                PsychologyTermAnswer("""učení pozorováním jiné osoby""",
                    false
                ),
            ),
            questionNumber = 75,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Přeceňování míry, do jaké se myšlení ostatních lidí podobá našemu vlastnímu myšlení, se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""akomodace mysli (mind accomodation)""",
                    false,
                    "Vnitřní přizpůsobení situaci - vytvoření nového kognitivního modelu."
                ),
                PsychologyTermAnswer("""konsensuální omyl (consensual fallacy)""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""falešný konsensus (false consensus)""",
                    false
                ),
                PsychologyTermAnswer("""skupinové zkreslení (group bias)""",
                    false,
                    "existuje in-group bias - preferujeme naší skupinu nad ostatními - out-group"
                ),
            ),
            questionNumber = 76,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Komunikační situace, kdy jeden účastník sděluje druhému dva rozporné obsahy, např. slovy vyjadřuje chválu a mimikou hněv, se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dvojná vazba""",
                    false,
                    "(double bind)"
                ),
                PsychologyTermAnswer("""kontradiktorická komunikace""",
                    false
                ),
                PsychologyTermAnswer("""konfliktní komunikace""",
                    false
                ),
                PsychologyTermAnswer("""komunikační past""",
                    false
                ),
            ),
            questionNumber = 77,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Jako sociální zahálení se označuje jev, kdy""",
            textAnswer = "Social loafing",
            answers = listOf(
                PsychologyTermAnswer(
                    """skupina jedinců podává větší výkon, než by odpovídalo součtu výkonu jedinců pracujících v přítomnosti jiných lidí""",
                    false
                ),
                PsychologyTermAnswer(
                    """jedinec není ochoten poskytnout pomoc, jsouli přítomni další lidé""",
                    false
                ),
                PsychologyTermAnswer(
                    """skupina jedinců podává menší výkon, než by odpovídalo součtu výkonu jedinců pracujících samostatně""",
                    false
                ),
                PsychologyTermAnswer(
                    """jedinec není ochoten poskytnout pomoc, je-li v dané situaci sám""",
                    false
                ),
            ),
            questionNumber = 78,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín skupinová koheze označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """míru angažovanosti určitého jedince ve skupině""",
                    false
                ),
                PsychologyTermAnswer("""soudržnost skupiny""",
                    false
                ),
                PsychologyTermAnswer("""aktivitu skupiny""",
                    false
                ),
                PsychologyTermAnswer("""míru vzájemných interakcí ve skupině""",
                    false
                ),
            ),
            questionNumber = 79,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Který z uvedených výroků je nejtypičtější pro symbolický interakcionismus?",
            textAnswer = "G. H. Mead - Sociální psychologie (sociální behaviorismus), reprezentace společnoste v mysli jedince - zobecněný druhý (generalized other) - Interakce je zprostředkována interpretacemi a významy mezi jedinci., Symbolický Interakcionismus - interakce jedinců a jejich interpretace.",
            answers = listOf(
                PsychologyTermAnswer(
                    """Interakce je zprostředkována interpretacemi a významy.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Význam sociálního chování je jednoznačně určen záměrem jednajícího.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Sociální chování se ustavuje jako automatická odpověď na určité podněty.""",
                    false
                ),
                PsychologyTermAnswer(
                    """Interakce působí jako odměna v operantním podmiňování.""",
                    false
                ),
            ),
            questionNumber = 80,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín kompetice označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""spolupráci""",
                    false
                ),
                PsychologyTermAnswer("""projevy agrese""",
                    false
                ),
                PsychologyTermAnswer("""výměnu informací ve skupině""",
                    false
                ),
                PsychologyTermAnswer("""soupeření""",
                    false
                ),
            ),
            questionNumber = 81,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín konformita označuje""",
            textAnswer = "Změna chování kvůli soc. tlaku",
            answers = listOf(
                PsychologyTermAnswer("""uvědomování si příslušnosti ke skupině""",
                    false
                ),
                PsychologyTermAnswer("""miru soudržnosti skupiny""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendenci podřizovat se vlivu sociálního prostředí""",
                    false
                ),
                PsychologyTermAnswer("""tendenci útočit na skupinové hodnoty""",
                    false
                ),
            ),
            questionNumber = 82,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Jednání ve prospěch druhých osob, které není spojeno s bezprostřední odměnou, se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""altruismus""",
                    false
                ),
                PsychologyTermAnswer("""sociální kontrakt""",
                    false
                ),
                PsychologyTermAnswer("""prohumanismus""",
                    false
                ),
                PsychologyTermAnswer("""alimentární chování""",
                    false
                ),
            ),
            questionNumber = 83,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín reciproční altruismus označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""poskytování pomoci proti odměně""",
                    false
                ),
                PsychologyTermAnswer(
                    """paradoxni prosociální, vyvolané antisociálním podnětem""",
                    false
                ),
                PsychologyTermAnswer(
                    """poskytování pomoci jiným jedincům, při kterém se očekává pozdější odplata podobnou či jinou službou podobného významu""",
                    false
                ),
                PsychologyTermAnswer("""interaktivní povahu sociálního chování""",
                    false
                ),
            ),
            questionNumber = 84,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Obratnost v sociálním jednání a interpersonálních vztazích označujeme jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociabilní poměr""",
                    false
                ),
                PsychologyTermAnswer("""sociální apetenci""",
                    false
                ),
                PsychologyTermAnswer("""sociální vlohy""",
                    false
                ),
                PsychologyTermAnswer("""sociální kompetenci""",
                    false
                ),
            ),
            questionNumber = 85,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Jako kongruentní komunikaci bychom označili komunikaci""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""autentickou""",
                    false
                ),
                PsychologyTermAnswer("""syntakticky neúplnou""",
                    false
                ),
                PsychologyTermAnswer("""v bludném kruhu""",
                    false
                ),
                PsychologyTermAnswer("""nesoudržnou""",
                    false
                ),
            ),
            questionNumber = 86,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Skupina, jejíž normy na jedince působí, zpravidla kladně, se označuje jako jeho",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""cílový agregát""",
                    false,
                    "seskupení lidí, které nemá charakter sociální skupiny"
                ),
                PsychologyTermAnswer("""motivační centrum""",
                    false
                ),
                PsychologyTermAnswer("""referenční skupina""",
                    false,
                    "Skupina, jejíž normy na jedince působí, zpravidla kladně"
                ),
                PsychologyTermAnswer("""sekundární skupina""",
                    false
                ),
            ),
            questionNumber = 87,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Rozvrstvení společnosti podle určitých kritérií, např. majetku, statusu, cílů atd., se nazývá",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální grupování""",
                    false
                ),
                PsychologyTermAnswer("""sociální stratifikace""",
                    false
                ),
                PsychologyTermAnswer("""třídní boj""",
                    false
                ),
                PsychologyTermAnswer("""třídní kategorizace""",
                    false
                ),
            ),
            questionNumber = 88,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Centrální organizační rys je""",
            textAnswer = "Jak již slovo \"centrální\" napovídá, jedná se o základní rys, " +
                "který se nám o osobě udelá a následně nám i pomáhá v interpretaci ostatních rysů.",
            answers = listOf(
                PsychologyTermAnswer(
                    """rys, který má významný vliv na formování celkového dojmu o osobě a ovlivňuje interpretaci dalších rysů""",
                    false
                ),
                PsychologyTermAnswer(
                    """charakteristika, kterou se kterou se jedinec nejvíce identifikuje""",
                    false
                ),
                PsychologyTermAnswer(
                    """charakteristický vliv, kterým působí organizační struktura instituce na sociální komunikaci""",
                    false
                ),
                PsychologyTermAnswer("""rys, který strukturuje osobnost jedince""",
                    false
                ),
            ),
            questionNumber = 89,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Proces, kterým si lidé vytvářejí dojmy o charakteristikách a rysech a emocích jiných lidí a o pohnutkách jejich chování, se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociokognice""",
                    false
                ),
                PsychologyTermAnswer("""sociální (interpersonální) percepce""",
                    false
                ),
                PsychologyTermAnswer("""personální atribuce""",
                    false
                ),
                PsychologyTermAnswer("""sociální (sociokulturní) konstrukce""",
                    false,
                    "Všechny naše definice a významy jsou reflexe reality a vyvíjíme je kolektivně."
                ),
            ),
            questionNumber = 90,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín řeč těla nejlépe odpovídá termínu/termínům:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""mimika, gestika, haptika a kinezika""",
                    false,
                    "kinezika - nauka o pohybech člověka (sleduje pohyby lidí, kteří jsou v osobním vzájemném styku, jakožto specifické signály, tj. pohyby těla, hlavy a krku, způsobu chůze, motorickém neklidu)." +
                        "\n\n" +
                        "mimika - nauka o významu pohybů obličejových svalů" +
                        "\n" +
                        "\n" +
                        "haptika - nauka o dotycích v mezilidském styku"
                ),
                PsychologyTermAnswer("""znaková řeč""",
                    false
                ),
                PsychologyTermAnswer("""nonverbální komunikace""",
                    false
                ),
                PsychologyTermAnswer("""paraverbální komunikace""",
                    false
                ),
            ),
            questionNumber = 91,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který termín nepatří k ostatním""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""kinestetika""",
                    false,
                    "Pohybová terapie"
                ),
                PsychologyTermAnswer("""kinezika""",
                    false,
                    "\"kinemá\"=pohyb. Pohyby těla v sociální interakce - nonverbální komunikace."
                ),
                PsychologyTermAnswer("""mimika""",
                    false
                ),
                PsychologyTermAnswer("""posturologie""",
                    false,
                    "(posturika) postoj a uspořádání těla v prostoru - nonverbální komunikace. Např. naklonění hlavy, či směr nohou."
                ),
            ),
            questionNumber = 92,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Pro označení záměru se používá také slovo""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""potence""",
                    false
                ),
                PsychologyTermAnswer("""atence""",
                    false
                ),
                PsychologyTermAnswer("""zaměřenost""",
                    false
                ),
                PsychologyTermAnswer("""intence""",
                    false
                ),
            ),
            questionNumber = 93,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Disciplína, která se zabývá biologickými a evolučními základy lidského sociálního chování, se označuje jako:",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """sociální neuropsychologie""",
                    false,
                    """Věda zabývající se sledováním aktivity mozku a jeho částí spojené s chováním subjektu."""
                ),
                PsychologyTermAnswer(
                    """biosociologie""",
                    false,
                    """Fiktivní disciplína. Snaží se spojit sociální život člověka s biologickými procesy."""
                ),
                PsychologyTermAnswer(
                    """sociobiologie""",
                    false,
                    """Úzce spojeno s evoluční psychologií. Zkoumá sociální chování z biologického (hlavně evolučního) pohledu.
                         Strach má evoluční původ, společenská hiearchie také, apod.
                    """
                ),
                PsychologyTermAnswer("""sociálně-biologická psychologie""",
                    false
                ),
            ),
            questionNumber = 94,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín egocentrické zkreslení (egocentric bias) označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """tendenci vnímat dění v okolí jako zaměřené na naši osobu, i když ve skutečnosti na nás zaměřeno není""",
                    false
                ),
                PsychologyTermAnswer(
                    """zkreslující vnímání nonverbální komunikace způsobené fyzickým postavením pozorovatele""",
                    false
                ),
                PsychologyTermAnswer(
                    """sklon pamatovat si pouze pozitivní charakteristiky, které jsou nám okolím přisuzovány""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendenci vykládat si jednání vůči naší osobě jako pozitivně hodnotící""",
                    false
                ),
            ),
            questionNumber = 95,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Které z uvedených označení má nejblíže k terminu interakce?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""komunikace""",
                    false
                ),
                PsychologyTermAnswer("""symbolický kontakt""",
                    false
                ),
                PsychologyTermAnswer("""vzájemné působení""",
                    false
                ),
                PsychologyTermAnswer("""funkční sdělování""",
                    false
                ),
            ),
            questionNumber = 96,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Obsahy, které vnímáme či chápeme ve vztahu k sobě samým, si zapamatujeme snadněji než obsahy jiné. Hovoříme zde o",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""automemickém efektu""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer(
                    """doprovodném paměťovém zisku (secondary memory gain)""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""tzv. self-memory (sebepaměti)""",
                    false
                ),
                PsychologyTermAnswer("""sebereferenčním efektu""",
                    false
                ),
            ),
            questionNumber = 97,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Které z uvedených slov označuje takový přístup k lidem," +
                " který se vyznačuje manipulativností a považuje ostatní lidi především za prostředky k dosažení vlastních cílů?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""machiavellismus""",
                    false
                ),
                PsychologyTermAnswer("""sociální adaptacionismus""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""socialismus""",
                    false
                ),
                PsychologyTermAnswer("""politické zaměření""",
                    false
                ),
            ),
            questionNumber = 98,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín sebeprodukční (self-generation) efekt označuje fakt, že""",
            textAnswer = "Pamatujeme si lépe věci, které jsou námi vygenerované, než-li ty, které pasivně příjímáme",
            answers = listOf(
                PsychologyTermAnswer(
                    """jedincovo já se v sociálních situacích rozvíjí""",
                    false
                ),
                PsychologyTermAnswer(
                    """to, co aktivně vytváříme, si zapamatujeme snadněji než pasivně přijaté obsahy""",
                    false
                ),
                PsychologyTermAnswer(
                    """člověk má tendenci v sociální situaci prezentovat svoje já určitým způsobem a tato prezentace zpětně ovlivňuje vlastní já""",
                    false
                ),
                PsychologyTermAnswer(
                    """sklon promítat do hodnocení druhých vlastní sebehodnocení""",
                    false,
                    "projekce"
                ),
            ),
            questionNumber = 99,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených termínů má nejblíže k termínu observační učení?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""disonance""",
                    false
                ),
                PsychologyTermAnswer(
                    """učení vhledem""",
                    false,
                    "Gestalt Psychologie. Wertheimer, Kohler\n" +
                        "Spontánní pochopení problému v dané situaci - najednou má člověk nadhled."
                ),
                PsychologyTermAnswer(
                    """reaktance""",
                    false,
                    """Teorie popisuje motivační tendenci člověka reagovat na omezení své subjektivně pociťované svobody opačnou reakcí,
                        aniž by si toho byl dotyčný vědom."""
                ),
                PsychologyTermAnswer("""imitace""",
                    false,
                    "Bobo Doll, Bandura"
                ),
            ),
            questionNumber = 100,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Lékař vyšetřuje dítě a pak mu musí dát injekci. Jaký postup je nejvhodnější z hlediska omezení úzkosti dítěte?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """před píchnutím injekce lékař dítěti řekne, že to bude bolet""",
                    false
                ),
                PsychologyTermAnswer("""lékař se o injekci dítěti vůbec nezmíní""",
                    false
                ),
                PsychologyTermAnswer(
                    """před píchnutím injekce lékař dítěti řekne, že to nebude bolet""",
                    false
                ),
                PsychologyTermAnswer(
                    """lékař se zmíní o injekci na začátku vyšetření""",
                    false
                ),
            ),
            questionNumber = 101,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = "Pohled lidí na sebe samotné určovaný tím, co si podle nich o nich myslí ostatní, se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální odraz""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""autopercepce""",
                    false
                ),
                PsychologyTermAnswer("""zrcadlové já""",
                    false,
                    "(Looking glass self)" +
                        "\n\t-1. Představujeme si, jak se jevíme druhým" +
                        "\n\t-2. Představujeme si a reagujeme, jak nás vidí druzí" +
                        "\n\t-3. Vytváříme si naše Já skrze soudy druhých"
                ),
                PsychologyTermAnswer("""xenoreflexe""",
                    false,
                    "neexistuje"
                ),
            ),
            questionNumber = 102,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Obsah a struktura vědomého nahlížení na sebe sama se označuje pojmem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""autoidentifikace""",
                    false,
                    "schopnost přiřadit v rámci vědomí sebe sama"
                ),
                PsychologyTermAnswer("""sebemonitorování""",
                    false,
                    "Lidé mají sklon regulovat své chování podle své představy o tom, jaké chování je u nich očekáváno. Mluvíme o"
                ),
                PsychologyTermAnswer("""sebehodnocení""",
                    false
                ),
                PsychologyTermAnswer("""sebepojetí""",
                    false
                ),
            ),
            questionNumber = 103,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Která z uvedených charakteristik nejlépe vystihuje termín gender?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """role a očekávání, která společnost připisuje každému pohlaví""",
                    false
                ),
                PsychologyTermAnswer(
                    """koncepce, která existenci společenských rozdílů mezi pohlavími""",
                    false
                ),
                PsychologyTermAnswer(
                    """jazykově zachycené aspekty pohlavních rozdílů""",
                    false
                ),
                PsychologyTermAnswer("""fyzické aspekty pohlavních rozdílů""",
                    false
                ),
            ),
            questionNumber = 104,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených pojmů má nejblíže k pojmu předsudek?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální reprezentace""",
                    false
                ),
                PsychologyTermAnswer("""stereotyp""",
                    false
                ),
                PsychologyTermAnswer("""skupinová norma""",
                    false
                ),
                PsychologyTermAnswer("""pojem""",
                    false
                ),
            ),
            questionNumber = 105,
            correctAnswer = 1,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termínem posun k riziku (risky shift) se označovala""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""tendence skupin chovat se riskantně""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendence jedinců chovat se riskantně vůči skupinovým normám""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendence lidí činit riskantnější rozhodnutí ve skupinách spíše než individuálně""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendence lidí činit riskantnější rozhodnutí individuálně spíše než ve skupinách""",
                    false
                ),
            ),
            questionNumber = 106,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Který z uvedených termínů nepatří k ostatním?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sociální srovnávání""",
                    false
                ),
                PsychologyTermAnswer("""sociometrie""",
                    false,
                    "Sociometrie - Zkoumání skrze vzájemné výběry a odmítnutí členů malé skupiny."
                ),
                PsychologyTermAnswer("""vzájemné volby""",
                    false
                ),
                PsychologyTermAnswer("""sociogram""",
                    false,
                    "vzájemné preference členů skupiny v určité době, jak byly zachyceny sociometrickým testem"
                ),
            ),
            questionNumber = 107,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Termín etnocentrismus označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """teoretický přístup, podle kterého jsou rozdíly mezi etnickými skupinami základem vývoje""",
                    false
                ),
                PsychologyTermAnswer(
                    """teoretický model vzniku národnostní identity""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendenci chápat všechna etnika jako stejně hodnotná""",
                    false
                ),
                PsychologyTermAnswer(
                    """tendenci hodnotit všechny lidi podle norem a pravidel platných ve vlastní etnické skupině""",
                    false
                ),
            ),
            questionNumber = 108,
            correctAnswer = 3,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Ekmanův výzkum týkající se emočního výrazu obličeje zjistil, že:""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""základní druhy výrazu jsou vrozené""",
                    false
                ),
                PsychologyTermAnswer(
                    """některé druhy výrazu mají i dětí od narození slepé""",
                    false
                ),
                PsychologyTermAnswer(
                    """lidé i z velmi odlišných kultur čtou základní druhy výrazu obdobně""",
                    false
                ),
                PsychologyTermAnswer(
                    """horní polovina obličeje zpravidla slouží k rozlišování negativních emocí a spodní pro rozlišování pozitivních""",
                    false
                ),
            ),
            questionNumber = 109,
            correctAnswer = 2,
            categoryId = "2 Sociální psychologie"
        ),
        PsychologyTerm(
            prompt = """Mezi tři nejvýznamnější americké sociální psychology nejspíše patří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Zimbardo, Milgram, Asch""",
                    false
                ),
                PsychologyTermAnswer("""Zimbardo, Milgram, Ach""",
                    false
                ),
                PsychologyTermAnswer("""Zimbardo, Milgram, Adorno""",
                    false
                ),
                PsychologyTermAnswer("""Zimbardo, Milgram, Skinner""",
                    false
                ),
            ),
            questionNumber = 110,
            correctAnswer = 0,
            categoryId = "2 Sociální psychologie"
        ),
    )
}