
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.*;
public class MarkovOne extends AbstractMarkovModel
{
 
    
    
    public String getRandomText(int numChars)
    {
        StringBuilder sb = new StringBuilder(); 
        
        int index = myRandom.nextInt(myText.length()-1);  
        // get a random number from the range >0 to < length
        String key = myText.substring(index,index+1);
        //NOTE:gets the character that starts at index and ends just before index+1
        //System.out.println(key);
        // what is it that you got
        sb.append(key);
        // well we have to start the random text with the key so there's that 
        for(int k=0; k < numChars-1; k++) //NOTE:c'mon man you know why it has to be -1.Cause you got nothing after the last element in the training text <<<<<<WRONG
        {
            ArrayList<String> follows = getFollows(key); // initialize the follows array brah and get all the characters that follow the key in the training text
        
            if(follows.size()==0) // soooo you got nothing huh, thats a shame
            {
                break;
               }
               //inds.add(index);
            index = myRandom.nextInt(follows.size()); // now we gotta pick the character that comes after the key based or probability, by wich i mean random from the 
                                                      // list of characters that were known to be following this key character 
            String next= follows.get(index);// this is where we get that son of a bitch 
            sb.append(next);// well gotta add him now.
            key=next;// now that becomes the key REMEMBER
            // now the next char has a follows array that has elements which are found to be following it in the training text.
            // now we select one of such characters based on probability and that becomes the new key after being added.
            //in other words this is how it goes
            /* if 'T' is the key 
               a is slected at random from the list of char that follow 'T'
               result-> Ta
               now 'A' is the key 
               b is slected at random from the list of char that follow 'A'
               result->Tab
               now 'b' is the key 
               ' ' is selected at random from the list of char that follow 'B'
               result->Tab */
        }
        return sb.toString();
    }
    
     public String toString()
    {
        return("Markov of Order 1");
    }
}
