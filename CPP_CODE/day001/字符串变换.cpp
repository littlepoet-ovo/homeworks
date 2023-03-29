//https://codeforces.com/contest/1704/problem/A
#include <bits/stdc++.h>
using namespace std;
int main(){
    int t;
    cin >> t;
    while(t--){
        int n,m;
        cin >> n >> m;
        vector<int> a,b;
        for(int i=0;i<n;i++){
            char x;
            cin >> x;
            a.push_back(x-'0');
        }
        for(int i=0;i<m;i++){
            char x;
            cin >> x;
            b.push_back(x-'0');
        }
        if(n<m){
            cout << "NO" << endl;
            continue;
        }
        int flag=1;
        int det = n-m;
        int flag2=1;
        for(int i=m-1;i>0;i--){
            if(a[det+i]!=b[i])flag=0;
        }
        if(flag){
            for(int i=0;i<det+1;i++){
                if(a[i]==b[0]){
                    cout << "YES" << endl;
                    flag2=0;
                    break;
                }
            }
            if(flag2) cout << "NO" << endl;
        }else{
            cout << "NO" << endl;
        }
        
    }  
    system("pause");
    return 0;
}
