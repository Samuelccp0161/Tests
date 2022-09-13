package Exercise_9;


public class Name {

    String string;
    public Name(String str){
        this.string = str;
    }
    @Override
    public boolean equals(Object obj){
        if (obj.getClass() != this.getClass())
            return false;
        Name tht = (Name) obj;
        if(string.equals(tht.string))
            return true;
        return false;
    }
    @Override
    public int hashCode(){
        final int hashMultiplier = 41;
        int result = 7;
        result = result * hashMultiplier;
        return result;
    }
}
