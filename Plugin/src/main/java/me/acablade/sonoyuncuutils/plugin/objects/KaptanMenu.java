package me.acablade.sonoyuncuutils.plugin.objects;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;


public class KaptanMenu {

    private String title = "Kaptan Menusu";

    private List<Game> games = new ArrayList<>();

    public String build(){
        return "{\"Title\":\"" + title + "\",\"Games\":" + buildGames() + "}";
    }

    public List<Game> getGames() {
        return games;
    }

    private String buildGames(){

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < games.size(); i++) {

            Game game = games.get(i);

            builder.append(game.toString());
            if(i != games.size()-1)
                builder.append(",");
        }

        builder.append("]");
        return builder.toString();
    }


    @Builder
    public static class Game {

        private String id;
        private String textureID;
        private String displayName;
        private int online;

        public String toString(){
            return "{\"ID\":\"" + id + "\",\"TextureID\":\"" + textureID + "\",\"DisplayName\":\"" + displayName + "\",\"Online\":\"" + online + "\"}";
        }

    }


}
