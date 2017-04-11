/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatextstory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author melan
 */
/*
Read input file and divide it into segments, returns one segment
input:string filename, return:string seg
*/
final class FileProcesser {
    
    private final List<String> segs = new ArrayList<>();
    FileProcesser(final String fileName) throws IOException {
        readFile(fileName);
    }
    String getSeg(int i){
        return segs.get(i);
    }
    void readFile(String fileName) throws IOException {
        //List<String> segs = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        //                System.out.println("segs contains: "+segs);
        try {
            outer:
            while (true){   //each segment

                StringBuilder sb = new StringBuilder();
                String line;
                boolean parBegin = false;
                while (true) {  //each line
                    String _nextline = br.readLine();
                    //System.out.println("nextline: "+nextline);
                    if (_nextline == null)
                        break outer;  //break outer
                    String nextline = _nextline.trim();
                    if (nextline.length()==0)
                        continue;
                    if (nextline.charAt(0)=='['&&nextline.charAt(1)=='[')
                    {parBegin = true; 
                    //System.out.println("parBegin True");
                    }
                    if (parBegin == false)
                    {//System.out.println("parBegin false"); 
                    continue;}
                    //if (nextline.charAt(nextline.length()-1)==']')                    
                    line = nextline;
                    //System.out.println("line: "+line);
                    sb.append(line);
                    sb.append("\n");
                    //System.out.println("sb: "+sb.toString());
                    if (nextline.charAt(nextline.length()-1)==']'&&nextline.charAt(nextline.length()-2)==']')
                    {
                        break;
                    }  //break inner
                    //line = br.readLine();
                }
                //System.out.println("segs contains: "+segs);

                segs.add(sb.toString());
                //System.out.println("segs.add: "+sb.toString());
                //System.out.println("segs contains: "+segs);
            }
        }
        finally {
            //System.out.println("br.close(): "+segs);
            br.close();
        }
        //return segs;
    }
}
