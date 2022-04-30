package com.example.finalll;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class StartController {
    public Image WorkImige;
    @FXML
    private ImageView imageView;

    @FXML
    private Button ToolsB;

    @FXML
    private Slider Light;

    @FXML
    private Button loudImg;

    @FXML
    protected void LoudImige(){
        InputStream loudStream = getClass().getResourceAsStream("foto/example.png");
        Image image = new Image(loudStream);
        imageView.setImage(image);
        WorkImige=image;
    }

    @FXML
    protected void SetToolsButtn(){

    }

    public void Light(MouseEvent mouseEvent) {
        Image tempImige=WorkImige;
        int width=(int)(tempImige.getWidth());
        int height=(int) (tempImige.getHeight());
        WritableImage wImage=new WritableImage(width,height);
        PixelWriter writer=wImage.getPixelWriter();
        PixelReader reader=tempImige.getPixelReader();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = reader.getColor(x, y);
                double red=color.getRed();
                double green=color.getGreen();
                double blue=color.getBlue();
                double temp=Light.getValue();
                if(red+temp<1) red+=+temp; else red=1.0;
                if(red+temp<0) red=0;
                if(green+temp<1) green+=+temp; else green=1.0;
                if(green+temp<0) green=0;
                if(blue+temp<1) blue+=+temp; else blue=1.0;
                if(blue+temp<0) blue=0;
                Color nColor=new Color(red, green, blue,1.0);
                writer.setColor(x, y, nColor);
            }
        }
        imageView.setImage(wImage);
    }
}
