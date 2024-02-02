import java.util.Queue;
import java.util.LinkList;
import java.util.LinkedList;
import java.util.Random;

// create ClientSystem class
public class ClientSystem {

    // declare and initialise variables for client queue and server array
    int numberOfServers = 4;
    int numberOfClients = 20;
    double meanSeriveTime = 5;
    double meanArrivalTime = 2;

    // create a queue to hold number of clients
    Queue<Client> clientQueue = new LinkedList<>();
    // create an array to hold number of servers
    Server[] servers = new Server[numberOfServers];

    // iterate through number of servers array
    for(
    int i = 0;i<numberOfServers;i++)
    {
        // set each elements mean service time
        servers[i] = new Server(meanSeriveTime);
    }

    // declare and initialise variables
    int currentTime = 0;
    int arrivalTime = 0;
    int clientID = 1;

    // look through client queue while client ID is smaller or equal to number of
    // clients
    // OR while the client queue is not empty
    while(clientID<=numberOfClients||!clientQueue.isEmpty())
    {
        // if there is enough time AND enough space is the queue
        if (arrivalTime <= currentTime && clientID <= numberOfClients) {
            // construct instance of Client class with variables
            Client newClient = new Client(clientID, currentTime);
            // add new element of new client to client queue
            clientQueue.add(newClient);

            // display new client ID and time when entered into queue
            System.out.println("Client #" + newClient.getID() + " arrived at " + currentTime);

            // calculate the next arrival time
            arrivalTime = currentTime + randomNumber(meanArrivalTime);

            // next iteration
            clientID++;
        }

        // iterate through servers, stopping and starting serving
        for (Server server : servers) {
            // if both, value from isServing AND stopTime equals currentTime, is true then
            if (server.isServing() && server.getStopTime() == currentTime) {
                // call stopServing method
                server.stopServing();
            }
            // if both, value from isServing AND client queue is not empty, is true then
            if (!server.isServing() && !clientQueue.isEmpty()) {
                // create an instance of Client and removed from the client queue
                Client nextClient = clientQueue.poll();
                // call startServing method
                server.startServing(nextClient, currentTime);
            }
        }
        // next iteration
        currentTime++;
    }

    // random number method
    public static double randomNumber (){
        // create instance of random named generator
        Random generator = new Random();
        double number;

        // generate double value by iterating until 10  
        for (double i = 1; i <= 10; i++) {
            number = generator.nextDouble();
        }
    }
}
