//https://codeforces.com/problemset/problem/1806/A
    #include <bits/stdc++.h>
    using namespace std;
    int main(){
        ios::sync_with_stdio(false);
        int t;
        cin >> t;
        while(t--){
            int flag=1;
            int a,b,c,d;
            cin >> a >> b >> c >> d;
            int cnt=0;
            if(d>b){
                cnt += d-b;
                b=d;
                a += cnt;
            }
            if(a>c){
                cnt += a-c;
                a=c;
            }

            if(a==c && b==d){
                cout << cnt << endl;
                flag = 0;
            }

            if(flag) cout << -1 << endl;
        }
        system("pause");
        return 0;
    }
