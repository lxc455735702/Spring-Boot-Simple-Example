package com.example.simple_lxc.leetCode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * @Description:
 * @Author: lxc 672063
 * @CreateTime: 2021-12-13 15:04
 * @Email: 18867762063@163.com
 */
@Slf4j
public class LeetCode {

    @Test
    public void test() {
        // String[] params =new String[]{"flower","flow","flight"};
        String[] params = new String[]{"a"};

        log.info("result->{}", longestCommonPrefix(params));
    }

    @Test
    public void Solution() {
        String result = thousandSeparator(12345);
        log.info("Solution result {}", result);
    }


    public String thousandSeparator(int n) {
        String content = n + "";
        if (content.length() < 4) {
            return content;
        }
        int index = content.length() / 3;
        int flag = content.length() % 3;
        if (index > 0) {

            if (flag == 0 && index > 1) {
                index = index - 1;
            }
            flag = flag == 0 ? 3 : flag;
            String temp = content.substring(0, flag);
            for (int i = 0; i < index; i++) {
                temp += "." + content.substring(flag + 3 * i, flag + 3 * (i + 1));
            }
            return temp;
        }
        return content;
    }


    public String longestCommonPrefix(String[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int minLength = 0;
        for (String item : array) {
            if (minLength == 0) {
                minLength = item.length();
            } else {
                if (item.length() < minLength) {
                    minLength = item.length();
                }
            }
        }
        String allStr = "";
        int index = 0;
        while (index < minLength) {
            for (int i = 0; i < minLength; i++) {
            }
        }
        return allStr;
    }
}
