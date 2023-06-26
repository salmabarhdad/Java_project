package com.example.projet_chatapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Appview {
    @FXML
    private TextField MessageID;
    @FXML
    private TextField HostID;
    @FXML
    private TextField PortID;
    @FXML
    private ListView testview;
    PrintWriter pw;
    @FXML
    protected void onconnect() throws IOException {
        String host=HostID.getText();
        int port = Integer.parseInt(PortID.getText());
        Socket s = new Socket(host, port);
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = s.getOutputStream();
        String Ip = s.getRemoteSocketAddress().toString();
        pw = new PrintWriter(os,true);
        new Thread(() -> {
            while (true){
                try {
                    String response = br.readLine();
                    Platform.runLater(()->{
                        testview.getItems().add(response);
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    @FXML
    public void onsubmit(){
        String  message = MessageID.getText();
        pw.println(message);
    }
}
