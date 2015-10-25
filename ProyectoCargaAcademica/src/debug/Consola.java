package debug;

import org.apache.log4j.Logger;

public class Consola {

    private static Logger log = Logger.getLogger(Consola.class);

    /**
     * @param args argumentos recibidos por la linea de comandos
     */
    public static void main(String[] args) {
        System.out.println("consola");
        
        
    }

    public static void log( String msg) {

//        if (log.isTraceEnabled()) {
//            log.trace("mensaje de trace");
//        }
//
//        if (log.isDebugEnabled()) {
//            log.debug("mensaje de debug");
//        }
//
//        if (log.isInfoEnabled()) {
//            log.info("mensaje de info");
//        }
//
//        log.warn("mensaje de warn");
//        log.error("mensaje de error");
//        log.fatal("mensaje de fatal");
        
        log.warn(msg);

    }

}
