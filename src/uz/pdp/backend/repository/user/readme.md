# UserRepositoryImp

This class implements the `UserRepository` interface and provides methods to interact with user data stored in a file.

## Methods

### `public static UserRepository getInstance()`

- Returns a singleton instance of `UserRepository`.

### `public User signIn(LoginDTO dto)`

- Finds and returns a user by username and password from the stored list.

### `public User findByUsername(String username)`

- Finds and returns a user by username from the stored list.

### `public boolean add(User user)`

- Adds a new user to the stored list if the username is not already taken.

### `public boolean delete(String id)`

- Deletes a user from the stored list by ID.

### `public boolean update(String id, User newE)`

- Updates a user in the stored list with new information.

### `public List<User> getAll()`

- Returns all users stored in the list.

### `public User get(String id)`

- Gets a user by ID from the stored list.

## Fields

### `private final List<User> list`

- The list containing user data.

### `private final String filePath`

- The file path where user data is stored.

### `private final ObjectWriterReader<User> owr`

- Helper object for reading and writing user data from/to file.

### `private static UserRepository userRepository`

- Singleton instance of `UserRepository`.

## Constructor

### `private UserRepositoryImp()`

- Initializes the list by reading user data from the file.

