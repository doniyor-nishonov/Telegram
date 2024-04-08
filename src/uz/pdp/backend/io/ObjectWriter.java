package uz.pdp.backend.io;

import java.io.*;
import java.util.List;

public class ObjectWriter<T> {
    private final String filePath;

    public ObjectWriter(String filePath) {
        this.filePath = filePath;
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
