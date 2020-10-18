import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HelloClassLoader extends ClassLoader{

	private static final String path = "D:/data/2020_10_18/Hello/Hello.xlass";

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassByte();
		
		classData = getData(classData);
		
		
		return defineClass(name, classData, 0, classData.length);
		
	}
	
	private byte[] getClassByte() {
		File file = new File(path);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
 
                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }
 
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
 
                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
        	System.out.println("文件不存在");
            return null;
        }

	}

	private byte[] getData(byte[] classData){
		
		for(int i=0;i<classData.length;i++){
			classData[i] = (byte) (255-classData[i]);
		}
		
		return classData;
	}
}
