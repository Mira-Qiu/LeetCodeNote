/*
1. Find a candidate by one pass: make sure people are not a celebrity
2. make sure if the candidate is a celebrity by one pass
*/

/** Time = O(n)
**/
/**
Second draft 2/25/2019
**/
public int findCelebrity(int n) {
    int celebrity = 0;

    for(int i = 1; i < n; i++){
        //檢查完代表兩件事
        //celebrity 以前的都不可能是celebrity 因為他們都認識celebrity 以前的其中一個人
        //celebrity 以後的他都不認識，因為如果認識的話 celebrity 早就被update了
        if(knows(celebrity, i)){
            celebrity = i;                  
        }
    }
    //check again if celebrities knows somebody
    for(int i = 0; i < celebrity; i++){
        //雖然celebrity 以前的都不可能是celebrity 因為他們都認識celebrity 前的一個人
        //但是我們必須檢查 celebrity 是否認識前面的任何一個人，如果有認識，-1
        //i != celebrity;
        //  if (!knows(i, candidate) 不用加因為就算在celebrities 之前有人不認識 celebritiy 他們也認識了期她的人 )    
    if(knows(celebrity, i)){
            return -1;   
        }
    }
    for(int i = celebrity + 1; i < n; i++){
        //雖然celebrity 以後的他都不認識
        //但是還是要檢查celebrity 以後的人是不是都認識他
        if(!knows(i, celebrity)){
            return -1;   
        }   
    }
    return celebrity;
}

/*
First draft 2/25/2019
*/
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        //find a candidate by one pass:
        for (int i = 0; i < n; i++){
            if (knows(candidate,i)){
                candidate = i;
            }
        }
        //make sure if the candidate is a celebrity by one pass
        for (int i = 0; i < n; i++){
            if (i == candidate) continue;
            if (!knows(i, candidate) || knows(candidate, i)){
                return -1;
            }
        }
        return candidate;
    }
}
