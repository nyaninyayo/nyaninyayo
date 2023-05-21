package bot.service;

import bot.enums.StateUser;

public record User (Long chatId, StateUser state) { }