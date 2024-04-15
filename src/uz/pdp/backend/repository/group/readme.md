# GroupRepositoryImp

This class implements the `GroupRepository` interface and provides methods to interact with group data stored in a file.

## Methods

### `public static GroupRepository getInstance()`

- Returns a singleton instance of `GroupRepository`.

### `public boolean add(Group group)`

- Adds a new group to the stored list if it doesn't already exist.

### `public boolean delete(String id)`

- Deletes a group from the stored list by ID.

### `public boolean update(String id, Group newE)`

- Updates a group in the stored list with new information.

### `public List<Group> getAll()`

- Returns all groups stored in the list.

### `public Group get(String id)`

- Gets a group by ID from the stored list.

### `public List<Group> findByName(String name)`

- Finds groups by name, case-insensitive.

## Fields

### `private final List<Group> list`

- The list containing group data.

### `private final String filePath`

- The file path where group data is stored.

### `private final ObjectWriterReader<Group> owr`

- Helper object for reading and writing group data from/to file.

### `private static GroupRepository groupRepository`

- Singleton instance of `GroupRepository`.

## Constructor

### `private GroupRepositoryImp()`

- Initializes the list by reading group data from the file.

