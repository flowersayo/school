#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//정렬할 배열, 정렬한 배열
vector<int> arr, sorted;
int cnt;
//start ~ end 사이의 원소를 출력하는 함수
void printArr(int start, int end, string tag) {
    cout << tag << " array : ";
    for (int i = start; i <= end; i++)
        cout << arr[i] << ' ';
    cout << '\n';
}

//합치기 
void merge(int left, int mid, int right) {
   
    int i = left;
    int j = mid + 1;
    int k = i; 

    while (i<=mid&&j<=right) {

        if (arr[i] < arr[j]) 
        {
            sorted[k++] = arr[i++];
           
        }
        else {

            sorted[k++] = arr[j++];
            
        }
    }    
    
   

    while (i <= mid) // 왼쪽 배열에 탐색하지 않은 원소가 있다면
    {
        sorted[k++] = arr[i++]; //차례대로 대입
    }
   
    while (j <= right) // 오른쪽 배열에 탐색하지 않은 원소가 있다면
    {
        sorted[k++] = arr[j++]; //차례대로 대입
    }



    //기존배열에 정렬된값 복사

    for (int t = left; t <= right; t++)
        arr[t] = sorted[t];

   

        
}

//일단 반으로 나누고(divide) 나중에 다시 합치면서 정렬.
void mergeSort(int left, int right) {
  
    cnt++;
   
    if (left < right) // 배열의 크기가 1이 아니라면
    {

        int m = (left + right) / 2; //반으로 쪼갠다.
        mergeSort(left, m);
        mergeSort(m, right);
        merge(left, m, right);

    }

}

int main() {
    int n;

    //입력
    cin >> n;
    arr.assign(n, 0);
    sorted.assign(n, 0);
    for (int i = 0; i < n; i++)
        cin >> arr[i];

   
    mergeSort(0, n - 1); //합병정렬
    //sort(arr.begin(), arr.end());

    //출력
    for (int i = 0; i < n; i++)
        cout << arr[i] << '\n';


}
