package problems;

public class TowerOfHanoi {
    public void towerOfHanoi(int n, char from , char to  ,char aux){
        if (n==0)
            return;
        towerOfHanoi(n-1,from,aux,to);
        System.out.println("Move disk " + n + " From "+from +" To "+to);
        towerOfHanoi(n-1,aux,to,from);
    }

    public static void main(String[] args) {
        new TowerOfHanoi().towerOfHanoi(3,'A','C','B');
    }
}
