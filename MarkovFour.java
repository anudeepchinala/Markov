
import java.util.*;
public class MarkovFour extends AbstractMarkovModel{
    private ArrayList<Integer> inds;
    public void getinds()
    {
        for(Integer item : inds)
        {
            System.out.print(item+" ");
        }
        inds.clear();
    }
    public MarkovFour() {
        myRandom = new Random();
        inds = new ArrayList<Integer>();
    }
    
    
    
    public void setTraining(String s){
        myText = s; // get the training text 
    }
    
    public String getRandomText(int numChars)
    {
        StringBuilder sb = new StringBuilder(); //initialize a new stringbuilder object 
        int index = myRandom.nextInt(myText.length()-4); 
        // if random gives the myText.Length() then there is no key with TWO char so we subtrat two.So the key could be last two char in my.Text and they have no follow array

        String key = myText.substring(index,index+4);
        sb.append(key);
        for(int k=0; k < numChars-4; k++) //k<numChar-4
        {
            ArrayList<String> follows = getFollows(key);
            //System.out.println("Key "+key+" follows array "+follows);
            if(follows.size()==0)
            {
                break;
               }
               inds.add(index);
            index = myRandom.nextInt(follows.size());
            
            String next= follows.get(index);
            sb.append(next);
            key=key.substring(1)+next;
            //System.out.println(sb.toString());
        }
        
        return sb.toString();
    }
    
    public String toString()
    {
        return("Markov of Order 4");
    }

}
