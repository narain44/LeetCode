package ArraysStringsAtoi;

class solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] parsedInts = new int[32];
        int parsedIntsIndex = 0;
        boolean negative = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                parsedInts[parsedIntsIndex] = 1; parsedIntsIndex++;
            } else if (str.charAt(i) == '2') {
                parsedInts[parsedIntsIndex] = 2; parsedIntsIndex++;
            } else if (str.charAt(i) == '3') {
                parsedInts[parsedIntsIndex] = 3; parsedIntsIndex++;
            } else if (str.charAt(i) == '4') {
                parsedInts[parsedIntsIndex] = 4; parsedIntsIndex++;
            } else if (str.charAt(i) == '5') {
                parsedInts[parsedIntsIndex] = 5; parsedIntsIndex++;
            } else if (str.charAt(i) == '6') {
                parsedInts[parsedIntsIndex] = 6; parsedIntsIndex++;
            } else if (str.charAt(i) == '7') {
                parsedInts[parsedIntsIndex] = 7; parsedIntsIndex++;
            } else if (str.charAt(i) == '8') {
                parsedInts[parsedIntsIndex] = 8; parsedIntsIndex++;
            } else if (str.charAt(i) == '9') {
                parsedInts[parsedIntsIndex] = 9; parsedIntsIndex++;
            } else if (str.charAt(i) == '0') {
                parsedInts[parsedIntsIndex] = 0; parsedIntsIndex++;
            }else {

                if(parsedIntsIndex == 0) {
                    if (str.charAt(i) == ' ') {
                        continue;
                    }
                    if (str.charAt(i) == '+') {
                        continue;
                    } else if (str.charAt(i) == '-') {
                        negative = true;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
        }

        double answer = 0;
        int factor = 1;
        for (int i = parsedIntsIndex - 1; i >= 0; i--) {
            if((parsedInts[i] * factor) >2147483647){
//                if(negative){
//                    if(answer>2147483647){
//                        return Integer.MIN_VALUE;
//                    }
//                }
                return Integer.MAX_VALUE;

            }else if(negative && ((parsedInts[i] * factor*-1) < -2147483648)){
                return Integer.MIN_VALUE;
            }
            answer += parsedInts[i] * factor;
            factor = factor * 10;
        }
        if(negative)
            answer=0-answer;
        return (int)answer;
    }
}