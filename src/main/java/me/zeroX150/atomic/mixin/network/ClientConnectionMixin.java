package me.zeroX150.atomic.mixin.network;

import io.netty.channel.ChannelHandlerContext;
import me.zeroX150.atomic.feature.module.ModuleRegistry;
import me.zeroX150.atomic.feature.module.impl.external.AntiPacketKick;
import me.zeroX150.atomic.helper.event.EventType;
import me.zeroX150.atomic.helper.event.Events;
import me.zeroX150.atomic.helper.event.events.PacketEvent;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(method = "handlePacket", at = @At("HEAD"), cancellable = true)
    private static <T extends PacketListener> void packetReceive(Packet<T> packet, PacketListener listener, CallbackInfo ci) {
        if (Events.fireEvent(EventType.PACKET_RECEIVE, new PacketEvent(packet))) ci.cancel();
    }

    @Inject(method = "exceptionCaught", at = @At("HEAD"), cancellable = true)
    public void exceptionCaught(ChannelHandlerContext context, Throwable ex, CallbackInfo ci) {
        if (Objects.requireNonNull(ModuleRegistry.getByClass(AntiPacketKick.class)).isEnabled()) ci.cancel();
    }

    @Inject(method = "send(Lnet/minecraft/network/Packet;)V", cancellable = true, at = @At("HEAD"))
    public void send(Packet<?> packet, CallbackInfo ci) {
        if (Events.fireEvent(EventType.PACKET_SEND, new PacketEvent(packet))) ci.cancel();
    }

}
