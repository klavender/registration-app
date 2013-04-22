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
public class RegistrantComparatorZCode implements Comparator<Registrant>
{
    public int compare(Registrant reg1,Registrant reg2)
    {
         Integer r1 = Integer.parseInt(reg1.getField(10)),
                 r2 = Integer.parseInt(reg2.getField(10));
         
         return r1.compareTo(r2);
    }
}
