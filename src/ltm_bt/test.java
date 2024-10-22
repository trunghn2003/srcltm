/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm_bt;

/**
 *
 * @author Admin
 */
public class test {
    public static int ucln(int a, int b) {        
//        while(a!=b) {
//            if(a>b) a=a-b;
//            if(a<b) b=b-a;
//        }
//        return a;
        while(b!=0) {
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    
    public static void main(String[] args) {
//        String s = "kjbnafiuwhefnwo21731134!@#$%";
//        StringBuilder s1 = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//        System.out.println(Character.isAlphabetic('c'));
//        for(int i=0; i<s.length(); i++) {
//            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
//                s1.append(s.charAt(i));                
//            }
//            else {
//                s2.append(s.charAt(i));
//            }
//        }
//        System.out.println(s1);
//        System.out.println(s2);
//        
//        System.out.println(ucln(4, 2));
//        String s = "iuhwoiuehf234234";
//        int[] dem = new int[255];
//        for(int i=0; i<255; i++) {
//            dem[i] = 0;
//        }
//        for(int i=0; i<s.length(); i++) {
//            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
//                dem[s.charAt(i)]++;               
//            }
//        }
//        StringBuilder s1 = new StringBuilder();
//        for(int i=0; i<s.length(); i++) {
//            if(dem[s.charAt(i)]>1){
//                //System.out.println(s.charAt(i) + ":" + dem[s.charAt(i)]);
//                String tmp = s.charAt(i) + ":" + dem[s.charAt(i)];
//                s1.append(tmp).append(", ");
//                dem[s.charAt(i)]=0;
//            }
//        }
//        System.out.println(s1.toString());
//        String s = "aAbcnd";
//        StringBuilder s1 = new StringBuilder();
//        for(int i=0; i<s.length(); i++) {
////            System.out.println((int) s.charAt(i));
//            int tmp = (int) s.charAt(i);
//            tmp = tmp+3;
//            if(Character.isLowerCase(s.charAt(i))) tmp = tmp%122;
//            else tmp =tmp%90;
//            s1.append((char) tmp);
//        }
//        System.out.println(s1.toString());
//        System.out.println((int) 'z');

        StringBuilder s1 = new StringBuilder();
        String s="hai";
        s+=s.charAt(2);
        System.out.println(s);
        
    }
}
