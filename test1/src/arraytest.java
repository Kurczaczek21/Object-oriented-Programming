public class arraytest {
    String[] names = new String[4];
    Integer[] numbers = new Integer[4];

    names[0]="Kuba";
    names[1]="Marek";
    names[2]="Jan";
    names[3]="Mateusz";

    numbers[0]=24;
    numbers[1]=33;
    numbers[2]=54;
    numbers[3]=75;

    for (int i=0;i<4;i++){
        System.out.println(names[i]+" "+numbers[i]);
    }
    for(String name : names){
        System.out.println(name);
    }
}
