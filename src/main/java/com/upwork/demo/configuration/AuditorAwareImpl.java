package com.upwork.demo.configuration;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        // return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
        return Optional.of("random_user");
    }
}
