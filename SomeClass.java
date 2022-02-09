public class SomeClass {
    public static String reverse(String theString) {
        String tempStr = "";
        for(int i = theString.length()-1; i>0; i--) {
            tempStr += theString.charAt(i);
        }
        return tempStr;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello There"));
    }
}