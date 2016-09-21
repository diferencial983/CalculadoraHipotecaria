/*
 * Copyright (c) 2016. Junta de Castilla y León
 */

package es.jglancho.calculadorahipotecaria.activities;

import android.app.Activity;
import android.os.Bundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.jglancho.calculadorahipotecaria.R;
import es.jglancho.calculadorahipotecaria.exceptions.JglanchoException;


public class MainActivity extends Activity {

    private static Logger log = LoggerFactory.getLogger(MainActivity.class);

    /**
     * onCreate()
     * He introducido esta línea para probar La instalación de GIT
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log.info("Actividad " + getLocalClassName()
                + " - Método " + Thread.currentThread().getStackTrace()[2].getMethodName()
                + " - Hilo " + Thread.currentThread().toString());

        try {
            testException();
        } catch (Exception e) {
            log.info("Mensaje de log que aparece cuando se produce una excepcion");
        }

    }

    /**
     * testException()
     *
     */
    protected void testException() throws JglanchoException {
        try {
            int[] numerosPrimos = {1, 3, 5, 7, 9, 11, 13, 17, 19, 23};
            int undecimoPrimo = numerosPrimos[12];

        } catch(ArrayIndexOutOfBoundsException e) {
            throw new JglanchoException(e, "Excepcion Indice ", e.toString());
        } catch (Exception e) {
            throw new JglanchoException(this.getClass(), Thread.currentThread().getStackTrace()[2].getMethodName(), "Excepcion General");
        } finally {
            throw new JglanchoException("Esto va a salir siempre en el log");
        }

    }

}
