//1491. Average Salary Excluding the Minimum and Maximum Salary

class Solution {
    public double average(int[] salary) {
        double MaxSalary=0, MinSalary=Integer.MAX_VALUE,Total=0;
        for(int i=0;i<salary.length;i++){
            if(salary[i]>MaxSalary){
                MaxSalary=salary[i];
            }
            if(salary[i]<MinSalary){
                MinSalary=salary[i];
            }
        }
        for(int i=0;i<salary.length;i++){
            Total+=salary[i];
        }
        return (Total-MaxSalary-MinSalary)/(salary.length-2);
    }
}
