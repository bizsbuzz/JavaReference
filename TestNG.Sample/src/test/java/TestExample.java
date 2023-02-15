import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;


/*

Annotations:

    @Test: Marks a method as a test method
    @BeforeMethod: Marks a method to run before each test method
    @AfterMethod: Marks a method to run after each test method
    @BeforeClass: Marks a method to run before all test methods in a class
    @AfterClass: Marks a method to run after all test methods in a class
    @BeforeTest: Marks a method to run before any test method belonging to the classes inside the <test> tag is run
    @AfterTest: Marks a method to run after all the test methods belonging to the classes inside the <test> tag have run
    @DataProvider: Specifies a method that returns an array of objects to be used as data for a test method
    @Factory: Specifies a method that returns an array of objects to be used as test classes
    @Listeners: Specifies a list of test listeners to be notified of events during a test run
    @Parameters: Specifies parameters to be passed to a test method from a testng.xml file

Assertions:

    Assert.assertEquals: Asserts that two values are equal
    Assert.assertNotEquals: Asserts that two values are not equal
    Assert.assertTrue: Asserts that a condition is true
    Assert.assertFalse: Asserts that a condition is false
    Assert.assertNull: Asserts that a value is null
    Assert.assertNotNull: Asserts that a value is not null
    Assert.fail: Forces a test to fail

TestNG XML Configuration:

<suite>: Defines a test suite
<test>: Defines a test
<class>: Specifies the name of a test class to run
<method>: Specifies a test method to run
<parameter>: Specifies a parameter to be passed to a test method
<listeners>: Specifies a list of test listeners to be notified of events during a test run
<data-provider>: Specifies the name of a data provider method to be used for data-driven testing
Note: TestNG also provides a more expressive and readable set of assertions through the use of the assertj library.

TestNG annotations are used to control the flow of execution in a test class. Some of the most commonly used TestNG annotations are:

@Test: Specifies that a method is a test method
@BeforeMethod: Specifies a method that will be run before each test method
@AfterMethod: Specifies a method that will be run after each test method
@BeforeClass: Specifies a method that will be run before the first test method in the current class is invoked
@AfterClass: Specifies a method that will be run after all the test methods in the current class have been run
@BeforeTest: Specifies a method that will be run before any test method belonging to the classes inside the <test> tag is run
@AfterTest: Specifies a method that will be run after all the test methods belonging to the classes inside the <test> tag have run
@DataProvider: Specifies a method as a data provider for one or more test methods

The @BeforeTest annotation is used to set up the test environment before any tests are run.
The @BeforeClass annotation is used to create an instance of the calculator before any test methods are run.
The @BeforeMethod annotation is used to clear the state of the calculator before each test method.


 */
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
        System.out.println("Subtraction test got executed");
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
