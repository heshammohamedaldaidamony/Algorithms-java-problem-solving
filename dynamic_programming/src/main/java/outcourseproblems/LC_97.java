package outcourseproblems;

import java.util.HashMap;

//general range problem
public class LC_97 {
    HashMap<String,Boolean> memo=new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        return dp(s1,s2,s3);
    }
    public boolean dp(String s1, String s2, String s3){
        if (s1.length()==0 && s2.length()==0 && s3.length()==0)
            return true;
        if (s3.length()==0)
            return false;

        String key=s1+"|"+s2+"|"+s3;
        if (memo.containsKey(key))
            return memo.get(key);

        boolean str1=false;
        if(!s1.isEmpty() && s1.charAt(0)==s3.charAt(0))
            str1=dp(s1.substring(1),s2,s3.substring(1));
        boolean str2 = !s2.isEmpty() &&  s2.charAt(0)==s3.charAt(0) && dp(s1,s2.substring(1),s3.substring(1));

        memo.put(key,str1||str2);
        return memo.get(key);  //it is or : if at any call it returns false the whole answer will be false although the correct answer is true ;
    }
}
