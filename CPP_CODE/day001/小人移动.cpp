#include <iostream>
#include <cmath>
using namespace std;
int main(){
    int t;
    cin >> t;
    while(t--){
        int x;
        cin >> x;
        int ans;
        switch(x){
            case 1:ans=2;break;
            case 2:case 3:ans=1;break;
            default : ans = ceil(x/3.0); 
        }
        cout << ans << endl;
    }
    
    system("pause");
    return 0;
}
