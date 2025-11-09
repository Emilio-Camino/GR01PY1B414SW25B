package facturacion.elementos.enumeraciones;

public enum TipoRecipiente {
    VASO ("Vaso"),
    CONO ("Cono"),
    TULIPAN ("Tulipan");
    private final String nombreVisible;
    // Constructor
    TipoRecipiente(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }
    @Override
    public String toString() {
        return nombreVisible;
    }
}
