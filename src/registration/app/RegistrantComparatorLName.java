/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.app;
import java.util.Comparator;
import registration.app.Registrant;

/**
 *
 * @author Kevin Lavender
 */
public class RegistrantComparatorLName implements Comparator<Registrant>
{
    public int compare(Registrant reg1,Registrant reg2)
    {
         return reg1.getField(1).compareTo(reg2.getField(1));
    }
}
