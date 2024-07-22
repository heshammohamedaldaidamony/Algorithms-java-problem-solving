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


        int result=dp(0,0);
        if (result<0)
            return 1-result;
        else
            return 1;
    }
    public int dp(int r, int c ){
        if(r>=dungeon.length || c>=dungeon[r].length)  //just valid right and down directions
            return Integer.MAX_VALUE/2;
        if (r==dungeon.length-1 && c==dungeon[r].length-1)
            return dungeon[dungeon.length-1 ][dungeon[r].length-1];

        int right=dp(r,c+1 );
        int down=dp(r+1,c);
        boolean flagPositiveResult=true;
        if(right<0){
            flagPositiveResult=false;
            right=Math.abs(right);
        }
        if(down<0){
            flagPositiveResult=false;
            down=Math.abs(down);
        }

        int result=Math.min(right,down);
        if (flagPositiveResult)
            return dungeon[r][c]+result;
        return  dungeon[r][c]+result*-1;
    }


    public static void main(String[] args) {
        int [][] dungeon={{-3,5}};
        System.out.println(new LC_174().calculateMinimumHP(dungeon));
    }
}
