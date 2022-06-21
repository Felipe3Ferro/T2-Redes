import java.util.ArrayList;
import java.util.Arrays;

public class Pacote {
    String origem;
    String destino;
    String tipo;
    String sequencia;
    ArrayList<String> dados;
    int crc[];

    public Pacote(String origem, String destino, String tipo, String sequencia, ArrayList<String> dados, int[] crc) {
        this.origem = origem;
        this.destino = destino;
        this.tipo = tipo;
        this.sequencia = sequencia;
        this.dados = dados;
        this.crc = crc;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public ArrayList<String> getDados() {
        return dados;
    }

    public void setDados(ArrayList<String> dados) {
        this.dados = dados;
    }

    public int[] getCrc() {
        return crc;
    }

    public void setCrc(int[] crc) {
        this.crc = crc;
    }

    @Override
    public String toString() {
        String crcs = "";
        for (int i = 0; i < crc.length - 1; i++) {
            crcs += crc[i];
        }
        return "Pacote [crc=" + crcs + ", dados=" + dados + ", destino=" + destino + ", origem="
                + origem + ", sequencia=" + sequencia + ", tipo=" + tipo + "]";
    }

}