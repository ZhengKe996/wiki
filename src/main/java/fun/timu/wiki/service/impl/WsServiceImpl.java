package fun.timu.wiki.service.impl;

import fun.timu.wiki.service.WsService;
import fun.timu.wiki.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WsServiceImpl implements WsService {
    @Autowired
    public WebSocketServer webSocketServer;

    @Async
    public void sendInfo(String message) {
        webSocketServer.sendInfo(message);
    }
}
