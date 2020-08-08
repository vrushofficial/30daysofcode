package day6;


class LongestPrefix {

    /*Approch 1:
    Horizonta Scanning
            lcp(str[n1],str[n2]) =lcp(lcp(lcp(str[0],str[1]),str[2]),str[3)]
    TP = O(n) where is is each charecter in all strings
    */

    public static   String longestCommonPrefixAP1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /*Approch 2:
    Divide and conquer
            lcp(str[n1],str[n2]) =lcp(lcp(str[1],str[k]),lcp(str[k1],str[n])
    TP = O(n) where is is each charecter in all strings
    */

    public static String longestCommonPrefixAP2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
    public static void main(String[] args) {

        String[] input={"vrushabhjoshi","vrushabh","vrush","vru"};
        System.out.println(longestCommonPrefixAP2(input));

    }
}