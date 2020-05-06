package com.example.vhrapi.utils;

import com.example.vhrapi.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}