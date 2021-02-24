/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jskuschner
 */

import java.util.Random; 

public class NewMain {

    /**
     * @param args the command line arguments
     */
     
    
    public static void main(String[] args) {
        
        BinaryTree test = new BinaryTree();
        final int riaSIZE = 15;
        final int randNumOfNodesToDelete = 5;
        int[] randomIntegerArray = new int[riaSIZE];
        Random rand = new Random();
        
        for(int i = 0; i < riaSIZE; i++){
            randomIntegerArray[i] = rand.nextInt(100);
            test.add(randomIntegerArray[i]);
        }
        
        test.printBinaryTree(test.root, 0);
        
        for(int i = 0; i <= randNumOfNodesToDelete; i++){
            int x = rand.nextInt(riaSIZE - 1);
            System.out.println("Deleting: " + randomIntegerArray[x]);
            test.delete(randomIntegerArray[x]);
        }
        System.out.println("**********************************************");
        System.out.println("**********************************************");
      
        test.printBinaryTree(test.root, 0);
        System.out.println("Adding Repeated Node: " + test.root.data);
        test.add(test.root.data);
        test.printBinaryTree(test.root, 0);

        test.contains(13);
        System.out.println("Deleting: " + test.root.data);
        test.delete(test.root.data);
        test.printBinaryTree(test.root, 0);
        
        
    }
    
}
