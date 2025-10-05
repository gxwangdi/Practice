class Solution {
public:
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A>G || E>C) {
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        if (F>D || B>H) {
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        int right = min(C,G);
        int left = max(A,E);
        int top = min(H,D);
        int bottom = max(F,B);

        return (G-E)*(H-F) + ((C-A)*(D-B) - (right-left)*(top-bottom));
    }
};
