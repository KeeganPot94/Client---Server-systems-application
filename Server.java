/*
 * Server class 
 */

import java.util.Random;

public class Server {

    // declare and initialise variables
    private Client currentClient;
    private double meanServiceTime;
    private int stopTime;

    // server class constructor
    public Server(double meanServiceTime) {
        // implement variables to constructor object
        this.meanServiceTime = meanServiceTime;
    }

    // isServing() method
    public boolean isServing() {
        // return if currentClient object is created
        return currentClient != null;
    }

    // getStopTime() method to return stopping time
    public int getStopTime() {
        return stopTime;
    }

    // startServing() method
    public void startServing(Client client, int currentTime) {
        // serve client and set start time to current time
        currentClient = client;
        currentClient.setStartTime(currentTime);

        // set stop time equal to current time plus random service time
        stopTime = currentTime + randomNumber(meanServiceTime);
        System.out.println("Server started serving client " + currentClient.getClientID() + " at time " + currentTime);
    }

    // stopServing() method
    public void stopServing() {
        // set stop time variable for current client
        currentClient.setStopTime(stopTime);
        System.out.println("Server stopping serving client " + currentClient.getClientID() + " at time " + stopTime);
        // reset currentClient to null
        currentClient = null;
    }

    // random number method
    public static double randomNumber() {
        // create instance of random named generator
        Random generator = new Random();
        double number;

        // generate double value by iterating until 10
        for (double i = 1; i <= 10; i++) {
            number = generator.nextDouble();
        }
    }
}
