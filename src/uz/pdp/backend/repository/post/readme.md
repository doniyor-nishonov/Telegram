# PostRepositoryImp

This class implements the `PostRepository` interface and provides methods to interact with post data stored in a file.

## Methods

### `public static PostRepository getInstance()`

- Returns a singleton instance of `PostRepository`.

### `public boolean add(Post post)`

- Adds a new post to the stored list.

### `public boolean delete(String id)`

- Deletes a post from the stored list by ID.

### `public boolean update(String id, Post post)`

- Updates a post in the stored list with new information.

### `public List<Post> getAll()`

- Returns all posts stored in the list.

### `public Post get(String id)`

- Gets a post by ID from the stored list.

### `public List<Post> getPostChannels(String channelId)`

- Returns all posts of a channel by channel ID.

## Fields

### `private final List<Post> list`

- The list containing post data.

### `private final String filePath`

- The file path where post data is stored.

### `private final ObjectWriterReader<Post> owr`

- Helper object for reading and writing post data from/to file.

### `private static PostRepository postRepository`

- Singleton instance of `PostRepository`.

## Constructor

### `private PostRepositoryImp()`

- Initializes the list by reading post data from the file.

