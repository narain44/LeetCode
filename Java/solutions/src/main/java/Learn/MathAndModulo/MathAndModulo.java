package Learn.MathAndModulo;

public class MathAndModulo {
    public static void main(String []args){
        int r=1,c=2,NC=Integer.MIN_VALUE;
        int NRC=r*NC+c;
        System.out.println("Row is"+NRC/NC);
        System.out.println("Column is"+NRC%NC);
    }
}
