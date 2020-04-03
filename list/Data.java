import java.util.LinkedList;

public class Data {
    private String nama;
    private int frekuensi;
    private Linkedlist artikel = new Linkedlist();

    public Data(String nama) {
        this.nama = nama;
        this.frekuensi = 1;
    }

    public String getNama() {
        return this.nama;
    }

    public int getFreq() {
        return this.frekuensi;
    }

    public void addFreq() {
        this.frekuensi++;
    }

    public void addArticle(String article) {
        this.artikel.addData(article);
    }

    public void displayArticle() {
        Node current = artikel.getHead();
        int nomor = 1;

        while (current != null) {
            System.out.println(nomor+". "+current.getData().getNama());
            current = current.getNext();
            nomor++;
        }
    }
}