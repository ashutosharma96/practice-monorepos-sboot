package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class    App
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        Tomcat tomcat = new Tomcat();

        Context context= tomcat.addContext("",null);
        Tomcat.addServlet(context,"Servlet1",new Servlet1());
        context.addServletMappingDecoded("/hello","Servlet1");

        tomcat.setPort(8080);
        tomcat.start();
        tomcat.getServer().await();

    }
}
