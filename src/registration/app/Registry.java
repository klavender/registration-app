/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.app;
import registration.app.Registrant;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Kevin Lavender
 */
public class Registry 
{
    public boolean writeOut() throws IOException
    {
        FileWriter file;
        file = new FileWriter("trans.dat");
        BufferedWriter file_out = new BufferedWriter(file);
        Iterator<Registrant> iterator = registrants.iterator();
        while (iterator.hasNext())
        {
            Registrant register = iterator.next();
            file_out.write(register.writeOut());
        }
        file_out.close();
    }
    
    public boolean readIn() throws FileNotFoundException, IOException
    {
        FileReader file = new FileReader("trans.dat");
        BufferedReader file_in = new BufferedReader(file);
        String line;
        while (line = file_in.readLine() != null)
        {
            registrants.add(new Registrant(line));
        }
        file_in.close();
    }
    
    public Registrant[] getRegistrant(String filterCriteria,String sortCriteria)
    {
        
    }
    
    public Registrant selectRandom()
    {
        
    }
    
    ArrayList<Registrant> registrants;
}
