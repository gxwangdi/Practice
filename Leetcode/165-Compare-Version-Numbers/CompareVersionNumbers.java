public class CompareVersionNumbers {
    
    public int compareVersion(String version1, String version2) {
    String[] arr1 = version1.split("\\.");
    String[] arr2 = version2.split("\\.");
 
    int i=0;
    while(i<arr1.length || i<arr2.length){
        if(i<arr1.length && i<arr2.length){
            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                return -1;
            }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                return 1;
            }
        } else if(i<arr1.length){
            if(Integer.parseInt(arr1[i]) != 0){
                return 1;
            }
        } else if(i<arr2.length){
           if(Integer.parseInt(arr2[i]) != 0){
                return -1;
            }
        }
 
        i++;
    }
 
    return 0;
}
    
    /*
    public int compareVersion(String version1, String version2) {
        if (version1==null || version1.length()<1 || version2==null || version2.length()<1) {
            return 0;
        }
        // String[] v1 = version1.split("\\.");
        String[] v1 = version1.split("[.]");
        // String[] v2 = version2.split(Pattern.quote("."));
        String[] v2 = version2.split("\\.");
        
        int iV1 = Integer.parseInt(v1[0]);
        int iV2 = Integer.parseInt(v2[0]);
        
        if (iV1 > iV2) {
            return 1;
        }
        if (iV1 < iV2) {
            return -1;
        }
        
        if (v1.length <2 && v2.length <2) {
            return 0;
        }
        
        if (v1.length <2) {
            if (Integer.parseInt(v2[1]) == 0) 
                return 0;
            return -1;
        }
        
        if (v2.length <2) {
            if (Integer.parseInt(v1[1]) == 0)
                return 0;
            return 1;
        }
        
        int fV1 = Integer.parseInt(v1[1]);
        int fV2 = Integer.parseInt(v2[1]);
        if (fV1 > fV2) {
            return 1;
        }
        if (fV1 < fV2) {
            return -1;
        }
        return 0;
    }*/
    
    /*
    public int compareVersion(String version1, String version2) {
        // for invalid input, return 0
        if (version1==null || version1.length()<1 || version2==null || version2.length()<1) {
            return 0;
        }
        
        try {
            float v1 = Float.parseFloat(version1);
            float v2 = Float.parseFloat(version2);
            if (v1 > v2) {
                return 1;
            } else if (v2 > v1) {
                return -1;
            } else {
                String dot = ".";
                int dot1 = version1.indexOf(dot);
                int dot2 = version2.indexOf(dot); 
                if (dot1 <0) {
                    return 0;
                }
                
                dot1 = version1.length() - dot1;
                dot2 = version2.length() - dot2;
                if (dot1 > dot2) {
                    return 1;
                } else if (dot2 > dot1) {
                    return -1;
                } else {
                    return 0;
                }
            }
        } catch (Exception e) {
            return 0;
        }
    }
    */
}// end of Solution class    



