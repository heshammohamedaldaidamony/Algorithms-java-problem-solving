package graph.homework.homework2;

public class From {
    String from;
    To[] to = new To[26];


    public void setTo (String to , int cost){
        int toIndex=to.charAt(0)-'a';
        if(this.to[toIndex]==null)
            this.to[toIndex]=new To();
        this.to[toIndex].to=to;
        this.to[toIndex].setCost(cost);



    }
}
