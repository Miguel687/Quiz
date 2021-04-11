package com.company.view;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagenFondo implements Border {
    private BufferedImage mImgagen = null;

    public ImagenFondo(BufferedImage mImgagen) {
        this.mImgagen = mImgagen;
    }

    @Override
    public void paintBorder(Component component, Graphics graphics, int x, int y, int width, int height) {
        if (mImgagen != null){
            graphics.drawImage(mImgagen,0,0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component component) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
