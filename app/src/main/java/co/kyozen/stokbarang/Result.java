package co.kyozen.stokbarang;

public class Result {

    //Tabel Barang
    String id;
    String nama;
    String jml;

    //Tabel Barang Out
    String id_out;
    String id_barang;
    String jumlah;

    public String getId_out() {
        return id_out;
    }

    public void setId_out(String id_out) {
        this.id_out = id_out;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJml() {
        return jml;
    }

    public void setJml(String jml) {
        this.jml = jml;
    }
}
