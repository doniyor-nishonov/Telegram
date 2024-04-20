package uz.pdp.backend.nio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * The ListFileHandler class provides utility methods to read and write
 * lists of objects to and from files using serialization.
 *
 * @param <T> The type of objects to be handled
 */
public class ListFileHandler<T> {

    private final String childPath;
    private final String dirPath;

    /**
     * Constructs a ListFileHandler with the provided file paths.
     *
     * @param childPath The relative path of the file
     * @param dirPath   The directory path where the file is located
     */
    public ListFileHandler(String dirPath,String childPath ) {
        this.childPath = childPath;
        this.dirPath = dirPath;
    }

    /**
     * Reads objects from the file.
     *
     * @return A list of objects read from the file
     */
    @SuppressWarnings("unchecked")
    public List<T> readObjects() {
        String path = dirPath + childPath;
        List<T> objects = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            while (true) {
                T object = (T) objectInputStream.readObject();
                objects.add(object);
            }
        } catch (IOException | ClassNotFoundException ignored) {}
        return objects;
    }

    /**
     * Writes objects to the file.
     *
     * @param list The list of objects to write to the file
     */
    public void writeObjects(List<T> list) {
        String path = dirPath + childPath;
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            for (T item : list)
                objectOutputStream.writeObject(item);
        } catch (IOException ignored) {}
    }
}
