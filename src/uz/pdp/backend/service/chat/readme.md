# Chat Service Implementation

This class implements the `ChatService` interface and provides methods to interact with chat entities.

## Fields

### `private final ChatRepository chatRepository`

- An instance of the `ChatRepository` interface to perform CRUD operations on chats.

## Constructor

### `private ChatServiceImp()`

- Private constructor to restrict instantiation from outside.

## Methods

### `public static ChatService getInstance()`

- Returns a singleton instance of the `ChatServiceImp`.

### `@Override public boolean add(Chat chat)`

- Adds a new chat.

### `@Override public boolean delete(String id)`

- Deletes a chat by ID.

### `@Override public boolean update(String id, Chat newE)`

- Updates a chat with the given ID using the provided data.

### `@Override public List<Chat> getAll()`

- Retrieves all chats.

### `@Override public Chat get(String id)`

- Retrieves a chat by ID.

### `@Override public List<String> getUserChats(String id)`

- Retrieves IDs of chats associated with the given user ID.

### `@Override public Chat findOrCreate(String id, String id1, MessageType type)`

- Finds or creates a chat with the provided user IDs and message type.
