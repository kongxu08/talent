package com.util;


public class CovertCompany {

    /**
     * @param args
     */


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String aaa = "/长江设计院/院(集团)总部/院领导";
        String bbb = "/长江设计院/长江设计公司/工程治理中心/工程治理中心工程安全研究室";
        String ccc = "/长江设计院/岩土公司/地质公司/地质三室";
        String eee = "/长江设计院";

        System.out.println(doCnvertDisplayName(aaa));
        System.out.println(doCnvertDisplayName(bbb));
        System.out.println(doCnvertDisplayName(ccc));
        System.out.println(doCnvertDisplayName(eee));
    }

    public static String doCnvertDisplayName(String displayPath) {
        String need3a = "/长江设计院/院(集团)总部";
        String need3b = "/长江设计院/院(集团)属职能部门";
        String need3c = "/长江设计院/长江设计公司";
        String[] sourceStrArray = displayPath.split("/");

        if (sourceStrArray.length > 2) {
            if (displayPath.contains(need3a) || displayPath.contains(need3b) || displayPath.contains(need3c)) {
                return sourceStrArray[3];
            } else
                return sourceStrArray[2];
        } else return sourceStrArray[1];
    }

    //是否是职能部门
    public static boolean isFunctionalDepartment(String displayPath) {
        String functionalDepartmentId = "DA9B70DC-0211-43CA-A528-79ECE07CB414";
        boolean b = displayPath.indexOf(functionalDepartmentId)==-1?false:true;
        return b;
    }
}
