package Learn.StringAndCharacter;

public class StringSubStringDemo {
    public static void main(String[] args) {
        String value = "abcd";
        System.out.println(value.substring(0));
        System.out.println(value.substring(0, 1));
        System.out.println(value.charAt(3));
        System.out.println(value.substring(0, 4));


        String test = "abcddddefg";
        System.out.println(test.substring(3, 6));

        String log1 = "a8 act zoo";
        String log2 = "g1 act car";
        String[] log1Split = log1.split(" ", 2);
        String[] log2Split = log2.split(" ", 2);
        System.out.println("Comparison of " + log1Split[0] + " and " + log2Split[0] + " :" + log1Split[0].compareTo(log2Split[0]));
        log1Split = log1.split(" ");
        log2Split = log2.split(" ");
        System.out.println("Comparison of " + log1Split[0] + " and " + log2Split[0] + " :" + log1Split[0].compareTo(log2Split[0]));
//        System.out.println(Arrays.toString(test1.split(" ")));
//        System.out.println(Arrays.toString(test2.split(" ")));
//        System.out.println(Arrays.toString(test1.split(" ",2)));
//        System.out.println(Arrays.toString(test2.split(" ",2)));
    }
}
