package sample;

public class Player {
        PlayerTeam playerTeam;
        String playerName = null;

        public Player(PlayerTeam playerTeam){
            this.playerTeam = playerTeam;
        }

    public PlayerTeam getPlayerTeam() {
        return playerTeam;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String playerToString(){
            return this.playerTeam + " " + this.playerName;
    }


}
