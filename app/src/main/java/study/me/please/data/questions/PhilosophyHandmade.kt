package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

object PhilosophyHandmade {

    val philosophyPrompts = listOf(
        PsychologyTerm(
            prompt = "Co znamená slovo filosofie?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("milovat moudrost",
                    false,
                    ""
                ),
                PsychologyTermAnswer("milovat myšlení",
                    false,
                    ""
                ),
                PsychologyTermAnswer("lidská znalost",
                    false,
                    ""
                ),
                PsychologyTermAnswer("poznání člověka",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo poprvé použil slovo filosofie?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Pýthagorás (572 - 494 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie" +
                        "\nNáboženský spolek - ovlivněno Orfiky (orfeus=mýt. hrdina)" +
                        "\nApeiron (Anaximandros) není, jelikož ho nelze od sebe odlišit." +
                        "\nKaždé jsoucno tvarováno a má svou mez (peras) a je počítatelné" +
                        "\n\tZáklad je číslo" +
                        "\n\t\t-např. správná šíře strun=harmonie., i kosmos má svou harmonii." +
                        "\n\t\t-svět a jeho harmonii můžeme poznávat až když máme harmonii ve vlastní duši" +
                        "\n\t\t-zjistili, že strany čtverce mají iracionální číslo - tedy chaos, snažili se utajit."
                ),
                PsychologyTermAnswer("Sókratés (469 - 399 př.kr)",
                    false,
                    "Dal slovu význam" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                ),
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Thalés (625 - 525 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                        "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem slova anamnésis je",
            textAnswer = "Rozpomínání se (anamnésis) na svět idejí -Ménón",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Pýthagorás (572 - 494 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie" +
                        "\nNáboženský spolek - ovlivněno Orfiky (orfeus=mýt. hrdina)" +
                        "\nApeiron (Anaximandros) není, jelikož ho nelze od sebe odlišit." +
                        "\nKaždé jsoucno tvarováno a má svou mez (peras) a je počítatelné" +
                        "\n\tZáklad je číslo" +
                        "\n\t\t-např. správná šíře strun=harmonie., i kosmos má svou harmonii." +
                        "\n\t\t-svět a jeho harmonii můžeme poznávat až když máme harmonii ve vlastní duši" +
                        "\n\t\t-zjistili, že strany čtverce mají iracionální číslo - tedy chaos, snažili se utajit."
                ),
                PsychologyTermAnswer("Sókratés (469 - 399 př.kr)",
                    false,
                    "Dal slovu význam" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                ),
                PsychologyTermAnswer("Thalés (625 - 525 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                        "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Symposion\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Esej o lidském mozku\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Menón\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Faidros\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jean-Francois Lyotard",
                    false,
                    "(1924), formuloval postmodernismus" +
                        "\n\"Postmoderní situace\"" +
                        "\n\t-co je pro naší dobu charakteristické?" +
                        "\n\t-meta-příběhy ztratily přesvědčivost" +
                        "\n\t-PLURALITA" +
                        "\n-ztráta veškeré jistoty - \"Všechno je možné\""
                ),
                PsychologyTermAnswer("Jacques Derrida",
                    false,
                    "(1930), postmodernismus, přehodnotil strukturalismus" +
                        "\n-znaky získávají význam díky vzájemnému odlišení - DIFERENCI" +
                        "\n-struktura je otevřená" +
                        "\ndiffere - 1. odkládání 2. rozmisťování" +
                        "\nSTOPA" +
                        "\n\t-zmizení transcendentálnosti, předcházení" +
                        "\n\t-filosofie není konstrukcí - je dekonstrukcí proměnlivých významů"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Ústava\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jean-Francois Lyotard",
                    false,
                    "(1924), formuloval postmodernismus" +
                        "\n\"Postmoderní situace\"" +
                        "\n\t-co je pro naší dobu charakteristické?" +
                        "\n\t-meta-příběhy ztratily přesvědčivost" +
                        "\n\t-PLURALITA" +
                        "\n-ztráta veškeré jistoty - \"Všechno je možné\""
                ),
                PsychologyTermAnswer("Jacques Derrida",
                    false,
                    "(1930), postmodernismus, přehodnotil strukturalismus" +
                        "\n-znaky získávají význam díky vzájemnému odlišení - DIFERENCI" +
                        "\n-struktura je otevřená" +
                        "\ndiffere - 1. odkládání 2. rozmisťování" +
                        "\nSTOPA" +
                        "\n\t-zmizení transcendentálnosti, předcházení" +
                        "\n\t-filosofie není konstrukcí - je dekonstrukcí proměnlivých významů"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem popisu mýtů \"Ví ke komu mluvit a ke komu mlčet\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Pýthagoras (572 - 494 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie" +
                        "\nNáboženský spolek - ovlivněno Orfiky (orfeus=mýt. hrdina)" +
                        "\nApeiron (Anaximandros) není, jelikož ho nelze od sebe odlišit." +
                        "\nKaždé jsoucno tvarováno a má svou mez (peras) a je počítatelné" +
                        "\n\tZáklad je číslo" +
                        "\n\t\t-např. správná šíře strun=harmonie., i kosmos má svou harmonii." +
                        "\n\t\t-svět a jeho harmonii můžeme poznávat až když máme harmonii ve vlastní duši" +
                        "\n\t\t-zjistili, že strany čtverce mají iracionální číslo - tedy chaos, snažili se utajit."
                ),
                PsychologyTermAnswer("Sókrates (469 - 399 př.kr)",
                    false,
                        "Antická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                ),
                PsychologyTermAnswer("Thalés (625 - 525 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                        "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo první přišel s přírodním vysvětlením zemětřesení?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Thalés (625 - 525 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                        "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)"
                ),
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Pýthagoras (572 - 494 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie" +
                        "\nNáboženský spolek - ovlivněno Orfiky (orfeus=mýt. hrdina)" +
                        "\nApeiron (Anaximandros) není, jelikož ho nelze od sebe odlišit." +
                        "\nKaždé jsoucno tvarováno a má svou mez (peras) a je počítatelné" +
                        "\n\tZáklad je číslo" +
                        "\n\t\t-např. správná šíře strun=harmonie., i kosmos má svou harmonii." +
                        "\n\t\t-svět a jeho harmonii můžeme poznávat až když máme harmonii ve vlastní duši" +
                        "\n\t\t-zjistili, že strany čtverce mají iracionální číslo - tedy chaos, snažili se utajit."
                ),
                PsychologyTermAnswer("Sókrates (469 - 399 př.kr)",
                    false,
                    "Antická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Alétheia znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("pravda",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vědomí",
                    false,
                    ""
                ),
                PsychologyTermAnswer("poznání",
                    false,
                    ""
                ),
                PsychologyTermAnswer("fyzikální poznání",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Schólé je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vzniklý volný čas v důsledku civilizací",
                    false,
                    "Bez životních starostí"
                ),
                PsychologyTermAnswer("pravda",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zákon a důvod, pravdivá/rozumná čet, myšlenka, pojem",
                    false,
                    "Logos"
                ),
                PsychologyTermAnswer("nauka o bytí",
                    false,
                    "Ontologie (ontos=jsoucí, co jest)" +
                        "\nZaměnitelné za Metafyziku (meta ta fysika=za fyzikou, Aristotelovy spisy v knihovně)" +
                        "\nCo umožňuje fyziku - co je za tím" +
                        "\n\"První filosofie\"-Aristotel" +
                        "\nSpekulace" +
                        "\n\tVyváření myšlenkových konstrukcí mimo zkušenost" +
                        "\nDialektika" +
                        "\n\tVidění světa v souvislostech, celku, ve vývoji" +
                        "\nPlatón, Aristotel, T. Akvinský, René Descartes (zakladatel novověké ontologie), B. Spinoza, G.W. Leibniz, Immanuel Kant, M. Heidegger"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ontologie znamená",
            textAnswer = "Ontologie (ontos=jsoucí, co, co jest)" +
                "\nZaměnitelné za Metafyziku (meta ta fysika=za fyzikou, Aristotelovy spisy v knihovně)" +
                "\nCo umožňuje fyziku - co je za tím" +
                "\n\"První filosofie\"-Aristotel" +
                "\nSpekulace" +
                "\n\tVyváření myšlenkových konstrukcí mimo zkušenost" +
                "\nDialektika" +
                "\n\tVidění světa v souvislostech, celku, ve vývoji" +
                "\nPlatón, Aristotel, T. Akvinský, René Descartes (zakladatel novověké ontologie), B. Spinoza, G.W. Leibniz, Immanuel Kant, M. Heidegger",
            answers =
            listOf(
                PsychologyTermAnswer("nauka o bytí",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svět je z jedné látky",
                    false,
                    "Monismus" +
                        "\n\t1. Materialismus" +
                        "\n\t\t-hmota tvoří realitu, vč duchovní" +
                        "\n\t2. Idealisté" +
                        "\n\t\t-idea/myšlenka, božský duch, princip" +
                        "\n\t\ta) Objektivní" +
                        "\n\t\t\t-existuje nezávisle na nás, Platón, W.F. Hegel" +
                        "\n\t\tb) Subjektivní" +
                        "\n\t\t\t-existence odvozena od nás (lidského vědomí), G. Berkeley"
                ),
                PsychologyTermAnswer("vzniklý volný čas v důsledku civilizací",
                    false,
                    "Schólé"
                ),
                PsychologyTermAnswer("základem světa jsou 2 neslučitelné principy",
                    false,
                    "Dualismus" +
                        "\n\t-základem světa jsou 2 neslučitelné principy" +
                        "\n\t-např. tělo a duše, René Descartes"
                ),
                PsychologyTermAnswer("základem světa jsou 2 a více neslučitelné principy",
                    false,
                    "Pluralismus" +
                        "\n\t-Leibniz"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Teleologie znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("svět má předurčenou budoucnost, daný cíl",
                    false,
                    ""
                ),
                PsychologyTermAnswer("svět je z jedné látky",
                    false,
                    "Monismus" +
                        "\n\t1. Materialismus" +
                        "\n\t\t-hmota tvoří realitu, vč duchovní" +
                        "\n\t2. Idealisté" +
                        "\n\t\t-idea/myšlenka, božský duch, princip" +
                        "\n\t\ta) Objektivní" +
                        "\n\t\t\t-existuje nezávisle na nás, Platón, W.F. Hegel" +
                        "\n\t\tb) Subjektivní" +
                        "\n\t\t\t-existence odvozena od nás (lidského vědomí), G. Berkeley"
                ),
                PsychologyTermAnswer("nauka o bytí",
                    false,
                    "Ontologie (ontos=jsoucí, co, co jest), nauka o bytí" +
                        "\nZaměnitelné za Metafyziku (meta ta fysika=za fyzikou, Aristotelovy spisy v knihovně)" +
                        "\nCo umožňuje fyziku - co je za tím" +
                        "\n\"První filosofie\"-Aristotel" +
                        "\nSpekulace" +
                        "\n\tVyváření myšlenkových konstrukcí mimo zkušenost" +
                        "\nDialektika" +
                        "\n\tVidění světa v souvislostech, celku, ve vývoji" +
                        "\nPlatón, Aristotel, T. Akvinský, René Descartes (zakladatel novověké ontologie), B. Spinoza, G.W. Leibniz, Immanuel Kant, M. Heidegger"
                ),
                PsychologyTermAnswer("pravda",
                    false,
                    "Alétheia"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Monismus znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("svět má předurčenou budoucnost, daný cíl",
                    false,
                    "Teleologie"
                ),
                PsychologyTermAnswer("svět je z jedné látky",
                    false,
                    "Monismus" +
                        "\n\t1. Materialismus" +
                        "\n\t\t-hmota tvoří realitu, vč duchovní" +
                        "\n\t2. Idealisté" +
                        "\n\t\t-idea/myšlenka, božský duch, princip" +
                        "\n\t\ta) Objektivní" +
                        "\n\t\t\t-existuje nezávisle na nás, Platón, W.F. Hegel" +
                        "\n\t\tb) Subjektivní" +
                        "\n\t\t\t-existence odvozena od nás (lidského vědomí), G. Berkeley"
                ),
                PsychologyTermAnswer("nauka o bytí",
                    false,
                    "Ontologie (ontos=jsoucí, co, co jest)" +
                        "\nZaměnitelné za Metafyziku (meta ta fysika=za fyzikou, Aristotelovy spisy v knihovně)" +
                        "\nCo umožňuje fyziku - co je za tím" +
                        "\n\"První filosofie\"-Aristotel" +
                        "\nSpekulace" +
                        "\n\tVyváření myšlenkových konstrukcí mimo zkušenost" +
                        "\nDialektika" +
                        "\n\tVidění světa v souvislostech, celku, ve vývoji" +
                        "\nPlatón, Aristotel, T. Akvinský, René Descartes (zakladatel novověké ontologie), B. Spinoza, G.W. Leibniz, Immanuel Kant, M. Heidegger"
                ),
                PsychologyTermAnswer("pravda",
                    false,
                    "Alétheia"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Determinismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("svět má předurčenou budoucnost, daný cíl",
                    false,
                    "Teleologie"
                ),
                PsychologyTermAnswer("svět je z jedné látky",
                    false,
                    "Monismus" +
                        "\n\t1. Materialismus" +
                        "\n\t\t-hmota tvoří realitu, vč duchovní" +
                        "\n\t2. Idealisté" +
                        "\n\t\t-idea/myšlenka, božský duch, princip" +
                        "\n\t\ta) Objektivní" +
                        "\n\t\t\t-existuje nezávisle na nás, Platón, W.F. Hegel" +
                        "\n\t\tb) Subjektivní" +
                        "\n\t\t\t-existence odvozena od nás (lidského vědomí), G. Berkeley"
                ),
                PsychologyTermAnswer("nauka o bytí",
                    false,
                    "Ontologie (ontos=jsoucí, co, co jest)" +
                        "\nZaměnitelné za Metafyziku (meta ta fysika=za fyzikou, Aristotelovy spisy v knihovně)" +
                        "\nCo umožňuje fyziku - co je za tím" +
                        "\n\"První filosofie\"-Aristotel" +
                        "\nSpekulace" +
                        "\n\tVyváření myšlenkových konstrukcí mimo zkušenost" +
                        "\nDialektika" +
                        "\n\tVidění světa v souvislostech, celku, ve vývoji" +
                        "\nPlatón, Aristotel, T. Akvinský, René Descartes (zakladatel novověké ontologie), B. Spinoza, G.W. Leibniz, Immanuel Kant, M. Heidegger"
                ),
                PsychologyTermAnswer("vidění světa v souvislostech",
                    false,
                    "Dialektika"
                ),
                PsychologyTermAnswer("příčina má jednoznačený následek",
                    false,
                    ""
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 4
        ),
        PsychologyTerm(
            prompt = "Na co se dělí jsouctví",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("imanentní a transcendentní",
                    false,
                    "imanentní - přímo obsaženo" +
                        "\ntranscendentní - přesahující"
                ),
                PsychologyTermAnswer("materialistické a idealistické",
                    false,
                    "Monismus" +
                        "\n\t1. Materialismus" +
                        "\n\t\t-hmota tvoří realitu, vč duchovní" +
                        "\n\t2. Idealisté" +
                        "\n\t\t-idea/myšlenka, božský duch, princip" +
                        "\n\t\ta) Objektivní" +
                        "\n\t\t\t-existuje nezávisle na nás, Platón, W.F. Hegel" +
                        "\n\t\tb) Subjektivní" +
                        "\n\t\t\t-existence odvozena od nás (lidského vědomí), G. Berkeley"
                ),
                PsychologyTermAnswer("empirické a racionalistické",
                    false,
                    "Způsoby poznání (gnoseologie)" +
                        "\n\t1. Empirismus" +
                        "\n\t\t-zkušenost základem, J. Locke" +
                        "\n\t2. Racionalismus" +
                        "\n\t\t-principy a zásady rozumu jsou vrozené, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jaké máme způsoby poznání?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("imanentní a transcendentní",
                    false,
                    "imanentní - přímo obsaženo" +
                        "\ntranscendentní - přesahující"
                ),
                PsychologyTermAnswer("materialistické a idealistické",
                    false,
                    "Monismus" +
                        "\n\t1. Materialismus" +
                        "\n\t\t-hmota tvoří realitu, vč duchovní" +
                        "\n\t2. Idealisté" +
                        "\n\t\t-idea/myšlenka, božský duch, princip" +
                        "\n\t\ta) Objektivní" +
                        "\n\t\t\t-existuje nezávisle na nás, Platón, W.F. Hegel" +
                        "\n\t\tb) Subjektivní" +
                        "\n\t\t\t-existence odvozena od nás (lidského vědomí), G. Berkeley"
                ),
                PsychologyTermAnswer("empirické a racionalistické",
                    false,
                    "Způsoby poznání (gnoseologie)" +
                        "\n\t1. Empirismus" +
                        "\n\t\t-zkušenost základem, J. Locke" +
                        "\n\t2. Racionalismus" +
                        "\n\t\t-principy a zásady rozumu jsou vrozené, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Gnoseologie je",
            textAnswer = "Způsoby poznání (gnoseologie)" +
                "\n\t1. Empirismus" +
                "\n\t\t-zkušenost základem, J. Locke" +
                "\n\t2. Racionalismus" +
                "\n\t\t-principy a zásady rozumu jsou vrozené, R. Descartes",
            answers =
            listOf(
                PsychologyTermAnswer("zákonitosti lidského poznání",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vědecké poznání",
                    false,
                    "Epistemologie"
                ),
                PsychologyTermAnswer("nauka o správném uvažování",
                    false,
                    "Logika"
                ),
                PsychologyTermAnswer("příčina má jednoznačený následek",
                    false,
                    "Determinismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Logika je součástí",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Ontologie",
                    false,
                    "Ontologie (ontos=jsoucí, co, co jest), nauka o bytí" +
                        "\nZaměnitelné za Metafyziku (meta ta fysika=za fyzikou, Aristotelovy spisy v knihovně)" +
                        "\nCo umožňuje fyziku - co je za tím" +
                        "\n\"První filosofie\"-Aristotel" +
                        "\nSpekulace" +
                        "\n\tVyváření myšlenkových konstrukcí mimo zkušenost" +
                        "\nDialektika" +
                        "\n\tVidění světa v souvislostech, celku, ve vývoji" +
                        "\nPlatón, Aristotel, T. Akvinský, René Descartes (zakladatel novověké ontologie), B. Spinoza, G.W. Leibniz, Immanuel Kant, M. Heidegger"
                ),
                PsychologyTermAnswer("Gnoseologie",
                    false,
                    "Způsoby poznání (gnoseologie)" +
                        "\n\t1. Empirismus" +
                        "\n\t\t-zkušenost základem, J. Locke" +
                        "\n\t2. Racionalismus" +
                        "\n\t\t-principy a zásady rozumu jsou vrozené, R. Descartes"
                ),
                PsychologyTermAnswer("Epistomologie",
                    false,
                    "vědecké poznání, také součástí Gnoseologie"
                ),
                PsychologyTermAnswer("Teleologie",
                    false,
                    "svět má předurčenou budoucnost, daný cíl"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Filosofie jazyka je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("sdělení skrze jazyk",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zákonitosti lidského poznání",
                    false,
                    "Gnoseologie (Gnósis=poznání)"
                ),
                PsychologyTermAnswer("vědecké poznání",
                    false,
                    "Epistemologie"
                ),
                PsychologyTermAnswer("nauka o správném uvažování",
                    false,
                    "Logika"
                ),
                PsychologyTermAnswer("svět má předurčenou budoucnost, daný cíl",
                    false,
                    "Teleologie"
                ),
                PsychologyTermAnswer("příčina má jednoznačený následek",
                    false,
                    "Determinismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Co je v rámci Gnoseologie subjekt",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("kdo poznává, je aktivní",
                    false,
                    ""
                ),
                PsychologyTermAnswer("co je poznáváno, je pasivní",
                    false,
                    ""
                ),
                PsychologyTermAnswer("střed dění",
                    false,
                    ""
                ),
                PsychologyTermAnswer("základ světa a principu",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Co je v rámci Gnoseologie objekt",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("kdo poznává, je aktivní",
                    false,
                    ""
                ),
                PsychologyTermAnswer("co je poznáváno, je pasivní",
                    false,
                    ""
                ),
                PsychologyTermAnswer("střed dění",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zákonitost lidského chování",
                    false,
                    "definice Gnoseologie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Naivní realismus znamená:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    ""
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("objektivní poznání není možné",
                    false,
                    "Agnosticismus"
                ),
                PsychologyTermAnswer("zkušenost je základem všeho",
                    false,
                    "Empirismus, Gnoseologie, J. Locke"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Skeptisismus znamená:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("objektivní poznání není možné",
                    false,
                    "Agnosticismus"
                ),
                PsychologyTermAnswer("zkušenost je základem všeho",
                    false,
                    "Empirismus, Gnoseologie, J. Locke"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Agnosticismus znamená:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("objektivní poznání není možné",
                    false,
                    "Agnosticismus"
                ),
                PsychologyTermAnswer("zkušenost je základem všeho",
                    false,
                    "Empirismus, Gnoseologie, J. Locke"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Senzualismus znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vše se dá redukovat na smysly",
                    false,
                    "i duševní schopnost"
                ),
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("objektivní poznání není možné",
                    false,
                    "Agnosticismus"
                ),
                PsychologyTermAnswer("zkušenost je základem všeho",
                    false,
                    "Empirismus, Gnoseologie, J. Locke"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mystika znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vše se dá redukovat na smysly",
                    false,
                    "i duševní schopnost"
                ),
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("vniterné prožití absolutna či Boha",
                    false,
                    "Případné ztotožnění se s ním"
                ),
                PsychologyTermAnswer("zkušenost je základem všeho",
                    false,
                    "Empirismus, Gnoseologie, J. Locke"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Kdo definoval pravdu jako \"Shodu rozumu a věci\"?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Atistotelés",
                    false,
                    "Žák Platóna, avšak ho později kritizoval, učitel Alexandra Velikého." +
                        "\nPeripatetická škola (peripatos=sloupořadí)" +
                        "\n\t-procházky s jeho žáky" +
                        "\nDíla: Metafyzika, Etika Nikomachova, Politika, Poetika, Organon" +
                        "\n>Látka (eidos) a forma (morfé)<" +
                        "\n\tDuše je forma a tělo je jen látka" +
                        "\n\tLátka je pouze potenčnost, až teprve forma vytváří věci skutečné z látky." +
                        "\nPohyb" +
                        "\n\t-proces, při čemž látka nabývá formy" +
                        "\n\t-\"Je třeba se zastavit\" - první hybatel - Bůh" +
                        "\nÚčel (telos)" +
                        "\n\t-vnitřní příčina věcí, vše má účel" +
                        "\n\t->Entelechie< - naplnění účelu" +
                        "\n\t-Teleologie - účel předchází uskutečnění" +
                        "\n>Logika<" +
                        "\n\t-nauka o pravidlech, formě usuzování" +
                        "\n\t-klasifikace úsudků, nadřazenost a podřazenost zákl. pojmů" +
                        "\n\t-zákon totožnosti, sporu a vyloučeního třetího" +
                        "\nForma společnosti" +
                        "\n\t-nadčasový výzkum 158 řeckých ústav" +
                        "\n\t-bytosti společenské (zóon polítikon)" +
                        "\n\t-střední míra - sřední třída ideál, vše tak nějak do míry"
                ),
                PsychologyTermAnswer("Pýthagoras (572 - 494 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie" +
                        "\nNáboženský spolek - ovlivněno Orfiky (orfeus=mýt. hrdina)" +
                        "\nApeiron (Anaximandros) není, jelikož ho nelze od sebe odlišit." +
                        "\nKaždé jsoucno tvarováno a má svou mez (peras) a je počítatelné" +
                        "\n\tZáklad je číslo" +
                        "\n\t\t-např. správná šíře strun=harmonie., i kosmos má svou harmonii." +
                        "\n\t\t-svět a jeho harmonii můžeme poznávat až když máme harmonii ve vlastní duši" +
                        "\n\t\t-zjistili, že strany čtverce mají iracionální číslo - tedy chaos, snažili se utajit."
                ),
                PsychologyTermAnswer("Sókrates (469 - 399 př.kr)",
                    false,
                    "Antická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                ),
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Thalés (625 - 525 př.kr.)",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                        "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "O čem pojednává Mahábháratam a Rámájana?",
            textAnswer = "Indická filosofie" +
                "\nPo příchodu Arjů (2000-1500 př.kr.)" +
                "\nAutoritativní texty: Védy, Bráhmany, Upanišady" +
                "\nTolerance, a správný způsob žití je více než pojmová filosofie (západ, antika)",
            answers =
            listOf(
                PsychologyTermAnswer("souboji dobra a zla",
                    false,
                    "souboji dobra a zla, vítězství dobra a řádu" +
                        "\nPurány - mladší texty jako komentáře na Mahábháratam a Rámájana"
                ),
                PsychologyTermAnswer("o brahmě v člověku",
                    false,
                    "Atman - Brahma v člověku, nesmrtelné já, cílem splynout s Brahma (Mokšá)"
                ),
                PsychologyTermAnswer("mravní řád obsahující vše, co existuje",
                    false,
                    "Dharma"
                ),
                PsychologyTermAnswer("že naše činy nejsou zapomenuty",
                    false,
                    "Karman" +
                        "\n\t-převtělení do doby, kdy člověk dosáhne dostatečnou míru dobrých činů" +
                        "\n\t-Mokšá - vtělení Atman do Brahma" +
                        "\n\t-cesta k Mokšá je obecně nazýváno Jóga"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jak se nazývá řád, který obsahuje vše co existuje a funguje jako mravní řád po člověka?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Dharma",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Karman",
                    false,
                    "Karman" +
                        "\n\t-převtělení do doby, kdy člověk dosáhne dostatečnou míru dobrých činů" +
                        "\n\t-Mokšá - vtělení Atman do Brahma" +
                        "\n\t-cesta k Mokšá je obecně nazýváno Jóga"
                ),
                PsychologyTermAnswer("Mahábháratam a Rámájana",
                    false,
                    "souboji dobra a zla, vítězství dobra a řádu" +
                        "\nPurány - mladší texty jako komentáře na Mahábháratam a Rámájana"
                ),
                PsychologyTermAnswer("Atman",
                    false,
                    "Atman - Brahma v člověku, nesmrtelné já, cílem splynout s Brahma (Mokšá)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jak dělíme indické materialistické školy?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Lókajata a Sánkhja",
                    false,
                    "Lókajata - země, voda, oheň vzduch" +
                        "\nSánkhja - neteistická škola (bez boha)"
                ),
                PsychologyTermAnswer("Atman a Karman",
                    false,
                    "Karman" +
                        "\n\t-převtělení do doby, kdy člověk dosáhne dostatečnou míru dobrých činů" +
                        "\n\t-Mokšá - vtělení Atman do Brahma" +
                        "\n\t-cesta k Mokšá je obecně nazýváno Jóga" +
                        "Atman - Brahma v člověku, nesmrtelné já, cílem splynout s Brahma (Mokšá)"
                ),
                PsychologyTermAnswer("Védanta a Dharma",
                    false,
                    "Védanta (konec véd) - teistická škola, upanišad" +
                        "\nDharma - mravní řád obsahující vše, co existuje, mravní řád pro lidi"
                ),
                PsychologyTermAnswer("Advaita-Védanta",
                    false,
                    "Škola, Advajta (nedvojnost) - pouze Brahma, která >dělá iluzi světa (Mája)<" +
                        "\n\tŠankara (788-820)" +
                        "\n\t\t-překonání nevědomosti (avidjka)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Šankara byl součástí školy",
            textAnswer = "-překonání nevědomosti (avidjka)",
            answers =
            listOf(
                PsychologyTermAnswer("Advaita-Védanta",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Osobního božství",
                    false,
                    "Osobní božství" +
                        "\n\t-nekonečně milující ty, duch Bhakti (oddanost, láska)" +
                        "\n\tRámánudža (1059-1137)" +
                        "\n\tČaitanja Maháprabhu (1485-1533)" +
                        "\n\t\t-Krišna uctívání skrze Bhakti"
                ),
                PsychologyTermAnswer("Buddhistické filosofie",
                    false,
                    "princ Siddharta Gótama/Buddha (osvícený) (564-480 př.kr.)" +
                        "\nDharma (jeho učení)" +
                        "\n\t3 sbírky písem - košů (Triptaka)" +
                        "\n\t4 pravdy:" +
                        "\n\t\t1. Vše v životě je strast" +
                        "\n\t\t2. Příčina strasti je touha, žízeň po životě" +
                        "\n\t\t3. Zbavení se žízně -> zbavení se strasti" +
                        "\n\t\t4. Cesta ke zbavení se žízně je osmidílná stezka" +
                        "\n\t\t\t-závěr - pravé soustředění (meditace)" +
                        "\n\t\t\t-Nirvána (Nibbána - vyvanutí jáství)" +
                        "\n\t\t\t-Samsára - ukončení koloběhu převtělování" +
                        "\nučení o ne-já" +
                        "\nExistence boha, vznik světa, existence duše - bezvýznamné pro cestu" +
                        "\n\nNavazující školy:" +
                        "\n\tThéraváda, Hínájna (malý vůz)" +
                        "\n\t\t-učení starších, není bůh ani věčná hmota" +
                        "\n\tMahájána (velký vůz)" +
                        "\n\t\t-Buddha je božský" +
                        "\n\t\t-Bódhisattové - naschvál nedocílí Nirvány, aby ji pomohli docílit ostatním" +
                        "\n\tTantrajána, Lamaismus (6st. po kristu)" +
                        "\n\t\t-Tibetská Mahájána" +
                        "\n\t\tTantry - tajné nauky s duchovní energií"
                ),
                PsychologyTermAnswer("Džínismu",
                    false,
                    "Džínismus (džaina=vítěz nad koloběhem životů)" +
                        "\n\tPrinc Vardhamáma - Mahávíra" +
                        "\n\tZásadní a tvrdé - půsty, umrtvování, meditace" +
                        "\nDělení na:" +
                        "\n\tDigambary (odění vzduchem=nazí) - přísnější" +
                        "\n\tŠvétambary (bílé odění) - umířněnější" +
                        "\nDžíva=duše" +
                        "\tAdžíva=skutečnost"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ti, co naschvál nedocílí Nirvány, aby ji pomohli docílit ostatním se nazývají",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Bódhisattové",
                    false,
                    "Buddhistická filosofie, Mahájána (velký vůz)"
                ),
                PsychologyTermAnswer("Digambary",
                    false,
                    "Džínismus, (odění vzduchem=nazí)"
                ),
                PsychologyTermAnswer("Théravádi",
                    false,
                    "princ Siddharta Gótama/Buddha (osvícený) (564-480 př.kr.)" +
                        "\nDharma (jeho učení)" +
                        "\n\t3 sbírky písem - košů (Triptaka)" +
                        "\n\t4 pravdy:" +
                        "\n\t\t1. Vše v životě je strast" +
                        "\n\t\t2. Příčina strasti je touha, žízeň po životě" +
                        "\n\t\t3. Zbavení se žízně -> zbavení se strasti" +
                        "\n\t\t4. Cesta ke zbavení se žízně je osmidílná stezka" +
                        "\n\t\t\t-závěr - pravé soustředění (meditace)" +
                        "\n\t\t\t-Nirvána (Nibbána - vyvanutí jáství)" +
                        "\n\t\t\t-Samsára - ukončení koloběhu převtělování" +
                        "\nučení o ne-já" +
                        "\nExistence boha, vznik světa, existence duše - bezvýznamné pro cestu" +
                        "\n\nNavazující školy:" +
                        "\n\tThéraváda, Hínájna (malý vůz)" +
                        "\n\t\t-učení starších, není bůh ani věčná hmota" +
                        "\n\tMahájána (velký vůz)" +
                        "\n\t\t-Buddha je božský" +
                        "\n\t\t-Bódhisattové - naschvál nedocílí Nirvány, aby ji pomohli docílit ostatním" +
                        "\n\tTantrajána, Lamaismus (6st. po kristu)" +
                        "\n\t\t-Tibetská Mahájána" +
                        "\n\t\tTantry - tajné nauky s duchovní energií"
                ),
                PsychologyTermAnswer("Švétambary",
                    false,
                    "Džínismus (džaina=vítěz nad koloběhem životů)" +
                        "\n\tPrinc Vardhamáma - Mahávíra" +
                        "\n\tZásadní a tvrdé - půsty, umrtvování, meditace" +
                        "\nDělení na:" +
                        "\n\tDigambary (odění vzduchem=nazí) - přísnější" +
                        "\n\tŠvétambary (bílé odění) - umířněnější" +
                        "\nDžíva=duše" +
                        "\tAdžíva=skutečnost"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jak se v Džínismu říká duše?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("džíva",
                    false,
                    ""
                ),
                PsychologyTermAnswer("adžíva",
                    false,
                    "skutečnost"
                ),
                PsychologyTermAnswer("tantra",
                    false,
                    "tajné nauky s duchovní energií" +
                        "\nBudhismus > Tantrajána, Lamaismus (6st. po kristu)"
                ),
                PsychologyTermAnswer("samsára",
                    false,
                    "ukončení koloběhu převtělování, buddhismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jaká filozofie zakládá na tzv. \"4 pravdách\"?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("buddhismus",
                    false,
                    "princ Siddharta Gótama/Buddha (osvícený) (564-480 př.kr.)" +
                        "\nDharma (jeho učení)" +
                        "\n\t3 sbírky písem - košů (Triptaka)" +
                        "\n\t4 pravdy:" +
                        "\n\t\t1. Vše v životě je strast" +
                        "\n\t\t2. Příčina strasti je touha, žízeň po životě" +
                        "\n\t\t3. Zbavení se žízně -> zbavení se strasti" +
                        "\n\t\t4. Cesta ke zbavení se žízně je osmidílná stezka" +
                        "\n\t\t\t-závěr - pravé soustředění (meditace)" +
                        "\n\t\t\t-Nirvána (Nibbána - vyvanutí jáství)" +
                        "\n\t\t\t-Samsára - ukončení koloběhu převtělování" +
                        "\nučení o ne-já" +
                        "\nExistence boha, vznik světa, existence duše - bezvýznamné pro cestu" +
                        "\n\nNavazující školy:" +
                        "\n\tThéraváda, Hínájna (malý vůz)" +
                        "\n\t\t-učení starších, není bůh ani věčná hmota" +
                        "\n\tMahájána (velký vůz)" +
                        "\n\t\t-Buddha je božský" +
                        "\n\t\t-Bódhisattové - naschvál nedocílí Nirvány, aby ji pomohli docílit ostatním" +
                        "\n\tTantrajána, Lamaismus (6st. po kristu)" +
                        "\n\t\t-Tibetská Mahájána" +
                        "\n\t\tTantry - tajné nauky s duchovní energií"
                ),
                PsychologyTermAnswer("džínismus",
                    false,
                    "Džínismus (džaina=vítěz nad koloběhem životů)" +
                        "\n\tPrinc Vardhamáma - Mahávíra" +
                        "\n\tZásadní a tvrdé - půsty, umrtvování, meditace" +
                        "\nDělení na:" +
                        "\n\tDigambary (odění vzduchem=nazí) - přísnější" +
                        "\n\tŠvétambary (bílé odění) - umířněnější" +
                        "\nDžíva=duše" +
                        "\tAdžíva=skutečnost"
                ),
                PsychologyTermAnswer("indická filozofie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("taoismus",
                    false,
                    "Taoismus" +
                        "\n\t-více přírodní, individualistický v porovnání se zbytkem čínského myšlení" +
                        "\n\t-základ světa je proudění \"čchi\" - tok energie." +
                        "\n\t-prazáklad \"Tao\"=cesta" +
                        "\n\t-umět vyjít si s málem, poddání se proměnlivosti, přirozenost" +
                        "\n\t-každý jev má 2 protiklady >Jin a Jang<, výsledek konfliktu je >harmonie<" +
                        "\n\t-obrana před vnucenou civilizací - \"nejednání\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo je Siddharta Gótama?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Buddha",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zástupce Džínismu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zástupce Konfuciuse",
                    false,
                    ""
                ),
                PsychologyTermAnswer("zástupce taoismu",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Co to je velký a malý vůz",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("dělení Buddhistického myšlení",
                    false,
                    ""
                ),
                PsychologyTermAnswer("hvězdné obrazce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("symbol společenské důležitosti v antice",
                    false,
                    ""
                ),
                PsychologyTermAnswer("pralátky",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Nirvána je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vyvanutí jáství",
                    false,
                    "(Nibbána), závěr osmidílné stezky Buddhismu"
                ),
                PsychologyTermAnswer("ukončení koloběhu převtělování",
                    false,
                    "Samsára"
                ),
                PsychologyTermAnswer("sbírka 3 písem",
                    false,
                    "Triptaka"
                ),
                PsychologyTermAnswer("Buddhovo učení",
                    false,
                    "Dharma"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Aporie je/jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("logické paradoxy dokazující nemožnost pohybu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vyvanutí jáství",
                    false,
                    "(Nibbána), závěr osmidílné stezky Buddhismu"
                ),
                PsychologyTermAnswer("ukončení koloběhu převtělování",
                    false,
                    "Samsára"
                ),
                PsychologyTermAnswer("sbírka 3 písem",
                    false,
                    "Triptaka"
                ),
                PsychologyTermAnswer("Buddhovo učení",
                    false,
                    "Dharma"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kniha proměn je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("I-Ťing",
                    false,
                    "kniha ze kterého čerpá čínského myšlení, 2000 př.kr."
                ),
                PsychologyTermAnswer("kniha mýtů",
                    false,
                    ""
                ),
                PsychologyTermAnswer("chameleon",
                    false,
                    "v I-Ťing je I=chameleon (znak proměny), Ťing=pojednání"
                ),
                PsychologyTermAnswer("Svatá kniha Švétambary",
                    false,
                    "Umírněnější Džínismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kolik obsahuje I-Ťing hexagramů? ",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("58",
                    false,
                    ""
                ),
                PsychologyTermAnswer("90",
                    false,
                    ""
                ),
                PsychologyTermAnswer("100",
                    false,
                    ""
                ),
                PsychologyTermAnswer("64",
                    false,
                    "plné čáry (Jang) a přerušené (Jin)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Mistr Kchun je zástupce",
            textAnswer = "Jméno Konfuciuse",
            answers =
            listOf(
                PsychologyTermAnswer("Konfucius",
                    false,
                        "Konfucius (551-479 př.kr.) učil 4 věcem:" +
                        "\n\t1. písmu, 2. pravidlům chvoání, 3. >oddanosti trůnu<, 4. upřímnosti" +
                        "\n\t-ušlechtilost, povinnost" +
                        "\n\t-neposlušenost je zdroj všeho nepořádku" +
                        "\n\t-sympatie - šu" +
                        "\n\t-nutnost vladaře, řádu" +
                        "\n\nKonfuciovo eticko-sociální učení prosadil následovník" +
                        "\nMencius (372-289 př. kr.)" +
                        "\n\t-přirozená dobrota člověka (oapk co prosazovali ostatní v Číně)"
                ),
                PsychologyTermAnswer("Taoismu",
                    false,
                    "Taoismus" +
                        "\n\t-více přírodní, individualistický v porovnání se zbytkem čínského myšlení" +
                        "\n\t-základ světa je proudění \"čchi\" - tok energie." +
                        "\n\t-prazáklad \"Tao\"=cesta" +
                        "\n\t-umět vyjít si s málem, poddání se proměnlivosti, přirozenost" +
                        "\n\t-každý jev má 2 protiklady >Jin a Jang<, výsledek konfliktu je >harmonie<" +
                        "\n\t-obrana před vnucenou civilizací - \"nejednání\""
                ),
                PsychologyTermAnswer("Džínismu",
                    false,
                    "Džínismus (džaina=vítěz nad koloběhem životů)" +
                        "\n\tPrinc Vardhamáma - Mahávíra" +
                        "\n\tZásadní a tvrdé - půsty, umrtvování, meditace" +
                        "\nDělení na:" +
                        "\n\tDigambary (odění vzduchem=nazí) - přísnější" +
                        "\n\tŠvétambary (bílé odění) - umířněnější" +
                        "\nDžíva=duše" +
                        "\tAdžíva=skutečnost"
                ),
                PsychologyTermAnswer("Buddhismu",
                    false,
                    "princ Siddharta Gótama/Buddha (osvícený) (564-480 př.kr.)" +
                        "\nDharma (jeho učení)" +
                        "\n\t3 sbírky písem - košů (Triptaka)" +
                        "\n\t4 pravdy:" +
                        "\n\t\t1. Vše v životě je strast" +
                        "\n\t\t2. Příčina strasti je touha, žízeň po životě" +
                        "\n\t\t3. Zbavení se žízně -> zbavení se strasti" +
                        "\n\t\t4. Cesta ke zbavení se žízně je osmidílná stezka" +
                        "\n\t\t\t-závěr - pravé soustředění (meditace)" +
                        "\n\t\t\t-Nirvána (Nibbána - vyvanutí jáství)" +
                        "\n\t\t\t-Samsára - ukončení koloběhu převtělování" +
                        "\nučení o ne-já" +
                        "\nExistence boha, vznik světa, existence duše - bezvýznamné pro cestu" +
                        "\n\nNavazující školy:" +
                        "\n\tThéraváda, Hínájna (malý vůz)" +
                        "\n\t\t-učení starších, není bůh ani věčná hmota" +
                        "\n\tMahájána (velký vůz)" +
                        "\n\t\t-Buddha je božský" +
                        "\n\t\t-Bódhisattové - naschvál nedocílí Nirvány, aby ji pomohli docílit ostatním" +
                        "\n\tTantrajána, Lamaismus (6st. po kristu)" +
                        "\n\t\t-Tibetská Mahájána" +
                        "\n\t\tTantry - tajné nauky s duchovní energií"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Konfuciusovo učení prosadil jeho následník",
            textAnswer = "Konfucius (551-479 př.kr.) učil 4 věcem:" +
                "\n\t1. písmu, 2. pravidlům chvoání, 3. >oddanosti trůnu<, 4. upřímnosti" +
                "\n\t-ušlechtilost, povinnost" +
                "\n\t-neposlušenost je zdroj všeho nepořádku" +
                "\n\t-sympatie - šu" +
                "\n\t-nutnost vladaře, řádu",
            answers =
            listOf(
                PsychologyTermAnswer("Mencius",
                    false,
                    "Mencius (372-289 př. kr.)" +
                        "\n\t-přirozená dobrota člověka (oapk co prosazovali ostatní v Číně)"
                ),
                PsychologyTermAnswer("Mistr Kchun",
                    false,
                    "jméno Konfuciuse"
                ),
                PsychologyTermAnswer("Lao-c'",
                    false,
                    "zakladatel taoismu"
                ),
                PsychologyTermAnswer("Čuang Čou",
                    false,
                    "Taoismus"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Michel Foucault",
                    false,
                    "(1926-1984), postmodernismus, archeologie vědění" +
                        "\n-zavádí pojem epistémé (systém či řád, kterým předem regulujeme čím se vědění zabývá a jak to činí)" +
                        "\n-epistémé se děje vždy skokem, dějiny nejsou kontinuální, ale diskontinuální" +
                        "\n\t-diskurs - argumentovaný dialog uvnitř kultury"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem apercepce je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Francois Marie Voltaire",
                    false,
                    "(1694-1778)" +
                        "\n-výřečný mluvčí osvícenství" +
                        "\n-osvícenství určeno aristokracii, změny společnosti vyjdou z osvícenskhé panovníka" +
                        "\n-dějiny viděl ve sledu proměn kultur a ducha" +
                        "\n-deismus (Bůh stvořil svět a dále do něj nezasahuje)" +
                        "\n-\"Promlouvá jazykem, jemuž mohou rozumět všichni, i když si nerozumějí navzájem\"" +
                        "\n-myšlenky TOLERANCE" +
                        "\n-po zemětřesení v Lisabonu se stal pesimistou"
                ),
                PsychologyTermAnswer("Dietrich von Holbach",
                    false,
                    "(1723-1789), osvícenství, materialismus" +
                        "\n\"Systém přírody\"" +
                        "\n\t-vše je jen hmota, pouze její pohyb a hmota působí na naše smysly" +
                        "\n\t-MATERIALISTICKÝ MONISMUS (jednost)"
                ),
                PsychologyTermAnswer("J.O. la Mettrie",
                    false,
                    "(1709-1751), osvícenství, materialismus" +
                        "\n-netřeba rozlišovat mezi živou přírodou, stroji a člověkem" +
                        "\n-redukcionismus (přírodovědné zjednodušování člověka i společnosti)" +
                        "\n\t-v jeho případě na fyziologický produkt (míza stromu)"
                ),
                PsychologyTermAnswer("Čuang Čou",
                    false,
                    "Taoismus"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Systém přírody\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Dietrich von Holbach",
                    false,
                    "(1723-1789), osvícenství, materialismus" +
                        "\n\"Systém přírody\"" +
                        "\n\t-vše je jen hmota, pouze její pohyb a hmota působí na naše smysly" +
                        "\n\t-MATERIALISTICKÝ MONISMUS (jednost)"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Francois Marie Voltaire",
                    false,
                    "(1694-1778)" +
                        "\n-výřečný mluvčí osvícenství" +
                        "\n-osvícenství určeno aristokracii, změny společnosti vyjdou z osvícenskhé panovníka" +
                        "\n-dějiny viděl ve sledu proměn kultur a ducha" +
                        "\n-deismus (Bůh stvořil svět a dále do něj nezasahuje)" +
                        "\n-\"Promlouvá jazykem, jemuž mohou rozumět všichni, i když si nerozumějí navzájem\"" +
                        "\n-myšlenky TOLERANCE" +
                        "\n-po zemětřesení v Lisabonu se stal pesimistou"
                ),
                PsychologyTermAnswer("J.O. la Mettrie",
                    false,
                    "(1709-1751), osvícenství, materialismus" +
                        "\n-netřeba rozlišovat mezi živou přírodou, stroji a člověkem" +
                        "\n-redukcionismus (přírodovědné zjednodušování člověka i společnosti)" +
                        "\n\t-v jeho případě na fyziologický produkt (míza stromu)"
                ),
                PsychologyTermAnswer("Čuang Čou",
                    false,
                    "Taoismus"
                ),
                PsychologyTermAnswer("Michel Foucault",
                    false,
                    "(1926-1984), postmodernismus, archeologie vědění" +
                        "\n-zavádí pojem epistémé (systém či řád, kterým předem regulujeme čím se vědění zabývá a jak to činí)" +
                        "\n-epistémé se děje vždy skokem, dějiny nejsou kontinuální, ale diskontinuální" +
                        "\n\t-diskurs - argumentovaný dialog uvnitř kultury"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jak se nazývá kniha o Tau a ctnosti?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("I-Ťing",
                    false,
                    "kniha ze kterého čerpá čínského myšlení, 2000 př.kr."
                ),
                PsychologyTermAnswer("Dharma",
                    false,
                    "mravní řád obsahující vše, co existuje, mravní řád pro lidi"
                ),
                PsychologyTermAnswer("Tao-te-ťing",
                    false,
                    "předpokládaný autor Lao-c'"
                ),
                PsychologyTermAnswer("Atman",
                    false,
                    "Atman - Brahma v člověku, nesmrtelné já, cílem splynout s Brahma (Mokšá)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Souvislostí mezi složením lidské duše a uspořádáním společnosti se ve svém díle zabývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false
                ),
                PsychologyTermAnswer("Tomáš Akvinský",
                    false
                ),
                PsychologyTermAnswer("Carl Gustav Jung",
                    false
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zakladatelem proxemiky – vědy o osobním prostoru – je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Edward Twitchell Hall",
                    false
                ),
                PsychologyTermAnswer("Immanuel Maurice Wallerstein",
                    false
                ),
                PsychologyTermAnswer("Stanley Milgram",
                    false
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Podle které školy je základ světa proudění \"čchi\" (tok energie)",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Taoismus",
                    false,
                    "Taoismus" +
                        "\n\t-více přírodní, individualistický v porovnání se zbytkem čínského myšlení" +
                        "\n\t-základ světa je proudění \"čchi\" - tok energie." +
                        "\n\t-prazáklad \"Tao\"=cesta" +
                        "\n\t-umět vyjít si s málem, poddání se proměnlivosti, přirozenost" +
                        "\n\t-každý jev má 2 protiklady >Jin a Jang<, výsledek konfliktu je >harmonie<" +
                        "\n\t-obrana před vnucenou civilizací - \"nejednání\""
                ),
                PsychologyTermAnswer("Buddhismus",
                    false,
                    "princ Siddharta Gótama/Buddha (osvícený) (564-480 př.kr.)" +
                        "\nDharma (jeho učení)" +
                        "\n\t3 sbírky písem - košů (Triptaka)" +
                        "\n\t4 pravdy:" +
                        "\n\t\t1. Vše v životě je strast" +
                        "\n\t\t2. Příčina strasti je touha, žízeň po životě" +
                        "\n\t\t3. Zbavení se žízně -> zbavení se strasti" +
                        "\n\t\t4. Cesta ke zbavení se žízně je osmidílná stezka" +
                        "\n\t\t\t-závěr - pravé soustředění (meditace)" +
                        "\n\t\t\t-Nirvána (Nibbána - vyvanutí jáství)" +
                        "\n\t\t\t-Samsára - ukončení koloběhu převtělování" +
                        "\nučení o ne-já" +
                        "\nExistence boha, vznik světa, existence duše - bezvýznamné pro cestu" +
                        "\n\nNavazující školy:" +
                        "\n\tThéraváda, Hínájna (malý vůz)" +
                        "\n\t\t-učení starších, není bůh ani věčná hmota" +
                        "\n\tMahájána (velký vůz)" +
                        "\n\t\t-Buddha je božský" +
                        "\n\t\t-Bódhisattové - naschvál nedocílí Nirvány, aby ji pomohli docílit ostatním" +
                        "\n\tTantrajána, Lamaismus (6st. po kristu)" +
                        "\n\t\t-Tibetská Mahájána" +
                        "\n\t\tTantry - tajné nauky s duchovní energií"
                ),
                PsychologyTermAnswer("Milétská škola",
                    false,
                    ""
                ),
                PsychologyTermAnswer("škola Konfuciusova",
                    false,
                    "Konfucius (551-479 př.kr.) učil 4 věcem:" +
                        "\n\t1. písmu, 2. pravidlům chvoání, 3. >oddanosti trůnu<, 4. upřímnosti" +
                        "\n\t-ušlechtilost, povinnost" +
                        "\n\t-neposlušenost je zdroj všeho nepořádku" +
                        "\n\t-sympatie - šu" +
                        "\n\t-nutnost vladaře, řádu" +
                        "\n\nKonfuciovo eticko-sociální učení prosadil následovník" +
                        "\nMencius (372-289 př. kr.)" +
                        "\n\t-přirozená dobrota člověka (oapk co prosazovali ostatní v Číně)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Podle které školy má každý jev 2 protiklady Jin a Jang",
            textAnswer = "výsledek konfilktu je harmonie",
            answers =
            listOf(
                PsychologyTermAnswer("Taoismus",
                    false,
                    "Taoismus" +
                        "\n\t-více přírodní, individualistický v porovnání se zbytkem čínského myšlení" +
                        "\n\t-základ světa je proudění \"čchi\" - tok energie." +
                        "\n\t-prazáklad \"Tao\"=cesta" +
                        "\n\t-umět vyjít si s málem, poddání se proměnlivosti, přirozenost" +
                        "\n\t-každý jev má 2 protiklady >Jin a Jang<, výsledek konfliktu je >harmonie<" +
                        "\n\t-obrana před vnucenou civilizací - \"nejednání\""
                ),
                PsychologyTermAnswer("Buddhismus",
                    false,
                    "princ Siddharta Gótama/Buddha (osvícený) (564-480 př.kr.)" +
                        "\nDharma (jeho učení)" +
                        "\n\t3 sbírky písem - košů (Triptaka)" +
                        "\n\t4 pravdy:" +
                        "\n\t\t1. Vše v životě je strast" +
                        "\n\t\t2. Příčina strasti je touha, žízeň po životě" +
                        "\n\t\t3. Zbavení se žízně -> zbavení se strasti" +
                        "\n\t\t4. Cesta ke zbavení se žízně je osmidílná stezka" +
                        "\n\t\t\t-závěr - pravé soustředění (meditace)" +
                        "\n\t\t\t-Nirvána (Nibbána - vyvanutí jáství)" +
                        "\n\t\t\t-Samsára - ukončení koloběhu převtělování" +
                        "\nučení o ne-já" +
                        "\nExistence boha, vznik světa, existence duše - bezvýznamné pro cestu" +
                        "\n\nNavazující školy:" +
                        "\n\tThéraváda, Hínájna (malý vůz)" +
                        "\n\t\t-učení starších, není bůh ani věčná hmota" +
                        "\n\tMahájána (velký vůz)" +
                        "\n\t\t-Buddha je božský" +
                        "\n\t\t-Bódhisattové - naschvál nedocílí Nirvány, aby ji pomohli docílit ostatním" +
                        "\n\tTantrajána, Lamaismus (6st. po kristu)" +
                        "\n\t\t-Tibetská Mahájána" +
                        "\n\t\tTantry - tajné nauky s duchovní energií"
                ),
                PsychologyTermAnswer("Milétská škola",
                    false,
                    ""
                ),
                PsychologyTermAnswer("škola Konfuciusova",
                    false,
                    "Konfucius (551-479 př.kr.) učil 4 věcem:" +
                        "\n\t1. písmu, 2. pravidlům chvoání, 3. >oddanosti trůnu<, 4. upřímnosti" +
                        "\n\t-ušlechtilost, povinnost" +
                        "\n\t-neposlušenost je zdroj všeho nepořádku" +
                        "\n\t-sympatie - šu" +
                        "\n\t-nutnost vladaře, řádu" +
                        "\n\nKonfuciovo eticko-sociální učení prosadil následovník" +
                        "\nMencius (372-289 př. kr.)" +
                        "\n\t-přirozená dobrota člověka (oapk co prosazovali ostatní v Číně)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Thalés je součástí",
            textAnswer = "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)",
            answers =
            listOf(
                PsychologyTermAnswer("předsokratovské filosofie (6.-4.st. př.kr.)",
                    false,
                    "Míletská škola" +
                        "\n\t-Thalés, Anaximandros, Anaximenés" +
                        "\nPýthagorás, " +
                        "\nElejská škola" +
                        "\n\t-Xenofanés, Parmenidés, Zénón" +
                        "\nHérakleitos, " +
                        "\nAntičtí atomisté" +
                        "\n\t-Leukippos, Démokritos" +
                        "\nEmpedoklés, Anaxagorás"
                ),
                PsychologyTermAnswer("období klasické filosofie (5-4.st. př.kr.)",
                    false,
                    "Sofisté" +
                        "\n\t-Prótagorás, Gorgiás" +
                        "\nSókratés" +
                        "\nPlatón" +
                        "\nAristotelés"
                ),
                PsychologyTermAnswer("období helénismu (4. st. př.kr - 529 po kr.)",
                    false,
                    "Epikúros" +
                        "\nStoicismus" +
                        "\n\t-Zénón, Chrýsippos, Seneca, Epiktétos, Marcus Aurelius" +
                        "\nSkepticismus" +
                        "\n\t-Pyrrhón" +
                        "\n\t-Probabilismus" +
                        "\n\t-Ainesidémos, Sextos, Empirikos" +
                        "\nPokračovatelé Platónovi; gnóze" +
                        "\n\t-Plútarchos, Núménios, Filón Alexandrijský, Ammónios Sakkás, Plótínos, Porfyrios, Plótínus"
                ),
                PsychologyTermAnswer("elejské školy",
                    false,
                    "-Xenofanés, Parmenidés, Zénón"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Hýlozoismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("živá hmota",
                    false,
                    "Hýlozoismus (hýlé=hmota, zoé=život)"
                ),
                PsychologyTermAnswer("pralátka",
                    false,
                    "(arché) např. Voda u Thalése, Apeiron u Anaximandrose, Vzduch u Anaximénese"
                ),
                PsychologyTermAnswer("vnější síla láska a svár",
                    false,
                    "částice jsou hýbány vnější silou -Empedoklés. U Anaxagora to byl kosmický duch (nús)"
                ),
                PsychologyTermAnswer("nedůvěra spolehlivě poznávat svět",
                    false,
                    "noetická skepsa" +
                        "\n -Filosofie klasického období > sofisté > Prótagorás a Gorgiás"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Nedůvěra spolehlivě poznávat svět",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("noetická skepse",
                    false,
                    " -Filosofie klasického období > sofisté > Prótagorás a Gorgiás"
                ),
                PsychologyTermAnswer("skeptisismus",
                    false,
                    "pochybování, prověřování našich schopností poznávat"
                ),
                PsychologyTermAnswer("relativismus",
                    false,
                    "pravda, spravedlnost, hodnoty jsou subjektivní" +
                        "\n -Filosofie klasického období > sofisté > Prótagorás a Gorgiás"
                ),
                PsychologyTermAnswer("hýlozoismus",
                    false,
                    "(hýlé=hmota, zoé=život)" +
                        "\n -Předsókratovská filosofie > Milétská škola"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce Elejské školy nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Pýthagorás",
                    false,
                    "(572 - 494 př.kr.) Antická filosofie > Předsokratovská filosofie" +
                        "\nNáboženský spolek - ovlivněno Orfiky (orfeus=mýt. hrdina)" +
                        "\nApeiron (Anaximandros) není, jelikož ho nelze od sebe odlišit." +
                        "\nKaždé jsoucno tvarováno a má svou mez (peras) a je počítatelné" +
                        "\n\tZáklad je číslo" +
                        "\n\t\t-např. správná šíře strun=harmonie., i kosmos má svou harmonii." +
                        "\n\t\t-svět a jeho harmonii můžeme poznávat až když máme harmonii ve vlastní duši" +
                        "\n\t\t-zjistili, že strany čtverce mají iracionální číslo - tedy chaos, snažili se utajit."
                ),
                PsychologyTermAnswer("Zénón",
                    false,
                    "(490-430 př.kr.) Antická filosofie > Předsokratovská filosofie > Elejská škola" +
                        "\nDokazoval učení Parmenidése" +
                        "\n\t>Aporiemi<" +
                        "\n\t\t-log. paradoxy nemožnosti pohybu" +
                        "\n\t\t-polovina poloviny poloviny poloviny..." +
                        "\n\t\t-Achillés nikdy nedožene želvu"
                ),
                PsychologyTermAnswer("Parmenidés",
                    false,
                    "(540-470 př.kr.) Antická filosofie > Předsokratovská filosofie > Elejská škola" +
                        "\n\n\"Nebytí není\", jest pouze bytí" +
                        "\n>Jsoucno< musí být jen >jedno<" +
                        "\n\tJinak by okolo byl prostor a jsoucno by se mohlo přelévat do nicotu - nebýt plný" +
                        "\nSmysly jsou zdání, rozum je pravdivý a nehybný"
                ),
                PsychologyTermAnswer("Xenofanés",
                    false,
                    "(569-477 př.kr.) Antická filosofie > Předsokratovská filosofie > Elejská škola" +
                        "\n\nKritik antromorfního náboženství (bůh v podobě člověka)" +
                        "\n\t-musí být pouze 1 Bůh (zdali má být neomezený)" +
                        "\n\t-musí být nehybný (jinak by okolo sebe musel mít prostor)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce Mílétské školy nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Thalés",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                        "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)"
                ),
                PsychologyTermAnswer("Anaximandros",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátka >Apeiron< (nezměrné, neomezené)" +
                        "\nApeiron se tvaruje a následně kvůli provinění se za trest zpětně rozplyne - rozpad objektu"
                ),
                PsychologyTermAnswer("Anaximenés",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nZjednodušil Anaximandrose - pralátka je neomezený vzduch (dýchání, dech)" +
                        "\nMěsíc má světlo od Slunce"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Centrum antické filozofie bylo převážně v",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Řecku",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Římě",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Itálii",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Turecku",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Za pralátku Apeiron považoval",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Anaximandros",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátka >Apeiron< (nezměrné, neomezené)" +
                        "\nApeiron se tvaruje a následně kvůli provinění se za trest zpětně rozplyne - rozpad objektu"
                ),
                PsychologyTermAnswer("Thalés",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátkou je voda - božšká síla (není to bůh, ani jen hmota)" +
                        "\nZěmě je plochá a pluje na povrchu oceánu - vlnobití způsobuje zemětřesení (první nemytologické vysvětlení přírodního jevu)"
                ),
                PsychologyTermAnswer("Xenofanés",
                    false,
                    "(569-477 př.kr.) Antická filosofie > Předsokratovská filosofie > Elejská škola" +
                        "\n\nKritik antromorfního náboženství (bůh v podobě člověka)" +
                        "\n\t-musí být pouze 1 Bůh (zdali má být neomezený)" +
                        "\n\t-musí být nehybný (jinak by okolo sebe musel mít prostor)"
                ),
                PsychologyTermAnswer("Empedoklés a Anaxagorás",
                    false,
                    "(490-435 př.kr.), antická filosofie > předsokratovká filosofie" +
                        "\nspojení elejské školy a Hérakleita" +
                        "\n\t-jsoucí jsou nepatrné částečky \"kořenů všeho\" a \"semen věcí\"" +
                        "\n\t\t-máme kořeny ohně, vzduchu, vody a země, z čehož se vše skládá." +
                        "\n\t-částice se již nehýbou sami, avšak jsou pohybovány vnějšími silami" +
                        "\n\t\t-Empedoklés - síly jsou >láska a svár<" +
                        "\n\t\t-Anaxagorás - >duch (nůs)<"
                ),
                PsychologyTermAnswer("Hérakleitos",
                    false,
                    "(540-480 př.kr.), antická filosofie > předsokratovská filosofie" +
                        "\nOpak elejské školy - proměnlivost věcí" +
                        "\n\t-přeměna bytí na nebytí a naopak" +
                        "\n\t-\"Nikdy nevstoupíme do řeky dvakrát\"" +
                        "\n\t-\"Svět je věčně panoucí oheň\"" +
                        "\n>Logos< (světový zákon)" +
                        "\n\t-díky logos poznáváme harmonii světa" +
                        "\nDialektické myšlení" +
                        "\n\t-boj a jednota protikladů"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jaká škola zastávala jednotu a nehybnost jsoucna a Boha?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Elejská škola",
                    false,
                    "-Xenofanés, Parmenidés, Zénón"
                ),
                PsychologyTermAnswer("Mílétská škola",
                    false,
                    "Hýlozoisté (hýlé=hmota, zoé=život)" +
                        "\n-Thalés (voda), Anaximandros (Apeiron), Anaximenés (vzduch)"
                ),
                PsychologyTermAnswer("Antičtí atomisté",
                    false,
                    "Antická filosofie > předsokratovská filosofie > Antičtí atomisté" +
                        "\nSpojení Elejské školy a Héreklitů" +
                        "\n\t-nedělitelné, věčné >Atomy<" +
                        "\n\t\t-pohybující se v prázdnotě, čili nebytí" +
                        "\n-neexistuje náhoda - >Determinismus<" +
                        "\n-Leukippos, Démokritos"
                ),
                PsychologyTermAnswer("Sofisté",
                    false,
                    "Antická filosofie > filosofie klasického období" +
                        "\n->Veřejná činnost<" +
                        "\nSubjektivismus" +
                        "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                        "\n\t-pravda je subjektivní" +
                        "\nNoetická skepce" +
                        "\n\t-nedůvěra spolehlivě poznávat svět" +
                        "\n\t-1. Nic není, 2. I kdyby, nelze to poznat, 3. I kdyby, nelze to sdělit" +
                        "\n\t-rozmělnilo se v řečnické triky - >Sofismata< (chytráčství)" +
                        "\nRelativismus" +
                        "\n\t-pravda, spravedlnost a hodnoty jsou subjektivní" +
                        "\n-Prótagorás, Gorgiás (483-375 př.kr.)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Prvními zástupci determinismu byli",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Antičtí atomisté",
                    false,
                    "Antická filosofie > předsokratovská filosofie" +
                        "\nSpojení Elejské školy a Héreklitů" +
                        "\n\t-nedělitelné, věčné >Atomy<" +
                        "\n\t\t-pohybující se v prázdnotě, čili nebytí" +
                        "\n-neexistuje náhoda - >Determinismus<" +
                        "\n-Leukippos, Démokritos"
                ),
                PsychologyTermAnswer("Sofisté",
                    false,
                    "Antická filosofie > filosofie klasického období" +
                    "\n->Veřejná činnost<" +
                        "\nSubjektivismus" +
                        "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                        "\n\t-pravda je subjektivní" +
                        "\nNoetická skepce" +
                        "\n\t-nedůvěra spolehlivě poznávat svět" +
                        "\n\t-1. Nic není, 2. I kdyby, nelze to poznat, 3. I kdyby, nelze to sdělit" +
                        "\n\t-rozmělnilo se v řečnické triky - >Sofismata< (chytráčství)" +
                        "\nRelativismus" +
                        "\n\t-pravda, spravedlnost a hodnoty jsou subjektivní" +
                        "\n-Prótagorás, Gorgiás (483-375 př.kr.)"
                ),
                PsychologyTermAnswer("Elejská škola",
                    false,
                    "Antická filosofie > předsokratovská filosofie" +
                        "\nJednotu, nehybnost jsoucna a Boha" +
                        "\nXenofanés (569-477 př.kr.)" +
                        "\n\nKritik antromorfního náboženství (bůh v podobě člověka)" +
                        "\n\t-musí být pouze 1 Bůh (zdali má být neomezený)" +
                        "\n\t-musí být nehybný (jinak by okolo sebe musel mít prostor)" +
                        "\n\nParmenidés (540-470 př.kr.)" +
                        "\n\n\"Nebytí není\", jest pouze bytí" +
                        "\n>Jsoucno< musí být jen >jedno<" +
                        "\n\tJinak by okolo byl prostor a jsoucno by se mohlo přelévat do nicotu - nebýt plný" +
                        "\nSmysly jsou zdání, rozum je pravdivý a nehybný"
                ),
                PsychologyTermAnswer("Stoicisti",
                    false,
                    "Antická filosofie > Hélenistická filosofie" +
                        "\nStoicismus:" +
                        "\nzdobné sloupí (stoa poikilé)" +
                        "\n-základ všeho je Bůh v podobě ducha (pneuma)" +
                        "\n-vše propojeno pouty sounáležitosti (sympatheia) a řízeno prozřetelností" +
                        "\n\t-pokud se nenásleduje, vzniká nemoc duše, ta je léčena >Apatheií<, z níž vzniká >Ctnost< (areté)" +
                        "\nEpiktétos" +
                        "\n\t-neřešit neřešitelné a řešit řešitelné" +
                        "\n\t-trápení nepouštět do prožívání (něco jako suprese)" +
                        "\n\t-vše má svůj důvod, naším cílem je se spokojit s tím, co máme" +
                        "\nRovnost všech lidí - proti otroctví" +
                        "\nZénón (336-264 př.kr., zakladatel)" +
                        "\nChrýsippos - vycházel z Platónismu, pozdní stoa v Římě" +
                        "\nSeneca (učitel císaře, Marcus Aurelius"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "S teorií, že Měsíc má světlo od Slunce přišel",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Anaximenés",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nZjednodušil Anaximandrose - pralátka je neomezený vzduch (dýchání, dech)" +
                        "\nMěsíc má světlo od Slunce"
                ),
                PsychologyTermAnswer("Xenofanés",
                    false,
                    "(569-477 př.kr.) Antická filosofie > Předsokratovská filosofie > Elejská škola" +
                        "\n\nKritik antromorfního náboženství (bůh v podobě člověka)" +
                        "\n\t-musí být pouze 1 Bůh (zdali má být neomezený)" +
                        "\n\t-musí být nehybný (jinak by okolo sebe musel mít prostor)"
                ),
                PsychologyTermAnswer("Hérakleitos",
                    false,
                    "(540-480 př.kr.), antická filosofie > předsokratovská filosofie" +
                        "\nOpak elejské školy - proměnlivost věcí" +
                        "\n\t-přeměna bytí na nebytí a naopak" +
                        "\n\t-\"Nikdy nevstoupíme do řeky dvakrát\"" +
                        "\n\t-\"Svět je věčně panoucí oheň\"" +
                        "\n>Logos< (světový zákon)" +
                        "\n\t-díky logos poznáváme harmonii světa" +
                        "\nDialektické myšlení" +
                        "\n\t-boj a jednota protikladů"
                ),
                PsychologyTermAnswer("Sókratés",
                    false,
                    "Antická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "První zástupci relativismu byli",
            textAnswer = "-pravda, spravedlnost a hodnoty jsou subjektivní",
            answers =
            listOf(
                PsychologyTermAnswer("Sofisté",
                    false,
                    "Antická filosofie > filosofie klasického období" +
                        "\n->Veřejná činnost<" +
                        "\nSubjektivismus" +
                        "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                        "\n\t-pravda je subjektivní" +
                        "\nNoetická skepce" +
                        "\n\t-nedůvěra spolehlivě poznávat svět" +
                        "\n\t-1. Nic není, 2. I kdyby, nelze to poznat, 3. I kdyby, nelze to sdělit" +
                        "\n\t-rozmělnilo se v řečnické triky - >Sofismata< (chytráčství)" +
                        "\n-Prótagorás, Gorgiás (483-375 př.kr.)"
                ),
                PsychologyTermAnswer("Antičtí atomisté",
                    false,
                    "Antická filosofie > předsokratovská filosofie" +
                        "\nSpojení Elejské školy a Héreklitů" +
                        "\n\t-nedělitelné, věčné >Atomy<" +
                        "\n\t\t-pohybující se v prázdnotě, čili nebytí" +
                        "\n-neexistuje náhoda - >Determinismus<" +
                        "\n-Leukippos, Démokritos"
                ),
                PsychologyTermAnswer("Elejská škola",
                    false,
                    "Antická filosofie > předsokratovská filosofie" +
                        "\nJednotu, nehybnost jsoucna a Boha" +
                        "\nXenofanés (569-477 př.kr.)" +
                        "\n\nKritik antromorfního náboženství (bůh v podobě člověka)" +
                        "\n\t-musí být pouze 1 Bůh (zdali má být neomezený)" +
                        "\n\t-musí být nehybný (jinak by okolo sebe musel mít prostor)" +
                        "\n\nParmenidés (540-470 př.kr.)" +
                        "\n\n\"Nebytí není\", jest pouze bytí" +
                        "\n>Jsoucno< musí být jen >jedno<" +
                        "\n\tJinak by okolo byl prostor a jsoucno by se mohlo přelévat do nicotu - nebýt plný" +
                        "\nSmysly jsou zdání, rozum je pravdivý a nehybný"
                ),
                PsychologyTermAnswer("Stoicisti",
                    false,
                    "Antická filosofie > Hélenistická filosofie" +
                        "\nzdobné sloupí (stoa poikilé)" +
                        "\n-základ všeho je Bůh v podobě ducha (pneuma)" +
                        "\n-vše propojeno pouty sounáležitosti (sympatheia) a řízeno prozřetelností" +
                        "\n\t-pokud se nenásleduje, vzniká nemoc duše, ta je léčena >Apatheií<, z níž vzniká >Ctnost< (areté)" +
                        "\nEpiktétos" +
                        "\n\t-neřešit neřešitelné a řešit řešitelné" +
                        "\n\t-trápení nepouštět do prožívání (něco jako suprese)" +
                        "\n\t-vše má svůj důvod, naším cílem je se spokojit s tím, co máme" +
                        "\nRovnost všech lidí - proti otroctví" +
                        "\nZénón (336-264 př.kr., zakladatel)" +
                        "\nChrýsippos - vycházel z Platónismu, pozdní stoa v Římě" +
                        "\nSeneca (učitel císaře, Marcus Aurelius"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "První zástupci subjektivismu byli",
            textAnswer = "Subjektivismus" +
                "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                "\n\t-pravda je subjektivní",
            answers =
            listOf(
                PsychologyTermAnswer("Sofisté",
                    false,
                    "Antická filosofie > filosofie klasického období" +
                        "\n->Veřejná činnost<" +
                        "\nSubjektivismus" +
                        "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                        "\n\t-pravda je subjektivní" +
                        "\nNoetická skepce" +
                        "\n\t-nedůvěra spolehlivě poznávat svět" +
                        "\n\t-1. Nic není, 2. I kdyby, nelze to poznat, 3. I kdyby, nelze to sdělit" +
                        "\n\t-rozmělnilo se v řečnické triky - >Sofismata< (chytráčství)" +
                        "\nRelativismus" +
                        "\n\t-pravda, spravedlnost a hodnoty jsou subjektivní" +
                        "\n-Prótagorás, Gorgiás (483-375 př.kr.)"
                ),
                PsychologyTermAnswer("Antičtí atomisté",
                    false,
                    "Antická filosofie > předsokratovská filosofie" +
                        "\nSpojení Elejské školy a Héreklitů" +
                        "\n\t-nedělitelné, věčné >Atomy<" +
                        "\n\t\t-pohybující se v prázdnotě, čili nebytí" +
                        "\n-neexistuje náhoda - >Determinismus<" +
                        "\n-Leukippos, Démokritos"
                ),
                PsychologyTermAnswer("Elejská škola",
                    false,
                    "Antická filosofie > předsokratovská filosofie" +
                    "\nJednotu, nehybnost jsoucna a Boha" +
                        "\nXenofanés (569-477 př.kr.)" +
                        "\n\nKritik antromorfního náboženství (bůh v podobě člověka)" +
                        "\n\t-musí být pouze 1 Bůh (zdali má být neomezený)" +
                        "\n\t-musí být nehybný (jinak by okolo sebe musel mít prostor)" +
                        "\n\nParmenidés (540-470 př.kr.)" +
                        "\n\n\"Nebytí není\", jest pouze bytí" +
                        "\n>Jsoucno< musí být jen >jedno<" +
                        "\n\tJinak by okolo byl prostor a jsoucno by se mohlo přelévat do nicotu - nebýt plný" +
                        "\nSmysly jsou zdání, rozum je pravdivý a nehybný"
                ),
                PsychologyTermAnswer("Stoicisti",
                    false,
                    "Antická filosofie > Hélenistická filosofie" +
                        "\nzdobné sloupí (stoa poikilé)" +
                        "\n-základ všeho je Bůh v podobě ducha (pneuma)" +
                        "\n-vše propojeno pouty sounáležitosti (sympatheia) a řízeno prozřetelností" +
                        "\n\t-pokud se nenásleduje, vzniká nemoc duše, ta je léčena >Apatheií<, z níž vzniká >Ctnost< (areté)" +
                        "\nEpiktétos" +
                        "\n\t-neřešit neřešitelné a řešit řešitelné" +
                        "\n\t-trápení nepouštět do prožívání (něco jako suprese)" +
                        "\n\t-vše má svůj důvod, naším cílem je se spokojit s tím, co máme" +
                        "\nRovnost všech lidí - proti otroctví" +
                        "\nZénón (336-264 př.kr., zakladatel)" +
                        "\nChrýsippos - vycházel z Platónismu, pozdní stoa v Římě" +
                        "\nSeneca (učitel císaře, Marcus Aurelius"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Nikdy nevstoupíme do řeky dvakrát\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Hérakleitos",
                    false,
                    "(540-480 př.kr.), antická filosofie > předsokratovská filosofie" +
                        "\nOpak elejské školy - proměnlivost věcí" +
                        "\n\t-přeměna bytí na nebytí a naopak" +
                        "\n\t-\"Nikdy nevstoupíme do řeky dvakrát\"" +
                        "\n\t-\"Svět je věčně panoucí oheň\"" +
                        "\n>Logos< (světový zákon)" +
                        "\n\t-díky logos poznáváme harmonii světa" +
                        "\nDialektické myšlení" +
                        "\n\t-boj a jednota protikladů"
                ),
                PsychologyTermAnswer("Empedoklés a Anaxagorás",
                    false,
                    "(490-435 př.kr.), antická filosofie > předsokratovká filosofie" +
                        "\nspojení elejské školy a Hérakleita" +
                        "\n\t-jsoucí jsou nepatrné částečky \"kořenů všeho\" a \"semen věcí\"" +
                        "\n\t\t-máme kořeny ohně, vzduchu, vody a země, z čehož se vše skládá." +
                        "\n\t-částice se již nehýbou sami, avšak jsou pohybovány vnějšími silami" +
                        "\n\t\t-Empedoklés - síly jsou >láska a svár<" +
                        "\n\t\t-Anaxagorás - >duch (nůs)<"
                ),
                PsychologyTermAnswer("Sókrates",
                    false,
                    "Antická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                ),
                PsychologyTermAnswer("Aristotelés",
                    false,
                    "Žák Platóna, avšak ho později kritizoval, učitel Alexandra Velikého." +
                        "\nPeripatetická škola (peripatos=sloupořadí)" +
                        "\n\t-procházky s jeho žáky" +
                        "\nDíla: Metafyzika, Etika Nikomachova, Politika, Poetika, Organon" +
                        "\n>Látka (eidos) a forma (morfé)<" +
                        "\n\tDuše je forma a tělo je jen látka" +
                        "\n\tLátka je pouze potenčnost, až teprve forma vytváří věci skutečné z látky." +
                        "\nPohyb" +
                        "\n\t-proces, při čemž látka nabývá formy" +
                        "\n\t-\"Je třeba se zastavit\" - první hybatel - Bůh" +
                        "\nÚčel (telos)" +
                        "\n\t-vnitřní příčina věcí, vše má účel" +
                        "\n\t->Entelechie< - naplnění účelu" +
                        "\n\t-Teleologie - účel předchází uskutečnění" +
                        "\n>Logika<" +
                        "\n\t-nauka o pravidlech, formě usuzování" +
                        "\n\t-klasifikace úsudků, nadřazenost a podřazenost zákl. pojmů" +
                        "\n\t-zákon totožnosti, sporu a vyloučeního třetího" +
                        "\nForma společnosti" +
                        "\n\t-nadčasový výzkum 158 řeckých ústav" +
                        "\n\t-bytosti společenské (zóon polítikon)" +
                        "\n\t-střední míra - sřední třída ideál, vše tak nějak do míry"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Který filosof je známý tzv. Peripatetickým učením?",
            textAnswer = "učení procházky",
            answers =
            listOf(
                PsychologyTermAnswer("Aristotelés",
                    false,
                    "Žák Platóna, avšak ho později kritizoval, učitel Alexandra Velikého." +
                        "\nPeripatetická škola (peripatos=sloupořadí)" +
                        "\n\t-procházky s jeho žáky" +
                        "\nDíla: Metafyzika, Etika Nikomachova, Politika, Poetika, Organon" +
                        "\n>Látka (eidos) a forma (morfé)<" +
                        "\n\tDuše je forma a tělo je jen látka" +
                        "\n\tLátka je pouze potenčnost, až teprve forma vytváří věci skutečné z látky." +
                        "\nPohyb" +
                        "\n\t-proces, při čemž látka nabývá formy" +
                        "\n\t-\"Je třeba se zastavit\" - první hybatel - Bůh" +
                        "\nÚčel (telos)" +
                        "\n\t-vnitřní příčina věcí, vše má účel" +
                        "\n\t->Entelechie< - naplnění účelu" +
                        "\n\t-Teleologie - účel předchází uskutečnění" +
                        "\n>Logika<" +
                        "\n\t-nauka o pravidlech, formě usuzování" +
                        "\n\t-klasifikace úsudků, nadřazenost a podřazenost zákl. pojmů" +
                        "\n\t-zákon totožnosti, sporu a vyloučeního třetího" +
                        "\nForma společnosti" +
                        "\n\t-nadčasový výzkum 158 řeckých ústav" +
                        "\n\t-bytosti společenské (zóon polítikon)" +
                        "\n\t-střední míra - sřední třída ideál, vše tak nějak do míry"
                ),
                PsychologyTermAnswer("Sókrates",
                    false,
                    "Antická filosofie > Filosofie klasického období" +
                        "\nNezůstalo po něm žádné dílo, vše máme od Platóna." +
                        "\nDiskuse na tržnicích, kladl lidem otázky." +
                        "\nMísto relativismu - >naslouchání nitru člověka<" +
                        "\n\tMetoda dialogu" +
                        "\n\t\t-např. co je vláda? Co je dobro?" +
                        "\n\t\t-pomocí různorodosti vytvářel >definice pojmů<" +
                        "\n\t\t-\"Nemluvím s úmyslem se zavděčit,...\"-dialog Górgias" +
                        "\nAristokracie" +
                        "\n\"Vím, že nic nevím\"" +
                        "\nRozum se sklání před vnitřním mystickým hlasem - Daimonion - >Hlas sebevědomí< po poznání" +
                        "\nVychází z něj >Kynická škola<" +
                        "\n\t-Diogenés (400-323 př.kr.)" +
                        "\n\t-apatie - neúčast"
                ),
                PsychologyTermAnswer("Platón",
                    false,
                    "Aristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                ),
                PsychologyTermAnswer("Epikůros",
                    false,
                    "(341-270 př.kr.), antická filosofie > Hélenistická filosofie" +
                        "\n-materialista, atomy, smrtelnost duše" +
                        "\n>Blaženost< (eudaimonia)" +
                        "\n\t-Bohové se o nás nezajímají, musí se tedy postarat o naše vlastní štěstí" +
                        "\n\tRozkoš - pozitivní pocit, klid duše" +
                        "\n\t\t-i duchovní rovina (např. přátělství)" +
                        "\n\"Když člověk žije, není smrt, až přijde, nebude tu člověk\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem názoru \"Když člověk žije, není smrt, až přijde, nebude tu člověk\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Epikůros",
                    false,
                    "Epikůros (341-270 př.kr.), antická filosofie > Hélenistická filosofie" +
                        "\n-materialista, atomy, smrtelnost duše" +
                        "\n>Blaženost< (eudaimonia)" +
                        "\n\t-Bohové se o nás nezajímají, musí se tedy postarat o naše vlastní štěstí" +
                        "\n\tRozkoš - pozitivní pocit, klid duše" +
                        "\n\t\t-i duchovní rovina (např. přátělství)" +
                        "\n\"Když člověk žije, není smrt, až přijde, nebude tu člověk\""
                ),
                PsychologyTermAnswer("Pyrrhón",
                    false,
                    "Pyrrhón (360-270 př.kr.), antická filosofie > Helenistická filosofie" +
                        "\nSkepticismus" +
                        "\n\t-únava z protichůdných názorů" +
                        "\n\t-zakladatel, ovlivněn brahmány (indická filosofie), nic nenapsal, jelikož psaní bral za klam" +
                        "\n\t-zdržení se - >Epoché<" +
                        "\n\t-nejsme-li si jisti, je lepší se neangažovat a docílit stavu lhostejnosti - >Ataraxiá<" +
                        "\n\nPlatónská akademie" +
                        "\n\t>Probabilita< - k praktickému životu stačí pravděpodobnostní poznání" +
                        "\n\nAinesidémos, Sextos Empirikos (Řím)"
                ),
                PsychologyTermAnswer("Epiktétos",
                    false,
                    "Epiktétos, stoicismus" +
                        "\n\t-neřešit neřešitelné a řešit řešitelné" +
                        "\n\t-trápení nepouštět do prožívání (něco jako suprese)" +
                        "\n\t-vše má svůj důvod, naším cílem je se spokojit s tím, co máme" +
                        "\nRovnost všech lidí - proti otroctví" +
                        "\nZénón (336-264 př.kr., zakladatel)" +
                        "\nChrýsippos - vycházel z Platónismu, pozdní stoa v Římě" +
                        "\nSeneca (učitel císaře, Marcus Aurelius"
                ),
                PsychologyTermAnswer("Zénón",
                    false,
                    "Zakladatel stoicismu" +
                        "Antická filosofie > Hélenistická filosofie" +
                        "\nStoicismus:" +
                        "\nzdobné sloupí (stoa poikilé)" +
                        "\n-základ všeho je Bůh v podobě ducha (pneuma)" +
                        "\n-vše propojeno pouty sounáležitosti (sympatheia) a řízeno prozřetelností" +
                        "\n\t-pokud se nenásleduje, vzniká nemoc duše, ta je léčena >Apatheií<, z níž vzniká >Ctnost< (areté)" +
                        "\nEpiktétos" +
                        "\n\t-neřešit neřešitelné a řešit řešitelné" +
                        "\n\t-trápení nepouštět do prožívání (něco jako suprese)" +
                        "\n\t-vše má svůj důvod, naším cílem je se spokojit s tím, co máme" +
                        "\nRovnost všech lidí - proti otroctví" +
                        "\nZénón (336-264 př.kr., zakladatel)" +
                        "\nChrýsippos - vycházel z Platónismu, pozdní stoa v Římě" +
                        "\nSeneca (učitel císaře, Marcus Aurelius"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Podle koho byl Platón ovlivněn Mojžíšem?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Filóna Alexandrijského",
                    false,
                    "(15. př.kr. - 50 po kr.), antická filosofie > Helenistická filosofie > Pokračovatelé Platóna; gnóze"
                ),
                PsychologyTermAnswer("Hérakleitose",
                    false,
                    "(540-480 př.kr.), antická filosofie > předsokratovská filosofie" +
                        "\nOpak elejské školy - proměnlivost věcí" +
                        "\n\t-přeměna bytí na nebytí a naopak" +
                        "\n\t-\"Nikdy nevstoupíme do řeky dvakrát\"" +
                        "\n\t-\"Svět je věčně panoucí oheň\"" +
                        "\n>Logos< (světový zákon)" +
                        "\n\t-díky logos poznáváme harmonii světa" +
                        "\nDialektické myšlení" +
                        "\n\t-boj a jednota protikladů"
                ),
                PsychologyTermAnswer("Sofistů",
                    false,
                    "Antická filosofie > filosofie klasického období" +
                        "\n->Veřejná činnost<" +
                        "\nSubjektivismus" +
                        "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                        "\n\t-pravda je subjektivní" +
                        "\nNoetická skepce" +
                        "\n\t-nedůvěra spolehlivě poznávat svět" +
                        "\n\t-1. Nic není, 2. I kdyby, nelze to poznat, 3. I kdyby, nelze to sdělit" +
                        "\n\t-rozmělnilo se v řečnické triky - >Sofismata< (chytráčství)" +
                        "\nRelativismus" +
                        "\n\t-pravda, spravedlnost a hodnoty jsou subjektivní" +
                        "\n-Prótagorás, Gorgiás (483-375 př.kr.)"
                ),
                PsychologyTermAnswer("Anaximandrose",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátka >Apeiron< (nezměrné, neomezené)" +
                        "\nApeiron se tvaruje a následně kvůli provinění se za trest zpětně rozplyne - rozpad objektu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Gnóze je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("poznání",
                    false,
                    "Gnoseologie (Gnósis=poznání), Antická filosofie > Helénistická filosfie - rozdílné názory a soustavy, hledání smysl života"
                ),
                PsychologyTermAnswer("zdržení se",
                    false,
                    "epoché, skepticismus, antická filosofie > Helénistická filosofie"
                ),
                PsychologyTermAnswer("vedení duše",
                    false,
                    "Psychagógia, Platón"
                ),
                PsychologyTermAnswer("subjektivnost pravdy, spravedlnosti a hodnot",
                    false,
                    "relativismus, sofisté. Antická filosofie > filosofie klasického období"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Anaximandros bral za pralátku",
            textAnswer = "antická filosofie > předsokratovská filosofie",
            answers =
            listOf(
                PsychologyTermAnswer("Apeiron",
                    false,
                    "-(nezměrné, neomezené)" +
                        "\nApeiron se tvaruje a následně kvůli provinění se za trest zpětně rozplyne - rozpad objektu"
                ),
                PsychologyTermAnswer("vodu",
                    false,
                    "Thalés, božská síla (není bůh ani hmota)"
                ),
                PsychologyTermAnswer("vzduch",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nZjednodušil Anaximandrose - pralátka je neomezený vzduch (dýchání, dech)" +
                        "\nMěsíc má světlo od Slunce"
                ),
                PsychologyTermAnswer("atom",
                    false,
                    "Antičtí atomisté" +
                        "\nAntická filosofie > předsokratovská filosofie" +
                        "\nSpojení Elejské školy a Héreklitů" +
                        "\n\t-nedělitelné, věčné >Atomy<" +
                        "\n\t\t-pohybující se v prázdnotě, čili nebytí" +
                        "\n-neexistuje náhoda - >Determinismus<" +
                        "\n-Leukippos, Démokritos"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo hrál důležitou roli v šíření křesťanství do nekřesťanských oblastí?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("žid Pavel z Tarsu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Justinos",
                    false,
                    "Návaznost na antickou kulturu." +
                        "\nApologet (apologie=obrana) - potřeba bránit křestanství, jelikož bylo pronásledováno."
                ),
                PsychologyTermAnswer("Tertullianus",
                    false,
                    "Apologet, odmítal návaznost na antickou kulturu"
                ),
                PsychologyTermAnswer("Kléméns Alexandrijský",
                    false,
                    "Alexandrijská škola (filosoficko-teologická škola)" +
                        "\n-společně s Órigenés (184-254)" +
                        "\n-mystické zkušenosti, dialog s antickou a Helenistickou myšlením" +
                        "\n-spojení lásky s moudrostí, filosofie s křesťanstvím"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Hereze jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("odpadlictví a kacířství",
                    false,
                    "alternativní neautentické proudy uvnitř křesťanství"
                ),
                PsychologyTermAnswer("základní věroučné definice",
                    false,
                    "dogma"
                ),
                PsychologyTermAnswer("obrana",
                    false,
                    "apogolie"
                ),
                PsychologyTermAnswer("teorie osvícení",
                    false,
                    "iluminace - přímý vhled k podstatě - Aurelius Augustinus (354-430)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jak se nazývá období hledání pojmových vyjádření a základů křesťanství?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("období patristiky",
                    false,
                    "patres=otcové (jak byli nazývání jeho význační myslitelé) -> základ církevní tradice"
                ),
                PsychologyTermAnswer("Alexandrijská škola",
                    false,
                    "Alexandrijská škola (filosoficko-teologická škola)" +
                        "\n-Kléméns Alexandrijský (narozen před 215) a Órigenés (184-254)" +
                        "\n-mystické zkušenosti, dialog s antickou a Helenistickou myšlením" +
                        "\n-spojení lásky s moudrostí, filosofie s křesťanstvím"
                ),
                PsychologyTermAnswer("Apologetí",
                    false,
                    "(apologie=obrana) - potřeba bránit křestanství, jelikož bylo pronásledováno."
                ),
                PsychologyTermAnswer("Scholistika",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "První pokus o systematický výklad křesťanství se nazýval",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("\"O principech\"",
                    false,
                    "Středověká filosofie > křesťanství > Alexandrijská škola" +
                        "\nÓrigenés (185-254)" +
                        "\n-byla aplikována Platónská východiska" +
                        "\n-Logos se vtělil v Kristu a vše vede ke spáse veškerenstva (apokatastis), bude proměněno i zlo"
                ),
                PsychologyTermAnswer("\"Útěcha z filosofie\"",
                    false,
                    "Boethius(480-525) se čistě filosoficky vypořádává s lidskými otázkami utrpení a smrti" +
                        "\nStředověká filosofie > Raná Scholastika"
                ),
                PsychologyTermAnswer("\"O Boží obci\"",
                    false,
                    "Aurelius Augustinus. Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("\"Vyznání\"",
                    false,
                    "Biografie o Aureliu Augustinu (354-430)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kniha obsahující filosoficky odpovězené lidské otázky utrpení a smrti",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("\"O principech\"",
                    false,
                    "Středověká filosofie > křesťanství > Alexandrijská škola" +
                        "\nÓrigenés (185-254)" +
                        "\n-byly aplikovány Platónské východiska" +
                        "\n-Logos se vtělil v Kristu a vše vede ke spáse veškerenstva (apokatastis), bude proměněno i zlo"
                ),
                PsychologyTermAnswer("\"Útěcha z filosofie\"",
                    false,
                    "Boethius(480-525) se čistě filosoficky vypořádává s lidskými otázkami utrpení a smrti" +
                        "\nStředověká filosofie > Raná Scholastika"
                ),
                PsychologyTermAnswer("\"O Boží obci\"",
                    false,
                    "Aurelius Augustinus. Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("\"Vyznání\"",
                    false,
                    "Biografie o Aureliu Augustinu (354-430)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Co je podle Alexandrijské školy konečné zavřšení země?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("spása veškerenstva",
                    false,
                    "Órigenés (185-254) \"O principech\""
                ),
                PsychologyTermAnswer("smrt všeho",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vtělení atman do brahma",
                    false,
                    "-mokšá" +
                        "\nindická filosofie > Karman"
                ),
                PsychologyTermAnswer("návrat do světa (říše) idejí",
                    false,
                    "Platón"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo na konci období patristiky (4. st.) prosazoval, že Kristus je pouhý člověk?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Aria (336)",
                    false,
                    "středověká filosofie > křesťanství > patristika, souboj s herezemi" +
                        "\nKristus je pouhý člověk" +
                        "\ndogma - zákl. věroučné definice"
                ),
                PsychologyTermAnswer("Athanasios (373)",
                    false,
                    "vystoupil proti arianismu"
                ),
                PsychologyTermAnswer("Basileos (330-379)",
                    false,
                    "kappadocký trojice otců Grégorios z Nyssy (325-394), Grégorios z Nazianzu (330-390)," +
                        " Basileos (330-379)" +
                        "\n\t-pokračovatelé Órigenése - otevřenost vůči kultuře"
                ),
                PsychologyTermAnswer("Grégorios z Nyssy (325-394)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Grégorios z Nazianzu (330-390)",
                    false,
                    "psal poezii"
                ),
                PsychologyTermAnswer("Ióannés Chrýstostomos (344-407)",
                    false,
                    "-konkrétní otázky křesťanské etiky (umřel na vyhnanství)" +
                        "\n\t-neudržitelnost sociální nespravedlnosti" +
                        "\n\t-nemravný původ veškerého bohatství" +
                        "\n\t-rovnost všech lidí"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Knihu \"O Boží obci\" napsal",
            textAnswer = "Aurelius Augustinus. Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová).",
            answers =
            listOf(
                PsychologyTermAnswer("Aurelius Augustinus (354-430)",
                    false,
                    "Středověká filosofie > křesťanství. Také napsal autobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("Aria (336)",
                    false,
                    "středověká filosofie > křesťanství > patristika, souboj s herezemi" +
                        "\nKristus je pouhý člověk" +
                        "\ndogma - zákl. věroučné definice"
                ),
                PsychologyTermAnswer("Athanasios (373)",
                    false,
                    "vystoupil proti arianismu"
                ),
                PsychologyTermAnswer("Basileos (330-379)",
                    false,
                    "kappadocký trojice otců Grégorios z Nyssy (325-394), Grégorios z Nazianzu (330-390)," +
                        " Basileos (330-379)" +
                        "\n\t-pokračovatelé Órigenése - otevřenost vůči kultuře"
                ),
                PsychologyTermAnswer("Grégorios z Nyssy (325-394)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Grégorios z Nazianzu (330-390)",
                    false,
                    "psal poezii"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tři způsoby jak se propracovat k poznání Boží existence popsal",
            textAnswer = "1. ptát se světa, který vyjeví svou příčinu" +
                "\n2. hledat v sobě, kde můžeme nalézt božské rysy (pravdu, lásku)" +
                "\n3. překročení veškeré skutečnosti",
            answers =
            listOf(
                PsychologyTermAnswer("Aurelius Augustinus (354-430)",
                    false,
                    "Středověká filosofie > křesťanství. Také napsal autobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("Aria (336)",
                    false,
                    "středověká filosofie > křesťanství > patristika, souboj s herezemi" +
                        "\nKristus je pouhý člověk" +
                        "\ndogma - zákl. věroučné definice"
                ),
                PsychologyTermAnswer("Athanasios (373)",
                    false,
                    "vystoupil proti arianismu"
                ),
                PsychologyTermAnswer("Basileos (330-379)",
                    false,
                    "kappadocký trojice otců Grégorios z Nyssy (325-394), Grégorios z Nazianzu (330-390)," +
                        " Basileos (330-379)" +
                        "\n\t-pokračovatelé Órigenése - otevřenost vůči kultuře"
                ),
                PsychologyTermAnswer("Grégorios z Nyssy (325-394)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Grégorios z Nazianzu (330-390)",
                    false,
                    "psal poezii"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. negativní cestu poznání vytvořil",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Dionýsios Areopagita (5. st.)",
                    false,
                    "Pouze psedonym, je to anonym" +
                        "\n-novoplatónik, uspořádání organizace církve" +
                        "\n-Bůh dá poznat ve zkušenosti duchovního života a modlitby" +
                        "\nnegativní (apofatická) cesta poznání" +
                        "\n\t-žádný pojem, žádná představa nemohou postihnout nepostižitelného"
                ),
                PsychologyTermAnswer("Aurelius Augustinus (354-430)",
                    false,
                    "Středověká filosofie > křesťanství. Také napsal autobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("Aria (336)",
                    false,
                    "středověká filosofie > křesťanství > patristika, souboj s herezemi" +
                        "\nKristus je pouhý člověk" +
                        "\ndogma - zákl. věroučné definice"
                ),
                PsychologyTermAnswer("Athanasios (373)",
                    false,
                    "vystoupil proti arianismu"
                ),
                PsychologyTermAnswer("Basileos (330-379)",
                    false,
                    "kappadocká trojice otců Grégorios z Nyssy (325-394), Grégorios z Nazianzu (330-390)," +
                        " Basileos (330-379)" +
                        "\n\t-pokračovatelé Órigenése - otevřenost vůči kultuře"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce rané scholastiky nespadá",
            textAnswer = "Středověká filosofie, (8.-12. st.)",
            answers =
            listOf(
                PsychologyTermAnswer("Aurelius Augustinus",
                    false,
                    "(354-430), Středověká filosofie > křesťanství. " +
                        "\nAutobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("Boethius",
                    false,
                    "(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti"
                ),
                PsychologyTermAnswer("Anselm",
                    false,
                    "(1033-1109), italský mnich, arcibiskup, středověká filosofie > raná scholastika" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce"
                ),
                PsychologyTermAnswer("nominalisté",
                    false,
                    "ve sporu o univerzálie (obecné pojmy) tvrdí, že pojmy jsou pouze jména (nomina) věcí, ale nereprezentují nutně reálné věci."
                ),
                PsychologyTermAnswer("Pierre Abélard",
                    false,
                    "(1079-1142), středověká filosofie > raná scholastika" +
                        "\nznám láskou k Héloise" +
                        "\n-kompromisní řešení na spor univerzálií, úmysl předchází a doprovází čin" +
                        "\n-rozumová metoda postavena na protichůdná stanoviska (ano i ne) a rozum hledá závěr"
                ),
                PsychologyTermAnswer("Bernard z Clairvaux",
                    false,
                    "(1091-1153), středověká filosofie > raná scholastika" +
                        "\nprotireákce na jednostranný důraz na rozum" +
                        "\n\t-zkušenost, láska, vztah k Bohu a lidem"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce rané scholastiky nespadá",
            textAnswer = "Středověká filosofie, (13. st.)",
            answers =
            listOf(
                PsychologyTermAnswer("František z Assisi",
                    false,
                    "(1182-1226), Středověká filosofie > Vrcholná scholastika. " +
                        "\n-Františkánské hnutí (později mnišský řád)" +
                        "\n\t-pokus o návrat k původním hodnotám křesťanství, chudoby a lásce k člověku"
                ),
                PsychologyTermAnswer("Boethius",
                    false,
                    "(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti"
                ),
                PsychologyTermAnswer("Anselm",
                    false,
                    "(1033-1109), italský mnich, arcibiskup, středověká filosofie > raná scholastika" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce"
                ),
                PsychologyTermAnswer("Pierre Abélard",
                    false,
                    "(1079-1142), středověká filosofie > raná scholastika" +
                        "\nznám láskou k Héloise" +
                        "\n-kompromisní řešení na spor univerzálií, úmysl předchází a doprovází čin" +
                        "\n-rozumová metoda postavena na protichůdná stanoviska (ano i ne) a rozum hledá závěr"
                ),
                PsychologyTermAnswer("Bernard z Clairvaux",
                    false,
                    "(1091-1153), středověká filosofie > raná scholastika" +
                        "\nprotireákce na jednostranný důraz na rozum" +
                        "\n\t-zkušenost, láska, vztah k Bohu a lidem"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Spor o univerzálie (obecné pojmy) znamená",
            textAnswer = "Spor mezi platónovci (realisti) a aristotelci (abstrakce, nominalisté), nakonec spor Boha a člověka." +
                "\nBez modelů a hodnot docházíme k relativismu - pravda, spravedlnost, hodnoty jsou subjektivní.",
            answers =
            listOf(
                PsychologyTermAnswer("zdali pojmy reprezentují reálné konkrétní skutečnosti",
                    false,
                    "nebo se jedná o modely v Boží mysli nebo Platónovy ideje." +
                        "\nNominalisté (nomina=jména) tvrdí, že se jedná o pouhé jména věcí." +
                        "\nRealisté tvrdí, že v Boží mysli jsou modely"
                ),
                PsychologyTermAnswer("zdali má Bůh člověčí formu",
                    false,
                    "antromorfního náboženství"
                ),
                PsychologyTermAnswer("zdali je Bůh nehybný",
                    false,
                    "Antická filosofie > Předsokratovská filosofie > Elejská škola" +
                        "\n-Xenofanés, Parmenidés, Zénón"
                ),
                PsychologyTermAnswer("zdali je člověk dobrý, racionální a nepotřebuje asistenci autority",
                    false,
                    "Mencius (372-289 př. kr.)" +
                        "\n\t-přirozená dobrota člověka (opak co prosazovali ostatní v Číně)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vrcholnou scholastiku (13.st.) můžeme shrnout jako spor dvou proudů",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("františkánské hnutí a dominikáni",
                    false,
                    "-Františkánské hnutí (později mnišský řád)" +
                        "\n\t-pokus o návrat k původním hodnotám křesťanství, chudoby a lásce k člověku" +
                        "\n\nDominikánské" +
                        "\n\t-vědecká práce a osvěta lidu"
                ),
                PsychologyTermAnswer("platónovci a aristotelci",
                    false,
                    "spor o univerzálie (obecné pojmy) v Rané scholistice" +
                        "\n\t-vztahují se pojmy v Boží mysli nebo Platónovy idejích na konkrétní věci jako strom, člověk, kůň?" +
                        "\n\t-spor mezi platónovci (realisti) a aristotelci (abstrakce), nakonec spor Boha a člověka." +
                    "\n\t-bez modelů a hodnot docházíme k relativismu - pravda, spravedlnost, hodnoty jsou subjektivní."
                ),
                PsychologyTermAnswer("Anaximandrose a Pýthagoráse",
                    false,
                    "spor o Hýlozoistice (hýlé=hmota, zoé=život)" +
                        "\n-Pralátce >Apeiron< (nezměrné, neomezené), kterou přednešl Anaximandros"
                ),
                PsychologyTermAnswer("souboj herezá a ariasmu",
                    false,
                    "Středoveká filosofie > Křesťanství" +
                        "\nAria ve vrcholném období patristiky (4.st.) prosazoval, že Kristus je pouhý člověk, na druhé straně je heréze -" +
                        "alternativní neautentické proudy uvnitř křesťanství (odpadlictví a kacířství)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo pojal život jako cestu k Bohu?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Bonaventura (Jan Fidanza) (1221-1274)",
                    false,
                    "Středověká Filosofie > Vrcholná scholastika" +
                        "\n\t-spor františkánského hnutí a dominikánů (aristotelská filosofie), Bonaventura byl františkán" +
                        "\n-Člověk poznává Boha v přírodě i ve svém nitru, každé poznávání je odhalování Boha" +
                        "\n-Priorita vůle před rozumem - nejprve toužíme a chceme poznat"
                ),
                PsychologyTermAnswer("Albert Veliký (1193-1280)",
                    false,
                    "Dominikán, filosof i přírodovědec, experimentální metoda"
                ),
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                ),
                PsychologyTermAnswer("Jan Duns Scotus (1264-1308)",
                    false,
                    "skotský mnich, Pozdní scholastika" +
                        "\n-syntéza T.e Akvinského a františkánské školy" +
                        "\n-intuitivní zkušenostní poznání"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Teorie analogia entis byla vytvořena filosofem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                ),
                PsychologyTermAnswer("Jan Duns Scotus (1264-1308)",
                    false,
                    "skotský mnich, Pozdní scholastika" +
                        "\n-syntéza T.e Akvinského a františkánské školy" +
                        "\n-intuitivní zkušenostní poznání"
                ),
                PsychologyTermAnswer("William Occam (1300-1350)",
                    false,
                    "William Occam (1300-1350)" +
                        "\nPozdní scholastika, považován za posledního scholastika" +
                        "\n-oddělil filosofii od teologie" +
                        "\n\t-to, co je řečeno o světě, neplatí o Bohu" +
                        "\n-ve sporu realismus-nominalismus (Spor o univerzálie) byl nominalista (nomina=jména)"
                ),
                PsychologyTermAnswer("Mistr Eckhart (1260-1327)",
                    false,
                    "Pozdní scholastika, němec" +
                        "\n-hranice racionality, význam srdce, kontemplace, oddanosti"
                ),
                PsychologyTermAnswer("T. Kempenský (1380-1471)",
                    false,
                    "Pozdní scholastika" +
                        "\n-Nová zbožnost (devotio moderna) - \"Následování Krista\" jehož je autor"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Významně oddělil filosofii od teologie",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("William Occam (1300-1350)",
                    false,
                    "William Occam (1300-1350)" +
                        "\nPozdní scholastika, považován za posledního scholastika" +
                        "\n-oddělil filosofii od teologie" +
                        "\n\t-to, co je řečeno o světě, neplatí o Bohu" +
                        "\n-ve sporu realismus-nominalismus (Spor o univerzálie) byl nominalista (nomina=jména)"
                ),
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                ),
                PsychologyTermAnswer("Jan Duns Scotus (1264-1308)",
                    false,
                    "skotský mnich, Pozdní scholastika" +
                        "\n-syntéza T.e Akvinského a františkánské školy" +
                        "\n-intuitivní zkušenostní poznání"
                ),
                PsychologyTermAnswer("Mistr Eckhart (1260-1327)",
                    false,
                    "Pozdní scholastika, němec" +
                        "\n-hranice racionality, význam srdce, kontemplace, oddanosti"
                ),
                PsychologyTermAnswer("T. Kempenský (1380-1471)",
                    false,
                    "Pozdní scholastika" +
                        "\n-Nová zbožnost (devotio moderna) - \"Následování Krista\" jehož je autor"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Následování Krista\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("T. Kempenský (1380-1471)",
                    false,
                    "Pozdní scholastika" +
                        "\n-Nová zbožnost (devotio moderna) - \"Následování Krista\" jehož je autor"
                ),
                PsychologyTermAnswer("William Occam (1300-1350)",
                    false,
                    "William Occam (1300-1350)" +
                        "\nPozdní scholastika, považován za posledního scholastika" +
                        "\n-oddělil filosofii od teologie" +
                        "\n\t-to, co je řečeno o světě, neplatí o Bohu" +
                        "\n-ve sporu realismus-nominalismus (Spor o univerzálie) byl nominalista (nomina=jména)"
                ),
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                ),
                PsychologyTermAnswer("Jan Duns Scotus (1264-1308)",
                    false,
                    "skotský mnich, Pozdní scholastika" +
                        "\n-syntéza T.e Akvinského a františkánské školy" +
                        "\n-intuitivní zkušenostní poznání"
                ),
                PsychologyTermAnswer("Mistr Eckhart (1260-1327)",
                    false,
                    "Pozdní scholastika, němec" +
                        "\n-hranice racionality, význam srdce, kontemplace, oddanosti"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Byl William Occam ve sporu o univerzálie nominalista či realista?",
            textAnswer = "William Occam (1300-1350)" +
                "\nPozdní scholastika, považován za posledního scholastika" +
                "\n-oddělil filosofii od teologie" +
                "\n\t-to, co je řečeno o světě, neplatí o Bohu" +
                "\n-ve sporu realismus-nominalismus (Spor o univerzálie) byl nominalista (nomina=jména)",
            answers =
            listOf(
                PsychologyTermAnswer("nominalista",
                    false,
                    ""
                ),
                PsychologyTermAnswer("realista",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Occam se v období scholastika neobjevuje",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ani jedno, snažil se oba směry spojit",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ve scholastice vznikl směr oddělující se od racionální scholistiky, jmenuje se",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("nová zbožnost",
                    false,
                    "Rysy popsány v knize \"Následování Krista\", autorství připisováno T.i Kempenskému (1380-1471)"
                ),
                PsychologyTermAnswer("stará zbožnost",
                    false,
                    ""
                ),
                PsychologyTermAnswer("nominalismus",
                    false,
                    "Ve sporu o univerzálie (obecné pojmy) tvrdí, že pojmy jsou pouze jména (nomina) věcí, ale nereprezentují nutně reálné věci."
                ),
                PsychologyTermAnswer("františkánské hnutí",
                    false,
                    "František z Assisi (1182-1226), Středověká filosofie > Vrcholná scholastika. " +
                        "\n-Františkánské hnutí (později mnišský řád)" +
                        "\n\t-pokus o návrat k původním hodnotám křesťanství, chudoby a lásce k člověku" +
                        "\nspor mezi františkány (teologie) a dominikány (racionalismus)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Teologické sumě\" napsal",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                ),
                PsychologyTermAnswer("Basileos (330-379)",
                    false,
                    "kappadocký trojice otců Grégorios z Nyssy (325-394), Grégorios z Nazianzu (330-390)," +
                        " Basileos (330-379)" +
                        "\n\t-pokračovatelé Órigenése - otevřenost vůči kultuře"
                ),
                PsychologyTermAnswer("Dionýsios Areopagita (5. st.)",
                    false,
                    "Pouze psedonym, je to anonym" +
                        "\n-novoplatónik, uspořádání organizace církve" +
                        "\n-Bůh dá poznat ve zkušenosti duchovního života a modlitby" +
                        "\nnegativní (apofatická) cesta poznání" +
                        "\n\t-žádný pojem, žádná představa nemohou postihnout nepostižitelného"
                ),
                PsychologyTermAnswer("Aurelius Augustinus (354-430)",
                    false,
                    "Středověká filosofie > křesťanství. Také napsal autobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Proti pohanům\" napsal",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                ),
                PsychologyTermAnswer("Anselm",
                    false,
                    "(1033-1109), italský mnich, arcibiskup, středověká filosofie > raná scholastika" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce"
                ),
                PsychologyTermAnswer("Pierre Abélard",
                    false,
                    "(1079-1142), středověká filosofie > raná scholastika" +
                        "\nznám láskou k Héloise" +
                        "\n-kompromisní řešení na spor univerzálií, úmysl předchází a doprovází čin" +
                        "\n-rozumová metoda postavena na protichůdná stanoviska (ano i ne) a rozum hledá závěr"
                ),
                PsychologyTermAnswer("Bernard z Clairvaux",
                    false,
                    "(1091-1153), středověká filosofie > raná scholastika" +
                        "\nprotireákce na jednostranný důraz na rozum" +
                        "\n\t-zkušenost, láska, vztah k Bohu a lidem"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zakladatel islámu byl",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Muhammad",
                    false,
                    "(571-632), sjednotil arabské pouštní kmeny" +
                        "\nIslám se nesblížil s antikou -> krátké arabské filosofické období (1. polovina 9.st do 12.st)"
                ),
                PsychologyTermAnswer("Mojžíš",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Lao-c'",
                    false,
                    "zakladatel taoismu"
                ),
                PsychologyTermAnswer("Zénón",
                    false,
                    "Zakladatel stoicismu" +
                        "Antická filosofie > Hélenistická filosofie" +
                        "\nStoicismus:" +
                        "\nzdobné sloupí (stoa poikilé)" +
                        "\n-základ všeho je Bůh v podobě ducha (pneuma)" +
                        "\n-vše propojeno pouty sounáležitosti (sympatheia) a řízeno prozřetelností" +
                        "\n\t-pokud se nenásleduje, vzniká nemoc duše, ta je léčena >Apatheií<, z níž vzniká >Ctnost< (areté)" +
                        "\nEpiktétos" +
                        "\n\t-neřešit neřešitelné a řešit řešitelné" +
                        "\n\t-trápení nepouštět do prožívání (něco jako suprese)" +
                        "\n\t-vše má svůj důvod, naším cílem je se spokojit s tím, co máme" +
                        "\nRovnost všech lidí - proti otroctví" +
                        "\nZénón (336-264 př.kr., zakladatel)" +
                        "\nChrýsippos - vycházel z Platónismu, pozdní stoa v Římě" +
                        "\nSeneca (učitel císaře, Marcus Aurelius"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Arabská filosofie trvala v období",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("1. polovina 9.st do 12.st",
                    false,
                    "Arabská filosofie" +
                        "\nkrátké období, jelikož nedošlo k harmonizaci teologie s filosofií" +
                        "\nIslám se nesblížil s antikou, snaha sloučit Platónovo a Aristotelovo učení" +
                        "\nal-Farábí (872-950), Avicenna, Averroes, Maimonides (Moše ben Maimon), Jehudy ben Becalela (Rabbi Low)"
                ),
                PsychologyTermAnswer("6.-4.st. př.kr.",
                    false,
                    "Antická filosofie > Předsokratovské filosofie > Mílétská škola" +
                        "\n\t-Thalés, Anaximandros, Anaximenés" +
                        "\nPýthagorás, " +
                        "\nElejská škola" +
                        "\n\t-Xenofanés, Parmenidés, Zénón" +
                        "\nHérakleitos, " +
                        "\nAntičtí atomisté" +
                        "\n\t-Leukippos, Démokritos" +
                        "\nEmpedoklés, Anaxagorás"
                ),
                PsychologyTermAnswer("5-4.st. př.kr.",
                    false,
                    "Antická filosofie > Období klasické filosofie" +
                        "\nSofisté" +
                        "\n\t-Prótagorás, Gorgiás" +
                        "\nSókratés" +
                        "\nPlatón" +
                        "\nAristotelés"
                ),
                PsychologyTermAnswer("4. st. př.kr - 529 po kr.",
                    false,
                    "Antická filosofie > Helénistická filosofie" +
                        "\nEpikúros" +
                        "\nStoicismus" +
                        "\n\t-Zénón, Chrýsippos, Seneca, Epiktétos, Marcus Aurelius" +
                        "\nSkepticismus" +
                        "\n\t-Pyrrhón" +
                        "\n\t-Probabilismus" +
                        "\n\t-Ainesidémos, Sextos, Empirikos" +
                        "\nPokračovatelé Platónovi; gnóze" +
                        "\n\t-Plútarchos, Núménios, Filón Alexandrijský, Ammónios Sakkás, Plótínos, Porfyrios, Plótínus"
                ),
                PsychologyTermAnswer("8.st - 12. st po kr.",
                    false,
                    "Raná scholastika" +
                        "\nBoethius" +
                        "\n(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti" +
                        "\n\nAnselm" +
                        "\n(1033-1109), italský mnich, arcibiskup" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce" +
                        "\n\nNominalisté" +
                        "\n-ve sporu o univerzálie (obecné pojmy) tvrdí, že pojmy jsou pouze jména (nomina) věcí, ale nereprezentují nutně reálné věci." +
                        "\n\nPierre Abélard" +
                        "\n(1079-1142), znám láskou k Héloise" +
                        "\n-kompromisní řešení na spor univerzálií, úmysl předchází a doprovází čin" +
                        "\n-rozumová metoda postavena na protichůdná stanoviska (ano i ne) a rozum hledá závěr" +
                        "\n\nBernard z Clairvaux" +
                        "\n(1091-1153), protireákce na jednostranný důraz na rozum" +
                        "\n\t-zkušenost, láska, vztah k Bohu a lidem"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Snaha spojit Platónovo a Aristotelovo učení je typické pro",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Arabskou filosofii",
                    false,
                    "Arabská filosofie" +
                        "\nkrátké období, jelikož nedošlo k harmonizaci teologie s filosofií" +
                        "\nIslám se nesblížil s antikou, snaha sloučit Platónovo a Aristotelovo učení" +
                        "\nal-Farábí (872-950), Avicenna, Averroes, Maimonides (Moše ben Maimon), Jehudy ben Becalela (Rabbi Low)"
                ),
                PsychologyTermAnswer("Sofisty",
                    false,
                    "Antická filosofie > filosofie klasického období" +
                        "\n->Veřejná činnost<" +
                        "\nSubjektivismus" +
                        "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                        "\n\t-pravda je subjektivní" +
                        "\nNoetická skepce" +
                        "\n\t-nedůvěra spolehlivě poznávat svět" +
                        "\n\t-1. Nic není, 2. I kdyby, nelze to poznat, 3. I kdyby, nelze to sdělit" +
                        "\n\t-rozmělnilo se v řečnické triky - >Sofismata< (chytráčství)" +
                        "\nRelativismus" +
                        "\n\t-pravda, spravedlnost a hodnoty jsou subjektivní" +
                        "\n-Prótagorás, Gorgiás (483-375 př.kr.)"
                ),
                PsychologyTermAnswer("Mílétskou školu",
                    false,
                    "Hýlozoisté (hýlé=hmota, zoé=život)" +
                        "\n-Thalés (voda), Anaximandros (Apeiron), Anaximenés (vzduch)"
                ),
                PsychologyTermAnswer("Ranou scholistiku",
                    false,
                    "Raná scholastika" +
                        "\nBoethius" +
                        "\n(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti" +
                        "\n\nAnselm" +
                        "\n(1033-1109), italský mnich, arcibiskup" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce" +
                        "\n\nNominalisté" +
                        "\n-ve sporu o univerzálie (obecné pojmy) tvrdí, že pojmy jsou pouze jména (nomina) věcí, ale nereprezentují nutně reálné věci." +
                        "\n\nPierre Abélard" +
                        "\n(1079-1142), znám láskou k Héloise" +
                        "\n-kompromisní řešení na spor univerzálií, úmysl předchází a doprovází čin" +
                        "\n-rozumová metoda postavena na protichůdná stanoviska (ano i ne) a rozum hledá závěr" +
                        "\n\nBernard z Clairvaux" +
                        "\n(1091-1153), protireákce na jednostranný důraz na rozum" +
                        "\n\t-zkušenost, láska, vztah k Bohu a lidem"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce arabské filosofie nepatří",
            textAnswer = "Arabská filosofie" +
                "\nkrátké období, jelikož nedošlo k harmonizaci teologie s filosofií" +
                "\nIslám se nesblížil s antikou, snaha sloučit Platónovo a Aristotelovo učení" +
                "\nal-Farábí (872-950), Avicenna (Ibn Síná), Averroes (Ibn Rušd), Maimonides (Moše ben Maimon), Jehudy ben Becalela (Rabbi Low)",
            answers =
            listOf(
                PsychologyTermAnswer("Anselm",
                    false,
                    "(1033-1109), italský mnich, arcibiskup" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce"
                ),
                PsychologyTermAnswer("al-Farábí",
                    false,
                    "(872-950), významný překladatel a komentátor Aristotela" +
                        "\nRozlišení mezi bytností (esencí) věci a jeho existencí" +
                        "\n\t-mezi tím, co dělá věc vecí (co činí židli židlí) a tím, co je konkrétním projevem esence (židle, na které sedím - existuje)" +
                        "\n\t-T. Akvinský se tímto inspiroval"
                ),
                PsychologyTermAnswer("Avicenna",
                    false,
                    "(Ibn Síná, 980-1037), nejvýznamnější islámského Východu" +
                        "\nRozvíjel Aristotelovo učení o látce a formě" +
                        "\n\t-svět je věčný, Bůh tvoří nové formy" +
                        "\nCílem člověka je dokonalé poznání"
                ),
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("Maimonides",
                    false,
                    "(Moše ben Maimon, 1135-1204)" +
                        "\n-Židovská filosofie" +
                        "\n-není zásadní rozdíl mezi Aristotelem a biblí"
                ),
                PsychologyTermAnswer("Jehuda ben Becalela",
                    false,
                    "(Rabbi Low, 1512-1609)" +
                        "\n-díky němu se stala Praha významným centrem kabalistických studií"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce arabské filosofie nepatří",
            textAnswer = "Arabská filosofie" +
                "\nkrátké období, jelikož nedošlo k harmonizaci teologie s filosofií" +
                "\nIslám se nesblížil s antikou, snaha sloučit Platónovo a Aristotelovo učení" +
                "\nal-Farábí (872-950), Avicenna (Ibn Síná), Averroes (Ibn Rušd), Maimonides (Moše ben Maimon), Jehudy ben Becalela (Rabbi Low)",
            answers =
            listOf(
                PsychologyTermAnswer("Aurelius Augustinus",
                    false,
                    "Středověká filosofie > křesťanství. Také napsal autobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("al-Farábí",
                    false,
                    "(872-950), významný překladatel a komentátor Aristotela" +
                        "\nRozlišení mezi bytností (esencí) věci a jeho existencí" +
                        "\n\t-mezi tím, co dělá věc vecí (co činí židli židlí) a tím, co je konkrétním projevem esence (židle, na které sedím - existuje)" +
                        "\n\t-T. Akvinský se tímto inspiroval"
                ),
                PsychologyTermAnswer("Avicenna",
                    false,
                    "(Ibn Síná, 980-1037), nejvýznamnější islámského Východu" +
                        "\nRozvíjel Aristotelovo učení o látce a formě" +
                        "\n\t-svět je věčný, Bůh tvoří nové formy" +
                        "\nCílem člověka je dokonalé poznání"
                ),
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("Maimonides",
                    false,
                    "(Moše ben Maimon, 1135-1204)" +
                        "\n-Židovská filosofie" +
                        "\n-není zásadní rozdíl mezi Aristotelem a biblí"
                ),
                PsychologyTermAnswer("Jehuda ben Becalela",
                    false,
                    "(Rabbi Low, 1512-1609)" +
                        "\n-díky němu se stala Praha významným centrem kabalistických studií"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Komu se v Evropě říkalo \"Komentátor\"?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("Aurelius Augustinus (354-430)",
                    false,
                    "Středověká filosofie > křesťanství. Také napsal autobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("al-Farábí",
                    false,
                    "(872-950), významný překladatel a komentátor Aristotela" +
                        "\nRozlišení mezi bytností (esencí) věci a jeho existencí" +
                        "\n\t-mezi tím, co dělá věc vecí (co činí židli židlí) a tím, co je konkrétním projevem esence (židle, na které sedím - existuje)" +
                        "\n\t-T. Akvinský se tímto inspiroval"
                ),
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Křesťanský averroismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("teorie dvojí pravdy",
                    false,
                    "Křesťanský averroismus - pravda vědy a pravda víry" +
                        "\nAverroes" +
                        "\n(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("islámská mystika",
                    false,
                    "Súfismus"
                ),
                PsychologyTermAnswer("židovská mystika",
                    false,
                    "Kabala" +
                        "\n\t-rozvinula učení Tóry (posvátné písmo judaismu) o stvoření světa" +
                        "\n\t-deset sefírů - duchovní sféry" +
                        "\n\t-nejen o harmonii, ale i o katastrofě (dobro i zlo)"
                ),
                PsychologyTermAnswer("posvátné písmo judaismu",
                    false,
                    "Tóra"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Súfismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("islámská mystika",
                    false,
                    "Súfismus"
                ),
                PsychologyTermAnswer("teorie dvojí pravdy",
                    false,
                    "Křesťanský averroismus - pravda vědy a pravda víry" +
                        "\nAverroes" +
                        "\n(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("židovská mystika",
                    false,
                    "Kabala" +
                        "\n\t-rozvinula učení Tóry (posvátné písmo judaismu) o stvoření světa" +
                        "\n\t-deset sefírů - duchovní sféry" +
                        "\n\t-nejen o harmonii, ale i o katastrofě (dobro i zlo)"
                ),
                PsychologyTermAnswer("posvátné písmo judaismu",
                    false,
                    "Tóra"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce židovské filosofie nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("al-Farábí",
                    false,
                    "(872-950), významný překladatel a komentátor Aristotela" +
                        "\nRozlišení mezi bytností (esencí) věci a jeho existencí" +
                        "\n\t-mezi tím, co dělá věc vecí (co činí židli židlí) a tím, co je konkrétním projevem esence (židle, na které sedím - existuje)" +
                        "\n\t-T. Akvinský se tímto inspiroval"
                ),
                PsychologyTermAnswer("Maimonides",
                    false,
                    "(Moše ben Maimon, 1135-1204)" +
                        "\n-Židovská filosofie" +
                        "\n-není zásadní rozdíl mezi Aristotelem a biblí"
                ),
                PsychologyTermAnswer("Jehuda ben Becalela",
                    false,
                    "(Rabbi Low, 1512-1609)" +
                        "\n-díky němu se stala Praha významným centrem kabalistických studií"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kabala je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("židovská mystika",
                    false,
                    "Kabala" +
                        "\n\t-rozvinula učení Tóry (posvátné písmo judaismu) o stvoření světa" +
                        "\n\t-deset sefírů - duchovní sféry" +
                        "\n\t-nejen o harmonii, ale i o katastrofě (dobro i zlo)"
                ),
                PsychologyTermAnswer("islámská mystika",
                    false,
                    "Súfismus"
                ),
                PsychologyTermAnswer("posvátné písmo judaismu",
                    false,
                    "Tóra"
                ),
                PsychologyTermAnswer("Buddhovo učení",
                    false,
                    "Dharma"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Posvátné písmo judaismu se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Tóry",
                    false,
                    "Judaismus"
                ),
                PsychologyTermAnswer("Bible",
                    false,
                    "Křesťanství"
                ),
                PsychologyTermAnswer("I-Ťing",
                    false,
                    "Čína"
                ),
                PsychologyTermAnswer("Dharma",
                    false,
                    "Buddhovo učení"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Deset safírů v Židovské filosofii jsou",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("duchovní sféry",
                    false,
                    ""
                ),
                PsychologyTermAnswer("myšlenka dualismu v Tóře",
                    false,
                    ""
                ),
                PsychologyTermAnswer("rovnost poznání rozumu i víry",
                    false,
                    ""
                ),
                PsychologyTermAnswer("židovské děditství",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Díky komu se stala Praha významným centrem Kabalistických studií?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jehuda ben Becalela",
                    false,
                    "(Rabbi Low, 1512, 1609)"
                ),
                PsychologyTermAnswer("al-Farábí",
                    false,
                    "(872-950), významný překladatel a komentátor Aristotela" +
                        "\nRozlišení mezi bytností (esencí) věci a jeho existencí" +
                        "\n\t-mezi tím, co dělá věc vecí (co činí židli židlí) a tím, co je konkrétním projevem esence (židle, na které sedím - existuje)" +
                        "\n\t-T. Akvinský se tímto inspiroval"
                ),
                PsychologyTermAnswer("Avicenna",
                    false,
                    "(Ibn Síná, 980-1037), nejvýznamnější islámského Východu" +
                        "\nRozvíjel Aristotelovo učení o látce a formě" +
                        "\n\t-svět je věčný, Bůh tvoří nové formy" +
                        "\nCílem člověka je dokonalé poznání"
                ),
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("Maimonides",
                    false,
                    "(Moše ben Maimon, 1135-1204)" +
                        "\n-Židovská filosofie" +
                        "\n-není zásadní rozdíl mezi Aristotelem a biblí"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Renesance znamená",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("znovuzrození",
                    false,
                    ""
                ),
                PsychologyTermAnswer("probuzení",
                    false,
                    ""
                ),
                PsychologyTermAnswer("návrat k bohu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("lidskost",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zastupitel humanismu byl v době Renesance",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Erasmus Rotterdamský",
                    false,
                    "(1465-1536)" +
                        "\nHumanismus (lidské, nenáboženské)" +
                        "\n-spojen s učenci a vzdělanci, antika" +
                        "\n->Florentská Akademie<"
                ),
                PsychologyTermAnswer("Jan Hus",
                    false,
                    "protestantismus, Reformace - náprava náboženství," +
                        "\n-církev nemá být zkorumpovaná - vnitřní opravdovost věřícího - \"přítelkyně pravda\""
                ),
                PsychologyTermAnswer("Martin Luther",
                    false,
                    "německá Reformace, protestantismus" +
                        "\n-slovo Boží třeba přijímat přímo srdcem, bez církve"
                ),
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Přítelkyně pravda\" je spojována s",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jan Hus",
                    false,
                    "protestantismus, renesanční filosofie >Reformace< - náprava náboženství," +
                        "\n-církev nemá být zkorumpovaná - vnitřní opravdovost věřícího - \"přítelkyně pravda\""
                ),
                PsychologyTermAnswer("Martin Luther",
                    false,
                    "německá >Reformace<, renesanční filosofie, protestantismus" +
                        "\n-slovo Boží třeba přijímat přímo srdcem, bez církve"
                ),
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("Erasmus Rotterdamský",
                    false,
                    "(1465-1536)" +
                        "\nHumanismus (lidské, nenáboženské)" +
                        "\n-spojen s učenci a vzdělanci, antika" +
                        "\n->Florentská Akademie<"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce Renesanční filosofie nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jan Hus",
                    false,
                    "protestantismus, renesanční filosofie >Reformace< - náprava náboženství," +
                        "\n-církev nemá být zkorumpovaná - vnitřní opravdovost věřícího - \"přítelkyně pravda\""
                ),
                PsychologyTermAnswer("Martin Luther",
                    false,
                    "německá >Reformace<, renesanční filosofie, protestantismus" +
                        "\n-slovo Boží třeba přijímat přímo srdcem, bez církve"
                ),
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-jeho díla působily v rámci scholastiky - >křesťanský averroismus<"
                ),
                PsychologyTermAnswer("Erasmus Rotterdamský",
                    false,
                    "(1465-1536)" +
                        "\nHumanismus (lidské, nenáboženské)" +
                        "\n-spojen s učenci a vzdělanci, antika" +
                        "\n->Florentská Akademie<"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Co bylo výsledkem protestantismu?",
            textAnswer = "Reformace náboženství, renesanční filosofie - Jan Hus, Martin Luther." +
                "\nNaturalismus, panteismus, individualismus a antropocentrismus, racionalismus",
            answers =
            listOf(
                PsychologyTermAnswer("zdůraznění individuální víry, svědomí a odpovědnosti",
                    false,
                    ""
                ),
                PsychologyTermAnswer("pomohla nadcházející scholastice budovat na základech protestantismu",
                    false,
                    ""
                ),
                PsychologyTermAnswer("postavit základy křesťanství",
                    false,
                    ""
                ),
                PsychologyTermAnswer("najít Boha",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Heliocentrismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("planety se točí okolo Slunce",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vztah k přírodě, odmítání askeze (náboženské odmítání některých slastí)",
                    false,
                    "naturalismus"
                ),
                PsychologyTermAnswer("spojení Boha a přírody",
                    false,
                    "panteismus"
                ),
                PsychologyTermAnswer("smyslovost, empirická zkušenost",
                    false,
                    "sensualismus"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené, rozumové ovládnutí skutečnosti",
                    false,
                    "racionalismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Naturalismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("planety se točí okolo Slunce",
                    false,
                    "Heliocentrismus"
                ),
                PsychologyTermAnswer("vztah k přírodě, odmítání askeze (náboženské odmítání některých slastí)",
                    false,
                    ""
                ),
                PsychologyTermAnswer("planety se točí okolo Země",
                    false,
                    "Geocentrismus"
                ),
                PsychologyTermAnswer("spojení Boha a přírody",
                    false,
                    "panteismus"
                ),
                PsychologyTermAnswer("smyslovost, empirická zkušenost",
                    false,
                    "sensualismus"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené, rozumové ovládnutí skutečnosti",
                    false,
                    "racionalismus, hegelovská filosofie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Geocentrismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("planety se točí okolo Slunce",
                    false,
                    "Heliocentrismus"
                ),
                PsychologyTermAnswer("planety se točí okolo Země",
                    false,
                    ""
                ),
                PsychologyTermAnswer("vztah k přírodě, odmítání askeze (náboženské odmítání některých slastí)",
                    false,
                    "Naturalismus"
                ),
                PsychologyTermAnswer("spojení Boha a přírody",
                    false,
                    "panteismus"
                ),
                PsychologyTermAnswer("smyslovost, empirická zkušenost",
                    false,
                    "sensualismus"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené, rozumové ovládnutí skutečnosti",
                    false,
                    "racionalismus, hegelovská filosofie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "Panteismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("planety se točí okolo Slunce",
                    false,
                    "Heliocentrismus"
                ),
                PsychologyTermAnswer("vztah k přírodě, odmítání askeze (náboženské odmítání některých slastí)",
                    false,
                    "naturalismus"
                ),
                PsychologyTermAnswer("spojení Boha a přírody",
                    false,
                    ""
                ),
                PsychologyTermAnswer("smyslovost, empirická zkušenost",
                    false,
                    "sensualismus"
                ),
                PsychologyTermAnswer("planety se točí okolo Země",
                    false,
                    "Geocentrismus"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené, rozumové ovládnutí skutečnosti",
                    false,
                    "racionalismus, hegelovská filosofie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Sensualismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("planety se točí okolo Slunce",
                    false,
                    "Heliocentrismus"
                ),
                PsychologyTermAnswer("vztah k přírodě, odmítání askeze (náboženské odmítání některých slastí)",
                    false,
                    "naturalismus"
                ),
                PsychologyTermAnswer("spojení Boha a přírody",
                    false,
                    "panteismus"
                ),
                PsychologyTermAnswer("planety se točí okolo Země",
                    false,
                    "Geocentrismus"
                ),
                PsychologyTermAnswer("smyslovost, empirická zkušenost",
                    false,
                    ""
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené, rozumové ovládnutí skutečnosti",
                    false,
                    "racionalismus, hegelovská filosofie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 4
        ),
        PsychologyTerm(
            prompt = "Racionalismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("planety se točí okolo Slunce",
                    false,
                    "Heliocentrismus"
                ),
                PsychologyTermAnswer("vztah k přírodě, odmítání askeze (náboženské odmítání některých slastí)",
                    false,
                    "naturalismus"
                ),
                PsychologyTermAnswer("spojení Boha a přírody",
                    false,
                    "panteismus"
                ),
                PsychologyTermAnswer("smyslovost, empirická zkušenost",
                    false,
                    "sensualismus"
                ),
                PsychologyTermAnswer("planety se točí okolo Země",
                    false,
                    "Geocentrismus"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené, rozumové ovládnutí skutečnosti",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 5
        ),
        PsychologyTerm(
            prompt = "Jaké termíny nejvíce vystihují renesanční filosofii?",
            textAnswer = "Reformace náboženství, renesanční filosofie - Jan Hus, Martin Luther.",
            answers =
            listOf(
                PsychologyTermAnswer("Naturalismus, Individualismus, Racionalismus",
                    false,
                    "Naturalismus" +
                        "\n\t-vztah k přírodě, odmítání askeze (náboženské odmítání některých slastí)" +
                        "\n\nIndividualismus" +
                        "\n\t-soběstačnost, svoboda, právo prosazovat své individuální cíle a zájmy" +
                        "\n\nRacionalismus" +
                        "\n\t-principy a zásady rozumu jsou vrozené, rozumové ovládnutí skutečnosti"
                ),
                PsychologyTermAnswer("Epikůrismus, Stoicismus, Skepticismus, Probabulismus",
                    false,
                        "Antická filosofie > Hélenistická filosofie" +
                            "\nEpikůros (341-270 př.kr.), antická filosofie > Hélenistická filosofie" +
                            "\n-materialista, atomy, smrtelnost duše" +
                            "\n>Blaženost< (eudaimonia)" +
                            "\n\t-Bohové se o nás nezajímají, musí se tedy postarat o naše vlastní štěstí" +
                            "\n\tRozkoš - pozitivní pocit, klid duše" +
                            "\n\t\t-i duchovní rovina (např. přátělství)" +
                            "\n\"Když člověk žije, není smrt, až přijde, nebude tu člověk\"" +
                            "\n\nStoicismus:" +
                            "\n\t-zdobné sloupí (stoa poikilé)" +
                            "\n\t-základ všeho je Bůh v podobě ducha (pneuma)" +
                            "\n\t-vše propojeno pouty sounáležitosti (sympatheia) a řízeno prozřetelností" +
                            "\n\t\t-pokud se nenásleduje, vzniká nemoc duše, ta je léčena >Apatheií<, z níž vzniká >Ctnost< (areté)" +
                            "\n\nSkepticismus" +
                            "\n\t-únava z protichůdných názorů" +
                            "\n\t-zakladatel, ovlivněn brahmány (indická filosofie), nic nenapsal, jelikož psaní bral za klam" +
                            "\n\t-zdržení se - >Epoché<" +
                            "\n\t-nejsme-li si jisti, je lepší se neangažovat a docílit stavu lhostejnosti - >Ataraxiá<" +
                            "\n\nPlatónská akademie" +
                            "\n\t>Probabilismus< - k praktickému životu stačí pravděpodobnostní poznání" +
                            "\n\nAinesidémos, Sextos Empirikos (Řím)"
                ),
                PsychologyTermAnswer("Látky a formy",
                    false,
                    "Aristotelés" +
                        "\nŽák Platóna, avšak ho později kritizoval, učitel Alexandra Velikého." +
                        "\nPeripatetická škola (peripatos=sloupořadí)" +
                        "\n\t-procházky s jeho žáky" +
                        "\nDíla: Metafyzika, Etika Nikomachova, Politika, Poetika, Organon" +
                        "\n>Látka (eidos) a forma (morfé)<" +
                        "\n\tDuše je forma a tělo je jen látka" +
                        "\n\tLátka je pouze potenčnost, až teprve forma vytváří věci skutečné z látky." +
                        "\nPohyb" +
                        "\n\t-proces, při čemž látka nabývá formy" +
                        "\n\t-\"Je třeba se zastavit\" - první hybatel - Bůh" +
                        "\nÚčel (telos)" +
                        "\n\t-vnitřní příčina věcí, vše má účel" +
                        "\n\t->Entelechie< - naplnění účelu" +
                        "\n\t-Teleologie - účel předchází uskutečnění" +
                        "\n>Logika<" +
                        "\n\t-nauka o pravidlech, formě usuzování" +
                        "\n\t-klasifikace úsudků, nadřazenost a podřazenost zákl. pojmů" +
                        "\n\t-zákon totožnosti, sporu a vyloučeního třetího" +
                        "\nForma společnosti" +
                        "\n\t-nadčasový výzkum 158 řeckých ústav" +
                        "\n\t-bytosti společenské (zóon polítikon)" +
                        "\n\t-střední míra - sřední třída ideál, vše tak nějak do míry"
                ),
                PsychologyTermAnswer("Svět idejí, psychagógiá, mýtus",
                    false,
                    "Platón" +
                        "\nAristokrat, objektivní idealismus" +
                        "\nAntická filosofie > Filosofie klasického období" +
                        "\nDíla: Obrana Sókratova, 34 dialogy, Ústava, Menón, Symposion, Faidros" +
                        "\nHledal kde se v lidech berou sny a touhy." +
                        "\n\t>Svět idejí< (původně eidos=obraz)" +
                        "\n\t\t-obrazy harmonie, dobra, krásy v našich duších" +
                        "\n\t\t-ideje jsou věčné, předobrazem skutečnosti" +
                        "\nMýtus o jeskyni -Ústava" +
                        "\n\t-stíny na stěně bereme jako skutečné" +
                        "\n\t-viditelné věci jsou pomíjivé" +
                        "\nDuše je věčná - je v říši idejí" +
                        "\n\t-avšak vznětlivostí přikována k tělu" +
                        "\n>Rozpomínání se< (anamnésis) na svět idejí -Ménón" +
                        "\nPředstava ideálního státu" +
                        "\n\t-3 třídy: pracovní třída, vojáci, a vládci." +
                        "\n\t-stát řízený filosofy" +
                        "\n\t-člověk nemůže budovat, co nevybudoval v sobě" +
                        "\nPsychagóggia" +
                        "\n\t-vedení duše za pomoci mýtů" +
                        "\n\t-mýtus je řeč duše - \"Ví ke komu mluvit a ke komu mlčet\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Florentská Akademie působila v období",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Renesanční filosofie",
                    false,
                    "Reformace náboženství, renesanční filosofie - Jan Hus, Martin Luther." +
                        "\nNaturalismus, panteismus, individualismus a antropocentrismus, racionalismus"
                ),
                PsychologyTermAnswer("Rané Scholastiky",
                    false,
                    "Raná scholastika" +
                        "\nBoethius" +
                        "\n(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti" +
                        "\n\nAnselm" +
                        "\n(1033-1109), italský mnich, arcibiskup" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce" +
                        "\n\nNominalisté" +
                        "\n-ve sporu o univerzálie (obecné pojmy) tvrdí, že pojmy jsou pouze jména (nomina) věcí, ale nereprezentují nutně reálné věci." +
                        "\n\nPierre Abélard" +
                        "\n(1079-1142), znám láskou k Héloise" +
                        "\n-kompromisní řešení na spor univerzálií, úmysl předchází a doprovází čin" +
                        "\n-rozumová metoda postavena na protichůdná stanoviska (ano i ne) a rozum hledá závěr" +
                        "\n\nBernard z Clairvaux" +
                        "\n(1091-1153), protireákce na jednostranný důraz na rozum" +
                        "\n\t-zkušenost, láska, vztah k Bohu a lidem"
                ),
                PsychologyTermAnswer("Helénistické filosofie",
                    false,
                    "Antická filosofie > Helénistická filosofie" +
                        "\nEpikúros" +
                        "\nStoicismus" +
                        "\n\t-Zénón, Chrýsippos, Seneca, Epiktétos, Marcus Aurelius" +
                        "\nSkepticismus" +
                        "\n\t-Pyrrhón" +
                        "\n\t-Probabilismus" +
                        "\n\t-Ainesidémos, Sextos, Empirikos" +
                        "\nPokračovatelé Platónovi; gnóze" +
                        "\n\t-Plútarchos, Núménios, Filón Alexandrijský, Ammónios Sakkás, Plótínos, Porfyrios, Plótínus"
                ),
                PsychologyTermAnswer("Sofistů",
                    false,
                    "Antická filosofie > filosofie klasického období" +
                        "\n->Veřejná činnost<" +
                        "\nSubjektivismus" +
                        "\n\t-věci a svět nemají bez člověka stálou hodnotu" +
                        "\n\t-pravda je subjektivní" +
                        "\nNoetická skepce" +
                        "\n\t-nedůvěra spolehlivě poznávat svět" +
                        "\n\t-1. Nic není, 2. I kdyby, nelze to poznat, 3. I kdyby, nelze to sdělit" +
                        "\n\t-rozmělnilo se v řečnické triky - >Sofismata< (chytráčství)" +
                        "\nRelativismus" +
                        "\n\t-pravda, spravedlnost a hodnoty jsou subjektivní" +
                        "\n-Prótagorás, Gorgiás (483-375 př.kr.)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Entelechie je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("uskutečnění se",
                    false,
                    "Aristotelés" +
                        "\nŽák Platóna, avšak ho později kritizoval, učitel Alexandra Velikého." +
                        "\nPeripatetická škola (peripatos=sloupořadí)" +
                        "\n\t-procházky s jeho žáky" +
                        "\nDíla: Metafyzika, Etika Nikomachova, Politika, Poetika, Organon" +
                        "\n>Látka (eidos) a forma (morfé)<" +
                        "\n\tDuše je forma a tělo je jen látka" +
                        "\n\tLátka je pouze potenčnost, až teprve forma vytváří věci skutečné z látky." +
                        "\nPohyb" +
                        "\n\t-proces, při čemž látka nabývá formy" +
                        "\n\t-\"Je třeba se zastavit\" - první hybatel - Bůh" +
                        "\nÚčel (telos)" +
                        "\n\t-vnitřní příčina věcí, vše má účel" +
                        "\n\t->Entelechie< - naplnění účelu" +
                        "\n\t-Teleologie - účel předchází uskutečnění" +
                        "\n>Logika<" +
                        "\n\t-nauka o pravidlech, formě usuzování" +
                        "\n\t-klasifikace úsudků, nadřazenost a podřazenost zákl. pojmů" +
                        "\n\t-zákon totožnosti, sporu a vyloučeního třetího" +
                        "\nForma společnosti" +
                        "\n\t-nadčasový výzkum 158 řeckých ústav" +
                        "\n\t-bytosti společenské (zóon polítikon)" +
                        "\n\t-střední míra - sřední třída ideál, vše tak nějak do míry"
                ),
                PsychologyTermAnswer("účel předchází uskutečnění",
                    false,
                    "Teleologie"
                ),
                PsychologyTermAnswer("obecné pojmy jsou jen jména",
                    false,
                    "nominalismus (nomina=jména)"
                ),
                PsychologyTermAnswer("přírodovědné zjednodušování člověka i společnosti",
                    false,
                    "redukcionismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce sociální myšlení renesance nepatří",
            textAnswer = "rozpad středověkých struktur - zájem o sociální otázky",
            answers =
            listOf(
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("Nicolo Machiavelli",
                    false,
                    "(1469-1527), florentský filosof, diplomat" +
                        "\n-zobecnil pojmy florentské filosofie" +
                        "\n->dějiny už nezávisí na Bohu, ale na lidech< (\"Vladař\")" +
                        "\n\t-lidé neschopní -> potřeba silného státu s obratným panovníkem v čele" +
                        "\n\t-možnost použít jakýchkoliv prostředků k docílení pol. cílů" +
                        "\n\t-namísto dobré/špatné -> prospěšné/škodlivé"
                ),
                PsychologyTermAnswer("Hugo Grotius",
                    false,
                    "(1583-1645), holandský právník" +
                        "\nmezinárodní právo"
                ),
                PsychologyTermAnswer("Thomas Morus",
                    false,
                    "(1561/1626), angličan" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Tomasso Campanella",
                    false,
                    "(1561/1626), Ital" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Giambattista Vico",
                    false,
                    "(1668-1744), ital" +
                        "\n-historický koloběh" +
                        "\n\t-3 epochy - božská, heroická, lidská" +
                        "\n\t-heroická - aristokratický stát" +
                        "\n\t-lidská - demokracie, svoboda" +
                        "\n\tNásledně přichází úpadek a nový koloběh na vyšší úrovni"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Novum Organon\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("Nicolo Machiavelli",
                    false,
                    "(1469-1527), florentský filosof, diplomat" +
                        "\n-zobecnil pojmy florentské filosofie" +
                        "\n->dějiny už nezávisí na Bohu, ale na lidech< (\"Vladař\")" +
                        "\n\t-lidé neschopní -> potřeba silného státu s obratným panovníkem v čele" +
                        "\n\t-možnost použít jakýchkoliv prostředků k docílení pol. cílů" +
                        "\n\t-namísto dobré/špatné -> prospěšné/škodlivé"
                ),
                PsychologyTermAnswer("Hugo Grotius",
                    false,
                    "(1583-1645), holandský právník" +
                        "\nmezinárodní právo"
                ),
                PsychologyTermAnswer("Thomas Morus",
                    false,
                    "(1561/1626), angličan" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Tomasso Campanella",
                    false,
                    "(1561/1626), Ital" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Giambattista Vico",
                    false,
                    "(1668-1744), ital" +
                        "\n-historický koloběh" +
                        "\n\t-3 epochy - božská, heroická, lidská" +
                        "\n\t-heroická - aristokratický stát" +
                        "\n\t-lidská - demokracie, svoboda" +
                        "\n\tNásledně přichází úpadek a nový koloběh na vyšší úrovni"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem nedokončeného myšlenkového projektu \"Velké obnovení věd\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("Nicolo Machiavelli",
                    false,
                    "(1469-1527), florentský filosof, diplomat" +
                        "\n-zobecnil pojmy florentské filosofie" +
                        "\n->dějiny už nezávisí na Bohu, ale na lidech< (\"Vladař\")" +
                        "\n\t-lidé neschopní -> potřeba silného státu s obratným panovníkem v čele" +
                        "\n\t-možnost použít jakýchkoliv prostředků k docílení pol. cílů" +
                        "\n\t-namísto dobré/špatné -> prospěšné/škodlivé"
                ),
                PsychologyTermAnswer("Hugo Grotius",
                    false,
                    "(1583-1645), holandský právník" +
                        "\nmezinárodní právo"
                ),
                PsychologyTermAnswer("Thomas Morus",
                    false,
                    "(1561/1626), angličan" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Tomasso Campanella",
                    false,
                    "(1561/1626), Ital" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Giambattista Vico",
                    false,
                    "(1668-1744), ital" +
                        "\n-historický koloběh" +
                        "\n\t-3 epochy - božská, heroická, lidská" +
                        "\n\t-heroická - aristokratický stát" +
                        "\n\t-lidská - demokracie, svoboda" +
                        "\n\tNásledně přichází úpadek a nový koloběh na vyšší úrovni"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo řekl, že dějiny už nezávisí na Bohu, ale na lidech?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Nicolo Machiavelli",
                    false,
                    "(1469-1527), florentský filosof, diplomat" +
                        "\n-zobecnil pojmy florentské filosofie" +
                        "\n->dějiny už nezávisí na Bohu, ale na lidech< (\"Vladař\")" +
                        "\n\t-lidé neschopní -> potřeba silného státu s obratným panovníkem v čele" +
                        "\n\t-možnost použít jakýchkoliv prostředků k docílení pol. cílů" +
                        "\n\t-namísto dobré/špatné -> prospěšné/škodlivé"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Historický koloběh lidstva navrhl",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Giambattista Vico",
                    false,
                    "(1668-1744), ital, Sociální myšlení renesance" +
                        "\n-historický koloběh" +
                        "\n\t-3 epochy - božská, heroická, lidská" +
                        "\n\t-heroická - aristokratický stát" +
                        "\n\t-lidská - demokracie, svoboda" +
                        "\n\tNásledně přichází úpadek a nový koloběh na vyšší úrovni"
                ),
                PsychologyTermAnswer("Thomas Morus",
                    false,
                    "(1561/1626), angličan" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561/1626), angličan" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Tomasso Campanella",
                    false,
                    "(1561/1626), Ital" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi vizionáře o utopii v době Renesance nepatří:",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Giambattista Vico",
                    false,
                    "(1668-1744), ital, Sociální myšlení renesance" +
                        "\n-historický koloběh" +
                        "\n\t-3 epochy - božská, heroická, lidská" +
                        "\n\t-heroická - aristokratický stát" +
                        "\n\t-lidská - demokracie, svoboda" +
                        "\n\tNásledně přichází úpadek a nový koloběh na vyšší úrovni"
                ),
                PsychologyTermAnswer("Thomas Morus",
                    false,
                    "(1561/1626), angličan" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                ),
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Tomasso Campanella",
                    false,
                    "(1561/1626), Ital" +
                        "\n-vize o rozumné a harmonické společnosti, >utopie<"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo vytvořil hypotézu o pohybu Země?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
                PsychologyTermAnswer("Mikuláš Koperník",
                    false,
                    "(1473-1543)"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Démokritos",
                    false,
                    "Antická filosofie > předsokratovská filosofie > Antičtí atomisté" +
                        "\nSpojení Elejské školy a Héreklitů" +
                        "\n\t-nedělitelné, věčné >Atomy<" +
                        "\n\t\t-pohybující se v prázdnotě, čili nebytí" +
                        "\n-neexistuje náhoda - >Determinismus<" +
                        "\n-Leukippos, Démokritos"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zastupitele renesanční \"přírodní\" filosofii nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Averroes",
                    false,
                    "(Ibn Rušd, 1126-1198)" +
                        "\nOkomentoval všechny Aristotelovy spisy - \"Komentátor\"" +
                        "\n-\"Aristoteles vysvětlil přírodu a Averroes vysvětlil Aristotela\"" +
                        "\nsubjektivní rozumové poznání (např. Korán)" +
                        "\nDvojí pravda - pravda vědy, pravda víry" +
                        "\n\t-inspirovalo scholastiku - křesťanský averroismus"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
                PsychologyTermAnswer("Theophrastus Bombastus PARACELSUS",
                    false,
                    "(1493-1541), lékař, Hermetická filosofie" +
                        "\n-jednota mikrokosmu (člověka) a makrokosmu (vesmíru, universa)"
                ),
                PsychologyTermAnswer("Hieron Cardano",
                    false,
                    "(1500-1576), ital, Hermetická filosofie"
                ),
                PsychologyTermAnswer("Bernardino Telesio",
                    false,
                    "(1508-1588), ital, Hermetická filosofie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi představitele hermetické filosofie nepatří",
            textAnswer = "Hermetické filosofie" +
                "\nSdružuje (uzavírá) do jednoho celku empirickou přírodovědu, básnictví, víru i filosofii" +
                "\novlivněni spisy boha Hermes (\"Corpus Hermeticum\")",
            answers =
            listOf(
                PsychologyTermAnswer("Nicolo Machiavelli",
                    false,
                    "(1469-1527), florentský filosof, diplomat, sociální myšlení renesance" +
                        "\n-zobecnil pojmy florentské filosofie" +
                        "\n->dějiny už nezávisí na Bohu, ale na lidech< (\"Vladař\")" +
                        "\n\t-lidé neschopní -> potřeba silného státu s obratným panovníkem v čele" +
                        "\n\t-možnost použít jakýchkoliv prostředků k docílení pol. cílů" +
                        "\n\t-namísto dobré/špatné -> prospěšné/škodlivé"
                ),
                PsychologyTermAnswer("Theophrastus Bombastus PARACELSUS",
                    false,
                    "(1493-1541), lékař, Hermetická filosofie" +
                        "\n-jednota mikrokosmu (člověka) a makrokosmu (vesmíru, universa)"
                ),
                PsychologyTermAnswer("Hieron Cardano",
                    false,
                    "(1500-1576), ital, Hermetická filosofie"
                ),
                PsychologyTermAnswer("Bernardino Telesio",
                    false,
                    "(1508-1588), ital, Hermetická filosofie"
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem spisů \"Corpus Hermeticum\" je",
            textAnswer = "Hermetické filosofie" +
                "\nSdružuje (uzavírá) do jednoho celku empirickou přírodovědu, básnictví, víru i filosofii" +
                "\novlivněni spisy boha Hermes (\"Corpus Hermeticum\")",
            answers =
            listOf(
                PsychologyTermAnswer("bůh Hermes",
                    false,
                    ""
                ),
                PsychologyTermAnswer("florentská Akademie",
                    false,
                    ""
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"téhož Písma používají židé, křesťané i mohamedáni\" řekl",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
                PsychologyTermAnswer("Johannes Kepler",
                    false,
                    "(1571-1630, Hermetická filosofie" +
                        "\n\"Ubi materia, ibi geometria\" - kde je látka, tam je matematika"
                ),
                PsychologyTermAnswer("Galieo Galilei",
                    false,
                    "(1564-1642), ital, Hermetická filosofie" +
                        "\n-rozklad složených objektů jednodušší" +
                        "\n-příroda je největší knihou, jejíž jazyk je matematika, písmena kruhy, jehlany atd."
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo přišel s universalistickým pojetím (vše je nějak ve všem) vesmíru?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("hermetičtí filosofové",
                    false,
                    ""
                ),
                PsychologyTermAnswer("stoicisti",
                    false,
                    "Antická filosofie > Hélenistická filosofie" +
                        "\nzdobné sloupí (stoa poikilé)" +
                        "\n-základ všeho je Bůh v podobě ducha (pneuma)" +
                        "\n-vše propojeno pouty sounáležitosti (sympatheia) a řízeno prozřetelností" +
                        "\n\t-pokud se nenásleduje, vzniká nemoc duše, ta je léčena >Apatheií<, z níž vzniká >Ctnost< (areté)" +
                        "\nEpiktétos" +
                        "\n\t-neřešit neřešitelné a řešit řešitelné" +
                        "\n\t-trápení nepouštět do prožívání (něco jako suprese)" +
                        "\n\t-vše má svůj důvod, naším cílem je se spokojit s tím, co máme" +
                        "\nRovnost všech lidí - proti otroctví" +
                        "\nZénón (336-264 př.kr., zakladatel)" +
                        "\nChrýsippos - vycházel z Platónismu, pozdní stoa v Římě" +
                        "\nSeneca (učitel císaře, Marcus Aurelius"
                ),
                PsychologyTermAnswer("raná scholastika",
                    false,
                    "Raná scholastika" +
                        "\nBoethius" +
                        "\n(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti" +
                        "\n\nAnselm" +
                        "\n(1033-1109), italský mnich, arcibiskup" +
                        "\n-vztah víry a rozumu, důkaz Boží existence" +
                        "\n\t-teprve věřící člověk hledá rozumové zdůvodnění víry, tudíž spíše odůvodnění, nežli důkaz" +
                        "\n\t-to, co si myslíme má reálný základ, tudíž pokud si myslíme něco, nad co už si nelze myslet něco většího," +
                        " myslíme o Bohu, který tudíž musí být i reálný" +
                        "\n\t\t-i kulatý čtverec předpokládá znalost kruhu a čtverce" +
                        "\n\nNominalisté" +
                        "\n-ve sporu o univerzálie (obecné pojmy) tvrdí, že pojmy jsou pouze jména (nomina) věcí, ale nereprezentují nutně reálné věci." +
                        "\n\nPierre Abélard" +
                        "\n(1079-1142), znám láskou k Héloise" +
                        "\n-kompromisní řešení na spor univerzálií, úmysl předchází a doprovází čin" +
                        "\n-rozumová metoda postavena na protichůdná stanoviska (ano i ne) a rozum hledá závěr" +
                        "\n\nBernard z Clairvaux" +
                        "\n(1091-1153), protireákce na jednostranný důraz na rozum" +
                        "\n\t-zkušenost, láska, vztah k Bohu a lidem"
                ),
                PsychologyTermAnswer("Francis Bacon a Thomas Hobbes",
                    false,
                    "Francis Bacon" +
                        "\n(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci" +
                        "\n\nThomas Hobbes" +
                        "\n(1588-1679), agličan, stát, právo" +
                        "\n\t-přirozenost člověka je egoismus" +
                        "\n\tTeorie společenské smlouvy" +
                        "\n\t-lidé se dohodli mít nad sebou moc, aby se navzájem nepovraždili" +
                        "\n\t-stát je obrovské těleso, jak bájná příšera \"Leviathan\" - absolutismus (absolutus=úplný, úplná, centrální vláda)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Ubi materia, ibi geometria\" je",
            textAnswer = "\"Ubi materia, ibi geometria\" - kde je látka, tam je matematika",
            answers =
            listOf(
                PsychologyTermAnswer("Johannes Kepler",
                    false,
                    "(1571-1630, Renesanční \"přírodní\" filosofie > Hermetická filosofie"
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
                PsychologyTermAnswer("Galieo Galilei",
                    false,
                    "(1564-1642), ital, Hermetická filosofie" +
                        "\n-rozklad složených objektů jednodušší" +
                        "\n-příroda je největší knihou, jejíž jazyk je matematika, písmena kruhy, jehlany atd."
                ),
                PsychologyTermAnswer("Aurelius Augustinus",
                    false,
                    "(354-430), Středověká filosofie > křesťanství. " +
                        "\nAutobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
                PsychologyTermAnswer("Boethius",
                    false,
                    "(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Útěcha z filosofie\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Boethius",
                    false,
                    "(480-525), překlad Aristotela do latiny" +
                        "\n-\"Útěcha z filosofie\" - čistě filosoficky se Boethius vypořádává s lidskými otázkami utrpení a smrti"
                ),
                PsychologyTermAnswer("Johannes Kepler",
                    false,
                    "(1571-1630, Renesanční \"přírodní\" filosofie > Hermetická filosofie"
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
                PsychologyTermAnswer("Galieo Galilei",
                    false,
                    "(1564-1642), ital, Hermetická filosofie" +
                        "\n-rozklad složených objektů jednodušší" +
                        "\n-příroda je největší knihou, jejíž jazyk je matematika, písmena kruhy, jehlany atd."
                ),
                PsychologyTermAnswer("Aurelius Augustinus",
                    false,
                    "(354-430), Středověká filosofie > křesťanství. " +
                        "\nAutobiografii \"Vyznání\"" +
                        "\n\t-lidské poznání Boha, lidská svoboda (nemocná svoboda musí být nejprve uzdravena)" +
                        "\n\t-křesťanské pojetí stvoření, myšlenku o čase" +
                        "\n\t-\"Stvořil jsi nás pro sebe a nepokojné je naše srdce, dokud nespočine v tobě, Bože\"" +
                        "\n\t->Iluminace< - přímý vhled k podstatě" +
                        "\n\t-\"O Boží obci\" - Téze o tom, že v dějinách se vytvářejí 2 společenství (obce)." +
                        "\nTo, které se řídí sobeckou láskou (pozemská obec) a obec Boží, která se řídí láskou k Bohu a lidem (menšinová)."
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo tvrdil, že příroda je největší knihou, jejíž jazyk je matematika, písmena kruhy, jehlany atd.",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Galieo Galilei",
                    false,
                    "(1564-1642), ital, Hermetická filosofie" +
                        "\n-rozklad složených objektů jednodušší" +
                        "\n-příroda je největší knihou, jejíž jazyk je matematika, písmena kruhy, jehlany atd."
                ),
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Thomas Hobbes",
                    false,
                    "(1588-1679), agličan, stát, právo" +
                        "\n\t-přirozenost člověka je egoismus" +
                        "\n\tTeorie společenské smlouvy" +
                        "\n\t-lidé se dohodli mít nad sebou moc, aby se navzájem nepovraždili" +
                        "\n\t-stát je obrovské těleso, jak bájná příšera \"Leviathan\" - absolutismus (absolutus=úplný, úplná, centrální vláda)"
                ),
                PsychologyTermAnswer("T. Akvinský (1225-1274)",
                    false,
                    "Dominikán ve sporu vrcholné scholastiky, nejrozšířenější škola středověku" +
                        "\n-Díla (2 sumy): \"Proti pohanům\", \"Teologické sumě\"" +
                        "\n-rozum a víra jsou pro něj 2 rozdílné metody přístupu k pravdě" +
                        "\n-pravým dokonalým stvořením je Bůh, ostatní jsou stvořené" +
                        "\n\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě" +
                        "\nExistence" +
                        "\n\t-konkrétní podoba esence (pravé podstaty)" +
                        "\n\nKonkrétní skutečnost má:" +
                        "\n\t-substanci - neměnná část" +
                        "\n\t-přípradné vlastnosti (akcidenty) - měnné, bez vlivu na substanci" +
                        "\n\nAnalogie bytí (analogia entis, ze znalosti jednoho jde usuzovat o druhém)" +
                        "\n\t-2 podoby bytí - dokonalého Boha a bytí věcí stvořených - společný pojem je bytí" +
                        "\n5 cest (důkazů) k poznání Boží existence" +
                        "\njednota duše a těla"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Induktivní metoda je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("od dílčích poznatků k závěru",
                    false,
                    "Induktivní metoda"
                ),
                PsychologyTermAnswer("od obecných poznatků závery",
                    false,
                    "dedukce"
                ),
                PsychologyTermAnswer("pochybnost o všech dosavadních míněních",
                    false,
                    "metoda skepse, René Descartes, Novověká filosofie, jelikož nás může klamat i náš vlastní rozum"
                ),
                PsychologyTermAnswer("vzájemné působení duchovní a hmotné substance prostřednictvím Boha",
                    false,
                    "Novověká filosofie, okkasionalismus" +
                        " - následovníci Descartese se snažili najít řešení na problém vztahu duchovní substance a hmotné substance"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Metoda skepse je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("od dílčích poznatků k závěru",
                    false,
                    "Induktivní metoda"
                ),
                PsychologyTermAnswer("od obecných poznatků závery",
                    false,
                    "dedukce"
                ),
                PsychologyTermAnswer("pochybnost o všech dosavadních míněních",
                    false,
                    "metoda skepse, René Descartes, Novověká filosofie, jelikož nás může klamat i náš vlastní rozum"
                ),
                PsychologyTermAnswer("vzájemné působení duchovní a hmotné substance prostřednictvím Boha",
                    false,
                    "Novověká filosofie, okkasionalismus" +
                        " - následovníci Descartese se snažili najít řešení na problém vztahu duchovní substance a hmotné substance"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Autorem \"Novum Organon\" popisující překážky rozumu a poznání je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Thomas Hobbes",
                    false,
                    "(1588-1679), agličan, stát, právo" +
                        "\n\t-přirozenost člověka je egoismus" +
                        "\n\tTeorie společenské smlouvy" +
                        "\n\t-lidé se dohodli mít nad sebou moc, aby se navzájem nepovraždili" +
                        "\n\t-stát je obrovské těleso, jak bájná příšera \"Leviathan\" - absolutismus (absolutus=úplný, úplná, centrální vláda)"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Racionalismus vznikl v období",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Novověká filosofie",
                    false,
                    "-matematika a mechanika" +
                        "\n-René Descart, Baruch Spinoza, Gottfried Wilhelm Leibniz"
                ),
                PsychologyTermAnswer("Novověký empirismus",
                    false,
                    "-anglická filosofická tradice" +
                        "\n-odmítání spekulace (včetně racionalistické dedukce)" +
                        "\n-John Locke, George Berkley, David Hume"
                ),
                PsychologyTermAnswer("Francouzská osvícenská filosofie",
                    false,
                    "-Evropa, 18st., rozumové akvitity a jejich výsledky, člověk-rozum-dějiny" +
                        "\n-zhodnocení empirismu, racionalismu a osvícenství - Immanuel Kant, G.W.F. Hegel"
                ),
                PsychologyTermAnswer("Mílétská škola",
                    false,
                    "Antická filosofie > Předsokratovské filosofie > Mílétská škola" +
                        "\n\t-Thalés, Anaximandros, Anaximenés" +
                        "\nPýthagorás, " +
                        "\nElejská škola" +
                        "\n\t-Xenofanés, Parmenidés, Zénón" +
                        "\nHérakleitos, " +
                        "\nAntičtí atomisté" +
                        "\n\t-Leukippos, Démokritos" +
                        "\nEmpedoklés, Anaxagorás"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Rozprava o metodě\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Metodou skepse je známý",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"Cogito, ergo sum\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Fenomenologie ducha\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jaké 2 substance rozděluje Descartes?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("duchovní a hmotná",
                    false,
                    "dualismus - 2 na sebe nezávislé substance" +
                        "\n-Duchovní substance - myšlení" +
                        "\n-Hmotná substance - rozlehlost"
                ),
                PsychologyTermAnswer("látka a forma",
                    false,
                    "Atistotelés" +
                        "\n\nŽák Platóna, avšak ho později kritizoval, učitel Alexandra Velikého." +
                        "\nPeripatetická škola (peripatos=sloupořadí)" +
                        "\n\t-procházky s jeho žáky" +
                        "\nDíla: Metafyzika, Etika Nikomachova, Politika, Poetika, Organon" +
                        "\n>Látka (eidos) a forma (morfé)<" +
                        "\n\tDuše je forma a tělo je jen látka" +
                        "\n\tLátka je pouze potenčnost, až teprve forma vytváří věci skutečné z látky." +
                        "\nPohyb" +
                        "\n\t-proces, při čemž látka nabývá formy" +
                        "\n\t-\"Je třeba se zastavit\" - první hybatel - Bůh" +
                        "\nÚčel (telos)" +
                        "\n\t-vnitřní příčina věcí, vše má účel" +
                        "\n\t->Entelechie< - naplnění účelu" +
                        "\n\t-Teleologie - účel předchází uskutečnění" +
                        "\n>Logika<" +
                        "\n\t-nauka o pravidlech, formě usuzování" +
                        "\n\t-klasifikace úsudků, nadřazenost a podřazenost zákl. pojmů" +
                        "\n\t-zákon totožnosti, sporu a vyloučeního třetího" +
                        "\nForma společnosti" +
                        "\n\t-nadčasový výzkum 158 řeckých ústav" +
                        "\n\t-bytosti společenské (zóon polítikon)" +
                        "\n\t-střední míra - sřední třída ideál, vše tak nějak do míry"
                ),
                PsychologyTermAnswer("číslo a apeiron",
                    false,
                    "Číslo:" +
                        "\nPýthagoras (572 - 494 př.kr.) Antická filosofie > Předsokratovská filosofie" +
                        "\nNáboženský spolek - ovlivněno Orfiky (orfeus=mýt. hrdina)" +
                        "\nApeiron (Anaximandros) není, jelikož ho nelze od sebe odlišit." +
                        "\nKaždé jsoucno tvarováno a má svou mez (peras) a je počítatelné" +
                        "\n\tZáklad je číslo" +
                        "\n\t\t-např. správná šíře strun=harmonie., i kosmos má svou harmonii." +
                        "\n\t\t-svět a jeho harmonii můžeme poznávat až když máme harmonii ve vlastní duši" +
                        "\n\t\t-zjistili, že strany čtverce mají iracionální číslo - tedy chaos, snažili se utajit." +
                        "\n\nApeiron:" +
                        "\nAnaximandros Antická filosofie > Předsokratovská filosofie > Milétská škola" +
                        "\nHýlozoista (hýlé=hmota, zoé=život)" +
                        "\nPralátka >Apeiron< (nezměrné, neomezené)" +
                        "\nApeiron se tvaruje a následně kvůli provinění se za trest zpětně rozplyne - rozpad objektu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Za otce moderní filosofie je považován",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("René Descartes",
                    false,
                    "René Descartes (1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)" +
                        "\nVyšli z něj 2 protichudné cesty:" +
                        "\n\t\t1. Zdůraznění subjektu ve filosofii Fichetoh (\"Jáství\")" +
                        "\n\t\t2. Vědecký objektivismus - objekt je něco vnějšího, na čem nemáme účast"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Okkasionalismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("vzájemné působení duchovní a hmotné substance prostřednictvím Boha",
                    false,
                    ""
                ),
                PsychologyTermAnswer("od dílčích poznatků k závěru",
                    false,
                    "Induktivní metoda"
                ),
                PsychologyTermAnswer("od obecných poznatků závery",
                    false,
                    "dedukce"
                ),
                PsychologyTermAnswer("pochybnost o všech dosavadních míněních",
                    false,
                    "metoda skepse, René Descartes, Novověká filosofie, jelikož nás může klamat i náš vlastní rozum"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi descartovi součastníky nepatřili",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Jacques Rousseau",
                    false,
                    "(1712-1778), viděl negativně pokroky vědy" +
                        "\n-všude viděl bídu a pokrytectví - druhá strana osvícenství" +
                        "\n-\"pokrok\" civilizace potlačily přirozenou citovost člověka -> ÚPADEK LIDSKOSTI" +
                        "\n-se soukromým vlastnictvím a zákony vznikla ve společnosti nerovnost" +
                        "\n\t-nemyslí si však, že ideální stav někdy byl či bude" +
                        "\n\tObnovení přírody v člověku, rovnost všech -> svoboda+státní moc" +
                        "\n\t-\"Svoboda je poslušnost vůči zákonu, který jsme si stanovili\"" +
                        "\nspolečenská smlouva (Thomas Hobbes, J. Locke)" +
                        "\n\t-přidal \"suverenita lidu\"" +
                        "\n\ninspiroval romantismus"
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                ),
                PsychologyTermAnswer("Nicolas de Malebranche",
                    false,
                    "(1638-1715)" +
                        "\n-chápe Boha jako jediné nekonečné jsoucno"
                ),
                PsychologyTermAnswer("Blaise Pascal",
                    false,
                    "(1623-1662), francouz" +
                        "\n-racionální a matematické myšlení neuspokojuje skryté hlubiny našeho ducha" +
                        "\n-\"Srdce má své důvody, o kterých rozum neví\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Srdce má své důvody, o kterých rozum neví\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Blaise Pascal",
                    false,
                    "(1623-1662), francouz" +
                        "\n-racionální a matematické myšlení neuspokojuje skryté hlubiny našeho ducha" +
                        "\n-\"Srdce má své důvody, o kterých rozum neví\""
                ),
                PsychologyTermAnswer("Jan Ámos Komenský",
                    false,
                    "(1592-1670), descartův současník, reformátor, pedagog" +
                        "\n-ztělesňuje a završuje celostní humanistické myšlení (po třicetileté válce poraženo)" +
                        "\n-hluboký prožitek víry" +
                        "\n-svět je organický celek mikrokosmosmos (člověk) v blízkém vztahu s makrokosmem (svět)" +
                        "\n-příroda není mechanismus, je to >VZOR pro člověka<, jelikož z něj poznáváme obecné ideje vzniku světa" +
                        "\n-Pansofický (všemoudré) vědění a synkretický (mnohovrstevný) přístup k člověku a světu"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)" +
                        "\nVyšli z něj 2 protichudné cesty:" +
                        "\n\t\t1. Zdůraznění subjektu ve filosofii Fichteho (\"Jáství\")" +
                        "\n\t\t2. Vědecký objektivismus - objekt je něco vnějšího, na čem nemáme účast"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Vědecký objektivismus je",
            textAnswer = "René Descartes (1596-1650), porenesanční filosofie" +
                "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                "\n\"Meditace o první filosofii\" - obraz světa" +
                "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                "\n\t-existuje však neomezená substance - Bůh" +
                "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                "\n-otec moderní filosofie" +
                "\n-subjekt-objekt rozměr" +
                "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)" +
                "\nVyšli z něj 2 protichudné cesty:" +
                "\n\t\t1. Zdůraznění subjektu ve filosofii Fichetoh (\"Jáství\")" +
                "\n\t\t2. Vědecký objektivismus - objekt je něco vnějšího, na čem nemáme účast",
            answers =
            listOf(
                PsychologyTermAnswer("objekt je něco vnějšího, na čem nemáme účast",
                    false,
                    "Descartes"
                ),
                PsychologyTermAnswer("zdůraznění subjektu - \"jáství\"",
                    false,
                    "Fichteho filosofie, návaznost na Descartese"
                ),
                PsychologyTermAnswer("vzájemné působení duchovní a hmotné substance prostřednictvím Boha",
                    false,
                    "okkasionalismus"
                ),
                PsychologyTermAnswer("činné síly uvnitř zvířat a všech věcí",
                    false,
                    "monády, Gottfried Wilhelm Leibniz"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Monáda je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("objekt je něco vnějšího, na čem nemáme účast",
                    false,
                    "Vědecký objektivismus, Návaznost na Descartese"
                ),
                PsychologyTermAnswer("zdůraznění subjektu - \"jáství\"",
                    false,
                    "Fichteho filosofie, návaznost na Descartese"
                ),
                PsychologyTermAnswer("vzájemné působení duchovní a hmotné substance prostřednictvím Boha",
                    false,
                    "okkasionalismus"
                ),
                PsychologyTermAnswer("činné síly uvnitř zvířat a všech věcí",
                    false,
                    "Gottfried Wilhelm Leibniz"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Autorem \"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jean-Francois Lyotard",
                    false,
                    "(1924), formuloval postmodernismus" +
                        "\n\"Postmoderní situace\"" +
                        "\n\t-co je pro naší dobu charakteristické?" +
                        "\n\t-meta-příběhy ztratily přesvědčivost" +
                        "\n\t-PLURALITA" +
                        "\n-ztráta veškeré jistoty - \"Všechno je možné\""
                ),
                PsychologyTermAnswer("Jacques Derrida",
                    false,
                    "(1930), postmodernismus, přehodnotil strukturalismus" +
                        "\n-znaky získávají význam díky vzájemnému odlišení - DIFERENCI" +
                        "\n-struktura je otevřená" +
                        "\ndiffere - 1. odkládání 2. rozmisťování" +
                        "\nSTOPA" +
                        "\n\t-zmizení transcendentálnosti, předcházení" +
                        "\n\t-filosofie není konstrukcí - je dekonstrukcí proměnlivých významů"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Celá příroda je plná života\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jean-Francois Lyotard",
                    false,
                    "(1924), formuloval postmodernismus" +
                        "\n\"Postmoderní situace\"" +
                        "\n\t-co je pro naší dobu charakteristické?" +
                        "\n\t-meta-příběhy ztratily přesvědčivost" +
                        "\n\t-PLURALITA" +
                        "\n-ztráta veškeré jistoty - \"Všechno je možné\""
                ),
                PsychologyTermAnswer("Jacques Derrida",
                    false,
                    "(1930), postmodernismus, přehodnotil strukturalismus" +
                        "\n-znaky získávají význam díky vzájemnému odlišení - DIFERENCI" +
                        "\n-struktura je otevřená" +
                        "\ndiffere - 1. odkládání 2. rozmisťování" +
                        "\nSTOPA" +
                        "\n\t-zmizení transcendentálnosti, předcházení" +
                        "\n\t-filosofie není konstrukcí - je dekonstrukcí proměnlivých významů"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Kdo je autorem tzv. \"předzjednané harmonie\"",
            textAnswer = "uloženo uvnitř monád, aby byl ve světě pořádek",
            answers =
            listOf(
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zástupcem anglického empirismu není",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař), novověká filosofie > anglický empirismus" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Isaac Newton",
                    false,
                    "(1643-1727), novověká filosofie, anglický empirismus" +
                        "\n-shrnul empirické a induktivní vědy do jedné matematické teorie" +
                        "\n-Newtonovo dílo zpopularizoval Francois Marie Voltaire" +
                        "\n-odmítnutí složených idejí"
                ),
                PsychologyTermAnswer("George Berkeley",
                    false,
                    "(1684-1753), irský biskup, novověká filosofie, anglický empirismus" +
                        "\n-společenost ovládána dvojicí mechanických sil:" +
                        "\n\todstředivostí - lidský egoismus" +
                        "\n\tdostředivostí - sdružovací pud" +
                        "\nBýti je totéž, co býti vnímáno (esse est percipi)" +
                        "\n->věci neexistují, dokud nejsou vnímány<" +
                        "\n-vliv na moderní idealismus (subjektivní)"
                ),
                PsychologyTermAnswer("David Hume",
                    false,
                    "(1711-1776), novověká filosofie, anglický empirismus" +
                        "\n-zkušenosti jsou naše duševní stavy" +
                        "\n-smyslové dojmy (imprese) != představy (ideje)" +
                        "\n-sdružování (asociace) idejí podle:" +
                        "\n\t\t1. podobnosti" +
                        "\n\t\t2. prostorové a časové sounáležitosti" +
                        "\n\t\t3. jako příčina a účinek" +
                        "\n\t-sdružování se však děje jen ze zvyku našich představ" +
                        "\n-pravděpodobnost kauzality - nikdy to není jisté" +
                        "\n-gnoseologický (poznávací) skepticismus (pochybování, prověřování našich schopností poznávat)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Společnost je ovládána dostředivou a odstředivou silou podle",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("George Berkeley",
                    false,
                    "(1684-1753), irský biskup, novověká filosofie, anglický empirismus" +
                        "\n-společenost ovládána dvojicí mechanických sil:" +
                        "\n\todstředivostí - lidský egoismus" +
                        "\n\tdostředivostí - sdružovací pud" +
                        "\nBýti je totéž, co býti vnímáno (esse est percipi)" +
                        "\n->věci neexistují, dokud nejsou vnímány<" +
                        "\n-vliv na moderní idealismus (subjektivní)"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař), novověká filosofie > anglický empirismus" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Isaac Newton",
                    false,
                    "(1643-1727), novověká filosofie, anglický empirismus" +
                        "\n-shrnul empirické a induktivní vědy do jedné matematické teorie" +
                        "\n-Newtonovo dílo zpopularizoval Francois Marie Voltaire" +
                        "\n-odmítnutí složených idejí"
                ),
                PsychologyTermAnswer("David Hume",
                    false,
                    "(1711-1776), novověká filosofie, anglický empirismus" +
                        "\n-zkušenosti jsou naše duševní stavy" +
                        "\n-smyslové dojmy (imprese) != představy (ideje)" +
                        "\n-sdružování (asociace) idejí podle:" +
                        "\n\t\t1. podobnosti" +
                        "\n\t\t2. prostorové a časové sounáležitosti" +
                        "\n\t\t3. jako příčina a účinek" +
                        "\n\t-sdružování se však děje jen ze zvyku našich představ" +
                        "\n-pravděpodobnost kauzality - nikdy to není jisté" +
                        "\n-gnoseologický (poznávací) skepticismus (pochybování, prověřování našich schopností poznávat)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"nic není v intelektu, co nebylo ve smyslech\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Deismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Bůh stvořil svět a dále do něj nezasahuje",
                    false,
                    "Deismus"
                ),
                PsychologyTermAnswer("obecné pojmy jsou jen jména",
                    false,
                    "nominalismus (nomina=jména)"
                ),
                PsychologyTermAnswer("přírodovědné zjednodušování člověka i společnosti",
                    false,
                    "redukcionismus"
                ),
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Redukcionismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Bůh stvořil svět a dále do něj nezasahuje",
                    false,
                    "Deismus"
                ),
                PsychologyTermAnswer("obecné pojmy jsou jen jména",
                    false,
                    "nominalismus (nomina=jména)"
                ),
                PsychologyTermAnswer("přírodovědné zjednodušování člověka i společnosti",
                    false,
                    "redukcionismus"
                ),
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "Racionalismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Bůh stvořil svět a dále do něj nezasahuje",
                    false,
                    "Deismus"
                ),
                PsychologyTermAnswer("obecné pojmy jsou jen jména",
                    false,
                    "nominalismus (nomina=jména)"
                ),
                PsychologyTermAnswer("přírodovědné zjednodušování člověka i společnosti",
                    false,
                    "redukcionismus"
                ),
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 5
        ),
        PsychologyTerm(
            prompt = "Skeptisismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Bůh stvořil svět a dále do něj nezasahuje",
                    false,
                    "Deismus"
                ),
                PsychologyTermAnswer("obecné pojmy jsou jen jména",
                    false,
                    "nominalismus (nomina=jména)"
                ),
                PsychologyTermAnswer("přírodovědné zjednodušování člověka i společnosti",
                    false,
                    "redukcionismus"
                ),
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 4
        ),
        PsychologyTerm(
            prompt = "Naivní realismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Bůh stvořil svět a dále do něj nezasahuje",
                    false,
                    "Deismus"
                ),
                PsychologyTermAnswer("obecné pojmy jsou jen jména",
                    false,
                    "nominalismus (nomina=jména)"
                ),
                PsychologyTermAnswer("přírodovědné zjednodušování člověka i společnosti",
                    false,
                    "redukcionismus"
                ),
                PsychologyTermAnswer("věci jsou takové, jak je vidíme",
                    false,
                    "Naivní realismus"
                ),
                PsychologyTermAnswer("pochybování, prověřování našich schopností poznávat",
                    false,
                    "Skeptisismus (skepsis=zkoumání)"
                ),
                PsychologyTermAnswer("principy a zásady rozumu jsou vrozené",
                    false,
                    "Racionalismus, Gnoseologie, R. Descartes"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Autorem \"Býti je totéž, co býti vnímáno \"(esse est percipi) je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("George Berkeley",
                    false,
                    "(1684-1753), irský biskup, novověká filosofie, anglický empirismus" +
                        "\n-společenost ovládána dvojicí mechanických sil:" +
                        "\n\todstředivostí - lidský egoismus" +
                        "\n\tdostředivostí - sdružovací pud" +
                        "\nBýti je totéž, co býti vnímáno (esse est percipi)" +
                        "\n->věci neexistují, dokud nejsou vnímány<" +
                        "\n-vliv na moderní idealismus (subjektivní)"
                ),
                PsychologyTermAnswer("David Hume",
                    false,
                    "(1711-1776), novověká filosofie, anglický empirismus" +
                        "\n-zkušenosti jsou naše duševní stavy" +
                        "\n-smyslové dojmy (imprese) != představy (ideje)" +
                        "\n-sdružování (asociace) idejí podle:" +
                        "\n\t\t1. podobnosti" +
                        "\n\t\t2. prostorové a časové sounáležitosti" +
                        "\n\t\t3. jako příčina a účinek" +
                        "\n\t-sdružování se však děje jen ze zvyku našich představ" +
                        "\n-pravděpodobnost kauzality - nikdy to není jisté" +
                        "\n-gnoseologický (poznávací) skepticismus (pochybování, prověřování našich schopností poznávat)"
                ),
                PsychologyTermAnswer("Charles-Louis Montesqueieu",
                    false,
                    "(1689-1755), novověká filosofie > francouzské osvícenství" +
                        "\n-satiricky porovnal Francii s východní despocií (autokracie)" +
                        "\n\t-král je nejmocnější, protože ovládá ducha poddaných" +
                        "\n-\"Duch zákonů\"" +
                        "\n\t-historie a forma práva, státu" +
                        "\n-kritika absolutního státu a teorie dělby moci (měla by být nezávislá soudní moc)"
                ),
                PsychologyTermAnswer("Francois Marie Voltaire",
                    false,
                    "(1694-1778)" +
                        "\n-výřečný mluvčí osvícenství" +
                        "\n-osvícenství určeno aristokracii, změny společnosti vyjdou z osvícenskhé panovníka" +
                        "\n-dějiny viděl ve sledu proměn kultur a ducha" +
                        "\n-deismus (Bůh stvořil svět a dále do něj nezasahuje)" +
                        "\n-\"Promlouvá jazykem, jemuž mohou rozumět všichni, i když si nerozumějí navzájem\"" +
                        "\n-myšlenky TOLERANCE" +
                        "\n-po zemětřesení v Lisabonu se stal pesimistou"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce francouzského osvícenství napatří",
            textAnswer = "-francouzská revoluce, boj proti autokracii a zastalosti náboženství" +
                "\n-francouzští materialisté a encyklopedisté",
            answers =
            listOf(
                PsychologyTermAnswer("David Hume",
                    false,
                    "(1711-1776), novověká filosofie, anglický empirismus" +
                        "\n-zkušenosti jsou naše duševní stavy" +
                        "\n-smyslové dojmy (imprese) != představy (ideje)" +
                        "\n-sdružování (asociace) idejí podle:" +
                        "\n\t\t1. podobnosti" +
                        "\n\t\t2. prostorové a časové sounáležitosti" +
                        "\n\t\t3. jako příčina a účinek" +
                        "\n\t-sdružování se však děje jen ze zvyku našich představ" +
                        "\n-pravděpodobnost kauzality - nikdy to není jisté" +
                        "\n-gnoseologický (poznávací) skepticismus (pochybování, prověřování našich schopností poznávat)"
                ),
                PsychologyTermAnswer("Charles-Louis Montesqueieu",
                    false,
                    "(1689-1755), novověká filosofie > francouzské osvícenství" +
                        "\n-satiricky porovnal Francii s východní despocií (autokracie)" +
                        "\n\t-král je nejmocnější, protože ovládá ducha poddaných" +
                        "\n-\"Duch zákonů\"" +
                        "\n\t-historie a forma práva, státu" +
                        "\n-kritika absolutního státu a teorie dělby moci (měla by být nezávislá soudní moc)"
                ),
                PsychologyTermAnswer("Francois Marie Voltaire",
                    false,
                    "(1694-1778)" +
                        "\n-výřečný mluvčí osvícenství" +
                        "\n-osvícenství určeno aristokracii, změny společnosti vyjdou z osvícenskhé panovníka" +
                        "\n-dějiny viděl ve sledu proměn kultur a ducha" +
                        "\n-deismus (Bůh stvořil svět a dále do něj nezasahuje)" +
                        "\n-\"Promlouvá jazykem, jemuž mohou rozumět všichni, i když si nerozumějí navzájem\"" +
                        "\n-myšlenky TOLERANCE" +
                        "\n-po zemětřesení v Lisabonu se stal pesimistou"
                ),
                PsychologyTermAnswer("Dietrich von Holbach",
                    false,
                    "(1723-1789), osvícenství, materialismus" +
                        "\n\"Systém přírody\"" +
                        "\n\t-vše je jen hmota, pouze její pohyb a hmota působí na naše smysly" +
                        "\n\t-MATERIALISTICKÝ MONISMUS (jednost)"
                ),
                PsychologyTermAnswer("J.O. la Mettrie",
                    false,
                    "(1709-1751), osvícenství, materialismus" +
                        "\n-netřeba rozlišovat mezi živou přírodou, stroji a člověkem" +
                        "\n-redukcionismus (přírodovědné zjednodušování člověka i společnosti)" +
                        "\n\t-v jeho případě na fyziologický produkt (míza stromu)"
                ),
                PsychologyTermAnswer("Denis Diderot",
                    false,
                    "(1713-1784), organizátor, redaktor - Novověká filosofie > Osvícenství" +
                        "\n\"Encyklopedie věd, umění a řemesel\" (28 svazků)" +
                        "\n\t-shrnutí vědění tehdejší doby a vyvození důsledků proti všemu zastaralému (náboženství)"
                ),
                PsychologyTermAnswer("J.B.Rond Alembert",
                    false,
                    "(1717-1783), matematik, Novověká filosofie > Osvícenství > encyklopedista" +
                        "\npodílel se na encyklopedii, v úvodu napsal:" +
                        "\n\t\"Věk náboženství a filosofie ustoupil století vědy\""
                ),
                PsychologyTermAnswer("Jean Jacques Rousseau",
                    false,
                    "(1712-1778), viděl negativně pokroky vědy" +
                        "\n-všude viděl bídu a pokrytectví - druhá strana osvícenství" +
                        "\n-\"pokrok\" civilizace potlačily přirozenou citovost člověka -> ÚPADEK LIDSKOSTI" +
                        "\n-se soukromým vlastnictvím a zákony vznikla ve společnosti nerovnost" +
                        "\n\t-nemyslí si však, že ideální stav někdy byl či bude" +
                        "\n\tObnovení přírody v člověku, rovnost všech -> svoboda+státní moc" +
                        "\n\t-\"Svoboda je poslušnost vůči zákonu, který jsme si stanovili\"" +
                        "\nspolečenská smlouva (Thomas Hobbes, J. Locke)" +
                        "\n\t-přidal \"suverenita lidu\"" +
                        "\n\ninspiroval romantismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Duch zákonů\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Charles-Louis Montesqueieu",
                    false,
                    "(1689-1755)" +
                        "\n-satiricky porovnal Francii s východní despocií (autokracie)" +
                        "\n\t-král je nejmocnější, protože ovládá ducha poddaných" +
                        "\n-\"Duch zákonů\"" +
                        "\n\t-historie a forma práva, státu" +
                        "\n-kritika absolutního státu a teorie dělby moci (měla by být nezávislá soudní moc)"
                ),
                PsychologyTermAnswer("Denis Diderot",
                    false,
                    "(1713-1784), organizátor, redaktor - Novověká filosofie > Osvícenství" +
                        "\n\"Encyklopedie věd, umění a řemesel\" (28 svazků)" +
                        "\n\t-shrnutí vědění tehdejší doby a vyvození důsledků proti všemu zastaralému (náboženství)"
                ),
                PsychologyTermAnswer("J.B.Rond Alembert",
                    false,
                    "(1717-1783), matematik, Novověká filosofie > Osvícenství > encyklopedista" +
                        "\npodílel se na encyklopedii, v úvodu napsal:" +
                        "\n\t\"Věk náboženství a filosofie ustoupil století vědy\""
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. \"výřečným mluvčím\" osvícenství byl",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Francois Marie Voltaire",
                    false,
                    "(1694-1778)" +
                        "\n-výřečný mluvčí osvícenství" +
                        "\n-osvícenství určeno aristokracii, změny společnosti vyjdou z osvícenskhé panovníka" +
                        "\n-dějiny viděl ve sledu proměn kultur a ducha" +
                        "\n-deismus (Bůh stvořil svět a dále do něj nezasahuje)" +
                        "\n-\"Promlouvá jazykem, jemuž mohou rozumět všichni, i když si nerozumějí navzájem\"" +
                        "\n-myšlenky TOLERANCE" +
                        "\n-po zemětřesení v Lisabonu se stal pesimistou"
                ),
                PsychologyTermAnswer("Dietrich von Holbach",
                    false,
                    "(1723-1789), osvícenství, materialismus" +
                        "\n\"Systém přírody\"" +
                        "\n\t-vše je jen hmota, pouze její pohyb a hmota působí na naše smysly" +
                        "\n\t-MATERIALISTICKÝ MONISMUS (jednost)"
                ),
                PsychologyTermAnswer("J.O. la Mettrie",
                    false,
                    "(1709-1751), osvícenství, materialismus" +
                        "\n-netřeba rozlišovat mezi živou přírodou, stroji a člověkem" +
                        "\n-redukcionismus (přírodovědné zjednodušování člověka i společnosti)" +
                        "\n\t-v jeho případě na fyziologický produkt (míza stromu)"
                ),
                PsychologyTermAnswer("David Hume",
                    false,
                    "(1711-1776), novověká filosofie, anglický empirismus" +
                        "\n-zkušenosti jsou naše duševní stavy" +
                        "\n-smyslové dojmy (imprese) != představy (ideje)" +
                        "\n-sdružování (asociace) idejí podle:" +
                        "\n\t\t1. podobnosti" +
                        "\n\t\t2. prostorové a časové sounáležitosti" +
                        "\n\t\t3. jako příčina a účinek" +
                        "\n\t-sdružování se však děje jen ze zvyku našich představ" +
                        "\n-pravděpodobnost kauzality - nikdy to není jisté" +
                        "\n-gnoseologický (poznávací) skepticismus (pochybování, prověřování našich schopností poznávat)"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Encyklopedie věd, umění a řemesel\" byl",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Denis Diderot",
                    false,
                    "(1713-1784), organizátor, redaktor - Novověká filosofie > Osvícenství" +
                        "\n\"Encyklopedie věd, umění a řemesel\" (28 svazků)" +
                        "\n\t-shrnutí vědění tehdejší doby a vyvození důsledků proti všemu zastaralému (náboženství)"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Fridrich Schiller",
                    false,
                    "(1759-1805), novověká filosofie > německá romantika" +
                        "\n-Kantův žák"
                ),
                PsychologyTermAnswer("Johann W. Goethe",
                    false,
                    "(1749-1832), novověká filosofie > německá romantika" +
                        "\n-navázal na renesanční hermetismus (celostnost)" +
                        "\n-proti abstrakci a empirii - přímé vidění podstaty - \"V tom nitru už dlíme\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Výrok \"Věk náboženství a filosofie ustoupil století vědy\" byl",
            textAnswer = "(na začátku encyklopedie). Jedná se o francouzské osvícenství (novověká filosofie do 19.st.)",
            answers =
            listOf(
                PsychologyTermAnswer("J.B.Rond Alembert",
                    false,
                    "(1717-1783), matematik, Novověká filosofie > Osvícenství > encyklopedista" +
                        "\npodílel se na encyklopedii, v úvodu napsal:" +
                        "\n\t\"Věk náboženství a filosofie ustoupil století vědy\""
                ),
                PsychologyTermAnswer("T.G. Masaryk",
                    false,
                    "(1850-1937), Husserl, Brentano" +
                        "\n\"Sebevražda jako masový jev moderní civilizace\"" +
                        "\n\t-kritika moderní doby, dříve se lidé dokázaly vypořádat s obtížemi života" +
                        "\n\t-ztráta harmonie rozumu a morálky - \"patologický stav všeobecné nervozity\"" +
                        "\n\t-prvně vidí východisko v náboženství, následně v IDEÁLU HUMANITY" +
                        "\n-filosofie a politika - rub a líc téže mince" +
                        "\n-lidskou existenci ohrožují hotové názory, nacionální, rasové, či třídní \"mýty\" a předsudky"
                ),
                PsychologyTermAnswer("Jean Jacques Rousseau",
                    false,
                    "(1712-1778), viděl negativně pokroky vědy" +
                        "\n-všude viděl bídu a pokrytectví - druhá strana osvícenství" +
                        "\n-\"pokrok\" civilizace potlačily přirozenou citovost člověka -> ÚPADEK LIDSKOSTI" +
                        "\n-se soukromým vlastnictvím a zákony vznikla ve společnosti nerovnost" +
                        "\n\t-nemyslí si však, že ideální stav někdy byl či bude" +
                        "\n\tObnovení přírody v člověku, rovnost všech -> svoboda+státní moc" +
                        "\n\t-\"Svoboda je poslušnost vůči zákonu, který jsme si stanovili\"" +
                        "\nspolečenská smlouva (Thomas Hobbes, J. Locke)" +
                        "\n\t-přidal \"suverenita lidu\"" +
                        "\n\ninspiroval romantismus"
                ),
                PsychologyTermAnswer("Auguste Comte",
                    false,
                    "(1798-1857) pozitivismus, francouz" +
                        "\npozitivismus - pozitivní, tedy věcné, určité, zkušenost > rozum" +
                        "\n3. stádia vývoje vědění:" +
                        "\n\t1. teologické (nadpřirozenost)" +
                        "\n\t2. metafyzické (nadpřirozeno nahrazeno abstrakcí)" +
                        "\n\t3. pozitivní stádium (faktuální)" +
                        "\n-nové poznatky třídit do soustavy věd (návaznost na encyklopedisty)" +
                        "\nSOCIOLOGIE" +
                        "\n\t-společnost (sociální fakta) zkoumána vědeckými metodami"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autor výroku \"Svoboda je poslušnost vůči zákonu, který jsme si stanovili\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Jacques Rousseau",
                    false,
                    "(1712-1778), viděl negativně pokroky vědy" +
                        "\n-všude viděl bídu a pokrytectví - druhá strana osvícenství" +
                        "\n-\"pokrok\" civilizace potlačily přirozenou citovost člověka -> ÚPADEK LIDSKOSTI" +
                        "\n-se soukromým vlastnictvím a zákony vznikla ve společnosti nerovnost" +
                        "\n\t-nemyslí si však, že ideální stav někdy byl či bude" +
                        "\n\tObnovení přírody v člověku, rovnost všech -> svoboda+státní moc" +
                        "\n\t-\"Svoboda je poslušnost vůči zákonu, který jsme si stanovili\"" +
                        "\nspolečenská smlouva (Thomas Hobbes, J. Locke)" +
                        "\n\t-přidal \"suverenita lidu\"" +
                        "\n\ninspiroval romantismus"
                ),
                PsychologyTermAnswer("T.G. Masaryk",
                    false,
                    "(1850-1937), Husserl, Brentano" +
                        "\n\"Sebevražda jako masový jev moderní civilizace\"" +
                        "\n\t-kritika moderní doby, dříve se lidé dokázaly vypořádat s obtížemi života" +
                        "\n\t-ztráta harmonie rozumu a morálky - \"patologický stav všeobecné nervozity\"" +
                        "\n\t-prvně vidí východisko v náboženství, následně v IDEÁLU HUMANITY" +
                        "\n-filosofie a politika - rub a líc téže mince" +
                        "\n-lidskou existenci ohrožují hotové názory, nacionální, rasové, či třídní \"mýty\" a předsudky"
                ),
                PsychologyTermAnswer("Auguste Comte",
                    false,
                    "(1798-1857) pozitivismus, francouz" +
                        "\npozitivismus - pozitivní, tedy věcné, určité, zkušenost > rozum" +
                        "\n3. stádia vývoje vědění:" +
                        "\n\t1. teologické (nadpřirozenost)" +
                        "\n\t2. metafyzické (nadpřirozeno nahrazeno abstrakcí)" +
                        "\n\t3. pozitivní stádium (faktuální)" +
                        "\n-nové poznatky třídit do soustavy věd (návaznost na encyklopedisty)" +
                        "\nSOCIOLOGIE" +
                        "\n\t-společnost (sociální fakta) zkoumána vědeckými metodami"
                ),
                PsychologyTermAnswer("Ludwig Feuerbach",
                    false,
                    "(1804-1872), Německo" +
                        "\n-návaznost na Hegela, odmítl absolutní idei (ideje v každé věci, absolutní)" +
                        "\nKritika náboženství" +
                        "\n\t-náboženství vzniklo z lidského egoismu" +
                        "\n\t-vysvětlení náboženství antropologicky a materialisticky (z přírodní podstaty člověka - smysly)" +
                        "\n\t-smyslovost a emoce člověk vtělil do Boha (odcizil sám sobě)" +
                        "\n\t\t-potřeba vztáhnout zpět do svého živoate - NÁBOŽENSTVÍ ČLOVĚKA" +
                        "\n\t\t\t-láska k lidem, nikoliv Bohu"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Etika vyložená způsobem užívaným v geometrii\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("J. Gottlieb Fichte",
                    false,
                    "(1762-1814), novověká filosofie > německá romanticko-idealistická filosofie" +
                        "\nNesouhlas s vztahem aposteriorním (odvozeným) a apriorním (předem daný) poznáním" +
                        "\n\t-\"buď jedno, nebo druhé\":" +
                        "\n\t\t-buď pasivní povaha - od věci (sensualismus, materialismus)" +
                        "\n\t\t-anebo >mé Já aktivně< kladě před sebe předmět poznání a >vytváří svět v ideji< a obrazotvornosti (idealismus)" +
                        "\n-Aktivitu ducha demonstruje dialektickou metodou"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"V tom nitru už dlíme\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("J. Wolfgang Goethe",
                    false,
                    "(1749-1832), novověká filosofie > německá romantika" +
                        "\n-navázal na renesanční hermetismus (celostnost)" +
                        "\n-proti abstrakci a empirii - přímé vidění podstaty - \"V tom nitru už dlíme\""
                ),
                PsychologyTermAnswer("J.G. Herder",
                    false,
                    "(1744-1803), novověká filosofie > německá romantika" +
                        "\n-fil. zkoumání dějin a jazyka-individuální povahy národa" +
                        "\n-vliv na naše národní obrození"
                ),
                PsychologyTermAnswer("J. Gottlieb Fichte",
                    false,
                    "(1762-1814), novověká filosofie > německá romanticko-idealistická filosofie" +
                        "\nNesouhlas s vztahem aposteriorním (odvozeným) a apriorním (předem daný) poznáním" +
                        "\n\t-\"buď jedno, nebo druhé\":" +
                        "\n\t\t-buď pasivní povaha - od věci (sensualismus, materialismus)" +
                        "\n\t\t-anebo >mé Já aktivně< kladě před sebe předmět poznání a >vytváří svět v ideji< a obrazotvornosti (idealismus)" +
                        "\n-Aktivitu ducha demonstruje dialektickou metodou"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Idea polarity je spojována s",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("J. Gottlieb Fichte",
                    false,
                    "(1762-1814), novověká filosofie > německá romanticko-idealistická filosofie" +
                        "\nNesouhlas s vztahem aposteriorním (odvozeným) a apriorním (předem daný) poznáním" +
                        "\n\t-\"buď jedno, nebo druhé\":" +
                        "\n\t\t-buď pasivní povaha - od věci (sensualismus, materialismus)" +
                        "\n\t\t-anebo >mé Já aktivně< kladě před sebe předmět poznání a >vytváří svět v ideji< a obrazotvornosti (idealismus)" +
                        "\n-Aktivitu ducha demonstruje dialektickou metodou"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Ludwig Feuerbach",
                    false,
                    "(1804-1872), Německo" +
                        "\n-návaznost na Hegela, odmítl absolutní idei (ideje v každé věci, absolutní)" +
                        "\nKritika náboženství" +
                        "\n\t-náboženství vzniklo z lidského egoismu" +
                        "\n\t-vysvětlení náboženství antropologicky a materialisticky (z přírodní podstaty člověka - smysly)" +
                        "\n\t-smyslovost a emoce člověk vtělil do Boha (odcizil sám sobě)" +
                        "\n\t\t-potřeba vztáhnout zpět do svého živoate - NÁBOŽENSTVÍ ČLOVĚKA" +
                        "\n\t\t\t-láska k lidem, nikoliv Bohu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Kritika čistého rozumu\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("Ludwig Feuerbach",
                    false,
                    "(1804-1872), Německo" +
                        "\n-návaznost na Hegela, odmítl absolutní idei (ideje v každé věci, absolutní)" +
                        "\nKritika náboženství" +
                        "\n\t-náboženství vzniklo z lidského egoismu" +
                        "\n\t-vysvětlení náboženství antropologicky a materialisticky (z přírodní podstaty člověka - smysly)" +
                        "\n\t-smyslovost a emoce člověk vtělil do Boha (odcizil sám sobě)" +
                        "\n\t\t-potřeba vztáhnout zpět do svého živoate - NÁBOŽENSTVÍ ČLOVĚKA" +
                        "\n\t\t\t-láska k lidem, nikoliv Bohu"
                ),
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem tzv. koperníkovského obratu je",
            textAnswer = "dosud poznání vykládáno z předmětu, nyní z člověka" +
            "\n\t\t-jsme to my, kdo vznášíme řád do světa",
            answers =
            listOf(
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("Francis Bacon",
                    false,
                    "(1561-1626), součastník Shakespeara" +
                        "\n-nedokončený myšlenkový projekt \"Velké obnovení věd\"" +
                        "\n-empirismus, věda" +
                        "\n-\"Novum Organon\"" +
                        "\n\t-předpoklady rozumu a poznání - jejich překážky" +
                        "\n\t1. Idoly jeskyně" +
                        "\n\t\t-předsudky vlivem naší individuality" +
                        "\n\t2. Idoly kmene" +
                        "\n\t\t-předsudky celého lidského rodu - zaslepuje nás omezená lidská perspektiva" +
                        "\n\t3. Idoly tržiště" +
                        "\n\t\t-ve společenském styku" +
                        "\n\t4. Idoly divadla" +
                        "\n\t\t-děděné předsudky - po generace, od autorit" +
                        "\n>Praktická účinnost< - \"Užitečná filosofie\"" +
                        "\n\t-přírodu lze nejen využít, ale donutit" +
                        "\n-\"Vědění je moc\"" +
                        "\n-\"Nová Atlantida\"" +
                        "\n\t-ideální společnost řízená učenci"
                ),
                PsychologyTermAnswer("Ludwig Feuerbach",
                    false,
                    "(1804-1872), Německo" +
                        "\n-návaznost na Hegela, odmítl absolutní idei (ideje v každé věci, absolutní)" +
                        "\nKritika náboženství" +
                        "\n\t-náboženství vzniklo z lidského egoismu" +
                        "\n\t-vysvětlení náboženství antropologicky a materialisticky (z přírodní podstaty člověka - smysly)" +
                        "\n\t-smyslovost a emoce člověk vtělil do Boha (odcizil sám sobě)" +
                        "\n\t\t-potřeba vztáhnout zpět do svého živoate - NÁBOŽENSTVÍ ČLOVĚKA" +
                        "\n\t\t\t-láska k lidem, nikoliv Bohu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. negace negace je charakteristická pro",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("John Locke",
                    false,
                    "(1632-1704), šlechtická rodina (učitel, lékař)" +
                        "\n-lidé nemají vrozené ideje, spíše zvyk (věrnost)" +
                        "\n\"Esej o lidském mozku\"" +
                        "\n\t-vychází z axiomu \"nic není v intelektu, co nebylo ve smyslech\"" +
                        "\n-lidská mysl je nepopsaným papírem (tabula rasa), na který se zapisuje pomocí smyslů (sensualismus)" +
                        "\n\t-mysl uspořádává počitky do idejí (\"ideje nepatří věcem\")" +
                        "\n\t-kombinováno s jednodušší představou (např. krása v porovnání s jinou věcí)" +
                        "\n\nfilosofie státu" +
                        "\n\t-spoleenské smlouvy a přirozené právo" +
                        "\n\t-přirozený stav je svoboda" +
                        "\n\t-panovník následuje, nevytváří právo, pokud nenásleduje, lid je schopen vypovědět \"smlouvu\""
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("Thomas Hobbes",
                    false,
                    "(1588-1679), agličan, stát, právo" +
                        "\n\t-přirozenost člověka je egoismus" +
                        "\n\tTeorie společenské smlouvy" +
                        "\n\t-lidé se dohodli mít nad sebou moc, aby se navzájem nepovraždili" +
                        "\n\t-stát je obrovské těleso, jak bájná příšera \"Leviathan\" - absolutismus (absolutus=úplný, úplná, centrální vláda)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. jednota protikladů je charakteristická pro",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("J. Gottlieb Fichte",
                    false,
                    "(1762-1814), novověká filosofie > německá romanticko-idealistická filosofie" +
                        "\nNesouhlas s vztahem aposteriorním (odvozeným) a apriorním (předem daný) poznáním" +
                        "\n\t-\"buď jedno, nebo druhé\":" +
                        "\n\t\t-buď pasivní povaha - od věci (sensualismus, materialismus)" +
                        "\n\t\t-anebo >mé Já aktivně< kladě před sebe předmět poznání a >vytváří svět v ideji< a obrazotvornosti (idealismus)" +
                        "\n-Aktivitu ducha demonstruje dialektickou metodou"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Hegelovská tríada se skládá z",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("teze, antiteze, synteze",
                    false,
                    ""
                ),
                PsychologyTermAnswer("geneze, syntéze, antiteze",
                    false,
                    ""
                ),
                PsychologyTermAnswer("ontologie, synteze, logiky",
                    false,
                    "Ontologie = nauka o bytí"
                ),
                PsychologyTermAnswer("antiteze, synteze, antisynteze",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pojem sebevědomí vytvořil",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("J. Gottlieb Fichte",
                    false,
                    "(1762-1814), novověká filosofie > německá romanticko-idealistická filosofie" +
                        "\nNesouhlas s vztahem aposteriorním (odvozeným) a apriorním (předem daný) poznáním" +
                        "\n\t-\"buď jedno, nebo druhé\":" +
                        "\n\t\t-buď pasivní povaha - od věci (sensualismus, materialismus)" +
                        "\n\t\t-anebo >mé Já aktivně< kladě před sebe předmět poznání a >vytváří svět v ideji< a obrazotvornosti (idealismus)" +
                        "\n-Aktivitu ducha demonstruje dialektickou metodou"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jako otec moderní filosofie je považován",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)"
                ),
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("J. Gottlieb Fichte",
                    false,
                    "(1762-1814), novověká filosofie > německá romanticko-idealistická filosofie" +
                        "\nNesouhlas s vztahem aposteriorním (odvozeným) a apriorním (předem daný) poznáním" +
                        "\n\t-\"buď jedno, nebo druhé\":" +
                        "\n\t\t-buď pasivní povaha - od věci (sensualismus, materialismus)" +
                        "\n\t\t-anebo >mé Já aktivně< kladě před sebe předmět poznání a >vytváří svět v ideji< a obrazotvornosti (idealismus)" +
                        "\n-Aktivitu ducha demonstruje dialektickou metodou"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"Svoboda je poznaná nutnost\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("Mikuláš Kusánský",
                    false,
                    "Renesanční \"přírodní\" filosofie" +
                        "\n(1401-1464), teolog, \"co je Bůh a je možné ho pochopit?\"" +
                        "\n\t-\"O učené nevědomosti\"" +
                        "\n\t-3 ontologická (nauka o bytí) jsoucna" +
                        "\n\t\t1. Bůh je absolutní nekonečno" +
                        "\n\t\t2. Svět, universum je odvozené nekonečno" +
                        "\n\t\t3. Jednotlivé věci jsou nekonečné" +
                        "\n-hypotéza pohybu Země" +
                        "\n-z kvality (proč co je a čím co je) k kvantitě (v jaké míře co je)" +
                        "\n-nahrazuje scholastický pojem substance za >vztah, kontrakce<" +
                        "\n-Universum a svět jsou vědecké objekty - dají se měřit"
                ),
                PsychologyTermAnswer("Giordano Bruno",
                    false,
                    "(1548-1600), ital, Hermetická filosofie" +
                        "\n-byl JEN CHVÍLI v dominikánském řádu" +
                        "\n-ztělesnil drama své doby, její ruiny, růže i trny" +
                        "\n\t-podrazen přítelem v Benátkách, pronásledován a následně upálen" +
                        "\n-idealista, který má nedostatek vědeckých podkladů (Galileo kritizoval jeho matematické chyby)" +
                        "\n-\"Vesmír je plný života\", a nekonečný" +
                        "\n-božský princip vně přírody - panteismus" +
                        "\n-v historii vidí nekonečné vývojové možnosti" +
                        "\n-kritizuje hrabivost civilizovaných Evropanů vykořisťující \"primitivní\" kmeny" +
                        "\n-napadá náboženskou nesnášenlivost" +
                        "\n\t-\"téhož Písma používají židé, křesťané i mohamedáni\"" +
                        "\nUniversalistické pojetí vesmíru (vše je nějak ve všem)"
                ),
                PsychologyTermAnswer("Michel Foucault",
                    false,
                    "(1926-1984), postmodernismus, archeologie vědění" +
                        "\n-zavádí pojem epistémé (systém či řád, kterým předem regulujeme čím se vědění zabývá a jak to činí)" +
                        "\n-epistémé se děje vždy skokem, dějiny nejsou kontinuální, ale diskontinuální" +
                        "\n\t-diskurs - argumentovaný dialog uvnitř kultury"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "S teorií společenské smlouvy přišel",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Thomas Hobbes",
                    false,
                    "(1588-1679), agličan, stát, právo" +
                        "\n\t-přirozenost člověka je egoismus" +
                        "\n\tTeorie společenské smlouvy" +
                        "\n\t-lidé se dohodli mít nad sebou moc, aby se navzájem nepovraždili" +
                        "\n\t-stát je obrovské těleso, jak bájná příšera \"Leviathan\" - absolutismus (absolutus=úplný, úplná, centrální vláda)"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("F.W.J. Schelling",
                    false,
                    "(1775-1854), novověká filosofie > německá romantika" +
                        "\nhlavní rysy romantického hnutí" +
                        "\n\t-intuitivní myšlení, emocionalita a příroda" +
                        "\nIDEA POLARITY (jako magnet)" +
                        "\n\t2 póly světa:" +
                        "\n\t\t1. subjektivní (ideový) svět (duch a dějiny)" +
                        "\n\t\t2.objektivní (hmotný) svět" +
                        "\n\t-ve světě nikdy není jen jedno nebo druhé, pouze převažování jednoho" +
                        "\n\tprazáklad obsažen absolutní jednotou objektu a subjektu" +
                        "\nFILOSOFIE IDENTITY" +
                        "\n\t-emotivní panteismus (spojení Boha a přírody)" +
                        "\n\t-Hegel má spíše logický panteismus"
                ),
                PsychologyTermAnswer("Auguste Comte",
                    false,
                    "(1798-1857) pozitivismus, francouz" +
                        "\npozitivismus - pozitivní, tedy věcné, určité, zkušenost > rozum" +
                        "\n3. stádia vývoje vědění:" +
                        "\n\t1. teologické (nadpřirozenost)" +
                        "\n\t2. metafyzické (nadpřirozeno nahrazeno abstrakcí)" +
                        "\n\t3. pozitivní stádium (faktuální)" +
                        "\n-nové poznatky třídit do soustavy věd (návaznost na encyklopedisty)" +
                        "\nSOCIOLOGIE" +
                        "\n\t-společnost (sociální fakta) zkoumána vědeckými metodami"
                ),
                PsychologyTermAnswer("J. Stuart Mill",
                    false,
                    "(1806-1873), Anglie, pozitivismus, spíše psychologie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi pohegelovské filosofie nepatří",
            textAnswer = "19.-20.st.",
            answers =
            listOf(
                PsychologyTermAnswer("romantika",
                    false,
                    "novověká filosofie - osvícenství"
                ),
                PsychologyTermAnswer("pozitivismus",
                    false,
                    "důraz na vědecký přístup a objektivitu poznání" +
                        "\npozitivní, věcné, určité, zkušenost se nedá popsat rozumem"
                ),
                PsychologyTermAnswer("marxismus",
                    false,
                    "důraz na vědecký přístup a objektivitu poznání"
                ),
                PsychologyTermAnswer("iracionalismus",
                    false,
                    "přístupy odmítající možnost rozumového vysvětlení světa, návaznost na Shellinga"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Přístup odmítající možnost rozumového vysvětlení světa se nazývá",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("iracionalismus",
                    false,
                    "návaznost na Schellinga"
                ),
                PsychologyTermAnswer("pragmatismus",
                    false,
                    "filosofie činu a užitku (pragma=jednání), praktické uplatnění"
                ),
                PsychologyTermAnswer("voluntarismus",
                    false,
                    "vstupujeme do podstaty světa vůlí - např. vůle žít, proto žijeme"
                ),
                PsychologyTermAnswer("pozitivismus",
                    false,
                    "pozitivní, věcné, určité, zkušenost se nedá popsat rozumem"
                ),
                PsychologyTermAnswer("antiscientismus",
                    false,
                    "orientace na vnitřní svět"
                ),
                PsychologyTermAnswer("fenomologie",
                    false,
                    "věda, zkoumající fenomény (jevy) našeho vědomí"
                ),
                PsychologyTermAnswer("psychologismus",
                    false,
                    "řešení zákonitosti lidského poznání v rámci psychologického rozboru a popisu procesů lids. vnímání"
                ),
                PsychologyTermAnswer("existencialismus",
                    false,
                    "problém existence, výzva ke svobodě a odpovědnosti"
                ),
                PsychologyTermAnswer("novotomismus",
                    false,
                    "harmonie víry a racionální poznání vědy, navazuje na T.e Akvinského" +
                        "\n\"aggiornamento\" - přiblížení církve dnešnímu dni"
                ),
                PsychologyTermAnswer("personalismus",
                    false,
                    "člověk považován za nejvyšší hodnotu a zároveň zdroj všech hodnot"
                ),
                PsychologyTermAnswer("protestantismus",
                    false,
                    "problémy člověka v současném světě"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "filosofie činu a užitku, praktické uplatnění",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("iracionalismus",
                    false,
                    "Přístup odmítající možnost rozumového vysvětlení světa se nazývá, návaznost na Schellinga"
                ),
                PsychologyTermAnswer("pragmatismus",
                    false,
                    "(pragma=jednání)"
                ),
                PsychologyTermAnswer("voluntarismus",
                    false,
                    "vstupujeme do podstaty světa vůlí - např. vůle žít, proto žijeme"
                ),
                PsychologyTermAnswer("pozitivismus",
                    false,
                    "pozitivní, věcné, určité, zkušenost se nedá popsat rozumem"
                ),
                PsychologyTermAnswer("antiscientismus",
                    false,
                    "orientace na vnitřní svět"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 1
        ),
        PsychologyTerm(
            prompt = "vstupujeme do podstaty světa vůlí - např. vůle žít, proto žijeme",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("iracionalismus",
                    false,
                    "Přístup odmítající možnost rozumového vysvětlení světa se nazývá, návaznost na Schellinga"
                ),
                PsychologyTermAnswer("pragmatismus",
                    false,
                    "filosofie činu a užitku (pragma=jednání), praktické uplatnění"
                ),
                PsychologyTermAnswer("voluntarismus",
                    false,
                    "vstupujeme do podstaty světa vůlí - např. vůle žít, proto žijeme"
                ),
                PsychologyTermAnswer("pozitivismus",
                    false,
                    "pozitivní, věcné, určité, zkušenost se nedá popsat rozumem"
                ),
                PsychologyTermAnswer("antiscientismus",
                    false,
                    "orientace na vnitřní svět"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = "věcné, určité, zkušenost se nedá popsat rozumem",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("iracionalismus",
                    false,
                    "Přístup odmítající možnost rozumového vysvětlení světa se nazývá, návaznost na Schellinga"
                ),
                PsychologyTermAnswer("pragmatismus",
                    false,
                    "filosofie činu a užitku (pragma=jednání), praktické uplatnění"
                ),
                PsychologyTermAnswer("voluntarismus",
                    false,
                    "vstupujeme do podstaty světa vůlí - např. vůle žít, proto žijeme"
                ),
                PsychologyTermAnswer("pozitivismus",
                    false,
                    "pozitivní, věcné, určité, zkušenost se nedá popsat rozumem"
                ),
                PsychologyTermAnswer("antiscientismus",
                    false,
                    "orientace na vnitřní svět"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "orientace na vnitřní svět, namísto empirismu a pozitivismus",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("iracionalismus",
                    false,
                    "Přístup odmítající možnost rozumového vysvětlení světa se nazývá, návaznost na Schellinga"
                ),
                PsychologyTermAnswer("pragmatismus",
                    false,
                    "filosofie činu a užitku (pragma=jednání), praktické uplatnění"
                ),
                PsychologyTermAnswer("voluntarismus",
                    false,
                    "vstupujeme do podstaty světa vůlí - např. vůle žít, proto žijeme"
                ),
                PsychologyTermAnswer("pozitivismus",
                    false,
                    "pozitivní, věcné, určité, zkušenost se nedá popsat rozumem"
                ),
                PsychologyTermAnswer("antiscientismus",
                    false,
                    "orientace na vnitřní svět"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 4
        ),
        PsychologyTerm(
            prompt = "věda, zkoumající jevy našeho vědomí",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("fenomologie",
                    false,
                    "věda, zkoumající fenomény (jevy) našeho vědomí"
                ),
                PsychologyTermAnswer("psychologismus",
                    false,
                    "řešení zákonitosti lidského poznání v rámci psychologického rozboru a popisu procesů lids. vnímání"
                ),
                PsychologyTermAnswer("existencialismus",
                    false,
                    "problém existence, výzva ke svobodě a odpovědnosti"
                ),
                PsychologyTermAnswer("novotomismus",
                    false,
                    "harmonie víry a racionální poznání vědy, navazuje na T.e Akvinského" +
                        "\n\"aggiornamento\" - přiblížení církve dnešnímu dni"
                ),
                PsychologyTermAnswer("personalismus",
                    false,
                    "člověk považován za nejvyšší hodnotu a zároveň zdroj všech hodnot"
                ),
                PsychologyTermAnswer("protestantismus",
                    false,
                    "problémy člověka v současném světě"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "harmonie víry a racionální poznání vědy",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("fenomologie",
                    false,
                    "věda, zkoumající fenomény (jevy) našeho vědomí"
                ),
                PsychologyTermAnswer("psychologismus",
                    false,
                    "řešení zákonitosti lidského poznání v rámci psychologického rozboru a popisu procesů lids. vnímání"
                ),
                PsychologyTermAnswer("existencialismus",
                    false,
                    "problém existence, výzva ke svobodě a odpovědnosti"
                ),
                PsychologyTermAnswer("novotomismus",
                    false,
                    "harmonie víry a racionální poznání vědy, navazuje na T.e Akvinského" +
                        "\n\"aggiornamento\" - přiblížení církve dnešnímu dni"
                ),
                PsychologyTermAnswer("personalismus",
                    false,
                    "člověk považován za nejvyšší hodnotu a zároveň zdroj všech hodnot"
                ),
                PsychologyTermAnswer("protestantismus",
                    false,
                    "problémy člověka v současném světě"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 3
        ),
        PsychologyTerm(
            prompt = "Personalismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("věda, zkoumající jevy našeho vědomí",
                    false,
                    "fenomologie"
                ),
                PsychologyTermAnswer("řešení zákonitosti lidského poznání v rámci psychologického rozboru a popisu procesů lids. vnímání",
                    false,
                    "psychologismus"
                ),
                PsychologyTermAnswer("problém existence, výzva ke svobodě a odpovědnosti",
                    false,
                    "existencialismus"
                ),
                PsychologyTermAnswer("harmonie víry a racionální poznání vědy",
                    false,
                    "Novotomismus" +
                        "\nharmonie víry a racionální poznání vědy, navazuje na T.e Akvinského" +
                        "\n\"aggiornamento\" - přiblížení církve dnešnímu dni"
                ),
                PsychologyTermAnswer("člověk považován za nejvyšší hodnotu a zároveň zdroj všech hodnot",
                    false,
                    "Personalismus, v době křesťanství 20.st."
                ),
                PsychologyTermAnswer("problémy člověka v současném světě",
                    false,
                    "protestantismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 4
        ),
        PsychologyTerm(
            prompt = "Jako společnost zkoumána vědeckými metodami popsal sociologii",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Auguste Comte",
                    false,
                    "(1798-1857) pozitivismus, francouz" +
                        "\npozitivismus - pozitivní, tedy věcné, určité, zkušenost > rozum" +
                        "\n3. stádia vývoje vědění:" +
                        "\n\t1. teologické (nadpřirozenost)" +
                        "\n\t2. metafyzické (nadpřirozeno nahrazeno abstrakcí)" +
                        "\n\t3. pozitivní stádium (faktuální)" +
                        "\n-nové poznatky třídit do soustavy věd (návaznost na encyklopedisty)" +
                        "\nSOCIOLOGIE" +
                        "\n\t-společnost (sociální fakta) zkoumána vědeckými metodami"
                ),
                PsychologyTermAnswer("Herbet Spencer",
                    false,
                    "(1820-1903), Anglie, inspirace Darwinem" +
                        "\n-EVOLUČNÍ ZÁKON - biologický, ale i sociální vývoj, fakta"
                ),
                PsychologyTermAnswer("Ernst Mach",
                    false,
                    "(1838-1916), fyzik, Brno" +
                        "\nnovopozitivismus, empiriokriticismus (druhý pozitivismus)"
                ),
                PsychologyTermAnswer("Karel Marx",
                    false,
                    "(1818-1883), materialismus" +
                        "\n-změnil Hegelovu dialektiku:" +
                        "\n\t-podstatou světa je materiální skutečnost" +
                        "\n\t-ideje jsou jen odrazem mat. skutečnosti v lidském vědomí" +
                        "\nPodstata člověka je práce" +
                        "\n\t-při ní se však člověk odcizil své podstatě" +
                        "\n\t-sociální, ekonomická nerovnost" +
                        "\nTŘÍDNÍ BOJ (ekonomické vztahy)" +
                        "\n\t-jsou to hybné síly dějin" +
                        "\n\t-protiklady vedou k sociálním revolucím (protiklady-Hegela)" +
                        "\n\tPROLETARIÁT - dělnická třída" +
                        "\n\t\t-živá práce (kapitál - mrtvá práce)" +
                        "\n\tproletářská revoluce -> beztřídní společnost" +
                        "\n\nMarxismus rozštěpen na komunistický a socialistický proud (konec 19.st), následně 2O.st. neomarxismus",
                    imageExplanationUrl = "https://www.politicky-slovnik.cz/wp-content/uploads/2019/09/prolet%C3%A1%C5%99i-v%C5%A1ech-zem%C3%AD-spojte-se.jpg"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem evolučního zákona je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Herbet Spencer",
                    false,
                    "(1820-1903), Anglie, inspirace Darwinem" +
                        "\n-EVOLUČNÍ ZÁKON - biologický, ale i sociální vývoj, fakta"
                ),
                PsychologyTermAnswer("Auguste Comte",
                    false,
                    "(1798-1857) pozitivismus, francouz" +
                        "\npozitivismus - pozitivní, tedy věcné, určité, zkušenost > rozum" +
                        "\n3. stádia vývoje vědění:" +
                        "\n\t1. teologické (nadpřirozenost)" +
                        "\n\t2. metafyzické (nadpřirozeno nahrazeno abstrakcí)" +
                        "\n\t3. pozitivní stádium (faktuální)" +
                        "\n-nové poznatky třídit do soustavy věd (návaznost na encyklopedisty)" +
                        "\nSOCIOLOGIE" +
                        "\n\t-společnost (sociální fakta) zkoumána vědeckými metodami"
                ),
                PsychologyTermAnswer("Ernst Mach",
                    false,
                    "(1838-1916), fyzik, Brno" +
                        "\nnovopozitivismus, empiriokriticismus (druhý pozitivismus)"
                ),
                PsychologyTermAnswer("Karel Marx",
                    false,
                    "(1818-1883), materialismus" +
                        "\n-změnil Hegelovu dialektiku:" +
                        "\n\t-podstatou světa je materiální skutečnost" +
                        "\n\t-ideje jsou jen odrazem mat. skutečnosti v lidském vědomí" +
                        "\nPodstata člověka je práce" +
                        "\n\t-při ní se však člověk odcizil své podstatě" +
                        "\n\t-sociální, ekonomická nerovnost" +
                        "\nTŘÍDNÍ BOJ (ekonomické vztahy)" +
                        "\n\t-jsou to hybné síly dějin" +
                        "\n\t-protiklady vedou k sociálním revolucím (protiklady-Hegela)" +
                        "\n\tPROLETARIÁT - dělnická třída" +
                        "\n\t\t-živá práce (kapitál - mrtvá práce)" +
                        "\n\tproletářská revoluce -> beztřídní společnost" +
                        "\n\nMarxismus rozštěpen na komunistický a socialistický proud (konec 19.st), následně 2O.st. neomarxismus",
                    imageExplanationUrl = "https://www.politicky-slovnik.cz/wp-content/uploads/2019/09/prolet%C3%A1%C5%99i-v%C5%A1ech-zem%C3%AD-spojte-se.jpg"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce pozitivismu nepatří",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Ludwig Feuerbach",
                    false,
                    "(1804-1872), Německo" +
                        "\n-návaznost na Hegela, odmítl absolutní idei (ideje v každé věci, absolutní)" +
                        "\nKritika náboženství" +
                        "\n\t-náboženství vzniklo z lidského egoismu" +
                        "\n\t-vysvětlení náboženství antropologicky a materialisticky (z přírodní podstaty člověka - smysly)" +
                        "\n\t-smyslovost a emoce člověk vtělil do Boha (odcizil sám sobě)" +
                        "\n\t\t-potřeba vztáhnout zpět do svého živoate - NÁBOŽENSTVÍ ČLOVĚKA" +
                        "\n\t\t\t-láska k lidem, nikoliv Bohu"
                ),
                PsychologyTermAnswer("J. Stuart Mill",
                    false,
                    "(1806-1873), Anglie, spíše psychologie"
                ),
                PsychologyTermAnswer("Auguste Comte",
                    false,
                    "(1798-1857) pozitivismus, francouz" +
                        "\npozitivismus - pozitivní, tedy věcné, určité, zkušenost > rozum" +
                        "\n3. stádia vývoje vědění:" +
                        "\n\t1. teologické (nadpřirozenost)" +
                        "\n\t2. metafyzické (nadpřirozeno nahrazeno abstrakcí)" +
                        "\n\t3. pozitivní stádium (faktuální)" +
                        "\n-nové poznatky třídit do soustavy věd (návaznost na encyklopedisty)" +
                        "\nSOCIOLOGIE" +
                        "\n\t-společnost (sociální fakta) zkoumána vědeckými metodami"
                ),
                PsychologyTermAnswer("Herbet Spencer",
                    false,
                    "(1820-1903), Anglie, inspirace Darwinem" +
                        "\n-EVOLUČNÍ ZÁKON - biologický, ale i sociální vývoj, fakta"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. Náboženství člověka vytvořil",
            textAnswer = "smysly a emoce vkládáme do Boha, je však potřeba toto vložit do sebe, lidi",
            answers =
            listOf(
                PsychologyTermAnswer("Ludwig Feuerbach",
                    false,
                    "(1804-1872), Německo" +
                        "\n-návaznost na Hegela, odmítl absolutní idei (ideje v každé věci, absolutní)" +
                        "\nKritika náboženství" +
                        "\n\t-náboženství vzniklo z lidského egoismu" +
                        "\n\t-vysvětlení náboženství antropologicky a materialisticky (z přírodní podstaty člověka - smysly)" +
                        "\n\t-smyslovost a emoce člověk vtělil do Boha (odcizil sám sobě)" +
                        "\n\t\t-potřeba vztáhnout zpět do svého živoate - NÁBOŽENSTVÍ ČLOVĚKA" +
                        "\n\t\t\t-láska k lidem, nikoliv Bohu"
                ),
                PsychologyTermAnswer("Karel Marx",
                    false,
                    "(1818-1883), materialismus" +
                        "\n-změnil Hegelovu dialektiku:" +
                        "\n\t-podstatou světa je materiální skutečnost" +
                        "\n\t-ideje jsou jen odrazem mat. skutečnosti v lidském vědomí" +
                        "\nPodstata člověka je práce" +
                        "\n\t-při ní se však člověk odcizil své podstatě" +
                        "\n\t-sociální, ekonomická nerovnost" +
                        "\nTŘÍDNÍ BOJ (ekonomické vztahy)" +
                        "\n\t-jsou to hybné síly dějin" +
                        "\n\t-protiklady vedou k sociálním revolucím (protiklady-Hegela)" +
                        "\n\tPROLETARIÁT - dělnická třída" +
                        "\n\t\t-živá práce (kapitál - mrtvá práce)" +
                        "\n\tproletářská revoluce -> beztřídní společnost" +
                        "\n\nMarxismus rozštěpen na komunistický a socialistický proud (konec 19.st), následně 2O.st. neomarxismus",
                    imageExplanationUrl = "https://www.politicky-slovnik.cz/wp-content/uploads/2019/09/prolet%C3%A1%C5%99i-v%C5%A1ech-zem%C3%AD-spojte-se.jpg"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Působitel marxismu mimo Karla Marxe byl",
            textAnswer = "Karel Marx (1818-1883), materialismus" +
                "\n-změnil Hegelovu dialektiku:" +
                "\n\t-podstatou světa je materiální skutečnost" +
                "\n\t-ideje jsou jen odrazem mat. skutečnosti v lidském vědomí" +
                "\nPodstata člověka je práce" +
                "\n\t-při ní se však člověk odcizil své podstatě" +
                "\n\t-sociální, ekonomická nerovnost" +
                "\nTŘÍDNÍ BOJ (ekonomické vztahy)" +
                "\n\t-jsou to hybné síly dějin" +
                "\n\t-protiklady vedou k sociálním revolucím (protiklady-Hegela)" +
                "\n\tPROLETARIÁT - dělnická třída" +
                "\n\t\t-živá práce (kapitál - mrtvá práce)" +
                "\n\tproletářská revoluce -> beztřídní společnost" +
                "\n\nMarxismus rozštěpen na komunistický a socialistický proud (konec 19.st), následně 2O.st. neomarxismus",
            answers =
            listOf(
                PsychologyTermAnswer("Bedřich Engels",
                    false,
                    "(1820-1895)"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zástupce voluntarismu, který pospal vůli jako vůli k moci byl",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                ),
                PsychologyTermAnswer("Henri Bergson",
                    false,
                    "(1859-1941), francouz, návaznost na iracionalismus" +
                        "\n-rozum (intelekt) má sklon \"kouskovat\" svět" +
                        "\n\t-je uzpůsoben převádět svět na věci" +
                        "\nPonoření do oceánu světa" +
                        "\n\t-pravá povaha bytí - čas a trvání" +
                        "\n\t-podstata života - \"tvořivý vývoj\"" +
                        "\n\t\t-\"elán vital\" (životní síla) - mimoracionální síla" +
                        "\n\tnaslouchání životu skrze INTUICI" +
                        "\n\nProtikladnost hmoty morálky a náboženství" +
                        "\n\tUzavřená forma" +
                        "\n\t\t-automatické chování, zvyky - sociální tlak společnosti" +
                        "\n\tOtevřená forma" +
                        "\n\t\t-osobní, nezávislá na společnosti, tvořivá"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "\"Obecné problémy\" nazval existenciálními",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                ),
                PsychologyTermAnswer("Ch.S. Pierce",
                    false,
                    "(1839-1914), američan, pragmatismus" +
                        "\n-hodnota idejí není v idejích, ale v jejich praktickému uplatnění" +
                        "\ntranscendentální, neřešitelné problémy jsou zbytečné - žádný úžitek"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jako \"okamžik v nekonečnosti času\" popsal existenci",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                ),
                PsychologyTermAnswer("Ch.S. Pierce",
                    false,
                    "(1839-1914), američan, pragmatismus" +
                        "\n-hodnota idejí není v idejích, ale v jejich praktickému uplatnění" +
                        "\ntranscendentální, neřešitelné problémy jsou zbytečné - žádný úžitek"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce iracionalismu nepatří",
            textAnswer = "přístupy odmítající možnost rozumového vysvětlení světa, návaznost na Schellinga",
            answers =
            listOf(
                PsychologyTermAnswer("Karel Marx",
                    false,
                    "(1818-1883), materialismus" +
                        "\n-změnil Hegelovu dialektiku:" +
                        "\n\t-podstatou světa je materiální skutečnost" +
                        "\n\t-ideje jsou jen odrazem mat. skutečnosti v lidském vědomí" +
                        "\nPodstata člověka je práce" +
                        "\n\t-při ní se však člověk odcizil své podstatě" +
                        "\n\t-sociální, ekonomická nerovnost" +
                        "\nTŘÍDNÍ BOJ (ekonomické vztahy)" +
                        "\n\t-jsou to hybné síly dějin" +
                        "\n\t-protiklady vedou k sociálním revolucím (protiklady-Hegela)" +
                        "\n\tPROLETARIÁT - dělnická třída" +
                        "\n\t\t-živá práce (kapitál - mrtvá práce)" +
                        "\n\tproletářská revoluce -> beztřídní společnost" +
                        "\n\nMarxismus rozštěpen na komunistický a socialistický proud (konec 19.st), následně 2O.st. neomarxismus",
                    imageExplanationUrl = "https://www.politicky-slovnik.cz/wp-content/uploads/2019/09/prolet%C3%A1%C5%99i-v%C5%A1ech-zem%C3%AD-spojte-se.jpg"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("René Descartes",
                    false,
                    "(1596-1650), porenesanční filosofie" +
                        "\n-\"Rozprava o metodě\" - napsal v ústranní" +
                        "\n->Jediná jistota jsou pochyby< - jestliže pochybuji, myslím" +
                        "\n-jestliže myslím, tedy jsem - \"Cogito, ergo sum\"" +
                        "\n->metoda skepse< - pochybnost o všech dosavadních míněních" +
                        "\n-Bůj je vševědoucí a ideji o Bohu mám od Boha" +
                        "\n\"Meditace o první filosofii\" - obraz světa" +
                        "\n2 na sobě nezávislé substance - duchovní (myšlení) a hmotná (rozlehlost) - dualismus" +
                        "\n\t-existuje však neomezená substance - Bůh" +
                        "\n-zvířata jsou také pouhými tělesy (mechanismy)" +
                        "\n-otec moderní filosofie" +
                        "\n-subjekt-objekt rozměr" +
                        "\n\t-subjekt (člověk), objekt (vnější svět, působící na člověka)" +
                        "\nVyšli z něj 2 protichudné cesty:" +
                        "\n\t\t1. Zdůraznění subjektu ve filosofii Fichteho (\"Jáství\")" +
                        "\n\t\t2. Vědecký objektivismus - objekt je něco vnějšího, na čem nemáme účast"
                ),
                PsychologyTermAnswer("Gottfried Wilhelm Leibniz",
                    false,
                    "(1646-1716), novověká filosofie" +
                        "\n-\"Monádologie\"" +
                        "\n-descartes nedostatečně vysvětlil činnost zvířete - není to mechanismus" +
                        "\n\t-ve věcech jsou činné síly - MONÁDY" +
                        "\nvšechny nejmenší jednoky (monády) jsou živé" +
                        "\n\t-\"Celá příroda je plná života\"" +
                        "\n\t-\"Každý kus hmoty může být současně pojímán...jako rybník plný ryb\"" +
                        "\n-monády jsou odlišené, individuální" +
                        "\n-nižší řád (monády) je třeba vysvětlit vyšším řádem" +
                        "\n\t-duchovní oblast - monády mají také představy a proměny" +
                        "\n\t-POHYB vychází zevnitř - monády nepodléhají zákonům mechaniku a neovlivňují se (\"nemají okna\")" +
                        "\n-monáda je zrcadlení universa, mnohosti" +
                        "\n\t-některé však podobné člověku v bezvědomí" +
                        "\n-ideja \"PŘEDZJEDNANÉ HARMONIE\", uložena v monádách" +
                        "\nholotropní vesmír - oduševnilý a živý ve všehc částech" +
                        "\n\nšpatnosti vycházejí z konečnosti (Bůh je nekonečný)" +
                        "\n\t-součet zla je méně než součet ve světě"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jaké jsou podle Schopenhauera východiska lidského strádání?",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("umění a popření vůle",
                    false,
                    ""
                ),
                PsychologyTermAnswer("práce a beztřídní společnost",
                    false,
                    "Karel Marx"
                ),
                PsychologyTermAnswer("svět o sobě, svět pro nás",
                    false,
                    "Immanuel Kant" +
                        "\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA"
                ),
                PsychologyTermAnswer("možnost a uzkutečnění",
                    false,
                    "T. Akvinský, scholastika" +
                        "\n>Beztvará látka a forma<, má 2 stavy:" +
                        "\n\t1. stav možnosti (co může být)" +
                        "\n\t2. stav uskutečnění (actus) - přechod do konkrétní bytí ze stavu možnosti" +
                        "\n\nPravá podstata (essentia)" +
                        "\n\t-skutečnost je nezávislá na konkrétní podobě"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"Bůh je mrtev\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                ),
                PsychologyTermAnswer("Henri Bergson",
                    false,
                    "(1859-1941), francouz, návaznost na iracionalismus" +
                        "\n-rozum (intelekt) má sklon \"kouskovat\" svět" +
                        "\n\t-je uzpůsoben převádět svět na věci" +
                        "\nPonoření do oceánu světa" +
                        "\n\t-pravá povaha bytí - čas a trvání" +
                        "\n\t-podstata života - \"tvořivý vývoj\"" +
                        "\n\t\t-\"elán vital\" (životní síla) - mimoracionální síla" +
                        "\n\tnaslouchání životu skrze INTUICI" +
                        "\n\nProtikladnost hmoty morálky a náboženství" +
                        "\n\tUzavřená forma" +
                        "\n\t\t-automatické chování, zvyky - sociální tlak společnosti" +
                        "\n\tOtevřená forma" +
                        "\n\t\t-osobní, nezávislá na společnosti, tvořivá"
                ),
                PsychologyTermAnswer("Hans Driesch",
                    false,
                    "(1867-1941), německo, neovitalismus (Bergson)" +
                        "\n-vystupoval proti Darwinismu - bral ho jako stejnosměrný" +
                        "\n-ENTELECHIE - to, co má cíl samo v sobě - neviditelná organizující síla"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Nadčlověk je mocný a osamělý podle",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                ),
                PsychologyTermAnswer("Henri Bergson",
                    false,
                    "(1859-1941), francouz, návaznost na iracionalismus" +
                        "\n-rozum (intelekt) má sklon \"kouskovat\" svět" +
                        "\n\t-je uzpůsoben převádět svět na věci" +
                        "\nPonoření do oceánu světa" +
                        "\n\t-pravá povaha bytí - čas a trvání" +
                        "\n\t-podstata života - \"tvořivý vývoj\"" +
                        "\n\t\t-\"elán vital\" (životní síla) - mimoracionální síla" +
                        "\n\tnaslouchání životu skrze INTUICI" +
                        "\n\nProtikladnost hmoty morálky a náboženství" +
                        "\n\tUzavřená forma" +
                        "\n\t\t-automatické chování, zvyky - sociální tlak společnosti" +
                        "\n\tOtevřená forma" +
                        "\n\t\t-osobní, nezávislá na společnosti, tvořivá"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem pojmu \"elán vital\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Henri Bergson",
                    false,
                    "(1859-1941), francouz, návaznost na iracionalismus" +
                        "\n-rozum (intelekt) má sklon \"kouskovat\" svět" +
                        "\n\t-je uzpůsoben převádět svět na věci" +
                        "\nPonoření do oceánu světa" +
                        "\n\t-pravá povaha bytí - čas a trvání" +
                        "\n\t-podstata života - \"tvořivý vývoj\"" +
                        "\n\t\t-\"elán vital\" (životní síla) - mimoracionální síla" +
                        "\n\tnaslouchání životu skrze INTUICI" +
                        "\n\nProtikladnost hmoty morálky a náboženství" +
                        "\n\tUzavřená forma" +
                        "\n\t\t-automatické chování, zvyky - sociální tlak společnosti" +
                        "\n\tOtevřená forma" +
                        "\n\t\t-osobní, nezávislá na společnosti, tvořivá"
                ),
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Na uzavřenou a otevřenou formu morálky dělil",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Henri Bergson",
                    false,
                    "(1859-1941), francouz, návaznost na iracionalismus" +
                        "\n-rozum (intelekt) má sklon \"kouskovat\" svět" +
                        "\n\t-je uzpůsoben převádět svět na věci" +
                        "\nPonoření do oceánu světa" +
                        "\n\t-pravá povaha bytí - čas a trvání" +
                        "\n\t-podstata života - \"tvořivý vývoj\"" +
                        "\n\t\t-\"elán vital\" (životní síla) - mimoracionální síla" +
                        "\n\tnaslouchání životu skrze INTUICI" +
                        "\n\nProtikladnost hmoty morálky a náboženství" +
                        "\n\tUzavřená forma" +
                        "\n\t\t-automatické chování, zvyky - sociální tlak společnosti" +
                        "\n\tOtevřená forma" +
                        "\n\t\t-osobní, nezávislá na společnosti, tvořivá"
                ),
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                ),
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce pragmatismus nepatří",
            textAnswer = "filosofie činu a užitku (pragma=jednání)" +
                "\ninspirováno USA - kapitalismus, produkce, teda čin a užitek" +
                "\n\"multi-versum\" - výběr \"co se nám zamlouvá\"",
            answers =
            listOf(
                PsychologyTermAnswer("Hans Driesch",
                    false,
                    "(1867-1941), německo, neovitalismus (Bergson)" +
                        "\n-vystupoval proti Darwinismu - bral ho jako stejnosměrný" +
                        "\n-ENTELECHIE - to, co má cíl samo v sobě - neviditelná organizující síla"
                ),
                PsychologyTermAnswer("Ch.S. Pierce",
                    false,
                    "(1839-1914), američan, pragmatismus" +
                        "\n-hodnota idejí není v idejích, ale v jejich praktickému uplatnění" +
                        "\ntranscendentální, neřešitelné problémy jsou zbytečné - žádný úžitek"
                ),
                PsychologyTermAnswer("William James",
                    false,
                    "(1842-1910), zakladatel pragmatismu" +
                        "\n-užitečnost věd, ale také náboženství" +
                        "\n-\"náboženství jakožto lékařství duší poskytuje některým z nás jasný klid... a předchází některým nemocem právě tak dobře jako věda\"" +
                        "\n-otázka \"zdali Bůh existuje\" již není otázka metafyzická, avšak pragmatická" +
                        "\n\nKoncepce (teorie) pravdy" +
                        "\n\t-pravda není shoda myšlenku a předmětu - měřítko pravdy je prospěch" +
                        "\n\t-pravda je relativní - PLURALITNÍ, různorodá"
                ),
                PsychologyTermAnswer("John Dewey",
                    false,
                    "(1859-1952), pragmatismus, navazoval na Jamese" +
                        "\n-pragmatismus v sociální teorii a pedagogice" +
                        "\nINSTRUMENTALISMUS" +
                        "\n\t-příroda, vzdělání, věda, produkce, ideje jsou pouhé nástroje pokroku" +
                        "\n-svět není jen jednolité universum, nýbrž \"MULTI-UNIVERSUM\" - výběr \"co se nám zamlouvá\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zakladatel voluntarismu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Arthur Schopenhauer",
                    false,
                    "(1788-1860), německý filosof, iracionalismus, pohegelovská filosofie" +
                        "\n-vychází z Kanta a indického myšlení (buddhismus)" +
                        "\n-viditelný svět je zdání" +
                        "\n-VOLUNTARISMUS (voluntas=vůle)" +
                        "\n\t-vstupujeme do podstaty světa vůlí" +
                        "\n\t-vše živé je vůlí života (pud rozmnožovací)" +
                        "\n\t-vůle je nekonečná, naplnění však ne - strádání člověka" +
                        "\n\t\tVýchodiska strádání:" +
                        "\n\t\t\t1. Umění" +
                        "\n\t\t\t2. Popření vůle"
                ),
                PsychologyTermAnswer("Oswald Spengler",
                    false,
                    "(1880-1936), němec" +
                        "\n-\"Zánik západu\"" +
                        "\n\t-vývoj KULTUR jako ORGANISMUS" +
                        "\n\t\t-stádia růstu, rozkvětu, odumírání a zániku" +
                        "\n\t\t-západní \"faustovská\" kultura ve stádiu nehybnosti"
                ),
                PsychologyTermAnswer("Hans Driesch",
                    false,
                    "(1867-1941), německo, neovitalismus (Bergson)" +
                        "\n-vystupoval proti Darwinismu - bral ho jako stejnosměrný" +
                        "\n-ENTELECHIE - to, co má cíl samo v sobě - neviditelná organizující síla"
                ),
                PsychologyTermAnswer("W. Dilthey",
                    false,
                    "(1833-1936), němec, hermeneutika" +
                        "\n-iracionalismus (logicky nesdělitelný obsah zkušenosti)" +
                        "\n-přírodověda zkoumá zprostředkované skutečnosti (věci)" +
                        "\n-duchovní vědy v prožitku (skrze intuici a introspekci)" +
                        "\n-dějiny jsou ve všem, co nás obklopuje"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem knihy \"Zánik západu je\"",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Oswald Spengler",
                    false,
                    "(1880-1936), němec" +
                        "\n-\"Zánik západu\"" +
                        "\n\t-vývoj KULTUR jako ORGANISMUS" +
                        "\n\t\t-stádia růstu, rozkvětu, odumírání a zániku" +
                        "\n\t\t-západní \"faustovská\" kultura ve stádiu nehybnosti"
                ),
                PsychologyTermAnswer("W. Dilthey",
                    false,
                    "(1833-1936), němec, hermeneutika" +
                        "\n-iracionalismus (logicky nesdělitelný obsah zkušenosti)" +
                        "\n-přírodověda zkoumá zprostředkované skutečnosti (věci)" +
                        "\n-duchovní vědy v prožitku (skrze intuici a introspekci)" +
                        "\n-dějiny jsou ve všem, co nás obklopuje"
                ),
                PsychologyTermAnswer("William James",
                    false,
                    "(1842-1910), zakladatel pragmatismu" +
                        "\n-užitečnost věd, ale také náboženství" +
                        "\n-\"náboženství jakožto lékařství duší poskytuje některým z nás jasný klid... a předchází některým nemocem právě tak dobře jako věda\"" +
                        "\n-otázka \"zdali Bůh existuje\" již není otázka metafyzická, avšak pragmatická" +
                        "\n\nKoncepce (teorie) pravdy" +
                        "\n\t-pravda není shoda myšlenku a předmětu - měřítko pravdy je prospěch" +
                        "\n\t-pravda je relativní - PLURALITNÍ, různorodá"
                ),
                PsychologyTermAnswer("John Dewey",
                    false,
                    "(1859-1952), pragmatismus, navazoval na Jamese" +
                        "\n-pragmatismus v sociální teorii a pedagogice" +
                        "\nINSTRUMENTALISMUS" +
                        "\n\t-příroda, vzdělání, věda, produkce, ideje jsou pouhé nástroje pokroku" +
                        "\n-svět není jen jednolité universum, nýbrž \"MULTI-UNIVERSUM\" - výběr \"co se nám zamlouvá\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. stádia růstu kultury jsou spojovány s",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Oswald Spengler",
                    false,
                    "(1880-1936), němec" +
                        "\n-\"Zánik západu\"" +
                        "\n\t-vývoj KULTUR jako ORGANISMUS" +
                        "\n\t\t-stádia růstu, rozkvětu, odumírání a zániku" +
                        "\n\t\t-západní \"faustovská\" kultura ve stádiu nehybnosti"
                ),
                PsychologyTermAnswer("Ch.S. Pierce",
                    false,
                    "(1839-1914), američan, pragmatismus" +
                        "\n-hodnota idejí není v idejích, ale v jejich praktickému uplatnění" +
                        "\ntranscendentální, neřešitelné problémy jsou zbytečné - žádný úžitek"
                ),
                PsychologyTermAnswer("William James",
                    false,
                    "(1842-1910), zakladatel pragmatismu" +
                        "\n-užitečnost věd, ale také náboženství" +
                        "\n-\"náboženství jakožto lékařství duší poskytuje některým z nás jasný klid... a předchází některým nemocem právě tak dobře jako věda\"" +
                        "\n-otázka \"zdali Bůh existuje\" již není otázka metafyzická, avšak pragmatická" +
                        "\n\nKoncepce (teorie) pravdy" +
                        "\n\t-pravda není shoda myšlenku a předmětu - měřítko pravdy je prospěch" +
                        "\n\t-pravda je relativní - PLURALITNÍ, různorodá"
                ),
                PsychologyTermAnswer("John Dewey",
                    false,
                    "(1859-1952), pragmatismus, navazoval na Jamese" +
                        "\n-pragmatismus v sociální teorii a pedagogice" +
                        "\nINSTRUMENTALISMUS" +
                        "\n\t-příroda, vzdělání, věda, produkce, ideje jsou pouhé nástroje pokroku" +
                        "\n-svět není jen jednolité universum, nýbrž \"MULTI-UNIVERSUM\" - výběr \"co se nám zamlouvá\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zakladatel pragmatismu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("William James",
                    false,
                    "(1842-1910), zakladatel pragmatismu" +
                        "\n-užitečnost věd, ale také náboženství" +
                        "\n-\"náboženství jakožto lékařství duší poskytuje některým z nás jasný klid... a předchází některým nemocem právě tak dobře jako věda\"" +
                        "\n-otázka \"zdali Bůh existuje\" již není otázka metafyzická, avšak pragmatická" +
                        "\n\nKoncepce (teorie) pravdy" +
                        "\n\t-pravda není shoda myšlenku a předmětu - měřítko pravdy je prospěch" +
                        "\n\t-pravda je relativní - PLURALITNÍ, různorodá"
                ),
                PsychologyTermAnswer("John Dewey",
                    false,
                    "(1859-1952), pragmatismus, navazoval na Jamese" +
                        "\n-pragmatismus v sociální teorii a pedagogice" +
                        "\nINSTRUMENTALISMUS" +
                        "\n\t-příroda, vzdělání, věda, produkce, ideje jsou pouhé nástroje pokroku" +
                        "\n-svět není jen jednolité universum, nýbrž \"MULTI-UNIVERSUM\" - výběr \"co se nám zamlouvá\""
                ),
                PsychologyTermAnswer("Edmund Husserl",
                    false,
                    "(1859-1938), fenomologie, ovlivněn Brentanem a Bolzanem" +
                        "\n-naše poznání má dogmatický (ustrnulý) ráz - věříme, že našim představám něco opravdu odpovídá - to je však potřeba zkoumat" +
                        "\n-Oblast vědomí" +
                        "\n\t-jakmile \"uzávorkujeme\" dogmatismus, svět je pouhým FENOMÉNEM (jevem)" +
                        "\n\t-následně tyto jevy můžeme uvnitř nás zkoumat - fenomologie" +
                        "\n\t-naše psychika je součást světa, tudíž již musíme také \"uzávorkovat\", čímž dojdeme k transcendentálnímu vědomí" +
                        "\n\t-svět jest a zjevuje se" +
                        "\n\tpřirozený svět našeho života" +
                        "\n-čas vědy je stejnoměrný, čas člověka se někdy vleče, jindy pádí" +
                        "\n-věda nám ulehčuje život, ale nepomáhá najít jeho smysl (stejně jako Pascal)"
                ),
                PsychologyTermAnswer("Franz Brentano",
                    false,
                    "(1838-1917), fenomologie" +
                        "\nPSYCHOLOGISMUS" +
                        "\n\t-základní gnoseologické (zákonitosti lidského poznání) otázky lze řešit pouze v rámci psychologického rozboru a popisu procesů lids. vnímání"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem psychologismu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Franz Brentano",
                    false,
                    "(1838-1917), fenomologie" +
                        "\nPSYCHOLOGISMUS" +
                        "\n\t-základní gnoseologické (zákonitosti lidského poznání) otázky lze řešit pouze v rámci psychologického rozboru a popisu procesů lids. vnímání"
                ),
                PsychologyTermAnswer("Edmund Husserl",
                    false,
                    "(1859-1938), fenomologie, ovlivněn Brentanem a Bolzanem" +
                        "\n-naše poznání má dogmatický (ustrnulý) ráz - věříme, že našim představám něco opravdu odpovídá - to je však potřeba zkoumat" +
                        "\n-Oblast vědomí" +
                        "\n\t-jakmile \"uzávorkujeme\" dogmatismus, svět je pouhým FENOMÉNEM (jevem)" +
                        "\n\t-následně tyto jevy můžeme uvnitř nás zkoumat - fenomologie" +
                        "\n\t-naše psychika je součást světa, tudíž již musíme také \"uzávorkovat\", čímž dojdeme k transcendentálnímu vědomí" +
                        "\n\t-svět jest a zjevuje se" +
                        "\n\tpřirozený svět našeho života" +
                        "\n-čas vědy je stejnoměrný, čas člověka se někdy vleče, jindy pádí" +
                        "\n-věda nám ulehčuje život, ale nepomáhá najít jeho smysl (stejně jako Pascal)"
                ),
                PsychologyTermAnswer("Bernard Bolzano",
                    false,
                    "(1781-1848), pražský německý filosof," +
                        "\n-inspirace pro Franze Brentano" +
                        "\n-myšlení nelze redukovat na výsledky psychických procesů nebo logických postupů"
                ),
                PsychologyTermAnswer("William James",
                    false,
                    "(1842-1910), zakladatel pragmatismu" +
                        "\n-užitečnost věd, ale také náboženství" +
                        "\n-\"náboženství jakožto lékařství duší poskytuje některým z nás jasný klid... a předchází některým nemocem právě tak dobře jako věda\"" +
                        "\n-otázka \"zdali Bůh existuje\" již není otázka metafyzická, avšak pragmatická" +
                        "\n\nKoncepce (teorie) pravdy" +
                        "\n\t-pravda není shoda myšlenku a předmětu - měřítko pravdy je prospěch" +
                        "\n\t-pravda je relativní - PLURALITNÍ, různorodá"
                ),
                PsychologyTermAnswer("John Dewey",
                    false,
                    "(1859-1952), pragmatismus, navazoval na Jamese" +
                        "\n-pragmatismus v sociální teorii a pedagogice" +
                        "\nINSTRUMENTALISMUS" +
                        "\n\t-příroda, vzdělání, věda, produkce, ideje jsou pouhé nástroje pokroku" +
                        "\n-svět není jen jednolité universum, nýbrž \"MULTI-UNIVERSUM\" - výběr \"co se nám zamlouvá\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zakladatel fenomologie je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Edmund Husserl",
                    false,
                    "(1859-1938), fenomologie, ovlivněn Brentanem a Bolzanem" +
                        "\n-naše poznání má dogmatický (ustrnulý) ráz - věříme, že našim představám něco opravdu odpovídá - to je však potřeba zkoumat" +
                        "\n-Oblast vědomí" +
                        "\n\t-jakmile \"uzávorkujeme\" dogmatismus, svět je pouhým FENOMÉNEM (jevem)" +
                        "\n\t-následně tyto jevy můžeme uvnitř nás zkoumat - fenomologie" +
                        "\n\t-naše psychika je součást světa, tudíž již musíme také \"uzávorkovat\", čímž dojdeme k transcendentálnímu vědomí" +
                        "\n\t-svět jest a zjevuje se" +
                        "\n\tpřirozený svět našeho života" +
                        "\n-čas vědy je stejnoměrný, čas člověka se někdy vleče, jindy pádí" +
                        "\n-věda nám ulehčuje život, ale nepomáhá najít jeho smysl (stejně jako Pascal)"
                ),
                PsychologyTermAnswer("Max Scheller",
                    false,
                    "(1874-1928), němec, fenomologie, teorie hodnot, ovlivněn E. Husserlem"
                ),
                PsychologyTermAnswer("M. Merleau-Ponty",
                    false,
                    "(1908-1961), francouz, fenomologie, teorie vědomí, ovlivněn E. Husserlem"
                ),
                PsychologyTermAnswer("Ludwig Landgrebe",
                    false,
                    "(1902-1991), německý tajemník pražského fil. klubu fenomologie" +
                        "\n-záchrana Husserlova díla od nacismu"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Pražský německo-český filosofický kroušek, založen roku 1934 se zabýval",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("fenomologii",
                    false,
                    "Jan Patočka, Ludwig Landgrebe"
                ),
                PsychologyTermAnswer("pragmatismem",
                    false,
                    "filosofie činu a užitku (pragma=jednání), praktické uplatnění, W. James"
                ),
                PsychologyTermAnswer("voluntarismem",
                    false,
                    "vstupujeme do podstaty světa vůlí - např. vůle žít, proto žijeme"
                ),
                PsychologyTermAnswer("instrumentalismem",
                    false,
                    "příroda, vzdělání, věda, produkce, ideje jsou pouhé nástroje pokroku, pragmatismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem studie \"Sebevražda jako masový jev moderní civilizace\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("T.G. Masaryk",
                    false,
                    "(1850-1937), Husserl, Brentano" +
                        "\n\"Sebevražda jako masový jev moderní civilizace\"" +
                        "\n\t-kritika moderní doby, dříve se lidé dokázaly vypořádat s obtížemi života" +
                        "\n\t-ztráta harmonie rozumu a morálky - \"patologický stav všeobecné nervozity\"" +
                        "\n\t-prvně vidí východisko v náboženství, následně v IDEÁLU HUMANITY" +
                        "\n-filosofie a politika - rub a líc téže mince" +
                        "\n-lidskou existenci ohrožují hotové názory, nacionální, rasové, či třídní \"mýty\" a předsudky"
                ),
                PsychologyTermAnswer("Martin Heidegger",
                    false,
                    "(1889-1976), žák Husserlův" +
                        "\nOntologie (problematika, nauka bytí)" +
                        "\n\t-\"Bytí a čas\"" +
                        "\n\t\t-dosavadní filosofie na bytí zapomněla" +
                        "\n\t\tOntologická diference" +
                        "\n\t\t\t-rozdíl mezi jsoucími věcmi a bytím (jsoucnost zakládá)" +
                        "\n-zkoumat musíme skrze jsoucno, které se dokáže na bytí tázat" +
                        "\n\t-takové jsoucno je Dasein=pobyt (člověk)" +
                        "\nAnalýza pobytu (člověka)" +
                        "\n\t1. Žije v první osobě" +
                        "\n\t2. Člověk je zainteresován svým bytím" +
                        "\n\t3. Nezvolili jsme si zrození - jsme do světa vrženi" +
                        "\n\t\tMožnosti volby žití:" +
                        "\n\t\t\ta) neautentické bytí - anonymní masa, necháme sebou manipulovat" +
                        "\n\t\t\tb) autentický život - usilování o život podle svého přesvědčení, zodpovědně" +
                        "\n\t4. Existence neoddělitelná od světa" +
                        "\n\t\t-mé bytí je vždy spolubytím ve světě" +
                        "\n\t5. Člověk žije v čase - bytí ke smrti" +
                        "\n\t\t-neautentické bytí uniká od tohoto faktu" +
                        "\n\t6. Člověk je bytostí pravdy" +
                        "\n\t\t-pravda se odhaluje skrze člověka, který se na bytí ptá" +
                        "\n\"Filosof je přítel bytí\""
                ),
                PsychologyTermAnswer("Edmund Husserl",
                    false,
                    "(1859-1938), fenomologie, ovlivněn Brentanem a Bolzanem" +
                        "\n-naše poznání má dogmatický (ustrnulý) ráz - věříme, že našim představám něco opravdu odpovídá - to je však potřeba zkoumat" +
                        "\n-Oblast vědomí" +
                        "\n\t-jakmile \"uzávorkujeme\" dogmatismus, svět je pouhým FENOMÉNEM (jevem)" +
                        "\n\t-následně tyto jevy můžeme uvnitř nás zkoumat - fenomologie" +
                        "\n\t-naše psychika je součást světa, tudíž již musíme také \"uzávorkovat\", čímž dojdeme k transcendentálnímu vědomí" +
                        "\n\t-svět jest a zjevuje se" +
                        "\n\tpřirozený svět našeho života" +
                        "\n-čas vědy je stejnoměrný, čas člověka se někdy vleče, jindy pádí" +
                        "\n-věda nám ulehčuje život, ale nepomáhá najít jeho smysl (stejně jako Pascal)"
                ),
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem pojmu \"patologický stav všeobecné nervozity\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("T.G. Masaryk",
                    false,
                    "(1850-1937), Husserl, Brentano" +
                        "\n\"Sebevražda jako masový jev moderní civilizace\"" +
                        "\n\t-kritika moderní doby, dříve se lidé dokázaly vypořádat s obtížemi života" +
                        "\n\t-ztráta harmonie rozumu a morálky - \"patologický stav všeobecné nervozity\"" +
                        "\n\t-prvně vidí východisko v náboženství, následně v IDEÁLU HUMANITY" +
                        "\n-filosofie a politika - rub a líc téže mince" +
                        "\n-lidskou existenci ohrožují hotové názory, nacionální, rasové, či třídní \"mýty\" a předsudky"
                ),
                PsychologyTermAnswer("Edmund Husserl",
                    false,
                    "(1859-1938), fenomologie, ovlivněn Brentanem a Bolzanem" +
                        "\n-naše poznání má dogmatický (ustrnulý) ráz - věříme, že našim představám něco opravdu odpovídá - to je však potřeba zkoumat" +
                        "\n-Oblast vědomí" +
                        "\n\t-jakmile \"uzávorkujeme\" dogmatismus, svět je pouhým FENOMÉNEM (jevem)" +
                        "\n\t-následně tyto jevy můžeme uvnitř nás zkoumat - fenomologie" +
                        "\n\t-naše psychika je součást světa, tudíž již musíme také \"uzávorkovat\", čímž dojdeme k transcendentálnímu vědomí" +
                        "\n\t-svět jest a zjevuje se" +
                        "\n\tpřirozený svět našeho života" +
                        "\n-čas vědy je stejnoměrný, čas člověka se někdy vleče, jindy pádí" +
                        "\n-věda nám ulehčuje život, ale nepomáhá najít jeho smysl (stejně jako Pascal)"
                ),
                PsychologyTermAnswer("F. Nietzsche",
                    false,
                    "(1844-1900), německý myslitel, iracionalismus" +
                        "\n-oproti appolinskému živlu smíru a harmonie vyzdvihl živel dionýský" +
                        "\nŽIVEL DIONÝSKÝ" +
                        "\n\t-nespoutanost, beztvará pravůle, podstata světa, neustálé tvoření a ničení" +
                        "\n-aforistický (strohé pravdy, fráze) a metaforický styl" +
                        "\n-voluntarismus" +
                        "\n\t-VŮLE K MOCI panující ve světě" +
                        "\n\t\t-tím však není člověk otrok - stádní stav davu" +
                        "\n\t\t-člověk je otrok, schovává se za demokracii, socialismus, emancipaci a KŘESŤANSTVÍ" +
                        "\n\tNadčlověk - ví, že \"Bůh je mrtev\", nepotřebuje berličku jako člověk, nadčlověk je mocný a osamělý"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Bytí a čas\" (1927) je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Martin Heidegger",
                    false,
                    "(1889-1976), žák Husserlův" +
                        "\nOntologie (problematika, nauka bytí)" +
                        "\n\t-\"Bytí a čas\"" +
                        "\n\t\t-dosavadní filosofie na bytí zapomněla" +
                        "\n\t\tOntologická diference" +
                        "\n\t\t\t-rozdíl mezi jsoucími věcmi a bytím (jsoucnost zakládá)" +
                        "\n-zkoumat musíme skrze jsoucno, které se dokáže na bytí tázat" +
                        "\n\t-takové jsoucno je Dasein=pobyt (člověk)" +
                        "\nAnalýza pobytu (člověka)" +
                        "\n\t1. Žije v první osobě" +
                        "\n\t2. Člověk je zainteresován svým bytím" +
                        "\n\t3. Nezvolili jsme si zrození - jsme do světa vrženi" +
                        "\n\t\tMožnosti volby žití:" +
                        "\n\t\t\ta) neautentické bytí - anonymní masa, necháme sebou manipulovat" +
                        "\n\t\t\tb) autentický život - usilování o život podle svého přesvědčení, zodpovědně" +
                        "\n\t4. Existence neoddělitelná od světa" +
                        "\n\t\t-mé bytí je vždy spolubytím ve světě" +
                        "\n\t5. Člověk žije v čase - bytí ke smrti" +
                        "\n\t\t-neautentické bytí uniká od tohoto faktu" +
                        "\n\t6. Člověk je bytostí pravdy" +
                        "\n\t\t-pravda se odhaluje skrze člověka, který se na bytí ptá" +
                        "\n\"Filosof je přítel bytí\""
                ),
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Bytí a nicota\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                ),
                PsychologyTermAnswer("Martin Heidegger",
                    false,
                    "(1889-1976), žák Husserlův" +
                        "\nOntologie (problematika, nauka bytí)" +
                        "\n\t-\"Bytí a čas\"" +
                        "\n\t\t-dosavadní filosofie na bytí zapomněla" +
                        "\n\t\tOntologická diference" +
                        "\n\t\t\t-rozdíl mezi jsoucími věcmi a bytím (jsoucnost zakládá)" +
                        "\n-zkoumat musíme skrze jsoucno, které se dokáže na bytí tázat" +
                        "\n\t-takové jsoucno je Dasein=pobyt (člověk)" +
                        "\nAnalýza pobytu (člověka)" +
                        "\n\t1. Žije v první osobě" +
                        "\n\t2. Člověk je zainteresován svým bytím" +
                        "\n\t3. Nezvolili jsme si zrození - jsme do světa vrženi" +
                        "\n\t\tMožnosti volby žití:" +
                        "\n\t\t\ta) neautentické bytí - anonymní masa, necháme sebou manipulovat" +
                        "\n\t\t\tb) autentický život - usilování o život podle svého přesvědčení, zodpovědně" +
                        "\n\t4. Existence neoddělitelná od světa" +
                        "\n\t\t-mé bytí je vždy spolubytím ve světě" +
                        "\n\t5. Člověk žije v čase - bytí ke smrti" +
                        "\n\t\t-neautentické bytí uniká od tohoto faktu" +
                        "\n\t6. Člověk je bytostí pravdy" +
                        "\n\t\t-pravda se odhaluje skrze člověka, který se na bytí ptá" +
                        "\n\"Filosof je přítel bytí\""
                ),
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Kritika dialektického rozumu\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                ),
                PsychologyTermAnswer("Martin Heidegger",
                    false,
                    "(1889-1976), žák Husserlův" +
                        "\nOntologie (problematika, nauka bytí)" +
                        "\n\t-\"Bytí a čas\"" +
                        "\n\t\t-dosavadní filosofie na bytí zapomněla" +
                        "\n\t\tOntologická diference" +
                        "\n\t\t\t-rozdíl mezi jsoucími věcmi a bytím (jsoucnost zakládá)" +
                        "\n-zkoumat musíme skrze jsoucno, které se dokáže na bytí tázat" +
                        "\n\t-takové jsoucno je Dasein=pobyt (člověk)" +
                        "\nAnalýza pobytu (člověka)" +
                        "\n\t1. Žije v první osobě" +
                        "\n\t2. Člověk je zainteresován svým bytím" +
                        "\n\t3. Nezvolili jsme si zrození - jsme do světa vrženi" +
                        "\n\t\tMožnosti volby žití:" +
                        "\n\t\t\ta) neautentické bytí - anonymní masa, necháme sebou manipulovat" +
                        "\n\t\t\tb) autentický život - usilování o život podle svého přesvědčení, zodpovědně" +
                        "\n\t4. Existence neoddělitelná od světa" +
                        "\n\t\t-mé bytí je vždy spolubytím ve světě" +
                        "\n\t5. Člověk žije v čase - bytí ke smrti" +
                        "\n\t\t-neautentické bytí uniká od tohoto faktu" +
                        "\n\t6. Člověk je bytostí pravdy" +
                        "\n\t\t-pravda se odhaluje skrze člověka, který se na bytí ptá" +
                        "\n\"Filosof je přítel bytí\""
                ),
                PsychologyTermAnswer("Immanuel Kant",
                    false,
                    "(1724-1804), profesor logiky, novověká, německá filosofie" +
                        "\n-narozdíl od filosofů před ním >podrobil kritice rozum sám<" +
                        "\n-rozvrhl své učení na část teoretickou, etickou a estetickou" +
                        "\n-\"KRITIKA ČISTÉHO ROZUMU\"" +
                        "\n\t-rozíl mezi smyslovou a rozumovou stránkou" +
                        "\n\t\t-APRIORI - co je dáno předem" +
                        "\n\t\t-APOSTERIORI - co je dáno dodatečně" +
                        "\n\t->člověku jsou vrozeny nazírací formy času a prostoru<" +
                        "\n\t\t-také vrozeny zákl. myšlenkové kategorie - nutnost, příčina, apod." +
                        "\n\t\t-Apercepce - vrozená schopnost syntézy smyslových údajů v jednu zkušenost" +
                        "\n\n\t\"KOPERNIKOVSKÝ OBRAT\" - dosud poznání vykládáno z předmětu, nyní z člověka" +
                        "\n\t\t-jsme to my, kdo vznášíme řád do světa" +
                        "\n\n\t-\"SVĚT PRO NÁS\" - říši jevů - zkušenostní poznání" +
                        "\n\t-\"SVĚT O SOBĚ\" - věc o sobě - apriorní formy poznání" +
                        "\n\t\t-existuje totiž poznání bez zkušenosti - TRANSCENDENTÁLNÍ DIALEKTIKA" +
                        "\n\n-\"KRITIKA PRAKTICKÉHO ROZUMU\"" +
                        "\n\t->předpoklady etiky<" +
                        "\n\t-nepodmíněnost (autonomii) marvního citu" +
                        "\n\t\t-kategorický imperativ (přikazující tvrzení) o třech větách (formulích):" +
                        "\n\t\t\t1.-2. jednej jako kdyby z toho měl být zákon 3. lidství v tobě účelem, nikoliv prostředkem" +
                        "\n-\"KRITIKA SOUDNOSTI\""+
                        "\n\n1. Zdůraznění autonomie člověka a transcendentalismus -> inspirace idealismu" +
                        "\n2. Zdůraznění nezávislosti vědění ve \"světě pro nás\" -> inspirace positivismu" +
                        "\n3. Protest proti dogmatickému (rozhodujícímu, jasnému) rozumu" +
                        "\nnásledně vznik novokantovství, fenomologie"
                ),
                PsychologyTermAnswer("Soren Kierkegaard",
                    false,
                    "(1813-1855), dánský myslitel, iracionalismus" +
                        "\n-\"obecné problémy\" mají povahu praktických konkrétních otázek" +
                        "\n\t-tyto problémy nazval EXISTENCIÁLNÍMI" +
                        "\n-existence není materialistická, je niterní - okamžik v nekonečnosti času" +
                        "\n-existenciální víra (v Boha)" +
                        "\n-v niterné zkušenosti nalézá prožiky:" +
                        "\n\t-strach, zklamání, vrženost (do světa), samota, úzkost, odhodlanost" +
                        "\n\nvliv na existencialismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Ontologický výraz pro jsoucno, které se může tázat je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Dasein",
                    false,
                    "Dasein=pobyt (člověk), Heidegger"
                ),
                PsychologyTermAnswer("elán vital",
                    false,
                    "životní síla, Henri Bergson"
                ),
                PsychologyTermAnswer("apriori",
                    false,
                    "Immanuel Kant" +
                        "\nAPRIORI - co je dáno předem"
                ),
                PsychologyTermAnswer("aposteriori",
                    false,
                    "Immanuel Kant" +
                        "\nAPOSTERIORI - co je dáno dodatečně"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"Filosof je přítel bytí\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Martin Heidegger",
                    false,
                    "(1889-1976), žák Husserlův" +
                        "\nOntologie (problematika, nauka bytí)" +
                        "\n\t-\"Bytí a čas\"" +
                        "\n\t\t-dosavadní filosofie na bytí zapomněla" +
                        "\n\t\tOntologická diference" +
                        "\n\t\t\t-rozdíl mezi jsoucími věcmi a bytím (jsoucnost zakládá)" +
                        "\n-zkoumat musíme skrze jsoucno, které se dokáže na bytí tázat" +
                        "\n\t-takové jsoucno je Dasein=pobyt (člověk)" +
                        "\nAnalýza pobytu (člověka)" +
                        "\n\t1. Žije v první osobě" +
                        "\n\t2. Člověk je zainteresován svým bytím" +
                        "\n\t3. Nezvolili jsme si zrození - jsme do světa vrženi" +
                        "\n\t\tMožnosti volby žití:" +
                        "\n\t\t\ta) neautentické bytí - anonymní masa, necháme sebou manipulovat" +
                        "\n\t\t\tb) autentický život - usilování o život podle svého přesvědčení, zodpovědně" +
                        "\n\t4. Existence neoddělitelná od světa" +
                        "\n\t\t-mé bytí je vždy spolubytím ve světě" +
                        "\n\t5. Člověk žije v čase - bytí ke smrti" +
                        "\n\t\t-neautentické bytí uniká od tohoto faktu" +
                        "\n\t6. Člověk je bytostí pravdy" +
                        "\n\t\t-pravda se odhaluje skrze člověka, který se na bytí ptá" +
                        "\n\"Filosof je přítel bytí\""
                ),
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Henri Bergson",
                    false,
                    "(1859-1941), francouz, návaznost na iracionalismus" +
                        "\n-rozum (intelekt) má sklon \"kouskovat\" svět" +
                        "\n\t-je uzpůsoben převádět svět na věci" +
                        "\nPonoření do oceánu světa" +
                        "\n\t-pravá povaha bytí - čas a trvání" +
                        "\n\t-podstata života - \"tvořivý vývoj\"" +
                        "\n\t\t-\"elán vital\" (životní síla) - mimoracionální síla" +
                        "\n\tnaslouchání životu skrze INTUICI" +
                        "\n\nProtikladnost hmoty morálky a náboženství" +
                        "\n\tUzavřená forma" +
                        "\n\t\t-automatické chování, zvyky - sociální tlak společnosti" +
                        "\n\tOtevřená forma" +
                        "\n\t\t-osobní, nezávislá na společnosti, tvořivá"
                ),
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"existence předchází podstatu\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Herbert Marcuse",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem výroku \"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Erich Fromm",
                    false,
                    ""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Hnus\" (\"Nevolnost\") je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                ),
                PsychologyTermAnswer("Ludwig Feuerbach",
                    false,
                    "(1804-1872), Německo" +
                        "\n-návaznost na Hegela, odmítl absolutní idei (ideje v každé věci, absolutní)" +
                        "\nKritika náboženství" +
                        "\n\t-náboženství vzniklo z lidského egoismu" +
                        "\n\t-vysvětlení náboženství antropologicky a materialisticky (z přírodní podstaty člověka - smysly)" +
                        "\n\t-smyslovost a emoce člověk vtělil do Boha (odcizil sám sobě)" +
                        "\n\t\t-potřeba vztáhnout zpět do svého živoate - NÁBOŽENSTVÍ ČLOVĚKA" +
                        "\n\t\t\t-láska k lidem, nikoliv Bohu"
                ),
                PsychologyTermAnswer("Auguste Comte",
                    false,
                    "(1798-1857) pozitivismus, francouz" +
                        "\npozitivismus - pozitivní, tedy věcné, určité, zkušenost > rozum" +
                        "\n3. stádia vývoje vědění:" +
                        "\n\t1. teologické (nadpřirozenost)" +
                        "\n\t2. metafyzické (nadpřirozeno nahrazeno abstrakcí)" +
                        "\n\t3. pozitivní stádium (faktuální)" +
                        "\n-nové poznatky třídit do soustavy věd (návaznost na encyklopedisty)" +
                        "\nSOCIOLOGIE" +
                        "\n\t-společnost (sociální fakta) zkoumána vědeckými metodami"
                ),
                PsychologyTermAnswer("Karel Marx",
                    false,
                    "(1818-1883), materialismus" +
                        "\n-změnil Hegelovu dialektiku:" +
                        "\n\t-podstatou světa je materiální skutečnost" +
                        "\n\t-ideje jsou jen odrazem mat. skutečnosti v lidském vědomí" +
                        "\nPodstata člověka je práce" +
                        "\n\t-při ní se však člověk odcizil své podstatě" +
                        "\n\t-sociální, ekonomická nerovnost" +
                        "\nTŘÍDNÍ BOJ (ekonomické vztahy)" +
                        "\n\t-jsou to hybné síly dějin" +
                        "\n\t-protiklady vedou k sociálním revolucím (protiklady-Hegela)" +
                        "\n\tPROLETARIÁT - dělnická třída" +
                        "\n\t\t-živá práce (kapitál - mrtvá práce)" +
                        "\n\tproletářská revoluce -> beztřídní společnost" +
                        "\n\nMarxismus rozštěpen na komunistický a socialistický proud (konec 19.st), následně 2O.st. neomarxismus",
                    imageExplanationUrl = "https://www.politicky-slovnik.cz/wp-content/uploads/2019/09/prolet%C3%A1%C5%99i-v%C5%A1ech-zem%C3%AD-spojte-se.jpg"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Cesty ke svobodě\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean Paul Sartre",
                    false,
                    "(1905-1980), francouz, ateistický existencialismus" +
                        "\n-díla: \"Bytí a nicota\", \"Kritika dialektického rozumu\", \"Hnus\" (\"Nevolnost\"), \"Cesty ke svobodě\"" +
                        "\n-divadelní a literární tvorba, původně SŠ učitel, vliv na mladou generaci" +
                        "\n\"Hnus\" (\"Nevolnost\")" +
                        "\n\t-pocit bezdůvodnosti a tíže existence" +
                        "\n\t-východisko - angažovanost pro druhé" +
                        "\n\t\t-\"Nic nemůže být dobré pro nás, není-li to dobré pro všechny\"" +
                        "\n\"Cesty ke svobodě\"" +
                        "\n\t-svoboda smyslem lidského života" +
                        "\n-není Bůh, není vymezená podstata - jsme tady a teď" +
                        "\n\t-jsme odsouzeni svobodě - čím se učiníme sami" +
                        "\n\t-\"existence předchází podstatu\""
                ),
                PsychologyTermAnswer("Richard Avenarius",
                    false,
                    "(1843-1896) empiriokriticismus, novopozitivismus (logický empirismus), problém jazyka a sdělnosti"
                ),
                PsychologyTermAnswer("Bernard Russell",
                    false,
                    "(1872-1970), novopozitivismus (logický empirismus)" +
                        "\nLogický atomismus - empirický pluralismus (vícečetnost)"
                ),
                PsychologyTermAnswer("Rudolf Carnap",
                    false,
                    "(1891-1970), novopozitivismus (logický empirismus)," +
                        "\n-profesor německé univerzity v Praze" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Mor\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Rudolf Carnap",
                    false,
                    "(1891-1970), novopozitivismus (logický empirismus)," +
                        "\n-profesor německé univerzity v Praze" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                ),
                PsychologyTermAnswer("Ludwig Wittgenstein",
                    false,
                    "(1889-1951), novopozitivismus (logický empirismus)" +
                        "\n\"\"Logicko-filosofický traktát" +
                        "\n\t-východiska logického pozitivismu" +
                        "\n\t-již to není o vědomí, nýbrž o jazyku" +
                        "\n\"Trakrát\"" +
                        "\n\t-jazyk je naše konstrukce světa" +
                        "\n\t-\"O čem nelze mluvit, o tom je třeba mlčet\"" +
                        "\nJazykové hry jsou formou života" +
                        "\n\t-analýza jazyka, nelze konstruovat ideální jazyk" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                ),
                PsychologyTermAnswer("K. Raimund Popper",
                    false,
                    "(1902-1994), novopozitivismus (logický empirismus), KRITICKÝ RACIONALISMUS" +
                        "\n-indukce nemůže být nikdy úplná - logicky se na ni nelze spoléhat" +
                        "\n-namísto verifikace zavádí FALZIFIKACE" +
                        "\n\t-můžeme verifikovat jak dlouho chceme, nejlepší ověření je, zdali lze falzifikovat" +
                        "\n-odmítá co je nefalzifikovatelné" +
                        "\n\"Otevřená společnost a její nepřátelé\"" +
                        "\n\t-rehabilitace metafyziky"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Otevřená společnost a její nepřátelé\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("K. Raimund Popper",
                    false,
                    "(1902-1994), novopozitivismus (logický empirismus), KRITICKÝ RACIONALISMUS" +
                        "\n-indukce nemůže být nikdy úplná - logicky se na ni nelze spoléhat" +
                        "\n-namísto verifikace zavádí FALZIFIKACE" +
                        "\n\t-můžeme verifikovat jak dlouho chceme, nejlepší ověření je, zdali lze falzifikovat" +
                        "\n-odmítá co je nefalzifikovatelné" +
                        "\n\"Otevřená společnost a její nepřátelé\"" +
                        "\n\t-rehabilitace metafyziky"
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Rudolf Carnap",
                    false,
                    "(1891-1970), novopozitivismus (logický empirismus)," +
                        "\n-profesor německé univerzity v Praze" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                ),
                PsychologyTermAnswer("Ludwig Wittgenstein",
                    false,
                    "(1889-1951), novopozitivismus (logický empirismus)" +
                        "\n\"\"Logicko-filosofický traktát" +
                        "\n\t-východiska logického pozitivismu" +
                        "\n\t-již to není o vědomí, nýbrž o jazyku" +
                        "\n\"Trakrát\"" +
                        "\n\t-jazyk je naše konstrukce světa" +
                        "\n\t-\"O čem nelze mluvit, o tom je třeba mlčet\"" +
                        "\nJazykové hry jsou formou života" +
                        "\n\t-analýza jazyka, nelze konstruovat ideální jazyk" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Logicko-filosofický traktát\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Ludwig Wittgenstein",
                    false,
                    "(1889-1951), novopozitivismus (logický empirismus)" +
                        "\n\"\"Logicko-filosofický traktát" +
                        "\n\t-východiska logického pozitivismu" +
                        "\n\t-již to není o vědomí, nýbrž o jazyku" +
                        "\n\"Trakrát\"" +
                        "\n\t-jazyk je naše konstrukce světa" +
                        "\n\t-\"O čem nelze mluvit, o tom je třeba mlčet\"" +
                        "\nJazykové hry jsou formou života" +
                        "\n\t-analýza jazyka, nelze konstruovat ideální jazyk" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                ),
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Rudolf Carnap",
                    false,
                    "(1891-1970), novopozitivismus (logický empirismus)," +
                        "\n-profesor německé univerzity v Praze" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                ),
                PsychologyTermAnswer("K. Raimund Popper",
                    false,
                    "(1902-1994), novopozitivismus (logický empirismus), KRITICKÝ RACIONALISMUS" +
                        "\n-indukce nemůže být nikdy úplná - logicky se na ni nelze spoléhat" +
                        "\n-namísto verifikace zavádí FALZIFIKACE" +
                        "\n\t-můžeme verifikovat jak dlouho chceme, nejlepší ověření je, zdali lze falzifikovat" +
                        "\n-odmítá co je nefalzifikovatelné" +
                        "\n\"Otevřená společnost a její nepřátelé\"" +
                        "\n\t-rehabilitace metafyziky"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Mýtus o Sisyfovi\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Albert Camus",
                    false,
                    "(1913-1960), francouzský existencialismus, novinář" +
                        "\n\"Cizinec\"" +
                        "\n\t-lidská existence je absurdní" +
                        "\n\"Mor\" (symbol absurdní situace)" +
                        "\n\t-možné reakce na absorditu - nemusí paralyzovat, může být výzvou k aktivní REVOLTĚ" +
                        "\n\t-i když boj proti absurditě je sám absurdní, člověk v něm může najít smysl a štěstí" +
                        "\n\"Mýtus o Sisyfovi\", \"Revoltující člověk\"" +
                        "\n\t-Sisyfos stále vlekoucí skálu do vrchu a stále se pro ní vracející - absurdita - končí dobře"
                ),
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Herbert Marcuse",
                    false,
                    "(1898-1979), Amerika, Neomarxismus" +
                        "\n-spoluzakladatel Frankfurtské školy \"kulturní kritiky\"" +
                        "\n-prohloubění Marxova sociální učení o psychologickou dimenzi (psychoanalýza-Freud)"
                ),
                PsychologyTermAnswer("J. Maritain",
                    false,
                    "J. Maritain (1882-1973), francouzský teolog, nototomismus" +
                        "\n-vytvoření koncepce přírody a člověka" +
                        "\n\t-z pohledu vědy i křesťanství" +
                        "\n\t-evoluce vesmíru, přírody, ducha" +
                        "\n-po atmosféře a biosféře vzniká noosféra - sféra ducha" +
                        "\nOdpovědnost člověka" +
                        "\n\t-personalizace (prohlubování osobní jedinečnosti)" +
                        "\n\t-socializace (nadosobní cíle - společnost, věda, víra)" +
                        "\n-ve vývoji se společnost sjednocuje a směřuje k BODU \"OMEGA\""
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Zástupcem personalizmu byl",
            textAnswer = "Personalismus - člověk považován za nejvyšší hodnotu a zároveň zdroj všech hodnot",
            answers =
            listOf(
                PsychologyTermAnswer("Emmanuel Mounier",
                    false,
                    "(1905-1950), personalismus" +
                        "\n-úzké sepětí křesťanské problematiky a existencialismem" +
                        "\nKritika kapitalismu, který vytváří \"krizi osobnosti\""
                ),
                PsychologyTermAnswer("Henri Bergson",
                    false,
                    "(1859-1941), francouz, návaznost na iracionalismus" +
                        "\n-rozum (intelekt) má sklon \"kouskovat\" svět" +
                        "\n\t-je uzpůsoben převádět svět na věci" +
                        "\nPonoření do oceánu světa" +
                        "\n\t-pravá povaha bytí - čas a trvání" +
                        "\n\t-podstata života - \"tvořivý vývoj\"" +
                        "\n\t\t-\"elán vital\" (životní síla) - mimoracionální síla" +
                        "\n\tnaslouchání životu skrze INTUICI" +
                        "\n\nProtikladnost hmoty morálky a náboženství" +
                        "\n\tUzavřená forma" +
                        "\n\t\t-automatické chování, zvyky - sociální tlak společnosti" +
                        "\n\tOtevřená forma" +
                        "\n\t\t-osobní, nezávislá na společnosti, tvořivá"
                ),
                PsychologyTermAnswer("Paul Tillich",
                    false,
                    "(1886-1965), protestantismus" +
                        "\n-kritika protestantismu, že ztratil mystické prvky" +
                        "\nSYMBOLY"
                ),
                PsychologyTermAnswer("Ernst Mach",
                    false,
                    "(1838-1916), Brno, empiriokriticismus, novopozitivismus (logický empirismus), problém jazyka a sdělnosti"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Noosféra je",
            textAnswer = "J. Maritain (1882-1973), francouzský teolog, nototomismus" +
                "\n-vytvoření koncepce přírody a člověka" +
                "\n\t-z pohledu vědy i křesťanství" +
                "\n\t-evoluce vesmíru, přírody, ducha" +
                "\n-po atmosféře a biosféře vzniká noosféra - sféra ducha" +
                "\nOdpovědnost člověka" +
                "\n\t-personalizace (prohlubování osobní jedinečnosti)" +
                "\n\t-socializace (nadosobní cíle - společnost, věda, víra)" +
                "\n-ve vývoji se společnost sjednocuje a směřuje k BODU \"OMEGA\"",
            answers =
            listOf(
                PsychologyTermAnswer("sféra ducha",
                    false,
                    ""
                ),
                PsychologyTermAnswer("sféra člověka",
                    false,
                    ""
                ),
                PsychologyTermAnswer("logický empirismus",
                    false,
                    "neboli novopozitivismus"
                ),
                PsychologyTermAnswer("druhý pozitivismus",
                    false,
                    "neboli empiriokriticismus"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Tzv. druhý pozitivismus je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("empiriokriticismus",
                    false,
                    "Ernst Mach (Brno), Richard Avenarius"
                ),
                PsychologyTermAnswer("teleologie",
                    false,
                    "svět má předurčenou budoucnost, daný cíl"
                ),
                PsychologyTermAnswer("harmonie víry a racionální poznání vědy",
                    false,
                    "Novotomismus" +
                        "\nharmonie víry a racionální poznání vědy, navazuje na T.e Akvinského" +
                        "\n\"aggiornamento\" - přiblížení církve dnešnímu dni"
                ),
                PsychologyTermAnswer("materialismus",
                    false,
                    "hmota tvoří realitu, vč duchovní"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Jiné označení novopozitivismu je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("logický empirismus",
                    false,
                    ""
                ),
                PsychologyTermAnswer("teleologie",
                    false,
                    "svět má předurčenou budoucnost, daný cíl"
                ),
                PsychologyTermAnswer("materialismus",
                    false,
                    "hmota tvoří realitu, vč duchovní"
                ),
                PsychologyTermAnswer("monismus",
                    false,
                    "svět je z jedné látky"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autor závěrečné věty \"Traktátu\" - \"O čem nelze mluvit, o tom je třeba mlčet\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Ludwig Wittgenstein",
                    false,
                    "(1889-1951), novopozitivismus (logický empirismus)" +
                        "\n\"\"Logicko-filosofický traktát" +
                        "\n\t-východiska logického pozitivismu" +
                        "\n\t-již to není o vědomí, nýbrž o jazyku" +
                        "\n\"Trakrát\"" +
                        "\n\t-jazyk je naše konstrukce světa" +
                        "\n\t-\"O čem nelze mluvit, o tom je třeba mlčet\"" +
                        "\nJazykové hry jsou formou života" +
                        "\n\t-analýza jazyka, nelze konstruovat ideální jazyk" +
                        "\n-VÍDEŇSKÝ KRUH (v Praze)" +
                        "\n\t-věda je systém výroků, filosofie metoda prověřování těchto výroků" +
                        "\n\t-věta je smysluplná, pokud je gramaticky, logicky správná a dá se VERIFIKOVAT"
                ),
                PsychologyTermAnswer("Ferdinand de Saussure",
                    false,
                    "(1857-1913), zakladatel strukturalismu" +
                        "\n-jazyk není jen chaotický, má systém (strukturu)" +
                        "\n-významové jednotky jazyka jsou znaky"
                ),
                PsychologyTermAnswer("Claude Lévi-Strauss",
                    false,
                    "(1908), strukturalismus" +
                        "\nzkoumání tzv. přírodních (primitivních) kultur"
                ),
                PsychologyTermAnswer("Michel Foucault",
                    false,
                    "(1926-1984), postmodernismus, archeologie vědění" +
                        "\n-zavádí pojem epistémé (systém či řád, kterým předem regulujeme čím se vědění zabývá a jak to činí)" +
                        "\n-epistémé se děje vždy skokem, dějiny nejsou kontinuální, ale diskontinuální" +
                        "\n\t-diskurs - argumentovaný dialog uvnitř kultury"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Mezi zástupce novodobé Hermeneutiky nepatří",
            textAnswer = "-hledání metody výkladu a porozumění světu a člověku" +
                "\n-obecná interpretace",
            answers =
            listOf(
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("W. Dilthey",
                    false,
                    "(1833-1936), němec, hermeneutika" +
                        "\n-iracionalismus (logicky nesdělitelný obsah zkušenosti)" +
                        "\n-přírodověda zkoumá zprostředkované skutečnosti (věci)" +
                        "\n-duchovní vědy v prožitku (skrze intuici a introspekci)" +
                        "\n-dějiny jsou ve všem, co nás obklopuje"
                ),
                PsychologyTermAnswer("H.G. Gadamer",
                    false,
                    "(1900-2002)" +
                        "\nhermeneutická situace" +
                        "\n\t-interpretace je dialogem, interpret čerpá z dějin a životního horizontu"
                ),
                PsychologyTermAnswer("Paul Ricoeur",
                    false,
                    "(1913-2005)" +
                        "\n-interpretace kulturně-historických symbolů a metafor"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Autorem \"Kacířské eseje o filosofii dějin\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Jacques Derrida",
                    false,
                    "(1930), postmodernismus, přehodnotil strukturalismus" +
                        "\n-znaky získávají význam díky vzájemnému odlišení - DIFERENCI" +
                        "\n-struktura je otevřená" +
                        "\ndiffere - 1. odkládání 2. rozmisťování" +
                        "\nSTOPA" +
                        "\n\t-zmizení transcendentálnosti, předcházení" +
                        "\n\t-filosofie není konstrukcí - je dekonstrukcí proměnlivých významů"
                ),
                PsychologyTermAnswer("Jean-Francois Lyotard",
                    false,
                    "(1924), formuloval postmodernismus" +
                        "\n\"Postmoderní situace\"" +
                        "\n\t-co je pro naší dobu charakteristické?" +
                        "\n\t-meta-příběhy ztratily přesvědčivost" +
                        "\n\t-PLURALITA" +
                        "\n-ztráta veškeré jistoty - \"Všechno je možné\""
                ),
                PsychologyTermAnswer("Wolfgang Welsch",
                    false,
                    "(1946), kritik postmoderny" +
                        "\n-snaha vyhnout se etické libovůli, lhostejnosti, neodpovědnosti"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
    PsychologyTerm(
            prompt = "Autorem \"Přirozený svět jako filosofický problém\" je",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jan Patočka",
                    false,
                    "(1907-1977), Husserlův a Heideggerův žák" +
                        "\n\"Přirozený svět jako filosofický problém\" (1936)" +
                        "\n\t-popis Husserlovy fenomologické metody" +
                        "\n\"Kacířské eseje o filosofii dějin\" (1975)" +
                        "\n\t-přechod z předdějiným obdobím lidstav (mýtu) a období filosofie, kde člověk objevil svobodu (v polis)" +
                        "\n\tObčanská svoboda a zodpovědnost - předpoklad existence" +
                        "\n\t-první mluvčí Charty 77" +
                        "\nzákladní životní pohyby:" +
                        "\n\t1. Pohyb zakotvení ve světě" +
                        "\n\t\t-člověk přijímá situaci, do které je vržen" +
                        "\n\t2. Pohyb sebezbavení sebeprodloužením" +
                        "\n\t\t-člověk si všímá věcí, které mu mohou sloužit" +
                        "\n\t3. Pohyb sebenalezení" +
                        "\n\n\t-uvědomění si smrtelnosti člověka, přijímání vlastní konečnosti"
                ),
                PsychologyTermAnswer("Jean-Francois Lyotard",
                    false,
                    "(1924), formuloval postmodernismus" +
                        "\n\"Postmoderní situace\"" +
                        "\n\t-co je pro naší dobu charakteristické?" +
                        "\n\t-meta-příběhy ztratily přesvědčivost" +
                        "\n\t-PLURALITA" +
                        "\n-ztráta veškeré jistoty - \"Všechno je možné\""
                ),
                PsychologyTermAnswer("Jacques Derrida",
                    false,
                    "(1930), postmodernismus, přehodnotil strukturalismus" +
                        "\n-znaky získávají význam díky vzájemnému odlišení - DIFERENCI" +
                        "\n-struktura je otevřená" +
                        "\ndiffere - 1. odkládání 2. rozmisťování" +
                        "\nSTOPA" +
                        "\n\t-zmizení transcendentálnosti, předcházení" +
                        "\n\t-filosofie není konstrukcí - je dekonstrukcí proměnlivých významů"
                ),
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
        PsychologyTerm(
            prompt = "Poprvé formuloval postmodernismus",
            textAnswer = "",
            answers =
            listOf(
                PsychologyTermAnswer("Jean-Francois Lyotard",
                    false,
                    "(1924), formuloval postmodernismus" +
                        "\n\"Postmoderní situace\"" +
                        "\n\t-co je pro naší dobu charakteristické?" +
                        "\n\t-meta-příběhy ztratily přesvědčivost" +
                        "\n\t-PLURALITA" +
                        "\n-ztráta veškeré jistoty - \"Všechno je možné\""
                ),
                PsychologyTermAnswer("G.W.F. Hegel",
                    false,
                    "(1770-1831), novověká filosofie > německá romantika" +
                        "\n\"Fenomenologie ducha\"" +
                        "\n\t-jednota bytí a myšlení, není rozdíl mezi logikou myšlenku a přírodním zákonem" +
                        "\n\t-\"Vše, co jest rozumné, je skutečné, a co je skutečné, jest rozumné\"" +
                        "\n-svět je seberozvíjením absolutní ideje" +
                        "\n\t-ideje je v každé věci, není subjektivní, je absolutní" +
                        "\n\trozvoj probíhá dialekticky (vývoj protikladů) ve třech stupních:" +
                        "\n\t\t1. LOGIKA" +
                        "\n\t\t\t-přesahuje tradiční formální logiku (jednota protikladů)" +
                        "\n\t\t\t-objektivní dialektika, nejen subjektivní" +
                        "\n\t\t\t-zákony dialektiky (aplikované na dějiny)" +
                        "\n\t\t2. FILOSOFIE PŘÍRODY" +
                        "\n\t\t\t-sama o sobě \"hloupá\"" +
                        "\n\t\t3. FILOSOFIE DUCHA" +
                        "\n\t\t\t-3 dialektické stupně:" +
                        "\n\t\t\t\t1) subjektivní duch (vznik pojmu SEBEVĚDOMÍ)" +
                        "\n\t\t\t\t2) objektivní duch (\"objektivní\" řád lidských dějin)" +
                        "\n\t\t\t\t3) absolutní duch (umění, náboženství a filosofie)" +
                        "\nDIALEKTICKÁ METODA" +
                        "\n\t-vývoj protikladů" +
                        "\n\t-každý pojem omezený -> negace -> neneguje vše, pozůstatek vyšší jednota (protikladů)" +
                        "\n\t-JEDNOTA PROTIKLADŮ (negace negace)" +
                        "\n-HEGELOVSKÁ TRIÁDA" +
                        "\n\ta) teze b) z antiteze c) ze synteze" +
                        "\nROZUM VLÁDNE DĚJINAMI" +
                        "\n\t-sebetvoření lidí povyšuje přírodu na vyšší formu" +
                        "\n\t-člověk je aktivním tvůrcem svých dějin" +
                        "\n\nnásledníci:" +
                        "\n\tstarohégelovci - interpretovali světový duch nábožensky" +
                        "\n\tmladohégelovci - sociálně-materiální zákonitosti dějin (Marx)"
                ),
                PsychologyTermAnswer("Baruch Spinoza",
                    false,
                    "(1632-1677), holandský myslitel, novověk, porenesanční filosofie" +
                        "\n-vyděděný, pronásledovaný židovskou obcí, osamocen, sláb, chud" +
                        "\n-těžká práce - >BROUŠENÍ SKLA<" +
                        "\n-\"Etika vyložená způsobem užívaným v geometrii\"" +
                        "\n\t-filosofie musí mít matematickou jednoznačnost (stejně jako Descartes)" +
                        "\n\t-ztotožnění Boha a přírody (panteismus - Giordano Bruno)" +
                        "\n\t-svět je existence Boha, člověk je myšlení Boha" +
                        "\nKauzální (příčinná) nutnost - přírodní zákony panují ve světě" +
                        "\nMravní ctnost" +
                        "\n\t-přirozená nutnost, v člověku rozum" +
                        "\n\t-\"Svoboda je poznaná nutnost\"" +
                        "\n\t-základem sebezachování státu je ponechání myšlení a rozumu lidem - něco, co je pro člověka \"správné\" nemá být zločin"
                ),
                PsychologyTermAnswer("J. Gottlieb Fichte",
                    false,
                    "(1762-1814), novověká filosofie > německá romanticko-idealistická filosofie" +
                        "\nNesouhlas s vztahem aposteriorním (odvozeným) a apriorním (předem daný) poznáním" +
                        "\n\t-\"buď jedno, nebo druhé\":" +
                        "\n\t\t-buď pasivní povaha - od věci (sensualismus, materialismus)" +
                        "\n\t\t-anebo >mé Já aktivně< kladě před sebe předmět poznání a >vytváří svět v ideji< a obrazotvornosti (idealismus)" +
                        "\n-Aktivitu ducha demonstruje dialektickou metodou"
                )
            ),
            categoryId = "Filosofie",
            correctAnswer = 0
        ),
    )
}