package listeners;

import java.lang.reflect.Method;

import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;

import data.DataMapper;
import data.InjectData;
import manager.DriverManager;

public class TestListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		DriverManager.start();
		ITestNGMethod method = result.getMethod();
		String path = getDataMapperPath(method);
		new DataMapper().setDataPath(path);
		DataMapper.initData();
	}
	
	private Method getMethod(ITestNGMethod method) {
		if (!method.isTest()) {
			return null;
		}
		ConstructorOrMethod com = method.getConstructorOrMethod();
		if (com.getMethod() == null) {
			return null;
		}
		return com.getMethod();
	}
	
	private String getDataMapperPath(ITestNGMethod method) {
		Method m = getMethod(method);
		if (m == null || m.getAnnotation(InjectData.class) == null) {
			return null;
		}
		String jsonFile = m.getAnnotation(InjectData.class).json();
		return jsonFile;
	}
}
