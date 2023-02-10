import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

public class TestExample {
    private Calculator calculator;

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: Setting up test environment");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: Creating an instance of the calculator");
        calculator = new Calculator();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: Clearing the calculator's state");
        calculator.clear();
    }

    @Test(dataProvider = "additionDataProvider")
    public void testAddition(int a, int b, int expectedResult) {
        int result = calculator.add(a, b);
        System.out.println("Addition test executed");
        Assert.assertEquals(result, expectedResult);
    }

    @Test(dataProvider = "subtractionDataProvider")
    public void testSubtraction(int a, int b, int expectedResult) {
        int result = calculator.subtract(a, b);
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider(name = "additionDataProvider")
    public Object[][] additionDataProvider() {
        return new Object[][] {
                {1, 1, 2},
                {2, 2, 4},
                {3, 3, 6}
        };
    }

    @DataProvider(name = "subtractionDataProvider")
    public Object[][] subtractionDataProvider() {
        return new Object[][] {
                {1, 1, 0},
                {2, 1, 1},
                {3, 1, 2}
        };
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: Test finished");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: Destroying the calculator instance");
        calculator = null;
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: Cleaning up test environment");
    }
}
