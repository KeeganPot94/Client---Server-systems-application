/*
 * Client class
 */
public class Client {

    // declare and initialise variables
    private int clientID;
    private int arrivalTime;
    private int startTime;
    private int endTime;

    // client class constructor
    public Client(int clientID, int arrivalTime) {
        // implement variables to constructor object
        this.clientID = clientID;
        this.arrivalTime = arrivalTime;

        // display client instance
        System.out.println("Client #" + clientID + " arrived at " + arrivalTime);
    }

    // getClientID() method to return any client id
    public int getClientID() {
        return clientID;
    }
}
