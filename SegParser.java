/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatextstory;
import java.util.*;

/**
 *
 * @author melan
 */
/*
Accepts one segment and parses it into a string, a string list, and an int list
*/
class SegParser {
    private String storyText;   //text of body
    private List<String> triggerList = new ArrayList<String>();   //text of triggers
    private List<Integer> triggerDir = new ArrayList<Integer>();   //directory of triggers
    SegParser(final String seg)
    {
        //System.out.println("parsing:"+seg);
        parseBody(seg);
    }
    void parseBody(final String seg){
        int triggerStart=-1;
        String _storyText= "";
        for(int i=0;i<seg.length();i++){
            if (seg.charAt(i)=='['||seg.charAt(i)==']')
                continue;
            if (seg.charAt(i)=='<'&&seg.charAt(i+1)=='<'){
                i+=2; triggerStart=i; break;
            }
            _storyText+=seg.charAt(i);
        }
        storyText=_storyText;
        //System.out.println("storyText:"+storyText);
        if (triggerStart==-1){
            System.out.println("NO TRIGGER DETECTED");
            System.exit(0);
        }
        parseTriggerList(seg, triggerStart);
    }
    
    void parseTriggerList(final String seg, int index) {   //trigger start index
        String thisTrigger = "";
        //System.out.println("index:"+index);
        for (int i=index; i<seg.length(); i++){
            char thisChar = seg.charAt(i);
            //System.out.println("TriggerListChar:"+thisChar);
            if (thisChar=='~'){
                //System.out.println("thisTrigger:"+thisTrigger);
                triggerList.add(thisTrigger);
                thisTrigger = "";
                //System.out.println(triggerList.get(0));
                i++; i = parseTriggerDir(seg, i); continue;               
            }
            if (thisChar=='|'){
                continue;
            }
            if (thisChar=='>'&&seg.charAt(i+1)=='>'){
                break;
            }
            thisTrigger+=thisChar;
        }
    }
    
    int parseTriggerDir(String seg, int index){ //returns index after last digit
        String dirStr="";
        for (int i = index; i<seg.length(); i++){
            char thisChar = seg.charAt(i);
            //System.out.println("dir:"+thisChar);
            if (!Character.isDigit(thisChar)){
                //System.out.println("is not digit");
                index = i;
                break;
            }
            dirStr+=thisChar;
        }
        //System.out.println("dirStr:"+dirStr);
        
                
        try{
            triggerDir.add(Integer.parseInt(dirStr));
        }catch(NumberFormatException ex){
            System.out.println("No directory info after '~', "+ex);
        }
        return index;
    }
    
    
    String getStoryText(){
        return storyText;
    }
    List<String> getTriggerList(){
        return triggerList;
    }
    List<Integer> getTriggerDir(){
        return triggerDir;
    }
}
