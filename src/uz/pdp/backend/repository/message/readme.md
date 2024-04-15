# MessageRepositoryImp

This class implements the `MessageRepository` interface and provides methods to interact with message data stored in a file.

## Methods

### `public static MessageRepository getInstance()`

- Returns a singleton instance of `MessageRepository`.

### `public boolean add(Message message)`

- Adds a new message to the stored list.

### `public boolean delete(String id)`

- Deletes a message from the stored list by ID.

### `public boolean update(String id, Message newE)`

- Updates a message in the stored list with new information.

### `public List<Message> getAll()`

- Returns all messages stored in the list.

### `public List<Message> getMessageAll(Chat chat, String id)`

- Returns all messages in a chat for a given user, marking those sent by the user as read.

### `public Message get(String id)`

- Gets a message by ID from the stored list.

### `public List<Message> getMyMessage(Chat chat)`

- Returns all messages sent by a user in a chat.

### `public List<Message> getGroupMessage(String chatId, String groupId)`

- Returns all messages sent by a group in a chat, marking those not from the chat as read.

### `public List<Message> getByGroupMyMessages(String chatId, String groupId)`

- Returns all messages sent by a user in a group chat.

## Fields

### `private final List<Message> list`

- The list containing message data.

### `private final String filePath`

- The file path where message data is stored.

### `private final ObjectWriterReader<Message> owr`

- Helper object for reading and writing message data from/to file.

### `private static MessageRepository messageRepository`

- Singleton instance of `MessageRepository`.

## Constructor

### `private MessageRepositoryImp()`

- Initializes the list by reading message data from the file.

