package com.juice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Reader {

    private static InputStream fileInputStream;
    private static Properties prop;

    public static Properties getAllProperties() {

        prop = new Properties();		//Inicializa el objeto Properties.

        try {
            String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";  	//Ruta del archivo con la configuracion
            fileInputStream = new FileInputStream(propFilePath);  	// lee el archivo de propiedades.
            prop.load(fileInputStream);		//Carga las propiedades del archivo en el objeto Properties.

        } catch (IOException ex) {
            ex.printStackTrace();		//Captura y maneja cualquier IOException que pueda ocurrir
        }
        return prop;
    }

    public static void cleanUp() {
        if (fileInputStream != null) {		//Si fileInputStream no es nulo, intenta cerrarlo y maneja cualquier IOException que pueda ocurrir.
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
