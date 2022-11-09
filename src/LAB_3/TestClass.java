import java.util.Calendar;

public class TestClass {

    private int objectId;
    private long whenCreated;
    private static int count=0;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Brak argumentów programu.");
            System.exit(0);
        }
        int objectsToCreate = Integer.parseInt(args[0]);

        for (int i = 0; i < objectsToCreate; i++) {
            TestClass testObj = new TestClass();
            System.out.printf("%d. [%d]\n", testObj.objectId, testObj.whenCreated);
        }
    }

    public TestClass(){
        ++count;
        this.objectId=count;
        this.whenCreated= Calendar.getInstance().getTimeInMillis();
    }

    public int getObjectId() {
        return objectId;
    }

    public long getWhenCreated() {
        return whenCreated;
    }

}
