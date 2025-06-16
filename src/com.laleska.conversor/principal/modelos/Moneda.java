package modelos;

public class Moneda {
    private String monedaInicial;
    private String monedaFinal;
    private double tipoCambio;
    private double monto;

    public Moneda(String monedaInicial, String monedaFinal, double tipoCambio, double monto) {
        this.monedaInicial = monedaInicial;
        this.monedaFinal = monedaFinal;
        this.tipoCambio = tipoCambio;
        this.monto = monto;
    }

    public Moneda(MonedaRecord record) {
        this.monedaInicial = record.base_code();
        this.monedaFinal = record.target_code();
        this.monto = record.conversion_result();
        this.tipoCambio = record.conversion_rate();
    }

    @Override
    public String toString() {
        return String.format(
                "\n========== Conversión de Moneda ==========\n" +
                        "Moneda de origen     : %s\n" +
                        "Moneda de destino    : %s\n" +
                        "Tipo de cambio       : %.4f\n" +
                        "Monto convertido     : %.2f %s\n" +
                        "===========================================",
                monedaInicial, monedaFinal, tipoCambio, monto, monedaFinal
        );
    }

}
