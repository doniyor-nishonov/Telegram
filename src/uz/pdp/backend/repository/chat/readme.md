# ChatRepositoryImp

This class implements the `ChatRepository` interface and provides methods to interact with chat data stored in a file.

## Methods

### `public static ChatRepository getInstance()`

- Returns a singleton instance of `ChatRepository`.

### `public boolean add(Chat chat)`

- Adds a new chat to the stored list.

### `public boolean delete(String id)`

- Deletes a chat from the stored list by ID.

### `public boolean update(String id, Chat newChat)`

- Updates a chat in the stored list with new information.

### `public List<Chat> getAll()`

- Returns all chats stored in the list.

### `public Chat get(String id)`

- Gets a chat by ID from the stored list.

### `public List<String> getUserChats(String id)`

- Returns all chats of a user by user ID.

### `public Chat findOrCreate(String id, String id1, MessageType type)`

- Finds or creates a chat between two users with the given IDs and message type.

## Fields

### `private final List<Chat> list`

- The list containing chat data.

### `private final String filePath`

- The file path where chat data is stored.

### `private final ObjectWriterReader<Chat> owr`

- Helper object for reading and writing chat data from/to file.

### `private static ChatRepository chatRepository`

- Singleton instance of `ChatRepository`.

## Constructor

### `private ChatRepositoryImp()`

- Initializes the list by reading chat data from the file.

