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
import java.util.Collections;
import java.util.Random;

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
        
        return true;
    }
    
    public boolean readIn() throws FileNotFoundException, IOException
    {
        FileReader file = new FileReader("trans.dat");
        BufferedReader file_in = new BufferedReader(file);
        String line;
        while ((line = file_in.readLine()) != null)
        {
            registrants.add(new Registrant(line));
        }
        file_in.close();
        
        return true;
    }
    
    public ArrayList<Registrant> getRegistrant(String filterString,String filterCriteria,String sortCriteria)
    {
        if (sortCriteria == "FName")
            Collections.sort(registrants,new RegistrantComparatorFName());
        else if (sortCriteria == "LName")
            Collections.sort(registrants,new RegistrantComparatorLName());
        else if (sortCriteria == "ZCode")
            Collections.sort(registrants,new RegistrantComparatorZCode());
        
        if (filterCriteria.length()==0) return registrants;
        
        Iterator<Registrant> iterator = registrants.iterator();
        ArrayList<Registrant> registrants_filtered = new ArrayList<Registrant>();
        
        while (iterator.hasNext())
        {
            Registrant register = iterator.next();
            int field=0;
            
            if (filterCriteria == "FName") field = 0;
            else if (filterCriteria == "LName") field = 1;
            else if (filterCriteria == "Email") field = 3;
            
            if (register.getField(field).contains(filterString)) 
                registrants_filtered.add(register);
        }
        
        return registrants_filtered;
    }
    
    public Registrant selectRandom()
    {
        Random ran = new Random(System.nanoTime());
        return registrants.get(ran.nextInt()%registrants.size());
    }
    
    ArrayList<Registrant> registrants;
}
