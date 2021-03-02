package com.chan.common;

public class StringUtil {
    /**
     * @package : com.chan.common
     * @method : getString
     * @comment : 문자열로 변환
     * @date : 2021-02-26 오후 6:22
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public static String getString(Object obj){
        if(obj == null || obj.toString().equals("")) {
            return "0";
        } else {
            if ("".equals(obj.toString())){
                return "0";
            } else {
                return obj.toString();
            }
        }
    }

    /**
     * @package : com.chan.common
     * @method : getInt
     * @comment : 정수형으로 변환
     * @date : 2021-02-26 오후 6:22
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public static int getInt(Object obj){
        if(obj == null || obj.toString().equals("")) {
            return 0;
        } else {
            if (Integer.parseInt(obj.toString()) <= 0){
                return 0;
            } else {
                return Integer.parseInt(obj.toString());
            }
        }
    }
}
