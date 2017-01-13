package net.md_5.bungee.http;

import io.netty.channel.Channel;
import io.netty.handler.proxy.Socks5ProxyHandler;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.Callback;
import net.md_5.bungee.conf.Configuration;

import java.net.InetSocketAddress;

/**
 * Dummy's fix for gfw
 * Created by dummy on 1/13/17.
 */
public class ProxiedHttpInitializer extends HttpInitializer {
    public ProxiedHttpInitializer(Callback<String> callback, boolean ssl, String host, int port) {
        super(callback, ssl, host, port);
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        super.initChannel(ch);
        Configuration config = BungeeCord.getInstance().getConfig();
        ch.pipeline().addFirst(new Socks5ProxyHandler(new InetSocketAddress(config.getSocks5ProxyAddress(), config.getSocks5ProxyPort())));
    }
}
