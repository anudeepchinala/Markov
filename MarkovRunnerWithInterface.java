
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface 
{
    public void runModel(IMarkovModel markov, String text, int size,int seed)
    {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 1; k++)
        {
            String st= markov.getRandomText(size);
            
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 100;
        int seed =792;
        //st ="yes-this-is-a-thin-pretty-pink-thistle";
//         
//         MarkovZero mz = new MarkovZero();
//         runModel(mz, st, size,seed);
//     
         MarkovOne mOne = new MarkovOne();
         runModel(mOne, st, size,seed);
//         
//           MarkovModel mThree = new MarkovModel(8);
//         double starttime = System.nanoTime();
//           runModel(mThree, st, size,seed);
//         double endtime = System.nanoTime();
//         System.out.println((endtime-starttime)/1000000000.00);
//         
           //MarkovFour mFour = new MarkovFour();
           //runModel(mFour, st, size,seed);
        
           EfficientMarkovModel eff = new EfficientMarkovModel(6);
        double sta = System.nanoTime();
        runModel(eff, st, size,seed);
        testHashmap();
        double et = System.nanoTime();
        //System.out.println((et-sta)/1000000000.00);
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
    public void testHashmap()
    {
        EfficientMarkovModel eff = new EfficientMarkovModel(5);
        int seed = 531;
        int size = 50;
        FileResource fr = new FileResource();
        String st = fr.asString();
        System.out.println(st.length());
        runModel(eff, st, size,seed);        
    }
    
}
