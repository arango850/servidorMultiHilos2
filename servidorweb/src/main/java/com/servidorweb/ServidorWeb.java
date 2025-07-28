package com.servidorweb;

import java.net.ServerSocket;
import java.net.Socket;

public final class ServidorWeb{
    public static void main(String[] args) throws Exception{
        int port = 6789;

        ServerSocket socketEscucha = new ServerSocket(port);

        System.out.println("Servidor web iniciado en el puerto "+ port +"...");

        while (true){
            Socket socketConexion = socketEscucha.accept();
            SolicitudHttp solicitud = new SolicitudHttp(socketConexion);

            Thread hilo = new Thread(solicitud);
            hilo.start();
        }

    }
}
