package functions;

import java.util.Vector;

public class C10 extends AbstractFunction {
    private double[] o = new double[]{-41.03250252873486,	-35.70280591875908,	-48.66938576680659,	94.51946988004894,	31.68700466174738,	99.69508270219342,	30.778279925351967,	-31.041222172110807,	-46.21010370947247,	27.26190010072706,	-2.093622677920422,	22.246274570582585,	-42.887366421312436,	89.88377145577851,	-6.731523713182725,	97.86439204258224,	49.49993772881544,	23.210695390854696,	-81.36716857155828,	-20.15688556597543,	36.692155371634726,	44.37408948075327,	-15.984549833405907,	-49.68391424581281,	98.3715576810595,	0.127593155843627,	61.709914317965655,	-84.0189999580673,	-35.39565398431638,	-5.143979333218638};
	private final double e = 0.0001;

	private double[][] M1 = {{-0.040348736997622,	-0.57547478301341,	-0.389765935131311,	 0.140885590781398,	-0.144670835908614,	 0.115450535800564,	-0.518304793509814,	 0.149470047989466,	 0.386138410795004,	 0.145230906380518},
                      {-0.065866355431932,	-0.257122057117828,	 0.298076832606074,	-0.339838329245853,	 0.36335902728584,	 0.69140513648482,	-0.028135015592,	 0.214592766458436,	-0.21337789362989,	 0.150888625576118},
                      {-0.154282201350543,	 0.233990300992969,	 0.196071677766854,	-0.516011967110319,	-0.265721705059327,	-0.060905234855331,	 0.017107816544837,	 0.459602625258773,	 0.548125243387881,	-0.174490925899168},
                       {0.363857337521185,	 0.622123871321307,	 0.051207493885242,	 0.281214293456459,	 0.077610534696611,	 0.38475834924149,	-0.410410905293451,	-0.035659107285799,	 0.245258564359423,	 0.122242429111897},
                       {0.050671935660746,	 0.081648277010661,	-0.034403618638332,	-0.604379533928053,	 0.029715665982435,	-0.255779368776897,	-0.321832198773717,	-0.454789288464763,	-0.04205042244723,	 0.49580649289475},
                      {-0.580165394752893,	 0.155095038022222,	 0.210065625307939,	 0.265731671126386,	-0.481942328396859,	 0.107406464626288,	-0.031135086609527,	 0.076014134025855,	-0.182793563791557,	 0.490558019238156},
                       {0.525119522958187,	-0.007317154673771,	-0.078860784151735,	-0.118095618729855,	-0.388828033497333,	-0.11024307003898,	-0.140281776355321,	 0.496093855143328,	-0.517431971433034,	 0.084650093567346},
                      {-0.221934029584865,	 0.08937666134435,	-0.161579047653623,	-0.202383925865339,	-0.358394121525824,	 0.305489267359872,	-0.319803594563591,	-0.329350210528224,	-0.279367850055518,	-0.604257992994783},
                      {-0.14024729892381,	-0.085950562359788,	 0.562192927749687,	 0.15621897836716,	 0.259175107289986,	-0.401255905586421,	-0.564318107548709,	 0.125407586464797,	-0.135691838706447,	-0.227388734136487},
                      {-0.392433919094433,	 0.338788001793312,	-0.569620515414919,	-0.064134166835177,	 0.436408519589215,	-0.115926326668514,	-0.12994296127687,	 0.36903024504463,	-0.213067396847211,	 0.016735182121047}};

	private double[][] M2 =	{{0.210498733952046,	0.044384555963486,	0.039557467453157,	0.322626150860574,	0.090728331050138,	-0.046559513284792,	0.279058079389439,	0.216086043131122,	0.001910966340658,	0.005653042988124,	0.055129408353881,	-0.157826900224939,	0.126895165086409,	0.21964276539513,	-0.030777527838514,	-0.174795699173724,	-0.071684319926197,	-0.435002022420347,	0.300879515782067,	0.196965690878292,	0.015408513092551,	-0.088767209425526,	-0.056721005316589,	0.004563253603378,	-0.411103445073825,	-0.098798851715865,	-0.017178459384374,	0.223973235768929,	-0.038630814336146,	0.153324298640425},
                     {-0.123853898371964,	0.006208844977804,	-0.196968610000223,	-0.297886862654356,	0.337304789619692,	0.151336922415474,	-0.190737243250796,	0.371272076371965,	0.05154807935738,	-0.089924110414285,	-0.147609151282806,	-0.083802701820601,	0.017052091139248,	0.207360614681,	  -0.014730657062048,	0.030357000089238,	-0.38493302429957,	-0.098471468276102,	-0.24989513579197,	0.265831026621616,	0.039327358400047,	0.102952558500907,	0.112835401766515,	0.075442015984702,	-0.050054414064672,	0.152147800707443,	0.275356821244483,	-0.075104525195784,	0.130811841464527,	0.128154556261642},
                     {-0.247552776888796,	-0.170900469984963,	-0.025609465501807,	-0.074857181493926,	0.06402729466598,	-0.249589575845155,	0.291141404096232,	-0.151955001483896,	-0.182101792706067,	0.177528281451576,	-0.11080027107009,	-0.101265961425373,	0.05885945181901,	0.282705041568106,	-0.075385821998282,	-0.183086148754718,	-0.03660323576297,	0.095170386364688,	0.004340336079074,	0.000556182984035,	0.321477491995385,	0.031769482356446,	-0.111377507159358,	0.532122152715201,	0.088882029439331,	-0.098799193147706,	0.101408217806575,	-0.110636423867126,	-0.211274352044764,	-0.155079279400244},
					  {0.025663646265114,	0.102509721975959,	0.309345681084264,	0.070334750076729,	0.097241604458889,	-0.273266320148514,	-0.239907149554807,	0.150740659614263,	0.069994908090163,	-0.039122490587809,	0.125893036315579,	-0.340093749710236,	0.154051275851787,	0.186934934550147,	-0.25121208048304,	-0.196077026994064,	0.01583365232178,	0.55909380072088,	0.112181997526451,	-0.008728203934299,	-0.217367189352171,	-0.106529307174376,	0.050536269466879,	-0.006551233713265,	-0.045903154193401,	0.167087870245007,	0.002122466601521,	-0.012682827041684,	-0.002595974426726,	0.093386409335028},
                     {-0.096757718998012,	-0.039650722973667,	-0.056221933017481,	0.247299467670382,	0.12500615760951,	-0.129535632819352,	0.037407381782829,	-0.049321379462225,	0.022699926035277,	0.192965409321344,	0.104996464498579,	0.085577579883565,	0.078833431392308,	0.19343561654434,	0.253727682682793,	0.025915952751218,	-0.084868665088399,	0.037854288550344,	-0.393242682132416,	-0.312008732104883,	0.022684882865586,	0.127011588278839,	-0.048595771065928,	-0.309159369729801,	-0.363341449374355,	0.16665805071768,	-0.056515345289132,	-0.298609174881293,	-0.294119559817135,	0.099285471881439},
					  {0.043186472508942,	0.001771226886988,	0.14263426111345,	-0.026446427851299,	-0.042202844595988,	0.229858934929016,	0.192708259881167,	0.454739275512023,	0.078993562199931,	0.012272017371985,	0.208615477072962,	0.0286479351207,	-0.078639302217307,	-0.271449720411795,	0.183880260881944,	-0.221305977752936,	0.090741804187672,	0.221668479563272,	-0.18125553211922,	0.202526121479001,	0.143690682699279,	-0.009428483121244,	-0.138122988901157,	-0.0087984112929,	0.180843519453226,	-0.167186223826231,	0.059308954954177,	0.044175554473605,	-0.451367400847036,	0.155461979668354},
					  {0.208459638473921,	-0.192313493572805,	0.042799453883608,	0.056319917449526,	-0.064050781971354,	0.336443527835829,	-0.024913686145588,	-0.135392681180607,	0.084208982811827,	0.19368687774262,	0.273506736028856,	0.161025819114185,	-0.145878857750618,	0.175226077989248,	0.197067036614125,	0.01612829628023,	-0.266892552385116,	0.294523656999125,	0.111195525470887,	-0.201292974303023,	0.007989116024197,	-0.133381335708404,	-0.05978698001368,	0.163532731543214,	-0.166898927792151,	-0.069407809244429,	0.410416043355545,	0.195220789227849,	0.206696988670138,	-0.030109638400114},
					 {-0.161888866215218,	-0.477833679054076,	0.090201553328432,	0.197276529552719,	0.257525091427261,	0.234933865087851,	0.111554961171882,	0.039671046122422,	0.1024028037035,	-0.275023229663029,	-0.179789894147703,	-0.149367349549056,	0.097199867696211,	0.038487537865377,	-0.102826054337925,	0.041005419958829,	0.071428957044728,	0.133047965356434,	-0.271733080060097,	-0.07745323185521,	-0.074759189714073,	0.047497229049009,	-0.165726777593199,	-0.084379708142798,	-0.046302009416911,	-0.250215681879312,	-0.226883004983199,	0.246816548042778,	0.174568318097348,	-0.215049387958273},
					  {0.163861486371016,	-0.148103013020227,	-0.198506174180913,	-0.04219384123679,	0.118302213986748,	0.022695570191254,	0.206707310041736,	0.156232002478571,	0.093575716314624,	0.487161837511012,	-0.277679678378239,	-0.05898824271195,	-0.101340463707747,	-0.197187024207523,	-0.356221119308529,	0.175907621024382,	0.025724776145916,	0.177555844621935,	0.186546393359421,	-0.011515740909936,	-0.063280757601228,	0.108572545320813,	0.250175342159778,	-0.217188740737622,	-0.118288673330692,	-0.018858445496624,	0.125813534590454,	-0.005766830114285,	-0.173770830530608,	-0.204076434641454},
					  {0.076726374752626,	-0.059157318075244,	-0.109120969315065,	0.281735964889155,	0.113701355600812,	0.057934126040283,	0.056930714392195,	-0.260311629272444,	0.066131852169431,	0.254150636558942,	-0.123595487021829,	-0.068770016151727,	-0.084370591918571,	-0.210531372886378,	-0.058314753673756,	-0.373308427361442,	-0.015030712250411,	0.013086120163669,	-0.210199938641698,	0.044179063442584,	-0.090836039745107,	0.110863603159718,	0.197449444025479,	0.163833987692559,	0.172463370094917,	-0.02624766621562,	-0.075091307788291,	-0.035678286150929,	0.258868590341026,	0.540009857641777},
					 {-0.11448537731886,	     0.158421318146668,	-0.119175728122649,	0.201903441501447,	-0.009316901256506,	0.173542979966456,	-0.234634060687318,	-0.135893056643097,	0.271225318340463,	0.108809056996355,	-0.016309462418078,	0.118496233811428,	0.304052823739158,	-0.007722437001817,	0.094448421400381,	0.034726127685042,	-0.116005525261297,	0.078981290570637,	0.205206605235178,	0.30369188618657,	-0.312746271441503,	0.393986794526704,	-0.195899452039796,	0.20494103596369,	-0.018949028418705,	-0.184962367629022,	-0.079402591539207,	-0.121729951631301,	-0.181982754615953,	-0.156530779671702},
					  {0.162253760728648,	-0.153789438331871,	0.00868657051539,	-0.131911170907241,	0.420552377770407,	-0.216321029385655,	-0.133791045486745,	-0.270383692536091,	-0.113959519847022,	-0.182238016801448,	0.191497999470082,	-0.054919230163731,	0.162994884573224,	-0.222520719869188,	0.021240982443138,	0.090745017688942,	-0.291288801107928,	-0.047608464418265,	0.152396018978015,	-0.070526756136424,	0.048450789083476,	-0.045567922857345,	0.102798772566309,	-0.159656473982117,	0.118251926660962,	-0.430675707603667,	0.10458086074914,	-0.029209095590176,	-0.242559117346188,	0.146082148041515},
					 {-0.054769889978099,	-0.102998778221723,	0.064729032089379,	0.181703388132909,	-0.238051881438163,	0.125211106412204,	-0.301322664395015,	-0.055687348687259,	-0.039615420818266,	-0.10893447819021,	-0.225903659932295,	-0.168752128472236,	0.050214382872752,	-0.209623736459376,	-0.021152472752855,	-0.530138693435876,	-0.134544018857329,	-0.145183011013022,	0.052406331352567,	-0.066953538369538,	0.210839727968681,	-0.005790710509523,	0.040900628077853,	-0.219106039109813,	-0.058779545307731,	0.037152749763887,	0.306738266478922,	-0.155410315881546,	-0.059669333754521,	-0.307937539980894},
                      {0.188677164396131,	0.102763453891941,	-0.392205809826425,	0.023274604305339,	-0.241062713234987,	-0.134335764348244,	-0.156920883882407,	0.118394352690385,	-0.242783527480707,	0.148199620429226,	0.038598382023358,	-0.373777385965017,	-0.079990650844341,	0.109379832985269,	0.276235130978874,	0.000424181313047,	-0.1581803206613,	0.194537934564581,	-0.112037113974561,	0.092669956020601,	0.151181460492394,	0.064779413736991,	0.03298441610138,	-0.105713078293658,	0.026477488720875,	-0.301872238837486,	-0.304572846125097,	0.129303116825904,	0.150275305655397,	-0.143819273917584},
					 {-0.121136819961029,	-0.280376857590378,	-0.142884824324944,	-0.234336987516145,	-0.27318548804741,	-0.062906552289143,	0.117125592225031,	-0.111153019559446,	0.170636020457398,	-0.049474387767955,	0.250337970843838,	-0.015737111315197,	0.303098653510777,	-0.031695841766391,	-0.018294649882712,	-0.004853390742363,	0.288923483741941,	0.102932886997556,	-0.030117891708216,	0.348873109957197,	0.107864455557603,	-0.053217559061395,	0.155554070063422,	-0.131389140271268,	-0.306220365198726,	-0.153022880982604,	0.128394915701578,	-0.254920058505309,	0.228391386551728,	0.124793864045053},
					 {-0.085458356559741,	-0.06749024827502,	-0.243684986433717,	0.195223151576616,	-0.056144203577952,	-0.107022717570903,	-0.119766313023139,	0.21180214818079,	0.286641525002163,	-0.256687343688466,	-0.016698212375744,	0.168676200561914,	-0.300510419700627,	0.3859169863873,	-0.025097350370833,	-0.064878242312045,	0.223840463303938,	-0.013692765327541,	0.191347293229108,	-0.221476004310888,	0.014539395850687,	0.108928515315896,	0.2763380292334,	-0.022071088238979,	0.190680276913542,	-0.305290419919566,	0.107640319223234,	-0.104538877590241,	-0.084705533603217,	0.108822927690725},
					  {0.359256748293047,	0.154976198577344,	-0.116153265766918,	0.13931677738968,	0.374496005165856,	0.178417709752365,	-0.020215045948477,	0.0511359434473,	-0.30173528700312,	-0.216545463965152,	-0.113137661147475,	0.186762444883836,	0.040082745946815,	-0.053364283388025,	0.065488033743007,	-0.033154988554239,	0.317998692979354,	0.247815755943833,	0.126243283202638,	0.038451263306162,	0.256900869660439,	0.043331197504268,	-0.051702015143296,	0.115290293077177,	-0.162878255904405,	0.042941144091639,	-0.0273285865418,	-0.345298257763101,	0.15936874911257,	-0.076890125653739},
					 {-0.28099424578992,	    0.107396814515739,	-0.084563105000033,	0.251259020314969,	-0.046244227618743,	0.194849917362354,	0.105731360526473,	-0.116729435444227,	-0.125871612130733,	-0.004143188817115,	0.031303723499165,	0.193842070959737,	-0.071047584389393,	0.163798237107731,	-0.33103883422486,	0.083042404997121,	-0.314536638066646,	0.1850656428806,	0.139857282060989,	0.258138857521682,	0.241402804816099,	-0.267773012822818,	-0.136618598358345,	-0.352889529882469,	0.178761358680642,	0.004675588386463,	-0.130523685747766,	-0.11010510100568,	0.012337514111924,	0.133039188998738},
					 {-0.136214748186763,	0.061446441408168,	0.124443001628158,	-0.384194680239079,	0.161386673633437,	0.05151848059208,	0.050237897866986,	0.092332554624287,	0.025301015752734,	0.144267170372807,	0.177218756700414,	0.330110661903483,	-0.032723550578364,	0.032862846981569,	-0.039329546595698,	-0.479455648611786,	-0.142384919826993,	-0.00804128544337,	0.153527223636046,	-0.147592550588846,	0.01671488256034,	0.153461668336777,	0.143391962131602,	-0.1032423296903,	-0.127806420761444,	-0.112212283814506,	-0.419393741016172,	0.011554752050117,	0.174489436742579,	-0.152583142805368},
					 {-0.183525414815911,	0.084264423476034,	-0.513582573163132,	-0.060641305770964,	0.096244159556264,	0.049715888666474,	0.311001693872411,	0.001259440460654,	0.036651495187505,	-0.187364828692437,	-0.017792472149735,	-0.108962196548542,	0.106923649625955,	-0.137418200183617,	0.231554866808663,	-0.211864650236558,	-0.056173351885998,	0.108205208097382,	0.152251721125532,	-0.172564127758839,	-0.379707703841598,	-0.399495209658996,	-0.017301373440465,	0.016739053799758,	0.035848677241745,	0.150058535685014,	0.019465311724744,	-0.030054112339037,	-0.049980094722222,	-0.078081830537862},
					  {0.061058425410664,	0.042041509977416,	-0.211003741431923,	-0.126388800908604,	0.039219152461988,	0.225495863827954,	-0.366358041819373,	-0.190018182245224,	-0.135422744295414,	0.106462362604256,	-0.028597656153562,	0.151442873263496,	0.108762194743749,	0.202895035408, 	-0.220198514387979,	-0.145116392843135,	0.287960518621411,	-0.046429895952516,	-0.236435128849732,	0.064337841563859,	-0.044861474741858,	-0.323541240367847,	0.116777979642275,	0.058194390691809,	-0.143859430803049,	-0.058357266848021,	-0.06663691339304,	0.323975481839132,	-0.363821240073463,	0.025044920981486},
					 {-0.189525638545991,	-0.006677446894394,	0.040135587178237,	0.030562197515064,	-0.081557175019313,	-0.35988601916995,	-0.046748366964196,	0.052796424347975,	-0.293965333147152,	-0.107256786396328,	-0.266428993150317,	0.331112621223704,	-0.3240691448606,	-0.183930905848232,	0.033931266862913,	-0.056733070481899,	-0.071906584046074,	0.165910393063134,	-0.066596131882292,	0.187535095996836,	-0.282573695097042,	-0.012822431812993,	-0.130628684496259,	0.019603565202997,	-0.36530186945985,	-0.218948877174082,	0.15928161680357,	0.117469132881907,	0.02739594774293,	0.086724839893498},
					 {-0.046415954902964,	-0.160644004446126,	-0.033524440660352,	0.07500744681351,	0.016322145454599,	-0.107804845719038,	-0.239974742220443,	0.045234085507995,	0.410025327436819,	-0.041785955831231,	-0.088824232512646,	0.019324971910103,	-0.164179563969319,	-0.274883654548913,	0.08344816321592,	0.134361131744622,	-0.168293304036166,	0.050119827090831,	0.107998968576299,	0.024222465405286,	0.333568438641683,	-0.314273943234102,	0.088627173413873,	0.307987145180008,	-0.25957029953184,	0.139693331842536,	-0.366318566467329,	-0.024315207215651,	-0.097866140810133,	0.031984120313315},
					  {0.414611908814294,	-0.37112136873643,	-0.073866553818035,	-0.29087757946088,	-0.217072217367287,	-0.029123302474621,	0.010661588246943,	-0.056648186984039,	0.052448395670158,	-0.125771363235671,	-0.323377762528554,	0.103065249994115,	0.03990538947911,	0.20892679696363,	0.025498721902253,	-0.133437428932213,	-0.116769147892009,	0.075000348696883,	0.147043486128104,	0.012254394305512,	-0.070162283643009,	0.104480173528188,	-0.343231962242353,	-0.124041674266431,	0.079443082346753,	0.192704701695008,	-0.169380089268582,	-0.054285719705745,	-0.145500023209769,	0.255395103787066},
					  {0.207119315322088,	-0.320073115712564,	0.0559314734117,	0.172649138634129,	-0.011542461945528,	-0.130620764160256,	-0.10888053008216,	0.267564406009138,	-0.120890663229249,	0.202202465644977,	0.149425179881808,	0.216934380895458,	0.065653150449446,	0.041794472366999,	-0.048128520065833,	-0.017549459873998,	-0.077842831218385,	-0.198170596730465,	-0.149865167620775,	0.12634718117617,	-0.30097962077431,	-0.356324559219511,	0.015984934796442,	0.112407601721805,	0.237966910014296,	-0.056653284700555,	-0.084496688943403,	-0.372456205768623,	0.097560810635958,	-0.241013145399317},
					  {0.042993730292494,	0.004956761653254,	0.053895052194156,	-0.088854185716889,	0.326910901526066,	-0.087794341394476,	-0.020802090219748,	-0.298708928515842,	0.25242600994189,	0.101197681470221,	0.07152866676548,	-0.181921564652412,	-0.505149592427631,	0.143193361309159,	0.186981040042569,	-0.133652828493287,	0.200265248087893,	-0.073752726703129,	-0.000238503991611,	0.374550360408052,	-0.050281630947108,	-0.092458775511721,	-0.205541771113341,	-0.211350594454595,	0.048295879169752,	0.061913849844292,	0.046521349189447,	-0.065574597414797,	0.000727202776555,	-0.214369198817042},
					 {-0.372708113027754,	-0.273111422565572,	-0.028044496936687,	-0.031315545207917,	0.128692442270306,	0.103912301156068,	-0.317409754881132,	0.193362522820359,	-0.263946940397186,	0.328539161755314,	0.014885444611456,	-0.135231025676715,	0.012770730354147,	-0.056470973842145,	0.187010128145666,	0.06551126700651,	0.264488080744978,	-0.092362300447396,	0.374463443107909,	-0.114265316590068,	0.014321931394336,	-0.014287975486322,	-0.251977653040875,	-0.068814134318263,	0.037272928895606,	0.036847910078949,	-0.004344868007102,	0.000682914575515,	0.075677153681488,	0.26759596689543},
					  {0.064818689916455,	0.284053411520265,	-0.063930667567762,	-0.055888531296039,	0.084971324574045,	-0.248553864049376,	-0.053882957221272,	0.109974358415086,	0.361665795220151,	0.212622412400492,	-0.222105881590724,	0.159407186211676,	0.277766857748719,	-0.040024212790115,	-0.045419517646103,	-0.049565963430445,	0.075309844691921,	-0.01462002387698,	-0.125901695229838,	-0.179360862877057,	0.201763873122918,	-0.220450927984847,	-0.414575162457279,	-0.112162765618009,	0.098487134259606,	-0.239965053948616,	0.170255100801187,	0.078980100492884,	0.243403068580785,	0.021368523436668},
					 {-0.054279013736138,	0.018659420049998,	0.330359950213943,	0.023123143363581,	0.035090878248845,	0.025527653285977,	0.082763577820282,	-0.044575644917522,	-0.004626086242742,	0.103520181686413,	-0.432497376883502,	0.119032674935153,	0.236464940348734,	0.185294902781396,	0.510006376075268,	0.054475637131684,	0.021019631752974,	0.107026280159219,	0.091553865611036,	0.169591926725838,	0.02088417330554,	-0.183147177835376,	0.427381645911547,	-0.13187711537175,	0.138348964310852,	-0.037276342733556,	-0.010728013977158,	0.085070861966194,	-0.008940851260341,	0.001071606497694},
					 {-0.001220559638941,	-0.207365392796594,	-0.23185510790523,	0.208482953784606,	0.122000548923194,	-0.322922674036945,	-0.041150767726355,	0.035241090632951,	-0.012254747396228,	-0.030675366498019,	0.216247246460075,	0.297863251529541,	0.168847156819068,	-0.082183953429559,	0.065957904193529,	-0.09572234076031,	0.040748898076806,	0.06592096841622,	0.028275231975731,	0.180261847132564,	0.167295789767305,	0.208499007714482,	0.06073181729704,	-0.09136260314961,	0.195634463938498,	0.405036010088252,	0.090356343227339,	0.443504939597125,	0.041746547462442,	-0.143522086623263}};

    public Double f(Vector<Double> x) {
        double[] z;
		double f;

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];
		}	

		//Function  
	    f = 0.0;

		for (int i = 0; i < x.size()-1; i++) {
			f = f + (100 * Math.pow(((z[i]+1) * (z[i]+1) - (z[i+1]+1)),2) + Math.pow(((z[i]+1) - 1),2));
		}

		return f;
    }

    public double violation(Vector<Double> x) {
		double[] z;
		double h = 0;
		double[] y;
		double[][] M = new double[x.size()][x.size()];

		//Setup
		z = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
		    z[i] = (double) x.get(i) - o[i];

			if (x.size() <= 10) {
				for (int j = 0; j < x.size(); j++)
					M[j][i] = M1[j][i];
			}
			else {
				for (int j = 0; j < x.size(); j++)
					M[j][i] = M2[j][i];
			}
		}	
		
		y = new double[x.size()];
		for (int i = 0; i < x.size(); i++) {
			for (int j = 0; j < x.size(); j++) {
				y[i] = y[i] + (z[j]  * M[j][i]);
			}
		}
		   
		//Constraints  
	    h = 0.0;

		for (int i = 0; i < x.size(); i++) {
			h = h + y[i] * Math.sin(Math.sqrt(Math.abs(y[i])));
		}

		h = Math.abs(h);

		//Mean Violations
		if ((h - e) <= 0) {
			h = 0;
		}

		return h;
    }
}
