class Solution {
    public int[] prevPermOpt1(int[] A) {
        int biggerIdx = A.length - 2;
        
        // find the last bottom of the array
        // since you can make an ascending array smaller
        // the most significant digit is the left element of the bottom.
        // Once changed, we can get a smaller result
        while(biggerIdx >= 0 && A[biggerIdx] <= A[biggerIdx+1])
            --biggerIdx;
        
        // if cannot find the bottom, then just return A, as A is smallest already
        if(biggerIdx == -1)
            return A;
        
        // find out the first elements which is less than the A[biggerIdx]
        int firstLessIdx = A.length - 1;
        while(firstLessIdx > biggerIdx && A[firstLessIdx] >= A[biggerIdx])
            --firstLessIdx;
        
        // don't forget to skip the duplicate elements
        // as [3,1,1,3], the smaller one should be [1,3,1,3] instead of [1,1,3,3]
        while(firstLessIdx > biggerIdx+1 && A[firstLessIdx-1] == A[firstLessIdx])
            --firstLessIdx;
        
        //swap A[biggerIdx] and A[firstLessIdx]
        int tmp = A[biggerIdx];
        A[biggerIdx] = A[firstLessIdx];
        A[firstLessIdx] = tmp;
        
        return A;
    }
}