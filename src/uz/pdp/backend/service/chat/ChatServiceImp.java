package uz.pdp.backend.service.chat;

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
    public boolean update(String id, Chat newE) {
        return chatRepository.update(id,newE);
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
    public List<Chat> getUsersAllChats(String id1, String id2) {
        return chatRepository.getUsersAllChats(id1, id2);
    }

    @Override
    public List<Chat> getMyChats(String id, String id1) {
        return chatRepository.getMyChats(id,id1);
    }
}
