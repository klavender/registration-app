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
    public Registrant()
    {
        datafields = new String[11];
    }
    
    public Registrant(String line)
    {
        readIn(line);
    }
    
    public String writeOut()
    {
        String dataout = new String();
        for (int i = 0; i < 11; i++)
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