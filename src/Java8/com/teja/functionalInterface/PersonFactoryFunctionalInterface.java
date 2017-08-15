package Java8.com.teja.functionalInterface;

/**
 * Created by TPathrikar on 3/30/2017.
 */
@FunctionalInterface
public interface PersonFactoryFunctionalInterface<P> {

    P create(String fname, String lname);
}
