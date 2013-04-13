/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.app;

/**
 *
 * @author Kevin Lavender
 */

//public enum datafield {BOB,SALLY}

public class Registrant 
{
    public Registrant(String line)
    {
        readIn(line);
    }
    
    public String writeOut()
    {
        String dataout;
        for (int i = 0; i < bla; i++)
        {
            dataout.concat(datafields[i]);
            dataout.concat(",");
        }
        return dataout;
    }
    
    public boolean readIn(String line)
    {
        datafields = line.split(",");
        return true;
    }
    
    public String getField(int field)
    {
        return datafields[field];
    }
    
    public void setField(int field,String value)
    {
        datafields[field] = value;
    }
    
    String[] datafields;
}