# SubscribeRepositoryImp

This class implements the `SubscribeRepository` interface and provides methods to interact with subscription data stored in a file.

## Methods

### `public static SubscribeRepository getInstance()`

- Returns a singleton instance of `SubscribeRepository`.

### `public boolean add(Subscribe subscribe)`

- Adds a new subscription to the stored list if it doesn't already exist.

### `public boolean delete(String id)`

- Deletes a subscription from the stored list by ID.

### `public boolean update(String id, Subscribe newE)`

- Updates a subscription in the stored list with new information.

### `public List<Subscribe> getAll()`

- Returns all subscriptions stored in the list.

### `public Subscribe get(String id)`

- Gets a subscription by ID from the stored list.

### `public List<Subscribe> getUserSubscribes(String userId)`

- Returns all subscriptions of a user by user ID.

## Fields

### `private final List<Subscribe> list`

- The list containing subscription data.

### `private final String filePath`

- The file path where subscription data is stored.

### `private final ObjectWriterReader<Subscribe> owr`

- Helper object for reading and writing subscription data from/to file.

### `private static SubscribeRepository subscribeRepository`

- Singleton instance of `SubscribeRepository`.

## Constructor

### `private SubscribeRepositoryImp()`

- Initializes the list by reading subscription data from the file.

