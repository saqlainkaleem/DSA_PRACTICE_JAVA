#include<iostream>
using namespace std;
int sqroot(int x){
    int start=1,end=x,result=0;
    if(x<=0){
        return x;
    }
    while(start<=end){
      int mid=start+(end-start)/2;
        if(mid<=x/mid){
            result=mid;
            start=mid+1;
        }
        else{
            end=mid-1;
        }
    }
    return result;
}
int main(){
    int number=0;
    cout<<"Enter the Number : ";
    cin >> number;
    int result=sqroot(number);
    cout <<"Result is : "<<result<<endl;
    return 1;
}