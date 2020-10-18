import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassTest {

	public static void main(String[] args) {
		HelloClassTest test = new HelloClassTest();
		test.getClassTest();

	}
	
	public void getClassTest(){
		HelloClassLoader helloClassLoader = new HelloClassLoader();
		
		try {
			Class<?> class1 = helloClassLoader.loadClass("Hello");
			Method method = class1.getDeclaredMethod("hello");
	        Object object = class1.newInstance();
	        method.invoke(object);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
