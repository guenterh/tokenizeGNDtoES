package org.swissbib.data.gnd;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File file = new File("/home/swissbib/Downloads/gnd/GND.jsonld");
        JsonFactory jsonFactory = new JsonFactory(); // or, for data binding, org.codehaus.jackson.mapper.MappingJsonFactory

        try {
            JsonParser jp = jsonFactory.createJsonParser(file);

            JsonToken jT = jp.nextToken();


            while (jT != null) {

                System.out.println(jT.toString());
                if (jp.getCurrentValue() != null) {
                    //System.out.println(jp.getCurrentValue().toString());
                }

                if (jT == JsonToken.END_OBJECT) {
                    System.out.println("whole object");
                }

                jT = jp.nextToken();


            }
        } catch (IOException ioe) {
            ioe.printStackTrace();

        }




    }
}
