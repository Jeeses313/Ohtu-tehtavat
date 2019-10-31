package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPalauttaaOikeanPelaajanJosLoytyy() {
        assertEquals("PIT", stats.search("Lemieux").getTeam());
    }

    @Test
    public void searchPalauttaaNullJosEiLoydy() {
        assertEquals(null, stats.search("Luukkainen"));
    }
    
    @Test
    public void teamPalauttaaSamaanJoukkueeseenKuuluvat() {
        boolean same = true;
        List<Player> teamList = stats.team("EDM");
        String team = teamList.get(0).getTeam();
        for (Player player: teamList) {
            if(!player.getTeam().equals(team)) {
                same=false;
            }
        }
        assertEquals(true, same);
    }
    
    @Test
    public void teamPalauttaaKaikkiSamaanJoukkueeseenKuuluvat() {
        List<Player> teamList = stats.team("EDM");
        assertEquals(3, teamList.size());
    }
    
    @Test
    public void topScorersPalauttaaPelaajatPisteJarjestyksestaSuurimmastaPienimpaan() {
        boolean order = true;
        List<Player> players = stats.topScorers(4);
        int score = players.get(0).getPoints();
        for (Player player:players) {
            if(player.getPoints() > score) {
                order = false;
            }
            score = player.getPoints();
        }
        assertEquals(true,order);
    }
    
    @Test
    public void topScorersPalauttaaOikeanMaaranPelaajia() {
        List<Player> players = stats.topScorers(2);
        assertEquals(3,players.size());
    }

}
