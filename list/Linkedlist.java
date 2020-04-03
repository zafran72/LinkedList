public class Linkedlist {
    private Node head;
    private int size;

    public Linkedlist() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return this.head;
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int getSize() {
        return this.size;
    }

    public void addData(String editor){
        Node isFound = this.searchData(editor);

        if(isFound == null){
            this.setHead(new Node(new Data(editor), this.getHead()));
            this.incSize();
        }else{
            isFound.getData().addFreq();
        }
            
    }

    public Node searchData(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getNama().contains(editor))
                return current;
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }

        return null;
    }

    public void searchAllEditor(String editor){
        Node current = this.getHead();
        int number = 1;
        boolean check = false;
        
        while(current != null){
            if(current.getData().getNama().contains(editor)){
                System.out.println(number + ". " + current.getData().getNama() + " mengedit artikel sebanyak " + current.getData().getFreq() + ".");
                number++;
                check =  true;
            }
            current = current.getNext();
        }

        if(!check) {
            System.out.println("Data " +editor+ " tidak ditemukan");
        }
    }

    public String fetchData(String editor){
        Node found = this.searchData(editor);

        if(found != null){
            return found.getData().getNama() + " mengedit " + found.getData().getFreq() + " artikel";
        }else{
            return "Data " + editor + " tidak ditemukan.";
        }
    }

    public void fetchAllData(String editor){
        Node found = this.searchData(editor);

        if(found != null){
            System.out.println(this.fetchData(editor));
            found.getData().displayArticle();
        }else{
            System.out.println("Data " + editor + " tidak ditemukan.");
        }
    }

    public void BubbleSort() {
        Node current = this.getHead();
        
        while (current.getNext() != null) { 
            Node next = current.getNext();         
            while (next != null) {
                if (current.getData().getNama().compareTo(next.getData().getNama()) > 0) {
                    Data tmp = current.getData();
                    current.setData(next.getData());
                    next.setData(tmp);
                }
                next = next.getNext();
            }
            current = current.getNext();
            next = current.getNext();
        }
    }

    public void display() {
        Node current = this.getHead();

        while (current != null) {
            System.out.println(current.getData().getNama() + " mengedit " + current.getData().getFreq() + " artikel");
            current = current.getNext();
        }
    }
}