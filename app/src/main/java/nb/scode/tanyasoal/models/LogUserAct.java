package nb.scode.tanyasoal.models;

/**
 * Created by User on 1/5/2017.
 */

public class LogUserAct {
    private String aksi, saldo_ptg;
    private long waktu;

    public String getAksi() {
        return aksi;
    }

    public void setAksi(String aksi) {
        this.aksi = aksi;
    }

    public String getSaldo_ptg() {
        return saldo_ptg;
    }

    public void setSaldo_ptg(String saldo_ptg) {
        this.saldo_ptg = saldo_ptg;
    }

    public long getWaktu() {
        return waktu;
    }

    public void setWaktu(long waktu) {
        this.waktu = waktu;
    }
}
