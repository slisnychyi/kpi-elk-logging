package com.kpi.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class DailyBot extends TelegramLongPollingBot {

  public DailyBot(@Value("${token}") String botToken) {
    super(botToken);
  }

  @Override
  public void onUpdateReceived(Update update) {
    String userName = update.getMessage().getFrom().getUserName();
    String message = update.getMessage().getText();
    log.info("user {} send message {}", userName, message);
  }

  @Override
  public String getBotUsername() {
    return "dailier";
  }

}
