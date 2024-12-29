class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<numRows; i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            if(i == 0) {
                res.add(arr);
            }
            else if(i == 1) {
                arr.add(1);
                res.add(arr);
            }
            else {
                List<Integer> prev = res.get(i-1);
                for(int j=prev.size()-1; j>0; j--) {
                    System.out.println(j + " ");
                    arr.add(prev.get(j) + prev.get(j-1));
                }
                arr.add(1);
                res.add(arr);
            }
            
        } 
        return res;
    }
}