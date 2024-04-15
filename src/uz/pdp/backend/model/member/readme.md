# Member Model

This class represents a member entity in the system.

## Fields

### `private final String userId`

- The ID of the user who is a member.

### `private final String groupId`

- The ID of the group to which the user belongs as a member.

### `private Role role`

- The role of the member in the group.

### `private boolean status`

- The status of the member in the group.

## Constructor

### `public Member(String userId, String groupId)`

- Initializes a new member with the given user ID and group ID. By default, sets the role to USER and status to false.

## Methods

### `public boolean getStatus()`

- Returns the status of the member in the group.

### `public void setStatus(boolean status)`

- Sets the status of the member in the group.

### `public Role getRole()`

- Returns the role of the member in the group.

### `public void setRole(Role role)`

- Sets the role of the member in the group.

### `public String getUserId()`

- Returns the ID of the user who is a member.

### `public String getGroupId()`

- Returns the ID of the group to which the user belongs as a member.

