/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair<T, V> {
    T first;
    V second;
    Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new LinkedList<>();

        q.add(new Pair<>(root, new Pair<>(0, 0)));

        while(!q.isEmpty()) {
            
            Pair<TreeNode, Pair<Integer, Integer>> pair = q.remove();
            TreeNode node = pair.first;
            int col = pair.second.first;
            int row = pair.second.second;

            if(!map.containsKey(col)) {
                Map<Integer, List> rowMap = new TreeMap<>();
                List<Integer> l = new ArrayList<>();
                l.add(node.val);
                rowMap.put(row, l);
                map.put(col, rowMap);
            }
            else {
                Map<Integer, List> rowMap = map.get(col);
                if(!rowMap.containsKey(row)) {
                    List<Integer> l = new ArrayList<>();
                    l.add(node.val);
                    rowMap.put(row, l);
                    map.put(col, rowMap);
                }
                else {
                    List l = rowMap.get(row);
                    l.add(node.val);
                }
                
            }

            if(node.left != null) {
                q.add(new Pair<>(node.left, new Pair<>(col-1, row+1)));
            }

            if(node.right != null) {
                q.add(new Pair<>(node.right, new Pair<>(col+1, row+1)));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Map<Integer, List> rowMap: map.values()) {
            List<Integer> temp = new ArrayList<>();
            for(List<Integer> l: rowMap.values()) {
                Collections.sort(l);
                for(Integer i: l) {
                    temp.add(i);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}