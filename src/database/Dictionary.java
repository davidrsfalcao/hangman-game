package database;

public class Dictionary {
    private static Dictionary ourInstance = new Dictionary();

    public static Dictionary getInstance() {
        return ourInstance;
    }

    private Dictionary() {
    }


    public enum Category {
        animal, countrie, object, brand, job,
    }

}
