package Linked_List;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < q; i++)
        {
            int type = sc.nextInt();
            if (type == 1)
            {
                int index = sc.nextInt();
                int node = sc.nextInt();

                list.add(index, node);
            }
            else
            {
                int index = sc.nextInt();
                if (index <= list.size())
                {
                    list.remove(index - 1);
                }
            }
        }

        list.forEach(integer -> System.out.print(integer + " "));
    }
}
