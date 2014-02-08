package com.hlx.birdhouse.common.util;

import com.alibaba.common.lang.StringUtil;

public class MathUitl {

    /**
     * 转换成数值
     * 
     * @param value
     * @return
     */
    public static Integer str2Int(String str) {
        if (StringUtil.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
