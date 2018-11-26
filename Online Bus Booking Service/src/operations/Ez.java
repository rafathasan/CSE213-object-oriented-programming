/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author rafikhan
 */
public class Ez{
    static void eZ(char set[])
    {
        int n = set.length;
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");
 
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
 
            System.out.println("}");
        }
    }
    public static void main(String args[]){
        char[] ez = {'a','b','c','d'};
        eZ(ez);
    }
}
