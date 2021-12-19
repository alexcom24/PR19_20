import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {


        int n=10;
        ArrayList<String> m = new ArrayList<String>();
        String[] b={"0","1","2","3","4","5","6","7","8","9"};
        for (int t=0;t<n;t++) {
            Random random=new Random();
            Random random2=new Random();
            Random random3=new Random();
            String[] a={"A","B","E","K","M","H","O","P","C","T","Y","X"};
            StringBuilder sb=new StringBuilder();
            int sizeA=a.length;
            String a1 = (a[random.nextInt(sizeA)]);
            sb.append(a1);
            for (int i = 0; i < sizeA; i++)
                if ((a[i].equals(a1))&&(i!=11)) {

                    for (int j = i; j < sizeA - 1; j++)
                        a[j] = a[j + 1];
                    sizeA=sizeA-1;
                    break;
                }
                else if ((a[i].equals(a1))&&(i==11)) { sizeA=sizeA-1; break; }
            String b1 = (b[new Random().nextInt(b.length)]);
            for (int i = 1; i <= 3; i++) {

                sb.append(b1);
            }
            String a2 = (a[random2.nextInt(sizeA)]);
            sb.append(a2);
            for (int i = 0; i < sizeA; i++)

                if ((a[i].equals(a2))&&(i!=10)) {

                    for (int j = i; j < sizeA - 1; j++)
                        a[j] = a[j + 1];
                    sizeA=sizeA-1;
                    break;
                }
                else if ((a[i].equals(a2))&&(i==10)) sizeA=sizeA-1;
            String a3 = (a[random3.nextInt(sizeA)]);
            sb.append(a3);
            int c = new Random().nextInt(199) + 1;
            if (c < 10) {
                sb.append("0");
                sb.append(c);
            } else sb.append(c);
            m.add(t,sb.toString());
        }
        long q = System.nanoTime();
        if(m.contains("A111BC197")) System.out.print("Есть, Поиск перебором занял: ");
        else System.out.print("Нет элемента, Поиск перебором занял:");
        System.out.println((double) (System.nanoTime() - q));
        Set set = new HashSet(m);
        TreeSet tSet = new TreeSet(m);
        long q1 = System.nanoTime();
        if (set.contains("A111BC197")) System.out.print("Есть, Поиск в хеш-таблице занял: ");
        else System.out.print("Нет элемента, Поиск в хеш-таблице занял:");
        System.out.println((double) (System.nanoTime() - q1));
        long q2 = System.nanoTime();
        if (tSet.contains("A111BC197")) System.out.print("Есть, поиск в дереве занял: ");
        else System.out.print("Нет элемента, поиск в дереве занял: ");
        System.out.println((double) (System.nanoTime() - q2));
        Collections.sort(m);
        long q3 = System.nanoTime();
        int i=Collections.binarySearch(m,"A111BC197");
        System.out.print(i+" Это индекс элемента, бинарный поиск занял: ");
        System.out.println((double) (System.nanoTime() - q3));

    }
}
