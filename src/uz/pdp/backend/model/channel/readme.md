# Channel Model

This class represents a channel entity in the system.

## Fields

### `private String name`

- The name of the channel.

### `private final String ownerId`

- The ID of the user who owns the channel.

### `private ChannelType channelType`

- The type of the channel, which can be either PUBLIC or PRIVATE.

## Constructor

### `public Channel(String name, String ownerId, ChannelType channelType)`

- Initializes a new channel with the given name, owner ID, and channel type.

## Methods

### `public String getName()`

- Returns the name of the channel.

### `public void setName(String name)`

- Sets the name of the channel.

### `public String getOwnerId()`

- Returns the ID of the owner of the channel.

### `public ChannelType getType()`

- Returns the type of the channel.

### `public void setType(ChannelType channelType)`

- Sets the type of the channel.

### `@Override public String toString()`

- Returns a string representation of the channel.

