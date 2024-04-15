# ChannelRepositoryImp

This class implements the `ChannelRepository` interface and provides methods to interact with channel data stored in a file.

## Methods

### `public static ChannelRepository getInstance()`

- Returns a singleton instance of `ChannelRepository`.

### `public List<Channel> getChannelByUser(String userId)`

- Returns all channels owned by a user.

### `public boolean add(Channel channel)`

- Adds a new channel to the stored list if it doesn't already exist.

### `public boolean delete(String id)`

- Deletes a channel from the stored list by ID.

### `public boolean update(String id, Channel newChannel)`

- Updates a channel in the stored list with new information.

### `public List<Channel> getAll()`

- Returns all channels stored in the list.

### `public Channel get(String id)`

- Gets a channel by ID from the stored list.

### `public List<Channel> findWithName(String name)`

- Finds public channels by name, case-insensitive.

## Fields

### `private final List<Channel> list`

- The list containing channel data.

### `private final String filePath`

- The file path where channel data is stored.

### `private final ObjectWriterReader<Channel> owr`

- Helper object for reading and writing channel data from/to file.

### `private static ChannelRepository channelRepository`

- Singleton instance of `ChannelRepository`.

## Constructor

### `private ChannelRepositoryImp()`

- Initializes the list by reading channel data from the file.

