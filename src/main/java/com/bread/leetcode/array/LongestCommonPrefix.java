package com.bread.leetcode.array;

/**
 * @program: leet-code-notes
 * @description: 14题 最长公共前缀
 * @author: LiuTuo
 * @create: 2022-04-04 16:35
 **/
public class LongestCommonPrefix {
    public String longestCommonPrefixlongestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        //假设最长公共前缀为数组第一位
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            prefix=longestCommonPrefixlongest(prefix,strs[i]);
            if(prefix==""){
                return prefix;
            }
        }

        return prefix;
    }

    //获取两个字符串最长前缀
    public String longestCommonPrefixlongest(String str1,String str2) {
        int index=0;
        int length=Math.min(str1.length(),str2.length());
        for(int i=0;i<length;i++){
            if(str1.charAt(i)==str2.charAt(i)){
                index++;
            }else {
                break;
            }
        }
        if(index==0){
            return "";
        }else{
            return str1.substring(0,index);
        }
    }
}
