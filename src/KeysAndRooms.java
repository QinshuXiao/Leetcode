class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] canVisit = new boolean[n];
        Arrays.fill(canVisit, true);
        canVisit[0] = false;
        
        return visitRoom(0, rooms, canVisit);
    }
    
    private boolean visitRoom(Integer room, List<List<Integer>> rooms, boolean[] canVisit){
        boolean visitAll = true;
        for(int i = 0; i < rooms.size(); ++i){
            if(canVisit[i]){
                visitAll = false;
                break;
            }
        }
        if(visitAll)
            return true;
        
        for(int nextRoom : rooms.get(room)){
            if(canVisit[nextRoom] ){
                canVisit[nextRoom] = false;
                if(visitRoom(nextRoom, rooms, canVisit))
                    return true;
            }
        }
        
        return false;
    }
}