package uz.pdp.backend.service.chat;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.repository.chat.ChatRepository;
import uz.pdp.backend.repository.chat.ChatRepositoryImp;

import java.util.List;

public class ChatServiceImp implements ChatService{
    private final ChatRepository chatRepository = new ChatRepositoryImp();
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
}
