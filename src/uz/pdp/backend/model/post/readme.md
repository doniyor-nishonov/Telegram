# Post Model

This class represents a post entity in the system.

## Fields

### `private String title`

- The title of the post.

### `private final String channelId`

- The ID of the channel to which the post belongs.

## Constructor

### `public Post(String title, String channelId)`

- Initializes a new post with the given title and channel ID.

## Methods

### `public String getTitle()`

- Returns the title of the post.

### `public void setTitle(String title)`

- Sets the title of the post.

### `public String getChannelId()`

- Returns the ID of the channel to which the post belongs.

### `@Override public String toString()`

- Returns a string representation of the post, including the title and creation time.

