# Group Service Implementation

This class implements the `GroupService` interface and provides methods to interact with group entities.

## Fields

### `private final GroupRepository groupRepository`

- An instance of the `GroupRepository` interface to perform CRUD operations on groups.

## Constructor

### `private GroupServiceImp()`

- Private constructor to restrict instantiation from outside.

## Methods

### `public static GroupService getInstance()`

- Returns a singleton instance of the `GroupServiceImp`.

### `@Override public boolean add(Group group)`

- Adds a new group.

### `@Override public boolean delete(String id)`

- Deletes a group by ID.

### `@Override public boolean update(String id, Group newGroup)`

- Updates a group with the given ID using the provided data.

### `@Override public List<Group> getAll()`

- Retrieves all groups.

### `@Override public Group get(String id)`

- Retrieves a group by ID.

### `@Override public List<Group> findByName(String name)`

- Retrieves groups with names containing the provided string.
