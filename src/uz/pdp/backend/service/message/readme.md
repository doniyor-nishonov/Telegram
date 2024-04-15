# Message Service Implementation

This class implements the `MessageService` interface and provides methods to interact with message entities.

## Fields

### `private final MessageRepository messageRepository`

- An instance of the `MessageRepository` interface to perform CRUD operations on messages.

## Constructor

### `private MessageServiceImp()`

- Private constructor to restrict instantiation from outside.

## Methods

### `public static MessageService getInstance()`

- Returns a singleton instance of the `MessageServiceImp`.

### `@Override public boolean add(Message message)`

- Adds a new message.

### `@Override public boolean delete(String id)`

- Deletes a message by ID.

### `@Override public boolean update(String id, Message newE)`

- Updates a message with the given ID using the provided data.

### `@Override public List<Message> getAll()`

- Retrieves all messages.

### `@Override public Message get(String id)`

- Retrieves a message by ID.

### `@Override public List<Message> getMessageAll(Chat chat,String id)`

- Retrieves all messages from a chat for a given user.

### `@Override public List<Message> getMyMessage(Chat chat)`

- Retrieves messages from a chat for the current user.

### `@Override public List<Message> getGroupMessage(String chatId, String groupId)`

- Retrieves group messages for a chat.

### `@Override public List<Message> getByGroupMyMessages(String chatId, String groupId)`

- Retrieves group messages for a chat sent by the current user.
