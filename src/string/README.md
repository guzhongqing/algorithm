KMP算法
解决字符串匹配问题


例题
/**
 * 28. 找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 中等
 * 暴力，KMP
 */

 /**
  * 459. 重复的子字符串
  * https://leetcode.cn/problems/repeated-substring-pattern/
  * 简单
  * 暴力,api，KMP
  */


  前缀：只包含首字母，不包含尾字母的所有子串
  前缀：只包含尾字母，不包含首字母的所有子串
  eg:abcd
  前缀:a,ab,abc
  后缀：d,cd,bcd


  前缀表(next，prefix)