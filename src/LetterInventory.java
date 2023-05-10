//Aaron Vadnais
//5-7-2023
//CS145
//Lab 3: Letter Inventory
//This project focuses on a single class that modifies the value of a letter inventory array

public class LetterInventory{ //letter inventory class with data field "inventory" and "size"

    private int[] inventory;
    private int size;

    public LetterInventory (String data){//constructor method
        size = 0;
        inventory = new int[26];//initializes inventory array and uses ascii table character to add values to array

        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++){
            if(data.charAt(i) >= 'a' && data.charAt(i) <= 'z'){
                inventory[data.charAt(i)-'a']++;
                size++;
            }
        }

    }

    public int get (char letter){  //accessor method for specific letter in inventory
        if(!Character.isLetter(letter))
            throw new IllegalArgumentException("the letter is not valid");

        letter = Character.toLowerCase(letter);
        return inventory[letter-'a'];//returns count of specific letter


    }
    public void set (char letter, int value){ //mutator method changes the value specific letter
        if(!Character.isLetter(letter) || value < 0)
            throw new IllegalArgumentException("the string or number is not valid");

        letter = Character.toLowerCase(letter);
        size -= inventory[letter-'a'];
        inventory[letter-'a'] = value;
        size += value;

    }


    public int size (){//returns the size of inventory
        return size;
    }

    public boolean isEmpty (){//if inventory is empty, returns true
        if(size == 0)
            return true;

        return false;
    }

    public String toString(){//returns alphabetically ordered string of inventory with all values included

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

    public LetterInventory add (LetterInventory other){//combines two inventory objects and adds their counts.
        LetterInventory sum = new LetterInventory("");
        for(int i = 0; i < 26; i++){
            int thisNum = inventory[i];
            char u = (char)(i+'a');
            int otherNum = other.get(u);
            sum.set(u,thisNum+otherNum);
        }

        return sum;
    }

    public LetterInventory subtract (LetterInventory other){//subtracts this inventory from other, if possible
        LetterInventory minus = new LetterInventory("");//returns null if this - other < 0
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


    //github https://github.com/this-is-a-cool-username/Letter-Inventory

}
