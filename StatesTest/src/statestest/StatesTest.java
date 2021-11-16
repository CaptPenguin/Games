
package statestest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StatesTest {

    public static void main(String[] args) throws FileNotFoundException{
        TreeMap <String,String> states = new TreeMap<>();
        File input = new File("states.txt");
        Scanner in = new Scanner(input);
        Random rand = new Random();
        
        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] splitted = line.split("\\t");
            states.put(splitted[0],splitted[1]);
        }
        
        int lives = 3;
        int credit = 0;
        
        while(lives > 0){
            String State = states.keySet().toArray()[rand.nextInt(50)].toString();
            System.out.println("What is the capital of " + State + ": ");
            
            Scanner userIn = new Scanner(System.in).useDelimiter("\\n");
            String userInput = userIn.next();
            
            if(userInput.toLowerCase().equals(states.get(State).toLowerCase())){
                System.out.println("Correct!");
                credit += 5;
                lives++;
            }
            else{
                System.out.println("You are wrong! Capitol of " + State + " is " + states.get(State));
                lives--;
            }
        }
        System.out.println("Game Over. Total score is " + credit);
    }
    
}
