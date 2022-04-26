#include<iostream>
using namespace std;
int binarySearch(int arr[],int size,int key){
    int start=0,end=size-1;
    int mid=(start+end)/2;
    while (start<=end)
    {
        if(arr[mid]==key){
            return mid;
        }
        if(key>arr[mid]){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
    
    mid=(start+end)/2;
    }
    
    return -1;
}
int main(){
    int arr[5]={5,4,3,2,1};
    int key=5;
    int size = sizeof(arr)/sizeof(arr[0]);
    int index = binarySearch(arr,size,key);
    cout<<"Result is : "<<index;
    return 0;
}