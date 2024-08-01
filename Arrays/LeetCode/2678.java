class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String detail : details){
        int a  = detail.charAt(11) - '0';
        int b  = detail.charAt(12) - '0';
        int age = a * 10 + b;
        if(age>60){
            count++;
        }
        }
return count;

    }
}
