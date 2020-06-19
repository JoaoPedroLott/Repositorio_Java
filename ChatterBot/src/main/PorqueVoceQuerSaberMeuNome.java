package main;

import java.io.*;
import java.util.*;

public class PorqueVoceQuerSaberMeuNome {

    final static int maxInput = 1;
    final static int maxResp = 1;
    final static String delim = "?!.;";

    static String[][] KnowledgeBase = {
        {"QUAL SEU NOME",
            "POR QUE VOCE QUER SABER MEU NOME."
        },
        {"OI",
            "OLA!"
        },
        {"COMO VOCE ESTA",
            "PORQUE VOCE QUER SABER SE ESTOU BEM"},
        {"QUEM E VOCE",
            "SOU ALGUEM"
        },
        {"VOCE E INTELIGENTE",
            "NA VERDADE, SOU MAIS INTELIGENTE QUE VOCE!"
        },
        {"VOCE E REAL",
            "SOU TEO REAL QUANTO PODERIA SER."
        },
        {"VOCE E UM TROLL",
            "SOU TROLL."
        },
        {"O QUE VOCE FAZ",
            "POSSO FALAR DE ALGUNS FILMES PARA VOC�!"
        },
        {"QUAIS FILMES VOCE CONHECE",
            "EU CONHE�O STAR WARS, HARRY POTTER, SENHOR DOS AN�IS, PROCURANDO DORY E PROCURANDO NEMO. "
        },
        //-------------------Star Wars
        {"QUAL O JEDI MAIS FODA DOS FILMES STAR WARS",
            "PEQUENO, S�BIO E VERDE ELE �. MESTRE YODA."
        },
        {"QUAL O PERSONAGEM MAIS ICONICO DOS FILMES STAR WARS",
            "DARTH VADER. ELE � UM DOS PERSONAGENS MAIS IC�NICOS J� CRIADOS."
        },
        {"UMA CURIOSIDADE SOBRE STAR WARS",
            "SAMUEL L. JACKSON S� ACEITOU FAZER O FILME SE PUDESSE USAR UM SABRE DE LUZ ROXO EM SEU \nPERSONAGEM MACE WINDU, PARA QUE SE DESTACASSE NO MEIO DOS OUTROS JEDI."
        },
        {"QUEM E DARTH VADER",
            "DARTH VADER, NASCIDO ANAKIN SKYWALKER, � O PROTAGONISTA DA TRILOGIA PREQUELA E ANTAGONISTA \nDA TRILOGIA ORIGINAL DA S�RIE DE FILMES STAR WARS, TENDO PARTICIPADO DE SEIS EPIS�DIOS E TAMB�M EM ROGUE ONE. SUAS PRINCIPAIS CARACTER�STICAS \nS�O A ARMADURA NEGRA E A  RUIDOSA RESPIRA��O MEC NICA."
        },
        {"QUAL ANO FOI LAN�ADO O PRIMEIRO FILME DE STAR WARS",
            "O PRIMEIRO FILME DA S�RIE FOI LAN�ADO EM 25 DE MAIO DE 1977."
        },
        {"QUAL A ORDEM DOS FILMES DE STAR WARS",
            "OS FILMES FORAM LAN�ADOS NA ORDEM IV, V, VI, I, II, III, VII, ROGUE ONE. POR�M A ORDEM MAIS RECOMENDADA PARA \nASSISTIR OS FILMES � I, II, III, ANTOLOGIA DE HAN SOLO (VAI SER LAN�ADO), ROGUE ONE, IV, V, VI, VII E ENT�O OS PR�XIMOS EPIS�DIOS A SEREM LAN�ADOS, OS EPIS�DIOS VIII E IX."
        },
        {"QUAL O DROID FAVORITO DA SERIE STAR WARS",
            "O FAMOSO R2-D2, MAS AGORA COMPETE COM O NOVO QUERIDINHO. O BB8."
        },
        {"SINOPSE EPISODIO 1",
            "OBI-WAN E SEU MENTOR EMBARCAM EM UMA PERIGOSA AVENTURA NA TENTATIVA DE SALVAR O PLANETA DAS GARRAS DE DARTH SIDIOUS. \nDURANTE A VIAGEM, ELES CONHECEM UM HABILIDOSO MENINO E DECIDEM TREIN�-LO PARA SE TORNAR UM JEDI. MAS O TEMPO IR� REVELAR QUE AS COISAS \nNEM SEMPRE S�O O QUE APARENTAM SER."
        },
        {"SINOPSE EPISODIO 2",
            "TENTADO POR PROMESSAS DE PODER, ANAKIN SKYWALKER SE APROXIMA DE DARTH SIDIOUS E PARTICIPA DE UM PLANO PARA ACABAR COM OS CAVALEIROS JEDI."
        },
        {"SINOPSE EPISODIO 3",
            "AS GUERRAS CL�NICAS EST�O EM PLENO ANDAMENTO E ANAKIN SKYWALKER MANT�M UM ELO DE LEALDADE COM PALPATINE, AO \nMESMO TEMPO EM QUE LUTA PARA QUE SEU CASAMENTO COM PADM� AMIDALA N�O SEJA AFETADO POR ESTA SITUA��O. SEDUZIDO POR \nPROMESSAS DE PODER, ANAKIN SE APROXIMA CADA VEZ MAIS DE DARTH SIDIOUS AT� SE TORNAR O TEM�VEL DARTH VADER. JUNTOS ELES TRAMAM UM PLANO PARA ANIQUILAR DE \nUMA VEZ POR TODAS COM OS CAVALEIROS JEDI."
        },
        {"SINOPSE EPISODIO 4",
            "A PRINCESA LEIA � MANTIDA REF�M PELAS FOR�AS IMPERIAIS COMANDADAS POR DARTH VADER. LUKE SKYWALKER E O CAPIT�O \nHAN SOLO PRECISAM LIBERT�-LA E RESTAURAR A LIBERDADE E A JUSTI�A NA GAL�XIA."
        },
        {"SINOPSE EPISODIO 5",
            "YODA TREINA LUKE SKYWALKER PARA SER UM CAVALEIRO JEDI. HAN SOLO CORTEJA A PRINCESA LEIA ENQUANTO DARTH VADER RETORNA \nPARA COMBATER AS FOR�AS REBELDES QUE TENTAM SALVAR A GAL�XIA."
        },
        {"SINOPSE EPISODIO 6",
            "UMA NOVA ESTRELA DA MORTE EST� SENDO CONSTRU�DA E SUPERVISIONADA PELO IMPERADOR. HAN SOLO E A PRINCESA LEIA S�O LIBERTADOS \nDAS M�OS DE JABBA POR LUKE SKYWALKER, QUE S� SE TORNAR� UM JEDI QUANDO DESTRUIR DARTH VADER, QUE \nDESEJA ATRA�-LO PARA O LADO SOMBRIO DA FOR�A."
        },
        {"SINOPSE EPISODIO 7",
            "A QUEDA DE DARTH VADER E DO IMP�RIO LEVOU AO SURGIMENTO DE UMA NOVA FOR�A SOMBRIA: A PRIMEIRA ORDEM. ELES PROCURAM O \nJEDI LUKE SKYWALKER, DESAPARECIDO. A RESIST�NCIA TENTA DESESPERADAMENTE ENCONTR�-LO ANTES PARA SALVAR A GAL�XIA."
        },
        {"SINOPSE ROGUE ONE",
            "A ALIAN�A REBELDE REALIZA UM MOVIMENTO ARRISCADO DE ROUBAR OS PLANOS DE DESTRUI��O DA ESTRELA DA MORTE \nPARA TRAZER UMA NOVA ESPERAN�A PARA A GAL�XIA"
        },
        {"STAR WARS",
            "STAR WARS � O T�TULO DE UMA FRANQUIA DE �PERA ESPACIAL ESTADUNIDENSE CRIADA PELO CINEASTA GEORGE LUCAS. \nA FRANQUIA CONTA COM UMA S�RIE DE SETE FILMES DE FANTASIA CIENT�FICA, UM SPIN-OFF E UMA S�RIE DE JOGOS."
        },
        {"LUKE SKYWALKER",
            "LUKE SKYWALKER � O PROTAGONISTA DA TRILOGIA ORIGINAL. UMA FIGURA IMPORTANTE NA LUTA DA ALIAN�A REBELDE CONTRA O IMP�RIO GAL�CTICO, \nELE � O IRM�O G�MEO DA L�DER REBELDE PRINCESA LEIA ORGANA DE ALDERAAN, � AMIGO DO MERCEN�RIO HAN SOLO, APRENDIZ DO MESTRE \nJEDI OBI-WAN 'BEN' KENOBI, E O FILHO DO JEDI CA�DO DARTH VADER (ANAKIN SKYWALKER) E DA RAINHA DE NABOO/SENADORA DA \nREP�BLICA PADM� AMIDALA. ELE TAMB�M � O TIO E ANTIGO MESTRE DE KYLO REN, ANTES DESTE TER SE CONVERTIDO \nAO LADO NEGRO DA FOR�A."
        },
        {"CHEWBACCA",
            "NA S�RIE STAR WARS, CHEWBACCA � APELIDO: CHEWIE � � O CO-PILOTO DA NAVE MILLENNIUM FALCON E O MELHOR AMIGO DE HAN SOLO, \nE UM ALIEN�GENA DA RA�A WOOKIEE, ORIUNDO DO PLANETA KASHYYYK. TENDO PARTICIPADO DE CINCO DOS SETE FILMES DA FRANQUIA."
        },
        //------------------Harry Potter
        {"EM QUAL ANO FOI LAN�ADO O PRIMEIRO FILME DO HARRY POTTER",
            "Harry Potter e a Pedra Filosofal foi lan�ado em 2001 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO O FILME HARRY POTTER E A PEDRA FILOSOFAL",
            "Harry Potter e a Pedra Filosofal foi lan�ado em 2001 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO O SEGUNDO FILME DO HARRY POTTER",
            "Harry Potter e a C�mara Secreta foi lan�ado no Brasil em 2002"},
        {"EM QUAL ANO FOI LAN�ADO O TERCEIRO FILME DO HARRY POTTER",
            "Harry Potter e o Prisioneiro de Azkaban foi lan�ado em 2004"},
        {"EM QUAL ANO FOI LAN�ADO O QUARTO FILME DO HARRY POTTER",
            "Harry Potter e o Calice de Fogo foi lan�ado em 2005 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO O QUINTO FILME DO HARRY POTTER",
            "Harry Potter e a Ordem da Fenix foi lan�ado no Brasil em 2007"},
        {"EM QUAL ANO FOI LAN�ADO O SEXTO FILME DO HARRY POTTER",
            "Harry Potter e o Pr�ncipe Mesti�o foi lan�ado em 2009 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO O SETIMO FILME DO HARRY POTTER",
            "Harry Potter e as Rel�quias Da Morte Parte 1 foi lan�ado em 2010 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO A PRIMEIRA PARTE DO SETIMO FILME DO HARRY POTTER",
            "Harry Potter e as Rel�quias Da Morte Parte 1 foi lan�ado em 2010 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO A PRIMEIRA PARTE DO HARRY POTTER E AS RELIQUIAS DA MORTE",
            "Harry Potter e as Rel�quias Da Morte Parte 1 foi lan�ado em 2010 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO O FILME HARRY POTTER E AS RELIQUIAS DA MORTE PARTE 1",
            "Harry Potter e as Rel�quias Da Morte Parte 1 foi lan�ado em 2010 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO O OITAVO FILME DO HARRY POTTER",
            "Harry Potter e as Rel�quias da Morte Parte 2 foi lan�ado em 2011 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO A PARTE 2 DO SETIMO FILME DO HARRY POTTER",
            "Harry Potter e as Rel�quias da Morte Parte 2 foi lan�ado em 2011 no Brasil"},
        {"EM QUAL ANO FOI LAN�ADO A SEGUNDA PARTE DO FILME HARRY POTTER E AS RELIQUIAS DA MORTE",
            "Harry Potter e as Rel�quias da Morte Parte 2 foi lan�ado em 2011 no Brasil"},
        {"PERSONAGENS PRINCIPAIS DA SERIE",
            "Existem varios que poderiam ser considerados principais, porem o trio maximo e Harry Potter (Daniel Radcliffe), \nRon Weasley (Rupert Grint) e Hermione Granger (Emma Watson)"},
        {"ALGUMA COISA SOBRE A SERIE QUE NAO SEJA MUITO CONHECIDA",
            "Nos ultimos filmes, ou ultimo livro, da serie o total de personagens mortos sao 83 pessoas, juntando conhecidas e n�o conhecidas"},
        {"LISTA DE FEITI�OS MAIS CONHECIDOS",
            "10 - imperius \n9 - Morsmordre \n8 - Petrificus Totalus \n7 - Wingardium Leviosa (n�o confundir com levios�) \n6 - Accio \n5 - Cruciatus \n4 - Lumos \n3 - Expecto Patronum \n2 - Avada Kedavra \n1 - Expelliarmus"},
        {"QUAIS SAO AS RELIQUIAS DA MORTE",
            "S�o 3, A VArinha das Varinhas, A Pedra da ressurei��o e a Capa de Invisibilidade infinita"},
        {"QUAIS SAO AS HORCRUX QUE VOLDEMORT USA",
            "1 O Di�rio de Tom Servolo Riddle\n2 O Anel de Servolo Gaunt / O Anel de Marvolo Gaunt\n3	O Medalh�o de Slytherin\n4	A Ta�a de Hufflepuff\n5	O Diadema de Ravenclaw\n6	A Cobra Nagini\n7	Harry Potter"},
        {"POR QUE VOLDEMORT E CHAMADO DE AQUELE QUE NAO DEVE SER NOMEADO",
            "O nome Voldemort possui um augouro que quando falado em voz alta aviza a ele quem disse e onde, como \num gps, por isso pessoas evitam mencionar o nome"},
        {"QUAL A UTILIDADE DE TER AS HORCRUX E COMO CONSEGUIR",
            "A utilidade e ser tecnicamente imortal, pois voc� divide sua alma e pode ser ressucitado, o metodo para \nse criar uma voc� precisar matar alguem para dividir a sua alma e a colocar em algum objeto para protegela"},
        //-------------SENHOR DOS ANEIS
        {"EM QUAL ANO FOI LAN�ADO O SENHOR DOS ANEIS 1",
            "O Senhor dos Aneis - A Sociedade do anel foi lan�ado em 2001"
        },
        {"EM QUAL ANO FOI LAN�ADO O SENHOR DOS ANEIS 2",
            "O Senhor dos Aneis  - As Duas Torres foi lan�ado em 2002"
        },
        {"EM QUAL ANO FOI LAN�ADO O SENHOR DOS ANEIS 3",
            "O Senhor dos Aneis - O Retorno do Rei foi lan�ado em 2003"
        },
        {"EM QUAL ANO FOI LAN�ADO O SENHOR DOS ANEIS A SOCIEDADE DO ANEL",
            "O Senhor dos Aneis  - A Sociedade do anel foi lan�ado em 2001"
        },
        {"EM QUAL ANO FOI LAN�ADO O SENHOR DOS ANEIS AS DUAS TORRES",
            "O Senhor dos Aneis  - As Duas Torres foi lan�ado em 2002"
        },
        {"EM QUAL ANO FOI LAN�ADO O SENHOR DOS ANEIS O RETORNO DO REI",
            "O Senhor dos Aneis  - O Retorno do Rei foi lan�ado em 2003"
        },
        {"SINOPSE SENHOR DOS ANEIS 1",
            "Um hobbit recebe de presente de seu tio um anel m�gico e maligno que precisa \nser destru�do antes que caia nas m�os do mal, pois o futuro da civiliza��o \ndepende do destino desse anel. Para isso, o hobbit Frodo ter� um caminho \n�rduo pela frente. Ao seu lado, para o cumprimento desta jornada, ele poder� \ncontar com outros hobbits."
        },
        {"SINOPSE SENHOR DOS ANEIS 2",
            "Frodo, seus amigos e os cont�nuos esfor�os para destruir o anel. Frodo e Sam\ndescobrem que est�o sendo seguidos pelo misterioso Gollum. Enquanto isso, \nAragorn, o elfo e arqueiro Legolas e o an�o Gimli chegam ao reino de Rohan,\nonde o rei Theoden foi v�tima de uma maldi��o mortal de Saruman."
        },
        {"SINOPSE SENHOR DOS ANEIS 3",
            "O confronto final entre as for�as do bem e do mal que lutam pelo controle do \nfuturo da Terra M�dia. Hobbits, Frodo e Sam chegam a Mordor na sua miss�o \npara destruir o anel enquanto Aragorn leva as for�as do bem contra o ex�rcito\ndo mal de Sauron na cidade de pedra de Minas Tirith."
        },
        {"PERSONAGENS SENHOR DOS ANEIS",
            "FRODO BOLSEIRO \nBILBO BOLSEIRO \nSAM GAMGI \nPIPPIN \nMERRY \nARAGORN \nGANDALF \nBOROMIR \nGIMLI \nLEGOLAS \nELROND \nARWEN \nGOLLUM \nGALADRIEL\nSARUMAN \nSAURON \nCAVALEIROS NEGROS"
        },
        {"FRODO BOLSEIRO",
            "O 'her�i' da saga, o hobbit portador do Um Anel - aquele capaz de controlar \ntodos os demais. Primo de Bilbo, de quem herda o anel e a miss�o de \nconduzi-lo � destrui��o, para evitar a vit�ria do reino das sombras e a \nvolta de Sauron.(MAIOR COVARDE EVER)"
        },
        {"BILBO BOLSEIRO",
            "Hobbit que viveu a grande aventura com os 13 an�es relatada no livro 'O Hobbit'\n, que antecede a trilogia de 'O Senhor dos An�is'. Foi ele quem, atrav�s de um \ntruque, apoderou-se do Um Anel, que estava em poder de Gollum, e cujos poderes \nespeciais, como o de conferir a invisibilidade, salvou sua vida diversas vezes."
        },
        {"SAM GAMGI",
            "Hobbit que � o mais fiel servidor de Frodo e cujo empenho ser� essencial ao \ncumprimento da miss�o do mestre.(TRUE HERO)"
        },
        {"PIPPIN",
            "Jovem hobbit que � um dos maiores amigos de Frodo e um de seus mais valentes parceiros."
        },
        {"MERRY",
            "Jovem hobbit que � um dos maiores amigos de Frodo."
        },
        {"ARAGORN",
            "Nome verdadeiro do guardi�o Passolargo. Descendente da linhagem de Elendil, � filho de \nArathorn e herdeiro leg�timo em condi��es de postular o trono de Gondor - cujo governo \nest� nas m�os do regente Denethor, pai de Boromir. � um dos l�deres da comitiva do anel."
        },
        {"GANDALF",
            "Mago de grande poder e sabedoria, conhecido como 'O Cinzento' (pela cor de suas roupas e chap�u)\n ou Mithrandir, na l�ngua dos elfos. Foi o mentor da aventura de Bilbo e tamb�m da \nmiss�o de Frodo. L�der m�ximo da comitiva do anel."
        },
        {"BOROMIR",
            "Filho mais velho de Denethor, regente de Gondor, � homem de grande bravura. Mas os \npoderes do anel exercem uma influ�ncia mal�fica sobre sua ambi��o."
        },
        {"GIMLI",
            "An�o, filho de Gl�in (um dos 13 an�es que viveram a grande aventura com Bilbo Bolseiro). \nForte e valente, usa o seu machado com grande per�cia nas batalhas contra os orcs. \nMas ainda tem para resolver uma velha pend�ncia de seu povo contra os elfos."
        },
        {"LEGOLAS",
            "Elfo dos povos do norte, usa com grande pontaria o seu insepar�vel arco, com o qual \ndispara flechas certeiras contra os orcs e outros inimigos de Gondor."
        },
        {"ELROND",
            "Meio-elfo, Senhor de Valfenda, � quem organiza o conselho onde ser� decidida a cria��o \nda comitiva do anel e sua composi��o de nove membros. Pai de Arwen."
        },
        {"ARWEN",
            "Princesa �lfica que se disp�e a abrir m�o da imortalidade de seu povo pelo amor a Aragorn."
        },
        {"GOLLUM",
            "Nome pelo qual � conhecido aquele que j� se chamou Sm�agol. Criatura sombria, vivia numa \nilha de pedra, num lago frio sob as minas dos orcs e se tornara dono do Um Anel, at� que \no hobbit Bilbo o enganou, apossando-se da j�ia. \nDesde ent�o, vive em busca de recuperar o que chama de ``meu precioso''. De car�ter d�bio, \nserve ao reino das sombras mas tem um papel decisivo na miss�o de Frodo."
        },
        {"GALADRIEL",
            "Senhora de L�thlorien, dotada de grande beleza, sabedoria e poderes m�gicos. Tamb�m � \nguardi� de um anel, Nenya, o Anel de Diamante, um dos tr�s destinados aos reis-elfos. \nMulher de Celeborn."
        },
        {"SARUMAN",
            "Velho mago, mestre da ordem de Gandalf e seu conselheiro, cai sob a influ�ncia maligna de\nSauron e torna-se l�der do reino das sombras."
        },
        {"SAURON",
            "L�der todo-poderoso do reino das sombras, que sucumbiu na batalha contra Isildur, rei \ndos homens, que lhe tomou o Um Anel, por ele forjado para controlar todos os outros \nan�is em poder dos elfos, an�es e homens a fim de evitar a destrui��o da Terra-m�dia. \nCom seu enorme poder, este Senhor do Escuro conseguiu sobreviver sem um corpo. Sua \nsombra tomou forma novamente na Floresta das Trevas e ele voltou a ocupar a torre de Mordor. "
        },
        {"CAVALEIROS NEGROS",
            "Tamb�m conhecidos como Nazg�l, ou Espectros do Anel. Foram outrora nove reis humanos que\nsucumbiram �s tenta��es suscitadas pela posse de seus respectivos an�is de poder e \ntornaram-se mortos-vivos a servi�o do Senhor do Escuro."
        },
        //------------------Disney
        {"CURIOSIDADE SOBRE PROCURANDO DORY",
            "O Filme Procurando Dory se passa um ano ap�s Marlin ter encontrado Nemo em Procurando Nemo"
        },
        {"FALE ALGUNS FILMES DA DISNEY", "Aqui vai alguns :)\nO Rei Le�o\nO C�o e a Raposa\nProcurando Nemo\nProcurando Dori"
        },
        {"PERSONAGENS DE PROCURANDO DORY",
            "Dory\nMarlin\nInez\nDestiny\nTio Raia\nGill\nHank"
        },
        {"O QUE ACONTECEU EM PROCURANDO DORY",
            "A amig�vel e esquecida Dory come�a uma busca por seus parentes perdidos e aprende algumas coisas \nsobre o significado de fam�lia."
        },
        {"QUANDO FOI LAN�ADO PROCURANDO DORY",
            "17 de junho de 2016 no Estados Unidos."
        },
        {"CURIOSIDADES DE PROCURANDO NEMO",
            "Despois de algum tempo do lan�amento de Procurando Nemo foi lan�ado um filme com Dori, uma personagem \nsecund�ria, pelo seu grande sucesso!"
        },
        {"O QUE ACONTECEU EM PROCURANDO NEMO",
            "Em seu primeiro dia de aula, esquecendo os conselhos do pai superprotetor, Nemo � capturado por um mergulhador e acaba \nno aqu�rio de um dentista. Enquanto Nemo tenta bolar um plano para escapar, seu pai cruza o oceano para resgat�-lo."
        },
        {"QUANDO FOI LAN�ADO PROCURANDO NEMO",
            "O Filme foi lan�ado em 2003, e devido ao grande sucesso em 2012, Procurando Nemo foi relan�ado em 3D, com a data \npara 14 de setembro de 2012 para os Estados Unidos. Para o Brasil, o relan�amento ocorreu no dia 12 de outubro de 2012."
        },
        {"ELENCO DE PROCURANDO NEMO",
            "Ellen DeGeneres\nAlexander Gould\nAlbert Brooks\nAndrew Staton\nWillem Dafoe"
        },
        {"QUAIS S�O OS PERSONAGENS DE PROCURANDO NEMO",
            "\nNemo\nMarlin\nDori\nCrush\nTio Raia"}

    };

    static boolean isPunc(char ch) {
        return delim.indexOf(ch) != -1;
    }

    // removes punctuation and redundant
    // spaces from the user's input
    static StringBuffer cleanString(String str) {
        StringBuffer temp = new StringBuffer(str.length());
        char prevChar = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ' && prevChar == ' ') {
                continue;
            } else if (!isPunc(str.charAt(i))) {
                temp.append(str.charAt(i));
            }
            prevChar = str.charAt(i);
        }
        return temp;
    }

    static String preProcessInput(String str) {
        StringBuffer temp = new StringBuffer(str.toUpperCase());
        temp = cleanString(temp.toString());
        return temp.toString();
    }

    static Vector<String> findMatch(String str) {
        Vector<String> result = new Vector<String>(maxResp);
        for (int i = 0; i < KnowledgeBase.length; ++i) {
            // there has been some improvements made in
            // here in order to make the matching process
            // a littlebit more flexible
            if (str.indexOf(KnowledgeBase[i][0]) != -1) {
                for (int j = maxInput; j <= maxResp; ++j) {
                    result.add(KnowledgeBase[i][j]);
                }
                break;
            }
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String sResponse = "";
        String sInput = "";
        while (true) {
            System.out.print(">");
            String sPrevInput = sInput;
            String sPrevResponse = sResponse;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            sInput = in.readLine();
            sInput = preProcessInput(sInput);
            Vector<String> responses = new Vector<String>(maxResp);
            responses = findMatch(sInput);
            if (sPrevInput.equalsIgnoreCase(sInput) && sPrevInput.length() > 0) {
                // controling repetitions made by the user
                System.out.println("VOC� EST� SE REPETINDO.");
            } else if (sInput.equalsIgnoreCase("TCHAU")) {
                System.out.println("FOI MUITO LEGAL CONVERSAR COM VOC� USU�RIO, AT� MAIS :)");
                break;
            } else if (responses.size() == 0) {
                // handles the case when the program doesn't understand what the user is talking about	
                System.out.println("N�O SEI SE ESTOU ENTENDENDO O QUE VOC� EST� FALANDO..");
            } else {
                Random generator = new Random();
                int nSelection = generator.nextInt(maxResp);
                sResponse = responses.elementAt(nSelection);
                // avoids repeating the same response
                if (sResponse == sPrevResponse) {
                    responses.removeElementAt(nSelection);
                    nSelection = generator.nextInt(maxResp);
                    sResponse = responses.elementAt(nSelection);
                }
                System.out.println(sResponse);
            }
        }
    }
}
