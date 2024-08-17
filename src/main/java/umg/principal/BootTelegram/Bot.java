package umg.principal.BootTelegram;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


@Override
public String getBotUsername() {
    return "Roseni98_bot";
}

@Override
public String getBotToken() {
    return "7487483882:AAHq2sNkcExdxXwMLs7JFNvICgKX_NAl4bQ";
}



//El método onUpdateReceived(Update update) de la clase Bot se usa para manejar todas las actualizaciones que el
// bot recibe.
// Dependiendo del tipo de actualización, se toman diferentes acciones.

@Override
public void onUpdateReceived(Update update) {


    //Se verifica si la actualización contiene un mensaje y si ese mensaje tiene texto.
    //Luego se procesa el contenido del mensaje y se responde según el caso.

    String nombre = update.getMessage().getFrom().getFirstName();
    String apellido = update.getMessage().getFrom().getFirstName();
    String nickname = update.getMessage().getFrom().getFirstName();

    if (update.hasMessage() && update.getMessage().hasText()) {
        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();
        //codigo en telefono
        if (message_text.toLowerCase().equals("hola")) {
        sendText(chat_id, "Que onda "+nombre+ " gusto de saludarte");
        }

        if (message_text.toLowerCase().equals("bye")) {
            sendText(chat_id, "orales"+nombre+ "carita");
        }

        if (chat_id == 1510734672) {
            String msg= nombre+ "te saluda";
            sendText(chat_id, "vos sos chupapi");
        }
        System.out.println("Enviaste:" +message_text);
    }

}
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }


}