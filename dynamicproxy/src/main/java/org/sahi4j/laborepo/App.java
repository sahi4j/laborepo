package org.sahi4j.laborepo;

import org.sahi4j.laborepo.beans.TimeMachine;
import org.sahi4j.laborepo.beans.TimeMachineInterface;
import org.sahi4j.laborepo.beans.TimeMachineProxy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Create the bean with its proxy
        TimeMachine t = new TimeMachine();
        TimeMachineInterface proxy = TimeMachineProxy.newInstance(t);
        proxy.moveInTime(100);
    }
}
