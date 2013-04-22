/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.app;
import registration.app.Registrant;
import java.io.File;
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
import android.app.Activity;

/**
 *
 * @author Kevin Lavender
 */
public class Registry 
{
    public Registry(Activity act)
    {
        registrants = new ArrayList<Registrant>();
        a = act;
        File f = new File(a.getFilesDir().toString() + "/trans.dat");
        f.delete();
    }
    
    public boolean writeOut(Registrant registree) throws IOException
    {
        FileWriter file;
        file = new FileWriter(a.getFilesDir().toString() + "/trans.dat",true);
        BufferedWriter file_out = new BufferedWriter(file);
        /*Iterator<Registrant> iterator = registrants.iterator();
        while (iterator.hasNext())
        {
            Registrant register = iterator.next();
            file_out.write(register.writeOut());
        }*/
        file_out.newLine();
        file_out.write(registree.writeOut());
        file_out.close();
        
        return true;
    }
    
    public boolean readIn() throws FileNotFoundException, IOException
    {
        String filename = a.getFilesDir().toString() + "/trans.dat";
        File fcheck = new File(a.getFilesDir().toString() + "/master.dat");
        ArrayList<Registrant> registrant_list = new ArrayList<Registrant>();
        
        if (fcheck.length()> 0) filename = a.getFilesDir().toString() + "/master.dat";
        
        FileReader file = new FileReader(filename);
        BufferedReader file_in = new BufferedReader(file);
        String line;
        while ((line = file_in.readLine()) != null)
        {
            if (!line.equals("")) registrant_list.add(new Registrant(line));
        }
        file_in.close();
        
        registrants = registrant_list;
        
        return true;
    }
    
    public ArrayList<Registrant> getRegistrants(String filterString,String filterCriteria,String sortCriteria)
    {
        try
        {
            try
            {
                readIn();
            }
            catch (FileNotFoundException e)
            {
                
            }
        }
        catch (IOException e)
        {
            
        }
        
        if (sortCriteria.equals("First Name"))
            Collections.sort(registrants,new RegistrantComparatorFName());
        else if (sortCriteria.equals("Last Name"))
            Collections.sort(registrants,new RegistrantComparatorLName());
        else if (sortCriteria.equals("Zip Code"))
            Collections.sort(registrants,new RegistrantComparatorZCode());
        
        if (filterCriteria.equals("None")) return registrants;
        
        Iterator<Registrant> iterator = registrants.iterator();
        ArrayList<Registrant> registrants_filtered = new ArrayList<Registrant>();
        
        int field=0;
            
        if (filterCriteria.equals("First Name")) field = 0;
        else if (filterCriteria.equals("Last Name")) field = 2;
        else if (filterCriteria.equals("Email")) field = 5;
        
        while (iterator.hasNext())
        {
            Registrant register = iterator.next();
            
            if (register.getField(field).toLowerCase().contains(filterString.toLowerCase())) 
                registrants_filtered.add(register);
        }
        
        return registrants_filtered;
    }
    
    public Registrant selectRandom()
    {
        Random ran = new Random(System.nanoTime());
        
        try
        {
            try
            {
                readIn();
            }
            catch (FileNotFoundException e)
            {
                
            }
        }
        catch (IOException e)
        {
            
        }
        int random = ran.nextInt();
        if (random < 0) random = random*(-1);
        return registrants.get(random%registrants.size());
    }
    
    public void addRegistrant(Registrant registree)
    {
        try
        {
            writeOut(registree);
        }
        catch (IOException e)
        {
                    
        }
    }
    
    Activity a;
    ArrayList<Registrant> registrants;
}
