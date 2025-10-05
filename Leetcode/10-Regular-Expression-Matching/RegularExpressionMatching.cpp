class Solution {
public:
    bool isMatch(string s, string p) {
        if (p.empty()) { // exit strategy
            return s.empty();
        }
        
        if (p.length() ==1 || p.at(1) != '*') { // compare 0 or more char
            if (s.empty() || (p.at(0) != '.' && p.at(0) != s.at(0))) {
                return false;
            } else {
                return isMatch(s.substr(1), p.substr(1));
            }
        }
        
        while ( !s.empty() && (s.at(0)==p.at(0) || p.at(0) == '.')) {
            if (isMatch(s, p.substr(2))) {
                return true;
            }
            s = s.substr(1);
        }
        
        return isMatch(s, p.substr(2));
    }
};

