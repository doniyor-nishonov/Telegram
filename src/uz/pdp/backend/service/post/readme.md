# Post Service Implementation

This class implements the `PostService` interface and provides methods to interact with post entities.

## Fields

### `private final PostRepository postRepository`

- An instance of the `PostRepository` interface to perform CRUD operations on posts.

## Constructor

### `private PostServiceImp()`

- Private constructor to restrict instantiation from outside.

## Methods

### `public static PostService getInstance()`

- Returns a singleton instance of the `PostServiceImp`.

### `@Override public boolean add(Post post)`

- Adds a new post.

### `@Override public boolean delete(String id)`

- Deletes a post by ID.

### `@Override public boolean update(String id, Post newE)`

- Updates a post with the given ID using the provided data.

### `@Override public List<Post> getAll()`

- Retrieves all posts.

### `@Override public Post get(String id)`

- Retrieves a post by ID.

### `@Override public List<Post> getPostChannels(String channelId)`

- Retrieves posts for a specific channel.
