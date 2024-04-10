package uz.pdp.backend.service.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.repository.message.MessageRepository;
import uz.pdp.backend.repository.message.MessageRepositoryImp;

import java.util.List;
import java.util.Objects;

public class MessageServiceImp implements MessageService {
    private final MessageRepository messageRepository = MessageRepositoryImp.getInstance();
    private static MessageService messageService;

    public static MessageService getInstance() {
        if(Objects.isNull(messageService))
            messageService = new MessageServiceImp();
        return messageService;
    }
    private MessageServiceImp() {
    }

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
    public List<Message> getMessageAll(List<Chat> chats,String userId) {
        return messageRepository.getMessageAll(chats,userId);
    }
}
