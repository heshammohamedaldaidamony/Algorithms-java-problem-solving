package grid;

public class LC_174 {
    int[][] dungeon;
    Boolean[][][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        int negatives=-1;
        for (int i =0 ; i<dungeon.length ; i++)
            for (int j=0 ; j<dungeon[i].length;j++)
                if (dungeon[i][j]<0)
                    negatives+=dungeon[i][j];
        negatives=Math.abs(negatives);

        this.dungeon=dungeon;
        this.memo=new Boolean[dungeon.length][dungeon[0].length][1000*200];

        //reverse thinking
        int result=1;
        for (int i=negatives; i>0 ; i--)
            if(dp(0,0,i))
                result=i;    //without any minimizaton so the i less by itself

        return result;
    }
    public boolean dp(int r, int c , int health){
        if(r>=dungeon.length || c>=dungeon[r].length)  //just valid right and down directions
            return false;
        if(health+dungeon[r][c]<=0)
            return false;
        if (health>=1 && r==dungeon.length-1 && c==dungeon[r].length-1)
            return true;
        if (memo[r][c][health]!=null)
            return memo[r][c][health];

        boolean right= dp(r,c+1 ,health+dungeon[r][c]);
        boolean down=dp(r+1,c,health+dungeon[r][c]);

        memo[r][c][health]=right||down;
        return  memo[r][c][health];
    }


    public static void main(String[] args) {
        int [][] dungeon={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new LC_174().calculateMinimumHP(dungeon));
    }
}
