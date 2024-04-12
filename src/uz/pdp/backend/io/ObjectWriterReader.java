package uz.pdp.backend.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectWriterReader<T> {
    private final String filePath;

    public ObjectWriterReader(String filePath) {
        this.filePath = filePath;
    }
    @SuppressWarnings("unchecked")
    public List<T> readObjects() {
        List<T> objects = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                T object = (T) objectInputStream.readObject();
                objects.add(object);
            }
        } catch (IOException | ClassNotFoundException ignored) {}
        return objects;
    }
    public void writeObjects(List<T> list) {
        File file = new File(filePath);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (T item : list) {
                objectOutputStream.writeObject(item);
            }
        } catch (IOException ignored) {
        }
    }
}
