class Solution {
    public String[] reorderLogFiles(String[] logs) {

        // sort the array
        Arrays.sort(logs, (a,b)->{
            String[] aa = a.split(" ", 2);
            String[] bb = b.split(" ", 2);
            
            boolean aIsDigit = Character.isDigit(aa[1].charAt(0));
            boolean bIsDigit = Character.isDigit(bb[1].charAt(0));

            // If both are digit-log, then keep it in original order
            if(aIsDigit && bIsDigit)
                return 0;
            // put the digit-log behind letter-log
            else if(aIsDigit)
                return 1;
            else if(bIsDigit)
                return -1;
            // If both are letter-log, then compare the log content firstly, finally compare identifier if necessary.
            else{
                int res = aa[1].compareTo(bb[1]);
                if(res == 0)
                    return aa[0].compareTo(bb[0]);
                
                return res;
            }
        });
        
        return logs;
    }
}