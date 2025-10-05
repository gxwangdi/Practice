import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length()==0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append("/");
        String[] stubs = path.split("/+");
        List<String> dirs = new ArrayList<>();
        for (String s : stubs) {
            if ("..".equals(s)) {
                if (dirs.size() > 0) {
                    dirs.remove(dirs.size()-1);
                }
            } else if (!".".equals(s) && !"".equals(s)) {
                dirs.add(s);
            }
        }
        for (String s : dirs) {
            res.append(s+"/");
        }
        if (res.length() > 1) {
            res.deleteCharAt(res.length()-1);
        }
        return res.toString();
    }
}





