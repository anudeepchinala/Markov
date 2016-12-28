import java.util.Random;
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel 
{
    private int order;
    private HashMap<String,ArrayList<String>> lookupmap;
    public EfficientMarkovModel(int n) {order =n; lookupmap = new HashMap<String,ArrayList<String>>();}
    public String getRandomText(int numChars)
    {
        StringBuilder sb = new StringBuilder(); 
        int index = myRandom.nextInt(myText.length()-order); 
        String key = myText.substring(index,index+order);
        sb.append(key);
        //buildHashmap(myText,order);
        //System.out.println("Size of the HashMap"+buildHashmap(myText,order).size());
        lookupmap = (buildHashmap(myText,order));
        printHashMapInfo(lookupmap);
        maxOf(lookupmap);

        for(int k=0; k < numChars-order; k++) 
        {
            ArrayList<String> follows = getFollows(key);
            if(follows.size()==0)
            { break;}            
            index = myRandom.nextInt(follows.size());
            String next= follows.get(index);
            sb.append(next);
            key=key.substring(1)+next;
        }

        //printHashMapInfo();

        return sb.toString();
    }
 
    public HashMap<String, ArrayList<String>> buildHashmap(String trngtext,int order)
    {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put(trngtext.substring(trngtext.length()-order), new ArrayList<String>());
        for(int i=0;i<trngtext.length()-order;i++)
        {
            String key = trngtext.substring(i,i+order);//the first two/three/model number characters
            String followsChar = trngtext.substring(i+order,i+order+1);// the following char right after the key
            ArrayList<String> followsArray =  new ArrayList<String>();//initialize the array
            if(map.keySet().contains(key))
            {
                map.get(key).add(followsChar);// OH!!! you have found an existing key huh??Might as well get that 'Existing' Array List and
            }
            else
            {
             followsArray.add(followsChar);
             map.put(key,followsArray);
            }
        }
        return map;
    }
    
    protected ArrayList<String> getFollows(String key)
    {
//         ArrayList<String> res= new ArrayList<String>();
//         int pos=0;
//         if(buildHashmap(key,order).keySet().contains(key))
//         {
//             res = lookupmap.get(key);//did not work wehn i built it on the spot i.e., bu calling the buildHashMap Function
//             //System.out.println(res);
//             int size = res.size();
//         }
//         else{
//         while(pos<myText.length())
//         {
//             int start = myText.indexOf(key,pos); //first occurance of key 
//             if (start ==-1){break;} // if the key is not found then we must be at the end 
//             if(start +key.length()>=myText.length()-3){break;}//if the index ~ first char and the next char is index +1  are at the end 
// 
//             String next=myText.substring(start+key.length(),start+key.length()+1); //
//             res.add(next);
//             pos =start+key.length();
//            }
//         }
        return(lookupmap.get(key));
        
       }
    
    public void maxOf(HashMap<String, ArrayList<String>> m)
    {
        int max=0;


        for(String k : m.keySet())
        {
            if(m.get(k).size()>max)
            {
                max=m.get(k).size();
            }
        }
        System.out.println("Largest size of a List"+max); 
    }
    public void printHashMapInfo (HashMap<String, ArrayList<String>> map)
    {
        int count = 0;
                Map<String, ArrayList<String>> m = new TreeMap<String, ArrayList<String>>(map);
     for(String k : m.keySet())   
        {
        count++;
        //System.out.println("Key -> "+k+" and Array List -> "+ map.get(k));
        }
        System.out.println("Size -> "+count);
    }
    public String toString()
    {
        return("Markov of Order"+ order);
    }
}
