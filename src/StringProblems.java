public class StringProblems {

    public static String convertNumberToWords(int num){
        String ones[] = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String teens[] = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String tens[] = {" ", " ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        if(num<10){
            return ones[num];
        }
        if(num<20){
            return teens[num%10];
        }
        if(num<100){
            return tens[num/10] + convertNumberToWords(num%10);
        }
        if(num<1000){
            if(num%100==0){
                return convertNumberToWords(num/100) + "Hundred";
            }else{
                return convertNumberToWords(num/100) + "Hundred and " + convertNumberToWords(num%100);
            }
        }
//        if(num<10000){
//            return convertNumberToWords(num/1000) + "Thousand " + convertNumberToWords(num%1000);
//        }
        if(num<100000){
            return convertNumberToWords(num/1000) + "Thousand " + convertNumberToWords(num%1000);
        }
        if(num<1000000){
            return convertNumberToWords(num/100000) + "Lakh " + convertNumberToWords(num%100000);
        }
        if(num<10000000){
            return convertNumberToWords(num/100000) + "Lakh " + convertNumberToWords(num%100000);
        }
        return "";
    }

    public static void main(String[] args) {
        int num = 6450;
        String word = convertNumberToWords(num);
        System.out.println(word);
    }
}
