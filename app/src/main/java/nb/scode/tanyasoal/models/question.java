package nb.scode.tanyasoal.models;

/**
 * Created by User on 1/2/2017.
 */

public class question {
    private int subjek;
    private int lvl;
    private int jawaban;

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    private int periode;
    private String nama,tutor,soal;

    public long getSisaw() {
        return sisaw;
    }

    public void setSisaw(long sisaw) {
        this.sisaw = sisaw;
    }

    private long sisaw;

    public int getSubjek() {
        return subjek;
    }

    public void setSubjek(int subjek) {
        this.subjek = subjek;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getJawaban() {
        return jawaban;
    }

    public void setJawaban(int jawaban) {
        this.jawaban = jawaban;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }
}
