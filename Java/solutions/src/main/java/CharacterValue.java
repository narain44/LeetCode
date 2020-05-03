public class CharacterValue {
    public static void main(String [] args){
        String text="ABZ";
        System.out.println("Value is "+text);
        System.out.println(text.charAt(0));
        System.out.println(text.charAt(2));
        System.out.println((int)text.charAt(0));
        System.out.println((int)text.charAt(2));
        System.out.println(Character.isLetter(text.charAt(0)));

        String number="129";
        System.out.println("Value is "+number);
        System.out.println((int)number.charAt(0));
        System.out.println((int)number.charAt(1));
        System.out.println(Character.isDigit(number.charAt(0)));
    }
}
