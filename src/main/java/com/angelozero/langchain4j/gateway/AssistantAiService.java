package com.angelozero.langchain4j;


import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantAiService {

    @SystemMessage(fromResource = "prompts/assistant-instructions.txt")
    Result<String> handleRequest(@UserMessage String userMessage);
}
