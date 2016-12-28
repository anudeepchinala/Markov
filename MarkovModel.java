import java.util.Random;
import java.util.*;
public class MarkovModel extends AbstractMarkovModel
{
    private int order;
    public MarkovModel(int n) {order = n;}
    public String getRandomText(int numChars)
    {
        StringBuilder sb = new StringBuilder();
        System.out.println("The length of the TEXT : "+myText.length()+" And the order is :"+order);
        System.out.println("What is  going to the Random Function: "+(myText.length()-order));
        int index = myRandom.nextInt(myText.length()-order); 
        String key = myText.substring(index,index+order);
        sb.append(key);
        for(int k=0; k < numChars-order; k++) 
        {
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0)
            { break;}
            System.out.print(index);            
            index = myRandom.nextInt(follows.size());
            String next= follows.get(index);
            sb.append(next);
            key=key.substring(1)+next;
        }
        return sb.toString();
    }
    public String toString(){return("Markov of Order"+ order);}
}
