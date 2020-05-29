package org.sahi4j.laborepo.beans;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeMachineProxy implements InvocationHandler {

    //Instance of the real bean we delegate the actual work
    private TimeMachineInterface instance;

    //Private constructor so as
    private TimeMachineProxy(TimeMachineInterface inst){
        instance=inst;
    }

    //We need a factory method in order to return an instance of something else than this class (here its a proxy instance)
    //otherwise we have to instantiate this proxy on the client side (cleaner code as shown here)
    public static TimeMachineInterface newInstance(TimeMachineInterface inst){
        return (TimeMachineInterface)java.lang.reflect.Proxy.newProxyInstance(
                inst.getClass().getClassLoader(),
                inst.getClass().getInterfaces(),
                new TimeMachineProxy(inst));//we build instance of this class as the proxy
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //This method acts as a JEE Filter, you add behavior before & after the call and use the instance to delegate
        //the actual work
        System.out.println("invocation de la méthode "+method.getName());
        return method.invoke(instance,args);
    }
}
