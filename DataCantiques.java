package com.sintel.defteregimmibefulfulde;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class DataCantiques {

    public static TreeMap<String, List<String>> getData() {
        TreeMap<String,List<String>> expandablelistDetail= new TreeMap<>();

        List<String> A = new ArrayList<String>();
        A.add(liste_titre_cantiques[102]);
        A.add(liste_titre_cantiques[55]);
        A.add(liste_titre_cantiques[40]);

        List<String> B = new ArrayList<String>();
        B.add(liste_titre_cantiques[21]);
        B.add(liste_titre_cantiques[4]);
        B.add(liste_titre_cantiques[69]);
        B.add(liste_titre_cantiques[10]);
        B.add(liste_titre_cantiques[97]);
        B.add(liste_titre_cantiques[95]);
        B.add(liste_titre_cantiques[18]);
        B.add(liste_titre_cantiques[86]);
        B.add(liste_titre_cantiques[11]);
        B.add(liste_titre_cantiques[85]);
        B.add(liste_titre_cantiques[83]);
        B.add(liste_titre_cantiques[42]);
        B.add(liste_titre_cantiques[92]);
        B.add(liste_titre_cantiques[49]);
        B.add(liste_titre_cantiques[27]);
        B.add(liste_titre_cantiques[52]);
        B.add(liste_titre_cantiques[23]);
        B.add(liste_titre_cantiques[33]);

        List<String> D = new ArrayList<String>();
        D.add(liste_titre_cantiques[87]);
        D.add(liste_titre_cantiques[54]);
        D.add(liste_titre_cantiques[105]);
        D.add(liste_titre_cantiques[1]);
        D.add(liste_titre_cantiques[17]);

        List<String> E = new ArrayList<String>();
        E.add(liste_titre_cantiques[93]);
        E.add(liste_titre_cantiques[76]);
        E.add(liste_titre_cantiques[47]);

        List<String> G = new ArrayList<String>();
        G.add(liste_titre_cantiques[24]);
        G.add(liste_titre_cantiques[16]);
        G.add(liste_titre_cantiques[56]);

        List<String> H = new ArrayList<String>();
        H.add(liste_titre_cantiques[77]);
        H.add(liste_titre_cantiques[32]);
        H.add(liste_titre_cantiques[43]);
        H.add(liste_titre_cantiques[65]);
        H.add(liste_titre_cantiques[41]);

        List<String> J = new ArrayList<String>();
        J.add(liste_titre_cantiques[2]);
        J.add(liste_titre_cantiques[53]);
        J.add(liste_titre_cantiques[29]);

        List<String> K = new ArrayList<String>();
        K.add(liste_titre_cantiques[63]);

        List<String> L = new ArrayList<String>();
        L.add(liste_titre_cantiques[19]);
        L.add(liste_titre_cantiques[73]);

        List<String> M = new ArrayList<String>();
        M.add(liste_titre_cantiques[80]);
        M.add(liste_titre_cantiques[96]);
        M.add(liste_titre_cantiques[5]);
        M.add(liste_titre_cantiques[79]);
        M.add(liste_titre_cantiques[90]);
        M.add(liste_titre_cantiques[89]);
        M.add(liste_titre_cantiques[98]);
        M.add(liste_titre_cantiques[72]);
        M.add(liste_titre_cantiques[61]);
        M.add(liste_titre_cantiques[13]);
        M.add(liste_titre_cantiques[60]);
        M.add(liste_titre_cantiques[26]);
        M.add(liste_titre_cantiques[94]);
        M.add(liste_titre_cantiques[39]);
        M.add(liste_titre_cantiques[62]);

        List<String> N = new ArrayList<String>();
        N.add(liste_titre_cantiques[9]);
        N.add(liste_titre_cantiques[103]);
        N.add(liste_titre_cantiques[106]);
        N.add(liste_titre_cantiques[46]);
        N.add(liste_titre_cantiques[74]);
        N.add(liste_titre_cantiques[84]);

        List<String> R = new ArrayList<String>();
        R.add(liste_titre_cantiques[48]);

        List<String> S = new ArrayList<String>();
        S.add(liste_titre_cantiques[78]);
        S.add(liste_titre_cantiques[82]);
        S.add(liste_titre_cantiques[70]);
        S.add(liste_titre_cantiques[3]);
        S.add(liste_titre_cantiques[15]);
        S.add(liste_titre_cantiques[66]);

        List<String> T = new ArrayList<String>();
        T.add(liste_titre_cantiques[30]);
        T.add(liste_titre_cantiques[35]);
        T.add(liste_titre_cantiques[99]);
        T.add(liste_titre_cantiques[38]);
        T.add(liste_titre_cantiques[104]);
        T.add(liste_titre_cantiques[101]);
        T.add(liste_titre_cantiques[58]);
        T.add(liste_titre_cantiques[68]);
        T.add(liste_titre_cantiques[57]);

        List<String> U = new ArrayList<String>();
        U.add(liste_titre_cantiques[36]);

        List<String> W = new ArrayList<String>();
        W.add(liste_titre_cantiques[12]);
        W.add(liste_titre_cantiques[75]);
        W.add(liste_titre_cantiques[20]);
        W.add(liste_titre_cantiques[100]);
        W.add(liste_titre_cantiques[50]);
        W.add(liste_titre_cantiques[67]);
        W.add(liste_titre_cantiques[22]);
        W.add(liste_titre_cantiques[7]);

        List<String> Y = new ArrayList<String>();
        Y.add(liste_titre_cantiques[71]);
        Y.add(liste_titre_cantiques[88]);
        Y.add(liste_titre_cantiques[31]);
        Y.add(liste_titre_cantiques[44]);
        Y.add(liste_titre_cantiques[37]);
        Y.add(liste_titre_cantiques[64]);
        Y.add(liste_titre_cantiques[25]);
        Y.add(liste_titre_cantiques[34]);
        Y.add(liste_titre_cantiques[14]);
        Y.add(liste_titre_cantiques[8]);
        Y.add(liste_titre_cantiques[28]);
        Y.add(liste_titre_cantiques[59]);
        Y.add(liste_titre_cantiques[6]);
        Y.add(liste_titre_cantiques[0]);
        Y.add(liste_titre_cantiques[45]);
        Y.add(liste_titre_cantiques[91]);

        List<String> Z = new ArrayList<String>();
        Z.add(liste_titre_cantiques[51]);
        Z.add(liste_titre_cantiques[81]);

        expandablelistDetail.put("A",A);
        expandablelistDetail.put("B",B);
        expandablelistDetail.put("D",D);
        expandablelistDetail.put("E",E);
        expandablelistDetail.put("G",G);
        expandablelistDetail.put("H",H);
        expandablelistDetail.put("J",J);
        expandablelistDetail.put("K",K);
        expandablelistDetail.put("L",L);
        expandablelistDetail.put("M",M);
        expandablelistDetail.put("N",N);
        expandablelistDetail.put("R",R);
        expandablelistDetail.put("S",S);
        expandablelistDetail.put("T",T);
        expandablelistDetail.put("U",U);
        expandablelistDetail.put("W",W);
        expandablelistDetail.put("Y",Y);
        expandablelistDetail.put("Z",Z);

        //Map<String,List<String>> map = new TreeMap<String,List<String>>(expandablelistDetail);

        return expandablelistDetail;
    }


    public static String[] liste_titre_cantiques = {
            "Yesu yidi bikkon fu",
            "Dum seyo tokkago lawol",
            "Jodago ha kosde yesu",
            "Sobabe ngurte ha nder nyibre",
            "Baba cenido",
            "Mi don teddina ma allah",
            "Yesu krist don wanca be am",
            "Wodi sobajo am yesu",
            "Yeesu mayi ha gafingal",
            "Nda lekkita manga wari",
            "Baba mi yidi ma",
            "Bana mi woni aybejo",
            "wala sobajo buran yeesu",
            "Mi yidi yalade sabba",
            "Yeesu krist badita hande",
            "Sondu ha ladde",
            "Gafingal yeesu krist",
            "Duniyaru ndu mere",
            "Baddi be yeesu krist",
            "Labinol bernde",
            "War ha yeesu",
            "Baba am don yila be am",
            "Wodi lesdi ha allahhira",
            "Boyma mi anda kisnowo",
            "Gafingal yeesu",
            "Yeesu kisnowo kibuudo",
            "Minin ngidi dowtare",
            "Biddo allah",
            "Yeesu yidi yam",
            "Jodu be am",
            "Tapare duminde",
            "Yeesu badi wartugo",
            "Ha nder asaman",
            "Burdum ha yeesu",
            "Yeesu kisnowo yam",
            "Teddingo allah",
            "Ummatore yimbe allah",
            "Yeesu gainako boddo",
            "Timminol sodol",
            "Mobture hisnabe",
            "Allah jodida be ma",
            "Hubar mbelka",
            "Be siru",
            "Hakke am hosama gal kisnowo",
            "Yeesu be kisnowo",
            "Yimre nyalade sabbat",
            "Ngade zakka",
            "Endam yajaumirawo yeesu-krist",
            "Ruuhu cenido",
            "Berniwol seningol ha asaman",
            "Wartol yeesu nder wudare",
            "Zunubajo bana mi wa’i",
            "Boddumji don har ma ",
            "Jodibe ha lesdi fu",
            "Deftere allah lati jayngol",
            "Allah ewni ma ",
            "Gaynako boddo ",
            "Tokken lawol be gorgaku ",
            "To wodi yide ha sare  ",
            "Yeesu, mi tokkete toye fu",
            "Min ngari ha sudu mada ",
            "Mi yetti ngam yide baba be yeesu ",
            "Moye hisnata duniyaru  ",
            "Kugal mada lati bodngal ",
            "Yeesu jodan cakka meden",
            "Hokku en ruhu mada",
            "Sukka ma wari ",
            "Wi’i fu ha yeesu",
            "Tokkago lawol gongaku",
            "Baba jogam",
            "Sembe don nder yiam yeesu",
            "Ya jawmirawo mi yenwi ma",
            "Mi woni jayngol ma",
            "Lawol kisndam",
            "Ngam ma mi wadi dum",
            "War ha baba hande",
            "Endam kisnowo yam",
            "Ha dukki wade min latan aman’en",
            "Sanya pukarajo",
            "Mi don tefa jam be endam",
            "Mi don be mada",
            "Zunubajo mi hurgete",
            "Sawtu yeesu don noddi yam",
            "Barka kisnowo yeesu-krist",
            "Nyalade fu nder ngendam am ",
            "Bangte ko’e mon",
            "Balde fumi mari haje ma",
            "Dande yeesu don ewna min",
            "Yedgo be yeesu ha asaman",
            "Mi hebi seyo ha kisnowo",
            "Mi don wara jaumirawo",
            "Yimre suwam ",
            "Bernde men seyake ngam yeesu",
            "En mayan hideko ngeden",
            "Mo’ere yeesu",
            "Babirawo allah",
            "Mi don haba habre wonde",
            "Babare fu ha yeesu krist",
            "Mi numan foroy ha allah ",
            "Teffe gikku nbongu",
            "War ha yeesu",
            "To hendu saatundu wadi",
            "A yobi kisdam am bee sadaka",
            "Nda yesu kisnowo men ",
            "To a linyi taaku maada ",
            "Dum seyo mango haa am ",
            "Nder juude ma mi halfini"
    };
}
