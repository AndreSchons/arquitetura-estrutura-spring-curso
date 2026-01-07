package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    public TodoService(TodoValidator todoValidator, TodoRepository todoRepository, MailSender mailSender) {
        this.todoValidator = todoValidator;
        this.todoRepository = todoRepository;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        todoValidator.validar(novoTodo);
        return todoRepository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo) {
        todoRepository.save(todo);
        String Statusconcluido = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Nao concluido";
        mailSender.enviar("Todo " + todo.getDescricao() + " foi atualizado! Status: " + Statusconcluido);
    }

    public TodoEntity buscarPorId(Integer id) {
        return this.todoRepository.findById(id).orElse(null);
    }
}
