package utils;

import android.util.Log;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import models.*;
import pt.ispg3814.com.weatherapp.R;

public class Utilities {

    public static ArrayList<Integer> getWeatherFromFilter(final String filter)
    {
        ArrayList<Integer> codesToFilter = new ArrayList<>();

        switch (filter) {
            case "Céu Limpo":
                codesToFilter.add(800);
                break;
            case "Céu Nublado":
                codesToFilter.add(801);
                codesToFilter.add(802);
                codesToFilter.add(803);
                codesToFilter.add(804);
                break;
            case "Aguaçeiros":
                codesToFilter.add(500);
                codesToFilter.add(501);
                codesToFilter.add(502);
                codesToFilter.add(503);
                codesToFilter.add(504);
                codesToFilter.add(511);
                codesToFilter.add(520);
                codesToFilter.add(521);
                codesToFilter.add(522);
                codesToFilter.add(531);
                break;
            case "Chuviscos":
                codesToFilter.add(300);
                codesToFilter.add(301);
                codesToFilter.add(302);
                codesToFilter.add(310);
                codesToFilter.add(311);
                codesToFilter.add(312);
                codesToFilter.add(313);
                codesToFilter.add(314);
                codesToFilter.add(321);
                break;
            case "Trevoada":
                codesToFilter.add(200);
                codesToFilter.add(201);
                codesToFilter.add(202);
                codesToFilter.add(210);
                codesToFilter.add(211);
                codesToFilter.add(212);
                codesToFilter.add(221);
                codesToFilter.add(230);
                codesToFilter.add(231);
                codesToFilter.add(232);
                break;
            case "Neve":
                codesToFilter.add(600);
                codesToFilter.add(601);
                codesToFilter.add(602);
                codesToFilter.add(611);
                codesToFilter.add(612);
                codesToFilter.add(615);
                codesToFilter.add(616);
                codesToFilter.add(620);
                codesToFilter.add(621);
                codesToFilter.add(622);
                break;
            default:
                break;
        }
        return codesToFilter;
    }
}
