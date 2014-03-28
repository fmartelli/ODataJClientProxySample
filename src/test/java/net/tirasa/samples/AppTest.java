package net.tirasa.samples;

import com.msopentech.odatajclient.proxy.api.EntityContainerFactory;
import com.msopentech.odatajclient.proxy.northwind.northwindmodel.types.Product;
import com.msopentech.odatajclient.proxy.northwind.northwindmodel.types.ProductCollection;
import com.msopentech.odatajclient.proxy.northwind.odatawebv3.northwind.model.NorthwindEntities;
import com.msopentech.odatajclient.proxy.northwind.odatawebv3.northwind.model.Products;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        final EntityContainerFactory entityContainerFactory = EntityContainerFactory.getV3Instance(
                "http://services.odata.org/v3/%28S%28g00nkir0ssikgdmz3maw5l1x%29%29/Northwind/Northwind.svc/");

        NorthwindEntities service = entityContainerFactory.getEntityContainer(NorthwindEntities.class);
        Products products = service.getProducts();
        ProductCollection all = service.getProducts().getAll();

        assertNotNull(all);
        assertFalse(all.isEmpty());

        for (Product person : all) {
            assertNotNull(person);
        }
    }
}
