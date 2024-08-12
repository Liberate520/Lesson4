package family_tree.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable{
    public boolean save(Serializable serializable, String filePath){
        try (ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            ObjectOutputStream.writeObject(serializable);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePatch){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePatch))){
            return objectInputStream.readObject();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
