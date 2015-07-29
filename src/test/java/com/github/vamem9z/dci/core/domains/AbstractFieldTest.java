package test.java.com.github.vamem9z.dci.core.domains;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

import main.java.com.github.vamem9z.dci.core.domains.AbstractFields;

public class AbstractFieldTest {
	
	public class TestObject extends AbstractFields {
		private int field1;
		private String field2;
		
		public TestObject(int field1, String field2) {
			this.field1 = field1;
			this.field2 = field2;
		}
		
		public final ArrayList<Object>fields() {
			return new ArrayList<Object>(Arrays.asList(this.field1, this.field2));
		}
	}

	@Test(groups={"unit"})
	public void testEqualityofDifferentObjectsWithSameValues() {
		AbstractFieldTest.TestObject testObj = new AbstractFieldTest.TestObject(1, "Test");
		AbstractFieldTest.TestObject testObj1 = new AbstractFieldTest.TestObject(1, "Test");
		assertTrue(testObj.equals(testObj1));  
	}

	@Test(groups={"unit"})
	public void testEqualityofDifferentObjectsWithDifferentValues() {
		AbstractFieldTest.TestObject testObj = new AbstractFieldTest.TestObject(1, "Test");
		AbstractFieldTest.TestObject testObj1 = new AbstractFieldTest.TestObject(2, "Another test");
		assertFalse(testObj.equals(testObj1));
	}
  
	@Test(groups={"unit"})
	public void testEqualityReflectivity() {
		AbstractFieldTest.TestObject testObj = new AbstractFieldTest.TestObject(1, "Test");
		assertTrue(testObj.equals(testObj));	
	}
  
	@Test(groups={"unit"})
	public void testHashCodeEqualityObjectsWithSameValues() {
		AbstractFieldTest.TestObject testObj = new AbstractFieldTest.TestObject(1, "Test");
		AbstractFieldTest.TestObject testObj1 = new AbstractFieldTest.TestObject(1, "Test");
		assertEquals(testObj.hashCode(), testObj1.hashCode());
	}
	
	@Test(groups={"unit"})
	public void testtoStringOutput() {
		AbstractFieldTest.TestObject testObj = new AbstractFieldTest.TestObject(1, "Test");
		String expectedString = "TestObject [1, Test]";
		assertEquals(testObj.toString(), expectedString);
	}
}
