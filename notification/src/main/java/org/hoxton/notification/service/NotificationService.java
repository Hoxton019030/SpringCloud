package org.hoxton.notification.service;

import lombok.RequiredArgsConstructor;
import org.hoxton.notification.dao.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
}
