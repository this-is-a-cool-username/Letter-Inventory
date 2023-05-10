
public class LetterInventory{

    private int[] inventory;
    private int size;

    public LetterInventory (String data){
        size = 0;
        inventory = new int[26];

        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++){
            if(data.charAt(i) >= 'a' && data.charAt(i) <= 'z'){
                inventory[data.charAt(i)-'a']++;
                size++;
            }
        }



    }

    public int get (char letter){
        if(!Character.isLetter(letter))
            throw new IllegalArgumentException("the letter is not valid");

        letter = Character.toLowerCase(letter);
        return inventory[letter-'a'];


    }
    public void set (char letter, int value){
        if(!Character.isLetter(letter) || value < 0)
            throw new IllegalArgumentException("the string or number is not valid");

        letter = Character.toLowerCase(letter);
        size -= inventory[letter-'a'];
        inventory[letter-'a'] = value;
        size += value;

    }


    public int size (){
        return size;
    }

    public boolean isEmpty (){
        if(size == 0)
            return true;

        return false;
    }

    public String toString(){

        String result = "[";
        for(int i = 0; i < inventory.length; i++){
            int x = inventory[i];
            char u = (char)(i+'a');
            for(int j = 0; j < x; j++){
                result += u;
            }
        }
        return result + "]";

    }

    public LetterInventory add (LetterInventory other){
        LetterInventory sum = new LetterInventory("");
        for(int i = 0; i < 26; i++){
            int thisNum = inventory[i];
            char u = (char)(i+'a');
            int otherNum = other.get(u);
            sum.set(u,thisNum+otherNum);
        }

        return sum;
    }

    public LetterInventory subtract (LetterInventory other){
        LetterInventory minus = new LetterInventory("");
        for(int i = 0; i < 26; i++){
            int thisNum = inventory[i];
            char u = (char)(i+'a');
            int otherNum = other.get(u);
            if(thisNum - otherNum < 0)
                return null;

            minus.set(u,thisNum-otherNum);
        }

        return minus;
    }




}
