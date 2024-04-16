package uz.pdp.backend.service.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.repository.chat.ChatRepository;
import uz.pdp.backend.repository.chat.ChatRepositoryImp;

import java.util.List;
import java.util.Objects;


public class ChatServiceImp implements ChatService{
    private final ChatRepository chatRepository = ChatRepositoryImp.getInstance();
    private static ChatService chatService;

    public static ChatService getInstance() {
        if(Objects.isNull(chatService))
            chatService = new ChatServiceImp();
        return chatService;
    }
    private ChatServiceImp() {}
    @Override
    public boolean add(Chat chat) {
        return chatRepository.add(chat);
    }

    @Override
    public boolean delete(String id) {
        return chatRepository.delete(id);
    }

    @Override
    public boolean update(Chat newE) {
        return chatRepository.update(newE);
    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.getAll();
    }

    @Override
    public Chat get(String id) {
        return chatRepository.get(id);
    }

    @Override
    public List<String> getUserChats(String id) {
        return chatRepository.getUserChats(id);
    }

    @Override
    public Chat findOrCreate(String id, String id1, MessageType type) {
        return chatRepository.findOrCreate(id,id1,type);
    }
}
