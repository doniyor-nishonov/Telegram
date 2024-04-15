# User Service Implementation

This class implements the `UserService` interface and provides methods to interact with user entities.

## Fields

### `private final UserRepository userRepository`

- An instance of the `UserRepository` interface to perform CRUD operations on users.

## Constructor

### `private UserServiceImp()`

- Private constructor to restrict instantiation from outside.

## Methods

### `public static UserService getInstance()`

- Returns a singleton instance of the `UserServiceImp`.

### `@Override public boolean add(User user)`

- Adds a new user.

### `@Override public boolean delete(String id)`

- Deletes a user by ID.

### `@Override public boolean update(String id, User newE)`

- Updates a user with the given ID using the provided data.

### `@Override public List<User> getAll()`

- Retrieves all users.

### `@Override public User get(String id)`

- Retrieves a user by ID.

### `@Override public User signIn(LoginDTO dto)`

- Signs in a user using the provided login credentials.

### `@Override public User findByUsername(String username)`

- Retrieves a user by username.
