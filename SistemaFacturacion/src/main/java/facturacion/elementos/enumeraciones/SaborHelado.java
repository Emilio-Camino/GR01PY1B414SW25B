package facturacion.elementos.enumeraciones;

public enum SaborHelado {
    CHOCOLATE ("Chocolate"),
    FRESA ("Fresa"),
    VAINILLA ("Vainilla"),
    COOKIESNCREAM ("Cookies & Cream"),
    RONPASAS ("Ron con Pasas"),
    CHICLE ("Chicle");

    private final String nombreVisible;
    // Constructor
    SaborHelado(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }
    @Override
    public String toString() {
        return nombreVisible;
    }

}
