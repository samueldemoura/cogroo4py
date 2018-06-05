package br.edu.univali.lia.cogroo;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CogrooPythonInterfaceTest extends TestCase {
	
	CogrooPythonInterface app;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @throws IOException 
     * @throws IllegalArgumentException 
     */
    public CogrooPythonInterfaceTest( String testName ) throws IllegalArgumentException, IOException
    {
        super( testName );
        
        app = new CogrooPythonInterface();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CogrooPythonInterfaceTest.class );
    }
    
    public static String getMistakeRuleId(CogrooPythonInterface app, String text)
    {
    	return app.grammarCheck(text).getMistakes().get(0).getRuleIdentifier();
    }
    
    public void testCommunityRulesExamples()
    {
			assertEquals(getMistakeRuleId(app, "Refiro-me à trabalho remunerado."), "xml:1");
			assertEquals(getMistakeRuleId(app, "Refiro-me à trabalhos remunerados."), "xml:2");
			assertEquals(getMistakeRuleId(app, "Refiro-me à reuniões extraordinárias."), "xml:3");
			assertEquals(getMistakeRuleId(app, "Fomos levados à crer."), "xml:4");
			assertEquals(getMistakeRuleId(app, "A uma hora estaremos partindo."), "xml:5");
			assertEquals(getMistakeRuleId(app, "As duas horas estaremos partindo"), "xml:6");
			assertEquals(getMistakeRuleId(app, "Os ônibus estacionaram a direita do pátio."), "xml:7");
			assertEquals(getMistakeRuleId(app, "Os ônibus estacionaram a esquerda do pátio."), "xml:8");
			//assertEquals(getMistakeRuleId(app, "Em relação a segurança dos menores."), "xml:9");
			//assertEquals(getMistakeRuleId(app, "Em relação as atividades programadas."), "xml:10");
			assertEquals(getMistakeRuleId(app, "Com relação a segurança dos menores,"), "xml:11");
			assertEquals(getMistakeRuleId(app, "Com relação as atividades programadas."), "xml:12");
			assertEquals(getMistakeRuleId(app, "Devido a cobrança injusta."), "xml:13");
			assertEquals(getMistakeRuleId(app, "Devido as cobranças injustas."), "xml:14");
			assertEquals(getMistakeRuleId(app, "Enviei os documentos à você."), "xml:15");
			//assertEquals(getMistakeRuleId(app, "Enviei os documentos à Vossa Excelência."), "xml:16");
			assertEquals(getMistakeRuleId(app, "Os casacos bonito ficaram prontos."), "xml:17");
			assertEquals(getMistakeRuleId(app, "O casaco feios ficou pronto."), "xml:17");
			assertEquals(getMistakeRuleId(app, "As faces rosada das crianças."), "xml:17");
			assertEquals(getMistakeRuleId(app, "A face rosadas da criança."), "xml:17");
			//assertEquals(getMistakeRuleId(app, "O casaco feios ficou pronto."), "xml:18"); // igual xml:17
			//assertEquals(getMistakeRuleId(app, "As faces rosada das crianças."), "xml:19"); 
			//assertEquals(getMistakeRuleId(app, "A face rosadas da criança."), "xml:20");
			assertEquals(getMistakeRuleId(app, "O belo carros ficou pronto."), "xml:21");
			assertEquals(getMistakeRuleId(app, "Os belos carro ficaram prontos."), "xml:21");
			assertEquals(getMistakeRuleId(app, "As bonitas face das crianças."), "xml:21");
			assertEquals(getMistakeRuleId(app, "As bonita faces das crianças."), "xml:21");
			//assertEquals(getMistakeRuleId(app, "Os belos carro ficaram prontos."), "xml:22");
			//assertEquals(getMistakeRuleId(app, "As bonita faces das crianças."), "xml:23");
			//assertEquals(getMistakeRuleId(app, "As bonitas face das crianças."), "xml:24");
			assertEquals(getMistakeRuleId(app, "Seguem em anexos os documentos solicitados."), "xml:25");
			assertEquals(getMistakeRuleId(app, "Segue em anexa a carta de apresentação."), "xml:26");
			assertEquals(getMistakeRuleId(app, "Seguem em anexas as cartas de apresentação."), "xml:27");
			//assertEquals(getMistakeRuleId(app, "Seguem anexos o documento solicitado."), "xml:28");
			//assertEquals(getMistakeRuleId(app, "Seguem anexo os documentos solicitados."), "xml:29");
			assertEquals(getMistakeRuleId(app, "Seguem anexa as cartas de apresentação."), "xml:30");
			//assertEquals(getMistakeRuleId(app, "Seguem anexas os documentos solicitados."), "xml:31");
			//assertEquals(getMistakeRuleId(app, "Seguem anexas a carta de representação."), "xml:32");
			assertEquals(getMistakeRuleId(app, "Segue anexos o documento solicitado."), "xml:33");
			//assertEquals(getMistakeRuleId(app, "Segue anexo os documentos solicitados."), "xml:34");
			assertEquals(getMistakeRuleId(app, "Segue anexa as cartas de apresentação."), "xml:35");
			//assertEquals(getMistakeRuleId(app, "Segue anexas os documentos solicitados."), "xml:36");
			//assertEquals(getMistakeRuleId(app, "Segue anexas a carta de apresentação."), "xml:37");
			assertEquals(getMistakeRuleId(app, "As conclusões estão meias confusas."), "xml:38");
			assertEquals(getMistakeRuleId(app, "As dificuldades financeiras deixam papai e mamãe meios tristes."), "xml:39");
			assertEquals(getMistakeRuleId(app, "Consumiram apenas meio garrafa de vinho."), "xml:40");
			assertEquals(getMistakeRuleId(app, "Compramos meio porção de queijo."), "xml:40");
			assertEquals(getMistakeRuleId(app, "São quinze meio litros de óleo."), "xml:41");
			assertEquals(getMistakeRuleId(app, "Já fazem dias que não o vejo."), "xml:42");
			assertEquals(getMistakeRuleId(app, "Já fizeram semanas que não o vejo."), "xml:42");
			assertEquals(getMistakeRuleId(app, "Já farão anos que eu não a verei."), "xml:42");
			assertEquals(getMistakeRuleId(app, "Já fazem três dias que não o vejo."), "xml:43");
			assertEquals(getMistakeRuleId(app, "Já fizeram duas semanas que não o vejo."), "xml:43");
			assertEquals(getMistakeRuleId(app, "Já farão nove anos que eu não a verei."), "xml:43");
			assertEquals(getMistakeRuleId(app, "Já vão fazer três semanas que não o vejo."), "xml:44");
			assertEquals(getMistakeRuleId(app, "Já iam fazer seis semanas que não o vejo."), "xml:44");
			assertEquals(getMistakeRuleId(app, "Já podem fazer duas semanas que não o vejo."), "xml:44");
			assertEquals(getMistakeRuleId(app, "Já vão fazer semanas que não o vejo."), "xml:45");
			assertEquals(getMistakeRuleId(app, "Já iam fazer semanas que não o vejo."), "xml:45");
			assertEquals(getMistakeRuleId(app, "Já podem fazer semanas que não o vejo."), "xml:45");
			assertEquals(getMistakeRuleId(app, "A dez anos não nos vemos."), "xml:46");
			assertEquals(getMistakeRuleId(app, "Suponho que a dez anos ocorreu um terremoto."), "xml:46");
			assertEquals(getMistakeRuleId(app, "A anos não nos vemos."), "xml:47");
			assertEquals(getMistakeRuleId(app, "Haviam dois anos que nos vimos pela última vez."), "xml:48");
			assertEquals(getMistakeRuleId(app, "Haviam anos que nos vimos pela última vez."), "xml:49");
			assertEquals(getMistakeRuleId(app, "Haviam ratos na cozinha."), "xml:50");
			assertEquals(getMistakeRuleId(app, "Haviam nuvens escuras no céu."), "xml:50");
			assertEquals(getMistakeRuleId(app, "Haverão ratos na cozinha."), "xml:50");
			assertEquals(getMistakeRuleId(app, "Haverão nuvens escuras no céu."), "xml:50");
			assertEquals(getMistakeRuleId(app, "Devem haver ratos na cozinha."), "xml:51");
			assertEquals(getMistakeRuleId(app, "Podem haver nuvens escuras no céu."), "xml:51");
			assertEquals(getMistakeRuleId(app, "Para mim estudar, silêncio é necessário."), "xml:52");
			assertEquals(getMistakeRuleId(app, "Entre ele e eu só há discórdia."), "xml:53");
			assertEquals(getMistakeRuleId(app, "Entre eu e ele só há discórdia."), "xml:54");
			assertEquals(getMistakeRuleId(app, "Entre ele e tu só há discórdia."), "xml:55");
			assertEquals(getMistakeRuleId(app, "Entre tu e ele só há discórdi"), "xml:56");
			assertEquals(getMistakeRuleId(app, "Não como carne mau passada."), "xml:57");
			assertEquals(getMistakeRuleId(app, "Eu sou mal."), "xml:58");
			assertEquals(getMistakeRuleId(app, "Eu prefiro mais comer no bandejão."), "xml:59");
			assertEquals(getMistakeRuleId(app, "Eu prefiro festa do que balada."), "xml:60");
			assertEquals(getMistakeRuleId(app, "Não meto-me no que não sou chamado."), "xml:61");
			assertEquals(getMistakeRuleId(app, "Nunca viu-te comendo carne."), "xml:61");
			assertEquals(getMistakeRuleId(app, "Jamais ocorreu-nos tal idéia."), "xml:61");
			assertEquals(getMistakeRuleId(app, "Jamais deixarei-lhes minha herança."), "xml:61");
			//assertEquals(getMistakeRuleId(app, "Ninguém conhece-nos mais do que nós mesmos."), "xml:62");
			//assertEquals(getMistakeRuleId(app, "Nada impede-nos de continuar."), "xml:62");
			assertEquals(getMistakeRuleId(app, "Nenhum homem quer-lhe bem."), "xml:63");
			assertEquals(getMistakeRuleId(app, "Nenhuma aventura atrai-te."), "xml:63");
			assertEquals(getMistakeRuleId(app, "Nenhuma idéia ocorreu-nos até então."), "xml:63");
			//assertEquals(getMistakeRuleId(app, "Nenhum homem quer-nos bem."), "xml:64");
			//assertEquals(getMistakeRuleId(app, "Nenhuma aventura atrai-nos."), "xml:64");
			assertEquals(getMistakeRuleId(app, "Briguei com ele porque falou-me que eu era incapaz."), "xml:65");
			assertEquals(getMistakeRuleId(app, "Quem falou-te que eu era incapaz?"), "xml:65");
			assertEquals(getMistakeRuleId(app, "Quando move-se um dedo, consegue-se tudo."), "xml:65");
			assertEquals(getMistakeRuleId(app, "Ele não sabe de nada porque foi-se embora mais cedo."), "xml:65");
			//assertEquals(getMistakeRuleId(app, "Quando virem-nos dirigir o carro, se fosse-nos permitido andar de carro, já que a lei que proíbe-nos de dirigir bêbado está em vigor. Quem impediu-nos de entrar o fez por não estarmos devidamente trajados. Porque compete-nos a excelência."), "xml:66");
			//assertEquals(getMistakeRuleId(app, "Creio que "), "xml:66");
			assertEquals(getMistakeRuleId(app, "O sol já põe-se e os soldados não retornaram."), "xml:67");
			assertEquals(getMistakeRuleId(app, "Um guia de ruas da cidade talvez ajude-te."), "xml:67");
			assertEquals(getMistakeRuleId(app, "Mais aprende-se com o exemplo."), "xml:67");
			//assertEquals(getMistakeRuleId(app, "Sempre entendemos-nos bem. Já perguntou-nos o que fazer. Bem fez-nos não almoçar. Aqui faz-nos bem. O excesso de cautela talvez prejudique-nos. A lembrança ainda remete-nos ao passado. Como foi-nos ordenado, fizemos o serviço."), "xml:68");
			assertEquals(getMistakeRuleId(app, "Por que a comida fez-te mal?"), "xml:69");
			assertEquals(getMistakeRuleId(app, "Por que a comida fez-me mal?"), "xml:69");
			//assertEquals(getMistakeRuleId(app, "Por que a comida fez-nos mal?"), "xml:70");
			//assertEquals(getMistakeRuleId(app, "Por que o cachorro mordeu-nos a perna?"), "xml:70");
			assertEquals(getMistakeRuleId(app, "Um dia tudo resolverá-se."), "xml:71");
			assertEquals(getMistakeRuleId(app, "Pouco fala-se de assuntos mais complexos."), "xml:71");
			assertEquals(getMistakeRuleId(app, "Algo diz-me que te enganaram."), "xml:71");
			//assertEquals(getMistakeRuleId(app, "Tudo contraria-nos."), "xml:72");
			//assertEquals(getMistakeRuleId(app, "Pouco falam-nos de assuntos mais complexos."), "xml:72");
			//assertEquals(getMistakeRuleId(app, "Algo diz-nos para parar."), "xml:72");
			assertEquals(getMistakeRuleId(app, "Só cansou-te à toa, pois o sacrifício foi em vão."), "xml:73");
			assertEquals(getMistakeRuleId(app, "Ou esforça-se, ou será reprovado."), "xml:73");
			assertEquals(getMistakeRuleId(app, "Quer tenha-se o aval, quer não o tenha, fecharemos o negócio."), "xml:73");
			//assertEquals(getMistakeRuleId(app, "Só pagaram-nos o salário depois de muita insistência. Ou esforçamo-nos, ou seremos reprovados. Os amigos, ora acolhem-nos, ora desprezam-nos. Quer apóie-nos, quer faça-nos oposição, o inimigo é sempre perigoso. Só fico nos lugares numerados e caros. Ou compro nos mercados ou por telefone."), "xml:74");
			assertEquals(getMistakeRuleId(app, "Quando ele dizer o que pensa, estaremos acabados."), "xml:75");
			assertEquals(getMistakeRuleId(app, "Se ele fazer algo errado, logo saberemos."), "xml:75");
			assertEquals(getMistakeRuleId(app, "Quando ele manter a palavra, ficaremos surpresos."), "xml:75");
			assertEquals(getMistakeRuleId(app, "Quando ele pôr as coisas em ordem, ele viajará para o exterior."), "xml:75");
			assertEquals(getMistakeRuleId(app, "Se eu ver meu irmão novamente, perguntar-lhe-ei sobre esse assunto."), "xml:75");
			assertEquals(getMistakeRuleId(app, "Quando Maria pôr as coisas em ordem, ela viajará para fora do país."), "xml:76");
			assertEquals(getMistakeRuleId(app, "Se João ver meu irmão novamente, perguntar-lhe-á sobre esse assunto."), "xml:76");
			assertEquals(getMistakeRuleId(app, "Quando a professora pôr as coisas em ordem, ela aplicará novas provas."), "xml:77");
			assertEquals(getMistakeRuleId(app, "Se o cachorro ver o gato novamente, latirá para ele."), "xml:77");
			assertEquals(getMistakeRuleId(app, "Mas quando o gato saber desviar do cachorro, nada acontecerá."), "xml:77");
			assertEquals(getMistakeRuleId(app, "Vamos as cidades históricas."), "xml:78");
			assertEquals(getMistakeRuleId(app, "Crianças vão a escola."), "xml:78");
			//assertEquals(getMistakeRuleId(app, "Nós fomos a livraria ontem."), "xml:78");
			assertEquals(getMistakeRuleId(app, "Os alunos aderiram as novas idéias do jovem professor."), "xml:79");
			assertEquals(getMistakeRuleId(app, "A cola aderiu a camada da pele."), "xml:79");
			assertEquals(getMistakeRuleId(app, "O dinheiro apreendido pertencia as crianças."), "xml:80");
			//assertEquals(getMistakeRuleId(app, "Os heróis pertencem a Pátria."), "xml:80");
			assertEquals(getMistakeRuleId(app, "Os alunos candidataram-se as vagas de estagiários."), "xml:81");
			assertEquals(getMistakeRuleId(app, "Paulo candidatou-se a vaga de inspetor de produção."), "xml:81");
			assertEquals(getMistakeRuleId(app, "Se desobedecermos as lideranças, será o caos."), "xml:82");
			assertEquals(getMistakeRuleId(app, "Se não obedecermos as lideranças, será o caos."), "xml:82");
			assertEquals(getMistakeRuleId(app, "Obedecia a tia, como antes obedecia a mãe."), "xml:82");
			//assertEquals(getMistakeRuleId(app, "Eles são estudioso."), "xml:83");
			assertEquals(getMistakeRuleId(app, "Ela estava acomodada a vida de solteira."), "xml:84");
			assertEquals(getMistakeRuleId(app, "Estava destinada a delicada tarefa de ser mãe."), "xml:84");
			assertEquals(getMistakeRuleId(app, "Ela foi exposta a radiação."), "xml:84");
			assertEquals(getMistakeRuleId(app, "A população reagirá mal as exigências de racionamento."), "xml:85");
			assertEquals(getMistakeRuleId(app, "O presidente reagiu bem as críticas."), "xml:85");
			assertEquals(getMistakeRuleId(app, "Nós obedeceremos os princípios básicos de convivência."), "xml:86");
			//assertEquals(getMistakeRuleId(app, "Ela, com certeza, mentiu, quanto à ele, parece que foi sincero."), "xml:87");
			//assertEquals(getMistakeRuleId(app, "Na hora do aperto, sempre recorrem à mim."), "xml:87");
			//assertEquals(getMistakeRuleId(app, "Graças à vocês, tudo se resolveu a tempo."), "xml:87");
			assertEquals(getMistakeRuleId(app, "Quanto a eu, estou pronto para renunciar."), "xml:88");
			//assertEquals(getMistakeRuleId(app, "Ela, com certeza, mentiu; quanto à ele, parece que foi sincero."), "xml:89");
			//assertEquals(getMistakeRuleId(app, "Na hora do aperto, sempre recorrem à mim."), "xml:89");
			//assertEquals(getMistakeRuleId(app, "Graças à vós, tudo se resolveu a tempo."), "xml:89");
			assertEquals(getMistakeRuleId(app, "Fiquei namorando com aquela jóia, disposto a comprá-la."), "xml:90");
			assertEquals(getMistakeRuleId(app, "Júlio namorou com Marina durante três anos."), "xml:90");
			assertEquals(getMistakeRuleId(app, "Estávamos acostumados as folgas semanais."), "xml:91");
			assertEquals(getMistakeRuleId(app, "Não tivemos acesso as provas."), "xml:91");
			assertEquals(getMistakeRuleId(app, "Chegamos para o almoço ao meio-dia e meio."), "xml:92");
			assertEquals(getMistakeRuleId(app, "A vitória deste ano terá sido equivalente as derrotas anteriores?"), "xml:93");
			assertEquals(getMistakeRuleId(app, "Nosso esforço era equivalente a ousadia de José."), "xml:93");
			assertEquals(getMistakeRuleId(app, "A revolta equivaleu as injustiças."), "xml:94");
			assertEquals(getMistakeRuleId(app, "A revolta equivaleu a injustiça cometida."), "xml:94");
			assertEquals(getMistakeRuleId(app, "Esse valor equivale a jornada de um dia."), "xml:94");
			assertEquals(getMistakeRuleId(app, "Esse valor equivale a dura jornada de um dia."), "xml:94");
			assertEquals(getMistakeRuleId(app, "Recebemos os cartão de crédito pelo correio."), "xml:95");
			assertEquals(getMistakeRuleId(app, "Os copo estão quebrados."), "xml:95");
			assertEquals(getMistakeRuleId(app, "As criança foram ao parque."), "xml:95");
			//assertEquals(getMistakeRuleId(app, "Recebemos o cartões de crédito pelo correio."), "xml:95");
			assertEquals(getMistakeRuleId(app, "Uns copo estão quebrados."), "xml:95");
			assertEquals(getMistakeRuleId(app, "Nós usufruímos da alegria de estar com vocês."), "xml:96");
			assertEquals(getMistakeRuleId(app, "Nós demoramos para perceber o erro."), "xml:97");
			assertEquals(getMistakeRuleId(app, "Quem torce para o Palmeiras?"), "xml:97");
			assertEquals(getMistakeRuleId(app, "Na escolha do líder, votarei para o Collor."), "xml:97");
			assertEquals(getMistakeRuleId(app, "Ele arrasou com os jogadores que perderam."), "xml:98");
			assertEquals(getMistakeRuleId(app, "Pôde habituar-se com o silêncio?"), "xml:99");
			assertEquals(getMistakeRuleId(app, "Ele não conseguiu habituar-se com o ritmo de trabalho."), "xml:99");
			assertEquals(getMistakeRuleId(app, "Todos já se habituaram com a nova rotina de trabalho."), "xml:100");
			assertEquals(getMistakeRuleId(app, "Não me habituo com esse silêncio."), "xml:100");
			//assertEquals(getMistakeRuleId(app, "Habituamo-nos com a miséria."), "xml:101");
			assertEquals(getMistakeRuleId(app, "Não nos habituamos com a injustiça."), "xml:102");
			assertEquals(getMistakeRuleId(app, "Assim que nos habituarmos com o seu ritmo, seremos mais eficientes."), "xml:102");
			//assertEquals(getMistakeRuleId(app, "Foi ferido por uma balas perdidas."), "xml:103");
			//assertEquals(getMistakeRuleId(app, "A meninas fantasiadas nos rodearam."), "xml:103");
			//assertEquals(getMistakeRuleId(app, "Já enviamos o cartões de identificação."), "xml:103");
			//assertEquals(getMistakeRuleId(app, "Cumprimentamos um alunos pelo sucesso nas provas."), "xml:103");
			//assertEquals(getMistakeRuleId(app, "As meninos quebraram as vidraças."), "xml:104");
			//assertEquals(getMistakeRuleId(app, "Uma amigos sempre ajuda nas horas difíceis."), "xml:104");
			//assertEquals(getMistakeRuleId(app, "As professores não deram aulas."), "xml:104");
			//assertEquals(getMistakeRuleId(app, "Um notícia mal divulgada gera confusão."), "xml:105");
			//assertEquals(getMistakeRuleId(app, "Deixamos as tarefas mais delicadas para o meninas realizarem."), "xml:105");
			//assertEquals(getMistakeRuleId(app, "Os canetas vermelhas estão sem tinta."), "xml:105");
			assertEquals(getMistakeRuleId(app, "À medida em que subíamos, o ar tornava-se mais rarefeito."), "xml:106");
			assertEquals(getMistakeRuleId(app, "O mau uso dos aparelhos acarretou nos enormes custos de produção."), "xml:107");
			assertEquals(getMistakeRuleId(app, "O balcão de informações atende de segunda à sexta-feira."), "xml:108");
			assertEquals(getMistakeRuleId(app, "É proibido estacionar de segunda à sábado."), "xml:108");
			assertEquals(getMistakeRuleId(app, "Os participantes poderão assistir a apresentação dos premiados."), "xml:109");
			assertEquals(getMistakeRuleId(app, "No fim do verão, assistimos a peça premiada no Festival."), "xml:109");
			assertEquals(getMistakeRuleId(app, "Hoje se busca a valorização ao corpo em detrimento do espírito."), "xml:110");
			assertEquals(getMistakeRuleId(app, "O trabalho mais importante, ou seja a coleta de dados, já foi iniciado."), "xml:111");
			assertEquals(getMistakeRuleId(app, "O trabalho mais importante ou seja, a coleta de dados, já foi iniciado."), "xml:112");
			assertEquals(getMistakeRuleId(app, "Eu vejo tudo no entanto não vejo nada."), "xml:113");
			assertEquals(getMistakeRuleId(app, "Este meninos são levados."), "xml:114");
			assertEquals(getMistakeRuleId(app, "Fomos rodeados por aquela meninas."), "xml:114");
			assertEquals(getMistakeRuleId(app, "Estas meninos são levados."), "xml:114");
			assertEquals(getMistakeRuleId(app, "As vidraças foram quebradas por aquelas meninos."), "xml:114");
			assertEquals(getMistakeRuleId(app, "Estes meninas são levadas."), "xml:114");
			assertEquals(getMistakeRuleId(app, "As vidraças foram quebradas por aqueles meninas."), "xml:114");
			assertEquals(getMistakeRuleId(app, "Eu comprei duas bola."), "xml:115");
			assertEquals(getMistakeRuleId(app, "Eu comprei dois carro."), "xml:115");
			assertEquals(getMistakeRuleId(app, "Eu comprei duas carro."), "xml:115");
			//assertEquals(getMistakeRuleId(app, ""), "xml:116"); // nao existe
			assertEquals(getMistakeRuleId(app, "Eles vai comprar banana."), "xml:117");
			assertEquals(getMistakeRuleId(app, "Elas não tem carro."), "xml:117");
			assertEquals(getMistakeRuleId(app, "Ele vão comprar banana."), "xml:118");
			assertEquals(getMistakeRuleId(app, "Ele não vão comprar banana."), "xml:118");
			assertEquals(getMistakeRuleId(app, "Haviam três ratos na cozinha."), "xml:119");
			assertEquals(getMistakeRuleId(app, "Haviam quatro nuvens escuras no céu."), "xml:119");
			assertEquals(getMistakeRuleId(app, "Haverão cinco ratos na cozinha."), "xml:119");
			assertEquals(getMistakeRuleId(app, "Haverão quinze nuvens escuras no céu."), "xml:119");
			assertEquals(getMistakeRuleId(app, "Devem haver oito ratos na cozinha."), "xml:120");
			assertEquals(getMistakeRuleId(app, "Podem haver doze nuvens escuras no céu."), "xml:120");
			assertEquals(getMistakeRuleId(app, "Nós poderemos estar agendando a visita para amanhã."), "xml:121");
			assertEquals(getMistakeRuleId(app, "A última vez que te vi foi há dois anos atrás."), "xml:122");
			assertEquals(getMistakeRuleId(app, "Eu nasci há 10000 anos atrás."), "xml:122");
			assertEquals(getMistakeRuleId(app, "Não convivemos juntos porque não nos damos muito bem."), "xml:123");
			
			//assertEquals(getMistakeRuleId(app, "Eles são legal."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "Nós somos verde."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "As bonecas eram vermelha."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "Elas eram bela."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "Ele é legais."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "Eu sou verdes."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "A boneca era vermelhas."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "Ela era belas mulheres."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "Eles são vermelha."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "As bonecas eram vermelho."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "Ele é vermelhas."), "xml:124");
			//assertEquals(getMistakeRuleId(app, "A boneca é vermelhos."), "xml:124");
			
			//assertEquals(getMistakeRuleId(app, "Nós vai para lá."), "xml:125");
			assertEquals(getMistakeRuleId(app, "Enviei os documentos à Vossa Excelência."), "xml:126");
			assertEquals(getMistakeRuleId(app, "Sangue e vida é os preços."), "xml:127");
			assertEquals(getMistakeRuleId(app, "Sangue são o preço."), "xml:127");
			
//			assertEquals(getMistakeRuleId(app, "Eles é legais."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "Nós sou verdes."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "As bonecas era vermelhas."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "Elas era belas."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "Ele são legal."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "Eu somos verde."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "A boneca eram vermelha."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "Ela eram bela mulher."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "Eles é vermelhos."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "As bonecas era vermelhas."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "Ele são vermelho."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "A boneca são vermelha."), "xml:128");
//			assertEquals(getMistakeRuleId(app, "O pão e a mantega é saborosos."), "xml:128");
			
			assertEquals(getMistakeRuleId(app, "Nós foi"), "xml:129");
			assertEquals(getMistakeRuleId(app, "Nós não foi."), "xml:129");
			assertEquals(getMistakeRuleId(app, "Ele assiste o filme."), "government:GOVERNMENT");
			assertEquals(getMistakeRuleId(app, "Eu tenho uma duvida."), "probs:paronyms");
			assertEquals(getMistakeRuleId(app, "!Este programa é bom."), "punctuation:BEFORE_SENTENCES");
			assertEquals(getMistakeRuleId(app, "Este programa é bom!!"), "punctuation:EXTRA_PUNCTUATION");
			assertEquals(getMistakeRuleId(app, "Ele ele foi ao mercado."), "repetition:DUPLICATED_TOKEN");
			assertEquals(getMistakeRuleId(app, "Este programa é ( era) bom."), "space:EXTRA_AFTER_LEFT_PUNCT");
			assertEquals(getMistakeRuleId(app, "Este programa é bom ."), "space:EXTRA_BEFORE_RIGHT_PUNCT");
			assertEquals(getMistakeRuleId(app, "Este programa é  bom."), "space:EXTRA_BETWEEN_WORDS");
			assertEquals(getMistakeRuleId(app, "Este programa é era bom.Mas agora é melhor."), "space:MISSING_SPACE_AFTER_PUNCT");

    }
}
