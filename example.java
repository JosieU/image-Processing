class PerfectSnt {
    public static boolean  square(double a){
        
        int b = (int) Math.sqrt(a);
        if (b * b == a){
            return true;
        }
        return false;
    }
    public static void main(String []args){
        System.out.println(square(16));
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory() - runtime.freeMemory());
        
    }

}