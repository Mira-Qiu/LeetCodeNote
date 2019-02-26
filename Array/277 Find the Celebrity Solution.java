/*
1. Find a candidate by one pass: make sure people are not a celebrity
2. make sure if the candidate is a celebrity by one pass
*/

/** Time = O(n)
**/
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
