package problems;

import java.util.Vector;

public class C15_30D extends AbstractProblem {
    private double[] o = new double[]{-31.718907007204272, -39.536680684207184, -46.033718058035944, -42.2004014684422, -28.331307546159135, -38.64403177375364, -11.313371899853626, -11.717383190039943, -43.345049558717875, -31.46016185891229, -35.57742732758397, -45.49638850141341, -4.177473725277878, -26.974808661067083, -46.30991533784743, -45.997883193212814, -29.479673271045964, -4.336542960830036, -43.66244285780764, -22.43896852522004, -25.89273808052249, -24.221450510218993, -30.3952886350567, -31.170730638052895, -9.859463575974534, -16.727846507426452, -44.35226340706524, -33.10843069426064, -7.175153678947718, -4.601421202670486};
    private static int dimension = 30;
    private static double[] domainsMin = new double[]{-1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000, -1000};	
	private static double[] domainsMax = new double[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
    
	private double[][] M1 = {{-18.785768809450733,	33.616954860437176,	26.882113915382682,	-10.43306419742936,	 0.944892894082476,	-3.353896433259691,	  3.535212733907637,	 7.394276941396782,	  7.790908752641235,	2.091292109983567},
                      {-0.38080580880289,	10.420967284673154,	9.347291913115678,	-20.926490513724943, 11.4259031588907,	 1.10563725749954,	  36.87928250597037,	-1.910339780463472,	  7.56116849320932,	   -9.743066435789972},
                      {-12.341688082549489,	6.362199355273804,	8.248429939792464,	8.089256366417835,	 0.069234506619011,	 2.578624135957486,	 -0.497340218618186,	-2.062722095484327,	  1.430205147745766,	15.52200376094467},
                      {-17.00654251044467,  -12.679306064055677,	51.65812051951116,	-3.97661207806369,	 3.934938475013658,	-30.777202564613845,  6.146597147627116,	-11.404959107806402,  12.694206030880832,  -9.395143228117439},
                      {-5.484749154282662,  -13.643476981518553,	-20.8125786035429,	12.48063177681885,	 0.844978205995699,	 24.830393330514045,  33.83850518570256,	-17.003569707093064, -5.293964367404844,	26.065703095424336},
                       {11.422878520470586,	10.221461943150496,	-5.999478987400263,	-8.935891602574142,	 3.340791625151446,	 3.924548854255449,	 -6.760571785727851,	 14.016300477765046,  2.353396935795215,   -15.957358828479556},
                       {14.1069797350053,   -0.689797572922294,	25.92835826668488,	-30.138271725378775, 12.953067028884863, -17.125782201118525, 19.122903237509483,	 3.85021017121606,	  14.44987126033593,   -37.768641488073015},
                       {1.817162027385162,  -4.52289774299815,	2.596064824368431,	-3.077970366333548,	 3.666238380627702,  -3.142271967105208, -1.93910379576585,	    -1.132846020949443,	 -1.459397119228072,   -4.385065305078107},
                       {17.05963501513677,  -40.88734304067851,	-9.04136854737176,	9.207816613351653,	 2.483559081696921,	 -3.135238286666343, -0.515970843448524,	-10.448164970351954, -3.97908386413912,	   -5.010151763870892},
                      {-2.100410473384162,	4.285743492212902,	18.13880373052391,	-5.569156622351854,	 0.020414928764168,	 -5.531568307180828,  1.750746232557792,	 2.018382353850689,	  8.96737078655512,	   -3.593654241962948}};

	private double[][] M2 = {{2.511190264603399,	8.257741094092125,	-4.576972024334265,	11.663051871013478,	 1.839271199160904,	-3.930477981638431,	 6.381869129516557,	 5.554163663846647,	 3.792259995720394,	-8.119579509114208,	-6.749873116676933,	-4.16744839268803,	-5.247229107097693,	 4.380091021522936,	 1.636265206648646,	 1.545744455341335,	 6.729651169519672,	-10.841704025647012, 5.27133366266056,	-7.315142457952093,	 5.586455189183544,	 0.134360209805352,	-4.757951297029205,	-7.494064226166734,	-5.71422876353246,	-3.494974588660678,	 16.86892010541546,	-6.058600435639238,	-11.353403083342686, -1.092357620889664},
                     {-1.176252081542598,	0.194672319059377,	 9.262321627779777,	-4.877620455960017,	-3.013825305151295,	 4.138941347418219,	-4.381399078195643,	-1.095599959738453,	 3.362553950833766,	-2.415178728944297,	-6.861613142354518,	-0.005940467288075,	 2.135933445957106,	-0.307275749657439,	 9.502954614655595,	 3.789220991977143,	-2.76964275770075,	 2.672716708411572,	-3.374116812054481,	-2.041106775198442,	-3.340247070143979,	-0.837499094352104,	-5.259049047845686,	-1.521493877085425,	 3.560245065816806,	 0.587849049777596,	-8.24965720380312,	 1.577881184618359,	 2.56392435402041,	  1.537958604481863},
                     {-1.308581228315848,   -2.050371351098398,	-3.874959824774145,	-2.136018990593701,	 0.425374281070453,	 3.043654044666869,	 2.852463840006697,	-4.609692730685587,	-2.676989994934014,	 0.018654380314467,	 4.1843245155883,	-2.941454921101105,	-9.0702547942116,	-2.890167502434176,	-6.517087530456076,	-6.458220473167814,	 5.214757843970958,	-5.672828398157034,	-1.291826775778004,	-0.425237758250728,	 2.004256913177237,	 7.010207042020759,	 3.245852998964355,	 0.975852195193769,	 1.406362603904871,	-2.052462316198574,	 2.872078581244381,	 2.445851054572349,	 1.108924529459803,	 -0.260629199129536},
                     {-0.691301322822554,   -1.994532314862069,	-8.604754485993125,	-2.97610726321536,	-2.546281717050659,	 0.13089272819699,	-2.095263510257371,	 3.356968437392792,	 0.259978867749323,	 5.401823223841656,	 3.061295803499265,	 1.403978462555566,	 3.459625904755164,	 0.875144781306571,	-4.037867043038509,	 2.69814135487501,	-1.046480563223284,	-0.162120818498023,	 3.972120681919849,	-0.360095886115473,	-3.590431022975543,	 1.135744786203014,	 6.085551336331358,	-0.306597750598646,	-2.349583036995845,	 3.903939972739528,	-1.48181865824383,	-2.878395159465752,	 7.258503538363769,	  4.796644771310021},
                     {-0.444232081955838,   -3.571385678786192,	 13.286045625307453,-12.839633153682575,-4.489679872696604,	 7.869013641543565,	-1.965105477391064,	-8.636636350365924,	-0.094822649845242,	-10.673493697992319,-12.53156986402604,	-1.854979185138595,	-4.845831775303889,	-3.303193299843544,	 14.504105531464209, 2.590044768433951,	-6.135686158996087,	-4.270904315841696,	-6.861683086853831,	-2.744870140116196,	-5.102676391316569,	 5.943125003510186,	-8.766966677691988,	 2.000662359536807,	 0.48220557102434,	 7.450887387478847,	-10.45013256174983,	 3.625933262996068,	 4.179177543735097,	  3.98247679713907},
                     {-10.464299208072154,  -0.185820260985436,	 6.552041396672776,	-5.911945191669922,	 8.168937620030086,	-10.982208830632558,-3.00135846456146,	 2.912065997677753,	 2.671937505436929,	-3.256558888247419,	-1.010981945614573,	-8.18916926806801,	-12.001606012082647, 0.565140546704374,	-6.816130902986662,	 7.034212706943163,	 12.40601107576485,	-14.537675875626526, 1.401546347401862,	 0.070761477781216,	 5.173018588042309,	 17.500331178638167, 3.097673254889692,	-4.026635320023784,	 3.007819170833911,	-6.986787465181084,	 6.394195915881141,	 3.687826212758699,	-10.500866576776128, -13.151879796730649},
                     {-5.781123825040053,   -4.695427919915561,	 9.384139425829048,	-7.575211154097536,	 8.514278328525183,	-5.720630545110835,	-3.828493595935516,	 5.90998861394398,	 0.148907769173485,	-0.631185579095166,	-7.572076478194538,	-3.770557393047349,	-8.178577514209056,	-5.098256869553833,	-12.07105725371895,	 1.248737932444238,	 0.478544192523777,	-8.678825875969533,	-0.946209858630089,	-0.78972756845699,	-8.64978321329506,	 2.485419664365408,	 12.153488342644684,-3.062242328783848,	-0.170370275829816,	-2.093524789628705,	-5.15404262324049,	 4.508277504607992,	 1.61064781893081,	 -3.274879887486953},
                      {2.268818310206689,	7.300452401745146,	-4.331575628327129,	10.74428874720899,	 0.15049273777556,	-0.522703831910356,	 6.686183057924437,	 3.782219973575128,	 2.188704155720839,	-8.966284106856413,	 7.937092834912006,	-1.31567415453634,	-3.395220022143096,	 1.559847175500902,	 2.78883479224772,	-2.138994752636062,	 8.323858134206022,	 1.103349691459627,	 2.080995858068952,	 3.671907915458957,	 10.73018786831511,	-0.786574921144261,	-12.077147983799486,-3.200483300835418,	 1.964680859010843,	-2.657000417145831,	 12.549412268552729,-5.048053145262655,	-8.92560318109584,	 -3.291078633192861},
                      {0.041055194191982,	4.198164286592344,	 0.380892004577647,	-8.23942251831774,	 4.779957612796264,	-3.478785140983899,	-4.340229693544734,	-1.26961685769858,	 6.146810236016467,	-3.071864805992567,	 0.971337912956829,	-5.896120164000506,	-0.757550831858382,	 0.878200934289778,	-1.532518943062243,	 5.844371522790389,	-0.837014728066397,	-3.907278737140878,	-2.030173016623314,	 3.202676786182734,	 1.470137096717735,	 6.858775309836105,	-5.751687072684216,	 2.261109122092457,	 5.446233047509159,	-0.994575214031629,	-4.198066474981203,	-0.916283719062444,	-4.341766414322003,	  0.660003095340524},
                     {-4.758805234887069,   -1.249096368305273,	 5.230241683696193,	-19.44236789411332,	 3.990165558570265,	-5.21678532927235,	-4.960118855176376,	 2.113664727176411,	 0.365246740004055,	 3.670941659701974,	-1.914288039871711,	-6.094333718753953,	-2.682967627659987,	 1.227422326532798,	-9.433645672535167,	 4.96643787530529,	-3.616907241245708,	-0.145552345328748,	-2.280394788413511,	 2.265409089297554,	-5.317818474692691,	 4.356958717932082,	 9.75139488271248,	 2.184418024240871,	 4.551729219908339,	-3.203937519303825,	-8.161877539527412,	 9.881964507838315,	-0.942679393999977,	 -4.09075977260806},
                      {5.895714456877837,	5.673958378336709,	-7.551189095277389,	 8.6763663921392,	-8.74212847286295,	 7.876941413449155,	 6.186314942878492,	-1.385292259378321,	 2.339350501494244,	-7.303402814099851,	-0.620345906721456,	-3.21480044327725,	-0.528558678306147,	-0.327651725159052,	 6.60017678920534,	-4.030480514390237,	-2.74819741682516,	 1.131719959794813,	 4.041615304275,	-3.807276819902737,	 7.174795405973731,	-7.105910692661075,	-16.16824790535485,	-8.490742807482299,	-1.205275569694925,	-3.213783451897369,	 10.19460083362542,	-8.1537702193513,	-3.34614228867147,	  6.852576635102674},
                      {5.050755100515472,   -1.015084166538332,	-4.488951762662663,	 3.071909362047136,	-6.309214790805194,	 4.607171586689359,	 0.518771985931275,	 2.576207604994254,	-2.538951540887637,	 3.871170428002043,	 0.86099787829018,	 9.333192517131101,	 3.898241746958841,	 2.045637143082407,	-4.632172666627585,	-3.251052343878506,	-10.340844584872428, 9.938362935470167,	 2.681875064667896,	-0.30928871960663,	-3.553804690623363,	-11.909220170048043, 3.407795649838816,	-0.852234992909218,	 1.470543694236073,	 0.018651383236502,	-0.400939937078999,	 1.006604199340888,	 5.546567833598792,	  8.936287451220219},
                     {-2.296736642073308,   -7.507685960269931,	 3.878804185286892,	 1.927870783876082,	 8.606052457582582,	-4.902250427177561,	-0.369415251862622,	 3.771105898431047,	-4.497236148553519,	 6.92064424996612,	 6.555606653106257,	 3.979481264635631,	 0.551670017289274,	-1.250380372234189,	-11.577926205347564, 0.98949362466787,	 4.643449205576342,	 0.039903009834915,	 2.717889467266028,	 2.628829050189848,	-1.391097858187011,	 2.040534828877561,	 14.571897255676616, 1.64579970252636,	-0.601128848469179,	-0.840404796582696,	-1.463197992681945,	 3.202376802222665,	-1.671176838446732,	 -3.3759766251534},
                     {-3.937515676606634,   -3.139929919295693,	 7.06320923587761,	 1.809248475068868,	 8.870247836692679,	-7.116279757514643,	-0.561569800957993,	 1.607623766047816,	-0.442980337701897,	-5.392629763518957,	 3.253312934476978,	-0.53910491395161,	-7.500926900397016,	 0.980573085142957,	-5.634247758036995,	 2.236908157606175,	 3.147822704551946,	-5.937762475731414,	 0.887239059660158,	 3.778662703078195,	 4.579851636624116,	 9.68224407023739,	 0.005007990083924,	-2.066608587954049,	-2.840100747113819,	 1.07267047086035,	 6.107120400203828,	-2.014818439278602,	-7.165823950693442,	 -9.272074819149603},
                     {-2.680240010855875,	0.356004349959002,	-0.414456907621788,	-0.067764618278143,	 5.320643303727243,	 0.737875437883548,	 1.213668435898487,	-3.145814327985767,	-2.507697183673514,	 2.536104038824088,	 3.558431317438912,	 2.131159153330951,	 3.764201252276733,	 0.816204397371172,	-4.632956423959657,	 0.184120289127522,	 1.217433374070159,	-4.036068485529014,	 2.258556949877698,	-0.910082542366675,	 3.754187256312381,	 7.457650756177197,	 1.456847256376522,	-1.608612250250221,	-0.757648771963665,	 3.790322347324032,	 0.887040099051261,	-6.027791111032598,	-0.328191702726934,	  0.866002766609515},
                      {6.578208237675698,	0.818410293291321,	-9.288863917296439,	 22.14413550757907,	-5.223269252930489,	 1.804141126348005,	 6.924767448007314,	-2.776780120617464,	-2.494384185627731,	 4.743636200841757,	 2.69082215234061,	 6.088855334101281,	 0.981039450131136,	-0.123672950299567,	-0.140131828740133,	-13.797914058713273,-1.914030716314594,	 1.35605332601434,	 2.48584096184779,	-2.669304324669153,	 2.289369793279759,	-12.59957022859263,	 0.93847348962723,	-3.000750651813473,	-6.748464919761018,	-2.998991813272391,	 7.50927404965129,	-4.712789813740673,	 2.583974262309686,	  4.259407321635679},
                     {-4.302432019312597,	1.030219160973822,	-0.035401401034044,	-3.864603659100286,	 11.181713062447539, 1.799128842154124,	-4.632382202673897,	-2.780991517575134,	-2.531316968742212,	 10.165545659183975, 1.550622641761506,	 5.402782921171298,	 7.066734336942432,	 3.559465053224369,	-7.838510786198628,	 0.872794527931054,	-6.729399256798964,	 1.851943659950421,	-3.17302307338725,	 0.303477456308984,	-7.294328632117977,	 0.431243357642238,	 12.108553118909567, 2.785512313731942,	 3.951422589853138,	 5.216571541524427,	-14.01807799640241,	 3.680618250481408,	 10.312528175880152,  9.072426201364811},
                     {-5.532986492249091,	1.368157626742091,	-2.996278911375891,	 1.180587738377175,	-1.172736098947577,	-3.033440537456964,	 0.240827440148848,	 1.274554856316978,	 3.664070614586986,	 1.450239057462672,	 0.43774922918318,	-5.139121137322196,	-2.184239731700786,	-1.722673663384784,	 5.003903006525603,	 1.555677376370723,	 4.592628073610951,	 0.031529946446351,	 1.962038675057533,	 1.311519327333439,	 2.97144042923956,	 4.358628571380574,	-3.02091040718656,	-2.026289674016738,	-2.179100342988682,	 0.199561404454555,	-0.642268764969934,	-0.48430217469127,	 0.867697193885426,	 -3.428256695897337},
                      {4.749688683748538,   -3.013096235466324,	-0.896473471506158,	-5.404408901826174,	 3.25190012448197,	 4.700501169041437,	-0.485841922084629,	 2.129019854577554,	-5.743986607455017,	 5.05072704099386,	 5.290426760843522,	 10.017074714718186, 4.109783454482344,	-2.171588999232304,	-9.143973237995885,	 2.158096752256321,	-4.288300573083361,	 8.440796859622568,	 0.622933708201643,	 0.366857770589574,	-5.372666211859802,	-6.422211641960874,	 12.41021882450194,	 3.749357041671196,	 2.769912683036556,	 3.508222243674678,	-5.740173772592829,	 6.606652001961278,	 5.630677773801195,	 6.253155297611987},
                      {4.559034813600619,	0.191335026648024,	-9.72469888506327,	 16.676435885179576,-11.815244699143054,-2.963619615334862,	 2.644195062564698,	-3.504534753584204,	 1.539473850852911,	 3.24795330924284,	 4.136178478443613,	-1.415042231009744,	 0.180777361594801,	-2.516794720186608,	 6.160828524988144,	-6.794575512958723,	 0.075817729728995,	 0.72736717628741,	 1.668305542072184,	 1.253458327957929,	 7.270581180009739,	-5.020680731171347,	-10.710260791368778,-3.482314899976028,	-3.159956937857408,	-5.264233710547034,	 7.244641579264396,	-10.641144576600027,-0.028015125221679,	 0.21956976936331},
                     {-2.551308504381034,   -5.624763316256503,	 5.82275011984547,	-18.83984795424589,	 2.287665332808314,	 3.202650930764413,	-0.143157181428193,	-1.939337105017224,	-7.297486396599838,	 4.714811455331595,	-2.285923849103187,	 1.571914512358247,	 1.18868883861133,	 0.665125048665022,	-3.62112489105088,	 7.315055227559002,	 2.59208112683563,	-3.604968061282964,	-1.269251512788574,	-4.603628537664914,	-6.186864603084382,	 8.62584019419564,	 15.640620254332642, 9.339712043883617,	 0.70056492461347,	 8.033185101455041,	-8.984569662115023,	 8.756788125840803,	 3.000294638756253,	 1.55270194363742},
                     {-3.861290375479539,   -4.675448372631536,	 9.251215593601152,	-23.607840924556356,-8.695565550492798,	-2.989076129194713,	-4.739435400680438,	 2.835678457877207,	-0.098166653883445,	-12.599368055638564,-10.371683803332736,-6.880266107606954,	-13.323520170751154, 0.836643098136934,	 5.174040794619552,	 10.49263721553011,	 6.802053133291294,	-6.116168624020712,	 0.612168202208346,	-1.561678744412428,	-2.961017400369882,	 14.555633724082611,-2.408921040101399,	 4.164763222501917,	-1.288537113083328,	 0.52492159991554,	-0.419743809901388,	 6.847306921165118,	-2.417811780641292,	-7.702891475003848},
                      {4.161137142387705,	1.482037717792366,	 1.287113176047423,	-11.780576083757202,-13.704438843176279, 2.252970644465878,	-4.628978648000722,	-8.44852567895537,	 4.501241923053804,	 3.218082210067639,	-9.096692746700437,	-6.359766478822383,	 2.458766877052462,	 2.747239663468253,	 11.352826871439879, 1.690071756894771,	-4.94464758404481,	 1.287478245120863,	-5.514465163301222,	-0.436320463384376,	-2.460885613501708,	-2.766872615896895,	-5.244256957948294,	 3.839764805067356,	 1.974486773795782,	-3.850467595501656,	-5.719184031653332,	 3.112555194710462,	 2.191998679485594,	-0.13026077572474},
                      {2.105310692725196,	0.544816987896791,	 1.846346039423678,	-0.509784805488332,	-8.19139781918348,	-0.226849791351708,	-3.085179788781892,	-5.699211118481947,	 3.293594390108838,	-2.909444711189409,	-7.764958328853763,	-1.166897030507534,	 3.020313808115756,	 6.799166924533074,	 10.7746541697421,	 1.525039302686581,	-7.554231411053715,	-0.587013107919599,	-1.300759655302306,	-4.080716282648349,	-2.186465568681216,	-2.406484706468079,	-6.958047179121224,	-3.235753723041708,	-4.304227928343334,	 0.206370537347841,	-2.625027214135385,	-5.715311685851154,	 1.3755895996309,	 7.31396280189546},
                      {4.460614374892582,	3.19529761978484,	-8.190318873976533,	 17.720929604353678, 1.079903507675288,	 4.032046572169589,	 6.846170634331792,	-2.990923968785385,	-1.01384879195201,	 4.210550185586089,	 0.764711025819911,	 6.307647053631859,	 6.791811206494187,	 1.358857762637734,	-1.624613814301878,	-10.150256933841442,-8.955086516370987,	 2.41129571860055,	 2.991835863170325,	-2.084105485259767,	-0.387882836033353,	-12.037911290804784, 0.784781445004331,	-3.51258593199461,	-6.358051224678802,	 2.354270933909405,	 1.762978551917006,	-7.508929712507494,	 4.153956520027669,	 8.430589071222315},
                      {0.112995451436564,	0.371936786139806,	-7.025568330781,	 9.769013689448464,	-0.640793257766108,	-11.677067837314976, 1.451572748927877,	 1.171502164469018,	 1.692647658091279,	-0.881205326796837,	 4.268282553052323,	-5.637459471007516,	-4.897450001353112,	 0.171735893079777,	-0.9211330468045,	-2.490514871584582,	 9.607046944744821,	-7.206797204798768,	 4.349647727744751,	 4.621339140117586,	 10.832359506208546, 5.100626759149631,	-4.076131311364439,	-0.932775487935339,	 0.50265512140222,	-8.6858164471001,	 15.294166113376837,-5.994248698329602,	-11.694453405846096,-11.801285777570579},
                      {3.672120136902007,	2.62662795338849,	-6.295270647326517,	-1.069859934951232,	-3.811330299405138,	 1.594900688552953,	-0.822649421610342,	-2.996102354897966,	 0.011410712161871,	 3.804973955584018,	 0.29095969601554,	 0.154412566421657,	 6.009123692794804,	 1.048840941857638,	 0.1142053347247,	 1.041139886749876,	-1.766488251223224,	-1.232261508678568,	 3.296071326639848,	-2.373608140335303,	-1.250158758539599,	-0.720873134553766,	-0.615677318700518,	 1.403259047870607,	 3.005529442348132,	-1.215626145907597,	 0.042094269477194,	-2.231879359014662,	 1.611360878893429,	 6.469735186892669},
                     {-5.818552929715837,   -0.916929571232854,	-0.366611990060092,	-5.12995032472354,	 6.905064130414796,	-6.544579871223458,	-7.16220048221164,	-1.218392721965018,	 0.028386972148047,	 13.304659303178061, 5.212031101975595,	-0.198414575621711,	 2.043938045553383,	-0.295480321457095,	-9.738766031154933,	 4.373893439532715,	 5.133821298601127,	-6.818797238217159,	 2.032166191824439,	 1.299068415608013,	-5.282486677908174,	 8.79704452443048,	 12.849891231025046, 2.787156804154204,	 6.225881805493842,	-4.429387659772509,	-7.4036051874247,	 3.478946685666019,	 1.632891481413625,	-1.105751993528384},
                      {3.486878591381191,	2.633938629834198,	-3.834544259817514,	 6.338661537296378,	 0.08440220487435,	 0.891537452927858,	 7.386752241464462,	-3.143341265990022,	 0.17569569189933,	-1.189840684944929,	 2.063745656499299,	-3.873741753209196,	 7.631037421790815,	 0.870407519991694,	 5.416923136109038,	-4.796174802688587,	-5.441484022053353,	 7.113220057014851,	-4.021007101784125,	 1.093337823554031,	-0.723713415910556,	-11.778856908851662, -8.947505317275446, 0.371697970006654,	-3.368349776966538,	 4.657443083154591,	 0.453955538023004,	-1.740701616944006,	-1.65220541740956,	 1.029317693975664},
                      {2.46194490699664,	   -0.336732006333566,	-0.552403825578577,	-8.452671777634976,	-5.633844858472623,	 4.461702367049373,	-3.779157969724202,	 2.769245822243623,	-1.006803537946152,	 1.372993145527169,	-2.883759917737196,	 3.935344741349428,	 1.588807880940938,	 1.666332742486905,	-3.345107247615156,	 9.018878681488209,	 4.966343941267382,	-2.378406115718362,	 4.984115491643569,	-6.369451753840427,	-4.810457553048149,	 4.695631510723671,	 8.870216904135045,	 1.851266423773728,	 0.47853186190453,	 2.284171420203474,	-1.699791507685024,	 4.11585412102773,	 2.079681507808699,	 6.064422880045283}};
	
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
		double g1, g2, g3;
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
	    g1 = 0.0;
		g2 = 0.0;
		g3 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 - y[i] * Math.cos(Math.sqrt(Math.abs(y[i])));
			g2 = g2 + y[i] * Math.cos(Math.sqrt(Math.abs(y[i])));
			g3 = g3 + y[i] * Math.sin(Math.sqrt(Math.abs(y[i])));
		}

		g1 = g1 -((double) x.size());
		g2 = g2 -((double) x.size());
		g3 = g3 - (10 *((double) x.size()));

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}

		return (g1 + g2 + g3)/3;
    }
    
    public double[] violationArray(Vector<Double> x) {
		double[] z;
		double g1, g2, g3;
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
	    g1 = 0.0;
		g2 = 0.0;
		g3 = 0.0;

		for (int i = 0; i < x.size(); i++) {
			g1 = g1 - y[i] * Math.cos(Math.sqrt(Math.abs(y[i])));
			g2 = g2 + y[i] * Math.cos(Math.sqrt(Math.abs(y[i])));
			g3 = g3 + y[i] * Math.sin(Math.sqrt(Math.abs(y[i])));
		}

		g1 = g1 -((double) x.size());
		g2 = g2 -((double) x.size());
		g3 = g3 - (10 *((double) x.size()));

		//Mean Violations
		if (g1 <= 0) {
			g1 = 0;
		}
		if (g2 <= 0) {
			g2 = 0;
		}
		if (g3 <= 0) {
			g3 = 0;
		}

		return new double[] {g1, g2, g3};
    }
    
    public int getDimension() {
    	return dimension;
    }
    
    public double[] getDomainsMin() {
    	return domainsMin;
    }
    
    public double[] getDomainsMax() {
    	return domainsMax;
    }
    
    public String getName() { 
    	return "C15_30D";
    }
}
