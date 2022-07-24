// Packages
package News;

// Programming Article
public class Programming extends Article{

    // Method that adds Content
    public void content(){

        // Adding Programming articles to the Array
        articles.add("Sorting Algorithms: Comprehensive Guide");
        articles.add("Set up a Multi-Stage Docker Build for Go Applications");
        articles.add("How to make the BEST JAVA PROJECT EVER!");

        //Printing Articles
        System.out.println("---------------------------");
        System.out.println(" - PROGRAMMING ARTICLES - ");
        System.out.println("---------------------------");
        System.out.println("a) " + articles.get(0));
        System.out.println("b) " + articles.get(1));
        System.out.println("c) " + articles.get(2));

    }
}
