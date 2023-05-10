
public class AVLetterTest{
    public static void main(String[] args){

        LetterInventory inventory1 = new LetterInventory("George W. Bush");

        LetterInventory inventory2 = new LetterInventory("Hillary Clinton");

        LetterInventory sum = inventory1.subtract(inventory2);
        System.out.println(sum.toString());

    }
}