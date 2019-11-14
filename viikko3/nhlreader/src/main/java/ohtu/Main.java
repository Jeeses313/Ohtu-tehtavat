package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players, (p1, p2) -> p2.getPoints() - p1.getPoints());
        System.out.println("Players from FIN Wed Nov 06 23:47:11 EET 2019");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player.getName() + "   " + player.getTeam() + "  " + player.getGoals() + " + " + player.getAssists() + " = " + player.getPoints());
            }
        }
    }

}
