import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner inp = new Scanner(System.in);

        try {
            File file = new File("../out/namefile.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String data = read.nextLine();
                String splitter[] = data.split(":");
                ll.addData(splitter[0]);
                ll.searchData(splitter[0]).getData().addArticle(splitter[1]);
                
            }
            read.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }  

        
        //tampilan program
        while(true){
            System.out.print("\n--------LinkedList Program--------\n\n1. Cari nama editor\n2. Tampilkan semua nama editor\n3. Tampilkan semua judul artikel editor\n4. Exit\nMasukkan Pilihan : ");
            int pilihan = Integer.parseInt(inp.nextLine());
            if(pilihan == 1){
                System.out.print("Masukkan nama editor : ");
                String editor = inp.nextLine();
                ll.searchAllEditor(editor);
            }else if(pilihan == 2){
                ll.BubbleSort();
                ll.display();
                System.out.println("");
            } else if(pilihan == 3){
                System.out.print("Masukkan nama editor : ");
                String editor = inp.nextLine();
                System.out.println("");
                ll.fetchAllData(editor);
            } else if(pilihan == 4) {
                System.exit(1);
            } else {
                System.out.println("Pilihan tidak ditemukan\n");
            }
        }
    }
}