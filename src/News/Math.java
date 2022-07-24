// Packages
package News;

// Math Article
public class Math extends Article{

    // Method that adds Content
    public void content(){

        // Adding Math articles to the Array
        articles.add("California’s proposed new math curriculum defies logic");
        articles.add("The math brain: Scientists find two predictive neurotransmitters");
        articles.add("The Numbers Hiding Behind That QR Code");

        //Printing Articles
        System.out.println("---------------------------");
        System.out.println("     - MATH ARTICLES - ");
        System.out.println("---------------------------");
        System.out.println("a) " + articles.get(0));
        System.out.println("b) " + articles.get(1));
        System.out.println("c) " + articles.get(2));

    }
}

