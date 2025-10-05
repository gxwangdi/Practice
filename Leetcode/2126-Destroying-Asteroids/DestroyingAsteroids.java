

class DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum=mass;
        for(int i=0;i<asteroids.length;i++){
            if(sum>=asteroids[i]){
                sum+=asteroids[i];

            }else{
                return false;
            }
        }
        return true;
    }
}
