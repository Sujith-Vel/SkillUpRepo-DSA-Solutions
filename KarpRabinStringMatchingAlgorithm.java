package DSA.Algorithms;

public class KarpRabinStringMatchingAlgorithm {

    public static final int PRIME = 10;

    public static void main(String[] args) {
        String word1 = "man";
        String word2 = "supermanworld";

        System.out.println(stringMatching("zzlfnrkg","xzzlfnrkguo"));

        //11862896920

        System.out.println(getHashVal("mma")); // 1000615
        System.out.println(getHashVal("man")); // 1132016
        System.out.println(updateHash(1000615 , 'm','n',3));


    }

    public static boolean stringMatching(String string , String mainString ){

        double hashValOfString = getHashVal(string);
        double hash = getHashVal(mainString.substring(0,string.length()));

        for (int i = 0; i < mainString.length()-string.length()+1; i++) {

            if(hash == hashValOfString){
                if(string.equals(mainString.substring(i,i+string.length()))) {
                    return true;
                }
            }

            if(i+string.length()<mainString.length()) // man  superman  i=0
           hash = updateHash(hash , mainString.charAt(i),  mainString.charAt(i+string.length())  , string.length());

        }

        if(string.equals(mainString.substring(mainString.length()-string.length()))) {
            return true;
        }

        return false;
    }

    private static double updateHash(double prevHash, char oldChar , char newChar , int patternLen) {

        double newHash = (prevHash - oldChar)/PRIME;
        newHash = newHash + newChar *  Math.pow(PRIME,patternLen-1);

        return  newHash;
    }

    private static double getHashVal(String string) {

        double hash = 0;
        for (int i = 0; i < string.length(); i++) {
            hash = (hash + string.charAt(i) * Math.pow(PRIME , i));
        }

        return hash;
    }

}
