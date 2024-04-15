# Chat Model

This class represents a chat entity in the system.

## Fields

### `private final String id1`

- The ID of the first participant in the chat.

### `private final String id2`

- The ID of the second participant in the chat.

### `private MessageType type`

- The type of the chat, which can be either CHAT or GROUP.

## Constructor

### `public Chat(String id1, String id2, MessageType type)`

- Initializes a new chat with the given participant IDs and chat type.

## Methods

### `public MessageType getType()`

- Returns the type of the chat.

### `public void setType(MessageType type)`

- Sets the type of the chat.

### `public String getId1()`

- Returns the ID of the first participant in the chat.

### `public String getId2()`

- Returns the ID of the second participant in the chat.

