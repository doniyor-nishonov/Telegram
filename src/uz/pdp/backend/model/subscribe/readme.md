# Subscribe Model

This class represents a subscription entity in the system.

## Fields

### `private final String userId`

- The ID of the user who subscribed.

### `private final String channelId`

- The ID of the channel to which the user subscribed.

### `private Role role`

- The role of the user in the channel.

## Constructor

### `public Subscribe(String userId, String channelId)`

- Initializes a new subscription with the given user ID and channel ID. By default, sets the user's role to USER.

## Methods

### `public Role getRole()`

- Returns the role of the user in the channel.

### `public void setRole(Role role)`

- Sets the role of the user in the channel.

### `public String getUserId()`

- Returns the ID of the user who subscribed.

### `public String getChannelId()`

- Returns the ID of the channel to which the user subscribed.

