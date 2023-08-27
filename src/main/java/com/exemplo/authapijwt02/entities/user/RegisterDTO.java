package com.exemplo.authapijwt02.entities.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
