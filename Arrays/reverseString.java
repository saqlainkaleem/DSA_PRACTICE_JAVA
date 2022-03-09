public class reverseString {
    public static void main(String[] args) {
        String name = "KALEEM", rname = "";
        char temp;
        for (int i = 0; i <name.length(); i++) {
            temp=name.charAt(i);
            rname=temp+rname;
        }
        System.out.println(rname);
    }
}
