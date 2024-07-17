package range;

//
public class LC_1105 {
    int[] memo;
    int[][] books;
    int shelfWidth;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        memo=new int[books.length];
        for (int i =0 ; i<memo.length ; i++)
            memo[i]=-1;

        this.books=books;
        this.shelfWidth=shelfWidth;

        return dp(0);
    }
    public int dp(int idx){
        if(idx==books.length)
            return 0;
        if(memo[idx]!=-1)
            return memo[idx];

        memo[idx]=Integer.MAX_VALUE;
        int rowHeight=0;
        int totalWidth=0;
        for (int i=idx ; i<books.length ; i++){
            totalWidth+=books[i][0];
            rowHeight=Math.max(rowHeight,books[i][1]);

            if(totalWidth>shelfWidth)
                break;

            memo[idx]=Math.min(memo[idx] , rowHeight+ dp(i+1 ));
        }
        return memo[idx];
    }

    public static void main(String[] args) {
        int[][] books={{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        System.out.println(new LC_1105().minHeightShelves(books,4));
    }
}
