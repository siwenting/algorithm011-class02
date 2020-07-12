class Solution {
    private Set<Integer> lie=new HashSet<>();
    private Set<Integer> pie=new HashSet<>();
    private Set<Integer> na=new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        dfs(res,new ArrayList<String>(),n,0);
        return res;
    }

    public void dfs(List<List<String>> res,List<String> list,int n,int row) {
        if(row==n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int col=0;col<n;col++) {
            if(lie.contains(col)||pie.contains(row-col)||na.contains(row+col))
                continue;
            
            char[] ch=new char[n];
            Arrays.fill(ch,'.');
            ch[col]='Q';
            String s=new String(ch);

            list.add(s);
            lie.add(col);
            pie.add(row-col);
            na.add(row+col);

            dfs(res,list,n,row+1);

            list.remove(list.size()-1);
            lie.remove(col);
            pie.remove(row-col);
            na.remove(row+col);
        }
    }
}