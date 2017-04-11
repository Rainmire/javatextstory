/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatextstory;
//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author melan
 */
class JavaTextStory {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
                // TODO code application logic here
        FileProcesser fp = new FileProcesser("test.txt");
        
        //DELETE FROM HERE
        //List<String> str = fp.readFile("test.txt");
        /*
        for (int i=0;i<str.size();i++){
            //System.out.println("Segment "+i+":"+str.get(i));
        }*/
        //System.out.println("full text: "+str);
        
        //SegParser sp = new SegParser(fp.getSeg(0));
        
        
        //System.out.println("getStoryText:"+sp.getStoryText());
        //System.out.println("getTriggerList:"+sp.getTriggerList());
        //System.out.println("getTriggerDir:"+sp.getTriggerDir());
        //DELETE TO HERE
        
        //BEGIN
        int dir = 0;    //index of next segment
        System.out.println("BEGIN. Use \"quit\" to quit\n");
        while(true){
            SegParser sp = new SegParser(fp.getSeg(dir));        
            System.out.println(sp.getStoryText());
            List<String> triggerList = sp.getTriggerList();
            ///
            List<Integer> triggerDir = sp.getTriggerDir();
            if (triggerDir.get(0)==0)
            {
                System.out.println("End of story");
                System.exit(0);
            }
            ///
            System.out.println("---Make a choice---");
            for (int i=0; i<triggerList.size(); i++){
                System.out.println((i+1)+": "+triggerList.get(i));
            }
            System.out.println();
            Scanner reader = new Scanner(System.in);
            String strInput = reader.next();
            System.out.println();

            if (strInput.equals("quit")){
                System.out.println("Exiting...");
                System.exit(0);
            }
            //implement checking for incorrect string entry
            int n = Integer.parseInt(strInput);
            if (n<1||n>triggerList.size())
                System.out.println("Invalid selection - Choose from options above");
            else{
                //System.out.println(n);
                dir = (triggerDir.get(n-1))-1;                
            }
        }
    }
    
    
}
