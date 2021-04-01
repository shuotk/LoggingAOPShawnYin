package com.bfs.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String msg;
}
