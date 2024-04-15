# Message Model

This class represents a message entity in the system.

## Fields

### `private String text`

- The content of the message.

### `private final String senderId`

- The ID of the sender of the message.

### `private final String chatId`

- The ID of the chat to which the message belongs.

### `private boolean state`

- The state of the message (read/unread).

### `private MessageType type`

- The type of the message, which can be either CHAT or GROUP.

## Constructor

### `public Message(String text, String senderId, String chatId, MessageType type)`

- Initializes a new message with the given content, sender ID, chat ID, and message type.

## Methods

### `public void setText(String text)`

- Sets the content of the message.

### `public void setState(boolean state)`

- Sets the state of the message (read/unread).

### `public void setType(MessageType type)`

- Sets the type of the message.

### `public String getText()`

- Returns the content of the message.

### `public String getChatId()`

- Returns the ID of the chat to which the message belongs.

### `public boolean getState()`

- Returns the state of the message.

### `public MessageType getType()`

- Returns the type of the message.

### `@Override public String toString()`

- Returns a string representation of the message.

