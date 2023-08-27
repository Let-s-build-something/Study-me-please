package study.me.please.data.questions

import study.me.please.data.io.PsychologyTerm
import study.me.please.data.io.PsychologyTermAnswer

object PsychologyNine {

    val psychologyPrompts = listOf(
        PsychologyTerm(
            imageAnswerUrl = "https://www.stefajir.cz/files/mozkovy_kmen.png",
            prompt = """Mozkový kmen se skládá z/ze""",
            textAnswer = "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                "\nVšechny dráhy do a z mozku.",
            answers = listOf(
                PsychologyTermAnswer(
                    """středního mozku, mostu a prodloužené míchy""",
                    false,
                    "Prodlouená mícha (medulla) - 1.5cm dlouhá, reflexy (dýchání, kašel, sací, polykací, zvracivý), křížení eferentní a aferentní dráhy" +
                        "\n\nVarolův most (pons varoli) - spojuje mozeček, střední mozek a prodlouženou míchu, regulace dýchání, slzných a slinných žláz" +
                        "\n\nStřední mozek - držení vzpřímené polohy těla" +
                        "\n\t-čtverohrbolí - zrakové a sluchové reflexy" +
                        "\n\t-substantia nigra - dopamin (Parkinson, Schizofrenie)"
                ),
                PsychologyTermAnswer("""prodloužené míchy a mozečku""",
                    false,
                    "Prodloužená mícha -(Medulla Obllongata) - reflexy (kašel, sací, polykací, zvracivý), křížení eferentní a aferentní."
                ),
                PsychologyTermAnswer("""mostu a mozečku""",
                    false,
                    "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky"
                ),
                PsychologyTermAnswer("""talamu a středního mozku""",
                    false,
                    "Thalamus - operátor mozku - informace z PNS do CNS, senzorické, motorické dráhy, bolest"
                ),
            ),
            questionNumber = 1,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "",
            prompt = """Velké útvary šedé hmoty uvnitř hemisfér se souhrnně označují""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""čtverohrbolí""",
                    false,
                    "(Tectum), ve středním mozku." +
                        "\nHorní pár (colliculi superiores) - jen některé zrakové reflexy" +
                        "\nSpodní pár (colliculi inferiores) - sluchové dráhy",
                    imageExplanationUrl = "https://static.wikia.nocookie.net/brain-for-ai/images/b/bd/Tectum.png"
                ),
                PsychologyTermAnswer("""bazální ganglia""",
                    false,
                    "Velké útvary šedé hmoty uvnitř hemisfér. Plynulé, cílené a přesné pohyby." +
                        "\nTypy:" +
                        "\n\t-Nucleus caudatus" +
                        "\n\t-Putamen" +
                        "\n\t-Corpus stratium - Putamen + Nucleus caudatus" +
                        "\n\t-Globus pallidus (medialis, lateralis)" +
                        "\n\t-Nucleus lentiformis - Putamen + Globus pallidus" +
                        "- Huntingtonova chorea, tiky, Parkinson",
                    imageExplanationUrl = "https://cdn-cfofm.nitrocdn.com/MMCsahxLgXapyDWrjVzGzdjiRyqxAjlx/assets/static/optimized/brainmadesimple.com/wp-content/uploads/2019/11/df4443c177147565cab9a44e2734d622.Basal-Ganglia.png"
                ),
                PsychologyTermAnswer("""substantia nigra""",
                    false,
                    "(černá substance) Ve středním mozku. Dopamin - Parkinson, Schizofrenie",
                    imageExplanationUrl = "https://images.squarespace-cdn.com/content/v1/5a96f42d5b409bfd5be103ca/1566059478440-O4HGOBENDPRBM8Z900DG/substantia+nigra+structure+and+function"
                ),
                PsychologyTermAnswer("""nucleus lentiformis""",
                    false,
                    "bazální ganglia > Putamen + Globus pallidus"
                ),
            ),
            questionNumber = 2,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://static.wikia.nocookie.net/brain-for-ai/images/b/bd/Tectum.png",
            prompt = """Horní hrbolek čtverohrbolí je zapojen do""",
            textAnswer = "(Tectum), ve středním mozku." +
                "\nHorní pár (colliculi superiores) - jen některé zrakové reflexy" +
                "\nSpodní pár (colliculi inferiores) - sluchové dráhy",
            answers = listOf(
                PsychologyTermAnswer("""čichové dráhy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pyramidových drah""",
                    false,
                    "(Tractus corticospinalis), volní motorika (jemná motorika distálních končetin)" +
                        "\nkřížení drah probíhá na rozhraní prodloužené a páteřní míchy" +
                        "\nochrnutí končetin"
                ),
                PsychologyTermAnswer("""sluchové dráhy""",
                    false,
                    "Spodní pár (colliculi inferiores)"
                ),
                PsychologyTermAnswer("""zrakové dráhy""",
                    false,
                    ""
                ),
            ),
            questionNumber = 3,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Třetí mozková komora se nachází""",
            textAnswer = "Komory jsou vždycky uprostřed, nejspodnější komora je 4., 3. je uprostřed, která je uzavřená thalamy, následně jsou postranní komory v obouch hemisférách",
            imageAnswerUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Fourth_ventricle.png/350px-Fourth_ventricle.png",
            answers = listOf(
                PsychologyTermAnswer("""v mediální rovině""",
                    false,
                    "Respektive v půlce těla"
                ),
                PsychologyTermAnswer("""v pravé hemisféře""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v levé hemisféře""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v míše""",
                    false,
                    ""
                ),
            ),
            questionNumber = 4,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Odstředivé nervy vycházejí z míchy""",
            textAnswer = "Odstředivé - eferentní nervy - přední rohy míchy" +
                "\nDostředivé - aferentní nervy, zadní rohy míchy",
            answers = listOf(
                PsychologyTermAnswer("""předními i zadními kořeny""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""postranními sloupci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předními kořeny""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zadními kořeny""",
                    false,
                    ""
                ),
            ),
            questionNumber = 5,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
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
            questionNumber = -5,
            categoryId = "9. Nervová soustava",
            correctAnswer = 2
        ),
        PsychologyTerm(
            prompt = """Součástí limbického systému není/nejsou""",
            textAnswer = "",
            imageAnswerUrl = "https://s.tmimgcdn.com/scr/1200x627/214700/anatomie-mozku-limbicky-system-infografiky-201100304-vektorove-ilustrace-koncept_214775-original.jpg",
            answers = listOf(
                PsychologyTermAnswer("""corpora mamillaria""",
                    false,
                    "Relé pro impulsy přícházející z amygdaly a hyppocampus. (občas se bere za součást hypothalamu)",
                    imageExplanationUrl = "https://upload.wikimedia.org/wikipedia/commons/8/84/Gray718.png"
                ),
                PsychologyTermAnswer("""gyrus cinguli""", false,
                    "Cingulární kortex (korová oblast) -  mimovolní aktivita/pohyb"
                ),
                PsychologyTermAnswer("""amygdala""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """retikulární formace""",
                    false,
                    "Retikulární formace prostupuje mozkovým kmenem, " +
                        "pokračuje do thalamu a hypothalamu, kaudálně navazuje na propriospinální míšní síť.\nFunkce: " +
                        "-senzitivní, motorická a autonomní funkce, složité reflexy\n" +
                        "- centrum řízení dýchání, kardiovaskulární soustavy, vazomotoriky, spánku, bdění"
                ),
            ),
            questionNumber = 6,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.wikiskripta.eu/images/2/2a/Gray754_cs.png",
            prompt = """Kolik vrstev se rozlišuje ve většině mozkové kůry?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""6""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""cca 45""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""4""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""22""",
                    false,
                    ""
                ),
            ),
            questionNumber = 7,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Wernickeovo řečové centrum se nachází v levém""",
            textAnswer = "",
            imageAnswerUrl = "https://sainte-anastasie.org/img/images_3/lbulo-occipital-estructura-y-funciones_4.jpg",
            answers = listOf(
                PsychologyTermAnswer("""frontálním laloku""",
                    false,
                    "čelní lalok - motorická oblast, centrum kontroly, na spodní části se přepojují čichové dráhy"
                ),
                PsychologyTermAnswer("""okcipitálním laloku""",
                    false,
                    "(tylní lalok) - centrum zraku" +
                        "\nPseudohalucinace - třeba u LSD, kdy vidímě věci, které tam nejsou, ale víme o tom." +
                        "\nProsopagnózie - neschopnost rozpoznávat obličeje"
                ),
                PsychologyTermAnswer("""temporálním laloku""",
                    false,
                    "(spánkový lalok) - centrum sluchu, hippocampus, řeč" +
                        "\nAmusie - neschopnost rozpoznávat zvuky"
                ),
                PsychologyTermAnswer("""parietálním laloku""",
                    false,
                    "(temenní lalok) - signály z receptorů, primární somatosenzorická oblast, pozornost, orientace" +
                        "\nAgnózie - porucha poznávání předmětů" +
                        "\nAutotopagnézie - neumí určit kde je jejich ruka, problém identifikace" +
                        "\nHemineglekt/neglect syndrom - neschopnost vnímat půlku těla"
                ),
                PsychologyTermAnswer("""paleokortexu""",
                    false,
                    "nejstarší část kortexu, v oblasti pro čich (rhinencephalon)"
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Brocovo řečové centrum se nachází v levém""",
            textAnswer = "",
            imageAnswerUrl = "https://sainte-anastasie.org/img/images_3/lbulo-occipital-estructura-y-funciones_4.jpg",
            answers = listOf(
                PsychologyTermAnswer("""frontálním laloku""",
                    false,
                    "čelní lalok - motorická oblast, centrum kontroly, na spodní části se přepojují čichové dráhy"
                ),
                PsychologyTermAnswer("""okcipitálním laloku""",
                    false,
                    "(tylní lalok) - centrum zraku" +
                        "\nPseudohalucinace - třeba u LSD, kdy vidímě věci, které tam nejsou, ale víme o tom." +
                        "\nProsopagnózie - neschopnost rozpoznávat obličeje"
                ),
                PsychologyTermAnswer("""temporálním laloku""",
                    false,
                    "(spánkový lalok) - centrum sluchu, hippocampus, řeč" +
                        "\nAmusie - neschopnost rozpoznávat zvuky"
                ),
                PsychologyTermAnswer("""parietálním laloku""",
                    false,
                    "(temenní lalok) - signály z receptorů, primární somatosenzorická oblast, pozornost, orientace" +
                        "\nAgnózie - porucha poznávání předmětů" +
                        "\nAutotopagnézie - neumí určit kde je jejich ruka, problém identifikace" +
                        "\nHemineglekt/neglect syndrom - neschopnost vnímat půlku těla"
                ),
                PsychologyTermAnswer("""paleokortexu""",
                    false,
                    "nejstarší část kortexu, v oblasti pro čich (rhinencephalon)"
                ),
            ),
            questionNumber = 8,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mozkomíšní mok se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""encefaloplazma""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""likvor""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""plazma""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""encefalitida""",
                    false,
                    ""
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Pro osobnostní integraci a plánování komplexního chování mají rozhodující význam""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""frontální laloky""",
                    false,
                    "čelní lalok - motorická oblast, centrum kontroly, na spodní části se přepojují čichové dráhy"
                ),
                PsychologyTermAnswer("""temporální laloky""",
                    false,
                    "(spánkový lalok) - centrum sluchu, hippocampus, řeč" +
                        "\nAmusie - neschopnost rozpoznávat zvuky"
                ),
                PsychologyTermAnswer("""bazální ganglia""",
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
                PsychologyTermAnswer("""talamy""",
                    false,
                    "Thalamus - operátor mozku - informace z PNS do CNS, senzorické, motorické dráhy, bolest"
                ),
            ),
            questionNumber = 10,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = "Neschopnost provádění určitých složitějších pohybů, postižení organizace a souhry složitějších pohybů," +
                " příp. schopnosti pochopit a zapamatovat si verbálně popsaný sled pohybů se označuje jako",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""prospagnózie""",
                    false,
                    "neschopnost rozpoznávat obličeje"
                ),
                PsychologyTermAnswer("""apraxie""",
                    false,
                    "hlavně již naučené pohyby, používání nástrojů (česání opačnou stranou hřebenu)"
                ),
                PsychologyTermAnswer("""agnózie""",
                    false,
                    "porucha poznávání předmětů"
                ),
                PsychologyTermAnswer("""ataxe""",
                    false,
                    "Poruchy koordinace pohybů těla, např. nejistota při chůzi"
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Odnětí velkých částí mozkové kůry se někdy provádí z léčebných důvodů při""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""amnézii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""depresi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""epilepsii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""schizofrenii""",
                    false,
                    "lobotomie (Egas Moniz)"
                ),
            ),
            questionNumber = 12,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.manual-cmp.cz/wp-content/uploads/2021/02/vizualni-kortex-3.jpg",
            prompt = """Ke křížení zrakových drah dochází""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pod přední částí hypotalamu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v inzule""",
                    false,
                    "je uprostřed mozku (uvnitř), integrační funkce (integruje senzorické a limbické funkce)"
                ),
                PsychologyTermAnswer("""v talamech""",
                    false,
                    "Thalamus - operátor mozku - informace z PNS do CNS, senzorické, motorické dráhy, bolest"
                ),
                PsychologyTermAnswer("""v bílé hmotě okcipitálního laloku""",
                    false,
                    "(tylní lalok) - centrum zraku" +
                        "\nPseudohalucinace - třeba u LSD, kdy vidímě věci, které tam nejsou, ale víme o tom." +
                        "\nProsopagnózie - neschopnost rozpoznávat obličeje"
                ),
            ),
            questionNumber = 13,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Pro zpracování jazyka je rozhodující""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pravá hemisféra""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""časová souhra pravé a levé hemisféry""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """propojení pravé a levé hemisféry v kaudální části kalózního tělesa""",
                    false
                ),
                PsychologyTermAnswer("""levá hemisféra""",
                    false,
                    ""
                ),
            ),
            questionNumber = 14,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mediátory (neurotransmittery) způsobují""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""polarizaci a hyperpolarizaci membrány""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""depolarizaci membrány""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""polarizaci membrány""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""depolarizaci i polarizaci membrány""",
                    false,
                    "Inhibice (utlumení) a excitace (podráždění)"
                ),
            ),
            questionNumber = 15,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Huntingtonova chorea je způsobena postižením""",
            textAnswer = "chorea - mimovolné rychlý pohyby",
            answers = listOf(
                PsychologyTermAnswer("""bazálních ganglii""",
                    false,
                    "Velké útvary šedé hmoty uvnitř hemisfér. Plnulé, cílené a přesné pohyby." +
                        "\nTypy:" +
                        "\n\t-Nucleus caudatus" +
                        "\n\t-Putamen" +
                        "\n\t-Corpus stratium - Putamen + Nucleus caudatus" +
                        "\n\t-Globus pallidus (medialis, lateralis)" +
                        "\n\t-Nucleus lentiformis - Putamen + Globus pallidus"
                ),
                PsychologyTermAnswer("""mostu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""motorické kůry""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""mozečku""",
                    false,
                    ""
                ),
            ),
            questionNumber = 16,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Somatosenzorická kůra se nachází""",
            textAnswer = "",
            imageAnswerUrl = "https://cdn.myshoptet.com/usr/www.zentrichovaapatyka.cz/user/documents/upload/gallery/FOTO/T%C4%9Blo/Mozek.png",
            answers = listOf(
                PsychologyTermAnswer("""v precentrálním závitu""",
                    false,
                    "předcentrální oblast – je před zářezem, motorická funkce (sbíhají se zde pyramidové dráhy)"
                ),
                PsychologyTermAnswer("""v pravém parietálním laloku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve frontálních lalocích""",
                    false,
                    "čelní lalok - motorická oblast, centrum kontroly, na spodní části se přepojují čichové dráhy"
                ),
                PsychologyTermAnswer("""v postcentrálním závitu""",
                    false,
                    "postcentrální oblast (v parietálním laloku) – jdou zde somatosenzorické a chuťové informace, nachází se u centrálního zářezu"
                ),
            ),
            questionNumber = 17,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.stefajir.cz/files/mozkovy_kmen.png",
            prompt = """Mezi středním mozkem a prodlouženou míchou se nachází""",
            textAnswer = "Mozkový kmen",
            answers = listOf(
                PsychologyTermAnswer("""mozkový kmen""",
                    false,
                    "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                        "\nSkládá se z středního mozku, mostu a prodloužené míchy." +
                        "\nVšechny dráhy do a z mozku."
                ),
                PsychologyTermAnswer("""hypotalamus""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
                PsychologyTermAnswer("""čtverohrbolí""",
                    false,
                    "(Tectum), ve středním mozku." +
                        "\nHorní pár (colliculi superiores) - jen některé zrakové reflexy" +
                        "\nSpodní pár (colliculi inferiores) - sluchové dráhy",
                    imageExplanationUrl = "https://static.wikia.nocookie.net/brain-for-ai/images/b/bd/Tectum.png"
                ),
                PsychologyTermAnswer(
                    """Varolův most""",
                    false,
                    "Varolův most (pons varoli) - spojuje mozeček, střední mozek a prodlouženou míchu, regulace dýchání, slzných a slinných žláz"
                ),
            ),
            questionNumber = 18,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaký mediátor se uvolňuje v nervosvalové ploténce?""",
            textAnswer = "Glutammát (excitační) - aktivátor všech mozk. funckcí" +
                "\nGaba (inhibiční, kyselina gamaaminomáselný) - alkohol, anxiotika" +
                "\nDopamin - limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)" +
                "\nSeratonin  - prožívání, spánek, deprese" +
                "\nAcethylcholin - nové paměťové spoje, Alzheimer, parasympatický NS" +
                "\nAdrenalin (Epinefrin), nonadrenalin - aktivace, spánek, probuzení, sympatický NS" +
                "\nOxytocin - sociální příjimání (matky mají mnoho před porodem)" +
                "\nEndorfiny (inhibiční) - tlumí bolest",
            answers = listOf(
                PsychologyTermAnswer("""acetylcholin""",
                    false,
                    "nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""žádný""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""tyrozin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""GABA""",
                    false,
                    "(inhibiční, kyselina gamaaminomáselný) - alkohol, anxiotika"
                ),
            ),
            questionNumber = 19,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.diygenius.com/wp-content/uploads/2022/12/brainwave-frequencies-chart.jpg",
            prompt = """Vlny alfa na EEG mají frekveci""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""asi 20 Hz""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""8-13 Hz""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""3-7 Hz""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na EEG se nevyskytují""",
                    false,
                    ""
                ),
            ),
            questionNumber = 20,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Do sluchové dráhy je zapojen/o""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nucleus lentiformis""",
                    false,
                    "bazální ganglia" +
                        "\nTypy:" +
                        "\n\t-Nucleus caudatus" +
                        "\n\t-Putamen" +
                        "\n\t-Corpus stratium - Putamen + Nucleus caudatus" +
                        "\n\t-Globus pallidus (medialis, lateralis)" +
                        "\n\t-Nucleus lentiformis - Putamen + Globus pallidus" +
                        "- Huntingtonova chorea, tiky, Parkinson"
                ),
                PsychologyTermAnswer("""corpus geniculatum laterale""",
                    false,
                    "thalamus, klíčový bod pro optickou dráhu u savců"
                ),
                PsychologyTermAnswer("""dolní hrbolek čtverohrbolí""",
                    false,
                    "Spodní pár (colliculi inferiores) - sluchové dráhy",
                    imageExplanationUrl = "https://pbs.twimg.com/media/DaHD9xKU0AA396V.jpg"
                ),
                PsychologyTermAnswer("""horní hrbolek čtverohrbolí""",
                    false,
                    "Horní pár (colliculi superiores) - jen některé zrakové reflexy"
                ),
            ),
            questionNumber = 21,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Centrum řady vegetativních funkcí, umístěné pod talamem, se označuje""",
            textAnswer = "Thalamus - operátor mozku - informace z PNS do CNS, senzorické, motorické dráhy, bolest",
            answers = listOf(
                PsychologyTermAnswer("""hypotalamus""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
                PsychologyTermAnswer("""subtalamus""",
                    false,
                    "mezi talamem a mezimozkem, somatické pohyby"
                ),
                PsychologyTermAnswer("""metatalamus""",
                    false,
                    "zrakové a sluchov dráhy"
                ),
                PsychologyTermAnswer("""epifýza""",
                    false,
                    "(šišinka), epitalamus - endokrinní funkce, melationin, biorytmy"
                ),
                PsychologyTermAnswer("""epitalamus""",
                    false,
                    "Součást mezimozku. Vybýhá z něho epifýza=šišinka. Endokrinní funkce (hormony), bioritmy (melatonin)"
                ),
            ),
            questionNumber = 22,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavový nerv č. II je""",
            textAnswer = "I. čichový nerv (koncový mozek)" +
                "\nII. zrakový nerv (mezimozek)" +
                "\nIII. okohybný nerv (střední mozek)" +
                "\nIV. kladkový nerv (střední mozek) - horní šikmý oční sval" +
                "\nV. trojklanný nerv (varolův most) - obličej" +
                "\nVI. odtahovací nerv (varolův most) - zevní přímý oční sval" +
                "\nVII. lícní nerv (varolův most) - mimika" +
                "\nVIII. sluchově rovnovážný nerv - zvuk, rovnováha" +
                "\nIX. jazykohltanový (prodloužená mícha) - slznice hltanu, zadní 1/3 jazyka" +
                "\nX. bloudivý nerv - krk, hruď" +
                "\nXI přídatný nerv - hltan, hrtan" +
                "\nXII. podjazykový nerv - svaly jazyka",
            answers = listOf(
                PsychologyTermAnswer("""nerv okohybný""",
                    false,
                    "III."
                ),
                PsychologyTermAnswer("""nerv kladkový""",
                    false,
                    "IV."
                ),
                PsychologyTermAnswer("""nerv zrakový""",
                    false,
                    "II."
                ),
                PsychologyTermAnswer("""nerv bloudivý""",
                    false,
                    "X."
                ),
            ),
            questionNumber = 23,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavový nerv č. V je""",
            textAnswer = "I. čichový nerv (koncový mozek)" +
                "\nII. zrakový nerv (mezimozek)" +
                "\nIII. okohybný nerv (střední mozek)" +
                "\nIV. kladkový nerv (střední mozek) - horní šikmý oční sval" +
                "\nV. trojklanný nerv (varolův most) - obličej" +
                "\nVI. odtahovací nerv (varolův most) - zevní přímý oční sval" +
                "\nVII. lícní nerv (varolův most) - mimika" +
                "\nVIII. sluchově rovnovážný nerv - zvuk, rovnováha" +
                "\nIX. jazykohltanový (prodloužená mícha) - slznice hltanu, zadní 1/3 jazyka" +
                "\nX. bloudivý nerv - krk, hruď" +
                "\nXI přídatný nerv - hltan, hrtan" +
                "\nXII. podjazykový nerv - svaly jazyka",
            answers = listOf(
                PsychologyTermAnswer("""nerv odtahovací""",
                    false,
                    "VI."
                ),
                PsychologyTermAnswer("""nerv trojklanný""",
                    false,
                    "V."
                ),
                PsychologyTermAnswer("""nerv lícní""",
                    false,
                    "VII."
                ),
                PsychologyTermAnswer("""nerv podjazykový""",
                    false,
                    "XII."
                ),
            ),
            questionNumber = -23,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavový nerv č. VIII je""",
            textAnswer = "I. čichový nerv (koncový mozek)" +
                "\nII. zrakový nerv (mezimozek)" +
                "\nIII. okohybný nerv (střední mozek)" +
                "\nIV. kladkový nerv (střední mozek) - horní šikmý oční sval" +
                "\nV. trojklanný nerv (varolův most) - obličej" +
                "\nVI. odtahovací nerv (varolův most) - zevní přímý oční sval" +
                "\nVII. lícní nerv (varolův most) - mimika" +
                "\nVIII. sluchově rovnovážný nerv - zvuk, rovnováha" +
                "\nIX. jazykohltanový (prodloužená mícha) - slznice hltanu, zadní 1/3 jazyka" +
                "\nX. bloudivý nerv - krk, hruď" +
                "\nXI přídatný nerv - hltan, hrtan" +
                "\nXII. podjazykový nerv - svaly jazyka",
            answers = listOf(
                PsychologyTermAnswer("""nerv jazykohltanový""",
                    false,
                    "IX."
                ),
                PsychologyTermAnswer("""nerv přídatný""",
                    false,
                    "XI."
                ),
                PsychologyTermAnswer("""nerv sluchově rovnovážný""",
                    false,
                    "VIII."
                ),
                PsychologyTermAnswer("""nerv čichový""",
                    false,
                    "I."
                ),
            ),
            questionNumber = -523,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Pacient po operaci ztratí schopnost zapamatovat si nové události, které se staly po operaci. Jedná se o""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""perzistentní hypomemii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""anterográdní amnézii""",
                    false,
                    "ztráta paměti po úrazu"
                ),
                PsychologyTermAnswer("""parciální hypomemii""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""retrográdní amnézii""",
                    false,
                    "ztráta paměti před úrazem"
                ),
                PsychologyTermAnswer("""selektivní amnézii""",
                    false,
                    "represe"
                ),
                PsychologyTermAnswer("""hypermnézie""",
                    false,
                    "člověk si pamatuje nepříjemné obsahy až do extrémního detailu"
                ),
            ),
            questionNumber = 24,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://cdn-cfofm.nitrocdn.com/MMCsahxLgXapyDWrjVzGzdjiRyqxAjlx/assets/static/optimized/brainmadesimple.com/wp-content/uploads/2019/11/df4443c177147565cab9a44e2734d622.Basal-Ganglia.png",
            prompt = """Bazální ganglia hrají roli zejména při""",
            textAnswer = "Velké útvary šedé hmoty uvnitř hemisfér. Plynulé, cílené a přesné pohyby." +
                "\nTypy:" +
                "\n\t-Nucleus caudatus" +
                "\n\t-Putamen" +
                "\n\t-Corpus stratium - Putamen + Nucleus caudatus" +
                "\n\t-Globus pallidus (medialis, lateralis)" +
                "\n\t-Nucleus lentiformis - Putamen + Globus pallidus" +
                "- Huntingtonova chorea, tiky, Parkinson",
            answers = listOf(
                PsychologyTermAnswer(
                    """koordinaci naučených automatizovaných pohybů""",
                    false
                ),
                PsychologyTermAnswer("""zrakové orientaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""tvorbě řeči""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """zpracování hmatové informace z prstů rukou""",
                    false
                ),
            ),
            questionNumber = 25,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Spojení mezi hemisférami koncového mozku obstarává""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""adhesio interthalamica""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""corpus callosum""",
                    false,
                    "R. Sperry - rozštěpení levé a pravé hemisféry, hemisféry fungují nezávisle na sobě, inverze končetin (levé okolo, pravá část hemisféry)",
                    imageExplanationUrl = "https://qbi.uq.edu.au/files/28026/Corpus_callosum.png"
                ),
                PsychologyTermAnswer("""střední mozek""", false,
                    "Střední mozek - držení vzpřímené polohy těla" +
                        "\n\t-čtverohrbolí - zrakové a sluchové reflexy" +
                        "\n\t-substantia nigra - dopamin (Parkinson, Schizofrenie)"
                ),
                PsychologyTermAnswer("""chiasma opticum""",
                    false,
                    ""
                ),
            ),
            questionNumber = 26,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://slideplayer.cz/slide/2913298/10/images/11/K%C5%AFra+mozkov%C3%A1+Mozkov%C3%A1+k%C5%AFra+%28neokortex%29+je+na+povrchu+hemisf%C3%A9r.jpg",
            prompt = """Jaká je tloušťka mozkové kůry?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""1-2 mm""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""2-5 mm""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asi 1 cm""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""5-8 mm""",
                    false,
                    ""
                ),
            ),
            questionNumber = 27,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Trojklanný nerv je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""V. hlavový nerv""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""VII. hlavový nerv""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rameno bloudivého nervu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""2. míšní nerv""",
                    false,
                    ""
                ),
            ),
            questionNumber = 28,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://cdn-cfofm.nitrocdn.com/MMCsahxLgXapyDWrjVzGzdjiRyqxAjlx/assets/static/optimized/brainmadesimple.com/wp-content/uploads/2019/11/df4443c177147565cab9a44e2734d622.Basal-Ganglia.png",
            prompt = """Mezi bazální ganglia nepatří""",
            textAnswer = "Velké útvary šedé hmoty uvnitř hemisfér. Plynulé, cílené a přesné pohyby." +
                "\nTypy:" +
                "\n\t-Nucleus caudatus" +
                "\n\t-Putamen" +
                "\n\t-Corpus stratium - Putamen + Nucleus caudatus" +
                "\n\t-Globus pallidus (medialis, lateralis)" +
                "\n\t-Nucleus lentiformis - Putamen + Globus pallidus" +
                "- Huntingtonova chorea, tiky, Parkinson",
            answers = listOf(
                PsychologyTermAnswer("""nucleus lentiformis""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""putamen""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nucleus caudatus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nucleus accumbens""",
                    false,
                    ""
                ),
            ),
            questionNumber = 29,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Limbický systém má rozhodující roli v řízení""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""vegetativních reakcí organismu""",
                    false,
                    "Hypothalamus, Autonomní/vegetativní NS"
                ),
                PsychologyTermAnswer("""plánování a volbě strategie""",
                    false,
                    "frontální lalok"
                ),
                PsychologyTermAnswer("""kosterního svalstva""",
                    false,
                    "Somatická NS"
                ),
                PsychologyTermAnswer("""komplexního instinktivního chování""",
                    false,
                    ""
                ),
            ),
            questionNumber = 30,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://upload.wikimedia.org/wikipedia/commons/3/3a/Head_olfactory_nerve.jpg",
            prompt = """Čichové dráhy se přepojují""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""na spodní části frontálního laloku""",
                    false,
                    "čelní lalok - motorická oblast, centrum kontroly"
                ),
                PsychologyTermAnswer("""v hypotalamu""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
                PsychologyTermAnswer("""v subtalamu""",
                    false,
                    "mezi talamem a mezimozkem, somatické pohyby"
                ),
                PsychologyTermAnswer(
                    """na mediálních plochách frontálního laloku""",
                    false
                ),
            ),
            questionNumber = 31,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Pacient trpící prozopagnózií""",
            textAnswer = "Zraková agnózie - porucha poznávání známých tváří",
            answers = listOf(
                PsychologyTermAnswer(
                    """nedokáže rozlišovat a zapamatovat si různé nástroje""",
                    false
                ),
                PsychologyTermAnswer(
                    """není schopen rozlišovat rostliny a zvířata""",
                    false
                ),
                PsychologyTermAnswer(
                    """vidí předměty a umí s nimi zacházet, ale nedokáže je pojmenovat""",
                    false
                ),
                PsychologyTermAnswer(
                    """nedokáže rozlišit a zapamatovat si různé lidské obličeje""",
                    false
                ),
            ),
            questionNumber = 32,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Asociační dráhy spojují""",
            textAnswer = "Bílá hmota. Spojují závity kůry v téže polokouli, analyticko - syntetická činnost kůryn",
            answers = listOf(
                PsychologyTermAnswer("""jádra mozkového kmene s jádry talamu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""různé oblasti šedé kůry mozkové""",
                    false,
                    "Šedá hmota - těla a krátké výběžky neuronů - analýza (rozklad informací) a syntéza (spojení informací) vzruchů - v kůře nebo jádře" +
                        "\nBílá hmota - dlouhé výběžky - nervové dráhy, vedení vzruchu"
                ),
                PsychologyTermAnswer("""jádra talamu s mozkovou kůrou""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """oblasti mozkové kůry s kontralaterálními oblastmi ve středním mozku""",
                    false
                ),
            ),
            questionNumber = 33,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaká je podstata účinku psychostimulancií, např. metamfetaminu?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """zvyšování koncentrace noradrenalinu a dopaminu v synaptické štěrbině""",
                    false
                ),
                PsychologyTermAnswer(
                    """zablokování zpětného vychytávání serotoninu ze synaptické štěrbiny""",
                    false
                ),
                PsychologyTermAnswer(
                    """snižování koncentrace dopaminu v synaptické štěrbině""",
                    false
                ),
                PsychologyTermAnswer("""zvýšení sekrece GABA do synapsi""",
                    false,
                    "(inhibiční, kyselina gamaaminomáselný) - alkohol, anxiotika"
                ),
            ),
            questionNumber = 34,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Která uvedených metod není zobrazovací metodou při vyšetřeních mozku?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pozitronová emisní tomografie""",
                    false,
                    "PET"
                ),
                PsychologyTermAnswer("""dvoufotonová magnetická tomografie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""počítačová (výpočetní) tomografie""",
                    false,
                    "CT"
                ),
                PsychologyTermAnswer("""magnetická rezonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""radioizotopová vyšetření """,
                    false,
                    "PET, SPECT, scintigrafie"
                ),
                PsychologyTermAnswer("""ultrasonografie""",
                    false,
                    "USG"
                ),
                PsychologyTermAnswer("""perimyelografie a radikulosakografie """,
                    false,
                    "PMG a RSG"
                ),
                PsychologyTermAnswer("""nativní RTG snímky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""digitální subtrakční angiografie""",
                    false,
                    "DSA"
                ),
                PsychologyTermAnswer("""elektroencefalografie """,
                    false,
                    "EEG"
                ),
            ),
            questionNumber = 35,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Která uvedených metod není zobrazovací metodou při vyšetřeních mozku?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pozitronová emisní tomografie""",
                    false,
                    "PET"
                ),
                PsychologyTermAnswer("""chorozlopická rezonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""počítačová (výpočetní) tomografie""",
                    false,
                    "CT"
                ),
                PsychologyTermAnswer("""magnetická rezonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""radioizotopová vyšetření""",
                    false,
                    "PET, SPECT, scintigrafie"
                ),
                PsychologyTermAnswer("""ultrasonografie""",
                    false,
                    "USG"
                ),
                PsychologyTermAnswer("""perimyelografie a radikulosakografie """,
                    false,
                    "PMG a RSG"
                ),
                PsychologyTermAnswer("""nativní RTG snímky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""digitální subtrakční angiografie""",
                    false,
                    "DSA"
                ),
                PsychologyTermAnswer("""elektroencefalografie """,
                    false,
                    "EEG"
                ),
            ),
            questionNumber = 835,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Která uvedených metod není zobrazovací metodou při vyšetřeních mozku?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pozitronová emisní tomografie""",
                    false,
                    "PET"
                ),
                PsychologyTermAnswer("""tropologická tomografie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""počítačová (výpočetní) tomografie""",
                    false,
                    "CT"
                ),
                PsychologyTermAnswer("""magnetická rezonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""radioizotopová vyšetření """,
                    false,
                    "PET, SPECT, scintigrafie"
                ),
                PsychologyTermAnswer("""ultrasonografie""",
                    false,
                    "USG"
                ),
                PsychologyTermAnswer("""perimyelografie a radikulosakografie """,
                    false,
                    "PMG a RSG"
                ),
                PsychologyTermAnswer("""nativní RTG snímky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""digitální subtrakční angiografie""",
                    false,
                    "DSA"
                ),
                PsychologyTermAnswer("""elektroencefalografie """,
                    false,
                    "EEG"
                ),
            ),
            questionNumber = 935,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Která uvedených metod není zobrazovací metodou při vyšetřeních mozku?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pozitronová emisní tomografie""",
                    false,
                    "PET"
                ),
                PsychologyTermAnswer("""radiokoporní tomografie""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""počítačová (výpočetní) tomografie""",
                    false,
                    "CT"
                ),
                PsychologyTermAnswer("""magnetická rezonance""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""radioizotopová vyšetření""",
                    false,
                    "PET, SPECT, scintigrafie"
                ),
                PsychologyTermAnswer("""ultrasonografie""",
                    false,
                    "USG"
                ),
                PsychologyTermAnswer("""perimyelografie a radikulosakografie""",
                    false,
                    "PMG a RSG"
                ),
                PsychologyTermAnswer("""nativní RTG snímky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""digitální subtrakční angiografie""",
                    false,
                    "DSA"
                ),
                PsychologyTermAnswer("""elektroencefalografie """,
                    false,
                    "EEG"
                ),
            ),
            questionNumber = 535,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.stefajir.cz/files/mozecek_bocni.png",
            prompt = """Mozeček se podílí zejména na""",
            textAnswer = "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky",
            answers = listOf(
                PsychologyTermAnswer("""zrakovém vnímání""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""řízení vegetativních funkcí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""prostorové paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """udržování rovnovážné polohy""",
                    false
                ),
            ),
            questionNumber = 36,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Ze kterého zárodečného listu se tvoří mozek""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""z ektodermu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""z endodermu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""z mezodermu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""z ektodermu a mezodermu""",
                    false,
                    ""
                ),
            ),
            questionNumber = 37,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://upload.wikimedia.org/wikipedia/commons/7/7a/Action_potential_cs.png",
            prompt = """Jaký je normální elektrický potenciál na buněčné membráně neuronu?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""-30 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""110 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""-70 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""40 mV""",
                    false,
                    ""
                ),
            ),
            questionNumber = 38,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaká je rychlost motorické informace?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""10 km/h""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""1100 m/s""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""120 m/s""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""480 m/s""",
                    false,
                    ""
                ),
            ),
            questionNumber = -38,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://upload.wikimedia.org/wikipedia/commons/7/7a/Action_potential_cs.png",
            prompt = "Jaký je prahový elektrický potenciál na buněčné membráně neuronu?",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""-30 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""110 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""-70 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""-55 mV""",
                    false,
                    ""
                ),
            ),
            questionNumber = 938,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://www.flowee.cz/images/.thumbnails/images/nora/korea/corpuscallosumvelkymozektalamushypotalamusepifyzasisinkahypofyzamozecekmicha.840x540c.jpg",
            prompt = """Epifýza (šišinka) je součásti""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""středního mozku""",
                    false,
                    "Střední mozek - držení vzpřímené polohy těla" +
                        "\n\t-čtverohrbolí - zrakové a sluchové reflexy" +
                        "\n\t-substantia nigra - dopamin (Parkinson, Schizofrenie)"
                ),
                PsychologyTermAnswer("""hypotalamu""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
                PsychologyTermAnswer("""mozkového kmene""",
                    false,
                    "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                        "\nSkládá se z středního mozku, mostu a prodloužené míchy." +
                        "\nVšechny dráhy do a z mozku."
                ),
                PsychologyTermAnswer("""mezimozku""",
                    false,
                    "(diencephalon), skládá se z epithalamu, thalamu, metathalamu, subhtalamu a hypothalamu"
                ),
            ),
            questionNumber = 39,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://slideplayer.cz/slide/4117882/12/images/6/Retikul%C3%A1rn%C3%AD+formace.jpg",
            prompt = """Síťovitý útvar, procházející mozkovým kmenem a řídící důležité životní funkce, se označuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """retikulární formace""",
                    false,
                    "Retikulární formace prostupuje mozkovým kmenem, " +
                        "pokračuje do thalamu a hypothalamu, kaudálně navazuje na propriospinální míšní síť.\nFunkce: " +
                        "-senzitivní, motorická a autonomní funkce, složité reflexy\n" +
                        "- centrum řízení dýchání, kardiovaskulární soustavy, vazomotoriky, spánku, bdění"
                ),
                PsychologyTermAnswer("""nucleus olivaris""",
                    false,
                    "v prodloužené míše, identifikace lokace zvuku"
                ),
                PsychologyTermAnswer("""vitální kmenový subsystém""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""síťovité jádro""",
                    false,
                    ""
                ),
            ),
            questionNumber = 40,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Akční potenciál vzniká""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""na dendritech""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na synaptických zakončeních""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na rozmezí axonu a těla neuronu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v jádře neuronu""",
                    false,
                    ""
                ),
            ),
            questionNumber = 41,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaké barvivo obsahují tyčinky""",
            textAnswer = "Díky čípkům vidíme barvy",
            imageAnswerUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Schematic_diagram_of_the_human_eye_cs.svg/1200px-Schematic_diagram_of_the_human_eye_cs.png",
            answers = listOf(
                PsychologyTermAnswer("""optopsin""",
                    false,
                    "neexistuje"
                ),
                PsychologyTermAnswer("""rhodopsin""",
                    false,
                    "Skládá se z opsinu + retinalu"
                ),
                PsychologyTermAnswer("""skotopsin""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""opsin""",
                    false,
                    ""
                ),
            ),
            questionNumber = 42,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaké je uspořádání mozkových plen (od povrchu mozku k lebce)?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""omozečnice, pavučnice, tvrdá plena""",
                    false,
                    "Tvrdá plena (dura mater) - vnější obal, vystýlá dutinu lební" +
                        "\n\nPavučnice (arachnoidea) - vnější obal, nesleduje záhyby mozku, dutiny zaplněny mozkomišním mokem" +
                        "\n\nOmozečnice (pia mater) - vnitřní obal, blanitá plena, vniká do brázd"
                ),
                PsychologyTermAnswer("""tvrdá plena, pavučnice, omozečnice""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""tvrdá plena, omozečnice, pavučnice""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pavučnice, omozečnice, tvrdá plena""",
                    false,
                    ""
                ),
            ),
            questionNumber = 43,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavní korová motorická oblast je umístěna""",
            textAnswer = "",
            imageAnswerUrl = "https://cdn.myshoptet.com/usr/www.zentrichovaapatyka.cz/user/documents/upload/gallery/FOTO/T%C4%9Blo/Mozek.png",
            answers = listOf(
                PsychologyTermAnswer("""v postcentrálním závitu""",
                    false,
                    "postcentrální oblast – jdou zde somatosenzorické a chuťové informace, nachází se u centrálního zářezu"
                ),
                PsychologyTermAnswer("""v precentrálním závitu""",
                    false,
                    "předcentrální oblast – je před zářezem, motorická funkce (sbíhají se zde pyramidové dráhy)"
                ),
                PsychologyTermAnswer("""ve ventromediální kůře""",
                    false,
                    "v oblasti frontálního laloku, řízení emocí"
                ),
                PsychologyTermAnswer("""v temenní oblasti kůry""",
                    false,
                    ""
                ),
            ),
            questionNumber = 44,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavní korová oblast čichu je umístěna""",
            textAnswer = "",
            imageAnswerUrl = "https://cdn.myshoptet.com/usr/www.zentrichovaapatyka.cz/user/documents/upload/gallery/FOTO/T%C4%9Blo/Mozek.png",
            answers = listOf(
                PsychologyTermAnswer("""v postcentrálním závitu""",
                    false,
                    "postcentrální oblast – jdou zde somatosenzorické a chuťové informace, nachází se u centrálního zářezu"
                ),
                PsychologyTermAnswer("""v precentrálním závitu""",
                    false,
                    "předcentrální oblast – je před zářezem, motorická funkce (sbíhají se zde pyramidové dráhy)"
                ),
                PsychologyTermAnswer("""ve ventromediální kůře""",
                    false,
                    "v oblasti frontálního laloku, řízení emocí"
                ),
                PsychologyTermAnswer("""spodině čelních laloků""",
                    false,
                    ""
                ),
            ),
            questionNumber = 944,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavní korová oblast kožní citlivosti je umístěna""",
            textAnswer = "",
            imageAnswerUrl = "https://cdn.myshoptet.com/usr/www.zentrichovaapatyka.cz/user/documents/upload/gallery/FOTO/T%C4%9Blo/Mozek.png",
            answers = listOf(
                PsychologyTermAnswer("""v postcentrálním závitu""",
                    false,
                    "postcentrální oblast – jdou zde somatosenzorické a chuťové informace, nachází se u centrálního zářezu"
                ),
                PsychologyTermAnswer("""v precentrálním závitu""",
                    false,
                    "předcentrální oblast – je před zářezem, motorická funkce (sbíhají se zde pyramidové dráhy)"
                ),
                PsychologyTermAnswer("""ve ventromediální kůře""",
                    false,
                    "v oblasti frontálního laloku, řízení emocí"
                ),
                PsychologyTermAnswer("""temenním laloku""",
                    false,
                    "za ústřední brázdou"
                ),
            ),
            questionNumber = 844,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Krátkozrakost se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""presbyopie""",
                    false,
                    "přirozená degenerace materiálu oční čočky"
                ),
                PsychologyTermAnswer("""hypermetropie""",
                    false,
                    "dalekozrakost - úpravou očního bulbu se zlěpší (čočky, brýle)"
                ),
                PsychologyTermAnswer("""myopie""",
                    false,
                    "krátkozrakost"
                ),
                PsychologyTermAnswer("""astigmatismus""",
                    false,
                    "refrakční oční vada, neostré a rozmazané vidění ve všech vzdálenostech"
                ),
                PsychologyTermAnswer("""emetropie""",
                    false,
                    "zdravý stav oka"
                ),
            ),
            questionNumber = 45,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavní somatosenzorická oblast je umístěna""",
            textAnswer = "",
            imageAnswerUrl = "https://cdn.myshoptet.com/usr/www.zentrichovaapatyka.cz/user/documents/upload/gallery/FOTO/T%C4%9Blo/Mozek.png",
            answers = listOf(
                PsychologyTermAnswer("""v temenní oblasti kůry""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v postcentrálním závitu""",
                    false,
                    "postcentrální oblast – jdou zde somatosenzorické a chuťové informace, nachází se u centrálního zářezu"
                ),
                PsychologyTermAnswer("""v precentrálním závitu""",
                    false,
                    "předcentrální oblast – je před zářezem, motorická funkce (sbíhají se zde pyramidové dráhy)"
                ),
                PsychologyTermAnswer("""ve ventromediální kůře""",
                    false,
                    "v oblasti frontálního laloku, řízení emocí"
                ),
            ),
            questionNumber = 46,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Dalekozrakost se koriguje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""rozptylkami""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""úpravou očního bulbu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""žádnou z uvedených metod""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""spojkami""",
                    false,
                    ""
                ),
            ),
            questionNumber = 47,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Retrográdní amnézie je porucha""",
            textAnswer = "ztráta paměti před úrazem",
            answers = listOf(
                PsychologyTermAnswer(
                    """procedurální paměti, při níž dojde k časově omezené ztrátě schopnosti naučit se novým dovednostem""",
                    false,
                    "Implicitní (procedurální a emoční) - bez vědomí, třeba motorické pohyby, behaviorální paměť."
                ),
                PsychologyTermAnswer(
                    """paměti, při níž dojde k časově omezené ztrátě schopnosti zapamatovat si nové informace""",
                    false
                ),
                PsychologyTermAnswer(
                    """paměti, při níž dojde ke ztrátě vzpomínek na určitou dobu před úrazem či onemocněním""",
                    false
                ),
                PsychologyTermAnswer(
                    """myšlení, kdy se ztratí schopnost pořádat pojmy do kategorií""",
                    false
                ),
            ),
            questionNumber = 48,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Různé části limbického systému hrají nejspíše minimální úlohu""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v mechanismech dlouhodobé paměti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve vzniku emocí""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve zpracování zvukových informaci""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""při řízení komplexního chování""",
                    false,
                    ""
                ),
            ),
            questionNumber = 49,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = "Tzv. lobotomie (prefrontální leukotomie), " +
                "která se ve čtyřicátých a padesátých letech používala při pokusech o úpravu některých psychiatrických poruch, spočívá",
            textAnswer = "Skrze oko",
            answers = listOf(
                PsychologyTermAnswer(
                    """v odstranění kůry v některých oblastech limbického systému""",
                    false
                ),
                PsychologyTermAnswer(
                    """v přetětí vláken vedoucích k čelním oblastem mozkové kůry""",
                    false
                ),
                PsychologyTermAnswer("""v umrtvení některých talamických jader""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """v odstranění specifických součástí motorické kůry""",
                    false
                ),
            ),
            questionNumber = 50,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Lícní nerv je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""odbočka VI. hlavového nervu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""X. hlavový nerv""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""VII. hlavový nerv""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""odbočka odtahovacího nervu""",
                    false,
                    ""
                ),
            ),
            questionNumber = 51,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """X. hlavový nerv označujeme""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nerv jazykohltanový""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nerv vagotonní""",
                    false,
                    "na stranách krku"
                ),
                PsychologyTermAnswer("""nerv sympatický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nerv bloudivý""",
                    false,
                    ""
                ),
            ),
            questionNumber = 52,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Na zpracování zrakové informace se nepodílí""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""horní hrbolek čtverohrboli""",
                    false,
                        "Horní pár (colliculi superiores) - jen některé zrakové reflexy"
                ),
                PsychologyTermAnswer("""týlní mozková kůra""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""corpus geniculatum laterale""",
                    false,
                    "thalamus, klíčový bod pro optickou dráhu u savců"
                ),
                PsychologyTermAnswer("""inzulární kůra""",
                    false,
                    "je uprostřed mozku (uvnitř), integrační funkce (integruje senzorické a limbické funkce)"
                ),
            ),
            questionNumber = 53,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mozeček nasedá""",
            textAnswer = "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky",
            imageAnswerUrl = "https://eluc.ikap.cz/uploads/block_images/6529/Mozek00.jpg",
            answers = listOf(
                PsychologyTermAnswer("""na horní hrbolky čtverohrbolí""",
                    false,
                    "Horní pár (colliculi superiores) - jen některé zrakové reflexy"
                ),
                PsychologyTermAnswer("""na mozečkový červ""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na strop 3. mozkové komory""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na strop 4. mozkové komory""",
                    false,
                    "Komory jsou vždycky uprostřed, nejspodnější komora je 4., 3. je uprostřed, která je uzavřená thalamy, následně jsou postranní komory v obouch hemisférách"
                ),
            ),
            questionNumber = 54,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Cortiho orgán je umístěn""",
            textAnswer = "Percepce zvuku, podráždění -> proximální stimulus" +
                "\nVlasové buňky - převod mechanické energie zvukových vln na el. signál",
            imageAnswerUrl = "https://o.quizlet.com/vNJYYOsyqEaRkwNuzgC9xw.png",
            answers = listOf(
                PsychologyTermAnswer("""v čichové sliznici""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v hlemýždi""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v mediálním talamu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v polokruhovitých kanálcích""",
                    false,
                    ""
                ),
            ),
            questionNumber = 55,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jak se označují systémy autonomního nervstva?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sympatikus a presympatikus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sympatikus a synaptikus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""míšní, sympatický a parasympatický""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sympatikus a parasympatikus""",
                    false,
                    "sympatikus - fight and flight" +
                        "\nparasympatikus - uklidnění systému"
                ),
            ),
            questionNumber = 56,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Kladívko je připojeno""",
            textAnswer = "",
            imageAnswerUrl = "http://www.khshk.cz/e-learning/kurs2a/2_1_1.jpg",
            answers = listOf(
                PsychologyTermAnswer("""ke třmínku a kovadlince""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""k bubínku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""k výstupům polokruhovitých kanálků""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""k membráně oválného okénka Radi""",
                    false,
                    ""
                ),
            ),
            questionNumber = 57,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Míšní motoneurony nalezneme zejména v""",
            textAnswer = "neuron, který je součástí motorické nervové dráhy",
            answers = listOf(
                PsychologyTermAnswer("""zadních provazcích bílé hmoty míšní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předních provazcích bilé hmoty míšní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""předních rozích šedé hmoty míšní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""zadních rozích šedé hmoty míšní""",
                    false,
                    ""
                ),
            ),
            questionNumber = 58,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Z postranních sloupců hrudní a horní bederní míchy vystupuje""",
            textAnswer = "pohyb těla, pyramidový systém, dráhy",
            answers = listOf(
                PsychologyTermAnswer("""parasympatikus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""synaptikus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dostředivé míšní nervstvo""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sympatikus""",
                    false,
                    ""
                ),
            ),
            questionNumber = 59,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Kovadlinka je spojena""",
            textAnswer = "",
            imageAnswerUrl = "https://www.mycimply.com/content/useruploads/stavba%20ucha%20popis.png",
            answers = listOf(
                PsychologyTermAnswer("""s třímnkem a oválným okénkem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""s oválným okénkem a utrikulem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""s bubínkem a kladívkem""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""s kladívkem a třmínkem""",
                    false,
                    ""
                ),
            ),
            questionNumber = 60,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Hlavní motorickou drahou je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""mammilotalamická dráha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""extrapyramidová dráha""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pyramidová dráha""",
                    false,
                    "Vystupuje z postranních sloupců hrudní a horní bederní míchy, předcentrální oblast, precentrální závit"
                ),
                PsychologyTermAnswer("""mozečková dráha""",
                    false,
                    ""
                ),
            ),
            questionNumber = 61,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Který systém působí zvýšení srdeční frekvence?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""sympatikus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""převodní systém srdeční""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""parasympatikus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""synaptikus""",
                    false,
                    ""
                ),
            ),
            questionNumber = 62,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Povrch sítnice směřující dovnitř oční koule je pokryt""",
            textAnswer = "",
            imageAnswerUrl = "https://docplayer.cz/docs-images/59/43150889/images/10-0.png",
            answers = listOf(
                PsychologyTermAnswer("""horizontálními buňkami""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""tyčinkami a čípky""",
                    false,
                    "tyčinky citlivé na světlo a čípky citlivé na barvy"
                ),
                PsychologyTermAnswer("""žlutou skvrnou""",
                    false,
                    "Hodně čípků u sebe, dále od ní přibývá tyčinek"
                ),
                PsychologyTermAnswer("""nervovými vlákny""",
                    false,
                    ""
                ),
            ),
            questionNumber = 63,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaké je správné řazení uvedených stavebních částí oka (zvenčí dovnitř)?""",
            textAnswer = "",
            imageAnswerUrl = "https://wikisofia.cz/w/images/6/69/Rez_okem.jpg",
            answers = listOf(
                PsychologyTermAnswer("""čočka, duhovka, rohovka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rohovka, čočka, duhovka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""rohovka, duhovka, čočka""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""čočka, rohovka, duhovka""",
                    false,
                    ""
                ),
            ),
            questionNumber = 64,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Míšních nervů je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""31 párů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""35 párů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""33 párů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""37 párů""",
                    false,
                    ""
                ),
            ),
            questionNumber = 65,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mapa cytoarchitektonických oblastí mozkové kůry se nazývá""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Wernickova""",
                    false,
                    "centrum porozumnění řeči"
                ),
                PsychologyTermAnswer("""Brodmannova""",
                    false,
                    " rozdělil mozkovou kůru na 11 oblastí a 50 okrsků, funkčně a morfologicky se od sebe liší"
                ),
                PsychologyTermAnswer("""Brocova""",
                    false,
                    "centrum produkce řeči" +
                        "\nfascikulus arkulatus - svazek nervů spojující Brocovo a Werneckiovo centrum"
                ),
                PsychologyTermAnswer("""Cajalova""",
                    false,
                    "Nobelovka za strukturu Nervového Systému"
                ),
            ),
            questionNumber = 66,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Kolik je okohybných svalů (pro jedno oko)?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""12""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""8""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""6""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""4""",
                    false,
                    ""
                ),
            ),
            questionNumber = 67,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Kolik je v oku tyčinek?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""asi 130 milionů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asi 13 milionů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asi 1,3 milionu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""asi 130 000""",
                    false,
                    ""
                ),
            ),
            questionNumber = 68,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Které autonomní nervy vystupují z krční, hrudní a bederní míchy?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""nervy sympatiku i parasympatiku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nervy sympatiku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""žádné""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""nervy parasympatiku""",
                    false,
                    ""
                ),
            ),
            questionNumber = 69,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Přídavná motorická oblast se nachází""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v bazálních gangliich""",
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
                PsychologyTermAnswer("""v parietální kůře""",
                    false,
                    "parientální oblast – asociační funkce (asociace k tělesné citlivosti)"
                ),
                PsychologyTermAnswer("""v temporální kůře""",
                    false,
                    "(spánkový lalok) - centrum sluchu, hippocampus, řeč" +
                        "\nAmusie - neschopnost rozpoznávat zvuky"
                ),
                PsychologyTermAnswer("""ve frontální kůře""",
                    false,
                    "čelní lalok - motorická oblast, centrum kontroly, na spodní části se přepojují čichové dráhy"
                ),
            ),
            questionNumber = 70,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Schwannovy buňky""",
            textAnswer = "PNS, vždy jen 1 myelin vrstvu",
            answers = listOf(
                PsychologyTermAnswer(
                    """vytváření myelinovou pochvu v periferním nervstvu""",
                    false
                ),
                PsychologyTermAnswer(
                    """vychytávají přebytečné mediátory v synapsích""",
                    false,
                    "astrocyty"
                ),
                PsychologyTermAnswer(
                    """vytváření myelinovou pochvu u spojů v CNS""",
                    false,
                    "oligodendrocyty"
                ),
                PsychologyTermAnswer(
                    """fagocytují myelinové obaly při demyelinizačních onemocněních""",
                    false
                ),
            ),
            questionNumber = 71,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Čípků je v oku v porovnání s tyčinkami přibližně""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""čtvrtina""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""osmina""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dvacetina""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""čtyřicetina""",
                    false,
                    ""
                ),
            ),
            questionNumber = 72,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Spolu s hlavovými nervy vystupují do těla""",
            textAnswer = "I. čichový nerv (koncový mozek)" +
                "\nII. zrakový nerv (mezimozek)" +
                "\nIII. okohybný nerv (střední mozek)" +
                "\nIV. kladkový nerv (střední mozek) - horní šikmý oční sval" +
                "\nV. trojklanný nerv (varolův most) - obličej" +
                "\nVI. odtahovací nerv (varolův most) - zevní přímý oční sval" +
                "\nVII. lícní nerv (varolův most) - mimika" +
                "\nVIII. sluchově rovnovážný nerv - zvuk, rovnováha" +
                "\nIX. jazykohltanový (prodloužená mícha) - slznice hltanu, zadní 1/3 jazyka" +
                "\nX. bloudivý nerv - krk, hruď" +
                "\nXI přídatný nerv - hltan, hrtan" +
                "\nXII. podjazykový nerv - svaly jazyka",
            answers = listOf(
                PsychologyTermAnswer("""všechny nervy sympatiku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""některé nervy parasympatiku""",
                    false,
                    "III., VII., IX., a X. jsou parasympatik"
                ),
                PsychologyTermAnswer("""všechny nervy parasympatiku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""některé nervy sympatiku""",
                    false,
                    ""
                ),
            ),
            questionNumber = 73,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Magno a parvo-systém jsou součástí""",
            textAnswer = "Parvo systém (jako barvo) rozlišuje tvary a barvy" +
                "\nMagno systém rozlišuje pohyby a prostor",
            answers = listOf(
                PsychologyTermAnswer("""zrakového systému""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sluchového systému""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""somatosenzorického systému""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""limbického systému""",
                    false,
                    ""
                ),
            ),
            questionNumber = 74,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Vedení vzruchu skokem od jednoho přerušení myelinového obalu k dalšímu se označuje jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""přebíhavé""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""diskrétní""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""salivatorni""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""saltatorní""",
                    false,
                    ""
                ),
            ),
            questionNumber = 75,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Vnitřní ucho je uloženo v/ve""",
            imageAnswerUrl = "https://www.symptomy.cz/anatomie/ucho/anatomie-lidskeho-ucha.jpg",
            answers = listOf(
                PsychologyTermAnswer("""temenní kosti""",
                    false,
                    "střední ucho"
                ),
                PsychologyTermAnswer("""spánkové kosti""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""skalní kosti""",
                    false,
                    "vnitřní ucho"
                ),
                PsychologyTermAnswer("""lícní kosti""",
                    false,
                    ""
                ),
            ),
            questionNumber = 76,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mediátorem parasympatických nervových zakončení je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""acetylcholin""",
                    false,
                    "nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""serotonin""",
                    false,
                    "prožívání, spánek, chuť, deprese, nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""noradrenalin""",
                    false,
                    "aktivace, spánek, probuzení, sympatický NS"
                ),
                PsychologyTermAnswer("""dopamin""",
                    false,
                    "limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)"
                ),
            ),
            questionNumber = 77,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mediátorem sympatických nervových zakončení je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""acetylcholin""",
                    false,
                    "nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""serotonin""",
                    false,
                    "prožívání, spánek, chuť, deprese, nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""noradrenalin""",
                    false,
                    "aktivace, spánek, probuzení, sympatický NS"
                ),
                PsychologyTermAnswer("""dopamin""",
                    false,
                    "limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)"
                ),
            ),
            questionNumber = -77,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Centrum hladu se nachází v""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""talamu""",
                    false,
                    "Thalamus - operátor mozku - informace z PNS do CNS, senzorické, motorické dráhy, bolest"
                ),
                PsychologyTermAnswer("""parietální kůře""",
                    false,
                    "parientální oblast – asociační funkce (asociace k tělesné citlivosti)"
                ),
                PsychologyTermAnswer("""hypotalamu""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
                PsychologyTermAnswer("""mozkovém kmeni""",
                    false,
                    "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                        "\nSkládá se z středního mozku, mostu a prodloužené míchy." +
                        "\nVšechny dráhy do a z mozku."
                ),
            ),
            questionNumber = 78,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Ranvierovy zářezy jsou""",
            textAnswer = "",
            imageAnswerUrl = "https://www.mentem.cz/static-155/uploads/blog/illustrations/neuron.png",
            answers = listOf(
                PsychologyTermAnswer(
                    """prohlubně oddělující presynaptickou a postsynaptickou část synapse""",
                    false
                ),
                PsychologyTermAnswer("""místa přerušení myelinové pochvy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""místa, kde dendrity nasedají na neuron""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """zářezy ohraničující synapsi od přívodního vlákna""",
                    false
                ),
            ),
            questionNumber = 79,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Dutiny kostěného hlemýždě jsou vyplněny tekutinou, v níž se vznáší blanitý hlemýžď'. Tekutinu označujeme""",
            textAnswer = "",
            imageAnswerUrl = "https://i.pinimg.com/originals/8f/32/b6/8f32b64c683fa5a37bd65bbb2a8bfd72.png",
            answers = listOf(
                PsychologyTermAnswer("""perilymfa""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""endolymfa""",
                    false,
                    "v membránových blanách"
                ),
                PsychologyTermAnswer("""převodní mok""",
                    false
                ),
                PsychologyTermAnswer("""akustický likvor""",
                    false,
                    ""
                ),
            ),
            questionNumber = 80,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mediátorem sympatických nervových zakončení je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""acetylcholin""",
                    false,
                    "nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""kyselina gamaaminomáselný""",
                    false,
                    "GABA (inhibiční) - alkohol, anxiotika"
                ),
                PsychologyTermAnswer("""serotonin a dopamin""",
                    false,
                    "seratonin - prožívání, spánek, chuť, deprese, nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
                PsychologyTermAnswer("""noradrenalin a adrenalin""",
                    false,
                    "aktivace, spánek, probuzení, sympatický NS"
                ),
            ),
            questionNumber = 81,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Oligodendroglie""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """odděluje cytoarchitektonické oblasti mozkové kůry""",
                    false
                ),
                PsychologyTermAnswer("""chrání synapse v CNS""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""vytváří myelinové pochvy v CNS""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """vytváří povrchovou membránu pod měkkou plenou mozkovou""",
                    false
                ),
            ),
            questionNumber = 82,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Oligodendroglie""",
            textAnswer = "Gliové buňky (neuroglie):" +
                "\nCentrální:" +
                "\n\t1) Makroglie: " +
                "\n\t\tAstrocyty - regenerace a výživa" +
                "\n\t\tOligodendroglie - tvoří myelin" +
                "\n\t2) Mikroglie - čistí, hojí" +
                "\nPeriferní:" +
                "\n\tSchwannovy buňky - stejně jako Oligodendroglie, ale jen jedno vlákno" +
                "\n\tSatelitové buňky - obalují neurony v gangliích" +
                "\n\tHlasové a míšní nervy",
            answers = listOf(
                PsychologyTermAnswer(
                    """odděluje cytoarchitektonické oblasti mozkové kůry""",
                    false
                ),
                PsychologyTermAnswer("""chrání synapse v CNS""",
                    false,
                    "astrocyty, výživa a izolace"
                ),
                PsychologyTermAnswer("""vytváří myelinové pochvy v CNS""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """vytváří povrchovou membránu pod měkkou plenou mozkovou""",
                    false,
                    "arachnoidální buňky"
                ),
            ),
            questionNumber = 82,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaká je funkce mikroglií?""",
            textAnswer = "Gliové buňky (neuroglie):" +
                "\nCentrální:" +
                "\n\t1) Makroglie: " +
                "\n\t\tAstrocyty - regenerace a výživa" +
                "\n\t\tOligodendroglie - tvoří myelin v CNS" +
                "\n\t2) Mikroglie - čistí, hojí" +
                "\nPeriferní:" +
                "\n\tSchwannovy buňky - stejně jako Oligodendroglie, ale jen jedno vlákno" +
                "\n\tSatelitové buňky - obalují neurony v gangliích" +
                "\n\tHlasové a míšní nervy",
            answers = listOf(
                PsychologyTermAnswer(
                    "čistění a hojení",
                    false
                ),
                PsychologyTermAnswer("""chrání synapse v CNS""",
                    false,
                    "astrocyty, výživa a izolace"
                ),
                PsychologyTermAnswer("""vytváří myelinové pochvy v CNS""",
                    false,
                    "Oligodendroglie"
                ),
                PsychologyTermAnswer(
                    """vytváření myelinovou pochvu v periferním nervstvu""",
                    false,
                    "Schwannovy buňky"
                ),
            ),
            questionNumber = 282,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Jaká je funkce satelitových buněk (amficyty)?""",
            textAnswer = "Gliové buňky (neuroglie):" +
                "\nCentrální:" +
                "\n\t1) Makroglie: " +
                "\n\t\tAstrocyty - regenerace a výživa" +
                "\n\t\tOligodendroglie - tvoří myelin v CNS" +
                "\n\t2) Mikroglie - čistí, hojí" +
                "\nPeriferní:" +
                "\n\tSchwannovy buňky - stejně jako Oligodendroglie, ale jen jedno vlákno" +
                "\n\tSatelitové buňky - obalují neurony v gangliích" +
                "\n\tHlasové a míšní nervy",
            answers = listOf(
                PsychologyTermAnswer(
                    "obalují neurony v gangliích",
                    false
                ),
                PsychologyTermAnswer("""chrání synapse v CNS""",
                    false,
                    "astrocyty, výživa a izolace"
                ),
                PsychologyTermAnswer("""regenerace a výživa v CNS""",
                    false,
                    "Astrocyty"
                ),
                PsychologyTermAnswer(
                    """vytváření myelinovou pochvu v periferním nervstvu""",
                    false,
                    "Schwannovy buňky"
                ),
            ),
            questionNumber = 782,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Statické čidlo je umístěno""",
            textAnswer = "Receptor zaznamenávající polohu",
            imageAnswerUrl = "https://metabolimed.cz/wp-content/uploads/2017/04/ucho-1.png",
            answers = listOf(
                PsychologyTermAnswer("""v kulatém a vejčitém váčku""",
                    false,
                    "vestibulární orgán, uvnitř labyrintu ve skální kosti lebky"
                ),
                PsychologyTermAnswer("""v pouze ve vejčitém váčku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v polokruhovitých kanálcích""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve vodorovném polokruhovitém kanálku""",
                    false,
                    ""
                ),
            ),
            questionNumber = 83,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Při vzniku akčního potenciálu se výrazně zvyšuje propustnost buněčné membrány pro""",
            textAnswer = "Sodikové ionty jdou dovnitř a draslíkové ionty jdou ven." +
                "\nPři hyperpolarizaci (po vyslání signálu) se vyměňují 3 sodíkové ionty za 2 draslíkové, čímž se navrátí až do nižších hodnot než je -70 mV.",
            imageAnswerUrl = "https://opentextbc.ca/biology/wp-content/uploads/sites/96/2015/03/Figure_35_02_02.jpg",
            answers = listOf(
                PsychologyTermAnswer("""draslíkové ionty""",
                    false,
                    "K+"
                ),
                PsychologyTermAnswer("""chloridové ionty""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""sodíkové ionty""",
                    false,
                    "Na+"
                ),
                PsychologyTermAnswer("""kyslíkové ionty""",
                    false,
                    ""
                ),
            ),
            questionNumber = 84,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Kinetické čidlo je umístěno""",
            textAnswer = "detekce pohybu, změny rychlosti",
            imageAnswerUrl = "https://metabolimed.cz/wp-content/uploads/2017/04/ucho-1.png",
            answers = listOf(
                PsychologyTermAnswer("""ve svislých polokruhovitých kanálcích""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""pouze v kulatém váčku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v kulatém a vejčitém váčku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v polokruhovitých kanálcích""",
                    false,
                    "3 na sebe vzájemně kolmé"
                ),
            ),
            questionNumber = 85,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Podstatou akčního potenciálu je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""depolarizace membrány""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""subpolarizace membrány""",
                    false,
                    "Blížíme se k akčnímu potenciálu, ale ještě ne"
                ),
                PsychologyTermAnswer("""hyperpolarizace membrány""",
                    false,
                    "Pod (více v mínusu) hladinou klidové potenciálu"
                ),
                PsychologyTermAnswer("""repolarizace membrány""",
                    false,
                    "návrat do mínusu po akčním potenciálu"
                ),
            ),
            questionNumber = 86,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Receptorem ve statickém čidlu jsou""",
            textAnswer = "\n\t-Fotoreceptory - světlo, tyčinky a čípky" +
                "\n\t-Mechanoreceptory - tlak, vibrace, dotyk, sluch" +
                "\n\t-Termoreceptory - teplota" +
                "\n\t-Chemoreceptory - chemikalie, hladina kyslíku, chuť a čich" +
                "\n\t-Nociceptory - poskozeni tkaniny -> bolest," +
                "\n\t-Baroreceptory - tlak krve" +
                "\n\tElektromagnetické receptory",
            answers = listOf(
                PsychologyTermAnswer("""krystalky vápenatých solí""",
                    false,
                    "krystalky slouží k dráždění vláskových buněk"
                ),
                PsychologyTermAnswer("""Meissnerova tělíska""",
                    false,
                    "mechoreceptor, hmat na prstech a rtech"
                ),
                PsychologyTermAnswer("""vláskové buňky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Ruffiniho tělíska""",
                    false,
                    "termoreceptor"
                ),
            ),
            questionNumber = 87,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Vlákna pyramidové dráhy se kříží""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v mozečku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na rozhraní prodloužené a páteřní míchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na rozhraní mostu a prodloužené míchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""ve středním mozku""",
                    false,
                    ""
                ),
            ),
            questionNumber = 88,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Ve které části je jazyk nejcitlivější na hořkou chut"?""",
            textAnswer = "chemoreceptory",
            answers = listOf(
                PsychologyTermAnswer("""v zadní části""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""na špičce""",
                    false,
                    "sladké a slané"
                ),
                PsychologyTermAnswer("""uprostřed""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""po stranách""",
                    false,
                    "kyselé a sladké"
                ),
            ),
            questionNumber = 89,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mozkové hemisféry, talamus a hypotalamus se celkově označují jako""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""mezencefalon""",
                    false,
                    "střední mozek"
                ),
                PsychologyTermAnswer("""telencefanon""",
                    false,
                    "nejvnovější a nejvíce vyvinutá část lids. mozku"
                ),
                PsychologyTermAnswer("""rhomboencefalon""",
                    false,
                    "zadní mozek - Varolův most, mozeček, prodloužená mícha"
                ),
                PsychologyTermAnswer("""mozkový kmen""",
                    false,
                    "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                        "\nSkládá se z středního mozku, mostu a prodloužené míchy." +
                        "\nVšechny dráhy do a z mozku."
                ),
            ),
            questionNumber = 90,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Špička jazyka je nejcitlivější na""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""hořkou chut""",
                    false,
                    "kořen, zadní část jazyka"
                ),
                PsychologyTermAnswer("""kyselou chuť""",
                    false,
                    "po stranách jazyka"
                ),
                PsychologyTermAnswer("""sladkou chuť""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""slanou chuť""",
                    false,
                    ""
                ),
            ),
            questionNumber = 91,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Šedá hmota míšní je umístěna""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""na povrchu míchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""uvnitř míchy""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """v kraniální části na povrchu míchy, v kaudální uvnitř míchy""",
                    false,
                    "kaudální - dole, kraniální nahoře"
                ),
                PsychologyTermAnswer(
                    """v kaudální části uvnitř míchy, v kraniální části na povrchu""",
                    false,
                    "kaudální - dole, kraniální nahoře"
                ),
            ),
            questionNumber = 92,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Kolik je hlavových nervů?""",
            textAnswer = "I. čichový nerv (koncový mozek)" +
                "\nII. zrakový nerv (mezimozek)" +
                "\nIII. okohybný nerv (střední mozek)" +
                "\nIV. kladkový nerv (střední mozek) - horní šikmý oční sval" +
                "\nV. trojklanný nerv (varolův most) - obličej" +
                "\nVI. odtahovací nerv (varolův most) - zevní přímý oční sval" +
                "\nVII. lícní nerv (varolův most) - mimika" +
                "\nVIII. sluchově rovnovážný nerv - zvuk, rovnováha" +
                "\nIX. jazykohltanový (prodloužená mícha) - slznice hltanu, zadní 1/3 jazyka" +
                "\nX. bloudivý nerv - krk, hruď" +
                "\nXI přídatný nerv - hltan, hrtan" +
                "\nXII. podjazykový nerv - svaly jazyka",
            answers = listOf(
                PsychologyTermAnswer("""7""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""17""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""10""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""12""",
                    false,
                    ""
                ),
            ),
            questionNumber = 93,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Mezi mediátory nepatří""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""dopamin""",
                    false,
                    "limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)"
                ),
                PsychologyTermAnswer("""noradrenalin""",
                    false,
                    "aktivace, spánek, probuzení, sympatický NS"
                ),
                PsychologyTermAnswer("""vazopresin""",
                    false,
                    "ADH, hormon"
                ),
                PsychologyTermAnswer("""serotonin""",
                    false,
                    "prožívání, spánek, chuť, deprese, nové paměťové spoje, Alzheimer, parasympatický NS"
                ),
            ),
            questionNumber = 94,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Která struktura má zásadní význam pro dlouhodobou paměť?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""hippocampus""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""okcipitální kůra""",
                    false,
                    "(tylní lalok) - centrum zraku" +
                        "\nPseudohalucinace - třeba u LSD, kdy vidímě věci, které tam nejsou, ale víme o tom." +
                        "\nProsopagnózie - neschopnost rozpoznávat obličeje"
                ),
                PsychologyTermAnswer("""hypotalamus""",
                    false,
                    "Nejvyšší řídící centrum vnitřních orgánů - regulace teploty, hladu a žízně" +
                        "\nPřipájí se k němu hypofýza (produkce hormonů)"
                ),
                PsychologyTermAnswer(
                    """retikulární formace""",
                    false,
                    "Retikulární formace prostupuje mozkovým kmenem, " +
                        "pokračuje do thalamu a hypothalamu, kaudálně navazuje na propriospinální míšní síť.\nFunkce: " +
                        "-senzitivní, motorická a autonomní funkce, složité reflexy\n" +
                        "- centrum řízení dýchání, kardiovaskulární soustavy, vazomotoriky, spánku, bdění"
                ),
            ),
            questionNumber = 95,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            imageAnswerUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1Iur-k04n3LlfcwM9Tj6K0Wg3zEWS22JSWQ&usqp=CAU",
            prompt = """Motorická afázie je spojena především s poškozením""",
            textAnswer = "Především porucha produkce řeči. Afázie - ztráta či porucha řeči",
            answers = listOf(
                PsychologyTermAnswer("""Wernickova centra""",
                    false,
                    "Sluchová"
                ),
                PsychologyTermAnswer("""prefrontální ventromediální kůry""",
                    false,
                    "v oblasti frontálního laloku, řízení emocí"
                ),
                PsychologyTermAnswer("""Brocova centra""",
                    false,
                    "Motorická, somatická"
                ),
                PsychologyTermAnswer("""Heschlových závitů""",
                    false,
                    "temporální (spánkový) lalok - sluch, hippocampus"
                ),
            ),
            questionNumber = 96,
            correctAnswer = 2,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Myelinová pochva obaluje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""jen dendrity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""gliové buňky""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""jen axony""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""některé axony i dentrity""",
                    false,
                    ""
                ),
            ),
            questionNumber = 97,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Obraz z pravé poloviny zorného pole se zpracovává""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""v levé hemisféře""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """obraz z pravého oka v pravé hemisféře, obraz z levého oka v levé hemisféře""",
                    false
                ),
                PsychologyTermAnswer("""v pravé hemisféře""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """obraz z levého oka v pravé hemisféře, obraz z pravého oka v levé hemisféře""",
                    false
                ),
            ),
            questionNumber = 98,
            correctAnswer = 0,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Nervová buňka má zpravidla""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""více axonů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""jeden axon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""více axonů než dendritů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dva axony""",
                    false,
                    ""
                ),
            ),
            questionNumber = 99,
            correctAnswer = 1,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Synaptické váčky najdeme""",
            textAnswer = "Vezikula",
            imageAnswerUrl = "https://slideplayer.cz/slide/5617663/2/images/13/S-9+mikrotubuly+neurofilamenta+presynaptick%C3%A9+zakon%C4%8Den%C3%AD+synaptick%C3%A9.jpg",
            answers = listOf(
                PsychologyTermAnswer("""v synaptické štěrbině""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v pre- i postsynaptické částí synapse""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v postsynaptické části synapse""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""v presynaptické části synapse""",
                    false,
                    ""
                ),
            ),
            questionNumber = 100,
            correctAnswer = 3,
            categoryId = "9. Nervová soustava"
        ),
        PsychologyTerm(
            prompt = """Kterou funkci sdílejí hipokampus a amygdala?""",
            textAnswer = "Obě jsou součástí limbického systému",
            answers = listOf(
                PsychologyTermAnswer("""motorické dovednosti""",
                    false,
                    "precentrální gyrus mozkové kůry, bazální ganglia, mozeček"
                ),
                PsychologyTermAnswer(
                    """plánování a rozhodování""",
                    false,
                    "frontal cortex"
                ),
                PsychologyTermAnswer(
                    """divergentní myšlení""",
                    false,
                    "Divergentní myšlení je sbíhavý vznik nových řešení na problém (ADHD)."
                ),
                PsychologyTermAnswer("""paměť""",
                    false,
                    ""
                ),
            ),
            questionNumber = 1,
            correctAnswer = 3,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Která část neuronu předává informace dalším neuronům?""",
            textAnswer = "",
            imageAnswerUrl = "https://www.mentem.cz/static-155/uploads/blog/illustrations/neuron.png",
            answers = listOf(
                PsychologyTermAnswer("""tělo neuronu""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""axon""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dendrity""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """jádro neuronu""",
                    false,
                    "uchovává informace"
                ),
            ),
            questionNumber = 2,
            correctAnswer = 2,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Která část mozku hraje u většiny lidí největší roli v situaci, kdy si čtou otázku a snaží se ji zodpovědět?""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""pravá hemisféra""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""levá hemisféra""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """mozeček""",
                    false,
                    "Mozeček - (Cerebellum) - Rovnováha, koordinace pohybů, jemná motorika, učení motorických dovedností, 2 hemisféry, Purkyňovy buňky"
                ),
                PsychologyTermAnswer("""mozkový kmen""",
                    false,
                    "Životně důležité tělesné funkce. Reptilní část mozku, takže většina nejjednodušších věcí jako srdeční činnost a dech." +
                        "\nSkládá se z středního mozku, mostu a prodloužené míchy." +
                        "\nVšechny dráhy do a z mozku."
                ),
            ),
            questionNumber = 3,
            correctAnswer = 1,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Centra pro řízení dechu a oběhu jsou v(e)""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""středním mozku""",
                    false,
                    "Střední mozek - držení vzpřímené polohy těla" +
                        "\n\t-čtverohrbolí - zrakové (horní pár) a sluchové (dolní pár) reflexy" +
                        "\n\t-substantia nigra - dopamin (Parkinson, Schizofrenie)"
                ),
                PsychologyTermAnswer("""prodloužené míše""",
                    false,
                    "(Medulla Obllongata) - reflexy (kašel, sací, polykací, zvracivý), křížení eferentní a aferentní."
                ),
                PsychologyTermAnswer("""čelním laloku""",
                    false,
                    ""
                ),
                PsychologyTermAnswer(
                    """corpus callosum""",
                    false,
                "spojnice mezi levou a pravou hemisférou"
                ),
            ),
            questionNumber = 4,
            correctAnswer = 1,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Hodnota klidového membránového potenciálu se pohybuje v rozmezí""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""-70 až -90 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""-20 až 0 mV""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""20 až 40 mV""",
                    false,
                    ""
                ),
            ),
            questionNumber = 5,
            correctAnswer = 0,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Hemisféry mozku spojuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer(
                    """retikulární formace""",
                    false,
                    "Retikulární formace prostupuje mozkovým kmenem, " +
                        "pokračuje do thalamu a hypothalamu, kaudálně navazuje na propriospinální míšní síť.\nFunkce: " +
                        "-senzitivní, motorická a autonomní funkce, složité reflexy\n" +
                        "- centrum řízení dýchání, kardiovaskulární soustavy, vazomotoriky, spánku, bdění"
                ),
                PsychologyTermAnswer("""Corpus callosum""",
                    false,
                    "R. Sperry - rozštěpení levé a pravé hemisféry, hemisféry fungují nezávisle na sobě, inverze končetin (levé okolo, pravá část hemisféry)"
                ),
                PsychologyTermAnswer("""Varolův most""", false,
                    "Varolův most (pons varoli) - spojuje mozeček, střední mozek a prodlouženou míchu, regulace dýchání, slzných a slinných žláz"
                ),
            ),
            questionNumber = 6,
            correctAnswer = 1,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Z celkového minutového objemu krve dostává mozek zhruba""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""2%""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""10%""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""20%""",
                    false,
                    ""
                ),
            ),
            questionNumber = 7,
            correctAnswer = 2,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Choroba spojená s třesem rukou a ztrátou kontroly nad volnými pohyby se jmenuje""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""Alzheimerova""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""Bechtěrevova""",
                    false,
                    "Zánětlivé onemocnění, hlavně páteřních obratlů (antigen HLA-B27)"
                ),
                PsychologyTermAnswer("""Parkinsonova""",
                    false,
                    ""
                ),
            ),
            questionNumber = 8,
            correctAnswer = 2,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Míšních nervů je""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""12 párů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""31 párů""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""33 párů""",
                    false,
                    ""
                ),
            ),
            questionNumber = 9,
            correctAnswer = 1,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Za centrum emocí můžeme v mozku považovat""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""frontální laloky""",
                    false,
                    "čelní lalok - motorická oblast, centrum kontroly, na spodní části se přepojují čichové dráhy"
                ),
                PsychologyTermAnswer("""hypofýzu""",
                    false,
                    "produkce hormonů, připojené na hypothalamu"
                ),
                PsychologyTermAnswer("""limbický systém""",
                    false,
                    ""
                ),
            ),
            questionNumber = 10,
            correctAnswer = 2,
            categoryId = "Přednáška FF UK"
        ),
        PsychologyTerm(
            prompt = """Hlavní excitačním neurotransmiterem""",
            textAnswer = "",
            answers = listOf(
                PsychologyTermAnswer("""GABA""",
                    false,
                    "(inhibiční, kyselina gamaaminomáselný) - alkohol, anxiotika"
                ),
                PsychologyTermAnswer("""glutamát""",
                    false,
                    ""
                ),
                PsychologyTermAnswer("""dopamin""",
                    false,
                    "limbický systém, centrum odměn, Schizofrenie (moc) a Parkinson (málo)"
                ),
            ),
            questionNumber = 11,
            correctAnswer = 1,
            categoryId = "Přednáška FF UK"
        ),
    )
}