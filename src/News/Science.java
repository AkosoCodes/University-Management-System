// Packages
package News;

// Science Article
public class Science extends Article{

    // Method that adds Content
    public void content(){

        // Adding Science articles to the Array
        articles.add("A National Ignition Facility experiment produced a record 1.3 million joules of fusion energy");
        articles.add("Should You Get a Booster Shot? Here’s What We Know");
        articles.add("Why Do Variants Such as Delta Become Dominant?");

        //Printing Articles
        System.out.println("---------------------------");
        System.out.println("   - SCIENCE ARTICLES - ");
        System.out.println("---------------------------");
        System.out.println("a) " + articles.get(0));
        System.out.println("b) " + articles.get(1));
        System.out.println("c) " + articles.get(2));
    }
}
