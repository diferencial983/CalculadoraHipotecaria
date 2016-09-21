/*
 * Copyright (c) 2016. Junta de Castilla y León
 */

package es.jglancho.calculadorahipotecaria.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.jglancho.calculadorahipotecaria.activities.MainActivity;

/**
 * Created by garlanja on 20/07/2016.
 */
public class JglanchoException extends Exception {

    private int tipoExcepcion;
    protected String mensajeExcepcion;

    protected transient final Logger logger = LoggerFactory.getLogger(this.getClass());

    public JglanchoException() {
        this.tipoExcepcion = 0;
        this.mensajeExcepcion = super.getMessage();
    }

    public JglanchoException(String causaException) {
        super(causaException);
        debugExceptionCreated();
    }

    public JglanchoException(Class classException, String methodException, String causaException) {
        super("JglanchoException en clase " + classException.getName()
                + " en método " + methodException
                + ". Causa: " + causaException);
        debugExceptionCreated();
    }

    public JglanchoException(Exception e, String classException, String causaException) {
        super("Excepcion de tipo: " + e.getClass().getName()
                + ", con mensaje: " + e.getLocalizedMessage()
                + "en la clase " + classException
                + ". Causa: " + causaException);
        debugExceptionCreated();
    }

    protected void debugExceptionCreated () {
        if (logger.isDebugEnabled()) {
            logger.debug("DEBUG JglanchoException Creada.");
        } else {
            logger.info("INFO. El logger no esta en debug");
        }
    }
}
