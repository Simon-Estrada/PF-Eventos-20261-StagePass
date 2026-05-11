package co.edu.uniquindio.stagepass.model;

public class GeneradorIds {
    private static int contadorUsuarios = 1;
    private static int contadorEventos = 1;
    private static int contadorRecintos = 1;
    private static int contadorZonas = 1;
    private static int contadorAsientos = 1;
    private static int contadorCompras = 1;
    private static int contadorEntradas = 1;
    private static int contadorIncidencias = 1;
    private static int contadorPagos = 1;

    private GeneradorIds() {
    }
    public static String generarIdPago(){
        return String.format("PAG-%03d", contadorPagos++);
    }

    public static String generarIdUsuario() {
        return String.format("USR-%03d", contadorUsuarios++);
    }

    public static String generarIdEvento() {
        return String.format("EVT-%03d", contadorEventos++);
    }

    public static String generarIdRecinto() {
        return String.format("REC-%03d", contadorRecintos++);
    }

    public static String generarIdZona() {
        return String.format("ZON-%03d", contadorZonas++);
    }

    public static String generarIdAsiento() {
        return String.format("ASI-%03d", contadorAsientos++);
    }

    public static String generarIdCompra() {
        return String.format("CMP-%03d", contadorCompras++);
    }

    public static String generarIdEntrada() {
        return String.format("ENT-%03d", contadorEntradas++);
    }

    public static String generarIdIncidencia() {
        return String.format("INC-%03d", contadorIncidencias++);

    }
}