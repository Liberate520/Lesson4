package ru.famally_tree.Filehandler;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath = "C://work/oop2/ru/famally_tree/treeFile.out";


    public void setPath(String filePath) { //для изменения пути в будущем
        this.filePath = filePath;
    }

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public Object read(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filePath)))){
            Object obj = objectInputStream.readObject();
            return obj;
         } catch (Exception e){
            return null;
        }

    }


}
