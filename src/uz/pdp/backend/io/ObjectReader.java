package uz.pdp.backend.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectReader<T> {
    private final String filePath;

    public ObjectReader(String filePath) {
        this.filePath = filePath;
    }

    public List<T> readObjects() {
        List<T> objects = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                T object = (T) objectInputStream.readObject();
                objects.add(object);
            }
        } catch (IOException | ClassNotFoundException exception) {}
        return objects;
    }
}

