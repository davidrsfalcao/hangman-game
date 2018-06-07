package server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ServerMaintenance implements Runnable {

    private int maxInativeTime;
    private ConcurrentHashMap<Integer, Long> playersActivity = new ConcurrentHashMap<>();
    private ArrayList<Integer> inativePlayers = new ArrayList<>();

    private boolean end = false;

    ServerMaintenance(){
        maxInativeTime = 60; // seconds
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        while(!end){
            long actualTime = System.currentTimeMillis();

            Iterator it = playersActivity.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(calcInactivityTime((long) pair.getValue(), actualTime) >= maxInativeTime){
                    addPlayerToInactives((int) pair.getKey());
                }
                else {
                    removePlayerToInactives((int) pair.getKey());
                }
            }

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public ConcurrentHashMap<Integer, Long> getPlayersActivity() {
        return playersActivity;
    }

    private int calcInactivityTime(long time, long actualTime ){

        return (int) ((actualTime-time)/1000);
    }

    private void addPlayerToInactives(int nrPlayer){
        if(!inativePlayers.contains(nrPlayer)){
            inativePlayers.add(nrPlayer);
            System.out.println("\n\n---------------------------------------");
            System.out.println("Player " + nrPlayer + " is inactive");
            System.out.println("---------------------------------------\n\n");
        }
    }

    private void removePlayerToInactives(int nrPlayer){
        if(inativePlayers.contains(nrPlayer)){
            for(int i=0; i < inativePlayers.size(); i++){
                if(inativePlayers.get(i) == nrPlayer){
                    inativePlayers.remove(i);
                    break;
                }
            }
        }
    }

    public ArrayList<Integer> getActivePlayers(){
        ArrayList<Integer> activePlayers = new ArrayList<>();

        Iterator it = playersActivity.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            if(!inativePlayers.contains(pair.getKey())){
                activePlayers.add((int) pair.getKey());
            }

        }

        return activePlayers;
    }

}
