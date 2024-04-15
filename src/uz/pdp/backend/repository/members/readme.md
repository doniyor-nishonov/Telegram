# MembersRepositoryImp

This class implements the `MembersRepository` interface and provides methods to interact with user group membership data stored in a file.

## Methods

### `public static MembersRepository getInstance()`

- Returns a singleton instance of `MembersRepository`.

### `public boolean add(UserGroup member)`

- Adds a new user group membership to the stored list if it doesn't already exist.

### `public boolean delete(String id)`

- Deletes a user group membership from the stored list by ID.

### `public boolean update(String id, UserGroup newE)`

- Updates a user group membership in the stored list with new information.

### `public List<UserGroup> getAll()`

- Returns all user group memberships stored in the list.

### `public UserGroup get(String id)`

- Gets a user group membership by user ID from the stored list.

### `public List<UserGroup> getUserByGroups(String id)`

- Returns all user group memberships of a user by user ID.

### `public List<UserGroup> getMembers(String groupId)`

- Returns all user group memberships in a group by group ID.

## Fields

### `private final List<UserGroup> list`

- The list containing user group membership data.

### `private final String filePath`

- The file path where user group membership data is stored.

### `private final ObjectWriterReader<UserGroup> owr`

- Helper object for reading and writing user group membership data from/to file.

### `private static MembersRepository membersRepository`

- Singleton instance of `MembersRepository`.

## Constructor

### `private MembersRepositoryImp()`

- Initializes the list by reading user group membership data from the file.