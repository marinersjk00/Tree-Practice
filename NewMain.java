import java.util.Random; 

public class NewMain {

    /**
     * @param args the command line arguments
     */
     
    
    public static void main(String[] args) {
        
        BinaryTree test = new BinaryTree();
        final int riaSIZE = 200;
        final int randNumOfNodesToDelete = 5;
        int[] randomIntegerArray = new int[riaSIZE];
        Random rand = new Random();
        
        
        for(int i = 0; i < riaSIZE; i++){
            randomIntegerArray[i] = rand.nextInt(100);
        
            test.add(randomIntegerArray[i]);
        }
        System.out.println();
                test.printBinaryTree(test.root, 0);

         for(int i = 0; i < riaSIZE; i++){
            test.delete(randomIntegerArray[i]);
        }
         if(test.root == null){
             System.out.print("The tree is empty.");
         }
        test.printBinaryTree(test.root, 0);
        
    }
    
}
