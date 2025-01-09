package com.fpoly.myspringbootapp.config;

import com.fpoly.myspringbootapp.repository.InvalidedTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class InvalidTokenCleanupScheduler {

    private final InvalidedTokenRepository invalidedTokenRepository;

    // CronJob chạy mỗi ngày cứ 3h chạy vào 1 lần
    @Scheduled(cron = "0 0 */3 * * *")
    @Transactional
    public void cleanupExpiredTokens() {
        log.info("Running cleanupExpiredTokens CronJob at {}", new Date());

        // Lấy ngày giờ hiện tại
        Date now = Date.from(Instant.now());

        // Xóa các bản ghi có expiryTime < hiện tại
        int deletedRecords = invalidedTokenRepository.deleteByExpiryTimeBefore(now);

        log.info("Cleanup completed. Deleted {} expired tokens.", deletedRecords);
    }
}

