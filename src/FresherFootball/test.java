package FresherFootball;

public class test {
    public static void main (String[] args){
        DBManager db = new DBManager();
        db.nextAccountNum();
        db.setupAccount("Renee", "Brookeland", "NaeNae", "Inver56");
    }
}
