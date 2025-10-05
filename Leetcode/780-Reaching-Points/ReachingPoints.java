

class ReachingPoints {
    // public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    //     if (sx > tx || sy > ty) return false;
    //     if (sx == tx && sy == ty) return true;
    //     return reachingPoints(sx+sy, sy, tx, ty) || reachingPoints(sx, sx+sy, tx, ty);
    // }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }
}
