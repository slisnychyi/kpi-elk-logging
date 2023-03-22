package com.kpi.listener;

import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

@Configuration
public class BotConfiguration {

  private final DailyBot bot;

  public BotConfiguration(DailyBot bot) {
    this.bot = bot;
  }

  @PostConstruct
  public void setup() throws TelegramApiException {
    TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
    try {
      botsApi.registerBot(bot);
    }
    catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

}
