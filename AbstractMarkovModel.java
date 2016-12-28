
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String key)
    {
        ArrayList<String> res= new ArrayList<String>();
        int pos=0;
        while(pos<myText.length())
        {
            int start = myText.indexOf(key,pos); //first occurance of key 
            if (start ==-1){break;} // if the key is not found then we must be at the end 
            if(start +key.length()>=myText.length()-3){break;}//if the index ~ first char and the next char is index +1  are at the end 
            String next=myText.substring(start+key.length(),start+key.length()+1); //
            res.add(next);
            pos =start+key.length();
           }
        return(res);
        
       }

    
}
