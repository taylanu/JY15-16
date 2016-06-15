import java.util.ArrayList;

public class WordList {
    private ArrayList myList;

    public WordList() {
        myList = new ArrayList();
    }

    public static void main(String[] args) {
        System.out.println("******* A-1 *******");
        WordList w = new WordList();
        w.add("cat");
        w.add("mouse");
        w.add("frog");
        w.add("dog");
        w.add("dog");
        System.out.println(w + " " +
                w.numWordsOfLength(4) + " " +
                w.numWordsOfLength(3) + " " +
                w.numWordsOfLength(2));
        w.removeWordsOfLength(4);
        System.out.println(w);
        w.removeWordsOfLength(3);
        System.out.println(w);
        w.removeWordsOfLength(2);
        System.out.println(w);
    }

    public void add(String word) {
        myList.add(word);
    }

    // A-1, (a)

    public String toString() {
        return myList.toString();
    }

    // A-1, (b)

    public int numWordsOfLength(int len) {

    }

    public void removeWordsOfLength(int len) {

    }
}
