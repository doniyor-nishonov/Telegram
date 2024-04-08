package uz.pdp.backend.service.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.repository.message.MessageRepository;
import uz.pdp.backend.repository.message.MessageRepositoryImp;

import java.util.List;

public class MessageServiceImp implements MessageService {
    private final MessageRepository messageRepository = new MessageRepositoryImp();

    @Override
    public boolean add(Message message) {
        return messageRepository.add(message);
    }

    @Override
    public boolean delete(String id) {
        return messageRepository.delete(id);
    }

    @Override
    public boolean update(String id, Message newE) {
        return messageRepository.update(id, newE);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    @Override
    public Message get(String id) {
        return messageRepository.get(id);
    }

    @Override
    public List<Message> getMessageAll(List<Chat> chats) {
        return messageRepository.getMessageAll(chats);
    }
}
