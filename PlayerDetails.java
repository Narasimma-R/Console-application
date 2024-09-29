package Game;

import java.util.UUID;

public class PlayerDetails {
    private UUID uid= UUID.randomUUID();
    private String name;
    private int points=0;

    public PlayerDetails(String name) {
        this.name = name;
    }

    public PlayerDetails(UUID uid,String name,int points){
        this.uid = uid;
        this.name = name;
        this.points = points;
    }

    public UUID getUserUid() {
        return uid;
    }

    public String getUserName() {
        return name;
    }

    public int getUserPoints() {
        return points;
    }

    public void updatePoints(int points){
        this.points+=points;
    }

    public void setUid(UUID uid){
        this.uid=uid;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setPoints(int points){
        this.points=points;
    }
}
